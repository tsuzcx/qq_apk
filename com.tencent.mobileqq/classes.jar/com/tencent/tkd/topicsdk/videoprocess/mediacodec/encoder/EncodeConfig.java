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
    return "EncodeConfig{sharedContext=" + this.jdField_a_of_type_AndroidOpenglEGLContext + ", outputFilePath='" + this.jdField_a_of_type_JavaLangString + '\'' + ", width='" + this.jdField_a_of_type_Int + '\'' + ", height='" + this.b + '\'' + ", bitRate='" + this.e + '\'' + ", frameRate='" + this.f + '\'' + ", iFrameInterval='" + this.g + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.encoder.EncodeConfig
 * JD-Core Version:    0.7.0.1
 */