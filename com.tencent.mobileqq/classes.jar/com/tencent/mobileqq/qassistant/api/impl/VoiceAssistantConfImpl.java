package com.tencent.mobileqq.qassistant.api.impl;

import com.tencent.mobileqq.qassistant.api.IVoiceAssistantConf;
import com.tencent.mobileqq.qassistant.config.QAssistantConfigItem;
import com.tencent.mobileqq.qassistant.config.QAssistantConfigItemFactory;
import com.tencent.mobileqq.qassistant.config.QAssistantConfigUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class VoiceAssistantConfImpl
  implements IVoiceAssistantConf
{
  public static final String HOST = "mqq.jump.qq";
  public static final String TAG = "QAssistantManager";
  private List<QAssistantConfigItem> configItemList = null;
  private List<String> supportOpenHost = null;
  
  public boolean checkHostIsSupport(String paramString)
  {
    if ("mqq.jump.qq".equals(paramString)) {
      return true;
    }
    if (!StringUtil.isEmpty(paramString))
    {
      Object localObject = this.supportOpenHost;
      if (localObject == null) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((String)((Iterator)localObject).next()).equalsIgnoreCase(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public QAssistantConfigItem findItemByOpenJumpAction(String paramString1, String paramString2)
  {
    if (StringUtil.isEmpty(paramString1)) {
      return null;
    }
    if ("mqq.jump.qq".equals(paramString2)) {
      paramString2 = QAssistantConfigItemFactory.a();
    } else {
      paramString2 = this.configItemList;
    }
    if (paramString2 != null)
    {
      if (paramString2.size() == 0) {
        return null;
      }
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        QAssistantConfigItem localQAssistantConfigItem = (QAssistantConfigItem)paramString2.next();
        if ((localQAssistantConfigItem.g != null) && (localQAssistantConfigItem.g.equalsIgnoreCase(paramString1))) {
          return localQAssistantConfigItem;
        }
      }
      return null;
    }
    return null;
  }
  
  public List<String> getConfigHostList()
  {
    return this.supportOpenHost;
  }
  
  public List<QAssistantConfigItem> getConfigItemList()
  {
    return this.configItemList;
  }
  
  public void loadConfigFromLocal()
  {
    String str = QAssistantConfigUtils.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadConfigFromLocal config is ");
    localStringBuilder.append(str);
    QLog.i("QAssistantManager", 2, localStringBuilder.toString());
    parseDataByJson(str);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    loadConfigFromLocal();
  }
  
  public void onDestroy() {}
  
  public void parseDataByJson(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return;
    }
    List localList = this.configItemList;
    if (localList == null) {
      this.configItemList = new ArrayList();
    } else {
      localList.clear();
    }
    localList = this.supportOpenHost;
    if (localList == null) {
      this.supportOpenHost = new ArrayList();
    } else {
      localList.clear();
    }
    paramString = QAssistantConfigUtils.a(paramString, this.supportOpenHost);
    if (paramString != null) {
      this.configItemList.addAll(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.api.impl.VoiceAssistantConfImpl
 * JD-Core Version:    0.7.0.1
 */