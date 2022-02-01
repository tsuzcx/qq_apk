package com.tencent.mobileqq.colornote.launcher;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleLaunchParam;
import com.tencent.mobileqq.miniapp.MiniAppColorNoteData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

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
  
  private void a(int paramInt, MiniAppInfo paramMiniAppInfo)
  {
    IMiniAppService localIMiniAppService = (IMiniAppService)QRoute.api(IMiniAppService.class);
    if (paramInt == 1132)
    {
      if (paramMiniAppInfo != null)
      {
        localIMiniAppService.report4239AsyncBySdkMiniAppInfo(paramMiniAppInfo, "addRecentColorSign", "recentColorSign_enter", "click", null);
        return;
      }
      localIMiniAppService.report4239Async("addRecentColorSign", "recentColorSign_enter", "click", null, null, null);
      return;
    }
    if (paramMiniAppInfo != null)
    {
      localIMiniAppService.report4239AsyncBySdkMiniAppInfo(paramMiniAppInfo, "addColorSign", "colorSign_enter", "click", null);
      return;
    }
    localIMiniAppService.report4239Async("addColorSign", "colorSign_enter", "click", null, null, null);
  }
  
  private void a(Context paramContext, String paramString)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startAppByAppid(paramContext, paramString, "", "", 1131, null);
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher_colorNote", 2, "startMiniAppByAppId, appId: " + paramString);
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString3 = SimpleMiniAppConfig.SimpleLaunchParam.standardEntryPath(paramString3);
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startAppByAppid(paramContext, paramString1, paramString3, paramString2, paramInt, null);
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppLauncher_colorNote", 2, "startMiniApp, appId: " + paramString1 + ", entryPath: " + paramString3 + ", versionType: " + paramString2 + ", colorSignScene: " + paramInt);
    }
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    if (paramColorNote.getServiceType() != 16842752) {}
    int i;
    do
    {
      do
      {
        return;
        i = a(paramColorNote.getSubTitle());
        str = paramColorNote.getSubType();
        if (!str.contains("###")) {
          break;
        }
        localObject = str.split("###");
      } while (localObject.length != 2);
      str = localObject[0];
      localObject = localObject[1];
      paramColorNote = paramColorNote.getReserve();
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramColorNote, 0, paramColorNote.length);
      localParcel.setDataPosition(0);
      paramColorNote = (MiniAppColorNoteData)MiniAppColorNoteData.CREATOR.createFromParcel(localParcel);
      a(i, paramColorNote.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
      a(paramContext, str, (String)localObject, paramColorNote.jdField_a_of_type_JavaLangString, i);
      return;
      if (!str.contains(".")) {
        break;
      }
      localObject = str.split("\\.");
    } while (localObject.length != 2);
    String str = localObject[0];
    Object localObject = localObject[1];
    paramColorNote = paramColorNote.getReserve();
    if ((paramColorNote != null) && (paramColorNote.length > 0)) {}
    for (paramColorNote = new String(paramColorNote);; paramColorNote = null)
    {
      a(i, null);
      a(paramContext, str, (String)localObject, paramColorNote, i);
      return;
      a(paramContext, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.launcher.MiniAppLauncher
 * JD-Core Version:    0.7.0.1
 */