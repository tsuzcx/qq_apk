package com.tencent.view;

import com.tencent.ttpic.baseutils.log.LogUtils;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class FilterContext
{
  private static final boolean LIST_CONFIGS = false;
  private static final String TAG = "PixelBuffer";
  private EGL10 mEGL;
  private EGLConfig mEGLConfig;
  private EGLConfig[] mEGLConfigs;
  private EGLContext mEGLContext;
  private EGLDisplay mEGLDisplay;
  private EGLSurface mEGLSurface;
  
  public FilterContext()
  {
    Object localObject = new int[2];
    this.mEGL = ((EGL10)EGLContext.getEGL());
    this.mEGLDisplay = this.mEGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    this.mEGL.eglInitialize(this.mEGLDisplay, (int[])localObject);
    this.mEGLConfig = chooseConfig();
    localObject = this.mEGLConfig;
    if (localObject != null)
    {
      this.mEGLContext = this.mEGL.eglCreateContext(this.mEGLDisplay, (EGLConfig)localObject, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
      this.mEGLSurface = this.mEGL.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[] { 12375, 100, 12374, 100, 12344 });
    }
  }
  
  private EGLConfig chooseConfig()
  {
    int[] arrayOfInt1 = new int[15];
    int[] tmp6_5 = arrayOfInt1;
    tmp6_5[0] = 12325;
    int[] tmp12_6 = tmp6_5;
    tmp12_6[1] = 0;
    int[] tmp16_12 = tmp12_6;
    tmp16_12[2] = 12326;
    int[] tmp22_16 = tmp16_12;
    tmp22_16[3] = 0;
    int[] tmp26_22 = tmp22_16;
    tmp26_22[4] = 12324;
    int[] tmp32_26 = tmp26_22;
    tmp32_26[5] = 8;
    int[] tmp37_32 = tmp32_26;
    tmp37_32[6] = 12323;
    int[] tmp44_37 = tmp37_32;
    tmp44_37[7] = 8;
    int[] tmp50_44 = tmp44_37;
    tmp50_44[8] = 12322;
    int[] tmp57_50 = tmp50_44;
    tmp57_50[9] = 8;
    int[] tmp63_57 = tmp57_50;
    tmp63_57[10] = 12321;
    int[] tmp70_63 = tmp63_57;
    tmp70_63[11] = 8;
    int[] tmp76_70 = tmp70_63;
    tmp76_70[12] = 12352;
    int[] tmp83_76 = tmp76_70;
    tmp83_76[13] = 4;
    int[] tmp88_83 = tmp83_76;
    tmp88_83[14] = 12344;
    tmp88_83;
    int[] arrayOfInt2 = new int[1];
    this.mEGL.eglChooseConfig(this.mEGLDisplay, arrayOfInt1, null, 0, arrayOfInt2);
    int i = arrayOfInt2[0];
    if (i > 0)
    {
      this.mEGLConfigs = new EGLConfig[i];
      this.mEGL.eglChooseConfig(this.mEGLDisplay, arrayOfInt1, this.mEGLConfigs, i, arrayOfInt2);
      return this.mEGLConfigs[0];
    }
    return null;
  }
  
  private int getConfigAttrib(EGLConfig paramEGLConfig, int paramInt)
  {
    int[] arrayOfInt = new int[1];
    boolean bool = this.mEGL.eglGetConfigAttrib(this.mEGLDisplay, paramEGLConfig, paramInt, arrayOfInt);
    paramInt = 0;
    if (bool) {
      paramInt = arrayOfInt[0];
    }
    return paramInt;
  }
  
  private void listConfig()
  {
    LogUtils.i("PixelBuffer", "Config List {");
    EGLConfig[] arrayOfEGLConfig = this.mEGLConfigs;
    int j = arrayOfEGLConfig.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfEGLConfig[i];
      int k = getConfigAttrib((EGLConfig)localObject, 12325);
      int m = getConfigAttrib((EGLConfig)localObject, 12326);
      int n = getConfigAttrib((EGLConfig)localObject, 12324);
      int i1 = getConfigAttrib((EGLConfig)localObject, 12323);
      int i2 = getConfigAttrib((EGLConfig)localObject, 12322);
      int i3 = getConfigAttrib((EGLConfig)localObject, 12321);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("    <d,s,r,g,b,a> = <");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(i3);
      ((StringBuilder)localObject).append(">");
      LogUtils.i("PixelBuffer", ((StringBuilder)localObject).toString());
      i += 1;
    }
    LogUtils.i("PixelBuffer", "}");
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
    EGL10 localEGL10 = this.mEGL;
    EGLDisplay localEGLDisplay = this.mEGLDisplay;
    EGLSurface localEGLSurface = this.mEGLSurface;
    return localEGL10.eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, this.mEGLContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.view.FilterContext
 * JD-Core Version:    0.7.0.1
 */