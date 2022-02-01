import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

public class tbm
  implements pql
{
  public int a;
  public long a;
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  public String a;
  private tbn<CharSequence> jdField_a_of_type_Tbn = new tbn("");
  private tbn<CharSequence> b = new tbn("");
  private tbn<CharSequence> c = new tbn("");
  
  private tbm(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_JavaLangCharSequence = qdk.a((ArticleInfo)paramBaseArticleInfo);
    this.c.a(tbp.a(paramBaseArticleInfo, this));
    this.jdField_a_of_type_Tbn.a(tbp.b(paramBaseArticleInfo, this));
    this.b.a(tbp.c(paramBaseArticleInfo, this));
  }
  
  public static tbm a(BaseArticleInfo paramBaseArticleInfo)
  {
    return new tbm(paramBaseArticleInfo);
  }
  
  public BaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  }
  
  public tbn<CharSequence> a()
  {
    return this.jdField_a_of_type_Tbn;
  }
  
  public void a(int paramInt)
  {
    QLog.d("ArticleViewModel", 1, "setCustomLinkTextColorSummary | linkedTextColor " + paramInt);
    this.c.a(tbp.a(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.b.a(tbp.b(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public tbn<CharSequence> b()
  {
    return this.b;
  }
  
  public tbn<CharSequence> c()
  {
    return this.c;
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.e("ArticleViewModel", 1, "[onLoadUserInfoFailed] uin=" + paramString1 + ", msg=" + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleViewModel", 2, "[onLoadUserInfoSucceed] uin=" + paramString + " userInfo: " + paramReadInJoyUserInfo);
    }
    this.c.a(tbp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
    this.jdField_a_of_type_Tbn.a(tbp.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
    this.b.a(tbp.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbm
 * JD-Core Version:    0.7.0.1
 */