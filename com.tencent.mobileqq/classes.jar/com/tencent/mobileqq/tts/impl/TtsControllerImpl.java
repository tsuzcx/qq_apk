package com.tencent.mobileqq.tts.impl;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tts.ITtsController;
import com.tencent.mobileqq.tts.ITtsPlayer;
import com.tencent.mobileqq.tts.TtsListener;
import com.tencent.mobileqq.tts.data.IFileCacheDataSource;
import com.tencent.mobileqq.tts.data.INetUrlDataSource;
import com.tencent.mobileqq.tts.data.TtsDataSource;
import com.tencent.mobileqq.tts.data.TtsNetStreamParam;
import com.tencent.mobileqq.tts.data.TtsNetStreamParam.Builder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.InputStream;

public class TtsControllerImpl
  implements Handler.Callback, ITtsController
{
  public static final int DATA_DONE = 1;
  public static final int DATA_LOADING = 0;
  private static final String TAG = "TtsController";
  public static final String TTS_APPID_AND_QQ = "201908021016";
  private int businessId = 0;
  private Handler handler;
  private volatile boolean isBlockOnAcquiringStream;
  private volatile boolean mRunning;
  private String myUin = "0";
  private String secretKey = "";
  private String speech = "";
  private TtsListener ttsListener;
  private ITtsPlayer ttsPlayer;
  
  private TtsNetStreamParam buildRequestParam(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AND_");
    ((StringBuilder)localObject).append(AppSetting.a());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("8.7.0");
    localObject = ((StringBuilder)localObject).toString();
    return new TtsNetStreamParam.Builder().a("201908021016").a(Long.parseLong(this.myUin)).b(Long.parseLong(paramString2)).b(paramString1).c(MD5Utils.toMD5(paramString1)).d((String)localObject).a(NetworkUtil.getNetWorkType()).b(this.businessId).e(this.secretKey).a();
  }
  
  private InputStream getInputStream(String paramString1, String paramString2)
  {
    Object localObject = TtsDataSource.a().a(paramString1);
    if (localObject != null) {
      return localObject;
    }
    localObject = TtsDataSource.a();
    paramString1 = buildRequestParam(paramString1, paramString2);
    try
    {
      paramString1 = ((INetUrlDataSource)localObject).a(paramString1);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("TtsController", 1, "[getInputStream] error: ", paramString1);
    }
    return null;
  }
  
  private void speak(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("TtsController", 1, new Object[] { "[speak] text is empty: ", paramString1 });
      return;
    }
    this.mRunning = true;
    this.speech = ((ITextUtilsApi)QRoute.api(ITextUtilsApi.class)).emoticonToTextForTalkBack(paramString1).replaceAll("/", " ");
    ThreadManagerV2.executeOnSubThread(new TtsControllerImpl.2(this, paramString2, paramInt));
  }
  
  public void destroy()
  {
    this.mRunning = false;
    QLog.d("TtsController", 1, "[destroy] release resources.");
    this.ttsPlayer.release();
    this.ttsListener = null;
  }
  
  public String getSpeech()
  {
    return this.speech;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i == 0)
    {
      paramMessage = this.ttsListener;
      if (paramMessage != null) {
        paramMessage.a();
      }
    }
    else if (i == 1)
    {
      paramMessage = this.ttsListener;
      if (paramMessage != null) {
        paramMessage.b();
      }
    }
    return false;
  }
  
  public void init(String paramString1, String paramString2, int paramInt)
  {
    QLog.d("TtsController", 1, new Object[] { "[init] uin: ", paramString1 });
    this.myUin = paramString1;
    this.secretKey = paramString2;
    this.businessId = paramInt;
    this.handler = new WeakReferenceHandler(this);
    this.ttsPlayer = ((ITtsPlayer)QRoute.api(ITtsPlayer.class));
    this.ttsPlayer.setPlayerCallback(new TtsControllerImpl.1(this));
  }
  
  public boolean isWorking()
  {
    return (this.isBlockOnAcquiringStream) || (this.ttsPlayer.isPlaying());
  }
  
  public void setTtsListener(TtsListener paramTtsListener)
  {
    this.ttsListener = paramTtsListener;
  }
  
  public void speak(String paramString, int paramInt)
  {
    speak(paramString, "0", paramInt);
  }
  
  public void speak(String paramString1, String paramString2)
  {
    speak(paramString1, paramString2, 0);
  }
  
  public void stop()
  {
    this.mRunning = false;
    this.ttsPlayer.stop();
    TtsListener localTtsListener = this.ttsListener;
    if (localTtsListener != null) {
      localTtsListener.b(this.speech);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.impl.TtsControllerImpl
 * JD-Core Version:    0.7.0.1
 */