package cooperation.smartdevice.ipc;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DevVideoMsgProcessor;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class SmartDeviceIPCHost
  implements Observer
{
  public QQAppInterface a;
  public ISmartDeviceService b;
  public boolean c = false;
  public ArrayList<Bundle> d = new ArrayList();
  ServiceConnection e = new SmartDeviceIPCHost.2(this);
  private Handler f = new SmartDeviceIPCHost.1(this, Looper.getMainLooper());
  
  public SmartDeviceIPCHost(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface = this.a;
    if ((paramQQAppInterface != null) && (paramQQAppInterface.getMessageFacade() != null)) {
      this.a.getMessageFacade().addObserver(this);
    } else if (QLog.isColorLevel()) {
      QLog.i("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost() construct!!!!! error: app == null");
    }
    c();
    d();
  }
  
  private void d()
  {
    if ((this.b == null) && (!this.c) && (this.a != null))
    {
      this.c = true;
      QLog.d("SmartDeviceIPCHost", 1, "start plugin service now");
      this.f.removeMessages(1);
      this.f.sendEmptyMessageDelayed(1, 300000L);
      SmartDeviceReport.a(this.a, "Net_Start_Service_Host", 0, 0, 0);
      SmartDevicePluginLoader.a().a(this.a, this.e);
    }
  }
  
  private void e()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "unregisterRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
      return;
    }
    if (localPluginCommunicationHandler.containsCmd("com.qqsmartdevice.remotecall"))
    {
      localPluginCommunicationHandler.unregister("com.qqsmartdevice.remotecall");
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::unregisterRemoteCommand unregister CMD:com.qqsmartdevice.remotecall");
      }
    }
  }
  
  public Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    String str = paramBundle.getString("notify_cmd");
    if ((this.b == null) && (this.a != null))
    {
      boolean bool = paramBundle.getBoolean("forceStart", false);
      paramBundle = (SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if ((bool) || ((paramBundle != null) && (paramBundle.c())))
      {
        paramBundle = new StringBuilder();
        paramBundle.append("start plugin service when send ");
        paramBundle.append(str);
        QLog.d("SmartDeviceIPCHost", 1, paramBundle.toString());
        d();
      }
      return null;
    }
    b();
    try
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramBundle = this.b.a("com.qqsmartdevice.action.notify", paramBundle);
      if (paramBundle != null) {
        paramBundle.setClassLoader(getClass().getClassLoader());
      }
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("plugin service transfer failed strNotifyCmd:");
        paramBundle.append(str);
        QLog.d("SmartDeviceIPCHost", 2, paramBundle.toString());
      }
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::OnDestory");
    }
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null)
    {
      if (localQQAppInterface.getMessageFacade() != null) {
        this.a.getMessageFacade().deleteObserver(this);
      }
      this.a = null;
    }
    e();
  }
  
  public void b()
  {
    if (!this.d.isEmpty())
    {
      if (this.b == null) {
        return;
      }
      Object localObject1 = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject1).getThread())
      {
        new Handler((Looper)localObject1).post(new SmartDeviceIPCHost.4(this));
        return;
      }
      while (!this.d.isEmpty())
      {
        Bundle localBundle = (Bundle)this.d.remove(0);
        localObject1 = "";
        Object localObject2 = localObject1;
        if (localBundle != null) {}
        try
        {
          localObject2 = localBundle.getString("notify_cmd");
          localObject1 = localObject2;
          localBundle.setClassLoader(getClass().getClassLoader());
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = localObject2;
            StringBuilder localStringBuilder2 = new StringBuilder();
            localObject1 = localObject2;
            localStringBuilder2.append("qq->plugin main thread doPostCachedMsg strNotifyCmd:");
            localObject1 = localObject2;
            localStringBuilder2.append((String)localObject2);
            localObject1 = localObject2;
            localStringBuilder2.append(" thread:");
            localObject1 = localObject2;
            localStringBuilder2.append(Thread.currentThread());
            localObject1 = localObject2;
            QLog.d("SmartDeviceIPCHost", 2, localStringBuilder2.toString());
          }
          localObject1 = localObject2;
          this.b.b("com.qqsmartdevice.action.notify", localBundle);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("mSmartDeviceService.transfer failed strNotifyCmd:");
          localStringBuilder1.append((String)localObject1);
          QLog.d("SmartDeviceIPCHost", 2, localStringBuilder1.toString());
        }
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "params is null");
      }
      return;
    }
    Object localObject1 = paramBundle.getString("notify_cmd");
    if ((this.b == null) && (this.a != null))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("plugin service not started strNotifyCmd:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" cached");
        QLog.d("SmartDeviceIPCHost", 2, ((StringBuilder)localObject2).toString());
      }
      boolean bool = paramBundle.getBoolean("forceStart", false);
      Object localObject2 = (SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if ((bool) || ((localObject2 != null) && (((SmartDeviceProxyMgr)localObject2).c())))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("start plugin service when post ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("SmartDeviceIPCHost", 1, ((StringBuilder)localObject2).toString());
        d();
        localObject1 = Looper.getMainLooper();
        if (Thread.currentThread() != ((Looper)localObject1).getThread())
        {
          new Handler((Looper)localObject1).post(new SmartDeviceIPCHost.3(this, paramBundle));
          return;
        }
        this.d.add(paramBundle);
        b();
      }
      return;
    }
    b();
    if (paramBundle != null) {}
    try
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.b.b("com.qqsmartdevice.action.notify", paramBundle);
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append(" plugin service transfer failed strNotifyCmd:");
        paramBundle.append((String)localObject1);
        QLog.d("SmartDeviceIPCHost", 2, paramBundle.toString());
      }
    }
  }
  
  public Bundle c(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("invoke_cmd");
    Object localObject2;
    if ((QLog.isColorLevel()) && (!"invokeCmdGetFaceBitmap".equals(localObject1)))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SmartDeviceIPCHost::OnRemoteInvoke strNotifyCmd:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("SmartDeviceIPCHost", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.a == null) {
      return null;
    }
    if (((String)localObject1).compareToIgnoreCase("invokeCmdOpenChatMsgActivity") == 0)
    {
      ((SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramBundle);
      return null;
    }
    if (((String)localObject1).equals("SmartDeviceHandler_makeSureProxyServiceStart"))
    {
      this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER);
      if (this.b != null)
      {
        SmartDeviceReport.a(this.a, "Net_Start_Service_Remote", 0, 1, 0);
        return null;
      }
      this.c = false;
      QLog.d("SmartDeviceIPCHost", 1, "try to start service again");
      d();
      SmartDeviceReport.a(this.a, "Net_Start_Service_Remote", 0, 0, 0);
      return null;
    }
    if (((String)localObject1).compareToIgnoreCase("invokeCmdStartVideoChat") == 0)
    {
      if (paramBundle.containsKey("devSubCode"))
      {
        localObject1 = new HashMap();
        ((Map)localObject1).put("devSubCode", paramBundle.getString("devSubCode"));
      }
      else
      {
        localObject1 = null;
      }
      localObject2 = this.a;
      ChatActivityUtils.a((QQAppInterface)localObject2, ((QQAppInterface)localObject2).getApp().getApplicationContext(), 9500, paramBundle.getString("din"), paramBundle.getString("devName"), "", paramBundle.getBoolean("onlyAudio", false), paramBundle.getString("tinyid"), true, false, null, "from_internal", (Map)localObject1);
      return null;
    }
    if (((String)localObject1).compareToIgnoreCase("invokeCmdStartVideoMessage") == 0)
    {
      localObject1 = this.a;
      DevVideoMsgProcessor.a((QQAppInterface)localObject1, ((QQAppInterface)localObject1).getApp().getApplicationContext(), paramBundle.getString("din"), paramBundle.getString("videoPath"));
      return null;
    }
    if (((String)localObject1).compareToIgnoreCase("invokeCmdGetBuddyName") == 0)
    {
      paramBundle = paramBundle.getString("Uin");
      paramBundle = ContactUtils.a(this.a, paramBundle, true);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("BuddyName", paramBundle);
      return localObject1;
    }
    if (((String)localObject1).compareToIgnoreCase("invokeCmdTransFileController") == 0)
    {
      ((SmartDeviceProxyMgr)this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).b(paramBundle);
      return null;
    }
    int i;
    if (((String)localObject1).compareToIgnoreCase("invokeCmdGetLockState") == 0)
    {
      i = EquipmentLockImpl.a().a(this.a, BaseApplicationImpl.getApplication());
      paramBundle = new Bundle();
      paramBundle.putInt("LockState", i);
      return paramBundle;
    }
    if (((String)localObject1).compareToIgnoreCase("qfind_localnotify") == 0)
    {
      long l = paramBundle.getLong("din");
      paramBundle = paramBundle.getString("msg");
      localObject1 = (MessageForText)MessageRecordFactory.a(-1000);
      ((MessageForText)localObject1).msgtype = -1000;
      ((MessageForText)localObject1).istroop = 9501;
      ((MessageForText)localObject1).issend = 0;
      ((MessageForText)localObject1).isread = false;
      ((MessageForText)localObject1).selfuin = this.a.getCurrentAccountUin();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("");
      ((MessageForText)localObject1).senderuin = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("");
      ((MessageForText)localObject1).frienduin = ((StringBuilder)localObject2).toString();
      ((MessageForText)localObject1).msg = paramBundle;
      ((MessageForText)localObject1).time = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
      this.a.getMsgHandler().b((MessageRecord)localObject1);
      return null;
    }
    if (((String)localObject1).compareToIgnoreCase("init_msgHandler") == 0)
    {
      this.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      return null;
    }
    if (((String)localObject1).compareToIgnoreCase("invokeCmdGetFaceBitmap") == 0)
    {
      paramBundle = paramBundle.getString("uin");
      paramBundle = this.a.getFaceBitmap(paramBundle, true);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putParcelable("face_bitmap", paramBundle);
      return localObject1;
    }
    if (((String)localObject1).compareToIgnoreCase("invokeCmdGetUnreadMsgNum") == 0)
    {
      paramBundle = paramBundle.getString("din");
      i = this.a.getConversationFacade().a(paramBundle, 9501);
      paramBundle = new Bundle();
      paramBundle.putInt("unread", i);
      return paramBundle;
    }
    return null;
  }
  
  public void c()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "PluginCommunicationHandler.getInstance failed");
      }
      return;
    }
    localPluginCommunicationHandler.register(new SmartDeviceIPCHost.5(this, "com.qqsmartdevice.remotecall"));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (paramObservable.istroop == 9501)
      {
        paramObject = this.a;
        if ((paramObject != null) && (paramObject.getConversationFacade().a(paramObservable.frienduin, 9501) > 0))
        {
          paramObservable = new Bundle();
          paramObservable.putString("notify_cmd", "updateUnreadMsgsNum");
          b(paramObservable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.smartdevice.ipc.SmartDeviceIPCHost
 * JD-Core Version:    0.7.0.1
 */