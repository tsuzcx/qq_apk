package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.ICommonManager;
import org.json.JSONObject;

class ShareProxyImpl$2
  implements MiniAppCmdInterface
{
  ShareProxyImpl$2(ShareProxyImpl paramShareProxyImpl, int paramInt, InnerShareData paramInnerShareData, MiniArkShareModel paramMiniArkShareModel, MiniProgramShareUtils.OnShareListener paramOnShareListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      if (this.jdField_a_of_type_Int == 5)
      {
        localObject = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
        if (localObject != null) {}
      }
      while (!MiniProgramShareUtils.performShareAsArkMessage(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelInnerShareData.fromActivity, MiniProgramShareUtils.getArkPrompt(this.jdField_a_of_type_ComTencentMobileqqMiniShareMiniArkShareModel, paramJSONObject), this.jdField_a_of_type_ComTencentMobileqqMiniShareMiniArkShareModel.getDescription(), this.jdField_a_of_type_ComTencentMobileqqMiniShareMiniArkShareModel.getPicUrl(), this.jdField_a_of_type_ComTencentMobileqqMiniShareMiniArkShareModel.getJumpUrl(), this.jdField_a_of_type_ComTencentMobileqqMiniShareMiniArkShareModel.getEntryModel(), this.jdField_a_of_type_ComTencentMobileqqMiniShareMiniArkShareModel.getShareChatModel(), this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelInnerShareData.shareSource, this.jdField_a_of_type_ComTencentMobileqqMiniShareMiniArkShareModel.getShareTarget(), paramJSONObject, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqMiniShareMiniArkShareModel.getAppId(), this.jdField_a_of_type_ComTencentMobileqqMiniShareMiniArkShareModel.getShareBusinessType()))
      {
        do
        {
          return;
          localObject = ((BaseRuntime)localObject).getShareState();
        } while (localObject == null);
        ((ShareState)localObject).shareJson = paramJSONObject.toString();
      }
      QLog.d("ShareProxyImpl", 1, "onCmdListener: share successful " + paramJSONObject.toString());
      return;
    }
    QLog.d("ShareProxyImpl", 1, "onCmdListener: share failed " + paramBoolean + " " + paramJSONObject);
    long l = -1L;
    Object localObject = null;
    boolean bool = false;
    if (paramJSONObject != null)
    {
      l = paramJSONObject.optLong("retCode");
      localObject = paramJSONObject.optString("errMsg");
      bool = paramJSONObject.optBoolean("needShareCallBack");
    }
    AppBrandTask.runTaskOnUiThread(new ShareProxyImpl.2.1(this, paramBoolean, Boolean.valueOf(bool), l, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */