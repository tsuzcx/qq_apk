package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import athh;
import atkc;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import java.net.URL;
import java.util.ArrayList;

public class ImageDisplayView
  extends FrameLayout
  implements URLDrawable.URLDrawableListener
{
  private View jdField_a_of_type_AndroidViewView;
  private atkc jdField_a_of_type_Atkc;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public FitXImageView a;
  
  public ImageDisplayView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ImageDisplayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ImageDisplayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560857, this, true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetFitXImageView = ((FitXImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365255));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.post(new ImageDisplayView.1(this, paramString, paramInt1, paramInt2), 8, null, true);
  }
  
  public void a(VideoData paramVideoData)
  {
    ativ.c = paramVideoData.jdField_a_of_type_JavaLangString;
    ativ.d = String.valueOf(paramVideoData.jdField_a_of_type_Long);
    if (paramVideoData.jdField_a_of_type_Int == 4)
    {
      a(((athh)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString, ((athh)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int, ((athh)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).b);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseAutoScaleParams = true;
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(((athh)paramVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString, localURLDrawableOptions);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetFitXImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      this.jdField_a_of_type_Atkc.a(this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicWidth(), this.jdField_a_of_type_ComTencentImageURLDrawable.getIntrinsicHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_Atkc != null) {
      this.jdField_a_of_type_Atkc.a(paramURLDrawable.getURL().toString(), this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetFitXImageView, 1);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_Atkc != null) {
      this.jdField_a_of_type_Atkc.a(paramURLDrawable.getURL().toString(), this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetFitXImageView, 0);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetFitXImageView.setImageDrawable(paramURLDrawable);
    this.jdField_a_of_type_Atkc.a(paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
  }
  
  public void setRelayoutListener(atkc paramatkc)
  {
    this.jdField_a_of_type_Atkc = paramatkc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView
 * JD-Core Version:    0.7.0.1
 */