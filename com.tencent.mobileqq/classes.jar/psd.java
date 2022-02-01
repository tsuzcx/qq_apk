import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJVideoViewInterceptor$innerPreloadAvatar$userInfo$1", "Lcom/tencent/biz/pubaccount/readinjoy/model/ReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "onLoadUserInfoFailed", "", "uin", "", "errMsg", "onLoadUserInfoSucceed", "userInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadInJoyUserInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class psd
  implements qhl
{
  psd(BaseArticleInfo paramBaseArticleInfo) {}
  
  public void onLoadUserInfoFailed(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    Intrinsics.checkParameterIsNotNull(paramString2, "errMsg");
    QLog.e("RIJVideoViewInterceptor", 2, "onLoadUserInfoFailed uin:" + paramString1 + " errMsg:" + paramString2);
  }
  
  public void onLoadUserInfoSucceed(@NotNull String paramString, @NotNull ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramReadInJoyUserInfo, "userInfo");
    psa.a(this.jdField_a_of_type_Psa, paramReadInJoyUserInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psd
 * JD-Core Version:    0.7.0.1
 */