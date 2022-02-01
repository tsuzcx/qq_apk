package com.tencent.mobileqq.guild.api.impl;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQGuildAvatarApiImpl
  implements IQQGuildAvatarApi
{
  private Drawable getDrawable(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean)
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(QQGuildUIUtil.a(paramBoolean));
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localBitmapDrawable;
    localURLDrawableOptions.mFailedDrawable = localBitmapDrawable;
    localURLDrawableOptions.mMemoryCacheKeySuffix = paramString2;
    if (TextUtils.isEmpty(paramString1)) {
      return localBitmapDrawable;
    }
    try
    {
      paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
      paramString1.setTag(new int[] { paramInt1, paramInt2 });
      if (paramBoolean) {
        paramString1.setDecodeHandler(QQGuildUtil.b);
      }
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("QQGuildServiceImpl", 1, paramString1, new Object[0]);
    }
    return localBitmapDrawable;
  }
  
  public Drawable getAvatarDrawable(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return getDrawable(paramString1, paramInt1, paramInt2, paramString2, true);
  }
  
  public Drawable getAvatarDrawable(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = ViewUtils.dip2px(140.0F);
    if (paramInt == 0) {
      i = ViewUtils.dip2px(140.0F);
    } else if (paramInt == 1) {
      i = ViewUtils.dip2px(640.0F);
    }
    return getDrawable(paramString, i, i, "", paramBoolean);
  }
  
  public Drawable getAvatarDrawable(AppRuntime paramAppRuntime, GuildUserAvatar paramGuildUserAvatar, int paramInt)
  {
    if ((paramAppRuntime != null) && (paramGuildUserAvatar != null)) {
      return getAvatarDrawable(((IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "")).getFullAvatarUrl(paramGuildUserAvatar, paramInt), paramInt, true);
    }
    return BaseImageUtil.j();
  }
  
  public Drawable getAvatarDrawable(AppRuntime paramAppRuntime, String paramString)
  {
    return getAvatarDrawable(getAvatarUrl(paramAppRuntime, paramString), 0, true);
  }
  
  public String getAvatarUrl(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = (IGPSService)paramAppRuntime.getRuntimeService(IGPSService.class, "");
    paramString = paramAppRuntime.getGuildUsersAvatarUrl(paramString);
    if (paramString != null) {
      return paramAppRuntime.getFullAvatarUrl(paramString, 0);
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.QQGuildAvatarApiImpl
 * JD-Core Version:    0.7.0.1
 */