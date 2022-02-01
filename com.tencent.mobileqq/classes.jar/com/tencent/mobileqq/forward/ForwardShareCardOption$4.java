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
      this.a.A();
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          paramString1 = HardCodeUtil.a(2131704925);
        } else {
          paramString1 = HardCodeUtil.a(2131704931);
        }
      }
      else {
        paramString1 = HardCodeUtil.a(2131704932);
      }
      ForwardShareCardOption.c(this.a, null);
      ForwardShareCardOption.a(this.a, false);
      QQToast.a(this.a.a, 1, paramString1, 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
      return;
    }
    if ((ForwardShareCardOption.c(this.a) != null) && (Long.parseLong(ForwardShareCardOption.c(this.a)) == paramLong2))
    {
      if (ForwardShareCardOption.a(this.a))
      {
        ForwardShareCardOption.c(this.a, paramString1);
        paramString1 = this.a;
        ForwardShareCardOption.a(paramString1, ForwardShareCardOption.c(paramString1), true);
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
    if ((ForwardShareCardOption.c(this.a) != null) && (ForwardShareCardOption.c(this.a).equals(paramString)))
    {
      paramString = this.a;
      ForwardShareCardOption.a(paramString, ForwardShareCardOption.c(paramString), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareCardOption.4
 * JD-Core Version:    0.7.0.1
 */