package com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder;

import android.opengl.EGLContext;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.MediaMuxerWrapper;

public class EncodeConfig
{
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public MediaMuxerWrapper f;
  int g;
  int h;
  int i;
  boolean j;
  MuxerDataListener k;
  private EGLContext l;
  
  public EGLContext a()
  {
    return this.l;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EncodeConfig{sharedContext=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", outputFilePath='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", width='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", height='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bitRate='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", frameRate='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iFrameInterval='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.EncodeConfig
 * JD-Core Version:    0.7.0.1
 */