package com.tencent.mobileqq.qassistant.audio;

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
    if (this.jdField_a_of_type_ArrayOfByte == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_ArrayOfByte.length)
    {
      this.jdField_a_of_type_Int = i;
      this.c = paramInt;
      this.jdField_b_of_type_Int = 0;
      return;
    }
  }
  
  public VoiceBean(byte[] paramArrayOfByte, String paramString) {}
  
  public String a()
  {
    String str2 = this.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Boolean) {}
    for (String str1 = "1";; str1 = "0") {
      return String.format("VoiceBean[voiceId:%s, isMute:%s, position:%s, sequence:%s, arrLen:%s, len:%s, off:%s]", new Object[] { str2, str1, VoiceBeanCoordinator.a(this.jdField_b_of_type_Int), Integer.valueOf(this.c), Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(this.jdField_a_of_type_Long) });
    }
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    if (this.jdField_a_of_type_ArrayOfByte == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_ArrayOfByte.length)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_b_of_type_Long = paramLong2;
      return;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 3);
  }
  
  public boolean b()
  {
    return (c()) && (a());
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Int > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceBean
 * JD-Core Version:    0.7.0.1
 */