import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class pzu
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  pzu(ArticleInfo paramArticleInfo, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo != null)
    {
      ReportInfo localReportInfo = new ReportInfo();
      Object localObject = paramArticleInfo.mSocialFeedInfo;
      qxa localqxa = new qxa();
      localReportInfo.mUin = ozs.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
      localReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
      localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
      localReportInfo.mServerContext = paramArticleInfo.mServerContext;
      localReportInfo.mReadTimeLength = -1;
      localReportInfo.mOperation = paramInt;
      if (localObject != null)
      {
        localqxa.jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject).jdField_a_of_type_Qxt != null) {
          localqxa.jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Qxt.jdField_a_of_type_Long;
        }
        localqxa.jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject).jdField_b_of_type_Int;
        localqxa.jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject).d;
        paramArticleInfo = ((SocializeFeedsInfo)localObject).jdField_a_of_type_JavaUtilList;
        if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
        {
          localqxa.jdField_a_of_type_JavaUtilList = new ArrayList();
          paramArticleInfo = paramArticleInfo.iterator();
          while (paramArticleInfo.hasNext())
          {
            localObject = (qxt)paramArticleInfo.next();
            if (localObject != null) {
              localqxa.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((qxt)localObject).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mFeedsReportData = localqxa;
      paramArticleInfo = new ArrayList();
      paramArticleInfo.add(localReportInfo);
      pfa.a().a(paramArticleInfo);
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    label28:
    label40:
    int i;
    label59:
    int j;
    label73:
    long l;
    if (ubg.a(paramArticleInfo.mChannelID))
    {
      if (!sel.a(paramArticleInfo)) {
        break label290;
      }
      paramString1 = paramArticleInfo.mSubscribeID;
      if (localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList == null) {
        break label320;
      }
      i = localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.size();
      if (!TextUtils.isEmpty(localSocializeFeedsInfo.jdField_a_of_type_JavaLangString)) {
        break label325;
      }
      j = 0;
      int k = localSocializeFeedsInfo.jdField_b_of_type_Int;
      int m = localSocializeFeedsInfo.d;
      int n = localSocializeFeedsInfo.f;
      paramString1 = ozs.a((int)paramArticleInfo.mChannelID, paramArticleInfo.mAlgorithmID, ozs.a(paramArticleInfo), paramString1, paramArticleInfo.innerUniqueID, i + 1, j, k, m, n).a();
      l = paramArticleInfo.mArticleID;
      if ((!ozs.b(paramArticleInfo)) && (!ozs.c(paramArticleInfo)) && (!ozs.e(paramArticleInfo)) && (!ozs.f(paramArticleInfo))) {
        break label381;
      }
      l = paramArticleInfo.businessId;
    }
    label290:
    label320:
    label325:
    label381:
    for (;;)
    {
      if ((sel.i(paramArticleInfo)) || (sel.g(paramArticleInfo)) || (sel.j(paramArticleInfo)) || (sel.k(paramArticleInfo)))
      {
        if (!sel.o(paramArticleInfo)) {
          ocd.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long), paramString2, paramString2, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(l), "" + paramArticleInfo.mStrategyId, paramString1, false);
        }
        if ((ozs.k(paramArticleInfo)) || (ozs.l(paramArticleInfo))) {
          break;
        }
        sel.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
        return;
        paramString2 = paramString1;
        break label28;
        paramString1 = "" + localSocializeFeedsInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long;
        break label40;
        i = 0;
        break label59;
        j = 1;
        break label73;
      }
      ocd.a(null, paramArticleInfo.mSubscribeID, paramString2, paramString2, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(l), "" + paramArticleInfo.mStrategyId, paramString1, false);
      return;
    }
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    ozs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  private void c(ArticleInfo paramArticleInfo)
  {
    a(paramArticleInfo);
    a(paramArticleInfo, a());
  }
  
  protected abstract int a();
  
  protected abstract void a(ArticleInfo paramArticleInfo);
  
  protected abstract void a(ViewBase paramViewBase);
  
  public final void onClick(ViewBase paramViewBase)
  {
    b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    a(paramViewBase);
    c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    tpq.a(paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzu
 * JD-Core Version:    0.7.0.1
 */