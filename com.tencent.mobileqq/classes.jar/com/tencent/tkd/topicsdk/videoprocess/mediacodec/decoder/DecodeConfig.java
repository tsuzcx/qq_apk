package com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder;

import android.text.TextUtils;
import org.jetbrains.annotations.NotNull;

public class DecodeConfig
{
  int jdField_a_of_type_Int;
  public long a;
  public String a;
  boolean jdField_a_of_type_Boolean;
  public long b;
  boolean b;
  
  public DecodeConfig(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  void a(DecodeConfig paramDecodeConfig)
  {
    if (paramDecodeConfig == null) {
      throw new NullPointerException();
    }
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramDecodeConfig.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramDecodeConfig.jdField_a_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Int != paramDecodeConfig.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = paramDecodeConfig.jdField_a_of_type_Int;
    }
    if (this.jdField_a_of_type_Boolean != paramDecodeConfig.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = paramDecodeConfig.jdField_a_of_type_Boolean;
    }
    if (this.jdField_b_of_type_Boolean != paramDecodeConfig.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = paramDecodeConfig.jdField_b_of_type_Boolean;
    }
    if (this.jdField_a_of_type_Long != paramDecodeConfig.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = paramDecodeConfig.jdField_a_of_type_Long;
    }
    if (this.jdField_b_of_type_Long != paramDecodeConfig.jdField_b_of_type_Long) {
      this.jdField_b_of_type_Long = paramDecodeConfig.jdField_b_of_type_Long;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "inputFilePath=" + this.jdField_a_of_type_JavaLangString + " speedType=" + this.jdField_a_of_type_Int + " noSleep=" + this.jdField_a_of_type_Boolean + " repeat=" + this.jdField_b_of_type_Boolean + " startTimeMillSecond=" + this.jdField_a_of_type_Long + " endTimeMillSecond=" + this.jdField_b_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.DecodeConfig
 * JD-Core Version:    0.7.0.1
 */