package com.tencent.mobileqq.emoticonview;

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
import com.tencent.mobileqq.activity.photo.OnProGalleryListener;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class EmotionPreviewAdapter
  extends BaseAdapter
  implements OnProGalleryListener
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
    this.mDefaultPhotoDrawable = this.mContext.getResources().getDrawable(2130848074);
    this.imageHeight = AIOUtils.b(207.0F, this.mContext.getResources());
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
    List localList = this.dataList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public EmotionPreviewInfo getItem(int paramInt)
  {
    List localList = this.dataList;
    if ((localList != null) && (paramInt < localList.size())) {
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
    if (paramView != null)
    {
      localObject1 = paramView;
    }
    else
    {
      URLImageView localURLImageView = new URLImageView(this.mContext);
      localObject1 = getItem(paramInt);
      if ((localObject1 != null) && (!TextUtils.isEmpty(((EmotionPreviewInfo)localObject1).path)))
      {
        Object localObject2 = (URLDrawable)this.mActiveDrawable.get(paramInt);
        if (localObject2 != null)
        {
          localURLImageView.setImageDrawable((Drawable)localObject2);
        }
        else
        {
          Object localObject3 = new File(((EmotionPreviewInfo)localObject1).path);
          localObject1 = null;
          if (((File)localObject3).exists())
          {
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            int i = this.imageHeight;
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = i;
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = i;
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.mDefaultPhotoDrawable;
            ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
            localObject3 = getFileUrl((File)localObject3);
            if (localObject3 != null)
            {
              localObject2 = URLDrawable.getDrawable((URL)localObject3, (URLDrawable.URLDrawableOptions)localObject2);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                i = ((URLDrawable)localObject2).getStatus();
                localObject1 = localObject2;
                if (i != 1)
                {
                  localObject1 = localObject2;
                  if (i != 2)
                  {
                    localObject1 = localObject2;
                    if (i != 3)
                    {
                      ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
                      ((URLDrawable)localObject2).startDownload();
                      localObject1 = localObject2;
                    }
                  }
                }
              }
            }
            if (localObject1 != null)
            {
              localURLImageView.setImageDrawable((Drawable)localObject1);
              this.mActiveDrawable.put(paramInt, localObject1);
            }
            else
            {
              localURLImageView.setImageDrawable(this.mDefaultPhotoDrawable);
            }
          }
          else
          {
            localURLImageView.setImageDrawable(this.mDefaultPhotoDrawable);
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("照片");
        ((StringBuilder)localObject1).append(paramInt);
        localURLImageView.setContentDescription(((StringBuilder)localObject1).toString());
        localObject1 = localURLImageView;
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getView Path is empty. position ");
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append(", size ");
          ((StringBuilder)localObject1).append(getCount());
          QLog.i("EmotionPreviewAdapter", 2, ((StringBuilder)localObject1).toString());
        }
        localURLImageView.setImageDrawable(URLDrawableHelperConstants.a);
        localObject1 = localURLImageView;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.mActiveDrawable.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 3)
      {
        paramView.restartDownload();
        return null;
      }
    }
    else
    {
      paramView = getItem(paramInt);
      if ((paramView == null) || (TextUtils.isEmpty(paramView.path))) {
        break label145;
      }
      paramViewGroup = new File(paramView.path);
      if (paramViewGroup.exists())
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        int i = this.imageHeight;
        paramView.mRequestWidth = i;
        paramView.mRequestHeight = i;
        paramView.mLoadingDrawable = URLDrawableHelperConstants.a;
        paramView.mPlayGifImage = true;
        paramViewGroup = getFileUrl(paramViewGroup);
        if (paramViewGroup != null)
        {
          paramView = URLDrawable.getDrawable(paramViewGroup, paramView);
          paramView.setTag(Integer.valueOf(1));
          paramView.startDownload();
          this.mActiveDrawable.put(paramInt, paramView);
        }
      }
    }
    return null;
    label145:
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onCreateView Path is empty. position ");
      paramView.append(paramInt);
      paramView.append(", size ");
      paramView.append(getCount());
      QLog.i("EmotionPreviewAdapter", 2, paramView.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */