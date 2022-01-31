import android.widget.ImageView;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.view.SplitedProgressBar;

public class oud
  implements Runnable
{
  public oud(StoryVideoPlayer paramStoryVideoPlayer) {}
  
  public void run()
  {
    if (!this.a.d)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oud
 * JD-Core Version:    0.7.0.1
 */