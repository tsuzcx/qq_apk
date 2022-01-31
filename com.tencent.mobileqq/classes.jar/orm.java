import android.widget.PopupWindow;
import com.tencent.qphone.base.util.QLog;

public final class orm
  implements Runnable
{
  public orm(PopupWindow paramPopupWindow) {}
  
  public void run()
  {
    try
    {
      if (this.a.isShowing()) {
        this.a.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("View", 2, QLog.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orm
 * JD-Core Version:    0.7.0.1
 */