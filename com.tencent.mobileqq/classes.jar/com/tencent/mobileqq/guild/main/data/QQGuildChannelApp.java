package com.tencent.mobileqq.guild.main.data;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IBaseChnnPreItemInfo;
import com.tencent.mobileqq.qqguildsdk.data.appchannel.IChannelPreInfo;
import java.util.List;

public class QQGuildChannelApp
  extends QQChannelItemData
{
  private String b;
  private IGProChannelInfo c;
  private IAppChnnPreInfo d;
  
  public QQGuildChannelApp(String paramString, IGProChannelInfo paramIGProChannelInfo)
  {
    this.b = paramString;
    this.c = paramIGProChannelInfo;
  }
  
  public IGProChannelInfo a()
  {
    return this.c;
  }
  
  public void a(IGProChannelInfo paramIGProChannelInfo)
  {
    this.c = paramIGProChannelInfo;
  }
  
  public void a(IAppChnnPreInfo paramIAppChnnPreInfo)
  {
    this.d = paramIAppChnnPreInfo;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public IAppChnnPreInfo c()
  {
    return this.d;
  }
  
  public List<IBaseChnnPreItemInfo> d()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return null;
    }
    localObject = ((IAppChnnPreInfo)localObject).j();
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return null;
      }
      return ((IChannelPreInfo)((List)localObject).get(0)).a();
    }
    return null;
  }
  
  public String e()
  {
    IAppChnnPreInfo localIAppChnnPreInfo = this.d;
    if ((localIAppChnnPreInfo != null) && (localIAppChnnPreInfo.f() != null)) {
      return this.d.f();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.data.QQGuildChannelApp
 * JD-Core Version:    0.7.0.1
 */