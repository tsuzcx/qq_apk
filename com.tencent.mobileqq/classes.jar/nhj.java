import android.os.Handler;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;

public class nhj
  implements Runnable
{
  public nhj(VideoPlayModeBase paramVideoPlayModeBase, QQStoryLoadingView paramQQStoryLoadingView, QQStoryVideoPlayerErrorView paramQQStoryVideoPlayerErrorView, int paramInt, StoryVideoItem paramStoryVideoItem) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a.postDelayed(this, 50L);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhj
 * JD-Core Version:    0.7.0.1
 */