package com.tencent.mobileqq.qwallet.red.impl;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.ConfigInfo;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class QWRedConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private transient String a;
  private transient String b;
  private transient byte[] c;
  public List<QWRedConfig.PathInfo> pathInfos = new LinkedList();
  public long version;
  
  private QWRedConfig.PathInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.pathInfos.iterator();
    while (localIterator.hasNext())
    {
      QWRedConfig.PathInfo localPathInfo = (QWRedConfig.PathInfo)localIterator.next();
      if ((localPathInfo.isMatchPath(paramString)) && (localPathInfo.isShow())) {
        return localPathInfo;
      }
    }
    return null;
  }
  
  private static String a(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder(((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath());
    localStringBuilder.append(paramAppRuntime.getAccount());
    localStringBuilder.append("/.config/");
    localStringBuilder.append(".redConfig");
    return localStringBuilder.toString();
  }
  
  private void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    this.a = paramString;
    this.b = paramBaseQQAppInterface.getCurrentAccountUin();
    this.c = new byte[0];
  }
  
  public static List<QWRedConfig.PathInfo> parseConfigToPathInfos(String paramString)
  {
    localLinkedList = new LinkedList();
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("list");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          QWRedConfig.PathInfo localPathInfo = QWRedConfig.PathInfo.parseToPathInfo(paramString.optJSONObject(i));
          if (localPathInfo != null) {
            localLinkedList.add(localPathInfo);
          }
          i += 1;
        }
      }
      return localLinkedList;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static QWRedConfig readConfig(BaseQQAppInterface paramBaseQQAppInterface)
  {
    String str = a(paramBaseQQAppInterface);
    Object localObject1;
    try
    {
      QWRedConfig localQWRedConfig = (QWRedConfig)QWalletTools.e(str);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new QWRedConfig();
    }
    ((QWRedConfig)localObject2).a(paramBaseQQAppInterface, str);
    if (QLog.isColorLevel())
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append("readQWRedConfig:");
      paramBaseQQAppInterface.append(localObject2);
      QLog.d("RedConfig", 2, paramBaseQQAppInterface.toString());
    }
    return localObject2;
  }
  
  public List<QWRedConfig.RedInfo> getCurShowRedInfosByPath(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramString.redInfos != null)) {
      return paramString.getCurShowRedInfos();
    }
    return new LinkedList();
  }
  
  public String getNotShowListStr()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator1 = this.pathInfos.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((QWRedConfig.PathInfo)localIterator1.next()).redInfos.iterator();
      while (localIterator2.hasNext())
      {
        QWRedConfig.RedInfo localRedInfo = (QWRedConfig.RedInfo)localIterator2.next();
        if (localRedInfo.isShow == 0) {
          localLinkedList.add(localRedInfo);
        }
      }
    }
    return QWRedConfig.RedInfo.transToReportStr(localLinkedList);
  }
  
  public IQWalletRedService.ShowInfo getShowInfoByPath(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.getShowInfo();
    }
    return new IQWalletRedService.ShowInfo(false, false, "", "");
  }
  
  public void parseConfig(ConfigInfo paramConfigInfo)
  {
    if (paramConfigInfo != null) {
      try
      {
        if ("redPoint".equals(paramConfigInfo.a))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parseConfig:");
            localStringBuilder.append(paramConfigInfo.c);
            localStringBuilder.append("|");
            localStringBuilder.append(this.version);
            localStringBuilder.append("|");
            localStringBuilder.append(paramConfigInfo.b);
            QLog.d("RedConfig", 2, localStringBuilder.toString());
          }
          if (paramConfigInfo.c > this.version)
          {
            this.pathInfos = parseConfigToPathInfos(paramConfigInfo.b);
            this.version = paramConfigInfo.c;
            saveConfig();
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public void saveConfig()
  {
    ThreadManager.getFileThreadHandler().post(new QWRedConfig.1(this));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QWRedConfig{pathInfos=");
    localStringBuilder.append(this.pathInfos);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.red.impl.QWRedConfig
 * JD-Core Version:    0.7.0.1
 */