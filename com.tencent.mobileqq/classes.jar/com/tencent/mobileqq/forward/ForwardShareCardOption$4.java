package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ForwardShareCardOption$4
  extends DiscussionObserver
{
  ForwardShareCardOption$4(ForwardShareCardOption paramForwardShareCardOption) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShareCardOption", 2, "onGetFlyTicket: " + paramBoolean + " sigUrl=" + paramString1);
    }
    if (!paramBoolean)
    {
      this.a.z();
      switch (paramInt)
      {
      default: 
        paramString1 = HardCodeUtil.a(2131704849);
        ForwardShareCardOption.c(this.a, null);
        ForwardShareCardOption.a(this.a, false);
        QQToast.a(this.a.a, 1, paramString1, 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
      }
    }
    while ((ForwardShareCardOption.c(this.a) == null) || (Long.parseLong(ForwardShareCardOption.c(this.a)) != paramLong2)) {
      for (;;)
      {
        return;
        paramString1 = HardCodeUtil.a(2131704856);
        continue;
        paramString1 = HardCodeUtil.a(2131704855);
      }
    }
    if (ForwardShareCardOption.a(this.a))
    {
      ForwardShareCardOption.c(this.a, paramString1);
      ForwardShareCardOption.a(this.a, ForwardShareCardOption.c(this.a), true);
    }
    ForwardShareCardOption.a(this.a, false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardOption.ForwardShareCardOption", 2, "onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramString + "]");
    }
    if ((ForwardShareCardOption.c(this.a) != null) && (ForwardShareCardOption.c(this.a).equals(paramString))) {
      ForwardShareCardOption.a(this.a, ForwardShareCardOption.c(this.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareCardOption.4
 * JD-Core Version:    0.7.0.1
 */