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
    if (paramDecodeConfig != null)
    {
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramDecodeConfig.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = paramDecodeConfig.jdField_a_of_type_JavaLangString;
      }
      int i = this.jdField_a_of_type_Int;
      int j = paramDecodeConfig.jdField_a_of_type_Int;
      if (i != j) {
        this.jdField_a_of_type_Int = j;
      }
      boolean bool1 = this.jdField_a_of_type_Boolean;
      boolean bool2 = paramDecodeConfig.jdField_a_of_type_Boolean;
      if (bool1 != bool2) {
        this.jdField_a_of_type_Boolean = bool2;
      }
      bool1 = this.jdField_b_of_type_Boolean;
      bool2 = paramDecodeConfig.jdField_b_of_type_Boolean;
      if (bool1 != bool2) {
        this.jdField_b_of_type_Boolean = bool2;
      }
      long l1 = this.jdField_a_of_type_Long;
      long l2 = paramDecodeConfig.jdField_a_of_type_Long;
      if (l1 != l2) {
        this.jdField_a_of_type_Long = l2;
      }
      l1 = this.jdField_b_of_type_Long;
      l2 = paramDecodeConfig.jdField_b_of_type_Long;
      if (l1 != l2) {
        this.jdField_b_of_type_Long = l2;
      }
      return;
    }
    throw new NullPointerException();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inputFilePath=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" speedType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" noSleep=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" repeat=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" startTimeMillSecond=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" endTimeMillSecond=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.DecodeConfig
 * JD-Core Version:    0.7.0.1
 */