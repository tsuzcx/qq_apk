package com.tencent.treasurecard.common;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.content.ContextCompat;
import com.tencent.treasurecard.api.ITcSdkContext;
import com.tencent.treasurecard.bean.TreasureCard;
import com.tencent.treasurecard.manager.CacheManager;
import com.tencent.treasurecard.manager.NetManager;
import com.tencent.treasurecard.manager.TcSdkManager;
import com.tencent.xaction.log.QLog;

public class NetworkReceiver
  extends BroadcastReceiver
{
  private long a = 0L;
  private long b = 0L;
  
  @SuppressLint({"MissingPermission"})
  private void a(Context paramContext, TcSdkManager paramTcSdkManager)
  {
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    paramContext = ((ConnectivityManager)localObject).getNetworkInfo(0);
    localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
    if ((localObject != null) && (paramContext != null))
    {
      boolean bool1 = ((NetworkInfo)localObject).isConnected();
      boolean bool2 = paramContext.isConnected();
      if ((bool1) && (!bool2) && (a()))
      {
        paramTcSdkManager.a(1001, paramTcSdkManager.c().a().a);
        return;
      }
      if ((!bool1) && (bool2) && (b())) {
        paramTcSdkManager.d().a(null);
      }
      return;
    }
    if (b()) {
      paramTcSdkManager.d().a(null);
    }
  }
  
  public boolean a()
  {
    long l = System.currentTimeMillis();
    if (l - this.a < 2000L) {
      return false;
    }
    this.a = l;
    return true;
  }
  
  public boolean b()
  {
    long l = System.currentTimeMillis();
    if (l - this.b < 2000L) {
      return false;
    }
    this.b = l;
    return true;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      ITcSdkContext localITcSdkContext = TcSdkManager.b();
      if (!(localITcSdkContext instanceof TcSdkManager)) {
        return;
      }
      if (ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE") != 0)
      {
        QLog.a("TcSdkManager", 1, "net permission denied", null);
        return;
      }
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        a(paramContext, (TcSdkManager)localITcSdkContext);
        return;
      }
    }
    catch (Exception paramContext)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("error:");
      paramIntent.append(paramContext.getMessage());
      QLog.a("TcSdkManager", 1, paramIntent.toString(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.treasurecard.common.NetworkReceiver
 * JD-Core Version:    0.7.0.1
 */