package com.tencent.mobileqq.guild.setting.msgnotify;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import java.util.List;

public class NotifySettingData
{
  private String a;
  private List<IGProChannelInfo> b;
  
  public NotifySettingData(String paramString, List<IGProChannelInfo> paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  public int a()
  {
    return this.b.size() + 1;
  }
  
  public Object a(int paramInt)
  {
    if (paramInt == 0) {
      return this.a;
    }
    return this.b.get(paramInt - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.msgnotify.NotifySettingData
 * JD-Core Version:    0.7.0.1
 */