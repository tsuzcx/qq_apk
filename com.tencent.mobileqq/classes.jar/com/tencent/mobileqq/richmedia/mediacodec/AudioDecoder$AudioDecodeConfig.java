package com.tencent.mobileqq.richmedia.mediacodec;

import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;

public class AudioDecoder$AudioDecodeConfig
{
  public int a;
  public long a;
  public AudioEncoder.AudioData a;
  public String a;
  public boolean a;
  public long b;
  public boolean b;
  public long c = 0L;
  
  public AudioDecoder$AudioDecodeConfig()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void a(AudioDecodeConfig paramAudioDecodeConfig)
  {
    if (paramAudioDecodeConfig == null) {
      throw new NullPointerException();
    }
    this.jdField_a_of_type_JavaLangString = paramAudioDecodeConfig.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData = paramAudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData;
    this.jdField_a_of_type_Boolean = paramAudioDecodeConfig.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Int = paramAudioDecodeConfig.jdField_a_of_type_Int;
    this.jdField_b_of_type_Boolean = paramAudioDecodeConfig.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Long = paramAudioDecodeConfig.jdField_a_of_type_Long;
    this.jdField_b_of_type_Long = paramAudioDecodeConfig.jdField_b_of_type_Long;
    this.c = paramAudioDecodeConfig.c;
  }
  
  public String toString()
  {
    return "AudioDecodeConfig=[audioFilePath:" + this.jdField_a_of_type_JavaLangString + " repeat:" + this.jdField_a_of_type_Boolean + " speedType:" + this.jdField_a_of_type_Int + " mMuteAudio:" + this.jdField_b_of_type_Boolean + " startTimeMs:" + this.jdField_a_of_type_Long + " endTimeMs:" + this.jdField_b_of_type_Long + " videoDuration:" + this.c + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.AudioDecodeConfig
 * JD-Core Version:    0.7.0.1
 */