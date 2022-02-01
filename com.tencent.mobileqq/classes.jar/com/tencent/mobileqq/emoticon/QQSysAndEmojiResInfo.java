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
      paramString = new File(paramString + "face_config.json");
      if (paramString.exists()) {
        paramString = FileUtils.a(paramString);
      }
      while ((paramString != null) && (paramString.length() > 0))
      {
        mFaceJsonObject = new JSONObject(paramString);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "getFaceConfigJson len:", Integer.valueOf(mFaceJsonObject.length()), " ,costTime = [", Long.valueOf(System.currentTimeMillis() - l), "]， content:", paramString });
        return;
        paramString = FileUtils.d("face_config.json");
        QLog.d("QQSysAndEmojiBaseInfo", 1, "getFaceConfigJson not exist!");
        ThreadManager.getSubThreadHandler().post(new QQSysAndEmojiResInfo.1());
      }
      return;
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
    if (this.mConfigItemMap == null) {
      return false;
    }
    if (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt))) {
      return isEmoticonHide((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt)));
    }
    return true;
  }
  
  public int getConfigEmoCount()
  {
    int i = 0;
    if (this.mConfigItemMap != null) {
      i = this.mConfigItemMap.size();
    }
    return i;
  }
  
  public abstract String getDescription(int paramInt);
  
  public abstract Drawable getDrawable(int paramInt);
  
  public String getEMCode(String paramString)
  {
    if ((this.mDesToEMCodeMap != null) && (this.mDesToEMCodeMap.containsKey(paramString))) {
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
    if ((this.mServerToLocalMap != null) && (this.mServerToLocalMap.containsKey(Integer.valueOf(paramInt)))) {
      return ((Integer)this.mServerToLocalMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return -1;
  }
  
  public int getLocalIdFromEMCode(String paramString)
  {
    if ((this.mEMCodeToLocalMap != null) && (this.mEMCodeToLocalMap.containsKey(paramString))) {
      return ((Integer)this.mEMCodeToLocalMap.get(paramString)).intValue();
    }
    return -1;
  }
  
  public abstract int getMaxLocalId();
  
  public ArrayList<Integer> getOrderList()
  {
    ArrayList localArrayList = null;
    if (this.mOrderList != null)
    {
      localArrayList = new ArrayList();
      localArrayList.addAll(this.mOrderList);
    }
    return localArrayList;
  }
  
  public abstract int getServerId(int paramInt);
  
  protected Drawable getUrlDrawable(URL paramURL, Drawable paramDrawable, boolean paramBoolean, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (paramDrawable == null) {
      if (this.mDefault != null) {}
    }
    for (;;)
    {
      try
      {
        this.mDefault = BaseApplication.getContext().getResources().getDrawable(2130838129);
        localURLDrawableOptions.mLoadingDrawable = this.mDefault;
        localURLDrawableOptions.mFailedDrawable = this.mDefault;
        localURLDrawableOptions.mPlayGifImage = paramBoolean;
        paramURL = realGetURLDrawable(paramURL, localURLDrawableOptions);
        if ((paramURL != null) && (!TextUtils.isEmpty(paramString))) {
          paramURL.addHeader("emoId", paramString);
        }
        return paramURL;
      }
      catch (Exception paramDrawable)
      {
        this.mDefault = new ColorDrawable();
        QLog.e("QQSysAndEmojiBaseInfo", 1, "getDrawable exception e: = " + paramDrawable.getMessage());
        continue;
      }
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
    }
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
      if ((paramDrawable.getStatus() == 1) || (paramDrawable.getStatus() == 0)) {
        break label71;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "reloadDrawable restartDownload:", Integer.valueOf(paramInt) });
      }
      paramDrawable.addHeader("emoId", Integer.toString(paramInt));
      paramDrawable.restartDownload();
    }
    label71:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QQSysAndEmojiBaseInfo", 2, new Object[] { "reloadDrawable do nothing:", Integer.valueOf(paramInt) });
  }
  
  public abstract void reportEmoClick(int paramInt1, int paramInt2);
  
  public void resDownloadFinish()
  {
    if (this.mResReloader != null) {
      this.mResReloader.nofityReloadList();
    }
  }
  
  public abstract void setReloadController();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo
 * JD-Core Version:    0.7.0.1
 */