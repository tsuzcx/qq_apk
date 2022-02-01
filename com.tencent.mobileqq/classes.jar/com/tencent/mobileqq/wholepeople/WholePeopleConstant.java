package com.tencent.mobileqq.wholepeople;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class WholePeopleConstant
{
  public static String a = "com.qq.hotact";
  
  public static BusinessInfoCheckUpdate.AppInfo a(int paramInt1, int paramInt2)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = new BusinessInfoCheckUpdate.AppInfo();
    if (QLog.isColorLevel()) {
      QLog.i("WholePeopleConstant", 2, "getMsgRedTouch redNum:" + paramInt1 + " redPoint:" + paramInt2);
    }
    if ((paramInt1 <= 0) && (paramInt2 <= 0)) {
      return localAppInfo;
    }
    if (paramInt1 > 0)
    {
      localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      if (paramInt1 > 99) {
        localRedTypeInfo.red_content.set("99+");
      }
      for (;;)
      {
        localRedTypeInfo.red_type.set(5);
        localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
        localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
        localAppInfo.iNewFlag.set(1);
        return localAppInfo;
        localRedTypeInfo.red_content.set(String.valueOf(paramInt1));
      }
    }
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(0);
    localRedTypeInfo.red_desc.set("");
    localRedTypeInfo.red_content.set("");
    localAppInfo.red_display_info.red_type_info.add(localRedTypeInfo);
    localAppInfo.iNewFlag.set(1);
    return localAppInfo;
  }
  
  public static EIPCResult a(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WholePeopleConstant", 2, "clearMsgRedPoint");
    }
    paramString = null;
    Bundle localBundle = new Bundle();
    paramBundle = new EIPCResult();
    paramBundle.data = localBundle;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WholePeopleConstant", 2, "clearMsgRedPoint, app is null");
      }
      paramBundle.code = -1;
      return paramBundle;
    }
    ((LocalRedTouchManager)paramString.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(10014);
    paramBundle.code = 0;
    return paramBundle;
  }
  
  public static EIPCResult b(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WholePeopleConstant", 2, "getMsgRedPoint");
    }
    paramString = null;
    paramBundle = new Bundle();
    EIPCResult localEIPCResult = new EIPCResult();
    localEIPCResult.data = paramBundle;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WholePeopleConstant", 2, "getMsgRedPoint, app is null");
      }
      localEIPCResult.code = -1;
      return localEIPCResult;
    }
    paramString = (LocalRedTouchManager)paramString.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = paramString.a(10014);
    int i;
    if (paramString.a(localRedTouchItem, false)) {
      if (localRedTouchItem.redtouchType == 2)
      {
        i = localRedTouchItem.count + 0;
        paramInt = 0;
      }
    }
    for (;;)
    {
      paramBundle.putInt("redPointCount", paramInt);
      paramBundle.putInt("redNumCount", i);
      if (QLog.isColorLevel()) {
        QLog.i("WholePeopleConstant", 2, "getMsgRedPoint redPointCount:" + paramInt + " redNumCount:" + i);
      }
      localEIPCResult.code = 0;
      return localEIPCResult;
      paramInt = 1;
      i = 0;
      continue;
      paramInt = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wholepeople.WholePeopleConstant
 * JD-Core Version:    0.7.0.1
 */