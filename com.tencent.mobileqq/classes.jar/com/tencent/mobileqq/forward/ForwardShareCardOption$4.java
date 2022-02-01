package com.tencent.mobileqq.forward;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ForwardShareCardOption$4
  extends DiscussionObserver
{
  ForwardShareCardOption$4(ForwardShareCardOption paramForwardShareCardOption) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("onGetFlyTicket: ");
      paramString2.append(paramBoolean);
      paramString2.append(" sigUrl=");
      paramString2.append(paramString1);
      QLog.d("ForwardOption.ForwardShareCardOption", 2, paramString2.toString());
    }
    if (!paramBoolean)
    {
      this.a.ae();
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          paramString1 = HardCodeUtil.a(2131902817);
        } else {
          paramString1 = HardCodeUtil.a(2131902823);
        }
      }
      else {
        paramString1 = HardCodeUtil.a(2131902824);
      }
      ForwardShareCardOption.c(this.a, null);
      ForwardShareCardOption.a(this.a, false);
      QQToast.makeText(this.a.s, 1, paramString1, 0).show(((BaseActivity)this.a.s).getTitleBarHeight());
      return;
    }
    if ((ForwardShareCardOption.d(this.a) != null) && (Long.parseLong(ForwardShareCardOption.d(this.a)) == paramLong2))
    {
      if (ForwardShareCardOption.f(this.a))
      {
        ForwardShareCardOption.c(this.a, paramString1);
        paramString1 = this.a;
        ForwardShareCardOption.a(paramString1, ForwardShareCardOption.d(paramString1), true);
      }
      ForwardShareCardOption.a(this.a, false);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateDiscussionFaceIcon|[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i("ForwardOption.ForwardShareCardOption", 2, localStringBuilder.toString());
    }
    if ((ForwardShareCardOption.d(this.a) != null) && (ForwardShareCardOption.d(this.a).equals(paramString)))
    {
      paramString = this.a;
      ForwardShareCardOption.a(paramString, ForwardShareCardOption.d(paramString), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareCardOption.4
 * JD-Core Version:    0.7.0.1
 */