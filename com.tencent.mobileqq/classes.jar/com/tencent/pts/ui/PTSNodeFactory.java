package com.tencent.pts.ui;

import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeContainer;
import com.tencent.pts.ui.vnode.PTSNodeImage;
import com.tencent.pts.ui.vnode.PTSNodeScrollView;
import com.tencent.pts.ui.vnode.PTSNodeSwiper;
import com.tencent.pts.ui.vnode.PTSNodeText;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.pts.ui.vnode.PTSNodeView;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSReportUtil;
import com.tencent.pts.utils.PTSTimeCostUtil;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
    }
    for (;;)
    {
      if (paramHashMap.hasNext())
      {
        Iterator localIterator = ((List)paramHashMap.next()).iterator();
        while (localIterator.hasNext())
        {
          PTSNodeVirtual localPTSNodeVirtual = (PTSNodeVirtual)localIterator.next();
          if ((localPTSNodeVirtual != null) && (localPTSNodeVirtual.getNodeInfo() != null) && (TextUtils.equals(localPTSNodeVirtual.getNodeInfo().getUniqueID(), paramPTSNodeInfo)))
          {
            removeNodeFromParent(paramPTSNodeVirtual);
            localPTSNodeVirtual.addChild(paramPTSNodeVirtual);
          }
        }
      }
      for (int i = 1; i != 0; i = 0) {
        return;
      }
    }
  }
  
  private static void addToListMap(String paramString, PTSNodeVirtual paramPTSNodeVirtual, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPTSNodeVirtual == null) || (paramHashMap == null)) {
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
  
  public static PTSNodeVirtual bindData(PTSAppInstance paramPTSAppInstance, PTSNodeInfo paramPTSNodeInfo, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((paramPTSAppInstance == null) || (paramPTSNodeInfo == null) || (paramHashMap == null)) {
      return null;
    }
    hideAllNodeOfListMap(paramHashMap);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramPTSNodeInfo);
    Object localObject1 = null;
    if (!localLinkedList.isEmpty())
    {
      PTSNodeInfo localPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
      paramPTSNodeInfo = getReusableNodeFromListMap(localPTSNodeInfo.getAttributes().getViewID(), paramHashMap);
      Object localObject2;
      if (paramPTSNodeInfo == null)
      {
        localObject2 = buildVirtualNodeBFS(localPTSNodeInfo, paramPTSAppInstance, paramHashMap);
        paramPTSNodeInfo = (PTSNodeInfo)localObject2;
        if (localObject2 != null)
        {
          ((PTSNodeVirtual)localObject2).bindNodeInfo(localPTSNodeInfo);
          paramPTSNodeInfo = (PTSNodeInfo)localObject2;
        }
      }
      for (;;)
      {
        addNodeToParent(paramPTSNodeInfo, localPTSNodeInfo, paramHashMap);
        localObject2 = localObject1;
        if (localPTSNodeInfo.isRootNode()) {
          localObject2 = paramPTSNodeInfo;
        }
        if (paramPTSNodeInfo != null)
        {
          paramPTSNodeInfo.showNode();
          paramPTSNodeInfo.setReusable(false);
        }
        localObject1 = localObject2;
        if (!localPTSNodeInfo.isContainer()) {
          break;
        }
        localLinkedList.addAll(localPTSNodeInfo.getChildren());
        localObject1 = localObject2;
        break;
        paramPTSNodeInfo.bindNodeInfo(localPTSNodeInfo);
      }
    }
    makeAllNodeReusableOfListMap(paramHashMap);
    return localObject1;
  }
  
  public static PTSNodeVirtual buildVirtualNode(PTSNodeInfo paramPTSNodeInfo, PTSAppInstance paramPTSAppInstance)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramPTSNodeInfo == null) || (paramPTSAppInstance == null))
    {
      PTSLog.e("PTSNodeFactory", "can not buildVirtualNode, nodeInfo or appInstance is null.");
      localObject2 = localObject1;
      return localObject2;
    }
    localObject1 = "";
    if (paramPTSNodeInfo.getAttributes() != null) {
      localObject1 = PTSValueConvertUtil.getString(paramPTSNodeInfo.getAttributes().get("pts:custom-view"));
    }
    String str = getKey(paramPTSNodeInfo.getNodeType(), (String)localObject1);
    Constructor localConstructor = (Constructor)sNodeConstructors.get(str);
    localObject1 = localObject2;
    if (localConstructor != null) {
      PTSTimeCostUtil.start("[buildVirtualNode]-" + paramPTSNodeInfo.getUniqueID());
    }
    for (;;)
    {
      try
      {
        localObject1 = (PTSNodeVirtual)localConstructor.newInstance(new Object[] { paramPTSAppInstance });
      }
      catch (Exception localException1)
      {
        try
        {
          ((PTSNodeVirtual)localObject1).setViewID(paramPTSNodeInfo.getAttributes().getViewID());
          PTSTimeCostUtil.end("[buildVirtualNode]-" + paramPTSNodeInfo.getUniqueID());
          localObject2 = localObject1;
          if (localObject1 != null) {
            break;
          }
          localObject1 = "[buildVirtualNode] error, use default PTSNodeView, the node type constructor does not exist, key = " + str;
          PTSLog.e("PTSNodeFactory", (String)localObject1);
          PTSReportUtil.reportEvent("PTSNodeFactory", (String)localObject1, 1);
          paramPTSAppInstance = new PTSNodeView(paramPTSAppInstance);
          paramPTSAppInstance.setViewID(paramPTSNodeInfo.getAttributes().getViewID());
          ((PTSNodeView)paramPTSAppInstance).setNodeVirtualKey(str);
          return paramPTSAppInstance;
        }
        catch (Exception localException2)
        {
          break label228;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label228:
      PTSLog.e("PTSNodeFactory", "[buildVirtualNode] error, use default PTSNodeView, key = " + str + ", e = " + localException1 + ", stackTraceString = " + Log.getStackTraceString(localException1));
    }
  }
  
  public static PTSNodeVirtual buildVirtualNodeBFS(PTSNodeInfo paramPTSNodeInfo, PTSAppInstance paramPTSAppInstance, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((paramPTSNodeInfo == null) || (paramPTSAppInstance == null))
    {
      PTSLog.e("PTSNodeFactory", "can not buildVirtualNodeBFS, nodeInfo or appInstance is null.");
      localObject = null;
    }
    HashMap localHashMap;
    LinkedList localLinkedList;
    do
    {
      return localObject;
      localHashMap = new HashMap();
      localLinkedList = new LinkedList();
      localLinkedList.add(paramPTSNodeInfo);
      paramPTSNodeInfo = null;
      localObject = paramPTSNodeInfo;
    } while (localLinkedList.isEmpty());
    PTSNodeInfo localPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
    PTSNodeVirtual localPTSNodeVirtual = buildVirtualNode(localPTSNodeInfo, paramPTSAppInstance);
    String str = localPTSNodeInfo.getAttributes().getViewID();
    Object localObject = paramPTSNodeInfo;
    if (paramPTSNodeInfo == null) {
      localObject = localPTSNodeVirtual;
    }
    if (localPTSNodeVirtual == null)
    {
      PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], currentNode is null.");
      if (PTSLog.isDebug()) {
        throw new IllegalArgumentException("[buildVirtualNodeBFS], currentNode is null.");
      }
      PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], currentNode is null.");
    }
    if (localPTSNodeInfo.hasParent())
    {
      paramPTSNodeInfo = (PTSNodeVirtual)localHashMap.get(localPTSNodeInfo.getParentID());
      if (paramPTSNodeInfo != null) {
        paramPTSNodeInfo.addChild(localPTSNodeVirtual);
      }
    }
    else
    {
      label164:
      localHashMap.put(localPTSNodeInfo.getUniqueID(), localPTSNodeVirtual);
      if (TextUtils.isEmpty(str)) {
        break label255;
      }
      if (paramHashMap != null) {
        addToListMap(str, localPTSNodeVirtual, paramHashMap);
      }
    }
    for (;;)
    {
      paramPTSNodeInfo = (PTSNodeInfo)localObject;
      if (!localPTSNodeInfo.isContainer()) {
        break;
      }
      localLinkedList.addAll(localPTSNodeInfo.getChildren());
      paramPTSNodeInfo = (PTSNodeInfo)localObject;
      break;
      PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], parentNode is null, parentId = " + localPTSNodeInfo.getParentID());
      break label164;
      label255:
      PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], currentViewID is null.");
    }
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
          PTSLog.e("PTSNodeFactory", "[getCustomTextMeasuredSize] failed, measuredSize is not valid, key = " + paramString5);
          return arrayOfFloat;
        }
        catch (Exception paramArrayOfFloat)
        {
          PTSLog.e("PTSNodeFactory", "[getCustomTextMeasuredSize] error, key = " + paramString5 + ", e = " + paramArrayOfFloat);
          return arrayOfFloat;
        }
      }
      PTSLog.e("PTSNodeFactory", "[getCustomTextMeasuredSize] error, the node type constructor does not exist, key = " + paramString5);
    }
    return arrayOfFloat;
  }
  
  private static String getKey(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString1 + "-" + paramString2;
    }
    return str;
  }
  
  public static Constructor<? extends View> getNodeViewConstructor(Class<? extends PTSNodeVirtual> paramClass)
  {
    if (paramClass == null) {
      paramClass = null;
    }
    Constructor localConstructor;
    do
    {
      return paramClass;
      paramClass = paramClass.getName();
      localConstructor = (Constructor)sNodeViewConstructors.get(paramClass);
      paramClass = localConstructor;
    } while (localConstructor != null);
    printNodeConstructorsMap();
    return localConstructor;
  }
  
  private static PTSNodeVirtual getReusableNodeFromListMap(String paramString, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramHashMap == null)) {
      return null;
    }
    paramString = (List)paramHashMap.get(paramString);
    if ((paramString == null) || (paramString.size() <= 0)) {
      return null;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      paramHashMap = (PTSNodeVirtual)paramString.next();
      if ((paramHashMap != null) && (paramHashMap.getReusable())) {
        return paramHashMap;
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
        PTSLog.e("PTSNodeFactory", "[getRichTextMeasuredSize] failed, measuredSize is not valid, key = " + str);
        return arrayOfFloat;
      }
      catch (Exception paramArrayOfFloat)
      {
        PTSLog.e("PTSNodeFactory", "[getRichTextMeasuredSize] error, key = " + str + ", e = " + paramArrayOfFloat);
        return arrayOfFloat;
      }
    }
    PTSLog.e("PTSNodeFactory", "[getRichTextMeasuredSize] error, the node type constructor does not exist, key = " + str);
    return arrayOfFloat;
  }
  
  public static float[] getTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return getTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4, "normal");
  }
  
  public static float[] getTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 2))
    {
      PTSLog.e("PTSNodeFactory", "[getTextMeasuredSize] constrainedSize is not valid.");
      return paramArrayOfFloat;
    }
    PTSLog.i("PTSNodeFactory", "[getTextMeasuredSize] constrainedSize[0] = " + paramArrayOfFloat[0] + ", constrainedSize[1] = " + paramArrayOfFloat[1]);
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      if (paramArrayOfFloat[i] < 0.0F) {
        paramArrayOfFloat[i] = 0.0F;
      }
      i += 1;
    }
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    float f4 = PTSDeviceUtil.dp2px(PTSValueConvertUtil.getFloat(paramString2));
    localTextPaint.setTextSize(f4);
    if (TextUtils.equals("bold", paramString5))
    {
      localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      localTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramArrayOfFloat[0];
    arrayOfFloat[1] = paramArrayOfFloat[1];
    float f2 = PTSNodeTextBase.getLineSpacing(PTSValueConvertUtil.getFloat(paramString3), PTSValueConvertUtil.getFloat(paramString2), localTextPaint);
    int j = PTSValueConvertUtil.getInt(paramString4);
    int k = PTSDeviceUtil.dp2pxInt(Math.min(paramArrayOfFloat[0], PTSDeviceUtil.getScreenWidthDp()));
    label291:
    float f1;
    float f3;
    if (TextUtils.isEmpty(paramString1))
    {
      i = 0;
      if (Build.VERSION.SDK_INT < 23) {
        break label559;
      }
      paramArrayOfFloat = StaticLayout.Builder.obtain(paramString1, 0, i, localTextPaint, k).setEllipsizedWidth(k).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(j).setLineSpacing(f2, 1.0F).setText(paramString1).setEllipsize(TextUtils.TruncateAt.END);
      if (Build.VERSION.SDK_INT >= 28) {
        paramArrayOfFloat.setUseLineSpacingFromFallbacks(true);
      }
      paramArrayOfFloat = paramArrayOfFloat.build();
      f1 = PTSDeviceUtil.px2dp(Layout.getDesiredWidth(paramString1, localTextPaint));
      float f5 = PTSDeviceUtil.px2dp(paramArrayOfFloat.getWidth());
      float f6 = PTSDeviceUtil.px2dp(paramArrayOfFloat.getHeight());
      f3 = PTSDeviceUtil.px2dp(PTSNodeTextBase.getHeightOffset(f4, paramArrayOfFloat.getLineCount()));
      arrayOfFloat[0] = Math.min(f1, f5);
      arrayOfFloat[1] = (f6 + f3);
      f1 = 0.0F;
      if (paramArrayOfFloat.getLineCount() == 1) {
        if (!TextUtils.isEmpty(paramString1)) {
          break label1134;
        }
      }
    }
    label559:
    label1134:
    for (i = 0;; i = paramString1.length())
    {
      for (;;)
      {
        f1 = PTSDeviceUtil.px2dp(PTSNodeTextBase.getWidthOffset(f4, i));
        arrayOfFloat[0] += f1;
        if (PTSLog.isDebug()) {
          PTSLog.i("PTSNodeFactory", "[getTextMeasuredSizeImpNew], measuredWidth = " + arrayOfFloat[0] + " dp , measureHeight = " + arrayOfFloat[1] + " dp , content = " + paramString1 + ", fontSize = " + paramString2 + ", fontWeight = " + paramString5 + ", lineHeight = " + paramString3 + ", lineSpacing = " + f2 + ", lineClamp = " + paramString4 + ", layoutHeightOffset = " + f3 + " dp , layoutWidthOffset = " + f1 + " dp , actualLineCount = " + paramArrayOfFloat.getLineCount());
        }
        return arrayOfFloat;
        i = paramString1.length() - 1;
        break;
        paramArrayOfFloat = new StaticLayout(paramString1, 0, i, localTextPaint, k, Layout.Alignment.ALIGN_NORMAL, 1.0F, f2, false, TextUtils.TruncateAt.END, k);
        try
        {
          Object localObject1 = paramArrayOfFloat.getClass();
          Field localField1 = ((Class)localObject1).getDeclaredField("mMaximumVisibleLineCount");
          localField1.setAccessible(true);
          localField1.set(paramArrayOfFloat, Integer.valueOf(j));
          localField1 = ((Class)localObject1).getDeclaredField("mFontMetricsInt");
          localField1.setAccessible(true);
          localField1.set(paramArrayOfFloat, new Paint.FontMetricsInt());
          Object localObject2 = Class.forName("android.text.TextDirectionHeuristic");
          Field localField2 = Class.forName("android.text.TextDirectionHeuristics").getDeclaredField("FIRSTSTRONG_LTR");
          localField2.setAccessible(true);
          Method localMethod = ((Class)localObject1).getDeclaredMethod("prepare", new Class[0]);
          localObject2 = ((Class)localObject1).getDeclaredMethod("generate", new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, localObject2, Float.TYPE, Float.TYPE, Boolean.TYPE, Boolean.TYPE, Float.TYPE, TextUtils.TruncateAt.class });
          localObject1 = ((Class)localObject1).getDeclaredMethod("finish", new Class[0]);
          localMethod.setAccessible(true);
          ((Method)localObject2).setAccessible(true);
          ((Method)localObject1).setAccessible(true);
          localMethod.invoke(paramArrayOfFloat, new Object[0]);
          ((Method)localObject2).invoke(paramArrayOfFloat, new Object[] { paramString1, Integer.valueOf(0), Integer.valueOf(i), localTextPaint, Integer.valueOf(k), localField2.get(null), Float.valueOf(1.0F), Float.valueOf(f2), Boolean.valueOf(false), Boolean.valueOf(false), Float.valueOf(k), TextUtils.TruncateAt.END });
          ((Method)localObject1).invoke(paramArrayOfFloat, new Object[0]);
          localField1.set(paramArrayOfFloat, null);
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          PTSLog.e("PTSNodeFactory", "[getTextMeasuredSizeImpNew] e = " + localNoSuchFieldException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          PTSLog.e("PTSNodeFactory", "[getTextMeasuredSizeImpNew] e = " + localIllegalAccessException);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          PTSLog.e("PTSNodeFactory", "[getTextMeasuredSizeImpNew] e = " + localNoSuchMethodException);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          PTSLog.e("PTSNodeFactory", "[getTextMeasuredSizeImpNew] e = " + localInvocationTargetException);
          PTSLog.e("PTSNodeFactory", "[getTextMeasuredSizeImpNew] trace = " + localInvocationTargetException.getTargetException());
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          PTSLog.e("PTSNodeFactory", "[getTextMeasuredSizeImpNew], e = " + localClassNotFoundException);
        }
      }
      break label291;
    }
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
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      PTSLog.i("PTSNodeFactory", "[printNodeConstructorsMap] node constructor key = " + str);
    }
    localIterator = sNodeViewConstructors.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      PTSLog.i("PTSNodeFactory", "[printNodeConstructorsMap] node view constructor key = " + str);
    }
  }
  
  public static void registerCustomViewNodeVirtual(String paramString1, String paramString2, Class<? extends PTSNodeVirtual> paramClass)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramClass == null)) {
      return;
    }
    registerNodeVirtualImp(getKey(paramString1, paramString2), paramClass);
  }
  
  public static void registerNodeVirtual(String paramString, Class<? extends PTSNodeVirtual> paramClass)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramClass == null)) {
      return;
    }
    registerNodeVirtualImp(paramString, paramClass);
  }
  
  private static void registerNodeVirtualImp(String paramString, Class<? extends PTSNodeVirtual> paramClass)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramClass == null)) {
      return;
    }
    PTSLog.i("PTSNodeFactory", "[registerNodeVirtualImp] key = " + paramString + ", class = " + paramClass.getName());
    try
    {
      Object localObject = paramClass.getDeclaredConstructor(new Class[] { PTSAppInstance.class });
      ((Constructor)localObject).setAccessible(true);
      sNodeConstructors.put(paramString, localObject);
      localObject = paramClass.getName();
      try
      {
        Constructor localConstructor = ((Class)((java.lang.reflect.ParameterizedType)paramClass.getGenericSuperclass()).getActualTypeArguments()[0]).getDeclaredConstructor(new Class[] { paramClass });
        localConstructor.setAccessible(true);
        sNodeViewConstructors.put(localObject, localConstructor);
        return;
      }
      catch (Exception localException)
      {
        PTSLog.e("PTSNodeFactory", "[registerNodeVirtualImp] register view constructor error, e = " + localException + ", key = " + paramString + ", class = " + paramClass.getName());
        return;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        PTSLog.e("PTSNodeFactory", "[registerNodeVirtualImp] register node constructor error, e = " + localNoSuchMethodException + ", key = " + paramString + ", class = " + paramClass.getName());
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
    if ((paramPTSNodeVirtual == null) || (paramPTSNodeVirtual.getParent() == null)) {
      return;
    }
    paramPTSNodeVirtual.getParent().removeChild(paramPTSNodeVirtual);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeFactory
 * JD-Core Version:    0.7.0.1
 */