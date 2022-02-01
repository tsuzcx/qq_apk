package com.tencent.pts.ui;

import android.text.TextUtils;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.IMeasureText;
import com.tencent.pts.ui.view.IRichTextMeasureText;
import com.tencent.pts.ui.vnode.PTSNodeContainer.Builder;
import com.tencent.pts.ui.vnode.PTSNodeImage.Builder;
import com.tencent.pts.ui.vnode.PTSNodeScrollView.Builder;
import com.tencent.pts.ui.vnode.PTSNodeSwiper.Builder;
import com.tencent.pts.ui.vnode.PTSNodeText.Builder;
import com.tencent.pts.ui.vnode.PTSNodeView;
import com.tencent.pts.ui.vnode.PTSNodeView.Builder;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.ui.vnode.PTSNodeVirtual.IBuilder;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSReportUtil;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PTSNodeFactory
{
  private static final String TAG = "PTSNodeFactory";
  private static HashMap<String, PTSNodeVirtual.IBuilder> sNodeBuilders = new HashMap();
  
  static
  {
    registerNodeVirtualList();
  }
  
  private static void addNodeToParent(PTSNodeVirtual paramPTSNodeVirtual, PTSNodeInfo paramPTSNodeInfo, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if (paramPTSNodeInfo.hasParent())
    {
      paramPTSNodeInfo = paramPTSNodeInfo.getParentID();
      paramHashMap = paramHashMap.values().iterator();
      int i;
      do
      {
        if (!paramHashMap.hasNext()) {
          break;
        }
        Object localObject = (List)paramHashMap.next();
        int j = 0;
        localObject = ((List)localObject).iterator();
        PTSNodeVirtual localPTSNodeVirtual;
        do
        {
          i = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localPTSNodeVirtual = (PTSNodeVirtual)((Iterator)localObject).next();
        } while ((localPTSNodeVirtual == null) || (localPTSNodeVirtual.getNodeInfo() == null) || (!TextUtils.equals(localPTSNodeVirtual.getNodeInfo().getUniqueID(), paramPTSNodeInfo)));
        if (paramPTSNodeVirtual.getParent() == null) {
          localPTSNodeVirtual.addChild(paramPTSNodeVirtual);
        }
        i = 1;
      } while (i == 0);
    }
  }
  
  private static void addToListMap(String paramString, PTSNodeVirtual paramPTSNodeVirtual, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramPTSNodeVirtual != null))
    {
      if (paramHashMap == null) {
        return;
      }
      List localList = (List)paramHashMap.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        paramHashMap.put(paramString, localObject);
      }
      ((List)localObject).add(paramPTSNodeVirtual);
    }
  }
  
  public static PTSNodeVirtual bindData(PTSAppInstance paramPTSAppInstance, PTSNodeInfo paramPTSNodeInfo, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    LinkedList localLinkedList = null;
    Object localObject2 = null;
    Object localObject1 = localLinkedList;
    if (paramPTSAppInstance != null)
    {
      localObject1 = localLinkedList;
      if (paramPTSNodeInfo != null)
      {
        if (paramHashMap == null) {
          return null;
        }
        hideAllNodeOfListMap(paramHashMap);
        localLinkedList = new LinkedList();
        localLinkedList.add(paramPTSNodeInfo);
        paramPTSNodeInfo = (PTSNodeInfo)localObject2;
        while (!localLinkedList.isEmpty())
        {
          PTSNodeInfo localPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
          localObject1 = getReusableNodeFromListMap(localPTSNodeInfo.getAttributes().getViewID(), paramHashMap, localPTSNodeInfo);
          if (localObject1 == null)
          {
            localObject2 = buildVirtualNodeBFS(localPTSNodeInfo, paramPTSAppInstance, paramHashMap);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              ((PTSNodeVirtual)localObject2).bindNodeInfo(localPTSNodeInfo);
              localObject1 = localObject2;
            }
          }
          else
          {
            ((PTSNodeVirtual)localObject1).bindNodeInfo(localPTSNodeInfo);
          }
          if ((localObject1 != null) && (((PTSNodeVirtual)localObject1).getParent() == null)) {
            addNodeToParent((PTSNodeVirtual)localObject1, localPTSNodeInfo, paramHashMap);
          }
          localObject2 = paramPTSNodeInfo;
          if (localPTSNodeInfo.isRootNode()) {
            localObject2 = localObject1;
          }
          if (localObject1 != null)
          {
            ((PTSNodeVirtual)localObject1).showNode();
            ((PTSNodeVirtual)localObject1).setReusable(false);
          }
          paramPTSNodeInfo = (PTSNodeInfo)localObject2;
          if (localPTSNodeInfo.isContainer())
          {
            localLinkedList.addAll(localPTSNodeInfo.getChildren());
            paramPTSNodeInfo = (PTSNodeInfo)localObject2;
          }
        }
        makeAllNodeReusableOfListMap(paramHashMap);
        updateAllNodeLayoutAndAttributes(paramHashMap);
        localObject1 = paramPTSNodeInfo;
      }
    }
    return localObject1;
  }
  
  public static PTSNodeVirtual buildVirtualNode(PTSNodeInfo paramPTSNodeInfo, PTSAppInstance paramPTSAppInstance)
  {
    Object localObject2 = null;
    if ((paramPTSNodeInfo != null) && (paramPTSAppInstance != null))
    {
      if (paramPTSNodeInfo.getAttributes() != null) {
        localObject1 = PTSValueConvertUtil.getString(paramPTSNodeInfo.getAttributes().get("pts:custom-view"));
      } else {
        localObject1 = "";
      }
      String str = getKey(paramPTSNodeInfo.getNodeType(), (String)localObject1);
      PTSNodeVirtual.IBuilder localIBuilder = (PTSNodeVirtual.IBuilder)sNodeBuilders.get(str);
      Object localObject1 = localObject2;
      if (localIBuilder != null) {
        localObject1 = localIBuilder.buildNodeVirtual(paramPTSAppInstance);
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[buildVirtualNode] error, use default PTSNodeView, the node type constructor does not exist, key = ");
        ((StringBuilder)localObject1).append(str);
        localObject1 = ((StringBuilder)localObject1).toString();
        PTSLog.e("PTSNodeFactory", (String)localObject1);
        PTSReportUtil.reportEvent("PTSNodeFactory", (String)localObject1, 1);
        localObject2 = new PTSNodeView(paramPTSAppInstance);
        ((PTSNodeVirtual)localObject2).setViewID(paramPTSNodeInfo.getAttributes().getViewID());
        ((PTSNodeView)localObject2).setNodeVirtualKey(str);
      }
      return localObject2;
    }
    PTSLog.e("PTSNodeFactory", "can not buildVirtualNode, nodeInfo or appInstance is null.");
    return null;
  }
  
  public static PTSNodeVirtual buildVirtualNodeBFS(PTSNodeInfo paramPTSNodeInfo, PTSAppInstance paramPTSAppInstance, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    Object localObject = null;
    if ((paramPTSNodeInfo != null) && (paramPTSAppInstance != null))
    {
      HashMap localHashMap = new HashMap();
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(paramPTSNodeInfo);
      while (!localLinkedList.isEmpty())
      {
        PTSNodeInfo localPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
        PTSNodeVirtual localPTSNodeVirtual = buildVirtualNode(localPTSNodeInfo, paramPTSAppInstance);
        String str = localPTSNodeInfo.getAttributes().getViewID();
        paramPTSNodeInfo = (PTSNodeInfo)localObject;
        if (localObject == null) {
          paramPTSNodeInfo = localPTSNodeVirtual;
        }
        if (localPTSNodeVirtual == null)
        {
          PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], currentNode is null.");
          if (!PTSLog.isDebug()) {
            PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], currentNode is null.");
          } else {
            throw new IllegalArgumentException("[buildVirtualNodeBFS], currentNode is null.");
          }
        }
        if (localPTSNodeInfo.hasParent())
        {
          localObject = (PTSNodeVirtual)localHashMap.get(localPTSNodeInfo.getParentID());
          if (localObject != null)
          {
            ((PTSNodeVirtual)localObject).addChild(localPTSNodeVirtual);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[buildVirtualNodeBFS], parentNode is null, parentId = ");
            ((StringBuilder)localObject).append(localPTSNodeInfo.getParentID());
            PTSLog.e("PTSNodeFactory", ((StringBuilder)localObject).toString());
          }
        }
        localHashMap.put(localPTSNodeInfo.getUniqueID(), localPTSNodeVirtual);
        if (!TextUtils.isEmpty(str))
        {
          if (paramHashMap != null) {
            addToListMap(str, localPTSNodeVirtual, paramHashMap);
          }
        }
        else {
          PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], currentViewID is null.");
        }
        localObject = paramPTSNodeInfo;
        if (localPTSNodeInfo.isContainer())
        {
          localLinkedList.addAll(localPTSNodeInfo.getChildren());
          localObject = paramPTSNodeInfo;
        }
      }
      return localObject;
    }
    PTSLog.e("PTSNodeFactory", "can not buildVirtualNodeBFS, nodeInfo or appInstance is null.");
    return null;
  }
  
  public static float[] getCustomTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return getCustomTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, paramString5, "normal");
  }
  
  public static float[] getCustomTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return getCustomTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, "");
  }
  
  public static float[] getCustomTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    float[] arrayOfFloat2 = new float[2];
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (!TextUtils.isEmpty(paramString5))
    {
      paramString5 = getNodeBuilder("text", paramString5);
      arrayOfFloat1 = arrayOfFloat2;
      if (paramString5 != null)
      {
        paramString5 = paramString5.buildNodeVirtual(null);
        arrayOfFloat1 = arrayOfFloat2;
        if ((paramString5 instanceof IMeasureText)) {
          arrayOfFloat1 = ((IMeasureText)paramString5).getTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, paramString6, paramString7);
        }
      }
    }
    return arrayOfFloat1;
  }
  
  private static String getKey(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static PTSNodeVirtual.IBuilder getNodeBuilder(String paramString1, String paramString2)
  {
    paramString1 = getKey(paramString1, paramString2);
    return (PTSNodeVirtual.IBuilder)sNodeBuilders.get(paramString1);
  }
  
  private static PTSNodeVirtual getReusableNodeFromListMap(String paramString, HashMap<String, List<PTSNodeVirtual>> paramHashMap, PTSNodeInfo paramPTSNodeInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramHashMap != null))
    {
      if (paramPTSNodeInfo == null) {
        return null;
      }
      paramString = (List)paramHashMap.get(paramString);
      if (paramString != null)
      {
        if (paramString.size() <= 0) {
          return null;
        }
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          paramHashMap = (PTSNodeVirtual)paramString.next();
          if ((paramHashMap != null) && (paramHashMap.getReusable()) && ((paramPTSNodeInfo.isRootNode()) || (paramHashMap.getNodeInfo() == null) || ((paramHashMap.getNodeInfo() != null) && (TextUtils.equals(paramPTSNodeInfo.getParentID(), paramHashMap.getNodeInfo().getParentID()))))) {
            return paramHashMap;
          }
        }
      }
    }
    return null;
  }
  
  public static float[] getRichTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    float[] arrayOfFloat2 = new float[2];
    Object localObject = getNodeBuilder("rich-text", "");
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (localObject != null)
    {
      localObject = ((PTSNodeVirtual.IBuilder)localObject).buildNodeVirtual(null);
      arrayOfFloat1 = arrayOfFloat2;
      if ((localObject instanceof IRichTextMeasureText)) {
        arrayOfFloat1 = ((IRichTextMeasureText)localObject).getRichTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
      }
    }
    return arrayOfFloat1;
  }
  
  public static float[] getTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return getTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, "normal");
  }
  
  /* Error */
  public static float[] getTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +1371 -> 1372
    //   4: aload_0
    //   5: arraylength
    //   6: iconst_2
    //   7: if_icmpge +6 -> 13
    //   10: goto +1362 -> 1372
    //   13: new 200	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   20: astore 15
    //   22: aload 15
    //   24: ldc_w 309
    //   27: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 15
    //   33: aload_0
    //   34: iconst_0
    //   35: faload
    //   36: invokevirtual 312	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 15
    //   42: ldc_w 314
    //   45: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 15
    //   51: aload_0
    //   52: iconst_1
    //   53: faload
    //   54: invokevirtual 312	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc 8
    //   60: aload 15
    //   62: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 317	com/tencent/pts/utils/PTSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: iconst_0
    //   69: istore 12
    //   71: iload 12
    //   73: aload_0
    //   74: arraylength
    //   75: if_icmpge +26 -> 101
    //   78: aload_0
    //   79: iload 12
    //   81: faload
    //   82: fconst_0
    //   83: fcmpg
    //   84: ifge +8 -> 92
    //   87: aload_0
    //   88: iload 12
    //   90: fconst_0
    //   91: fastore
    //   92: iload 12
    //   94: iconst_1
    //   95: iadd
    //   96: istore 12
    //   98: goto -27 -> 71
    //   101: new 319	android/text/TextPaint
    //   104: dup
    //   105: invokespecial 320	android/text/TextPaint:<init>	()V
    //   108: astore 15
    //   110: aload 15
    //   112: iconst_1
    //   113: invokevirtual 323	android/text/TextPaint:setAntiAlias	(Z)V
    //   116: aload_2
    //   117: invokestatic 327	com/tencent/pts/utils/PTSValueConvertUtil:getFloat	(Ljava/lang/Object;)F
    //   120: invokestatic 333	com/tencent/pts/utils/PTSDeviceUtil:dp2px	(F)F
    //   123: fstore 6
    //   125: aload 15
    //   127: fload 6
    //   129: invokevirtual 337	android/text/TextPaint:setTextSize	(F)V
    //   132: ldc_w 339
    //   135: aload 5
    //   137: invokestatic 74	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   140: ifeq +20 -> 160
    //   143: aload 15
    //   145: getstatic 345	android/graphics/Paint$Style:FILL_AND_STROKE	Landroid/graphics/Paint$Style;
    //   148: invokevirtual 349	android/text/TextPaint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   151: aload 15
    //   153: getstatic 355	android/graphics/Typeface:DEFAULT_BOLD	Landroid/graphics/Typeface;
    //   156: invokevirtual 359	android/text/TextPaint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   159: pop
    //   160: iconst_2
    //   161: newarray float
    //   163: astore 17
    //   165: aload 17
    //   167: iconst_0
    //   168: aload_0
    //   169: iconst_0
    //   170: faload
    //   171: fastore
    //   172: aload 17
    //   174: iconst_1
    //   175: aload_0
    //   176: iconst_1
    //   177: faload
    //   178: fastore
    //   179: aload_3
    //   180: invokestatic 327	com/tencent/pts/utils/PTSValueConvertUtil:getFloat	(Ljava/lang/Object;)F
    //   183: aload_2
    //   184: invokestatic 327	com/tencent/pts/utils/PTSValueConvertUtil:getFloat	(Ljava/lang/Object;)F
    //   187: aload 15
    //   189: invokestatic 365	com/tencent/pts/ui/vnode/PTSNodeTextBase:getLineSpacing	(FFLandroid/text/TextPaint;)F
    //   192: fstore 7
    //   194: aload 4
    //   196: invokestatic 369	com/tencent/pts/utils/PTSValueConvertUtil:getInt	(Ljava/lang/Object;)I
    //   199: istore 13
    //   201: aload_0
    //   202: iconst_0
    //   203: faload
    //   204: invokestatic 373	com/tencent/pts/utils/PTSDeviceUtil:getScreenWidthDp	()F
    //   207: invokestatic 379	java/lang/Math:min	(FF)F
    //   210: invokestatic 383	com/tencent/pts/utils/PTSDeviceUtil:dp2pxInt	(F)I
    //   213: istore 14
    //   215: aload_1
    //   216: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   219: ifeq +9 -> 228
    //   222: iconst_0
    //   223: istore 12
    //   225: goto +11 -> 236
    //   228: aload_1
    //   229: invokevirtual 388	java/lang/String:length	()I
    //   232: iconst_1
    //   233: isub
    //   234: istore 12
    //   236: getstatic 394	android/os/Build$VERSION:SDK_INT	I
    //   239: bipush 23
    //   241: if_icmplt +73 -> 314
    //   244: aload_1
    //   245: iconst_0
    //   246: iload 12
    //   248: aload 15
    //   250: iload 14
    //   252: invokestatic 400	android/text/StaticLayout$Builder:obtain	(Ljava/lang/CharSequence;IILandroid/text/TextPaint;I)Landroid/text/StaticLayout$Builder;
    //   255: iload 14
    //   257: invokevirtual 404	android/text/StaticLayout$Builder:setEllipsizedWidth	(I)Landroid/text/StaticLayout$Builder;
    //   260: getstatic 410	android/text/Layout$Alignment:ALIGN_NORMAL	Landroid/text/Layout$Alignment;
    //   263: invokevirtual 414	android/text/StaticLayout$Builder:setAlignment	(Landroid/text/Layout$Alignment;)Landroid/text/StaticLayout$Builder;
    //   266: iconst_0
    //   267: invokevirtual 418	android/text/StaticLayout$Builder:setIncludePad	(Z)Landroid/text/StaticLayout$Builder;
    //   270: iload 13
    //   272: invokevirtual 421	android/text/StaticLayout$Builder:setMaxLines	(I)Landroid/text/StaticLayout$Builder;
    //   275: fload 7
    //   277: fconst_1
    //   278: invokevirtual 425	android/text/StaticLayout$Builder:setLineSpacing	(FF)Landroid/text/StaticLayout$Builder;
    //   281: aload_1
    //   282: invokevirtual 429	android/text/StaticLayout$Builder:setText	(Ljava/lang/CharSequence;)Landroid/text/StaticLayout$Builder;
    //   285: getstatic 435	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   288: invokevirtual 439	android/text/StaticLayout$Builder:setEllipsize	(Landroid/text/TextUtils$TruncateAt;)Landroid/text/StaticLayout$Builder;
    //   291: astore_0
    //   292: getstatic 394	android/os/Build$VERSION:SDK_INT	I
    //   295: bipush 28
    //   297: if_icmplt +9 -> 306
    //   300: aload_0
    //   301: iconst_1
    //   302: invokevirtual 442	android/text/StaticLayout$Builder:setUseLineSpacingFromFallbacks	(Z)Landroid/text/StaticLayout$Builder;
    //   305: pop
    //   306: aload_0
    //   307: invokevirtual 446	android/text/StaticLayout$Builder:build	()Landroid/text/StaticLayout;
    //   310: astore_0
    //   311: goto +722 -> 1033
    //   314: getstatic 410	android/text/Layout$Alignment:ALIGN_NORMAL	Landroid/text/Layout$Alignment;
    //   317: astore_0
    //   318: getstatic 435	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   321: astore 16
    //   323: fload 7
    //   325: fstore 8
    //   327: new 448	android/text/StaticLayout
    //   330: dup
    //   331: aload_1
    //   332: iconst_0
    //   333: iload 12
    //   335: aload 15
    //   337: iload 14
    //   339: aload_0
    //   340: fconst_1
    //   341: fload 8
    //   343: iconst_0
    //   344: aload 16
    //   346: iload 14
    //   348: invokespecial 451	android/text/StaticLayout:<init>	(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;I)V
    //   351: astore 16
    //   353: aload 16
    //   355: invokevirtual 455	java/lang/Object:getClass	()Ljava/lang/Class;
    //   358: astore 18
    //   360: aload 18
    //   362: ldc_w 457
    //   365: invokevirtual 463	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   368: astore 19
    //   370: aload 19
    //   372: iconst_1
    //   373: invokevirtual 468	java/lang/reflect/Field:setAccessible	(Z)V
    //   376: aload 16
    //   378: astore_0
    //   379: aload 19
    //   381: aload_0
    //   382: iload 13
    //   384: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   387: invokevirtual 478	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   390: aload 18
    //   392: ldc_w 480
    //   395: invokevirtual 463	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   398: astore 19
    //   400: aload 19
    //   402: iconst_1
    //   403: invokevirtual 468	java/lang/reflect/Field:setAccessible	(Z)V
    //   406: aload 19
    //   408: aload_0
    //   409: new 482	android/graphics/Paint$FontMetricsInt
    //   412: dup
    //   413: invokespecial 483	android/graphics/Paint$FontMetricsInt:<init>	()V
    //   416: invokevirtual 478	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   419: ldc_w 485
    //   422: invokestatic 489	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   425: astore 22
    //   427: ldc_w 491
    //   430: invokestatic 489	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   433: ldc_w 493
    //   436: invokevirtual 463	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   439: astore 20
    //   441: aload 20
    //   443: iconst_1
    //   444: invokevirtual 468	java/lang/reflect/Field:setAccessible	(Z)V
    //   447: aload 18
    //   449: ldc_w 495
    //   452: iconst_0
    //   453: anewarray 459	java/lang/Class
    //   456: invokevirtual 499	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   459: astore 21
    //   461: aload 18
    //   463: ldc_w 501
    //   466: bipush 12
    //   468: anewarray 459	java/lang/Class
    //   471: dup
    //   472: iconst_0
    //   473: ldc_w 503
    //   476: aastore
    //   477: dup
    //   478: iconst_1
    //   479: getstatic 507	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   482: aastore
    //   483: dup
    //   484: iconst_2
    //   485: getstatic 507	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   488: aastore
    //   489: dup
    //   490: iconst_3
    //   491: ldc_w 319
    //   494: aastore
    //   495: dup
    //   496: iconst_4
    //   497: getstatic 507	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   500: aastore
    //   501: dup
    //   502: iconst_5
    //   503: aload 22
    //   505: aastore
    //   506: dup
    //   507: bipush 6
    //   509: getstatic 510	java/lang/Float:TYPE	Ljava/lang/Class;
    //   512: aastore
    //   513: dup
    //   514: bipush 7
    //   516: getstatic 510	java/lang/Float:TYPE	Ljava/lang/Class;
    //   519: aastore
    //   520: dup
    //   521: bipush 8
    //   523: getstatic 513	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   526: aastore
    //   527: dup
    //   528: bipush 9
    //   530: getstatic 513	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   533: aastore
    //   534: dup
    //   535: bipush 10
    //   537: getstatic 510	java/lang/Float:TYPE	Ljava/lang/Class;
    //   540: aastore
    //   541: dup
    //   542: bipush 11
    //   544: ldc_w 431
    //   547: aastore
    //   548: invokevirtual 499	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   551: astore 22
    //   553: aload 18
    //   555: ldc_w 515
    //   558: iconst_0
    //   559: anewarray 459	java/lang/Class
    //   562: invokevirtual 499	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   565: astore 18
    //   567: aload 21
    //   569: iconst_1
    //   570: invokevirtual 518	java/lang/reflect/Method:setAccessible	(Z)V
    //   573: aload 22
    //   575: iconst_1
    //   576: invokevirtual 518	java/lang/reflect/Method:setAccessible	(Z)V
    //   579: aload 18
    //   581: iconst_1
    //   582: invokevirtual 518	java/lang/reflect/Method:setAccessible	(Z)V
    //   585: aload 21
    //   587: aload_0
    //   588: iconst_0
    //   589: anewarray 4	java/lang/Object
    //   592: invokevirtual 522	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   595: pop
    //   596: aload 22
    //   598: aload_0
    //   599: bipush 12
    //   601: anewarray 4	java/lang/Object
    //   604: dup
    //   605: iconst_0
    //   606: aload_1
    //   607: aastore
    //   608: dup
    //   609: iconst_1
    //   610: iconst_0
    //   611: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   614: aastore
    //   615: dup
    //   616: iconst_2
    //   617: iload 12
    //   619: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   622: aastore
    //   623: dup
    //   624: iconst_3
    //   625: aload 15
    //   627: aastore
    //   628: dup
    //   629: iconst_4
    //   630: iload 14
    //   632: invokestatic 474	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   635: aastore
    //   636: dup
    //   637: iconst_5
    //   638: aload 20
    //   640: aconst_null
    //   641: invokevirtual 523	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   644: aastore
    //   645: dup
    //   646: bipush 6
    //   648: fconst_1
    //   649: invokestatic 526	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   652: aastore
    //   653: dup
    //   654: bipush 7
    //   656: fload 8
    //   658: invokestatic 526	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   661: aastore
    //   662: dup
    //   663: bipush 8
    //   665: iconst_0
    //   666: invokestatic 529	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   669: aastore
    //   670: dup
    //   671: bipush 9
    //   673: iconst_0
    //   674: invokestatic 529	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   677: aastore
    //   678: dup
    //   679: bipush 10
    //   681: iload 14
    //   683: i2f
    //   684: invokestatic 526	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   687: aastore
    //   688: dup
    //   689: bipush 11
    //   691: getstatic 435	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   694: aastore
    //   695: invokevirtual 522	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   698: pop
    //   699: aload 18
    //   701: aload_0
    //   702: iconst_0
    //   703: anewarray 4	java/lang/Object
    //   706: invokevirtual 522	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   709: pop
    //   710: aload 19
    //   712: aload_0
    //   713: aconst_null
    //   714: invokevirtual 478	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   717: goto +313 -> 1030
    //   720: astore_0
    //   721: goto +80 -> 801
    //   724: astore_0
    //   725: goto +115 -> 840
    //   728: astore_0
    //   729: goto +188 -> 917
    //   732: astore_0
    //   733: goto +223 -> 956
    //   736: astore_0
    //   737: goto +258 -> 995
    //   740: astore_0
    //   741: goto +60 -> 801
    //   744: astore_0
    //   745: goto +95 -> 840
    //   748: astore_0
    //   749: goto +168 -> 917
    //   752: astore_0
    //   753: goto +203 -> 956
    //   756: astore_0
    //   757: goto +238 -> 995
    //   760: astore_0
    //   761: goto +40 -> 801
    //   764: astore_0
    //   765: goto +75 -> 840
    //   768: astore_0
    //   769: goto +148 -> 917
    //   772: astore_0
    //   773: goto +183 -> 956
    //   776: astore_0
    //   777: goto +218 -> 995
    //   780: astore_0
    //   781: goto +20 -> 801
    //   784: astore_0
    //   785: goto +55 -> 840
    //   788: astore_0
    //   789: goto +128 -> 917
    //   792: astore_0
    //   793: goto +163 -> 956
    //   796: astore_0
    //   797: goto +198 -> 995
    //   800: astore_0
    //   801: new 200	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   808: astore 18
    //   810: aload 18
    //   812: ldc_w 531
    //   815: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload 18
    //   821: aload_0
    //   822: invokevirtual 534	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: ldc 8
    //   828: aload 18
    //   830: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 216	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   836: goto +194 -> 1030
    //   839: astore_0
    //   840: new 200	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   847: astore 18
    //   849: aload 18
    //   851: ldc_w 536
    //   854: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload 18
    //   860: aload_0
    //   861: invokevirtual 534	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: ldc 8
    //   867: aload 18
    //   869: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: invokestatic 216	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   875: new 200	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   882: astore 18
    //   884: aload 18
    //   886: ldc_w 538
    //   889: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: aload 18
    //   895: aload_0
    //   896: invokevirtual 542	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   899: invokevirtual 534	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: ldc 8
    //   905: aload 18
    //   907: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: invokestatic 216	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   913: goto +117 -> 1030
    //   916: astore_0
    //   917: new 200	java/lang/StringBuilder
    //   920: dup
    //   921: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   924: astore 18
    //   926: aload 18
    //   928: ldc_w 536
    //   931: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: aload 18
    //   937: aload_0
    //   938: invokevirtual 534	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   941: pop
    //   942: ldc 8
    //   944: aload 18
    //   946: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   949: invokestatic 216	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   952: goto +78 -> 1030
    //   955: astore_0
    //   956: new 200	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   963: astore 18
    //   965: aload 18
    //   967: ldc_w 536
    //   970: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: aload 18
    //   976: aload_0
    //   977: invokevirtual 534	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   980: pop
    //   981: ldc 8
    //   983: aload 18
    //   985: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokestatic 216	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   991: goto +39 -> 1030
    //   994: astore_0
    //   995: new 200	java/lang/StringBuilder
    //   998: dup
    //   999: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1002: astore 18
    //   1004: aload 18
    //   1006: ldc_w 536
    //   1009: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: pop
    //   1013: aload 18
    //   1015: aload_0
    //   1016: invokevirtual 534	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: ldc 8
    //   1022: aload 18
    //   1024: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1027: invokestatic 216	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1030: aload 16
    //   1032: astore_0
    //   1033: aload_1
    //   1034: aload 15
    //   1036: invokestatic 548	android/text/Layout:getDesiredWidth	(Ljava/lang/CharSequence;Landroid/text/TextPaint;)F
    //   1039: invokestatic 551	com/tencent/pts/utils/PTSDeviceUtil:px2dp	(F)F
    //   1042: fstore 9
    //   1044: aload_0
    //   1045: invokevirtual 554	android/text/StaticLayout:getWidth	()I
    //   1048: i2f
    //   1049: invokestatic 551	com/tencent/pts/utils/PTSDeviceUtil:px2dp	(F)F
    //   1052: fstore 10
    //   1054: aload_0
    //   1055: invokevirtual 557	android/text/StaticLayout:getHeight	()I
    //   1058: i2f
    //   1059: invokestatic 551	com/tencent/pts/utils/PTSDeviceUtil:px2dp	(F)F
    //   1062: fstore 11
    //   1064: fload 6
    //   1066: aload_0
    //   1067: invokevirtual 560	android/text/StaticLayout:getLineCount	()I
    //   1070: invokestatic 564	com/tencent/pts/ui/vnode/PTSNodeTextBase:getHeightOffset	(FI)F
    //   1073: invokestatic 551	com/tencent/pts/utils/PTSDeviceUtil:px2dp	(F)F
    //   1076: fstore 8
    //   1078: aload 17
    //   1080: iconst_0
    //   1081: fload 9
    //   1083: fload 10
    //   1085: invokestatic 379	java/lang/Math:min	(FF)F
    //   1088: fastore
    //   1089: aload 17
    //   1091: iconst_1
    //   1092: fload 11
    //   1094: fload 8
    //   1096: fadd
    //   1097: fastore
    //   1098: aload_0
    //   1099: invokevirtual 560	android/text/StaticLayout:getLineCount	()I
    //   1102: iconst_1
    //   1103: if_icmpne +48 -> 1151
    //   1106: aload_1
    //   1107: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1110: ifeq +9 -> 1119
    //   1113: iconst_0
    //   1114: istore 12
    //   1116: goto +9 -> 1125
    //   1119: aload_1
    //   1120: invokevirtual 388	java/lang/String:length	()I
    //   1123: istore 12
    //   1125: fload 6
    //   1127: iload 12
    //   1129: invokestatic 567	com/tencent/pts/ui/vnode/PTSNodeTextBase:getWidthOffset	(FI)F
    //   1132: invokestatic 551	com/tencent/pts/utils/PTSDeviceUtil:px2dp	(F)F
    //   1135: fstore 6
    //   1137: aload 17
    //   1139: iconst_0
    //   1140: aload 17
    //   1142: iconst_0
    //   1143: faload
    //   1144: fload 6
    //   1146: fadd
    //   1147: fastore
    //   1148: goto +6 -> 1154
    //   1151: fconst_0
    //   1152: fstore 6
    //   1154: invokestatic 243	com/tencent/pts/utils/PTSLog:isDebug	()Z
    //   1157: ifeq +212 -> 1369
    //   1160: new 200	java/lang/StringBuilder
    //   1163: dup
    //   1164: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   1167: astore 15
    //   1169: aload 15
    //   1171: ldc_w 569
    //   1174: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: pop
    //   1178: aload 15
    //   1180: aload 17
    //   1182: iconst_0
    //   1183: faload
    //   1184: invokevirtual 312	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1187: pop
    //   1188: aload 15
    //   1190: ldc_w 571
    //   1193: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: pop
    //   1197: aload 15
    //   1199: aload 17
    //   1201: iconst_1
    //   1202: faload
    //   1203: invokevirtual 312	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: aload 15
    //   1209: ldc_w 573
    //   1212: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: pop
    //   1216: aload 15
    //   1218: aload_1
    //   1219: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: pop
    //   1223: aload 15
    //   1225: ldc_w 575
    //   1228: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload 15
    //   1234: aload_2
    //   1235: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: pop
    //   1239: aload 15
    //   1241: ldc_w 577
    //   1244: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: aload 15
    //   1250: aload 5
    //   1252: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: pop
    //   1256: aload 15
    //   1258: ldc_w 579
    //   1261: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: pop
    //   1265: aload 15
    //   1267: aload_3
    //   1268: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: aload 15
    //   1274: ldc_w 581
    //   1277: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: pop
    //   1281: aload 15
    //   1283: fload 7
    //   1285: invokevirtual 312	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1288: pop
    //   1289: aload 15
    //   1291: ldc_w 583
    //   1294: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: pop
    //   1298: aload 15
    //   1300: aload 4
    //   1302: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: pop
    //   1306: aload 15
    //   1308: ldc_w 585
    //   1311: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: pop
    //   1315: aload 15
    //   1317: fload 8
    //   1319: invokevirtual 312	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1322: pop
    //   1323: aload 15
    //   1325: ldc_w 587
    //   1328: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: pop
    //   1332: aload 15
    //   1334: fload 6
    //   1336: invokevirtual 312	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1339: pop
    //   1340: aload 15
    //   1342: ldc_w 589
    //   1345: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: aload 15
    //   1351: aload_0
    //   1352: invokevirtual 560	android/text/StaticLayout:getLineCount	()I
    //   1355: invokevirtual 592	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1358: pop
    //   1359: ldc 8
    //   1361: aload 15
    //   1363: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1366: invokestatic 317	com/tencent/pts/utils/PTSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1369: aload 17
    //   1371: areturn
    //   1372: ldc 8
    //   1374: ldc_w 594
    //   1377: invokestatic 216	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1380: aload_0
    //   1381: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1382	0	paramArrayOfFloat	float[]
    //   0	1382	1	paramString1	String
    //   0	1382	2	paramString2	String
    //   0	1382	3	paramString3	String
    //   0	1382	4	paramString4	String
    //   0	1382	5	paramString5	String
    //   123	1212	6	f1	float
    //   192	1092	7	f2	float
    //   325	993	8	f3	float
    //   1042	40	9	f4	float
    //   1052	32	10	f5	float
    //   1062	31	11	f6	float
    //   69	1059	12	i	int
    //   199	184	13	j	int
    //   213	469	14	k	int
    //   20	1342	15	localObject1	Object
    //   321	710	16	localObject2	Object
    //   163	1207	17	arrayOfFloat	float[]
    //   358	665	18	localObject3	Object
    //   368	343	19	localField1	java.lang.reflect.Field
    //   439	200	20	localField2	java.lang.reflect.Field
    //   459	127	21	localMethod	java.lang.reflect.Method
    //   425	172	22	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   596	717	720	java/lang/ClassNotFoundException
    //   596	717	724	java/lang/reflect/InvocationTargetException
    //   596	717	728	java/lang/NoSuchMethodException
    //   596	717	732	java/lang/IllegalAccessException
    //   596	717	736	java/lang/NoSuchFieldException
    //   447	596	740	java/lang/ClassNotFoundException
    //   447	596	744	java/lang/reflect/InvocationTargetException
    //   447	596	748	java/lang/NoSuchMethodException
    //   447	596	752	java/lang/IllegalAccessException
    //   447	596	756	java/lang/NoSuchFieldException
    //   379	447	760	java/lang/ClassNotFoundException
    //   379	447	764	java/lang/reflect/InvocationTargetException
    //   379	447	768	java/lang/NoSuchMethodException
    //   379	447	772	java/lang/IllegalAccessException
    //   379	447	776	java/lang/NoSuchFieldException
    //   370	376	780	java/lang/ClassNotFoundException
    //   370	376	784	java/lang/reflect/InvocationTargetException
    //   370	376	788	java/lang/NoSuchMethodException
    //   370	376	792	java/lang/IllegalAccessException
    //   370	376	796	java/lang/NoSuchFieldException
    //   353	370	800	java/lang/ClassNotFoundException
    //   353	370	839	java/lang/reflect/InvocationTargetException
    //   353	370	916	java/lang/NoSuchMethodException
    //   353	370	955	java/lang/IllegalAccessException
    //   353	370	994	java/lang/NoSuchFieldException
  }
  
  private static void hideAllNodeOfListMap(HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    paramHashMap = paramHashMap.values().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (List)paramHashMap.next();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PTSNodeVirtual localPTSNodeVirtual = (PTSNodeVirtual)((Iterator)localObject).next();
          if (localPTSNodeVirtual != null) {
            localPTSNodeVirtual.hideNode();
          }
        }
      }
    }
  }
  
  private static void makeAllNodeReusableOfListMap(HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    paramHashMap = paramHashMap.values().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (List)paramHashMap.next();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PTSNodeVirtual localPTSNodeVirtual = (PTSNodeVirtual)((Iterator)localObject).next();
          if (localPTSNodeVirtual != null) {
            localPTSNodeVirtual.setReusable(true);
          }
        }
      }
    }
  }
  
  public static void registerCustomViewNodeVirtual(String paramString1, String paramString2, PTSNodeVirtual.IBuilder paramIBuilder)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramIBuilder == null) {
        return;
      }
      registerNodeVirtualImp(getKey(paramString1, paramString2), paramIBuilder);
    }
  }
  
  public static void registerNodeVirtual(String paramString, PTSNodeVirtual.IBuilder paramIBuilder)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIBuilder == null) {
        return;
      }
      registerNodeVirtualImp(paramString, paramIBuilder);
    }
  }
  
  private static void registerNodeVirtualImp(String paramString, PTSNodeVirtual.IBuilder paramIBuilder)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIBuilder == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[registerNodeVirtualImp] key = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", builder = ");
      localStringBuilder.append(paramIBuilder.getClass());
      PTSLog.i("PTSNodeFactory", localStringBuilder.toString());
      sNodeBuilders.put(paramString, paramIBuilder);
    }
  }
  
  private static void registerNodeVirtualList()
  {
    registerNodeVirtual("view", new PTSNodeContainer.Builder());
    registerNodeVirtual("page", new PTSNodeContainer.Builder());
    registerNodeVirtual("block", new PTSNodeContainer.Builder());
    registerNodeVirtual("text", new PTSNodeText.Builder());
    registerNodeVirtual("img", new PTSNodeImage.Builder());
    registerNodeVirtual("swiper", new PTSNodeSwiper.Builder());
    registerNodeVirtual("swiper-item", new PTSNodeContainer.Builder());
    registerNodeVirtual("boring", new PTSNodeView.Builder());
    registerCustomViewNodeVirtual("view", "scroll-view", new PTSNodeScrollView.Builder());
  }
  
  private static void removeNodeFromParent(PTSNodeVirtual paramPTSNodeVirtual)
  {
    if (paramPTSNodeVirtual != null)
    {
      if (paramPTSNodeVirtual.getParent() == null) {
        return;
      }
      paramPTSNodeVirtual.getParent().removeChild(paramPTSNodeVirtual);
    }
  }
  
  private static void updateAllNodeLayoutAndAttributes(HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    paramHashMap = paramHashMap.values().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (List)paramHashMap.next();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PTSNodeVirtual localPTSNodeVirtual = (PTSNodeVirtual)((Iterator)localObject).next();
          if ((localPTSNodeVirtual != null) && (localPTSNodeVirtual.isVisible()))
          {
            localPTSNodeVirtual.applyLayout();
            localPTSNodeVirtual.onParseValueFinished();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeFactory
 * JD-Core Version:    0.7.0.1
 */