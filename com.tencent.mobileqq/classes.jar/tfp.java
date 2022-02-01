import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;

public class tfp
  implements pwf
{
  public int a;
  public long a;
  private final BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  public String a;
  private tfq<CharSequence> jdField_a_of_type_Tfq = new tfq("");
  private tfq<CharSequence> b = new tfq("");
  private tfq<CharSequence> c = new tfq("");
  
  private tfp(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_JavaLangCharSequence = qji.a((ArticleInfo)paramBaseArticleInfo);
    this.c.a(tfs.a(paramBaseArticleInfo, this));
    this.jdField_a_of_type_Tfq.a(tfs.b(paramBaseArticleInfo, this));
    this.b.a(tfs.c(paramBaseArticleInfo, this));
  }
  
  public static tfp a(BaseArticleInfo paramBaseArticleInfo)
  {
    return new tfp(paramBaseArticleInfo);
  }
  
  public BaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  }
  
  public tfq<CharSequence> a()
  {
    return this.jdField_a_of_type_Tfq;
  }
  
  public void a()
  {
    this.c.a(tfs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.jdField_a_of_type_Tfq.a(tfs.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public void a(int paramInt)
  {
    QLog.d("ArticleViewModel", 1, "setCustomLinkTextColorSummary | linkedTextColor " + paramInt);
    this.c.a(tfs.a(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
    this.b.a(tfs.b(paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this));
  }
  
  public tfq<CharSequence> b()
  {
    return this.b;
  }
  
  public tfq<CharSequence> c()
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
    this.c.a(tfs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
    this.jdField_a_of_type_Tfq.a(tfs.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
    this.b.a(tfs.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tfp
 * JD-Core Version:    0.7.0.1
 */