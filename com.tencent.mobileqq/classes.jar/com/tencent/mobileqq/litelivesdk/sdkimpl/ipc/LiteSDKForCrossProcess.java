package com.tencent.mobileqq.litelivesdk.sdkimpl.ipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.litelivesdk.api.IBusinessExpireObserver;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.customized.BaseSDKPageBizBootModules;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.mobileqq.litelivesdk.api.login.ILiveLoginTicketListener;
import com.tencent.mobileqq.litelivesdk.api.login.LoginResult;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.customizedmgr.CustomizedServiceManager;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCServer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

public class LiteSDKForCrossProcess
  extends QIPCModule
  implements ILiveSDK
{
  private static LiteSDKForCrossProcess jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcLiteSDKForCrossProcess = null;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = -1L;
  private PendingIPCTaskManager jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcPendingIPCTaskManager = new PendingIPCTaskManager();
  private Map<String, List<ILiveLoginTicketListener>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  private LiteSDKForCrossProcess(String paramString)
  {
    super(paramString);
    c();
  }
  
  public static LiteSDKForCrossProcess a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcLiteSDKForCrossProcess == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcLiteSDKForCrossProcess == null) {
        jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcLiteSDKForCrossProcess = new LiteSDKForCrossProcess("LiteSDKServerModuleName");
      }
      return jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcLiteSDKForCrossProcess;
    }
  }
  
  private void a(int paramInt)
  {
    LogFactory.a().e("LiteSDKForCrossProcess", "ilive requestHostRefreshToken----");
    Object localObject = (List)this.jdField_a_of_type_JavaUtilMap.get(BusinessManager.a.a().a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ILiveLoginTicketListener localILiveLoginTicketListener = (ILiveLoginTicketListener)((Iterator)localObject).next();
        localILiveLoginTicketListener.a(paramInt, new LiteSDKForCrossProcess.3(this, paramInt, localILiveLoginTicketListener));
      }
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcPendingIPCTaskManager.b(paramString);
    CustomizedServiceManager.a.a(paramString);
    BusinessManager.a.a(false);
    BusinessManager.a.a(null);
  }
  
  private boolean b()
  {
    boolean bool = true;
    Intent localIntent;
    if (this.jdField_a_of_type_Int != 1)
    {
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Long == -1L) || (l - this.jdField_a_of_type_Long > 1000L))
      {
        this.jdField_a_of_type_Long = l;
        QLog.e("LiteSDKForCrossProcess", 1, "ilive not connect, try connect ");
        localIntent = new Intent(BaseApplicationImpl.getContext(), PreloadWebService.class);
        localIntent.putExtra("liveSdkBinding", true);
        localIntent.putExtra("liveBindState", this.jdField_a_of_type_Int);
      }
    }
    try
    {
      BaseApplicationImpl.getContext().startService(localIntent);
      bool = false;
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LiteSDKForCrossProcess", 2, "preDownloadIfNecessary=>" + localThrowable.getMessage());
        }
      }
    }
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    QLog.e("LiteSDKForCrossProcess", 1, "doEnterRoom-----IPC State = " + this.jdField_a_of_type_Int + " appid = " + paramString1);
    Bundle localBundle = new Bundle();
    localBundle.putString("Key_mqq", paramString2);
    if (b())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcPendingIPCTaskManager.a(paramString1)) {
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcPendingIPCTaskManager.a(paramString1);
      }
      paramString1 = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_EnterRoom", localBundle);
      return (paramString1 != null) && (paramString1.isSuccess());
    }
    ThreadManager.getUIHandler().post(new LiteSDKForCrossProcess.2(this));
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcPendingIPCTaskManager.a(paramString1, "Action_Client_EnterRoom", localBundle);
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LiteSDKForCrossProcess", 2, "init");
    }
    this.jdField_a_of_type_Boolean = true;
    QIPCServerHelper.getInstance().getServer().addListener(new LiteSDKForCrossProcess.MyEIPCOnGetConnectionListener(this));
    b();
  }
  
  private void d()
  {
    QLog.e("LiteSDKForCrossProcess", 1, "---onBind----start ");
    this.jdField_a_of_type_Int = 1;
    BusinessConfig localBusinessConfig = BusinessManager.a.a();
    if ((localBusinessConfig != null) && (!this.jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcPendingIPCTaskManager.a(localBusinessConfig.a)))
    {
      QLog.e("LiteSDKForCrossProcess", 1, "---onConnectBind----will do pending IPC task");
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcPendingIPCTaskManager.a(localBusinessConfig.a);
    }
    if ((!a()) && (localBusinessConfig != null))
    {
      QLog.e("LiteSDKForCrossProcess", 1, "---onConnectBind----will Reinit Business appid = " + localBusinessConfig.a);
      Object localObject = CustomizedServiceManager.a.b(localBusinessConfig.a);
      Map localMap = CustomizedServiceManager.a.a(localBusinessConfig.a);
      CustomizedServiceManager.a.a();
      BusinessManager.a.a(null);
      Iterator localIterator = ((Map)localObject).keySet().iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        a(localBusinessConfig.a, localClass, (Class)((Map)localObject).get(localClass));
      }
      localObject = localMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((Integer)((Iterator)localObject).next()).intValue();
        a(localBusinessConfig.a, i, (Class)localMap.get(Integer.valueOf(i)));
      }
      a(localBusinessConfig);
      a(1);
    }
  }
  
  public BusinessConfig a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (b())
    {
      EIPCResult localEIPCResult = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_GetActiveBizConfig", null);
      localObject1 = localObject2;
      if (localEIPCResult != null)
      {
        localObject1 = localObject2;
        if (localEIPCResult.code == 0)
        {
          localEIPCResult.data.setClassLoader(BusinessConfig.class.getClassLoader());
          localObject1 = (BusinessConfig)localEIPCResult.data.getParcelable("Key_BusinessConfig");
        }
      }
    }
    return localObject1;
  }
  
  public LoginResult a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (b())
    {
      EIPCResult localEIPCResult = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_getLiveLoginTicket", null);
      localObject1 = localObject2;
      if (localEIPCResult != null)
      {
        localObject1 = localObject2;
        if (localEIPCResult.code == 0)
        {
          localEIPCResult.data.setClassLoader(LoginResult.class.getClassLoader());
          localObject1 = (LoginResult)localEIPCResult.data.getParcelable("Key_LoginResult");
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    if (b()) {
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_UninitLiteSDK", null);
    }
  }
  
  public void a(BusinessConfig paramBusinessConfig)
  {
    if (paramBusinessConfig == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Key_BusinessConfig", paramBusinessConfig);
    if (b()) {
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_InitLiteSDK", localBundle);
    }
    for (;;)
    {
      if ((BusinessManager.a.a()) && (BusinessManager.a.a() != null))
      {
        if (BusinessManager.a.a().a.equals(paramBusinessConfig.a)) {
          break;
        }
        a(BusinessManager.a.a().a);
      }
      BusinessManager.a.a(true);
      BusinessManager.a.a(paramBusinessConfig);
      return;
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcPendingIPCTaskManager.a(paramBusinessConfig.a, "Action_Client_InitLiteSDK", localBundle);
    }
  }
  
  public void a(BizLoginRequest paramBizLoginRequest)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Key_BizLoginRequest", paramBizLoginRequest);
    if (b())
    {
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_Login", localBundle);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcPendingIPCTaskManager.a(paramBizLoginRequest.a, "Action_Client_Login", localBundle);
  }
  
  public void a(String paramString, int paramInt, Class<? extends BaseSDKPageBizBootModules> paramClass)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("Key_Appid", paramString);
    localBundle.putInt("Key_PageType", paramInt);
    localBundle.putSerializable("Key_BizModulesClazz", paramClass);
    if (b()) {
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_CustomizedBizModules", localBundle);
    }
    for (;;)
    {
      CustomizedServiceManager.a.a(paramString, paramInt, paramClass);
      return;
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcPendingIPCTaskManager.a(paramString, "Action_Client_CustomizedBizModules", localBundle);
    }
  }
  
  public void a(String paramString, IBusinessExpireObserver paramIBusinessExpireObserver)
  {
    BusinessManager.a.a(paramString, paramIBusinessExpireObserver);
  }
  
  public void a(String paramString, ILiveLoginTicketListener paramILiveLoginTicketListener)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    ((List)localObject).clear();
    ((List)localObject).add(paramILiveLoginTicketListener);
  }
  
  public void a(String paramString, Class<? extends ServiceBaseInterface> paramClass, Class<? extends BaseServiceBuilder> paramClass1)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("Key_Appid", paramString);
    localBundle.putSerializable("Key_ServiceClazz", paramClass);
    localBundle.putSerializable("Key_ServiceBuildClazz", paramClass1);
    if (b()) {
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_customizedBizSDKService", localBundle);
    }
    for (;;)
    {
      CustomizedServiceManager.a.a(paramString, paramClass, paramClass1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkSdkimplIpcPendingIPCTaskManager.a(paramString, "Action_Client_customizedBizSDKService", localBundle);
    }
  }
  
  public boolean a()
  {
    if (b())
    {
      EIPCResult localEIPCResult = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_isInitLiteSDK", null);
      if ((localEIPCResult != null) && (localEIPCResult.code == 0)) {
        return localEIPCResult.data.getBoolean("Key_Inited");
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    QLog.e("LiteSDKForCrossProcess", 1, "enterRoom-----appid = " + paramString1 + ", mqq = " + paramString2);
    if ((BusinessManager.a.a() != null) && (BusinessManager.a.a().a.equals(paramString1))) {
      return b(paramString1, paramString2);
    }
    QLog.e("LiteSDKForCrossProcess", 1, "warn: enterRoom-----当前业务初始化信息已被清理");
    BusinessManager.a.a(paramString1).a(new LiteSDKForCrossProcess.1(this, paramString1, paramString2));
    return true;
  }
  
  public void b()
  {
    if (b()) {
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_Logout", null);
    }
  }
  
  public void b(BusinessConfig paramBusinessConfig)
  {
    if (b())
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("Key_BusinessConfig", paramBusinessConfig);
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_UpdateActiveBizConfig", localBundle);
    }
    BusinessManager.a.a(paramBusinessConfig);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    LogFactory.a().c("LiteSDKForCrossProcess", "======onCall=====action = " + paramString);
    if ("Action_Server_OnBind".equals(paramString)) {
      d();
    }
    for (;;)
    {
      return EIPCResult.createSuccessResult(null);
      if ("Action_Server_OnLoginSuccess".equals(paramString))
      {
        paramBundle.setClassLoader(LoginResult.class.getClassLoader());
        paramString = (LoginResult)paramBundle.getParcelable("Key_LoginResult");
        paramBundle = (List)this.jdField_a_of_type_JavaUtilMap.get(BusinessManager.a.a().a);
        if (paramBundle != null)
        {
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext()) {
            ((ILiveLoginTicketListener)paramBundle.next()).a(paramString);
          }
        }
      }
      else if ("Action_Server_OnLoginFailed".equals(paramString))
      {
        paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(BusinessManager.a.a().a);
        if (paramString != null)
        {
          paramString = paramString.iterator();
          while (paramString.hasNext()) {
            ((ILiveLoginTicketListener)paramString.next()).a(paramBundle.getInt("Key_ErrCode"), paramBundle.getString("Key_ErrMsg"));
          }
        }
      }
      else if ("Action_Server_OnRefreshToken".equals(paramString))
      {
        a(2);
      }
      else
      {
        EIPCResult.createExceptionResult(new Throwable("LiteSDKForCrossProcess======invaild action: " + paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.LiteSDKForCrossProcess
 * JD-Core Version:    0.7.0.1
 */