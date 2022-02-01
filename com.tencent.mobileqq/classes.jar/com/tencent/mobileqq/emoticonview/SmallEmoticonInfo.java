package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import avsq;
import bggr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SmallEmoticonInfo
  extends EmoticonInfo
{
  private String TAG = "SmallEmoticonInfo";
  public Emoticon emoticon;
  public int imageType;
  public boolean isAPNG;
  private Drawable mDefault;
  private ColorDrawable mEmptyDrawable = new ColorDrawable();
  private Drawable mFailed;
  private int reqHeight;
  private int reqWidth;
  private String uin;
  
  public SmallEmoticonInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "currentAccountUin:" + paramString);
    }
    this.uin = paramString;
    if ((this.mDefault == null) || (this.mFailed == null)) {}
    try
    {
      paramString = BaseApplication.getContext().getResources();
      this.mDefault = paramString.getDrawable(2130838035);
      this.mFailed = paramString.getDrawable(2130843781);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.TAG, 2, paramString.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.TAG, 2, paramString.getMessage());
    }
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
          paramContext = BaseApplicationImpl.getApplication().waitAppRuntime(null);
          if ((paramContext instanceof QQAppInterface)) {
            paramContext = (QQAppInterface)paramContext;
          }
          paramContext = this.mFailed;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mFailedDrawable = paramContext;
          localURLDrawableOptions.mLoadingDrawable = this.mDefault;
          localURLDrawableOptions.mPlayGifImage = true;
          if (this.isAPNG)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 2, "getBigDrawable: APNG so loaded use apng image");
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
              QLog.d(this.TAG, 2, "b.getStatus=" + ((URLDrawable)localObject).getStatus() + " e.epId=" + this.emoticon.epId + " e.eId=" + this.emoticon.eId);
              return localObject;
            }
          }
        }
        catch (MalformedURLException localMalformedURLException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "getDrawable ,", localMalformedURLException);
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
          QLog.d(this.TAG, 2, "getDrawable ,", paramContext);
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
          break label195;
        }
        localObject = new File((String)localObject);
        if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
          i = 1;
        }
      }
      for (;;)
      {
        label166:
        if ((bool1) && (i != 0)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          return bool1;
          bool1 = false;
          break;
          i = 0;
          break label166;
        }
        return bool1;
        label195:
        i = 0;
      }
      bool1 = false;
    }
  }
  
  public void send(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (this.emoticon == null)
    {
      bggr.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e(this.TAG, 1, "fail to send small_emotion.");
      return;
    }
    try
    {
      int i = Integer.parseInt(this.emoticon.eId);
      int j = Integer.parseInt(this.emoticon.epId);
      ((avsq)paramQQAppInterface.getManager(14)).a(String.valueOf(j), new SmallEmoticonInfo.1(this, j, i, paramEditText, paramQQAppInterface));
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      bggr.a("emotionType", "emotionActionSend", "4", "", "", "", "", "", "", "");
      QLog.e(this.TAG, 1, "fail to send small_emotion. id is not Int.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SmallEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */