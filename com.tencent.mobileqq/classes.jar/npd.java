import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.callback.OnPlayModeShareListener;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class npd
  extends OnPlayModeShareListener
{
  npd(npc paramnpc, VideoPlayModeBase paramVideoPlayModeBase)
  {
    super(paramVideoPlayModeBase);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.a.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      StoryReportor.a("play_video", "guest_share_suc", i, paramInt, new String[] { "", String.valueOf(StoryReportor.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npd
 * JD-Core Version:    0.7.0.1
 */