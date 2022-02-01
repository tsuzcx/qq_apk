package cooperation.qqdataline.ipc;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.DatalineHelper;
import cooperation.qqdataline.QQProxyForDataline;
import cooperation.qqdataline.ServerInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;

public class DatalineRemoteManager
  implements Observer
{
  QQAppInterface a;
  IDatalineService b;
  boolean c = false;
  ArrayList<Bundle> d = new ArrayList();
  QQCustomDialog e;
  boolean f = false;
  private ServiceConnection g = new DatalineRemoteManager.7(this);
  
  public DatalineRemoteManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.a.getMessageFacade().addObserver(this);
    m();
  }
  
  private Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    String str = paramBundle.getString("notify_cmd");
    if (this.b == null)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("mDatalineService not started strNotifyCmd:");
        paramBundle.append(str);
        QLog.d("DatalineRemoteManager", 2, paramBundle.toString());
      }
      f();
      return null;
    }
    l();
    try
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sendRemoteNotify send success strNotifyCmd:");
        localStringBuilder.append(str);
        QLog.d("DatalineRemoteManager", 2, localStringBuilder.toString());
      }
      paramBundle = this.b.a("com.qqdataline.action.notify", paramBundle);
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
        paramBundle.append("sendRemoteNotify send failed strNotifyCmd:");
        paramBundle.append(str);
        QLog.d("DatalineRemoteManager", 2, paramBundle.toString());
      }
    }
    return null;
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject;
    if (paramBundle != null) {
      localObject = paramBundle.getString("notify_cmd");
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder;
    if (this.b == null)
    {
      if (((String)localObject).equals("onReceive"))
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("postRemoteNotify mDatalineService not started strNotifyCmd:");
          paramBundle.append((String)localObject);
          paramBundle.append(" no need cached");
          QLog.d("DatalineRemoteManager", 2, paramBundle.toString());
        }
        return;
      }
      if (paramBoolean) {
        f();
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("postRemoteNotify mDatalineService not started strNotifyCmd:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" cached");
        QLog.d("DatalineRemoteManager", 2, localStringBuilder.toString());
      }
      localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new DatalineRemoteManager.9(this, paramBundle));
        return;
      }
      b(paramBundle);
      this.d.add(paramBundle);
      return;
    }
    l();
    if (paramBundle != null) {}
    try
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("postRemoteNotify send success strNotifyCmd:");
        localStringBuilder.append((String)localObject);
        QLog.d("DatalineRemoteManager", 2, localStringBuilder.toString());
      }
      this.b.b("com.qqdataline.action.notify", paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("postRemoteNotify send failed strNotifyCmd:");
        paramBundle.append((String)localObject);
        QLog.d("DatalineRemoteManager", 2, paramBundle.toString());
      }
    }
  }
  
  private void b(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle = paramBundle.getString("notify_cmd");
    } else {
      paramBundle = "";
    }
    Bundle localBundle;
    if (paramBundle.equals("onReceiveRegisterProxySvcPack"))
    {
      paramBundle = this.d.iterator();
      do
      {
        if (!paramBundle.hasNext()) {
          break;
        }
        localBundle = (Bundle)paramBundle.next();
      } while (!localBundle.getString("notify_cmd").equals("onReceiveRegisterProxySvcPack"));
      this.d.remove(localBundle);
      return;
    }
    if (paramBundle.equals("UpdateUnreadMsgsNum"))
    {
      paramBundle = this.d.iterator();
      while (paramBundle.hasNext())
      {
        localBundle = (Bundle)paramBundle.next();
        if (localBundle.getString("notify_cmd").equals("UpdateUnreadMsgsNum")) {
          this.d.remove(localBundle);
        }
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    if (paramInt == 2)
    {
      DatalineHelper.a("0X800672B");
    }
    else if (paramInt == 1)
    {
      DatalineHelper.a("0X800672C");
      localObject = this.a;
      if (localObject != null)
      {
        localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
        if (localObject != null)
        {
          Message localMessage = ((MqqHandler)localObject).obtainMessage(1134022);
          localMessage.arg1 = 0;
          ((MqqHandler)localObject).sendMessage(localMessage);
        }
        localObject = new Intent();
        ((Intent)localObject).setAction("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_REFUSE_AUTH");
        this.a.getApp().sendBroadcast((Intent)localObject);
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("notify_cmd", "authWifiphoto");
    ((Bundle)localObject).putInt("authresult", paramInt);
    localObject = a((Bundle)localObject);
    if (localObject == null) {
      return false;
    }
    return ((Bundle)localObject).getBoolean("result");
  }
  
  private Bundle c(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("invoke_cmd");
    long l1;
    int j;
    Object localObject2;
    if (((String)localObject1).equals("DatalineHandler_sendC2CMessage_ToService"))
    {
      l1 = paramBundle.getLong("uCookie");
      localObject1 = paramBundle.getString("toUin");
      i = paramBundle.getInt("c2cCmd");
      j = paramBundle.getInt("subCmd");
      int k = paramBundle.getInt("datalineCmd");
      localObject2 = paramBundle.getByteArray("bodyContent");
      long l2 = paramBundle.getLong("nSessionId");
      paramBundle = new Bundle();
      paramBundle.putParcelable("ToServiceMsg", ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(l1, (String)localObject1, i, j, k, (byte[])localObject2, l2));
      return paramBundle;
    }
    if (((String)localObject1).equals("BusinessHandler_sendPbReq"))
    {
      ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).sendPbReq((ToServiceMsg)paramBundle.getParcelable("ToServiceMsg"));
      return null;
    }
    boolean bool = ((String)localObject1).equals("DataLineMsgProxy_getInitMpfileTaskRecordList");
    int i = 0;
    if (bool)
    {
      paramBundle = this.a.getProxyManager().d();
      if (paramBundle != null)
      {
        localObject1 = paramBundle.a();
        if (((List)localObject1).size() > 0)
        {
          paramBundle = new MessageRecordParcel[((List)localObject1).size()];
          while (i < paramBundle.length)
          {
            paramBundle[i] = new MessageRecordParcel((MessageRecord)((List)localObject1).get(i));
            i += 1;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putParcelableArray("result", paramBundle);
          return localObject1;
        }
      }
    }
    else
    {
      if (((String)localObject1).equals("DataLineMPfile_browserMpfileInfo"))
      {
        a((MpfileTaskInfo)paramBundle.getParcelable("taskInfo"), paramBundle.getLong("din"));
        return null;
      }
      if (((String)localObject1).equals("DataLineWifiphoto_showWifiphotoBar"))
      {
        i = paramBundle.getInt("what");
        j = paramBundle.getInt("status");
        paramBundle = this.a.getHandler(Conversation.class);
        if (paramBundle != null)
        {
          localObject1 = paramBundle.obtainMessage(i);
          ((Message)localObject1).arg1 = j;
          paramBundle.sendMessage((Message)localObject1);
          return null;
        }
      }
      else
      {
        if (((String)localObject1).equals("DataLineMsgProxy_add_DataLineMsgRecord"))
        {
          a((DataLineMsgRecord)((MessageRecordParcel)paramBundle.getParcelable("Entity")).a(), null);
          return null;
        }
        if (((String)localObject1).equals("DataLineMsgProxy_add_MpfileTaskRecord"))
        {
          a((MpfileTaskRecord)((MessageRecordParcel)paramBundle.getParcelable("Entity")).a(), null);
          return null;
        }
        if (((String)localObject1).equals("DataLineMsgProxy_update"))
        {
          a(paramBundle.getString("tableName"), (ContentValues)paramBundle.getParcelable("value"), paramBundle.getString("whereClause"), paramBundle.getStringArray("whereArgs"), null);
          return null;
        }
        if (((String)localObject1).equals("DataLineMsgProxy_delete"))
        {
          a(paramBundle.getString("tableName"), paramBundle.getString("whereClause"), paramBundle.getStringArray("whereArgs"), null);
          return null;
        }
        if (((String)localObject1).equals("RouterHandler_datalineSendCCMsg"))
        {
          bool = RouterHandler.a(paramBundle.getLong("din"), paramBundle.getInt("nCookie"), paramBundle.getByteArray("buffer"));
          paramBundle = new Bundle();
          paramBundle.putBoolean("result", bool);
          return paramBundle;
        }
        if (((String)localObject1).equals("RouterHandler_datalineSendCSMsg"))
        {
          bool = RouterHandler.a(paramBundle.getInt("nUserCmd"), paramBundle.getInt("nCookie"), paramBundle.getByteArray("buffer"));
          paramBundle = new Bundle();
          paramBundle.putBoolean("result", bool);
          return paramBundle;
        }
        if (((String)localObject1).equals("RouterHandler_getSelfDeviceUin"))
        {
          l1 = RouterHandler.b();
          paramBundle = new Bundle();
          paramBundle.putLong("result", l1);
          return paramBundle;
        }
        if (((String)localObject1).equals("DatalineHandler_saveFileManagerEntity"))
        {
          localObject1 = paramBundle.getString("strFilePath");
          i = paramBundle.getInt("nOpType");
          l1 = paramBundle.getLong("sCurDIN");
          paramBundle = FileManagerUtil.a((String)localObject1);
          localObject2 = this.a.getCurrentAccountUin();
          FileManagerEntity localFileManagerEntity = this.a.getFileManagerDataCenter().b(-1L, (String)localObject2, 6000);
          localFileManagerEntity.nOpType = i;
          localFileManagerEntity.fileSize = FileManagerUtil.h((String)localObject1);
          localFileManagerEntity.isReaded = true;
          localFileManagerEntity.peerUin = ((String)localObject2);
          if (l1 == 0L) {
            localFileManagerEntity.peerNick = this.a.getApplication().getString(2131892059);
          } else {
            localFileManagerEntity.peerNick = this.a.getApplication().getString(2131892061);
          }
          localFileManagerEntity.setFilePath((String)localObject1);
          localFileManagerEntity.srvTime = (MessageCache.c() * 1000L);
          localFileManagerEntity.fileName = paramBundle;
          localFileManagerEntity.setCloudType(3);
          localFileManagerEntity.bSend = false;
          localFileManagerEntity.status = 1;
          localFileManagerEntity.fProgress = 1.0F;
          this.a.getFileManagerDataCenter().a(localFileManagerEntity);
          return null;
        }
        if (((String)localObject1).equals("DatalineHandler_showWifiphotoActivity"))
        {
          o();
          return null;
        }
        if (((String)localObject1).equals("BusinessHandler_makeSureProxyServiceStart"))
        {
          f();
          return null;
        }
        if (((String)localObject1).equals("DatalineHandler_showWifiphotoAuthDlg"))
        {
          g();
          return null;
        }
        if (((String)localObject1).equals("DatalineHandler_dismissReqAuthDlg"))
        {
          i();
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "OnRemoteInvoke unknow invokeCmd");
        }
      }
    }
    return null;
  }
  
  private void f()
  {
    if ((this.b == null) && (!this.c))
    {
      this.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "mDatalineService start service");
      }
      DatalineProxyService.a(this.a, this.g);
    }
  }
  
  private void g()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DatalineRemoteManager.1(this));
      return;
    }
    h();
  }
  
  private void h()
  {
    if (this.e != null) {
      return;
    }
    if (!BaseActivity.mAppForground)
    {
      b(3);
      return;
    }
    if (BaseActivity.sTopActivity == null)
    {
      b(3);
      return;
    }
    if (!CheckPermission.isHasStoragePermission(BaseActivity.sTopActivity))
    {
      CheckPermission.requestSDCardPermission(BaseActivity.sTopActivity, new DatalineRemoteManager.2(this));
      return;
    }
    j();
  }
  
  private void i()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DatalineRemoteManager.3(this));
      return;
    }
    k();
  }
  
  private void j()
  {
    b(0);
    this.f = false;
    this.e = DialogUtil.a(BaseActivity.sTopActivity, 230, HardCodeUtil.a(2131900908), HardCodeUtil.a(2131900912), 2131892140, 2131918207, new DatalineRemoteManager.4(this), new DatalineRemoteManager.5(this));
    this.e.setOnDismissListener(new DatalineRemoteManager.6(this));
    TextView localTextView = (TextView)this.e.findViewById(2131431876);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setMinHeight(DisplayUtil.a(BaseActivity.sTopActivity, 35.0F));
    localTextView.setGravity(17);
    this.e.show();
  }
  
  private void k()
  {
    QQCustomDialog localQQCustomDialog = this.e;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.e = null;
    }
  }
  
  private void l()
  {
    if (this.d.isEmpty()) {
      return;
    }
    Object localObject1 = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject1).getThread())
    {
      new Handler((Looper)localObject1).post(new DatalineRemoteManager.10(this));
      return;
    }
    while (!this.d.isEmpty())
    {
      Object localObject3 = (Bundle)this.d.remove(0);
      localObject1 = "";
      Object localObject2 = localObject1;
      if (localObject3 != null) {}
      try
      {
        localObject2 = ((Bundle)localObject3).getString("notify_cmd");
        localObject1 = localObject2;
        ((Bundle)localObject3).setClassLoader(getClass().getClassLoader());
        localObject1 = localObject2;
        this.b.b("com.qqdataline.action.notify", (Bundle)localObject3);
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = localObject2;
        localObject3 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append("doPostCachedMsg send success strNotifyCmd:");
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject1 = localObject2;
        QLog.d("DatalineRemoteManager", 2, ((StringBuilder)localObject3).toString());
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doPostCachedMsg send failed strNotifyCmd:");
        localStringBuilder.append((String)localObject1);
        QLog.d("DatalineRemoteManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void m()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "registerRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
      return;
    }
    if (!localPluginCommunicationHandler.containsCmd("dataline.remotecall")) {
      localPluginCommunicationHandler.register(new DatalineRemoteManager.11(this, "dataline.remotecall"));
    }
  }
  
  private void n()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "unregisterRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
      return;
    }
    if (localPluginCommunicationHandler.containsCmd("dataline.remotecall")) {
      localPluginCommunicationHandler.unregister("dataline.remotecall");
    }
  }
  
  private void o()
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new DatalineRemoteManager.12(this));
      return;
    }
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("string_from", true);
    ((Bundle)localObject).putBoolean("string_uin", false);
    ((Bundle)localObject).putLong("device_din", 0L);
    ((Bundle)localObject).putInt("sTitleID", 0);
    QQProxyForDataline.a(BaseActivity.sTopActivity, (Bundle)localObject, "com.qqdataline.activity.LiteWifiphotoActivity");
    BaseActivity.sTopActivity.overridePendingTransition(2130772014, 0);
  }
  
  public long a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "startConnectPC");
    localBundle.putInt("MPFPBtype", paramInt);
    localBundle = a(localBundle);
    if (localBundle == null) {
      return -1L;
    }
    return localBundle.getLong("result");
  }
  
  public long a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "addMpFileDownloadTask");
    localBundle.putLong("taskId", paramLong1);
    localBundle.putLong("din", paramLong2);
    localBundle.putString("fileId", paramString1);
    localBundle.putString("fileName", paramString2);
    localBundle.putLong("totalSize", paramLong3);
    paramString1 = a(localBundle);
    if (paramString1 == null) {
      return -1L;
    }
    return paramString1.getLong("result");
  }
  
  public long a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3, long paramLong4, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "addMpFileDownloadTaskWithBuildConn");
    localBundle.putLong("taskId", paramLong1);
    localBundle.putLong("din", paramLong2);
    localBundle.putString("fileId", paramString1);
    localBundle.putString("fileName", paramString2);
    localBundle.putLong("totalSize", paramLong3);
    localBundle.putLong("startPCSessionID", paramLong4);
    localBundle.putInt("PC_Version", paramInt);
    paramString1 = a(localBundle);
    if (paramString1 == null) {
      return -1L;
    }
    return paramString1.getLong("result");
  }
  
  public void a()
  {
    if (this.a.getMessageFacade() != null) {
      this.a.getMessageFacade().deleteObserver(this);
    }
    n();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "onReceiveRegisterProxySvcPack");
    localBundle.putInt("iPcOnlineStatus", paramInt1);
    localBundle.putInt("iIsSupportDataLine", paramInt2);
    localBundle.putInt("iIsSupportPrintable", paramInt3);
    localBundle.putInt("iIsSupportViewPCFile", paramInt4);
    localBundle.putLong("iPcVersion", paramLong);
    a(localBundle, false);
  }
  
  public void a(MpfileTaskInfo paramMpfileTaskInfo, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramMpfileTaskInfo, paramLong);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    if (FileManagerUtil.n(localFileManagerEntity.getFilePath())) {
      localForwardFileInfo.b(10000);
    } else {
      localForwardFileInfo.b(10009);
    }
    localForwardFileInfo.d(7);
    localForwardFileInfo.b(localFileManagerEntity.nSessionId);
    localForwardFileInfo.d(paramMpfileTaskInfo.k);
    localForwardFileInfo.c(paramMpfileTaskInfo.s);
    localForwardFileInfo.d(paramMpfileTaskInfo.q);
    localForwardFileInfo.a(paramMpfileTaskInfo.l);
    paramMpfileTaskInfo = Looper.getMainLooper();
    if (Thread.currentThread() != paramMpfileTaskInfo.getThread())
    {
      new Handler(paramMpfileTaskInfo).post(new DatalineRemoteManager.8(this, localFileManagerEntity, localForwardFileInfo));
      return;
    }
    paramMpfileTaskInfo = new Intent(this.a.getApplication().getApplicationContext(), FileBrowserActivity.class);
    paramMpfileTaskInfo.addFlags(268435456);
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
      paramMpfileTaskInfo.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
    }
    paramMpfileTaskInfo.putExtra("fileinfo", localForwardFileInfo);
    this.a.getApplication().getApplicationContext().startActivity(paramMpfileTaskInfo);
  }
  
  public void a(Entity paramEntity, ProxyListener paramProxyListener)
  {
    if ((paramEntity instanceof DataLineMsgRecord))
    {
      this.a.getDataLineMsgProxy(0).a(paramEntity, paramProxyListener);
      return;
    }
    if ((paramEntity instanceof MpfileTaskRecord)) {
      this.a.getProxyManager().d().a((MpfileTaskRecord)paramEntity);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "onReceive");
    if (paramToServiceMsg != null) {
      localBundle.putParcelable("ToServiceMsg", paramToServiceMsg);
    }
    if (paramFromServiceMsg != null) {
      localBundle.putParcelable("FromServiceMsg", paramFromServiceMsg);
    }
    if (paramArrayOfByte != null) {
      localBundle.putByteArray("data", paramArrayOfByte);
    }
    a(localBundle, true);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "cancelMpfile");
    localBundle.putString("strDataLineMPFileID", paramString);
    a(localBundle);
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    if (paramString1.equals(DataLineMsgRecord.tableName()))
    {
      this.a.getDataLineMsgProxy(0).a(paramString1, paramContentValues, paramString2, paramArrayOfString, paramProxyListener);
      return;
    }
    if (paramString1.equals(MpfileTaskRecord.tableName())) {
      this.a.getProxyManager().d().a(paramString1, paramContentValues, paramString2, paramArrayOfString, paramProxyListener);
    }
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    if (paramString1.equals(DataLineMsgRecord.tableName()))
    {
      this.a.getDataLineMsgProxy(0).a(paramString1, paramString2, paramArrayOfString, paramProxyListener);
      return;
    }
    if (paramString1.equals(MpfileTaskRecord.tableName())) {
      this.a.getProxyManager().d().a(paramString1, paramString2, paramArrayOfString, paramProxyListener);
    }
  }
  
  public void a(msg_comm.Msg paramMsg)
  {
    paramMsg = paramMsg.toByteArray();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "handleDataLinePushMsg_210");
    localBundle.putByteArray("msgBytes", paramMsg);
    a(localBundle, true);
  }
  
  public void a(msg_comm.Msg paramMsg, SubMsgType0x7.MsgBody paramMsgBody)
  {
    paramMsg = paramMsg.toByteArray();
    paramMsgBody = paramMsgBody.toByteArray();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "DoCCPush");
    localBundle.putByteArray("msgBytes", paramMsg);
    localBundle.putByteArray("ccBytes", paramMsgBody);
    a(localBundle, true);
  }
  
  public MpfileTaskInfo b(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileDownloadTask");
    localBundle.putString("fileId", paramString);
    paramString = a(localBundle);
    if (paramString == null) {
      return null;
    }
    return (MpfileTaskInfo)paramString.getParcelable("result");
  }
  
  public boolean b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getIsNeedReCreateConnection");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return true;
    }
    return localBundle.getBoolean("result");
  }
  
  public long c(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "setMpFileDownloadPwd");
    localBundle.putString("pwd", paramString);
    paramString = a(localBundle);
    if (paramString == null) {
      return -1L;
    }
    return paramString.getLong("result");
  }
  
  public ServerInfo c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileServerInfo");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return null;
    }
    ServerInfo localServerInfo = new ServerInfo();
    localServerInfo.a = localBundle.getString("ServerInfo.serverIp");
    localServerInfo.b = localBundle.getInt("ServerInfo.serverPort");
    return localServerInfo;
  }
  
  public String d()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileThumbSaveFolder");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return null;
    }
    return localBundle.getString("result");
  }
  
  public String e()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileSaveFolder");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return null;
    }
    return localBundle.getString("result");
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = this.a.getMessageFacade();
    if (paramObservable != null)
    {
      int i = paramObservable.w();
      paramObservable = new Bundle();
      paramObservable.putString("notify_cmd", "UpdateUnreadMsgsNum");
      paramObservable.putInt("unread", i);
      a(paramObservable, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager
 * JD-Core Version:    0.7.0.1
 */