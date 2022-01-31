import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import java.util.Timer;
import java.util.TimerTask;

public class nse
  extends TimerTask
{
  public nse(ProgressControler paramProgressControler) {}
  
  public void run()
  {
    ProgressControler localProgressControler = this.a;
    localProgressControler.c += 50L;
    if (this.a.c >= this.a.b)
    {
      this.a.c = this.a.b;
      if (this.a.jdField_a_of_type_JavaUtilTimer != null) {
        this.a.jdField_a_of_type_JavaUtilTimer.cancel();
      }
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nse
 * JD-Core Version:    0.7.0.1
 */