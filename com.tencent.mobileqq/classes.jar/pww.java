import android.text.TextPaint;
import android.widget.Button;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;

public class pww
  implements pbx
{
  public pww(ComponentHeaderFriendRecommend paramComponentHeaderFriendRecommend, ArticleInfo paramArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("ComponentHeaderFriendRecommend", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    if ((paramBoolean) && (paramInt == 2))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.h = paramInt;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.setEnabled(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.setText(ajya.a(2131702307));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.h = 2;
      osg.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      osg.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.a, paramInt);
      osj.a().b();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.setEnabled(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.setText(ajya.a(2131702308));
    bcql.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.getContext(), ajya.a(2131702349), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pww
 * JD-Core Version:    0.7.0.1
 */