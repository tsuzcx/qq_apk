package dov.com.qq.im.ae.play;

import com.tencent.qphone.base.util.QLog;

class AEPlayShowPart$1
  implements Runnable
{
  AEPlayShowPart$1(AEPlayShowPart paramAEPlayShowPart) {}
  
  public void run()
  {
    QLog.d("AEPlayShowPart", 4, "load data");
    AEPlayShowPart.access$000(this.this$0).refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPart.1
 * JD-Core Version:    0.7.0.1
 */