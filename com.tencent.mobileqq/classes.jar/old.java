import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import java.util.List;

public class old
  implements ood
{
  boolean jdField_a_of_type_Boolean = false;
  
  public old(ReadInJoyCommentListFragment paramReadInJoyCommentListFragment) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<omt> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    QLog.d("ReadInJoyCommentListFragment", 1, "onCommentListLoad anchor");
    if (!paramBoolean1) {}
    do
    {
      return;
      paramList = ReadInJoyCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment).a().a();
    } while (paramList == null);
    if (!TextUtils.isEmpty(paramList.b))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.f();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(true, paramList.a, paramList.b);
    }
    for (;;)
    {
      paramList.a(false);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.f();
    }
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (paramInt == 1001) {
        ybk.a(1, 2131718787);
      }
    } while (paramInt != 1003);
    ybk.a(1, 2131718788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     old
 * JD-Core Version:    0.7.0.1
 */