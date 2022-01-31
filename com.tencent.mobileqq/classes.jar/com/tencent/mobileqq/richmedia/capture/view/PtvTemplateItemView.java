package com.tencent.mobileqq.richmedia.capture.view;

import aepi;
import alud;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import axnx;
import axoc;
import azjh;
import azqs;
import bcyz;
import bdnn;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.widget.AbsListView.LayoutParams;

public class PtvTemplateItemView
  extends LinearLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  axnx jdField_a_of_type_Axnx;
  public URLImageView a;
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  boolean jdField_a_of_type_Boolean;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  
  public PtvTemplateItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public PtvTemplateItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    int i = aepi.a(60.0F, getResources());
    int j = aepi.a(60.0F, getResources());
    setLayoutParams(new AbsListView.LayoutParams(j, j));
    setGravity(17);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = new RelativeLayout.LayoutParams(j, j);
    this.jdField_a_of_type_ComTencentImageURLImageView.setMinimumWidth(j);
    this.jdField_a_of_type_ComTencentImageURLImageView.setMinimumHeight(j);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845538);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(204);
    this.jdField_a_of_type_AndroidWidgetImageView.setMinimumWidth(i);
    this.jdField_a_of_type_AndroidWidgetImageView.setMinimumHeight(i);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    j = aepi.a(28.0F, getResources());
    int k = getResources().getColor(2131166903);
    int m = getResources().getColor(2131165332);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = new CircleProgress(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(j, j);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setScaleType(ImageView.ScaleType.FIT_XY);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setMinimumHeight(j);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setMinimumWidth(j);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(2.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, k, 100, m);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(int paramInt, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, axnx paramaxnx)
  {
    if (paramPtvTemplateInfo == null) {}
    do
    {
      return;
      setTag(paramPtvTemplateInfo);
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Axnx = paramaxnx;
      if (!TextUtils.isEmpty(paramPtvTemplateInfo.id)) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    return;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramPtvTemplateInfo);
    axoc.a();
    paramInt = axoc.jdField_a_of_type_Int;
    boolean bool;
    label265:
    int i;
    if ((paramPtvTemplateInfo.funcType == PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET) && (azjh.a(paramInt)))
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (TextUtils.isEmpty(paramPtvTemplateInfo.iconurl)) {
        break label569;
      }
      paramaxnx = URLDrawable.URLDrawableOptions.obtain();
      paramInt = aepi.a(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131165804));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt, paramInt);
      paramaxnx.mRequestWidth = paramInt;
      paramaxnx.mRequestHeight = paramInt;
      paramaxnx.mFailedDrawable = localGradientDrawable;
      paramaxnx.mLoadingDrawable = localGradientDrawable;
      paramaxnx = URLDrawable.getDrawable(paramPtvTemplateInfo.iconurl, paramaxnx);
      paramaxnx.setTag(bcyz.a(paramInt, paramInt));
      paramaxnx.setDecodeHandler(bcyz.a);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramaxnx);
      paramaxnx = axoc.a().a();
      if ((paramaxnx == null) || (!paramPtvTemplateInfo.id.equals(paramaxnx.id)) || (!paramPtvTemplateInfo.usable)) {
        break label511;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!this.jdField_a_of_type_Boolean) {
        break label522;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845539);
      paramInt = getResources().getColor(2131166903);
      i = Color.parseColor("#E62555");
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, paramInt, 100, i);
      label314:
      bool = axoc.a().a(3, paramPtvTemplateInfo.categoryId, paramPtvTemplateInfo.id);
      if (!paramPtvTemplateInfo.advertisement) {
        break label650;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      if (bdnn.a(paramPtvTemplateInfo.badgeurl)) {
        break label638;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
        paramaxnx = URLDrawable.getDrawable(paramPtvTemplateInfo.badgeurl);
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramaxnx);
        paramaxnx = this.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
        paramaxnx.height = 42;
        paramaxnx.width = 42;
        this.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams(paramaxnx);
        azqs.b(null, "dc00898", "", "", "0X800859E", "0X800859E", 1, 0, "", "", paramPtvTemplateInfo.id, "");
        paramaxnx = paramPtvTemplateInfo.name;
        if (!paramPtvTemplateInfo.usable) {
          break label874;
        }
        paramPtvTemplateInfo = paramaxnx + alud.a(2131709125);
        this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(paramPtvTemplateInfo);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        return;
        bool = false;
        break;
        label511:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        break label265;
        label522:
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845538);
        paramInt = getResources().getColor(2131166903);
        i = getResources().getColor(2131165332);
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, paramInt, 100, i);
        break label314;
        label569:
        if (!"0".equals(paramPtvTemplateInfo.id)) {
          break label314;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        if (axoc.a().a() == null)
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130845536);
          break label314;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130845537);
      }
      catch (Exception paramaxnx)
      {
        this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
        continue;
      }
      label638:
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      continue;
      label650:
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849177);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (paramPtvTemplateInfo.downloading) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
        }
      }
      else if (bool)
      {
        if (paramPtvTemplateInfo.downloading)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845535);
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
        }
      }
      else if ((paramPtvTemplateInfo.usable) || (paramPtvTemplateInfo.id.equals("0")))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      }
      else if (paramPtvTemplateInfo.downloading)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845534);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
        continue;
        label874:
        if (paramPtvTemplateInfo.downloading) {
          paramPtvTemplateInfo = paramaxnx + alud.a(2131709124);
        } else {
          paramPtvTemplateInfo = paramaxnx + alud.a(2131709126);
        }
      }
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    if (((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getTag()).id.equals(paramPtvTemplateInfo.id))
    {
      if (paramInt < 100) {
        break label55;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    label55:
    do
    {
      do
      {
        return;
        if (paramInt >= 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845534);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(paramInt);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Axnx != null) {
      this.jdField_a_of_type_Axnx.a(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.PtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */