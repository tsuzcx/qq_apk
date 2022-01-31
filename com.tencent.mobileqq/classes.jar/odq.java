import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import java.util.TimerTask;

public class odq
  extends TimerTask
{
  private odq(EditVideoMusic paramEditVideoMusic) {}
  
  public void run()
  {
    this.a.a.sendEmptyMessage(1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odq
 * JD-Core Version:    0.7.0.1
 */