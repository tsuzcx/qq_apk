package com.tencent.mobileqq.ecshop.keep;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Date;
import mqq.app.AppRuntime;

public class QggMinusOneViewTitleLayout
  extends FrameLayout
{
  private ImageView a;
  private TextView b;
  private RelativeLayout.LayoutParams c;
  private boolean d;
  
  public QggMinusOneViewTitleLayout(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public QggMinusOneViewTitleLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.d = ThemeUtil.isNowThemeIsNight(AppUtils.a(), false, null);
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    addView(localRelativeLayout);
    ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
    int i = -1;
    localLayoutParams.width = -1;
    localRelativeLayout.getLayoutParams().height = -2;
    this.a = new ImageView(paramContext);
    localRelativeLayout.addView(this.a);
    this.c = ((RelativeLayout.LayoutParams)this.a.getLayoutParams());
    this.c.addRule(9);
    ((RelativeLayout.LayoutParams)this.a.getLayoutParams()).addRule(15);
    this.b = new TextView(paramContext);
    localRelativeLayout.addView(this.b);
    paramContext = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    paramContext.width = -2;
    paramContext.height = -1;
    paramContext.addRule(11);
    paramContext = this.b;
    if (!this.d) {
      i = -16777216;
    }
    paramContext.setTextColor(i);
    this.b.setTextSize(1, 14.0F);
    this.b.setGravity(8388613);
    ((RelativeLayout.LayoutParams)this.b.getLayoutParams()).addRule(15);
  }
  
  private void a(String paramString, ImageView paramImageView, int paramInt)
  {
    if (!StringUtil.isEmpty(paramString)) {
      if (paramImageView == null) {
        return;
      }
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = AppUtils.a().getApp().getResources().getDrawable(2130853309);
      this.c.height = DisplayUtil.a(getContext(), 40.0F);
      localURLDrawableOptions.mRequestHeight = this.c.height;
      this.c.width = (localURLDrawableOptions.mRequestHeight * 3 + DisplayUtil.a(getContext(), 10.0F));
      localURLDrawableOptions.mRequestWidth = this.c.width;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramString == null) {
        break label155;
      }
      if (paramString.getStatus() == 2) {
        paramString.restartDownload();
      }
      if (!this.d) {
        break label160;
      }
      paramInt = -1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        continue;
        paramInt = -16777216;
      }
    }
    paramString.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    paramImageView.setBackgroundDrawable(paramString);
    return;
    paramImageView.setVisibility(8);
    label155:
  }
  
  private void a(String paramString, TextView paramTextView)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      if (paramTextView == null) {
        return;
      }
      paramTextView.setText(paramString);
    }
  }
  
  public void setMinusViewTitle(EcshopConfBean paramEcshopConfBean)
  {
    if (paramEcshopConfBean == null) {
      return;
    }
    if (StringUtil.isEmpty(paramEcshopConfBean.g)) {
      paramEcshopConfBean = "https://i.gtimg.cn/channel/imglib/202005/upload_0130d1d150ac825d9804c01c17955272.png";
    } else {
      paramEcshopConfBean = paramEcshopConfBean.g;
    }
    a(paramEcshopConfBean, this.a, 0);
    paramEcshopConfBean = EcshopUtils.a(NetConnInfoCenter.getServerTimeMillis(), "M月d日");
    String str = EcshopUtils.a(getContext(), new Date());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEcshopConfBean);
    localStringBuilder.append("\n");
    localStringBuilder.append(str);
    a(localStringBuilder.toString(), this.b);
  }
  
  public void setQggTitle(EcshopConfBean paramEcshopConfBean)
  {
    if (paramEcshopConfBean == null) {
      return;
    }
    if (StringUtil.isEmpty(paramEcshopConfBean.h)) {
      paramEcshopConfBean = "https://i.gtimg.cn/channel/imglib/202005/upload_d10f6014892e80a6195c5a965a6b8ac0.png";
    } else {
      paramEcshopConfBean = paramEcshopConfBean.h;
    }
    a(paramEcshopConfBean, this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.keep.QggMinusOneViewTitleLayout
 * JD-Core Version:    0.7.0.1
 */