import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class snc
  implements soj
{
  snc(smz paramsmz, int paramInt, CommentEntry paramCommentEntry) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    a(-1, ajjy.a(2131638608));
  }
  
  public void a(int paramInt, String paramString)
  {
    bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131638631) + paramInt, 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    this.jdField_a_of_type_Smz.e();
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, new Object[] { "ReqGetLikeList ErrorCode:", Integer.valueOf(paramInt), " | ErrorMsg: ", paramString });
    }
  }
  
  public void a(MessageMicro paramMessageMicro)
  {
    this.jdField_a_of_type_Smz.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Smz.e();
    this.jdField_a_of_type_Smz.jdField_a_of_type_Spd.d(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    snv.a().a();
    this.jdField_a_of_type_Smz.a(false, null);
    bbmy.a(BaseApplication.getContext(), 2, ajjy.a(2131638632), 0).a();
    smz.a(this.jdField_a_of_type_Smz.jdField_a_of_type_Int, 2, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.feedId, this.jdField_a_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     snc
 * JD-Core Version:    0.7.0.1
 */