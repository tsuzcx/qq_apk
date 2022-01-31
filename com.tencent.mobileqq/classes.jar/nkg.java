import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.callback.OnPlayModeShareListener;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.child.NewDiscoverBannerPlayMode;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class nkg
  extends OnPlayModeShareListener
{
  public nkg(NewDiscoverBannerPlayMode paramNewDiscoverBannerPlayMode, VideoPlayModeBase paramVideoPlayModeBase, boolean paramBoolean, VideoListFeedItem paramVideoListFeedItem, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    super(paramVideoPlayModeBase);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      StoryReportor.a("play_video", "guest_share_suc", i, paramInt, new String[] { "", String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nkg
 * JD-Core Version:    0.7.0.1
 */