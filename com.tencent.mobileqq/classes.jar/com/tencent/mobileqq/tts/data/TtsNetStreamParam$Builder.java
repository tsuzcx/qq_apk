package com.tencent.mobileqq.tts.data;

public class TtsNetStreamParam$Builder
{
  private int jdField_a_of_type_Int;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private Long jdField_b_of_type_JavaLangLong;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(paramLong);
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public TtsNetStreamParam a()
  {
    TtsNetStreamParam localTtsNetStreamParam = new TtsNetStreamParam();
    localTtsNetStreamParam.appId = this.jdField_a_of_type_JavaLangString;
    localTtsNetStreamParam.uin = this.jdField_a_of_type_JavaLangLong;
    localTtsNetStreamParam.sendUin = this.jdField_b_of_type_JavaLangLong;
    localTtsNetStreamParam.text = this.jdField_b_of_type_JavaLangString;
    localTtsNetStreamParam.textMd5 = this.c;
    localTtsNetStreamParam.seq = Long.valueOf(TtsNetStreamParam.access$008());
    localTtsNetStreamParam.clientVersion = this.d;
    localTtsNetStreamParam.net = this.jdField_a_of_type_Int;
    localTtsNetStreamParam.businessID = this.jdField_b_of_type_Int;
    localTtsNetStreamParam.sKey = this.e;
    return localTtsNetStreamParam;
  }
  
  public Builder b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder b(long paramLong)
  {
    this.jdField_b_of_type_JavaLangLong = Long.valueOf(paramLong);
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public Builder e(String paramString)
  {
    this.e = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.data.TtsNetStreamParam.Builder
 * JD-Core Version:    0.7.0.1
 */