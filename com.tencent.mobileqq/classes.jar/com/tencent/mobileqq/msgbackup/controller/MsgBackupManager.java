package com.tencent.mobileqq.msgbackup.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReportData.ServerFileDetail;
import com.tencent.mobileqq.msgbackup.util.MsgBackupReporter;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime.InterceptKickListener;
import mqq.app.AppRuntime.KickParams;
import mqq.os.MqqHandler;

public class MsgBackupManager
  implements IMsgBackupRequestCallback
{
  public static int a;
  public static Activity a;
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
  public static boolean e;
  public static boolean f;
  public static boolean g;
  private long jdField_a_of_type_Long = 0L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  private MsgBackupAuthProcessor jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupAuthProcessor;
  protected MsgBackupObserver a;
  private IMsgBackup0x210Reject jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackup0x210Reject;
  private IMsgBackupQueryCallback jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupQueryCallback;
  public IMsgBackupUICallback a;
  private MsgBackupController jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupController = new MsgBackupController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
  public ConcurrentHashMap<Long, MsgBackupReportData.ServerFileDetail> e;
  private int f;
  public ConcurrentHashMap<Long, MsgBackupSessionTask> f;
  private int g;
  public ConcurrentHashMap<Long, MsgBackupSessionTask> g;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager = null;
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_AndroidAppActivity = null;
    jdField_c_of_type_Boolean = false;
    jdField_d_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
    jdField_f_of_type_Boolean = true;
  }
  
  private MsgBackupManager()
  {
    this.jdField_d_of_type_Int = 0;
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
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 3;
    jdField_g_of_type_Boolean = true;
  }
  
  public static MsgBackupManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager == null) {
        jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager = new MsgBackupManager();
      }
      return jdField_a_of_type_ComTencentMobileqqMsgbackupControllerMsgBackupManager;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aFailed: " + paramInt);
    }
    if (paramInt == 6) {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackup0x210Reject != null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackup0x210Reject.a();
      }
    }
    while (paramInt != 20) {
      return;
    }
  }
  
  private void a(MsgBackupConfirmQrRsp paramMsgBackupConfirmQrRsp)
  {
    if (paramMsgBackupConfirmQrRsp == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aSucc: data is null!");
      }
    }
    String str1;
    String str2;
    int i;
    do
    {
      return;
      str1 = paramMsgBackupConfirmQrRsp.b();
      str2 = paramMsgBackupConfirmQrRsp.a();
      i = paramMsgBackupConfirmQrRsp.a();
      localObject = paramMsgBackupConfirmQrRsp.a().a();
    } while (((List)localObject).size() != 2);
    paramMsgBackupConfirmQrRsp = paramMsgBackupConfirmQrRsp.a().a();
    int j = ((Integer)((List)localObject).get(0)).intValue();
    int k = ((Integer)((List)localObject).get(1)).intValue();
    if (QLog.isColorLevel())
    {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "pc端已经确认了，客户端收到了0x11a的push了--------> bizType= " + i);
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aSucc: client ip = " + paramMsgBackupConfirmQrRsp + ", udpport = " + k + ", tcpport = " + j);
    }
    Object localObject = a();
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
    for (;;)
    {
      paramMsgBackupConfirmQrRsp = new Intent();
      if (BaseActivity.sTopActivity != null) {
        break;
      }
      MsgBackupUtil.a("MsgBackup.BackupAndMigrateManager", "activity is null! please check whether is assigned!", new Object[0]);
      return;
      if (i == 2)
      {
        ((MsgBackupTransportProcessor)localObject).g(1);
        ((MsgBackupTransportProcessor)localObject).f(1);
      }
    }
    PublicFragmentActivity.a(BaseActivity.sTopActivity, paramMsgBackupConfirmQrRsp, MsgBackupPCConfirmFragment.class, 1000);
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
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1134067));
        MsgBackupTransportProcessor.a().a(null);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar: send msg MSG_MUSIC_PLAYER_HIDE");
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar app = null!");
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
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
    if (paramMsgBackupRequest.jdField_a_of_type_Int == 0) {}
    while (paramMsgBackupRequest.jdField_a_of_type_Int != 2) {
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor.a(this.jdField_e_of_type_JavaLangString, paramInt, paramString);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar----------> bizType = " + paramInt2 + ", finishedCount" + paramInt1 + ", sessionCount = " + jdField_b_of_type_Int);
    }
    this.jdField_e_of_type_Int = jdField_b_of_type_Int;
    this.jdField_g_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_f_of_type_Int = paramInt1;
    int i = paramInt1;
    if (paramInt1 != jdField_b_of_type_Int) {
      i = paramInt1 + 1;
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    Message localMessage;
    String str1;
    String str2;
    if (localMqqHandler != null)
    {
      localMessage = localMqqHandler.obtainMessage(1134066);
      if (paramInt2 != 1) {
        break label266;
      }
      str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690649);
      str2 = i + "/" + jdField_b_of_type_Int;
    }
    for (;;)
    {
      localMessage.obj = String.format(str1, new Object[] { str2, MsgBackupUtil.a(paramLong) + "B/s" });
      localMessage.arg1 = paramInt2;
      MsgBackupAuthProcessor.a().a(paramInt2);
      localMqqHandler.sendMessage(localMessage);
      MsgBackupTransportProcessor.a().a(null);
      MsgBackupTransportProcessor.a().a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback);
      a(paramBaseActivity);
      paramBaseActivity.finish();
      return;
      label266:
      if (paramInt2 == 3)
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690651);
        str2 = i + "/" + jdField_b_of_type_Int;
      }
      else
      {
        str1 = BaseApplicationImpl.getApplication().getResources().getString(2131690651);
        str2 = i + "/" + jdField_b_of_type_Int;
      }
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
      while (!QLog.isColorLevel()) {}
      QLog.e("MsgBackup.BackupAndMigrateManager", 2, "acquireBrightWakeLock:" + paramActivity.toString());
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    Intent localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(67108864);
    paramBaseActivity.startActivity(localIntent);
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar----------> bizType = " + paramInt + ", hasFinishedCount = " + this.jdField_f_of_type_Int + ", sessionCount = " + jdField_b_of_type_Int);
    }
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "gotoSpecialPage------------------");
      }
      if (this.jdField_e_of_type_Int == this.jdField_f_of_type_Int)
      {
        MsgBackupCompleteFragment.g(paramBaseActivity, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
        return;
      }
      MsgBackupPcBaseFragment.a(paramBaseActivity, paramInt);
      return;
    }
    if (paramInt == 3)
    {
      Intent localIntent = new Intent();
      if (this.jdField_e_of_type_Int == this.jdField_f_of_type_Int)
      {
        if (MsgBackupTransportProcessor.a().e() == 2)
        {
          MsgBackupCompleteFragment.b(paramBaseActivity, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
          return;
        }
        MsgBackupCompleteFragment.e(paramBaseActivity, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
        return;
      }
      localIntent.putExtra("param_start", 5);
      PublicFragmentActivity.a(paramBaseActivity, localIntent, MsgBackupTransportFragment.class);
      return;
    }
    if (this.jdField_e_of_type_Int == this.jdField_f_of_type_Int)
    {
      MsgBackupCompleteFragment.k(paramBaseActivity, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
      return;
    }
    MsgBackupPcBaseFragment.a(paramBaseActivity, paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
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
    if (paramMsgBackupRequest.jdField_a_of_type_Int == 0) {
      if ((paramObject != null) && ((paramObject instanceof MsgBackupSessionInfo)))
      {
        paramMsgBackupRequest = (MsgBackupSessionInfo)paramObject;
        paramObject = new File(MsgBackupUtil.a(paramMsgBackupRequest.jdField_a_of_type_JavaLangString, MsgBackupUtil.b(paramMsgBackupRequest.jdField_a_of_type_Int), paramMsgBackupRequest.jdField_b_of_type_JavaLangString));
        if (paramObject.exists()) {
          break label72;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProgress, db prepared! file is not exist!");
        }
      }
    }
    label72:
    while ((paramMsgBackupRequest.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback == null))
    {
      return;
      paramMsgBackupRequest.jdField_a_of_type_Long = paramObject.length();
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(MsgBackupUtil.b(paramMsgBackupRequest.jdField_a_of_type_JavaLangString, MsgBackupUtil.b(paramMsgBackupRequest.jdField_a_of_type_Int)), paramMsgBackupRequest);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProgress, db prepared! result = 0, sessionInfo.uin = " + paramMsgBackupRequest.jdField_a_of_type_JavaLangString);
      }
      a().i(257);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupControllerIMsgBackupUICallback.b(paramMsgBackupRequest.jdField_c_of_type_Int + 1, paramMsgBackupRequest.jdField_b_of_type_Int);
  }
  
  public void a(MsgBackupPushData paramMsgBackupPushData)
  {
    if (jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProcessPush0x11b: now is phone to phone transfer, so please wait the transfer done!");
      }
    }
    while (paramMsgBackupPushData == null) {
      return;
    }
    jdField_c_of_type_Boolean = true;
    Intent localIntent = new Intent();
    int i = paramMsgBackupPushData.a();
    a().a(i);
    paramMsgBackupPushData = paramMsgBackupPushData.a();
    a().a(paramMsgBackupPushData);
    localIntent.putExtra("0x11bpush_extra", paramMsgBackupPushData);
    localIntent.putExtra("BIZ_TYPE", i);
    localIntent.addFlags(268435456);
    PublicFragmentActivity.a(BaseApplicationImpl.getApplication(), localIntent, MsgBackupPCConfirmFragment.class);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof MsgBackupConfirmQrRsp))
    {
      paramObject = (MsgBackupConfirmQrRsp)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProcessPush0x11a: " + paramObject);
      }
      a(paramObject);
    }
    while (!(paramObject instanceof Integer)) {
      return;
    }
    a(((Integer)paramObject).intValue());
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      ((MsgBackupAuthHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER)).c(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 3;
    if (paramBoolean) {
      i = 1;
    }
    for (;;)
    {
      a().a(i);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor.a(this.jdField_e_of_type_JavaLangString, paramBoolean);
      return;
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupDataMsgBackupGetQrRsp = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory update msgtab bar----------> content = " + paramString + "., bizType = " + paramInt);
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      Message localMessage = localMqqHandler.obtainMessage(1134066);
      localMessage.obj = paramString;
      localMessage.arg1 = paramInt;
      localMqqHandler.sendMessage(localMessage);
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
      while (!QLog.isColorLevel()) {}
      QLog.e("MsgBackup.BackupAndMigrateManager", 2, "acquireBrightWakeLock:" + paramActivity.toString());
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
    ((MsgBackupAuthHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER)).a();
  }
  
  public void h()
  {
    MsgBackupUtil.b("MsgBackup.BackupAndMigrateManager", "sFileMeta = %s", new Object[] { jdField_a_of_type_JavaLangString });
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {}
    ((MsgBackupAuthHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MSG_BACK_UP_HANDLER)).b(jdField_a_of_type_JavaLangString);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqMsgbackupAuthenticationMsgBackupObserver);
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupTransportProcessor.a(this.jdField_e_of_type_JavaLangString);
  }
  
  public void k()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_MqqAppAppRuntime$KickParams = null;
    if (this.jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener == null) {
      this.jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener = new MsgBackupManager.3(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setInterceptKickListener(this.jdField_a_of_type_MqqAppAppRuntime$InterceptKickListener);
  }
  
  public void l()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.kick(this.jdField_a_of_type_MqqAppAppRuntime$KickParams);
      this.jdField_a_of_type_MqqAppAppRuntime$KickParams = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setInterceptKickListener(null);
  }
  
  public void n()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupManager.5(this));
  }
  
  public void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager
 * JD-Core Version:    0.7.0.1
 */