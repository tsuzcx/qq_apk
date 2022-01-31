import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.viewmodels.ArticleViewModel.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class rvk
  implements pbg
{
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private rvl<CharSequence> jdField_a_of_type_Rvl = new rvl("");
  private rvl<CharSequence> b = new rvl("");
  private rvl<CharSequence> c = new rvl("");
  
  private rvk(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_JavaLangCharSequence = pmo.a((ArticleInfo)paramBaseArticleInfo);
    this.c.a(rvn.a(paramBaseArticleInfo, this));
    this.jdField_a_of_type_Rvl.a(rvn.b(paramBaseArticleInfo, this));
    this.b.a(rvn.c(paramBaseArticleInfo, this));
  }
  
  public static rvk a(BaseArticleInfo paramBaseArticleInfo)
  {
    return new rvk(paramBaseArticleInfo);
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
  
  public rvl<CharSequence> a()
  {
    return this.jdField_a_of_type_Rvl;
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleViewModel", 2, "[onLoadUserInfoSucceed] uin=" + paramString + " userInfo: " + paramReadInJoyUserInfo);
    }
    this.c.a(rvn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.jdField_a_of_type_Rvl.a(rvn.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.b.a(rvn.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.e("ArticleViewModel", 1, "[onLoadUserInfoFailed] uin=" + paramString1 + ", msg=" + paramString2);
  }
  
  public rvl<CharSequence> b()
  {
    return this.b;
  }
  
  public rvl<CharSequence> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvk
 * JD-Core Version:    0.7.0.1
 */