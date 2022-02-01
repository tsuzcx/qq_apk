import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;

public class oke
  implements DialogInterface.OnClickListener
{
  public oke(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-3", "{}" });
    this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oke
 * JD-Core Version:    0.7.0.1
 */