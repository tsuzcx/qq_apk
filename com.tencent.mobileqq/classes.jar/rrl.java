import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;

public class rrl
  extends pms
{
  private final long jdField_a_of_type_Long;
  private final ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  public final String a;
  private final String b;
  
  public rrl(long paramLong, String paramString, ArticleInfo paramArticleInfo)
  {
    super(-12084769, 13421772, 860716207);
    this.jdField_a_of_type_JavaLangString = "UserSpan";
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.b = paramString;
  }
  
  private void a(long paramLong, Context paramContext)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null)) {}
    ArticleInfo localArticleInfo;
    String str;
    do
    {
      return;
      QLog.d("UserSpan", 1, new Object[] { "openPersonUrl, uin = ", Long.valueOf(paramLong) });
      onk.a(paramContext, omm.g + bbca.encodeToString(String.valueOf(paramLong).getBytes(), 2));
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      onk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
      str = onk.a(this.b, localArticleInfo, paramLong);
      if (shx.a(localArticleInfo.mChannelID)) {}
      for (paramContext = "0X800935C"; TextUtils.equals(this.b, "3"); paramContext = "0X8007BA3")
      {
        noo.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long), paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
        rap.a(localArticleInfo, (int)localArticleInfo.mChannelID);
        return;
      }
      if (TextUtils.equals(this.b, "5"))
      {
        if (pvb.a(localArticleInfo))
        {
          noo.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Long), paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
          rap.a(localArticleInfo, (int)localArticleInfo.mChannelID);
          return;
        }
        noo.a(null, localArticleInfo.mSubscribeID, paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "" + localArticleInfo.mStrategyId, str, false);
        return;
      }
    } while (!TextUtils.equals(this.b, "2"));
    noo.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long), paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
  }
  
  public void onClick(View paramView)
  {
    a(this.jdField_a_of_type_Long, paramView.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrl
 * JD-Core Version:    0.7.0.1
 */