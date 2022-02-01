package com.tencent.mobileqq.msgbackup.authentication;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.Builder;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class MsgBackupAuthProcessor
{
  private static MsgBackupAuthProcessor jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthProcessor;
  public static final String a;
  private int jdField_a_of_type_Int;
  private String b;
  private String c;
  
  static
  {
    jdField_a_of_type_JavaLangString = MsgBackupAuthHandler.class.getName();
  }
  
  private MsgBackupAuthHandler a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return (MsgBackupAuthHandler)paramBaseQQAppInterface.getBusinessHandler(jdField_a_of_type_JavaLangString);
  }
  
  public static MsgBackupAuthProcessor a()
  {
    if (jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthProcessor == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthProcessor == null) {
          jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthProcessor = new MsgBackupAuthProcessor();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthProcessor;
  }
  
  private String[] a(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    paramContext = (WifiManager)paramContext.getApplicationContext().getSystemService("wifi");
    if (paramContext != null)
    {
      paramContext = paramContext.getConnectionInfo();
      arrayOfString[0] = paramContext.getSSID();
      arrayOfString[1] = paramContext.getBSSID();
    }
    return arrayOfString;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a()
  {
    Object localObject2 = a(BaseApplication.getContext());
    Object localObject1 = new MsgBackupUserData.Builder();
    ((MsgBackupUserData.Builder)localObject1).c(localObject2[1]);
    ((MsgBackupUserData.Builder)localObject1).b(localObject2[0]);
    localObject2 = new ArrayList(2);
    int i = this.jdField_a_of_type_Int;
    if (i == 1)
    {
      ((MsgBackupUserData.Builder)localObject1).a(MsgBackupTransportProcessor.a().b());
      ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().d()));
      ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().c()));
    }
    else if (i == 2)
    {
      ((MsgBackupUserData.Builder)localObject1).a(MsgBackupTransportProcessor.a().a());
      ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().b()));
      ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().a()));
    }
    else
    {
      ((MsgBackupUserData.Builder)localObject1).a(MsgBackupTransportProcessor.a().a());
      ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().b()));
      ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().a()));
    }
    ((MsgBackupUserData.Builder)localObject1).a(4);
    ((MsgBackupUserData.Builder)localObject1).a((List)localObject2);
    localObject1 = ((MsgBackupUserData.Builder)localObject1).a();
    a((BaseQQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime()).a((MsgBackupUserData)localObject1, this.b, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("confirmQrReq, userData: ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(", biztype = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append(", qr_sig = ");
      ((StringBuilder)localObject2).append(this.b);
      QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(int paramInt)
  {
    MsgBackupReporter.a();
    MsgBackupReporter.a.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = a(BaseApplication.getContext());
    Object localObject1 = new MsgBackupUserData.Builder();
    ((MsgBackupUserData.Builder)localObject1).c(localObject2[1]);
    ((MsgBackupUserData.Builder)localObject1).b(localObject2[0]);
    localObject2 = new ArrayList(2);
    ((MsgBackupUserData.Builder)localObject1).a(MsgBackupTransportProcessor.a().b());
    ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().d()));
    ((List)localObject2).add(Integer.valueOf(MsgBackupTransportProcessor.a().c()));
    ((MsgBackupUserData.Builder)localObject1).a(4);
    ((MsgBackupUserData.Builder)localObject1).a((List)localObject2);
    localObject1 = ((MsgBackupUserData.Builder)localObject1).a();
    a((BaseQQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime()).a((MsgBackupUserData)localObject1, this.jdField_a_of_type_Int, paramBoolean);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requestQR, userData: ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(", biztype = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject2).append(", ispush = ");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d("MsgBackup.MsgBackupAuthProcessor", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor
 * JD-Core Version:    0.7.0.1
 */