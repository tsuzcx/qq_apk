package com.tencent.mobileqq.qassistant.api;

import com.tencent.mobileqq.qassistant.config.QAssistantConfigItem;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IVoiceAssistantConf
  extends IRuntimeService
{
  public abstract boolean checkHostIsSupport(String paramString);
  
  public abstract QAssistantConfigItem findItemByOpenJumpAction(String paramString1, String paramString2);
  
  public abstract List<String> getConfigHostList();
  
  public abstract List<QAssistantConfigItem> getConfigItemList();
  
  public abstract void loadConfigFromLocal();
  
  public abstract void parseDataByJson(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.api.IVoiceAssistantConf
 * JD-Core Version:    0.7.0.1
 */