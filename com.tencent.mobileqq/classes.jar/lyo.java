import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class lyo
  implements Runnable
{
  lyo(lym paramlym) {}
  
  public void run()
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: error, show toast");
    QQToast.a(this.a.a, 2131438918, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lyo
 * JD-Core Version:    0.7.0.1
 */