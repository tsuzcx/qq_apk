package com.tencent.mobileqq.guild.pic.config.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IGuildPicDownLoadConfigApi
  extends QRouteApi
{
  public static final String GUILD_PIC_LOG_TAG = "<gld>";
  
  public abstract boolean[] isPreDownload(int paramInt);
  
  public abstract void preDownLoadMsg(ArrayList<MessageRecord> paramArrayList, AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.pic.config.api.IGuildPicDownLoadConfigApi
 * JD-Core Version:    0.7.0.1
 */