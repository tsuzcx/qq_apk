package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.source.QQGuildJumpSource;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.guild.util.QQJoinGuildHelper;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class QQGuildServiceImpl
  implements IQQGuildService
{
  private AppRuntime mAppRuntime;
  private HashMap<String, List<String>> mCollapseGuildMap = new HashMap();
  
  public void addGuild(Context paramContext, String paramString1, String paramString2, int paramInt, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    QQJoinGuildHelper.a(this.mAppRuntime, paramContext, paramString1, paramString2, paramInt, paramIResultWithSecurityCallback);
  }
  
  public void addGuildAndJump2AIO(Context paramContext, String paramString1, String paramString2, int paramInt, @Nullable String paramString3, Bundle paramBundle)
  {
    QQJoinGuildHelper.a(this.mAppRuntime, paramContext, paramString1, paramString2, paramInt, paramString3, paramBundle);
  }
  
  public Drawable getAvatarDrawable(String paramString)
  {
    Drawable localDrawable = BaseImageUtil.j();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    try
    {
      paramString = ((IGPSService)this.mAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString);
      if ((paramString != null) && (paramString.getAvatarUrl(0) != null))
      {
        paramString = URLDrawable.getDrawable(paramString.getAvatarUrl(0), localURLDrawableOptions);
        int i = BaseApplication.getContext().getResources().getDimensionPixelSize(2131297583);
        paramString.setTag(new int[] { i, i });
        paramString.setDecodeHandler(QQGuildUtil.b);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("QQGuildServiceImpl", 1, paramString, new Object[0]);
    }
    return localDrawable;
  }
  
  public Drawable getAvatarDrawable(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(QQGuildUIUtil.a(paramBoolean));
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localBitmapDrawable;
    localURLDrawableOptions.mFailedDrawable = localBitmapDrawable;
    localURLDrawableOptions.mMemoryCacheKeySuffix = paramString2;
    try
    {
      paramString1 = ((IGPSService)this.mAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString1);
      if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1.getAvatarUrl(paramInt))))
      {
        paramString1 = URLDrawable.getDrawable(paramString1.getAvatarUrl(paramInt), localURLDrawableOptions);
        paramString1.setTag(new int[] { paramInt, paramInt });
        if (paramBoolean) {
          paramString1.setDecodeHandler(QQGuildUtil.b);
        }
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      QLog.e("QQGuildServiceImpl", 1, paramString1, new Object[0]);
    }
    return localBitmapDrawable;
  }
  
  public void globalSetJumpEntrance(int paramInt)
  {
    if (paramInt == 1)
    {
      QQGuildJumpSource.a(2);
      return;
    }
    if (paramInt == 5) {
      QQGuildJumpSource.a(4);
    }
  }
  
  public boolean isCategoryCollapse(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return false;
    }
    paramString1 = (List)this.mCollapseGuildMap.get(paramString1);
    if (paramString1 != null)
    {
      if (paramString1.size() == 0) {
        return false;
      }
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext()) {
        if (paramString2.equals((String)paramString1.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isCurrentGuildManager(AppInterface paramAppInterface, String paramString)
  {
    return QQGuildUtil.a(((IGPSService)paramAppInterface.getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString));
  }
  
  public boolean isWhiteUser()
  {
    return QQGuildUtil.a();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    this.mCollapseGuildMap.clear();
  }
  
  public void setCategoryCollapse(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Object localObject2 = (List)this.mCollapseGuildMap.get(paramString1);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (paramString2.equals((String)((Iterator)localObject2).next())) {
        ((Iterator)localObject2).remove();
      }
    }
    if (paramBoolean) {
      ((List)localObject1).add(paramString2);
    }
    this.mCollapseGuildMap.put(paramString1, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.QQGuildServiceImpl
 * JD-Core Version:    0.7.0.1
 */