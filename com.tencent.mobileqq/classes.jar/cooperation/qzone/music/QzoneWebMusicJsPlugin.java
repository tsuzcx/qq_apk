package cooperation.qzone.music;

import amfd;
import amfe;
import amff;
import amfg;
import amfh;
import amfi;
import amfj;
import amfk;
import amfl;
import amfm;
import amfn;
import amfo;
import amfp;
import amfq;
import amfr;
import amfs;
import amft;
import amfu;
import amfv;
import amfw;
import amfx;
import amfy;
import amfz;
import amga;
import amgb;
import amgc;
import amgf;
import amgg;
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
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneWebMusicJsPlugin
  extends WebViewPlugin
  implements WebEventListener
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
    this.mMainHandler.post(new amft(this, paramBundle));
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
    this.mMainHandler.post(new amfu(this, paramString, paramBundle));
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
        break label210;
      }
      localJSONObject.put("name", localSongInfo.jdField_b_of_type_JavaLangString);
      localJSONObject.put("singer", localSongInfo.g);
      localJSONObject.put("songId", localSongInfo.jdField_a_of_type_Long);
      localJSONObject.put("singerId", localSongInfo.jdField_b_of_type_Long);
      localJSONObject.put("type", localSongInfo.jdField_a_of_type_Int);
      localJSONObject.put("cover", localSongInfo.d);
      localJSONObject.put("playUrl", localSongInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("detailUrl", localSongInfo.e);
      if (!TextUtils.isEmpty(localSongInfo.c)) {
        localJSONObject.put("showId", localSongInfo.c);
      }
      switch (localSongInfo.jdField_a_of_type_Int)
      {
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label210:
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
          break label569;
        }
        bool = true;
        this.isRandom = bool;
        if (paramBundle.getInt("param.playModeAuto", 0) != 1) {
          break label574;
        }
        bool = true;
        this.isAutoPlay = bool;
        if (paramBundle.getInt("param.playModeLoop", 0) != 0) {
          break label579;
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
  
  private void doPlayMusicOrAudioCommon(amgg paramamgg)
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (needPlayTips()))
    {
      showPlayTips(localActivity, new amfx(this, paramamgg), new amfy(this));
      this.isFlowWarningVisible = true;
    }
    while (paramamgg == null) {
      return;
    }
    paramamgg.a();
  }
  
  private void doSetPlayMode(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new amfs(this, paramInt1, paramInt2, paramInt3));
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
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new amfi(this));
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
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new amgf(this, j, localArrayList));
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
      this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new amfe(this, i, k, localArrayList));
      return;
    }
    label156:
    QLog.e(this.TAG, 2, "playAudioListForBgMusic no song in song list");
  }
  
  private static final void showAutoPlayTips(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramContext = DialogUtil.a(paramContext, 230, null, "打开后，wifi环境下访问自己和好友的空间将自动播放背景音乐", "取消", "知道了", paramOnClickListener2, paramOnClickListener1);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
  }
  
  private static final void showPlayTips(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    DialogUtil.a(paramContext, 230, "流量提示", "你正处于非WiFi环境，继续播放将会消耗流量，运营商可能会收取费用，是否继续\n", "继续", "取消", paramOnClickListener2, paramOnClickListener1).show();
  }
  
  public void getLivingInfo()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new amfl(this));
  }
  
  public void getPlayMode()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new amfn(this));
  }
  
  public void getPlayingSongInfo()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new amfk(this));
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("QzMusic")) {
      return false;
    }
    if ((paramString3.equals("playMusic")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new amfd(this, paramVarArgs[0]));
      return true;
    }
    if ((paramString3.equals("playMusicList")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new amfo(this, paramVarArgs[0]));
      return true;
    }
    if ((paramString3.equals("playAudioList")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new amfz(this, paramVarArgs[0]));
      return true;
    }
    if (("playLiveList".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new amga(this, paramVarArgs[0]));
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
      doPlayMusicOrAudioCommon(new amgb(this, paramVarArgs[0]));
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
          RemoteHandleManager.a().a(this);
          initUserInfo();
        }
        this.isWebPageListening = true;
        this.isUseRemoteMusicManager = true;
        return;
      }
      if (i == 0)
      {
        if (this.isWebPageListening) {
          RemoteHandleManager.a().b(this);
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
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new amfj(this));
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.isWebPageListening) {
      RemoteHandleManager.a().a(this);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    RemoteHandleManager.a().b(this);
    if (this.isUseRemoteMusicManager) {
      RemoteHandleManager.a().a();
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
      showPlayTips(paramString, new amfv(this), new amfw(this));
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
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new amfg(this));
  }
  
  /* Error */
  public void playAudioList(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 470	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 471	java/util/ArrayList:<init>	()V
    //   10: astore 7
    //   12: new 200	org/json/JSONObject
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 473	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: ldc_w 475
    //   25: invokevirtual 675	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   28: istore_3
    //   29: aload_1
    //   30: ldc_w 744
    //   33: invokevirtual 675	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   36: istore_2
    //   37: aload_1
    //   38: ldc_w 480
    //   41: invokevirtual 484	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   44: astore_1
    //   45: iload_2
    //   46: istore 6
    //   48: iload_3
    //   49: istore 4
    //   51: iload 5
    //   53: aload_1
    //   54: invokevirtual 490	org/json/JSONArray:length	()I
    //   57: if_icmpge +42 -> 99
    //   60: aload 7
    //   62: aload_1
    //   63: iload 5
    //   65: invokevirtual 494	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   68: invokestatic 747	cooperation/qzone/music/QzoneMusicHelper:convertAudioSongInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/music/SongInfo;
    //   71: invokevirtual 504	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   90: invokevirtual 748	org/json/JSONException:printStackTrace	()V
    //   93: iload_3
    //   94: istore 4
    //   96: iload_2
    //   97: istore 6
    //   99: aload 7
    //   101: invokevirtual 509	java/util/ArrayList:size	()I
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
    //   122: getfield 140	cooperation/qzone/music/QzoneWebMusicJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   125: invokevirtual 386	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   128: ldc 2
    //   130: invokevirtual 392	com/tencent/common/app/AppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   133: new 750	amge
    //   136: dup
    //   137: aload_0
    //   138: iload_2
    //   139: iload 4
    //   141: aload 7
    //   143: invokespecial 751	amge:<init>	(Lcooperation/qzone/music/QzoneWebMusicJsPlugin;IILjava/util/ArrayList;)V
    //   146: invokevirtual 399	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   149: pop
    //   150: return
    //   151: bipush 6
    //   153: istore_2
    //   154: goto -33 -> 121
    //   157: invokestatic 331	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq -10 -> 150
    //   163: aload_0
    //   164: getfield 80	cooperation/qzone/music/QzoneWebMusicJsPlugin:TAG	Ljava/lang/String;
    //   167: iconst_2
    //   168: ldc_w 753
    //   171: invokestatic 518	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
        if (((SongInfo)localArrayList.get(0)).jdField_a_of_type_Int == 6)
        {
          i = 6;
          this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new amgc(this, i, localArrayList));
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
  
  /* Error */
  public void playMusicList(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 470	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 471	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: new 200	org/json/JSONObject
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 473	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload_1
    //   21: ldc_w 475
    //   24: invokevirtual 675	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   27: istore_2
    //   28: aload_1
    //   29: ldc_w 480
    //   32: invokevirtual 484	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   35: astore_1
    //   36: iload_2
    //   37: istore 4
    //   39: iload_3
    //   40: aload_1
    //   41: invokevirtual 490	org/json/JSONArray:length	()I
    //   44: if_icmpge +34 -> 78
    //   47: aload 5
    //   49: aload_1
    //   50: iload_3
    //   51: invokevirtual 494	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   54: invokestatic 756	cooperation/qzone/music/QzoneMusicHelper:convertSongInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/music/SongInfo;
    //   57: invokevirtual 504	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: iload_3
    //   62: iconst_1
    //   63: iadd
    //   64: istore_3
    //   65: goto -29 -> 36
    //   68: astore_1
    //   69: iconst_0
    //   70: istore_2
    //   71: aload_1
    //   72: invokevirtual 748	org/json/JSONException:printStackTrace	()V
    //   75: iload_2
    //   76: istore 4
    //   78: aload 5
    //   80: invokevirtual 509	java/util/ArrayList:size	()I
    //   83: ifle +32 -> 115
    //   86: aload_0
    //   87: getfield 140	cooperation/qzone/music/QzoneWebMusicJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   90: invokevirtual 386	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   93: ldc 2
    //   95: invokevirtual 392	com/tencent/common/app/AppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   98: new 767	amgd
    //   101: dup
    //   102: aload_0
    //   103: iload 4
    //   105: aload 5
    //   107: invokespecial 768	amgd:<init>	(Lcooperation/qzone/music/QzoneWebMusicJsPlugin;ILjava/util/ArrayList;)V
    //   110: invokevirtual 399	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   113: pop
    //   114: return
    //   115: invokestatic 331	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq -4 -> 114
    //   121: aload_0
    //   122: getfield 80	cooperation/qzone/music/QzoneWebMusicJsPlugin:TAG	Ljava/lang/String;
    //   125: iconst_2
    //   126: ldc_w 753
    //   129: invokestatic 518	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: return
    //   133: astore_1
    //   134: goto -63 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	QzoneWebMusicJsPlugin
    //   0	137	1	paramString	String
    //   27	49	2	i	int
    //   1	64	3	j	int
    //   37	67	4	k	int
    //   9	97	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   11	28	68	org/json/JSONException
    //   28	36	133	org/json/JSONException
    //   39	61	133	org/json/JSONException
  }
  
  public void resumePlay()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new amff(this));
  }
  
  public void setPlayMode(String paramString)
  {
    k = 0;
    j = 0;
    if (!NetworkState.isNetSupport())
    {
      QQToast.a(BaseApplication.getContext(), 1, "无网络情况下无法修改设置", 1).a();
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
      showAutoPlayTips(this.mRuntime.a(), new amfp(this), new amfq(this, i, k, j), new amfr(this));
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
        localObject = (TextView)this.mRuntime.a().findViewById(2131363410);
        if (bool) {}
        try
        {
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setTextColor(Color.parseColor("#" + str));
          ((TextView)localObject).setText(paramString);
          ((TextView)localObject).setOnClickListener(new amfm(this));
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
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new amfh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin
 * JD-Core Version:    0.7.0.1
 */