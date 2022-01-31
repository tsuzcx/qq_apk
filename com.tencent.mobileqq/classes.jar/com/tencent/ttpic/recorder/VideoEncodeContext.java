package com.tencent.ttpic.recorder;

import com.tencent.util.LogUtil;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoEncodeContext
{
  static final boolean LIST_CONFIGS = false;
  static final String TAG = VideoEncodeContext.class.getSimpleName();
  EGL10 mEGL;
  EGLConfig mEGLConfig;
  EGLConfig[] mEGLConfigs;
  EGLContext mEGLContext;
  EGLDisplay mEGLDisplay;
  EGLSurface mEGLSurface;
  
  public VideoEncodeContext()
  {
    int[] arrayOfInt = new int[2];
    this.mEGL = ((EGL10)EGLContext.getEGL());
    this.mEGLDisplay = this.mEGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    this.mEGL.eglInitialize(this.mEGLDisplay, arrayOfInt);
    this.mEGLConfig = chooseConfig();
    if (this.mEGLConfig != null)
    {
      this.mEGLContext = this.mEGL.eglCreateContext(this.mEGLDisplay, this.mEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
      this.mEGLSurface = this.mEGL.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[] { 12375, 100, 12374, 100, 12344 });
    }
  }
  
  private EGLConfig chooseConfig()
  {
    EGLConfig localEGLConfig = null;
    int[] arrayOfInt1 = new int[15];
    int[] tmp8_7 = arrayOfInt1;
    tmp8_7[0] = 12325;
    int[] tmp14_8 = tmp8_7;
    tmp14_8[1] = 0;
    int[] tmp18_14 = tmp14_8;
    tmp18_14[2] = 12326;
    int[] tmp24_18 = tmp18_14;
    tmp24_18[3] = 0;
    int[] tmp28_24 = tmp24_18;
    tmp28_24[4] = 12324;
    int[] tmp34_28 = tmp28_24;
    tmp34_28[5] = 8;
    int[] tmp39_34 = tmp34_28;
    tmp39_34[6] = 12323;
    int[] tmp46_39 = tmp39_34;
    tmp46_39[7] = 8;
    int[] tmp52_46 = tmp46_39;
    tmp52_46[8] = 12322;
    int[] tmp59_52 = tmp52_46;
    tmp59_52[9] = 8;
    int[] tmp65_59 = tmp59_52;
    tmp65_59[10] = 12321;
    int[] tmp72_65 = tmp65_59;
    tmp72_65[11] = 8;
    int[] tmp78_72 = tmp72_65;
    tmp78_72[12] = 12352;
    int[] tmp85_78 = tmp78_72;
    tmp85_78[13] = 4;
    int[] tmp90_85 = tmp85_78;
    tmp90_85[14] = 12344;
    tmp90_85;
    int[] arrayOfInt2 = new int[1];
    this.mEGL.eglChooseConfig(this.mEGLDisplay, arrayOfInt1, null, 0, arrayOfInt2);
    int i = arrayOfInt2[0];
    if (i > 0)
    {
      this.mEGLConfigs = new EGLConfig[i];
      this.mEGL.eglChooseConfig(this.mEGLDisplay, arrayOfInt1, this.mEGLConfigs, i, arrayOfInt2);
      localEGLConfig = this.mEGLConfigs[0];
    }
    return localEGLConfig;
  }
  
  private int getConfigAttrib(EGLConfig paramEGLConfig, int paramInt)
  {
    int i = 0;
    int[] arrayOfInt = new int[1];
    if (this.mEGL.eglGetConfigAttrib(this.mEGLDisplay, paramEGLConfig, paramInt, arrayOfInt)) {
      i = arrayOfInt[0];
    }
    return i;
  }
  
  private void listConfig()
  {
    LogUtil.i(TAG, "Config List {");
    EGLConfig[] arrayOfEGLConfig = this.mEGLConfigs;
    int j = arrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      EGLConfig localEGLConfig = arrayOfEGLConfig[i];
      int k = getConfigAttrib(localEGLConfig, 12325);
      int m = getConfigAttrib(localEGLConfig, 12326);
      int n = getConfigAttrib(localEGLConfig, 12324);
      int i1 = getConfigAttrib(localEGLConfig, 12323);
      int i2 = getConfigAttrib(localEGLConfig, 12322);
      int i3 = getConfigAttrib(localEGLConfig, 12321);
      LogUtil.i(TAG, "    <d,s,r,g,b,a> = <" + k + "," + m + "," + n + "," + i1 + "," + i2 + "," + i3 + ">");
      i += 1;
    }
    LogUtil.i(TAG, "}");
  }
  
  public void destroyEgl()
  {
    this.mEGL.eglMakeCurrent(this.mEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
    if (this.mEGLConfig != null)
    {
      this.mEGL.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
      this.mEGL.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
    }
    this.mEGL.eglTerminate(this.mEGLDisplay);
  }
  
  public boolean usecurruntContext()
  {
    if (this.mEGLConfig == null) {
      return false;
    }
    return this.mEGL.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.recorder.VideoEncodeContext
 * JD-Core Version:    0.7.0.1
 */