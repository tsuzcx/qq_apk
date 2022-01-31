package com.tencent.mobileqq.onlinestatus;

import alzw;
import amdi;
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
import atlb;
import atlj;
import bajq;
import belp;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class OnlineStatusView
  extends LinearLayout
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  amdi jdField_a_of_type_Amdi;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  belp jdField_a_of_type_Belp;
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
    int k = bajq.a(2.0F);
    int m = bajq.a(12.0F);
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
    float f = getResources().getDimensionPixelSize(2131165575);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101336));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, f);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("[");
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, bajq.a(19.0F));
    localLayoutParams.gravity = 16;
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
    this.jdField_a_of_type_ComTencentImageURLImageView.setDuplicateParentStateEnabled(false);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localLayoutParams = new LinearLayout.LayoutParams(bajq.a(12.0F), bajq.a(12.0F));
    localLayoutParams.gravity = 16;
    localLayoutParams.leftMargin = bajq.a(2.0F);
    localLayoutParams.rightMargin = bajq.a(2.0F);
    addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(false);
    this.jdField_b_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101336));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(0, f);
    this.jdField_b_of_type_AndroidWidgetTextView.setGravity(16);
    localLayoutParams = new LinearLayout.LayoutParams(-2, bajq.a(19.0F));
    localLayoutParams.gravity = 16;
    addView(this.jdField_b_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_Amdi = ((amdi)alzw.a().a(578));
    this.jdField_a_of_type_Belp = new belp(1);
  }
  
  public boolean a(Friends paramFriends)
  {
    this.jdField_a_of_type_Long = paramFriends.uExtOnlineStatus;
    this.jdField_a_of_type_Int = paramFriends.getBatteryCapacity();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusView", 2, new Object[] { "setOnlineStatus extStatus:", Long.valueOf(this.jdField_a_of_type_Long), " battery:", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    atlj localatlj = this.jdField_a_of_type_Amdi.a(AppRuntime.Status.online, this.jdField_a_of_type_Long);
    if ((localatlj.jdField_a_of_type_Int == 2) || ((this.jdField_a_of_type_Long == 1000L) && (this.jdField_a_of_type_Int <= 0)))
    {
      QLog.d("OnlineStatusView", 2, "setOnlineStatus item is null");
      return false;
    }
    Object localObject;
    if (atlj.a(this.jdField_a_of_type_Long))
    {
      localObject = this.jdField_a_of_type_Belp.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    for (;;)
    {
      paramFriends = atlb.a().a(localatlj, localatlj.jdField_a_of_type_MqqAppAppRuntime$Status, paramFriends);
      if (this.jdField_b_of_type_Int != 2) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramFriends + "]");
      return true;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = bajq.a(12.0F);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = bajq.a(12.0F);
      localObject = URLDrawable.getDrawable(localatlj.b, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramFriends);
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusView
 * JD-Core Version:    0.7.0.1
 */