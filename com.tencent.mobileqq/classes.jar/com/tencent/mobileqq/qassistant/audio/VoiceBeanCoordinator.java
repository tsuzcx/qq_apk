package com.tencent.mobileqq.qassistant.audio;

public class VoiceBeanCoordinator
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return "Header";
    case 2: 
      return "Middle";
    case 3: 
      return "Tailor";
    }
    return "Invali";
  }
  
  public static void a(VoiceBean paramVoiceBean1, VoiceBean paramVoiceBean2)
  {
    if ((paramVoiceBean1.a) && (paramVoiceBean2.a))
    {
      if (paramVoiceBean1.b != 3) {
        paramVoiceBean1.b = 0;
      }
      paramVoiceBean2.b = 0;
    }
    if ((paramVoiceBean1.a) && (!paramVoiceBean2.a))
    {
      if (!paramVoiceBean1.c()) {
        break label153;
      }
      if (paramVoiceBean1.b != 3)
      {
        paramVoiceBean1.b = 1;
        paramVoiceBean2.b = 2;
      }
    }
    else
    {
      label71:
      if ((!paramVoiceBean1.a) && (paramVoiceBean2.a)) {
        if (paramVoiceBean1.b != 1) {
          break label166;
        }
      }
    }
    for (paramVoiceBean2.b = 2;; paramVoiceBean2.b = 3)
    {
      if ((!paramVoiceBean1.a) && (!paramVoiceBean2.a))
      {
        if (paramVoiceBean1.b != 1) {
          paramVoiceBean1.b = 2;
        }
        paramVoiceBean2.b = 2;
      }
      VoiceTimeTraceUtil.a().d(paramVoiceBean1);
      VoiceTimeTraceUtil.a().d(paramVoiceBean2);
      return;
      paramVoiceBean1.b = 2;
      break;
      label153:
      paramVoiceBean1.b = 0;
      paramVoiceBean2.b = 1;
      break label71;
      label166:
      paramVoiceBean1.b = 2;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.audio.VoiceBeanCoordinator
 * JD-Core Version:    0.7.0.1
 */