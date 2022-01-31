package com.tencent.mobileqq.profile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import atxq;
import atzx;
import atzy;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.ProfileCardScrollImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class PhotoViewForShopping$StylePagerAdapter
  extends PagerAdapter
{
  public Context a;
  public LayoutInflater a;
  View.OnClickListener a;
  
  public PhotoViewForShopping$StylePagerAdapter(PhotoViewForShopping paramPhotoViewForShopping, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new atzx(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileShoppingView", 2, "destroyItem, pos = " + paramInt);
    }
    paramObject = (View)paramObject;
    atzy localatzy = (atzy)paramObject.getTag();
    paramViewGroup.removeView(paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a.size();
  }
  
  @TargetApi(16)
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileShoppingView", 2, "instantiateItem, pos = " + paramInt);
    }
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131496039, paramViewGroup, false);
    atzy localatzy = new atzy(this);
    localatzy.a = ((ProfileCardScrollImageView)localView.findViewById(2131301290));
    localView.setTag(localatzy);
    localatzy.a.setScaleType(ImageView.ScaleType.FIT_XY);
    Object localObject = (RelativeLayout.LayoutParams)localatzy.a.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.c;
    ((RelativeLayout.LayoutParams)localObject).height = this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.d;
    localatzy.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = ((atxq)this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a.get(paramInt)).b;
    localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846315);
    localatzy.a.setImageDrawable((Drawable)localObject);
    localView.setId(paramInt);
    paramViewGroup.addView(localView);
    localatzy.a.setIsScroll(false);
    paramViewGroup = URLDrawable.getDrawable(((atxq)this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.a.get(paramInt)).a, this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.c, this.jdField_a_of_type_ComTencentMobileqqProfileViewPhotoViewForShopping.d);
    localatzy.a.setImageDrawable(paramViewGroup);
    localatzy.a.setTag(Integer.valueOf(paramInt));
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.PhotoViewForShopping.StylePagerAdapter
 * JD-Core Version:    0.7.0.1
 */