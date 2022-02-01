package com.tencent.mobileqq.upgrade;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.open.downloadnew.MyAppApi;

final class NewUpgradeDialog$7
  implements Runnable
{
  NewUpgradeDialog$7(Activity paramActivity, Bundle paramBundle) {}
  
  public void run()
  {
    MyAppApi.l().a(this.a, this.b, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.NewUpgradeDialog.7
 * JD-Core Version:    0.7.0.1
 */