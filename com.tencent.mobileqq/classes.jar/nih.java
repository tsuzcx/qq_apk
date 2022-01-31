import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.child.MsgTabPlayMode;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoDataProvider;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoDataProvider.MsgTabVideoDataEvent;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.mobileqq.widget.QQToast;

public class nih
  implements View.OnClickListener
{
  public nih(MsgTabPlayMode paramMsgTabPlayMode, MsgTabVideoDataProvider.MsgTabVideoDataEvent paramMsgTabVideoDataEvent, int paramInt, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.a(VideoPlayModeBase.a()))
    {
      QQToast.a(VideoPlayModeBase.a(), 1, 2131430281, 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildMsgTabPlayMode.a.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$MsgTabVideoDataEvent.a, this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilMsgTabVideoDataProvider$MsgTabVideoDataEvent.b, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nih
 * JD-Core Version:    0.7.0.1
 */