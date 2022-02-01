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
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  
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
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNight(AppUtils.a(), false, null);
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    addView(localRelativeLayout);
    ViewGroup.LayoutParams localLayoutParams = localRelativeLayout.getLayoutParams();
    int i = -1;
    localLayoutParams.width = -1;
    localRelativeLayout.getLayoutParams().height = -2;
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(9);
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(15);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    paramContext.width = -2;
    paramContext.height = -1;
    paramContext.addRule(11);
    paramContext = this.jdField_a_of_type_AndroidWidgetTextView;
    if (!this.jdField_a_of_type_Boolean) {
      i = -16777216;
    }
    paramContext.setTextColor(i);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(8388613);
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(15);
  }
  
  private void a(String paramString, ImageView paramImageView, int paramInt)
  {
    if (!StringUtil.a(paramString)) {
      if (paramImageView == null) {
        return;
      }
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = AppUtils.a().getApp().getResources().getDrawable(2130851078);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.height = DisplayUtil.a(getContext(), 40.0F);
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.height;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = (localURLDrawableOptions.mRequestHeight * 3 + DisplayUtil.a(getContext(), 10.0F));
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramString == null) {
        break label155;
      }
      if (paramString.getStatus() == 2) {
        paramString.restartDownload();
      }
      if (!this.jdField_a_of_type_Boolean) {
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
    if (!StringUtil.a(paramString))
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
    if (StringUtil.a(paramEcshopConfBean.c)) {
      paramEcshopConfBean = "https://i.gtimg.cn/channel/imglib/202005/upload_0130d1d150ac825d9804c01c17955272.png";
    } else {
      paramEcshopConfBean = paramEcshopConfBean.c;
    }
    a(paramEcshopConfBean, this.jdField_a_of_type_AndroidWidgetImageView, 0);
    paramEcshopConfBean = EcshopUtils.a(NetConnInfoCenter.getServerTimeMillis(), "M月d日");
    String str = EcshopUtils.a(getContext(), new Date());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEcshopConfBean);
    localStringBuilder.append("\n");
    localStringBuilder.append(str);
    a(localStringBuilder.toString(), this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public void setQggTitle(EcshopConfBean paramEcshopConfBean)
  {
    if (paramEcshopConfBean == null) {
      return;
    }
    if (StringUtil.a(paramEcshopConfBean.d)) {
      paramEcshopConfBean = "https://i.gtimg.cn/channel/imglib/202005/upload_d10f6014892e80a6195c5a965a6b8ac0.png";
    } else {
      paramEcshopConfBean = paramEcshopConfBean.d;
    }
    a(paramEcshopConfBean, this.jdField_a_of_type_AndroidWidgetImageView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.keep.QggMinusOneViewTitleLayout
 * JD-Core Version:    0.7.0.1
 */