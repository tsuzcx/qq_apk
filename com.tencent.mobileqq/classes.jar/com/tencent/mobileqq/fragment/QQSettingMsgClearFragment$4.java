package com.tencent.mobileqq.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
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
    QQToast.a(this.a.getActivity(), this.a.getString(2131691916), 0).b(this.a.getActivity().getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingMsgClearFragment.4
 * JD-Core Version:    0.7.0.1
 */