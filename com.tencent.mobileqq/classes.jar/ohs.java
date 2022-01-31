import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ohs
{
  private ohu a = new ohu();
  
  public static ohs a()
  {
    return ohv.a();
  }
  
  public static ohu a(oio paramoio, boolean paramBoolean)
  {
    ohu localohu = new ohu();
    if (paramoio == null) {
      return localohu;
    }
    QLog.d("RIJNewBiuCardTransformManager", 1, "convertRespToBiuInfo " + paramoio.toString() + " ,isFromRecommentFeeds:" + paramBoolean);
    localohu.jdField_a_of_type_Boolean = paramBoolean;
    localohu.jdField_a_of_type_Long = paramoio.a();
    localohu.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramoio.a();
    localohu.jdField_a_of_type_JavaLangString = paramoio.b();
    localohu.b = paramoio.d();
    localohu.d = paramoio.e();
    localohu.c = paramoio.f();
    return localohu;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    int i = rqj.a(paramArticleInfo, 0);
    QLog.d("RIJNewBiuCardTransformManager", 2, "checkBiuCardWhiteList | type : " + i);
    if ((i == 0) || (i == 3) || (i == 1) || (i == 5) || (i == 6) || (i == 126) || (b(paramArticleInfo)))
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkBiuCardWhiteList | valid type : " + i);
      return true;
    }
    QLog.d("RIJNewBiuCardTransformManager", 2, "checkBiuCardWhiteList not in white list");
    return false;
  }
  
  public static boolean b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType articleInfo is null");
      return false;
    }
    if (!paramArticleInfo.isPGCShortContent())
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | is not pgcShortContent");
      return false;
    }
    if ((paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.a == null))
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | socialFeedsInfo is null");
      return true;
    }
    int i = paramArticleInfo.mSocialFeedInfo.a.a;
    if ((i == 1) || (i == 3) || (i == 4) || (i == 2) || (i == 5))
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | longContent out");
      return false;
    }
    QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | valid shortContent type");
    return true;
  }
  
  public void a()
  {
    if (this.a == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "transformCard | mBiuInfo is null");
      return;
    }
    owy.a().a(this.a);
    QLog.d("RIJNewBiuCardTransformManager", 1, " transformCard | mBiuInfo " + this.a);
  }
  
  public void a(ohu paramohu)
  {
    if (paramohu != null)
    {
      this.a = paramohu;
      QLog.d("RIJNewBiuCardTransformManager", 2, "updateBiuInfo | mBiuInfo  : " + this.a);
      b();
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (this.a == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | false, biuInfo is null");
      return false;
    }
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | false, articleInfo is null");
      return false;
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | should refresh when out from related articles");
      return true;
    }
    if (!owy.a().a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {}
    for (;;)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | shouldRefresh: " + bool);
      return bool;
      bool = false;
    }
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = ors.a();
    if (localQQAppInterface != null)
    {
      Object localObject = (oxd)localQQAppInterface.getManager(163);
      if (localObject != null)
      {
        localObject = ((oxd)localObject).a().a();
        if (localObject != null) {
          ((pgh)localObject).a(localQQAppInterface.getLongAccountUin(), new oht(this));
        }
      }
    }
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ohs
 * JD-Core Version:    0.7.0.1
 */