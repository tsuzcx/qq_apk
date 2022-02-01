package com.tencent.mobileqq.emosm.control;

import android.text.TextUtils;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;

public class EmoCaptureAsyncStepFactory
{
  public static EmoAsyncStep a(EmoAutomator paramEmoAutomator, String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.trim();
    }
    if (!TextUtils.isEmpty(str))
    {
      int i = -1;
      if (str.startsWith("{"))
      {
        paramString = new EmoCaptureAsyncStepFactory.CaptureEmoLinearGroup();
        paramString.b = str;
      }
      else if (str.startsWith("["))
      {
        paramString = new EmoCaptureAsyncStepFactory.CaptureEmoParallGroup();
        paramString.b = str;
      }
      else
      {
        i = Integer.parseInt(str);
        if (i != 1000) {
          paramString = new EmoAsyncStep();
        } else {
          paramString = new CameraEmoAllSend();
        }
      }
      paramString.jdField_a_of_type_ComTencentMobileqqEmosmControlEmoAutomator = paramEmoAutomator;
      paramString.b = i;
      if (i >= 0)
      {
        paramString.jdField_a_of_type_JavaLangString = paramString.getClass().getSimpleName();
        return paramString;
      }
      paramString.jdField_a_of_type_JavaLangString = str;
      return paramString;
    }
    paramEmoAutomator = new StringBuilder();
    paramEmoAutomator.append("createStepGroup: ");
    paramEmoAutomator.append(str);
    throw new RuntimeException(paramEmoAutomator.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.control.EmoCaptureAsyncStepFactory
 * JD-Core Version:    0.7.0.1
 */