import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient.Observer;
import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class mzl
  implements VideoFeedsIPCClient.Observer
{
  public mzl(PublicAccountH5AbilityPlugin paramPublicAccountH5AbilityPlugin, QQProgressDialog paramQQProgressDialog, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {}
  
  public void a(String paramString, Bundle paramBundle)
  {
    int i;
    if ("CMD_CAMERA_CAPTURE_SO_DOWNLOAD".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
      QQToast.a(BaseApplicationImpl.getContext(), 2131432992, 0).a();
      return;
    case 1: 
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsIPCClient.a("CMD_CAMERA_CAPTURE_CHECK_SO_READY", null).getBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY");
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.cameracapture", 2, "showUGCVideoRecordPage() isSoReady:" + bool);
      }
      PublicAccountH5AbilityPlugin.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.d, this.e, this.f, this.g);
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilPublicAccountH5AbilityPlugin.jdField_a_of_type_AndroidAppActivity, 230).setMessage("短视频插件下载完成，需要重启QQ生效").setNegativeButton(2131433029, new DialogUtil.DialogOnClickAdapter()).setPositiveButton(2131433030, new mzm(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzl
 * JD-Core Version:    0.7.0.1
 */