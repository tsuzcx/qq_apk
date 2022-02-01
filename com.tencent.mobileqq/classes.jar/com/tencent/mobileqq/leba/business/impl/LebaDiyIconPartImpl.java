package com.tencent.mobileqq.leba.business.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.config.business.qvip.QVipPersonalIconConfig;
import com.tencent.mobileqq.config.business.qvip.QVipPersonalIconProcessor;
import com.tencent.mobileqq.leba.business.ILebaDiyIconPart;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;

public class LebaDiyIconPartImpl
  implements ILebaDiyIconPart
{
  private static final int PERSONAL_ICON_SIZE = 18;
  public static final String TAG = "LebaDiyIconPartImpl";
  
  public boolean addPersonalBackgroundToIcon(Context paramContext, View paramView, int paramInt)
  {
    QVipPersonalIconConfig localQVipPersonalIconConfig = QVipPersonalIconProcessor.c();
    if (!localQVipPersonalIconConfig.a()) {}
    for (;;)
    {
      return false;
      String str = localQVipPersonalIconConfig.a(String.valueOf(paramInt));
      if (str != null) {
        try
        {
          paramInt = localQVipPersonalIconConfig.a(str);
          if (SkinEngine.getInstances().checkResExist(paramInt))
          {
            ViewUtils.a(paramView, paramContext.getResources().getDrawable(paramInt));
            return true;
          }
        }
        catch (Exception paramContext) {}
      }
    }
    return false;
  }
  
  public boolean addPersonalBackgroundToIcon(ImageView paramImageView, Drawable paramDrawable, String paramString)
  {
    QVipPersonalIconConfig localQVipPersonalIconConfig = QVipPersonalIconProcessor.c();
    if (!localQVipPersonalIconConfig.a())
    {
      paramDrawable.clearColorFilter();
      paramImageView.setImageDrawable(paramDrawable);
      ViewUtils.a(paramImageView, null);
      paramImageView.setPadding(0, 0, 0, 0);
      return false;
    }
    try
    {
      int i = localQVipPersonalIconConfig.a(paramString);
      if (!SkinEngine.getInstances().checkResExist(i))
      {
        QLog.i("LebaDiyIconPartImpl", 1, "addPersonalBackgroundToIcon ： 主题包没有该资源");
        paramDrawable.clearColorFilter();
        paramImageView.setImageDrawable(paramDrawable);
        ViewUtils.a(paramImageView, null);
        paramImageView.setPadding(0, 0, 0, 0);
        return false;
      }
      ViewUtils.a(paramImageView, paramImageView.getResources().getDrawable(i));
      paramDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
      paramString = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
      i = paramString.width;
      int j = paramString.height;
      int k = ViewUtils.b(18.0F);
      paramImageView.setPadding((i - k) / 2, (j - k) / 2, (i - k) / 2, (j - k) / 2);
      paramImageView.setImageDrawable(paramDrawable);
      paramImageView.invalidate();
      return true;
    }
    catch (Exception paramString)
    {
      QLog.i("LebaDiyIconPartImpl", 1, "addPersonalBackgroundToIcon Exception : " + paramString.toString());
      paramDrawable.clearColorFilter();
      paramImageView.setImageDrawable(paramDrawable);
      ViewUtils.a(paramImageView, null);
      paramImageView.setPadding(0, 0, 0, 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.impl.LebaDiyIconPartImpl
 * JD-Core Version:    0.7.0.1
 */