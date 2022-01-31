package mqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Queue;

public class QQBroadcastReceiver
  extends BroadcastReceiver
{
  public String getModuleId()
  {
    return null;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    long l = System.currentTimeMillis();
    Object localObject1;
    if (paramIntent == null)
    {
      localObject1 = "";
      localObject1 = Pair.create(Long.valueOf(l), localObject1);
      if ((localMobileQQ != null) && (localMobileQQ.broadcastInfoQueue != null))
      {
        if (localMobileQQ.broadcastInfoQueue.size() >= 5) {
          break label99;
        }
        localMobileQQ.broadcastInfoQueue.offer(localObject1);
      }
      label70:
      localMobileQQ.onActivityCreate(this, paramIntent);
      if ("Success".equals(MobileQQ.sInjectResult)) {
        break label126;
      }
    }
    label99:
    label126:
    do
    {
      return;
      localObject1 = paramIntent.toString();
      break;
      localMobileQQ.broadcastInfoQueue.poll();
      localMobileQQ.broadcastInfoQueue.offer(localObject1);
      break label70;
      localObject1 = localMobileQQ.waitAppRuntime(null);
    } while (localObject1 == null);
    Object localObject3 = getModuleId();
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = ((AppRuntime)localObject1).getAppRuntime((String)localObject3);
      localObject2 = localObject1;
      if (localObject3 != null) {
        localObject2 = localObject3;
      }
    }
    int i;
    if (paramIntent != null)
    {
      localObject1 = null;
      i = -1;
    }
    try
    {
      localObject3 = paramIntent.getStringExtra("k_pcactive_uin");
      localObject1 = localObject3;
      int j = paramIntent.getIntExtra("k_pcactive_retryIndex", -1);
      i = j;
      localObject1 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        Object localObject4 = null;
      }
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!"0".equals(localObject1)))
    {
      QLog.d("QQBroadcastReceiver", 1, "PCActive:active qq process");
      localMobileQQ.isPCActive = true;
      localMobileQQ.reportPCActive((String)localObject1, i);
      if (!SettingCloneUtil.readValue(localMobileQQ, localObject2.getAccount(), null, "pcactive_has_notice", false)) {
        SettingCloneUtil.writeValue(localMobileQQ, localObject2.getAccount(), null, "pcactive_notice_key", true);
      }
      if (!localObject2.isLogin())
      {
        QLog.d("QQBroadcastReceiver", 1, "PCActive:Account is not login");
        localObject3 = localObject2.getApplication().getAllAccounts();
        if (localObject3 == null) {
          break label418;
        }
        localObject3 = (SimpleAccount)((List)localObject3).get(0);
        if ((localObject3 != null) && (((String)localObject1).equals(((SimpleAccount)localObject3).getUin())) && (((SimpleAccount)localObject3).isLogined()))
        {
          QLog.d("QQBroadcastReceiver", 1, "PCActive:Show Notification");
          localObject2.login((SimpleAccount)localObject3);
          localObject3 = new Intent("com.tencent.mobileqq.closeNotification");
          ((Intent)localObject3).putExtra("uin", (String)localObject1);
          paramContext.sendBroadcast((Intent)localObject3);
        }
      }
    }
    onReceive(localObject2, paramContext, paramIntent);
  }
  
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.QQBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */