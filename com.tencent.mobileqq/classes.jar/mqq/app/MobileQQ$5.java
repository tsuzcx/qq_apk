package mqq.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;

class MobileQQ$5
  implements Runnable
{
  MobileQQ$5(MobileQQ paramMobileQQ, SimpleAccount paramSimpleAccount, int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  public void run()
  {
    int j = 1;
    if (MobileQQ.access$000(this.this$0) == null) {}
    Object localObject1;
    for (int i = 1;; i = 0)
    {
      localObject1 = this.this$0.createRuntime(MobileQQ.processName, true);
      if (localObject1 != null) {
        break;
      }
      QLog.i("mqq", 1, MobileQQ.processName + " needn't AppRuntime!");
      return;
    }
    ((AppRuntime)localObject1).init(this.this$0, MobileQQ.access$100(this.this$0), this.val$account);
    if (!this.this$0.getQQProcessName().endsWith(":video")) {
      ((AppRuntime)localObject1).getService().msfSub.registerMsfService();
    }
    if ((this.val$account != null) && (this.val$account.isLogined())) {
      if (this.val$cnrType == 2) {
        break label663;
      }
    }
    label644:
    label649:
    label663:
    for (boolean bool = ((AppRuntime)localObject1).canAutoLogin(this.val$account.getUin());; bool = true)
    {
      if ((this.val$forLogin) || (bool)) {
        ((AppRuntime)localObject1).setLogined();
      }
      QLog.d("MobileQQ", 1, "createNewRuntime, canAutoOK: " + bool);
      MobileQQ.access$802(this.this$0, ((AppRuntime)localObject1).isLogin());
      long l1;
      long l2;
      if (((AppRuntime)localObject1).isLogin())
      {
        if (MobileQQ.access$000(this.this$0) != null)
        {
          MobileQQ.access$000(this.this$0).logout(Constants.LogoutReason.switchAccount, true);
          MobileQQ.access$000(this.this$0).onDestroy();
        }
        long l3;
        if (this.val$needSaveLoginTime)
        {
          localObject2 = this.this$0.getFirstSimpleAccount();
          l3 = System.currentTimeMillis();
          l1 = l3;
          if (localObject2 != null) {
            l2 = l3;
          }
        }
        try
        {
          long l4 = this.this$0.string2Long(this.this$0.getProperty(((SimpleAccount)localObject2).getUin() + Constants.Key._logintime));
          l1 = l3;
          if (l3 <= l4)
          {
            l3 = 1L + l4;
            l1 = l3;
            l2 = l3;
            if (QLog.isColorLevel())
            {
              l2 = l3;
              QLog.d("mqq", 2, "CNR account savetime => system time is error..");
              l1 = l3;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            l1 = l2;
          }
        }
        Object localObject2 = ((AppRuntime)localObject1).getAccount();
        if ((localObject2 != null) && (this.this$0.getQQProcessName().equals(this.this$0.getPackageName())))
        {
          localObject2 = this.this$0.mHandler.obtainMessage(3, localObject2);
          this.this$0.mHandler.sendMessageDelayed((Message)localObject2, 1000L);
        }
        this.this$0.setProperty(((AppRuntime)localObject1).getAccount() + Constants.Key._logintime, String.valueOf(l1));
        ((AppRuntime)localObject1).onCreate(null);
        MobileQQ.access$002(this.this$0, (AppRuntime)localObject1);
        label482:
        localObject1 = this.this$0.mHandler.obtainMessage(1);
        if (i == 0) {
          break label644;
        }
      }
      for (i = j;; i = 0)
      {
        ((Message)localObject1).arg2 = i;
        ((Message)localObject1).arg1 = this.val$cnrType;
        ((Message)localObject1).obj = this.val$process;
        if (Looper.getMainLooper() != Looper.myLooper()) {
          break label649;
        }
        this.this$0.mHandler.dispatchMessage((Message)localObject1);
        return;
        if (this.val$account != null)
        {
          QLog.d("MobileQQ", 1, "CNR account != null and account.isLogined =" + this.val$account.isLogined());
          break;
        }
        QLog.d("MobileQQ", 1, "CNR account == null");
        break;
        if (MobileQQ.access$000(this.this$0) != null) {
          break label482;
        }
        ((AppRuntime)localObject1).onCreate(null);
        MobileQQ.access$002(this.this$0, (AppRuntime)localObject1);
        break label482;
      }
      this.this$0.mHandler.sendMessage((Message)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MobileQQ.5
 * JD-Core Version:    0.7.0.1
 */