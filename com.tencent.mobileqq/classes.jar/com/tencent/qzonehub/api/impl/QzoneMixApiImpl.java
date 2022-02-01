package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mobileqq.pluginsdk.IPluginActivity;
import com.tencent.qzonehub.api.IQzoneMixApi;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.SharpPDec;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import cooperation.qzone.util.QzonePublicAccountHelper;
import java.util.Map;
import mqq.app.QQPermissionCallback;

public class QzoneMixApiImpl
  implements IQzoneMixApi
{
  public void broadcastFollowIfNeed(Context paramContext, String paramString, int paramInt)
  {
    QzonePublicAccountHelper.broadcastFollowIfNeed(paramContext, paramString, paramInt);
  }
  
  public void execCtrlCommand(String paramString, int paramInt, Map<String, String> paramMap)
  {
    QZoneDistributedAppCtrl.Control localControl = new QZoneDistributedAppCtrl.Control();
    localControl.cmd = paramInt;
    localControl.data.putAll(paramMap);
    QZoneDistributedAppCtrl.getInstance(paramString).submitCtrl(localControl);
  }
  
  public int getVersion()
  {
    return SharpPDec.getVersion();
  }
  
  public int isSupportSharpP(Context paramContext)
  {
    return SharpPDec.isSupportSharpP(paramContext);
  }
  
  public boolean requestStoragePermission(Activity paramActivity, QQPermissionCallback paramQQPermissionCallback, int paramInt)
  {
    if (paramActivity == null) {
      return false;
    }
    if ((paramActivity instanceof QzonePluginProxyActivity))
    {
      if ((Build.VERSION.SDK_INT >= 23) && ((paramActivity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (paramActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)))
      {
        paramActivity = ((QzonePluginProxyActivity)paramActivity).getRealPluginActivity();
        if (paramActivity != null) {
          paramActivity.requestPermissions(paramQQPermissionCallback, paramInt, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        }
        return false;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneMixApiImpl
 * JD-Core Version:    0.7.0.1
 */