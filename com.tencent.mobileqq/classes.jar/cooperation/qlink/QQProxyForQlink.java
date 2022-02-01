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
  private QQAppInterface a;
  private Timer b;
  private int c = 0;
  private QlAndQQInterface.WorkState d = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);
  private QQCustomDialog e;
  private BroadcastReceiver f = null;
  private int g = -1;
  private BroadcastReceiver h = null;
  
  public QQProxyForQlink(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    if (paramActivity == null) {
      return;
    }
    String str = HardCodeUtil.a(2131908334);
    StringBuilder localStringBuilder;
    if (1 == paramInt)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(HardCodeUtil.a(2131908337));
      localStringBuilder.append(paramString);
      localStringBuilder.append(HardCodeUtil.a(2131908332));
      paramString = localStringBuilder.toString();
    }
    for (;;)
    {
      break;
      if (2 == paramInt)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(HardCodeUtil.a(2131908336));
        localStringBuilder.append(paramString);
        localStringBuilder.append(HardCodeUtil.a(2131908331));
        paramString = localStringBuilder.toString();
      }
      else
      {
        paramString = HardCodeUtil.a(2131908333);
      }
    }
    DialogUtil.a(paramActivity, 230, paramActivity.getString(2131896322), paramString, 2131896316, 2131896316, new QQProxyForQlink.8(this, paramOnQRHandleResultCallback), null).show();
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - startQlink failed context=null!");
      }
      Toast.makeText(BaseApplication.getContext(), HardCodeUtil.a(2131908335), 0).show();
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
  
  private void j()
  {
    try
    {
      Timer localTimer = this.b;
      if (localTimer != null) {
        return;
      }
      QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ setQlinkHeartTimer");
      this.b = new Timer();
      this.b.schedule(new QQProxyForQlink.9(this), 0L, 5000L);
      return;
    }
    finally {}
  }
  
  private void k()
  {
    try
    {
      if (this.b != null)
      {
        QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ cancelQlinkHeartTimer");
        this.b.cancel();
        this.b = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void l()
  {
    if (this.h == null)
    {
      this.h = new QQProxyForQlink.10(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      Object localObject = this.a;
      if (localObject != null) {
        localObject = ((QQAppInterface)localObject).getApp();
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        ((BaseApplication)localObject).registerReceiver(this.h, localIntentFilter);
        return;
      }
      QLog.e("QQProxyForQlink", 1, "registerAccountReceiver error. fail");
      this.h = null;
    }
  }
  
  private void m()
  {
    if (this.h != null)
    {
      QQAppInterface localQQAppInterface = this.a;
      if ((localQQAppInterface != null) && (localQQAppInterface.getApp() != null))
      {
        this.a.getApp().unregisterReceiver(this.h);
        this.h = null;
        return;
      }
      QLog.e("QQProxyForQlink", 1, "unregisterAccountReceiver error.");
    }
  }
  
  private void n()
  {
    for (;;)
    {
      try
      {
        if (this.f == null)
        {
          this.f = new QQProxyForQlink.11(this);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("com.tencent.qlink.finishworkingdlg");
          if (this.a == null) {
            break label91;
          }
          BaseApplication localBaseApplication = this.a.getApp();
          if (localBaseApplication != null)
          {
            localBaseApplication.registerReceiver(this.f, localIntentFilter);
          }
          else
          {
            QLog.e("QQProxyForQlink", 1, "registerFinishWorkingDlgReceiver error.fail");
            this.f = null;
          }
        }
        return;
      }
      finally {}
      label91:
      Object localObject2 = null;
    }
  }
  
  private void o()
  {
    try
    {
      if (this.f != null) {
        if ((this.a != null) && (this.a.getApp() != null))
        {
          this.a.getApp().unregisterReceiver(this.f);
          this.f = null;
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
  
  public QlAndQQInterface.WorkState a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    int i = this.d.mTransferingCount;
    Object localObject = this.d;
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
      i = QLinkTransingBannerProcessor.a;
      if (this.a.getQQProxyForQlink().h() != 0) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
      ((BannerManager)localObject).a(i, paramInt, null);
    }
  }
  
  public void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, String paramString)
  {
    if (this.e != null) {
      return;
    }
    String str2 = ContactUtils.d(this.a, this.d.mPeerUin);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!this.d.mPeerUin.equalsIgnoreCase(str2)) {}
    }
    else if (this.d.mPeerNick != null)
    {
      str1 = this.d.mPeerNick;
    }
    else
    {
      str1 = this.d.mPeerUin;
    }
    if (this.d.mMode == 1)
    {
      a("0X8004854", 1);
      paramOnClickListener3 = new StringBuilder();
      paramOnClickListener3.append(paramActivity.getResources().getString(2131896362));
      paramOnClickListener3.append(str1);
      paramOnClickListener3.append(paramActivity.getResources().getString(2131896363));
      paramOnClickListener3 = paramOnClickListener3.toString();
      if ((paramString != null) && (!paramString.equalsIgnoreCase(this.d.mPeerUin))) {
        this.e = DialogUtil.a(paramActivity, 230, paramActivity.getResources().getString(2131896323), paramOnClickListener3, paramActivity.getResources().getString(2131896364), paramActivity.getResources().getString(2131896364), paramOnClickListener2, null);
      } else {
        this.e = DialogUtil.a(paramActivity, 230, paramActivity.getResources().getString(2131896323), paramOnClickListener3, paramActivity.getResources().getString(2131896364), paramActivity.getResources().getString(2131896365), paramOnClickListener1, paramOnClickListener2);
      }
      this.e.show();
    }
    else if (this.d.mMode == 2)
    {
      a("0X8004856", 1);
      paramOnClickListener1 = new StringBuilder();
      paramOnClickListener1.append(str1);
      paramOnClickListener1.append(paramActivity.getResources().getString(2131896361));
      paramOnClickListener1 = paramOnClickListener1.toString();
      this.e = DialogUtil.a(paramActivity, 230, paramActivity.getResources().getString(2131896323), paramOnClickListener1, paramActivity.getResources().getString(2131896360), paramActivity.getResources().getString(2131896360), paramOnClickListener3, null);
      this.e.show();
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("QQProxyForQlink", 2, "[QLINK] QQ - working but op err");
    }
    paramActivity = this.e;
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
    if (!this.d.mWorking)
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
    this.d.mForIphone = paramBundle.mForIphone;
    this.d.mMode = paramBundle.mMode;
    this.d.mPeerNick = paramBundle.mPeerNick;
    this.d.mPeerUin = paramBundle.mPeerUin;
    this.d.mState = paramBundle.mState;
    this.d.mTransferingCount = paramBundle.mTransferingCount;
    this.d.mWorking = paramBundle.mWorking;
  }
  
  public void a(QlAndQQInterface.DailogClickInfo paramDailogClickInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.a, paramDailogClickInfo);
    int i = this.a.getQlinkServiceMgr().a("cmd.senddailogclickinfo", localBundle);
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
    long l1 = FileManagerUtil.h(paramInsertFMFileInfo.filePath);
    long l2 = MessageRecordFactory.a(-1000).uniseq;
    FileManagerEntity localFileManagerEntity = this.a.getFileManagerDataCenter().b(l2, paramInsertFMFileInfo.uin, 0);
    localFileManagerEntity.setCloudType(5);
    localFileManagerEntity.nSessionId = paramInsertFMFileInfo.sessionId;
    localFileManagerEntity.setFilePath(paramInsertFMFileInfo.filePath);
    localFileManagerEntity.nFileType = FileManagerUtil.c(paramInsertFMFileInfo.filePath);
    localFileManagerEntity.strThumbPath = paramInsertFMFileInfo.thumbPath;
    localFileManagerEntity.fileName = ((String)localObject);
    localFileManagerEntity.fileSize = l1;
    localFileManagerEntity.srvTime = (MessageCache.c() * 1000L);
    localFileManagerEntity.msgSeq = FileManagerUtil.f();
    localFileManagerEntity.msgUid = FileManagerUtil.g();
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = paramInsertFMFileInfo.uin;
    localFileManagerEntity.nOlSenderProgress = paramInsertFMFileInfo.transSeq;
    FriendsManager localFriendsManager = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager.m(String.valueOf(localFileManagerEntity.peerUin)) != null) {
      localFileManagerEntity.peerType = 0;
    } else {
      localFileManagerEntity.peerType = 1003;
    }
    localFileManagerEntity.peerNick = FileManagerUtil.a(this.a, paramInsertFMFileInfo.uin, null, 0);
    localFileManagerEntity.status = 1;
    localFriendsManager.n(paramInsertFMFileInfo.uin);
    if (paramInsertFMFileInfo.bSend)
    {
      localFileManagerEntity.nOpType = 0;
      localFileManagerEntity.bSend = true;
      TransfileUtile.makeTransFileProtocolData(paramInsertFMFileInfo.filePath, 0L, 0, true);
      this.a.getFileManagerDataCenter().a(localFileManagerEntity);
    }
    else
    {
      localFileManagerEntity.nOpType = 1;
      localFileManagerEntity.bSend = false;
      TransfileUtile.makeTransFileProtocolData(paramInsertFMFileInfo.filePath, l1, 0, false, null);
      TransFileUtil.getTransferFilePath(this.a.getAccount(), (String)localObject, 0, null);
      this.a.getFileManagerDataCenter().a(localFileManagerEntity);
    }
    this.a.getFileManagerDataCenter().c(localFileManagerEntity);
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
    int i = this.a.getQlinkServiceMgr().a("cmd.senduserinfo", localBundle);
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
    String str = ContactUtils.c(this.a, paramString);
    FriendsManager localFriendsManager = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    QlAndQQInterface.UserInfo localUserInfo = new QlAndQQInterface.UserInfo();
    localUserInfo.uin = paramString;
    if (str != null) {
      localUserInfo.nick = str;
    } else {
      localUserInfo.nick = paramString;
    }
    paramString = localFriendsManager.m(paramString);
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
    ReportController.b(this.a, "CliOper", "", "", paramString, paramString, 0, paramInt, 0, "", "", "", "");
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
    DialogUtil.a(paramAppActivity, 230, paramAppActivity.getString(2131896340), paramAppActivity.getString(2131896341), 2131896316, 2131896316, new QQProxyForQlink.7(this, paramOnQRHandleResultCallback), null).show();
  }
  
  public void a(AppActivity paramAppActivity, String paramString, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    if (paramAppActivity != null)
    {
      if (paramString == null) {
        return;
      }
      QlinkHelper.QRScanInfo localQRScanInfo = QlinkHelper.e(paramString);
      if (localQRScanInfo == null)
      {
        DialogUtil.a(paramAppActivity, 230, paramAppActivity.getString(2131896322), paramAppActivity.getString(2131896342), 2131896316, 2131896316, new QQProxyForQlink.6(this, paramOnQRHandleResultCallback), null).show();
        return;
      }
      if (this.d.mWorking)
      {
        a(paramAppActivity, this.d.mMode, this.d.mPeerNick, paramOnQRHandleResultCallback);
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
      this.a.getQQProxyForQlink();
      a(paramAppActivity, 11, localBundle);
      paramOnQRHandleResultCallback.b();
    }
  }
  
  public boolean a(QlAndQQInterface.SendFileInfos paramSendFileInfos)
  {
    this.a.getQQProxyForQlink().a("0X8004763", 1);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable(QlAndQQInterface.a, paramSendFileInfos);
    int i = this.a.getQlinkServiceMgr().a("cmd.sendfilemsgs", localBundle);
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
        localSendFileInfo.fileSize = FileManagerUtil.h(paramList);
        localSendFileInfos.infos.add(localSendFileInfo);
      }
      return a(localSendFileInfos);
    }
    if (QLog.isColorLevel()) {
      QLog.e("QQProxyForQlink", 2, "[QLINK]-QQ sendFileMsgs. param error");
    }
    return false;
  }
  
  public void b()
  {
    QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ UI_LOG:QQProxyForQlink. onAppInit");
    QQAppInterface localQQAppInterface = this.a;
    if ((localQQAppInterface != null) && (localQQAppInterface.getApp() != null)) {
      ThreadManager.executeOnSubThread(new QQProxyForQlink.1(this));
    }
  }
  
  public void b(int paramInt)
  {
    if (1 == paramInt) {
      FileManagerUtil.a(this.a.getApplication().getApplicationContext());
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("qlinkexit", false))
      {
        QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ qlink is exit:");
        this.d = new QlAndQQInterface.WorkState(false, 1, null, null, 0, 0, false);
        k();
        return;
      }
      paramBundle = (QlAndQQInterface.WorkState)paramBundle.getSerializable("wstate");
      if (paramBundle != null)
      {
        this.d.mForIphone = paramBundle.mForIphone;
        this.d.mMode = paramBundle.mMode;
        this.d.mPeerNick = paramBundle.mPeerNick;
        this.d.mPeerUin = paramBundle.mPeerUin;
        this.d.mState = paramBundle.mState;
        this.d.mTransferingCount = paramBundle.mTransferingCount;
        this.d.mWorking = paramBundle.mWorking;
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
    this.c = 0;
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("cmd", paramInt);
    this.a.getQlinkServiceMgr().a("cmd.sendsimplecmd", localBundle);
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
      e();
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
    QLog.i("QQProxyForQlink", 1, "[QLINK]-QQ UI_LOG:QQProxyForQlink. onAppDestroy");
    m();
    o();
    k();
    this.a = null;
  }
  
  public void e()
  {
    QLog.d("QQProxyForQlink", 4, "[QLINK]-QQ nofityQlinkStart");
    j();
  }
  
  public void f()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("param", 1);
    QQAppInterface localQQAppInterface = this.a;
    if ((localQQAppInterface != null) && (localQQAppInterface.getQlinkServiceMgr() != null)) {
      this.a.getQlinkServiceMgr().a("cmd.sendheart", localBundle);
    }
  }
  
  public void g() {}
  
  public int h()
  {
    return this.d.mTransferingCount;
  }
  
  public void i()
  {
    QQCustomDialog localQQCustomDialog = this.e;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.e = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QQProxyForQlink
 * JD-Core Version:    0.7.0.1
 */