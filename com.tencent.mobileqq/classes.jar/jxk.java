import com.tencent.av.VideoController;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class jxk
  implements Runnable
{
  public jxk(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.f();
      this.a.S();
      if (this.a.d == 2) {
        ReportController.b(null, "CliOper", "", "", "0X8004425", "0X8004425", 0, 0, "", "", "", "");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(this.a.c, 2, "RequestVideoTimeOutRunnable, mVideoController = null!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jxk
 * JD-Core Version:    0.7.0.1
 */