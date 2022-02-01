package com.tencent.mobileqq.listentogether;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.aiosharemusic.AioShareMusicIPCMainClient;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.avgame.business.api.IAvGameManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleMainServer;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;
import com.tencent.mobileqq.listentogether.player.IPlayCallback;
import com.tencent.mobileqq.listentogether.player.IProgressChangeCallback;
import com.tencent.mobileqq.listentogether.player.IQQMusicPlayClient;
import com.tencent.mobileqq.listentogether.player.IStateChangeCallback;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayClient;
import com.tencent.mobileqq.listentogether.predownload.IListenTogetherResDownloader;
import com.tencent.mobileqq.listentogether.predownload.ListenTogetherResDownloader;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.profile.musicbox.ProfileMusicBoxController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherOperationHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class ListenTogetherManager
  implements Manager
{
  private IStateChangeCallback A = new ListenTogetherManager.3(this);
  private IProgressChangeCallback B = new ListenTogetherManager.4(this);
  private IPlayCallback C = new ListenTogetherManager.5(this);
  private TroopPushObserver D = new ListenTogetherManager.6(this);
  private TroopMngObserver E = new ListenTogetherManager.7(this);
  private FriendListObserver F = new ListenTogetherManager.8(this);
  private BroadcastReceiver G = new ListenTogetherManager.9(this);
  private Handler.Callback H = new ListenTogetherManager.10(this);
  private WeakReference<OnJoinListenTogetherCallback> I;
  private boolean J = false;
  private boolean K = false;
  private WeakReference<OnExistListenTogetherCallback> L;
  int a = -1;
  OnJoinListenTogetherCallback b;
  private QQAppInterface c;
  private Handler d;
  private volatile String e = "";
  private volatile String f = "";
  private volatile String g = "";
  private volatile boolean h;
  private volatile boolean i;
  private volatile boolean j = true;
  private Map<String, ListenTogetherSession> k;
  private LruCache<String, MusicInfo> l;
  private LruCache<String, String> m;
  private IListenTogetherResDownloader n;
  private IQQMusicPlayClient o;
  private LyricsController p;
  private ProfileMusicBoxController q;
  private ListenTogetherHeartBeatController r;
  private long s;
  private LruCache<String, Long> t;
  private LruCache<String, String> u;
  private ListenTogetherManager.ConnCallback v = new ListenTogetherManager.ConnCallback(this, null);
  private Runnable w = new ListenTogetherManager.1(this);
  private ListenTogetherManager.RunnableShowForKey x = new ListenTogetherManager.RunnableShowForKey(this, false);
  private ListenTogetherManager.RunnableShowForKey y = new ListenTogetherManager.RunnableShowForKey(this, true);
  private Runnable z = new ListenTogetherManager.2(this);
  
  public ListenTogetherManager(QQAppInterface paramQQAppInterface)
  {
    this.c = paramQQAppInterface;
    this.d = new Handler(ThreadManager.getSubThreadLooper(), this.H);
    this.k = new ConcurrentHashMap();
    this.m = new LruCache(5);
    this.l = new LruCache(100);
    this.t = new LruCache(100);
    this.u = new LruCache(100);
    this.p = new LyricsController(paramQQAppInterface);
    this.q = new ProfileMusicBoxController(paramQQAppInterface);
    this.r = new ListenTogetherHeartBeatController(paramQQAppInterface);
    this.n = new ListenTogetherResDownloader(paramQQAppInterface);
    this.o = new QQMusicPlayClient(BaseApplicationImpl.context, paramQQAppInterface);
    this.o.a(this.A);
    this.o.a(this.B);
    this.o.a(this.C);
    this.o.a(this.v);
    paramQQAppInterface.addObserver(this.E);
    paramQQAppInterface.addObserver(this.D);
    paramQQAppInterface.addObserver(this.F);
    BaseApplicationImpl.getContext().registerReceiver(this.G, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
  
  public static ListenTogetherManager a(QQAppInterface paramQQAppInterface)
  {
    return (ListenTogetherManager)paramQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(18, true, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    int i1 = 2;
    if (paramInt == 2)
    {
      ReportController.b(null, "dc00899", "c2c_AIO", "", "music_tab", "song_play", 0, 0, "", "", paramString3, paramString2);
      return;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).f(paramString1);
    paramInt = i1;
    if (localTroopInfo != null)
    {
      paramInt = i1;
      if ((localTroopInfo.dwAdditionalFlag & 1L) == 1L) {
        paramInt = 0;
      }
      if ((localTroopInfo.dwCmdUinUinFlag & 1L) == 1L) {
        paramInt = 1;
      }
    }
    ReportController.b(null, "dc00899", "Grp_AIO", "", "music_tab", "song_play", 0, 0, paramString1, String.valueOf(paramInt), paramString3, paramString2);
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyLyricModuleSwitchChange, type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" uin: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" open:");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" userAction: ");
    localStringBuilder.append(paramBoolean2);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(11, true, new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  private void a(BaseActivity paramBaseActivity, String paramString)
  {
    QQToast.makeText(paramBaseActivity, 1, paramString, 0).show(paramBaseActivity.getTitleBarHeight());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if ((paramQQAppInterface != null) && (paramSessionInfo != null) && (paramSessionInfo.a == 1))
    {
      paramQQAppInterface.c(1, paramSessionInfo.b, paramInt);
      return;
    }
    if ((paramQQAppInterface != null) && (paramSessionInfo != null) && (paramSessionInfo.a == 0)) {
      paramQQAppInterface.c(2, paramSessionInfo.b, paramInt);
    }
  }
  
  private void a(ListenTogetherSession paramListenTogetherSession, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyUIModuleJoinListenTogetherFail session: ");
    localStringBuilder.append(paramListenTogetherSession);
    localStringBuilder.append(" listenTogetherClosed:");
    localStringBuilder.append(paramBoolean);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(5, true, new Object[] { Integer.valueOf(paramListenTogetherSession.m), paramListenTogetherSession.n, Boolean.valueOf(paramBoolean) });
  }
  
  private void a(ISong paramISong)
  {
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(13, true, new Object[] { paramISong });
  }
  
  private void a(String paramString, int paramInt)
  {
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(12, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(9, true, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ListenTogetherHandler localListenTogetherHandler = (ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
    int i1 = 0;
    localListenTogetherHandler.notifyUI(10, true, new Object[] { paramString1, paramString2, Boolean.valueOf(false) });
    paramString1 = new StringBuilder();
    paramString1.append("notifyMusicModuleLyric use cache lyric: ");
    if (paramString2 != null) {
      i1 = paramString2.length();
    }
    paramString1.append(i1);
    paramString1.append(" serverError");
    QLog.i("ListenTogether.Manager", 1, paramString1.toString());
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(15, true, new Object[] { Boolean.valueOf(paramBoolean), this.k.get(paramString) });
  }
  
  private void a(boolean paramBoolean, List<MusicInfo> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetMusicUrlFromServer success: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" musicList: ");
    ((StringBuilder)localObject).append(paramList);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if (!paramBoolean) {
      return;
    }
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      localObject = new ArrayList();
      int i1 = 0;
      int i2 = paramList.size();
      while (i1 < i2)
      {
        MusicInfo localMusicInfo = (MusicInfo)paramList.get(i1);
        if ((localMusicInfo != null) && (localMusicInfo.j()))
        {
          this.l.put(localMusicInfo.a, localMusicInfo);
          ((List)localObject).add(localMusicInfo);
        }
        i1 += 1;
      }
      if (!((List)localObject).isEmpty()) {
        this.n.a((List)localObject);
      }
    }
  }
  
  private boolean a(ListenTogetherSession paramListenTogetherSession)
  {
    if (paramListenTogetherSession.q == 2)
    {
      this.e = paramListenTogetherSession.f();
      this.f = this.e;
    }
    else if (this.e.equals(paramListenTogetherSession.f()))
    {
      this.e = "";
      return true;
    }
    return false;
  }
  
  private boolean a(ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    synchronized (this.k)
    {
      String str = paramListenTogetherSession.f();
      ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.k.get(str);
      if (localListenTogetherSession == null)
      {
        this.k.put(str, paramListenTogetherSession);
      }
      else
      {
        if (paramListenTogetherSession.t < localListenTogetherSession.t) {
          return false;
        }
        localListenTogetherSession.a(paramListenTogetherSession);
        paramListenTogetherSession = localListenTogetherSession;
      }
      if ((paramListenTogetherSession.p == 3) || (paramListenTogetherSession.q == 3)) {
        paramListenTogetherSession.b = false;
      }
      if (b(paramInt)) {
        paramListenTogetherSession.b = false;
      }
      return true;
    }
  }
  
  private void b(ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("notifyMusicModuleToRefresh session: ");
    ((StringBuilder)localObject1).append(paramListenTogetherSession);
    ((StringBuilder)localObject1).append(" manager destroy: ");
    ((StringBuilder)localObject1).append(this.i);
    ((StringBuilder)localObject1).append(" playFocused: ");
    ((StringBuilder)localObject1).append(this.j);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject1).toString());
    if (paramListenTogetherSession == null) {
      return;
    }
    this.d.removeMessages(1001);
    boolean bool;
    if (paramListenTogetherSession.q == 2)
    {
      if (paramListenTogetherSession.p == 1)
      {
        localObject1 = paramListenTogetherSession.e();
        if (localObject1 == null)
        {
          QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh startPlay musicInfo is null. return.");
          return;
        }
        if (this.i) {
          return;
        }
        if (!this.j) {
          return;
        }
        if ((a()) && (!this.c.isVideoChatting()))
        {
          if (this.c.isPttRecordingOrPlaying()) {
            return;
          }
          Object localObject2 = (IAvGameManager)this.c.getRuntimeService(IAvGameManager.class, "");
          if ((localObject2 != null) && (((IAvGameManager)localObject2).isAvGameRoomExist())) {
            return;
          }
          if (!q()) {
            return;
          }
          long l1 = ((MusicInfo)localObject1).h;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("sendRefreshPlayMsg seek: ");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append(" currentTime: ");
          ((StringBuilder)localObject2).append(System.currentTimeMillis());
          QLog.i("ListenTogether.Seek", 1, ((StringBuilder)localObject2).toString());
          if (l1 < 0L) {
            this.d.sendEmptyMessageDelayed(1001, -l1);
          } else {
            this.d.sendEmptyMessage(1001);
          }
          if ((paramInt != 1009) && (paramInt != 1021) && (paramInt != 1001) && (paramInt != 1023) && (paramInt != 1015) && (paramInt != 1014) && (paramInt != 1010)) {
            return;
          }
          a(paramListenTogetherSession.m, paramListenTogetherSession.n, ((MusicInfo)localObject1).a, ((MusicInfo)localObject1).b);
        }
      }
      else
      {
        if (paramListenTogetherSession.p == 2)
        {
          bool = this.o.a();
          paramListenTogetherSession = new StringBuilder();
          paramListenTogetherSession.append("notifyMusicModuleToRefresh pausePlay result: ");
          paramListenTogetherSession.append(bool);
          QLog.i("ListenTogether.Manager", 1, paramListenTogetherSession.toString());
          return;
        }
        if (paramListenTogetherSession.p == 3)
        {
          bool = this.o.c();
          paramListenTogetherSession = new StringBuilder();
          paramListenTogetherSession.append("notifyMusicModuleToRefresh stopPlay result: ");
          paramListenTogetherSession.append(bool);
          QLog.i("ListenTogether.Manager", 1, paramListenTogetherSession.toString());
          return;
        }
        if (paramListenTogetherSession.p == 4)
        {
          bool = this.o.c();
          paramListenTogetherSession = new StringBuilder();
          paramListenTogetherSession.append("notifyMusicModuleToRefresh stopPlay result: ");
          paramListenTogetherSession.append(bool);
          QLog.i("ListenTogether.Manager", 1, paramListenTogetherSession.toString());
        }
      }
    }
    else
    {
      bool = this.o.c();
      paramListenTogetherSession = new StringBuilder();
      paramListenTogetherSession.append("notifyMusicModuleToRefresh stopPlay result: ");
      paramListenTogetherSession.append(bool);
      QLog.i("ListenTogether.Manager", 1, paramListenTogetherSession.toString());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.e)) {
      return;
    }
    Object localObject1 = (ListenTogetherSession)this.k.get(this.e);
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((ListenTogetherSession)localObject1).e();
    if (localObject1 == null) {
      return;
    }
    String str1 = (String)this.m.get(((MusicInfo)localObject1).a);
    Object localObject2 = (ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
    String str2 = ((MusicInfo)localObject1).a;
    int i1 = 0;
    ((ListenTogetherHandler)localObject2).notifyUI(10, true, new Object[] { str2, str1, Boolean.valueOf(paramBoolean) });
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("notifyMusicModuleLyric lyric: ");
    if (str1 != null) {
      i1 = str1.length();
    }
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append(" serverError: ");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(" songid: ");
    ((StringBuilder)localObject2).append(((MusicInfo)localObject1).a);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject2).toString());
  }
  
  private void b(boolean paramBoolean, List<MusicInfo> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetLyricFromServer success: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" musicList: ");
    ((StringBuilder)localObject).append(paramList);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if (!paramBoolean)
    {
      b(true);
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = (MusicInfo)paramList.get(0);
      if (localObject == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      if (!TextUtils.isEmpty(((MusicInfo)localObject).f))
      {
        this.m.put(((MusicInfo)paramList.get(0)).a, ((MusicInfo)localObject).f);
        localHashMap.put("has_lyric", "1");
      }
      else
      {
        localHashMap.put("has_lyric", "0");
      }
      b(false);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "listen_together_lyric", true, 0L, 0L, localHashMap, "");
      return;
    }
    b(true);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 1009) || (paramInt == 1021) || (paramInt == 1023);
  }
  
  private boolean b(ListenTogetherSession paramListenTogetherSession)
  {
    int i1 = paramListenTogetherSession.m;
    boolean bool = false;
    if (i1 == 2)
    {
      MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = MutualMarkDataCenter.a(this.c, paramListenTogetherSession.n, 28L, true);
      if (localMutualMarkForDisplayInfo == null) {
        i1 = 0;
      } else {
        i1 = (int)localMutualMarkForDisplayInfo.b;
      }
      if (paramListenTogetherSession.k != i1)
      {
        paramListenTogetherSession.k = i1;
        bool = true;
      }
      else
      {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogether.Manager", 2, String.format("updateMutualLevel sessionType=%d uin=%s level=%d changed=%b", new Object[] { Integer.valueOf(paramListenTogetherSession.m), paramListenTogetherSession.n, Integer.valueOf(i1), Boolean.valueOf(bool) }));
      }
    }
    return bool;
  }
  
  private boolean b(MusicInfo paramMusicInfo)
  {
    boolean bool = false;
    if (paramMusicInfo == null) {
      return false;
    }
    if (SystemClock.elapsedRealtime() - paramMusicInfo.i < 180000L) {
      bool = true;
    }
    return bool;
  }
  
  private void c(ListenTogetherSession paramListenTogetherSession)
  {
    if ((paramListenTogetherSession != null) && (paramListenTogetherSession.a != null))
    {
      if (paramListenTogetherSession.a.isEmpty()) {
        return;
      }
      if (paramListenTogetherSession.p == 1)
      {
        if (paramListenTogetherSession.q != 2) {
          return;
        }
        int i2 = paramListenTogetherSession.a.size();
        ArrayList localArrayList = new ArrayList(i2);
        int i1 = 0;
        while (i1 < i2)
        {
          MusicInfo localMusicInfo = (MusicInfo)paramListenTogetherSession.a.get(i1);
          if (localMusicInfo != null)
          {
            if (localMusicInfo.j()) {
              this.l.put(localMusicInfo.a, localMusicInfo);
            }
            boolean bool;
            if ((b((MusicInfo)this.l.get(localMusicInfo.a))) && (localMusicInfo.j())) {
              bool = false;
            } else {
              bool = true;
            }
            if (bool) {
              localArrayList.add(new MusicExtendedReqParam(localMusicInfo.a, bool, false));
            }
          }
          i1 += 1;
        }
        if (!localArrayList.isEmpty()) {
          ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).a(paramListenTogetherSession.m, paramListenTogetherSession.n, localArrayList, false);
        }
      }
    }
  }
  
  private boolean c(int paramInt)
  {
    return (b(paramInt)) || (paramInt == 1000) || (paramInt == 1013) || (paramInt == 1018);
  }
  
  private void d(int paramInt)
  {
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.k.get(this.e);
    if (localListenTogetherSession != null) {
      j(localListenTogetherSession.m, localListenTogetherSession.n, paramInt);
    }
  }
  
  private void d(ListenTogetherSession paramListenTogetherSession)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyUIModuleToInitOrUpdate session: ");
    localStringBuilder.append(paramListenTogetherSession);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    if (paramListenTogetherSession == null) {
      return;
    }
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(4, true, new Object[] { paramListenTogetherSession });
  }
  
  private void d(String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new MusicExtendedReqParam(paramString, false, true));
    paramString = (ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.k.get(this.f);
    if (localListenTogetherSession == null) {
      return;
    }
    paramString.a(localListenTogetherSession.m, localListenTogetherSession.n, localArrayList, true);
  }
  
  private String e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1002: 
      return "JOIN_SESSION_BY_JOIN_AND_ENTER";
    case 1001: 
      return "JOIN_SESSION_BY_WEB";
    }
    return "JOIN_SESSION_BY_MUSIC_PANEL";
  }
  
  private void e(ListenTogetherSession paramListenTogetherSession)
  {
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(19, true, new Object[] { Integer.valueOf(paramListenTogetherSession.m), paramListenTogetherSession.n });
  }
  
  private String f(int paramInt)
  {
    switch (paramInt)
    {
    case 1022: 
    default: 
      return "";
    case 1023: 
      return "client_open_n_join";
    case 1021: 
      return "join_enter";
    case 1020: 
      return "change_playmode";
    case 1019: 
      return "cut_song";
    case 1018: 
      return "musicbox_resume";
    case 1017: 
      return "relation_finish";
    case 1016: 
      return "exit";
    case 1015: 
      return "push_auto_cute";
    case 1014: 
      return "push_cute";
    case 1013: 
      return "js_api_end_try_song";
    case 1012: 
      return "push_close";
    case 1011: 
      return "js_api_close";
    case 1010: 
      return "js_api_cute";
    case 1009: 
      return "js_api_open";
    case 1008: 
      return "net_connected";
    case 1007: 
      return "finish";
    case 1006: 
      return "resume";
    case 1005: 
      return "pause";
    case 1004: 
      return "audio_release";
    case 1003: 
      return "push";
    case 1002: 
      return "js_api";
    case 1001: 
      return "join";
    }
    return "enter_aio";
  }
  
  private String g(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 11)
            {
              if (paramInt != 12)
              {
                if (paramInt != 31)
                {
                  if (paramInt != 32)
                  {
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        return "";
                      case 24: 
                        return "clear";
                      case 23: 
                        return "sort";
                      case 22: 
                        return "delete";
                      }
                      return "add";
                    case 16: 
                      return "change_playmode";
                    case 15: 
                      return "pause";
                    }
                    return "auto_cut";
                  }
                  return "quit";
                }
                return "join";
              }
              return "cut";
            }
            return "play";
          }
          return "auto_stop";
        }
        return "auto_start";
      }
      return "stop";
    }
    return "start";
  }
  
  private boolean g(int paramInt1, String paramString, int paramInt2)
  {
    i(paramInt1, paramString, paramInt2);
    if (paramInt1 == 2) {}
    do
    {
      do
      {
        return true;
        if (paramInt1 != 1) {
          break;
        }
        paramString = ListenTogetherUtils.a(paramInt1, paramString);
        paramString = (ListenTogetherSession)this.k.get(paramString);
        if (paramString == null) {
          break;
        }
      } while (TextUtils.equals(paramString.r, this.c.getCurrentUin()));
      paramString = ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.c.getCurrentUin());
    } while ((paramString != null) && (paramString.isAdmin()));
    return false;
  }
  
  private void h(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyUIModulePauseListenTogetherFail type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(paramString);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(6, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void h(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSessionStatus type:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" status:");
      localStringBuilder.append(paramInt2);
      QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    }
    paramString = ListenTogetherUtils.a(paramInt1, paramString);
    if ((this.k.containsKey(paramString)) && (this.k.get(paramString) != null))
    {
      ((ListenTogetherSession)this.k.get(paramString)).p = paramInt2;
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogether.Manager", 1, "updateSessionStatus in ");
      }
    }
  }
  
  private void i(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyUIModuleResumeListenTogetherFail type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(paramString);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(7, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void i(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSessionPlayMode type:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" playMode:");
      localStringBuilder.append(paramInt2);
      QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    }
    if ((paramInt2 <= 3) && (paramInt2 >= 1))
    {
      paramString = ListenTogetherUtils.a(paramInt1, paramString);
      paramString = (ListenTogetherSession)this.k.get(paramString);
      if ((paramString != null) && (paramString.j != paramInt2))
      {
        paramString.j = paramInt2;
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogether.Manager", 1, "updateSessionPlayMode in ");
        }
        d(paramString);
      }
    }
  }
  
  private void j(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyUIModuleCutListenTogetherFail type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(paramString);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(20, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void j(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshListenTogetherStatus, type: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" uin: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" by:");
    ((StringBuilder)localObject).append(f(paramInt2));
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    localObject = ListenTogetherUtils.a(paramInt1, paramString);
    if ((!((String)localObject).equals(this.e)) && (!((String)localObject).equals(this.g)))
    {
      paramString = new StringBuilder();
      paramString.append("refreshListenTogetherStatus, currentSessionKey: ");
      paramString.append(this.e);
      paramString.append(" currentAio: ");
      paramString.append(this.g);
      paramString.append(" not equal return.");
      QLog.i("ListenTogether.Manager", 1, paramString.toString());
      return;
    }
    ((TogetherOperationHandler)this.c.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).a(1, paramInt1, paramString, paramInt2);
  }
  
  private void k(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyUIModuleChangePlayModeListenTogetherFail type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(paramString);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(21, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void l(int paramInt, String paramString)
  {
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(22, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private int n()
  {
    if (this.h) {
      return 800;
    }
    return 100;
  }
  
  private void o()
  {
    this.d.postDelayed(this.w, 8000L);
  }
  
  private void p()
  {
    if (TextUtils.isEmpty(this.e)) {
      return;
    }
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.k.get(this.e);
    if (localListenTogetherSession == null) {
      return;
    }
    j(localListenTogetherSession.m, localListenTogetherSession.n, 1008);
  }
  
  private boolean q()
  {
    if (!this.o.d())
    {
      long l1 = SystemClock.uptimeMillis();
      synchronized (this.v.a)
      {
        boolean bool = this.o.d();
        if (!bool) {
          try
          {
            this.o.e();
            this.v.a.wait(1500L);
          }
          catch (InterruptedException localInterruptedException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ListenTogether.Manager", 2, "doConnIfNeed InterruptedException==>", localInterruptedException);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogether.Manager", 2, String.format("doConnIfNeed %b cos=%d", new Object[] { Boolean.valueOf(this.o.d()), Long.valueOf(SystemClock.uptimeMillis() - l1) }));
        }
      }
    }
    return this.o.d();
  }
  
  private void r()
  {
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(16, true, null);
  }
  
  public String a(String paramString)
  {
    return (String)this.m.get(paramString);
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyWebCheckJoinResult retCode:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    }
    JSONObject localJSONObject;
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", "joinListen");
      ((JSONObject)localObject).put("retCode", paramInt);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyWebJoinListenResult error : ");
      localStringBuilder.append(localJSONException.getMessage());
      QLog.e("ListenTogether.Manager", 1, localStringBuilder.toString());
      localJSONObject = null;
    }
    if (localJSONObject != null) {
      ListenTogetherIPCModuleMainServer.a(localJSONObject);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPauseMusicPlay type: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" ,uin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    this.d.removeMessages(1001);
    boolean bool = this.o.a();
    localObject = (ListenTogetherSession)this.k.get(ListenTogetherUtils.a(paramInt, paramString));
    if (bool)
    {
      if (localObject != null) {
        ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).b(((ListenTogetherSession)localObject).m, ((ListenTogetherSession)localObject).n);
      }
    }
    else {
      h(paramInt, paramString);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.h = true;
    this.g = ListenTogetherUtils.a(paramInt1, paramString);
    boolean bool = c(paramInt1, paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEnterAio type: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" ,uin: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" open: ");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(" mLastEnterAIOId:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" aioId:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    this.a = paramInt2;
    localObject = this.p;
    if (localObject != null) {
      ((LyricsController)localObject).d(paramInt1, paramString);
    }
    if (!bool) {
      return;
    }
    if ((paramInt1 == 2) && (!((FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramString))) {
      return;
    }
    localObject = ListenTogetherUtils.a(paramInt1, paramString);
    d((ListenTogetherSession)this.k.get(localObject));
    j(paramInt1, paramString, 1000);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.t.put(paramString, Long.valueOf(paramLong));
  }
  
  public void a(int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetListenTogetherJoinedCountChangePush type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" uin: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" sep: ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" timeStamp: ");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" msg: ");
    localStringBuilder.append(paramString2);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    a(paramInt, paramString1, paramString2);
    paramString1 = (ListenTogetherSession)this.k.get(ListenTogetherUtils.a(paramInt, paramString1));
    if (paramString1 == null) {
      return;
    }
    paramString1.c = paramString2;
  }
  
  public void a(int paramInt1, String paramString1, long paramLong1, String paramString2, int paramInt2, long paramLong2, Object paramObject)
  {
    boolean bool3 = QLog.isColorLevel();
    boolean bool2 = false;
    int i1 = 0;
    if (bool3) {
      QLog.i("ListenTogether.Manager", 2, String.format("onGetListenTogetherPush type=%d seq=%d actionUin=%s pushType=%s data=%s ts=%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString2, g(paramInt2), paramObject, Long.valueOf(paramLong2) }));
    }
    if ((this.c.getCurrentAccountUin().equals(paramString2)) && (paramInt2 != 3) && (paramInt2 != 4) && (paramInt2 != 14))
    {
      if (paramInt2 == 1)
      {
        if (paramInt1 == 2) {
          ListenTogetherAIOStatusHelper.b(this.c, paramString1, true);
        } else if (paramInt1 == 1) {
          ListenTogetherAIOStatusHelper.a(this.c, paramString1, true);
        }
      }
      else if (paramInt2 == 2)
      {
        if (paramInt1 == 2) {
          ListenTogetherAIOStatusHelper.b(this.c, paramString1, false);
        } else if (paramInt1 == 1) {
          ListenTogetherAIOStatusHelper.a(this.c, paramString1, false);
        }
        h(paramInt1, paramString1, 3);
      }
      else if (paramInt2 == 32)
      {
        a(true, new ListenTogetherSession(paramInt1, paramString1), 2, false);
      }
      QLog.i("ListenTogether.Manager", 1, "onGetListenTogetherPush action uin == current uin return.");
      return;
    }
    a(paramInt1, paramString1, paramLong2);
    if (paramInt2 == 14)
    {
      this.d.removeCallbacks(this.w);
    }
    else if ((paramInt2 != 1) && (paramInt2 != 3))
    {
      if ((paramInt2 != 2) && (paramInt2 != 4))
      {
        if (paramInt2 == 16)
        {
          if ((paramObject instanceof Integer)) {
            i1 = ((Integer)paramObject).intValue();
          }
          bool1 = g(paramInt1, paramString1, i1) | true;
          break label438;
        }
        if (paramInt2 == 31)
        {
          bool1 = bool2;
          break label438;
        }
      }
      else
      {
        if (paramInt1 == 2) {
          ListenTogetherAIOStatusHelper.b(this.c, paramString1, false);
        } else if (paramInt1 == 1) {
          ListenTogetherAIOStatusHelper.a(this.c, paramString1, false);
        }
        h(paramInt1, paramString1, 3);
        a(paramInt1, paramString1, "closeListen", 0);
      }
    }
    else
    {
      if (paramInt1 == 2) {
        ListenTogetherAIOStatusHelper.b(this.c, paramString1, true);
      } else if (paramInt1 == 1) {
        ListenTogetherAIOStatusHelper.a(this.c, paramString1, true);
      }
      a(paramInt1, paramString1, "openListen", 0);
    }
    boolean bool1 = true;
    label438:
    if (bool1)
    {
      int i2 = 1003;
      if (paramInt2 == 2) {
        i2 = 1012;
      } else if (paramInt2 == 12) {
        i2 = 1014;
      } else if (paramInt2 == 14) {
        i2 = 1015;
      } else if (paramInt2 == 16) {
        i2 = 1020;
      }
      j(paramInt1, paramString1, i2);
    }
  }
  
  public void a(int paramInt, String paramString, OnExistListenTogetherCallback paramOnExistListenTogetherCallback)
  {
    this.L = new WeakReference(paramOnExistListenTogetherCallback);
    paramOnExistListenTogetherCallback = ListenTogetherUtils.a(paramInt, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkAndExitListenTogether type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ,uin: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" key:");
    localStringBuilder.append(paramOnExistListenTogetherCallback);
    localStringBuilder.append("  currentSessionKey:");
    localStringBuilder.append(this.e);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    paramOnExistListenTogetherCallback = (ListenTogetherSession)this.k.get(paramOnExistListenTogetherCallback);
    if (paramOnExistListenTogetherCallback == null)
    {
      d();
      return;
    }
    boolean bool = TextUtils.equals(paramOnExistListenTogetherCallback.r, this.c.getCurrentUin());
    if (paramOnExistListenTogetherCallback.m == 2) {}
    do
    {
      do
      {
        paramInt = 1;
        break label208;
        if (paramOnExistListenTogetherCallback.m != 1) {
          break;
        }
      } while (bool);
      paramString = ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).g(paramString);
    } while ((paramString != null) && (paramString.isAdmin()));
    paramInt = 0;
    label208:
    if (paramInt != 0)
    {
      paramString = new Intent();
      paramString.putExtra("type", 3);
      paramString.putExtra("uinType", paramOnExistListenTogetherCallback.m);
      paramString.putExtra("public_fragment_window_feature", 1);
      paramString.setFlags(268435456);
      PublicFragmentActivity.Launcher.a(BaseApplicationImpl.getContext(), paramString, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
      return;
    }
    a(false);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("musicSongStateChange uinType:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" changeType:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" opValue:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", paramString2);
      ((JSONObject)localObject).put("uin", paramString1);
      ((JSONObject)localObject).put("uinType", paramInt1);
      ((JSONObject)localObject).put("value", paramInt2);
      paramString1 = (String)localObject;
    }
    catch (JSONException paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("musicSongStateChange error : ");
      paramString2.append(paramString1.getMessage());
      QLog.e("ListenTogether.Manager", 1, paramString2.toString());
      paramString1 = null;
    }
    if (paramString1 != null) {
      ListenTogetherIPCModuleMainServer.a(paramString1);
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onExitListenTogether type: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" ,uin: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("bForceStop");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if ((paramInt != 1) && (paramInt != 2)) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    localObject = (ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
    if (paramBoolean)
    {
      ((ListenTogetherHandler)localObject).d(paramInt, paramString);
      return;
    }
    ((ListenTogetherHandler)localObject).c(paramInt, paramString);
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyWebCheckJoinResult uinTypeForOpener:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" isOpener:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" canJoin:");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("type", "checkJoin");
        ((JSONObject)localObject).put("canJoin", paramInt1);
        if (!paramBoolean) {
          break label195;
        }
        paramInt1 = 1;
        ((JSONObject)localObject).put("isOpener", paramInt1);
        ((JSONObject)localObject).put("uinType", paramInt2);
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyWebCheckJoinResult error : ");
        localStringBuilder.append(localJSONException.getMessage());
        QLog.e("ListenTogether.Manager", 1, localStringBuilder.toString());
        localJSONObject = null;
      }
      if (localJSONObject != null) {
        ListenTogetherIPCModuleMainServer.a(localJSONObject);
      }
      return;
      label195:
      paramInt1 = 0;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    String str = ListenTogetherUtils.a(paramInt, paramString);
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.k.get(str);
    int i1 = 0;
    if (localListenTogetherSession != null) {
      str = localListenTogetherSession.toString();
    } else {
      str = "null";
    }
    QLog.d("ListenTogether.Manager", 1, new Object[] { "joinTogetherAndEnter", " type=", Integer.valueOf(paramInt), " uin=", paramString, " session=", str });
    if ((localListenTogetherSession != null) && (localListenTogetherSession.p != 3))
    {
      if (localListenTogetherSession.q != 2)
      {
        this.b = new ListenTogetherManager.11(this, new WeakReference(paramBaseActivity), paramInt, paramString);
        a(this.c).a(paramBaseActivity, paramInt, paramString, this.b);
      }
      else
      {
        l(paramInt, paramString);
      }
    }
    else {
      a(paramBaseActivity, HardCodeUtil.a(2131891234));
    }
    if (paramInt == 2) {
      i1 = 1;
    }
    if (i1 != 0)
    {
      ReportController.b(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_musicark", 0, 0, paramString, "", "", "");
      return;
    }
    paramBaseActivity = new StringBuilder();
    paramBaseActivity.append("");
    paramBaseActivity.append(ListenTogetherUtils.a(this.c.getCurrentAccountUin(), paramString));
    ReportController.b(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_musicark", 0, 0, paramString, "", paramBaseActivity.toString(), "");
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt, String paramString, OnJoinListenTogetherCallback paramOnJoinListenTogetherCallback)
  {
    this.I = new WeakReference(paramOnJoinListenTogetherCallback);
    paramOnJoinListenTogetherCallback = new StringBuilder();
    paramOnJoinListenTogetherCallback.append("checkAndJoinListenTogether type: ");
    paramOnJoinListenTogetherCallback.append(paramInt);
    paramOnJoinListenTogetherCallback.append(" ,uin: ");
    paramOnJoinListenTogetherCallback.append(paramString);
    QLog.i("ListenTogether.Manager", 1, paramOnJoinListenTogetherCallback.toString());
    if ((a()) && (!this.c.isVideoChatting()) && (!this.c.isPttRecordingOrPlaying()))
    {
      ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.k.get(ListenTogetherUtils.a(paramInt, paramString));
      if ((localListenTogetherSession != null) && (!TextUtils.isEmpty(localListenTogetherSession.e)) && (!"0".equals(localListenTogetherSession.e)))
      {
        String str = HardCodeUtil.a(2131904124);
        paramOnJoinListenTogetherCallback = HardCodeUtil.a(2131904122);
        if (localListenTogetherSession.d == 1)
        {
          if (localListenTogetherSession.g) {
            paramOnJoinListenTogetherCallback = HardCodeUtil.a(2131904123);
          }
        }
        else {
          paramOnJoinListenTogetherCallback = HardCodeUtil.a(2131904117);
        }
        paramBaseActivity = DialogUtil.a(paramBaseActivity, 230);
        paramString = new ListenTogetherManager.12(this, paramInt, paramString);
        paramBaseActivity.setTitle(str);
        paramBaseActivity.setMessage(paramOnJoinListenTogetherCallback);
        paramBaseActivity.setOnDismissListener(new ListenTogetherManager.13(this));
        paramBaseActivity.setNegativeButton(HardCodeUtil.a(2131898212), paramString);
        paramBaseActivity.setPositiveButton(HardCodeUtil.a(2131899883), paramString);
        paramBaseActivity.setCanceledOnTouchOutside(false);
        paramBaseActivity.show();
        if ((paramInt == 1) && (!this.J))
        {
          this.J = true;
          paramBaseActivity = this.c;
          paramString = new StringBuilder();
          paramString.append("is_not_first_join_listen_together_");
          paramString.append(paramInt);
          ListenTogetherUtils.b(paramBaseActivity, paramString.toString(), true, false);
          return;
        }
        if ((paramInt == 2) && (!this.K))
        {
          this.K = true;
          paramBaseActivity = this.c;
          paramString = new StringBuilder();
          paramString.append("is_not_first_join_listen_together_");
          paramString.append(paramInt);
          ListenTogetherUtils.b(paramBaseActivity, paramString.toString(), true, false);
        }
      }
      else
      {
        b();
        a(paramBaseActivity, paramInt, paramString);
      }
      return;
    }
    a(paramBaseActivity, HardCodeUtil.a(2131904116));
    d((ListenTogetherSession)this.k.get(ListenTogetherUtils.a(paramInt, paramString)));
    c();
  }
  
  public void a(MusicInfo paramMusicInfo)
  {
    if (paramMusicInfo == null) {
      return;
    }
    try
    {
      Object localObject = c(paramMusicInfo.a);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = ((String)localObject).split("_");
      int i1 = Integer.parseInt(localObject[0]);
      localObject = localObject[1];
      ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).a(i1, (String)localObject, paramMusicInfo.a, paramMusicInfo.b, (String)paramMusicInfo.e.get(0), paramMusicInfo.d);
      return;
    }
    catch (Exception paramMusicInfo)
    {
      paramMusicInfo.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    this.u.put(paramString1, paramString2);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    String str1 = paramJSONObject.optString("type");
    String str2 = paramJSONObject.optString("uin");
    int i3 = paramJSONObject.optInt("uinType");
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("onMusicStateChangeJsApiCalled type: ");
    paramJSONObject.append(i3);
    paramJSONObject.append(" uin: ");
    paramJSONObject.append(str2);
    paramJSONObject.append(" apiType: ");
    paramJSONObject.append(str1);
    paramJSONObject = paramJSONObject.toString();
    int i1 = 1;
    QLog.i("ListenTogether.Manager", 1, paramJSONObject);
    if ("switchSong".equals(str1))
    {
      j(i3, str2, 1010);
      return;
    }
    if ("openListen".equals(str1))
    {
      if (i3 == 2) {
        ListenTogetherAIOStatusHelper.b(this.c, str2, true);
      } else if (i3 == 1) {
        ListenTogetherAIOStatusHelper.a(this.c, str2, true);
      }
      j(i3, str2, 1009);
      return;
    }
    boolean bool = "closeListen".equals(str1);
    int i2 = 0;
    if (bool)
    {
      if (i3 == 2) {
        ListenTogetherAIOStatusHelper.b(this.c, str2, false);
      } else if (i3 == 1) {
        ListenTogetherAIOStatusHelper.a(this.c, str2, false);
      }
      j(i3, str2, 1011);
      return;
    }
    if ("addSong".equals(str1))
    {
      j(i3, str2, 1002);
      return;
    }
    if ("deleteSong".equals(str1))
    {
      j(i3, str2, 1002);
      return;
    }
    if ("sortSong".equals(str1))
    {
      j(i3, str2, 1002);
      return;
    }
    if ("closeListenSelf".equals(str1))
    {
      a(i3, str2, false);
      return;
    }
    if ("showLyrics".equals(str1))
    {
      a(i3, str2, true, true);
      return;
    }
    if ("hideLyrics".equals(str1))
    {
      a(i3, str2, false, true);
      return;
    }
    if ("checkJoin".equals(str1))
    {
      if (e())
      {
        paramJSONObject = (ListenTogetherSession)this.k.get(this.e);
        if (paramJSONObject != null)
        {
          bool = TextUtils.equals(paramJSONObject.r, this.c.getCurrentUin());
          i1 = paramJSONObject.m;
        }
        else
        {
          bool = false;
        }
      }
      else
      {
        bool = false;
        i2 = 1;
      }
      a(i2, bool, i1);
      return;
    }
    if ("endTrySong".equals(str1))
    {
      if (SystemClock.elapsedRealtime() - this.s <= 180000L)
      {
        d(1013);
        return;
      }
      QLog.i("ListenTogether.Manager", 1, "endTrySong, > 3 min");
      return;
    }
    if ("joinListen".equals(str1))
    {
      ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).c(i3, str2, 1001);
      return;
    }
    if ("musicboxResume".equals(str1)) {
      d(1018);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.L;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (OnExistListenTogetherCallback)((WeakReference)localObject).get();
    }
    if (localObject != null) {
      ((OnExistListenTogetherCallback)localObject).a(paramBoolean);
    }
    this.L = null;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    paramString = (ListenTogetherSession)this.k.get(ListenTogetherUtils.a(paramInt, paramString));
    if (paramString != null) {
      paramString.b = paramBoolean;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChangePlayModeRespFromServer, success: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ,type: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ,uin: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", playMode: ");
    localStringBuilder.append(paramInt2);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    if (!paramBoolean)
    {
      k(paramInt1, paramString);
      return;
    }
    i(paramInt1, paramString, paramInt2);
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogether.Manager", 1, String.format("suc=%b type=%d uin=%s, err=%s from=%d id=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), MobileQQ.getShortUinStr(paramString1), paramString2, Integer.valueOf(paramInt2), paramString3 }));
    }
    if (paramBoolean)
    {
      if (paramInt1 == 2) {
        ListenTogetherAIOStatusHelper.b(this.c, paramString1, true);
      } else if (paramInt1 == 1) {
        ListenTogetherAIOStatusHelper.a(this.c, paramString1, true);
      }
      j(paramInt1, paramString1, 1023);
    }
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(23, paramBoolean, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), paramString3 });
  }
  
  public void a(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetListenTogetherSessionFromServer, success: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" ,session: ");
    ((StringBuilder)localObject).append(paramListenTogetherSession);
    ((StringBuilder)localObject).append(" ,by: ");
    ((StringBuilder)localObject).append(f(paramInt));
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if (paramListenTogetherSession == null) {
      return;
    }
    if (paramBoolean)
    {
      if (!a(paramListenTogetherSession, paramInt)) {
        return;
      }
      localObject = (ListenTogetherSession)this.k.get(paramListenTogetherSession.f());
      paramBoolean = a((ListenTogetherSession)localObject);
      b((ListenTogetherSession)localObject);
      d((ListenTogetherSession)localObject);
      a(((ListenTogetherSession)localObject).m, ((ListenTogetherSession)localObject).n, ((ListenTogetherSession)localObject).c);
      if ((this.e.equals(paramListenTogetherSession.f())) || (paramBoolean))
      {
        if (c(paramInt)) {
          this.j = true;
        }
        b((ListenTogetherSession)localObject, paramInt);
        c((ListenTogetherSession)localObject);
      }
      if (this.e.equals(paramListenTogetherSession.f()))
      {
        if (b(paramInt)) {
          this.p.h();
        }
        if ((paramInt == 1014) || (paramInt == 1015) || (paramInt == 1012) || (paramInt == 1003)) {
          a(paramListenTogetherSession.m, paramListenTogetherSession.n, "switchSong", 0);
        }
        if (paramInt == 1020) {
          a(paramListenTogetherSession.m, paramListenTogetherSession.n, "playModeChange", paramListenTogetherSession.j);
        }
        if (paramInt == 1021) {
          l(paramListenTogetherSession.m, paramListenTogetherSession.n);
        }
      }
      if (paramBoolean)
      {
        int i1 = paramListenTogetherSession.m;
        localObject = paramListenTogetherSession.n;
        ThreadManager.getUIHandler().post(new ListenTogetherManager.14(this, i1, (String)localObject));
        if (paramInt == 1012)
        {
          a(paramListenTogetherSession.m, paramListenTogetherSession.n, "closeListen", 0);
          return;
        }
        a(paramListenTogetherSession.m, paramListenTogetherSession.n, "comeoutSong", 0);
      }
    }
    else
    {
      d((ListenTogetherSession)this.k.get(paramListenTogetherSession.f()));
    }
  }
  
  public void a(boolean paramBoolean1, ListenTogetherSession paramListenTogetherSession, int paramInt, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetExitListenTogetherResponse isSuceess: ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(" byUser: ");
    ((StringBuilder)localObject).append(paramBoolean2);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if (paramListenTogetherSession == null) {
      return;
    }
    localObject = (ListenTogetherSession)this.k.get(paramListenTogetherSession.f());
    if (!paramBoolean1)
    {
      d((ListenTogetherSession)localObject);
      e((ListenTogetherSession)localObject);
      return;
    }
    if (paramListenTogetherSession.m == 2)
    {
      if (paramInt == 3) {
        ListenTogetherAIOStatusHelper.b(this.c, paramListenTogetherSession.n, false);
      }
    }
    else if (paramInt == 3) {
      ListenTogetherAIOStatusHelper.a(this.c, paramListenTogetherSession.n, false);
    }
    j(paramListenTogetherSession.m, paramListenTogetherSession.n, 1016);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleCheckAndShowAioShareMusic() isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AioShareMusicListenTogether.Manager", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      try
      {
        AioShareMusicIPCMainClient.a((JSONObject)paramObject, "checkAioShareMusic");
        return;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean1, List<MusicInfo> paramList, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      b(paramBoolean1, paramList);
      return;
    }
    a(paramBoolean1, paramList);
  }
  
  public void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("handleReportDownloadFailedAioShareMusic()  isSuccess = ");
      paramArrayOfObject.append(paramBoolean);
      QLog.d("AioShareMusicListenTogether.Manager", 2, paramArrayOfObject.toString());
    }
  }
  
  public boolean a()
  {
    String str = AVBizModuleFactory.getModuleByName("一起听歌").checkAVFocus();
    if (!"true".equals(str))
    {
      Object localObject = this.c.getApp().getBaseContext();
      QQToast.makeText((Context)localObject, String.format(((Context)localObject).getString(2131887170), new Object[] { str }), 1).show();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("preCheckIsUserGamePlaying, res[");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("]");
      QLog.e("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  public boolean a(Context paramContext, int paramInt, String paramString)
  {
    boolean bool;
    if (paramInt == 1)
    {
      if (!this.J)
      {
        paramContext = this.c;
        paramString = new StringBuilder();
        paramString.append("is_not_first_join_listen_together_");
        paramString.append(paramInt);
        this.J = ListenTogetherUtils.a(paramContext, paramString.toString(), false, false);
      }
      bool = this.J;
    }
    else
    {
      if (!this.K)
      {
        paramContext = this.c;
        paramString = new StringBuilder();
        paramString.append("is_not_first_join_listen_together_");
        paramString.append(paramInt);
        this.K = ListenTogetherUtils.a(paramContext, paramString.toString(), false, false);
      }
      bool = this.K;
    }
    if (!bool)
    {
      this.p.r = true;
      paramContext = new Intent();
      paramContext.putExtra("type", 4);
      paramContext.putExtra("uinType", paramInt);
      paramContext.putExtra("public_fragment_window_feature", 1);
      paramContext.setFlags(268435456);
      PublicFragmentActivity.Launcher.a(BaseApplicationImpl.getContext(), paramContext, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
      if (paramInt == 1) {
        this.J = true;
      } else {
        this.K = true;
      }
      paramContext = this.c;
      paramString = new StringBuilder();
      paramString.append("is_not_first_join_listen_together_");
      paramString.append(paramInt);
      ListenTogetherUtils.b(paramContext, paramString.toString(), true, false);
      return true;
    }
    return false;
  }
  
  public boolean a(BaseActivity paramBaseActivity, int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("joinListenTogether type: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ,uin: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ,by:");
    localStringBuilder.append(e(paramInt2));
    QLog.d("ListenTogether.Manager", 1, localStringBuilder.toString());
    if (!a()) {
      return false;
    }
    if ((!this.c.isVideoChatting()) && (!this.c.isPttRecordingOrPlaying()))
    {
      if (TogetherControlManager.a(this.c).a(paramBaseActivity, 1, paramString, paramInt1)) {
        return false;
      }
      ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).c(paramInt1, paramString, paramInt2);
      return true;
    }
    a(paramBaseActivity, HardCodeUtil.a(2131904118));
    d((ListenTogetherSession)this.k.get(ListenTogetherUtils.a(paramInt1, paramString)));
    return false;
  }
  
  public void b()
  {
    Object localObject = this.I;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (OnJoinListenTogetherCallback)((WeakReference)localObject).get();
    }
    if (localObject != null) {
      ((OnJoinListenTogetherCallback)localObject).a();
    }
    this.I = null;
  }
  
  public void b(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onResumeMusicPlay type: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" ,uin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    this.d.removeMessages(1001);
    boolean bool = this.o.b();
    localObject = (ListenTogetherSession)this.k.get(ListenTogetherUtils.a(paramInt, paramString));
    if (bool)
    {
      if (localObject != null) {
        ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).a(((ListenTogetherSession)localObject).m, ((ListenTogetherSession)localObject).n);
      }
    }
    else {
      i(paramInt, paramString);
    }
  }
  
  public void b(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onExitAio. mLastEnterAIOId:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" aioId:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if (this.a != paramInt2) {
      return;
    }
    this.h = false;
    localObject = this.p;
    if (localObject != null) {
      ((LyricsController)localObject).a(paramInt1, paramString, false);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyPlayChangeToAioShareMusic() newSong = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AioShareMusicListenTogether.Manager", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("current_song_id", paramString);
      AioShareMusicIPCMainClient.a((JSONObject)localObject, "updateSongIdToAioShareMusic");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).a(paramJSONObject);
  }
  
  public void b(boolean paramBoolean, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPauseRespFromServer, success: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ,type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ,uin: ");
    localStringBuilder.append(paramString);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    if (!paramBoolean) {
      h(paramInt, paramString);
    }
    a(paramInt, paramString, "pauseSong", 0);
    j(paramInt, paramString, 1005);
  }
  
  public void b(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetJoinListenTogetherResponse isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" by: ");
    ((StringBuilder)localObject).append(e(paramInt));
    localObject = ((StringBuilder)localObject).toString();
    int i2 = 1;
    QLog.i("ListenTogether.Manager", 1, (String)localObject);
    if (paramListenTogetherSession == null) {
      return;
    }
    localObject = (ListenTogetherSession)this.k.get(paramListenTogetherSession.f());
    int i1 = 1001;
    if (!paramBoolean)
    {
      d((ListenTogetherSession)localObject);
      if (paramInt != 1001)
      {
        a((ListenTogetherSession)localObject, false);
        return;
      }
      a(1);
      return;
    }
    switch (paramInt)
    {
    default: 
      i1 = -1;
      break;
    case 1002: 
      i1 = 1021;
      break;
    case 1001: 
      i1 = 1009;
    }
    j(paramListenTogetherSession.m, paramListenTogetherSession.n, i1);
    a(0);
    if (paramInt == 1002)
    {
      if (paramListenTogetherSession.m == 2) {
        paramInt = i2;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0)
      {
        ReportController.b(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_musicark_suc", 0, 0, paramListenTogetherSession.n, "", "", "");
        return;
      }
      localObject = paramListenTogetherSession.n;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ListenTogetherUtils.a(this.c.getCurrentAccountUin(), paramListenTogetherSession.n));
      ReportController.b(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_musicark_suc", 0, 0, (String)localObject, "", localStringBuilder.toString(), "");
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    for (;;)
    {
      int i1;
      String str;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("isSuccess", paramBoolean);
        if (paramBoolean)
        {
          paramObject = (Object[])paramObject;
          i1 = ((Integer)paramObject[0]).intValue();
          str = (String)paramObject[1];
          paramObject = (String)paramObject[2];
          j(i1, str, 1022);
          a(paramObject, str, i1);
          if (i1 != 2) {
            break label218;
          }
          paramObject = "c2c_AIO";
          break label222;
          ReportController.b(null, "dc00899", paramObject, "", "music_tab", "clk_share_suc", 0, 0, str, "", "", "");
        }
        else
        {
          paramObject = (Object[])paramObject;
          i1 = ((Integer)paramObject[0]).intValue();
          paramObject = (String)paramObject[1];
          localJSONObject.put("uint32_result", i1);
          localJSONObject.put("bytes_errmsg", paramObject);
        }
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleStartAioShareMusic() jsonObject = ");
          paramObject.append(localJSONObject.toString());
          QLog.d("AioShareMusicListenTogether.Manager", 2, paramObject.toString());
        }
        AioShareMusicIPCMainClient.a(localJSONObject, "startListenAioShareMusic");
        return;
      }
      catch (JSONException paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
      label218:
      paramObject = "Grp_AIO";
      label222:
      if (i1 == 2) {
        str = "";
      }
    }
  }
  
  public String c(String paramString)
  {
    return (String)this.u.get(paramString);
  }
  
  public void c()
  {
    Object localObject = this.I;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (OnJoinListenTogetherCallback)((WeakReference)localObject).get();
    }
    if (localObject != null) {
      ((OnJoinListenTogetherCallback)localObject).b();
    }
    this.I = null;
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onBackFromAIO. mLastEnterAIOId:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" aioId:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if (this.a != paramInt2) {
      return;
    }
    localObject = this.p;
    if ((localObject != null) && (((LyricsController)localObject).g()))
    {
      this.h = false;
      this.p.a(paramInt1, paramString, true);
    }
  }
  
  public void c(JSONObject paramJSONObject)
  {
    ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).b(paramJSONObject);
  }
  
  public void c(boolean paramBoolean, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResumeRespFromServer, success: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ,type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ,uin: ");
    localStringBuilder.append(paramString);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    if (!paramBoolean) {
      i(paramInt, paramString);
    }
    a(paramInt, paramString, "resumeSong", 0);
    j(paramInt, paramString, 1006);
  }
  
  public boolean c(int paramInt, String paramString)
  {
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (paramInt == 1)
    {
      localObject = ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).e(paramString);
      if (localObject != null)
      {
        bool1 = ((TroopInfo)localObject).isListenTogetherOpen();
      }
      else
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ListenTogether.switch", 2, "isListenTogetherOpen troopinfo is null");
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (paramInt == 2)
      {
        localObject = ((FriendsManager)this.c.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(paramString, false);
        if (localObject != null)
        {
          bool1 = ((ExtensionInfo)localObject).isListenTogetherOpen;
        }
        else
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("ListenTogether.switch", 2, "isListenTogetherOpen extensionInfo is null");
            bool1 = bool2;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isListenTogetherOpen, type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" res:");
      ((StringBuilder)localObject).append(bool1);
      QLog.d("ListenTogether.switch", 2, ((StringBuilder)localObject).toString());
    }
    return bool1;
  }
  
  public void d()
  {
    Object localObject = this.L;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (OnExistListenTogetherCallback)((WeakReference)localObject).get();
    }
    if (localObject != null) {
      ((OnExistListenTogetherCallback)localObject).a();
    }
    this.L = null;
  }
  
  public void d(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDestroyAIO. type: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" uin:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" mLastEnterAIOId:");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" aioId:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if (this.a != paramInt2) {
      return;
    }
    if (ListenTogetherUtils.a(paramInt1, paramString).equals(this.g)) {
      this.g = "";
    }
    localObject = this.p;
    if (localObject != null) {
      ((LyricsController)localObject).e(paramInt1, paramString);
    }
  }
  
  public void d(boolean paramBoolean, int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCutOperRespFromServer, success: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ,type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ,uin: ");
    localStringBuilder.append(paramString);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    if (!paramBoolean)
    {
      j(paramInt, paramString);
      return;
    }
    j(paramInt, paramString, 1019);
  }
  
  public boolean d(int paramInt, String paramString)
  {
    return this.e.equals(ListenTogetherUtils.a(paramInt, paramString));
  }
  
  public ListenTogetherSession e(int paramInt, String paramString)
  {
    return (ListenTogetherSession)this.k.get(ListenTogetherUtils.a(paramInt, paramString));
  }
  
  public void e(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCutSong type: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ,uin: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",cutType: ");
    localStringBuilder.append(paramInt2);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    this.d.removeMessages(1001);
    paramString = (ListenTogetherSession)this.k.get(ListenTogetherUtils.a(paramInt1, paramString));
    if (paramString != null) {
      ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).b(paramString.m, paramString.n, paramInt2);
    }
  }
  
  public boolean e()
  {
    QLog.d("ListenTogether.Manager", 1, String.format("isJoinSession [%s, %s]", new Object[] { this.g, this.e }));
    return TextUtils.isEmpty(this.e) ^ true;
  }
  
  public long f(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    paramString = (Long)this.t.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public MusicInfo f()
  {
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.k.get(this.f);
    if (localListenTogetherSession == null) {
      return null;
    }
    if (localListenTogetherSession.a != null)
    {
      if (localListenTogetherSession.a.isEmpty()) {
        return null;
      }
      return (MusicInfo)localListenTogetherSession.a.get(0);
    }
    return null;
  }
  
  public void f(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChangePlayMode type: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ,uin: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ,dstPlayMode: ");
    localStringBuilder.append(paramInt2);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    paramString = (ListenTogetherSession)this.k.get(ListenTogetherUtils.a(paramInt1, paramString));
    if (paramString != null) {
      ((ListenTogetherHandler)this.c.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).a(paramString.m, paramString.n, paramInt2);
    }
  }
  
  public ListenTogetherSession g()
  {
    return (ListenTogetherSession)this.k.get(this.f);
  }
  
  public boolean g(int paramInt, String paramString)
  {
    return this.p.c(paramInt, paramString);
  }
  
  public int h()
  {
    return this.o.f();
  }
  
  public boolean i()
  {
    int i1 = h();
    boolean bool = true;
    if (i1 != 2)
    {
      if (i1 == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public int j()
  {
    return this.o.g();
  }
  
  public LyricsController k()
  {
    return this.p;
  }
  
  public ProfileMusicBoxController l()
  {
    return this.q;
  }
  
  public void m()
  {
    this.s = 0L;
  }
  
  public void onDestroy()
  {
    QLog.i("ListenTogether.Manager", 1, "onDestroy");
    this.i = true;
    this.d.removeCallbacksAndMessages(null);
    this.o.c();
    this.n.a();
    this.p.e();
    this.q.e();
    this.r.c();
    this.c.removeObserver(this.E);
    this.c.removeObserver(this.D);
    this.c.removeObserver(this.F);
    BaseApplicationImpl.getContext().unregisterReceiver(this.G);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager
 * JD-Core Version:    0.7.0.1
 */