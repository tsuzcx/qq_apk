package com.tencent.mobileqq.businessCard.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class CardPicGalleryActivity$10
  extends BaseAdapter
{
  CardPicGalleryActivity$10(CardPicGalleryActivity paramCardPicGalleryActivity) {}
  
  public String a(int paramInt)
  {
    if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.a.jdField_a_of_type_JavaUtilArrayList.size()) && (paramInt >= 0)) {
      return (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.a.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CardPicGalleryActivity.ImagePhotoHolder localImagePhotoHolder;
    Object localObject;
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2131561131, null);
      localImagePhotoHolder = new CardPicGalleryActivity.ImagePhotoHolder();
      localImagePhotoHolder.a = ((URLImageView)paramView.findViewById(2131364450));
      paramView.setTag(localImagePhotoHolder);
      localObject = a(paramInt);
      if ((this.a.jdField_a_of_type_Int != 0) && (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
        this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.a.getResources().getDrawable(this.a.jdField_a_of_type_Int);
      }
      if (localObject == null) {}
    }
    else
    {
      try
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          break label210;
        }
        localObject = URLDrawable.getDrawable((String)localObject, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        label139:
        localImagePhotoHolder.a.setImageDrawable((Drawable)localObject);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions;
          localException1.printStackTrace();
          continue;
          this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      if ((this.a.d == 1) && (!this.a.jdField_a_of_type_Boolean)) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localImagePhotoHolder = (CardPicGalleryActivity.ImagePhotoHolder)paramView.getTag();
      break;
      label210:
      localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      break label139;
      try
      {
        if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          localObject = URLDrawable.getDrawable("https://aaa", this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          localException1.a.setImageDrawable((Drawable)localObject);
        }
        for (;;)
        {
          this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break;
          localException1.a.setImageDrawable(null);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.10
 * JD-Core Version:    0.7.0.1
 */