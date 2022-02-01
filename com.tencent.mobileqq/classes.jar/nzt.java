import android.os.Bundle;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.3;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;

public class nzt
  implements BusinessObserver
{
  public nzt(NativeAdUtils.3 param3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        return;
      }
      WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
      localWebSsoResponseBody.mergeFrom(paramBundle);
      if ((!localWebSsoResponseBody.ret.has()) || (localWebSsoResponseBody.ret.get() != 0)) {
        return;
      }
      paramBundle = "";
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        paramBundle = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle;
      }
      tpx.a("REPORT_LINK", "new report success : title = " + paramBundle + " type = " + this.a.jdField_a_of_type_Tlv.a());
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    tpx.a("REPORT_LINK", "new report fail : " + this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo + " type = " + this.a.jdField_a_of_type_Tlv.a());
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzt
 * JD-Core Version:    0.7.0.1
 */