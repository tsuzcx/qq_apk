import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.qphone.base.util.QLog;

public class jyl
  implements Runnable
{
  public jyl(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "RemoveTipsRunnale Run");
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyl
 * JD-Core Version:    0.7.0.1
 */