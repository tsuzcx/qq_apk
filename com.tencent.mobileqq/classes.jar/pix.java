import com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadExposeReport.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class pix
{
  public static void a(List<ArticleInfo> paramList, String paramString)
  {
    QLog.d("FeedsPreloadExposeReport", 1, "reportFeedsExposeRewrite.");
    Object localObject = (oxd)((QQAppInterface)ors.a()).getManager(163);
    if (localObject != null)
    {
      localObject = ((oxd)localObject).a();
      piu.a().a(new FeedsPreloadExposeReport.1((owy)localObject, paramList, paramString));
      return;
    }
    QLog.d("FeedsPreloadExposeReport", 1, "readInJoyLogicManager is null.");
  }
  
  public static void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    String str = ors.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt));
    localHashMap.put("uin", str);
    AppRuntime localAppRuntime = ors.a();
    if ((localAppRuntime == null) || (paramLong < 0L) || (paramLong > 30000L))
    {
      QLog.d("FeedsPreloadExposeReport", 1, "app is null or cost is not available, reportFeedsPreloadExposeMonitorData");
      return;
    }
    azri.a(localAppRuntime.getApplication()).a(str, "actFeedsPreloadExposeReport", paramBoolean, paramLong, 0L, localHashMap, null);
  }
  
  private static List<ReportInfo> b(List<ArticleInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = new ArrayList(paramList).iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (ArticleInfo)paramList.next();
        Object localObject2;
        if ((ors.t((BaseArticleInfo)localObject1)) && (((ArticleInfo)localObject1).mNewPolymericInfo != null) && (((ArticleInfo)localObject1).mNewPolymericInfo.a != null))
        {
          localObject1 = ((ArticleInfo)localObject1).mNewPolymericInfo.a.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (qlk)((Iterator)localObject1).next();
            ReportInfo localReportInfo = new ReportInfo();
            localReportInfo.mUin = ors.a();
            localReportInfo.mOperation = 56;
            localReportInfo.mSourceArticleId = ((qlk)localObject2).a;
            localReportInfo.mInnerId = ((qlk)localObject2).g;
            localReportInfo.mAlgorithmId = ((int)((qlk)localObject2).b);
            localReportInfo.mGWCommonData = "";
            localArrayList.add(localReportInfo);
          }
        }
        else
        {
          localObject2 = new ReportInfo();
          ((ReportInfo)localObject2).mUin = ors.a();
          ((ReportInfo)localObject2).mOperation = 56;
          ((ReportInfo)localObject2).mSourceArticleId = ((ArticleInfo)localObject1).mArticleID;
          ((ReportInfo)localObject2).mInnerId = ((ArticleInfo)localObject1).innerUniqueID;
          ((ReportInfo)localObject2).mAlgorithmId = ((int)((ArticleInfo)localObject1).mAlgorithmID);
          ((ReportInfo)localObject2).mGWCommonData = ((ArticleInfo)localObject1).mGWCommonData;
          localArrayList.add(localObject2);
          if (((ArticleInfo)localObject1).hasOnlyTwoVideoFeeds())
          {
            localObject1 = (ArticleInfo)((ArticleInfo)localObject1).mSubArtilceList.get(0);
            localObject2 = new ReportInfo();
            ((ReportInfo)localObject2).mUin = ors.a();
            ((ReportInfo)localObject2).mOperation = 56;
            ((ReportInfo)localObject2).mSourceArticleId = ((ArticleInfo)localObject1).mArticleID;
            ((ReportInfo)localObject2).mInnerId = ((ArticleInfo)localObject1).innerUniqueID;
            ((ReportInfo)localObject2).mAlgorithmId = ((int)((ArticleInfo)localObject1).mAlgorithmID);
            ((ReportInfo)localObject2).mGWCommonData = ((ArticleInfo)localObject1).mGWCommonData;
            localArrayList.add(localObject2);
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pix
 * JD-Core Version:    0.7.0.1
 */