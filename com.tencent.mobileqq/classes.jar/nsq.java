import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;

public class nsq
  implements Runnable
{
  public nsq(StoryPlayVideoActivity paramStoryPlayVideoActivity) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.a.a.setBackground(new ColorDrawable(0));
      return;
    }
    this.a.a.setBackgroundDrawable(new ColorDrawable(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsq
 * JD-Core Version:    0.7.0.1
 */