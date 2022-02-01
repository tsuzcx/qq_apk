package com.tencent.mobileqq.msgbackup.authentication;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.Builder;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class MsgBackupAuthProcessor
{
  public static final String a = MsgBackupAuthHandler.class.getName();
  private static MsgBackupAuthProcessor e;
  private int b;
  private String c;
  private String d;
  
  private MsgBackupAuthHandler a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return (MsgBackupAuthHandler)paramBaseQQAppInterface.getBusinessHandler(a);
  }
  
  public static MsgBackupAuthProcessor a()
  {
    if (e == null) {
      try
      {
        if (e == null) {
          e = new MsgBackupAuthProcessor();
        }
      }
      finally {}
    }
    return e;
  }
  
  private String[] a(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext != null)
    {
      paramContext = NetworkMonitor.getConnectionInfo(paramContext);
      arrayOfString[0] = paramContext.getSSID();
      arrayOfString[1] = paramContext.getBSSID();
    }
    return arrayOfString;
  }
  
  public void a(int paramInt)
  {
    MsgBackupReporter.a();
    MsgBackupReporter.a.a = paramInt;
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = a(BaseApplication.getContext());
    Object localObject1 = new MsgBackupUserData.Builder();
    ((MsgBackupUserData.Builder)localObject1).c(localObject2[1]);
    ((MsgBackupUserData.Builder)localObject1).b(localObject2[0]);
    localObject2 = new ArrayList(2);
    ((MsgBackupUserData.Builder)localObject1).a(MsgBackupTransportProcessor.a().f());
    ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().h()));
    ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().g()));
    ((MsgBackupUserData.Builder)localObject1).a(4);
    ((MsgBackupUserData.Builder)localObject1).a((List)localObject2);
    localObject1 = ((MsgBackupUserData.Builder)localObject1).a();
    a((BaseQQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime()).a((MsgBackupUserData)localObject1, this.b, paramBoolean);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requestQR, userData: ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(", biztype = ");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(", ispush = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void b()
  {
    Object localObject2 = a(BaseApplication.getContext());
    Object localObject1 = new MsgBackupUserData.Builder();
    ((MsgBackupUserData.Builder)localObject1).c(localObject2[1]);
    ((MsgBackupUserData.Builder)localObject1).b(localObject2[0]);
    localObject2 = new ArrayList(2);
    int i = this.b;
    if (i == 1)
    {
      ((MsgBackupUserData.Builder)localObject1).a(MsgBackupTransportProcessor.a().f());
      ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().h()));
      ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().g()));
    }
    else if (i == 2)
    {
      ((MsgBackupUserData.Builder)localObject1).a(MsgBackupTransportProcessor.a().c());
      ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().e()));
      ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().d()));
    }
    else
    {
      ((MsgBackupUserData.Builder)localObject1).a(MsgBackupTransportProcessor.a().c());
      ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().e()));
      ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().d()));
    }
    ((MsgBackupUserData.Builder)localObject1).a(4);
    ((MsgBackupUserData.Builder)localObject1).a((List)localObject2);
    localObject1 = ((MsgBackupUserData.Builder)localObject1).a();
    a((BaseQQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime()).a((MsgBackupUserData)localObject1, this.c, this.b);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("confirmQrReq, userData: ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(", biztype = ");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(", qr_sig = ");
      ((StringBuilder)localObject2).append(this.c);
      QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor
 * JD-Core Version:    0.7.0.1
 */