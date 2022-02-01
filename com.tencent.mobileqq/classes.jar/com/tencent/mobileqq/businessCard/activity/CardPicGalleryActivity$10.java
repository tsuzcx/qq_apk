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
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2131560995, null);
      localImagePhotoHolder = new CardPicGalleryActivity.ImagePhotoHolder();
      localImagePhotoHolder.a = ((URLImageView)paramView.findViewById(2131364340));
      paramView.setTag(localImagePhotoHolder);
    }
    else
    {
      localImagePhotoHolder = (CardPicGalleryActivity.ImagePhotoHolder)paramView.getTag();
    }
    Object localObject1 = a(paramInt);
    Object localObject2;
    if ((this.a.jdField_a_of_type_Int != 0) && (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      localObject2 = this.a;
      ((CardPicGalleryActivity)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((CardPicGalleryActivity)localObject2).getResources().getDrawable(this.a.jdField_a_of_type_Int);
    }
    if (localObject1 != null)
    {
      try
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          localObject1 = URLDrawable.getDrawable((String)localObject1, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        } else {
          localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        }
        localImagePhotoHolder.a.setImageDrawable((Drawable)localObject1);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      if ((this.a.d == 1) && (!this.a.jdField_a_of_type_Boolean)) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      } else {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      try
      {
        if (this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          localObject1 = URLDrawable.getDrawable("https://aaa", this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          localException1.a.setImageDrawable((Drawable)localObject1);
        }
        else
        {
          localException1.a.setImageDrawable(null);
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.10
 * JD-Core Version:    0.7.0.1
 */