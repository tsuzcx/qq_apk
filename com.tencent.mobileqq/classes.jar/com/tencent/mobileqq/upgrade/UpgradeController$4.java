package com.tencent.mobileqq.upgrade;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.UpgradeInfo;

class UpgradeController$4
  implements Runnable
{
  UpgradeController$4(UpgradeController paramUpgradeController, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if ((UpgradeController.a(this.this$0) != null) && (UpgradeController.a(this.this$0).f != null) && (UpgradeController.a(this.this$0).f.dialog != null))
    {
      Object localObject = UpgradeController.a(this.this$0).f.dialog;
      Intent localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", ((NewUpgradeConfig.Dialog)localObject).e);
      localIntent.putExtra("StrUpgradeDesc", ((NewUpgradeConfig.Dialog)localObject).f);
      if (this.a) {
        localIntent.putExtra("strDesc", ((NewUpgradeConfig.Dialog)localObject).g);
      }
      localIntent.putExtra("lBtnText", ((NewUpgradeConfig.Dialog)localObject).m);
      localIntent.putExtra("rBtnText", ((NewUpgradeConfig.Dialog)localObject).n);
      localIntent.putExtra("StrUrl", "");
      localIntent.putExtra("iUpgradeType", UpgradeController.a(this.this$0).b.iUpgradeType);
      localIntent.putExtra("iTipsType", UpgradeController.a(this.this$0).b.iTipsType);
      localIntent.putExtra("strConfirmBtnText", UpgradeController.a(this.this$0).b.strButtonDesc);
      localIntent.putExtra("strCancelButtonDesc", UpgradeController.a(this.this$0).b.strCancelButtonDesc);
      localIntent.putExtra("iUpgradeSdkId", UpgradeController.a(this.this$0).b.iUpgradeSdkId);
      if ((UpgradeController.a(this.this$0).f != null) && (UpgradeController.a(this.this$0).f.dialog != null)) {
        localIntent.putExtra("rate", UpgradeController.a(this.this$0).f.dialog.j);
      }
      localIntent.putExtra("activity_type", 4096);
      localIntent.putExtra("mode", 0);
      localObject = ConfigHandler.a(this.b.getApp());
      if ((localObject != null) && (((String)localObject).equals("com.tencent.mobileqq.activity.UserguideActivity")))
      {
        this.b.upgradeData = localIntent;
        return;
      }
      this.b.upgradeData = null;
      if (BaseActivity.sTopActivity != null) {
        BaseActivity.sTopActivity.startActivity(localIntent);
      }
      return;
    }
    QLog.d("UpgradeController", 1, "showUpgradeDialog fail, invalid param.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeController.4
 * JD-Core Version:    0.7.0.1
 */