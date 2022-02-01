package com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder;

import android.opengl.EGLContext;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.MediaMuxerWrapper;

public class EncodeConfig
{
  public int a;
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  MuxerDataListener jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecEncoderMuxerDataListener;
  public MediaMuxerWrapper a;
  public String a;
  boolean jdField_a_of_type_Boolean;
  public int b;
  public int c;
  public int d;
  int e;
  int f;
  int g;
  
  public EGLContext a()
  {
    return this.jdField_a_of_type_AndroidOpenglEGLContext;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EncodeConfig{sharedContext=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidOpenglEGLContext);
    localStringBuilder.append(", outputFilePath='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", width='");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('\'');
    localStringBuilder.append(", height='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bitRate='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", frameRate='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iFrameInterval='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.EncodeConfig
 * JD-Core Version:    0.7.0.1
 */