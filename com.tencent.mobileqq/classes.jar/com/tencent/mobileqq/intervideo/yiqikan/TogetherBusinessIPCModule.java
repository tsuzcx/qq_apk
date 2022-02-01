package com.tencent.mobileqq.intervideo.yiqikan;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class TogetherBusinessIPCModule
  extends QIPCModule
{
  private static volatile TogetherBusinessIPCModule a;
  
  public TogetherBusinessIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static TogetherBusinessIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new TogetherBusinessIPCModule("TogetherBusinessIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("call TogetherBusinessIPCModule action=");
      localStringBuilder.append(paramString);
      QLog.d("TogetherBusinessIPCModule", 2, localStringBuilder.toString());
    }
    if ("action_open_identify".equals(paramString))
    {
      TogetherBusinessServlet.a("QQAIOMediaSvc.open_identify", (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle, new TogetherBusinessIPCModule.TogetherObserver(this, paramInt));
      return null;
    }
    if ("action_open_start".equals(paramString))
    {
      TogetherBusinessServlet.a("QQAIOMediaSvc.open_start", (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle, new TogetherBusinessIPCModule.TogetherObserver(this, paramInt));
      return null;
    }
    if ("action_set_floating".equals(paramString))
    {
      boolean bool1 = paramBundle.getBoolean("BUNDLE_SET_STATUS");
      paramString = paramBundle.getString("BUNDLE_SET_KEY_UIN", "");
      paramInt = paramBundle.getInt("BUNDLE_SET_KEY_SESSION_TYPE", -1);
      boolean bool2 = paramBundle.getBoolean("BUNDLE_SET_KEY_REFRESH_UI", true);
      TogetherWatchFloatingUtil.a(bool1, paramString, paramInt, bool2);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder("ACTION_SET_FLOATING ");
        paramBundle.append(" isShow=");
        paramBundle.append(bool1);
        paramBundle.append(" uin=");
        paramBundle.append(paramString);
        paramBundle.append(" sessionType=");
        paramBundle.append(paramInt);
        paramBundle.append(" refresh=");
        paramBundle.append(bool2);
        QLog.d("TogetherBusinessIPCModule", 2, paramBundle.toString());
      }
      if (!bool2) {
        return null;
      }
      paramBundle = (TogetherControlManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
      paramString = (WatchTogetherSession)paramBundle.a(2, paramInt, paramString);
      if (paramString != null) {
        paramBundle.a(true, paramString, 1002, "");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.TogetherBusinessIPCModule
 * JD-Core Version:    0.7.0.1
 */