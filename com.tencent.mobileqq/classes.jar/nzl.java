import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;

public class nzl
  implements bgwe
{
  public nzl(CustomWebView paramCustomWebView, nzm paramnzm) {}
  
  public void onSetCookiesFinished(String paramString, Bundle paramBundle, long paramLong)
  {
    switch (this.jdField_a_of_type_Nzm.a)
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
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadData(paramString, this.jdField_a_of_type_Nzm.c, this.jdField_a_of_type_Nzm.d);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(paramString, this.jdField_a_of_type_Nzm.b, this.jdField_a_of_type_Nzm.c, this.jdField_a_of_type_Nzm.d, this.jdField_a_of_type_Nzm.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzl
 * JD-Core Version:    0.7.0.1
 */