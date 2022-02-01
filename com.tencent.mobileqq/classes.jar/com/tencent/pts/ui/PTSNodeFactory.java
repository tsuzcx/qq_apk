package com.tencent.pts.ui;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeContainer;
import com.tencent.pts.ui.vnode.PTSNodeImage;
import com.tencent.pts.ui.vnode.PTSNodeScrollView;
import com.tencent.pts.ui.vnode.PTSNodeSwiper;
import com.tencent.pts.ui.vnode.PTSNodeText;
import com.tencent.pts.ui.vnode.PTSNodeView;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSReportUtil;
import com.tencent.pts.utils.PTSTimeCostUtil;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PTSNodeFactory
{
  private static final String TAG = "PTSNodeFactory";
  private static HashMap<String, Constructor<? extends PTSNodeVirtual>> sNodeConstructors = new HashMap();
  private static HashMap<String, Constructor<? extends View>> sNodeViewConstructors = new HashMap();
  
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
          addNodeToParent((PTSNodeVirtual)localObject1, localPTSNodeInfo, paramHashMap);
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
    StringBuilder localStringBuilder = null;
    if ((paramPTSNodeInfo != null) && (paramPTSAppInstance != null))
    {
      if (paramPTSNodeInfo.getAttributes() != null) {
        localObject1 = PTSValueConvertUtil.getString(paramPTSNodeInfo.getAttributes().get("pts:custom-view"));
      } else {
        localObject1 = "";
      }
      String str = getKey(paramPTSNodeInfo.getNodeType(), (String)localObject1);
      Constructor localConstructor = (Constructor)sNodeConstructors.get(str);
      Object localObject1 = localObject2;
      if (localConstructor != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[buildVirtualNode]-");
        ((StringBuilder)localObject1).append(paramPTSNodeInfo.getUniqueID());
        PTSTimeCostUtil.start(((StringBuilder)localObject1).toString());
        try
        {
          localObject1 = (PTSNodeVirtual)localConstructor.newInstance(new Object[] { paramPTSAppInstance });
          try
          {
            ((PTSNodeVirtual)localObject1).setViewID(paramPTSNodeInfo.getAttributes().getViewID());
          }
          catch (Exception localException1) {}
          localStringBuilder = new StringBuilder();
        }
        catch (Exception localException2)
        {
          localObject1 = localStringBuilder;
        }
        localStringBuilder.append("[buildVirtualNode] error, use default PTSNodeView, key = ");
        localStringBuilder.append(str);
        localStringBuilder.append(", e = ");
        localStringBuilder.append(localException2);
        localStringBuilder.append(", stackTraceString = ");
        localStringBuilder.append(Log.getStackTraceString(localException2));
        PTSLog.e("PTSNodeFactory", localStringBuilder.toString());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[buildVirtualNode]-");
        ((StringBuilder)localObject3).append(paramPTSNodeInfo.getUniqueID());
        PTSTimeCostUtil.end(((StringBuilder)localObject3).toString());
      }
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[buildVirtualNode] error, use default PTSNodeView, the node type constructor does not exist, key = ");
        ((StringBuilder)localObject1).append(str);
        localObject1 = ((StringBuilder)localObject1).toString();
        PTSLog.e("PTSNodeFactory", (String)localObject1);
        PTSReportUtil.reportEvent("PTSNodeFactory", (String)localObject1, 1);
        localObject3 = new PTSNodeView(paramPTSAppInstance);
        ((PTSNodeVirtual)localObject3).setViewID(paramPTSNodeInfo.getAttributes().getViewID());
        ((PTSNodeView)localObject3).setNodeVirtualKey(str);
      }
      return localObject3;
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
    float[] arrayOfFloat = new float[2];
    if (!TextUtils.isEmpty(paramString5))
    {
      paramString5 = getKey("text", paramString5);
      Object localObject = (Constructor)sNodeConstructors.get(paramString5);
      if (localObject != null) {
        try
        {
          localObject = (PTSNodeVirtual)((Constructor)localObject).newInstance(new Object[] { null });
          paramArrayOfFloat = (float[])localObject.getClass().getMethod("getTextMeasuredSize", new Class[] { [F.class, String.class, String.class, String.class, String.class, String.class, String.class }).invoke(localObject, new Object[] { paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, paramString6, paramString7 });
          if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 2))
          {
            arrayOfFloat[0] = paramArrayOfFloat[0];
            arrayOfFloat[1] = paramArrayOfFloat[1];
            return arrayOfFloat;
          }
          paramArrayOfFloat = new StringBuilder();
          paramArrayOfFloat.append("[getCustomTextMeasuredSize] failed, measuredSize is not valid, key = ");
          paramArrayOfFloat.append(paramString5);
          PTSLog.e("PTSNodeFactory", paramArrayOfFloat.toString());
          return arrayOfFloat;
        }
        catch (Exception paramArrayOfFloat)
        {
          paramString1 = new StringBuilder();
          paramString1.append("[getCustomTextMeasuredSize] error, key = ");
          paramString1.append(paramString5);
          paramString1.append(", e = ");
          paramString1.append(paramArrayOfFloat);
          PTSLog.e("PTSNodeFactory", paramString1.toString());
          return arrayOfFloat;
        }
      }
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("[getCustomTextMeasuredSize] error, the node type constructor does not exist, key = ");
      paramArrayOfFloat.append(paramString5);
      PTSLog.e("PTSNodeFactory", paramArrayOfFloat.toString());
    }
    return arrayOfFloat;
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
  
  public static Constructor<? extends View> getNodeViewConstructor(Class<? extends PTSNodeVirtual> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    paramClass = paramClass.getName();
    paramClass = (Constructor)sNodeViewConstructors.get(paramClass);
    if (paramClass == null) {
      printNodeConstructorsMap();
    }
    return paramClass;
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
    float[] arrayOfFloat = new float[2];
    String str = getKey("rich-text", "");
    Object localObject = (Constructor)sNodeConstructors.get(str);
    if (localObject != null) {
      try
      {
        localObject = (PTSNodeVirtual)((Constructor)localObject).newInstance(new Object[] { null });
        paramArrayOfFloat = (float[])localObject.getClass().getMethod("getRichTextMeasuredSize", new Class[] { [F.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class }).invoke(localObject, new Object[] { paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7 });
        if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 2))
        {
          arrayOfFloat[0] = paramArrayOfFloat[0];
          arrayOfFloat[1] = paramArrayOfFloat[1];
          return arrayOfFloat;
        }
        paramArrayOfFloat = new StringBuilder();
        paramArrayOfFloat.append("[getRichTextMeasuredSize] failed, measuredSize is not valid, key = ");
        paramArrayOfFloat.append(str);
        PTSLog.e("PTSNodeFactory", paramArrayOfFloat.toString());
        return arrayOfFloat;
      }
      catch (Exception paramArrayOfFloat)
      {
        paramString1 = new StringBuilder();
        paramString1.append("[getRichTextMeasuredSize] error, key = ");
        paramString1.append(str);
        paramString1.append(", e = ");
        paramString1.append(paramArrayOfFloat);
        PTSLog.e("PTSNodeFactory", paramString1.toString());
        return arrayOfFloat;
      }
    }
    paramArrayOfFloat = new StringBuilder();
    paramArrayOfFloat.append("[getRichTextMeasuredSize] error, the node type constructor does not exist, key = ");
    paramArrayOfFloat.append(str);
    PTSLog.e("PTSNodeFactory", paramArrayOfFloat.toString());
    return arrayOfFloat;
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
    //   13: new 202	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   20: astore 15
    //   22: aload 15
    //   24: ldc_w 371
    //   27: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 15
    //   33: aload_0
    //   34: iconst_0
    //   35: faload
    //   36: invokevirtual 374	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 15
    //   42: ldc_w 376
    //   45: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 15
    //   51: aload_0
    //   52: iconst_1
    //   53: faload
    //   54: invokevirtual 374	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc 8
    //   60: aload 15
    //   62: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 379	com/tencent/pts/utils/PTSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   101: new 381	android/text/TextPaint
    //   104: dup
    //   105: invokespecial 382	android/text/TextPaint:<init>	()V
    //   108: astore 15
    //   110: aload 15
    //   112: iconst_1
    //   113: invokevirtual 385	android/text/TextPaint:setAntiAlias	(Z)V
    //   116: aload_2
    //   117: invokestatic 389	com/tencent/pts/utils/PTSValueConvertUtil:getFloat	(Ljava/lang/Object;)F
    //   120: invokestatic 395	com/tencent/pts/utils/PTSDeviceUtil:dp2px	(F)F
    //   123: fstore 6
    //   125: aload 15
    //   127: fload 6
    //   129: invokevirtual 399	android/text/TextPaint:setTextSize	(F)V
    //   132: ldc_w 401
    //   135: aload 5
    //   137: invokestatic 78	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   140: ifeq +20 -> 160
    //   143: aload 15
    //   145: getstatic 407	android/graphics/Paint$Style:FILL_AND_STROKE	Landroid/graphics/Paint$Style;
    //   148: invokevirtual 411	android/text/TextPaint:setStyle	(Landroid/graphics/Paint$Style;)V
    //   151: aload 15
    //   153: getstatic 417	android/graphics/Typeface:DEFAULT_BOLD	Landroid/graphics/Typeface;
    //   156: invokevirtual 421	android/text/TextPaint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
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
    //   180: invokestatic 389	com/tencent/pts/utils/PTSValueConvertUtil:getFloat	(Ljava/lang/Object;)F
    //   183: aload_2
    //   184: invokestatic 389	com/tencent/pts/utils/PTSValueConvertUtil:getFloat	(Ljava/lang/Object;)F
    //   187: aload 15
    //   189: invokestatic 427	com/tencent/pts/ui/vnode/PTSNodeTextBase:getLineSpacing	(FFLandroid/text/TextPaint;)F
    //   192: fstore 7
    //   194: aload 4
    //   196: invokestatic 431	com/tencent/pts/utils/PTSValueConvertUtil:getInt	(Ljava/lang/Object;)I
    //   199: istore 13
    //   201: aload_0
    //   202: iconst_0
    //   203: faload
    //   204: invokestatic 435	com/tencent/pts/utils/PTSDeviceUtil:getScreenWidthDp	()F
    //   207: invokestatic 441	java/lang/Math:min	(FF)F
    //   210: invokestatic 445	com/tencent/pts/utils/PTSDeviceUtil:dp2pxInt	(F)I
    //   213: istore 14
    //   215: aload_1
    //   216: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   219: ifeq +9 -> 228
    //   222: iconst_0
    //   223: istore 12
    //   225: goto +11 -> 236
    //   228: aload_1
    //   229: invokevirtual 448	java/lang/String:length	()I
    //   232: iconst_1
    //   233: isub
    //   234: istore 12
    //   236: getstatic 454	android/os/Build$VERSION:SDK_INT	I
    //   239: bipush 23
    //   241: if_icmplt +73 -> 314
    //   244: aload_1
    //   245: iconst_0
    //   246: iload 12
    //   248: aload 15
    //   250: iload 14
    //   252: invokestatic 460	android/text/StaticLayout$Builder:obtain	(Ljava/lang/CharSequence;IILandroid/text/TextPaint;I)Landroid/text/StaticLayout$Builder;
    //   255: iload 14
    //   257: invokevirtual 464	android/text/StaticLayout$Builder:setEllipsizedWidth	(I)Landroid/text/StaticLayout$Builder;
    //   260: getstatic 470	android/text/Layout$Alignment:ALIGN_NORMAL	Landroid/text/Layout$Alignment;
    //   263: invokevirtual 474	android/text/StaticLayout$Builder:setAlignment	(Landroid/text/Layout$Alignment;)Landroid/text/StaticLayout$Builder;
    //   266: iconst_0
    //   267: invokevirtual 478	android/text/StaticLayout$Builder:setIncludePad	(Z)Landroid/text/StaticLayout$Builder;
    //   270: iload 13
    //   272: invokevirtual 481	android/text/StaticLayout$Builder:setMaxLines	(I)Landroid/text/StaticLayout$Builder;
    //   275: fload 7
    //   277: fconst_1
    //   278: invokevirtual 485	android/text/StaticLayout$Builder:setLineSpacing	(FF)Landroid/text/StaticLayout$Builder;
    //   281: aload_1
    //   282: invokevirtual 489	android/text/StaticLayout$Builder:setText	(Ljava/lang/CharSequence;)Landroid/text/StaticLayout$Builder;
    //   285: getstatic 495	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   288: invokevirtual 499	android/text/StaticLayout$Builder:setEllipsize	(Landroid/text/TextUtils$TruncateAt;)Landroid/text/StaticLayout$Builder;
    //   291: astore_0
    //   292: getstatic 454	android/os/Build$VERSION:SDK_INT	I
    //   295: bipush 28
    //   297: if_icmplt +9 -> 306
    //   300: aload_0
    //   301: iconst_1
    //   302: invokevirtual 502	android/text/StaticLayout$Builder:setUseLineSpacingFromFallbacks	(Z)Landroid/text/StaticLayout$Builder;
    //   305: pop
    //   306: aload_0
    //   307: invokevirtual 506	android/text/StaticLayout$Builder:build	()Landroid/text/StaticLayout;
    //   310: astore_0
    //   311: goto +722 -> 1033
    //   314: getstatic 470	android/text/Layout$Alignment:ALIGN_NORMAL	Landroid/text/Layout$Alignment;
    //   317: astore_0
    //   318: getstatic 495	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   321: astore 16
    //   323: fload 7
    //   325: fstore 8
    //   327: new 508	android/text/StaticLayout
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
    //   348: invokespecial 511	android/text/StaticLayout:<init>	(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZLandroid/text/TextUtils$TruncateAt;I)V
    //   351: astore 16
    //   353: aload 16
    //   355: invokevirtual 303	java/lang/Object:getClass	()Ljava/lang/Class;
    //   358: astore 18
    //   360: aload 18
    //   362: ldc_w 513
    //   365: invokevirtual 517	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   368: astore 19
    //   370: aload 19
    //   372: iconst_1
    //   373: invokevirtual 522	java/lang/reflect/Field:setAccessible	(Z)V
    //   376: aload 16
    //   378: astore_0
    //   379: aload 19
    //   381: aload_0
    //   382: iload 13
    //   384: invokestatic 528	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   387: invokevirtual 532	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   390: aload 18
    //   392: ldc_w 534
    //   395: invokevirtual 517	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   398: astore 19
    //   400: aload 19
    //   402: iconst_1
    //   403: invokevirtual 522	java/lang/reflect/Field:setAccessible	(Z)V
    //   406: aload 19
    //   408: aload_0
    //   409: new 536	android/graphics/Paint$FontMetricsInt
    //   412: dup
    //   413: invokespecial 537	android/graphics/Paint$FontMetricsInt:<init>	()V
    //   416: invokevirtual 532	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   419: ldc_w 539
    //   422: invokestatic 543	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   425: astore 22
    //   427: ldc_w 545
    //   430: invokestatic 543	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   433: ldc_w 547
    //   436: invokevirtual 517	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   439: astore 20
    //   441: aload 20
    //   443: iconst_1
    //   444: invokevirtual 522	java/lang/reflect/Field:setAccessible	(Z)V
    //   447: aload 18
    //   449: ldc_w 549
    //   452: iconst_0
    //   453: anewarray 307	java/lang/Class
    //   456: invokevirtual 552	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   459: astore 21
    //   461: aload 18
    //   463: ldc_w 554
    //   466: bipush 12
    //   468: anewarray 307	java/lang/Class
    //   471: dup
    //   472: iconst_0
    //   473: ldc_w 556
    //   476: aastore
    //   477: dup
    //   478: iconst_1
    //   479: getstatic 560	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   482: aastore
    //   483: dup
    //   484: iconst_2
    //   485: getstatic 560	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   488: aastore
    //   489: dup
    //   490: iconst_3
    //   491: ldc_w 381
    //   494: aastore
    //   495: dup
    //   496: iconst_4
    //   497: getstatic 560	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   500: aastore
    //   501: dup
    //   502: iconst_5
    //   503: aload 22
    //   505: aastore
    //   506: dup
    //   507: bipush 6
    //   509: getstatic 563	java/lang/Float:TYPE	Ljava/lang/Class;
    //   512: aastore
    //   513: dup
    //   514: bipush 7
    //   516: getstatic 563	java/lang/Float:TYPE	Ljava/lang/Class;
    //   519: aastore
    //   520: dup
    //   521: bipush 8
    //   523: getstatic 566	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   526: aastore
    //   527: dup
    //   528: bipush 9
    //   530: getstatic 566	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   533: aastore
    //   534: dup
    //   535: bipush 10
    //   537: getstatic 563	java/lang/Float:TYPE	Ljava/lang/Class;
    //   540: aastore
    //   541: dup
    //   542: bipush 11
    //   544: ldc_w 491
    //   547: aastore
    //   548: invokevirtual 552	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   551: astore 22
    //   553: aload 18
    //   555: ldc_w 568
    //   558: iconst_0
    //   559: anewarray 307	java/lang/Class
    //   562: invokevirtual 552	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   565: astore 18
    //   567: aload 21
    //   569: iconst_1
    //   570: invokevirtual 569	java/lang/reflect/Method:setAccessible	(Z)V
    //   573: aload 22
    //   575: iconst_1
    //   576: invokevirtual 569	java/lang/reflect/Method:setAccessible	(Z)V
    //   579: aload 18
    //   581: iconst_1
    //   582: invokevirtual 569	java/lang/reflect/Method:setAccessible	(Z)V
    //   585: aload 21
    //   587: aload_0
    //   588: iconst_0
    //   589: anewarray 4	java/lang/Object
    //   592: invokevirtual 321	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
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
    //   611: invokestatic 528	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   614: aastore
    //   615: dup
    //   616: iconst_2
    //   617: iload 12
    //   619: invokestatic 528	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   622: aastore
    //   623: dup
    //   624: iconst_3
    //   625: aload 15
    //   627: aastore
    //   628: dup
    //   629: iconst_4
    //   630: iload 14
    //   632: invokestatic 528	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   635: aastore
    //   636: dup
    //   637: iconst_5
    //   638: aload 20
    //   640: aconst_null
    //   641: invokevirtual 570	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   644: aastore
    //   645: dup
    //   646: bipush 6
    //   648: fconst_1
    //   649: invokestatic 573	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   652: aastore
    //   653: dup
    //   654: bipush 7
    //   656: fload 8
    //   658: invokestatic 573	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   661: aastore
    //   662: dup
    //   663: bipush 8
    //   665: iconst_0
    //   666: invokestatic 576	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   669: aastore
    //   670: dup
    //   671: bipush 9
    //   673: iconst_0
    //   674: invokestatic 576	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   677: aastore
    //   678: dup
    //   679: bipush 10
    //   681: iload 14
    //   683: i2f
    //   684: invokestatic 573	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   687: aastore
    //   688: dup
    //   689: bipush 11
    //   691: getstatic 495	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   694: aastore
    //   695: invokevirtual 321	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   698: pop
    //   699: aload 18
    //   701: aload_0
    //   702: iconst_0
    //   703: anewarray 4	java/lang/Object
    //   706: invokevirtual 321	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   709: pop
    //   710: aload 19
    //   712: aload_0
    //   713: aconst_null
    //   714: invokevirtual 532	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
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
    //   801: new 202	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   808: astore 18
    //   810: aload 18
    //   812: ldc_w 578
    //   815: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload 18
    //   821: aload_0
    //   822: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: ldc 8
    //   828: aload 18
    //   830: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokestatic 246	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   836: goto +194 -> 1030
    //   839: astore_0
    //   840: new 202	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   847: astore 18
    //   849: aload 18
    //   851: ldc_w 580
    //   854: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload 18
    //   860: aload_0
    //   861: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: ldc 8
    //   867: aload 18
    //   869: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: invokestatic 246	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   875: new 202	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   882: astore 18
    //   884: aload 18
    //   886: ldc_w 582
    //   889: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: aload 18
    //   895: aload_0
    //   896: invokevirtual 586	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   899: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: ldc 8
    //   905: aload 18
    //   907: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: invokestatic 246	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   913: goto +117 -> 1030
    //   916: astore_0
    //   917: new 202	java/lang/StringBuilder
    //   920: dup
    //   921: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   924: astore 18
    //   926: aload 18
    //   928: ldc_w 580
    //   931: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: aload 18
    //   937: aload_0
    //   938: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   941: pop
    //   942: ldc 8
    //   944: aload 18
    //   946: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   949: invokestatic 246	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   952: goto +78 -> 1030
    //   955: astore_0
    //   956: new 202	java/lang/StringBuilder
    //   959: dup
    //   960: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   963: astore 18
    //   965: aload 18
    //   967: ldc_w 580
    //   970: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: aload 18
    //   976: aload_0
    //   977: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   980: pop
    //   981: ldc 8
    //   983: aload 18
    //   985: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokestatic 246	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   991: goto +39 -> 1030
    //   994: astore_0
    //   995: new 202	java/lang/StringBuilder
    //   998: dup
    //   999: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1002: astore 18
    //   1004: aload 18
    //   1006: ldc_w 580
    //   1009: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: pop
    //   1013: aload 18
    //   1015: aload_0
    //   1016: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: ldc 8
    //   1022: aload 18
    //   1024: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1027: invokestatic 246	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1030: aload 16
    //   1032: astore_0
    //   1033: aload_1
    //   1034: aload 15
    //   1036: invokestatic 592	android/text/Layout:getDesiredWidth	(Ljava/lang/CharSequence;Landroid/text/TextPaint;)F
    //   1039: invokestatic 595	com/tencent/pts/utils/PTSDeviceUtil:px2dp	(F)F
    //   1042: fstore 9
    //   1044: aload_0
    //   1045: invokevirtual 598	android/text/StaticLayout:getWidth	()I
    //   1048: i2f
    //   1049: invokestatic 595	com/tencent/pts/utils/PTSDeviceUtil:px2dp	(F)F
    //   1052: fstore 10
    //   1054: aload_0
    //   1055: invokevirtual 601	android/text/StaticLayout:getHeight	()I
    //   1058: i2f
    //   1059: invokestatic 595	com/tencent/pts/utils/PTSDeviceUtil:px2dp	(F)F
    //   1062: fstore 11
    //   1064: fload 6
    //   1066: aload_0
    //   1067: invokevirtual 604	android/text/StaticLayout:getLineCount	()I
    //   1070: invokestatic 608	com/tencent/pts/ui/vnode/PTSNodeTextBase:getHeightOffset	(FI)F
    //   1073: invokestatic 595	com/tencent/pts/utils/PTSDeviceUtil:px2dp	(F)F
    //   1076: fstore 8
    //   1078: aload 17
    //   1080: iconst_0
    //   1081: fload 9
    //   1083: fload 10
    //   1085: invokestatic 441	java/lang/Math:min	(FF)F
    //   1088: fastore
    //   1089: aload 17
    //   1091: iconst_1
    //   1092: fload 11
    //   1094: fload 8
    //   1096: fadd
    //   1097: fastore
    //   1098: aload_0
    //   1099: invokevirtual 604	android/text/StaticLayout:getLineCount	()I
    //   1102: iconst_1
    //   1103: if_icmpne +48 -> 1151
    //   1106: aload_1
    //   1107: invokestatic 94	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1110: ifeq +9 -> 1119
    //   1113: iconst_0
    //   1114: istore 12
    //   1116: goto +9 -> 1125
    //   1119: aload_1
    //   1120: invokevirtual 448	java/lang/String:length	()I
    //   1123: istore 12
    //   1125: fload 6
    //   1127: iload 12
    //   1129: invokestatic 611	com/tencent/pts/ui/vnode/PTSNodeTextBase:getWidthOffset	(FI)F
    //   1132: invokestatic 595	com/tencent/pts/utils/PTSDeviceUtil:px2dp	(F)F
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
    //   1154: invokestatic 274	com/tencent/pts/utils/PTSLog:isDebug	()Z
    //   1157: ifeq +212 -> 1369
    //   1160: new 202	java/lang/StringBuilder
    //   1163: dup
    //   1164: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1167: astore 15
    //   1169: aload 15
    //   1171: ldc_w 613
    //   1174: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: pop
    //   1178: aload 15
    //   1180: aload 17
    //   1182: iconst_0
    //   1183: faload
    //   1184: invokevirtual 374	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1187: pop
    //   1188: aload 15
    //   1190: ldc_w 615
    //   1193: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: pop
    //   1197: aload 15
    //   1199: aload 17
    //   1201: iconst_1
    //   1202: faload
    //   1203: invokevirtual 374	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: aload 15
    //   1209: ldc_w 617
    //   1212: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1215: pop
    //   1216: aload 15
    //   1218: aload_1
    //   1219: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: pop
    //   1223: aload 15
    //   1225: ldc_w 619
    //   1228: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload 15
    //   1234: aload_2
    //   1235: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: pop
    //   1239: aload 15
    //   1241: ldc_w 621
    //   1244: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: aload 15
    //   1250: aload 5
    //   1252: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: pop
    //   1256: aload 15
    //   1258: ldc_w 623
    //   1261: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: pop
    //   1265: aload 15
    //   1267: aload_3
    //   1268: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: aload 15
    //   1274: ldc_w 625
    //   1277: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: pop
    //   1281: aload 15
    //   1283: fload 7
    //   1285: invokevirtual 374	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1288: pop
    //   1289: aload 15
    //   1291: ldc_w 627
    //   1294: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1297: pop
    //   1298: aload 15
    //   1300: aload 4
    //   1302: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: pop
    //   1306: aload 15
    //   1308: ldc_w 629
    //   1311: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1314: pop
    //   1315: aload 15
    //   1317: fload 8
    //   1319: invokevirtual 374	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1322: pop
    //   1323: aload 15
    //   1325: ldc_w 631
    //   1328: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: pop
    //   1332: aload 15
    //   1334: fload 6
    //   1336: invokevirtual 374	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1339: pop
    //   1340: aload 15
    //   1342: ldc_w 633
    //   1345: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: aload 15
    //   1351: aload_0
    //   1352: invokevirtual 604	android/text/StaticLayout:getLineCount	()I
    //   1355: invokevirtual 636	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1358: pop
    //   1359: ldc 8
    //   1361: aload 15
    //   1363: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1366: invokestatic 379	com/tencent/pts/utils/PTSLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1369: aload 17
    //   1371: areturn
    //   1372: ldc 8
    //   1374: ldc_w 638
    //   1377: invokestatic 246	com/tencent/pts/utils/PTSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   459	127	21	localMethod	Method
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
  
  private static void printNodeConstructorsMap()
  {
    Iterator localIterator = sNodeConstructors.keySet().iterator();
    String str;
    StringBuilder localStringBuilder;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[printNodeConstructorsMap] node constructor key = ");
      localStringBuilder.append(str);
      PTSLog.i("PTSNodeFactory", localStringBuilder.toString());
    }
    localIterator = sNodeViewConstructors.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[printNodeConstructorsMap] node view constructor key = ");
      localStringBuilder.append(str);
      PTSLog.i("PTSNodeFactory", localStringBuilder.toString());
    }
  }
  
  public static void registerCustomViewNodeVirtual(String paramString1, String paramString2, Class<? extends PTSNodeVirtual> paramClass)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramClass == null) {
        return;
      }
      registerNodeVirtualImp(getKey(paramString1, paramString2), paramClass);
    }
  }
  
  public static void registerNodeVirtual(String paramString, Class<? extends PTSNodeVirtual> paramClass)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramClass == null) {
        return;
      }
      registerNodeVirtualImp(paramString, paramClass);
    }
  }
  
  private static void registerNodeVirtualImp(String paramString, Class<? extends PTSNodeVirtual> paramClass)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramClass == null) {
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[registerNodeVirtualImp] key = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", class = ");
      ((StringBuilder)localObject1).append(paramClass.getName());
      PTSLog.i("PTSNodeFactory", ((StringBuilder)localObject1).toString());
      Object localObject2;
      try
      {
        localObject1 = paramClass.getDeclaredConstructor(new Class[] { PTSAppInstance.class });
        ((Constructor)localObject1).setAccessible(true);
        sNodeConstructors.put(paramString, localObject1);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[registerNodeVirtualImp] register node constructor error, e = ");
        ((StringBuilder)localObject2).append(localNoSuchMethodException);
        ((StringBuilder)localObject2).append(", key = ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(", class = ");
        ((StringBuilder)localObject2).append(paramClass.getName());
        PTSLog.e("PTSNodeFactory", ((StringBuilder)localObject2).toString());
      }
      String str = paramClass.getName();
      try
      {
        localObject2 = ((Class)((java.lang.reflect.ParameterizedType)paramClass.getGenericSuperclass()).getActualTypeArguments()[0]).getDeclaredConstructor(new Class[] { paramClass });
        ((Constructor)localObject2).setAccessible(true);
        sNodeViewConstructors.put(str, localObject2);
        return;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[registerNodeVirtualImp] register view constructor error, e = ");
        ((StringBuilder)localObject2).append(localException);
        ((StringBuilder)localObject2).append(", key = ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(", class = ");
        ((StringBuilder)localObject2).append(paramClass.getName());
        PTSLog.e("PTSNodeFactory", ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private static void registerNodeVirtualList()
  {
    registerNodeVirtual("view", PTSNodeContainer.class);
    registerNodeVirtual("page", PTSNodeContainer.class);
    registerNodeVirtual("block", PTSNodeContainer.class);
    registerNodeVirtual("text", PTSNodeText.class);
    registerNodeVirtual("img", PTSNodeImage.class);
    registerNodeVirtual("swiper", PTSNodeSwiper.class);
    registerNodeVirtual("swiper-item", PTSNodeContainer.class);
    registerNodeVirtual("boring", PTSNodeView.class);
    registerCustomViewNodeVirtual("view", "scroll-view", PTSNodeScrollView.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeFactory
 * JD-Core Version:    0.7.0.1
 */