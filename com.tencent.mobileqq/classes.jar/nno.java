import android.widget.ImageView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.IPlayVideoStatusChangeListener;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView.OnInfoListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class nno
  implements IVideoView.OnInfoListener
{
  private final int jdField_a_of_type_Int;
  protected final ImageView a;
  protected final StoryVideoItem a;
  private IVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView;
  protected final QQStoryLoadingView a;
  
  public nno(VideoPlayModeBase paramVideoPlayModeBase, int paramInt, IVideoView paramIVideoView, ImageView paramImageView, QQStoryLoadingView paramQQStoryLoadingView)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView = paramIVideoView;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = paramQQStoryLoadingView;
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)paramVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(paramInt));
  }
  
  public boolean a(IVideoView paramIVideoView, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayModeBase", 2, "StoryVideoOnInfoListener onInfo time:" + System.currentTimeMillis() + ", what:" + paramInt + ",index:" + this.jdField_a_of_type_Int);
    }
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.player.StoryPlayVideoActivity", 2, "onInfo隐藏cover");
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.m(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        SLog.d("Q.qqstory.player.YPlayModeUtils", "[8] onInfo hide video cover");
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.getVisibility() == 0)
      {
        SLog.b("Q.qqstory.player.YPlayModeUtils", "MEDIA_INFO_VIDEO_RENDERING_START set progress bar GONE");
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.c();
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.k(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPlaying = 0;
      }
      return false;
      if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.b();
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(0);
        paramIVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase;
        paramIVideoView.jdField_g_of_type_Int += 1;
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_g_of_type_Long = System.currentTimeMillis();
      }
      else if (paramInt == 3)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.c();
        SLog.b("Q.qqstory.player.YPlayModeUtils", "MEDIA_INFO_BUFFERING_END set progress bar GONE");
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView.setVisibility(8);
        paramIVideoView = this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase;
        paramIVideoView.f += System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_g_of_type_Long;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nno
 * JD-Core Version:    0.7.0.1
 */