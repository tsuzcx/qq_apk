import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.RetryableSynchronizer;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.widget.QQToast;

public class nin
  implements View.OnClickListener
{
  public nin(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.a(VideoPlayModeBase.a()))
    {
      QQToast.a(VideoPlayModeBase.a(), 1, 2131433213, 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    paramView = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(this.jdField_a_of_type_Int);
    if ((paramView instanceof DefaultPlayerVideoListSynchronizer.RetryableSynchronizer))
    {
      ((DefaultPlayerVideoListSynchronizer.RetryableSynchronizer)paramView).a(this.jdField_a_of_type_JavaLangString, new nio(this));
      return;
    }
    SLog.e("VideoPlayModeBase", "cannot found synchronizer , vid = %s , index = %d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) });
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.t();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nin
 * JD-Core Version:    0.7.0.1
 */