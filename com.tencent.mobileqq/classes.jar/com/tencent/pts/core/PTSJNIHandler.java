package com.tencent.pts.core;

import android.text.TextUtils;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.List;

public class PTSJNIHandler
{
  private static String TAG = "PTSJNIHandler";
  private static HashMap<Integer, PTSAppInstance> sAppInstanceMap;
  private static HashMap<PTSAppInstance, PTSJNIHandler> sAppToJNIHandlerMap = new HashMap();
  private PTSAppInstance mAppInstance;
  private int mAppInstanceUniqueID;
  
  static
  {
    sAppInstanceMap = new HashMap();
    init();
  }
  
  private PTSJNIHandler(PTSAppInstance paramPTSAppInstance, String paramString1, String paramString2, int paramInt)
  {
    this.mAppInstance = paramPTSAppInstance;
    this.mAppInstanceUniqueID = paramPTSAppInstance.getUniqueID();
    int i = this.mAppInstanceUniqueID;
    float f1 = this.mAppInstance.getRootViewWidth();
    float f2 = PTSDeviceUtil.getScreenScale();
    float f3 = PTSDeviceUtil.getRPXScaling();
    if (this.mAppInstance.getRootNodeType() == 1) {}
    for (;;)
    {
      createPTSPage(i, f1, f2, f3, bool, paramString1, paramString2, paramInt);
      return;
      bool = false;
    }
  }
  
  private native void callJSEventFunction(String paramString1, int paramInt1, String paramString2, String paramString3, String[] paramArrayOfString1, String[] paramArrayOfString2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt2, int paramInt3);
  
  private native void callJSFunction(String paramString, Object[] paramArrayOfObject, int paramInt1, int paramInt2);
  
  public static void create(PTSAppInstance paramPTSAppInstance, String paramString1, String paramString2, int paramInt)
  {
    if (((PTSJNIHandler)sAppToJNIHandlerMap.get(paramPTSAppInstance) == null) && (paramPTSAppInstance != null))
    {
      paramString1 = new PTSJNIHandler(paramPTSAppInstance, paramString1, paramString2, paramInt);
      sAppToJNIHandlerMap.put(paramPTSAppInstance, paramString1);
      sAppInstanceMap.put(Integer.valueOf(paramPTSAppInstance.getUniqueID()), paramPTSAppInstance);
    }
  }
  
  public static native void createJSEnvironment(int paramInt);
  
  private native void createPTSPage(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString1, String paramString2, int paramInt2);
  
  public static void destroy(PTSAppInstance paramPTSAppInstance, int paramInt)
  {
    if (paramPTSAppInstance != null)
    {
      PTSJNIHandler localPTSJNIHandler = (PTSJNIHandler)sAppToJNIHandlerMap.get(paramPTSAppInstance);
      if (localPTSJNIHandler != null)
      {
        localPTSJNIHandler.destroyPTSPage(localPTSJNIHandler.mAppInstanceUniqueID, paramInt);
        sAppToJNIHandlerMap.remove(paramPTSAppInstance);
        sAppInstanceMap.remove(Integer.valueOf(paramPTSAppInstance.getUniqueID()));
      }
    }
  }
  
  public static native void destroyJSEnvironment(int paramInt);
  
  private native void destroyPTSPage(int paramInt1, int paramInt2);
  
  public static native void evaluateJavaScript(int paramInt, String paramString);
  
  public static PTSJNIHandler get(PTSAppInstance paramPTSAppInstance)
  {
    return (PTSJNIHandler)sAppToJNIHandlerMap.get(paramPTSAppInstance);
  }
  
  private static PTSAppInstance getAppInstance(int paramInt)
  {
    return (PTSAppInstance)sAppInstanceMap.get(Integer.valueOf(paramInt));
  }
  
  private native String getJSGlobalValueForKey(String paramString, int paramInt1, int paramInt2);
  
  public static String getPageInfo(int paramInt, String paramString)
  {
    Object localObject = getAppInstance(paramInt);
    String str = "";
    if (localObject != null)
    {
      localObject = ((PTSAppInstance)localObject).getItemData();
      if (localObject != null) {
        str = ((PTSItemData)localObject).getJSONData();
      }
    }
    for (;;)
    {
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "";
      }
      PTSLog.i(TAG, "[getPageInfo], key = " + paramString + ", res = " + (String)localObject);
      return localObject;
      PTSLog.e(TAG, "[getPageInfo], data is null.");
      continue;
      PTSLog.e(TAG, "[getPageInfo], app not found.");
    }
  }
  
  public static float[] getTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    PTSAppInstance localPTSAppInstance = getAppInstance(paramInt);
    if (localPTSAppInstance != null) {
      return localPTSAppInstance.getTextMeasuredSize(paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4);
    }
    return new float[2];
  }
  
  private static native void init();
  
  private static native void jsFunctionCallback(long paramLong, Object[] paramArrayOfObject);
  
  public static void jsFunctionCallbackAsync(long paramLong, Object[] paramArrayOfObject)
  {
    PTSThreadUtil.runOnSubThread(new PTSJNIHandler.1(paramLong, paramArrayOfObject));
  }
  
  private static native void jsFunctionCallbackWithHttpResponse(long paramLong1, long paramLong2, byte[] paramArrayOfByte, long paramLong3);
  
  public static void jsFunctionCallbackWithHttpResponseAsync(long paramLong1, long paramLong2, byte[] paramArrayOfByte, long paramLong3)
  {
    PTSThreadUtil.runOnSubThread(new PTSJNIHandler.2(paramLong1, paramLong2, paramArrayOfByte, paramLong3));
  }
  
  public static void layoutRefreshCallback(List<PTSLayoutTempPatch> paramList, int paramInt)
  {
    PTSThreadUtil.runOnUIThread(new PTSJNIHandler.4(paramInt, paramList));
  }
  
  public static boolean refreshNodeList(List<PTSNodeInfo> paramList, int paramInt)
  {
    PTSThreadUtil.runOnUIThread(new PTSJNIHandler.3(paramInt, paramList));
    return true;
  }
  
  private native void setJSGlobalValueForKey(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public void callJSEventFunction(String paramString1, int paramInt1, String paramString2, String paramString3, String[] paramArrayOfString1, String[] paramArrayOfString2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt2)
  {
    callJSEventFunction(paramString1, paramInt1, paramString2, paramString3, paramArrayOfString1, paramArrayOfString2, paramArrayOfFloat1, paramArrayOfFloat2, this.mAppInstanceUniqueID, paramInt2);
  }
  
  public void callJSFunction(String paramString, Object[] paramArrayOfObject, int paramInt)
  {
    callJSFunction(paramString, paramArrayOfObject, this.mAppInstanceUniqueID, paramInt);
  }
  
  public String getJSGlobalValueForKey(String paramString, int paramInt)
  {
    return getJSGlobalValueForKey(paramString, this.mAppInstanceUniqueID, paramInt);
  }
  
  public void setJSGlobalValueForKey(String paramString1, String paramString2, int paramInt)
  {
    setJSGlobalValueForKey(paramString1, paramString2, this.mAppInstanceUniqueID, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.core.PTSJNIHandler
 * JD-Core Version:    0.7.0.1
 */