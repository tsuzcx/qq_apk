package dov.com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import bdcw;
import bogr;
import boov;
import bpqs;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import zfn;

public class PtvTemplateItemView
  extends LinearLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  bogr jdField_a_of_type_Bogr;
  public URLImageView a;
  QIMCommonLoadingView jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView;
  boolean jdField_a_of_type_Boolean;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  ImageView c;
  
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
    int i = AIOUtils.dp2px(60.0F, getResources());
    int j = AIOUtils.dp2px(60.0F, getResources());
    int k = AIOUtils.dp2px(16.0F, getResources());
    int m = AIOUtils.dp2px(6.0F, getResources());
    int n = AIOUtils.dp2px(2.0F, getResources());
    setLayoutParams(new AbsListView.LayoutParams(j, j));
    setGravity(17);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = new RelativeLayout.LayoutParams(j, j);
    this.jdField_a_of_type_ComTencentImageURLImageView.setMinimumWidth(j);
    this.jdField_a_of_type_ComTencentImageURLImageView.setMinimumHeight(j);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject).setImageResource(2130837709);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(80, 80);
    localLayoutParams.addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844650);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844603);
    this.jdField_a_of_type_AndroidWidgetImageView.setMinimumWidth(i);
    this.jdField_a_of_type_AndroidWidgetImageView.setMinimumHeight(i);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(k, k);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setBgCorner(k / 2);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setMinimumHeight(k);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setMinimumWidth(k);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setProgressSizeAndMode(m, n, false);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.c = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.c.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.c, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
    if (paramInt >= 100) {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt >= 0) {
          break;
        }
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844541);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(int paramInt1, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, bogr parambogr, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (paramPtvTemplateInfo == null) {}
    do
    {
      return;
      setTag(paramPtvTemplateInfo);
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_Bogr = parambogr;
      if (!TextUtils.isEmpty(paramPtvTemplateInfo.id)) {
        break;
      }
    } while (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 4);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    return;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateItemView", 2, "bindData: invoked. info: info = " + paramPtvTemplateInfo);
    }
    paramInt1 = bpqs.jdField_a_of_type_Int;
    boolean bool;
    if ((paramPtvTemplateInfo.funcType == PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET) && (bdcw.a(paramInt1)))
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (TextUtils.isEmpty(paramPtvTemplateInfo.iconurl)) {
        break label501;
      }
      parambogr = URLDrawable.URLDrawableOptions.obtain();
      paramInt1 = AIOUtils.dp2px(60.0F, getResources());
      Drawable localDrawable = getResources().getDrawable(2130844540);
      parambogr.mRequestWidth = paramInt1;
      parambogr.mRequestHeight = paramInt1;
      parambogr.mFailedDrawable = localDrawable;
      parambogr.mLoadingDrawable = localDrawable;
      parambogr.mRetryCount = 3;
      parambogr = URLDrawable.getDrawable(paramPtvTemplateInfo.iconurl, parambogr);
      if (parambogr.getStatus() == 2) {
        parambogr.restartDownload();
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(parambogr);
      if ((!paramPtvTemplateInfo.id.equals(paramString)) || (!paramPtvTemplateInfo.usable)) {
        break label444;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramPtvTemplateInfo.editablewatermark = paramBoolean;
      if (!paramPtvTemplateInfo.editablewatermark) {
        break label433;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      label268:
      if (!this.jdField_a_of_type_Boolean) {
        break label463;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845940);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setBgColor(2145789269);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(false);
      label303:
      if (!this.jdField_a_of_type_Boolean) {
        break label572;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130849747);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if ((!paramPtvTemplateInfo.id.equals(paramString)) || (!paramPtvTemplateInfo.usable)) {
        break label560;
      }
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setBgColor(2130706432);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(true);
      label373:
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      if (!paramPtvTemplateInfo.isWsBanner()) {
        break label644;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.c.setVisibility(0);
      if (!paramPtvTemplateInfo.isDovItem()) {
        break label631;
      }
      this.c.setImageResource(2130845929);
    }
    for (;;)
    {
      zfn.a(paramPtvTemplateInfo);
      return;
      bool = false;
      break;
      label433:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      break label268;
      label444:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      break label268;
      label463:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844603);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setBgColor(-1);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setProgressColor(-16725252);
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(false);
      break label303;
      label501:
      if (!"0".equals(paramPtvTemplateInfo.id)) {
        break label303;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      if (paramPtvTemplateInfo.id.equals(paramString))
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130845937);
        break label303;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130845938);
      break label303;
      label560:
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(8);
      break label373;
      label572:
      if ((paramPtvTemplateInfo.usable) || (paramPtvTemplateInfo.id.equals("0")))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label373;
      }
      if (paramPtvTemplateInfo.downloading) {
        break label373;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844541);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      break label373;
      label631:
      this.c.setImageResource(2130845942);
    }
    label644:
    if (paramPtvTemplateInfo.needDisplayType())
    {
      this.c.setVisibility(0);
      this.c.setImageResource(paramPtvTemplateInfo.getDisplayIconByType());
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(boov.a(paramPtvTemplateInfo));
      return;
      this.c.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bogr != null) {
      this.jdField_a_of_type_Bogr.a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */