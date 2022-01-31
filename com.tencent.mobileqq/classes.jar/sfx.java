import android.os.Bundle;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.5;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class sfx
  implements qpb
{
  public sfx(PublicAccountH5AbilityPlugin.5 param5, bcqf parambcqf, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {}
  
  public void a(String paramString, Bundle paramBundle)
  {
    int i;
    if ("CMD_CAMERA_CAPTURE_SO_DOWNLOAD".equals(paramString))
    {
      this.jdField_a_of_type_Bcqf.dismiss();
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
      bcql.a(BaseApplicationImpl.getContext(), 2131718792, 0).a();
      return;
    case 1: 
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin$5.this$0.jdField_a_of_type_Qoz.a("CMD_CAMERA_CAPTURE_CHECK_SO_READY", null).getBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY");
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage() isSoReady:" + bool);
      }
      sfk.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin$5.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.f, this.g, this.h);
      return;
    }
    bbdj.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin$5.this$0.jdField_a_of_type_AndroidAppActivity, 230).setMessage(ajya.a(2131708795)).setNegativeButton(2131690596, new bbdt()).setPositiveButton(2131694794, new sfy(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sfx
 * JD-Core Version:    0.7.0.1
 */