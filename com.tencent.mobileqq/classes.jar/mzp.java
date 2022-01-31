import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;

public class mzp
  implements bbbb
{
  public mzp(CustomWebView paramCustomWebView, mzq parammzq) {}
  
  public void a(String paramString, Bundle paramBundle, long paramLong)
  {
    switch (this.jdField_a_of_type_Mzq.a)
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
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadData(paramString, this.jdField_a_of_type_Mzq.c, this.jdField_a_of_type_Mzq.d);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.loadDataWithBaseURL(paramString, this.jdField_a_of_type_Mzq.b, this.jdField_a_of_type_Mzq.c, this.jdField_a_of_type_Mzq.d, this.jdField_a_of_type_Mzq.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzp
 * JD-Core Version:    0.7.0.1
 */