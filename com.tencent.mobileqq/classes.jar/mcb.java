import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class mcb
  implements Runnable
{
  mcb(mbz parammbz) {}
  
  public void run()
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: error, show toast");
    QQToast.a(this.a.a, 2131438942, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcb
 * JD-Core Version:    0.7.0.1
 */