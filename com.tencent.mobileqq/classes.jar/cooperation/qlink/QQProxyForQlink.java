package cooperation.qlink;

import alwx;
import alwy;
import alxa;
import alxb;
import alxc;
import alxd;
import alxe;
import alxf;
import alxg;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.widget.Toast;
import com.tencent.biz.qrcode.ipc.QrHandleResultCallBack;
import com.tencent.biz.viewplugin.ViewPluginContext;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class QQProxyForQlink
  implements QlAndQQInterface.QQ2Ql, QlAndQQInterface.Ql2QQ
{
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private QlAndQQInterface.WorkState jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);
  private Timer jdField_a_of_type_JavaUtilTimer;
  private int jdField_b_of_type_Int = -1;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  
  public QQProxyForQlink(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString, QrHandleResultCallBack paramQrHandleResultCallBack)
  {
    if (paramActivity == null) {
      return;
    }
    if (1 == paramInt) {
      paramString = "你当前正在使用面对面快传" + "发送文件给" + paramString + ",请稍候";
    }
    for (;;)
    {
      DialogUtil.b(paramActivity, 230, paramActivity.getString(2131431950), paramString, 2131431907, 2131431907, new alxg(this, paramQrHandleResultCallBack), null).show();
      return;
      if (2 == paramInt) {
        paramString = "你当前正在使用面对面快传" + "接收来着" + paramString + "的文件,请稍候";
      } else {
        paramString = "出错误啦";
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - startQlink failed context=null!");
      }
      Toast.makeText(BaseApplication.getContext(), "加载失败，请重试", 0).show();
      return;
    }
    Intent localIntent = new Intent(paramContext, QlinkBridgeActivity.class);
    localIntent.putExtra("_from_", paramInt);
    if (paramBundle != null) {
      localIntent.putExtra("_param_", paramBundle);
    }
    if ((paramContext instanceof ViewPluginContext)) {
      localIntent.setFlags(276824064);
    }
    if ((9 == paramInt) || (10 == paramInt)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 168	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 98
    //   16: iconst_1
    //   17: ldc 170
    //   19: invokestatic 172	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: new 174	java/util/Timer
    //   26: dup
    //   27: invokespecial 175	java/util/Timer:<init>	()V
    //   30: putfield 168	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   33: aload_0
    //   34: getfield 168	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   37: new 177	alxh
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 179	alxh:<init>	(Lcooperation/qlink/QQProxyForQlink;)V
    //   45: lconst_0
    //   46: ldc2_w 180
    //   49: invokevirtual 185	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   52: goto -41 -> 11
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	QQProxyForQlink
    //   6	2	1	localTimer	Timer
    //   55	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	55	finally
    //   14	52	55	finally
  }
  
  private void i()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ cancelQlinkHeartTimer");
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver == null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null)) {
        QLog.e("QQProxyForQlink", 1, "registerAccountReceiver error.");
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = new alwy(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() == null)) {
        QLog.e("QQProxyForQlink", 1, "unregisterAccountReceiver error.");
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
    this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 32	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: invokevirtual 197	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   16: ifnonnull +14 -> 30
    //   19: ldc 98
    //   21: iconst_1
    //   22: ldc 230
    //   24: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: getfield 232	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   34: ifnonnull -7 -> 27
    //   37: aload_0
    //   38: new 234	alwz
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 235	alwz:<init>	(Lcooperation/qlink/QQProxyForQlink;)V
    //   46: putfield 232	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   49: new 204	android/content/IntentFilter
    //   52: dup
    //   53: invokespecial 205	android/content/IntentFilter:<init>	()V
    //   56: astore_1
    //   57: aload_1
    //   58: ldc 237
    //   60: invokevirtual 211	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 32	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   67: invokevirtual 197	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   70: aload_0
    //   71: getfield 232	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   74: aload_1
    //   75: invokevirtual 221	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   78: pop
    //   79: goto -52 -> 27
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	QQProxyForQlink
    //   56	19	1	localIntentFilter	IntentFilter
    //   82	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	82	finally
    //   19	27	82	finally
    //   30	79	82	finally
  }
  
  /* Error */
  private void m()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 232	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   6: ifnull +28 -> 34
    //   9: aload_0
    //   10: getfield 32	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 32	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: invokevirtual 197	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: ifnonnull +14 -> 37
    //   26: ldc 98
    //   28: iconst_1
    //   29: ldc 240
    //   31: invokestatic 104	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield 32	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   41: invokevirtual 197	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   44: aload_0
    //   45: getfield 232	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   48: invokevirtual 228	com/tencent/qphone/base/util/BaseApplication:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 232	cooperation/qlink/QQProxyForQlink:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   56: goto -22 -> 34
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	QQProxyForQlink
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	59	finally
    //   26	34	59	finally
    //   37	56	59	finally
  }
  
  public int a()
  {
    return this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount;
  }
  
  public QlAndQQInterface.WorkState a()
  {
    return this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState;
  }
  
  public void a()
  {
    QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ UI_LOG:QQProxyForQlink. onAppInit");
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null)) {
      ThreadManager.executeOnSubThread(new alwx(this));
    }
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount = paramInt;
    if (i != this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("QQProxyForQlink", 4, "[QLINK]-QQ UI_LOG:notifyGoingonTransChanged.count:" + paramInt);
      }
      MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(1134025, null).sendToTarget();
      }
    }
  }
  
  public void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {}
    label403:
    for (;;)
    {
      return;
      String str2 = ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin);
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin.equalsIgnoreCase(str2)) {}
      }
      else
      {
        if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick == null) {
          break label224;
        }
        str1 = this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick;
      }
      if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode == 1)
      {
        a("0X8004854", 1);
        paramOnClickListener3 = paramActivity.getResources().getString(2131431996) + str1 + paramActivity.getResources().getString(2131431997);
        if ((paramString != null) && (!paramString.equalsIgnoreCase(this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin)))
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramActivity, 230, paramActivity.getResources().getString(2131431949), paramOnClickListener3, paramActivity.getResources().getString(2131431998), paramActivity.getResources().getString(2131431998), paramOnClickListener2, null);
          label194:
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
          break label403;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new alxd(this));
        return;
        label224:
        str1 = this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin;
        break;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramActivity, 230, paramActivity.getResources().getString(2131431949), paramOnClickListener3, paramActivity.getResources().getString(2131431998), paramActivity.getResources().getString(2131431999), paramOnClickListener1, paramOnClickListener2);
        break label194;
        if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode == 2)
        {
          a("0X8004856", 1);
          paramOnClickListener1 = str1 + paramActivity.getResources().getString(2131432000);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramActivity, 230, paramActivity.getResources().getString(2131431949), paramOnClickListener1, paramActivity.getResources().getString(2131432001), paramActivity.getResources().getString(2131432001), paramOnClickListener3, null);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - working but op err");
        }
      }
    }
  }
  
  public void a(Activity paramActivity, ArrayList paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramActivity == null) {}
    label166:
    do
    {
      return;
      switch (paramInt2)
      {
      }
      for (;;)
      {
        if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mWorking) {
          break label166;
        }
        Object localObject = null;
        paramString = localObject;
        if (paramArrayList != null)
        {
          paramString = localObject;
          if (paramArrayList.size() > 0)
          {
            paramString = new Bundle();
            paramString.putStringArrayList("string_filepaths", paramArrayList);
          }
        }
        a(paramActivity, paramInt1, paramString);
        if (!paramBoolean) {
          break;
        }
        paramActivity.finish();
        return;
        a("0X800484F", 1);
        continue;
        a("0X800485B", 1);
        continue;
        a("0X800485E", 1);
        continue;
        a("0X8004858", 1);
        continue;
        a("0X800566F", 1);
      }
      if ((15 != paramInt1) || ((paramArrayList != null) && (paramArrayList.size() != 0))) {
        break;
      }
      a(paramActivity, paramInt1, new Bundle());
    } while (!paramBoolean);
    paramActivity.finish();
    return;
    a(paramActivity, new alxa(this, paramArrayList, paramActivity, paramInt1, paramBoolean), new alxb(this), new alxc(this), paramString);
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = (QlAndQQInterface.WorkState)paramBundle.getSerializable("wstate");
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mForIphone = paramBundle.mForIphone;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode = paramBundle.mMode;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick = paramBundle.mPeerNick;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin = paramBundle.mPeerUin;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mState = paramBundle.mState;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount = paramBundle.mTransferingCount;
    this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mWorking = paramBundle.mWorking;
  }
  
  public void a(QlAndQQInterface.DailogClickInfo paramDailogClickInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.a, paramDailogClickInfo);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("cmd.senddailogclickinfo", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ sendDailogClick:" + i);
    }
  }
  
  public void a(QlAndQQInterface.InsertFMFileInfo paramInsertFMFileInfo)
  {
    if (paramInsertFMFileInfo == null) {
      return;
    }
    String str = FileManagerUtil.a(paramInsertFMFileInfo.filePath);
    long l1 = FileManagerUtil.a(paramInsertFMFileInfo.filePath);
    long l2 = MessageRecordFactory.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(l2, paramInsertFMFileInfo.uin, 0);
    localFileManagerEntity.setCloudType(5);
    localFileManagerEntity.nSessionId = paramInsertFMFileInfo.sessionId;
    localFileManagerEntity.setFilePath(paramInsertFMFileInfo.filePath);
    localFileManagerEntity.nFileType = FileManagerUtil.a(paramInsertFMFileInfo.filePath);
    localFileManagerEntity.strThumbPath = paramInsertFMFileInfo.thumbPath;
    localFileManagerEntity.fileName = str;
    localFileManagerEntity.fileSize = l1;
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.msgSeq = FileManagerUtil.a();
    localFileManagerEntity.msgUid = FileManagerUtil.b();
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = paramInsertFMFileInfo.uin;
    localFileManagerEntity.nOlSenderProgress = paramInsertFMFileInfo.transSeq;
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (localFriendsManager.c(String.valueOf(localFileManagerEntity.peerUin)) != null)
    {
      localFileManagerEntity.peerType = 0;
      localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInsertFMFileInfo.uin, null, 0);
      localFileManagerEntity.status = 1;
      if ((!localFriendsManager.b(paramInsertFMFileInfo.uin)) && (!paramInsertFMFileInfo.bSend)) {
        break label356;
      }
      localFileManagerEntity.nOpType = 0;
      localFileManagerEntity.bSend = true;
      TransfileUtile.a(paramInsertFMFileInfo.filePath, 0L, 0, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
      QLog.d("QQProxyForQlink", 4, "insertFM sessionid:" + paramInsertFMFileInfo.sessionId + " transeq:" + localFileManagerEntity.nOlSenderProgress + " filePath:" + paramInsertFMFileInfo.filePath);
      return;
      localFileManagerEntity.peerType = 1003;
      break;
      label356:
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.bSend = false;
      TransfileUtile.a(paramInsertFMFileInfo.filePath, l1, 0, false, null);
      BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), str, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
    }
  }
  
  public void a(QlAndQQInterface.UserInfo paramUserInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.a, paramUserInfo);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("cmd.senduserinfo", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ sendUserInfo:" + i);
    }
  }
  
  public void a(String paramString)
  {
    String str = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    QlAndQQInterface.UserInfo localUserInfo = new QlAndQQInterface.UserInfo();
    localUserInfo.uin = paramString;
    if (str != null) {}
    for (localUserInfo.nick = str;; localUserInfo.nick = paramString)
    {
      paramString = localFriendsManager.c(paramString);
      localUserInfo.isFriend = false;
      if (paramString != null) {
        localUserInfo.isFriend = paramString.isFriend();
      }
      a(localUserInfo);
      return;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "QLINK_CLICK_EVENT: act=" + paramString + " count:" + paramInt);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, 0, paramInt, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap paramHashMap)
  {
    if (QLog.isDevelopLevel())
    {
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (paramHashMap != null)
      {
        localObject1 = localObject2;
        if (paramHashMap.size() > 0)
        {
          localObject2 = paramHashMap.entrySet().iterator();
          Map.Entry localEntry;
          for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + " " + (String)localEntry.getKey() + ":" + (String)localEntry.getValue()) {
            localEntry = (Map.Entry)((Iterator)localObject2).next();
          }
        }
      }
      QLog.d("QQProxyForQlink", 4, "QLINK_PERFORMANCE: tagName=" + paramString2 + " uin:" + paramString1 + " success:" + paramBoolean + (String)localObject1);
    }
    QlinkReliableReport.a(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap);
  }
  
  public void a(AppActivity paramAppActivity, QrHandleResultCallBack paramQrHandleResultCallBack)
  {
    if (paramAppActivity == null) {
      return;
    }
    DialogUtil.b(paramAppActivity, 230, paramAppActivity.getString(2131432022), paramAppActivity.getString(2131431954), 2131431907, 2131431907, new alxf(this, paramQrHandleResultCallBack), null).show();
  }
  
  public void a(AppActivity paramAppActivity, String paramString, QrHandleResultCallBack paramQrHandleResultCallBack)
  {
    if ((paramAppActivity == null) || (paramString == null)) {
      return;
    }
    QlinkHelper.QRScanInfo localQRScanInfo = QlinkHelper.a(paramString);
    if (localQRScanInfo == null)
    {
      DialogUtil.b(paramAppActivity, 230, paramAppActivity.getString(2131431950), paramAppActivity.getString(2131431955), 2131431907, 2131431907, new alxe(this, paramQrHandleResultCallBack), null).show();
      return;
    }
    if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mWorking)
    {
      a(paramAppActivity, this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode, this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick, paramQrHandleResultCallBack);
      return;
    }
    boolean bool = "qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from"));
    if (bool) {
      c(1);
    }
    paramQrHandleResultCallBack = new Bundle();
    paramQrHandleResultCallBack.putString("url", paramString);
    paramQrHandleResultCallBack.putString("key", localQRScanInfo.a);
    paramQrHandleResultCallBack.putString("peerUin", localQRScanInfo.b);
    paramQrHandleResultCallBack.putString("peerNick", localQRScanInfo.c);
    paramQrHandleResultCallBack.putString("peerOS", localQRScanInfo.d);
    paramQrHandleResultCallBack.putString("apSSID", localQRScanInfo.e);
    paramQrHandleResultCallBack.putBoolean("fromqlink", bool);
    paramString = paramAppActivity.getIntent().getStringExtra("subfrom");
    if (paramString != null) {
      paramQrHandleResultCallBack.putString("subfrom", paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    a(paramAppActivity, 11, paramQrHandleResultCallBack);
    paramAppActivity.finish();
  }
  
  public boolean a(QlAndQQInterface.SendFileInfos paramSendFileInfos)
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("0X8004763", 1);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.a, paramSendFileInfos);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("cmd.sendfilemsgs", localBundle);
    if (QLog.isDevelopLevel()) {
      QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ QQ2QlSendFileMsgs:" + i);
    }
    if (i == -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(String paramString, List paramList)
  {
    if ((paramList == null) || (paramString == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. param error");
      }
    }
    do
    {
      return false;
      if (paramList.size() > 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. no any file");
    return false;
    QlAndQQInterface.SendFileInfos localSendFileInfos = new QlAndQQInterface.SendFileInfos();
    localSendFileInfos.strUin = paramString;
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      QlAndQQInterface.SendFileInfo localSendFileInfo = new QlAndQQInterface.SendFileInfo();
      localSendFileInfo.sessionid = FileManagerUtil.a().longValue();
      localSendFileInfo.filePath = paramList;
      localSendFileInfo.fileSize = FileManagerUtil.a(paramList);
      localSendFileInfos.infos.add(localSendFileInfo);
    }
    return a(localSendFileInfos);
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (1 == paramInt) {
      FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("qlinkexit", false))
      {
        QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ qlink is exit:");
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);
        i();
        return;
      }
      paramBundle = (QlAndQQInterface.WorkState)paramBundle.getSerializable("wstate");
      if (paramBundle != null)
      {
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mForIphone = paramBundle.mForIphone;
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode = paramBundle.mMode;
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick = paramBundle.mPeerNick;
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin = paramBundle.mPeerUin;
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mState = paramBundle.mState;
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount = paramBundle.mTransferingCount;
        this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mWorking = paramBundle.mWorking;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 0;
      return;
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ respHeart. no wstate error");
      continue;
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ respHeart. info = null");
    }
  }
  
  public void c()
  {
    QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ UI_LOG:QQProxyForQlink. onAppDestroy");
    k();
    m();
    i();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void c(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("cmd", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("cmd.sendsimplecmd", localBundle);
  }
  
  public void c(Bundle paramBundle)
  {
    int i = paramBundle.getInt("Event", 0);
    switch (i)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - unimplement event[" + i + "]");
      }
    case 18: 
    case 19: 
      do
      {
        return;
        a(paramBundle.getString("action_name"), paramBundle.getInt(QlAndQQInterface.a));
        return;
        paramBundle = (QlAndQQInterface.ReportInfo)paramBundle.getSerializable(QlAndQQInterface.a);
      } while (!(paramBundle.data instanceof QlAndQQInterface.ReportPerformanceInfo));
      paramBundle = (QlAndQQInterface.ReportPerformanceInfo)paramBundle.data;
      a(paramBundle.mUin, paramBundle.mTagName, paramBundle.mSuccess, paramBundle.mDuration, paramBundle.mSize, paramBundle.mParams);
      return;
    case 20: 
      QlinkReliableReport.a();
      return;
    case 21: 
      QlinkReliableReport.b();
      return;
    case 15: 
      a((QlAndQQInterface.InsertFMFileInfo)paramBundle.getSerializable(QlAndQQInterface.a));
      return;
    case 16: 
      a(paramBundle.getInt(QlAndQQInterface.a));
      return;
    case 17: 
      a(paramBundle.getString(QlAndQQInterface.a));
      return;
    case 22: 
      d();
      return;
    case 23: 
      a(paramBundle.getBundle(QlAndQQInterface.a));
      return;
    case 24: 
      b(paramBundle.getBundle(QlAndQQInterface.a));
      return;
    }
    b(paramBundle.getInt(QlAndQQInterface.a));
  }
  
  public void d()
  {
    QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ nofityQlinkStart");
    h();
  }
  
  public void e()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("param", 1);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a("cmd.sendheart", localBundle);
    }
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink
 * JD-Core Version:    0.7.0.1
 */