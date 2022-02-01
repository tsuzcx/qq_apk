package com.tencent.mobileqq.colornote.launcher;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleLaunchParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class MiniAppLauncher
  implements ILauncher
{
  private int a(String paramString)
  {
    if ((paramString != null) && (paramString.contains("最近浏览"))) {
      return 1132;
    }
    return 1131;
  }
  
  private void a(Context paramContext, String paramString)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startAppByAppid(paramContext, paramString, "", "", 1131, null);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("startMiniAppByAppId, appId: ");
      paramContext.append(paramString);
      QLog.d("MiniAppLauncher_colorNote", 2, paramContext.toString());
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString3 = SimpleMiniAppConfig.SimpleLaunchParam.standardEntryPath(paramString3);
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startAppByAppid(paramContext, paramString1, paramString3, paramString2, paramInt, null);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("startMiniApp, appId: ");
      paramContext.append(paramString1);
      paramContext.append(", entryPath: ");
      paramContext.append(paramString3);
      paramContext.append(", versionType: ");
      paramContext.append(paramString2);
      paramContext.append(", colorSignScene: ");
      paramContext.append(paramInt);
      QLog.d("MiniAppLauncher_colorNote", 2, paramContext.toString());
    }
  }
  
  public int getType()
  {
    return 16842752;
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    if (paramColorNote.getServiceType() != 16842752) {
      return;
    }
    int i = a(paramColorNote.getSubTitle());
    Object localObject1 = paramColorNote.getSubType();
    Object localObject2;
    if (((String)localObject1).contains("#@#"))
    {
      localObject2 = ((String)localObject1).split("#@#");
      if (localObject2.length == 2)
      {
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramColorNote = paramColorNote.getReserve();
        if ((paramColorNote != null) && (paramColorNote.length > 0)) {
          paramColorNote = new String(paramColorNote);
        } else {
          paramColorNote = null;
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportColorSignClickAndStartMiniApp(paramContext, (String)localObject1, paramColorNote, (String)localObject2, i);
      }
    }
    else if (((String)localObject1).contains("###"))
    {
      localObject1 = ((String)localObject1).split("###");
      if (localObject1.length == 2)
      {
        paramColorNote = localObject1[0];
        localObject1 = localObject1[1];
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportColorSignClickAndStartMiniApp(paramContext, paramColorNote, null, (String)localObject1, i);
      }
    }
    else if (((String)localObject1).contains("."))
    {
      localObject2 = ((String)localObject1).split("\\.");
      if (localObject2.length == 2)
      {
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        paramColorNote = paramColorNote.getReserve();
        if ((paramColorNote != null) && (paramColorNote.length > 0)) {
          paramColorNote = new String(paramColorNote);
        } else {
          paramColorNote = null;
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportColorSignClickWithNoAppInfo(i);
        a(paramContext, (String)localObject1, (String)localObject2, paramColorNote, i);
      }
    }
    else
    {
      a(paramContext, (String)localObject1);
    }
  }
  
  public void onCreate(Context paramContext, ColorNote paramColorNote, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.launcher.MiniAppLauncher
 * JD-Core Version:    0.7.0.1
 */