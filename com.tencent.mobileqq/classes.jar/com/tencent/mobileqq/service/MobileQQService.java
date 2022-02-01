package com.tencent.mobileqq.service;

import com.tencent.aelight.camera.ae.config.CameraDataService;
import com.tencent.biz.bmqq.protocol.BmqqBusinessService;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NearFieldDiscussHandler;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.guild.message.api.impl.GuildMessagePushHandler;
import com.tencent.mobileqq.hotchat.app.HotChatHandler;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.service.RegisterProxySvcPack.RegisterProxySvcPackService;
import com.tencent.mobileqq.service.config.ConfigService;
import com.tencent.mobileqq.service.discussion.DiscussionService;
import com.tencent.mobileqq.service.friendlist.FriendListService;
import com.tencent.mobileqq.service.lbs.LBSService;
import com.tencent.mobileqq.service.message.MessageService;
import com.tencent.mobileqq.service.profile.ProfileService;
import com.tencent.mobileqq.service.push.PushService;
import com.tencent.mobileqq.service.qwallet.QWalletAuthService;
import com.tencent.mobileqq.service.qwallet.UniPayService;
import com.tencent.mobileqq.service.qwallet.VIPRecommendService;
import com.tencent.mobileqq.service.qzone.QZoneService;
import com.tencent.mobileqq.service.report.ReportService;
import com.tencent.mobileqq.service.wifisdk.WifiSdkService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountBindHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MSFServlet;

public class MobileQQService
  extends MobileQQServiceBase
{
  @ConfigInject(configPath="Mqq/resources/Inject_MobileQQServiceConfig.yml", version=1)
  public static ArrayList<Class<? extends BaseProtocolCoder>> a = new ArrayList();
  @ConfigInject(configPath="Mqq/resources/Inject_MobileQQServiceConfig.yml", version=1)
  public static ArrayList<Class<? extends BusinessHandler>> b;
  @ConfigInject(configPath="Mqq/resources/Inject_MobileQQServiceConfig.yml", version=1)
  public static ArrayList<Class<? extends BusinessHandler>> c;
  private BaseQQAppInterface d;
  private List<String> e = new ArrayList();
  
  static
  {
    a.add(CameraDataService.class);
    a.add(ProfileService.class);
    a.add(FriendListService.class);
    a.add(MessageService.class);
    a.add(LBSService.class);
    a.add(QZoneService.class);
    a.add(PushService.class);
    a.add(ConfigService.class);
    a.add(ReportService.class);
    a.add(DiscussionService.class);
    a.add(RegisterProxySvcPackService.class);
    a.add(VIPService.class);
    a.add(VasService.class);
    a.add(BmqqBusinessService.class);
    a.add(UniPayService.class);
    a.add(VIPRecommendService.class);
    a.add(VIPAioSendService.class);
    a.add(QWalletAuthService.class);
    a.add(WifiSdkService.class);
    b = new ArrayList();
    b.add(MessageHandler.class);
    b.add(SubAccountBindHandler.class);
    b.add(GuildMessagePushHandler.class);
    b.add(HotChatHandler.class);
    c = new ArrayList();
    c.add(MessageHandler.class);
    c.add(NearFieldDiscussHandler.class);
    c.add(OnlineStatusHandler.class);
  }
  
  public MobileQQService(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.d = paramBaseQQAppInterface;
    b();
    c();
  }
  
  private void a()
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      try
      {
        addCoder((BaseProtocolCoder)localClass.newInstance());
      }
      catch (Exception localException)
      {
        QLog.e("MobileQQService", 1, "translate inject coder error", localException);
      }
    }
  }
  
  private void b()
  {
    Iterator localIterator = b.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        try
        {
          Object localObject = this.d.getBusinessHandler(localClass.getName()).getPushCommandList();
          if ((localObject != null) && (!((Set)localObject).isEmpty()))
          {
            localObject = ((Set)localObject).iterator();
            while (((Iterator)localObject).hasNext()) {
              Cmd2HandlerMapHelper.a((String)((Iterator)localObject).next(), localClass.getName());
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("MobileQQService", 1, "translate inject pushCmd handler error", localException);
        }
      }
    }
  }
  
  private void c()
  {
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Class)localIterator.next();
      try
      {
        localObject = this.d.getBusinessHandler(((Class)localObject).getName()).getPushPBCommandList();
        if (localObject != null) {
          this.e.addAll((Collection)localObject);
        }
      }
      catch (Exception localException)
      {
        QLog.e("MobileQQService", 1, "translate inject pushPBCmd handler error", localException);
      }
    }
  }
  
  public void destroy()
  {
    super.destroy();
    if (QLog.isColorLevel()) {
      QLog.i("MobileQQService", 2, "MobileQQService has destroyed.");
    }
  }
  
  public AppInterface getAppInterface()
  {
    return this.d;
  }
  
  protected Class<? extends MSFServlet> getServlet()
  {
    return TempServlet.class;
  }
  
  protected void initCoders()
  {
    try
    {
      a();
      super.setCodersInit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isPBPushCmd(String paramString)
  {
    return this.e.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.MobileQQService
 * JD-Core Version:    0.7.0.1
 */