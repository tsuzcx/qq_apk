package com.tencent.mobileqq.videocodec.audio;

import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;

public class AudioDecodeConfig
{
  public int a;
  public long a;
  public AudioEncoder.AudioData a;
  public String a;
  public boolean a;
  public long b;
  public AudioEncoder.AudioData b;
  public String b;
  public boolean b;
  public long c = 0L;
  
  public AudioDecodeConfig()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void a(AudioDecodeConfig paramAudioDecodeConfig)
  {
    if (paramAudioDecodeConfig != null)
    {
      this.jdField_a_of_type_JavaLangString = paramAudioDecodeConfig.jdField_a_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramAudioDecodeConfig.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData = paramAudioDecodeConfig.jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData;
      this.jdField_a_of_type_Boolean = paramAudioDecodeConfig.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Int = paramAudioDecodeConfig.jdField_a_of_type_Int;
      this.jdField_b_of_type_Boolean = paramAudioDecodeConfig.jdField_b_of_type_Boolean;
      this.jdField_a_of_type_Long = paramAudioDecodeConfig.jdField_a_of_type_Long;
      this.jdField_b_of_type_Long = paramAudioDecodeConfig.jdField_b_of_type_Long;
      this.c = paramAudioDecodeConfig.c;
      return;
    }
    throw new NullPointerException();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioDecodeConfig=[audioFilePath:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" repeat:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" speedType:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" mMuteAudio:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" startTimeMs:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" endTimeMs:");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" videoDuration:");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.audio.AudioDecodeConfig
 * JD-Core Version:    0.7.0.1
 */