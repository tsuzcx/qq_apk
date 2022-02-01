package com.tencent.mobileqq.litelivesdk.sdkimpl.ipc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import cooperation.ilive.lite.IliveLiteMonitorUtil;
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
  private static final Object c = new Object();
  private static LiteSDKForCrossProcess d = null;
  private int a = 0;
  private boolean b = false;
  private Map<String, List<ILiveLoginTicketListener>> e = new HashMap();
  private PendingIPCTaskManager f = new PendingIPCTaskManager();
  private long g = -1L;
  
  private LiteSDKForCrossProcess(String paramString)
  {
    super(paramString);
    g();
  }
  
  private void a(int paramInt)
  {
    LogFactory.a().e("LiteSDKForCrossProcess", "ilive requestHostRefreshToken----");
    Object localObject = (List)this.e.get(BusinessManager.a.b().a);
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
    this.f.c(paramString);
    CustomizedServiceManager.c.c(paramString);
    BusinessManager.a.a(false);
    BusinessManager.a.a(null);
    BusinessManager.a.k();
  }
  
  private void b(String paramString)
  {
    if ("1037".equals(paramString)) {
      return;
    }
    ThreadManager.getUIHandler().post(new LiteSDKForCrossProcess.2(this));
  }
  
  private boolean b(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doEnterRoom-----IPC State = ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" appid = ");
    ((StringBuilder)localObject).append(paramString1);
    QLog.e("LiteSDKForCrossProcess", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("Key_mqq", paramString2);
    if (h())
    {
      if (!this.f.b(paramString1)) {
        this.f.a(paramString1);
      }
      paramString1 = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_EnterRoom", (Bundle)localObject);
      return (paramString1 != null) && (paramString1.isSuccess());
    }
    b(paramString1);
    this.f.a(paramString1, "Action_Client_EnterRoom", (Bundle)localObject);
    return true;
  }
  
  public static LiteSDKForCrossProcess f()
  {
    if (d == null) {
      synchronized (c)
      {
        if (d == null) {
          d = new LiteSDKForCrossProcess("LiteSDKServerModuleName");
        }
      }
    }
    return d;
  }
  
  private void g()
  {
    if (this.b) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LiteSDKForCrossProcess", 2, "init");
    }
    this.b = true;
    QIPCServerHelper.getInstance().getServer().addListener(new LiteSDKForCrossProcess.MyEIPCOnGetConnectionListener(this));
    h();
  }
  
  private boolean h()
  {
    if (this.a != 1)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.g;
      if ((l2 == -1L) || (l1 - l2 > 1000L))
      {
        this.g = l1;
        QLog.e("LiteSDKForCrossProcess", 1, "ilive not connect, try connect ");
        Intent localIntent = new Intent(BaseApplicationImpl.getContext(), PreloadWebService.class);
        localIntent.putExtra("startTime", System.currentTimeMillis());
        localIntent.putExtra("liveSdkBinding", true);
        localIntent.putExtra("liveBindState", this.a);
        try
        {
          BaseApplicationImpl.getContext().startService(localIntent);
        }
        catch (Throwable localThrowable)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("preDownloadIfNecessary=>");
            localStringBuilder.append(localThrowable.getMessage());
            QLog.e("LiteSDKForCrossProcess", 2, localStringBuilder.toString());
          }
        }
      }
      return false;
    }
    return true;
  }
  
  private void i()
  {
    QLog.e("LiteSDKForCrossProcess", 1, "---onBind----start ");
    this.a = 1;
    IliveLiteMonitorUtil.b();
    BusinessConfig localBusinessConfig = BusinessManager.a.b();
    if ((localBusinessConfig != null) && (!this.f.b(localBusinessConfig.a)))
    {
      QLog.e("LiteSDKForCrossProcess", 1, "---onConnectBind----will do pending IPC task");
      this.f.a(localBusinessConfig.a);
    }
    IliveLiteMonitorUtil.c();
    if ((!c()) && (localBusinessConfig != null))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("---onConnectBind----will Reinit Business appid = ");
      ((StringBuilder)localObject1).append(localBusinessConfig.a);
      QLog.e("LiteSDKForCrossProcess", 1, ((StringBuilder)localObject1).toString());
      Object localObject2 = CustomizedServiceManager.c.b(localBusinessConfig.a);
      localObject1 = CustomizedServiceManager.c.a(localBusinessConfig.a);
      CustomizedServiceManager.c.a();
      BusinessManager.a.a(null);
      Iterator localIterator = ((Map)localObject2).keySet().iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        a(localBusinessConfig.a, localClass, (Class)((Map)localObject2).get(localClass));
      }
      localObject2 = ((Map)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        int i = ((Integer)((Iterator)localObject2).next()).intValue();
        a(localBusinessConfig.a, i, (Class)((Map)localObject1).get(Integer.valueOf(i)));
      }
      a(localBusinessConfig);
      a(1);
    }
  }
  
  public void a()
  {
    if (h()) {
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
    if (h()) {
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_InitLiteSDK", localBundle);
    } else {
      this.f.a(paramBusinessConfig.a, "Action_Client_InitLiteSDK", localBundle);
    }
    if ((BusinessManager.a.a()) && (BusinessManager.a.b() != null) && (!TextUtils.isEmpty(BusinessManager.a.b().a)))
    {
      if (BusinessManager.a.b().a.equals(paramBusinessConfig.a)) {
        return;
      }
      a(BusinessManager.a.b().a);
    }
    BusinessManager.a.a(true);
    BusinessManager.a.a(paramBusinessConfig);
  }
  
  public void a(BizLoginRequest paramBizLoginRequest)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("Key_BizLoginRequest", paramBizLoginRequest);
    if (h())
    {
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_Login", localBundle);
      return;
    }
    this.f.a(paramBizLoginRequest.a, "Action_Client_Login", localBundle);
  }
  
  public void a(String paramString, int paramInt, Class<? extends BaseSDKPageBizBootModules> paramClass)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("Key_Appid", paramString);
    localBundle.putInt("Key_PageType", paramInt);
    localBundle.putSerializable("Key_BizModulesClazz", paramClass);
    if (h()) {
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_CustomizedBizModules", localBundle);
    } else {
      this.f.a(paramString, "Action_Client_CustomizedBizModules", localBundle);
    }
    CustomizedServiceManager.c.a(paramString, paramInt, paramClass);
  }
  
  public void a(String paramString, IBusinessExpireObserver paramIBusinessExpireObserver)
  {
    BusinessManager.a.a(paramString, paramIBusinessExpireObserver);
  }
  
  public void a(String paramString, ILiveLoginTicketListener paramILiveLoginTicketListener)
  {
    List localList = (List)this.e.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.e.put(paramString, localObject);
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
    if (h()) {
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_customizedBizSDKService", localBundle);
    } else {
      this.f.a(paramString, "Action_Client_customizedBizSDKService", localBundle);
    }
    CustomizedServiceManager.c.a(paramString, paramClass, paramClass1);
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterRoom-----appid = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", mqq = ");
    localStringBuilder.append(paramString2);
    QLog.e("LiteSDKForCrossProcess", 1, localStringBuilder.toString());
    if ((BusinessManager.a.b() != null) && (BusinessManager.a.b().a.equals(paramString1))) {
      return b(paramString1, paramString2);
    }
    QLog.e("LiteSDKForCrossProcess", 1, "warn: enterRoom-----当前业务初始化信息已被清理");
    BusinessManager.a.c(paramString1).a(new LiteSDKForCrossProcess.1(this, paramString1, paramString2));
    return true;
  }
  
  public BusinessConfig b()
  {
    if (h())
    {
      EIPCResult localEIPCResult = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_GetActiveBizConfig", null);
      if ((localEIPCResult != null) && (localEIPCResult.code == 0))
      {
        localEIPCResult.data.setClassLoader(BusinessConfig.class.getClassLoader());
        return (BusinessConfig)localEIPCResult.data.getParcelable("Key_BusinessConfig");
      }
    }
    return null;
  }
  
  public void b(BusinessConfig paramBusinessConfig)
  {
    if (h())
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("Key_BusinessConfig", paramBusinessConfig);
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_UpdateActiveBizConfig", localBundle);
    }
    BusinessManager.a.a(paramBusinessConfig);
  }
  
  public boolean c()
  {
    if (h())
    {
      EIPCResult localEIPCResult = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_isInitLiteSDK", null);
      if ((localEIPCResult != null) && (localEIPCResult.code == 0)) {
        return localEIPCResult.data.getBoolean("Key_Inited");
      }
    }
    return false;
  }
  
  public LoginResult d()
  {
    if (h())
    {
      EIPCResult localEIPCResult = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_getLiveLoginTicket", null);
      if ((localEIPCResult != null) && (localEIPCResult.code == 0))
      {
        localEIPCResult.data.setClassLoader(LoginResult.class.getClassLoader());
        return (LoginResult)localEIPCResult.data.getParcelable("Key_LoginResult");
      }
    }
    return null;
  }
  
  public void e()
  {
    if (h()) {
      QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:tool", 1, "LiteSDKClientModuleName", "Action_Client_Logout", null);
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    LogInterface localLogInterface = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("======onCall=====action = ");
    localStringBuilder.append(paramString);
    localLogInterface.c("LiteSDKForCrossProcess", localStringBuilder.toString());
    if ("Action_Server_OnBind".equals(paramString))
    {
      i();
    }
    else if ("Action_Server_OnLoginSuccess".equals(paramString))
    {
      paramBundle.setClassLoader(LoginResult.class.getClassLoader());
      paramString = (LoginResult)paramBundle.getParcelable("Key_LoginResult");
      paramBundle = (List)this.e.get(BusinessManager.a.b().a);
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
      paramString = (List)this.e.get(BusinessManager.a.b().a);
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
      paramBundle = new StringBuilder();
      paramBundle.append("LiteSDKForCrossProcess======invaild action: ");
      paramBundle.append(paramString);
      EIPCResult.createExceptionResult(new Throwable(paramBundle.toString()));
    }
    return EIPCResult.createSuccessResult(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.sdkimpl.ipc.LiteSDKForCrossProcess
 * JD-Core Version:    0.7.0.1
 */