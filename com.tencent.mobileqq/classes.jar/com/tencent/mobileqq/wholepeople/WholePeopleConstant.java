package com.tencent.mobileqq.wholepeople;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.MessageMicro;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMsgRedTouch redNum:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" redPoint:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("WholePeopleConstant", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 <= 0) && (paramInt2 <= 0)) {
      return localAppInfo;
    }
    if (paramInt1 > 0)
    {
      localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
      if (paramInt1 > 99) {
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set("99+");
      } else {
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set(String.valueOf(paramInt1));
      }
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(5);
      ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("{'cn':'#FF0000'}");
      localAppInfo.red_display_info.red_type_info.add((MessageMicro)localObject);
      localAppInfo.iNewFlag.set(1);
      return localAppInfo;
    }
    Object localObject = new BusinessInfoCheckUpdate.RedTypeInfo();
    ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_type.set(0);
    ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_desc.set("");
    ((BusinessInfoCheckUpdate.RedTypeInfo)localObject).red_content.set("");
    localAppInfo.red_display_info.red_type_info.add((MessageMicro)localObject);
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
    ((LocalRedTouchManager)paramString.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).b(10014);
    paramBundle.code = 0;
    return paramBundle;
  }
  
  public static EIPCResult b(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WholePeopleConstant", 2, "getMsgRedPoint");
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
        QLog.d("WholePeopleConstant", 2, "getMsgRedPoint, app is null");
      }
      paramBundle.code = -1;
      return paramBundle;
    }
    paramString = (LocalRedTouchManager)paramString.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = paramString.a(10014);
    if (paramString.a(localRedTouchItem, false))
    {
      if (localRedTouchItem.redtouchType == 2)
      {
        paramInt = localRedTouchItem.count + 0;
        i = 0;
        break label153;
      }
      paramInt = 1;
    }
    else
    {
      paramInt = 0;
    }
    int j = 0;
    int i = paramInt;
    paramInt = j;
    label153:
    localBundle.putInt("redPointCount", i);
    localBundle.putInt("redNumCount", paramInt);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getMsgRedPoint redPointCount:");
      paramString.append(i);
      paramString.append(" redNumCount:");
      paramString.append(paramInt);
      QLog.i("WholePeopleConstant", 2, paramString.toString());
    }
    paramBundle.code = 0;
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.wholepeople.WholePeopleConstant
 * JD-Core Version:    0.7.0.1
 */