import com.tencent.biz.qqstory.playmode.child.FeedsPlayModeBase;
import com.tencent.biz.qqstory.playvideo.ProgressControler;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter;
import java.util.ArrayList;

public class nnu
  implements Runnable
{
  public nnu(FeedsPlayModeBase paramFeedsPlayModeBase, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase.e = false;
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase.g();
    }
    while ((this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter.a.size() <= 0) || (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.a() <= 1)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a.a() - 1);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.setCurrentItem(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildFeedsPlayModeBase.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnu
 * JD-Core Version:    0.7.0.1
 */