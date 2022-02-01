import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;

public class nwg
  implements bhpd
{
  public nwg(CustomWebView paramCustomWebView, nwh paramnwh) {}
  
  public void onSetCookiesFinished(String paramString, Bundle paramBundle, long paramLong)
  {
    switch (this.jdField_a_of_type_Nwh.a)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramString);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrlOriginal(paramString);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadData(paramString, this.jdField_a_of_type_Nwh.c, this.jdField_a_of_type_Nwh.d);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(paramString, this.jdField_a_of_type_Nwh.b, this.jdField_a_of_type_Nwh.c, this.jdField_a_of_type_Nwh.d, this.jdField_a_of_type_Nwh.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwg
 * JD-Core Version:    0.7.0.1
 */