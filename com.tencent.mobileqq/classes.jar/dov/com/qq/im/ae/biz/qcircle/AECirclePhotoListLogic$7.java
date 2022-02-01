package dov.com.qq.im.ae.biz.qcircle;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import dov.com.qq.im.ae.util.AEQLog;

class AECirclePhotoListLogic$7
  implements ThreadExcutor.IThreadListener
{
  AECirclePhotoListLogic$7(AECirclePhotoListLogic paramAECirclePhotoListLogic) {}
  
  public void onAdded()
  {
    AEQLog.a("AECirclePhotoListLogic", "onAdded--serialCompressVideos");
  }
  
  public void onPostRun()
  {
    AEQLog.a("AECirclePhotoListLogic", "onPostRun--serialCompressVideos");
  }
  
  public void onPreRun()
  {
    AEQLog.a("AECirclePhotoListLogic", "onPreRun--serialCompressVideos");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic.7
 * JD-Core Version:    0.7.0.1
 */