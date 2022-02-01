package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletCommonJsPlugin$QWVideoJsPlugin
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Handler.Callback
{
  static final String ACTION_DOWNLOAD = "downloadVideo";
  static final String ACTION_INIT = "initVideo";
  static final String ACTION_ISVIDEOEXIST = "isExistVideo";
  static final String ACTION_PAUSE = "pauseVideo";
  static final String ACTION_PLAY = "playVideo";
  static final String ACTION_STOP = "stopVideo";
  static final String KEY_DURATION = "videoDuration";
  static final String KEY_PLAYTIMEINTERVAL = "callbackInterval";
  static final String KEY_POS = "currentTime";
  static final String KEY_RESULTCODE = "resultCode";
  static final String KEY_RESULTMSG = "resultMsg";
  static final String KEY_STATUS = "videoStatus";
  static final String KEY_VID = "videoID";
  static final String KEY_VIDEOCFG = "videoConfig";
  static final String KEY_VIDEOURL = "downloadURLs";
  static final int MSG_PLAY_STATUS = 2;
  static final int MSG_PROGRESS = 1;
  static final int RESULTCODE_ERR = -1;
  static final int RESULTCODE_NO_MEM = -2;
  static final int RESULTCODE_OK = 0;
  static final int RSP_PLAYING = 2;
  static final int RSP_PLAY_END = 3;
  static final int RSP_PLAY_START = 1;
  static final int STATUS_END = 4;
  static final int STATUS_ERR = 5;
  static final int STATUS_PAUSE = 3;
  static final int STATUS_PLAYING = 2;
  static final int STATUS_READY = 1;
  static final int STATUS_UNKNOWN = 0;
  static final String TAG = "QWalletCommonJsPlugin";
  final HashMap<String, HashMap<String, String>> mCallbacks = new HashMap();
  private Context mContext;
  private long mDelayMillis = 0L;
  WebViewPlugin mExtPlugin;
  private Handler mHandler;
  private String mVid;
  final HashMap<String, QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView> mVideoViews = new HashMap();
  private IPreloadServiceProxy preloadManager;
  private ViewGroup videoLayout;
  private ViewGroup videoParent;
  
  public QWalletCommonJsPlugin$QWVideoJsPlugin(QWalletCommonJsPlugin paramQWalletCommonJsPlugin, Context paramContext, WebViewPlugin paramWebViewPlugin, AppInterface paramAppInterface)
  {
    this.mContext = paramContext;
    this.mHandler = new WeakReferenceHandler(this);
    this.mExtPlugin = paramWebViewPlugin;
    this.preloadManager = ((IPreloadServiceProxy)paramAppInterface.getRuntimeService(IPreloadServiceProxy.class, "multi"));
  }
  
  private void callbackJs(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    String str2 = getCacheCallback(paramString1, paramString2);
    Object localObject;
    if ((this.mExtPlugin != null) && (!TextUtils.isEmpty(str2)))
    {
      if (paramJSONObject != null) {
        try
        {
          paramJSONObject.put("videoID", paramString2);
          String str1 = paramJSONObject.toString();
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QWalletCommonJsPlugin", 2, "callbackJs,exc.", localJSONException);
          }
        }
      } else {
        localObject = "";
      }
      this.mExtPlugin.callJs(str2, new String[] { localObject });
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("callbackJs,action:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",cbId:");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(",vid:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",cb_json:");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("QWalletCommonJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private String getCacheCallback(String paramString1, String paramString2)
  {
    paramString1 = (HashMap)this.mCallbacks.get(paramString1);
    if (paramString1 != null) {
      return (String)paramString1.get(paramString2);
    }
    return null;
  }
  
  private String getInnerVideoPath(String paramString)
  {
    return this.preloadManager.getVideoResPathByID(paramString);
  }
  
  private void js_download(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    setCacheCallback("downloadVideo", paramString1, paramString2);
    if (paramJSONObject != null) {
      paramString2 = paramJSONObject.optString("videoConfig");
    } else {
      paramString2 = null;
    }
    this.preloadManager.downloadModule(paramString1, paramString2, new QWalletCommonJsPlugin.QWVideoJsPlugin.1(this, paramString1));
  }
  
  /* Error */
  private void js_init(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 19
    //   3: aload_1
    //   4: aload_2
    //   5: invokespecial 242	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin$QWVideoJsPlugin:setCacheCallback	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   8: new 175	org/json/JSONObject
    //   11: dup
    //   12: invokespecial 258	org/json/JSONObject:<init>	()V
    //   15: astore 13
    //   17: aload_0
    //   18: getfield 123	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin$QWVideoJsPlugin:mContext	Landroid/content/Context;
    //   21: invokevirtual 264	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   24: invokevirtual 270	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   27: getfield 275	android/util/DisplayMetrics:widthPixels	I
    //   30: istore 8
    //   32: aload_0
    //   33: getfield 123	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin$QWVideoJsPlugin:mContext	Landroid/content/Context;
    //   36: invokevirtual 264	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   39: invokevirtual 270	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   42: getfield 278	android/util/DisplayMetrics:heightPixels	I
    //   45: istore 12
    //   47: aload_3
    //   48: ldc_w 280
    //   51: iconst_0
    //   52: invokevirtual 284	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   55: istore 5
    //   57: aload_3
    //   58: ldc_w 286
    //   61: iconst_0
    //   62: invokevirtual 284	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   65: istore 7
    //   67: iload 8
    //   69: istore 6
    //   71: aload_3
    //   72: ldc_w 288
    //   75: iload 8
    //   77: invokevirtual 284	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   80: istore 8
    //   82: iload 8
    //   84: istore 6
    //   86: aload_3
    //   87: ldc_w 290
    //   90: iload 12
    //   92: invokevirtual 284	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   95: istore 9
    //   97: iload 5
    //   99: istore 10
    //   101: iload 7
    //   103: istore 11
    //   105: goto +71 -> 176
    //   108: astore_2
    //   109: goto +18 -> 127
    //   112: astore_2
    //   113: goto +7 -> 120
    //   116: astore_2
    //   117: iconst_0
    //   118: istore 5
    //   120: iconst_0
    //   121: istore 7
    //   123: iload 8
    //   125: istore 6
    //   127: iload 6
    //   129: istore 8
    //   131: iload 12
    //   133: istore 9
    //   135: iload 5
    //   137: istore 10
    //   139: iload 7
    //   141: istore 11
    //   143: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +30 -> 176
    //   149: ldc 84
    //   151: iconst_2
    //   152: aload_2
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   160: iload 7
    //   162: istore 11
    //   164: iload 5
    //   166: istore 10
    //   168: iload 12
    //   170: istore 9
    //   172: iload 6
    //   174: istore 8
    //   176: new 295	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin$QWVideoJsPlugin$MyVideoView
    //   179: dup
    //   180: aload_0
    //   181: aload_0
    //   182: getfield 123	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin$QWVideoJsPlugin:mContext	Landroid/content/Context;
    //   185: invokespecial 298	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin$QWVideoJsPlugin$MyVideoView:<init>	(Lcom/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin$QWVideoJsPlugin;Landroid/content/Context;)V
    //   188: astore_2
    //   189: aload_2
    //   190: aload_1
    //   191: invokevirtual 302	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin$QWVideoJsPlugin$MyVideoView:setTag	(Ljava/lang/Object;)V
    //   194: aload_0
    //   195: getfield 123	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin$QWVideoJsPlugin:mContext	Landroid/content/Context;
    //   198: invokevirtual 264	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   201: invokevirtual 270	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   204: getfield 306	android/util/DisplayMetrics:density	F
    //   207: fstore 4
    //   209: new 308	android/widget/FrameLayout$LayoutParams
    //   212: dup
    //   213: iload 8
    //   215: iload 9
    //   217: invokespecial 311	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   220: astore_3
    //   221: aload_3
    //   222: iload 10
    //   224: i2f
    //   225: fload 4
    //   227: fmul
    //   228: f2i
    //   229: iload 11
    //   231: i2f
    //   232: fload 4
    //   234: fmul
    //   235: f2i
    //   236: iconst_0
    //   237: iconst_0
    //   238: invokevirtual 315	android/widget/FrameLayout$LayoutParams:setMargins	(IIII)V
    //   241: aload_0
    //   242: getfield 317	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin$QWVideoJsPlugin:videoLayout	Landroid/view/ViewGroup;
    //   245: aload_2
    //   246: aload_3
    //   247: invokevirtual 323	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   250: aload_0
    //   251: getfield 117	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin$QWVideoJsPlugin:mVideoViews	Ljava/util/HashMap;
    //   254: aload_1
    //   255: aload_2
    //   256: invokevirtual 326	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: aload 13
    //   262: ldc 43
    //   264: iconst_0
    //   265: invokevirtual 329	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 13
    //   271: ldc 49
    //   273: iconst_0
    //   274: invokevirtual 329	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   277: pop
    //   278: goto +51 -> 329
    //   281: astore_2
    //   282: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +14 -> 299
    //   288: ldc 84
    //   290: iconst_2
    //   291: aload_2
    //   292: iconst_0
    //   293: anewarray 4	java/lang/Object
    //   296: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   299: aload 13
    //   301: ldc 43
    //   303: iconst_m1
    //   304: invokevirtual 329	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   307: pop
    //   308: goto +21 -> 329
    //   311: astore_2
    //   312: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +14 -> 329
    //   318: ldc 84
    //   320: iconst_2
    //   321: aload_2
    //   322: iconst_0
    //   323: anewarray 4	java/lang/Object
    //   326: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   329: aload_0
    //   330: ldc 19
    //   332: aload_1
    //   333: aload 13
    //   335: invokespecial 151	com/tencent/mobileqq/vaswebviewplugin/QWalletCommonJsPlugin$QWVideoJsPlugin:callbackJs	(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   338: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	QWVideoJsPlugin
    //   0	339	1	paramString1	String
    //   0	339	2	paramString2	String
    //   0	339	3	paramJSONObject	JSONObject
    //   207	26	4	f	float
    //   55	110	5	i	int
    //   69	104	6	j	int
    //   65	96	7	k	int
    //   30	184	8	m	int
    //   95	121	9	n	int
    //   99	124	10	i1	int
    //   103	127	11	i2	int
    //   45	124	12	i3	int
    //   15	319	13	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   71	82	108	java/lang/Exception
    //   86	97	108	java/lang/Exception
    //   57	67	112	java/lang/Exception
    //   47	57	116	java/lang/Exception
    //   17	47	281	java/lang/Exception
    //   143	160	281	java/lang/Exception
    //   176	278	281	java/lang/Exception
    //   299	308	311	org/json/JSONException
  }
  
  private void js_isVideoExist(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    setCacheCallback("isExistVideo", paramString1, paramString2);
    int i;
    if (TextUtils.isEmpty(getInnerVideoPath(paramString1))) {
      i = -1;
    } else {
      i = 0;
    }
    paramString2 = new JSONObject();
    try
    {
      paramString2.put("resultCode", i);
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QWalletCommonJsPlugin", 2, paramJSONObject, new Object[0]);
      }
    }
    callbackJs("isExistVideo", paramString1, paramString2);
  }
  
  private void js_pause(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    resumeOrPause(false, true);
    this.mHandler.removeMessages(1);
    setCacheCallback("pauseVideo", paramString1, paramString2);
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("resultCode", 0);
      paramString1.put("videoStatus", 3);
    }
    catch (JSONException paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QWalletCommonJsPlugin", 2, paramString2, new Object[0]);
      }
    }
    callbackJs("pauseVideo", this.mVid, paramString1);
  }
  
  private void js_play(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    setCacheCallback("playVideo", paramString1, paramString2);
    paramString2 = (QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)this.mVideoViews.get(paramString1);
    if (paramString2 != null)
    {
      if (paramString2.testFlag(2))
      {
        resumeOrPause(true, false);
      }
      else
      {
        Object localObject = getInnerVideoPath(paramString1);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramString2.setOnPreparedListener(this);
          paramString2.setOnCompletionListener(this);
          paramString2.setOnErrorListener(this);
          paramString2.setVideoPath((String)localObject);
          paramString2.mCurrTime = 0;
          paramString2.start();
          localObject = paramString2.getLayoutParams();
          paramString2.setDimension(((ViewGroup.LayoutParams)localObject).width, ((ViewGroup.LayoutParams)localObject).width * 1334 / 750);
          this.mVid = paramString1;
          this.mDelayMillis = paramJSONObject.optInt("callbackInterval", 0);
        }
      }
      paramString2 = new JSONObject();
      try
      {
        paramString2.put("resultCode", 0);
        paramString2.put("videoStatus", 1);
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletCommonJsPlugin", 2, paramJSONObject, new Object[0]);
        }
      }
      callbackJs("playVideo", paramString1, paramString2);
      return;
    }
    paramString2 = new JSONObject();
    try
    {
      paramString2.put("resultCode", -1);
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QWalletCommonJsPlugin", 2, paramJSONObject, new Object[0]);
      }
    }
    callbackJs("playVideo", paramString1, paramString2);
  }
  
  private void js_stop(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    stopPlay(paramString1);
    setCacheCallback("stopVideo", paramString1, paramString2);
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("resultCode", 0);
      paramString1.put("videoStatus", 0);
    }
    catch (JSONException paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QWalletCommonJsPlugin", 2, paramString2, new Object[0]);
      }
    }
    callbackJs("stopVideo", this.mVid, paramString1);
  }
  
  private void refreshVideoFlag(int paramInt, boolean paramBoolean)
  {
    QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView localMyVideoView = (QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)this.mVideoViews.get(this.mVid);
    if (localMyVideoView != null) {
      localMyVideoView.setFlag(paramInt, paramBoolean);
    }
  }
  
  private void setCacheCallback(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap2 = (HashMap)this.mCallbacks.get(paramString1);
    HashMap localHashMap1 = localHashMap2;
    if (localHashMap2 == null) {
      localHashMap1 = new HashMap();
    }
    localHashMap1.put(paramString2, paramString3);
    this.mCallbacks.put(paramString1, localHashMap1);
  }
  
  private boolean stopPlay(String paramString)
  {
    QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView localMyVideoView = (QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)this.mVideoViews.get(paramString);
    if (localMyVideoView != null)
    {
      try
      {
        if (localMyVideoView.isPlaying()) {
          localMyVideoView.stopPlayback();
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletCommonJsPlugin", 2, localException, new Object[0]);
        }
      }
      localMyVideoView.release();
      this.mHandler.removeMessages(1);
      this.mVideoViews.remove(paramString);
      this.videoLayout.removeView(localMyVideoView);
      this.videoLayout.setVisibility(4);
      return true;
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramVarArgs != null) {}
    for (;;)
    {
      try
      {
        if (paramVarArgs.length <= 0) {
          break label429;
        }
        paramJsBridgeListener = paramVarArgs[0];
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("handleJsRequest, pkgName:");
          paramString1.append(paramString2);
          paramString1.append(", method:=");
          paramString1.append(paramString3);
          paramString1.append(", arg:");
          paramString1.append(paramJsBridgeListener);
          QLog.i("QWalletCommonJsPlugin", 2, paramString1.toString());
        }
        bool2 = bool3;
        if (TextUtils.isEmpty(paramString3)) {
          continue;
        }
        bool2 = bool3;
        if (this.videoParent == null) {
          continue;
        }
        bool2 = bool3;
        if (paramJsBridgeListener == null) {
          continue;
        }
        JSONObject localJSONObject = new JSONObject(paramJsBridgeListener);
        paramString1 = localJSONObject.optString("videoID");
        paramJsBridgeListener = localObject2;
        try
        {
          paramString2 = localJSONObject.optString("callback");
          paramJsBridgeListener = paramString2;
          boolean bool4 = TextUtils.isEmpty(paramString1);
          bool2 = bool3;
          if (bool4) {
            continue;
          }
          try
          {
            if ("initVideo".equals(paramString3))
            {
              js_init(paramString1, paramString2, localJSONObject);
            }
            else if ("playVideo".equals(paramString3))
            {
              js_play(paramString1, paramString2, localJSONObject);
            }
            else if ("pauseVideo".equals(paramString3))
            {
              js_pause(paramString1, paramString2, localJSONObject);
            }
            else if ("stopVideo".equals(paramString3))
            {
              js_stop(paramString1, paramString2, localJSONObject);
            }
            else if ("downloadVideo".equals(paramString3))
            {
              js_download(paramString1, paramString2, localJSONObject);
            }
            else
            {
              bool2 = bool3;
              if (!"isExistVideo".equals(paramString3)) {
                continue;
              }
              js_isVideoExist(paramString1, paramString2, localJSONObject);
            }
            return true;
          }
          catch (Throwable localThrowable)
          {
            paramString3 = paramString2;
            paramJsBridgeListener = paramString1;
            bool1 = true;
            paramString2 = localThrowable;
            paramString1 = paramString3;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
        }
        catch (Throwable paramString3)
        {
          paramString2 = paramJsBridgeListener;
          paramJsBridgeListener = paramString1;
          paramString1 = paramString2;
          paramString2 = paramString3;
        }
      }
      catch (Throwable paramString2)
      {
        boolean bool2;
        paramString1 = null;
        paramJsBridgeListener = localThrowable;
        continue;
      }
      QLog.e("QWalletCommonJsPlugin", 2, "handleJsRequest Throwable:", paramString2);
      paramString2 = new JSONObject();
      try
      {
        paramString2.put("resultCode", -1);
        paramString2.put("videoID", paramJsBridgeListener);
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletCommonJsPlugin", 2, "handleJsRequest JSONException:", paramJsBridgeListener);
        }
      }
      bool2 = bool1;
      if (paramString1 != null)
      {
        this.this$0.callJs(paramString1, paramVarArgs);
        bool2 = bool1;
      }
      return bool2;
      label429:
      paramJsBridgeListener = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage, what:");
      ((StringBuilder)localObject).append(paramMessage.what);
      ((StringBuilder)localObject).append(",obj:");
      ((StringBuilder)localObject).append(paramMessage.obj);
      QLog.i("QWalletCommonJsPlugin", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        if ((paramMessage.obj instanceof Integer))
        {
          i = ((Integer)paramMessage.obj).intValue();
          if (1 == i) {
            return true;
          }
          if (4 == i)
          {
            js_stop(this.mVid, getCacheCallback("playVideo", this.mVid), new JSONObject());
            return true;
          }
        }
      }
      else if (((paramMessage.obj instanceof String)) && (this.mDelayMillis > 0L))
      {
        paramMessage = (String)paramMessage.obj;
        localObject = (QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)this.mVideoViews.get(paramMessage);
        if ((localObject != null) && (((QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)localObject).isPlaying()))
        {
          i = ((QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)localObject).getCurrentPosition();
          localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("videoStatus", 2);
            ((JSONObject)localObject).put("currentTime", i);
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QWalletCommonJsPlugin", 2, localJSONException, new Object[0]);
            }
          }
          callbackJs("playVideo", paramMessage, (JSONObject)localObject);
          this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, paramMessage), this.mDelayMillis);
          return true;
        }
      }
    }
    catch (Throwable paramMessage)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QWalletCommonJsPlugin", 2, "handleMessage, Throwable:", paramMessage);
      }
    }
    return true;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletCommonJsPlugin", 2, "onCompletion");
    }
    paramMediaPlayer = new JSONObject();
    try
    {
      paramMediaPlayer.put("resultCode", 0);
      paramMediaPlayer.put("videoStatus", 4);
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QWalletCommonJsPlugin", 2, localJSONException, new Object[0]);
      }
    }
    refreshVideoFlag(2, false);
    callbackJs("playVideo", this.mVid, paramMediaPlayer);
    this.mHandler.obtainMessage(2, Integer.valueOf(4)).sendToTarget();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramMediaPlayer = new StringBuilder();
      paramMediaPlayer.append("onError,what:");
      paramMediaPlayer.append(paramInt1);
      paramMediaPlayer.append("extra:");
      paramMediaPlayer.append(paramInt2);
      QLog.e("QWalletCommonJsPlugin", 2, paramMediaPlayer.toString());
    }
    paramMediaPlayer = new JSONObject();
    try
    {
      paramMediaPlayer.put("resultCode", -1);
      paramMediaPlayer.put("videoStatus", 5);
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QWalletCommonJsPlugin", 2, localJSONException, new Object[0]);
      }
    }
    refreshVideoFlag(2, false);
    callbackJs("playVideo", this.mVid, paramMediaPlayer);
    stopPlay(this.mVid);
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QWalletCommonJsPlugin", 2, "onPrepared");
    }
    JSONObject localJSONObject = new JSONObject();
    QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView localMyVideoView = (QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)this.mVideoViews.get(this.mVid);
    if (localMyVideoView == null) {}
    for (;;)
    {
      try
      {
        try
        {
          localJSONObject.put("resultCode", -1);
          localJSONObject.put("videoStatus", 0);
        }
        catch (JSONException paramMediaPlayer)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
        }
        QLog.e("QWalletCommonJsPlugin", 2, paramMediaPlayer, new Object[0]);
        continue;
        i = localMyVideoView.mCurrTime;
        if (i > 0)
        {
          paramMediaPlayer.seekTo(i);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("resumeplay,time:");
            localStringBuilder.append(i);
            QLog.i("QWalletCommonJsPlugin", 2, localStringBuilder.toString());
          }
        }
        if (!localMyVideoView.testFlag(4))
        {
          paramMediaPlayer.start();
          this.mHandler.obtainMessage(1, this.mVid).sendToTarget();
          i = 2;
          localMyVideoView.requestFocus();
          this.videoLayout.setVisibility(0);
          refreshVideoFlag(2, true);
          try
          {
            localJSONObject.put("resultCode", 0);
            localJSONObject.put("videoStatus", i);
          }
          catch (JSONException paramMediaPlayer)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QWalletCommonJsPlugin", 2, paramMediaPlayer, new Object[0]);
            }
          }
          callbackJs("playVideo", this.mVid, localJSONObject);
          return;
        }
      }
      catch (IllegalStateException paramMediaPlayer)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletCommonJsPlugin", 2, paramMediaPlayer, new Object[0]);
        }
        try
        {
          localJSONObject.put("resultCode", -1);
          localJSONObject.put("videoStatus", 0);
        }
        catch (JSONException paramMediaPlayer)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QWalletCommonJsPlugin", 2, paramMediaPlayer, new Object[0]);
          }
        }
        stopPlay(this.mVid);
        callbackJs("playVideo", this.mVid, localJSONObject);
        return;
      }
      int i = 3;
    }
  }
  
  protected void onWebViewCreated(WebViewPlugin.PluginRuntime paramPluginRuntime)
  {
    this.videoParent = ((ViewGroup)paramPluginRuntime.d().findViewById(2131450099));
    if (this.videoParent != null)
    {
      this.videoLayout = new FrameLayout(this.mContext);
      paramPluginRuntime = new FrameLayout.LayoutParams(this.mContext.getResources().getDisplayMetrics().widthPixels, this.mContext.getResources().getDisplayMetrics().heightPixels);
      paramPluginRuntime.setMargins(0, 0, 0, 0);
      this.videoParent.addView(this.videoLayout, paramPluginRuntime);
      this.videoLayout.setBackgroundColor(0);
      this.videoLayout.setVisibility(4);
    }
  }
  
  public void resumeOrPause(boolean paramBoolean1, boolean paramBoolean2)
  {
    QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView localMyVideoView = (QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)this.mVideoViews.get(this.mVid);
    if ((localMyVideoView != null) && (localMyVideoView.testFlag(2)))
    {
      if (!paramBoolean1)
      {
        if (localMyVideoView.isPlaying())
        {
          localMyVideoView.mCurrTime = localMyVideoView.getCurrentPosition();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("pause,time:");
            localStringBuilder.append(localMyVideoView.mCurrTime);
            QLog.i("QWalletCommonJsPlugin", 2, localStringBuilder.toString());
          }
          localMyVideoView.pause();
          this.mHandler.removeMessages(1);
        }
      }
      else if (!localMyVideoView.isPlaying())
      {
        localMyVideoView.resume();
        this.mHandler.obtainMessage(1, this.mVid).sendToTarget();
      }
      localMyVideoView.setFlag(3, paramBoolean1);
      if (paramBoolean1) {
        paramBoolean1 = false;
      } else {
        paramBoolean1 = localMyVideoView.testFlag(4) | paramBoolean2;
      }
      localMyVideoView.setFlag(4, paramBoolean1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.QWVideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */