package com.tencent.mobileqq.emoticon;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQSysFaceResImpl
  extends QQSysAndEmojiResInfo
  implements QQSysAndEmojiResReloader.IResReloadListener
{
  private static final String CATEGORY_NAME = "sysface";
  private static final String QZONE_CHI_GUA = "/吃瓜";
  public static final int SYSFACE_ANISTICKER = 1;
  public static final int SYSFACE_NORMAL = 0;
  public static final int SYSFACE_RANDOM = 2;
  public static final String TAG = "QQSysFaceResInfo";
  private int mMaxLocalId;
  private int mMaxServerId;
  
  public AniStickerInfo getAniStickerInfo(int paramInt)
  {
    if ((this.mConfigItemMap != null) && (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt))))
    {
      QQSysAndEmojiResInfo.QQEmoConfigItem localQQEmoConfigItem = (QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt));
      AniStickerInfo localAniStickerInfo = new AniStickerInfo();
      localAniStickerInfo.convert(localQQEmoConfigItem);
      return localAniStickerInfo;
    }
    return null;
  }
  
  public int getAniStickerType(int paramInt)
  {
    if (this.mConfigItemMap == null) {
      return 0;
    }
    Object localObject = (QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("item is null. localId: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("QQSysFaceResInfo", 2, ((StringBuilder)localObject).toString());
      return 0;
    }
    return ((QQSysAndEmojiResInfo.QQEmoConfigItem)localObject).AniStickerType;
  }
  
  public String getDescription(int paramInt)
  {
    if ((this.mConfigItemMap != null) && (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt)))) {
      return ((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt))).QDes;
    }
    return "";
  }
  
  public Drawable getDrawable(int paramInt)
  {
    int i = QQSysFaceUtil.convertToServer(paramInt);
    URL localURL1;
    URL localURL2;
    try
    {
      localURL1 = new URL("qqsys_emoji", "host_qqsys_static", String.format("s%d.png", new Object[] { Integer.valueOf(i) }));
      localURL2 = localURL1;
      try
      {
        if (!QLog.isColorLevel()) {
          break label117;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDrawable url:");
        localStringBuilder.append(localURL1.toString());
        QLog.d("QQSysFaceResInfo", 2, localStringBuilder.toString());
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
      QLog.d("QQSysFaceResInfo", 2, "getDrawable ,", localMalformedURLException2);
      localURL2 = localURL1;
    }
    label117:
    return getUrlDrawable(localURL2, QQSysFaceUtil.getFaceDrawableFromLocal(paramInt), false, String.valueOf(paramInt));
  }
  
  public String getEMCode(int paramInt)
  {
    if ((this.mConfigItemMap != null) && (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt)))) {
      return ((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt))).EMCode;
    }
    return null;
  }
  
  public Drawable getGifDrawable(int paramInt)
  {
    int i = QQSysFaceUtil.convertToServer(paramInt);
    URL localURL1;
    URL localURL2;
    try
    {
      localURL1 = new URL("qqsys_emoji", "host_qqsys_gif", String.format("s%d.gif", new Object[] { Integer.valueOf(i) }));
      localURL2 = localURL1;
      try
      {
        if (!QLog.isColorLevel()) {
          break label117;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getGifDrawable url:");
        localStringBuilder.append(localURL1.toString());
        QLog.d("QQSysFaceResInfo", 2, localStringBuilder.toString());
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
      QLog.d("QQSysFaceResInfo", 2, "getGifDrawable ", localMalformedURLException2);
      localURL2 = localURL1;
    }
    label117:
    return getUrlDrawable(localURL2, QQSysFaceUtil.getFaceDrawableFromLocal(paramInt), true, Integer.toString(paramInt));
  }
  
  public int getMaxLocalId()
  {
    return this.mMaxLocalId;
  }
  
  public int getMaxServerId()
  {
    return this.mMaxServerId;
  }
  
  public int getServerId(int paramInt)
  {
    if ((this.mConfigItemMap != null) && (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt)))) {
      return Integer.parseInt(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt))).QSid);
    }
    return -1;
  }
  
  public boolean isCMEmoji(int paramInt)
  {
    if ((this.mConfigItemMap != null) && (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt)))) {
      return "1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt))).isCMEmoji);
    }
    return false;
  }
  
  public boolean isResReady(int paramInt)
  {
    boolean bool = false;
    String str = QQSysAndEmojiResMgr.getFullResPath(2, String.format("/s%d.png", new Object[] { Integer.valueOf(paramInt) }));
    if (!TextUtils.isEmpty(str)) {
      bool = new File(str).exists();
    }
    return bool;
  }
  
  public boolean isStaticFace(int paramInt)
  {
    if ((this.mConfigItemMap != null) && (this.mConfigItemMap.containsKey(Integer.valueOf(paramInt)))) {
      return "1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(Integer.valueOf(paramInt))).isStatic);
    }
    return com.tencent.mobileqq.text.EmotcationConstants.STATIC_SYS_EMOTCATION_RESOURCE[paramInt] == com.tencent.mobileqq.text.EmotcationConstants.STATIC_SYS_EMO_GIF_RES[paramInt];
  }
  
  public void parseConfigData()
  {
    Object localObject = getFaceConfigJson();
    if (localObject != null)
    {
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("sysface");
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
          localObject = null;
          try
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            localObject = localJSONObject;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          QQSysAndEmojiResInfo.QQEmoConfigItem localQQEmoConfigItem = (QQSysAndEmojiResInfo.QQEmoConfigItem)JSONConverter.a((JSONObject)localObject, QQSysAndEmojiResInfo.QQEmoConfigItem.class);
          try
          {
            int j = Integer.parseInt(localQQEmoConfigItem.AQLid);
            int k = Integer.parseInt(localQQEmoConfigItem.QSid);
            if (!TextUtils.isEmpty(localQQEmoConfigItem.EMCode))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[em]e");
              ((StringBuilder)localObject).append(localQQEmoConfigItem.EMCode);
              ((StringBuilder)localObject).append("[/em]");
              String str2 = ((StringBuilder)localObject).toString();
              String str1 = localQQEmoConfigItem.QDes;
              localObject = str1;
              if (!TextUtils.isEmpty(str1))
              {
                localObject = str1;
                if (str1.equals("/吃瓜")) {
                  localObject = "/chigua";
                }
              }
              this.mDesToEMCodeMap.put(localObject, str2);
              this.mEMCodeToLocalMap.put(str2, Integer.valueOf(j));
            }
            this.mConfigItemMap.put(Integer.valueOf(j), localQQEmoConfigItem);
            this.mServerToLocalMap.put(Integer.valueOf(k), Integer.valueOf(j));
            if (!isEmoticonHide(localQQEmoConfigItem)) {
              this.mOrderList.add(Integer.valueOf(j));
            }
            if (j > this.mMaxLocalId) {
              this.mMaxLocalId = j;
            }
            if (k <= this.mMaxServerId) {
              break label445;
            }
            this.mMaxServerId = k;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            label421:
            break label421;
          }
          QLog.d("QQSysFaceResInfo", 1, new Object[] { "error occur in sysface AQLid:", localQQEmoConfigItem.AQLid });
          label445:
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQSysFaceResInfo", 2, new Object[] { "sysface configItem:", Integer.valueOf(this.mConfigItemMap.size()), ", orderlist:", Integer.valueOf(this.mOrderList.size()), ", maxLid:", Integer.valueOf(this.mMaxLocalId), ", maxSid:", Integer.valueOf(this.mMaxServerId), ", costTime = [", Long.valueOf(System.currentTimeMillis() - l), "]" });
        }
      }
    }
  }
  
  public void preLoadURLDrawable()
  {
    if (this.mConfigItemMap == null) {
      return;
    }
    Iterator localIterator = this.mConfigItemMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if ((localInteger.intValue() >= 260) && (!"-1".equals(((QQSysAndEmojiResInfo.QQEmoConfigItem)this.mConfigItemMap.get(localInteger)).QSid))) {
        ((URLDrawable)getDrawable(localInteger.intValue())).downloadImediatly();
      }
    }
  }
  
  public void reportEmoClick(int paramInt1, int paramInt2)
  {
    paramInt1 = getServerId(paramInt1);
    if (paramInt1 == 0) {
      paramInt1 = 1000;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A7A2", "0X800A7A2", paramInt1, 0, String.valueOf(paramInt2), "", "", "");
  }
  
  public void setReloadController()
  {
    this.mResReloader = new QQSysAndEmojiResReloader(this);
  }
  
  public void startReloadDrawable(int paramInt)
  {
    reloadDrawable(getDrawable(paramInt), paramInt);
    reloadDrawable(getGifDrawable(paramInt), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysFaceResImpl
 * JD-Core Version:    0.7.0.1
 */