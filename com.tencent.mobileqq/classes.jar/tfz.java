import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;

class tfz
  implements Runnable
{
  tfz(tfy paramtfy) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "do SmoothFinish at run");
    }
    QQLSActivity.g(this.a.a);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfz
 * JD-Core Version:    0.7.0.1
 */