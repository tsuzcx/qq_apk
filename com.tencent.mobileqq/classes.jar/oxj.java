import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;

class oxj
  implements oqy
{
  oxj(oxh paramoxh, ArticleInfo paramArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("OnSocialHeaderFollowClickListener", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
    if ((paramBoolean) && (paramInt == 2))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.h = paramInt;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.h = 2;
      ogy.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      ogy.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.a, paramInt);
      ohb.a().b();
      ohb.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, true);
      return;
    }
    bbmy.a(oxh.a(this.jdField_a_of_type_Oxh), ajjy.a(2131642057), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxj
 * JD-Core Version:    0.7.0.1
 */