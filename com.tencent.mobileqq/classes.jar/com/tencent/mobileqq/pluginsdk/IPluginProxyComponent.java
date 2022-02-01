package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.qphone.base.util.MD5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

class IPluginProxyComponent
{
  private static final String ACTION_QQPROCESS_EXIT = "com.tencent.process.exit";
  private static BroadcastReceiver sAccountReceiver;
  
  static void exitProcess(String paramString)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginRuntime.exitProcess");
    }
    Object localObject1 = PluginStatic.getActivitys();
    try
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IPluginActivity)((WeakReference)((Iterator)localObject1).next()).get();
        if (localObject2 != null) {
          ((IPluginActivity)localObject2).IFinish();
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      label60:
      break label60;
    }
    localObject1 = MobileQQ.processName;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = new Intent("com.tencent.process.exit");
      ((Intent)localObject2).putExtra("K_EXCEP", paramString);
      ((Intent)localObject2).putExtra("exit_type", 0);
      paramString = new ArrayList();
      paramString.add(localObject1);
      ((Intent)localObject2).putStringArrayListExtra("procNameList", paramString);
      ((Intent)localObject2).putExtra("verify", getLocalVerify(paramString, false));
      MobileQQ.getMobileQQ().sendBroadcast((Intent)localObject2);
    }
  }
  
  private static String getLocalVerify(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(((Time)localObject).year);
    localStringBuilder.append(((Time)localObject).month + 1);
    localStringBuilder.append(((Time)localObject).monthDay);
    localStringBuilder.append(((Time)localObject).hour);
    if (paramBoolean) {
      localStringBuilder.append(((Time)localObject).minute - 1);
    } else {
      localStringBuilder.append(((Time)localObject).minute);
    }
    if (paramArrayList == null) {
      paramArrayList = "null";
    } else {
      paramArrayList = paramArrayList.toString();
    }
    localStringBuilder.append(paramArrayList);
    paramArrayList = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramArrayList);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return MD5.toMD5(((StringBuilder)localObject).toString());
  }
  
  static void registerAccountReceiverIfNeccessary()
  {
    IntentFilter localIntentFilter;
    if (sAccountReceiver == null)
    {
      sAccountReceiver = new IPluginProxyComponent.AccountReceiver();
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mqq.intent.action.EXIT_");
      localStringBuilder.append(MobileQQ.getMobileQQ().getPackageName());
      localIntentFilter.addAction(localStringBuilder.toString());
    }
    try
    {
      MobileQQ.getMobileQQ().registerReceiver(sAccountReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
  
  static void unregisterAccountReceiverIfNeccessary()
  {
    if (sAccountReceiver != null)
    {
      MobileQQ.getMobileQQ().unregisterReceiver(sAccountReceiver);
      sAccountReceiver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IPluginProxyComponent
 * JD-Core Version:    0.7.0.1
 */