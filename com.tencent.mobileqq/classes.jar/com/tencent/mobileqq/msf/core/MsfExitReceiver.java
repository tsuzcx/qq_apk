package com.tencent.mobileqq.msf.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.format.Time;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class MsfExitReceiver
  extends BroadcastReceiver
{
  private static final String tag = "MsfExitReceiver";
  
  public MsfExitReceiver()
  {
    BaseApplication.getContext().registerReceiver(this, new IntentFilter("com.tencent.process.exit"));
  }
  
  public static String getLocalVerify(String paramString, boolean paramBoolean)
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
    localObject = paramString;
    if (paramString == null) {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    paramString = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return MD5.toMD5(((StringBuilder)localObject).toString());
  }
  
  private static boolean isLegalBroadcast(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString1.length() == 0) {
        return false;
      }
      if (!paramString1.equals(getLocalVerify(paramString2, false))) {
        return paramString1.equals(getLocalVerify(paramString2, true));
      }
      return true;
    }
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.process.exit".equals(paramIntent.getAction()))
    {
      String str = paramIntent.getExtras().getString("procName");
      if (str != null)
      {
        if (!str.equals(BaseApplication.processName)) {
          return;
        }
        if (isLegalBroadcast(paramIntent.getExtras().getString("verify"), str))
        {
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("recv kill msf broadcast from QQ, sRecvRegister=");
            paramIntent.append(MsfPullConfigUtil.sRecvRegister);
            paramIntent.append(", sRecvProxy=");
            paramIntent.append(MsfPullConfigUtil.sRecvProxy);
            QLog.d("MsfExitReceiver", 2, paramIntent.toString());
          }
          paramContext = paramContext.getSharedPreferences("crashcontrol", 4);
          int i = paramContext.getInt("countRecvKillMsf", 0);
          paramContext.edit().putInt("countRecvKillMsf", i + 1).commit();
          if ((MsfPullConfigUtil.sRecvRegister) || (MsfPullConfigUtil.sRecvProxy))
          {
            i = paramContext.getInt("countMsfRealExit", 0);
            paramContext.edit().putInt("countMsfRealExit", i + 1).commit();
            System.exit(0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.MsfExitReceiver
 * JD-Core Version:    0.7.0.1
 */