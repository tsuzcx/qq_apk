import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class oxh
  implements ViewBase.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  public final String a;
  
  public oxh(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "OnSocialHeaderFollowClickListener";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static long a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramArticleInfo.mSubscribeID);
      return l;
    }
    catch (NumberFormatException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
      return 0L;
    }
    catch (Exception paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return 0L;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    while (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    long l = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    ogy.a().a().a(localQQAppInterface.getAccount(), String.valueOf(l), true, new oxi(this), 1);
    c();
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArticleInfo != null)
    {
      bool1 = bool2;
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramArticleInfo.mSocialFeedInfo.h == 2) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b()
  {
    AppRuntime localAppRuntime = obz.a();
    ArticleInfo localArticleInfo;
    if (localAppRuntime != null)
    {
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (localArticleInfo != null)
      {
        if ((localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.h == 2)) {
          return;
        }
        if (!rvf.a(localArticleInfo.mChannelID)) {
          break label128;
        }
      }
    }
    label128:
    for (String str = "0X800941D";; str = "0X80080EC")
    {
      qoe.a(localArticleInfo, str, str, (int)localArticleInfo.mChannelID);
      ogy.b(localArticleInfo);
      if (localArticleInfo.mSocialFeedInfo != null)
      {
        long l = localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
        ogy.a().a().a(localAppRuntime.getAccount(), String.valueOf(l), true, new oxj(this, localArticleInfo));
      }
      c();
      return;
    }
  }
  
  private void c()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (localObject2 != null)
    {
      Object localObject3 = ((ArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new pqg();
      localReportInfo.mUin = obz.a();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = ((ArticleInfo)localObject2).mArticleID;
      localReportInfo.mChannelId = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mAlgorithmId = ((int)((ArticleInfo)localObject2).mAlgorithmID);
      localReportInfo.mStrategyId = ((ArticleInfo)localObject2).mStrategyId;
      localReportInfo.mServerContext = ((ArticleInfo)localObject2).mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (localObject3 != null)
      {
        ((pqg)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_Pqo != null) {
          ((pqg)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Pqo.jdField_a_of_type_Long;
        }
        ((pqg)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((pqg)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).d;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((pqg)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (pqo)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((pqg)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((pqo)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 14;
      localReportInfo.mFeedsReportData = ((pqg)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    ogy.a().a((List)localObject1);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      QLog.d("OnSocialHeaderFollowClickListener", 2, "OnSocialHeaderFollowClickListener: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle);
      if ((this.jdField_a_of_type_Int != 31) && (this.jdField_a_of_type_Int != 32) && (this.jdField_a_of_type_Int != 83) && (this.jdField_a_of_type_Int != 84) && (this.jdField_a_of_type_Int != 85) && (this.jdField_a_of_type_Int != 86) && (this.jdField_a_of_type_Int != 77) && (this.jdField_a_of_type_Int != 78) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isPGCShortContent()) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isAccountShown)) {
        break label144;
      }
      a();
    }
    for (;;)
    {
      npb.a(paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, true);
      return;
      label144:
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxh
 * JD-Core Version:    0.7.0.1
 */