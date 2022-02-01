import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class owf
{
  private owh a = new owh();
  
  public static owf a()
  {
    return owi.a();
  }
  
  public static owh a(oxb paramoxb, boolean paramBoolean)
  {
    owh localowh = new owh();
    if (paramoxb == null) {
      return localowh;
    }
    QLog.d("RIJNewBiuCardTransformManager", 1, "convertRespToBiuInfo | respData : " + paramoxb.toString() + " ,isFromRecommentFeeds:" + paramBoolean);
    localowh.jdField_a_of_type_Boolean = paramBoolean;
    localowh.jdField_a_of_type_Long = paramoxb.a();
    localowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramoxb.a();
    localowh.jdField_a_of_type_JavaLangString = paramoxb.c();
    localowh.b = paramoxb.d();
    localowh.e = paramoxb.f();
    localowh.c = paramoxb.g();
    localowh.d = paramoxb.b();
    localowh.jdField_a_of_type_Int = paramoxb.e();
    return localowh;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return false;
    }
    int i = ppe.a(paramArticleInfo, 0);
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
    int i = paramArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Int;
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
    pvj.a().a(this.a);
    QLog.d("RIJNewBiuCardTransformManager", 1, " transformCard | mBiuInfo " + this.a);
  }
  
  public void a(owh paramowh)
  {
    if (paramowh != null)
    {
      this.a = paramowh;
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
    if (!pvj.a().a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {}
    for (;;)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | shouldRefresh: " + bool);
      return bool;
      bool = false;
    }
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = pnn.a();
    if (localQQAppInterface != null)
    {
      Object localObject = (pvp)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject != null)
      {
        localObject = ((pvp)localObject).a().a();
        if (localObject != null) {
          ((qgv)localObject).a(localQQAppInterface.getLongAccountUin(), new owg(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owf
 * JD-Core Version:    0.7.0.1
 */