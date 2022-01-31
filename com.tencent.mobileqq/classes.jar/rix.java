import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.ArticleViewModel.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class rix
  implements oqi
{
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private riy<CharSequence> jdField_a_of_type_Riy = new riy("");
  private riy<CharSequence> b = new riy("");
  private riy<CharSequence> c = new riy("");
  
  private rix(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_JavaLangCharSequence = paz.a((ArticleInfo)paramBaseArticleInfo);
    this.c.a(rja.a(paramBaseArticleInfo, this));
    this.jdField_a_of_type_Riy.a(rja.b(paramBaseArticleInfo, this));
    this.b.a(rja.c(paramBaseArticleInfo, this));
  }
  
  public static rix a(BaseArticleInfo paramBaseArticleInfo)
  {
    return new rix(paramBaseArticleInfo);
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new ArticleViewModel.1(this));
  }
  
  public BaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  }
  
  public CharSequence a()
  {
    a();
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public riy<CharSequence> a()
  {
    return this.jdField_a_of_type_Riy;
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleViewModel", 2, "[onLoadUserInfoSucceed] uin=" + paramString + " userInfo: " + paramReadInJoyUserInfo);
    }
    this.c.a(rja.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.jdField_a_of_type_Riy.a(rja.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.b.a(rja.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.e("ArticleViewModel", 1, "[onLoadUserInfoFailed] uin=" + paramString1 + ", msg=" + paramString2);
  }
  
  public riy<CharSequence> b()
  {
    return this.b;
  }
  
  public riy<CharSequence> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rix
 * JD-Core Version:    0.7.0.1
 */