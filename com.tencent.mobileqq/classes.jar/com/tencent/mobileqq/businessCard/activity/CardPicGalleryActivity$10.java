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
    if ((this.a.f != null) && (paramInt < this.a.f.size()) && (paramInt >= 0)) {
      return (String)this.a.f.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.a.f != null) {
      return this.a.f.size();
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
      paramView = this.a.getLayoutInflater().inflate(2131627336, null);
      localImagePhotoHolder = new CardPicGalleryActivity.ImagePhotoHolder();
      localImagePhotoHolder.a = ((URLImageView)paramView.findViewById(2131430368));
      paramView.setTag(localImagePhotoHolder);
    }
    else
    {
      localImagePhotoHolder = (CardPicGalleryActivity.ImagePhotoHolder)paramView.getTag();
    }
    Object localObject1 = a(paramInt);
    Object localObject2;
    if ((this.a.g != 0) && (this.a.h == null))
    {
      localObject2 = this.a;
      ((CardPicGalleryActivity)localObject2).h = ((CardPicGalleryActivity)localObject2).getResources().getDrawable(this.a.g);
    }
    if (localObject1 != null)
    {
      try
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        if (this.a.h != null) {
          localObject1 = URLDrawable.getDrawable((String)localObject1, this.a.h, this.a.h);
        } else {
          localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
        }
        localImagePhotoHolder.a.setImageDrawable((Drawable)localObject1);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      if ((this.a.m == 1) && (!this.a.e)) {
        this.a.d.setVisibility(8);
      } else {
        this.a.d.setVisibility(0);
      }
    }
    else
    {
      try
      {
        if (this.a.h != null)
        {
          localObject1 = URLDrawable.getDrawable("https://aaa", this.a.h, this.a.h);
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
      this.a.d.setVisibility(8);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity.10
 * JD-Core Version:    0.7.0.1
 */