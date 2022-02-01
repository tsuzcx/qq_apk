package com.tencent.mobileqq.qqgift.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class QQGiftImageUtil
{
  public static Drawable a(Context paramContext)
  {
    return paramContext.getResources().getDrawable(2130847979);
  }
  
  public static GradientDrawable a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(paramInt4);
    localGradientDrawable.setCornerRadius(paramInt2);
    localGradientDrawable.setStroke(paramInt1, paramInt3);
    return localGradientDrawable;
  }
  
  public static URLDrawable a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getDrawable url:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("QQGiftImageUtil", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramDrawable1;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramDrawable2;
      if (a(paramString)) {
        return URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      }
      paramString = URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      return paramString;
    }
    catch (Throwable paramString)
    {
      label72:
      break label72;
    }
    return null;
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://")) || (paramString.startsWith("http://")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.QQGiftImageUtil
 * JD-Core Version:    0.7.0.1
 */