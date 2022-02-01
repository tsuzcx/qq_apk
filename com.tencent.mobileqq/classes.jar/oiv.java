import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.observer.BusinessObserver;

final class oiv
  implements BusinessObserver
{
  oiv(AdvertisementInfo paramAdvertisementInfo, ufw paramufw, int paramInt) {}
  
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
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
        paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle;
      }
      ukq.a("REPORT_LINK", "new report success : title = " + paramBundle + " type = " + this.jdField_a_of_type_Ufw.a());
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    ukq.a("REPORT_LINK", "new report fail : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo + " type = " + this.jdField_a_of_type_Ufw.a());
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oiv
 * JD-Core Version:    0.7.0.1
 */