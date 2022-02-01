package cooperation.qlink;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.biz.viewplugin.ViewPluginContext;
import com.tencent.mobileqq.activity.recent.bannerprocessor.QLinkTransingBannerProcessor;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.TransFileUtil;
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

public class QQProxyForQlink
  implements QlAndQQInterface.QQ2Ql, QlAndQQInterface.Ql2QQ
{
  private int jdField_a_of_type_Int = 0;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private QlAndQQInterface.WorkState jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);
  private Timer jdField_a_of_type_JavaUtilTimer;
  private int jdField_b_of_type_Int = -1;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = null;
  
  public QQProxyForQlink(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    if (paramActivity == null) {
      return;
    }
    String str = HardCodeUtil.a(2131710651);
    StringBuilder localStringBuilder;
    if (1 == paramInt)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(HardCodeUtil.a(2131710654));
      localStringBuilder.append(paramString);
      localStringBuilder.append(HardCodeUtil.a(2131710649));
      paramString = localStringBuilder.toString();
    }
    for (;;)
    {
      break;
      if (2 == paramInt)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(HardCodeUtil.a(2131710653));
        localStringBuilder.append(paramString);
        localStringBuilder.append(HardCodeUtil.a(2131710648));
        paramString = localStringBuilder.toString();
      }
      else
      {
        paramString = HardCodeUtil.a(2131710650);
      }
    }
    DialogUtil.a(paramActivity, 230, paramActivity.getString(2131698398), paramString, 2131698392, 2131698392, new QQProxyForQlink.8(this, paramOnQRHandleResultCallback), null).show();
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - startQlink failed context=null!");
      }
      Toast.makeText(BaseApplication.getContext(), HardCodeUtil.a(2131710652), 0).show();
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
  
  private void h()
  {
    try
    {
      Timer localTimer = this.jdField_a_of_type_JavaUtilTimer;
      if (localTimer != null) {
        return;
      }
      QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ setQlinkHeartTimer");
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new QQProxyForQlink.9(this), 0L, 5000L);
      return;
    }
    finally {}
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
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new QQProxyForQlink.10(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null) {
        localObject = ((QQAppInterface)localObject).getApp();
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        ((BaseApplication)localObject).registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        return;
      }
      QLog.e("QQProxyForQlink", 1, "registerAccountReceiver error. fail");
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if ((localQQAppInterface != null) && (localQQAppInterface.getApp() != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
        this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
        return;
      }
      QLog.e("QQProxyForQlink", 1, "unregisterAccountReceiver error.");
    }
  }
  
  private void l()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
        {
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = new QQProxyForQlink.11(this);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("com.tencent.qlink.finishworkingdlg");
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label91;
          }
          BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
          if (localBaseApplication != null)
          {
            localBaseApplication.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
          }
          else
          {
            QLog.e("QQProxyForQlink", 1, "registerFinishWorkingDlgReceiver error.fail");
            this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
          }
        }
        return;
      }
      finally {}
      label91:
      Object localObject2 = null;
    }
  }
  
  private void m()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp() != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
        }
        else
        {
          QLog.e("QQProxyForQlink", 1, "unregisterFinishWorkingDlgReceiver error.");
          return;
        }
      }
      return;
    }
    finally {}
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
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localQQAppInterface != null) && (localQQAppInterface.getApp() != null)) {
      ThreadManager.executeOnSubThread(new QQProxyForQlink.1(this));
    }
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mTransferingCount;
    Object localObject = this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState;
    ((QlAndQQInterface.WorkState)localObject).mTransferingCount = paramInt;
    if (i != ((QlAndQQInterface.WorkState)localObject).mTransferingCount)
    {
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[QLINK]-QQ UI_LOG:notifyGoingonTransChanged.count:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.i("QQProxyForQlink", 4, ((StringBuilder)localObject).toString());
      }
      localObject = BannerManager.a();
      i = QLinkTransingBannerProcessor.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQProxyForQlink().a() != 0) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
      ((BannerManager)localObject).a(i, paramInt, null);
    }
  }
  
  public void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      return;
    }
    String str2 = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin.equalsIgnoreCase(str2)) {}
    }
    else if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick != null)
    {
      str1 = this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick;
    }
    else
    {
      str1 = this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin;
    }
    if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode == 1)
    {
      a("0X8004854", 1);
      paramOnClickListener3 = new StringBuilder();
      paramOnClickListener3.append(paramActivity.getResources().getString(2131698438));
      paramOnClickListener3.append(str1);
      paramOnClickListener3.append(paramActivity.getResources().getString(2131698439));
      paramOnClickListener3 = paramOnClickListener3.toString();
      if ((paramString != null) && (!paramString.equalsIgnoreCase(this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerUin))) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramActivity, 230, paramActivity.getResources().getString(2131698399), paramOnClickListener3, paramActivity.getResources().getString(2131698440), paramActivity.getResources().getString(2131698440), paramOnClickListener2, null);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramActivity, 230, paramActivity.getResources().getString(2131698399), paramOnClickListener3, paramActivity.getResources().getString(2131698440), paramActivity.getResources().getString(2131698441), paramOnClickListener1, paramOnClickListener2);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
    else if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode == 2)
    {
      a("0X8004856", 1);
      paramOnClickListener1 = new StringBuilder();
      paramOnClickListener1.append(str1);
      paramOnClickListener1.append(paramActivity.getResources().getString(2131698437));
      paramOnClickListener1 = paramOnClickListener1.toString();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramActivity, 230, paramActivity.getResources().getString(2131698399), paramOnClickListener1, paramActivity.getResources().getString(2131698436), paramActivity.getResources().getString(2131698436), paramOnClickListener3, null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - working but op err");
    }
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (paramActivity != null) {
      paramActivity.setOnDismissListener(new QQProxyForQlink.5(this));
    }
  }
  
  public void a(Activity paramActivity, ArrayList<String> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramActivity == null) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      break;
    case 5: 
    case 6: 
      a("0X800566F", 1);
      break;
    case 4: 
      a("0X8004858", 1);
      break;
    case 3: 
      a("0X800485E", 1);
      break;
    case 2: 
      a("0X800485B", 1);
      break;
    case 1: 
      a("0X800484F", 1);
    }
    if (!this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mWorking)
    {
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
      if (paramBoolean) {
        paramActivity.finish();
      }
    }
    else
    {
      if ((15 == paramInt1) && ((paramArrayList == null) || (paramArrayList.size() == 0)))
      {
        a(paramActivity, paramInt1, new Bundle());
        if (paramBoolean) {
          paramActivity.finish();
        }
        return;
      }
      a(paramActivity, new QQProxyForQlink.2(this, paramArrayList, paramActivity, paramInt1, paramBoolean), new QQProxyForQlink.3(this), new QQProxyForQlink.4(this), paramString);
    }
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
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr().a("cmd.senddailogclickinfo", localBundle);
    if (QLog.isDevelopLevel())
    {
      paramDailogClickInfo = new StringBuilder();
      paramDailogClickInfo.append("[QLINK]-QQ sendDailogClick:");
      paramDailogClickInfo.append(i);
      QLog.d("QQProxyForQlink", 4, paramDailogClickInfo.toString());
    }
  }
  
  public void a(QlAndQQInterface.InsertFMFileInfo paramInsertFMFileInfo)
  {
    if (paramInsertFMFileInfo == null) {
      return;
    }
    Object localObject = FileManagerUtil.a(paramInsertFMFileInfo.filePath);
    long l1 = FileManagerUtil.a(paramInsertFMFileInfo.filePath);
    long l2 = MessageRecordFactory.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(l2, paramInsertFMFileInfo.uin, 0);
    localFileManagerEntity.setCloudType(5);
    localFileManagerEntity.nSessionId = paramInsertFMFileInfo.sessionId;
    localFileManagerEntity.setFilePath(paramInsertFMFileInfo.filePath);
    localFileManagerEntity.nFileType = FileManagerUtil.a(paramInsertFMFileInfo.filePath);
    localFileManagerEntity.strThumbPath = paramInsertFMFileInfo.thumbPath;
    localFileManagerEntity.fileName = ((String)localObject);
    localFileManagerEntity.fileSize = l1;
    localFileManagerEntity.srvTime = (MessageCache.a() * 1000L);
    localFileManagerEntity.msgSeq = FileManagerUtil.a();
    localFileManagerEntity.msgUid = FileManagerUtil.b();
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = paramInsertFMFileInfo.uin;
    localFileManagerEntity.nOlSenderProgress = paramInsertFMFileInfo.transSeq;
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager.e(String.valueOf(localFileManagerEntity.peerUin)) != null) {
      localFileManagerEntity.peerType = 0;
    } else {
      localFileManagerEntity.peerType = 1003;
    }
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInsertFMFileInfo.uin, null, 0);
    localFileManagerEntity.status = 1;
    localFriendsManager.b(paramInsertFMFileInfo.uin);
    if (paramInsertFMFileInfo.bSend)
    {
      localFileManagerEntity.nOpType = 0;
      localFileManagerEntity.bSend = true;
      TransfileUtile.makeTransFileProtocolData(paramInsertFMFileInfo.filePath, 0L, 0, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
    }
    else
    {
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.bSend = false;
      TransfileUtile.makeTransFileProtocolData(paramInsertFMFileInfo.filePath, l1, 0, false, null);
      TransFileUtil.getTransferFilePath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (String)localObject, 0, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("insertFM sessionid:");
    ((StringBuilder)localObject).append(paramInsertFMFileInfo.sessionId);
    ((StringBuilder)localObject).append(" transeq:");
    ((StringBuilder)localObject).append(localFileManagerEntity.nOlSenderProgress);
    ((StringBuilder)localObject).append(" filePath:");
    ((StringBuilder)localObject).append(paramInsertFMFileInfo.filePath);
    QLog.d("QQProxyForQlink", 4, ((StringBuilder)localObject).toString());
  }
  
  public void a(QlAndQQInterface.UserInfo paramUserInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.a, paramUserInfo);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr().a("cmd.senduserinfo", localBundle);
    if (QLog.isDevelopLevel())
    {
      paramUserInfo = new StringBuilder();
      paramUserInfo.append("[QLINK]-QQ sendUserInfo:");
      paramUserInfo.append(i);
      QLog.d("QQProxyForQlink", 4, paramUserInfo.toString());
    }
  }
  
  public void a(String paramString)
  {
    String str = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    QlAndQQInterface.UserInfo localUserInfo = new QlAndQQInterface.UserInfo();
    localUserInfo.uin = paramString;
    if (str != null) {
      localUserInfo.nick = str;
    } else {
      localUserInfo.nick = paramString;
    }
    paramString = localFriendsManager.e(paramString);
    localUserInfo.isFriend = false;
    if (paramString != null) {
      localUserInfo.isFriend = paramString.isFriend();
    }
    a(localUserInfo);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QLINK_CLICK_EVENT: act=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" count:");
      localStringBuilder.append(paramInt);
      QLog.d("QQProxyForQlink", 4, localStringBuilder.toString());
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", paramString, paramString, 0, paramInt, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap)
  {
    if (QLog.isDevelopLevel())
    {
      Object localObject1 = "";
      Object localObject2 = localObject1;
      if (paramHashMap != null)
      {
        localObject2 = localObject1;
        if (paramHashMap.size() > 0)
        {
          Iterator localIterator = paramHashMap.entrySet().iterator();
          for (;;)
          {
            localObject2 = localObject1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (Map.Entry)localIterator.next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(" ");
            localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
            localStringBuilder.append(":");
            localStringBuilder.append((String)((Map.Entry)localObject2).getValue());
            localObject1 = localStringBuilder.toString();
          }
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QLINK_PERFORMANCE: tagName=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" uin:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" success:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("QQProxyForQlink", 4, ((StringBuilder)localObject1).toString());
    }
    QlinkReliableReport.a(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap);
  }
  
  public void a(AppActivity paramAppActivity, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    if (paramAppActivity == null) {
      return;
    }
    DialogUtil.a(paramAppActivity, 230, paramAppActivity.getString(2131698416), paramAppActivity.getString(2131698417), 2131698392, 2131698392, new QQProxyForQlink.7(this, paramOnQRHandleResultCallback), null).show();
  }
  
  public void a(AppActivity paramAppActivity, String paramString, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    if (paramAppActivity != null)
    {
      if (paramString == null) {
        return;
      }
      QlinkHelper.QRScanInfo localQRScanInfo = QlinkHelper.a(paramString);
      if (localQRScanInfo == null)
      {
        DialogUtil.a(paramAppActivity, 230, paramAppActivity.getString(2131698398), paramAppActivity.getString(2131698418), 2131698392, 2131698392, new QQProxyForQlink.6(this, paramOnQRHandleResultCallback), null).show();
        return;
      }
      if (this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mWorking)
      {
        a(paramAppActivity, this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mMode, this.jdField_a_of_type_CooperationQlinkQlAndQQInterface$WorkState.mPeerNick, paramOnQRHandleResultCallback);
        return;
      }
      boolean bool = "qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from"));
      if (bool) {
        c(1);
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("url", paramString);
      localBundle.putString("key", localQRScanInfo.a);
      localBundle.putString("peerUin", localQRScanInfo.b);
      localBundle.putString("peerNick", localQRScanInfo.c);
      localBundle.putString("peerOS", localQRScanInfo.d);
      localBundle.putString("apSSID", localQRScanInfo.e);
      localBundle.putString("preSharedKey", localQRScanInfo.f);
      localBundle.putBoolean("fromqlink", bool);
      paramString = paramAppActivity.getIntent().getStringExtra("subfrom");
      if (paramString != null) {
        localBundle.putString("subfrom", paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQProxyForQlink();
      a(paramAppActivity, 11, localBundle);
      paramOnQRHandleResultCallback.b();
    }
  }
  
  public boolean a(QlAndQQInterface.SendFileInfos paramSendFileInfos)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQProxyForQlink().a("0X8004763", 1);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.a, paramSendFileInfos);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr().a("cmd.sendfilemsgs", localBundle);
    if (QLog.isDevelopLevel())
    {
      paramSendFileInfos = new StringBuilder();
      paramSendFileInfos.append("[QLINK]-QQ QQ2QlSendFileMsgs:");
      paramSendFileInfos.append(i);
      QLog.d("QQProxyForQlink", 4, paramSendFileInfos.toString());
    }
    return i != -1;
  }
  
  public boolean a(String paramString, List<String> paramList)
  {
    if ((paramList != null) && (paramString != null))
    {
      if (paramList.size() <= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. no any file");
        }
        return false;
      }
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
    if (QLog.isColorLevel()) {
      QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. param error");
    }
    return false;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (1 == paramInt) {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
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
      else
      {
        QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ respHeart. no wstate error");
      }
    }
    else
    {
      QLog.e("QQProxyForQlink", 1, "[QLINK]-QQ respHeart. info = null");
    }
    this.jdField_a_of_type_Int = 0;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr().a("cmd.sendsimplecmd", localBundle);
  }
  
  public void c(Bundle paramBundle)
  {
    int i = paramBundle.getInt("Event", 0);
    switch (i)
    {
    default: 
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("[QLINK] QQ - unimplement event[");
        paramBundle.append(i);
        paramBundle.append("]");
        QLog.e("QQProxyForQlink", 2, paramBundle.toString());
        return;
      }
      break;
    case 25: 
      b(paramBundle.getInt(QlAndQQInterface.a));
      return;
    case 24: 
      b(paramBundle.getBundle(QlAndQQInterface.a));
      return;
    case 23: 
      a(paramBundle.getBundle(QlAndQQInterface.a));
      return;
    case 22: 
      d();
      return;
    case 21: 
      QlinkReliableReport.b();
      return;
    case 20: 
      QlinkReliableReport.a();
      return;
    case 19: 
      paramBundle = (QlAndQQInterface.ReportInfo)paramBundle.getSerializable(QlAndQQInterface.a);
      if ((paramBundle.data instanceof QlAndQQInterface.ReportPerformanceInfo))
      {
        paramBundle = (QlAndQQInterface.ReportPerformanceInfo)paramBundle.data;
        a(paramBundle.mUin, paramBundle.mTagName, paramBundle.mSuccess, paramBundle.mDuration, paramBundle.mSize, paramBundle.mParams);
        return;
      }
      break;
    case 18: 
      a(paramBundle.getString("action_name"), paramBundle.getInt(QlAndQQInterface.a));
      return;
    case 17: 
      a(paramBundle.getString(QlAndQQInterface.a));
      return;
    case 16: 
      a(paramBundle.getInt(QlAndQQInterface.a));
      return;
    case 15: 
      a((QlAndQQInterface.InsertFMFileInfo)paramBundle.getSerializable(QlAndQQInterface.a));
    }
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
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localQQAppInterface != null) && (localQQAppInterface.getQlinkServiceMgr() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQlinkServiceMgr().a("cmd.sendheart", localBundle);
    }
  }
  
  public void f() {}
  
  public void g()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink
 * JD-Core Version:    0.7.0.1
 */