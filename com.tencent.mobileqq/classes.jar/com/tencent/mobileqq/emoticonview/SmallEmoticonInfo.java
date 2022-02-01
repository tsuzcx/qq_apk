package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;

public class SmallEmoticonInfo
  extends EmoticonInfo
  implements Parcelable
{
  public static final Parcelable.Creator<SmallEmoticonInfo> CREATOR = new SmallEmoticonInfo.1();
  private static final String TAG = "SmallEmoticonInfo";
  public Emoticon emoticon;
  public int imageType;
  public boolean isAPNG;
  private Drawable mDefault = null;
  private ColorDrawable mEmptyDrawable = new ColorDrawable();
  private Drawable mFailed = null;
  private int reqHeight = 0;
  private int reqWidth = 0;
  private String uin;
  
  protected SmallEmoticonInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.emoticon = ((Emoticon)paramParcel.readSerializable());
    this.imageType = paramParcel.readInt();
    this.uin = paramParcel.readString();
    this.reqWidth = paramParcel.readInt();
    this.reqHeight = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isAPNG = bool;
      return;
    }
  }
  
  public SmallEmoticonInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallEmoticonInfo", 2, "currentAccountUin:" + paramString);
    }
    this.uin = paramString;
    if ((this.mDefault == null) || (this.mFailed == null)) {}
    try
    {
      paramString = BaseApplication.getContext().getResources();
      this.mDefault = paramString.getDrawable(2130838121);
      this.mFailed = paramString.getDrawable(2130843990);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SmallEmoticonInfo", 2, paramString.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SmallEmoticonInfo", 2, paramString.getMessage());
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Drawable getBigDrawable(Context paramContext, float paramFloat)
  {
    paramContext = null;
    if (this.emoticon == null) {}
    do
    {
      for (;;)
      {
        return paramContext;
        try
        {
          Object localObject = new URL("emotion_pic", "fromAIO", getFictionPath(this.emoticon));
          paramContext = this.mDefault;
          paramContext = this.mFailed;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = paramContext;
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
          localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
          paramContext = (Context)localObject;
          if (((URLDrawable)localObject).getStatus() != 1)
          {
            ((URLDrawable)localObject).setTag(this.emoticon);
            ((URLDrawable)localObject).addHeader("my_uin", this.uin);
            ((URLDrawable)localObject).addHeader("emo_big", "true");
            paramContext = (Context)localObject;
            if (QLog.isColorLevel())
            {
              QLog.d("SmallEmoticonInfo", 2, "b.getStatus=" + ((URLDrawable)localObject).getStatus() + " e.epId=" + this.emoticon.epId + " e.eId=" + this.emoticon.eId);
              return localObject;
            }
          }
        }
        catch (MalformedURLException localMalformedURLException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("SmallEmoticonInfo", 2, "getDrawable ,", localMalformedURLException);
    return null;
  }
  
  public Drawable getDrawable(Context paramContext, float paramFloat)
  {
    if (this.emoticon != null) {
      try
      {
        paramContext = new URL("emotion_pic", "fromPanel", getFictionPath(this.emoticon));
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
  
  public String getFictionPath(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    return paramEmoticon.epId + "_" + paramEmoticon.eId;
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
      localObject = EmoticonUtils.emoticonPreviewPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
      label50:
      if (localObject == null) {
        break label108;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
        break label110;
      }
    }
    for (;;)
    {
      return bool;
      localObject = EmoticonUtils.emoticonAIOPreviewPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
      break label50;
      label108:
      break;
      label110:
      bool = false;
    }
  }
  
  public boolean isBigImageExists()
  {
    boolean bool2 = true;
    if (this.emoticon == null) {
      return false;
    }
    Object localObject = "";
    if (this.emoticon.jobType != 1) {
      localObject = EmoticonUtils.emoticonEncryptPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
    }
    boolean bool1;
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      int i;
      if ((this.emoticon.isSound) && (bool1))
      {
        localObject = EmoticonUtils.emoticonSoundPath.replace("[epId]", this.emoticon.epId).replace("[eId]", this.emoticon.eId);
        if (localObject == null) {
          break label196;
        }
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
          i = 1;
        }
      }
      for (;;)
      {
        label167:
        if ((bool1) && (i != 0)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          return bool1;
          bool1 = false;
          break;
          i = 0;
          break label167;
        }
        return bool1;
        label196:
        i = 0;
      }
      bool1 = false;
    }
  }
  
  public void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    if (paramAppRuntime == null) {
      QLog.e("SmallEmoticonInfo", 2, "app is null.");
    }
    do
    {
      return;
      if (this.emoticon == null)
      {
        VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
        QLog.e("SmallEmoticonInfo", 1, "fail to send small_emotion.");
        return;
      }
    } while (!(paramAppRuntime instanceof QQAppInterface));
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    try
    {
      int i = Integer.parseInt(this.emoticon.eId);
      int j = Integer.parseInt(this.emoticon.epId);
      ((EmoticonManager)paramAppRuntime.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(String.valueOf(j), new SmallEmoticonInfo.2(this, j, i, paramEditText, paramAppRuntime));
      return;
    }
    catch (NumberFormatException paramAppRuntime)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
      QLog.e("SmallEmoticonInfo", 1, "fail to send small_emotion. id is not Int.");
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeSerializable(this.emoticon);
    paramParcel.writeInt(this.imageType);
    paramParcel.writeString(this.uin);
    paramParcel.writeInt(this.reqWidth);
    paramParcel.writeInt(this.reqHeight);
    if (this.isAPNG) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */