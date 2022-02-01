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
    int i = NewUpgradeDialog.b(this.a);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 10)
            {
              if (i == 20) {
                LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_WAIT");
              }
            }
            else {
              LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_CANCEL");
            }
          }
          else
          {
            NewUpgradeDialog.d(this.a);
            LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_COMPLETE");
          }
        }
        else
        {
          NewUpgradeDialog.e(this.a);
          LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_PAUSE");
        }
      }
      else
      {
        this.a.c();
        LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_DOWNLOADING");
      }
    }
    else
    {
      LogUtility.c("NewUpgradeDialog", "onclick right btn  state = STATE_INIT");
      NewUpgradeDialog.c(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeDialog.4
 * JD-Core Version:    0.7.0.1
 */