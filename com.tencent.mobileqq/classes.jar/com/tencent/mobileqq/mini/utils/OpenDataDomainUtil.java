package com.tencent.mobileqq.mini.utils;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.mini.apkg.DomainConfig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OpenDataDomainUtil
{
  private static final String CONFIG_SPLIT = ";";
  private static String TAG = "OpenDataDomainUtil";
  private static volatile OpenDataDomainUtil sInstance;
  private ConcurrentHashMap<Integer, ArrayList<DomainConfig>> mCachedDomainConfigMap = new ConcurrentHashMap();
  private String mCurWhiteListConfig;
  private ArrayList<String> mDomainWhiteList;
  
  private boolean checkWnsConfig(String paramString, int paramInt, DomainConfig paramDomainConfig)
  {
    paramString = getDomainWhiteList().iterator();
    while (paramString.hasNext()) {
      if (DomainConfig.isDomainMatchRfc2019((String)paramString.next(), paramDomainConfig))
      {
        putDomainConfigToCache(paramDomainConfig, paramInt);
        return true;
      }
    }
    return false;
  }
  
  private List<String> getDomainWhiteList()
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.mDomainWhiteList == null)
        {
          this.mDomainWhiteList = new ArrayList();
          String str1 = QzoneConfig.getInstance().getConfig("qqminiapp", "opendatahosts", ".qlogo.com;.qlogo.cn;.qq.com;.tcb.qcloud.la");
          if ((str1 != null) && (!str1.equals(this.mCurWhiteListConfig)))
          {
            QLog.i("[mini] http.openDataDomainValid", 1, "Default white domain:" + str1);
            String[] arrayOfString = str1.split(";");
            if (arrayOfString != null)
            {
              int j = arrayOfString.length;
              i = 0;
              if (i < j)
              {
                String str2 = arrayOfString[i];
                if (TextUtils.isEmpty(str2)) {
                  break label144;
                }
                this.mDomainWhiteList.add(str2);
                break label144;
              }
            }
            this.mCurWhiteListConfig = str1;
          }
        }
        return this.mDomainWhiteList;
      }
      finally {}
      label144:
      i += 1;
    }
  }
  
  public static OpenDataDomainUtil getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new OpenDataDomainUtil();
      }
      return sInstance;
    }
    finally {}
  }
  
  private boolean isDomainConfigCached(DomainConfig paramDomainConfig, int paramInt)
  {
    if (paramDomainConfig == null) {
      return false;
    }
    Object localObject = this.mCachedDomainConfigMap;
    if (localObject == null) {
      return false;
    }
    localObject = (ArrayList)((Map)localObject).get(Integer.valueOf(paramInt));
    return (localObject != null) && (((ArrayList)localObject).contains(paramDomainConfig));
  }
  
  private void putDomainConfigToCache(DomainConfig paramDomainConfig, int paramInt)
  {
    if (paramDomainConfig == null) {}
    ArrayList localArrayList1;
    do
    {
      return;
      if (this.mCachedDomainConfigMap == null) {
        this.mCachedDomainConfigMap = new ConcurrentHashMap();
      }
      ArrayList localArrayList2 = (ArrayList)this.mCachedDomainConfigMap.get(Integer.valueOf(paramInt));
      localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.mCachedDomainConfigMap.put(Integer.valueOf(paramInt), localArrayList1);
      }
    } while (localArrayList1.contains(paramDomainConfig));
    localArrayList1.add(paramDomainConfig);
  }
  
  public boolean isDomainValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("[mini] http.domainValid", 1, "url is null. url : " + paramString);
    }
    Object localObject;
    label80:
    do
    {
      for (;;)
      {
        return false;
        localObject = paramString.toLowerCase();
        if ((URLUtil.isHttpUrl(paramString)) || (URLUtil.isHttpsUrl(paramString))) {}
        for (int i = 1; i != 0; i = 0)
        {
          localObject = DomainConfig.getDomainConfig((String)localObject);
          if (!isDomainConfigCached((DomainConfig)localObject, 0)) {
            break label80;
          }
          return true;
        }
      }
    } while (!checkWnsConfig(paramString, 0, (DomainConfig)localObject));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.OpenDataDomainUtil
 * JD-Core Version:    0.7.0.1
 */