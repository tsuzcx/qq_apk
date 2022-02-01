package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.emoticonview.sender.FavoriteEmoticonInfoSender;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;

public class FavoriteEmoticonInfo
  extends CustomEmoticonInfoBase
  implements Parcelable, ICustomEmotionInfo, IFavoriteEmoticonInfo
{
  public static final Parcelable.Creator<FavoriteEmoticonInfo> CREATOR = new FavoriteEmoticonInfo.1();
  public static final String TAG = "FavoriteEmoticonInfo";
  public String actionData;
  private ColorDrawable mEmptyDrawable = new ColorDrawable();
  
  public FavoriteEmoticonInfo()
  {
    this.longClickAction = "show_fav_menu";
  }
  
  protected FavoriteEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.actionData = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    try
    {
      Object localObject = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      int i = (int)(paramFloat * 100.0F);
      localURLDrawableOptions.mRequestHeight = i;
      localURLDrawableOptions.mRequestWidth = i;
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130846453);
      localURLDrawableOptions.mLoadingDrawable = this.mEmptyDrawable;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("d: width = ");
        ((StringBuilder)localObject).append(paramContext.getIntrinsicWidth());
        ((StringBuilder)localObject).append(";height = ");
        ((StringBuilder)localObject).append(paramContext.getIntrinsicHeight());
        ((StringBuilder)localObject).append(";options:width = ");
        ((StringBuilder)localObject).append(localURLDrawableOptions.mRequestWidth);
        ((StringBuilder)localObject).append(";options:height = ");
        ((StringBuilder)localObject).append(localURLDrawableOptions.mRequestHeight);
        QLog.d("FavoriteEmoticonInfo", 2, ((StringBuilder)localObject).toString());
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL_DYNAMIC", this.path);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = paramInt1;
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130846453);
      localURLDrawableOptions.mLoadingDrawable = this.mEmptyDrawable;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("d: width = ");
        ((StringBuilder)localObject).append(paramContext.getIntrinsicWidth());
        ((StringBuilder)localObject).append(";height = ");
        ((StringBuilder)localObject).append(paramContext.getIntrinsicHeight());
        ((StringBuilder)localObject).append(";options:width = ");
        ((StringBuilder)localObject).append(localURLDrawableOptions.mRequestWidth);
        ((StringBuilder)localObject).append(";options:height = ");
        ((StringBuilder)localObject).append(localURLDrawableOptions.mRequestHeight);
        QLog.d("FavoriteEmoticonInfo", 2, ((StringBuilder)localObject).toString());
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    Object localObject3 = new ColorDrawable();
    Object localObject1 = localObject3;
    Object localObject2 = localObject3;
    Object localObject4;
    try
    {
      localObject4 = paramContext.getResources();
      localObject1 = localObject3;
      localObject2 = localObject3;
      paramContext = ((Resources)localObject4).getDrawable(2130846447);
      localObject1 = paramContext;
      localObject2 = paramContext;
      localObject3 = ((Resources)localObject4).getDrawable(2130846453);
      localObject1 = localObject3;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      paramContext = (Context)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.e("FavoriteEmoticonInfo", 2, localOutOfMemoryError.getMessage());
        paramContext = (Context)localObject1;
      }
      localObject1 = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramContext = localOutOfMemoryError;
        if (QLog.isColorLevel())
        {
          QLog.e("FavoriteEmoticonInfo", 2, localException.getMessage());
          paramContext = localOutOfMemoryError;
        }
      }
    }
    try
    {
      localObject3 = new URL("protocol_vas_extension_image", "FAVORITE_PANEL_THUMB", this.path);
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = this.path;
      localLocalMediaInfo.thumbWidth = 100;
      localLocalMediaInfo.thumbHeight = 100;
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = paramContext;
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = localException;
      ((URLDrawable.URLDrawableOptions)localObject4).mExtraInfo = this;
      if (!TextUtils.isEmpty(this.path))
      {
        paramContext = URLDrawable.getDrawable((URL)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
        paramContext.setTag(localLocalMediaInfo);
        return paramContext;
      }
      paramContext = new StringBuilder();
      paramContext.append("FavoriteEmoticonInfo path is null! ");
      paramContext.append(toString());
      QLog.e("FavoriteEmoticonInfo", 1, paramContext.toString());
      return null;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
      QLog.e("FavoriteEmoticonInfo", 1, "FavoriteEmoticonInfo: MalformedURLException", paramContext);
    }
    return null;
  }
  
  public String getEid()
  {
    return this.eId;
  }
  
  public int getEmoId()
  {
    return this.emoId;
  }
  
  public int getEmoType()
  {
    return 0;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public String getResID()
  {
    return this.resID;
  }
  
  public String getRoamingType()
  {
    return this.roamingType;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public Drawable getZoomDrawable(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    Object localObject3 = new ColorDrawable();
    Object localObject1 = localObject3;
    Object localObject2 = localObject3;
    Object localObject4;
    try
    {
      localObject4 = paramContext.getResources();
      localObject1 = localObject3;
      localObject2 = localObject3;
      paramContext = ((Resources)localObject4).getDrawable(2130846447);
      localObject1 = paramContext;
      localObject2 = paramContext;
      localObject3 = ((Resources)localObject4).getDrawable(2130846453);
      localObject1 = localObject3;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      paramContext = (Context)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.e("FavoriteEmoticonInfo", 2, localOutOfMemoryError.getMessage());
        paramContext = (Context)localObject1;
      }
      localObject1 = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramContext = localOutOfMemoryError;
        if (QLog.isColorLevel())
        {
          QLog.e("FavoriteEmoticonInfo", 2, localException.getMessage());
          paramContext = localOutOfMemoryError;
        }
      }
    }
    try
    {
      localObject3 = new URL("protocol_vas_extension_image", "FAVORITE_PANEL_THUMB_NEW", this.path);
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = this.path;
      localLocalMediaInfo.thumbWidth = paramInt1;
      localLocalMediaInfo.thumbHeight = paramInt2;
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = paramContext;
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = localException;
      ((URLDrawable.URLDrawableOptions)localObject4).mExtraInfo = this;
      if (!TextUtils.isEmpty(this.path))
      {
        paramContext = URLDrawable.getDrawable((URL)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
        paramContext.setTag(localLocalMediaInfo);
        return paramContext;
      }
      paramContext = new StringBuilder();
      paramContext.append("getZoomDrawable path is null! ");
      paramContext.append(toString());
      QLog.e("FavoriteEmoticonInfo", 1, paramContext.toString());
      return null;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
      QLog.e("FavoriteEmoticonInfo", 1, "getZoomDrawable: MalformedURLException", paramContext);
    }
    return null;
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    FavoriteEmoticonInfoSender.send(this, paramAppRuntime, paramContext, paramEditText, paramParcelable);
  }
  
  public void setIsChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public String toString()
  {
    return String.format("FavoriteEmoticonInfo, path %s, url %s", new Object[] { this.path, this.url });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.actionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */