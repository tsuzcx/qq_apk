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

public abstract class pjd
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  pjd(ArticleInfo paramArticleInfo, Context paramContext)
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
      qcc localqcc = new qcc();
      localReportInfo.mUin = onk.a();
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
        localqcc.jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject).jdField_a_of_type_Qcl != null) {
          localqcc.jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject).jdField_a_of_type_Qcl.jdField_a_of_type_Long;
        }
        localqcc.jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject).jdField_b_of_type_Int;
        localqcc.jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject).d;
        paramArticleInfo = ((SocializeFeedsInfo)localObject).jdField_a_of_type_JavaUtilList;
        if ((paramArticleInfo != null) && (!paramArticleInfo.isEmpty()))
        {
          localqcc.jdField_a_of_type_JavaUtilList = new ArrayList();
          paramArticleInfo = paramArticleInfo.iterator();
          while (paramArticleInfo.hasNext())
          {
            localObject = (qcl)paramArticleInfo.next();
            if (localObject != null) {
              localqcc.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((qcl)localObject).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mFeedsReportData = localqcc;
      paramArticleInfo = new ArrayList();
      paramArticleInfo.add(localReportInfo);
      osj.a().a(paramArticleInfo);
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
    if (shx.a(paramArticleInfo.mChannelID))
    {
      if (!rap.a(paramArticleInfo)) {
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
      paramString1 = onk.a((int)paramArticleInfo.mChannelID, paramArticleInfo.mAlgorithmID, onk.a(paramArticleInfo), paramString1, paramArticleInfo.innerUniqueID, i + 1, j, k, m, n).a();
      l = paramArticleInfo.mArticleID;
      if ((!onk.b(paramArticleInfo)) && (!onk.c(paramArticleInfo)) && (!onk.e(paramArticleInfo)) && (!onk.f(paramArticleInfo))) {
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
      if ((rap.i(paramArticleInfo)) || (rap.a(paramArticleInfo)) || (rap.j(paramArticleInfo)) || (rap.k(paramArticleInfo)))
      {
        if (!rap.o(paramArticleInfo)) {
          noo.a(null, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Long), paramString2, paramString2, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(l), "" + paramArticleInfo.mStrategyId, paramString1, false);
        }
        if ((onk.k(paramArticleInfo)) || (onk.l(paramArticleInfo))) {
          break;
        }
        rap.a(paramArticleInfo, (int)paramArticleInfo.mChannelID);
        return;
        paramString2 = paramString1;
        break label28;
        paramString1 = "" + localSocializeFeedsInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long;
        break label40;
        i = 0;
        break label59;
        j = 1;
        break label73;
      }
      noo.a(null, paramArticleInfo.mSubscribeID, paramString2, paramString2, 0, 0, String.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Long), String.valueOf(l), "" + paramArticleInfo.mStrategyId, paramString1, false);
      return;
    }
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    onk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
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
    oam.a(paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pjd
 * JD-Core Version:    0.7.0.1
 */