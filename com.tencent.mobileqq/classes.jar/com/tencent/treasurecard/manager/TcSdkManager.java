package com.tencent.treasurecard.manager;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.treasurecard.api.ITcSdkContext;
import com.tencent.treasurecard.api.ITcSdkContext.OnCardStateChangeListener;
import com.tencent.treasurecard.common.NetworkReceiver;
import com.tencent.treasurecard.net.INetCallBack;
import com.tencent.treasurecard.net.INetRequest;
import com.tencent.xaction.log.QLog;

public class TcSdkManager
  implements ITcSdkContext
{
  private static ITcSdkContext jdField_a_of_type_ComTencentTreasurecardApiITcSdkContext;
  private Context jdField_a_of_type_AndroidContentContext;
  private ITcSdkContext.OnCardStateChangeListener jdField_a_of_type_ComTencentTreasurecardApiITcSdkContext$OnCardStateChangeListener;
  public NetworkReceiver a;
  public CacheManager a;
  public NetManager a;
  
  public static ITcSdkContext a()
  {
    if (jdField_a_of_type_ComTencentTreasurecardApiITcSdkContext == null) {
      try
      {
        if (jdField_a_of_type_ComTencentTreasurecardApiITcSdkContext == null) {
          jdField_a_of_type_ComTencentTreasurecardApiITcSdkContext = new TcSdkManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentTreasurecardApiITcSdkContext;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ITcSdkContext.OnCardStateChangeListener localOnCardStateChangeListener = this.jdField_a_of_type_ComTencentTreasurecardApiITcSdkContext$OnCardStateChangeListener;
    if (localOnCardStateChangeListener != null) {
      localOnCardStateChangeListener.a(paramInt1, paramInt2);
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.a("TcSdkManager", 1, "SDK init error, Context is must", null);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentTreasurecardManagerCacheManager = new CacheManager();
    this.jdField_a_of_type_ComTencentTreasurecardManagerNetManager = new NetManager();
    paramContext = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    this.jdField_a_of_type_ComTencentTreasurecardCommonNetworkReceiver = new NetworkReceiver();
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentTreasurecardCommonNetworkReceiver, paramContext);
  }
  
  public void a(ITcSdkContext.OnCardStateChangeListener paramOnCardStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentTreasurecardApiITcSdkContext$OnCardStateChangeListener = paramOnCardStateChangeListener;
  }
  
  public void a(INetCallBack paramINetCallBack)
  {
    NetManager localNetManager = this.jdField_a_of_type_ComTencentTreasurecardManagerNetManager;
    if (localNetManager != null) {
      localNetManager.a(paramINetCallBack);
    }
  }
  
  public void a(INetRequest paramINetRequest)
  {
    NetManager localNetManager = this.jdField_a_of_type_ComTencentTreasurecardManagerNetManager;
    if (localNetManager != null) {
      localNetManager.a(paramINetRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.treasurecard.manager.TcSdkManager
 * JD-Core Version:    0.7.0.1
 */