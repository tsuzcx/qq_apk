package com.tencent.pts.core.jni;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSJNIHandler;
import com.tencent.pts.utils.PTSDeviceUtil;

public class PTSLiteJniHandler
{
  private static String TAG = "PTSLiteJniHandler";
  
  public static void create(PTSAppInstance paramPTSAppInstance, String paramString)
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
      createPTSLitePage(i, f1, f2, f3, bool, paramString);
      return;
      bool = false;
    }
  }
  
  private static native void createPTSLitePage(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, String paramString);
  
  public static void destroy(PTSAppInstance paramPTSAppInstance)
  {
    if (paramPTSAppInstance == null) {
      return;
    }
    PTSJNIHandler.removePTSAppInstance(paramPTSAppInstance);
    destroyPTSLitePage(paramPTSAppInstance.getUniqueID());
  }
  
  private static native void destroyPTSLitePage(int paramInt);
  
  public static void setData(PTSAppInstance paramPTSAppInstance, String paramString)
  {
    if (paramPTSAppInstance == null) {
      return;
    }
    setPTSLiteData(paramPTSAppInstance.getUniqueID(), paramString);
  }
  
  private static native void setPTSLiteData(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.core.jni.PTSLiteJniHandler
 * JD-Core Version:    0.7.0.1
 */