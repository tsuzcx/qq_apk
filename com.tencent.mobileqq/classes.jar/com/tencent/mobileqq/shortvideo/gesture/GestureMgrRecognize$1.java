package com.tencent.mobileqq.shortvideo.gesture;

import com.tencent.av.avgesture.AVGestureWrapper.AVUploadReport;
import com.tencent.sveffects.Reporter;
import com.tencent.sveffects.SdkContext;

final class GestureMgrRecognize$1
  implements AVGestureWrapper.AVUploadReport
{
  public void avGestureUploadReport(String paramString1, String paramString2)
  {
    SdkContext.getInstance().getReporter().reportToCompass("dc00898", "", paramString1, paramString1, 0, 0, "", "", paramString2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize.1
 * JD-Core Version:    0.7.0.1
 */