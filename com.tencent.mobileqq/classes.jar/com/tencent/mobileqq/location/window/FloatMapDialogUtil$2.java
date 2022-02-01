package com.tencent.mobileqq.location.window;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class FloatMapDialogUtil$2
  implements Runnable
{
  FloatMapDialogUtil$2(QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    if (((IFloatMapService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "")).getBadNetOnFloatWindowDialogShown())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapDialogUtil", 2, "showBadNetDialog: invoked. 当前如果展示悬浮窗，就不显示这个弹窗了");
      }
      return;
    }
    Object localObject = this.a;
    localObject = DialogUtil.a((Context)localObject, 230, null, ((QBaseActivity)localObject).getResources().getString(2131916654), 2131892267, 2131887648, null, new FloatMapDialogUtil.2.1(this));
    FloatMapDialogUtil.a(this.a, (QQCustomDialog)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.FloatMapDialogUtil.2
 * JD-Core Version:    0.7.0.1
 */