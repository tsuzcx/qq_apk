import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.base.preload.PlayingListPreloader;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.IPlayVideoStatusChangeListener;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase.VideoOnErrorListener;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class nhr
  implements View.OnClickListener
{
  public nhr(VideoPlayModeBase.VideoOnErrorListener paramVideoOnErrorListener) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.a(VideoPlayModeBase.a()))
    {
      QQToast.a(VideoPlayModeBase.a(), 1, 2131430281, 0).a();
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
    if (VideoViewFactory.a(BaseApplicationImpl.getContext()).a())
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.e = 0L;
      this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.d();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b);
      this.a.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
      return;
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryBasePreloadPlayingListPreloader.a(this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhr
 * JD-Core Version:    0.7.0.1
 */