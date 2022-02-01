package com.tencent.mobileqq.newfriend.ui.adapter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class NewFriendMoreSysMsgAdapter$3
  implements DialogInterface.OnClickListener
{
  NewFriendMoreSysMsgAdapter$3(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "clear click");
    }
    if (NetworkUtil.isNetSupport(NewFriendMoreSysMsgAdapter.a(this.a)))
    {
      ReportController.b(this.a.a, "dc00898", "", "", "0X800A328", "0X800A328", 2, 0, "", "", "", "");
      NewFriendMoreSysMsgAdapter.b(this.a);
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).clearAllSystemMsg(this.a.a);
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).deleteAllSuspiciousMsg(this.a.a);
      return;
    }
    QQToast.a(NewFriendMoreSysMsgAdapter.a(this.a), 2131694433, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter.3
 * JD-Core Version:    0.7.0.1
 */