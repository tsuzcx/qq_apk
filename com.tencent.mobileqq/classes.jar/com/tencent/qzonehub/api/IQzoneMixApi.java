package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import mqq.app.QQPermissionCallback;

@QAPI(process={"all"})
public abstract interface IQzoneMixApi
  extends QRouteApi
{
  public static final int CLOSE_SHARPP = 0;
  public static final String KEY_CTRL_CMD = "key_ctrl_cmd";
  public static final String KEY_DESC = "key_desc";
  public static final int NOT_SUPPORT_SHARPP = 0;
  public static final int OPEN_SHARPP = 1;
  public static final int SUPPORT_SHARPP = 1;
  
  public abstract void broadcastFollowIfNeed(Context paramContext, String paramString, int paramInt);
  
  public abstract void execCtrlCommand(String paramString, int paramInt, Map<String, String> paramMap);
  
  public abstract int getVersion();
  
  public abstract int isSupportSharpP(Context paramContext);
  
  public abstract boolean requestStoragePermission(Activity paramActivity, QQPermissionCallback paramQQPermissionCallback, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzoneMixApi
 * JD-Core Version:    0.7.0.1
 */