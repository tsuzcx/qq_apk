package com.tencent.mobileqq.emoticonview;

import akki;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class EmotionPreviewAdapter
  extends BaseAdapter
  implements akki
{
  private static final String TAG = "EmotionPreviewAdapter";
  private List<EmotionPreviewInfo> dataList;
  private int imageHeight;
  private SparseArray<URLDrawable> mActiveDrawable = new SparseArray();
  private Context mContext;
  private Drawable mDefaultPhotoDrawable;
  
  public EmotionPreviewAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.mDefaultPhotoDrawable = this.mContext.getResources().getDrawable(2130847846);
    this.imageHeight = AIOUtils.dp2px(207.0F, this.mContext.getResources());
  }
  
  private URL getFileUrl(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = paramFile.toURI().toURL();
      return paramFile;
    }
    catch (MalformedURLException paramFile) {}
    return null;
  }
  
  public static Bitmap zoomImg(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  public int getBitmapWidth(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return Math.min(Math.max(localOptions.outWidth, localOptions.outHeight), this.imageHeight);
  }
  
  public int getCount()
  {
    if (this.dataList != null) {
      return this.dataList.size();
    }
    return 0;
  }
  
  public EmotionPreviewInfo getItem(int paramInt)
  {
    if ((this.dataList != null) && (paramInt < this.dataList.size())) {
      return (EmotionPreviewInfo)this.dataList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramView != null) {
      localObject1 = paramView;
    }
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = new URLImageView(this.mContext);
      localObject2 = getItem(paramInt);
      if ((localObject2 != null) && (!TextUtils.isEmpty(((EmotionPreviewInfo)localObject2).path))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("EmotionPreviewAdapter", 2, "getView Path is empty. position " + paramInt + ", size " + getCount());
      }
      ((URLImageView)localObject1).setImageDrawable(URLDrawableHelper.TRANSPARENT);
    }
    Object localObject3 = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (localObject3 != null) {
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject3);
    }
    for (;;)
    {
      ((URLImageView)localObject1).setContentDescription("照片" + paramInt);
      break;
      Object localObject4 = new File(((EmotionPreviewInfo)localObject2).path);
      localObject2 = null;
      if (((File)localObject4).exists())
      {
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.imageHeight;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.imageHeight;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = this.mDefaultPhotoDrawable;
        ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
        localObject4 = getFileUrl((File)localObject4);
        if (localObject4 != null)
        {
          localObject3 = URLDrawable.getDrawable((URL)localObject4, (URLDrawable.URLDrawableOptions)localObject3);
          localObject2 = localObject3;
          if (localObject3 != null)
          {
            localObject2 = localObject3;
            switch (((URLDrawable)localObject3).getStatus())
            {
            default: 
              ((URLDrawable)localObject3).setTag(Integer.valueOf(1));
              ((URLDrawable)localObject3).startDownload();
              localObject2 = localObject3;
            }
          }
        }
        if (localObject2 != null)
        {
          ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
          this.mActiveDrawable.put(paramInt, localObject2);
        }
        else
        {
          ((URLImageView)localObject1).setImageDrawable(this.mDefaultPhotoDrawable);
        }
      }
      else
      {
        ((URLImageView)localObject1).setImageDrawable(this.mDefaultPhotoDrawable);
      }
    }
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          paramView = getItem(paramInt);
          if ((paramView != null) && (!TextUtils.isEmpty(paramView.path))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("EmotionPreviewAdapter", 2, "onCreateView Path is empty. position " + paramInt + ", size " + getCount());
        return null;
        paramViewGroup = new File(paramView.path);
      } while (!paramViewGroup.exists());
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = this.imageHeight;
      paramView.mRequestHeight = this.imageHeight;
      paramView.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      paramView.mPlayGifImage = true;
      paramViewGroup = getFileUrl(paramViewGroup);
    } while (paramViewGroup == null);
    paramView = URLDrawable.getDrawable(paramViewGroup, paramView);
    paramView.setTag(Integer.valueOf(1));
    paramView.startDownload();
    this.mActiveDrawable.put(paramInt, paramView);
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
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData) {}
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void refreshData(List<EmotionPreviewInfo> paramList)
  {
    this.dataList = paramList;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */