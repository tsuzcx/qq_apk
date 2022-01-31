import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playmode.child.NewDiscoverBannerPlayMode;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.app.ThreadManager;

public class niq
  implements View.OnClickListener
{
  public niq(NewDiscoverBannerPlayMode paramNewDiscoverBannerPlayMode) {}
  
  public void onClick(View paramView)
  {
    ThreadManager.post(new nir(this), 8, null, true);
    this.a.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.a.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     niq
 * JD-Core Version:    0.7.0.1
 */