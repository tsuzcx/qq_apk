package dov.com.tencent.mobileqq.activity.richmedia;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.IPtvTemplateItemCallback;
import dov.com.qq.im.capture.view.QIMCommonLoadingProgress;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

public class PtvTemplateItemView
  extends LinearLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public URLImageView a;
  QIMPtvTemplateAdapter.IPtvTemplateItemCallback jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$IPtvTemplateItemCallback;
  QIMCommonLoadingView jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView;
  ImageView b;
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842029);
    this.jdField_a_of_type_AndroidWidgetImageView.setMinimumWidth(i);
    this.jdField_a_of_type_AndroidWidgetImageView.setMinimumHeight(i);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localObject = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(j, j);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setCorner(j / 2);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setMinimumHeight(j);
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setMinimumWidth(j);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView, (ViewGroup.LayoutParams)localObject);
    this.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.b, (ViewGroup.LayoutParams)localObject);
    this.c = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(10);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.c, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout.LayoutParams(i, i);
    ((LinearLayout.LayoutParams)localObject).gravity = 17;
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.setVisibility(0);
    if (paramInt >= 100)
    {
      this.b.setVisibility(8);
      return;
    }
    if (paramInt < 0)
    {
      this.b.setImageResource(2130843189);
      this.b.setVisibility(0);
      return;
    }
    this.b.setVisibility(8);
  }
  
  public void a(int paramInt1, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, QIMPtvTemplateAdapter.IPtvTemplateItemCallback paramIPtvTemplateItemCallback, int paramInt2, String paramString)
  {
    if (paramPtvTemplateInfo == null) {}
    do
    {
      return;
      setTag(paramPtvTemplateInfo);
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$IPtvTemplateItemCallback = paramIPtvTemplateItemCallback;
      if (!TextUtils.isEmpty(paramPtvTemplateInfo.id)) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    return;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateItemView", 2, "bindData: invoked. info: info = " + paramPtvTemplateInfo);
    }
    if (!TextUtils.isEmpty(paramPtvTemplateInfo.iconurl))
    {
      paramIPtvTemplateItemCallback = URLDrawable.URLDrawableOptions.obtain();
      paramInt1 = AIOUtils.a(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131493213));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt1, paramInt1);
      paramIPtvTemplateItemCallback.mRequestWidth = paramInt1;
      paramIPtvTemplateItemCallback.mRequestHeight = paramInt1;
      paramIPtvTemplateItemCallback.mFailedDrawable = localGradientDrawable;
      paramIPtvTemplateItemCallback.mLoadingDrawable = localGradientDrawable;
      paramIPtvTemplateItemCallback.mRetryCount = 3;
      paramIPtvTemplateItemCallback = URLDrawable.getDrawable(paramPtvTemplateInfo.iconurl, paramIPtvTemplateItemCallback);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateItemView", 2, "bindData: invoked. info: drawable = " + paramIPtvTemplateItemCallback);
      }
      if (paramIPtvTemplateItemCallback.getStatus() == 2) {
        paramIPtvTemplateItemCallback.restartDownload();
      }
      paramIPtvTemplateItemCallback.setTag(URLDrawableDecodeHandler.a(paramInt1, paramInt1));
      paramIPtvTemplateItemCallback.setDecodeHandler(URLDrawableDecodeHandler.a);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramIPtvTemplateItemCallback);
      if ((paramPtvTemplateInfo.id.equals(paramString)) && (paramPtvTemplateInfo.usable))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (!((QIMPtvTemplateManager)QIMManager.a(3)).a(3, paramPtvTemplateInfo.categoryId, paramPtvTemplateInfo.id)) {
          break label453;
        }
        this.b.setImageResource(2130843190);
        this.b.setVisibility(0);
      }
    }
    for (;;)
    {
      if (!paramPtvTemplateInfo.downloading) {}
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      if (!paramPtvTemplateInfo.isWsBanner()) {
        break label512;
      }
      this.b.setVisibility(8);
      this.c.setVisibility(0);
      this.c.setImageResource(2130843196);
      WeishiGuideUtils.a(paramPtvTemplateInfo);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break;
      if (!"0".equals(paramPtvTemplateInfo.id)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      if (paramPtvTemplateInfo.id.equals(paramString))
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130843191);
        break;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130843192);
      break;
      label453:
      if ((paramPtvTemplateInfo.usable) || (paramPtvTemplateInfo.id.equals("0")))
      {
        this.b.setVisibility(8);
      }
      else if (!paramPtvTemplateInfo.downloading)
      {
        this.b.setImageResource(2130843189);
        this.b.setVisibility(0);
      }
    }
    label512:
    this.jdField_a_of_type_DovComQqImCaptureViewQIMCommonLoadingView.a(QIMCommonLoadingProgress.a(paramPtvTemplateInfo));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$IPtvTemplateItemCallback != null) {
      this.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateAdapter$IPtvTemplateItemCallback.a(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */