package com.tencent.pts.core.jni;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSJNIHandler;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.utils.PTSDeviceUtil;

public class PTSJsJniHandler
{
  private static String TAG = "PTSJsJniHandler";
  
  static
  {
    init();
  }
  
  public static void callJSEventFunction(PTSAppInstance paramPTSAppInstance, String paramString1, int paramInt1, String paramString2, String paramString3, String[] paramArrayOfString1, String[] paramArrayOfString2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt2)
  {
    if (paramPTSAppInstance == null) {
      return;
    }
    callJSEventFunction(paramString1, paramInt1, paramString2, paramString3, paramArrayOfString1, paramArrayOfString2, paramArrayOfFloat1, paramArrayOfFloat2, paramPTSAppInstance.getUniqueID(), paramInt2);
  }
  
  private static native void callJSEventFunction(String paramString1, int paramInt1, String paramString2, String paramString3, String[] paramArrayOfString1, String[] paramArrayOfString2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt2, int paramInt3);
  
  public static void callJSFunction(PTSAppInstance paramPTSAppInstance, String paramString, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramPTSAppInstance == null) {
      return;
    }
    callJSFunction(paramString, paramArrayOfObject, paramPTSAppInstance.getUniqueID(), paramInt);
  }
  
  private static native void callJSFunction(String paramString, Object[] paramArrayOfObject, int paramInt1, int paramInt2);
  
  public static void create(PTSAppInstance paramPTSAppInstance, String paramString1, String paramString2, int paramInt)
  {
    boolean bool = true;
    if (paramPTSAppInstance == null) {
      return;
    }
    PTSJNIHandler.addPTSAppInstance(paramPTSAppInstance);
    int i = paramPTSAppInstance.getUniqueID();
    float f1 = paramPTSAppInstance.getRootViewWidth();
    float f2 = PTSDeviceUtil.getScreenScale();
    float f3 = PTSDeviceUtil.getRPXScaling();
    if (paramPTSAppInstance.getRootNodeType() == 1) {}
    for (;;)
    {
      createPTSPage(i, f1, f2, f3, bool, paramString1, paramString2, paramInt);
      return;
      bool = false;
    }
  }
  
  public static native void createJSEnvironment(int paramInt);
  
  private static native void createPTSPage(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString1, String paramString2, int paramInt2);
  
  public static void destroy(PTSAppInstance paramPTSAppInstance, int paramInt)
  {
    if (paramPTSAppInstance == null) {
      return;
    }
    PTSJNIHandler.removePTSAppInstance(paramPTSAppInstance);
    destroyPTSPage(paramPTSAppInstance.getUniqueID(), paramInt);
  }
  
  public static native void destroyJSEnvironment(int paramInt);
  
  private static native void destroyPTSPage(int paramInt1, int paramInt2);
  
  public static native void evaluateJavaScript(int paramInt, String paramString);
  
  private static native void init();
  
  private static native void jsFunctionCallback(long paramLong, Object[] paramArrayOfObject);
  
  public static void jsFunctionCallbackAsync(long paramLong, Object[] paramArrayOfObject)
  {
    PTSThreadUtil.runOnSubThread(new PTSJsJniHandler.1(paramLong, paramArrayOfObject));
  }
  
  private static native void jsFunctionCallbackWithHttpResponse(long paramLong1, long paramLong2, byte[] paramArrayOfByte, long paramLong3);
  
  public static void jsFunctionCallbackWithHttpResponseAsync(long paramLong1, long paramLong2, byte[] paramArrayOfByte, long paramLong3)
  {
    PTSThreadUtil.runOnSubThread(new PTSJsJniHandler.2(paramLong1, paramLong2, paramArrayOfByte, paramLong3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.core.jni.PTSJsJniHandler
 * JD-Core Version:    0.7.0.1
 */