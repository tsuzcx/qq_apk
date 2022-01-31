import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.widget.ActionSheet;

class lkb
  implements View.OnClickListener
{
  lkb(lka paramlka, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Lka.a.a;
    String str1 = ReadInJoyCommentUtils.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lka.a));
    long l = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lka.a).mArticleID;
    int j = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lka.a).mStrategyId;
    String str2 = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lka.a).innerUniqueID;
    ArticleInfo localArticleInfo = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lka.a);
    if (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lka.a)) {}
    for (int i = 2;; i = 1)
    {
      PublicAccountReportUtils.a(paramView, str1, "0X8009018", "0X8009018", 0, 0, String.valueOf(l), String.valueOf(j), str2, ReadInJoyCommentUtils.a(localArticleInfo, i, ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lka.a).commentId, 3, 2), false);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkb
 * JD-Core Version:    0.7.0.1
 */