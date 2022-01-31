package cooperation.qzone;

import android.os.Handler;
import android.os.Message;
import bgyo;

public class QZoneLiveVideoDownLoadActivtyV2$2$1
  implements Runnable
{
  public QZoneLiveVideoDownLoadActivtyV2$2$1(bgyo parambgyo, float paramFloat) {}
  
  public void run()
  {
    if ((int)(this.jdField_a_of_type_Float * 100.0F) > 0)
    {
      this.jdField_a_of_type_Bgyo.a.a.removeMessages(1009);
      this.jdField_a_of_type_Bgyo.a.a.obtainMessage(1004, 100, 0).sendToTarget();
      this.jdField_a_of_type_Bgyo.a.a(false, true);
    }
    while (!this.jdField_a_of_type_Bgyo.a.e) {
      return;
    }
    this.jdField_a_of_type_Bgyo.a.a.removeMessages(1009);
    this.jdField_a_of_type_Bgyo.a.a(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2.2.1
 * JD-Core Version:    0.7.0.1
 */