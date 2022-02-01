package com.tencent.mobileqq.guild.message.data;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.guild.message.base.AbsGuildGuestMessageProcessorCallback;
import com.tencent.mobileqq.guild.pic.config.api.IGuildPicDownLoadConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasExtensionManager;
import java.util.ArrayList;

public class GuildGuestMessageProcessorCallback
  extends AbsGuildGuestMessageProcessorCallback
{
  public void a(AppInterface paramAppInterface, ArrayList<MessageRecord> paramArrayList)
  {
    ((IGuildPicDownLoadConfigApi)QRoute.api(IGuildPicDownLoadConfigApi.class)).preDownLoadMsg(paramArrayList, paramAppInterface);
    ((VasExtensionManager)paramAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).d.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.data.GuildGuestMessageProcessorCallback
 * JD-Core Version:    0.7.0.1
 */