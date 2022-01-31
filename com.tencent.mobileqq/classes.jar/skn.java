import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

final class skn
  implements DialogInterface.OnClickListener
{
  skn(Activity paramActivity, WSDownloadParams paramWSDownloadParams) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof skj)) {
      skj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      skj.a(125, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams);
      sms.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mScene, false, true);
      return;
      Log.e("weishi-808", "dialog type is error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     skn
 * JD-Core Version:    0.7.0.1
 */