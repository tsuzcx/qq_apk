import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.callback.OnPlayModeShareListener;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.child.NewDiscoverBannerPlayMode;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class nit
  extends OnPlayModeShareListener
{
  public nit(NewDiscoverBannerPlayMode paramNewDiscoverBannerPlayMode, VideoPlayModeBase paramVideoPlayModeBase, VideoListFeedItem paramVideoListFeedItem, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    super(paramVideoPlayModeBase);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    StoryReportor.a("host_share", "suc_share", 1, paramInt, new String[] { String.valueOf(StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    StoryReportor.a("host_share", "share_chanel", 1, paramInt, new String[] { String.valueOf(StoryReportor.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nit
 * JD-Core Version:    0.7.0.1
 */