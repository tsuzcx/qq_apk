import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import java.util.TimerTask;

public class ojy
  extends TimerTask
{
  private ojy(EditVideoMusic paramEditVideoMusic) {}
  
  public void run()
  {
    this.a.a.sendEmptyMessage(1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojy
 * JD-Core Version:    0.7.0.1
 */