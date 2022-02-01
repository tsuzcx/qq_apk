package com.tencent.mobileqq.msgbackup.fragment;

import android.view.View;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.QLog;

class MsgBackupTransportFragment$1
  implements OnItemSelectListener
{
  MsgBackupTransportFragment$1(MsgBackupTransportFragment paramMsgBackupTransportFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 8) {
        return;
      }
      MsgBackupManager.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("transfer is going, page is in link page! click 收起按钮! sIsShouQiBtnClick= ");
        paramView.append(MsgBackupManager.jdField_a_of_type_Boolean);
        paramView.append(", curSpeed = ");
        paramView.append(this.a.jdField_a_of_type_Long);
        paramView.append(", hasFinishedCount = ");
        paramView.append(this.a.d);
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, paramView.toString());
      }
      MsgBackupManager.a().a(this.a.jdField_a_of_type_Long, this.a.d, 3, this.a.getQBaseActivity());
      MsgBackupReporter.a("0X800A249");
      return;
    }
    MsgBackupTransportFragment.a(this.a);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("transfer is going, page is in link page! click cancel btn! sIsShouQiBtnClick= ");
      paramView.append(MsgBackupManager.jdField_a_of_type_Boolean);
      paramView.append(", isStart = ");
      paramView.append(this.a.jdField_a_of_type_Boolean);
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, paramView.toString());
    }
    if (MsgBackupTransportFragment.a(this.a) == 2) {
      if (this.a.e) {
        MsgBackupReporter.a("0X800A243", 2);
      } else {
        MsgBackupReporter.a("0X800A243", 1);
      }
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.l();
      return;
    }
    if (MsgBackupTransportFragment.a(this.a) == 1)
    {
      this.a.onBackEvent();
      return;
    }
    paramView = this.a;
    paramView.a(paramView.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment.1
 * JD-Core Version:    0.7.0.1
 */