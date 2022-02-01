package dov.com.qq.im.capture.paster;

import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InfomationFacePackage.Item;

class QIMInformationPasterManager$3
  implements QIMInformationPasterManager.IInformationPasterResDownloaderCallback
{
  QIMInformationPasterManager$3(QIMInformationPasterManager paramQIMInformationPasterManager) {}
  
  public void a(float paramFloat, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, InfomationFacePackage.Item paramItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "preload:" + paramString + " item:" + paramItem.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.QIMInformationPasterManager.3
 * JD-Core Version:    0.7.0.1
 */