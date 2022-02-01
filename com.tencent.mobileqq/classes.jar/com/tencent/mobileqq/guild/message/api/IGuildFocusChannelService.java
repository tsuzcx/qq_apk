package com.tencent.mobileqq.guild.message.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashSet;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IGuildFocusChannelService
  extends IRuntimeService
{
  public abstract String getCurActiveChannelId();
  
  public abstract boolean isHugeChannel(String paramString);
  
  public abstract void updateCurChannelId(String paramString1, String paramString2);
  
  public abstract void updateFocusChannel(HashSet<String> paramHashSet);
  
  public abstract void updateHugeChannel(HashSet<String> paramHashSet);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildFocusChannelService
 * JD-Core Version:    0.7.0.1
 */