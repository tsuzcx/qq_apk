package com.tencent.mobileqq.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.config.DeepCleanConfigReporter;
import com.tencent.mobileqq.widget.QQToast;

class QQSettingMsgClearFragment$4
  implements DialogInterface.OnClickListener
{
  QQSettingMsgClearFragment$4(QQSettingMsgClearFragment paramQQSettingMsgClearFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DeepCleanConfigReporter.a(2);
    QQSettingMsgClearFragment.b(this.a);
    QQSettingMsgClearFragment.c(this.a);
    QQToast.a(this.a.getBaseActivity(), this.a.getString(2131691843), 0).b(this.a.getBaseActivity().getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.4
 * JD-Core Version:    0.7.0.1
 */