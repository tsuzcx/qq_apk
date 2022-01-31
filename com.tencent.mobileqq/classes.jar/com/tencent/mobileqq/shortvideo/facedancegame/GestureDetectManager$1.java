package com.tencent.mobileqq.shortvideo.facedancegame;

import com.tencent.av.avgesture.AVGestureWrapper.AVUploadReport;
import com.tencent.sveffects.Reporter;
import com.tencent.sveffects.SdkContext;

class GestureDetectManager$1
  implements AVGestureWrapper.AVUploadReport
{
  GestureDetectManager$1(GestureDetectManager paramGestureDetectManager) {}
  
  public void avGestureUploadReport(String paramString1, String paramString2)
  {
    SdkContext.getInstance().getReporter().reportToCompass("dc00898", "", paramString1, paramString1, 0, 0, "", "", paramString2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.facedancegame.GestureDetectManager.1
 * JD-Core Version:    0.7.0.1
 */