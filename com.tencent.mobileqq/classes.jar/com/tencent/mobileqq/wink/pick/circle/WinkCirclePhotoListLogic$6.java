package com.tencent.mobileqq.wink.pick.circle;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;

class WinkCirclePhotoListLogic$6
  implements ThreadExcutor.IThreadListener
{
  WinkCirclePhotoListLogic$6(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic) {}
  
  public void onAdded()
  {
    AEQLog.a("WinkCirclePhotoListLogic", "onAdded--serialCompressVideos");
  }
  
  public void onPostRun()
  {
    AEQLog.a("WinkCirclePhotoListLogic", "onPostRun--serialCompressVideos");
  }
  
  public void onPreRun()
  {
    AEQLog.a("WinkCirclePhotoListLogic", "onPreRun--serialCompressVideos");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic.6
 * JD-Core Version:    0.7.0.1
 */