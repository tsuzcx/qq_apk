import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.widget.ActionSheet;

class lmp
  implements View.OnClickListener
{
  lmp(lmo paramlmo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Lmo.a.a;
    String str1 = ReadInJoyCommentUtils.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lmo.a));
    long l = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lmo.a).mArticleID;
    int j = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lmo.a).mStrategyId;
    String str2 = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lmo.a).innerUniqueID;
    ArticleInfo localArticleInfo = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lmo.a);
    if (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lmo.a)) {}
    for (int i = 2;; i = 1)
    {
      PublicAccountReportUtils.a(paramView, str1, "0X8009018", "0X8009018", 0, 0, String.valueOf(l), String.valueOf(j), str2, ReadInJoyCommentUtils.a(localArticleInfo, i, ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lmo.a).commentId, 3, 2), false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmp
 * JD-Core Version:    0.7.0.1
 */