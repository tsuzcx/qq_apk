package com.tencent.mobileqq.mini.out.activity;

import akki;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import anvx;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.ArrayList;

class PhotoPreviewActivity$ImageAdapter
  extends BaseAdapter
  implements akki
{
  SparseArray<URLDrawable> mActiveDrawable = new SparseArray();
  URLDrawable mRawDrawable;
  int mRawDrawablePosition = -1;
  
  PhotoPreviewActivity$ImageAdapter(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public int getCount()
  {
    if (this.this$0.paths != null) {
      return this.this$0.paths.size();
    }
    return 0;
  }
  
  public String getItem(int paramInt)
  {
    if ((this.this$0.paths != null) && (paramInt < this.this$0.paths.size()) && (paramInt >= 0)) {
      return (String)this.this$0.paths.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    Object localObject2 = this.this$0.getURL(getItem(paramInt));
    Object localObject3 = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "getView position=" + paramInt + ",cache=" + localObject3 + ",url=" + (String)localObject2);
    }
    Object localObject1 = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
    if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 1)) {
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
    }
    for (;;)
    {
      ((ImageView)localObject1).setContentDescription(anvx.a(2131707598) + paramInt);
      break;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        int i = paramViewGroup.getWidth();
        int j = paramViewGroup.getHeight();
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        switch (((URLDrawable)localObject2).getStatus())
        {
        default: 
          ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
          ((URLDrawable)localObject2).startDownload();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "getView position=" + paramInt + ",parentWidth=" + i + ",parentHeight=" + j);
        }
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      }
    }
  }
  
  String listActiviteDrawables()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(preview) Actives: ");
    int i = 0;
    while (i < this.mActiveDrawable.size())
    {
      if (i > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(this.mActiveDrawable.keyAt(i) + 1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, listActiviteDrawables());
      }
      do
      {
        return null;
        paramView = this.this$0.getURL(getItem(paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "onCreateView position=" + paramInt + ", url=" + paramView);
        }
      } while (TextUtils.isEmpty(paramView));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramViewGroup.getWidth();
      localURLDrawableOptions.mRequestHeight = paramViewGroup.getHeight();
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      paramView = URLDrawable.getDrawable(paramView, localURLDrawableOptions);
      paramView.setTag(Integer.valueOf(1));
      paramView.startDownload();
      this.mActiveDrawable.put(paramInt, paramView);
    }
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.mActiveDrawable.remove(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, listActiviteDrawables());
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (!ImageView.class.isInstance(paramView)) {}
    do
    {
      return;
      paramView = ((ImageView)paramView).getDrawable();
    } while (!URLDrawable.class.isInstance(paramView));
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramInt == this.mRawDrawablePosition)
    {
      if ((this.mRawDrawable != null) && (this.mRawDrawable.getStatus() == 0)) {
        this.mRawDrawable.cancelDownload(true);
      }
      this.mRawDrawable = null;
      this.mRawDrawablePosition = -1;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "(preview)destory rawDrawable, position: " + paramInt);
      }
    }
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!(paramView instanceof AbstractImageAdapter.URLImageView2)) {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "onscaleBegin,classcast error,class of current view is " + paramView.getClass().toString());
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramView = (AbstractImageAdapter.URLImageView2)paramView;
          paramViewGroup = paramView.getDrawable();
          localObject = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
        } while ((!(paramViewGroup instanceof URLDrawable)) || (!((URLDrawable)paramViewGroup).isFakeSize()) || (localObject != null));
        paramViewGroup = ((URLDrawable)paramViewGroup).getURL();
      } while ((!"file".equals(paramViewGroup.getProtocol())) || (paramViewGroup.getRef() != null));
      if ((paramInt != this.mRawDrawablePosition) || (this.mRawDrawable == null)) {
        break;
      }
      paramView = this.mRawDrawable;
    } while ((!QLog.isColorLevel()) || (this.mRawDrawable == null));
    QLog.d("PhotoPreviewActivity", 2, "use exist raw drawable");
    return;
    if ((QLog.isColorLevel()) && (this.mRawDrawable != null)) {
      QLog.d("PhotoPreviewActivity", 2, "rawDrawable is exist");
    }
    paramViewGroup = paramViewGroup.toString() + "#NOSAMPLE";
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
    paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject);
    paramViewGroup.setTag(Integer.valueOf(2));
    this.mRawDrawable = null;
    this.mRawDrawablePosition = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "create rawDrawable, position:" + paramInt);
    }
    if (paramViewGroup.getStatus() == 1)
    {
      paramView.jdField_a_of_type_Boolean = true;
      paramView.setImageDrawable(paramViewGroup);
      paramView.jdField_a_of_type_Boolean = false;
      return;
    }
    paramView.setDecodingDrawble(paramViewGroup);
    paramViewGroup.startDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PhotoPreviewActivity.ImageAdapter
 * JD-Core Version:    0.7.0.1
 */