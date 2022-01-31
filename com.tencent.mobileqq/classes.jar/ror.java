import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class ror
  implements Runnable
{
  public ror(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "mRunOnShow 800 hasDestory=" + this.a.I);
    }
    if (!this.a.I) {
      this.a.j(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ror
 * JD-Core Version:    0.7.0.1
 */