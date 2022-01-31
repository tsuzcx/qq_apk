package com.tencent.mobileqq.voicechange;

public class VoiceChangeModeParams
{
  String jdField_a_of_type_JavaLangString = null;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = true;
  boolean c = true;
  boolean d = false;
  boolean e = true;
  
  public VoiceChangeModeParams(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
    this.e = paramBoolean5;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static VoiceChangeModeParams a()
  {
    return new VoiceChangeModeParams(true, false, true, true, true, null);
  }
  
  public static VoiceChangeModeParams a(String paramString)
  {
    return new VoiceChangeModeParams(false, true, true, false, true, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.VoiceChangeModeParams
 * JD-Core Version:    0.7.0.1
 */