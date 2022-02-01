package com.tencent.mobileqq.identification;

import android.content.Context;
import android.os.Bundle;
import com.dataline.util.DBNetworkUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class FaceAreaManager
{
  private static volatile FaceAreaManager b;
  protected int a;
  private String c;
  
  public static FaceAreaManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new FaceAreaManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  protected LoginVerifyObserver a(LoginVerifyObserver paramLoginVerifyObserver)
  {
    return new FaceAreaManager.1(this, paramLoginVerifyObserver);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, LoginVerifyObserver paramLoginVerifyObserver)
  {
    QLog.d("FaceContext", 1, "start refreshIpStateOnSubProcess");
    Bundle localBundle = new Bundle();
    localBundle.putString("method", paramString2);
    localBundle.putInt("srcAppId", paramInt);
    localBundle.putString("uin", paramString1);
    a(localBundle, paramLoginVerifyObserver);
  }
  
  protected void a(int paramInt, byte[] paramArrayOfByte, long paramLong, BusinessObserver paramBusinessObserver)
  {
    LoginVerifyServlet.a(paramInt, paramArrayOfByte, paramLong, paramBusinessObserver);
  }
  
  protected void a(Bundle paramBundle, LoginVerifyObserver paramLoginVerifyObserver)
  {
    QIPCClientHelper.getInstance().callServer("IdentificationIpcServer_Model", "action_face_usable", paramBundle, new FaceAreaManager.2(this, paramLoginVerifyObserver));
  }
  
  protected void a(EIPCResult paramEIPCResult, LoginVerifyObserver paramLoginVerifyObserver)
  {
    int i = 11;
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null))
    {
      if (paramEIPCResult.code == 0)
      {
        boolean bool = paramEIPCResult.data.getBoolean("usable", false);
        if (!bool) {
          i = 10;
        }
        this.a = i;
        paramLoginVerifyObserver.ipJudgeSuccess(bool, paramEIPCResult.data.getString("msg"));
        return;
      }
      if (paramEIPCResult.code == -102)
      {
        this.a = 11;
        i = paramEIPCResult.data.getInt("code");
        paramLoginVerifyObserver.onFailedResponse(paramEIPCResult.data.getString("cmd"), i, paramEIPCResult.data.getString("msg"));
        return;
      }
      this.a = 11;
      QLog.e("FaceContext", 1, new Object[] { "refreshIpStateOnSubProcess error, unknown code : ", Integer.valueOf(paramEIPCResult.code) });
      paramLoginVerifyObserver.onFailedResponse(null, -1, "unknown code");
      return;
    }
    this.a = 11;
    QLog.e("FaceContext", 1, "refreshIpStateOnSubProcess error, eipcResult is null or data is null");
    paramLoginVerifyObserver.onFailedResponse(null, -1, "eipcResult is null");
  }
  
  protected void a(AppRuntime paramAppRuntime, int paramInt, BusinessObserver paramBusinessObserver)
  {
    LoginVerifyServlet.a(paramAppRuntime, paramInt, paramBusinessObserver);
  }
  
  public void a(AppRuntime paramAppRuntime, Context paramContext, int paramInt, String paramString, LoginVerifyObserver paramLoginVerifyObserver)
  {
    a(paramAppRuntime, paramContext, paramInt, paramString, null, paramLoginVerifyObserver);
  }
  
  public void a(AppRuntime paramAppRuntime, Context paramContext, int paramInt, String paramString1, String paramString2, LoginVerifyObserver paramLoginVerifyObserver)
  {
    paramLoginVerifyObserver = a(paramLoginVerifyObserver);
    QLog.d("FaceContext", 1, "start refreshIpState");
    if (IdentificationConstant.b.contains(paramString1))
    {
      a(paramAppRuntime, paramInt, paramLoginVerifyObserver);
      return;
    }
    if (IdentificationConstant.d.contains(paramString1))
    {
      paramContext = b();
      paramAppRuntime = null;
      if (IPAddressUtil.isIPv4LiteralAddress(paramContext))
      {
        paramAppRuntime = IPAddressUtil.textToNumericFormatV4(paramContext);
        QLog.d("FaceContext", 1, "v4");
      }
      else if (IPAddressUtil.isIPv6LiteralAddress(paramContext))
      {
        paramAppRuntime = IPAddressUtil.textToNumericFormatV6(paramContext);
        QLog.e("FaceContext", 1, "v6");
      }
      paramContext = paramAppRuntime;
      if (paramAppRuntime == null) {
        paramContext = new byte[0];
      }
      long l1 = 0L;
      if (paramString2 != null) {}
      try
      {
        long l2 = Long.parseLong(paramString2);
        l1 = l2;
      }
      catch (Exception paramAppRuntime)
      {
        for (;;)
        {
          QLog.d("FaceContext", 1, new Object[] { "parse uin error, ", paramAppRuntime.getMessage() });
        }
      }
      a(paramInt, paramContext, l1, paramLoginVerifyObserver);
    }
  }
  
  protected String b()
  {
    return DBNetworkUtil.a(false);
  }
  
  public IFaceAreaStrategy c()
  {
    int i = this.a;
    if ((i != 11) && (i != 0))
    {
      if (i == 10)
      {
        this.c = HardCodeUtil.a(2131896906);
        return new UnusableAreaStrategy(this.c);
      }
      QLog.d("FaceContext", 1, new Object[] { "unknown usable state : ", Integer.valueOf(i) });
      return null;
    }
    return new UsableAreaStrategy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceAreaManager
 * JD-Core Version:    0.7.0.1
 */