import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.IPlayVideoStatusChangeListener;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase.VideoOnCompletionListener;
import com.tencent.biz.qqstory.playmode.util.ViewPagerScroller;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class nnm
  implements Runnable
{
  public nnm(VideoPlayModeBase.VideoOnCompletionListener paramVideoOnCompletionListener) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_Int < 0) || (this.a.jdField_a_of_type_Int >= this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())) {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayModeBase", 2, "video onCompletion go next but found no data.");
      }
    }
    do
    {
      return;
      ((StoryVideoItem)this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.get(this.a.jdField_a_of_type_Int)).mIsPlaying = 0;
      int i = this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoProgressControler.a();
      int j = this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b);
      this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b = (this.a.jdField_a_of_type_Int + 1);
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.d == 3) && (j + 1 == i))
      {
        VideoPlayModeBase localVideoPlayModeBase = this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase;
        localVideoPlayModeBase.b -= i;
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.setCurrentItem(this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b, false);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.b(this.a.jdField_a_of_type_Int);
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b < this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size())
      {
        boolean bool = this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b);
        if (bool) {
          this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeUtilViewPagerScroller.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager);
        }
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.setCurrentItem(this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b, bool);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.b(this.a.jdField_a_of_type_Int);
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.d == 2)
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b = 0;
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.setCurrentItem(this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b, false);
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.b(this.a.jdField_a_of_type_Int);
        return;
      }
    } while (!this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a());
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b = (this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() - 1);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryPlaymodeIPlayVideoStatusChangeListener.h(this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnm
 * JD-Core Version:    0.7.0.1
 */