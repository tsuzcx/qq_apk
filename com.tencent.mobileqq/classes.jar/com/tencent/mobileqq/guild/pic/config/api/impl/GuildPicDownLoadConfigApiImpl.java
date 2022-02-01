package com.tencent.mobileqq.guild.pic.config.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.pic.config.GuildPicDownloadConfig;
import com.tencent.mobileqq.guild.pic.config.api.IGuildPicDownLoadConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class GuildPicDownLoadConfigApiImpl
  implements IGuildPicDownLoadConfigApi
{
  private static final String TAG = "GuildPicDownLoadConfigApiImpl<gld>";
  
  private GuildPicDownloadConfig getDownloadConfig()
  {
    GuildPicDownloadConfig localGuildPicDownloadConfig2 = (GuildPicDownloadConfig)QConfigManager.b().b(772);
    GuildPicDownloadConfig localGuildPicDownloadConfig1 = localGuildPicDownloadConfig2;
    if (localGuildPicDownloadConfig2 == null) {
      localGuildPicDownloadConfig1 = new GuildPicDownloadConfig();
    }
    return localGuildPicDownloadConfig1;
  }
  
  public boolean[] isPreDownload(int paramInt)
  {
    return new boolean[] { getDownloadConfig().b(), getDownloadConfig().a() };
  }
  
  public void preDownLoadMsg(ArrayList<MessageRecord> paramArrayList, AppInterface paramAppInterface)
  {
    ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).startDownloadPic(paramArrayList, true, paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.pic.config.api.impl.GuildPicDownLoadConfigApiImpl
 * JD-Core Version:    0.7.0.1
 */