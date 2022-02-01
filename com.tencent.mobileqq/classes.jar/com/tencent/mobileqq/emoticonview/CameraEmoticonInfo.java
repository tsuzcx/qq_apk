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
import com.tencent.mobileqq.emoticonview.api.ICameraEmoticonSenderService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;

public class CameraEmoticonInfo
  extends CustomEmoticonInfoBase
  implements Parcelable, ICustomEmotionInfo
{
  public static final Parcelable.Creator<CameraEmoticonInfo> CREATOR = new CameraEmoticonInfo.1();
  public static final String TAG = "CameraEmoticonInfo";
  public String contextKey;
  private ColorDrawable mEmptyDrawable = new ColorDrawable();
  public String templateId;
  public String thumbPath;
  
  public CameraEmoticonInfo() {}
  
  protected CameraEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.contextKey = paramParcel.readString();
    this.thumbPath = paramParcel.readString();
    this.templateId = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    try
    {
      Object localObject = new URL("protocol_vas_extension_image", "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.path);
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
        QLog.d("CameraEmoticonInfo", 2, ((StringBuilder)localObject).toString());
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public Drawable getBigDrawable(Context paramContext, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new URL("protocol_vas_extension_image", "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC", this.path);
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
        QLog.d("CameraEmoticonInfo", 2, ((StringBuilder)localObject).toString());
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
    Object localObject1 = this.path;
    Object localObject2;
    if (!this.roamingType.equals("needUpload"))
    {
      localObject2 = localObject1;
      if (!this.roamingType.equals("failed")) {}
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (new File((String)localObject1).exists()) {}
    }
    else
    {
      localObject2 = this.thumbPath;
    }
    for (;;)
    {
      try
      {
        localObject1 = paramContext.getResources();
        paramContext = ((Resources)localObject1).getDrawable(2130846447);
        try
        {
          localObject1 = ((Resources)localObject1).getDrawable(2130846453);
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          localObject1 = paramContext;
        }
        catch (Exception localException1)
        {
          localObject1 = paramContext;
        }
        paramContext = (Context)localObject1;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        localObject1 = null;
        paramContext = (Context)localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e("CameraEmoticonInfo", 2, localOutOfMemoryError2.getMessage());
          paramContext = (Context)localObject1;
        }
        localObject1 = null;
      }
      catch (Exception localException2)
      {
        localObject1 = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.e("CameraEmoticonInfo", 2, localException2.getMessage());
        paramContext = (Context)localObject1;
      }
    }
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "BUSINESS_CAMERA_EMO_PANEL_THUMB", (String)localObject2);
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = ((String)localObject2);
      localLocalMediaInfo.thumbWidth = 100;
      localLocalMediaInfo.thumbHeight = 100;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramContext;
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
      localURLDrawableOptions.mExtraInfo = this;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        paramContext.setTag(localLocalMediaInfo);
        return paramContext;
      }
      paramContext = new StringBuilder();
      paramContext.append("CameraEmoticonInfo path is null! ");
      paramContext.append(toString());
      QLog.e("CameraEmoticonInfo", 1, paramContext.toString());
      return null;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
      QLog.e("CameraEmoticonInfo", 1, "CameraEmoticonInfo: MalformedURLException", paramContext);
    }
    return null;
  }
  
  public int getEmoId()
  {
    return this.emoId;
  }
  
  public int getEmoType()
  {
    return 2;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public String getRoamingType()
  {
    return this.roamingType;
  }
  
  public Drawable getZoomDrawable(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    return getDrawable(paramContext, paramFloat);
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    ((ICameraEmoticonSenderService)QRoute.api(ICameraEmoticonSenderService.class)).send(this, paramAppRuntime, paramContext, paramEditText, paramParcelable);
  }
  
  public void setIsChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  public String toString()
  {
    return String.format("CameraEmoticonInfo, path %s, url %s, contextKey %s", new Object[] { this.path, this.url, this.contextKey });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.contextKey);
    paramParcel.writeString(this.thumbPath);
    paramParcel.writeString(this.templateId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CameraEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */