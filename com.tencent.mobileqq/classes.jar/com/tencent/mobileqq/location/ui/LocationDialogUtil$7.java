package com.tencent.mobileqq.location.ui;

import android.content.res.Resources;
import arvk;
import arvz;
import arzl;
import bbcv;
import bbgg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public final class LocationDialogUtil$7
  implements Runnable
{
  public LocationDialogUtil$7(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    if (arzl.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, "showBadNetDialog: invoked. 当前如果展示悬浮窗，就不显示这个弹窗了");
      }
      return;
    }
    bbgg localbbgg = bbcv.a(this.a, 230, null, this.a.getResources().getString(2131719598), 2131694793, 2131690596, null, new arvz(this));
    arvk.a(this.a, localbbgg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationDialogUtil.7
 * JD-Core Version:    0.7.0.1
 */