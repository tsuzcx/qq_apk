package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.core.SystemEmotionPanelManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PicEmoticonInfo
  extends EmoticonInfo
  implements Parcelable, ICustomEmotionInfo
{
  public static final Parcelable.Creator<PicEmoticonInfo> CREATOR = new PicEmoticonInfo.1();
  public static final int DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR = Color.parseColor("#21d9c6");
  public static final int DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR = Color.parseColor("#ffffff");
  public static final String ORIGINAL_EMOTION_COUNT_SP_FILE_NAME = "originalEmotionCountSp_";
  public static final int ORIGINAL_EMOTION_REWORD_COUNT = 21;
  private static final String TAG = "PicEmoticonInfo";
  public static final int TYPE_GIF = 3;
  public static final int TYPE_PNG = 2;
  public Emoticon emoticon;
  public int imageType;
  public boolean isAPNG = false;
  public boolean isDownLoad = false;
  public Drawable mDefault = null;
  private ColorDrawable mEmptyDrawable = new ColorDrawable();
  public Drawable mFailed = null;
  public Drawable mFiveInchDefault = null;
  public Drawable mFiveInchFailed = null;
  public int reqHeight = 0;
  public int reqWidth = 0;
  public String roamingType;
  public String uin;
  
  protected PicEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.emoticon = ((Emoticon)paramParcel.readSerializable());
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.isDownLoad = bool1;
      this.reqWidth = paramParcel.readInt();
      this.reqHeight = paramParcel.readInt();
      this.imageType = paramParcel.readInt();
      this.uin = paramParcel.readString();
      if (paramParcel.readByte() == 0) {
        break label143;
      }
    }
    label143:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.isAPNG = bool1;
      this.roamingType = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public PicEmoticonInfo(String paramString)
  {
    this.uin = paramString;
    if ((this.mDefault == null) || (this.mFailed == null)) {}
    try
    {
      paramString = MobileQQ.sMobileQQ.getResources();
      this.mDefault = paramString.getDrawable(2130850943);
      this.mFailed = paramString.getDrawable(2130850948);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PicEmoticonInfo", 2, paramString.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PicEmoticonInfo", 2, paramString.getMessage());
    }
  }
  
  public static String getFictionPath(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    return paramEmoticon.epId + "_" + paramEmoticon.eId;
  }
  
  public static void send(AppRuntime paramAppRuntime, Context paramContext, Parcelable paramParcelable, Emoticon paramEmoticon, Serializable paramSerializable)
  {
    IPicEmoticonInfoSender localIPicEmoticonInfoSender = (IPicEmoticonInfoSender)SystemEmotionPanelManager.a().a(6);
    if (localIPicEmoticonInfoSender == null)
    {
      QLog.e("PicEmoticonInfo", 1, "emotionInfoSender is null.");
      return;
    }
    localIPicEmoticonInfoSender.send(paramAppRuntime, paramContext, paramParcelable, paramEmoticon, paramSerializable);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public URLDrawable getAioPreviewDrawable()
  {
    return ((IEmoticonPanelService)QRoute.api(IEmoticonPanelService.class)).getPicEmoticonAioPreviewDrawable(this);
  }
  
  public URLDrawable getBigDrawable(Context paramContext, float paramFloat)
  {
    return getLoadingDrawable("fromAIO", true);
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    if (this.emoticon != null)
    {
      Object localObject = null;
      try
      {
        paramContext = new URL("emotion_pic", "fromPanel", getFictionPath(this.emoticon));
        if (paramContext != null)
        {
          ColorDrawable localColorDrawable = this.mEmptyDrawable;
          if (this.mFailed != null)
          {
            localObject = this.mFailed;
            paramContext = URLDrawable.getDrawable(paramContext, localColorDrawable, (Drawable)localObject, false);
            paramContext.setTag(this.emoticon);
            paramContext.addHeader("my_uin", this.uin);
            return paramContext;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          paramContext = (Context)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("PicEmoticonInfo", 2, "getDrawable ,", localMalformedURLException);
            paramContext = (Context)localObject;
            continue;
            localObject = this.mEmptyDrawable;
          }
        }
      }
    }
    return this.mDefault;
  }
  
  public int getEmoId()
  {
    return this.emoId;
  }
  
  public int getEmoType()
  {
    return 1;
  }
  
  public URLDrawable getLoadingDrawable(String paramString, boolean paramBoolean)
  {
    return getLoadingDrawable(paramString, paramBoolean, false, null);
  }
  
  public <T> URLDrawable getLoadingDrawable(String paramString, boolean paramBoolean1, boolean paramBoolean2, T paramT)
  {
    return ((IEmoticonPanelService)QRoute.api(IEmoticonPanelService.class)).getPicEmoticonLoadingDrawable(this, paramString, paramBoolean1, paramBoolean2, paramT);
  }
  
  public <T> URLDrawable getLoadingDrawable(String paramString, boolean paramBoolean1, boolean paramBoolean2, T paramT, int paramInt1, int paramInt2)
  {
    return ((IEmoticonPanelService)QRoute.api(IEmoticonPanelService.class)).getPicEmoticonLoadingDrawable(this, paramString, paramBoolean1, paramBoolean2, paramT, paramInt1, paramInt2);
  }
  
  public String getPath()
  {
    return "";
  }
  
  public String getRoamingType()
  {
    return this.roamingType;
  }
  
  public int getVoiceLength()
  {
    return 0;
  }
  
  public int getWaveBackgroundColor()
  {
    if ((this.emoticon != null) && (this.emoticon.backColor != null)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR;
      if (i == 0) {
        return j;
      }
      try
      {
        i = Color.parseColor(this.emoticon.backColor);
        return i;
      }
      catch (Exception localException)
      {
        QLog.e("PicEmoticonInfo", 2, localException, new Object[0]);
      }
    }
    return j;
  }
  
  public int getWaveForegroundColor()
  {
    if ((this.emoticon != null) && (this.emoticon.volumeColor != null)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR;
      if (i == 0) {
        return j;
      }
      try
      {
        i = Color.parseColor(this.emoticon.volumeColor);
        return i;
      }
      catch (Exception localException)
      {
        QLog.e("PicEmoticonInfo", 2, localException, new Object[0]);
      }
    }
    return j;
  }
  
  public int[] getWaveformArray()
  {
    if ((this.emoticon != null) && (this.emoticon.parseSoundPrintString() != null) && (!this.emoticon.parseSoundPrintString().isEmpty()))
    {
      int[] arrayOfInt = new int[this.emoticon.parseSoundPrintString().size()];
      int i = 0;
      while (i < this.emoticon.parseSoundPrintString().size())
      {
        arrayOfInt[i] = ((Integer)this.emoticon.parseSoundPrintString().get(i)).intValue();
        i += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
  
  public Drawable getZoomDrawable(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    return getDrawable(paramContext, paramFloat);
  }
  
  public boolean isAioPreviewExists()
  {
    boolean bool = true;
    if (this.emoticon == null) {
      return false;
    }
    Object localObject;
    if (this.emoticon.jobType == 1)
    {
      localObject = CommonEmoticonConstans.emoticonPreviewPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
      label52:
      if (localObject == null) {
        break label112;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
        break label114;
      }
    }
    for (;;)
    {
      return bool;
      localObject = CommonEmoticonConstans.emoticonAIOPreviewPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
      break label52;
      label112:
      break;
      label114:
      bool = false;
    }
  }
  
  public boolean isBigImageExists()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.emoticon == null) || (this.emoticon.jobType == 1))
    {
      bool1 = false;
      return bool1;
    }
    Object localObject = CommonEmoticonConstans.emoticonEncryptPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((this.emoticon.isSound) && (bool1))
      {
        localObject = CommonEmoticonConstans.emoticonSoundPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
        if (localObject == null) {
          break label165;
        }
        localObject = new File((String)localObject);
        if (((File)localObject).exists())
        {
          bool1 = bool2;
          if (((File)localObject).isFile()) {
            break;
          }
        }
        return false;
        bool1 = false;
        continue;
      }
      return bool1;
      label165:
      return false;
      bool1 = false;
    }
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public boolean isNewSoundType()
  {
    return (this.emoticon != null) && (this.emoticon.parseSoundPrintString() != null) && (!this.emoticon.parseSoundPrintString().isEmpty());
  }
  
  public boolean isSound()
  {
    return (this.emoticon != null) && (this.emoticon.isSound);
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    send(paramAppRuntime, paramContext, paramParcelable, this.emoticon, this.stickerInfo);
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable, boolean paramBoolean)
  {
    send(paramAppRuntime, paramContext, paramEditText, paramParcelable, paramBoolean, 0);
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable, boolean paramBoolean, int paramInt)
  {
    IPicEmoticonInfoSender localIPicEmoticonInfoSender = (IPicEmoticonInfoSender)SystemEmotionPanelManager.a().a(6);
    if (localIPicEmoticonInfoSender == null)
    {
      QLog.e("PicEmoticonInfo", 1, "emotionInfoSender is null.");
      return;
    }
    localIPicEmoticonInfoSender.send(this, paramAppRuntime, paramContext, paramEditText, paramParcelable, paramBoolean, paramInt);
  }
  
  public void setIsChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  public String toString()
  {
    if (this.emoticon != null) {
      return String.format("PicEmoticonInfo, name %s, eId %s, epId %s", new Object[] { this.emoticon.name, this.emoticon.eId, this.emoticon.epId });
    }
    return "PicEmoticonInfo TYPE_BIG_EMOTICON and no emoticon";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeSerializable(this.emoticon);
    if (this.isDownLoad)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.reqWidth);
      paramParcel.writeInt(this.reqHeight);
      paramParcel.writeInt(this.imageType);
      paramParcel.writeString(this.uin);
      if (!this.isAPNG) {
        break label92;
      }
    }
    label92:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.roamingType);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */