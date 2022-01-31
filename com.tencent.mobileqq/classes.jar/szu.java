import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class szu
  implements tbc
{
  szu(szr paramszr, CommentEntry paramCommentEntry, tbw paramtbw, boolean paramBoolean1, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, boolean paramBoolean2) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      szs.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.jdField_a_of_type_Int, this.jdField_a_of_type_Szr, false, this.b);
      int i;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.isReply())
      {
        paramInt = 2;
        i = vei.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
        if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
          break label117;
        }
      }
      label117:
      for (paramBundle = "1";; paramBundle = "2")
      {
        vei.a("home_page", "comment_auto", i, paramInt, new String[] { paramBundle, vei.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
        return;
        paramInt = 1;
        break;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 2;
    this.jdField_a_of_type_Tbw.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, "ReqAddComment errorCode " + paramInt);
    }
    bcql.a(BaseApplication.getContext(), 1, ajya.a(2131704398), 0).a();
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 2;
    this.jdField_a_of_type_Tbw.c(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    if (paramInt == 10407) {
      vei.a("play_video", "exp_limit", 0, 0, new String[] { "", "", "", "" });
    }
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, "ReqAddComment fails: " + paramInt + "|" + paramString);
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = ajya.a(2131704433);
    }
    bcql.a(BaseApplication.getContext(), 1, str, 0).a();
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    paramMessageMicro = (qqstory_service.RspAddFeedComment)paramMessageMicro;
    if (this.jdField_a_of_type_Szr.a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry, paramMessageMicro)) {
      return;
    }
    this.jdField_a_of_type_Tbw.d(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId = paramMessageMicro.comment_id.get();
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    this.jdField_a_of_type_Tbw.b(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    tao.a().a();
    if ((this.jdField_a_of_type_Boolean) && (!paramBoolean))
    {
      tau.a().a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      return;
    }
    szs.a(this.jdField_a_of_type_Int, 1, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.feedId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId);
    boolean bool;
    int i;
    label93:
    label100:
    String str2;
    String str3;
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status == 0))
    {
      bool = true;
      this.jdField_a_of_type_Szr.a(bool, paramBundle, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.isReply()) {
        break label202;
      }
      i = 2;
      if (!paramBoolean) {
        break label207;
      }
      paramBundle = "comment_suc";
      str2 = vei.a("home_page-comment_suc-d1");
      str3 = tau.a().a;
      if (!this.b) {
        break label213;
      }
    }
    label202:
    label207:
    label213:
    for (int j = 12;; j = vei.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "0";
      }
      vei.a("home_page", paramBundle, j, i, new String[] { str1, vei.a(this.jdField_a_of_type_Int), str3, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      tau.a().a(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
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
 * Qualified Name:     szu
 * JD-Core Version:    0.7.0.1
 */