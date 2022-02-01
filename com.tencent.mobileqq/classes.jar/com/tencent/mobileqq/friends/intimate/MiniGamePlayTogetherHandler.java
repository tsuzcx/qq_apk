package com.tencent.mobileqq.friends.intimate;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class MiniGamePlayTogetherHandler
{
  public static void a(Context paramContext, INTERFACE.StApiAppInfo paramStApiAppInfo, String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramContext != null) && (paramStApiAppInfo != null) && (!TextUtils.isEmpty(paramStApiAppInfo.appId.get())))
    {
      if (paramBoolean)
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).createUpdatableMsg(paramStApiAppInfo.appId.get(), "657667B4D8C04B3F84E4AAA3D046A903", 1, 1, -1, paramString, 0, null, new MiniGamePlayTogetherHandler.1(paramContext, paramString));
        if (paramInt == 2064) {
          paramContext = "c2close";
        } else if (paramInt == 2062) {
          paramContext = "id_card";
        } else {
          paramContext = "page_view";
        }
        paramStApiAppInfo = new SimpleMiniAppConfig(SimpleMiniAppConfig.SimpleMiniAppInfo.from(paramStApiAppInfo));
        paramStApiAppInfo.launchParam.scene = paramInt;
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async(paramStApiAppInfo, paramContext, "click", null, null);
        return;
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(paramContext, paramStApiAppInfo.appId.get(), null, null, null, null, paramInt, null);
      return;
    }
    QLog.e("MiniGamePlayTogetherHandler", 1, new Object[] { "onPlayClick param error context:", paramContext, ", appInfo=", paramStApiAppInfo });
    if (paramContext != null)
    {
      paramContext = (Activity)paramContext;
      paramContext.runOnUiThread(new MiniGamePlayTogetherHandler.2(paramContext));
    }
  }
  
  public static boolean a(INTERFACE.StApiAppInfo paramStApiAppInfo)
  {
    if ((paramStApiAppInfo != null) && (paramStApiAppInfo.extInfo != null))
    {
      if (paramStApiAppInfo.extInfo.mapInfo == null) {
        return false;
      }
      int i = 0;
      while (i < paramStApiAppInfo.extInfo.mapInfo.size())
      {
        COMM.Entry localEntry = (COMM.Entry)paramStApiAppInfo.extInfo.mapInfo.get(i);
        if ((localEntry != null) && ("battle_attr".equals(localEntry.key.get()))) {
          return "1".equals(localEntry.value.get());
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.MiniGamePlayTogetherHandler
 * JD-Core Version:    0.7.0.1
 */