package com.tencent.mobileqq.emoticon;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQEmojiResImpl
  extends QQSysAndEmojiResInfo
  implements QQSysAndEmojiResReloader.IResReloadListener
{
  private static final String CATEGORY_NAME = "emoji";
  public static final String TAG = "QQEmojiResInfo";
  private int mMaxLocalId;
  
  public String getDescription(int paramInt)
  {
    if ((this.mConfigItemMap != null) && (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt)))) {
      return ((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt))).QDes;
    }
    return "";
  }
  
  public Drawable getDrawable(int paramInt)
  {
    URL localURL1;
    URL localURL2;
    try
    {
      localURL1 = new URL("qqsys_emoji", "host_emoji", String.format("emoji_%03d.png", new Object[] { Integer.valueOf(paramInt) }));
      localURL2 = localURL1;
      try
      {
        if (!QLog.isColorLevel()) {
          break label105;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDrawable url:");
        localStringBuilder.append(localURL1.toString());
        QLog.d("QQEmojiResInfo", 2, localStringBuilder.toString());
        localURL2 = localURL1;
      }
      catch (MalformedURLException localMalformedURLException1) {}
      localURL2 = localURL1;
    }
    catch (MalformedURLException localMalformedURLException2)
    {
      localURL1 = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("QQEmojiResInfo", 2, "getDrawable ,", localMalformedURLException2);
      localURL2 = localURL1;
    }
    label105:
    return getUrlDrawable(localURL2, null, false, String.valueOf(paramInt));
  }
  
  public int getMaxLocalId()
  {
    return this.mMaxLocalId;
  }
  
  public int getServerId(int paramInt)
  {
    if ((this.mConfigItemMap != null) && (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt)))) {
      return Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt))).QCid);
    }
    return -1;
  }
  
  public boolean isResReady(int paramInt)
  {
    boolean bool = false;
    String str = QQSysAndEmojiResMgr.getFullResPath(3, String.format("/emoji_%03d.png", new Object[] { Integer.valueOf(paramInt) }));
    if (!TextUtils.isEmpty(str)) {
      bool = new File(str).exists();
    }
    return bool;
  }
  
  public void parseConfigData()
  {
    Object localObject1 = getFaceConfigJson();
    if (localObject1 != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject1).optJSONArray("emoji");
      if (localJSONArray != null)
      {
        if (this.mConfigItemMap == null) {
          this.mConfigItemMap = new HashMap();
        }
        if (this.mOrderList == null) {
          this.mOrderList = new ArrayList();
        }
        if (this.mServerToLocalMap == null) {
          this.mServerToLocalMap = new HashMap();
        }
        if (this.mDesToEMCodeMap == null) {
          this.mDesToEMCodeMap = new HashMap();
        }
        if (this.mEMCodeToLocalMap == null) {
          this.mEMCodeToLocalMap = new HashMap();
        }
        this.mConfigItemMap.clear();
        this.mOrderList.clear();
        this.mServerToLocalMap.clear();
        this.mDesToEMCodeMap.clear();
        this.mEMCodeToLocalMap.clear();
        long l = System.currentTimeMillis();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localObject1 = null;
          try
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            localObject1 = localJSONObject;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          localObject1 = (QQSysAndEmojiResInfo.QQEmoConfigItem)JSONConverter.a((JSONObject)localObject1, QQSysAndEmojiResInfo.QQEmoConfigItem.class);
          try
          {
            int j = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).AQLid);
            int k = Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).QCid);
            if (!TextUtils.isEmpty(((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).EMCode))
            {
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[em]e");
              ((StringBuilder)localObject2).append(((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).EMCode);
              ((StringBuilder)localObject2).append("[/em]");
              localObject2 = ((StringBuilder)localObject2).toString();
              String str = ((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).QDes;
              this.mDesToEMCodeMap.put(str, localObject2);
              this.mEMCodeToLocalMap.put(localObject2, Integer.valueOf(j));
            }
            this.mConfigItemMap.put(Integer.valueOf(j), localObject1);
            this.mServerToLocalMap.put(Integer.valueOf(k), Integer.valueOf(j));
            if (!isEmoticonHide((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1)) {
              this.mOrderList.add(Integer.valueOf(j));
            }
            if (j <= this.mMaxLocalId) {
              break label398;
            }
            this.mMaxLocalId = j;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            label375:
            break label375;
          }
          QLog.d("QQEmojiResInfo", 1, new Object[] { "error occur in emoji AQLid:", ((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject1).AQLid });
          label398:
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQEmojiResInfo", 2, new Object[] { "emoji configItem:", Integer.valueOf(this.mConfigItemMap.size()), " ,orderlist:", Integer.valueOf(this.mOrderList.size()), ", maxLid:", Integer.valueOf(this.mMaxLocalId), " ,costTime = [", Long.valueOf(System.currentTimeMillis() - l), "]" });
        }
      }
    }
  }
  
  public void preLoadURLDrawable() {}
  
  public void reportEmoClick(int paramInt1, int paramInt2)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A7A3", "0X800A7A3", getServerId(paramInt1), 0, String.valueOf(paramInt2), "", "", "");
  }
  
  public void setReloadController()
  {
    this.mResReloader = new QQSysAndEmojiResReloader(this);
  }
  
  public void startReloadDrawable(int paramInt)
  {
    reloadDrawable(getDrawable(paramInt), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQEmojiResImpl
 * JD-Core Version:    0.7.0.1
 */