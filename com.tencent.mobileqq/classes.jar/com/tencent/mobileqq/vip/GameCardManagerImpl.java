package com.tencent.mobileqq.vip;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.updatesystem.business.GameNamePlateBusiness;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

public class GameCardManagerImpl
  implements IGameCardManager
{
  @Nullable
  private URLDrawable a(IGameCardManager.GameCardInfo paramGameCardInfo, IGameCardManager.OnResultCallBack paramOnResultCallBack, ApngOptions paramApngOptions)
  {
    if ((paramGameCardInfo != null) && (paramOnResultCallBack != null))
    {
      if (paramApngOptions == null) {
        return null;
      }
      if (!a(paramGameCardInfo.f)) {
        return null;
      }
      paramGameCardInfo = getCardResPath(1, paramGameCardInfo.f);
      if (TextUtils.isEmpty(paramGameCardInfo)) {
        return null;
      }
      paramGameCardInfo = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramGameCardInfo, paramApngOptions, paramGameCardInfo);
      if (paramGameCardInfo == null) {
        return null;
      }
      paramOnResultCallBack.a(paramGameCardInfo);
      return paramGameCardInfo;
    }
    return null;
  }
  
  @Nullable
  private URLDrawable a(boolean paramBoolean, IGameCardManager.GameCardInfo paramGameCardInfo, IGameCardManager.OnResultCallBack paramOnResultCallBack, ApngOptions paramApngOptions)
  {
    Object localObject = VasUtil.c();
    if ((localObject != null) && (paramGameCardInfo != null) && (paramOnResultCallBack != null))
    {
      if (paramApngOptions == null) {
        return null;
      }
      String str = VipGrayConfigHelper.a().e;
      int k;
      if ((!TextUtils.isEmpty(paramGameCardInfo.b)) && (((AppRuntime)localObject).getCurrentUin().equals(paramGameCardInfo.b))) {
        k = 1;
      } else {
        k = 0;
      }
      SharedPreferences localSharedPreferences = ((AppRuntime)localObject).getApp().getSharedPreferences("sp_plate_of_king", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("plate_of_king_display_switch_");
      localStringBuilder.append(((AppRuntime)localObject).getCurrentUin());
      boolean bool = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
      int i;
      if ((!TextUtils.isEmpty(str)) && (paramGameCardInfo.c != 0L)) {
        i = 1;
      } else {
        i = 0;
      }
      int j = i;
      if (k != 0) {
        if ((i != 0) && ((bool) || (paramBoolean))) {
          j = 1;
        } else {
          j = 0;
        }
      }
      if (j == 0) {
        return null;
      }
      if (paramGameCardInfo.d == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(paramGameCardInfo.c);
        paramGameCardInfo = (IGameCardManager.GameCardInfo)localObject;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(paramGameCardInfo.c);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramGameCardInfo.d);
        paramGameCardInfo = (IGameCardManager.GameCardInfo)localObject;
      }
      paramGameCardInfo.append(".png");
      paramGameCardInfo = paramGameCardInfo.toString();
      paramGameCardInfo = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramGameCardInfo, paramApngOptions);
      if (paramGameCardInfo == null) {
        return null;
      }
      if ((paramGameCardInfo.getStatus() != 1) && (paramGameCardInfo.getStatus() != 0))
      {
        paramOnResultCallBack.d(paramGameCardInfo);
        return paramGameCardInfo;
      }
      paramOnResultCallBack.a(paramGameCardInfo);
      return paramGameCardInfo;
    }
    return null;
  }
  
  private String a(String paramString)
  {
    Object localObject = VasUtil.c();
    if (localObject == null) {
      return null;
    }
    localObject = (IFeatureRuntimeService)((AppRuntime)localObject).getRuntimeService(IFeatureRuntimeService.class, "all");
    if (!((IFeatureRuntimeService)localObject).isFeatureSwitchEnable("gamecard_config_url")) {
      return null;
    }
    localObject = ((IFeatureRuntimeService)localObject).isEnabledWithDataSet("gamecard_config_url", "");
    if (localObject == null) {
      return null;
    }
    return (String)((Map)localObject).get(paramString);
  }
  
  private boolean a(int paramInt)
  {
    return checkGameCardAble(false, paramInt);
  }
  
  public boolean checkGameCardAble(boolean paramBoolean, int paramInt)
  {
    if ((!paramBoolean) && (paramInt <= 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("new_game_card Switch close:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("GameNameplateManager", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    Object localObject = VasUtil.c();
    if (localObject == null) {
      return false;
    }
    paramBoolean = ((IFeatureRuntimeService)((AppRuntime)localObject).getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("gamecard_config_url");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("new_game_card Switch ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("GameNameplateManager", 2, ((StringBuilder)localObject).toString());
    }
    return paramBoolean;
  }
  
  public String getCardResPath(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("55.");
    ((StringBuilder)localObject).append(paramInt2);
    String str = ((StringBuilder)localObject).toString();
    GameNamePlateBusiness localGameNamePlateBusiness = (GameNamePlateBusiness)QQVasUpdateBusinessUtil.a(GameNamePlateBusiness.class);
    if (localGameNamePlateBusiness == null) {
      return "";
    }
    localObject = null;
    if (paramInt1 != 1)
    {
      if (paramInt1 == 2) {
        localObject = localGameNamePlateBusiness.b(str);
      }
    }
    else {
      localObject = localGameNamePlateBusiness.a(str);
    }
    if (localGameNamePlateBusiness.c(str)) {
      return localObject;
    }
    localGameNamePlateBusiness.startDownload(str);
    return "";
  }
  
  public URLDrawable getGameCardDrawable(boolean paramBoolean, IGameCardManager.GameCardInfo paramGameCardInfo, IGameCardManager.OnResultCallBack paramOnResultCallBack)
  {
    if ((paramGameCardInfo != null) && (paramOnResultCallBack != null))
    {
      Object localObject = new ApngOptions();
      ((ApngOptions)localObject).a(new GameCardManagerImpl.1(this, paramOnResultCallBack));
      if (paramGameCardInfo.e) {
        paramOnResultCallBack = a(paramBoolean, paramGameCardInfo, paramOnResultCallBack, (ApngOptions)localObject);
      } else {
        paramOnResultCallBack = a(paramGameCardInfo, paramOnResultCallBack, (ApngOptions)localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("new_game_card GetDrawable ");
        ((StringBuilder)localObject).append(paramGameCardInfo.toString());
        ((StringBuilder)localObject).append(" result:");
        if (paramOnResultCallBack != null) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("GameNameplateManager", 2, ((StringBuilder)localObject).toString());
      }
      return paramOnResultCallBack;
    }
    return null;
  }
  
  public void gotoGameIconSetWeb(Context paramContext, String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (!checkGameCardAble(paramBoolean, paramInt)) {
        return;
      }
      Object localObject1;
      if ((!isSelf(paramString)) && (!paramBoolean))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("np_active_url_");
        ((StringBuilder)localObject1).append(paramInt);
        localObject2 = a(((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = a("np_active_url_def");
        }
      }
      else
      {
        localObject1 = a("np_host_setting_url");
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("new_game_card GameJump ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("GameNameplateManager", 2, ((StringBuilder)localObject2).toString());
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      Object localObject2 = new Intent(paramContext, ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
      ((Intent)localObject2).putExtra("portraitOnly", true);
      ((Intent)localObject2).putExtra("uin", paramString);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      VasWebviewUtil.b(paramContext, (String)localObject1, 256L, (Intent)localObject2, false, -1);
    }
  }
  
  public void gotoKingIconSetWeb(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject2 = a("np_setting_url");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = IndividuationUrlHelper.a("gameIconSetupH5Url");
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("new_game_card KingJump ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("GameNameplateManager", 2, ((StringBuilder)localObject2).toString());
    }
    localObject2 = new Intent(paramContext, ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
    ((Intent)localObject2).setFlags(268435456);
    ((Intent)localObject2).putExtra("vasUsePreWebview", true);
    VasWebviewUtil.b(paramContext, (String)localObject1, -1L, (Intent)localObject2, false, -1);
  }
  
  public boolean isSelf(String paramString)
  {
    AppRuntime localAppRuntime = VasUtil.c();
    if (localAppRuntime == null) {
      return false;
    }
    return localAppRuntime.getCurrentUin().equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.GameCardManagerImpl
 * JD-Core Version:    0.7.0.1
 */