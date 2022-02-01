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
  Context a;
  List<InterestTagInfo> b;
  int c;
  int d;
  int e;
  int f;
  int g;
  Drawable h;
  int i;
  float j;
  
  SavorImgTagAdapter(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramContext;
    this.b = new ArrayList(2);
    this.c = paramInt1;
    this.d = paramInt2;
    int k = this.a.getResources().getDimensionPixelSize(2131299665);
    this.f = paramInt1;
    this.e = (paramInt2 + k);
    this.h = paramDrawable;
    this.i = 0;
    this.g = paramInt3;
    this.j = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    if ((paramInt > 0) && (this.i == 0))
    {
      if (this.b.size() > 0)
      {
        this.b.add(0, null);
        this.b.add(null);
      }
    }
    else if ((paramInt == 0) && (this.i > 0) && (this.b.size() > 2))
    {
      this.b.remove(0);
      List localList = this.b;
      localList.remove(localList.size() - 1);
    }
    this.i = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(List<InterestTagInfo> paramList)
  {
    this.b.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.b.addAll(paramList);
    }
    if ((this.b.size() > 0) && (this.i > 0))
    {
      this.b.add(0, null);
      this.b.add(null);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return (InterestTagInfo)this.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    InterestTagInfo localInterestTagInfo;
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      localInterestTagInfo = (InterestTagInfo)this.b.get(paramInt);
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
    int k = getItemViewType(paramInt);
    InterestTagInfo localInterestTagInfo;
    SavorImgTagAdapter.ViewHolder localViewHolder;
    Object localObject1;
    if (k == 0)
    {
      localInterestTagInfo = (InterestTagInfo)getItem(paramInt);
      if (paramView == null)
      {
        paramViewGroup = LayoutInflater.from(this.a).inflate(2131627588, null);
        localViewHolder = new SavorImgTagAdapter.ViewHolder();
        localViewHolder.a = ((URLImageView)paramViewGroup.findViewById(2131435503));
        localViewHolder.b = ((TextView)paramViewGroup.findViewById(2131447463));
        paramViewGroup.setTag(localViewHolder);
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(this.f, this.e));
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
        localViewHolder.a.setImageResource(2130842258);
        if ((localInterestTagInfo.tagType != 10) && (localInterestTagInfo.tagType != 11) && (localInterestTagInfo.tagType != 9)) {
          break label404;
        }
        localViewHolder.a.setImageResource(2130842259);
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.d;
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.c;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.h;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "nearbyCard";
        if (TextUtils.isEmpty(paramView)) {
          break label471;
        }
        paramView = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramView), (URLDrawable.URLDrawableOptions)localObject2);
        localObject1 = paramView;
        try
        {
          if (this.g == 7)
          {
            localObject1 = paramView;
            paramView.setTag(URLDrawableDecodeHandler.b(this.c, this.d, (int)(this.j * 10.0F)));
            localObject1 = paramView;
            paramView.setDecodeHandler(URLDrawableDecodeHandler.d);
          }
          localObject1 = paramView;
          paramView.setDownloadListener(new ImgDownloadListener(this.a, "actInterestTagPicDownload"));
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
      Object localObject2 = localViewHolder.a;
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = this.h;
      }
      ((URLImageView)localObject2).setImageDrawable((Drawable)localObject1);
      label404:
      localViewHolder.b.setText(localInterestTagInfo.tagName);
      return paramViewGroup;
      localObject1 = paramView;
      if (k == 1)
      {
        localObject1 = paramView;
        if (paramView == null)
        {
          localObject1 = new View(this.a);
          ((View)localObject1).setLayoutParams(new ViewGroup.LayoutParams(this.i, this.e));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.SavorImgTagAdapter
 * JD-Core Version:    0.7.0.1
 */