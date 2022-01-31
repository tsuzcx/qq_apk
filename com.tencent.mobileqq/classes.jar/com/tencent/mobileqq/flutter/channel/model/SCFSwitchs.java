package com.tencent.mobileqq.flutter.channel.model;

import aqap;
import java.util.Map;

public class SCFSwitchs
{
  public Boolean isQzoneNotify;
  public Boolean isSpecialCare;
  public Boolean isVoiceNewFlag;
  
  public static SCFSwitchs fromMap(Map paramMap)
  {
    return (SCFSwitchs)aqap.a(paramMap, SCFSwitchs.class);
  }
  
  public static Map toMap(SCFSwitchs paramSCFSwitchs)
  {
    return aqap.a(paramSCFSwitchs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.model.SCFSwitchs
 * JD-Core Version:    0.7.0.1
 */