package com.tencent.mobileqq.teamworkforgroup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

class GroupTeamWorkListActivity$12
  implements DialogInterface.OnClickListener
{
  GroupTeamWorkListActivity$12(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, PadInfo paramPadInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.makeText(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131889169), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299920));
      return;
    }
    if (this.b.i != null)
    {
      paramDialogInterface = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).getDocId(this.a.domainId, this.a.padId);
      if (GroupTeamWorkListActivity.d(this.b).getCheckBoxState()) {
        this.b.i.reqDeleteGroupTeamWorkFile(this.b.m, paramDialogInterface, this.a.pad_url, true);
      } else {
        this.b.i.reqDeleteGroupTeamWorkFile(this.b.m, paramDialogInterface, this.a.pad_url, false);
      }
      this.b.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.12
 * JD-Core Version:    0.7.0.1
 */