package com.tencent.mobileqq.vaswebviewplugin;

import aksh;
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
import bhod;
import bkgm;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
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
  private long mDelayMillis;
  WebViewPlugin mExtPlugin;
  private Handler mHandler;
  private String mVid;
  final HashMap<String, QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView> mVideoViews = new HashMap();
  private aksh preloadManager;
  private ViewGroup videoLayout;
  private ViewGroup videoParent;
  
  public QWalletCommonJsPlugin$QWVideoJsPlugin(QWalletCommonJsPlugin paramQWalletCommonJsPlugin, Context paramContext, WebViewPlugin paramWebViewPlugin, AppInterface paramAppInterface)
  {
    this.mContext = paramContext;
    this.mHandler = new bkgm(this);
    this.mExtPlugin = paramWebViewPlugin;
    this.preloadManager = aksh.a(paramAppInterface);
  }
  
  private void callbackJs(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    String str3 = getCacheCallback(paramString1, paramString2);
    String str2;
    String str1;
    if ((this.mExtPlugin != null) && (!TextUtils.isEmpty(str3)))
    {
      str2 = "";
      str1 = str2;
      if (paramJSONObject == null) {}
    }
    try
    {
      paramJSONObject.put("videoID", paramString2);
      str1 = paramJSONObject.toString();
      this.mExtPlugin.callJs(str3, new String[] { str1 });
      if (QLog.isColorLevel()) {
        QLog.i("QWalletCommonJsPlugin", 2, "callbackJs,action:" + paramString1 + ",cbId:" + str3 + ",vid:" + paramString2 + ",cb_json:" + paramJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        str1 = str2;
        if (QLog.isColorLevel())
        {
          QLog.e("QWalletCommonJsPlugin", 2, "callbackJs,exc.", localJSONException);
          str1 = str2;
        }
      }
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
    return this.preloadManager.d(paramString);
  }
  
  private void js_download(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    setCacheCallback("downloadVideo", paramString1, paramString2);
    paramString2 = null;
    if (paramJSONObject != null) {
      paramString2 = paramJSONObject.optString("videoConfig");
    }
    this.preloadManager.a(paramString1, paramString2, new QWalletCommonJsPlugin.QWVideoJsPlugin.1(this, paramString1));
  }
  
  private void js_init(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    setCacheCallback("initVideo", paramString1, paramString2);
    localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        m = this.mContext.getResources().getDisplayMetrics().widthPixels;
        n = this.mContext.getResources().getDisplayMetrics().heightPixels;
      }
      catch (Exception paramString2)
      {
        int n;
        int j;
        int i1;
        float f;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QWalletCommonJsPlugin", 2, paramString2, new Object[0]);
        try
        {
          localJSONObject.put("resultCode", -1);
        }
        catch (JSONException paramString2) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QWalletCommonJsPlugin", 2, paramString2, new Object[0]);
        continue;
      }
      try
      {
        j = paramJSONObject.optInt("x", 0);
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (Exception paramString2)
      {
        try
        {
          i = paramJSONObject.optInt("y", 0);
          k = m;
        }
        catch (Exception paramString2)
        {
          i = 0;
          k = m;
          continue;
        }
        try
        {
          m = paramJSONObject.optInt("w", m);
          k = m;
          i1 = paramJSONObject.optInt("h", n);
          k = i1;
          n = m;
          m = k;
          paramString2 = new QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView(this, this.mContext);
          paramString2.setTag(paramString1);
          f = this.mContext.getResources().getDisplayMetrics().density;
          paramJSONObject = new FrameLayout.LayoutParams(n, m);
          paramJSONObject.setMargins((int)(j * f), (int)(i * f), 0, 0);
          this.videoLayout.addView(paramString2, paramJSONObject);
          this.mVideoViews.put(paramString1, paramString2);
          localJSONObject.put("resultCode", 0);
          localJSONObject.put("videoStatus", 0);
          callbackJs("initVideo", paramString1, localJSONObject);
          return;
        }
        catch (Exception paramString2)
        {
          continue;
        }
        paramString2 = paramString2;
        i = 0;
        j = 0;
        k = m;
      }
      QLog.e("QWalletCommonJsPlugin", 2, paramString2, new Object[0]);
      m = n;
      n = k;
    }
  }
  
  private void js_isVideoExist(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    setCacheCallback("isExistVideo", paramString1, paramString2);
    int i;
    if (TextUtils.isEmpty(getInnerVideoPath(paramString1))) {
      i = -1;
    }
    for (;;)
    {
      paramString2 = new JSONObject();
      try
      {
        paramString2.put("resultCode", i);
        callbackJs("isExistVideo", paramString1, paramString2);
        return;
        i = 0;
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QWalletCommonJsPlugin", 2, paramJSONObject, new Object[0]);
          }
        }
      }
    }
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
      callbackJs("pauseVideo", this.mVid, paramString1);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletCommonJsPlugin", 2, paramString2, new Object[0]);
        }
      }
    }
  }
  
  private void js_play(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    setCacheCallback("playVideo", paramString1, paramString2);
    paramString2 = (QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)this.mVideoViews.get(paramString1);
    if (paramString2 != null)
    {
      if (paramString2.testFlag(2)) {
        resumeOrPause(true, false);
      }
      for (;;)
      {
        paramString2 = new JSONObject();
        try
        {
          paramString2.put("resultCode", 0);
          paramString2.put("videoStatus", 1);
          callbackJs("playVideo", paramString1, paramString2);
          return;
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
        catch (JSONException paramJSONObject)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QWalletCommonJsPlugin", 2, paramJSONObject, new Object[0]);
            }
          }
        }
      }
    }
    paramString2 = new JSONObject();
    try
    {
      paramString2.put("resultCode", -1);
      callbackJs("playVideo", paramString1, paramString2);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletCommonJsPlugin", 2, paramJSONObject, new Object[0]);
        }
      }
    }
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
      callbackJs("stopVideo", this.mVid, paramString1);
      return;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletCommonJsPlugin", 2, paramString2, new Object[0]);
        }
      }
    }
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
    if (localMyVideoView != null) {
      try
      {
        if (localMyVideoView.isPlaying()) {
          localMyVideoView.stopPlayback();
        }
        localMyVideoView.release();
        this.mHandler.removeMessages(1);
        this.mVideoViews.remove(paramString);
        this.videoLayout.removeView(localMyVideoView);
        this.videoLayout.setVisibility(4);
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QWalletCommonJsPlugin", 2, localException, new Object[0]);
          }
        }
      }
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramString1 = null;
    if (paramVarArgs != null) {}
    for (;;)
    {
      boolean bool2;
      try
      {
        if (paramVarArgs.length <= 0) {
          break label389;
        }
        paramJsBridgeListener = paramVarArgs[0];
        if (QLog.isColorLevel()) {
          QLog.i("QWalletCommonJsPlugin", 2, "handleJsRequest, pkgName:" + paramString2 + ", method:=" + paramString3 + ", arg:" + paramJsBridgeListener);
        }
        if ((TextUtils.isEmpty(paramString3)) || (this.videoParent == null) || (paramJsBridgeListener == null)) {
          continue;
        }
        paramString2 = new JSONObject(paramJsBridgeListener);
        paramJsBridgeListener = paramString2.optString("videoID");
      }
      catch (Throwable paramJsBridgeListener)
      {
        paramString2 = null;
        boolean bool1 = false;
        continue;
        bool2 = false;
      }
      try
      {
        paramString1 = paramString2.optString("callback");
      }
      catch (Throwable paramString1)
      {
        bool1 = false;
        paramString2 = paramJsBridgeListener;
        paramString3 = null;
        paramJsBridgeListener = paramString1;
        paramString1 = paramString2;
        paramString2 = paramString3;
        continue;
      }
      try
      {
        bool1 = TextUtils.isEmpty(paramJsBridgeListener);
        if (bool1) {
          continue;
        }
        bool1 = true;
        try
        {
          if ("initVideo".equals(paramString3))
          {
            js_init(paramJsBridgeListener, paramString1, paramString2);
            return true;
          }
          if (!"playVideo".equals(paramString3)) {
            continue;
          }
          js_play(paramJsBridgeListener, paramString1, paramString2);
          return true;
        }
        catch (Throwable paramString3)
        {
          paramString2 = paramString1;
          paramString1 = paramJsBridgeListener;
          paramJsBridgeListener = paramString3;
        }
      }
      catch (Throwable paramString2)
      {
        bool1 = false;
        paramString3 = paramJsBridgeListener;
        String str = paramString1;
        paramJsBridgeListener = paramString2;
        paramString1 = paramString3;
        paramString2 = str;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QWalletCommonJsPlugin", 2, "handleJsRequest Throwable:", paramJsBridgeListener);
      }
      paramJsBridgeListener = new JSONObject();
      try
      {
        paramJsBridgeListener.put("resultCode", -1);
        paramJsBridgeListener.put("videoID", paramString1);
        bool2 = bool1;
        if (paramString2 != null)
        {
          this.this$0.callJs(paramString2, paramVarArgs);
          return bool1;
          if ("pauseVideo".equals(paramString3))
          {
            js_pause(paramJsBridgeListener, paramString1, paramString2);
            return true;
          }
          if ("stopVideo".equals(paramString3))
          {
            js_stop(paramJsBridgeListener, paramString1, paramString2);
            return true;
          }
          if ("downloadVideo".equals(paramString3))
          {
            js_download(paramJsBridgeListener, paramString1, paramString2);
            return true;
          }
          if ("isExistVideo".equals(paramString3))
          {
            js_isVideoExist(paramJsBridgeListener, paramString1, paramString2);
            return true;
          }
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QWalletCommonJsPlugin", 2, "handleJsRequest JSONException:", paramJsBridgeListener);
        continue;
      }
      return bool2;
      label389:
      paramJsBridgeListener = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.i("QWalletCommonJsPlugin", 2, "handleMessage, what:" + paramMessage.what + ",obj:" + paramMessage.obj);
    }
    try
    {
      switch (paramMessage.what)
      {
      case 2: 
        if ((paramMessage.obj instanceof Integer))
        {
          i = ((Integer)paramMessage.obj).intValue();
          if ((1 == i) || (4 != i)) {
            break label313;
          }
          js_stop(this.mVid, getCacheCallback("playVideo", this.mVid), new JSONObject());
        }
        break;
      }
    }
    catch (Throwable paramMessage)
    {
      int i;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("QWalletCommonJsPlugin", 2, "handleMessage, Throwable:", paramMessage);
        return true;
        if (((paramMessage.obj instanceof String)) && (this.mDelayMillis > 0L))
        {
          paramMessage = (String)paramMessage.obj;
          Object localObject = (QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)this.mVideoViews.get(paramMessage);
          if ((localObject == null) || (!((QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)localObject).isPlaying())) {
            break label318;
          }
          i = ((QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)localObject).getCurrentPosition();
          localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("videoStatus", 2);
            ((JSONObject)localObject).put("currentTime", i);
            callbackJs("playVideo", paramMessage, (JSONObject)localObject);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, paramMessage), this.mDelayMillis);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("QWalletCommonJsPlugin", 2, localJSONException, new Object[0]);
              }
            }
          }
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      return bool1;
      label313:
      bool1 = true;
      continue;
      label318:
      bool1 = true;
    }
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
      refreshVideoFlag(2, false);
      callbackJs("playVideo", this.mVid, paramMediaPlayer);
      this.mHandler.obtainMessage(2, Integer.valueOf(4)).sendToTarget();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletCommonJsPlugin", 2, localJSONException, new Object[0]);
        }
      }
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QWalletCommonJsPlugin", 2, "onError,what:" + paramInt1 + "extra:" + paramInt2);
    }
    paramMediaPlayer = new JSONObject();
    try
    {
      paramMediaPlayer.put("resultCode", -1);
      paramMediaPlayer.put("videoStatus", 5);
      refreshVideoFlag(2, false);
      callbackJs("playVideo", this.mVid, paramMediaPlayer);
      stopPlay(this.mVid);
      return false;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletCommonJsPlugin", 2, localJSONException, new Object[0]);
        }
      }
    }
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
        localJSONObject.put("resultCode", -1);
        localJSONObject.put("videoStatus", 0);
        callbackJs("playVideo", this.mVid, localJSONObject);
        return;
      }
      catch (JSONException paramMediaPlayer)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("QWalletCommonJsPlugin", 2, paramMediaPlayer, new Object[0]);
        continue;
      }
      catch (IllegalStateException paramMediaPlayer)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QWalletCommonJsPlugin", 2, paramMediaPlayer, new Object[0]);
        }
      }
      try
      {
        localJSONObject.put("resultCode", -1);
        localJSONObject.put("videoStatus", 0);
        stopPlay(this.mVid);
        callbackJs("playVideo", this.mVid, localJSONObject);
        return;
        int i = localMyVideoView.mCurrTime;
        if (i > 0)
        {
          paramMediaPlayer.seekTo(i);
          if (QLog.isColorLevel()) {
            QLog.i("QWalletCommonJsPlugin", 2, "resumeplay,time:" + i);
          }
        }
        if (!localMyVideoView.testFlag(4))
        {
          paramMediaPlayer.start();
          this.mHandler.obtainMessage(1, this.mVid).sendToTarget();
        }
        for (i = 2;; i = 3)
        {
          for (;;)
          {
            localMyVideoView.requestFocus();
            this.videoLayout.setVisibility(0);
            refreshVideoFlag(2, true);
            try
            {
              localJSONObject.put("resultCode", 0);
              localJSONObject.put("videoStatus", i);
            }
            catch (JSONException paramMediaPlayer) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("QWalletCommonJsPlugin", 2, paramMediaPlayer, new Object[0]);
          break;
        }
      }
      catch (JSONException paramMediaPlayer)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QWalletCommonJsPlugin", 2, paramMediaPlayer, new Object[0]);
          }
        }
      }
    }
  }
  
  protected void onWebViewCreated(bhod parambhod)
  {
    this.videoParent = ((ViewGroup)parambhod.a().findViewById(2131381162));
    if (this.videoParent != null)
    {
      this.videoLayout = new FrameLayout(this.mContext);
      parambhod = new FrameLayout.LayoutParams(this.mContext.getResources().getDisplayMetrics().widthPixels, this.mContext.getResources().getDisplayMetrics().heightPixels);
      parambhod.setMargins(0, 0, 0, 0);
      this.videoParent.addView(this.videoLayout, parambhod);
      this.videoLayout.setBackgroundColor(0);
      this.videoLayout.setVisibility(4);
    }
  }
  
  public void resumeOrPause(boolean paramBoolean1, boolean paramBoolean2)
  {
    QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView localMyVideoView = (QWalletCommonJsPlugin.QWVideoJsPlugin.MyVideoView)this.mVideoViews.get(this.mVid);
    if ((localMyVideoView != null) && (localMyVideoView.testFlag(2)))
    {
      if (paramBoolean1) {
        break label112;
      }
      if (localMyVideoView.isPlaying())
      {
        localMyVideoView.mCurrTime = localMyVideoView.getCurrentPosition();
        if (QLog.isColorLevel()) {
          QLog.i("QWalletCommonJsPlugin", 2, "pause,time:" + localMyVideoView.mCurrTime);
        }
        localMyVideoView.pause();
        this.mHandler.removeMessages(1);
      }
      localMyVideoView.setFlag(3, paramBoolean1);
      if (!paramBoolean1) {
        break label141;
      }
    }
    label141:
    for (paramBoolean1 = false;; paramBoolean1 = localMyVideoView.testFlag(4) | paramBoolean2)
    {
      localMyVideoView.setFlag(4, paramBoolean1);
      return;
      label112:
      if (localMyVideoView.isPlaying()) {
        break;
      }
      localMyVideoView.resume();
      this.mHandler.obtainMessage(1, this.mVid).sendToTarget();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.QWVideoJsPlugin
 * JD-Core Version:    0.7.0.1
 */