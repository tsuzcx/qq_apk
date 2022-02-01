package mqq.app;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class MainService$MyErrorHandler$3
  implements Runnable
{
  MainService$MyErrorHandler$3(MainService.MyErrorHandler paramMyErrorHandler, String paramString1, AppRuntime paramAppRuntime, Constants.LogoutReason paramLogoutReason, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5) {}
  
  public void run()
  {
    boolean bool;
    if ((this.val$uin != null) && (this.val$uin.equals(this.val$app.getAccount())))
    {
      if (this.val$reason != Constants.LogoutReason.expired) {
        break label452;
      }
      if (this.val$app.isLogin()) {
        break label522;
      }
      bool = false;
    }
    for (;;)
    {
      if ((this.val$reason != Constants.LogoutReason.tips) && (this.val$app.isLogin()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "kickPC in popupNotification  do logout");
        }
        this.val$app.logout(this.val$reason, true);
      }
      Intent localIntent;
      if ((bool) && (MainService.access$000(this.this$1.this$0) != null) && (MainService.access$000(this.this$1.this$0).getQQProcessName().equalsIgnoreCase(MainService.access$000(this.this$1.this$0).getPackageName())))
      {
        localIntent = new Intent(this.val$action);
        localIntent.setPackage(MainService.access$000(this.this$1.this$0).getPackageName());
        localIntent.putExtra("title", this.val$title);
        localIntent.putExtra("msg", this.val$msg);
        localIntent.putExtra("reason", this.val$reason);
        localIntent.putExtra("isSameDevice", this.val$isSameDevice);
        localIntent.addFlags(268435456);
        if ((!this.val$app.isClearTaskBySystem) && ((!this.val$isSameDevice) || (this.val$action == null) || (!this.val$action.equalsIgnoreCase("mqq.intent.action.ACCOUNT_KICKED")) || (!this.val$app.isBackgroundStop))) {
          break label457;
        }
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "kicked samedevice and set kickIntent ");
        }
        this.val$app.setKickIntent(localIntent);
      }
      for (;;)
      {
        localIntent = new Intent(this.val$action);
        localIntent.putExtra("reason", this.val$reason);
        localIntent.putExtra("title", this.val$title);
        localIntent.putExtra("msg", this.val$msg);
        localIntent.putExtra("reason", this.val$reason);
        localIntent.putExtra("isSameDevice", this.val$isSameDevice);
        localIntent.putExtra("needNotify", false);
        localIntent.setPackage(MainService.access$000(this.this$1.this$0).getPackageName());
        if ("QQConnectLogin.pre_auth".equals(this.val$serviceCmd)) {
          localIntent.putExtra("serviceCmd", this.val$serviceCmd);
        }
        MainService.access$000(this.this$1.this$0).sendBroadcast(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "kicked....kickPC...... in popupNotification end isNeedNotify = " + bool);
        }
        return;
        label452:
        bool = true;
        break;
        label457:
        if (!this.val$app.onReceiveUnhandledKickedMsg(this.val$action, localIntent)) {
          try
          {
            MainService.access$000(this.this$1.this$0).startActivity(localIntent);
            if (QLog.isColorLevel()) {
              QLog.d("mqq", 2, "kicked start notification......");
            }
          }
          catch (Exception localException)
          {
            this.val$app.runOnUiThread(new MainService.MyErrorHandler.3.1(this));
          }
        }
      }
      label522:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MainService.MyErrorHandler.3
 * JD-Core Version:    0.7.0.1
 */