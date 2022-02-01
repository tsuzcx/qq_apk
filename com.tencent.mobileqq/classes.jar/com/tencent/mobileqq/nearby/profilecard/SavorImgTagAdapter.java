package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import java.util.ArrayList;
import java.util.List;

public class SavorImgTagAdapter
  extends BaseAdapter
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  List<InterestTagInfo> jdField_a_of_type_JavaUtilList;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  SavorImgTagAdapter(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298943);
    this.d = paramInt1;
    this.c = (paramInt2 + i);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.f = 0;
    this.e = paramInt3;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    if ((paramInt > 0) && (this.f == 0))
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(0, null);
        this.jdField_a_of_type_JavaUtilList.add(null);
      }
    }
    else if ((paramInt == 0) && (this.f > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 2))
    {
      this.jdField_a_of_type_JavaUtilList.remove(0);
      List localList = this.jdField_a_of_type_JavaUtilList;
      localList.remove(localList.size() - 1);
    }
    this.f = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(List<InterestTagInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.f > 0))
    {
      this.jdField_a_of_type_JavaUtilList.add(0, null);
      this.jdField_a_of_type_JavaUtilList.add(null);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (InterestTagInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    InterestTagInfo localInterestTagInfo;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      localInterestTagInfo = (InterestTagInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    } else {
      localInterestTagInfo = null;
    }
    if (localInterestTagInfo == null) {
      return 0L;
    }
    return localInterestTagInfo.tagId;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((InterestTagInfo)getItem(paramInt) != null) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    InterestTagInfo localInterestTagInfo;
    SavorImgTagAdapter.ViewHolder localViewHolder;
    Object localObject1;
    if (i == 0)
    {
      localInterestTagInfo = (InterestTagInfo)getItem(paramInt);
      if (paramView == null)
      {
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561232, null);
        localViewHolder = new SavorImgTagAdapter.ViewHolder();
        localViewHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131368591));
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378784));
        paramViewGroup.setTag(localViewHolder);
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(this.d, this.c));
      }
      else
      {
        localViewHolder = (SavorImgTagAdapter.ViewHolder)paramView.getTag();
        paramViewGroup = paramView;
      }
      localObject1 = paramViewGroup;
      if (localInterestTagInfo == null) {
        break label468;
      }
      localObject1 = paramViewGroup;
      if (localViewHolder == null) {
        break label468;
      }
      paramView = localInterestTagInfo.tagIconUrl;
      if ((paramView != null) && (paramView.equals("icon_more_url")))
      {
        localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130841418);
        if ((localInterestTagInfo.tagType != 10) && (localInterestTagInfo.tagType != 11) && (localInterestTagInfo.tagType != 9)) {
          break label404;
        }
        localViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130841419);
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.b;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "nearbyCard";
        if (TextUtils.isEmpty(paramView)) {
          break label471;
        }
        paramView = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramView), (URLDrawable.URLDrawableOptions)localObject2);
        localObject1 = paramView;
        try
        {
          if (this.e == 7)
          {
            localObject1 = paramView;
            paramView.setTag(URLDrawableDecodeHandler.b(this.jdField_a_of_type_Int, this.b, (int)(this.jdField_a_of_type_Float * 10.0F)));
            localObject1 = paramView;
            paramView.setDecodeHandler(URLDrawableDecodeHandler.c);
          }
          localObject1 = paramView;
          paramView.setDownloadListener(new ImgDownloadListener(this.jdField_a_of_type_AndroidContentContext, "actInterestTagPicDownload"));
          localObject1 = paramView;
          ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = null;
          localObject1 = paramView;
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = null;
        }
        catch (Exception paramView) {}
        paramView.printStackTrace();
      }
      catch (Exception paramView)
      {
        localObject1 = null;
      }
      paramView = (View)localObject1;
      Object localObject2 = localViewHolder.jdField_a_of_type_ComTencentImageURLImageView;
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
      ((URLImageView)localObject2).setImageDrawable((Drawable)localObject1);
      label404:
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localInterestTagInfo.tagName);
      return paramViewGroup;
      localObject1 = paramView;
      if (i == 1)
      {
        localObject1 = paramView;
        if (paramView == null)
        {
          localObject1 = new View(this.jdField_a_of_type_AndroidContentContext);
          ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(this.f, this.c));
        }
      }
      label468:
      return localObject1;
      label471:
      paramView = null;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.SavorImgTagAdapter
 * JD-Core Version:    0.7.0.1
 */