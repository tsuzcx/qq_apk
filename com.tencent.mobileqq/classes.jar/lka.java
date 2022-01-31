import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.widget.ActionSheet;
import java.util.List;

public class lka
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public lka(ReadInJoySecondCommentListAdapter paramReadInJoySecondCommentListAdapter, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    int i = 2;
    if (this.jdField_a_of_type_Int == 0)
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str1 = ReadInJoyCommentUtils.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter));
      l = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mArticleID;
      j = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mStrategyId;
      str2 = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).innerUniqueID;
      localArticleInfo = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
      if (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter)) {
        PublicAccountReportUtils.a(paramView, str1, "0X8009017", "0X8009017", 0, 0, String.valueOf(l), String.valueOf(j), str2, ReadInJoyCommentUtils.a(localArticleInfo, i, ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).commentId, 0, 4), false);
      }
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList().size() <= 0)) {
      for (;;)
      {
        paramView = ActionSheet.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter));
        paramView.a("回复", 0);
        paramView.a("Biu", 0);
        paramView.c(2131433015);
        paramView.a(new lkb(this, paramView));
        paramView.a(new lkc(this, paramView));
        if (!paramView.isShowing()) {
          paramView.show();
        }
        return;
        i = 1;
      }
    }
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str1 = ReadInJoyCommentUtils.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter));
    long l = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mArticleID;
    int j = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mStrategyId;
    String str2 = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).innerUniqueID;
    ArticleInfo localArticleInfo = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
    if (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter)) {}
    for (i = 2;; i = 1)
    {
      PublicAccountReportUtils.a(paramView, str1, "0X8009017", "0X8009017", 0, 0, String.valueOf(l), String.valueOf(j), str2, ReadInJoyCommentUtils.a(localArticleInfo, i, ((CommentInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList().get(this.jdField_a_of_type_Int - 2)).commentId, 1, 4), false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lka
 * JD-Core Version:    0.7.0.1
 */