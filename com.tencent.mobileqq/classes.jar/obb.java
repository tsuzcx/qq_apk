import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;

public class obb
  implements DialogInterface.OnCancelListener
{
  public obb(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-3", "{}" });
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     obb
 * JD-Core Version:    0.7.0.1
 */