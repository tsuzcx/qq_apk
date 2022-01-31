import android.app.Dialog;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.qphone.base.util.QLog;

class rvt
  implements Runnable
{
  rvt(rvs paramrvs) {}
  
  public void run()
  {
    try
    {
      this.a.a.b(this.a.a.b, this.a.a.a);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatHistory", 2, "onExportMessageRecord Exception", localException);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatHistory", 2, "onExportMessageRecord OOM", localOutOfMemoryError);
      }
      return;
    }
    finally
    {
      this.a.a.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rvt
 * JD-Core Version:    0.7.0.1
 */