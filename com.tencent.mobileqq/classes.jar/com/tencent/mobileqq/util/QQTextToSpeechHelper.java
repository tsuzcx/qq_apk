package com.tencent.mobileqq.util;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;

public class QQTextToSpeechHelper
{
  private static TextToSpeech a;
  
  public static void a()
  {
    TextToSpeech localTextToSpeech = a;
    if (localTextToSpeech != null)
    {
      localTextToSpeech.stop();
      a = null;
    }
  }
  
  public static void a(Context paramContext)
  {
    if (a == null) {
      a = new TextToSpeech(paramContext, null);
    }
  }
  
  public static void a(String paramString)
  {
    if ((a != null) && (!TextUtils.isEmpty(paramString))) {
      a.speak(paramString, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQTextToSpeechHelper
 * JD-Core Version:    0.7.0.1
 */