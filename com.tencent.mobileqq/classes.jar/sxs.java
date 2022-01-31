import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.6;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class sxs
  implements ref
{
  public sxs(PublicAccountH5AbilityPlugin.6 param6, bepp parambepp, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public void a(String paramString, Bundle paramBundle)
  {
    int i;
    if ("CMD_CAMERA_CAPTURE_SO_DOWNLOAD".equals(paramString))
    {
      this.jdField_a_of_type_Bepp.dismiss();
      i = paramBundle.getInt("VALUE_CAMERA_CAPTURE_SO_DOWNLOAD_STATUS");
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage VideoFeedsIPCClient.callback downloadResult=" + i);
      }
    }
    switch (i)
    {
    default: 
      return;
    case 3: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131719266, 0).a();
      return;
    case 1: 
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin$6.this$0.jdField_a_of_type_Red.a("CMD_CAMERA_CAPTURE_CHECK_SO_READY", null).getBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY");
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage() isSoReady:" + bool);
      }
      sxe.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin$6.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.f, this.g, this.h);
      return;
    }
    bdcd.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin$6.this$0.jdField_a_of_type_AndroidAppActivity, 230).setMessage(alpo.a(2131709167)).setNegativeButton(2131690648, new bdco()).setPositiveButton(2131694951, new sxt(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sxs
 * JD-Core Version:    0.7.0.1
 */