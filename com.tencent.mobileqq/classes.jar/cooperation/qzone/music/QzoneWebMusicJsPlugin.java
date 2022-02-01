package cooperation.qzone.music;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleWebClient;
import com.tencent.mobileqq.music.BroadcastMusicInfo;
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
  public static final String METHOD_STOP_MUSIC_BOX = "stopMusicBox";
  public static final String MUSIC_METHOD_NAMESPACE = "QzMusic";
  public static final String WEB_APP_MUSIC_EVENT = "WEBAPP_MUSIC";
  private static JsBridgeListener mFMLiveInfoJsBridgeListener;
  private String TAG = QzoneWebMusicJsPlugin.class.getSimpleName();
  private boolean isAutoPlay = false;
  public boolean isFlowWarningVisible = false;
  private boolean isLoop = true;
  private boolean isRandom = false;
  private boolean isShowing = false;
  private boolean isUseRemoteMusicManager = false;
  private boolean isWebPageListening = false;
  private Handler mMainHandler = null;
  
  public QzoneWebMusicJsPlugin()
  {
    this.mPluginNameSpace = "QzMusic";
  }
  
  private void callNetWorkInterface(String paramString)
  {
    if (!this.isDestroy)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:try{QQMusicJSInterface.onRecieve({type:\"networktype\",data:{type:\"isUnicomNetwork\",value:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("}})}catch(e){}");
      localCustomWebView.loadUrl(localStringBuilder.toString());
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
    if ((this.isWebPageListening) && (!this.isDestroy))
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:try{QQMusicJSInterface.onRecieve({type:\"WEBAPP_MUSIC\",data:{type:\"");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\"}})}catch(e){}");
      localCustomWebView.loadUrl(localStringBuilder.toString());
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
    JSONObject localJSONObject;
    boolean bool2;
    boolean bool1;
    if (this.isWebPageListening)
    {
      localJSONObject = new JSONObject();
      bool2 = false;
      if (paramBundle != null) {
        try
        {
          SongInfo localSongInfo = (SongInfo)paramBundle.getParcelable("param.song");
          if (localSongInfo != null)
          {
            localJSONObject.put("name", localSongInfo.jdField_c_of_type_JavaLangString);
            localJSONObject.put("singer", localSongInfo.h);
            localJSONObject.put("songId", localSongInfo.a);
            localJSONObject.put("songMid", localSongInfo.g);
            localJSONObject.put("singerId", localSongInfo.jdField_c_of_type_Long);
            localJSONObject.put("type", localSongInfo.jdField_b_of_type_Int);
            localJSONObject.put("cover", localSongInfo.e);
            localJSONObject.put("ownerUin", localSongInfo.jdField_b_of_type_Long);
            localJSONObject.put("playUrl", localSongInfo.jdField_b_of_type_JavaLangString);
            localJSONObject.put("detailUrl", localSongInfo.f);
            if (!TextUtils.isEmpty(localSongInfo.d)) {
              localJSONObject.put("showId", localSongInfo.d);
            }
            int i = localSongInfo.jdField_b_of_type_Int;
            if ((i != 6) && (i != 8))
            {
              if (i != 9) {
                localJSONObject.put("voiceType", 0);
              } else {
                localJSONObject.put("voiceType", 2);
              }
            }
            else {
              localJSONObject.put("voiceType", 1);
            }
          }
          localJSONObject.put("uin", paramBundle.getLong("param.uin"));
          localJSONObject.put("state", getStateString(paramBundle.getInt("param.state", -1)));
          localJSONObject.put("total", paramBundle.getInt("param.duration"));
          localJSONObject.put("curr", paramBundle.getInt("param.currentTime"));
          if (paramBundle.getInt("param.origin") != 2) {
            break label666;
          }
          bool1 = true;
          localJSONObject.put("isDefaultList", bool1);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      if (paramBundle == null) {}
    }
    for (;;)
    {
      try
      {
        if (paramBundle.getInt("param.playModeRandom", 0) != 1) {
          break label672;
        }
        bool1 = true;
        this.isRandom = bool1;
        if (paramBundle.getInt("param.playModeAuto", 0) != 1) {
          break label678;
        }
        bool1 = true;
        this.isAutoPlay = bool1;
        bool1 = bool2;
        if (paramBundle.getInt("param.playModeLoop", 0) == 0) {
          bool1 = true;
        }
        this.isLoop = bool1;
        localJSONObject.put("randomMode", this.isRandom);
        localJSONObject.put("autoModeWithWifi", this.isAutoPlay);
        localJSONObject.put("isLoop", this.isLoop);
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        paramBundle = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" callWebPageInterfaceImpl  ：");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" isdetroy ");
        localStringBuilder.append(this.isDestroy);
        localStringBuilder.append(" value  ");
        localStringBuilder.append(localJSONObject.toString());
        localStringBuilder.append(" plugin ");
        localStringBuilder.append(this);
        QLog.w(paramBundle, 1, localStringBuilder.toString());
      }
      if (!this.isDestroy)
      {
        paramBundle = this.mRuntime.a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:try{QQMusicJSInterface.onRecieve({type:\"WEBAPP_MUSIC\",data:{type:\"");
        localStringBuilder.append(paramString);
        localStringBuilder.append("\",value:");
        localStringBuilder.append(localJSONObject.toString());
        localStringBuilder.append("}})}catch(e){}");
        paramBundle.loadUrl(localStringBuilder.toString());
      }
      return;
      label666:
      bool1 = false;
      break;
      label672:
      bool1 = false;
      continue;
      label678:
      bool1 = false;
    }
  }
  
  private void doPlayMusicOrAudioCommon(QzoneWebMusicJsPlugin.onUserConfirmListener paramonUserConfirmListener)
  {
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (needPlayTips()))
    {
      showPlayTips(localActivity, new QzoneWebMusicJsPlugin.29(this, paramonUserConfirmListener), new QzoneWebMusicJsPlugin.30(this));
      this.isFlowWarningVisible = true;
      return;
    }
    if (paramonUserConfirmListener != null) {
      paramonUserConfirmListener.onConfirm();
    }
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
      str2 = Uri.parse(str1).getQueryParameter("guestuin");
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
      String str2;
      if (QLog.isColorLevel())
      {
        str2 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("illegal guestuin,url=");
        localStringBuilder.append((String)localObject);
        QLog.e(str2, 2, localStringBuilder.toString(), localException);
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
    case 5: 
    case 7: 
      return "error";
    case 4: 
    case 6: 
      return "stop";
    case 3: 
      return "paused";
    case 2: 
      return "playing";
    }
    return "buffering";
  }
  
  private void initUserInfo()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.15(this));
  }
  
  private boolean needPlayTips()
  {
    boolean bool3 = NetworkState.isMobile();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
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
    try
    {
      paramString = new JSONObject(paramString);
      int j = paramString.optInt("index");
      paramString = paramString.getJSONArray("songList");
      int i = 0;
      while (i < paramString.length())
      {
        localArrayList.add(QzoneMusicHelper.convertFMBgMusic(paramString.getJSONObject(i)));
        i += 1;
      }
      if (localArrayList.size() > 0)
      {
        this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.10(this, j, localArrayList));
        return;
      }
      QLog.e(this.TAG, 2, "playAudioListForBgMusic no song in song list");
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e(this.TAG, 1, "playAudioListForBgMusic 参数异常", paramString);
    }
  }
  
  private void playFMBrocastList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString);
      int j = paramString.optInt("index");
      int k = paramString.optInt("playMode");
      paramString = paramString.getJSONArray("liveList");
      new BroadcastMusicInfo();
      int i = 0;
      while (i < paramString.length())
      {
        localArrayList.add(BroadcastMusicInfo.a(paramString.getString(i)).a(NetworkState.isWifiConn()));
        i += 1;
      }
      int m = localArrayList.size();
      i = 2;
      if (m > 0)
      {
        if (k != 1) {
          i = 4;
        }
        this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.11(this, i, j, localArrayList));
        return;
      }
      QLog.e(this.TAG, 2, "playAudioListForBgMusic no song in song list");
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e(this.TAG, 1, "playFMBrocastList 参数异常", paramString);
    }
  }
  
  private static final void showAutoPlayTips(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramContext = DialogUtil.a(paramContext, 230, null, HardCodeUtil.a(2131712573), HardCodeUtil.a(2131712567), HardCodeUtil.a(2131712569), paramOnClickListener2, paramOnClickListener1);
    paramContext.setOnCancelListener(paramOnCancelListener);
    paramContext.show();
  }
  
  private static final void showPlayTips(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    DialogUtil.a(paramContext, 230, HardCodeUtil.a(2131712574), "你正处于非WiFi环境，继续播放将会消耗流量，运营商可能会收取费用，是否继续\n", HardCodeUtil.a(2131712568), HardCodeUtil.a(2131712575), paramOnClickListener2, paramOnClickListener1).show();
  }
  
  public void changeMusicList(String paramString)
  {
    try
    {
      ListenTogetherIPCModuleWebClient.a(new JSONObject(paramString), "changeMusicList", null);
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
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!paramString2.equals("QzMusic")) {
      return false;
    }
    if ((paramString3.equals("playMusic")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new QzoneWebMusicJsPlugin.1(this, paramVarArgs[0]));
      return true;
    }
    if ((paramString3.equals("playMusicList")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new QzoneWebMusicJsPlugin.2(this, paramVarArgs[0]));
      return true;
    }
    if ((paramString3.equals("playAudioList")) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new QzoneWebMusicJsPlugin.3(this, paramVarArgs[0]));
      return true;
    }
    if (("playLiveList".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new QzoneWebMusicJsPlugin.4(this, paramVarArgs[0]));
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
      RemoteHandleManager.getInstance().addWebEventListener(this);
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
      if (NetworkState.getIsUnicomNetWork())
      {
        callNetWorkInterface("true");
        return true;
      }
      callNetWorkInterface("false");
      return true;
    }
    if (("playAudioListForBgMusic".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (!this.isFlowWarningVisible))
    {
      doPlayMusicOrAudioCommon(new QzoneWebMusicJsPlugin.5(this, paramVarArgs[0]));
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
    paramJsBridgeListener = this.TAG;
    paramString1 = new StringBuilder();
    paramString1.append("method ：");
    paramString1.append(paramString3);
    paramString1.append(" 没有做任何处理。");
    QLog.w(paramJsBridgeListener, 1, paramString1.toString());
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
          RemoteHandleManager.getInstance().addWebEventListener(this);
          initUserInfo();
        }
        this.isWebPageListening = true;
        this.isUseRemoteMusicManager = true;
        return;
      }
      if (i == 0)
      {
        if (this.isWebPageListening) {
          RemoteHandleManager.getInstance().removeWebEventListener(this);
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
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.isWebPageListening) {
      RemoteHandleManager.getInstance().addWebEventListener(this);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    RemoteHandleManager.getInstance().removeWebEventListener(this);
    if (this.isUseRemoteMusicManager) {
      RemoteHandleManager.getInstance().destroy();
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("data")) {
        return;
      }
      paramBundle = paramBundle.getBundle("data");
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "call js function,bundle is empty");
        }
        return;
      }
      String str = getStateString(paramBundle.getInt("param.state", -1));
      if (paramString.equals("cmd.notifyStateCallback"))
      {
        callWebPageInterface(str, paramBundle);
        boolean bool = paramBundle.getBoolean("param.needPlayTips");
        paramString = this.mRuntime.a();
        if ((paramString != null) && (!paramString.isFinishing()) && (!this.isShowing) && (bool) && (needPlayTips()))
        {
          pausePlay();
          showPlayTips(paramString, new QzoneWebMusicJsPlugin.27(this), new QzoneWebMusicJsPlugin.28(this));
          this.isShowing = true;
        }
      }
      else
      {
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
        if (paramString.equals("cmd.getLivingInfo")) {
          callNetWorkInterfaceForGetttingLiveInfo("livinginfo", paramBundle);
        }
      }
    }
  }
  
  public void pausePlay()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.13(this));
  }
  
  /* Error */
  public void playAudioList(String paramString)
  {
    // Byte code:
    //   0: new 486	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 487	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: iconst_0
    //   10: istore 6
    //   12: new 211	org/json/JSONObject
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 489	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: ldc_w 491
    //   25: invokevirtual 713	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   28: istore_2
    //   29: aload_1
    //   30: ldc_w 775
    //   33: invokevirtual 713	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   36: istore 5
    //   38: aload_1
    //   39: ldc_w 496
    //   42: invokevirtual 500	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   45: astore_1
    //   46: iload 5
    //   48: istore_3
    //   49: iload_2
    //   50: istore 4
    //   52: iload 6
    //   54: aload_1
    //   55: invokevirtual 506	org/json/JSONArray:length	()I
    //   58: if_icmpge +50 -> 108
    //   61: aload 7
    //   63: aload_1
    //   64: iload 6
    //   66: invokevirtual 510	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   69: invokestatic 778	cooperation/qzone/music/QzoneMusicHelper:convertAudioSongInfo	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/music/SongInfo;
    //   72: invokevirtual 520	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   75: pop
    //   76: iload 6
    //   78: iconst_1
    //   79: iadd
    //   80: istore 6
    //   82: goto -36 -> 46
    //   85: astore_1
    //   86: iload 5
    //   88: istore_3
    //   89: goto +12 -> 101
    //   92: astore_1
    //   93: goto +6 -> 99
    //   96: astore_1
    //   97: iconst_0
    //   98: istore_2
    //   99: iconst_0
    //   100: istore_3
    //   101: aload_1
    //   102: invokevirtual 596	org/json/JSONException:printStackTrace	()V
    //   105: iload_2
    //   106: istore 4
    //   108: aload 7
    //   110: invokevirtual 523	java/util/ArrayList:size	()I
    //   113: istore_2
    //   114: iconst_2
    //   115: istore 5
    //   117: iload_2
    //   118: ifle +55 -> 173
    //   121: iload 5
    //   123: istore_2
    //   124: iload_3
    //   125: iconst_1
    //   126: if_icmpeq +17 -> 143
    //   129: iload_3
    //   130: iconst_3
    //   131: if_icmpne +9 -> 140
    //   134: iload 5
    //   136: istore_2
    //   137: goto +6 -> 143
    //   140: bipush 6
    //   142: istore_2
    //   143: aload_0
    //   144: getfield 153	cooperation/qzone/music/QzoneWebMusicJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   147: invokevirtual 402	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   150: ldc 2
    //   152: invokevirtual 408	com/tencent/common/app/AppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   155: new 780	cooperation/qzone/music/QzoneWebMusicJsPlugin$9
    //   158: dup
    //   159: aload_0
    //   160: iload_2
    //   161: iload 4
    //   163: aload 7
    //   165: invokespecial 781	cooperation/qzone/music/QzoneWebMusicJsPlugin$9:<init>	(Lcooperation/qzone/music/QzoneWebMusicJsPlugin;IILjava/util/ArrayList;)V
    //   168: invokevirtual 415	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   171: pop
    //   172: return
    //   173: invokestatic 351	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +14 -> 190
    //   179: aload_0
    //   180: getfield 83	cooperation/qzone/music/QzoneWebMusicJsPlugin:TAG	Ljava/lang/String;
    //   183: iconst_2
    //   184: ldc_w 783
    //   187: invokestatic 532	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	QzoneWebMusicJsPlugin
    //   0	191	1	paramString	String
    //   28	133	2	i	int
    //   48	84	3	j	int
    //   50	112	4	k	int
    //   36	99	5	m	int
    //   10	71	6	n	int
    //   7	157	7	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   38	46	85	org/json/JSONException
    //   52	76	85	org/json/JSONException
    //   29	38	92	org/json/JSONException
    //   12	29	96	org/json/JSONException
  }
  
  public void playMusic(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(QzoneMusicHelper.convertSongInfo(new JSONObject(paramString)));
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    if (localArrayList.size() > 0)
    {
      int j = ((SongInfo)localArrayList.get(0)).jdField_b_of_type_Int;
      int i = 6;
      if (j != 6) {
        i = 1;
      }
      this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.7(this, i, localArrayList));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.TAG, 2, "song info error");
    }
  }
  
  public void playMusicList(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    try
    {
      paramString = new JSONObject(paramString);
      i = paramString.getInt("index");
      try
      {
        paramString = paramString.getJSONArray("songList");
        j = 0;
        while (j < paramString.length())
        {
          SongInfo localSongInfo = QzoneMusicHelper.convertSongInfo(paramString.getJSONObject(j));
          if (localSongInfo.a == 0L) {
            localSongInfo.a = j;
          }
          localArrayList.add(localSongInfo);
          j += 1;
        }
        j = i;
        if (paramString.length() <= 0) {
          break label197;
        }
        j = i;
        if (i >= paramString.length()) {
          break label197;
        }
        j = i;
        if (paramString.getJSONObject(0).optInt("isProfileMusicBox", 0) != 1) {
          break label197;
        }
        paramString = new JSONObject();
        paramString.put("uin", ((SongInfo)localArrayList.get(i)).jdField_b_of_type_Long);
        paramString.put("coverUrl", ((SongInfo)localArrayList.get(i)).e);
        ListenTogetherIPCModuleWebClient.a(paramString, "showFloatView", null);
        j = i;
      }
      catch (JSONException paramString) {}
      paramString.printStackTrace();
    }
    catch (JSONException paramString)
    {
      i = 0;
    }
    int j = i;
    label197:
    if (localArrayList.size() > 0)
    {
      this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.8(this, j, localArrayList));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.TAG, 2, "no song in song list");
    }
  }
  
  public void resumePlay()
  {
    this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.12(this));
  }
  
  public void setPlayMode(String paramString)
  {
    if (!NetworkState.isNetSupport())
    {
      QQToast.a(BaseApplication.getContext(), 1, QzoneMusicHelper.NO_NETWORK_MSG, 1).a();
      getPlayMode();
      return;
    }
    int i2 = -1;
    int k = 0;
    int m = 0;
    int j = 0;
    int i;
    try
    {
      paramString = new JSONObject(paramString);
      bool = paramString.optBoolean("randomMode", this.isRandom);
      if (bool) {
        i = 1;
      } else {
        i = 0;
      }
      try
      {
        if (paramString.optBoolean("autoModeWithWifi", this.isAutoPlay)) {
          j = 1;
        }
        k = j;
        n = i2;
        i1 = j;
        m = i;
        if (!paramString.has("isLoop")) {
          break label163;
        }
        k = j;
        bool = paramString.optBoolean("isLoop");
        n = bool ^ true;
        i1 = j;
        m = i;
      }
      catch (JSONException paramString) {}
      paramString.printStackTrace();
    }
    catch (JSONException paramString)
    {
      i = 0;
      k = m;
    }
    m = i;
    int i1 = k;
    int n = i2;
    label163:
    boolean bool = needSetAutoPlayTips();
    if ((i1 == 1) && (!this.isAutoPlay) && (bool))
    {
      showAutoPlayTips(this.mRuntime.a(), new QzoneWebMusicJsPlugin.21(this), new QzoneWebMusicJsPlugin.22(this, m, i1, n), new QzoneWebMusicJsPlugin.23(this));
      return;
    }
    doSetPlayMode(m, i1, n);
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
        localObject = (TextView)this.mRuntime.a().findViewById(2131369233);
        if (bool) {}
        try
        {
          ((TextView)localObject).setVisibility(0);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("#");
          localStringBuilder.append(str);
          ((TextView)localObject).setTextColor(Color.parseColor(localStringBuilder.toString()));
          ((TextView)localObject).setText(paramString);
          ((TextView)localObject).setOnClickListener(new QzoneWebMusicJsPlugin.19(this));
          return;
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            break label162;
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
      label162:
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
      if (new JSONObject(paramString).optInt("isProfileMusicBox") == 1)
      {
        this.mRuntime.a().getHandler(QzoneWebMusicJsPlugin.class).post(new QzoneWebMusicJsPlugin.6(this));
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin
 * JD-Core Version:    0.7.0.1
 */