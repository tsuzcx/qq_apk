package com.tencent.mobileqq.mini.out.activity;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.galleryactivity.URLImageView2;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.OnProGalleryListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

class PhotoPreviewActivity$ImageAdapter
  extends BaseAdapter
  implements OnProGalleryListener
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
    Object localObject = this.this$0.getURL(getItem(paramInt));
    URLDrawable localURLDrawable = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("getView position=");
      paramView.append(paramInt);
      paramView.append(",cache=");
      paramView.append(localURLDrawable);
      paramView.append(",url=");
      paramView.append((String)localObject);
      QLog.d("PhotoPreviewActivity", 2, paramView.toString());
    }
    paramView = new URLImageView2(paramViewGroup.getContext());
    if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1))
    {
      paramView.setImageDrawable(localURLDrawable);
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      int i = paramViewGroup.getWidth();
      int j = paramViewGroup.getHeight();
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup.mRequestWidth = i;
      paramViewGroup.mRequestHeight = j;
      paramViewGroup.mLoadingDrawable = URLDrawableHelperConstants.a;
      paramViewGroup = URLDrawable.getDrawable((String)localObject, paramViewGroup);
      int k = paramViewGroup.getStatus();
      if ((k != 1) && (k != 2) && (k != 3))
      {
        paramViewGroup.setTag(Integer.valueOf(1));
        paramViewGroup.startDownload();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getView position=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(",parentWidth=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(",parentHeight=");
        ((StringBuilder)localObject).append(j);
        QLog.d("PhotoPreviewActivity", 2, ((StringBuilder)localObject).toString());
      }
      paramView.setImageDrawable(paramViewGroup);
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append(HardCodeUtil.a(2131708144));
    paramViewGroup.append(paramInt);
    paramView.setContentDescription(paramViewGroup.toString());
    return paramView;
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
    if (paramView != null)
    {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    else
    {
      paramView = this.this$0.getURL(getItem(paramInt));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCreateView position=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", url=");
        ((StringBuilder)localObject).append(paramView);
        QLog.d("PhotoPreviewActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (TextUtils.isEmpty(paramView)) {
        return null;
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramViewGroup.getWidth();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramViewGroup.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
      paramView = URLDrawable.getDrawable(paramView, (URLDrawable.URLDrawableOptions)localObject);
      paramView.setTag(Integer.valueOf(1));
      paramView.startDownload();
      this.mActiveDrawable.put(paramInt, paramView);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, listActiviteDrawables());
    }
    return null;
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
    if (!ImageView.class.isInstance(paramView)) {
      return;
    }
    paramView = ((ImageView)paramView).getDrawable();
    if (!URLDrawable.class.isInstance(paramView)) {
      return;
    }
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramInt == this.mRawDrawablePosition)
    {
      paramView = this.mRawDrawable;
      if ((paramView != null) && (paramView.getStatus() == 0)) {
        this.mRawDrawable.cancelDownload(true);
      }
      this.mRawDrawable = null;
      this.mRawDrawablePosition = -1;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("(preview)destory rawDrawable, position: ");
        paramView.append(paramInt);
        QLog.d("PhotoPreviewActivity", 2, paramView.toString());
      }
    }
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!(paramView instanceof URLImageView2))
    {
      if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("onscaleBegin,classcast error,class of current view is ");
        paramViewGroup.append(paramView.getClass().toString());
        QLog.d("PhotoPreviewActivity", 2, paramViewGroup.toString());
      }
      return;
    }
    paramView = (URLImageView2)paramView;
    Object localObject = paramView.getDrawable();
    paramViewGroup = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((localObject instanceof URLDrawable))
    {
      localObject = (URLDrawable)localObject;
      if ((((URLDrawable)localObject).isFakeSize()) && (paramViewGroup == null))
      {
        paramViewGroup = ((URLDrawable)localObject).getURL();
        if (("file".equals(paramViewGroup.getProtocol())) && (paramViewGroup.getRef() == null)) {
          if ((paramInt == this.mRawDrawablePosition) && (this.mRawDrawable != null))
          {
            if ((QLog.isColorLevel()) && (this.mRawDrawable != null)) {
              QLog.d("PhotoPreviewActivity", 2, "use exist raw drawable");
            }
          }
          else
          {
            if ((QLog.isColorLevel()) && (this.mRawDrawable != null)) {
              QLog.d("PhotoPreviewActivity", 2, "rawDrawable is exist");
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramViewGroup.toString());
            ((StringBuilder)localObject).append("#NOSAMPLE");
            paramViewGroup = ((StringBuilder)localObject).toString();
            localObject = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
            ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
            paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject);
            paramViewGroup.setTag(Integer.valueOf(2));
            this.mRawDrawable = null;
            this.mRawDrawablePosition = paramInt;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("create rawDrawable, position:");
              ((StringBuilder)localObject).append(paramInt);
              QLog.d("PhotoPreviewActivity", 2, ((StringBuilder)localObject).toString());
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
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.PhotoPreviewActivity.ImageAdapter
 * JD-Core Version:    0.7.0.1
 */