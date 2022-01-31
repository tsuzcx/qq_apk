package cooperation.qzone.music;

import ajya;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.TextView;
import arsj;
import bbdj;
import bbgu;
import bcdp;
import bcql;
import bhgd;
import bhge;
import bhgf;
import bhgg;
import bhgh;
import bhgi;
import bhgj;
import bhgk;
import bhgl;
import bhgm;
import bhgn;
import bhgo;
import bhgp;
import bhgq;
import bhlc;
import bhlf;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneWebMusicJsPlugin
  extends WebViewPlugin
  implements bhlf
{
  public static final String CONFIG_MOBINET_TIPS = "qzbg_music_mobinet_tips";
  public static final String EVENT_BUFFERING = "buffering";
  public static final String EVENT_BUTTON_CLICK = "buttonclick";
  public static final String EVENT_CANCEL = "cancel";
  public static final String EVENT_ERROR = "error";
  public static final String EVENT_FINISH = "finish";
  public static final String EVENT_GET_LIVINGINGO = "livinginfo";
  public static final String EVENT_GET_NETWORKE_TYPE = "networktype";
  public static final String EVENT_GET_PLAY_MODE = "playmode";
  public static final String EVENT_GET_SONGINFO = "songinfo";
  public static final String EVENT_PAUSED = "paused";
  public static final String EVENT_PLAYING = "playing";
  public static final String EVENT_STOP = "stop";
  public static final String EVENT_UNKOWN = "unknow";
  public static final String METHOD_STOP_MUSIC_BOX = "stopMusicBox";
  public static final String MUSIC_METHOD_NAMESPACE = "QzMusic";
  public static final String WEB_APP_MUSIC_EVENT = "WEBAPP_MUSIC";
  private static JsBridgeListener mFMLiveInfoJsBridgeListener;
  private String TAG = QzoneWebMusicJsPlugin.class.getSimpleName();
  private boolean isAutoPlay;
  public boolean isFlowWarningVisible;
  private boolean isLoop = true;
  private boolean isRandom;
  private boolean isShowing;
  private boolean isUseRemoteMusicManager;
  private boolean isWebPageListening;
  private Handler mMainHandler;
  
  public QzoneWebMusicJsPlugin()
  {
    this.mPluginNameSpace = "QzMusic";
  }
  
  private void callNetWorkInterface(String paramString)
  {
    if (!this.isDestroy) {
      this.mRuntime.a().loadUrl("javascript:try{QQMusicJSInterface.onRecieve({type:\"networktype\",data:{type:\"isUnicomNetwork\",value:" + paramString + "}})}catch(e){}");
    }
  }
  
  private void callNetWorkInterfaceForGetttingLiveInfo(String paramString, Bundle paramBundle)
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    this.mMainHandler.post(new QzoneWebMusicJsPlugin.25(this, paramBundle));
  }
  
  private void callWebPageInterface(String paramString)
  {
    if ((this.isWebPageListening) && (!this.isDestroy)) {
      this.mRuntime.a().loadUrl("javascript:try{QQMusicJSInterface.onRecieve({type:\"WEBAPP_MUSIC\",data:{type:\"" + paramString + "\"}})}catch(e){}");
    }
  }
  
  private void callWebPageInterface(String paramString, Bundle paramBundle)
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    this.mMainHandler.post(new QzoneWebMusicJsPlugin.26(this, paramString, paramBundle));
  }
  
  private void callWebPageInterfaceImpl(String paramString, Bundle paramBundle)
  {
    if (this.isWebPageListening)
    {
      localJSONObject = new JSONObject();
      if (paramBundle == null) {}
    }
    try
    {
      SongInfo localSongInfo = (SongInfo)paramBundle.getParcelable("param.song");
      if (localSongInfo == null) {
        break label242;
      }
      localJSONObject.put("name", localSongInfo.jdField_b_of_type_JavaLangString);
      localJSONObject.put("singer", localSongInfo.g);
      localJSONObject.put("songId", localSongInfo.jdField_a_of_type_Long);
      localJSONObject.put("songMid", localSongInfo.f);
      localJSONObject.put("singerId", localSongInfo.jdField_c_of_type_Long);
      localJSONObject.put("type", localSongInfo.jdField_b_of_type_Int);
      localJSONObject.put("cover", localSongInfo.d);
      localJSONObject.put("ownerUin", localSongInfo.jdField_b_of_type_Long);
      localJSONObject.put("playUrl", localSongInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("detailUrl", localSongInfo.e);
      if (!TextUtils.isEmpty(localSongInfo.jdField_c_of_type_JavaLangString)) {
        localJSONObject.put("showId", localSongInfo.jdField_c_of_type_JavaLangString);
      }
      switch (localSongInfo.jdField_b_of_type_Int)
      {
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label242:
        localException.printStackTrace();
        continue;
        localJSONObject.put("voiceType", 2);
        continue;
        boolean bool = false;
        continue;
        bool = false;
        continue;
        bool = false;
        continue;
        bool = false;
      }
    }
    localJSONObject.put("voiceType", 0);
    for (;;)
    {
      localJSONObject.put("uin", paramBundle.getLong("param.uin"));
      localJSONObject.put("state", getStateString(paramBundle.getInt("param.state", -1)));
      localJSONObject.put("total", paramBundle.getInt("param.duration"));
      localJSONObject.put("curr", paramBundle.getInt("param.currentTime"));
      if (paramBundle.getInt("param.origin") != 2) {
        break;
      }
      bool = true;
      localJSONObject.put("isDefaultList", bool);
      if (paramBundle != null) {}
      try
      {
        if (paramBundle.getInt("param.playModeRandom", 0) != 1) {
          break label601;
        }
        bool = true;
        this.isRandom = bool;
        if (paramBundle.getInt("param.playModeAuto", 0) != 1) {
          break label606;
        }
        bool = true;
        this.isAutoPlay = bool;
        if (paramBundle.getInt("param.playModeLoop", 0) != 0) {
          break label611;
        }
        bool = true;
        this.isLoop = bool;
        localJSONObject.put("randomMode", this.isRandom);
        localJSONObject.put("autoModeWithWifi", this.isAutoPlay);
        localJSONObject.put("isLoop", this.isLoop);
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, " callWebPageInterfaceImpl  ：" + paramString + " isdetroy " + this.isDestroy + " value  " + localJSONObject.toString() + " plugin " + this);
      }
      if (!this.isDestroy) {
        this.mRuntime.a().loadUrl("javascript:try{QQMusicJSInterface.onRecieve({type:\"WEBAPP_MUSIC\",data:{type:\"" + paramString + "\",value:" + localJSONObject.toString() + "}})}catch(e){}");
      }
      return;
      localJSONObject.put("voiceType", 1);
    }
  }
  
  private void doPlayMusicOrAudioCommon(bhgq parambhgq)
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (needPlayTips()))
    {
      showPlayTips(localActivity, new bhgl(this, parambhgq), new bhgn(this));
      this.isFlowWarningVisible = true;
    }
    while (parambhgq == null) {
      return;
    }
    parambhgq.a();
  }
  
  private void doSetPlayMode(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.24(this, paramInt1, paramInt2, paramInt3));
  }
  
  private long getCurrentHostUin()
  {
    Object localObject = "";
    try
    {
      String str1 = this.mRuntime.a().getUrl();
      localObject = str1;
      String str2 = Uri.parse(str1).getQueryParameter("guestuin");
      if (str2 == null)
      {
        localObject = str1;
        return this.mRuntime.a().getLongAccountUin();
      }
      localObject = str1;
      long l = Long.parseLong(str2);
      return l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.TAG, 2, "illegal guestuin,url=" + (String)localObject, localException);
      }
    }
    return 10000L;
  }
  
  private String getStateString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknow";
    case 1: 
      return "buffering";
    case 2: 
      return "playing";
    case 3: 
      return "paused";
    case 4: 
    case 6: 
      return "stop";
    }
    return "error";
  }
  
  private void initUserInfo()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.15(this));
  }
  
  private boolean needPlayTips()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (NetworkState.isMobile())
    {
      bool1 = bool2;
      if (!LocalMultiProcConfig.getBool("qzbg_music_mobinet_tips", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean needSetAutoPlayTips()
  {
    return BaseApplication.getContext().getSharedPreferences("share", 0).getBoolean("qzone_bg_music_auto_play_warn_flag", true);
  }
  
  private void playAudioListForBgMusic(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      j = paramString.optInt("index");
      paramString = paramString.getJSONArray("songList");
      int i = 0;
      while (i < paramString.length())
      {
        localArrayList.add(QzoneMusicHelper.convertFMBgMusic(paramString.getJSONObject(i)));
        i += 1;
      }
      if (localArrayList.size() <= 0) {
        break label115;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e(this.TAG, 1, "playAudioListForBgMusic 参数异常", paramString);
      return;
    }
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.10(this, j, localArrayList));
    return;
    label115:
    QLog.e(this.TAG, 2, "playAudioListForBgMusic no song in song list");
  }
  
  private void playFMBrocastList(String paramString)
  {
    int j = 2;
    ArrayList localArrayList = new ArrayList();
    int k;
    int m;
    try
    {
      paramString = new JSONObject(paramString);
      k = paramString.optInt("index");
      m = paramString.optInt("playMode");
      paramString = paramString.getJSONArray("liveList");
      new BroadcastMusicInfo();
      i = 0;
      while (i < paramString.length())
      {
        localArrayList.add(BroadcastMusicInfo.createFromJsonString(paramString.getString(i)).toQusicInfo(NetworkState.isWifiConn()));
        i += 1;
      }
      if (localArrayList.size() <= 0) {
        break label156;
      }
    }
    catch (JSONException paramString)
    {
      QLog.e(this.TAG, 1, "playFMBrocastList 参数异常", paramString);
      return;
    }
    if (m == 1) {}
    for (int i = j;; i = 4)
    {
      this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.11(this, i, k, localArrayList));
      return;
    }
    label156:
    QLog.e(this.TAG, 2, "playAudioListForBgMusic no song in song list");
  }
  
  private static final void showAutoPlayTips(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramContext = bbdj.a(paramContext, 230, null, ajya.a(2131712632), ajya.a(2131712626), ajya.a(2131712628), paramOnClickListener2, paramOnClickListener1);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
  }
  
  private static final void showPlayTips(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    bbdj.a(paramContext, 230, ajya.a(2131712633), "你正处于非WiFi环境，继续播放将会消耗流量，运营商可能会收取费用，是否继续\n", ajya.a(2131712627), ajya.a(2131712634), paramOnClickListener2, paramOnClickListener1).show();
  }
  
  public void changeMusicList(String paramString)
  {
    try
    {
      arsj.a(new JSONObject(paramString), "changeMusicList", null);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getLivingInfo()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.18(this));
  }
  
  public void getPlayMode()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.20(this));
  }
  
  public void getPlayingSongInfo()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.17(this));
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("QzMusic")) {
      return false;
    }
    if ((paramString3.equals("playMusic")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new bhgd(this, paramVarArgs[0]));
      return true;
    }
    if ((paramString3.equals("playMusicList")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new bhgf(this, paramVarArgs[0]));
      return true;
    }
    if ((paramString3.equals("playAudioList")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new bhgm(this, paramVarArgs[0]));
      return true;
    }
    if (("playLiveList".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new bhgo(this, paramVarArgs[0]));
      return true;
    }
    if (paramString3.equals("resumePlay"))
    {
      resumePlay();
      return true;
    }
    if (paramString3.equals("pausePlay"))
    {
      pausePlay();
      return true;
    }
    if ((paramString3.equals("listenMusicState")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      listenMusicState(paramVarArgs[0]);
      return true;
    }
    if (paramString3.equals("musicListChange"))
    {
      musicListChange();
      return true;
    }
    if ((paramString3.equals("setPlayMode")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      setPlayMode(paramVarArgs[0]);
      return true;
    }
    if ((paramString3.equals("setRightButton")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      setRightButton(paramVarArgs[0]);
      return true;
    }
    if (paramString3.equals("getPlayingSongInfo"))
    {
      bhlc.a().a(this);
      getPlayingSongInfo();
      return true;
    }
    if ((paramString3.equals("playMusicList")) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      playMusicList(paramVarArgs[0]);
      return true;
    }
    if (paramString3.equals("getPlayMode"))
    {
      getPlayMode();
      return true;
    }
    if (paramString3.equals("getNetworkType"))
    {
      if (NetworkState.getIsUnicomNetWork()) {
        callNetWorkInterface("true");
      }
      for (;;)
      {
        return true;
        callNetWorkInterface("false");
      }
    }
    if (("playAudioListForBgMusic".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new bhgp(this, paramVarArgs[0]));
      return true;
    }
    if ("FmListChange".equals(paramString3))
    {
      musicListChange();
      return true;
    }
    if ("getLivingInfo".equals(paramString3))
    {
      mFMLiveInfoJsBridgeListener = paramJsBridgeListener;
      getLivingInfo();
      return true;
    }
    if (("changeMusicList".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      changeMusicList(paramVarArgs[0]);
      return true;
    }
    if (("stopPlay".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      stopPlay(paramVarArgs[0]);
      return true;
    }
    QLog.w(this.TAG, 1, "method ：" + paramString3 + " 没有做任何处理。");
    return false;
  }
  
  public void listenMusicState(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).getInt("isOpen");
      if (i == 1)
      {
        if (!this.isWebPageListening)
        {
          bhlc.a().a(this);
          initUserInfo();
        }
        this.isWebPageListening = true;
        this.isUseRemoteMusicManager = true;
        return;
      }
      if (i == 0)
      {
        if (this.isWebPageListening) {
          bhlc.a().b(this);
        }
        this.isWebPageListening = false;
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void musicListChange()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.16(this));
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.isWebPageListening) {
      bhlc.a().a(this);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bhlc.a().b(this);
    if (this.isUseRemoteMusicManager) {
      bhlc.a().a();
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return;
          paramBundle = paramBundle.getBundle("data");
          if (paramBundle != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e(this.TAG, 2, "call js function,bundle is empty");
        return;
        String str = getStateString(paramBundle.getInt("param.state", -1));
        if (!paramString.equals("cmd.notifyStateCallback")) {
          break;
        }
        callWebPageInterface(str, paramBundle);
        bool = paramBundle.getBoolean("param.needPlayTips");
        paramString = this.mRuntime.a();
      } while ((paramString == null) || (paramString.isFinishing()) || (this.isShowing) || (!bool) || (!needPlayTips()));
      pausePlay();
      showPlayTips(paramString, new bhgj(this), new bhgk(this));
      this.isShowing = true;
      return;
      if (paramString.equals("cmd.getPlayMode"))
      {
        callWebPageInterface("playmode", paramBundle);
        return;
      }
      if (paramString.equals("cmd.getPlayingSong"))
      {
        callWebPageInterface("songinfo", paramBundle);
        return;
      }
    } while (!paramString.equals("cmd.getLivingInfo"));
    callNetWorkInterfaceForGetttingLiveInfo("livinginfo", paramBundle);
  }
  
  public void pausePlay()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.13(this));
  }
  
  /* Error */
  public void playAudioList(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 482	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 483	java/util/ArrayList:<init>	()V
    //   10: astore 7
    //   12: new 203	org/json/JSONObject
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 485	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: ldc_w 487
    //   25: invokevirtual 709	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   28: istore_3
    //   29: aload_1
    //   30: ldc_w 770
    //   33: invokevirtual 709	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   36: istore_2
    //   37: aload_1
    //   38: ldc_w 492
    //   41: invokevirtual 496	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   44: astore_1
    //   45: iload_2
    //   46: istore 6
    //   48: iload_3
    //   49: istore 4
    //   51: iload 5
    //   53: aload_1
    //   54: invokevirtual 502	org/json/JSONArray:length	()I
    //   57: if_icmpge +42 -> 99
    //   60: aload 7
    //   62: aload_1
    //   63: iload 5
    //   65: invokevirtual 506	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   68: invokestatic 773	cooperation/qzone/music/QzoneMusicHelper:convertAudioSongInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/music/SongInfo;
    //   71: invokevirtual 516	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   74: pop
    //   75: iload 5
    //   77: iconst_1
    //   78: iadd
    //   79: istore 5
    //   81: goto -36 -> 45
    //   84: astore_1
    //   85: iconst_0
    //   86: istore_3
    //   87: iconst_0
    //   88: istore_2
    //   89: aload_1
    //   90: invokevirtual 594	org/json/JSONException:printStackTrace	()V
    //   93: iload_3
    //   94: istore 4
    //   96: iload_2
    //   97: istore 6
    //   99: aload 7
    //   101: invokevirtual 521	java/util/ArrayList:size	()I
    //   104: ifle +53 -> 157
    //   107: iload 6
    //   109: iconst_1
    //   110: if_icmpeq +9 -> 119
    //   113: iload 6
    //   115: iconst_3
    //   116: if_icmpne +35 -> 151
    //   119: iconst_2
    //   120: istore_2
    //   121: aload_0
    //   122: getfield 143	cooperation/qzone/music/QzoneWebMusicJsPlugin:mRuntime	Lbcdp;
    //   125: invokevirtual 398	bcdp:a	()Lcom/tencent/common/app/AppInterface;
    //   128: ldc 2
    //   130: invokevirtual 404	com/tencent/common/app/AppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   133: new 775	cooperation/qzone/music/QzoneWebMusicJsPlugin$9
    //   136: dup
    //   137: aload_0
    //   138: iload_2
    //   139: iload 4
    //   141: aload 7
    //   143: invokespecial 776	cooperation/qzone/music/QzoneWebMusicJsPlugin$9:<init>	(Lcooperation/qzone/music/QzoneWebMusicJsPlugin;IILjava/util/ArrayList;)V
    //   146: invokevirtual 411	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   149: pop
    //   150: return
    //   151: bipush 6
    //   153: istore_2
    //   154: goto -33 -> 121
    //   157: invokestatic 343	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq -10 -> 150
    //   163: aload_0
    //   164: getfield 83	cooperation/qzone/music/QzoneWebMusicJsPlugin:TAG	Ljava/lang/String;
    //   167: iconst_2
    //   168: ldc_w 778
    //   171: invokestatic 530	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: return
    //   175: astore_1
    //   176: iconst_0
    //   177: istore_2
    //   178: goto -89 -> 89
    //   181: astore_1
    //   182: goto -93 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	QzoneWebMusicJsPlugin
    //   0	185	1	paramString	String
    //   36	142	2	i	int
    //   28	66	3	j	int
    //   49	91	4	k	int
    //   1	79	5	m	int
    //   46	71	6	n	int
    //   10	132	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   12	29	84	org/json/JSONException
    //   29	37	175	org/json/JSONException
    //   37	45	181	org/json/JSONException
    //   51	75	181	org/json/JSONException
  }
  
  public void playMusic(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(QzoneMusicHelper.convertSongInfo(new JSONObject(paramString)));
      if (localArrayList.size() > 0) {
        if (((SongInfo)localArrayList.get(0)).jdField_b_of_type_Int == 6)
        {
          i = 6;
          this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.7(this, i, localArrayList));
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
          continue;
          int i = 1;
        }
      } while (!QLog.isColorLevel());
      QLog.e(this.TAG, 2, "song info error");
    }
  }
  
  public void playMusicList(String paramString)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    label212:
    do
    {
      for (;;)
      {
        try
        {
          paramString = new JSONObject(paramString);
          int i = paramString.getInt("index");
          SongInfo localSongInfo;
          paramString.printStackTrace();
        }
        catch (JSONException paramString)
        {
          try
          {
            paramString = paramString.getJSONArray("songList");
            if (j < paramString.length())
            {
              localSongInfo = QzoneMusicHelper.convertSongInfo(paramString.getJSONObject(j));
              if (localSongInfo.jdField_a_of_type_Long == 0L) {
                localSongInfo.jdField_a_of_type_Long = j;
              }
              localArrayList.add(localSongInfo);
              j += 1;
              continue;
            }
            if ((paramString.length() > 0) && (i < paramString.length()) && (paramString.getJSONObject(0).optInt("isProfileMusicBox", 0) == 1))
            {
              paramString = new JSONObject();
              paramString.put("uin", ((SongInfo)localArrayList.get(i)).jdField_b_of_type_Long);
              paramString.put("coverUrl", ((SongInfo)localArrayList.get(i)).d);
              arsj.a(paramString, "showFloatView", null);
            }
            if (localArrayList.size() <= 0) {
              break;
            }
            this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.8(this, i, localArrayList));
            return;
          }
          catch (JSONException paramString)
          {
            break label212;
          }
          paramString = paramString;
          i = 0;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e(this.TAG, 2, "no song in song list");
  }
  
  public void resumePlay()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.12(this));
  }
  
  public void setPlayMode(String paramString)
  {
    k = 0;
    j = 0;
    if (!NetworkState.isNetSupport())
    {
      bcql.a(BaseApplication.getContext(), 1, QzoneMusicHelper.NO_NETWORK_MSG, 1).a();
      getPlayMode();
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        bool = paramString.optBoolean("randomMode", this.isRandom);
        if (bool) {
          i = 1;
        }
      }
      catch (JSONException paramString)
      {
        boolean bool;
        int i = 0;
        j = k;
        paramString.printStackTrace();
        k = j;
        j = -1;
        continue;
        doSetPlayMode(i, k, j);
        return;
      }
      try
      {
        bool = paramString.optBoolean("autoModeWithWifi", this.isAutoPlay);
        if (bool) {
          k = 1;
        }
      }
      catch (JSONException paramString)
      {
        j = k;
        continue;
      }
      try
      {
        if (!paramString.has("isLoop")) {
          break label225;
        }
        bool = paramString.optBoolean("isLoop");
        if (!bool) {
          continue;
        }
      }
      catch (JSONException paramString)
      {
        j = k;
        continue;
        j = -1;
        continue;
      }
      bool = needSetAutoPlayTips();
      if ((k != 1) || (this.isAutoPlay) || (!bool)) {
        continue;
      }
      showAutoPlayTips(this.mRuntime.a(), new bhgg(this), new bhgh(this, i, k, j), new bhgi(this));
      return;
      i = 0;
      continue;
      k = 0;
      continue;
      j = 1;
    }
  }
  
  public void setRightButton(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("text");
      String str = ((JSONObject)localObject).getString("color");
      boolean bool = ((JSONObject)localObject).getBoolean("visible");
      if ((this.mRuntime.a() instanceof QQBrowserActivity))
      {
        localObject = (TextView)this.mRuntime.a().findViewById(2131368457);
        if (bool) {}
        try
        {
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setTextColor(Color.parseColor("#" + str));
          ((TextView)localObject).setText(paramString);
          ((TextView)localObject).setOnClickListener(new bhge(this));
          return;
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            break label152;
          }
          QLog.e(this.TAG, 2, "set right textview error");
          paramString.printStackTrace();
          return;
        }
        ((TextView)localObject).setVisibility(8);
        return;
      }
    }
    catch (Exception paramString)
    {
      label152:
      paramString.printStackTrace();
    }
  }
  
  public void stopPlay()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.14(this));
  }
  
  public void stopPlay(String paramString)
  {
    try
    {
      if (new JSONObject(paramString).optInt("isProfileMusicBox") == 1) {
        this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.6(this));
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin
 * JD-Core Version:    0.7.0.1
 */