import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.utils.QQLSSensor;
import com.tencent.qphone.base.util.QLog;

public class tfx
  implements Runnable
{
  public tfx(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSSensor", 2, "====shutSensor===" + Thread.currentThread().getId());
    }
    if (this.a.a != null)
    {
      this.a.a.b();
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfx
 * JD-Core Version:    0.7.0.1
 */