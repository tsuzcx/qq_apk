package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class CameraCaptureView$CaptureParam
{
  public static final String f;
  public static String k = "key_aio_fbo";
  public static String l = "key_riji_h_compress_fbo";
  public static String m = "key_riji_h_clip_fbo";
  public static String n = "key_riji_l_compress_fbo";
  public static String o = "key_riji_l_clip_fbo";
  public static String p = "key_ae_gif_fbo";
  public int a;
  public int b;
  protected float c = 1.0F;
  protected int d = -1;
  protected int e = -1;
  public long g = System.currentTimeMillis();
  public String h;
  protected boolean i;
  protected boolean j;
  private int q = 960;
  private int r = 720;
  private int s = 960;
  private int t = 720;
  private int u;
  private int v;
  private int w = 1;
  private int x = 2000000;
  private int y = 1;
  private int z;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getFilesDir().getPath());
    localStringBuilder.append("/Android/data/com.tencent.mobileqq/qq/video/LightVideo/");
    f = localStringBuilder.toString();
  }
  
  public CameraCaptureView$CaptureParam()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getFilesDir().getPath());
    localStringBuilder.append("/Android/data/com.tencent.mobileqq/qq/video/Source/");
    localStringBuilder.append(this.g);
    this.h = localStringBuilder.toString();
    this.i = true;
    this.z = 1;
    this.j = true;
  }
  
  public void a(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void e(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void f(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void g(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void h(int paramInt)
  {
    this.x = paramInt;
  }
  
  public void i(int paramInt)
  {
    this.y = paramInt;
  }
  
  public void j(int paramInt)
  {
    this.d = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CaptureParam{wantedPreviewWidth=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", wantedPreviewHeight=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", defaultCamera=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", videoSizeRate=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", videoBitRate=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", videoIFrameInterval=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", captureDir='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", audioCaptureEnable=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", functionFlag=");
    localStringBuilder.append(this.z);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam
 * JD-Core Version:    0.7.0.1
 */