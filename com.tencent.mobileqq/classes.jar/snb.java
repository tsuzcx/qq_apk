import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class snb
  implements soj
{
  snb(smy paramsmy, CommentEntry paramCommentEntry, spd paramspd, boolean paramBoolean1, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, boolean paramBoolean2) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      smz.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int, this.jdField_a_of_type_Smy, false, this.b);
      int i;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.isReply())
      {
        paramInt = 2;
        i = urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
        if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
          break label117;
        }
      }
      label117:
      for (paramBundle = "1";; paramBundle = "2")
      {
        urp.a("home_page", "comment_auto", i, paramInt, new String[] { paramBundle, urp.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
        return;
        paramInt = 1;
        break;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 2;
    this.jdField_a_of_type_Spd.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, "ReqAddComment errorCode " + paramInt);
    }
    bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131638602), 0).a();
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 2;
    this.jdField_a_of_type_Spd.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    if (paramInt == 10407) {
      urp.a("play_video", "exp_limit", 0, 0, new String[] { "", "", "", "" });
    }
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, "ReqAddComment fails: " + paramInt + "|" + paramString);
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = ajjy.a(2131638637);
    }
    bbmy.a(BaseApplication.getContext(), 1, str, 0).a();
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    paramMessageMicro = (qqstory_service.RspAddFeedComment)paramMessageMicro;
    if (this.jdField_a_of_type_Smy.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, paramMessageMicro)) {
      return;
    }
    this.jdField_a_of_type_Spd.d(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId = paramMessageMicro.comment_id.get();
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    this.jdField_a_of_type_Spd.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    snv.a().a();
    if ((this.jdField_a_of_type_Boolean) && (!paramBoolean))
    {
      sob.a().a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      return;
    }
    smz.a(this.jdField_a_of_type_Int, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.feedId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId);
    boolean bool;
    int i;
    label93:
    label100:
    String str2;
    String str3;
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status == 0))
    {
      bool = true;
      this.jdField_a_of_type_Smy.a(bool, paramBundle, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.isReply()) {
        break label202;
      }
      i = 2;
      if (!paramBoolean) {
        break label207;
      }
      paramBundle = "comment_suc";
      str2 = urp.a("home_page-comment_suc-d1");
      str3 = sob.a().a;
      if (!this.b) {
        break label213;
      }
    }
    label202:
    label207:
    label213:
    for (int j = 12;; j = urp.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "0";
      }
      urp.a("home_page", paramBundle, j, i, new String[] { str1, urp.a(this.jdField_a_of_type_Int), str3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      sob.a().a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      return;
      bool = false;
      break;
      i = 1;
      break label93;
      paramBundle = "comment_fail";
      break label100;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     snb
 * JD-Core Version:    0.7.0.1
 */