package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IQQGuildJubaoApi
  extends QRouteApi
{
  public abstract void reportGuild(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4);
  
  public abstract void reportGuild(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean);
  
  public abstract void reportGuild(QBaseActivity paramQBaseActivity, String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IQQGuildJubaoApi
 * JD-Core Version:    0.7.0.1
 */