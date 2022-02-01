package com.tencent.mobileqq.fragment;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class SDKSetEmotionPreviewFragment$PreviewGridAdapter
  extends BaseAdapter
{
  public List<String> a = new ArrayList();
  LayoutInflater b;
  
  public SDKSetEmotionPreviewFragment$PreviewGridAdapter(SDKSetEmotionPreviewFragment paramSDKSetEmotionPreviewFragment)
  {
    this.b = paramSDKSetEmotionPreviewFragment.getBaseActivity().getLayoutInflater();
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null)
    {
      if (this.a.size() != 0)
      {
        this.a.clear();
        notifyDataSetChanged();
      }
      return;
    }
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.b.inflate(2131627955, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(SDKSetEmotionPreviewFragment.a(this.c), SDKSetEmotionPreviewFragment.b(this.c)));
      paramView = new SDKSetEmotionPreviewFragment.PreviewGridAdapter.Holder(this);
      paramView.a = ((URLImageView)localView.findViewById(2131432411));
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (SDKSetEmotionPreviewFragment.PreviewGridAdapter.Holder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject1 = (String)this.a.get(paramInt);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = BaseImageUtil.c((String)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = true;
    localObject2 = URLDrawable.getFileDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
    paramView.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramView.a.setImageDrawable((Drawable)localObject2);
    localObject2 = paramView.a;
    paramView.a.setOnClickListener(new SDKSetEmotionPreviewFragment.PreviewGridAdapter.1(this, (String)localObject1, (View)localObject2));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment.PreviewGridAdapter
 * JD-Core Version:    0.7.0.1
 */