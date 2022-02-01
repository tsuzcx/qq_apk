package com.tencent.mobileqq.guild.forwardshare.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IGuildShareForwardApi
  extends IRuntimeService
{
  public static final String GUILD_SHARE_URL = "detail_url";
  public static final String SHARE_LEAVE_MESSAGE = "share_leave_message";
  
  public abstract void ShareForwardMsg(String paramString1, String paramString2, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.forwardshare.api.IGuildShareForwardApi
 * JD-Core Version:    0.7.0.1
 */