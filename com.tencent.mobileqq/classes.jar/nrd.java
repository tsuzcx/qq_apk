import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.util.PlayModePollViewUtils;
import com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter.VideoViewHolder;

public final class nrd
  implements Runnable
{
  public nrd(VideoPlayModeBase paramVideoPlayModeBase, VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, StoryVideoItem paramStoryVideoItem) {}
  
  public void run()
  {
    PlayModePollViewUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase, this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerVideoPlayerPagerAdapter$VideoViewHolder, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nrd
 * JD-Core Version:    0.7.0.1
 */