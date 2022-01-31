package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aogj;
import aokn;
import awaf;
import awam;
import bdkf;
import bhux;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class OnlineStatusView
  extends LinearLayout
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aokn jdField_a_of_type_Aokn;
  bhux jdField_a_of_type_Bhux;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  int jdField_b_of_type_Int = 1;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public OnlineStatusView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public OnlineStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public OnlineStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public int a()
  {
    CharSequence localCharSequence1 = this.jdField_a_of_type_AndroidWidgetTextView.getText();
    CharSequence localCharSequence2 = this.jdField_b_of_type_AndroidWidgetTextView.getText();
    int i = (int)this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(localCharSequence1, 0, localCharSequence1.length());
    int j = (int)this.jdField_b_of_type_AndroidWidgetTextView.getPaint().measureText(localCharSequence2, 0, localCharSequence2.length());
    int k = bdkf.a(2.0F);
    int m = bdkf.a(12.0F);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusView", 2, new Object[] { "prefixLen:", Integer.valueOf(i), " suffixLen:", Integer.valueOf(j), " iconLen:", Integer.valueOf(m) });
    }
    return i + m + j + k;
  }
  
  public CharSequence a()
  {
    CharSequence localCharSequence1 = this.jdField_a_of_type_AndroidWidgetTextView.getText();
    CharSequence localCharSequence2 = this.jdField_b_of_type_AndroidWidgetTextView.getText();
    StringBuilder localStringBuilder = new StringBuilder(10);
    localStringBuilder.append(localCharSequence1).append(localCharSequence2);
    return localStringBuilder.toString();
  }
  
  void a()
  {
    setOrientation(0);
    setGravity(16);
    float f = getResources().getDimensionPixelSize(2131296663);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166979));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, f);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("[");
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, bdkf.a(19.0F));
    localLayoutParams.gravity = 16;
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
    this.jdField_a_of_type_ComTencentImageURLImageView.setDuplicateParentStateEnabled(false);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localLayoutParams = new LinearLayout.LayoutParams(bdkf.a(12.0F), bdkf.a(12.0F));
    localLayoutParams.gravity = 16;
    localLayoutParams.leftMargin = bdkf.a(2.0F);
    localLayoutParams.rightMargin = bdkf.a(2.0F);
    addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(false);
    this.jdField_b_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166979));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, f);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(16);
    localLayoutParams = new LinearLayout.LayoutParams(-2, bdkf.a(19.0F));
    localLayoutParams.gravity = 16;
    addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_Aokn = ((aokn)aogj.a().a(578));
    this.jdField_a_of_type_Bhux = new bhux();
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Friends paramFriends)
  {
    this.jdField_a_of_type_Long = paramFriends.uExtOnlineStatus;
    this.jdField_a_of_type_Int = paramFriends.getBatteryCapacity();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusView", 2, new Object[] { "setOnlineStatus extStatus:", Long.valueOf(this.jdField_a_of_type_Long), " battery:", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    awam localawam = this.jdField_a_of_type_Aokn.a(AppRuntime.Status.online, this.jdField_a_of_type_Long);
    if ((localawam.jdField_a_of_type_Int == 2) || ((this.jdField_a_of_type_Long == 1000L) && (this.jdField_a_of_type_Int <= 0)))
    {
      QLog.d("OnlineStatusView", 2, "setOnlineStatus item is null");
      return false;
    }
    Object localObject;
    if (awam.a(this.jdField_a_of_type_Long))
    {
      localObject = this.jdField_a_of_type_Bhux.a(this.jdField_a_of_type_Int, 1);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      paramQQAppInterface = awaf.a().a(paramQQAppInterface, localawam, localawam.jdField_a_of_type_MqqAppAppRuntime$Status, paramFriends, this.jdField_b_of_type_AndroidWidgetTextView);
      if (this.jdField_b_of_type_Int != 2) {
        break label257;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramQQAppInterface + "]");
    }
    for (;;)
    {
      return true;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bdkf.a(12.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bdkf.a(12.0F);
      localObject = URLDrawable.getDrawable(localawam.b, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      break;
      label257:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramQQAppInterface);
    }
  }
  
  public void setTextSize(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, paramInt);
  }
  
  public void setViewStyle(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusView
 * JD-Core Version:    0.7.0.1
 */