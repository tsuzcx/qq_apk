package com.tencent.qqlive.tvkplayer.vinfo.live;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.thirdparties.LocalCache;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKHandlerThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKLiveInfoGetter.OnGetLiveInfoListener;
import java.util.Map;

public class TVKLiveInfoGetter
  implements ITVKLiveInfoGetter
{
  private static final int EVENT_SUCCESS = 100;
  private static String TAG = "MediaPlayerMgr[TVKLiveInfoGetter.java]";
  private static int mPlayerBaseID = 30000;
  private Context mContext;
  private String mDefinition;
  private TVKLiveInfoGetter.EventHandler mEventHandler;
  private Map<String, String> mExtraPara;
  private boolean mHandlerInit;
  private HandlerThread mHandlerThread = null;
  private TVKLiveInfoCallback mLiveInfoCallBack = new TVKLiveInfoGetter.1(this);
  private ITVKLiveInfoGetter.OnGetLiveInfoListener mLiveListener;
  private int mLocalProxyID = -1;
  private TVKLiveInfoCallback mPreloadLiveCallBack = new TVKLiveInfoGetter.2(this);
  private String mProgramId;
  private boolean mStopped;
  private TVKUserInfo mUserInfo;
  private TVKPlayerVideoInfo mVideoInfo;
  
  private TVKLiveInfoGetter(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static TVKLiveInfoGetter create(Context paramContext)
  {
    return new TVKLiveInfoGetter(paramContext);
  }
  
  private void doPreloadLiveInfo(int paramInt1, int paramInt2, boolean paramBoolean, Map<String, String> paramMap)
  {
    Object localObject3;
    try
    {
      Object localObject1 = LocalCache.get(this.mContext);
      localObject3 = this.mUserInfo;
      if ((localObject3 != null) && (!TextUtils.isEmpty(this.mUserInfo.getLoginCookie())) && (this.mUserInfo.isVip()))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("live_");
        ((StringBuilder)localObject3).append(this.mProgramId);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(this.mDefinition);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(TVKUtils.getMd5(this.mUserInfo.getLoginCookie()));
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(TVKVcSystemInfo.getIP(this.mContext));
        localObject1 = (TVKLiveVideoInfo)((LocalCache)localObject1).getAsObject(((StringBuilder)localObject3).toString());
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("live_");
        ((StringBuilder)localObject3).append(this.mProgramId);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(this.mDefinition);
        ((StringBuilder)localObject3).append("_");
        ((StringBuilder)localObject3).append(TVKVcSystemInfo.getIP(this.mContext));
        localObject1 = (TVKLiveVideoInfo)((LocalCache)localObject1).getAsObject(((StringBuilder)localObject3).toString());
      }
      if (localObject1 != null) {
        TVKLogUtil.i(TAG, "preLoadLiveInfo, have cache, need not to preload");
      }
    }
    catch (Throwable localThrowable)
    {
      TVKLogUtil.e(TAG, localThrowable);
    }
    for (;;)
    {
      try
      {
        String str1 = TAG;
        String str2 = this.mProgramId;
        localObject2 = this.mUserInfo;
        localObject3 = "";
        if (localObject2 != null)
        {
          localObject2 = this.mUserInfo.getUin();
          String str3 = this.mDefinition;
          if (this.mUserInfo != null) {
            localObject3 = this.mUserInfo.getLoginCookie();
          }
          TVKLogUtil.i(str1, String.format("[getLiveInfo] progId = %s uin = %s definition = %s cookie = %s", new Object[] { str2, localObject2, str3, localObject3 }));
          localObject2 = new TVKLiveInfoParams();
          ((TVKLiveInfoParams)localObject2).setGetDlnaUrl(false);
          ((TVKLiveInfoParams)localObject2).setGetPreviewInfo(false);
          ((TVKLiveInfoParams)localObject2).setStreamFormat(paramInt2);
          ((TVKLiveInfoParams)localObject2).setDolby(paramBoolean);
          ((TVKLiveInfoParams)localObject2).setExtraPara(paramMap);
          new TVKLiveInfoRequest(paramInt1, this.mUserInfo, this.mProgramId, this.mDefinition, this.mPreloadLiveCallBack, (TVKLiveInfoParams)localObject2).execute();
          return;
        }
      }
      catch (Exception paramMap)
      {
        localObject2 = new TVKLiveVideoInfo();
        ((TVKLiveVideoInfo)localObject2).setErrModule(10000);
        ((TVKLiveVideoInfo)localObject2).setErrInfo(paramMap.getMessage());
        ((TVKLiveVideoInfo)localObject2).setRetCode(143004);
        this.mLiveInfoCallBack.onFailure(paramInt1, (TVKLiveVideoInfo)localObject2);
        return;
      }
      Object localObject2 = "";
    }
  }
  
  private void handleSuccess(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[live]handleSuccess(), id: ");
    localStringBuilder.append(paramInt);
    TVKLogUtil.i((String)localObject, localStringBuilder.toString());
    if (paramTVKLiveVideoInfo != null) {
      TVKLogUtil.i(TAG, String.format("[handleSuccess]  isGetUrl=%b isDlnaUrl=%b stream:%d", new Object[] { Boolean.valueOf(paramTVKLiveVideoInfo.isGetPreviewInfo()), Boolean.valueOf(paramTVKLiveVideoInfo.isGetDlnaUrl()), Integer.valueOf(paramTVKLiveVideoInfo.getStream()) }));
    } else {
      TVKLogUtil.i(TAG, "[handleSuccess]  data is null ");
    }
    if (this.mStopped)
    {
      TVKLogUtil.e(TAG, "[handleSuccess]  have stop ,return ");
      return;
    }
    if ((paramTVKLiveVideoInfo != null) && ((paramTVKLiveVideoInfo.getRetCode() == 0) || (paramTVKLiveVideoInfo.getRetCode() == 10) || (paramTVKLiveVideoInfo.getRetCode() == 11) || (paramTVKLiveVideoInfo.getRetCode() == 13)))
    {
      localObject = this.mLiveListener;
      if (localObject != null) {
        ((ITVKLiveInfoGetter.OnGetLiveInfoListener)localObject).onGetLiveInfoSucceed(paramInt, paramTVKLiveVideoInfo);
      }
    }
    else
    {
      if (paramTVKLiveVideoInfo != null) {
        paramTVKLiveVideoInfo.setErrModule(10001);
      }
      localObject = this.mLiveListener;
      if (localObject != null) {
        ((ITVKLiveInfoGetter.OnGetLiveInfoListener)localObject).onGetLiveInfoFailed(paramInt, paramTVKLiveVideoInfo);
      }
    }
  }
  
  private void initHandler()
  {
    if ((this.mHandlerInit) && (this.mHandlerThread != null) && (this.mEventHandler != null)) {
      return;
    }
    try
    {
      this.mHandlerThread = TVKHandlerThreadPool.getInstance().obtainShareThread("TVK_LiveInfoGetter");
      Looper localLooper = this.mHandlerThread.getLooper();
      if (localLooper == null)
      {
        localLooper = Looper.myLooper();
        Looper.prepare();
        this.mEventHandler = new TVKLiveInfoGetter.EventHandler(this, localLooper);
        Looper.loop();
      }
      else
      {
        this.mEventHandler = new TVKLiveInfoGetter.EventHandler(this, localLooper);
      }
      this.mHandlerInit = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      TVKLogUtil.e(TAG, localThrowable);
    }
  }
  
  private int inquireSpecialInfo(TVKUserInfo paramTVKUserInfo, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Map<String, String> paramMap)
  {
    int i = mPlayerBaseID;
    mPlayerBaseID = i + 1;
    this.mUserInfo = paramTVKUserInfo;
    try
    {
      TVKLogUtil.i(TAG, String.format("[getLiveInfo] progId = %s uin = %s definition = %s cookie = %s isGetUrl=%b isDlnaUrl=%b ", new Object[] { paramString1, paramTVKUserInfo.getUin(), paramString2, paramTVKUserInfo.getLoginCookie(), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
      TVKLiveInfoParams localTVKLiveInfoParams = new TVKLiveInfoParams();
      localTVKLiveInfoParams.setStreamFormat(2);
      localTVKLiveInfoParams.setGetDlnaUrl(paramBoolean2);
      localTVKLiveInfoParams.setGetPreviewInfo(paramBoolean1);
      localTVKLiveInfoParams.setExtraPara(paramMap);
      new TVKLiveInfoRequest(i, paramTVKUserInfo, paramString1, paramString2, this.mLiveInfoCallBack, localTVKLiveInfoParams).execute();
      return i;
    }
    catch (Exception paramTVKUserInfo)
    {
      paramString1 = new TVKLiveVideoInfo();
      paramString1.setErrModule(10000);
      paramString1.setRetCode(143004);
      paramString1.setErrInfo(paramTVKUserInfo.getMessage());
      this.mLiveInfoCallBack.onFailure(i, paramString1);
    }
    return i;
  }
  
  public void cancel()
  {
    this.mLiveInfoCallBack.cancel();
  }
  
  public int getDlnaUrl(TVKUserInfo paramTVKUserInfo, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    return inquireSpecialInfo(paramTVKUserInfo, paramString1, paramString2, false, true, paramMap);
  }
  
  public int getLiveInfo(TVKUserInfo paramTVKUserInfo, TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString, int paramInt, boolean paramBoolean)
  {
    initHandler();
    int i = mPlayerBaseID;
    mPlayerBaseID = i + 1;
    this.mUserInfo = paramTVKUserInfo;
    this.mProgramId = paramTVKPlayerVideoInfo.getVid();
    this.mDefinition = paramString;
    this.mExtraPara = paramTVKPlayerVideoInfo.getExtraRequestParamsMap();
    this.mVideoInfo = paramTVKPlayerVideoInfo;
    try
    {
      paramTVKPlayerVideoInfo = LocalCache.get(this.mContext);
      Object localObject = this.mUserInfo;
      if ((localObject != null) && (!TextUtils.isEmpty(this.mUserInfo.getLoginCookie())) && (this.mUserInfo.isVip()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("live_");
        ((StringBuilder)localObject).append(this.mProgramId);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(TVKUtils.getMd5(this.mUserInfo.getLoginCookie()));
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(TVKVcSystemInfo.getIP(this.mContext));
        paramTVKPlayerVideoInfo = (TVKLiveVideoInfo)paramTVKPlayerVideoInfo.getAsObject(((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("live_");
        ((StringBuilder)localObject).append(this.mProgramId);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(TVKVcSystemInfo.getIP(this.mContext));
        paramTVKPlayerVideoInfo = (TVKLiveVideoInfo)paramTVKPlayerVideoInfo.getAsObject(((StringBuilder)localObject).toString());
      }
      if (paramTVKPlayerVideoInfo != null)
      {
        TVKLogUtil.i(TAG, "getLiveInfo, have cache");
        if (this.mEventHandler == null)
        {
          TVKLogUtil.e(TAG, "[handleSuccess]  mEventHandler is null ");
          handleSuccess(i, paramTVKPlayerVideoInfo);
          return i;
        }
        localObject = this.mEventHandler.obtainMessage(100);
        ((Message)localObject).arg1 = i;
        ((Message)localObject).obj = paramTVKPlayerVideoInfo;
        this.mEventHandler.sendMessage((Message)localObject);
        return i;
      }
    }
    catch (Throwable paramTVKPlayerVideoInfo)
    {
      TVKLogUtil.e(TAG, paramTVKPlayerVideoInfo);
      try
      {
        TVKLogUtil.i(TAG, String.format("[getLiveInfo] progId = %s uin = %s definition = %s cookie = %s", new Object[] { this.mProgramId, paramTVKUserInfo.getUin(), paramString, paramTVKUserInfo.getLoginCookie() }));
        paramTVKPlayerVideoInfo = new TVKLiveInfoParams();
        paramTVKPlayerVideoInfo.setGetDlnaUrl(false);
        paramTVKPlayerVideoInfo.setGetPreviewInfo(false);
        paramTVKPlayerVideoInfo.setStreamFormat(paramInt);
        paramTVKPlayerVideoInfo.setDolby(paramBoolean);
        paramTVKPlayerVideoInfo.setExtraPara(this.mExtraPara);
        paramTVKPlayerVideoInfo.setVideoInfo(this.mVideoInfo);
        new TVKLiveInfoRequest(i, paramTVKUserInfo, this.mProgramId, paramString, this.mLiveInfoCallBack, paramTVKPlayerVideoInfo).execute();
        return i;
      }
      catch (Exception paramTVKUserInfo)
      {
        paramTVKPlayerVideoInfo = new TVKLiveVideoInfo();
        paramTVKPlayerVideoInfo.setErrModule(10000);
        paramTVKPlayerVideoInfo.setErrInfo(paramTVKUserInfo.getMessage());
        this.mLiveInfoCallBack.onFailure(i, paramTVKPlayerVideoInfo);
      }
    }
    return i;
  }
  
  public int inquireInfo(TVKUserInfo paramTVKUserInfo, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    return inquireSpecialInfo(paramTVKUserInfo, paramString1, paramString2, true, false, paramMap);
  }
  
  public int preLoadLiveInfo(TVKUserInfo paramTVKUserInfo, String paramString1, String paramString2, int paramInt, boolean paramBoolean, Map<String, String> paramMap)
  {
    int i = mPlayerBaseID;
    mPlayerBaseID = i + 1;
    initHandler();
    this.mUserInfo = paramTVKUserInfo;
    this.mProgramId = paramString1;
    this.mDefinition = paramString2;
    paramTVKUserInfo = this.mEventHandler;
    if (paramTVKUserInfo != null)
    {
      paramTVKUserInfo.post(new TVKLiveInfoGetter.3(this, i, paramInt, paramBoolean, paramMap));
      return i;
    }
    doPreloadLiveInfo(i, paramInt, paramBoolean, paramMap);
    return i;
  }
  
  public void setOnGetLiveInfoListener(ITVKLiveInfoGetter.OnGetLiveInfoListener paramOnGetLiveInfoListener)
  {
    this.mLiveListener = paramOnGetLiveInfoListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter
 * JD-Core Version:    0.7.0.1
 */