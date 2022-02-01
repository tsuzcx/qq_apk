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
  private ArrayList<String> mDomainWhiteList = null;
  
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
    try
    {
      if (this.mDomainWhiteList != null) {
        break label140;
      }
      this.mDomainWhiteList = new ArrayList();
      str = QzoneConfig.getInstance().getConfig("qqminiapp", "opendatahosts", ".qlogo.com;.qlogo.cn;.qq.com;.tcb.qcloud.la");
      if ((str == null) || (str.equals(this.mCurWhiteListConfig))) {
        break label140;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Default white domain:");
      ((StringBuilder)localObject2).append(str);
      QLog.i("[mini] http.openDataDomainValid", 1, ((StringBuilder)localObject2).toString());
      localObject2 = str.split(";");
      if (localObject2 == null) {
        break label135;
      }
      j = localObject2.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        String str;
        Object localObject2;
        int j;
        int i;
        CharSequence localCharSequence;
        for (;;)
        {
          label135:
          label140:
          throw localObject1;
        }
        i += 1;
      }
    }
    if (i < j)
    {
      localCharSequence = localObject2[i];
      if (!TextUtils.isEmpty(localCharSequence)) {
        this.mDomainWhiteList.add(localCharSequence);
      }
    }
    else
    {
      this.mCurWhiteListConfig = str;
      return this.mDomainWhiteList;
    }
  }
  
  public static OpenDataDomainUtil getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new OpenDataDomainUtil();
        }
      }
      finally {}
    }
    return sInstance;
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
    if (paramDomainConfig == null) {
      return;
    }
    if (this.mCachedDomainConfigMap == null) {
      this.mCachedDomainConfigMap = new ConcurrentHashMap();
    }
    ArrayList localArrayList2 = (ArrayList)this.mCachedDomainConfigMap.get(Integer.valueOf(paramInt));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.mCachedDomainConfigMap.put(Integer.valueOf(paramInt), localArrayList1);
    }
    if (!localArrayList1.contains(paramDomainConfig)) {
      localArrayList1.add(paramDomainConfig);
    }
  }
  
  public boolean isDomainValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("url is null. url : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("[mini] http.domainValid", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    Object localObject = paramString.toLowerCase();
    int i;
    if ((!URLUtil.isHttpUrl(paramString)) && (!URLUtil.isHttpsUrl(paramString))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return false;
    }
    localObject = DomainConfig.getDomainConfig((String)localObject);
    if (isDomainConfigCached((DomainConfig)localObject, 0)) {
      return true;
    }
    return checkWnsConfig(paramString, 0, (DomainConfig)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.OpenDataDomainUtil
 * JD-Core Version:    0.7.0.1
 */