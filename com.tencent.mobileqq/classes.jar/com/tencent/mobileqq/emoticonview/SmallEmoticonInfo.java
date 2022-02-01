package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;

public class SmallEmoticonInfo
  extends EmoticonInfo
  implements Parcelable, ISmallEmoticonInfo
{
  public static final Parcelable.Creator<SmallEmoticonInfo> CREATOR = new SmallEmoticonInfo.1();
  private static final String TAG = "SmallEmoticonInfo";
  public Emoticon emoticon;
  public int imageType;
  public boolean isAPNG;
  private Drawable mDefault = null;
  private ColorDrawable mEmptyDrawable = new ColorDrawable();
  private Drawable mFailed = null;
  private int reqHeight;
  private int reqWidth;
  private String uin;
  
  protected SmallEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    boolean bool = false;
    this.reqWidth = 0;
    this.reqHeight = 0;
    this.emoticon = ((Emoticon)paramParcel.readSerializable());
    this.imageType = paramParcel.readInt();
    this.uin = paramParcel.readString();
    this.reqWidth = paramParcel.readInt();
    this.reqHeight = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.isAPNG = bool;
  }
  
  public SmallEmoticonInfo(String paramString)
  {
    this.reqWidth = 0;
    this.reqHeight = 0;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("currentAccountUin:");
      localStringBuilder.append(paramString);
      QLog.d("SmallEmoticonInfo", 2, localStringBuilder.toString());
    }
    this.uin = paramString;
    if ((this.mDefault == null) || (this.mFailed == null)) {
      try
      {
        paramString = BaseApplication.getContext().getResources();
        this.mDefault = paramString.getDrawable(2130837970);
        this.mFailed = paramString.getDrawable(2130843910);
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("SmallEmoticonInfo", 2, paramString.getMessage());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SmallEmoticonInfo", 2, paramString.getMessage());
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    paramContext = this.emoticon;
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = new URL("emotion_pic", "fromAIO", getFictionPath(paramContext));
      Object localObject = this.mDefault;
      localObject = this.mFailed;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mLoadingDrawable = this.mDefault;
      localURLDrawableOptions.mPlayGifImage = true;
      if (this.isAPNG)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmoticonInfo", 2, "getBigDrawable: APNG so loaded use apng image");
        }
        localURLDrawableOptions.mUseApngImage = true;
        localURLDrawableOptions.mPlayGifImage = false;
        localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
      }
      localURLDrawableOptions.mRequestWidth = this.reqWidth;
      localURLDrawableOptions.mRequestHeight = this.reqHeight;
      paramContext = URLDrawable.getDrawable(paramContext, localURLDrawableOptions);
      if (paramContext.getStatus() != 1)
      {
        paramContext.setTag(this.emoticon);
        paramContext.addHeader("my_uin", this.uin);
        paramContext.addHeader("emo_big", "true");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("b.getStatus=");
          ((StringBuilder)localObject).append(paramContext.getStatus());
          ((StringBuilder)localObject).append(" e.epId=");
          ((StringBuilder)localObject).append(this.emoticon.epId);
          ((StringBuilder)localObject).append(" e.eId=");
          ((StringBuilder)localObject).append(this.emoticon.eId);
          QLog.d("SmallEmoticonInfo", 2, ((StringBuilder)localObject).toString());
        }
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallEmoticonInfo", 2, "getDrawable ,", paramContext);
      }
    }
    return null;
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    paramContext = this.emoticon;
    if (paramContext != null) {
      try
      {
        paramContext = new URL("emotion_pic", "fromPanel", getFictionPath(paramContext));
        paramContext = URLDrawable.getDrawable(paramContext, this.mDefault, this.mFailed, false);
        paramContext.setTag(this.emoticon);
        paramContext.addHeader("my_uin", this.uin);
        return paramContext;
      }
      catch (MalformedURLException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SmallEmoticonInfo", 2, "getDrawable ,", paramContext);
        }
        return this.mDefault;
      }
    }
    return this.mDefault;
  }
  
  public Emoticon getEmoticon()
  {
    return this.emoticon;
  }
  
  public String getFictionPath(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramEmoticon.epId);
    localStringBuilder.append("_");
    localStringBuilder.append(paramEmoticon.eId);
    return localStringBuilder.toString();
  }
  
  public boolean isAioPreviewExists()
  {
    Object localObject = this.emoticon;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    if (((Emoticon)localObject).jobType == 1) {
      localObject = EmotionPanelConstans.emoticonPreviewPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
    } else {
      localObject = EmotionPanelConstans.emoticonAIOPreviewPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
    }
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      bool1 = bool2;
      if (((File)localObject).exists())
      {
        bool1 = bool2;
        if (((File)localObject).isFile()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isBigImageExists()
  {
    Object localObject = this.emoticon;
    boolean bool3 = false;
    if (localObject == null) {
      return false;
    }
    if (((Emoticon)localObject).jobType != 1) {
      localObject = EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
    } else {
      localObject = "";
    }
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        bool1 = true;
        break label101;
      }
    }
    boolean bool1 = false;
    label101:
    if ((this.emoticon.isSound) && (bool1))
    {
      localObject = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
      if (localObject != null)
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          i = 1;
          break label183;
        }
      }
      int i = 0;
      boolean bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (i != 0) {
          bool2 = true;
        }
      }
      return bool2;
    }
    label183:
    return bool1;
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("SmallEmoticonInfo", 2, "app is null.");
      return;
    }
    paramContext = this.emoticon;
    if (paramContext == null)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("SmallEmoticonInfo", 1, "fail to send small_emotion.");
      return;
    }
    if (!(paramAppRuntime instanceof BaseQQAppInterface)) {
      return;
    }
    paramAppRuntime = (BaseQQAppInterface)paramAppRuntime;
    try
    {
      int i = Integer.parseInt(paramContext.eId);
      int j = Integer.parseInt(this.emoticon.epId);
      ((IEmoticonManagerService)paramAppRuntime.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(String.valueOf(j), new SmallEmoticonInfo.2(this, j, i, paramEditText, paramAppRuntime));
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      label135:
      break label135;
    }
    VasReportUtils.a("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
    QLog.e("SmallEmoticonInfo", 1, "fail to send small_emotion. id is not Int.");
  }
  
  public void setEmoticon(Emoticon paramEmoticon)
  {
    this.emoticon = paramEmoticon;
  }
  
  public void setIsAPNG(boolean paramBoolean)
  {
    this.isAPNG = paramBoolean;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeSerializable(this.emoticon);
    paramParcel.writeInt(this.imageType);
    paramParcel.writeString(this.uin);
    paramParcel.writeInt(this.reqWidth);
    paramParcel.writeInt(this.reqHeight);
    paramParcel.writeByte((byte)this.isAPNG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */