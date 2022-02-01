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
  private Context a;
  private List<FileBrowserModelBase.ImageFileInfo> b;
  private int c;
  private Drawable d;
  private Drawable e;
  private Drawable f = null;
  private SparseArray<URLDrawable> g = new SparseArray();
  
  public ImageGalleryAdapter(Context paramContext)
  {
    this.a = paramContext;
    this.c = this.a.getResources().getDisplayMetrics().densityDpi;
    this.d = paramContext.getResources().getDrawable(2130853414);
    this.e = paramContext.getResources().getDrawable(2130839590);
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
    this.b = paramList;
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.b;
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
      localView = LayoutInflater.from(this.a).inflate(2131627098, null);
      paramView = new ImageGalleryAdapter.ImagePhotoHolder(this, null);
      paramView.a = ((URLImageView)localView.findViewById(2131435357));
      paramView.b = ((TextView)localView.findViewById(2131447419));
      paramView.c = ((ProgressBar)localView.findViewById(2131440737));
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
      paramView.a.setImageDrawable(this.d);
    }
    else
    {
      URL localURL = ((FileBrowserModelBase.ImageFileInfo)localObject1).b();
      int i = ((FileBrowserModelBase.ImageFileInfo)localObject1).d();
      if (localURL != null)
      {
        Object localObject2 = this.e;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
        localURLDrawableOptions.mFailedDrawable = this.d;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mUseExifOrientation = false;
        localObject2 = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        ((URLDrawable)localObject2).setTargetDensity(this.c);
        paramView.a.setImageDrawable((Drawable)localObject2);
        if (((FileBrowserModelBase.ImageFileInfo)localObject1).a()) {
          paramView.c.setVisibility(0);
        } else {
          paramView.c.setVisibility(4);
        }
        a(localView, (URLDrawable)localObject2, ((FileBrowserModelBase.ImageFileInfo)localObject1).e());
        if ((i == 1) && (AsyncImageView.a(localURL)) && (FileUtil.d(((FileBrowserModelBase.ImageFileInfo)localObject1).g())))
        {
          ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
          this.g.put(paramInt, localObject2);
        }
        else
        {
          this.g.remove(paramInt);
        }
      }
      else
      {
        paramView.a.setImageDrawable(this.d);
        if (!((FileBrowserModelBase.ImageFileInfo)localObject1).f())
        {
          paramView.b.setVisibility(0);
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
    paramView = (URLDrawable)this.g.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.g.remove(paramInt);
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    paramView = (URLDrawable)this.g.get(paramInt);
    if (paramView != null) {
      paramView.updateRegionBitmap(paramRegionDrawableData);
    }
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ImageGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */