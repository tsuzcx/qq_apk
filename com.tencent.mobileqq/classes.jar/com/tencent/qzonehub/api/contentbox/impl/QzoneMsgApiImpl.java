package com.tencent.qzonehub.api.contentbox.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneRuntimeService;
import com.tencent.qzonehub.api.contentbox.IMQMsg;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import com.tencent.qzonehub.model.QZoneMsgEntityNew;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.contentbox.QZoneMsgActivity;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QzoneMsgApiImpl
  implements IQzoneMsgApi
{
  private static final String TAG = "QzoneMsgApi";
  
  private void launchContentBoxMiniProgram(long paramLong, Context paramContext)
  {
    if (TextUtils.isEmpty(String.valueOf(paramLong)))
    {
      QZLog.e("QzoneMsgApi", "empty mini prog appid");
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(paramContext, String.valueOf(paramLong), null, null, null, null, 2009, null);
  }
  
  public void likeFeed(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    if (localAppRuntime == null)
    {
      QLog.e("QzoneMsgApi", 1, "appRuntime is null");
      return;
    }
    paramAppRuntime = (IQzoneRuntimeService)localAppRuntime.getRuntimeService(IQzoneRuntimeService.class, "all");
    if (paramAppRuntime != null) {
      paramAppRuntime.likeFeed(paramString, paramInt, paramBoolean, paramLong);
    }
  }
  
  public ArrayList<QZoneMsgEntityNew> loadMsgFromDB(AppRuntime paramAppRuntime)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    if (localAppRuntime == null)
    {
      QLog.e("QzoneMsgApi", 1, "appRuntime is null");
      return null;
    }
    paramAppRuntime = (IQzoneRuntimeService)localAppRuntime.getRuntimeService(IQzoneRuntimeService.class, "all");
    if (paramAppRuntime != null) {
      return paramAppRuntime.loadMsgFromDB();
    }
    return null;
  }
  
  public boolean open(Context paramContext, AppRuntime paramAppRuntime)
  {
    return QZoneMsgActivity.open(paramContext, paramAppRuntime);
  }
  
  public boolean openContentBox(Context paramContext)
  {
    if (paramContext == null)
    {
      QLog.e("QzoneMsgApi", 1, "activity is null");
      return false;
    }
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null)
    {
      QLog.e("QzoneMsgApi", 1, "appRuntime is null");
      return false;
    }
    localObject = (IQzoneRuntimeService)((AppRuntime)localObject).getRuntimeService(IQzoneRuntimeService.class, "all");
    int i;
    if ((localObject != null) && (((IQzoneRuntimeService)localObject).isEnableQZoneContextBox())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      long l = QZoneHelper.enableQZoneContentBoxMiniProgram();
      if (l != 0L)
      {
        launchContentBoxMiniProgram(l, paramContext);
        return true;
      }
      localObject = new Intent(paramContext, QZoneMsgActivity.class);
      ((Intent)localObject).addFlags(67108864);
      paramContext.startActivity((Intent)localObject);
      return true;
    }
    return false;
  }
  
  public void preloadData(AppRuntime paramAppRuntime)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    if (localAppRuntime == null)
    {
      QLog.e("QzoneMsgApi", 1, "appRuntime is null");
      return;
    }
    paramAppRuntime = (IQzoneRuntimeService)localAppRuntime.getRuntimeService(IQzoneRuntimeService.class, "all");
    if (paramAppRuntime != null) {
      paramAppRuntime.preloadContentBox();
    }
  }
  
  public void refreshQzoneMsg(AppRuntime paramAppRuntime)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    if (localAppRuntime == null)
    {
      QLog.e("QzoneMsgApi", 1, "appRuntime is null");
      return;
    }
    paramAppRuntime = (IQzoneRuntimeService)localAppRuntime.getRuntimeService(IQzoneRuntimeService.class, "all");
    if (paramAppRuntime != null) {
      paramAppRuntime.refreshQzoneMsg();
    }
  }
  
  public void saveMsgToDB(AppRuntime paramAppRuntime, IMQMsg paramIMQMsg)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    if (localAppRuntime == null)
    {
      QLog.e("QzoneMsgApi", 1, "appRuntime is null");
      return;
    }
    paramAppRuntime = (IQzoneRuntimeService)localAppRuntime.getRuntimeService(IQzoneRuntimeService.class, "all");
    if (paramAppRuntime != null) {
      paramAppRuntime.saveMsgToDB(paramIMQMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.contentbox.impl.QzoneMsgApiImpl
 * JD-Core Version:    0.7.0.1
 */