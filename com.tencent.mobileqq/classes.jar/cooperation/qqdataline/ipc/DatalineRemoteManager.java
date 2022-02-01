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
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new DatalineRemoteManager.7(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  IDatalineService jdField_a_of_type_CooperationQqdatalineIpcIDatalineService;
  ArrayList<Bundle> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public DatalineRemoteManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
    i();
  }
  
  private Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    String str = paramBundle.getString("notify_cmd");
    if (this.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService == null)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("mDatalineService not started strNotifyCmd:");
        paramBundle.append(str);
        QLog.d("DatalineRemoteManager", 2, paramBundle.toString());
      }
      b();
      return null;
    }
    h();
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
      paramBundle = this.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService.a("com.qqdataline.action.notify", paramBundle);
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
  
  private void a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle = paramBundle.getString("notify_cmd");
    } else {
      paramBundle = "";
    }
    Bundle localBundle;
    if (paramBundle.equals("onReceiveRegisterProxySvcPack"))
    {
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!paramBundle.hasNext()) {
          break;
        }
        localBundle = (Bundle)paramBundle.next();
      } while (!localBundle.getString("notify_cmd").equals("onReceiveRegisterProxySvcPack"));
      this.jdField_a_of_type_JavaUtilArrayList.remove(localBundle);
      return;
    }
    if (paramBundle.equals("UpdateUnreadMsgsNum"))
    {
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramBundle.hasNext())
      {
        localBundle = (Bundle)paramBundle.next();
        if (localBundle.getString("notify_cmd").equals("UpdateUnreadMsgsNum")) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localBundle);
        }
      }
    }
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
    if (this.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService == null)
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
        b();
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
      a(paramBundle);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
      return;
    }
    h();
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
      this.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService.a("com.qqdataline.action.notify", paramBundle);
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
  
  private boolean a(int paramInt)
  {
    if (paramInt == 2)
    {
      DatalineHelper.a("0X800672B");
    }
    else if (paramInt == 1)
    {
      DatalineHelper.a("0X800672C");
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject);
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
  
  private Bundle b(Bundle paramBundle)
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
      paramBundle.putParcelable("ToServiceMsg", ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(l1, (String)localObject1, i, j, k, (byte[])localObject2, l2));
      return paramBundle;
    }
    if (((String)localObject1).equals("BusinessHandler_sendPbReq"))
    {
      ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).sendPbReq((ToServiceMsg)paramBundle.getParcelable("ToServiceMsg"));
      return null;
    }
    boolean bool = ((String)localObject1).equals("DataLineMsgProxy_getInitMpfileTaskRecordList");
    int i = 0;
    if (bool)
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
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
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
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
          l1 = RouterHandler.a();
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
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(-1L, (String)localObject2, 6000);
          localFileManagerEntity.nOpType = i;
          localFileManagerEntity.fileSize = FileManagerUtil.a((String)localObject1);
          localFileManagerEntity.isReaded = true;
          localFileManagerEntity.peerUin = ((String)localObject2);
          if (l1 == 0L) {
            localFileManagerEntity.peerNick = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694380);
          } else {
            localFileManagerEntity.peerNick = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694382);
          }
          localFileManagerEntity.setFilePath((String)localObject1);
          localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
          localFileManagerEntity.fileName = paramBundle;
          localFileManagerEntity.setCloudType(3);
          localFileManagerEntity.bSend = false;
          localFileManagerEntity.status = 1;
          localFileManagerEntity.fProgress = 1.0F;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
          return null;
        }
        if (((String)localObject1).equals("DatalineHandler_showWifiphotoActivity"))
        {
          k();
          return null;
        }
        if (((String)localObject1).equals("BusinessHandler_makeSureProxyServiceStart"))
        {
          b();
          return null;
        }
        if (((String)localObject1).equals("DatalineHandler_showWifiphotoAuthDlg"))
        {
          c();
          return null;
        }
        if (((String)localObject1).equals("DatalineHandler_dismissReqAuthDlg"))
        {
          e();
          return null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "OnRemoteInvoke unknow invokeCmd");
        }
      }
    }
    return null;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService == null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "mDatalineService start service");
      }
      DatalineProxyService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentServiceConnection);
    }
  }
  
  private void c()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DatalineRemoteManager.1(this));
      return;
    }
    d();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      return;
    }
    if (!BaseActivity.mAppForground)
    {
      a(3);
      return;
    }
    if (BaseActivity.sTopActivity == null)
    {
      a(3);
      return;
    }
    if (!CheckPermission.isHasStoragePermission(BaseActivity.sTopActivity))
    {
      CheckPermission.requestSDCardPermission(BaseActivity.sTopActivity, new DatalineRemoteManager.2(this));
      return;
    }
    f();
  }
  
  private void e()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DatalineRemoteManager.3(this));
      return;
    }
    g();
  }
  
  private void f()
  {
    a(0);
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(BaseActivity.sTopActivity, 230, HardCodeUtil.a(2131702931), HardCodeUtil.a(2131702935), 2131694460, 2131720490, new DatalineRemoteManager.4(this), new DatalineRemoteManager.5(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new DatalineRemoteManager.6(this));
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131365644);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setMinHeight(DisplayUtil.a(BaseActivity.sTopActivity, 35.0F));
    localTextView.setGravity(17);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void g()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    Object localObject1 = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject1).getThread())
    {
      new Handler((Looper)localObject1).post(new DatalineRemoteManager.10(this));
      return;
    }
    while (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      Object localObject3 = (Bundle)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      localObject1 = "";
      Object localObject2 = localObject1;
      if (localObject3 != null) {}
      try
      {
        localObject2 = ((Bundle)localObject3).getString("notify_cmd");
        localObject1 = localObject2;
        ((Bundle)localObject3).setClassLoader(getClass().getClassLoader());
        localObject1 = localObject2;
        this.jdField_a_of_type_CooperationQqdatalineIpcIDatalineService.a("com.qqdataline.action.notify", (Bundle)localObject3);
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
  
  private void i()
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
  
  private void j()
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
  
  private void k()
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
    BaseActivity.sTopActivity.overridePendingTransition(2130772011, 0);
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
  
  public long a(String paramString)
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
  
  public MpfileTaskInfo a(String paramString)
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
  
  public ServerInfo a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileServerInfo");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return null;
    }
    ServerInfo localServerInfo = new ServerInfo();
    localServerInfo.jdField_a_of_type_JavaLangString = localBundle.getString("ServerInfo.serverIp");
    localServerInfo.jdField_a_of_type_Int = localBundle.getInt("ServerInfo.serverPort");
    return localServerInfo;
  }
  
  public String a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileThumbSaveFolder");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return null;
    }
    return localBundle.getString("result");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    }
    j();
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
    if (FileManagerUtil.a(localFileManagerEntity.getFilePath())) {
      localForwardFileInfo.b(10000);
    } else {
      localForwardFileInfo.b(10009);
    }
    localForwardFileInfo.d(7);
    localForwardFileInfo.b(localFileManagerEntity.nSessionId);
    localForwardFileInfo.d(paramMpfileTaskInfo.jdField_d_of_type_JavaLangString);
    localForwardFileInfo.c(paramMpfileTaskInfo.jdField_d_of_type_Long);
    localForwardFileInfo.d(paramMpfileTaskInfo.b);
    localForwardFileInfo.a(paramMpfileTaskInfo.e);
    paramMpfileTaskInfo = Looper.getMainLooper();
    if (Thread.currentThread() != paramMpfileTaskInfo.getThread())
    {
      new Handler(paramMpfileTaskInfo).post(new DatalineRemoteManager.8(this, localFileManagerEntity, localForwardFileInfo));
      return;
    }
    paramMpfileTaskInfo = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), FileBrowserActivity.class);
    paramMpfileTaskInfo.addFlags(268435456);
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
      paramMpfileTaskInfo.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
    }
    paramMpfileTaskInfo.putExtra("fileinfo", localForwardFileInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().startActivity(paramMpfileTaskInfo);
  }
  
  public void a(Entity paramEntity, ProxyListener paramProxyListener)
  {
    if ((paramEntity instanceof DataLineMsgRecord))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0).a(paramEntity, paramProxyListener);
      return;
    }
    if ((paramEntity instanceof MpfileTaskRecord)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a((MpfileTaskRecord)paramEntity);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0).a(paramString1, paramContentValues, paramString2, paramArrayOfString, paramProxyListener);
      return;
    }
    if (paramString1.equals(MpfileTaskRecord.tableName())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramString1, paramContentValues, paramString2, paramArrayOfString, paramProxyListener);
    }
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    if (paramString1.equals(DataLineMsgRecord.tableName()))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDataLineMsgProxy(0).a(paramString1, paramString2, paramArrayOfString, paramProxyListener);
      return;
    }
    if (paramString1.equals(MpfileTaskRecord.tableName())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramString1, paramString2, paramArrayOfString, paramProxyListener);
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
  
  public boolean a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getIsNeedReCreateConnection");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return true;
    }
    return localBundle.getBoolean("result");
  }
  
  public String b()
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
    paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (paramObservable != null)
    {
      int i = paramObservable.b();
      paramObservable = new Bundle();
      paramObservable.putString("notify_cmd", "UpdateUnreadMsgsNum");
      paramObservable.putInt("unread", i);
      a(paramObservable, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager
 * JD-Core Version:    0.7.0.1
 */