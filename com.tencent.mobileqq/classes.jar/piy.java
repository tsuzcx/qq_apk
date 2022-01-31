import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;

class piy
  implements pbx
{
  piy(piw parampiw, ArticleInfo paramArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("OnSocialHeaderFollowClickListener", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
    if ((paramBoolean) && (paramInt == 2))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.h = paramInt;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.h = 2;
      osg.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      osg.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.a, paramInt);
      osj.a().b();
      osj.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, true);
      return;
    }
    bcql.a(piw.a(this.jdField_a_of_type_Piw), ajya.a(2131707853), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     piy
 * JD-Core Version:    0.7.0.1
 */