package com.tencent.mobileqq.videocodec.mediacodec.encoder;

import android.opengl.EGLContext;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.MediaMuxerWrapper;
import com.tencent.mobileqq.videocodec.mediacodec.util.ThumbnailUtil.ThumbConfig;

public class EncodeConfig
{
  public EGLContext a;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f = 30;
  public int g = 8;
  public int h;
  public boolean i;
  public String j;
  public String k;
  public int l;
  public int m = 0;
  public boolean n = false;
  public String o;
  public int p = -1;
  public int q = -1;
  public boolean r;
  public MediaMuxerWrapper s;
  public MuxerDataListener t;
  public boolean u = true;
  public ThumbnailUtil.ThumbConfig v;
  
  public EncodeConfig(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, int paramInt7, String paramString2, String paramString3, String paramString4, boolean paramBoolean2)
  {
    this.b = paramString1;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.g = paramInt4;
    this.h = paramInt6;
    this.i = paramBoolean1;
    this.j = paramString2;
    this.k = paramString3;
    this.f = paramInt5;
    this.l = paramInt7;
    this.o = paramString4;
  }
  
  public EncodeConfig(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    this(paramString, paramInt1, paramInt2, paramInt3, paramInt4, 30, 0, paramBoolean, paramInt5, null, null, null, false);
  }
  
  public EGLContext a()
  {
    return this.a;
  }
  
  public void a(EGLContext paramEGLContext)
  {
    this.a = paramEGLContext;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EncodeConfig{sharedContext=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", outputFilePath='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", width='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", height='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bitRate='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", frameRate='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iFrameInterval='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", filterType=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", needGenerateThumb=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", watermarkPath='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mosaicPath='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", orientation=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", adjustRotation=");
    localStringBuilder.append(this.m);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig
 * JD-Core Version:    0.7.0.1
 */