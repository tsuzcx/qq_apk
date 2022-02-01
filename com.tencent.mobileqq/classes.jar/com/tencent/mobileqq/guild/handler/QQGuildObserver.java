package com.tencent.mobileqq.guild.handler;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.guild.data.QQGuildWrapData;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.ChannelData;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;

public class QQGuildObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(ChannelData paramChannelData) {}
  
  public void a(IGProChannelInfo paramIGProChannelInfo) {}
  
  public void a(Object paramObject, int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, IGProChannelInfo paramIGProChannelInfo) {}
  
  public void a(boolean paramBoolean, IGProChannelInfo paramIGProChannelInfo, String paramString) {}
  
  public void b() {}
  
  public void b(boolean paramBoolean, IGProChannelInfo paramIGProChannelInfo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 10: 
      a((IGProChannelInfo)paramObject);
      return;
    case 9: 
      b();
      return;
    case 8: 
      a();
      return;
    case 7: 
      a((ChannelData)paramObject);
      return;
    case 6: 
      a((String)paramObject);
      return;
    case 5: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        a(paramObject[0], ((Integer)paramObject[1]).intValue());
        return;
      }
      break;
    case 4: 
      a(paramBoolean);
      return;
    case 3: 
      b(paramBoolean, (IGProChannelInfo)paramObject);
      return;
    case 2: 
      a(paramBoolean, (IGProChannelInfo)paramObject);
      return;
    case 1: 
      paramObject = (QQGuildWrapData)paramObject;
      a(paramBoolean, (IGProChannelInfo)paramObject.a(), paramObject.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.handler.QQGuildObserver
 * JD-Core Version:    0.7.0.1
 */