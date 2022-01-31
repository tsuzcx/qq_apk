import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.qphone.base.util.QLog;

public class jsz
  implements Runnable
{
  public jsz(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    try
    {
      this.a.a.a(new Object[] { Integer.valueOf(102) });
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.a.c, 2, "mRootView.post(new Runnable()-->exception=" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jsz
 * JD-Core Version:    0.7.0.1
 */