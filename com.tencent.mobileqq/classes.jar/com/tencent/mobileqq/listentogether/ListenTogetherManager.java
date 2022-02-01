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
  int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ListenTogetherManager.9(this);
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new ListenTogetherManager.10(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, MusicInfo> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ListenTogetherManager.8(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListenTogetherHeartBeatController jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController;
  private ListenTogetherManager.ConnCallback jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager$ConnCallback = new ListenTogetherManager.ConnCallback(this, null);
  private ListenTogetherManager.RunnableShowForKey jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager$RunnableShowForKey = new ListenTogetherManager.RunnableShowForKey(this, false);
  OnJoinListenTogetherCallback jdField_a_of_type_ComTencentMobileqqListentogetherOnJoinListenTogetherCallback;
  private LyricsController jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController;
  private IPlayCallback jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIPlayCallback = new ListenTogetherManager.5(this);
  private IProgressChangeCallback jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIProgressChangeCallback = new ListenTogetherManager.4(this);
  private IQQMusicPlayClient jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient;
  private IStateChangeCallback jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIStateChangeCallback = new ListenTogetherManager.3(this);
  private IListenTogetherResDownloader jdField_a_of_type_ComTencentMobileqqListentogetherPredownloadIListenTogetherResDownloader;
  private ProfileMusicBoxController jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController;
  private TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new ListenTogetherManager.7(this);
  private TroopPushObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver = new ListenTogetherManager.6(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new ListenTogetherManager.1(this);
  private volatile String jdField_a_of_type_JavaLangString = "";
  private Map<String, ListenTogetherSession> jdField_a_of_type_JavaUtilMap;
  private WeakReference<OnJoinListenTogetherCallback> jdField_a_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  private LruCache<String, String> jdField_b_of_type_AndroidSupportV4UtilLruCache;
  private ListenTogetherManager.RunnableShowForKey jdField_b_of_type_ComTencentMobileqqListentogetherListenTogetherManager$RunnableShowForKey = new ListenTogetherManager.RunnableShowForKey(this, true);
  private Runnable jdField_b_of_type_JavaLangRunnable = new ListenTogetherManager.2(this);
  private volatile String jdField_b_of_type_JavaLangString = "";
  private WeakReference<OnExistListenTogetherCallback> jdField_b_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_b_of_type_Boolean;
  private LruCache<String, Long> jdField_c_of_type_AndroidSupportV4UtilLruCache;
  private volatile String jdField_c_of_type_JavaLangString = "";
  private volatile boolean jdField_c_of_type_Boolean = true;
  private LruCache<String, String> jdField_d_of_type_AndroidSupportV4UtilLruCache;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  
  public ListenTogetherManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(5);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_c_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_d_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController = new LyricsController(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController = new ProfileMusicBoxController(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController = new ListenTogetherHeartBeatController(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPredownloadIListenTogetherResDownloader = new ListenTogetherResDownloader(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient = new QQMusicPlayClient(BaseApplicationImpl.context, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIStateChangeCallback);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIProgressChangeCallback);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIPlayCallback);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager$ConnCallback);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
  
  public static ListenTogetherManager a(QQAppInterface paramQQAppInterface)
  {
    return (ListenTogetherManager)paramQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER);
  }
  
  private String a(int paramInt)
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
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(18, true, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    int i = 2;
    if (paramInt == 2)
    {
      ReportController.b(null, "dc00899", "c2c_AIO", "", "music_tab", "song_play", 0, 0, "", "", paramString3, paramString2);
      return;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
    paramInt = i;
    if (localTroopInfo != null)
    {
      paramInt = i;
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
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(11, true, new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  private void a(BaseActivity paramBaseActivity, String paramString)
  {
    QQToast.a(paramBaseActivity, 1, paramString, 0).b(paramBaseActivity.getTitleBarHeight());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if ((paramQQAppInterface != null) && (paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_Int == 1))
    {
      paramQQAppInterface.c(1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramInt);
      return;
    }
    if ((paramQQAppInterface != null) && (paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_Int == 0)) {
      paramQQAppInterface.c(2, paramSessionInfo.jdField_a_of_type_JavaLangString, paramInt);
    }
  }
  
  private void a(ListenTogetherSession paramListenTogetherSession)
  {
    if ((paramListenTogetherSession != null) && (paramListenTogetherSession.jdField_a_of_type_JavaUtilList != null))
    {
      if (paramListenTogetherSession.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return;
      }
      if (paramListenTogetherSession.h == 1)
      {
        if (paramListenTogetherSession.i != 2) {
          return;
        }
        int j = paramListenTogetherSession.jdField_a_of_type_JavaUtilList.size();
        ArrayList localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          MusicInfo localMusicInfo = (MusicInfo)paramListenTogetherSession.jdField_a_of_type_JavaUtilList.get(i);
          if (localMusicInfo != null)
          {
            if (localMusicInfo.a()) {
              this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localMusicInfo.jdField_a_of_type_JavaLangString, localMusicInfo);
            }
            boolean bool;
            if ((a((MusicInfo)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localMusicInfo.jdField_a_of_type_JavaLangString))) && (localMusicInfo.a())) {
              bool = false;
            } else {
              bool = true;
            }
            if (bool) {
              localArrayList.add(new MusicExtendedReqParam(localMusicInfo.jdField_a_of_type_JavaLangString, bool, false));
            }
          }
          i += 1;
        }
        if (!localArrayList.isEmpty()) {
          ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).a(paramListenTogetherSession.jdField_f_of_type_Int, paramListenTogetherSession.e, localArrayList, false);
        }
      }
    }
  }
  
  private void a(ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("notifyMusicModuleToRefresh session: ");
    ((StringBuilder)localObject1).append(paramListenTogetherSession);
    ((StringBuilder)localObject1).append(" manager destroy: ");
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_Boolean);
    ((StringBuilder)localObject1).append(" playFocused: ");
    ((StringBuilder)localObject1).append(this.jdField_c_of_type_Boolean);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject1).toString());
    if (paramListenTogetherSession == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    boolean bool;
    if (paramListenTogetherSession.i == 2)
    {
      if (paramListenTogetherSession.h == 1)
      {
        localObject1 = paramListenTogetherSession.a();
        if (localObject1 == null)
        {
          QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh startPlay musicInfo is null. return.");
          return;
        }
        if (this.jdField_b_of_type_Boolean) {
          return;
        }
        if (!this.jdField_c_of_type_Boolean) {
          return;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isPttRecordingOrPlaying()) {
            return;
          }
          Object localObject2 = (IAvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IAvGameManager.class, "");
          if ((localObject2 != null) && (((IAvGameManager)localObject2).isAvGameRoomExist())) {
            return;
          }
          if (!c()) {
            return;
          }
          long l = ((MusicInfo)localObject1).jdField_a_of_type_Long;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("sendRefreshPlayMsg seek: ");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append(" currentTime: ");
          ((StringBuilder)localObject2).append(System.currentTimeMillis());
          QLog.i("ListenTogether.Seek", 1, ((StringBuilder)localObject2).toString());
          if (l < 0L) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, -l);
          } else {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
          }
          if ((paramInt != 1009) && (paramInt != 1021) && (paramInt != 1001) && (paramInt != 1023) && (paramInt != 1015) && (paramInt != 1014) && (paramInt != 1010)) {
            return;
          }
          a(paramListenTogetherSession.jdField_f_of_type_Int, paramListenTogetherSession.e, ((MusicInfo)localObject1).jdField_a_of_type_JavaLangString, ((MusicInfo)localObject1).jdField_b_of_type_JavaLangString);
        }
      }
      else
      {
        if (paramListenTogetherSession.h == 2)
        {
          bool = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.a();
          paramListenTogetherSession = new StringBuilder();
          paramListenTogetherSession.append("notifyMusicModuleToRefresh pausePlay result: ");
          paramListenTogetherSession.append(bool);
          QLog.i("ListenTogether.Manager", 1, paramListenTogetherSession.toString());
          return;
        }
        if (paramListenTogetherSession.h == 3)
        {
          bool = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.c();
          paramListenTogetherSession = new StringBuilder();
          paramListenTogetherSession.append("notifyMusicModuleToRefresh stopPlay result: ");
          paramListenTogetherSession.append(bool);
          QLog.i("ListenTogether.Manager", 1, paramListenTogetherSession.toString());
          return;
        }
        if (paramListenTogetherSession.h == 4)
        {
          bool = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.c();
          paramListenTogetherSession = new StringBuilder();
          paramListenTogetherSession.append("notifyMusicModuleToRefresh stopPlay result: ");
          paramListenTogetherSession.append(bool);
          QLog.i("ListenTogether.Manager", 1, paramListenTogetherSession.toString());
        }
      }
    }
    else
    {
      bool = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.c();
      paramListenTogetherSession = new StringBuilder();
      paramListenTogetherSession.append("notifyMusicModuleToRefresh stopPlay result: ");
      paramListenTogetherSession.append(bool);
      QLog.i("ListenTogether.Manager", 1, paramListenTogetherSession.toString());
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
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(5, true, new Object[] { Integer.valueOf(paramListenTogetherSession.jdField_f_of_type_Int), paramListenTogetherSession.e, Boolean.valueOf(paramBoolean) });
  }
  
  private void a(ISong paramISong)
  {
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(13, true, new Object[] { paramISong });
  }
  
  private void a(String paramString, int paramInt)
  {
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(12, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(9, true, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ListenTogetherHandler localListenTogetherHandler = (ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
    int i = 0;
    localListenTogetherHandler.notifyUI(10, true, new Object[] { paramString1, paramString2, Boolean.valueOf(false) });
    paramString1 = new StringBuilder();
    paramString1.append("notifyMusicModuleLyric use cache lyric: ");
    if (paramString2 != null) {
      i = paramString2.length();
    }
    paramString1.append(i);
    paramString1.append(" serverError");
    QLog.i("ListenTogether.Manager", 1, paramString1.toString());
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(15, true, new Object[] { Boolean.valueOf(paramBoolean), this.jdField_a_of_type_JavaUtilMap.get(paramString) });
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
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        MusicInfo localMusicInfo = (MusicInfo)paramList.get(i);
        if ((localMusicInfo != null) && (localMusicInfo.a()))
        {
          this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localMusicInfo.jdField_a_of_type_JavaLangString, localMusicInfo);
          ((List)localObject).add(localMusicInfo);
        }
        i += 1;
      }
      if (!((List)localObject).isEmpty()) {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherPredownloadIListenTogetherResDownloader.a((List)localObject);
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 1009) || (paramInt == 1021) || (paramInt == 1023);
  }
  
  private boolean a(int paramInt1, String paramString, int paramInt2)
  {
    h(paramInt1, paramString, paramInt2);
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
        paramString = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if (paramString == null) {
          break;
        }
      } while (TextUtils.equals(paramString.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()));
      paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    } while ((paramString != null) && (paramString.isAdmin()));
    return false;
  }
  
  private boolean a(ListenTogetherSession paramListenTogetherSession)
  {
    if (paramListenTogetherSession.i == 2)
    {
      this.jdField_a_of_type_JavaLangString = paramListenTogetherSession.b();
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    }
    else if (this.jdField_a_of_type_JavaLangString.equals(paramListenTogetherSession.b()))
    {
      this.jdField_a_of_type_JavaLangString = "";
      return true;
    }
    return false;
  }
  
  private boolean a(ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      String str = paramListenTogetherSession.b();
      ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(str);
      if (localListenTogetherSession == null)
      {
        this.jdField_a_of_type_JavaUtilMap.put(str, paramListenTogetherSession);
      }
      else
      {
        if (paramListenTogetherSession.jdField_c_of_type_Long < localListenTogetherSession.jdField_c_of_type_Long) {
          return false;
        }
        localListenTogetherSession.a(paramListenTogetherSession);
        paramListenTogetherSession = localListenTogetherSession;
      }
      if ((paramListenTogetherSession.h == 3) || (paramListenTogetherSession.i == 3)) {
        paramListenTogetherSession.jdField_a_of_type_Boolean = false;
      }
      if (a(paramInt)) {
        paramListenTogetherSession.jdField_a_of_type_Boolean = false;
      }
      return true;
    }
  }
  
  private boolean a(MusicInfo paramMusicInfo)
  {
    boolean bool = false;
    if (paramMusicInfo == null) {
      return false;
    }
    if (SystemClock.elapsedRealtime() - paramMusicInfo.jdField_b_of_type_Long < 180000L) {
      bool = true;
    }
    return bool;
  }
  
  private String b(int paramInt)
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
  
  private void b(int paramInt)
  {
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
    if (localListenTogetherSession != null) {
      i(localListenTogetherSession.jdField_f_of_type_Int, localListenTogetherSession.e, paramInt);
    }
  }
  
  private void b(ListenTogetherSession paramListenTogetherSession)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyUIModuleToInitOrUpdate session: ");
    localStringBuilder.append(paramListenTogetherSession);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    if (paramListenTogetherSession == null) {
      return;
    }
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(4, true, new Object[] { paramListenTogetherSession });
  }
  
  private void b(String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new MusicExtendedReqParam(paramString, false, true));
    paramString = (ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaLangString);
    if (localListenTogetherSession == null) {
      return;
    }
    paramString.a(localListenTogetherSession.jdField_f_of_type_Int, localListenTogetherSession.e, localArrayList, true);
  }
  
  private void b(boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    Object localObject1 = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((ListenTogetherSession)localObject1).a();
    if (localObject1 == null) {
      return;
    }
    String str1 = (String)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(((MusicInfo)localObject1).jdField_a_of_type_JavaLangString);
    Object localObject2 = (ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
    String str2 = ((MusicInfo)localObject1).jdField_a_of_type_JavaLangString;
    int i = 0;
    ((ListenTogetherHandler)localObject2).notifyUI(10, true, new Object[] { str2, str1, Boolean.valueOf(paramBoolean) });
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("notifyMusicModuleLyric lyric: ");
    if (str1 != null) {
      i = str1.length();
    }
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(" serverError: ");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(" songid: ");
    ((StringBuilder)localObject2).append(((MusicInfo)localObject1).jdField_a_of_type_JavaLangString);
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
      if (!TextUtils.isEmpty(((MusicInfo)localObject).d))
      {
        this.jdField_b_of_type_AndroidSupportV4UtilLruCache.put(((MusicInfo)paramList.get(0)).jdField_a_of_type_JavaLangString, ((MusicInfo)localObject).d);
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
    return (a(paramInt)) || (paramInt == 1000) || (paramInt == 1013) || (paramInt == 1018);
  }
  
  private boolean b(ListenTogetherSession paramListenTogetherSession)
  {
    int i = paramListenTogetherSession.jdField_f_of_type_Int;
    boolean bool = false;
    if (i == 2)
    {
      MutualMarkForDisplayInfo localMutualMarkForDisplayInfo = MutualMarkDataCenter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramListenTogetherSession.e, 28L, true);
      if (localMutualMarkForDisplayInfo == null) {
        i = 0;
      } else {
        i = (int)localMutualMarkForDisplayInfo.jdField_b_of_type_Long;
      }
      if (paramListenTogetherSession.d != i)
      {
        paramListenTogetherSession.d = i;
        bool = true;
      }
      else
      {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogether.Manager", 2, String.format("updateMutualLevel sessionType=%d uin=%s level=%d changed=%b", new Object[] { Integer.valueOf(paramListenTogetherSession.jdField_f_of_type_Int), paramListenTogetherSession.e, Integer.valueOf(i), Boolean.valueOf(bool) }));
      }
    }
    return bool;
  }
  
  private int c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 800;
    }
    return 100;
  }
  
  private String c(int paramInt)
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
  
  private void c(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyUIModulePauseListenTogetherFail type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(paramString);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(6, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void c(ListenTogetherSession paramListenTogetherSession)
  {
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(19, true, new Object[] { Integer.valueOf(paramListenTogetherSession.jdField_f_of_type_Int), paramListenTogetherSession.e });
  }
  
  private boolean c()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.d())
    {
      long l = SystemClock.uptimeMillis();
      synchronized (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager$ConnCallback.a)
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.d();
        if (!bool) {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.a();
            this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager$ConnCallback.a.wait(1500L);
          }
          catch (InterruptedException localInterruptedException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ListenTogether.Manager", 2, "doConnIfNeed InterruptedException==>", localInterruptedException);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogether.Manager", 2, String.format("doConnIfNeed %b cos=%d", new Object[] { Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.d()), Long.valueOf(SystemClock.uptimeMillis() - l) }));
        }
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.d();
  }
  
  private void d(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyUIModuleResumeListenTogetherFail type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(paramString);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(7, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 8000L);
  }
  
  private void e(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyUIModuleCutListenTogetherFail type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(paramString);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(20, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void f()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
    if (localListenTogetherSession == null) {
      return;
    }
    i(localListenTogetherSession.jdField_f_of_type_Int, localListenTogetherSession.e, 1008);
  }
  
  private void f(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyUIModuleChangePlayModeListenTogetherFail type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(paramString);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(21, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void g()
  {
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(16, true, null);
  }
  
  private void g(int paramInt, String paramString)
  {
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(22, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void g(int paramInt1, String paramString, int paramInt2)
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
    if ((this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilMap.get(paramString) != null))
    {
      ((ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramString)).h = paramInt2;
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogether.Manager", 1, "updateSessionStatus in ");
      }
    }
  }
  
  private void h(int paramInt1, String paramString, int paramInt2)
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
      paramString = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if ((paramString != null) && (paramString.jdField_c_of_type_Int != paramInt2))
      {
        paramString.jdField_c_of_type_Int = paramInt2;
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogether.Manager", 1, "updateSessionPlayMode in ");
        }
        b(paramString);
      }
    }
  }
  
  private void i(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshListenTogetherStatus, type: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" uin: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" by:");
    ((StringBuilder)localObject).append(b(paramInt2));
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    localObject = ListenTogetherUtils.a(paramInt1, paramString);
    if ((!((String)localObject).equals(this.jdField_a_of_type_JavaLangString)) && (!((String)localObject).equals(this.jdField_c_of_type_JavaLangString)))
    {
      paramString = new StringBuilder();
      paramString.append("refreshListenTogetherStatus, currentSessionKey: ");
      paramString.append(this.jdField_a_of_type_JavaLangString);
      paramString.append(" currentAio: ");
      paramString.append(this.jdField_c_of_type_JavaLangString);
      paramString.append(" not equal return.");
      QLog.i("ListenTogether.Manager", 1, paramString.toString());
      return;
    }
    ((TogetherOperationHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TOGETHER_OPERATOR_HANDLER)).a(1, paramInt1, paramString, paramInt2);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.a();
  }
  
  public long a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    paramString = (Long)this.jdField_c_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public ListenTogetherSession a()
  {
    return (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaLangString);
  }
  
  public ListenTogetherSession a(int paramInt, String paramString)
  {
    return (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(ListenTogetherUtils.a(paramInt, paramString));
  }
  
  public MusicInfo a()
  {
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaLangString);
    if (localListenTogetherSession == null) {
      return null;
    }
    if (localListenTogetherSession.jdField_a_of_type_JavaUtilList != null)
    {
      if (localListenTogetherSession.jdField_a_of_type_JavaUtilList.isEmpty()) {
        return null;
      }
      return (MusicInfo)localListenTogetherSession.jdField_a_of_type_JavaUtilList.get(0);
    }
    return null;
  }
  
  public LyricsController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController;
  }
  
  public ProfileMusicBoxController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (OnJoinListenTogetherCallback)((WeakReference)localObject).get();
    }
    if (localObject != null) {
      ((OnJoinListenTogetherCallback)localObject).a();
    }
    this.jdField_a_of_type_MqqUtilWeakReference = null;
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
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.a();
    localObject = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(ListenTogetherUtils.a(paramInt, paramString));
    if (bool)
    {
      if (localObject != null) {
        ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).b(((ListenTogetherSession)localObject).jdField_f_of_type_Int, ((ListenTogetherSession)localObject).e);
      }
    }
    else {
      c(paramInt, paramString);
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = ListenTogetherUtils.a(paramInt1, paramString);
    boolean bool = a(paramInt1, paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEnterAio type: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" ,uin: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" open: ");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(" mLastEnterAIOId:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(" aioId:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_Int = paramInt2;
    localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController;
    if (localObject != null) {
      ((LyricsController)localObject).c(paramInt1, paramString);
    }
    if (!bool) {
      return;
    }
    if ((paramInt1 == 2) && (!((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString))) {
      return;
    }
    localObject = ListenTogetherUtils.a(paramInt1, paramString);
    b((ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(localObject));
    i(paramInt1, paramString, 1000);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    this.jdField_c_of_type_AndroidSupportV4UtilLruCache.put(paramString, Long.valueOf(paramLong));
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
    paramString1 = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(ListenTogetherUtils.a(paramInt, paramString1));
    if (paramString1 == null) {
      return;
    }
    paramString1.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public void a(int paramInt1, String paramString1, long paramLong1, String paramString2, int paramInt2, long paramLong2, Object paramObject)
  {
    boolean bool3 = QLog.isColorLevel();
    boolean bool2 = false;
    int i = 0;
    if (bool3) {
      QLog.i("ListenTogether.Manager", 2, String.format("onGetListenTogetherPush type=%d seq=%d actionUin=%s pushType=%s data=%s ts=%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString2, c(paramInt2), paramObject, Long.valueOf(paramLong2) }));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString2)) && (paramInt2 != 3) && (paramInt2 != 4) && (paramInt2 != 14))
    {
      if (paramInt2 == 1)
      {
        if (paramInt1 == 2) {
          ListenTogetherAIOStatusHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
        } else if (paramInt1 == 1) {
          ListenTogetherAIOStatusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
        }
      }
      else if (paramInt2 == 2)
      {
        if (paramInt1 == 2) {
          ListenTogetherAIOStatusHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, false);
        } else if (paramInt1 == 1) {
          ListenTogetherAIOStatusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, false);
        }
        g(paramInt1, paramString1, 3);
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
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    else if ((paramInt2 != 1) && (paramInt2 != 3))
    {
      if ((paramInt2 != 2) && (paramInt2 != 4))
      {
        if (paramInt2 == 16)
        {
          if ((paramObject instanceof Integer)) {
            i = ((Integer)paramObject).intValue();
          }
          bool1 = a(paramInt1, paramString1, i) | true;
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
          ListenTogetherAIOStatusHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, false);
        } else if (paramInt1 == 1) {
          ListenTogetherAIOStatusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, false);
        }
        g(paramInt1, paramString1, 3);
        a(paramInt1, paramString1, "closeListen", 0);
      }
    }
    else
    {
      if (paramInt1 == 2) {
        ListenTogetherAIOStatusHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
      } else if (paramInt1 == 1) {
        ListenTogetherAIOStatusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
      }
      a(paramInt1, paramString1, "openListen", 0);
    }
    boolean bool1 = true;
    label438:
    if (bool1)
    {
      int j = 1003;
      if (paramInt2 == 2) {
        j = 1012;
      } else if (paramInt2 == 12) {
        j = 1014;
      } else if (paramInt2 == 14) {
        j = 1015;
      } else if (paramInt2 == 16) {
        j = 1020;
      }
      i(paramInt1, paramString1, j);
    }
  }
  
  public void a(int paramInt, String paramString, OnExistListenTogetherCallback paramOnExistListenTogetherCallback)
  {
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramOnExistListenTogetherCallback);
    paramOnExistListenTogetherCallback = ListenTogetherUtils.a(paramInt, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkAndExitListenTogether type: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ,uin: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" key:");
    localStringBuilder.append(paramOnExistListenTogetherCallback);
    localStringBuilder.append("  currentSessionKey:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.i("ListenTogether.Manager", 1, localStringBuilder.toString());
    paramOnExistListenTogetherCallback = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramOnExistListenTogetherCallback);
    if (paramOnExistListenTogetherCallback == null)
    {
      c();
      return;
    }
    boolean bool = TextUtils.equals(paramOnExistListenTogetherCallback.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    if (paramOnExistListenTogetherCallback.jdField_f_of_type_Int == 2) {}
    do
    {
      do
      {
        paramInt = 1;
        break label208;
        if (paramOnExistListenTogetherCallback.jdField_f_of_type_Int != 1) {
          break;
        }
      } while (bool);
      paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
    } while ((paramString != null) && (paramString.isAdmin()));
    paramInt = 0;
    label208:
    if (paramInt != 0)
    {
      paramString = new Intent();
      paramString.putExtra("type", 3);
      paramString.putExtra("uinType", paramOnExistListenTogetherCallback.jdField_f_of_type_Int);
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
    localObject = (ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
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
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(str);
    int i = 0;
    if (localListenTogetherSession != null) {
      str = localListenTogetherSession.toString();
    } else {
      str = "null";
    }
    QLog.d("ListenTogether.Manager", 1, new Object[] { "joinTogetherAndEnter", " type=", Integer.valueOf(paramInt), " uin=", paramString, " session=", str });
    if ((localListenTogetherSession != null) && (localListenTogetherSession.h != 3))
    {
      if (localListenTogetherSession.i != 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherOnJoinListenTogetherCallback = new ListenTogetherManager.11(this, new WeakReference(paramBaseActivity), paramInt, paramString);
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseActivity, paramInt, paramString, this.jdField_a_of_type_ComTencentMobileqqListentogetherOnJoinListenTogetherCallback);
      }
      else
      {
        g(paramInt, paramString);
      }
    }
    else {
      a(paramBaseActivity, HardCodeUtil.a(2131693659));
    }
    if (paramInt == 2) {
      i = 1;
    }
    if (i != 0)
    {
      ReportController.b(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_musicark", 0, 0, paramString, "", "", "");
      return;
    }
    paramBaseActivity = new StringBuilder();
    paramBaseActivity.append("");
    paramBaseActivity.append(ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString));
    ReportController.b(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_musicark", 0, 0, paramString, "", paramBaseActivity.toString(), "");
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt, String paramString, OnJoinListenTogetherCallback paramOnJoinListenTogetherCallback)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramOnJoinListenTogetherCallback);
    paramOnJoinListenTogetherCallback = new StringBuilder();
    paramOnJoinListenTogetherCallback.append("checkAndJoinListenTogether type: ");
    paramOnJoinListenTogetherCallback.append(paramInt);
    paramOnJoinListenTogetherCallback.append(" ,uin: ");
    paramOnJoinListenTogetherCallback.append(paramString);
    QLog.i("ListenTogether.Manager", 1, paramOnJoinListenTogetherCallback.toString());
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isPttRecordingOrPlaying()))
    {
      ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(ListenTogetherUtils.a(paramInt, paramString));
      if ((localListenTogetherSession != null) && (!TextUtils.isEmpty(localListenTogetherSession.jdField_b_of_type_JavaLangString)) && (!"0".equals(localListenTogetherSession.jdField_b_of_type_JavaLangString)))
      {
        String str = HardCodeUtil.a(2131706260);
        paramOnJoinListenTogetherCallback = HardCodeUtil.a(2131706258);
        if (localListenTogetherSession.jdField_a_of_type_Int == 1)
        {
          if (localListenTogetherSession.jdField_b_of_type_Boolean) {
            paramOnJoinListenTogetherCallback = HardCodeUtil.a(2131706259);
          }
        }
        else {
          paramOnJoinListenTogetherCallback = HardCodeUtil.a(2131706251);
        }
        paramBaseActivity = DialogUtil.a(paramBaseActivity, 230);
        paramString = new ListenTogetherManager.12(this, paramInt, paramString);
        paramBaseActivity.setTitle(str);
        paramBaseActivity.setMessage(paramOnJoinListenTogetherCallback);
        paramBaseActivity.setOnDismissListener(new ListenTogetherManager.13(this));
        paramBaseActivity.setNegativeButton(HardCodeUtil.a(2131706255), paramString);
        paramBaseActivity.setPositiveButton(HardCodeUtil.a(2131706253), paramString);
        paramBaseActivity.setCanceledOnTouchOutside(false);
        paramBaseActivity.show();
        if ((paramInt == 1) && (!this.jdField_d_of_type_Boolean))
        {
          this.jdField_d_of_type_Boolean = true;
          paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          paramString = new StringBuilder();
          paramString.append("is_not_first_join_listen_together_");
          paramString.append(paramInt);
          ListenTogetherUtils.a(paramBaseActivity, paramString.toString(), true, false);
          return;
        }
        if ((paramInt == 2) && (!this.e))
        {
          this.e = true;
          paramBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          paramString = new StringBuilder();
          paramString.append("is_not_first_join_listen_together_");
          paramString.append(paramInt);
          ListenTogetherUtils.a(paramBaseActivity, paramString.toString(), true, false);
        }
      }
      else
      {
        a();
        a(paramBaseActivity, paramInt, paramString);
      }
      return;
    }
    a(paramBaseActivity, HardCodeUtil.a(2131706250));
    b((ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(ListenTogetherUtils.a(paramInt, paramString)));
    b();
  }
  
  public void a(MusicInfo paramMusicInfo)
  {
    if (paramMusicInfo == null) {
      return;
    }
    try
    {
      Object localObject = b(paramMusicInfo.jdField_a_of_type_JavaLangString);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = ((String)localObject).split("_");
      int i = Integer.parseInt(localObject[0]);
      localObject = localObject[1];
      ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).a(i, (String)localObject, paramMusicInfo.jdField_a_of_type_JavaLangString, paramMusicInfo.jdField_b_of_type_JavaLangString, (String)paramMusicInfo.jdField_b_of_type_JavaUtilList.get(0), paramMusicInfo.jdField_a_of_type_JavaUtilList);
      return;
    }
    catch (Exception paramMusicInfo)
    {
      paramMusicInfo.printStackTrace();
    }
  }
  
  public void a(String paramString)
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
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    this.jdField_d_of_type_AndroidSupportV4UtilLruCache.put(paramString1, paramString2);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    String str1 = paramJSONObject.optString("type");
    String str2 = paramJSONObject.optString("uin");
    int k = paramJSONObject.optInt("uinType");
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("onMusicStateChangeJsApiCalled type: ");
    paramJSONObject.append(k);
    paramJSONObject.append(" uin: ");
    paramJSONObject.append(str2);
    paramJSONObject.append(" apiType: ");
    paramJSONObject.append(str1);
    paramJSONObject = paramJSONObject.toString();
    int i = 1;
    QLog.i("ListenTogether.Manager", 1, paramJSONObject);
    if ("switchSong".equals(str1))
    {
      i(k, str2, 1010);
      return;
    }
    if ("openListen".equals(str1))
    {
      if (k == 2) {
        ListenTogetherAIOStatusHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, true);
      } else if (k == 1) {
        ListenTogetherAIOStatusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, true);
      }
      i(k, str2, 1009);
      return;
    }
    boolean bool = "closeListen".equals(str1);
    int j = 0;
    if (bool)
    {
      if (k == 2) {
        ListenTogetherAIOStatusHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, false);
      } else if (k == 1) {
        ListenTogetherAIOStatusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, false);
      }
      i(k, str2, 1011);
      return;
    }
    if ("addSong".equals(str1))
    {
      i(k, str2, 1002);
      return;
    }
    if ("deleteSong".equals(str1))
    {
      i(k, str2, 1002);
      return;
    }
    if ("sortSong".equals(str1))
    {
      i(k, str2, 1002);
      return;
    }
    if ("closeListenSelf".equals(str1))
    {
      a(k, str2, false);
      return;
    }
    if ("showLyrics".equals(str1))
    {
      a(k, str2, true, true);
      return;
    }
    if ("hideLyrics".equals(str1))
    {
      a(k, str2, false, true);
      return;
    }
    if ("checkJoin".equals(str1))
    {
      if (a())
      {
        paramJSONObject = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
        if (paramJSONObject != null)
        {
          bool = TextUtils.equals(paramJSONObject.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
          i = paramJSONObject.jdField_f_of_type_Int;
        }
        else
        {
          bool = false;
        }
      }
      else
      {
        bool = false;
        j = 1;
      }
      a(j, bool, i);
      return;
    }
    if ("endTrySong".equals(str1))
    {
      if (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long <= 180000L)
      {
        b(1013);
        return;
      }
      QLog.i("ListenTogether.Manager", 1, "endTrySong, > 3 min");
      return;
    }
    if ("joinListen".equals(str1))
    {
      ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).c(k, str2, 1001);
      return;
    }
    if ("musicboxResume".equals(str1)) {
      b(1018);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_MqqUtilWeakReference;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (OnExistListenTogetherCallback)((WeakReference)localObject).get();
    }
    if (localObject != null) {
      ((OnExistListenTogetherCallback)localObject).a(paramBoolean);
    }
    this.jdField_b_of_type_MqqUtilWeakReference = null;
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    paramString = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(ListenTogetherUtils.a(paramInt, paramString));
    if (paramString != null) {
      paramString.jdField_a_of_type_Boolean = paramBoolean;
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
      f(paramInt1, paramString);
      return;
    }
    h(paramInt1, paramString, paramInt2);
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogether.Manager", 1, String.format("suc=%b type=%d uin=%s, err=%s from=%d id=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), MobileQQ.getShortUinStr(paramString1), paramString2, Integer.valueOf(paramInt2), paramString3 }));
    }
    if (paramBoolean)
    {
      if (paramInt1 == 2) {
        ListenTogetherAIOStatusHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
      } else if (paramInt1 == 1) {
        ListenTogetherAIOStatusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
      }
      i(paramInt1, paramString1, 1023);
    }
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(23, paramBoolean, new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), paramString3 });
  }
  
  public void a(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetListenTogetherSessionFromServer, success: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" ,session: ");
    ((StringBuilder)localObject).append(paramListenTogetherSession);
    ((StringBuilder)localObject).append(" ,by: ");
    ((StringBuilder)localObject).append(b(paramInt));
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if (paramListenTogetherSession == null) {
      return;
    }
    if (paramBoolean)
    {
      if (!a(paramListenTogetherSession, paramInt)) {
        return;
      }
      localObject = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramListenTogetherSession.b());
      paramBoolean = a((ListenTogetherSession)localObject);
      b((ListenTogetherSession)localObject);
      b((ListenTogetherSession)localObject);
      a(((ListenTogetherSession)localObject).jdField_f_of_type_Int, ((ListenTogetherSession)localObject).e, ((ListenTogetherSession)localObject).jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_JavaLangString.equals(paramListenTogetherSession.b())) || (paramBoolean))
      {
        if (b(paramInt)) {
          this.jdField_c_of_type_Boolean = true;
        }
        a((ListenTogetherSession)localObject, paramInt);
        a((ListenTogetherSession)localObject);
      }
      if (this.jdField_a_of_type_JavaLangString.equals(paramListenTogetherSession.b()))
      {
        if (a(paramInt)) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.g();
        }
        if ((paramInt == 1014) || (paramInt == 1015) || (paramInt == 1012) || (paramInt == 1003)) {
          a(paramListenTogetherSession.jdField_f_of_type_Int, paramListenTogetherSession.e, "switchSong", 0);
        }
        if (paramInt == 1020) {
          a(paramListenTogetherSession.jdField_f_of_type_Int, paramListenTogetherSession.e, "playModeChange", paramListenTogetherSession.jdField_c_of_type_Int);
        }
        if (paramInt == 1021) {
          g(paramListenTogetherSession.jdField_f_of_type_Int, paramListenTogetherSession.e);
        }
      }
      if (paramBoolean)
      {
        int i = paramListenTogetherSession.jdField_f_of_type_Int;
        localObject = paramListenTogetherSession.e;
        ThreadManager.getUIHandler().post(new ListenTogetherManager.14(this, i, (String)localObject));
        if (paramInt == 1012)
        {
          a(paramListenTogetherSession.jdField_f_of_type_Int, paramListenTogetherSession.e, "closeListen", 0);
          return;
        }
        a(paramListenTogetherSession.jdField_f_of_type_Int, paramListenTogetherSession.e, "comeoutSong", 0);
      }
    }
    else
    {
      b((ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramListenTogetherSession.b()));
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
    localObject = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramListenTogetherSession.b());
    if (!paramBoolean1)
    {
      b((ListenTogetherSession)localObject);
      c((ListenTogetherSession)localObject);
      return;
    }
    if (paramListenTogetherSession.jdField_f_of_type_Int == 2)
    {
      if (paramInt == 3) {
        ListenTogetherAIOStatusHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramListenTogetherSession.e, false);
      }
    }
    else if (paramInt == 3) {
      ListenTogetherAIOStatusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramListenTogetherSession.e, false);
    }
    i(paramListenTogetherSession.jdField_f_of_type_Int, paramListenTogetherSession.e, 1016);
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
    QLog.d("ListenTogether.Manager", 1, String.format("isJoinSession [%s, %s]", new Object[] { this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString }));
    return TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString) ^ true;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (paramInt == 1)
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString);
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
        localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString, false);
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
  
  public boolean a(Context paramContext, int paramInt, String paramString)
  {
    boolean bool;
    if (paramInt == 1)
    {
      if (!this.jdField_d_of_type_Boolean)
      {
        paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        paramString = new StringBuilder();
        paramString.append("is_not_first_join_listen_together_");
        paramString.append(paramInt);
        this.jdField_d_of_type_Boolean = ListenTogetherUtils.a(paramContext, paramString.toString(), false, false);
      }
      bool = this.jdField_d_of_type_Boolean;
    }
    else
    {
      if (!this.e)
      {
        paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        paramString = new StringBuilder();
        paramString.append("is_not_first_join_listen_together_");
        paramString.append(paramInt);
        this.e = ListenTogetherUtils.a(paramContext, paramString.toString(), false, false);
      }
      bool = this.e;
    }
    if (!bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.jdField_d_of_type_Boolean = true;
      paramContext = new Intent();
      paramContext.putExtra("type", 4);
      paramContext.putExtra("uinType", paramInt);
      paramContext.putExtra("public_fragment_window_feature", 1);
      paramContext.setFlags(268435456);
      PublicFragmentActivity.Launcher.a(BaseApplicationImpl.getContext(), paramContext, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
      if (paramInt == 1) {
        this.jdField_d_of_type_Boolean = true;
      } else {
        this.e = true;
      }
      paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramString = new StringBuilder();
      paramString.append("is_not_first_join_listen_together_");
      paramString.append(paramInt);
      ListenTogetherUtils.a(paramContext, paramString.toString(), true, false);
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
    localStringBuilder.append(a(paramInt2));
    QLog.d("ListenTogether.Manager", 1, localStringBuilder.toString());
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isPttRecordingOrPlaying()))
    {
      if (TogetherControlManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseActivity, 1, paramString, paramInt1)) {
        return false;
      }
      ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).c(paramInt1, paramString, paramInt2);
      return true;
    }
    a(paramBaseActivity, HardCodeUtil.a(2131706252));
    b((ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(ListenTogetherUtils.a(paramInt1, paramString)));
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.b();
  }
  
  public String b(String paramString)
  {
    return (String)this.jdField_d_of_type_AndroidSupportV4UtilLruCache.get(paramString);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (OnJoinListenTogetherCallback)((WeakReference)localObject).get();
    }
    if (localObject != null) {
      ((OnJoinListenTogetherCallback)localObject).b();
    }
    this.jdField_a_of_type_MqqUtilWeakReference = null;
  }
  
  public void b(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onResumeMusicPlay type: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" ,uin: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.b();
    localObject = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(ListenTogetherUtils.a(paramInt, paramString));
    if (bool)
    {
      if (localObject != null) {
        ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).a(((ListenTogetherSession)localObject).jdField_f_of_type_Int, ((ListenTogetherSession)localObject).e);
      }
    }
    else {
      d(paramInt, paramString);
    }
  }
  
  public void b(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onExitAio. mLastEnterAIOId:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(" aioId:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int != paramInt2) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController;
    if (localObject != null) {
      ((LyricsController)localObject).a(paramInt1, paramString, false);
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).a(paramJSONObject);
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
      c(paramInt, paramString);
    }
    a(paramInt, paramString, "pauseSong", 0);
    i(paramInt, paramString, 1005);
  }
  
  public void b(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetJoinListenTogetherResponse isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" by: ");
    ((StringBuilder)localObject).append(a(paramInt));
    localObject = ((StringBuilder)localObject).toString();
    int j = 1;
    QLog.i("ListenTogether.Manager", 1, (String)localObject);
    if (paramListenTogetherSession == null) {
      return;
    }
    localObject = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramListenTogetherSession.b());
    int i = 1001;
    if (!paramBoolean)
    {
      b((ListenTogetherSession)localObject);
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
      i = -1;
      break;
    case 1002: 
      i = 1021;
      break;
    case 1001: 
      i = 1009;
    }
    i(paramListenTogetherSession.jdField_f_of_type_Int, paramListenTogetherSession.e, i);
    a(0);
    if (paramInt == 1002)
    {
      if (paramListenTogetherSession.jdField_f_of_type_Int == 2) {
        paramInt = j;
      } else {
        paramInt = 0;
      }
      if (paramInt != 0)
      {
        ReportController.b(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_musicark_suc", 0, 0, paramListenTogetherSession.e, "", "", "");
        return;
      }
      localObject = paramListenTogetherSession.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(ListenTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramListenTogetherSession.e));
      ReportController.b(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_musicark_suc", 0, 0, (String)localObject, "", localStringBuilder.toString(), "");
    }
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    for (;;)
    {
      int i;
      String str;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("isSuccess", paramBoolean);
        if (paramBoolean)
        {
          paramObject = (Object[])paramObject;
          i = ((Integer)paramObject[0]).intValue();
          str = (String)paramObject[1];
          paramObject = (String)paramObject[2];
          i(i, str, 1022);
          a(paramObject, str, i);
          if (i != 2) {
            break label218;
          }
          paramObject = "c2c_AIO";
          break label222;
          ReportController.b(null, "dc00899", paramObject, "", "music_tab", "clk_share_suc", 0, 0, str, "", "", "");
        }
        else
        {
          paramObject = (Object[])paramObject;
          i = ((Integer)paramObject[0]).intValue();
          paramObject = (String)paramObject[1];
          localJSONObject.put("uint32_result", i);
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
      if (i == 2) {
        str = "";
      }
    }
  }
  
  public boolean b()
  {
    int i = a();
    boolean bool = true;
    if (i != 2)
    {
      if (i == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean b(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_JavaLangString.equals(ListenTogetherUtils.a(paramInt, paramString));
  }
  
  public void c()
  {
    Object localObject = this.jdField_b_of_type_MqqUtilWeakReference;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (OnExistListenTogetherCallback)((WeakReference)localObject).get();
    }
    if (localObject != null) {
      ((OnExistListenTogetherCallback)localObject).a();
    }
    this.jdField_b_of_type_MqqUtilWeakReference = null;
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onBackFromAIO. mLastEnterAIOId:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(" aioId:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int != paramInt2) {
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController;
    if ((localObject != null) && (((LyricsController)localObject).a()))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.a(paramInt1, paramString, true);
    }
  }
  
  public void c(JSONObject paramJSONObject)
  {
    ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).b(paramJSONObject);
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
      d(paramInt, paramString);
    }
    a(paramInt, paramString, "resumeSong", 0);
    i(paramInt, paramString, 1006);
  }
  
  public boolean c(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.a(paramInt, paramString);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void d(int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDestroyAIO. type: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" uin:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" mLastEnterAIOId:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(" aioId:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("ListenTogether.Manager", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int != paramInt2) {
      return;
    }
    if (ListenTogetherUtils.a(paramInt1, paramString).equals(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = "";
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController;
    if (localObject != null) {
      ((LyricsController)localObject).d(paramInt1, paramString);
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
      e(paramInt, paramString);
      return;
    }
    i(paramInt, paramString, 1019);
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
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    paramString = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(ListenTogetherUtils.a(paramInt1, paramString));
    if (paramString != null) {
      ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).b(paramString.jdField_f_of_type_Int, paramString.e, paramInt2);
    }
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
    paramString = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(ListenTogetherUtils.a(paramInt1, paramString));
    if (paramString != null) {
      ((ListenTogetherHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).a(paramString.jdField_f_of_type_Int, paramString.e, paramInt2);
    }
  }
  
  public void onDestroy()
  {
    QLog.i("ListenTogether.Manager", 1, "onDestroy");
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerIQQMusicPlayClient.c();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPredownloadIListenTogetherResDownloader.a();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.e();
    this.jdField_a_of_type_ComTencentMobileqqProfileMusicboxProfileMusicBoxController.e();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager
 * JD-Core Version:    0.7.0.1
 */