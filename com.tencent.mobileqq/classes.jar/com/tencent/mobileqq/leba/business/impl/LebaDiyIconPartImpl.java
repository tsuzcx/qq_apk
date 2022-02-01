package com.tencent.mobileqq.leba.business.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.leba.business.ILebaDiyIconPart;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPersonalIconConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPersonalIconProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;

public class LebaDiyIconPartImpl
  implements ILebaDiyIconPart
{
  private static final int PERSONAL_ICON_SIZE = 18;
  public static final String TAG = "LebaDiyIconPartImpl";
  
  public boolean addPersonalBackgroundToIcon(Context paramContext, View paramView, int paramInt)
  {
    QVipPersonalIconConfig localQVipPersonalIconConfig = QVipPersonalIconProcessor.e();
    if (!localQVipPersonalIconConfig.b()) {
      return false;
    }
    String str = localQVipPersonalIconConfig.b(String.valueOf(paramInt));
    if (str != null) {}
    try
    {
      paramInt = localQVipPersonalIconConfig.c(str);
      if (!SkinEngine.getInstances().checkResExist(paramInt)) {
        return false;
      }
      ViewUtils.setViewBackground(paramView, paramContext.getResources().getDrawable(paramInt));
      return true;
    }
    catch (Exception paramContext) {}
    return false;
    return false;
  }
  
  public boolean addPersonalBackgroundToIcon(ImageView paramImageView, Drawable paramDrawable, String paramString)
  {
    Object localObject = QVipPersonalIconProcessor.e();
    if (!((QVipPersonalIconConfig)localObject).b())
    {
      paramDrawable.clearColorFilter();
      paramImageView.setImageDrawable(paramDrawable);
      ViewUtils.setViewBackground(paramImageView, null);
      paramImageView.setPadding(0, 0, 0, 0);
      return false;
    }
    try
    {
      int i = ((QVipPersonalIconConfig)localObject).c(paramString);
      if (!SkinEngine.getInstances().checkResExist(i))
      {
        QLog.i("LebaDiyIconPartImpl", 1, "addPersonalBackgroundToIcon ： 主题包没有该资源");
        paramDrawable.clearColorFilter();
        paramImageView.setImageDrawable(paramDrawable);
        ViewUtils.setViewBackground(paramImageView, null);
        paramImageView.setPadding(0, 0, 0, 0);
        return false;
      }
      ViewUtils.setViewBackground(paramImageView, paramImageView.getResources().getDrawable(i));
      paramDrawable.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
      paramString = (RelativeLayout.LayoutParams)paramImageView.getLayoutParams();
      int k = paramString.width;
      i = paramString.height;
      int j = ViewUtils.dpToPx(18.0F);
      k -= j;
      int m = k / 2;
      i -= j;
      paramImageView.setPadding(m, i / 2, k / 2, i / 2);
      paramImageView.setImageDrawable(paramDrawable);
      paramImageView.invalidate();
      return true;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addPersonalBackgroundToIcon Exception : ");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.i("LebaDiyIconPartImpl", 1, ((StringBuilder)localObject).toString());
      paramDrawable.clearColorFilter();
      paramImageView.setImageDrawable(paramDrawable);
      ViewUtils.setViewBackground(paramImageView, null);
      paramImageView.setPadding(0, 0, 0, 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.impl.LebaDiyIconPartImpl
 * JD-Core Version:    0.7.0.1
 */