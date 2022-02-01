package com.tencent.mobileqq.videocodec.mediacodec.decoder;

import android.text.TextUtils;

public class DecodeConfig
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public boolean c = false;
  
  public DecodeConfig()
  {
    this(null, 0, true, false);
  }
  
  public DecodeConfig(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramString, paramInt, paramBoolean1, paramBoolean2, 0L, 0L);
  }
  
  public DecodeConfig(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public boolean a(DecodeConfig paramDecodeConfig)
  {
    if (paramDecodeConfig != null)
    {
      boolean bool1 = false;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramDecodeConfig.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = paramDecodeConfig.jdField_a_of_type_JavaLangString;
        bool1 = true;
      }
      int i = this.jdField_a_of_type_Int;
      int j = paramDecodeConfig.jdField_a_of_type_Int;
      if (i != j)
      {
        this.jdField_a_of_type_Int = j;
        bool1 = true;
      }
      boolean bool2 = this.jdField_a_of_type_Boolean;
      boolean bool3 = paramDecodeConfig.jdField_a_of_type_Boolean;
      if (bool2 != bool3)
      {
        this.jdField_a_of_type_Boolean = bool3;
        bool1 = true;
      }
      bool2 = this.jdField_b_of_type_Boolean;
      bool3 = paramDecodeConfig.jdField_b_of_type_Boolean;
      if (bool2 != bool3)
      {
        this.jdField_b_of_type_Boolean = bool3;
        bool1 = true;
      }
      long l1 = this.jdField_a_of_type_Long;
      long l2 = paramDecodeConfig.jdField_a_of_type_Long;
      if (l1 != l2)
      {
        this.jdField_a_of_type_Long = l2;
        bool1 = true;
      }
      l1 = this.jdField_b_of_type_Long;
      l2 = paramDecodeConfig.jdField_b_of_type_Long;
      if (l1 != l2)
      {
        this.jdField_b_of_type_Long = l2;
        bool1 = true;
      }
      i = this.jdField_b_of_type_Int;
      j = paramDecodeConfig.jdField_b_of_type_Int;
      if (i != j)
      {
        this.jdField_b_of_type_Int = j;
        bool1 = true;
      }
      bool2 = this.c;
      bool3 = paramDecodeConfig.c;
      if (bool2 != bool3)
      {
        this.c = bool3;
        bool1 = true;
      }
      return bool1;
    }
    throw new NullPointerException();
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.decoder.DecodeConfig
 * JD-Core Version:    0.7.0.1
 */