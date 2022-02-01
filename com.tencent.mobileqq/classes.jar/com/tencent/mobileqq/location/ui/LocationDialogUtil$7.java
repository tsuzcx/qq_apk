package com.tencent.mobileqq.location.ui;

import android.content.res.Resources;
import awju;
import awkj;
import awnx;
import bhdj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public final class LocationDialogUtil$7
  implements Runnable
{
  public LocationDialogUtil$7(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (awnx.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, "showBadNetDialog: invoked. 当前如果展示悬浮窗，就不显示这个弹窗了");
      }
      return;
    }
    QQCustomDialog localQQCustomDialog = bhdj.a(this.a, 230, null, this.a.getResources().getString(2131718875), 2131694399, 2131690697, null, new awkj(this));
    awju.a(this.a, localQQCustomDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.7
 * JD-Core Version:    0.7.0.1
 */