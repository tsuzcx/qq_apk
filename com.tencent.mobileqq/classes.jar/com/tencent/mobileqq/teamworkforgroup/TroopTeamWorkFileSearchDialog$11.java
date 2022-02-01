package com.tencent.mobileqq.teamworkforgroup;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class TroopTeamWorkFileSearchDialog$11
  implements Runnable
{
  TroopTeamWorkFileSearchDialog$11(TroopTeamWorkFileSearchDialog paramTroopTeamWorkFileSearchDialog, View paramView, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((View)localObject).setDrawingCacheEnabled(this.b);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mBlurBackground == null :");
      boolean bool;
      if (TroopTeamWorkFileSearchDialog.a(this.this$0) == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("TroopTeamWorkFileSearchDialog", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.11
 * JD-Core Version:    0.7.0.1
 */