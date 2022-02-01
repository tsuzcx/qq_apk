package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import bfur;
import bjfr;
import bjfs;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;

public class ShareProxyImpl$2$1
  implements Runnable
{
  public ShareProxyImpl$2$1(bjfr parambjfr, boolean paramBoolean, Boolean paramBoolean1, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bjfr.jdField_a_of_type_ComTencentMobileqqMiniShareMiniProgramShareUtils$OnShareListener != null)) {
      this.jdField_a_of_type_Bjfr.jdField_a_of_type_ComTencentMobileqqMiniShareMiniProgramShareUtils$OnShareListener.onShared(this.jdField_a_of_type_JavaLangBoolean.booleanValue(), false);
    }
    if (this.jdField_a_of_type_Long == -100070004L)
    {
      if (this.jdField_a_of_type_Bjfr.jdField_a_of_type_ComTencentMobileqqMiniShareMiniProgramShareUtils$OnShareListener != null) {
        this.jdField_a_of_type_Bjfr.jdField_a_of_type_ComTencentMobileqqMiniShareMiniProgramShareUtils$OnShareListener.onShared(this.jdField_a_of_type_JavaLangBoolean.booleanValue(), false);
      }
      bfur.a(this.jdField_a_of_type_Bjfr.jdField_a_of_type_ComTencentQqminiSdkLauncherModelInnerShareData.fromActivity, 233, this.jdField_a_of_type_Bjfr.jdField_a_of_type_ComTencentQqminiSdkLauncherModelInnerShareData.fromActivity.getString(2131718383), this.jdField_a_of_type_JavaLangString, new bjfs(this), null).show();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Bjfr.jdField_a_of_type_ComTencentQqminiSdkLauncherModelInnerShareData.fromActivity, 1, 2131718383, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.2.1
 * JD-Core Version:    0.7.0.1
 */