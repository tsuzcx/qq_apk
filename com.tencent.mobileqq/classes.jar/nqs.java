import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;

public class nqs
  implements DialogInterface.OnClickListener
{
  public nqs(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, String paramString1, long paramLong, String paramString2, String paramString3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PublicAccountJavascriptInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    PublicAccountJavascriptInterface.setLocationPermissionGrant(this.b, this.c, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nqs
 * JD-Core Version:    0.7.0.1
 */