package com.tencent.mobileqq.richmedia.capture.view;

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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter.IPtvTemplateItemCallback;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.StringUtil;
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
  public URLImageView a;
  PtvTemplateAdapter.IPtvTemplateItemCallback jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$IPtvTemplateItemCallback;
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
    int i = AIOUtils.a(60.0F, getResources());
    int j = AIOUtils.a(60.0F, getResources());
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843193);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(204);
    this.jdField_a_of_type_AndroidWidgetImageView.setMinimumWidth(i);
    this.jdField_a_of_type_AndroidWidgetImageView.setMinimumHeight(i);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    j = AIOUtils.a(28.0F, getResources());
    int k = getResources().getColor(2131494214);
    int m = getResources().getColor(2131493308);
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
  
  public void a(int paramInt, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateAdapter.IPtvTemplateItemCallback paramIPtvTemplateItemCallback)
  {
    if (paramPtvTemplateInfo == null) {}
    do
    {
      return;
      setTag(paramPtvTemplateInfo);
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$IPtvTemplateItemCallback = paramIPtvTemplateItemCallback;
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
    CapturePtvTemplateManager.a();
    paramInt = CapturePtvTemplateManager.jdField_a_of_type_Int;
    boolean bool;
    label265:
    int i;
    if ((paramPtvTemplateInfo.funcType == PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET) && (RedBagVideoManager.a(paramInt)))
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (TextUtils.isEmpty(paramPtvTemplateInfo.iconurl)) {
        break label566;
      }
      paramIPtvTemplateItemCallback = URLDrawable.URLDrawableOptions.obtain();
      paramInt = AIOUtils.a(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131493213));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt, paramInt);
      paramIPtvTemplateItemCallback.mRequestWidth = paramInt;
      paramIPtvTemplateItemCallback.mRequestHeight = paramInt;
      paramIPtvTemplateItemCallback.mFailedDrawable = localGradientDrawable;
      paramIPtvTemplateItemCallback.mLoadingDrawable = localGradientDrawable;
      paramIPtvTemplateItemCallback = URLDrawable.getDrawable(paramPtvTemplateInfo.iconurl, paramIPtvTemplateItemCallback);
      paramIPtvTemplateItemCallback.setTag(URLDrawableDecodeHandler.a(paramInt, paramInt));
      paramIPtvTemplateItemCallback.setDecodeHandler(URLDrawableDecodeHandler.a);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramIPtvTemplateItemCallback);
      paramIPtvTemplateItemCallback = CapturePtvTemplateManager.a().a();
      if ((paramIPtvTemplateItemCallback == null) || (!paramPtvTemplateInfo.id.equals(paramIPtvTemplateItemCallback.id)) || (!paramPtvTemplateInfo.usable)) {
        break label508;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!this.jdField_a_of_type_Boolean) {
        break label519;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843194);
      paramInt = getResources().getColor(2131494214);
      i = Color.parseColor("#E62555");
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, paramInt, 100, i);
      label314:
      bool = CapturePtvTemplateManager.a().a(3, paramPtvTemplateInfo.categoryId, paramPtvTemplateInfo.id);
      if (!paramPtvTemplateInfo.advertisement) {
        break label647;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
      if (StringUtil.a(paramPtvTemplateInfo.badgeurl)) {
        break label635;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
        paramIPtvTemplateItemCallback = URLDrawable.getDrawable(paramPtvTemplateInfo.badgeurl);
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramIPtvTemplateItemCallback);
        paramIPtvTemplateItemCallback = this.jdField_b_of_type_ComTencentImageURLImageView.getLayoutParams();
        paramIPtvTemplateItemCallback.height = 42;
        paramIPtvTemplateItemCallback.width = 42;
        this.jdField_b_of_type_ComTencentImageURLImageView.setLayoutParams(paramIPtvTemplateItemCallback);
        ReportController.b(null, "dc00898", "", "", "0X800859E", "0X800859E", 1, 0, "", "", paramPtvTemplateInfo.id, "");
        paramIPtvTemplateItemCallback = paramPtvTemplateInfo.name;
        if (!paramPtvTemplateInfo.usable) {
          break label871;
        }
        paramPtvTemplateInfo = paramIPtvTemplateItemCallback + ", 已选中";
        this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(paramPtvTemplateInfo);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        return;
        bool = false;
        break;
        label508:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        break label265;
        label519:
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843193);
        paramInt = getResources().getColor(2131494214);
        i = getResources().getColor(2131493308);
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(30, paramInt, 100, i);
        break label314;
        label566:
        if (!"0".equals(paramPtvTemplateInfo.id)) {
          break label314;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        if (CapturePtvTemplateManager.a().a() == null)
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130843191);
          break label314;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130843192);
      }
      catch (Exception paramIPtvTemplateItemCallback)
      {
        this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
        continue;
      }
      label635:
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      continue;
      label647:
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845557);
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
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843190);
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
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843189);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(8);
        continue;
        label871:
        if (paramPtvTemplateInfo.downloading) {
          paramPtvTemplateInfo = paramIPtvTemplateItemCallback + ", 正在下载";
        } else {
          paramPtvTemplateInfo = paramIPtvTemplateItemCallback + ", 未下载";
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
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130843189);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(paramInt);
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$IPtvTemplateItemCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAdapterPtvTemplateAdapter$IPtvTemplateItemCallback.a(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.PtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */