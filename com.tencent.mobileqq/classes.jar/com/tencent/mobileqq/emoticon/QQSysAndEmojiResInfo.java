package com.tencent.mobileqq.emoticon;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class QQSysAndEmojiResInfo
{
  private static final String CONFIG_FILE_NAME = "face_config.json";
  public static final String EMO_ID = "emoId";
  public static final String TAG = "QQSysAndEmojiBaseInfo";
  private static JSONObject mFaceJsonObject;
  protected HashMap<Integer, QQSysAndEmojiResInfo.QQEmoConfigItem> mConfigItemMap;
  protected Drawable mDefault;
  protected HashMap<String, String> mDesToEMCodeMap;
  protected HashMap<String, Integer> mEMCodeToLocalMap;
  protected ArrayList<Integer> mOrderList;
  protected QQSysAndEmojiResReloader mResReloader;
  protected HashMap<Integer, Integer> mServerToLocalMap;
  
  public QQSysAndEmojiResInfo()
  {
    parseConfigData();
  }
  
  protected static void parseFaceConfigJson(String paramString)
  {
    mFaceJsonObject = null;
    try
    {
      long l = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("face_config.json");
      paramString = new File(localStringBuilder.toString());
      boolean bool = paramString.exists();
      if (bool)
      {
        paramString = FileUtils.readFileContent(paramString);
      }
      else
      {
        paramString = FileUtils.readStringFromAsset("face_config.json");
        QLog.d("QQSysAndEmojiBaseInfo", 1, "getFaceConfigJson not exist!");
        ThreadManager.getSubThreadHandler().post(new QQSysAndEmojiResInfo.1());
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        mFaceJsonObject = new JSONObject(paramString);
        if (QLog.isColorLevel())
        {
          QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "getFaceConfigJson len:", Integer.valueOf(mFaceJsonObject.length()), " ,costTime = [", Long.valueOf(System.currentTimeMillis() - l), "]， content:", paramString });
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void addReloadDrawable(int paramInt)
  {
    if (this.mResReloader == null) {
      setReloadController();
    }
    this.mResReloader.addReloadList(paramInt);
  }
  
  public boolean checkEmoticonShouldHide(int paramInt)
  {
    HashMap localHashMap = this.mConfigItemMap;
    if (localHashMap == null) {
      return false;
    }
    if (localHashMap.containsKey(Integer.valueOf(paramInt))) {
      return isEmoticonHide((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt)));
    }
    return true;
  }
  
  public int getConfigEmoCount()
  {
    HashMap localHashMap = this.mConfigItemMap;
    if (localHashMap != null) {
      return localHashMap.size();
    }
    return 0;
  }
  
  public abstract String getDescription(int paramInt);
  
  public abstract Drawable getDrawable(int paramInt);
  
  public String getEMCode(String paramString)
  {
    HashMap localHashMap = this.mDesToEMCodeMap;
    if ((localHashMap != null) && (localHashMap.containsKey(paramString))) {
      return (String)this.mDesToEMCodeMap.get(paramString);
    }
    return null;
  }
  
  public JSONObject getFaceConfigJson()
  {
    if (mFaceJsonObject == null) {
      parseFaceConfigJson(QQSysAndEmojiResMgr.getResSavePath());
    }
    return mFaceJsonObject;
  }
  
  public int getLocalId(int paramInt)
  {
    HashMap localHashMap = this.mServerToLocalMap;
    if ((localHashMap != null) && (localHashMap.containsKey(Integer.valueOf(paramInt)))) {
      return ((Integer)this.mServerToLocalMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return -1;
  }
  
  public int getLocalIdFromEMCode(String paramString)
  {
    HashMap localHashMap = this.mEMCodeToLocalMap;
    if ((localHashMap != null) && (localHashMap.containsKey(paramString))) {
      return ((Integer)this.mEMCodeToLocalMap.get(paramString)).intValue();
    }
    return -1;
  }
  
  public abstract int getMaxLocalId();
  
  public ArrayList<Integer> getOrderList()
  {
    if (this.mOrderList != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.mOrderList);
      return localArrayList;
    }
    return null;
  }
  
  public abstract int getServerId(int paramInt);
  
  protected Drawable getUrlDrawable(URL paramURL, Drawable paramDrawable, boolean paramBoolean, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (paramDrawable == null)
    {
      if (this.mDefault == null) {
        try
        {
          this.mDefault = BaseApplication.getContext().getResources().getDrawable(2130837978);
        }
        catch (Exception paramDrawable)
        {
          this.mDefault = new ColorDrawable();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getDrawable exception e: = ");
          localStringBuilder.append(paramDrawable.getMessage());
          QLog.e("QQSysAndEmojiBaseInfo", 1, localStringBuilder.toString());
        }
      }
      paramDrawable = this.mDefault;
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
    }
    else
    {
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
    }
    localURLDrawableOptions.mUseApngImage = paramBoolean;
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    paramURL = realGetURLDrawable(paramURL, localURLDrawableOptions);
    if ((paramURL != null) && (!TextUtils.isEmpty(paramString))) {
      paramURL.addHeader("emoId", paramString);
    }
    return paramURL;
  }
  
  public boolean isEmoticonHide(QQSysAndEmojiResInfo.QQEmoConfigItem paramQQEmoConfigItem)
  {
    return "1".equals(paramQQEmoConfigItem.QHide);
  }
  
  public abstract boolean isResReady(int paramInt);
  
  public abstract void parseConfigData();
  
  public abstract void preLoadURLDrawable();
  
  protected URLDrawable realGetURLDrawable(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    return URLDrawable.getDrawable(paramURL, paramURLDrawableOptions);
  }
  
  protected void reloadDrawable(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof URLDrawable))
    {
      paramDrawable = (URLDrawable)paramDrawable;
      if ((paramDrawable.getStatus() != 1) && (paramDrawable.getStatus() != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "reloadDrawable restartDownload:", Integer.valueOf(paramInt) });
        }
        paramDrawable.addHeader("emoId", Integer.toString(paramInt));
        paramDrawable.restartDownload();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "reloadDrawable do nothing:", Integer.valueOf(paramInt) });
      }
    }
  }
  
  public abstract void reportEmoClick(int paramInt1, int paramInt2);
  
  public void resDownloadFinish()
  {
    QQSysAndEmojiResReloader localQQSysAndEmojiResReloader = this.mResReloader;
    if (localQQSysAndEmojiResReloader != null) {
      localQQSysAndEmojiResReloader.nofityReloadList();
    }
  }
  
  public abstract void setReloadController();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
 * JD-Core Version:    0.7.0.1
 */