package com.tencent.mobileqq.studymode;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class StudyModeIpcServer
  extends QIPCModule
{
  public static StudyModeIpcServer a;
  private int b;
  private KidModeObserver c = new StudyModeIpcServer.1(this);
  
  private StudyModeIpcServer(String paramString)
  {
    super(paramString);
  }
  
  public static StudyModeIpcServer a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new StudyModeIpcServer("StudyModeIpcServer_model");
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ret", paramInt2);
    localBundle.putString("errMsg", paramString);
    localBundle.putBoolean("reset_null", true);
    callbackResult(paramInt1, EIPCResult.createResult(-102, localBundle));
  }
  
  private void a(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ret", 0);
    localBundle.putString("errMsg", paramString);
    localBundle.putBoolean("reset_null", false);
    callbackResult(paramInt, EIPCResult.createResult(0, localBundle));
  }
  
  private void a(Bundle paramBundle)
  {
    long l = paramBundle.getLong("nonce");
    paramBundle = paramBundle.getString("idKey", "");
    if ((!TextUtils.isEmpty(paramBundle)) && (l != 0L))
    {
      Object localObject = b();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        localObject = (QQAppInterface)localObject;
        ((QQAppInterface)localObject).registObserver(this.c);
        KidModeServlet.c((QQAppInterface)localObject, String.valueOf(l), paramBundle);
        return;
      }
      a(this.b, 1, "appRuntime err");
      return;
    }
    a(this.b, 1, "nonce or idKey null");
  }
  
  private AppRuntime b()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    this.b = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, callbackId =");
      localStringBuilder.append(paramInt);
      QLog.d("qqstudymode_server", 2, localStringBuilder.toString());
    }
    if ("clear_pwd".equals(paramString))
    {
      if (paramBundle == null)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCall, param is null, action=");
        paramBundle.append(paramString);
        paramBundle.append(", callBackId=");
        paramBundle.append(paramInt);
        QLog.d("qqstudymode_server", 1, paramBundle.toString());
        a(paramInt, 1, "no params");
        return null;
      }
      a(paramBundle);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeIpcServer
 * JD-Core Version:    0.7.0.1
 */