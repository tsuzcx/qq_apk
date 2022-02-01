import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;

public class sws
  extends qdl
{
  private final long jdField_a_of_type_Long;
  private final ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private final String jdField_a_of_type_JavaLangString;
  
  public sws(long paramLong, String paramString, ArticleInfo paramArticleInfo)
  {
    super(-15504151, 13421772, 860716207);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public sws(long paramLong, String paramString, ArticleInfo paramArticleInfo, int paramInt)
  {
    super(paramInt, 13421772, 860716207);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
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
      ozs.a(paramContext, oyu.g + bhkv.encodeToString(String.valueOf(paramLong).getBytes(), 2));
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      ozs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
      str = ozs.a(this.jdField_a_of_type_JavaLangString, localArticleInfo, paramLong);
      if (ubg.a(localArticleInfo.mChannelID)) {}
      for (paramContext = "0X800935C"; TextUtils.equals(this.jdField_a_of_type_JavaLangString, "3"); paramContext = "0X8007BA3")
      {
        ocd.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long), paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
        sel.a(localArticleInfo, (int)localArticleInfo.mChannelID);
        return;
      }
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "5"))
      {
        if (qno.a(localArticleInfo))
        {
          ocd.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long), paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
          sel.a(localArticleInfo, (int)localArticleInfo.mChannelID);
          return;
        }
        ocd.a(null, localArticleInfo.mSubscribeID, paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), "" + localArticleInfo.mStrategyId, str, false);
        return;
      }
    } while (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, "2"));
    ocd.a(null, String.valueOf(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long), paramContext, paramContext, 0, 0, String.valueOf(localArticleInfo.mFeedId), "0", "" + localArticleInfo.mStrategyId, str, false);
  }
  
  public void onClick(View paramView)
  {
    a(this.jdField_a_of_type_Long, paramView.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sws
 * JD-Core Version:    0.7.0.1
 */