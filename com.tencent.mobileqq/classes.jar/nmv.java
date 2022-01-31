import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;

public class nmv
  implements AudioManager.OnAudioFocusChangeListener
{
  public nmv(StoryPlayVideoActivity paramStoryPlayVideoActivity) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    if (((paramInt == -1) || (paramInt == -2) || (paramInt == -3)) && (this.a.isResume())) {
      this.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmv
 * JD-Core Version:    0.7.0.1
 */