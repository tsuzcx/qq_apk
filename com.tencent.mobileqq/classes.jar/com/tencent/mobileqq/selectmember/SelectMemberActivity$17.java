package com.tencent.mobileqq.selectmember;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;

class SelectMemberActivity$17
  extends Handler
{
  SelectMemberActivity$17(SelectMemberActivity paramSelectMemberActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if ((this.a.pd != null) && (this.a.pd.isShowing()))
      {
        this.a.pd.dismiss();
        String str = (String)paramMessage.obj;
        paramMessage = str;
        if (str == null) {
          paramMessage = this.a.getString(2131693483);
        }
        QQToast.a(this.a, 1, paramMessage, 1500).b(this.a.getTitleBarHeight());
      }
    }
    else if ((this.a.pd != null) && (this.a.pd.isShowing()))
    {
      this.a.pd.dismiss();
      paramMessage = new Intent();
      paramMessage.putExtra("select_member_add_request_ok", true);
      this.a.setResult(-1, paramMessage);
      if (!TextUtils.isEmpty(this.a.mInviteSuccToastWording))
      {
        paramMessage = this.a.mInviteSuccToastWording;
      }
      else
      {
        if (this.a.mIsTroopAdmin) {
          i = 2131693485;
        } else {
          i = 2131693484;
        }
        paramMessage = this.a.getResources().getString(i);
      }
      QQToast.a(this.a, 2, paramMessage, 1500).b(this.a.getTitleBarHeight());
      postDelayed(new SelectMemberActivity.17.1(this), 1500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.17
 * JD-Core Version:    0.7.0.1
 */