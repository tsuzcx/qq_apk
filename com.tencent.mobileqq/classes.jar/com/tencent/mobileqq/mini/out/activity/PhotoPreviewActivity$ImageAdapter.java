package com.tencent.mobileqq.mini.out.activity;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

class PhotoPreviewActivity$ImageAdapter
  extends BaseAdapter
  implements ProGallery.OnProGalleryListener
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
    if (paramView != null) {
      return paramView;
    }
    String str = this.this$0.getURL(getItem(paramInt));
    URLDrawable localURLDrawable = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "getView position=" + paramInt + ",cache=" + localURLDrawable + ",url=" + str);
    }
    paramView = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
    if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1)) {
      paramView.setImageDrawable(localURLDrawable);
    }
    for (;;)
    {
      paramView.setContentDescription(HardCodeUtil.a(2131708125) + paramInt);
      return paramView;
      if (!TextUtils.isEmpty(str))
      {
        int i = paramViewGroup.getWidth();
        int j = paramViewGroup.getHeight();
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mRequestWidth = i;
        paramViewGroup.mRequestHeight = j;
        paramViewGroup.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
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