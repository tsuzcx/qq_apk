import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.comment.FeedCommentEventHandler.PostCommentCallback;
import com.tencent.biz.qqstory.comment.FeedCommentLego;
import com.tencent.biz.qqstory.comment.StoryQQTextCacher;
import com.tencent.biz.qqstory.comment.lego.LegoResponseCallBack;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public final class nak
  implements LegoResponseCallBack
{
  public nak(FeedCommentEventHandler.PostCommentCallback paramPostCommentCallback, CommentEntry paramCommentEntry, CommentManager paramCommentManager, boolean paramBoolean, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      FeedCommentLego.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$PostCommentCallback, false);
      int i;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.isReply())
      {
        paramInt = 2;
        i = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
        if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
          break label113;
        }
      }
      label113:
      for (paramBundle = "1";; paramBundle = "2")
      {
        StoryReportor.a("home_page", "comment_auto", i, paramInt, new String[] { paramBundle, StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
        return;
        paramInt = 1;
        break;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 2;
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.d(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, "ReqAddComment errorCode " + paramInt);
    }
    QQToast.a(BaseApplication.getContext(), 1, "发表评论失败", 0).a();
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 2;
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.d(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    if (paramInt == 10407) {
      StoryReportor.a("play_video", "exp_limit", 0, 0, new String[] { "", "", "", "" });
    }
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, "ReqAddComment fails: " + paramInt + "|" + paramString);
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "发表评论失败";
    }
    QQToast.a(BaseApplication.getContext(), 1, str, 0).a();
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    paramMessageMicro = (qqstory_service.RspAddFeedComment)paramMessageMicro;
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$PostCommentCallback.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, paramMessageMicro)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.e(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId = paramMessageMicro.comment_id.get();
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    this.jdField_a_of_type_ComTencentBizQqstoryModelCommentManager.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_Boolean) && (!paramBoolean))
    {
      StoryQQTextCacher.a().a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      return;
    }
    FeedCommentLego.a(this.jdField_a_of_type_Int, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.feedId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId);
    boolean bool;
    int i;
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status == 0))
    {
      bool = true;
      this.jdField_a_of_type_ComTencentBizQqstoryCommentFeedCommentEventHandler$PostCommentCallback.a(bool, paramBundle, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.isReply()) {
        break label194;
      }
      i = 2;
      label87:
      if (!paramBoolean) {
        break label199;
      }
    }
    label194:
    label199:
    for (paramBundle = "comment_suc";; paramBundle = "comment_fail")
    {
      String str2 = StoryReportor.a("home_page-comment_suc-d1");
      String str3 = StoryQQTextCacher.a().a;
      int j = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "0";
      }
      StoryReportor.a("home_page", paramBundle, j, i, new String[] { str1, StoryReportor.a(this.jdField_a_of_type_Int), str3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      StoryQQTextCacher.a().a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      return;
      bool = false;
      break;
      i = 1;
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nak
 * JD-Core Version:    0.7.0.1
 */