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
  boolean a = true;
  
  @SuppressLint({"MissingPermission"})
  private void a(Context paramContext, TcSdkManager paramTcSdkManager)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    NetworkInfo localNetworkInfo = paramContext.getNetworkInfo(0);
    boolean bool1 = paramContext.getNetworkInfo(1).isConnected();
    boolean bool2 = localNetworkInfo.isConnected();
    if ((this.a) && (bool1) && (!bool2))
    {
      paramContext = paramTcSdkManager.jdField_a_of_type_ComTencentTreasurecardManagerCacheManager.a();
      if (paramContext == null) {
        a(paramTcSdkManager);
      } else {
        paramTcSdkManager.a(0, paramContext.a);
      }
      this.a = false;
      return;
    }
    if ((!bool1) && (bool2)) {
      a(paramTcSdkManager);
    }
    this.a = true;
  }
  
  private void a(TcSdkManager paramTcSdkManager)
  {
    paramTcSdkManager.jdField_a_of_type_ComTencentTreasurecardManagerNetManager.a();
    if (paramTcSdkManager.jdField_a_of_type_ComTencentTreasurecardManagerNetManager.a()) {
      return;
    }
    paramTcSdkManager.jdField_a_of_type_ComTencentTreasurecardManagerNetManager.a(null);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ITcSdkContext localITcSdkContext = TcSdkManager.a();
    if (!(localITcSdkContext instanceof TcSdkManager)) {
      return;
    }
    if (!paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
      return;
    }
    if (ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE") == 0)
    {
      a(paramContext, (TcSdkManager)localITcSdkContext);
      return;
    }
    QLog.a("TcSdkManager", 1, "net permission denied", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.treasurecard.common.NetworkReceiver
 * JD-Core Version:    0.7.0.1
 */