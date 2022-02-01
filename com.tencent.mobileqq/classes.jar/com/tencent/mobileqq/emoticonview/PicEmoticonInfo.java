package com.tencent.mobileqq.emoticonview;

import TT;;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.sender.PicEmoticonInfoSender;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
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
  implements Parcelable, ICustomEmotionInfo, IPicEmoticonInfo
{
  public static final Parcelable.Creator<PicEmoticonInfo> CREATOR = new PicEmoticonInfo.1();
  private static final String TAG = "PicEmoticonInfo";
  public Emoticon emoticon;
  public int imageType;
  public boolean isAPNG;
  public boolean isDownLoad;
  public Drawable mDefault;
  private ColorDrawable mEmptyDrawable;
  public Drawable mFailed;
  public Drawable mFiveInchDefault;
  public Drawable mFiveInchFailed;
  public int reqHeight;
  public int reqWidth;
  public String roamingType;
  public String uin;
  
  protected PicEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    boolean bool2 = false;
    this.isDownLoad = false;
    this.reqWidth = 0;
    this.reqHeight = 0;
    this.mDefault = null;
    this.mFailed = null;
    this.mEmptyDrawable = new ColorDrawable();
    this.mFiveInchDefault = null;
    this.mFiveInchFailed = null;
    this.isAPNG = false;
    this.emoticon = ((Emoticon)paramParcel.readSerializable());
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.isDownLoad = bool1;
    this.reqWidth = paramParcel.readInt();
    this.reqHeight = paramParcel.readInt();
    this.imageType = paramParcel.readInt();
    this.uin = paramParcel.readString();
    boolean bool1 = bool2;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    }
    this.isAPNG = bool1;
    this.roamingType = paramParcel.readString();
  }
  
  public PicEmoticonInfo(String paramString)
  {
    this.isDownLoad = false;
    this.reqWidth = 0;
    this.reqHeight = 0;
    this.mDefault = null;
    this.mFailed = null;
    this.mEmptyDrawable = new ColorDrawable();
    this.mFiveInchDefault = null;
    this.mFiveInchFailed = null;
    this.isAPNG = false;
    this.uin = paramString;
    if ((this.mDefault == null) || (this.mFailed == null)) {
      try
      {
        paramString = MobileQQ.sMobileQQ.getResources();
        this.mDefault = paramString.getDrawable(2130850883);
        this.mFailed = paramString.getDrawable(2130850888);
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("PicEmoticonInfo", 2, paramString.getMessage());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicEmoticonInfo", 2, paramString.getMessage());
        }
      }
    }
  }
  
  private void modifyDrawableByScreenSize(PicEmoticonInfo paramPicEmoticonInfo, Emoticon paramEmoticon)
  {
    if ((paramEmoticon.extensionWidth != 0) && (paramEmoticon.extensionHeight != 0))
    {
      if ((paramPicEmoticonInfo.mFiveInchDefault == null) || (paramPicEmoticonInfo.mFiveInchFailed == null)) {
        try
        {
          paramEmoticon = MobileQQ.getContext().getResources();
          paramPicEmoticonInfo.mFiveInchDefault = paramEmoticon.getDrawable(2130846448);
          paramPicEmoticonInfo.mFiveInchFailed = paramEmoticon.getDrawable(2130846449);
        }
        catch (OutOfMemoryError paramEmoticon)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PicEmoticonInfo", 2, paramEmoticon.getMessage());
          }
        }
        catch (Exception paramEmoticon)
        {
          if (QLog.isColorLevel()) {
            QLog.e("PicEmoticonInfo", 2, paramEmoticon.getMessage());
          }
        }
      }
      paramPicEmoticonInfo.mDefault = paramPicEmoticonInfo.mFiveInchDefault;
      paramPicEmoticonInfo.mFailed = paramPicEmoticonInfo.mFiveInchFailed;
    }
  }
  
  public static void send(AppRuntime paramAppRuntime, Context paramContext, BaseSessionInfo paramBaseSessionInfo, Emoticon paramEmoticon, Serializable paramSerializable)
  {
    PicEmoticonInfoSender.send(paramAppRuntime, paramContext, paramBaseSessionInfo, paramEmoticon, paramSerializable);
  }
  
  private void tryApng(BaseQQAppInterface paramBaseQQAppInterface, Emoticon paramEmoticon, URL paramURL, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, URLDrawable paramURLDrawable)
  {
    if (paramBaseQQAppInterface != null)
    {
      paramBaseQQAppInterface = (IEmoticonManagerService)paramBaseQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
      if ((paramEmoticonPackage == null) && (!paramBoolean) && (paramEmoticon != null) && (!(paramURLDrawable.getCurrDrawable() instanceof ApngDrawable)))
      {
        paramURL = paramURL.toString();
        paramBaseQQAppInterface.asyncFindEmoticonPackage(paramEmoticon.epId, new PicEmoticonInfo.2(this, paramURL));
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public URLDrawable getAioPreviewDrawable()
  {
    return getPicEmoticonAioPreviewDrawable(this);
  }
  
  public URLDrawable getBigDrawable(Context paramContext, float paramFloat)
  {
    return getLoadingDrawable("fromAIO", true);
  }
  
  public Drawable getDefault()
  {
    return this.mDefault;
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    paramContext = this.emoticon;
    if (paramContext != null)
    {
      Object localObject = null;
      try
      {
        paramContext = new URL("emotion_pic", "fromPanel", PicEmoticonInfoConstant.getFictionPath(paramContext));
      }
      catch (MalformedURLException localMalformedURLException)
      {
        paramContext = (Context)localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("PicEmoticonInfo", 2, "getDrawable ,", localMalformedURLException);
          paramContext = (Context)localObject;
        }
      }
      if (paramContext != null)
      {
        ColorDrawable localColorDrawable = this.mEmptyDrawable;
        localObject = this.mFailed;
        if (localObject == null) {
          localObject = localColorDrawable;
        }
        paramContext = URLDrawable.getDrawable(paramContext, localColorDrawable, (Drawable)localObject, false);
        paramContext.setTag(this.emoticon);
        paramContext.addHeader("my_uin", this.uin);
        return paramContext;
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
  
  public Emoticon getEmoticon()
  {
    return this.emoticon;
  }
  
  public Drawable getFailed()
  {
    return this.mFailed;
  }
  
  public Drawable getFiveInchDefault()
  {
    return this.mFiveInchDefault;
  }
  
  public Drawable getFiveInchFailed()
  {
    return this.mFiveInchFailed;
  }
  
  public int getImageType()
  {
    return this.imageType;
  }
  
  public URLDrawable getLoadingDrawable(String paramString, boolean paramBoolean)
  {
    return getLoadingDrawable(paramString, paramBoolean, false, null);
  }
  
  public <T> URLDrawable getLoadingDrawable(String paramString, boolean paramBoolean1, boolean paramBoolean2, T paramT)
  {
    return getPicEmoticonLoadingDrawable(this, paramString, paramBoolean1, paramBoolean2, paramT);
  }
  
  public <T> URLDrawable getLoadingDrawable(String paramString, boolean paramBoolean1, boolean paramBoolean2, T paramT, int paramInt1, int paramInt2)
  {
    return getPicEmoticonLoadingDrawable(this, paramString, paramBoolean1, paramBoolean2, paramT, paramInt1, paramInt2);
  }
  
  public String getPath()
  {
    return "";
  }
  
  public <T> URLDrawable getPicEmoticonAioPreviewDrawable(T paramT)
  {
    Object localObject2 = null;
    if (paramT == null) {
      return null;
    }
    PicEmoticonInfo localPicEmoticonInfo = (PicEmoticonInfo)paramT;
    Emoticon localEmoticon = localPicEmoticonInfo.emoticon;
    if (localEmoticon == null) {
      return null;
    }
    String str = EmotionPanelConstans.emoticonAIOPreviewPath.replace("[epId]", localEmoticon.epId).replace("[eId]", localEmoticon.eId);
    paramT = localObject2;
    Object localObject1;
    if (str != null)
    {
      try
      {
        localObject1 = new URL("emotion_pic", "fromAIO", PicEmoticonInfoConstant.getFictionPath(localEmoticon));
      }
      catch (MalformedURLException paramT)
      {
        paramT.printStackTrace();
        localObject1 = null;
      }
      paramT = localObject2;
      if (localObject1 != null)
      {
        modifyDrawableByScreenSize(localPicEmoticonInfo, localEmoticon);
        localObject1 = URLDrawable.getDrawable((URL)localObject1, localPicEmoticonInfo.mDefault, localPicEmoticonInfo.mFailed, false);
        paramT = (TT)localObject1;
        if (((URLDrawable)localObject1).getStatus() != 1)
        {
          ((URLDrawable)localObject1).setTag(localEmoticon);
          ((URLDrawable)localObject1).addHeader("my_uin", localPicEmoticonInfo.uin);
          paramT = (TT)localObject1;
          if (!FileUtil.b(str)) {}
        }
      }
    }
    try
    {
      ((URLDrawable)localObject1).downloadImediatly();
      return localObject1;
    }
    catch (OutOfMemoryError paramT)
    {
      label162:
      break label162;
    }
    paramT = (TT)localObject1;
    if (QLog.isColorLevel())
    {
      paramT = new StringBuilder();
      paramT.append("getBigDrawable oom,drawableID=");
      paramT.append(localPicEmoticonInfo.drawableId);
      QLog.e("PicEmoticonInfo", 2, paramT.toString());
      paramT = (TT)localObject1;
    }
    return paramT;
  }
  
  public <T, K> URLDrawable getPicEmoticonLoadingDrawable(K paramK, String paramString, boolean paramBoolean1, boolean paramBoolean2, T paramT)
  {
    Object localObject2 = null;
    if (paramK == null) {
      return null;
    }
    PicEmoticonInfo localPicEmoticonInfo = (PicEmoticonInfo)paramK;
    Emoticon localEmoticon = localPicEmoticonInfo.emoticon;
    paramBoolean1 = localPicEmoticonInfo.isAPNG;
    Object localObject3 = localPicEmoticonInfo.mDefault;
    Object localObject1 = localPicEmoticonInfo.mFailed;
    if (localEmoticon == null) {
      return null;
    }
    try
    {
      paramK = new URL("emotion_pic", paramString, PicEmoticonInfoConstant.getFictionPath(localEmoticon));
    }
    catch (MalformedURLException paramK)
    {
      QLog.e("PicEmoticonInfo", 1, "market face getLoadingDrawable", paramK);
      paramK = null;
    }
    if (paramK == null) {
      return null;
    }
    modifyDrawableByScreenSize(localPicEmoticonInfo, localEmoticon);
    paramString = (String)localObject3;
    if (paramT != null)
    {
      paramString = ((IEmosmService)QRoute.api(IEmosmService.class)).getMarketFaceItemBuilderHolderImage(paramT).getDrawable();
      localObject1 = paramString;
    }
    paramT = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((paramT instanceof BaseQQAppInterface)) {
      paramT = (BaseQQAppInterface)paramT;
    } else {
      paramT = null;
    }
    localObject3 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = paramString;
    ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = true;
    paramString = localObject2;
    if (paramT != null)
    {
      localObject1 = (IEmoticonManagerService)paramT.getRuntimeService(IEmoticonManagerService.class);
      paramString = localObject2;
      if (localEmoticon != null) {
        paramString = ((IEmoticonManagerService)localObject1).syncFindEmoticonPackageInCache(localEmoticon.epId, 0);
      }
    }
    if (((paramString == null) || (paramString.isAPNG != 2)) && (!paramBoolean1) && (!localEmoticon.isAPNG))
    {
      paramBoolean1 = false;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "getBigDrawable: APNG so loaded use apng image");
      }
      ((URLDrawable.URLDrawableOptions)localObject3).mUseApngImage = true;
      ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
      ((URLDrawable.URLDrawableOptions)localObject3).mMemoryCacheKeySuffix = "useAPNG";
      paramBoolean1 = true;
    }
    ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = localEmoticon.extensionWidth;
    ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = localEmoticon.extensionHeight;
    localObject1 = URLDrawable.getDrawable(paramK, (URLDrawable.URLDrawableOptions)localObject3);
    if (((URLDrawable)localObject1).getStatus() != 1)
    {
      ((URLDrawable)localObject1).setTag(localEmoticon);
      ((URLDrawable)localObject1).addHeader("my_uin", localPicEmoticonInfo.uin);
      ((URLDrawable)localObject1).addHeader("emo_type", String.valueOf(localPicEmoticonInfo.imageType));
      if (paramBoolean2) {
        ((URLDrawable)localObject1).addHeader("2g_use_gif", "true");
      } else {
        ((URLDrawable)localObject1).addHeader("2g_use_gif", "false");
      }
      if ((((URLDrawable)localObject1).getStatus() == 2) || (((URLDrawable)localObject1).getStatus() == 3))
      {
        ((URLDrawable)localObject1).restartDownload();
        return localObject1;
      }
    }
    else
    {
      tryApng(paramT, localEmoticon, paramK, paramString, paramBoolean1, (URLDrawable)localObject1);
    }
    return localObject1;
  }
  
  public <T, K> URLDrawable getPicEmoticonLoadingDrawable(K paramK, String paramString, boolean paramBoolean1, boolean paramBoolean2, T paramT, int paramInt1, int paramInt2)
  {
    URLDrawable localURLDrawable = null;
    if (paramK == null) {
      return null;
    }
    PicEmoticonInfo localPicEmoticonInfo = (PicEmoticonInfo)paramK;
    Emoticon localEmoticon = localPicEmoticonInfo.emoticon;
    paramBoolean1 = localPicEmoticonInfo.isAPNG;
    if (localEmoticon == null) {
      return null;
    }
    try
    {
      paramK = new URL("emotion_pic", paramString, PicEmoticonInfoConstant.getFictionPath(localEmoticon));
    }
    catch (MalformedURLException paramK)
    {
      QLog.e("PicEmoticonInfo", 1, "market face getLoadingDrawable", paramK);
      paramK = null;
    }
    if (paramK == null) {
      return null;
    }
    modifyDrawableByScreenSize(localPicEmoticonInfo, localEmoticon);
    paramString = localPicEmoticonInfo.mDefault;
    paramString = localPicEmoticonInfo.mFailed;
    if (paramT != null) {
      paramString = ((IEmosmService)QRoute.api(IEmosmService.class)).getMarketFaceItemBuilderHolderImage(paramT).getDrawable();
    }
    paramT = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((paramT instanceof BaseQQAppInterface)) {
      paramT = (BaseQQAppInterface)paramT;
    } else {
      paramT = null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = paramString;
    localURLDrawableOptions.mLoadingDrawable = localPicEmoticonInfo.mDefault;
    localURLDrawableOptions.mPlayGifImage = true;
    paramString = localURLDrawable;
    if (paramT != null)
    {
      IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)paramT.getRuntimeService(IEmoticonManagerService.class);
      paramString = localURLDrawable;
      if (localEmoticon != null) {
        paramString = localIEmoticonManagerService.syncFindEmoticonPackageInCache(localEmoticon.epId, 0);
      }
    }
    if (((paramString == null) || (paramString.isAPNG != 2)) && (!paramBoolean1) && (!localEmoticon.isAPNG))
    {
      paramBoolean1 = false;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "getBigDrawable: APNG so loaded use apng image");
      }
      localURLDrawableOptions.mUseApngImage = true;
      localURLDrawableOptions.mPlayGifImage = false;
      localURLDrawableOptions.mMemoryCacheKeySuffix = "useAPNG";
      paramBoolean1 = true;
    }
    localURLDrawableOptions.mRequestWidth = localPicEmoticonInfo.reqWidth;
    localURLDrawableOptions.mRequestHeight = localPicEmoticonInfo.reqHeight;
    localURLDrawable = URLDrawable.getDrawable(paramK, localURLDrawableOptions);
    if (localURLDrawable.getStatus() != 1)
    {
      localURLDrawable.setTag(localEmoticon);
      localURLDrawable.addHeader("my_uin", localPicEmoticonInfo.uin);
      localURLDrawable.addHeader("emo_type", String.valueOf(localPicEmoticonInfo.imageType));
      if (paramBoolean2) {
        localURLDrawable.addHeader("2g_use_gif", "true");
      } else {
        localURLDrawable.addHeader("2g_use_gif", "false");
      }
      if ((localURLDrawable.getStatus() == 2) || (localURLDrawable.getStatus() == 3))
      {
        localURLDrawable.restartDownload();
        return localURLDrawable;
      }
    }
    else
    {
      tryApng(paramT, localEmoticon, paramK, paramString, paramBoolean1, localURLDrawable);
    }
    return localURLDrawable;
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
    Emoticon localEmoticon = this.emoticon;
    int i;
    if ((localEmoticon != null) && (localEmoticon.backColor != null)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR;
    if (i != 0) {
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
    Emoticon localEmoticon = this.emoticon;
    int i;
    if ((localEmoticon != null) && (localEmoticon.volumeColor != null)) {
      i = 1;
    } else {
      i = 0;
    }
    int j = DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR;
    if (i != 0) {
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
    Object localObject = this.emoticon;
    if ((localObject != null) && (((Emoticon)localObject).parseSoundPrintString() != null) && (!this.emoticon.parseSoundPrintString().isEmpty()))
    {
      localObject = new int[this.emoticon.parseSoundPrintString().size()];
      int i = 0;
      while (i < this.emoticon.parseSoundPrintString().size())
      {
        localObject[i] = ((Integer)this.emoticon.parseSoundPrintString().get(i)).intValue();
        i += 1;
      }
      return localObject;
    }
    return null;
  }
  
  public Drawable getZoomDrawable(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    return getDrawable(paramContext, paramFloat);
  }
  
  public boolean isAPNG()
  {
    return this.isAPNG;
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
    boolean bool2 = false;
    if (localObject != null)
    {
      if (((Emoticon)localObject).jobType == 1) {
        return false;
      }
      localObject = EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
      if (localObject != null)
      {
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          bool1 = true;
          break label85;
        }
      }
      boolean bool1 = false;
      label85:
      if ((this.emoticon.isSound) && (bool1))
      {
        localObject = EmotionPanelConstans.emoticonSoundPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
        bool1 = bool2;
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
      return bool1;
    }
    return false;
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public boolean isNewSoundType()
  {
    Emoticon localEmoticon = this.emoticon;
    return (localEmoticon != null) && (localEmoticon.parseSoundPrintString() != null) && (!this.emoticon.parseSoundPrintString().isEmpty());
  }
  
  public boolean isSound()
  {
    Emoticon localEmoticon = this.emoticon;
    return (localEmoticon != null) && (localEmoticon.isSound);
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    send(paramAppRuntime, paramContext, (BaseSessionInfo)paramParcelable, this.emoticon, this.stickerInfo);
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable, boolean paramBoolean)
  {
    send(paramAppRuntime, paramContext, paramEditText, paramParcelable, paramBoolean, 0);
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable, boolean paramBoolean, int paramInt)
  {
    PicEmoticonInfoSender.send(this, paramAppRuntime, paramContext, paramEditText, paramParcelable, paramBoolean, paramInt);
  }
  
  public void setEmoticon(Emoticon paramEmoticon)
  {
    this.emoticon = paramEmoticon;
  }
  
  public void setIsChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
  }
  
  public void setStickerInfo(StickerInfo paramStickerInfo)
  {
    this.stickerInfo = paramStickerInfo;
  }
  
  public String toString()
  {
    Emoticon localEmoticon = this.emoticon;
    if (localEmoticon != null) {
      return String.format("PicEmoticonInfo, name %s, eId %s, epId %s", new Object[] { localEmoticon.name, this.emoticon.eId, this.emoticon.epId });
    }
    return "PicEmoticonInfo TYPE_BIG_EMOTICON and no emoticon";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeSerializable(this.emoticon);
    paramParcel.writeByte((byte)this.isDownLoad);
    paramParcel.writeInt(this.reqWidth);
    paramParcel.writeInt(this.reqHeight);
    paramParcel.writeInt(this.imageType);
    paramParcel.writeString(this.uin);
    paramParcel.writeByte((byte)this.isAPNG);
    paramParcel.writeString(this.roamingType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.PicEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */