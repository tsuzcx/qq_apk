import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler;
import com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.troop.TroopStoryManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class npf
  implements DialogInterface.OnClickListener
{
  public npf(NewFriendsPlayMode paramNewFriendsPlayMode, StoryVideoItem paramStoryVideoItem) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.s();
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.a("");
    if (StoryVideoItem.isFakeVid(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      ((StoryVideoUploadManager)SuperManager.a(3)).c(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mGroupId);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mStoryType == 2)
    {
      ((TroopStoryManager)PlayModeUtils.a().getManager(207)).a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, 0, false, new npg(this));
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.a.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.g, this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.p, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
    new DeleteStoryVideoHandler().a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     npf
 * JD-Core Version:    0.7.0.1
 */