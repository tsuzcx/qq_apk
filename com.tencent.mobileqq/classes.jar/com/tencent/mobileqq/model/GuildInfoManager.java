package com.tencent.mobileqq.model;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.navigatebar.BaseInfoManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class GuildInfoManager
  extends BaseInfoManager
  implements Manager
{
  final String a = "GuildInfoManager";
  protected QQAppInterface b;
  protected ConcurrentHashMap<String, MessageInfo> c = new ConcurrentHashMap();
  
  public GuildInfoManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  public MessageInfo a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("messageInfoMap.size() = ");
      localStringBuilder.append(this.c.size());
      QLog.d("GuildInfoManager", 2, localStringBuilder.toString());
    }
    return (MessageInfo)this.c.get(paramString);
  }
  
  public MessageInfo a(String paramString, MessageInfo paramMessageInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("messageInfoMap: update__:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMessageInfo.a());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMessageInfo.e());
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramMessageInfo.b());
      QLog.d("GuildInfoManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (MessageInfo)this.c.get(paramString);
    if (paramMessageInfo != null)
    {
      if (!paramMessageInfo.e()) {
        return localObject;
      }
      if (localObject == null)
      {
        paramMessageInfo = new MessageInfo(paramMessageInfo);
        this.c.put(paramString, paramMessageInfo);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("messageInfoMap: put:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("GuildInfoManager", 2, ((StringBuilder)localObject).toString());
        }
        return paramMessageInfo;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("messageInfoMap: update:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("GuildInfoManager", 2, ((StringBuilder)localObject).toString());
      }
      this.c.put(paramString, paramMessageInfo);
      return paramMessageInfo;
    }
    return localObject;
  }
  
  public MessageInfo b(String paramString)
  {
    return (MessageInfo)this.c.remove(paramString);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.model.GuildInfoManager
 * JD-Core Version:    0.7.0.1
 */