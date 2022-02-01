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
  private static volatile MsgBackupManager A = null;
  public static boolean a;
  public static String b;
  public static String c;
  public static String d;
  public static ConcurrentHashMap<String, String> e;
  public static boolean f;
  public static int g;
  public static int i = 0;
  public static String o;
  public static int p;
  public static boolean s = false;
  public static volatile boolean t = false;
  public static boolean u = false;
  public static boolean v = true;
  public static boolean w;
  private static final String z = MsgBackupAuthHandler.class.getName();
  private BaseQQAppInterface B = (BaseQQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
  private MsgBackupController C = new MsgBackupController(this.B);
  private final AtomicBoolean D = new AtomicBoolean();
  private AppRuntime.InterceptKickListener E;
  private AppRuntime.KickParams F;
  private MsgBackupTransportProcessor G = MsgBackupTransportProcessor.a();
  private MsgBackupAuthProcessor H;
  private String I = this.B.getCurrentUin();
  private MsgBackupGetQrRsp J;
  private IMsgBackupUICallback K = new MsgBackupManager.4(this);
  private long L = 0L;
  private int M;
  private int N = 0;
  private int O = 3;
  private IMsgBackup0x210Reject P;
  private IMsgBackupQueryCallback Q;
  public HashSet<RecentBaseData> h = new HashSet();
  public ConcurrentHashMap<String, MsgBackupSessionInfo> j = new ConcurrentHashMap();
  public ConcurrentHashMap<String, MsgBackupSessionInfo> k = new ConcurrentHashMap();
  public CopyOnWriteArraySet<Long> l = new CopyOnWriteArraySet();
  public ConcurrentHashMap<Long, MsgBackupReportData.ServerFileDetail> m = new ConcurrentHashMap();
  public ConcurrentHashMap<Long, MsgBackupReportData.ServerFileDetail> n = new ConcurrentHashMap();
  public ConcurrentHashMap<Long, MsgBackupSessionTask> q = new ConcurrentHashMap();
  public ConcurrentHashMap<Long, MsgBackupSessionTask> r = new ConcurrentHashMap();
  protected MsgBackupObserver x = new MsgBackupManager.2(this);
  public IMsgBackupUICallback y;
  
  static
  {
    a = false;
    e = new ConcurrentHashMap();
    f = false;
    g = 0;
  }
  
  private MsgBackupManager()
  {
    w = true;
  }
  
  public static MsgBackupManager a()
  {
    if (A == null) {
      try
      {
        if (A == null) {
          A = new MsgBackupManager();
        }
      }
      finally {}
    }
    return A;
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
      localObject = this.P;
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
    int i1 = paramMsgBackupConfirmQrRsp.d();
    Object localObject = paramMsgBackupConfirmQrRsp.c().b();
    if (((List)localObject).size() == 2)
    {
      paramMsgBackupConfirmQrRsp = paramMsgBackupConfirmQrRsp.c().a();
      int i2 = ((Integer)((List)localObject).get(0)).intValue();
      int i3 = ((Integer)((List)localObject).get(1)).intValue();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pc端已经确认了，客户端收到了0x11a的push了--------> bizType= ");
        ((StringBuilder)localObject).append(i1);
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processPush0x11aSucc: client ip = ");
        ((StringBuilder)localObject).append(paramMsgBackupConfirmQrRsp);
        ((StringBuilder)localObject).append(", udpport = ");
        ((StringBuilder)localObject).append(i3);
        ((StringBuilder)localObject).append(", tcpport = ");
        ((StringBuilder)localObject).append(i2);
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = d();
      ((MsgBackupTransportProcessor)localObject).d(str1);
      e().b(str2);
      e().a(i1);
      ((MsgBackupTransportProcessor)localObject).b(paramMsgBackupConfirmQrRsp);
      ((MsgBackupTransportProcessor)localObject).b(i2);
      ((MsgBackupTransportProcessor)localObject).a(i3);
      if (i1 == 1)
      {
        ((MsgBackupTransportProcessor)localObject).g(2);
        ((MsgBackupTransportProcessor)localObject).f(2);
      }
      else if (i1 == 2)
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
  
  public static void q()
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
  
  private boolean v()
  {
    return this.F != null;
  }
  
  public void a(int paramInt, MsgBackupRequest paramMsgBackupRequest, Object paramObject)
  {
    if (paramMsgBackupRequest.b == 0) {
      return;
    }
    paramInt = paramMsgBackupRequest.b;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.G.a(this.I, paramInt, paramString);
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
      ((StringBuilder)localObject1).append(i);
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, ((StringBuilder)localObject1).toString());
    }
    int i2 = i;
    this.M = i2;
    this.O = paramInt2;
    this.L = paramLong;
    this.N = paramInt1;
    int i1 = paramInt1;
    if (paramInt1 != i2) {
      i1 = paramInt1 + 1;
    }
    MqqHandler localMqqHandler = a(this.B);
    if (localMqqHandler != null)
    {
      Message localMessage = localMqqHandler.obtainMessage(1134066);
      Object localObject2;
      if (paramInt2 == 1)
      {
        localObject1 = BaseApplication.getContext().getString(2131887488);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(i);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else if (paramInt2 == 3)
      {
        localObject1 = BaseApplication.getContext().getResources().getString(2131887490);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(i);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject1 = BaseApplication.getContext().getResources().getString(2131887490);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(i);
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
      MsgBackupTransportProcessor.a().a(this.K);
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
      ((StringBuilder)localObject).append(this.N);
      ((StringBuilder)localObject).append(", sessionCount = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "gotoSpecialPage------------------");
      }
      i1 = this.M;
      i2 = this.N;
      if (i1 == i2)
      {
        MsgBackupCompleteFragment.g(paramContext, i1, i2);
        return;
      }
      MsgBackupPcBaseFragment.a(paramContext, paramInt);
      return;
    }
    if (paramInt == 3)
    {
      localObject = new Intent();
      if (this.M == this.N)
      {
        if (MsgBackupTransportProcessor.a().i() == 2)
        {
          MsgBackupCompleteFragment.b(paramContext, this.M, this.N);
          return;
        }
        MsgBackupCompleteFragment.e(paramContext, this.M, this.N);
        return;
      }
      ((Intent)localObject).putExtra("param_start", 5);
      QPublicFragmentActivity.start(paramContext, (Intent)localObject, MsgBackupTransportFragment.class);
      return;
    }
    int i1 = this.M;
    int i2 = this.N;
    if (i1 == i2)
    {
      MsgBackupCompleteFragment.k(paramContext, i1, i2);
      return;
    }
    MsgBackupPcBaseFragment.a(paramContext, paramInt);
  }
  
  public void a(IMsgBackup0x210Reject paramIMsgBackup0x210Reject)
  {
    this.P = paramIMsgBackup0x210Reject;
  }
  
  public void a(IMsgBackupQueryCallback paramIMsgBackupQueryCallback)
  {
    this.Q = paramIMsgBackupQueryCallback;
  }
  
  public void a(IMsgBackupUICallback paramIMsgBackupUICallback)
  {
    this.y = paramIMsgBackupUICallback;
  }
  
  public void a(MsgBackupRequest paramMsgBackupRequest)
  {
    if (paramMsgBackupRequest == null) {
      return;
    }
    paramMsgBackupRequest.h = this;
    this.C.a(paramMsgBackupRequest, 10000);
  }
  
  public void a(MsgBackupRequest paramMsgBackupRequest, Object paramObject)
  {
    if (paramMsgBackupRequest.b == 0)
    {
      if ((paramObject != null) && ((paramObject instanceof MsgBackupSessionInfo)))
      {
        paramMsgBackupRequest = (MsgBackupSessionInfo)paramObject;
        paramObject = new File(MsgBackupUtil.a(paramMsgBackupRequest.a, MsgBackupUtil.b(paramMsgBackupRequest.b), paramMsgBackupRequest.c));
        if (!paramObject.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProgress, db prepared! file is not exist!");
          }
          return;
        }
        paramMsgBackupRequest.d = paramObject.length();
        this.j.put(MsgBackupUtil.b(paramMsgBackupRequest.a, MsgBackupUtil.b(paramMsgBackupRequest.b)), paramMsgBackupRequest);
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("onProgress, db prepared! result = 0, sessionInfo.uin = ");
          paramObject.append(paramMsgBackupRequest.a);
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, paramObject.toString());
        }
        d().i(257);
      }
    }
    else if (paramMsgBackupRequest.b == 2)
    {
      paramObject = this.y;
      if (paramObject != null) {
        paramObject.b(paramMsgBackupRequest.g + 1, paramMsgBackupRequest.f);
      }
    }
  }
  
  public void a(MsgBackupPushData paramMsgBackupPushData)
  {
    if (f)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProcessPush0x11b: now is phone to phone transfer, so please wait the transfer done!");
      }
      return;
    }
    if (paramMsgBackupPushData != null)
    {
      s = true;
      Intent localIntent = new Intent();
      int i1 = paramMsgBackupPushData.b();
      e().a(i1);
      paramMsgBackupPushData = paramMsgBackupPushData.a();
      e().a(paramMsgBackupPushData);
      localIntent.putExtra("0x11bpush_extra", paramMsgBackupPushData);
      localIntent.putExtra("BIZ_TYPE", i1);
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
      ((MsgBackupAuthHandler)this.B.getBusinessHandler(z)).c(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      i1 = 1;
    }
    else
    {
      this.J = null;
      this.B.addObserver(this.x);
      i1 = 3;
    }
    e().a(i1);
    this.G.a(this.I, paramBoolean);
  }
  
  public void b()
  {
    b = null;
    c = null;
    d = null;
    e.clear();
    g = 0;
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
    Object localObject = a(this.B);
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
  
  public void b(BaseQQAppInterface paramBaseQQAppInterface)
  {
    MsgBackupReporter.b();
    g();
    try
    {
      h();
      return;
    }
    finally {}
  }
  
  public void b(MsgBackupRequest paramMsgBackupRequest)
  {
    if (paramMsgBackupRequest == null) {
      return;
    }
    paramMsgBackupRequest.h = this;
    this.C.a(paramMsgBackupRequest, 10001);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "clearSessionData ->>>>>>>>>>");
    }
    i = 0;
    o = null;
    p = 0;
    this.j.clear();
    this.l.clear();
    this.m.clear();
    this.n.clear();
    this.q.clear();
    this.r.clear();
    s = false;
    this.J = null;
    l();
    u = false;
  }
  
  public void c(MsgBackupRequest paramMsgBackupRequest)
  {
    if (paramMsgBackupRequest == null) {
      return;
    }
    paramMsgBackupRequest.h = this;
    this.C.a(paramMsgBackupRequest, -1);
  }
  
  public MsgBackupTransportProcessor d()
  {
    if (this.G == null) {
      this.G = MsgBackupTransportProcessor.a();
    }
    return this.G;
  }
  
  public MsgBackupAuthProcessor e()
  {
    if (this.H == null) {
      this.H = MsgBackupAuthProcessor.a();
    }
    return this.H;
  }
  
  public void f()
  {
    this.h.clear();
  }
  
  public void g()
  {
    MsgBackupUtil.a("MsgBackup.BackupAndMigrateManager", "onDestory ......", new Object[0]);
    this.G.k();
    c();
    f = false;
    this.C.a();
    MsgBackupReporter.c();
    ThreadManager.getFileThreadHandler().post(new MsgBackupManager.1(this));
  }
  
  public void h()
  {
    this.C.b();
    w = false;
    A = null;
  }
  
  public void i() {}
  
  public void j()
  {
    ((MsgBackupAuthHandler)this.B.getBusinessHandler(z)).a();
  }
  
  public void k()
  {
    MsgBackupUtil.b("MsgBackup.BackupAndMigrateManager", "sFileMeta = %s", new Object[] { b });
    TextUtils.isEmpty(b);
    ((MsgBackupAuthHandler)this.B.getBusinessHandler(z)).b(b);
  }
  
  public void l()
  {
    this.B.removeObserver(this.x);
  }
  
  public MsgBackupGetQrRsp m()
  {
    return this.J;
  }
  
  public void n()
  {
    this.G.a(this.I);
  }
  
  public void o()
  {
    this.D.set(true);
    this.F = null;
    if (this.E == null) {
      this.E = new MsgBackupManager.3(this);
    }
    this.B.setInterceptKickListener(this.E);
  }
  
  public void p()
  {
    this.D.set(false);
    if (v())
    {
      this.B.kick(this.F);
      this.F = null;
    }
    this.B.setInterceptKickListener(null);
  }
  
  public int r()
  {
    return this.N;
  }
  
  public long s()
  {
    return this.L;
  }
  
  public void t()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupManager.5(this));
  }
  
  public void u() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupManager
 * JD-Core Version:    0.7.0.1
 */