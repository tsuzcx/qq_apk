import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class szv
  implements tbc
{
  szv(szs paramszs, int paramInt, CommentEntry paramCommentEntry) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, ajya.a(2131704404));
  }
  
  public void a(int paramInt, String paramString)
  {
    bcql.a(BaseApplication.getContext(), 1, ajya.a(2131704427) + paramInt, 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    this.jdField_a_of_type_Szs.e();
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, new Object[] { "ReqGetLikeList ErrorCode:", Integer.valueOf(paramInt), " | ErrorMsg: ", paramString });
    }
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    this.jdField_a_of_type_Szs.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Szs.e();
    this.jdField_a_of_type_Szs.jdField_a_of_type_Tbw.d(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    tao.a().a();
    this.jdField_a_of_type_Szs.a(false, null);
    bcql.a(BaseApplication.getContext(), 2, ajya.a(2131704428), 0).a();
    szs.a(this.jdField_a_of_type_Szs.jdField_a_of_type_Int, 2, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.feedId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     szv
 * JD-Core Version:    0.7.0.1
 */