import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;

public class ogl
  implements bigw
{
  public ogl(CustomWebView paramCustomWebView, ogm paramogm) {}
  
  public void onSetCookiesFinished(String paramString, Bundle paramBundle, long paramLong)
  {
    switch (this.jdField_a_of_type_Ogm.a)
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
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadData(paramString, this.jdField_a_of_type_Ogm.c, this.jdField_a_of_type_Ogm.d);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(paramString, this.jdField_a_of_type_Ogm.b, this.jdField_a_of_type_Ogm.c, this.jdField_a_of_type_Ogm.d, this.jdField_a_of_type_Ogm.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ogl
 * JD-Core Version:    0.7.0.1
 */