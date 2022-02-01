package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class SquareCornerTextImageView
  extends FrameLayout
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  public boolean a;
  TextView b;
  
  public SquareCornerTextImageView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = new KandianUrlImageView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundColor(Color.parseColor("#80000000"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    paramContext = new FrameLayout.LayoutParams(Utils.dp2px(30.0D), Utils.dp2px(18.0D));
    paramContext.gravity = 85;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, localLayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131560140, null);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379809));
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_AndroidViewView, paramContext);
  }
  
  private void b(@NonNull SquareCornerTextImageView.PicInfo paramPicInfo)
  {
    float f = SquareCornerTextImageView.PicInfo.a(paramPicInfo) * 1.0F / SquareCornerTextImageView.PicInfo.b(paramPicInfo);
    if (SquareCornerTextImageView.PicInfo.a(paramPicInfo))
    {
      double d = f;
      if ((d < 0.455D) || (d > 2.2D))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131718071));
        break label77;
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    label77:
    if (SquareCornerTextImageView.PicInfo.b(paramPicInfo))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131718070));
    }
    if ((SquareCornerTextImageView.PicInfo.c(paramPicInfo)) && (!TextUtils.isEmpty(SquareCornerTextImageView.PicInfo.a(paramPicInfo))))
    {
      this.b.setText(SquareCornerTextImageView.PicInfo.a(paramPicInfo));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(@NonNull SquareCornerTextImageView.PicInfo paramPicInfo)
  {
    ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, SquareCornerTextImageView.PicInfo.a(paramPicInfo), getContext());
    b(paramPicInfo);
  }
  
  public void a(@NonNull SquareCornerTextImageView.PicInfo paramPicInfo, String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramString, getContext());
    }
    catch (MalformedURLException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[configSmartSizeImage], e = ");
      localStringBuilder.append(paramString);
      QLog.e("SquareCornerTextImageView", 1, localStringBuilder.toString());
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, SquareCornerTextImageView.PicInfo.a(paramPicInfo), getContext());
    }
    b(paramPicInfo);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      super.onMeasure(paramInt1, paramInt1);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView
 * JD-Core Version:    0.7.0.1
 */