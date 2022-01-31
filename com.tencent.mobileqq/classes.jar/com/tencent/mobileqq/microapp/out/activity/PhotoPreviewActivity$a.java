package com.tencent.mobileqq.microapp.out.activity;

import agdg;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import axwd;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

final class PhotoPreviewActivity$a
  extends BaseAdapter
  implements agdg
{
  SparseArray a = new SparseArray();
  URLDrawable b;
  int c = -1;
  
  PhotoPreviewActivity$a(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(preview) Actives: ");
    int i = 0;
    while (i < this.a.size())
    {
      if (i > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(this.a.keyAt(i) + 1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String a(int paramInt)
  {
    if ((this.d.b != null) && (paramInt < this.d.b.size()) && (paramInt >= 0)) {
      return (String)this.d.b.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.d.b != null) {
      return this.d.b.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {
      return paramView;
    }
    String str = this.d.a(a(paramInt));
    URLDrawable localURLDrawable = (URLDrawable)this.a.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "getView position=" + paramInt + ",cache=" + localURLDrawable + ",url=" + str);
    }
    paramView = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
    if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1)) {
      paramView.setImageDrawable(localURLDrawable);
    }
    for (;;)
    {
      paramView.setContentDescription("照片" + paramInt);
      return paramView;
      if (!TextUtils.isEmpty(str))
      {
        int i = paramViewGroup.getWidth();
        int j = paramViewGroup.getHeight();
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mRequestWidth = i;
        paramViewGroup.mRequestHeight = j;
        paramViewGroup.mLoadingDrawable = axwd.a;
        paramViewGroup = URLDrawable.getDrawable(str, paramViewGroup);
        switch (paramViewGroup.getStatus())
        {
        default: 
          paramViewGroup.setTag(Integer.valueOf(1));
          paramViewGroup.startDownload();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "getView position=" + paramInt + ",parentWidth=" + i + ",parentHeight=" + j);
        }
        paramView.setImageDrawable(paramViewGroup);
      }
    }
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.a.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, a());
      }
      do
      {
        return null;
        paramView = this.d.a(a(paramInt));
        if (QLog.isColorLevel()) {
          QLog.d("PhotoPreviewActivity", 2, "onCreateView position=" + paramInt + ", url=" + paramView);
        }
      } while (TextUtils.isEmpty(paramView));
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramViewGroup.getWidth();
      localURLDrawableOptions.mRequestHeight = paramViewGroup.getHeight();
      localURLDrawableOptions.mLoadingDrawable = axwd.a;
      paramView = URLDrawable.getDrawable(paramView, localURLDrawableOptions);
      paramView.setTag(Integer.valueOf(1));
      paramView.startDownload();
      this.a.put(paramInt, paramView);
    }
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.a.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.a.remove(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, a());
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
    if (paramInt == this.c)
    {
      if ((this.b != null) && (this.b.getStatus() == 0)) {
        this.b.cancelDownload(true);
      }
      this.b = null;
      this.c = -1;
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
      if ((paramInt != this.c) || (this.b == null)) {
        break;
      }
    } while ((!QLog.isColorLevel()) || (this.b == null));
    QLog.d("PhotoPreviewActivity", 2, "use exist raw drawable");
    return;
    if ((QLog.isColorLevel()) && (this.b != null)) {
      QLog.d("PhotoPreviewActivity", 2, "rawDrawable is exist");
    }
    paramViewGroup = paramViewGroup.toString() + "#NOSAMPLE";
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
    paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject);
    paramViewGroup.setTag(Integer.valueOf(2));
    this.b = null;
    this.c = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.PhotoPreviewActivity.a
 * JD-Core Version:    0.7.0.1
 */