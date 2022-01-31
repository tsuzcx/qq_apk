import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.qphone.base.util.QLog;

public class jxe
  implements Runnable
{
  jxe(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.c, 2, "AutoCheckVideoRunnable");
    }
    if (this.a.a != null) {
      this.a.a.a().an = true;
    }
    this.a.Q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxe
 * JD-Core Version:    0.7.0.1
 */