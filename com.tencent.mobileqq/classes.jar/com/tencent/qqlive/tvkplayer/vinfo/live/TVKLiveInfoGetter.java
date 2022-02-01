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
    try
    {
      localObject1 = LocalCache.get(this.mContext);
      if ((this.mUserInfo != null) && (!TextUtils.isEmpty(this.mUserInfo.getLoginCookie())) && (this.mUserInfo.isVip()))
      {
        localObject1 = (TVKLiveVideoInfo)((LocalCache)localObject1).getAsObject("live_" + this.mProgramId + "_" + this.mDefinition + "_" + TVKUtils.getMd5(this.mUserInfo.getLoginCookie()) + "_" + TVKVcSystemInfo.getIP(this.mContext));
        if (localObject1 != null) {
          TVKLogUtil.i(TAG, "preLoadLiveInfo, have cache, need not to preload");
        }
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        Object localObject1;
        label129:
        String str2 = TAG;
        String str3 = this.mProgramId;
        label156:
        String str4;
        if (this.mUserInfo != null)
        {
          localObject1 = this.mUserInfo.getUin();
          str4 = this.mDefinition;
          if (this.mUserInfo == null) {
            break label364;
          }
        }
        Object localObject2;
        label364:
        for (String str1 = this.mUserInfo.getLoginCookie();; str1 = "")
        {
          TVKLogUtil.i(str2, String.format("[getLiveInfo] progId = %s uin = %s definition = %s cookie = %s", new Object[] { str3, localObject1, str4, str1 }));
          localObject1 = new TVKLiveInfoParams();
          ((TVKLiveInfoParams)localObject1).setGetDlnaUrl(false);
          ((TVKLiveInfoParams)localObject1).setGetPreviewInfo(false);
          ((TVKLiveInfoParams)localObject1).setStreamFormat(paramInt2);
          ((TVKLiveInfoParams)localObject1).setDolby(paramBoolean);
          ((TVKLiveInfoParams)localObject1).setExtraPara(paramMap);
          new TVKLiveInfoRequest(paramInt1, this.mUserInfo, this.mProgramId, this.mDefinition, this.mPreloadLiveCallBack, (TVKLiveInfoParams)localObject1).execute();
          return;
          localObject1 = (TVKLiveVideoInfo)((LocalCache)localObject1).getAsObject("live_" + this.mProgramId + "_" + this.mDefinition + "_" + TVKVcSystemInfo.getIP(this.mContext));
          break;
          localThrowable = localThrowable;
          TVKLogUtil.e(TAG, localThrowable);
          break label129;
          localObject2 = "";
          break label156;
        }
        return;
      }
      catch (Exception paramMap)
      {
        localObject2 = new TVKLiveVideoInfo();
        ((TVKLiveVideoInfo)localObject2).setErrModule(10000);
        ((TVKLiveVideoInfo)localObject2).setErrInfo(paramMap.getMessage());
        ((TVKLiveVideoInfo)localObject2).setRetCode(143004);
        this.mLiveInfoCallBack.onFailure(paramInt1, (TVKLiveVideoInfo)localObject2);
      }
    }
  }
  
  private void handleSuccess(int paramInt, TVKLiveVideoInfo paramTVKLiveVideoInfo)
  {
    TVKLogUtil.i(TAG, "[live]handleSuccess(), id: " + paramInt);
    if (paramTVKLiveVideoInfo != null)
    {
      TVKLogUtil.i(TAG, String.format("[handleSuccess]  isGetUrl=%b isDlnaUrl=%b stream:%d", new Object[] { Boolean.valueOf(paramTVKLiveVideoInfo.isGetPreviewInfo()), Boolean.valueOf(paramTVKLiveVideoInfo.isGetDlnaUrl()), Integer.valueOf(paramTVKLiveVideoInfo.getStream()) }));
      if (!this.mStopped) {
        break label104;
      }
      TVKLogUtil.e(TAG, "[handleSuccess]  have stop ,return ");
    }
    label104:
    do
    {
      do
      {
        return;
        TVKLogUtil.i(TAG, "[handleSuccess]  data is null ");
        break;
        if ((paramTVKLiveVideoInfo == null) || ((paramTVKLiveVideoInfo.getRetCode() != 0) && (paramTVKLiveVideoInfo.getRetCode() != 10) && (paramTVKLiveVideoInfo.getRetCode() != 11) && (paramTVKLiveVideoInfo.getRetCode() != 13))) {
          break label161;
        }
      } while (this.mLiveListener == null);
      this.mLiveListener.onGetLiveInfoSucceed(paramInt, paramTVKLiveVideoInfo);
      return;
      if (paramTVKLiveVideoInfo != null) {
        paramTVKLiveVideoInfo.setErrModule(10001);
      }
    } while (this.mLiveListener == null);
    label161:
    this.mLiveListener.onGetLiveInfoFailed(paramInt, paramTVKLiveVideoInfo);
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
      for (;;)
      {
        this.mHandlerInit = true;
        return;
        this.mEventHandler = new TVKLiveInfoGetter.EventHandler(this, localLooper);
      }
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
      if ((this.mUserInfo != null) && (!TextUtils.isEmpty(this.mUserInfo.getLoginCookie())) && (this.mUserInfo.isVip())) {
        paramTVKPlayerVideoInfo = (TVKLiveVideoInfo)paramTVKPlayerVideoInfo.getAsObject("live_" + this.mProgramId + "_" + paramString + "_" + TVKUtils.getMd5(this.mUserInfo.getLoginCookie()) + "_" + TVKVcSystemInfo.getIP(this.mContext));
      }
      while (paramTVKPlayerVideoInfo != null)
      {
        TVKLogUtil.i(TAG, "getLiveInfo, have cache");
        if (this.mEventHandler == null)
        {
          TVKLogUtil.e(TAG, "[handleSuccess]  mEventHandler is null ");
          handleSuccess(i, paramTVKPlayerVideoInfo);
          return i;
          paramTVKPlayerVideoInfo = (TVKLiveVideoInfo)paramTVKPlayerVideoInfo.getAsObject("live_" + this.mProgramId + "_" + paramString + "_" + TVKVcSystemInfo.getIP(this.mContext));
        }
        else
        {
          Message localMessage = this.mEventHandler.obtainMessage(100);
          localMessage.arg1 = i;
          localMessage.obj = paramTVKPlayerVideoInfo;
          this.mEventHandler.sendMessage(localMessage);
          return i;
        }
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
    if (this.mEventHandler != null)
    {
      this.mEventHandler.post(new TVKLiveInfoGetter.3(this, i, paramInt, paramBoolean, paramMap));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoGetter
 * JD-Core Version:    0.7.0.1
 */