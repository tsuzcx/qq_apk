package com.tencent.mobileqq.gallery.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.galleryactivity.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class BigImageAdapter
  extends BaseAdapter
{
  SparseArray<URLDrawable> a = new SparseArray();
  int b = -1;
  private List<String> c;
  
  public BigImageAdapter(List<String> paramList)
  {
    this.c = paramList;
  }
  
  public String a(int paramInt)
  {
    List localList = this.c;
    if ((localList != null) && (paramInt < localList.size()) && (paramInt >= 0)) {
      return (String)this.c.get(paramInt);
    }
    return null;
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.startsWith("//"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file:/");
      ((StringBuilder)localObject).append(paramString);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = paramString;
    if (paramString.startsWith("/"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file://");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public int getCount()
  {
    List localList = this.c;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramView != null)
    {
      localObject1 = paramView;
    }
    else
    {
      Object localObject2 = a(a(paramInt));
      Object localObject3 = (URLDrawable)this.a.get(paramInt);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getView position=");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(",cache=");
        ((StringBuilder)localObject1).append(localObject3);
        ((StringBuilder)localObject1).append(",url=");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("BigImageAdapter", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = new URLImageView2(paramViewGroup.getContext());
      if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 1))
      {
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
      }
      else if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        int i = paramViewGroup.getWidth();
        int j = paramViewGroup.getHeight();
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = URLDrawableHelperConstants.a;
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        int k = ((URLDrawable)localObject2).getStatus();
        if ((k != 1) && (k != 2) && (k != 3))
        {
          ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
          ((URLDrawable)localObject2).startDownload();
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getView position=");
          ((StringBuilder)localObject3).append(paramInt);
          ((StringBuilder)localObject3).append(",parentWidth=");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(",parentHeight=");
          ((StringBuilder)localObject3).append(j);
          QLog.d("BigImageAdapter", 2, ((StringBuilder)localObject3).toString());
        }
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131905941));
      ((StringBuilder)localObject2).append(paramInt);
      ((ImageView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.BigImageAdapter
 * JD-Core Version:    0.7.0.1
 */