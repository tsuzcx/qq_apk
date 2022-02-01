package com.tencent.mobileqq.qassistant.data;

public class VoiceBean
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public int c;
  
  public VoiceBean(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = -1;
    this.jdField_b_of_type_Int = 0;
  }
  
  private VoiceBean(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i;
    if (paramArrayOfByte == null) {
      i = 0;
    } else {
      i = paramArrayOfByte.length;
    }
    this.jdField_a_of_type_Int = i;
    this.c = paramInt;
    this.jdField_b_of_type_Int = 0;
  }
  
  public VoiceBean(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte, -1, bool);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "";
          }
          return "Tailor";
        }
        return "Middle";
      }
      return "Header";
    }
    return "Invali";
  }
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str1;
    if (this.jdField_a_of_type_Boolean) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    return String.format("VoiceBean[voiceId:%s, isMute:%s, position:%s, sequence:%s, arrLen:%s, len:%s, off:%s]", new Object[] { str2, str1, a(this.jdField_b_of_type_Int), Integer.valueOf(this.c), Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(this.jdField_a_of_type_Long) });
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i;
    if (paramArrayOfByte == null) {
      i = 0;
    } else {
      i = paramArrayOfByte.length;
    }
    this.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int == 1;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 3;
  }
  
  public boolean c()
  {
    int i = this.jdField_b_of_type_Int;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 1)
    {
      bool1 = bool2;
      if (i != 2)
      {
        if (i == 3) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean d()
  {
    return (e()) && (c());
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Int > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.data.VoiceBean
 * JD-Core Version:    0.7.0.1
 */