package com.tencent.mobileqq.guild.channel.create.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.RoundRectImageView;
import java.util.List;

class QQGuildAppPreviewFragment$MyAdapter
  extends PagerAdapter
{
  private QQGuildAppPreviewFragment$MyAdapter(QQGuildAppPreviewFragment paramQQGuildAppPreviewFragment) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramObject != null)
    {
      if (paramViewGroup == null) {
        return;
      }
      paramViewGroup.removeView((View)paramObject);
    }
  }
  
  public int getCount()
  {
    return QQGuildAppPreviewFragment.d(this.a).size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = LayoutInflater.from(this.a.getContext()).inflate(2131624988, null);
    RoundRectImageView localRoundRectImageView = (RoundRectImageView)localView.findViewById(2131440619);
    Object localObject = localRoundRectImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = QQGuildAppPreviewFragment.b(this.a);
    ((ViewGroup.LayoutParams)localObject).width = QQGuildAppPreviewFragment.c(this.a);
    localRoundRectImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localRoundRectImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localRoundRectImageView.setCornerRadiusAndMode(ViewUtils.dpToPx(8.0F), 1);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = QQGuildAppPreviewFragment.c(this.a);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = QQGuildAppPreviewFragment.b(this.a);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getContext().getResources().getDrawable(2130840785);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getContext().getResources().getDrawable(2130840785);
    localRoundRectImageView.setImageDrawable(URLDrawable.getDrawable((String)QQGuildAppPreviewFragment.d(this.a).get(paramInt), (URLDrawable.URLDrawableOptions)localObject));
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.fragment.QQGuildAppPreviewFragment.MyAdapter
 * JD-Core Version:    0.7.0.1
 */