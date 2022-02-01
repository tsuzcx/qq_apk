package com.tencent.timi.game.teamlist.util;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.image.api.IDrawableService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;

public class URLDrawableUtil
{
  public static URLDrawable a(String paramString, float paramFloat1, float paramFloat2)
  {
    return a(paramString, null, paramFloat1, paramFloat2);
  }
  
  public static URLDrawable a(String paramString, Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      localObject = new URLDrawableUtil.1();
    }
    paramDrawable = URLDrawable.URLDrawableOptions.obtain();
    paramDrawable.mRequestWidth = ViewUtils.dpToPx(paramFloat1);
    paramDrawable.mRequestHeight = ViewUtils.dpToPx(paramFloat2);
    paramDrawable.mFailedDrawable = ((Drawable)localObject);
    paramDrawable.mLoadingDrawable = ((Drawable)localObject);
    try
    {
      paramDrawable = ((IDrawableService)ServiceCenter.a(IDrawableService.class)).a(paramString, paramDrawable);
      return paramDrawable;
    }
    catch (Exception paramDrawable)
    {
      label75:
      break label75;
    }
    paramDrawable = new StringBuilder();
    paramDrawable.append("URLDrawableUtil Loading fail");
    paramDrawable.append(paramString);
    Logger.c("URLDrawableUtil", paramDrawable.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.util.URLDrawableUtil
 * JD-Core Version:    0.7.0.1
 */