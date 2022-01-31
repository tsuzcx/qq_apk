import com.tencent.av.utils.TipsManager;
import com.tencent.qphone.base.util.QLog;

public class khc
  implements Runnable
{
  public khc(TipsManager paramTipsManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsManager", 2, "hideTipsRunnable, mPreviosState[" + this.a.b + "]");
    }
    this.a.a();
    if (this.a.b) {
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     khc
 * JD-Core Version:    0.7.0.1
 */