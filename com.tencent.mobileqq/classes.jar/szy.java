import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class szy
  implements tbf
{
  szy(szv paramszv, int paramInt, CommentEntry paramCommentEntry) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, ajyc.a(2131704393));
  }
  
  public void a(int paramInt, String paramString)
  {
    bcpw.a(BaseApplication.getContext(), 1, ajyc.a(2131704416) + paramInt, 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    this.jdField_a_of_type_Szv.e();
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, new Object[] { "ReqGetLikeList ErrorCode:", Integer.valueOf(paramInt), " | ErrorMsg: ", paramString });
    }
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    this.jdField_a_of_type_Szv.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Szv.e();
    this.jdField_a_of_type_Szv.jdField_a_of_type_Tbz.d(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    tar.a().a();
    this.jdField_a_of_type_Szv.a(false, null);
    bcpw.a(BaseApplication.getContext(), 2, ajyc.a(2131704417), 0).a();
    szv.a(this.jdField_a_of_type_Szv.jdField_a_of_type_Int, 2, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.feedId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     szy
 * JD-Core Version:    0.7.0.1
 */