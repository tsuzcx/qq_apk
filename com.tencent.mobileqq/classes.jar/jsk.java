import com.tencent.av.ui.AVActivity;
import com.tencent.qphone.base.util.QLog;

public class jsk
  implements Runnable
{
  public jsk(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.a.b, 4, "onWindowFocusChangedRunnable, nfonWindowFocus[" + this.a.j + "->true]");
    }
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jsk
 * JD-Core Version:    0.7.0.1
 */