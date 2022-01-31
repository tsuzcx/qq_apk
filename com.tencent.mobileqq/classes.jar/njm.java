import android.os.Bundle;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupVideoDelete;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.playmode.child.NewFriendsPlayMode;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

class njm
  extends ProtoUtils.StoryProtocolObserver
{
  njm(njl paramnjl) {}
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.r();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.player.NewFriendsPlayMode", 2, "troop story delete result, code=" + paramInt);
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    label307:
    for (;;)
    {
      try
      {
        paramBundle = this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.g;
        if (paramBundle != null) {
          break label307;
        }
        Object localObject = this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.b);
        if (localObject == null) {
          break label307;
        }
        paramBundle = ((VideoListFeedItem)localObject).feedId;
        localObject = new qqstory_group.RspGroupVideoDelete();
        ((qqstory_group.RspGroupVideoDelete)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (qqstory_struct.ErrorInfo)((qqstory_group.RspGroupVideoDelete)localObject).result.get();
        this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.a.a(paramBundle, this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.p, this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
        localObject = new DeleteStoryVideoEvent(new ErrorMessage(), this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, false);
        ((DeleteStoryVideoEvent)localObject).jdField_b_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid;
        ((DeleteStoryVideoEvent)localObject).d = paramBundle;
        ((DeleteStoryVideoEvent)localObject).jdField_b_of_type_Boolean = false;
        ((DeleteStoryVideoEvent)localObject).c = this.a.jdField_a_of_type_ComTencentBizQqstoryPlaymodeChildNewFriendsPlayMode.a();
        ((DeleteStoryVideoEvent)localObject).a = this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoIndex;
        if (((DeleteStoryVideoEvent)localObject).a == 0L) {
          ((DeleteStoryVideoEvent)localObject).a = this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime;
        }
        Bosses.get().scheduleJobDelayed(new njn(this, (DeleteStoryVideoEvent)localObject), 400);
        return paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.player.NewFriendsPlayMode", 2, "parse RspGroupVideoDelete error", paramArrayOfByte);
        }
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njm
 * JD-Core Version:    0.7.0.1
 */