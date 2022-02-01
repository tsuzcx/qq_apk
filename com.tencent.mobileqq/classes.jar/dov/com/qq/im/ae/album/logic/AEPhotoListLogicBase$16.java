package dov.com.qq.im.ae.album.logic;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import dov.com.qq.im.ae.util.AEQLog;

class AEPhotoListLogicBase$16
  implements ThreadExcutor.IThreadListener
{
  AEPhotoListLogicBase$16(AEPhotoListLogicBase paramAEPhotoListLogicBase) {}
  
  public void onAdded()
  {
    AEQLog.a("AEPhotoListLogicBase", "onAdded--serialCompressVideos");
  }
  
  public void onPostRun()
  {
    AEQLog.a("AEPhotoListLogicBase", "onPostRun--serialCompressVideos");
  }
  
  public void onPreRun()
  {
    AEQLog.a("AEPhotoListLogicBase", "onPreRun--serialCompressVideos");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.16
 * JD-Core Version:    0.7.0.1
 */