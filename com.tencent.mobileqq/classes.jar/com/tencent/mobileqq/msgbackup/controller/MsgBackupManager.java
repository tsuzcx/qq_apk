package com.tencent.mobileqq.msgbackup.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthHandler;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupAuthProcessor;
import com.tencent.mobileqq.msgbackup.authentication.MsgBackupObserver;
import com.tencent.mobileqq.msgbackup.data.MsgBackupConfirmQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp;
import com.tencent.mobileqq.msgbackup.data.MsgBackupPushData;
import com.tencent.mobileqq.msgbackup.data.MsgBackupSessionInfo;
import com.tencent.mobileqq.msgbackup.data.MsgBackupSessionTask;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReportData.ServerFileDetail;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime.InterceptKickListener;
import mqq.app.AppRuntime.KickParams;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class MsgBackupManager
  implements IMsgBackupRequestCallback
{
  public static int a;
  private static volatile MsgBackupManager jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager;
  public static String a;
  public static ConcurrentHashMap<String, String> a;
  public static boolean a;
  public static int b;
  public static String b;
  public static boolean b;
  public static int c;
  public static String c;
  public static boolean c;
  public static String d;
  public static volatile boolean d;
  private static final String jdField_e_of_type_JavaLangString = MsgBackupAuthHandler.class.getName();
  public static boolean e;
  public static boolean f;
  public static boolean g;
  private long jdField_a_of_type_Long = 0L;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = (BaseQQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
  private MsgBackupAuthProcessor jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthProcessor;
  protected MsgBackupObserver a;
  private IMsgBackup0x210Reject jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackup0x210Reject;
  private IMsgBackupQueryCallback jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupQueryCallback;
  public IMsgBackupUICallback a;
  private MsgBackupController jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupController = new MsgBackupController(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
  private MsgBackupGetQrRsp jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp;
  private MsgBackupTransportProcessor jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor = MsgBackupTransportProcessor.a();
  public HashSet<RecentBaseData> a;
  public CopyOnWriteArraySet<Long> a;
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private AppRuntime.InterceptKickListener jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener;
  private AppRuntime.KickParams jdField_a_of_type_MqqAppAppRuntime$KickParams;
  private IMsgBackupUICallback b;
  public ConcurrentHashMap<String, MsgBackupSessionInfo> b;
  public ConcurrentHashMap<String, MsgBackupSessionInfo> c;
  private int d;
  public ConcurrentHashMap<Long, MsgBackupReportData.ServerFileDetail> d;
  private int jdField_e_of_type_Int = 0;
  public ConcurrentHashMap<Long, MsgBackupReportData.ServerFileDetail> e;
  private int jdField_f_of_type_Int = 3;
  private String jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentUin();
  public ConcurrentHashMap<Long, MsgBackupSessionTask> f;
  public ConcurrentHashMap<Long, MsgBackupSessionTask> g;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager = null;
    jdField_b_of_type_Int = 0;
    jdField_c_of_type_Boolean = false;
    jdField_d_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
    jdField_f_of_type_Boolean = true;
  }
  
  private MsgBackupManager()
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver = new MsgBackupManager.2(this);
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback = new MsgBackupManager.4(this);
    jdField_g_of_type_Boolean = true;
  }
  
  public static MsgBackupManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager == null) {
          jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager = new MsgBackupManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager;
  }
  
  public static MqqHandler a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).getConversationHandler(paramBaseQQAppInterface);
  }
  
  private void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("processPush0x11aFailed: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackup0x210Reject;
      if (localObject != null) {
        ((IMsgBackup0x210Reject)localObject).a();
      }
    }
  }
  
  private void a(MsgBackupConfirmQrRsp paramMsgBackupConfirmQrRsp)
  {
    if (paramMsgBackupConfirmQrRsp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aSucc: data is null!");
      }
      return;
    }
    String str1 = paramMsgBackupConfirmQrRsp.b();
    String str2 = paramMsgBackupConfirmQrRsp.a();
    int i = paramMsgBackupConfirmQrRsp.a();
    Object localObject = paramMsgBackupConfirmQrRsp.a().a();
    if (((List)localObject).size() == 2)
    {
      paramMsgBackupConfirmQrRsp = paramMsgBackupConfirmQrRsp.a().a();
      int j = ((Integer)((List)localObject).get(0)).intValue();
      int k = ((Integer)((List)localObject).get(1)).intValue();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pc端已经确认了，客户端收到了0x11a的push了--------> bizType= ");
        ((StringBuilder)localObject).append(i);
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processPush0x11aSucc: client ip = ");
        ((StringBuilder)localObject).append(paramMsgBackupConfirmQrRsp);
        ((StringBuilder)localObject).append(", udpport = ");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(", tcpport = ");
        ((StringBuilder)localObject).append(j);
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = a();
      ((MsgBackupTransportProcessor)localObject).d(str1);
      a().b(str2);
      a().a(i);
      ((MsgBackupTransportProcessor)localObject).b(paramMsgBackupConfirmQrRsp);
      ((MsgBackupTransportProcessor)localObject).b(j);
      ((MsgBackupTransportProcessor)localObject).a(k);
      if (i == 1)
      {
        ((MsgBackupTransportProcessor)localObject).g(2);
        ((MsgBackupTransportProcessor)localObject).f(2);
      }
      else if (i == 2)
      {
        ((MsgBackupTransportProcessor)localObject).g(1);
        ((MsgBackupTransportProcessor)localObject).f(1);
      }
      paramMsgBackupConfirmQrRsp = new Intent();
      if (QBaseActivity.sTopActivity == null)
      {
        MsgBackupUtil.a("MsgBackup.BackupAndMigrateManager", "activity is null! please check whether is assigned!", new Object[0]);
        return;
      }
      QPublicFragmentActivity.startForResult(QBaseActivity.sTopActivity, paramMsgBackupConfirmQrRsp, MsgBackupPCConfirmFragment.class, 1000);
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_MqqAppAppRuntime$KickParams != null;
  }
  
  public static void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar <=======");
    }
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localObject instanceof BaseQQAppInterface))
    {
      localObject = a((BaseQQAppInterface)localObject);
      if (localObject != null)
      {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1134067));
        MsgBackupTransportProcessor.a().a(null);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar: send msg MSG_MUSIC_PLAYER_HIDE");
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar app = null!");
    }
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public MsgBackupAuthProcessor a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthProcessor == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthProcessor = MsgBackupAuthProcessor.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthProcessor;
  }
  
  public MsgBackupGetQrRsp a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp;
  }
  
  public MsgBackupTransportProcessor a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor = MsgBackupTransportProcessor.a();
    }
    return this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor;
  }
  
  public void a()
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_JavaLangString = null;
    jdField_c_of_type_JavaLangString = null;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt, MsgBackupRequest paramMsgBackupRequest, Object paramObject)
  {
    if (paramMsgBackupRequest.jdField_a_of_type_Int == 0) {
      return;
    }
    paramInt = paramMsgBackupRequest.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor.a(this.jdField_f_of_type_JavaLangString, paramInt, paramString);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, QBaseActivity paramQBaseActivity)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("msg memory show msgtab bar----------> bizType = ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", finishedCount");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", sessionCount = ");
      ((StringBuilder)localObject1).append(jdField_b_of_type_Int);
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, ((StringBuilder)localObject1).toString());
    }
    int j = jdField_b_of_type_Int;
    this.jdField_d_of_type_Int = j;
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_e_of_type_Int = paramInt1;
    int i = paramInt1;
    if (paramInt1 != j) {
      i = paramInt1 + 1;
    }
    MqqHandler localMqqHandler = a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
    if (localMqqHandler != null)
    {
      Message localMessage = localMqqHandler.obtainMessage(1134066);
      Object localObject2;
      if (paramInt2 == 1)
      {
        localObject1 = BaseApplication.getContext().getString(2131690577);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(jdField_b_of_type_Int);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else if (paramInt2 == 3)
      {
        localObject1 = BaseApplication.getContext().getResources().getString(2131690579);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(jdField_b_of_type_Int);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject1 = BaseApplication.getContext().getResources().getString(2131690579);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(jdField_b_of_type_Int);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MsgBackupUtil.a(paramLong));
      localStringBuilder.append("B/s");
      localMessage.obj = String.format((String)localObject1, new Object[] { localObject2, localStringBuilder.toString() });
      localMessage.arg1 = paramInt2;
      MsgBackupAuthProcessor.a().a(paramInt2);
      localMqqHandler.sendMessage(localMessage);
      MsgBackupTransportProcessor.a().a(null);
      MsgBackupTransportProcessor.a().a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback);
      ((IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class)).gotoConversation(paramQBaseActivity);
      paramQBaseActivity.finish();
    }
  }
  
  public void a(Activity paramActivity)
  {
    try
    {
      paramActivity.getWindow().addFlags(128);
      return;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("acquireBrightWakeLock:");
        localStringBuilder.append(paramActivity.toString());
        QLog.e("MsgBackup.BackupAndMigrateManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(Context paramContext, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msg memory show msgtab bar----------> bizType = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", hasFinishedCount = ");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
      ((StringBuilder)localObject).append(", sessionCount = ");
      ((StringBuilder)localObject).append(jdField_b_of_type_Int);
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "gotoSpecialPage------------------");
      }
      i = this.jdField_d_of_type_Int;
      j = this.jdField_e_of_type_Int;
      if (i == j)
      {
        MsgBackupCompleteFragment.g(paramContext, i, j);
        return;
      }
      MsgBackupPcBaseFragment.a(paramContext, paramInt);
      return;
    }
    if (paramInt == 3)
    {
      localObject = new Intent();
      if (this.jdField_d_of_type_Int == this.jdField_e_of_type_Int)
      {
        if (MsgBackupTransportProcessor.a().e() == 2)
        {
          MsgBackupCompleteFragment.b(paramContext, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
          return;
        }
        MsgBackupCompleteFragment.e(paramContext, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
        return;
      }
      ((Intent)localObject).putExtra("param_start", 5);
      QPublicFragmentActivity.start(paramContext, (Intent)localObject, MsgBackupTransportFragment.class);
      return;
    }
    int i = this.jdField_d_of_type_Int;
    int j = this.jdField_e_of_type_Int;
    if (i == j)
    {
      MsgBackupCompleteFragment.k(paramContext, i, j);
      return;
    }
    MsgBackupPcBaseFragment.a(paramContext, paramInt);
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    MsgBackupReporter.b();
    d();
    try
    {
      e();
      return;
    }
    finally {}
  }
  
  public void a(IMsgBackup0x210Reject paramIMsgBackup0x210Reject)
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackup0x210Reject = paramIMsgBackup0x210Reject;
  }
  
  public void a(IMsgBackupQueryCallback paramIMsgBackupQueryCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupQueryCallback = paramIMsgBackupQueryCallback;
  }
  
  public void a(IMsgBackupUICallback paramIMsgBackupUICallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback = paramIMsgBackupUICallback;
  }
  
  public void a(MsgBackupRequest paramMsgBackupRequest)
  {
    if (paramMsgBackupRequest == null) {
      return;
    }
    paramMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback = this;
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupController.a(paramMsgBackupRequest, 10000);
  }
  
  public void a(MsgBackupRequest paramMsgBackupRequest, Object paramObject)
  {
    if (paramMsgBackupRequest.jdField_a_of_type_Int == 0)
    {
      if ((paramObject != null) && ((paramObject instanceof MsgBackupSessionInfo)))
      {
        paramMsgBackupRequest = (MsgBackupSessionInfo)paramObject;
        paramObject = new File(MsgBackupUtil.a(paramMsgBackupRequest.jdField_a_of_type_JavaLangString, MsgBackupUtil.b(paramMsgBackupRequest.jdField_a_of_type_Int), paramMsgBackupRequest.jdField_b_of_type_JavaLangString));
        if (!paramObject.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProgress, db prepared! file is not exist!");
          }
          return;
        }
        paramMsgBackupRequest.jdField_a_of_type_Long = paramObject.length();
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(MsgBackupUtil.b(paramMsgBackupRequest.jdField_a_of_type_JavaLangString, MsgBackupUtil.b(paramMsgBackupRequest.jdField_a_of_type_Int)), paramMsgBackupRequest);
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("onProgress, db prepared! result = 0, sessionInfo.uin = ");
          paramObject.append(paramMsgBackupRequest.jdField_a_of_type_JavaLangString);
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, paramObject.toString());
        }
        a().i(257);
      }
    }
    else if (paramMsgBackupRequest.jdField_a_of_type_Int == 2)
    {
      paramObject = this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback;
      if (paramObject != null) {
        paramObject.b(paramMsgBackupRequest.jdField_c_of_type_Int + 1, paramMsgBackupRequest.jdField_b_of_type_Int);
      }
    }
  }
  
  public void a(MsgBackupPushData paramMsgBackupPushData)
  {
    if (jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProcessPush0x11b: now is phone to phone transfer, so please wait the transfer done!");
      }
      return;
    }
    if (paramMsgBackupPushData != null)
    {
      jdField_c_of_type_Boolean = true;
      Intent localIntent = new Intent();
      int i = paramMsgBackupPushData.a();
      a().a(i);
      paramMsgBackupPushData = paramMsgBackupPushData.a();
      a().a(paramMsgBackupPushData);
      localIntent.putExtra("0x11bpush_extra", paramMsgBackupPushData);
      localIntent.putExtra("BIZ_TYPE", i);
      localIntent.addFlags(268435456);
      QPublicFragmentActivity.start(BaseApplication.getContext(), localIntent, MsgBackupPCConfirmFragment.class);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof MsgBackupConfirmQrRsp))
    {
      paramObject = (MsgBackupConfirmQrRsp)paramObject;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onProcessPush0x11a: ");
        localStringBuilder.append(paramObject);
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, localStringBuilder.toString());
      }
      a(paramObject);
      return;
    }
    if ((paramObject instanceof Integer)) {
      a(((Integer)paramObject).intValue());
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      ((MsgBackupAuthHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(jdField_e_of_type_JavaLangString)).c(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 1;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp = null;
      this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
      i = 3;
    }
    a().a(i);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor.a(this.jdField_f_of_type_JavaLangString, paramBoolean);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "clearSessionData ->>>>>>>>>>");
    }
    jdField_b_of_type_Int = 0;
    jdField_d_of_type_JavaLangString = null;
    jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.clear();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp = null;
    i();
    jdField_e_of_type_Boolean = false;
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msg memory update msgtab bar----------> content = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("., bizType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
    if (localObject != null)
    {
      Message localMessage = ((MqqHandler)localObject).obtainMessage(1134066);
      localMessage.obj = paramString;
      localMessage.arg1 = paramInt;
      ((MqqHandler)localObject).sendMessage(localMessage);
    }
  }
  
  public void b(Activity paramActivity)
  {
    try
    {
      paramActivity.getWindow().clearFlags(128);
      return;
    }
    catch (Exception paramActivity)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("acquireBrightWakeLock:");
        localStringBuilder.append(paramActivity.toString());
        QLog.e("MsgBackup.BackupAndMigrateManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void b(MsgBackupRequest paramMsgBackupRequest)
  {
    if (paramMsgBackupRequest == null) {
      return;
    }
    paramMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback = this;
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupController.a(paramMsgBackupRequest, 10001);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
  }
  
  public void c(MsgBackupRequest paramMsgBackupRequest)
  {
    if (paramMsgBackupRequest == null) {
      return;
    }
    paramMsgBackupRequest.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupRequestCallback = this;
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupController.a(paramMsgBackupRequest, -1);
  }
  
  public void d()
  {
    MsgBackupUtil.a("MsgBackup.BackupAndMigrateManager", "onDestory ......", new Object[0]);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor.b();
    b();
    jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupController.a();
    MsgBackupReporter.c();
    ThreadManager.getFileThreadHandler().post(new MsgBackupManager.1(this));
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupController.b();
    jdField_g_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager = null;
  }
  
  public void f() {}
  
  public void g()
  {
    ((MsgBackupAuthHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(jdField_e_of_type_JavaLangString)).a();
  }
  
  public void h()
  {
    MsgBackupUtil.b("MsgBackup.BackupAndMigrateManager", "sFileMeta = %s", new Object[] { jdField_a_of_type_JavaLangString });
    TextUtils.isEmpty(jdField_a_of_type_JavaLangString);
    ((MsgBackupAuthHandler)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(jdField_e_of_type_JavaLangString)).b(jdField_a_of_type_JavaLangString);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor.a(this.jdField_f_of_type_JavaLangString);
  }
  
  public void k()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_MqqAppAppRuntime$KickParams = null;
    if (this.jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener == null) {
      this.jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener = new MsgBackupManager.3(this);
    }
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.setInterceptKickListener(this.jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener);
  }
  
  public void l()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (a())
    {
      this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.kick(this.jdField_a_of_type_MqqAppAppRuntime$KickParams);
      this.jdField_a_of_type_MqqAppAppRuntime$KickParams = null;
    }
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.setInterceptKickListener(null);
  }
  
  public void n()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupManager.5(this));
  }
  
  public void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager
 * JD-Core Version:    0.7.0.1
 */