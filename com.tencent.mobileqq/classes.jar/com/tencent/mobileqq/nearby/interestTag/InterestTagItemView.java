package com.tencent.mobileqq.nearby.interestTag;

import alud;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import avax;
import avay;
import bauz;
import bcyz;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class InterestTagItemView
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new avax(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avay jdField_a_of_type_Avay;
  private URLDrawable.URLDrawableOptions jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
  private InterestTagInfo jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  
  public InterestTagItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561060, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131368203));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131379208));
    this.b = ((ImageView)paramContext.findViewById(2131368185));
    setBackgroundResource(2130844656);
    int i = getResources().getColor(2131166260);
    findViewById(2131379483).setBackgroundColor(i);
    this.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void a()
  {
    boolean bool = this.jdField_a_of_type_Avay.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo);
    if ((!bool) && (this.jdField_a_of_type_Boolean == true)) {
      this.b.setImageResource(2130846661);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      if ((bool == true) && (!this.jdField_a_of_type_Boolean)) {
        this.b.setImageResource(2130846662);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramInt == 5)
    {
      localLayoutParams.height = ((int)(this.jdField_a_of_type_Float * 50.0F + 0.5D));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(InterestTagInfo paramInterestTagInfo)
  {
    Object localObject4 = null;
    localObject2 = null;
    this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo = paramInterestTagInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo == null) {
      return;
    }
    if ((this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 6))
    {
      localObject1 = getResources().getDrawable(2131165804);
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      label66:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo.tagIconUrl)) {
        localObject3 = localObject4;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localObject3 = localObject4;
        if (this.jdField_a_of_type_Int != 5) {
          continue;
        }
        localObject3 = localObject4;
        localObject2 = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
        localObject3 = localObject4;
        i = getResources().getDimensionPixelSize(2131297276);
        localObject3 = localObject4;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
        localObject3 = localObject4;
        localObject2 = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
        localObject3 = localObject4;
        j = getResources().getDimensionPixelSize(2131297275);
        localObject3 = localObject4;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = j;
        localObject3 = localObject4;
        this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
        localObject3 = localObject4;
        this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
        localObject3 = localObject4;
        localObject2 = URLDrawable.getDrawable(bauz.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo.tagIconUrl), this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions);
        localObject3 = localObject2;
        if (this.jdField_a_of_type_Int != 7) {
          continue;
        }
        localObject3 = localObject2;
        ((URLDrawable)localObject2).setTag(bcyz.b(j, i, (int)(10.0F * this.jdField_a_of_type_Float)));
        localObject3 = localObject2;
        ((URLDrawable)localObject2).setDecodeHandler(bcyz.c);
      }
      catch (Exception localException)
      {
        int i;
        int j;
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("choose_interest_tag", 2, localException.toString());
        localObject2 = localObject3;
        continue;
        localObject3 = localObject2;
        if (this.jdField_a_of_type_Int == 5) {
          continue;
        }
        localObject3 = localObject2;
        if (this.jdField_a_of_type_Int == 6) {
          continue;
        }
        localObject3 = localObject2;
        ((URLDrawable)localObject2).setTag(bcyz.a(j, i));
        localObject3 = localObject2;
        ((URLDrawable)localObject2).setDecodeHandler(bcyz.a);
        continue;
        localObject1 = localObject2;
        continue;
      }
      localObject3 = localObject2;
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = null;
      localObject3 = localObject2;
      this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = null;
      localObject3 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject2 != null) {
        continue;
      }
      ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInterestTagInfo.tagName);
      a();
      setTag(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo);
      if (!AppSetting.c) {
        break;
      }
      setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText() + alud.a(2131706190));
      return;
      if (this.jdField_a_of_type_Int == 7)
      {
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setColor(getResources().getColor(2131165804));
        ((GradientDrawable)localObject1).setCornerRadius(10.0F * this.jdField_a_of_type_Float);
        ((GradientDrawable)localObject1).setShape(0);
        i = getResources().getDimensionPixelSize(2131297274);
        ((GradientDrawable)localObject1).setSize(i, i);
        this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
        break label66;
      }
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setColor(getResources().getColor(2131165804));
      ((GradientDrawable)localObject1).setShape(1);
      i = getResources().getDimensionPixelSize(2131297274);
      ((GradientDrawable)localObject1).setSize(i, i);
      break label66;
      localObject3 = localObject4;
      localObject2 = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
      localObject3 = localObject4;
      i = getResources().getDimensionPixelSize(2131297274);
      localObject3 = localObject4;
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
    }
  }
  
  public void setCallback(avay paramavay)
  {
    this.jdField_a_of_type_Avay = paramavay;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTagItemView
 * JD-Core Version:    0.7.0.1
 */