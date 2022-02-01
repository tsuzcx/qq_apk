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
  public static ArrayList<Class<? extends BaseProtocolCoder>> a;
  @ConfigInject(configPath="Mqq/resources/Inject_MobileQQServiceConfig.yml", version=1)
  public static ArrayList<Class<? extends BusinessHandler>> b;
  @ConfigInject(configPath="Mqq/resources/Inject_MobileQQServiceConfig.yml", version=1)
  public static ArrayList<Class<? extends BusinessHandler>> c;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(CameraDataService.class);
    jdField_a_of_type_JavaUtilArrayList.add(ProfileService.class);
    jdField_a_of_type_JavaUtilArrayList.add(FriendListService.class);
    jdField_a_of_type_JavaUtilArrayList.add(MessageService.class);
    jdField_a_of_type_JavaUtilArrayList.add(LBSService.class);
    jdField_a_of_type_JavaUtilArrayList.add(QZoneService.class);
    jdField_a_of_type_JavaUtilArrayList.add(PushService.class);
    jdField_a_of_type_JavaUtilArrayList.add(ConfigService.class);
    jdField_a_of_type_JavaUtilArrayList.add(ReportService.class);
    jdField_a_of_type_JavaUtilArrayList.add(DiscussionService.class);
    jdField_a_of_type_JavaUtilArrayList.add(RegisterProxySvcPackService.class);
    jdField_a_of_type_JavaUtilArrayList.add(VIPService.class);
    jdField_a_of_type_JavaUtilArrayList.add(VasService.class);
    jdField_a_of_type_JavaUtilArrayList.add(BmqqBusinessService.class);
    jdField_a_of_type_JavaUtilArrayList.add(UniPayService.class);
    jdField_a_of_type_JavaUtilArrayList.add(VIPRecommendService.class);
    jdField_a_of_type_JavaUtilArrayList.add(VIPAioSendService.class);
    jdField_a_of_type_JavaUtilArrayList.add(QWalletAuthService.class);
    jdField_a_of_type_JavaUtilArrayList.add(WifiSdkService.class);
    b = new ArrayList();
    b.add(MessageHandler.class);
    b.add(SubAccountBindHandler.class);
    b.add(HotChatHandler.class);
    c = new ArrayList();
    c.add(MessageHandler.class);
    c.add(NearFieldDiscussHandler.class);
    c.add(OnlineStatusHandler.class);
  }
  
  public MobileQQService(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    b();
    c();
  }
  
  private void a()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
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
          Object localObject = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(localClass.getName()).getPushCommandList();
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
        localObject = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(((Class)localObject).getName()).getPushPBCommandList();
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
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
    return this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
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
    return this.jdField_a_of_type_JavaUtilList.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.MobileQQService
 * JD-Core Version:    0.7.0.1
 */