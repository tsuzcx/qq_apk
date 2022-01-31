import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.ArticleViewModel.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class slx
  implements pgr
{
  public int a;
  public long a;
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  public String a;
  private sly<CharSequence> jdField_a_of_type_Sly = new sly("");
  private sly<CharSequence> b = new sly("");
  private sly<CharSequence> c = new sly("");
  
  private slx(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_JavaLangCharSequence = psw.a((ArticleInfo)paramBaseArticleInfo);
    this.c.a(sma.a(paramBaseArticleInfo, this));
    this.jdField_a_of_type_Sly.a(sma.b(paramBaseArticleInfo, this));
    this.b.a(sma.c(paramBaseArticleInfo, this));
  }
  
  public static slx a(BaseArticleInfo paramBaseArticleInfo)
  {
    return new slx(paramBaseArticleInfo);
  }
  
  private void b()
  {
    ThreadManager.executeOnSubThread(new ArticleViewModel.1(this));
  }
  
  public BaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  }
  
  public CharSequence a()
  {
    b();
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public sly<CharSequence> a()
  {
    return this.jdField_a_of_type_Sly;
  }
  
  public void a()
  {
    this.c.a(sma.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.jdField_a_of_type_Sly.a(sma.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleViewModel", 2, "[onLoadUserInfoSucceed] uin=" + paramString + " userInfo: " + paramReadInJoyUserInfo);
    }
    this.c.a(sma.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.jdField_a_of_type_Sly.a(sma.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.b.a(sma.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.e("ArticleViewModel", 1, "[onLoadUserInfoFailed] uin=" + paramString1 + ", msg=" + paramString2);
  }
  
  public sly<CharSequence> b()
  {
    return this.b;
  }
  
  public sly<CharSequence> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     slx
 * JD-Core Version:    0.7.0.1
 */