import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.SetCookiesCallback;

public class kvw
  implements SwiftBrowserCookieMonster.SetCookiesCallback
{
  public kvw(CustomWebView paramCustomWebView, kwa paramkwa) {}
  
  public void a(String paramString, Bundle paramBundle, long paramLong)
  {
    switch (this.jdField_a_of_type_Kwa.a)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadUrl(paramString);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.a(paramString);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadData(paramString, this.jdField_a_of_type_Kwa.c, this.jdField_a_of_type_Kwa.d);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(paramString, this.jdField_a_of_type_Kwa.b, this.jdField_a_of_type_Kwa.c, this.jdField_a_of_type_Kwa.d, this.jdField_a_of_type_Kwa.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kvw
 * JD-Core Version:    0.7.0.1
 */