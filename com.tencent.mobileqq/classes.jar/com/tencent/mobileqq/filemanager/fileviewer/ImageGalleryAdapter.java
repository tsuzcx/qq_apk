package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.OnProGalleryListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.ImageFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.List;

public class ImageGalleryAdapter
  extends BaseAdapter
  implements OnProGalleryListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private List<FileBrowserModelBase.ImageFileInfo> jdField_a_of_type_JavaUtilList;
  private Drawable b;
  private Drawable c = null;
  
  public ImageGalleryAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130851160);
    this.b = paramContext.getResources().getDrawable(2130839406);
  }
  
  private void a(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 6)
      {
        if (paramInt != 8) {
          paramInt = 0;
        } else {
          paramInt = 3;
        }
      }
      else {
        paramInt = 1;
      }
    }
    else {
      paramInt = 2;
    }
    boolean bool = paramURLDrawable.isAnim() ^ true;
    paramView.setTag(2131296390, Boolean.valueOf(bool));
    if (bool) {
      paramView.setTag(2131296389, Integer.valueOf(paramInt));
    }
  }
  
  public void a(List<FileBrowserModelBase.ImageFileInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560840, null);
      paramView = new ImageGalleryAdapter.ImagePhotoHolder(this, null);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131368461));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378745));
      paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131373132));
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (ImageGalleryAdapter.ImagePhotoHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject1 = (FileBrowserModelBase.ImageFileInfo)getItem(paramInt);
    if (localObject1 == null)
    {
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    else
    {
      URL localURL = ((FileBrowserModelBase.ImageFileInfo)localObject1).a();
      int i = ((FileBrowserModelBase.ImageFileInfo)localObject1).a();
      if (localURL != null)
      {
        Object localObject2 = this.b;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mUseExifOrientation = false;
        localObject2 = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        ((URLDrawable)localObject2).setTargetDensity(this.jdField_a_of_type_Int);
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        if (((FileBrowserModelBase.ImageFileInfo)localObject1).a()) {
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        } else {
          paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        }
        a(localView, (URLDrawable)localObject2, ((FileBrowserModelBase.ImageFileInfo)localObject1).b());
        if ((i == 1) && (AsyncImageView.a(localURL)) && (FileUtil.b(((FileBrowserModelBase.ImageFileInfo)localObject1).b())))
        {
          ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject2);
        }
        else
        {
          this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
        }
      }
      else
      {
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        if (!((FileBrowserModelBase.ImageFileInfo)localObject1).b())
        {
          paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          localView.setTag(2131296386, Float.valueOf(1.0F));
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null) {
      paramView.updateRegionBitmap(paramRegionDrawableData);
    }
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ImageGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */