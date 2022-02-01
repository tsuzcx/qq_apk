package dov.com.qq.im.ae.album.logic;

import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.mobileqq.widget.ProgressPieDrawable.OnProgressListener;
import com.tencent.qphone.base.util.QLog;

class AEPhotoListLogicAECircle$5
  implements ProgressPieDrawable.OnProgressListener
{
  AEPhotoListLogicAECircle$5(AEPhotoListLogicAECircle paramAEPhotoListLogicAECircle) {}
  
  public void onProgressChanged(ProgressPieDrawable paramProgressPieDrawable, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(ProgressPieDrawable paramProgressPieDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListLogicAECircle", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + paramProgressPieDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicAECircle.5
 * JD-Core Version:    0.7.0.1
 */