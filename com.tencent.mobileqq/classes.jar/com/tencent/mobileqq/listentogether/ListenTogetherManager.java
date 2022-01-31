package com.tencent.mobileqq.listentogether;

import adky;
import alox;
import aloz;
import alpo;
import amab;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import athl;
import athq;
import athr;
import aths;
import atht;
import athu;
import athv;
import athw;
import athx;
import athy;
import athz;
import atia;
import atib;
import atii;
import atij;
import atik;
import atil;
import atjc;
import atjn;
import atka;
import atkb;
import atkc;
import atkd;
import atke;
import atkn;
import atko;
import awon;
import azmj;
import azmz;
import baky;
import bali;
import bdcd;
import bdfq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ldx;
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
  private alox jdField_a_of_type_Alox = new athy(this);
  private amab jdField_a_of_type_Amab = new athx(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new athz(this);
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new atia(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, MusicInfo> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private atib jdField_a_of_type_Atib = new atib(this, null);
  atil jdField_a_of_type_Atil;
  private atjn jdField_a_of_type_Atjn;
  private atka jdField_a_of_type_Atka = new athw(this);
  private atkb jdField_a_of_type_Atkb = new athv(this);
  private atkc jdField_a_of_type_Atkc;
  private atkd jdField_a_of_type_Atkd = new athu(this);
  private atkn jdField_a_of_type_Atkn;
  private awon jdField_a_of_type_Awon;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListenTogetherManager.RunnableShowForKey jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager$RunnableShowForKey = new ListenTogetherManager.RunnableShowForKey(this, false);
  private Runnable jdField_a_of_type_JavaLangRunnable = new ListenTogetherManager.1(this);
  private volatile String jdField_a_of_type_JavaLangString = "";
  private Map<String, ListenTogetherSession> jdField_a_of_type_JavaUtilMap;
  private WeakReference<atil> jdField_a_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  private LruCache<String, String> jdField_b_of_type_AndroidSupportV4UtilLruCache;
  private ListenTogetherManager.RunnableShowForKey jdField_b_of_type_ComTencentMobileqqListentogetherListenTogetherManager$RunnableShowForKey = new ListenTogetherManager.RunnableShowForKey(this, true);
  private Runnable jdField_b_of_type_JavaLangRunnable = new ListenTogetherManager.2(this);
  private volatile String jdField_b_of_type_JavaLangString = "";
  private WeakReference<atik> jdField_b_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_b_of_type_Boolean;
  private LruCache<String, Long> jdField_c_of_type_AndroidSupportV4UtilLruCache;
  private volatile String jdField_c_of_type_JavaLangString = "";
  private volatile boolean jdField_c_of_type_Boolean = true;
  private LruCache<String, String> jdField_d_of_type_AndroidSupportV4UtilLruCache;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  public ListenTogetherManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_b_of_type_AndroidSupportV4UtilLruCache = new LruCache(5);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_c_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_d_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_a_of_type_Atjn = new atjn(paramQQAppInterface);
    this.jdField_a_of_type_Awon = new awon(paramQQAppInterface);
    this.jdField_a_of_type_Atkn = new atko(paramQQAppInterface);
    this.jdField_a_of_type_Atkc = new atke(BaseApplicationImpl.context, paramQQAppInterface);
    this.jdField_a_of_type_Atkc.a(this.jdField_a_of_type_Atkd);
    this.jdField_a_of_type_Atkc.a(this.jdField_a_of_type_Atkb);
    this.jdField_a_of_type_Atkc.a(this.jdField_a_of_type_Atka);
    this.jdField_a_of_type_Atkc.a(this.jdField_a_of_type_Atib);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
  }
  
  public static ListenTogetherManager a(QQAppInterface paramQQAppInterface)
  {
    return (ListenTogetherManager)paramQQAppInterface.getManager(331);
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1001: 
      return "JOIN_SESSION_BY_WEB";
    case 1000: 
      return "JOIN_SESSION_BY_MUSIC_PANEL";
    }
    return "JOIN_SESSION_BY_JOIN_AND_ENTER";
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(18, true, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt == 2)
    {
      azmj.b(null, "dc00899", "c2c_AIO", "", "music_tab", "song_play", 0, 0, "", "", paramString3, paramString2);
      return;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramString1);
    int i = 2;
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
    for (;;)
    {
      azmj.b(null, "dc00899", "Grp_AIO", "", "music_tab", "song_play", 0, 0, paramString1, String.valueOf(paramInt), paramString3, paramString2);
      return;
    }
  }
  
  private void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyLyricModuleSwitchChange, type: " + paramInt + " uin: " + paramString + " open:" + paramBoolean1 + " userAction: " + paramBoolean2);
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(11, true, new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
  }
  
  private void a(BaseActivity paramBaseActivity, String paramString)
  {
    QQToast.a(paramBaseActivity, 1, paramString, 0).b(paramBaseActivity.getTitleBarHeight());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if ((paramQQAppInterface != null) && (paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_Int == 1)) {
      paramQQAppInterface.c(1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramInt);
    }
    while ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramSessionInfo.jdField_a_of_type_Int != 0)) {
      return;
    }
    paramQQAppInterface.c(2, paramSessionInfo.jdField_a_of_type_JavaLangString, paramInt);
  }
  
  private void a(ListenTogetherSession paramListenTogetherSession)
  {
    if ((paramListenTogetherSession == null) || (paramListenTogetherSession.jdField_a_of_type_JavaUtilList == null) || (paramListenTogetherSession.jdField_a_of_type_JavaUtilList.isEmpty())) {}
    ArrayList localArrayList;
    label185:
    do
    {
      do
      {
        return;
      } while ((paramListenTogetherSession.g != 1) || (paramListenTogetherSession.h != 2));
      int j = paramListenTogetherSession.jdField_a_of_type_JavaUtilList.size();
      localArrayList = new ArrayList(j);
      int i = 0;
      if (i < j)
      {
        MusicInfo localMusicInfo = (MusicInfo)paramListenTogetherSession.jdField_a_of_type_JavaUtilList.get(i);
        if (localMusicInfo == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localMusicInfo.a()) {
            this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localMusicInfo.jdField_a_of_type_JavaLangString, localMusicInfo);
          }
          if ((!a((MusicInfo)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localMusicInfo.jdField_a_of_type_JavaLangString))) || (!localMusicInfo.a())) {}
          for (boolean bool = true;; bool = false)
          {
            if (!bool) {
              break label185;
            }
            localArrayList.add(new atij(localMusicInfo.jdField_a_of_type_JavaLangString, bool, false));
            break;
          }
        }
      }
    } while (localArrayList.isEmpty());
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).a(paramListenTogetherSession.jdField_e_of_type_Int, paramListenTogetherSession.jdField_e_of_type_JavaLangString, localArrayList, false);
  }
  
  private void a(ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh session: " + paramListenTogetherSession + " manager destroy: " + this.jdField_b_of_type_Boolean + " playFocused: " + this.jdField_c_of_type_Boolean);
    if (paramListenTogetherSession == null) {}
    do
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
        if (paramListenTogetherSession.h != 2) {
          break label427;
        }
        if (paramListenTogetherSession.g != 1) {
          break;
        }
        MusicInfo localMusicInfo = paramListenTogetherSession.a();
        if (localMusicInfo == null)
        {
          QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh startPlay musicInfo is null. return.");
          return;
        }
        if ((!this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q()) && (c()))
        {
          long l = localMusicInfo.jdField_a_of_type_Long;
          QLog.i("ListenTogether.Seek", 1, "sendRefreshPlayMsg seek: " + l + " currentTime: " + System.currentTimeMillis());
          if (l < 0L) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, -l);
          }
          while ((paramInt == 1009) || (paramInt == 1001) || (paramInt == 1015) || (paramInt == 1014) || (paramInt == 1010))
          {
            a(paramListenTogetherSession.jdField_e_of_type_Int, paramListenTogetherSession.jdField_e_of_type_JavaLangString, localMusicInfo.jdField_a_of_type_JavaLangString, localMusicInfo.jdField_b_of_type_JavaLangString);
            return;
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
          }
        }
      }
      if (paramListenTogetherSession.g == 2)
      {
        bool = this.jdField_a_of_type_Atkc.a();
        QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh pausePlay result: " + bool);
        return;
      }
      if (paramListenTogetherSession.g == 3)
      {
        bool = this.jdField_a_of_type_Atkc.c();
        QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh stopPlay result: " + bool);
        return;
      }
    } while (paramListenTogetherSession.g != 4);
    boolean bool = this.jdField_a_of_type_Atkc.c();
    QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh stopPlay result: " + bool);
    return;
    label427:
    bool = this.jdField_a_of_type_Atkc.c();
    QLog.i("ListenTogether.Manager", 1, "notifyMusicModuleToRefresh stopPlay result: " + bool);
  }
  
  private void a(ListenTogetherSession paramListenTogetherSession, boolean paramBoolean)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyUIModuleJoinListenTogetherFail session: " + paramListenTogetherSession + " listenTogetherClosed:" + paramBoolean);
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(5, true, new Object[] { Integer.valueOf(paramListenTogetherSession.jdField_e_of_type_Int), paramListenTogetherSession.jdField_e_of_type_JavaLangString, Boolean.valueOf(paramBoolean) });
  }
  
  private void a(ISong paramISong)
  {
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(13, true, new Object[] { paramISong });
  }
  
  private void a(String paramString, int paramInt)
  {
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(12, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(9, true, new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(10, true, new Object[] { paramString1, paramString2, Boolean.valueOf(false) });
    paramString1 = new StringBuilder().append("notifyMusicModuleLyric use cache lyric: ");
    if (paramString2 == null) {}
    for (int i = 0;; i = paramString2.length())
    {
      QLog.i("ListenTogether.Manager", 1, i + " serverError");
      return;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(15, true, new Object[] { Boolean.valueOf(paramBoolean), this.jdField_a_of_type_JavaUtilMap.get(paramString) });
  }
  
  private void a(boolean paramBoolean, List<MusicInfo> paramList)
  {
    QLog.i("ListenTogether.Manager", 1, "onGetMusicUrlFromServer success: " + paramBoolean + " musicList: " + paramList);
    if (!paramBoolean) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
      } while ((paramList == null) || (paramList.isEmpty()));
      localArrayList = new ArrayList();
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        MusicInfo localMusicInfo = (MusicInfo)paramList.get(i);
        if (localMusicInfo == null) {}
        for (;;)
        {
          i += 1;
          break;
          if (localMusicInfo.a())
          {
            this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localMusicInfo.jdField_a_of_type_JavaLangString, localMusicInfo);
            localArrayList.add(localMusicInfo);
          }
        }
      }
    } while (localArrayList.isEmpty());
    this.jdField_a_of_type_Atkn.a(localArrayList);
  }
  
  private boolean a(MusicInfo paramMusicInfo)
  {
    if (paramMusicInfo == null) {}
    while (SystemClock.elapsedRealtime() - paramMusicInfo.jdField_b_of_type_Long >= 180000L) {
      return false;
    }
    return true;
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1000: 
      return "enter_aio";
    case 1001: 
      return "join";
    case 1021: 
      return "join_enter";
    case 1002: 
      return "js_api";
    case 1003: 
      return "push";
    case 1004: 
      return "audio_release";
    case 1005: 
      return "pause";
    case 1006: 
      return "resume";
    case 1007: 
      return "finish";
    case 1008: 
      return "net_connected";
    case 1009: 
      return "js_api_open";
    case 1010: 
      return "js_api_cute";
    case 1011: 
      return "js_api_close";
    case 1012: 
      return "push_close";
    case 1013: 
      return "js_api_end_try_song";
    case 1014: 
      return "push_cute";
    case 1015: 
      return "push_auto_cute";
    case 1016: 
      return "exit";
    case 1017: 
      return "relation_finish";
    case 1018: 
      return "musicbox_resume";
    case 1019: 
      return "cut_song";
    }
    return "change_playmode";
  }
  
  private void b(int paramInt)
  {
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
    if (localListenTogetherSession != null) {
      i(localListenTogetherSession.jdField_e_of_type_Int, localListenTogetherSession.jdField_e_of_type_JavaLangString, paramInt);
    }
  }
  
  private void b(ListenTogetherSession paramListenTogetherSession)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyUIModuleToInitOrUpdate session: " + paramListenTogetherSession);
    if (paramListenTogetherSession == null) {
      return;
    }
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(4, true, new Object[] { paramListenTogetherSession });
  }
  
  private void b(String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new atij(paramString, false, true));
    paramString = (athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156);
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaLangString);
    if (localListenTogetherSession == null) {
      return;
    }
    paramString.a(localListenTogetherSession.jdField_e_of_type_Int, localListenTogetherSession.jdField_e_of_type_JavaLangString, localArrayList, true);
  }
  
  private void b(boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
      } while (localObject == null);
      localObject = ((ListenTogetherSession)localObject).a();
    } while (localObject == null);
    String str = (String)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(((MusicInfo)localObject).jdField_a_of_type_JavaLangString);
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(10, true, new Object[] { ((MusicInfo)localObject).jdField_a_of_type_JavaLangString, str, Boolean.valueOf(paramBoolean) });
    StringBuilder localStringBuilder = new StringBuilder().append("notifyMusicModuleLyric lyric: ");
    if (str == null) {}
    for (int i = 0;; i = str.length())
    {
      QLog.i("ListenTogether.Manager", 1, i + " serverError: " + paramBoolean + " songid: " + ((MusicInfo)localObject).jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  private void b(boolean paramBoolean, List<MusicInfo> paramList)
  {
    QLog.i("ListenTogether.Manager", 1, "onGetLyricFromServer success: " + paramBoolean + " musicList: " + paramList);
    if (!paramBoolean) {
      b(true);
    }
    MusicInfo localMusicInfo;
    do
    {
      return;
      if ((paramList == null) || (paramList.isEmpty()))
      {
        b(true);
        return;
      }
      localMusicInfo = (MusicInfo)paramList.get(0);
    } while (localMusicInfo == null);
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(localMusicInfo.d))
    {
      this.jdField_b_of_type_AndroidSupportV4UtilLruCache.put(((MusicInfo)paramList.get(0)).jdField_a_of_type_JavaLangString, localMusicInfo.d);
      localHashMap.put("has_lyric", "1");
    }
    for (;;)
    {
      b(false);
      azmz.a(BaseApplication.getContext()).a("", "listen_together_lyric", true, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("has_lyric", "0");
    }
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
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 13: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    default: 
      return "";
    case 1: 
      return "start";
    case 2: 
      return "stop";
    case 3: 
      return "auto_start";
    case 4: 
      return "auto_stop";
    case 11: 
      return "play";
    case 12: 
      return "cut";
    case 14: 
      return "auto_cut";
    case 15: 
      return "pause";
    case 21: 
      return "add";
    case 22: 
      return "delete";
    case 23: 
      return "sort";
    case 24: 
      return "clear";
    case 31: 
      return "join";
    case 32: 
      return "quit";
    }
    return "change_playmode";
  }
  
  private void c(int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyUIModulePauseListenTogetherFail type: " + paramInt + " uin:" + paramString);
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(6, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void c(ListenTogetherSession paramListenTogetherSession)
  {
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(19, true, new Object[] { Integer.valueOf(paramListenTogetherSession.jdField_e_of_type_Int), paramListenTogetherSession.jdField_e_of_type_JavaLangString });
  }
  
  private boolean c()
  {
    long l;
    if (!this.jdField_a_of_type_Atkc.d()) {
      l = SystemClock.uptimeMillis();
    }
    synchronized (this.jdField_a_of_type_Atib.a)
    {
      boolean bool = this.jdField_a_of_type_Atkc.d();
      if (!bool) {}
      try
      {
        this.jdField_a_of_type_Atkc.a();
        this.jdField_a_of_type_Atib.a.wait(1500L);
        if (QLog.isColorLevel()) {
          QLog.i("ListenTogether.Manager", 2, String.format("doConnIfNeed %b cos=%d", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Atkc.d()), Long.valueOf(SystemClock.uptimeMillis() - l) }));
        }
        return this.jdField_a_of_type_Atkc.d();
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ListenTogether.Manager", 2, "doConnIfNeed InterruptedException==>", localInterruptedException);
          }
        }
      }
    }
  }
  
  private void d(int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyUIModuleResumeListenTogetherFail type: " + paramInt + " uin:" + paramString);
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(7, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 8000L);
  }
  
  private void e(int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyUIModuleCutListenTogetherFail type: " + paramInt + " uin:" + paramString);
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(20, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void f()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    ListenTogetherSession localListenTogetherSession;
    do
    {
      return;
      localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
    } while (localListenTogetherSession == null);
    i(localListenTogetherSession.jdField_e_of_type_Int, localListenTogetherSession.jdField_e_of_type_JavaLangString, 1008);
  }
  
  private void f(int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "notifyUIModuleChangePlayModeListenTogetherFail type: " + paramInt + " uin:" + paramString);
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(21, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void g()
  {
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(16, true, null);
  }
  
  private void g(int paramInt, String paramString)
  {
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).notifyUI(22, true, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  private void g(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogether.Manager", 1, "updateSessionStatus type:" + paramInt1 + " uin:" + paramString + " status:" + paramInt2);
    }
    paramString = atii.a(paramInt1, paramString);
    if ((this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (this.jdField_a_of_type_JavaUtilMap.get(paramString) != null))
    {
      ((ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramString)).g = paramInt2;
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogether.Manager", 1, "updateSessionStatus in ");
      }
    }
  }
  
  private void h(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogether.Manager", 1, "updateSessionPlayMode type:" + paramInt1 + " uin:" + paramString + " playMode:" + paramInt2);
    }
    if ((paramInt2 <= 3) && (paramInt2 >= 1))
    {
      paramString = atii.a(paramInt1, paramString);
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
    QLog.i("ListenTogether.Manager", 1, "refreshListenTogetherStatus, type: " + paramInt1 + " uin: " + paramString + " by:" + b(paramInt2));
    String str = atii.a(paramInt1, paramString);
    if ((!str.equals(this.jdField_a_of_type_JavaLangString)) && (!str.equals(this.jdField_c_of_type_JavaLangString)))
    {
      QLog.i("ListenTogether.Manager", 1, "refreshListenTogetherStatus, currentSessionKey: " + this.jdField_a_of_type_JavaLangString + " currentAio: " + this.jdField_c_of_type_JavaLangString + " not equal return.");
      return;
    }
    ((bali)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(165)).a(1, paramInt1, paramString, paramInt2);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Atkc.a();
  }
  
  public long a(int paramInt, String paramString)
  {
    paramString = paramInt + "_" + paramString;
    paramString = (Long)this.jdField_c_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.longValue();
  }
  
  public atjn a()
  {
    return this.jdField_a_of_type_Atjn;
  }
  
  public awon a()
  {
    return this.jdField_a_of_type_Awon;
  }
  
  public ListenTogetherSession a()
  {
    return (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaLangString);
  }
  
  public ListenTogetherSession a(int paramInt, String paramString)
  {
    return (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(atii.a(paramInt, paramString));
  }
  
  public MusicInfo a()
  {
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_b_of_type_JavaLangString);
    if (localListenTogetherSession == null) {
      return null;
    }
    if ((localListenTogetherSession.jdField_a_of_type_JavaUtilList == null) || (localListenTogetherSession.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    return (MusicInfo)localListenTogetherSession.jdField_a_of_type_JavaUtilList.get(0);
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_b_of_type_AndroidSupportV4UtilLruCache.get(paramString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (atil localatil = null;; localatil = (atil)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if (localatil != null) {
        localatil.a();
      }
      this.jdField_a_of_type_MqqUtilWeakReference = null;
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.Manager", 1, "notifyWebCheckJoinResult retCode:" + paramInt);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", "joinListen");
      localJSONObject.put("retCode", paramInt);
      if (localJSONObject != null) {
        atjc.a(localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("ListenTogether.Manager", 1, "notifyWebJoinListenResult error : " + localJSONException.getMessage());
        Object localObject = null;
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onPauseMusicPlay type: " + paramInt + " ,uin: " + paramString);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    boolean bool = this.jdField_a_of_type_Atkc.a();
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(atii.a(paramInt, paramString));
    if (bool)
    {
      if (localListenTogetherSession != null) {
        ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).b(localListenTogetherSession.jdField_e_of_type_Int, localListenTogetherSession.jdField_e_of_type_JavaLangString);
      }
      return;
    }
    c(paramInt, paramString);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_JavaLangString = atii.a(paramInt1, paramString);
    boolean bool = a(paramInt1, paramString);
    QLog.i("ListenTogether.Manager", 1, "onEnterAio type: " + paramInt1 + " ,uin: " + paramString + " open: " + bool + " mLastEnterAIOId:" + this.jdField_a_of_type_Int + " aioId:" + paramInt2);
    this.jdField_a_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Atjn != null) {
      this.jdField_a_of_type_Atjn.c(paramInt1, paramString);
    }
    if (!bool) {}
    while ((paramInt1 == 2) && (!((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramString))) {
      return;
    }
    String str = atii.a(paramInt1, paramString);
    b((ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(str));
    i(paramInt1, paramString, 1000);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    paramString = paramInt + "_" + paramString;
    this.jdField_c_of_type_AndroidSupportV4UtilLruCache.put(paramString, Long.valueOf(paramLong));
  }
  
  public void a(int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    QLog.i("ListenTogether.Manager", 1, "onGetListenTogetherJoinedCountChangePush type: " + paramInt + " uin: " + paramString1 + " sep: " + paramLong1 + " timeStamp: " + paramLong2 + " msg: " + paramString2);
    a(paramInt, paramString1, paramString2);
    paramString1 = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(atii.a(paramInt, paramString1));
    if (paramString1 == null) {
      return;
    }
    paramString1.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public void a(int paramInt1, String paramString1, long paramLong1, String paramString2, int paramInt2, long paramLong2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogether.Manager", 2, String.format("onGetListenTogetherPush type=%d seq=%d actionUin=%s pushType=%s data=%s ts=%d", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(paramLong1), paramString2, c(paramInt2), paramObject, Long.valueOf(paramLong2) }));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString2)) && (paramInt2 != 3) && (paramInt2 != 4) && (paramInt2 != 14)) {
      if (paramInt2 == 1) {
        if (paramInt1 == 2)
        {
          athl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
          QLog.i("ListenTogether.Manager", 1, "onGetListenTogetherPush action uin == current uin return.");
        }
      }
    }
    for (;;)
    {
      return;
      if (paramInt1 != 1) {
        break;
      }
      athl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
      break;
      if (paramInt2 != 2) {
        break;
      }
      if (paramInt1 == 2) {
        athl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, false);
      }
      for (;;)
      {
        g(paramInt1, paramString1, 3);
        break;
        if (paramInt1 == 1) {
          athl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, false);
        }
      }
      a(paramInt1, paramString1, paramLong2);
      int j = 1;
      int i;
      if (paramInt2 == 14)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        i = 1;
      }
      label435:
      label599:
      while (i != 0)
      {
        i = 1003;
        if (paramInt2 == 2) {
          i = 1012;
        }
        for (;;)
        {
          i(paramInt1, paramString1, i);
          return;
          if ((paramInt2 == 1) || (paramInt2 == 3))
          {
            if (paramInt1 == 2) {
              athl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
            }
            for (;;)
            {
              a(paramInt1, paramString1, "openListen", 0);
              i = 1;
              break;
              if (paramInt1 == 1) {
                athl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, true);
              }
            }
          }
          if ((paramInt2 == 2) || (paramInt2 == 4))
          {
            if (paramInt1 == 2) {
              athl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, false);
            }
            for (;;)
            {
              g(paramInt1, paramString1, 3);
              a(paramInt1, paramString1, "closeListen", 0);
              i = 1;
              break;
              if (paramInt1 == 1) {
                athl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, false);
              }
            }
          }
          i = j;
          if (paramInt2 != 16) {
            break label599;
          }
          if ((paramObject instanceof Integer)) {}
          for (i = ((Integer)paramObject).intValue();; i = 0)
          {
            h(paramInt1, paramString1, i);
            if (paramInt1 != 2) {
              break label435;
            }
            i = 1;
            break;
          }
          i = j;
          if (paramInt1 != 1) {
            break label599;
          }
          j = 0;
          paramString2 = atii.a(paramInt1, paramString1);
          paramString2 = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramString2);
          i = j;
          if (paramString2 == null) {
            break label599;
          }
          if (!TextUtils.equals(paramString2.f, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
          {
            paramString2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
            i = j;
            if (paramString2 == null) {
              break label599;
            }
            i = j;
            if (!paramString2.isAdmin()) {
              break label599;
            }
            i = 1;
            break;
          }
          i = 1;
          break;
          if (paramInt2 == 12) {
            i = 1014;
          } else if (paramInt2 == 14) {
            i = 1015;
          } else if (paramInt2 == 16) {
            i = 1020;
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString, atik paramatik)
  {
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramatik);
    paramatik = atii.a(paramInt, paramString);
    QLog.i("ListenTogether.Manager", 1, "checkAndExitListenTogether type: " + paramInt + " ,uin: " + paramString + " key:" + paramatik + "  currentSessionKey:" + this.jdField_a_of_type_JavaLangString);
    paramatik = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramatik);
    if (paramatik == null)
    {
      c();
      return;
    }
    boolean bool = TextUtils.equals(paramatik.f, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    if (paramatik.jdField_e_of_type_Int == 2) {
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        paramString = new Intent();
        paramString.putExtra("type", 3);
        paramString.putExtra("uinType", paramatik.jdField_e_of_type_Int);
        paramString.putExtra("public_fragment_window_feature", 1);
        paramString.setFlags(268435456);
        adky.a(BaseApplicationImpl.getContext(), paramString, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
        return;
        if (paramatik.jdField_e_of_type_Int == 1)
        {
          if (bool)
          {
            paramInt = 1;
            continue;
          }
          paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramString);
          if ((paramString != null) && (paramString.isAdmin())) {
            paramInt = 1;
          }
        }
      }
      else
      {
        a(false);
        return;
      }
      paramInt = 0;
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.Manager", 1, "musicSongStateChange uinType:" + paramInt1 + " uin:" + paramString1 + " changeType:" + paramString2 + " opValue:" + paramInt2);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", paramString2);
      localJSONObject.put("uin", paramString1);
      localJSONObject.put("uinType", paramInt1);
      localJSONObject.put("value", paramInt2);
      paramString1 = localJSONObject;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        QLog.e("ListenTogether.Manager", 1, "musicSongStateChange error : " + paramString1.getMessage());
        paramString1 = null;
      }
    }
    if (paramString1 != null) {
      atjc.a(paramString1);
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    QLog.i("ListenTogether.Manager", 1, "onExitListenTogether type: " + paramInt + " ,uin: " + paramString + "bForceStop" + paramBoolean);
    if ((paramInt != 1) && (paramInt != 2)) {}
    while (TextUtils.isEmpty(paramString)) {
      return;
    }
    athq localathq = (athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156);
    if (paramBoolean)
    {
      localathq.d(paramInt, paramString);
      return;
    }
    localathq.c(paramInt, paramString);
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogether.Manager", 1, "notifyWebCheckJoinResult uinTypeForOpener:" + paramInt2 + " isOpener:" + paramBoolean + " canJoin:" + paramInt1);
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("type", "checkJoin");
        localJSONObject.put("canJoin", paramInt1);
        if (!paramBoolean) {
          continue;
        }
        paramInt1 = 1;
        localJSONObject.put("isOpener", paramInt1);
        localJSONObject.put("uinType", paramInt2);
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject;
        QLog.e("ListenTogether.Manager", 1, "notifyWebCheckJoinResult error : " + localJSONException.getMessage());
        Object localObject = null;
        continue;
      }
      if (localJSONObject != null) {
        atjc.a(localJSONObject);
      }
      return;
      paramInt1 = 0;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt, String paramString, long paramLong)
  {
    String str = atii.a(paramInt, paramString);
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(str);
    if (localListenTogetherSession != null)
    {
      str = localListenTogetherSession.toString();
      QLog.d("ListenTogether.Manager", 1, new Object[] { "joinTogetherAndEnter", " type=", Integer.valueOf(paramInt), " uin=", paramString, " id=", Long.valueOf(paramLong), " session=", str });
      if ((localListenTogetherSession == null) || (localListenTogetherSession.g == 3) || (paramLong != localListenTogetherSession.d) || (paramLong == 0L)) {
        break label233;
      }
      if (localListenTogetherSession.h == 2) {
        break label224;
      }
      this.jdField_a_of_type_Atil = new athr(this, paramBaseActivity, paramInt, paramString);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseActivity, paramInt, paramString, this.jdField_a_of_type_Atil);
      label177:
      if (paramInt != 2) {
        break label247;
      }
    }
    label224:
    label233:
    label247:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label252;
      }
      azmj.b(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_musicark", 0, 0, paramString, "", "", "");
      return;
      str = "null";
      break;
      g(paramInt, paramString);
      break label177;
      a(paramBaseActivity, alpo.a(2131693954));
      break label177;
    }
    label252:
    azmj.b(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_musicark", 0, 0, paramString, "", "" + atii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString), "");
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt, String paramString, atil paramatil)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramatil);
    QLog.i("ListenTogether.Manager", 1, "checkAndJoinListenTogether type: " + paramInt + " ,uin: " + paramString);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q()))
    {
      a(paramBaseActivity, alpo.a(2131706545));
      b((ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(atii.a(paramInt, paramString)));
      b();
      return;
    }
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(atii.a(paramInt, paramString));
    if ((localListenTogetherSession == null) || (TextUtils.isEmpty(localListenTogetherSession.jdField_b_of_type_JavaLangString)) || ("0".equals(localListenTogetherSession.jdField_b_of_type_JavaLangString)))
    {
      a();
      a(paramBaseActivity, paramInt, paramString);
      return;
    }
    String str = alpo.a(2131706555);
    paramatil = alpo.a(2131706553);
    if (localListenTogetherSession.jdField_a_of_type_Int == 1)
    {
      if (!localListenTogetherSession.jdField_b_of_type_Boolean) {
        break label393;
      }
      paramatil = alpo.a(2131706554);
    }
    label393:
    for (;;)
    {
      paramBaseActivity = bdcd.a(paramBaseActivity, 230);
      paramString = new aths(this, paramInt, paramString);
      paramBaseActivity.setTitle(str);
      paramBaseActivity.setMessage(paramatil);
      paramBaseActivity.setOnDismissListener(new atht(this));
      paramBaseActivity.setNegativeButton(alpo.a(2131706550), paramString);
      paramBaseActivity.setPositiveButton(alpo.a(2131706548), paramString);
      paramBaseActivity.setCanceledOnTouchOutside(false);
      paramBaseActivity.show();
      if ((paramInt == 1) && (!this.jdField_d_of_type_Boolean))
      {
        this.jdField_d_of_type_Boolean = true;
        atii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "is_not_first_join_listen_together_" + paramInt, true, false);
        return;
        paramatil = alpo.a(2131706546);
      }
      else
      {
        if ((paramInt != 2) || (this.e)) {
          break;
        }
        this.e = true;
        atii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "is_not_first_join_listen_together_" + paramInt, true, false);
        return;
      }
    }
  }
  
  public void a(MusicInfo paramMusicInfo)
  {
    if (paramMusicInfo == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = b(paramMusicInfo.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("_");
          int i = Integer.parseInt(localObject[0]);
          localObject = localObject[1];
          ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).a(i, (String)localObject, paramMusicInfo.jdField_a_of_type_JavaLangString, paramMusicInfo.jdField_b_of_type_JavaLangString, (String)paramMusicInfo.jdField_b_of_type_JavaUtilList.get(0), paramMusicInfo.jdField_a_of_type_JavaUtilList);
          return;
        }
      }
      catch (Exception paramMusicInfo)
      {
        paramMusicInfo.printStackTrace();
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AioShareMusicListenTogether.Manager", 2, "notifyPlayChangeToAioShareMusic() newSong = " + paramString);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("current_song_id", paramString);
      ldx.a(localJSONObject, "updateSongIdToAioShareMusic");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = paramInt + "_" + paramString2;
    this.jdField_d_of_type_AndroidSupportV4UtilLruCache.put(paramString1, paramString2);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    int j = 0;
    if (paramJSONObject == null) {
      return;
    }
    String str1 = paramJSONObject.optString("type");
    String str2 = paramJSONObject.optString("uin");
    int i = paramJSONObject.optInt("uinType");
    QLog.i("ListenTogether.Manager", 1, "onMusicStateChangeJsApiCalled type: " + i + " uin: " + str2 + " apiType: " + str1);
    if ("switchSong".equals(str1))
    {
      i(i, str2, 1010);
      return;
    }
    if ("openListen".equals(str1))
    {
      if (i == 2) {
        athl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, true);
      }
      for (;;)
      {
        i(i, str2, 1009);
        return;
        if (i == 1) {
          athl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, true);
        }
      }
    }
    if ("closeListen".equals(str1))
    {
      if (i == 2) {
        athl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, false);
      }
      for (;;)
      {
        i(i, str2, 1011);
        return;
        if (i == 1) {
          athl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, false);
        }
      }
    }
    if ("addSong".equals(str1))
    {
      i(i, str2, 1002);
      return;
    }
    if ("deleteSong".equals(str1))
    {
      i(i, str2, 1002);
      return;
    }
    if ("sortSong".equals(str1))
    {
      i(i, str2, 1002);
      return;
    }
    if ("closeListenSelf".equals(str1))
    {
      a(i, str2, false);
      return;
    }
    if ("showLyrics".equals(str1))
    {
      a(i, str2, true, true);
      return;
    }
    if ("hideLyrics".equals(str1))
    {
      a(i, str2, false, true);
      return;
    }
    boolean bool;
    if ("checkJoin".equals(str1))
    {
      if (!a()) {
        break label517;
      }
      paramJSONObject = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
      if (paramJSONObject == null) {
        break label509;
      }
      bool = TextUtils.equals(paramJSONObject.f, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      i = paramJSONObject.jdField_e_of_type_Int;
    }
    for (;;)
    {
      a(j, bool, i);
      return;
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
        ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).c(i, str2, 1001);
        return;
      }
      if (!"musicboxResume".equals(str1)) {
        break;
      }
      b(1018);
      return;
      label509:
      i = 1;
      bool = false;
      continue;
      label517:
      i = 1;
      j = 1;
      bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_MqqUtilWeakReference == null) {}
    for (atik localatik = null;; localatik = (atik)this.jdField_b_of_type_MqqUtilWeakReference.get())
    {
      if (localatik != null) {
        localatik.a(paramBoolean);
      }
      this.jdField_b_of_type_MqqUtilWeakReference = null;
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    paramString = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(atii.a(paramInt, paramString));
    if (paramString != null) {
      paramString.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "onChangePlayModeRespFromServer, success: " + paramBoolean + " ,type: " + paramInt1 + " ,uin: " + paramString + ", playMode: " + paramInt2);
    if (!paramBoolean)
    {
      f(paramInt1, paramString);
      return;
    }
    h(paramInt1, paramString, paramInt2);
  }
  
  public void a(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    QLog.i("ListenTogether.Manager", 1, "onGetListenTogetherSessionFromServer, success: " + paramBoolean + " ,session: " + paramListenTogetherSession + " ,by: " + b(paramInt));
    if (paramListenTogetherSession == null) {
      return;
    }
    if (paramBoolean) {}
    label535:
    label579:
    for (;;)
    {
      Object localObject;
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        String str = paramListenTogetherSession.b();
        localObject = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(str);
        if (localObject == null)
        {
          this.jdField_a_of_type_JavaUtilMap.put(str, paramListenTogetherSession);
          localObject = paramListenTogetherSession;
          if ((((ListenTogetherSession)localObject).g != 3) && (((ListenTogetherSession)localObject).h != 3)) {
            break label579;
          }
          ((ListenTogetherSession)localObject).jdField_a_of_type_Boolean = false;
          break label579;
          ((ListenTogetherSession)localObject).jdField_a_of_type_Boolean = false;
          if (((ListenTogetherSession)localObject).h != 2) {
            break label508;
          }
          this.jdField_a_of_type_JavaLangString = ((ListenTogetherSession)localObject).b();
          this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          i = 0;
          localObject = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramListenTogetherSession.b());
          b((ListenTogetherSession)localObject);
          a(((ListenTogetherSession)localObject).jdField_e_of_type_Int, ((ListenTogetherSession)localObject).jdField_e_of_type_JavaLangString, ((ListenTogetherSession)localObject).jdField_a_of_type_JavaLangString);
          if ((this.jdField_a_of_type_JavaLangString.equals(paramListenTogetherSession.b())) || (i != 0))
          {
            if ((paramInt == 1000) || (paramInt == 1001) || (paramInt == 1009) || (paramInt == 1013) || (paramInt == 1018)) {
              this.jdField_c_of_type_Boolean = true;
            }
            a((ListenTogetherSession)localObject, paramInt);
            a((ListenTogetherSession)localObject);
          }
          if (this.jdField_a_of_type_JavaLangString.equals(paramListenTogetherSession.b()))
          {
            if ((paramInt == 1001) || (paramInt == 1009)) {
              this.jdField_a_of_type_Atjn.f();
            }
            if ((paramInt == 1014) || (paramInt == 1015) || (paramInt == 1012) || (paramInt == 1003)) {
              a(paramListenTogetherSession.jdField_e_of_type_Int, paramListenTogetherSession.jdField_e_of_type_JavaLangString, "switchSong", 0);
            }
            if (paramInt == 1020) {
              a(paramListenTogetherSession.jdField_e_of_type_Int, paramListenTogetherSession.jdField_e_of_type_JavaLangString, "playModeChange", paramListenTogetherSession.jdField_c_of_type_Int);
            }
            if (paramInt == 1021) {
              g(paramListenTogetherSession.jdField_e_of_type_Int, paramListenTogetherSession.jdField_e_of_type_JavaLangString);
            }
          }
          if (i == 0) {
            break;
          }
          i = paramListenTogetherSession.jdField_e_of_type_Int;
          localObject = paramListenTogetherSession.jdField_e_of_type_JavaLangString;
          ThreadManager.getUIHandler().post(new ListenTogetherManager.13(this, i, (String)localObject));
          if (paramInt != 1012) {
            break label535;
          }
          a(paramListenTogetherSession.jdField_e_of_type_Int, paramListenTogetherSession.jdField_e_of_type_JavaLangString, "closeListen", 0);
          return;
        }
        if (paramListenTogetherSession.jdField_c_of_type_Long < ((ListenTogetherSession)localObject).jdField_c_of_type_Long) {
          return;
        }
      }
      ((ListenTogetherSession)localObject).a(paramListenTogetherSession);
      continue;
      label508:
      if (this.jdField_a_of_type_JavaLangString.equals(((ListenTogetherSession)localObject).b()))
      {
        this.jdField_a_of_type_JavaLangString = "";
        i = 1;
        continue;
        a(paramListenTogetherSession.jdField_e_of_type_Int, paramListenTogetherSession.jdField_e_of_type_JavaLangString, "comeoutSong", 0);
        return;
        b((ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramListenTogetherSession.b()));
      }
      else
      {
        i = 0;
        continue;
        if (paramInt != 1001) {
          if (paramInt != 1009) {}
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AioShareMusicListenTogether.Manager", 2, "handleCheckAndShowAioShareMusic() isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {}
    try
    {
      ldx.a((JSONObject)paramObject, "checkAioShareMusic");
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
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
    if (QLog.isColorLevel()) {
      QLog.d("AioShareMusicListenTogether.Manager", 2, "handleReportDownloadFailedAioShareMusic()  isSuccess = " + paramBoolean);
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (paramInt == 1)
    {
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(paramString);
      if (localObject != null) {
        bool1 = ((TroopInfo)localObject).isListenTogetherOpen();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.switch", 2, "isListenTogetherOpen, type:" + paramInt + " uin:" + paramString + " res:" + bool1);
      }
      return bool1;
      if (QLog.isColorLevel()) {
        QLog.d("ListenTogether.switch", 2, "isListenTogetherOpen troopinfo is null");
      }
      bool1 = false;
      continue;
      bool1 = bool2;
      if (paramInt == 2)
      {
        localObject = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramString, false);
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
  }
  
  public boolean a(Context paramContext, int paramInt, String paramString)
  {
    boolean bool;
    if (paramInt == 1)
    {
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_d_of_type_Boolean = atii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "is_not_first_join_listen_together_" + paramInt, false, false);
      }
      bool = this.jdField_d_of_type_Boolean;
      if (bool) {
        break label218;
      }
      this.jdField_a_of_type_Atjn.jdField_d_of_type_Boolean = true;
      paramContext = new Intent();
      paramContext.putExtra("type", 4);
      paramContext.putExtra("uinType", paramInt);
      paramContext.putExtra("public_fragment_window_feature", 1);
      paramContext.setFlags(268435456);
      adky.a(BaseApplicationImpl.getContext(), paramContext, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
      if (paramInt != 1) {
        break label210;
      }
      this.jdField_d_of_type_Boolean = true;
    }
    for (;;)
    {
      atii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "is_not_first_join_listen_together_" + paramInt, true, false);
      return true;
      if (!this.e) {
        this.e = atii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "is_not_first_join_listen_together_" + paramInt, false, false);
      }
      bool = this.e;
      break;
      label210:
      this.e = true;
    }
    label218:
    return false;
  }
  
  public boolean a(BaseActivity paramBaseActivity, int paramInt1, String paramString, int paramInt2)
  {
    QLog.d("ListenTogether.Manager", 1, "joinListenTogether type: " + paramInt1 + " ,uin: " + paramString + " ,by:" + a(paramInt2));
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.q()))
    {
      a(paramBaseActivity, alpo.a(2131706547));
      b((ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(atii.a(paramInt1, paramString)));
      return false;
    }
    if (baky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramBaseActivity, 1, paramString, paramInt1)) {
      return false;
    }
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).c(paramInt1, paramString, paramInt2);
    return true;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Atkc.b();
  }
  
  public String b(String paramString)
  {
    return (String)this.jdField_d_of_type_AndroidSupportV4UtilLruCache.get(paramString);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (atil localatil = null;; localatil = (atil)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if (localatil != null) {
        localatil.b();
      }
      this.jdField_a_of_type_MqqUtilWeakReference = null;
      return;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onResumeMusicPlay type: " + paramInt + " ,uin: " + paramString);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    boolean bool = this.jdField_a_of_type_Atkc.b();
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(atii.a(paramInt, paramString));
    if (bool)
    {
      if (localListenTogetherSession != null) {
        ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).a(localListenTogetherSession.jdField_e_of_type_Int, localListenTogetherSession.jdField_e_of_type_JavaLangString);
      }
      return;
    }
    d(paramInt, paramString);
  }
  
  public void b(int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "onExitAio. mLastEnterAIOId:" + this.jdField_a_of_type_Int + " aioId:" + paramInt2);
    if (this.jdField_a_of_type_Int != paramInt2) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
    } while (this.jdField_a_of_type_Atjn == null);
    this.jdField_a_of_type_Atjn.a(paramInt1, paramString, false);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).a(paramJSONObject);
  }
  
  public void b(boolean paramBoolean, int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onPauseRespFromServer, success: " + paramBoolean + " ,type: " + paramInt + " ,uin: " + paramString);
    if (!paramBoolean) {
      c(paramInt, paramString);
    }
    a(paramInt, paramString, "pauseSong", 0);
    i(paramInt, paramString, 1005);
  }
  
  public void b(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    QLog.i("ListenTogether.Manager", 1, "onGetJoinListenTogetherResponse isSuccess: " + paramBoolean + " by: " + a(paramInt));
    if (paramListenTogetherSession == null) {}
    int i;
    do
    {
      return;
      ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramListenTogetherSession.b());
      if (!paramBoolean)
      {
        b(localListenTogetherSession);
        if (paramInt != 1001)
        {
          a(localListenTogetherSession, false);
          return;
        }
        a(1);
        return;
      }
      i = -1;
      switch (paramInt)
      {
      default: 
        i(paramListenTogetherSession.jdField_e_of_type_Int, paramListenTogetherSession.jdField_e_of_type_JavaLangString, i);
        a(0);
      }
    } while (paramInt != 1002);
    if (paramListenTogetherSession.jdField_e_of_type_Int == 2) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label224;
      }
      azmj.b(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_musicark_suc", 0, 0, paramListenTogetherSession.jdField_e_of_type_JavaLangString, "", "", "");
      return;
      i = 1001;
      break;
      i = 1009;
      break;
      i = 1021;
      break;
    }
    label224:
    azmj.b(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_musicark_suc", 0, 0, paramListenTogetherSession.jdField_e_of_type_JavaLangString, "", "" + atii.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramListenTogetherSession.jdField_e_of_type_JavaLangString), "");
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    String str;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isSuccess", paramBoolean);
      int i;
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        i = ((Integer)paramObject[0]).intValue();
        str = (String)paramObject[1];
        paramObject = (String)paramObject[2];
        i(i, str, 1022);
        a(paramObject, str, i);
        if (i == 2) {
          paramObject = "c2c_AIO";
        }
      }
      else
      {
        while (i != 2)
        {
          azmj.b(null, "dc00899", paramObject, "", "music_tab", "clk_share_suc", 0, 0, str, "", "", "");
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AioShareMusicListenTogether.Manager", 2, "handleStartAioShareMusic() jsonObject = " + localJSONObject.toString());
            }
            ldx.a(localJSONObject, "startListenAioShareMusic");
            return;
            paramObject = (Object[])paramObject;
            i = ((Integer)paramObject[0]).intValue();
            paramObject = (String)paramObject[1];
            localJSONObject.put("uint32_result", i);
            localJSONObject.put("bytes_errmsg", paramObject);
          }
        }
      }
    }
    catch (JSONException paramObject)
    {
      paramObject.printStackTrace();
      return;
    }
    for (;;)
    {
      str = "";
      break;
      paramObject = "Grp_AIO";
    }
  }
  
  public boolean b()
  {
    int i = a();
    return (i == 2) || (i == 1);
  }
  
  public boolean b(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_JavaLangString.equals(atii.a(paramInt, paramString));
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_MqqUtilWeakReference == null) {}
    for (atik localatik = null;; localatik = (atik)this.jdField_b_of_type_MqqUtilWeakReference.get())
    {
      if (localatik != null) {
        localatik.a();
      }
      this.jdField_b_of_type_MqqUtilWeakReference = null;
      return;
    }
  }
  
  public void c(int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "onBackFromAIO. mLastEnterAIOId:" + this.jdField_a_of_type_Int + " aioId:" + paramInt2);
    if (this.jdField_a_of_type_Int != paramInt2) {}
    while ((this.jdField_a_of_type_Atjn == null) || (!this.jdField_a_of_type_Atjn.a())) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Atjn.a(paramInt1, paramString, true);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).b(paramJSONObject);
  }
  
  public void c(boolean paramBoolean, int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onResumeRespFromServer, success: " + paramBoolean + " ,type: " + paramInt + " ,uin: " + paramString);
    if (!paramBoolean) {
      d(paramInt, paramString);
    }
    a(paramInt, paramString, "resumeSong", 0);
    i(paramInt, paramString, 1006);
  }
  
  public void c(boolean paramBoolean, ListenTogetherSession paramListenTogetherSession, int paramInt)
  {
    QLog.i("ListenTogether.Manager", 1, "onGetExitListenTogetherResponse isSuceess: " + paramBoolean);
    if (paramListenTogetherSession == null) {
      return;
    }
    ListenTogetherSession localListenTogetherSession = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(paramListenTogetherSession.b());
    if (!paramBoolean)
    {
      b(localListenTogetherSession);
      c(localListenTogetherSession);
      return;
    }
    if (paramListenTogetherSession.jdField_e_of_type_Int == 2) {
      if (paramInt == 3) {
        athl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramListenTogetherSession.jdField_e_of_type_JavaLangString, false);
      }
    }
    for (;;)
    {
      i(paramListenTogetherSession.jdField_e_of_type_Int, paramListenTogetherSession.jdField_e_of_type_JavaLangString, 1016);
      return;
      if (paramInt == 3) {
        athl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramListenTogetherSession.jdField_e_of_type_JavaLangString, false);
      }
    }
  }
  
  public boolean c(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_Atjn.a(paramInt, paramString);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void d(int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "onDestroyAIO. type: " + paramInt1 + " uin:" + paramString + " mLastEnterAIOId:" + this.jdField_a_of_type_Int + " aioId:" + paramInt2);
    if (this.jdField_a_of_type_Int != paramInt2) {}
    do
    {
      return;
      if (atii.a(paramInt1, paramString).equals(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = "";
      }
    } while (this.jdField_a_of_type_Atjn == null);
    this.jdField_a_of_type_Atjn.d(paramInt1, paramString);
  }
  
  public void d(boolean paramBoolean, int paramInt, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onCutOperRespFromServer, success: " + paramBoolean + " ,type: " + paramInt + " ,uin: " + paramString);
    if (!paramBoolean)
    {
      e(paramInt, paramString);
      return;
    }
    i(paramInt, paramString, 1019);
  }
  
  public void e(int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "onCutSong type: " + paramInt1 + " ,uin: " + paramString + ",cutType: " + paramInt2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    paramString = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(atii.a(paramInt1, paramString));
    if (paramString != null) {
      ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).b(paramString.jdField_e_of_type_Int, paramString.jdField_e_of_type_JavaLangString, paramInt2);
    }
  }
  
  public void f(int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("ListenTogether.Manager", 1, "onChangePlayMode type: " + paramInt1 + " ,uin: " + paramString + " ,dstPlayMode: " + paramInt2);
    paramString = (ListenTogetherSession)this.jdField_a_of_type_JavaUtilMap.get(atii.a(paramInt1, paramString));
    if (paramString != null) {
      ((athq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(156)).a(paramString.jdField_e_of_type_Int, paramString.jdField_e_of_type_JavaLangString, paramInt2);
    }
  }
  
  public void onDestroy()
  {
    QLog.i("ListenTogether.Manager", 1, "onDestroy");
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Atkc.c();
    this.jdField_a_of_type_Atkn.a();
    this.jdField_a_of_type_Atjn.e();
    this.jdField_a_of_type_Awon.e();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
    BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherManager
 * JD-Core Version:    0.7.0.1
 */