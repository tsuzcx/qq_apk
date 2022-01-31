import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;

public class jry
  implements Runnable
{
  public jry(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.c, 2, "2s has past, startTimer now!");
    }
    this.a.Z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jry
 * JD-Core Version:    0.7.0.1
 */