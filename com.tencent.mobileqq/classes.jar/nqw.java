import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;

public class nqw
  implements DialogInterface.OnClickListener
{
  public nqw(PublicAccountJavascriptInterface paramPublicAccountJavascriptInterface, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PublicAccountJavascriptInterface.a(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountJavascriptInterface, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.b);
    PublicAccountJavascriptInterface.setLocationPermissionGrant(this.c, this.d, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nqw
 * JD-Core Version:    0.7.0.1
 */