import com.tencent.biz.qqstory.boundaries.StoryDepends.InviteCode;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.newshare.mode.BigVContentShareMode;
import com.tencent.biz.qqstory.newshare.mode.OpenStoryShareMode;
import com.tencent.biz.qqstory.newshare.mode.base.ShareModeBase;
import com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class npc
  implements Runnable
{
  public npc(NewFriendsPlayMode paramNewFriendsPlayMode, boolean paramBoolean, StoryVideoItem paramStoryVideoItem, String paramString, VideoListFeedItem paramVideoListFeedItem) {}
  
  public void run()
  {
    
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new BigVContentShareMode(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.a().a(2131433114).a(new npd(this, this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode)).a((ShareModeBase)localObject).a();
      if (!this.jdField_a_of_type_Boolean) {
        break label138;
      }
    }
    label138:
    for (int i = 1;; i = 2)
    {
      StoryReportor.a("play_video", "guest_share", i, 0, new String[] { "", String.valueOf(StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem)), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
      localObject = new OpenStoryShareMode(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, this.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npc
 * JD-Core Version:    0.7.0.1
 */