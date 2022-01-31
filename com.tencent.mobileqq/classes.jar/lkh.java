import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListAdapter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class lkh
  implements ActionSheet.OnButtonClickListener
{
  lkh(lkf paramlkf, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    label31:
    int i;
    label120:
    Object localObject2;
    label216:
    ArticleInfo localArticleInfo;
    label296:
    long l;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    case 0: 
      do
      {
        do
        {
          return;
          i = 4;
          paramInt = i;
          if (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter) != null)
          {
            if (((ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mFeedType != 1) || (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mSocialFeedInfo == null) || (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mSocialFeedInfo.jdField_a_of_type_Int != 5)) && (!ReadInJoyUtils.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter)))) {
              break;
            }
            paramInt = 2;
          }
          if (this.jdField_a_of_type_Lkf.jdField_a_of_type_Int <= 1) {
            break label550;
          }
        } while ((this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule == null) || (this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList().size() == 0));
        localObject1 = (CommentInfo)this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList().get(this.jdField_a_of_type_Lkf.jdField_a_of_type_Int - 2);
      } while (localObject1 == null);
      Object localObject3;
      boolean bool;
      if (TextUtils.isEmpty(((CommentInfo)localObject1).authorNickName))
      {
        paramView = "";
        paramView = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).getString(2131438899) + paramView;
        localObject2 = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
        localArticleInfo = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
        localObject3 = ((CommentInfo)localObject1).authorUin;
        if (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter)) {
          break label539;
        }
        bool = true;
        ReadInJoyCommentUtils.a((Activity)localObject2, localArticleInfo, (CommentInfo)localObject1, paramInt, paramView, null, true, (String)localObject3, bool);
        paramView = this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = ReadInJoyCommentUtils.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter));
        l = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mArticleID;
        i = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mStrategyId;
        localObject2 = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).innerUniqueID;
        localArticleInfo = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
        if (!ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter)) {
          break label545;
        }
      }
      label539:
      label545:
      for (paramInt = 2;; paramInt = 1)
      {
        PublicAccountReportUtils.a(paramView, (String)localObject1, "0X8009018", "0X8009018", 0, 0, String.valueOf(l), String.valueOf(i), (String)localObject2, ReadInJoyCommentUtils.a(localArticleInfo, paramInt, ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).commentId, 3, 0), false);
        break;
        paramInt = i;
        if (!ReadInJoyDeliverBiuActivity.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter))) {
          break label120;
        }
        paramInt = i;
        if (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) {
          break label120;
        }
        paramInt = i;
        if (!ReadInJoyDeliverBiuActivity.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
          break label120;
        }
        paramInt = 9;
        break label120;
        paramView = ((CommentInfo)localObject1).authorNickName;
        break label216;
        bool = false;
        break label296;
      }
      label550:
      if (TextUtils.isEmpty(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).authorNickName))
      {
        paramView = "";
        label572:
        localObject1 = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).getString(2131438899) + paramView;
        localObject2 = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
        localArticleInfo = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
        localObject3 = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
        if (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter) == null) {
          break label864;
        }
        paramView = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).authorUin;
        if (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter)) {
          break label869;
        }
        bool = true;
        label685:
        ReadInJoyCommentUtils.a((Activity)localObject2, localArticleInfo, (CommentInfo)localObject3, paramInt, (String)localObject1, null, false, paramView, bool);
        paramView = this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject1 = ReadInJoyCommentUtils.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter));
        l = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mArticleID;
        i = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mStrategyId;
        localObject2 = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).innerUniqueID;
        localArticleInfo = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
        if (!ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter)) {
          break label875;
        }
      }
      label669:
      label864:
      label869:
      label875:
      for (paramInt = 2;; paramInt = 1)
      {
        PublicAccountReportUtils.a(paramView, (String)localObject1, "0X8009018", "0X8009018", 0, 0, String.valueOf(l), String.valueOf(i), (String)localObject2, ReadInJoyCommentUtils.a(localArticleInfo, paramInt, ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).commentId, 3, 0), false);
        break;
        paramView = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).authorNickName;
        break label572;
        paramView = null;
        break label669;
        bool = false;
        break label685;
      }
    }
    Object localObject1 = null;
    label965:
    int j;
    int k;
    if (this.jdField_a_of_type_Lkf.jdField_a_of_type_Int > 1)
    {
      paramView = (View)localObject1;
      if (this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule != null)
      {
        paramView = (View)localObject1;
        if (this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList().size() > 0) {
          paramView = (CommentInfo)this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList().get(this.jdField_a_of_type_Lkf.jdField_a_of_type_Int - 2);
        }
      }
      if ((ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter) == null) || (paramView == null)) {
        break label1305;
      }
      j = 4;
      k = 19;
      if (((ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mFeedType != 1) || (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mSocialFeedInfo == null) || (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mSocialFeedInfo.jdField_a_of_type_Int != 5)) && (!ReadInJoyUtils.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter)))) {
        break label1307;
      }
      paramInt = 2;
      i = 20;
      label1063:
      localObject1 = paramView.commentContent;
      paramView = paramView.authorUin;
      paramView = ReadInJoyUtils.a(new Intent(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter), ReadInJoyDeliverBiuActivity.class), ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter), paramInt, (String)localObject1, Long.valueOf(paramView).longValue(), 0, i);
      ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).startActivity(paramView);
      ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).overridePendingTransition(0, 0);
      paramView = this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject1 = ReadInJoyCommentUtils.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter));
      l = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mArticleID;
      i = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mStrategyId;
      localObject2 = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).innerUniqueID;
      localArticleInfo = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
      if (!ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter)) {
        break label1394;
      }
    }
    label1305:
    label1307:
    label1394:
    for (paramInt = 2;; paramInt = 1)
    {
      PublicAccountReportUtils.a(paramView, (String)localObject1, "0X8009018", "0X8009018", 0, 0, String.valueOf(l), String.valueOf(i), (String)localObject2, ReadInJoyCommentUtils.a(localArticleInfo, paramInt, ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).commentId, 3, 1), false);
      break;
      paramView = ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter);
      break label965;
      break label31;
      paramInt = j;
      i = k;
      if (!ReadInJoyDeliverBiuActivity.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter))) {
        break label1063;
      }
      paramInt = j;
      i = k;
      if (ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) {
        break label1063;
      }
      paramInt = j;
      i = k;
      if (!ReadInJoyDeliverBiuActivity.a(ReadInJoySecondCommentListAdapter.a(this.jdField_a_of_type_Lkf.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListAdapter).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
        break label1063;
      }
      paramInt = 9;
      i = 20;
      break label1063;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lkh
 * JD-Core Version:    0.7.0.1
 */