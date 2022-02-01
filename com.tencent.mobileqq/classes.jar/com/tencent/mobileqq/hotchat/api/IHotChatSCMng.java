package com.tencent.mobileqq.hotchat.api;

import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.hotchat.HotChatNote;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHotChatSCMng
  extends QRouteApi
{
  public static final boolean DEBUG = true;
  
  public abstract HotChatNote getHotChatNote(String paramString, int paramInt, long paramLong);
  
  public abstract boolean updateHotChatSceneConfig(ConfigurationService.Config paramConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.api.IHotChatSCMng
 * JD-Core Version:    0.7.0.1
 */