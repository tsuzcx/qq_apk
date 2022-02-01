package com.tencent.mobileqq.upgrade;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.base.LogUtility;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewUpgradeDialog$4
  implements View.OnClickListener
{
  NewUpgradeDialog$4(NewUpgradeDialog paramNewUpgradeDialog) {}
  
  public void onClick(View paramView)
  {
    switch (NewUpgradeDialog.a(this.a))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      NewUpgradeDialog.a(this.a);
      continue;
      NewUpgradeDialog.b(this.a);
      LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
      continue;
      LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
      continue;
      NewUpgradeDialog.c(this.a);
      LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
      continue;
      this.a.c();
      LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      continue;
      LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeDialog.4
 * JD-Core Version:    0.7.0.1
 */