import android.text.TextPaint;
import android.widget.Button;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class lvn
  implements UserOperationModule.Ox978RespCallBack
{
  public lvn(ComponentHeaderFriendRecommend paramComponentHeaderFriendRecommend, ArticleInfo paramArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("ComponentHeaderFriendRecommend", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    if ((paramBoolean) && (paramInt == 2))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.h = paramInt;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.setEnabled(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.getPaint().setFakeBoldText(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.setText("已关注");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.h = 2;
      ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      ReadInJoyLogicEngine.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.a, paramInt);
      ReadInJoyLogicEngineEventDispatcher.a().b();
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.setEnabled(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.a.setText("关注");
    QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend.getContext(), "关注失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lvn
 * JD-Core Version:    0.7.0.1
 */