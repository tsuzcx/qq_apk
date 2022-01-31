import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.ArticleViewModel.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class rvn
  implements pbj
{
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private rvo<CharSequence> jdField_a_of_type_Rvo = new rvo("");
  private rvo<CharSequence> b = new rvo("");
  private rvo<CharSequence> c = new rvo("");
  
  private rvn(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_JavaLangCharSequence = pmr.a((ArticleInfo)paramBaseArticleInfo);
    this.c.a(rvq.a(paramBaseArticleInfo, this));
    this.jdField_a_of_type_Rvo.a(rvq.b(paramBaseArticleInfo, this));
    this.b.a(rvq.c(paramBaseArticleInfo, this));
  }
  
  public static rvn a(BaseArticleInfo paramBaseArticleInfo)
  {
    return new rvn(paramBaseArticleInfo);
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
  
  public rvo<CharSequence> a()
  {
    return this.jdField_a_of_type_Rvo;
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleViewModel", 2, "[onLoadUserInfoSucceed] uin=" + paramString + " userInfo: " + paramReadInJoyUserInfo);
    }
    this.c.a(rvq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.jdField_a_of_type_Rvo.a(rvq.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.b.a(rvq.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.e("ArticleViewModel", 1, "[onLoadUserInfoFailed] uin=" + paramString1 + ", msg=" + paramString2);
  }
  
  public rvo<CharSequence> b()
  {
    return this.b;
  }
  
  public rvo<CharSequence> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvn
 * JD-Core Version:    0.7.0.1
 */