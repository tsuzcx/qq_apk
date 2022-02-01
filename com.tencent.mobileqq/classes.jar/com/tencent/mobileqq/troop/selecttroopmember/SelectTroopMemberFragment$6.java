package com.tencent.mobileqq.troop.selecttroopmember;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberMngHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;

class SelectTroopMemberFragment$6
  implements View.OnClickListener
{
  SelectTroopMemberFragment$6(SelectTroopMemberFragment paramSelectTroopMemberFragment, ArrayList paramArrayList, CheckBox paramCheckBox, boolean paramBoolean, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ITroopMemberMngHandler)this.e.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_MNG_HANDLER);
    if (localObject != null) {}
    try
    {
      if (this.e.k == null)
      {
        this.e.k = new ReportDialog(this.e.getBaseActivity(), 2131953338);
        this.e.k.setContentView(2131623999);
        this.e.k.setCancelable(true);
        ((TextView)this.e.k.findViewById(2131431876)).setText(this.e.getString(2131888735));
      }
      this.e.k.show();
      ((ITroopMemberMngHandler)localObject).a(Long.parseLong(this.e.d), this.a, this.b.isChecked(), this.c);
    }
    catch (Exception localException)
    {
      label148:
      break label148;
    }
    localObject = this.d;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.d.dismiss();
    }
    SelectTroopMemberFragment.a(this.e);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment.6
 * JD-Core Version:    0.7.0.1
 */