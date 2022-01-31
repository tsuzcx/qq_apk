import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.widget.QQToast;

public class nha
  implements View.OnClickListener
{
  public nha(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.a(VideoPlayModeBase.a()))
    {
      QQToast.a(VideoPlayModeBase.a(), 1, 2131433196, 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nha
 * JD-Core Version:    0.7.0.1
 */