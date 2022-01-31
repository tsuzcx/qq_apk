package cooperation.qzone;

import android.os.Handler;
import android.os.Message;
import bjej;

public class QZoneLiveVideoDownLoadActivtyV2$2$1
  implements Runnable
{
  public QZoneLiveVideoDownLoadActivtyV2$2$1(bjej parambjej, float paramFloat) {}
  
  public void run()
  {
    if ((int)(this.jdField_a_of_type_Float * 100.0F) > 0)
    {
      this.jdField_a_of_type_Bjej.a.a.removeMessages(1009);
      this.jdField_a_of_type_Bjej.a.a.obtainMessage(1004, 100, 0).sendToTarget();
      this.jdField_a_of_type_Bjej.a.a(false, true);
    }
    while (!this.jdField_a_of_type_Bjej.a.e) {
      return;
    }
    this.jdField_a_of_type_Bjej.a.a.removeMessages(1009);
    this.jdField_a_of_type_Bjej.a.a(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2.2.1
 * JD-Core Version:    0.7.0.1
 */