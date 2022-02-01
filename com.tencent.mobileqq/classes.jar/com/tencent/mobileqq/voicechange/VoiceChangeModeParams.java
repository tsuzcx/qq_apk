package com.tencent.mobileqq.voicechange;

public class VoiceChangeModeParams
{
  boolean a = false;
  boolean b = true;
  boolean c = true;
  boolean d = false;
  boolean e = true;
  String f = null;
  
  public VoiceChangeModeParams(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
    this.e = paramBoolean5;
    this.f = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.VoiceChangeModeParams
 * JD-Core Version:    0.7.0.1
 */