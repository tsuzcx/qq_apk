package com.tencent.mobileqq.nearby.interestTag;

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
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;

public class InterestTagItemView
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new InterestTagItemView.1(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable.URLDrawableOptions jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
  private InterestTagInfo jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo;
  private InterestTagItemView.IInterestTagItemViewCallback jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagItemView$IInterestTagItemViewCallback;
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
    paramContext = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561190, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131368741));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131380085));
    this.b = ((ImageView)paramContext.findViewById(2131368723));
    setBackgroundResource(2130845057);
    int i = getResources().getColor(2131166377);
    findViewById(2131380360).setBackgroundColor(i);
    this.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagItemView$IInterestTagItemViewCallback.a(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo);
    if ((!bool) && (this.jdField_a_of_type_Boolean == true)) {
      this.b.setImageResource(2130847352);
    } else if ((bool == true) && (!this.jdField_a_of_type_Boolean)) {
      this.b.setImageResource(2130847353);
    }
    this.jdField_a_of_type_Boolean = bool;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramInt == 5)
    {
      double d = this.jdField_a_of_type_Float * 50.0F;
      Double.isNaN(d);
      localLayoutParams.height = ((int)(d + 0.5D));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a(InterestTagInfo paramInterestTagInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo = paramInterestTagInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo == null) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    Object localObject1;
    if ((i != 5) && (i != 6))
    {
      if (i == 7)
      {
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setColor(getResources().getColor(2131165886));
        ((GradientDrawable)localObject1).setCornerRadius(this.jdField_a_of_type_Float * 10.0F);
        ((GradientDrawable)localObject1).setShape(0);
        i = getResources().getDimensionPixelSize(2131297462);
        ((GradientDrawable)localObject1).setSize(i, i);
        this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
      }
      else
      {
        localObject1 = new GradientDrawable();
        ((GradientDrawable)localObject1).setColor(getResources().getColor(2131165886));
        ((GradientDrawable)localObject1).setShape(1);
        i = getResources().getDimensionPixelSize(2131297462);
        ((GradientDrawable)localObject1).setSize(i, i);
      }
    }
    else
    {
      localObject1 = getResources().getDrawable(2131165886);
      this.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
    }
    boolean bool = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo.tagIconUrl);
    Object localObject2 = null;
    Object localObject3 = null;
    if (!bool)
    {
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (this.jdField_a_of_type_Int == 5)
        {
          localObject2 = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
          i = getResources().getDimensionPixelSize(2131297464);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
          i = getResources().getDimensionPixelSize(2131297462);
          ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
        }
        localObject2 = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
        int j = getResources().getDimensionPixelSize(2131297463);
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = j;
        this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
        this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
        localObject2 = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo.tagIconUrl), this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions);
        try
        {
          if (this.jdField_a_of_type_Int == 7)
          {
            ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.b(j, i, (int)(this.jdField_a_of_type_Float * 10.0F)));
            ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.c);
          }
          else if ((this.jdField_a_of_type_Int != 5) && (this.jdField_a_of_type_Int != 6))
          {
            ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.a(j, i));
            ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.a);
          }
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = null;
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = null;
        }
        catch (Exception localException1)
        {
          localObject3 = localObject2;
        }
        localObject2 = localObject3;
      }
      catch (Exception localException2) {}
      if (QLog.isColorLevel())
      {
        QLog.i("choose_interest_tag", 2, localException2.toString());
        localObject2 = localObject3;
      }
    }
    localObject3 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInterestTagInfo.tagName);
    a();
    setTag(this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagInfo);
    if (AppSetting.d)
    {
      paramInterestTagInfo = new StringBuilder();
      paramInterestTagInfo.append(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramInterestTagInfo.append(HardCodeUtil.a(2131705874));
      setContentDescription(paramInterestTagInfo.toString());
    }
  }
  
  public void setCallback(InterestTagItemView.IInterestTagItemViewCallback paramIInterestTagItemViewCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyInterestTagInterestTagItemView$IInterestTagItemViewCallback = paramIInterestTagItemViewCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTagItemView
 * JD-Core Version:    0.7.0.1
 */