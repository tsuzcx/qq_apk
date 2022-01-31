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

public abstract class oxl
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  oxl(ArticleInfo paramArticleInfo, Context paramContext)
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
      pqg localpqg = new pqg();
      localReportInfo.mUin = obz.a();
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
        localpqg.jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject).jdField_a_of_type_Pqo != null) {
          localpqg.jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Pqo.jdField_a_of_type_Long;
        }
        localpqg.jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject).jdField_b_of_type_Int;
        localpqg.jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject).d;
        paramArticleInfo = ((SocializeFeedsInfo)localObject).jdField_a_of_type_JavaUtilList;
        if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
        {
          localpqg.jdField_a_of_type_JavaUtilList = new ArrayList();
          paramArticleInfo = paramArticleInfo.iterator();
          while (paramArticleInfo.hasNext())
          {
            localObject = (pqo)paramArticleInfo.next();
            if (localObject != null) {
              localpqg.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((pqo)localObject).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mFeedsReportData = localpqg;
      paramArticleInfo = new ArrayList();
      paramArticleInfo.add(localReportInfo);
      ogy.a().a(paramArticleInfo);
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
    if (rvf.a(paramArticleInfo.mChannelID))
    {
      if (!qoe.a(paramArticleInfo)) {
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
      paramString1 = obz.a((int)paramArticleInfo.mChannelID, paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), paramString1, paramArticleInfo.innerUniqueID, i + 1, j, k, m, n).a();
      l = paramArticleInfo.mArticleID;
      if ((!obz.b(paramArticleInfo)) && (!obz.c(paramArticleInfo)) && (!obz.e(paramArticleInfo)) && (!obz.f(paramArticleInfo))) {
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
      if ((qoe.i(paramArticleInfo)) || (qoe.a(paramArticleInfo)) || (qoe.j(paramArticleInfo)) || (qoe.k(paramArticleInfo)))
      {
        if (!qoe.o(paramArticleInfo)) {
          ndn.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long), paramString2, paramString2, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(l), "" + paramArticleInfo.mStrategyId, paramString1, false);
        }
        if ((obz.k(paramArticleInfo)) || (obz.l(paramArticleInfo))) {
          break;
        }
        qoe.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
        return;
        paramString2 = paramString1;
        break label28;
        paramString1 = "" + localSocializeFeedsInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
        break label40;
        i = 0;
        break label59;
        j = 1;
        break label73;
      }
      ndn.a(null, paramArticleInfo.mSubscribeID, paramString2, paramString2, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(l), "" + paramArticleInfo.mStrategyId, paramString1, false);
      return;
    }
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    obz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
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
    npb.a(paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxl
 * JD-Core Version:    0.7.0.1
 */