package com.tencent.mobileqq.settings.message;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.QVipUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.qphone.base.util.QLog;

class AssistantSettingFragment$43
  implements DialogInterface.OnClickListener
{
  AssistantSettingFragment$43(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("vip_ptt.AssistantSettingFragment", 1, "click pay for auto ptt");
    paramDialogInterface = QVipAutoPttProcessor.e();
    if (TextUtils.isEmpty(paramDialogInterface.b))
    {
      QVipUtils.a(this.a.getBaseActivity(), "https://h5.vip.qq.com/p/pay/index?_wv=524289&_fv=0&type=!svip&aid=mvip.n.a.zdzwz");
    }
    else
    {
      paramDialogInterface = paramDialogInterface.b.replace("{aid}", "mvip.n.a.zdzwz");
      QVipUtils.a(this.a.getBaseActivity(), paramDialogInterface);
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.43
 * JD-Core Version:    0.7.0.1
 */