package com.tencent.superplayer.datatransport;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.superplayer.api.ISPlayerPreLoader;
import com.tencent.superplayer.api.ISPlayerPreLoader.Listener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.Utils;
import com.tencent.superplayer.vinfo.VInfoGetter;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.proxy.TPP2PProxyFactory;
import java.util.HashMap;

public class SPlayerPreLoaderImpl
  implements ISPlayerPreLoader
{
  public static final String TAG = SPlayerPreLoaderImpl.class.getSimpleName();
  private ISPlayerPreLoader.Listener mCallbackListener;
  private Context mContext;
  private HandlerThread mHandlerThread;
  private Looper mLooper;
  private HashMap<String, Integer> mPreloadIdSet = new HashMap();
  private ITPPreloadProxy mTPPreloadProxy;
  
  public SPlayerPreLoaderImpl(Context paramContext, int paramInt)
  {
    Utils.initDataTransportDataFolder(Utils.getDownloadProxyServiceType(paramInt));
    this.mContext = paramContext.getApplicationContext();
    this.mTPPreloadProxy = TPP2PProxyFactory.createPreloadManager(paramContext, Utils.getDownloadProxyServiceType(paramInt));
    this.mHandlerThread = new HandlerThread(SPlayerPreLoaderImpl.class.getSimpleName());
    this.mHandlerThread.start();
    this.mLooper = this.mHandlerThread.getLooper();
  }
  
  private boolean innerCheckParamCorrect(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramSuperPlayerVideoInfo.getVideoSource())
    {
    case 2: 
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              if ((TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) || (paramSuperPlayerVideoInfo.getVideoType() != 1)) {
                break;
              }
              bool1 = bool2;
            } while (paramSuperPlayerVideoInfo.getFormat() != 203);
            return false;
            if (TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) {
              break;
            }
            bool1 = bool2;
          } while (paramSuperPlayerVideoInfo.getFormat() == 202);
          bool1 = bool2;
        } while (paramSuperPlayerVideoInfo.getFormat() == 201);
        bool1 = bool2;
      } while (paramSuperPlayerVideoInfo.getFormat() == 101);
      bool1 = bool2;
    } while (paramSuperPlayerVideoInfo.getFormat() == 102);
    return false;
  }
  
  private void innerCreatePreDownloadTask(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, TPDownloadParamData paramTPDownloadParamData)
  {
    switch (paramSuperPlayerVideoInfo.getVideoSource())
    {
    case 2: 
    default: 
      return;
    case 1: 
      VInfoGetter localVInfoGetter = new VInfoGetter(this.mContext, this.mLooper);
      localVInfoGetter.setListener(new SPlayerPreLoaderImpl.2(this, paramTPDownloadParamData));
      localVInfoGetter.doGetVInfo(paramSuperPlayerVideoInfo);
      return;
    }
    innerDoPreDownload(paramSuperPlayerVideoInfo, paramTPDownloadParamData);
  }
  
  private void innerDoPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, TPDownloadParamData paramTPDownloadParamData)
  {
    if (!innerCheckParamCorrect(paramSuperPlayerVideoInfo)) {}
    while (this.mPreloadIdSet.containsKey(Utils.calculateFileIDForVideoInfo(paramSuperPlayerVideoInfo))) {
      return;
    }
    paramTPDownloadParamData.setUrl(paramSuperPlayerVideoInfo.getPlayUrl());
    paramTPDownloadParamData.setDownloadFileID(Utils.calculateFileIDForVideoInfo(paramSuperPlayerVideoInfo));
    int i = 0;
    switch (paramSuperPlayerVideoInfo.getFormat())
    {
    }
    for (;;)
    {
      paramTPDownloadParamData.setDlType(i);
      LogUtil.i(TAG, "innerDoPreDownload() url = " + paramSuperPlayerVideoInfo.getPlayUrl());
      i = this.mTPPreloadProxy.startPreload(Utils.calculateFileIDForVideoInfo(paramSuperPlayerVideoInfo), paramTPDownloadParamData);
      this.mPreloadIdSet.put(Utils.calculateFileIDForVideoInfo(paramSuperPlayerVideoInfo), Integer.valueOf(i));
      return;
      i = 1;
      continue;
      i = 3;
    }
  }
  
  public void destory()
  {
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
  }
  
  public void setPreDownloadListener(ISPlayerPreLoader.Listener paramListener)
  {
    this.mCallbackListener = paramListener;
    this.mTPPreloadProxy.setPreloadListener(new SPlayerPreLoaderImpl.1(this, paramListener));
  }
  
  public void startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong)
  {
    TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData();
    localTPDownloadParamData.setPreloadSize(paramLong);
    localTPDownloadParamData.setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
    innerCreatePreDownloadTask(paramSuperPlayerVideoInfo, localTPDownloadParamData);
  }
  
  public void startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong1, long paramLong2, long paramLong3)
  {
    TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData();
    localTPDownloadParamData.setFileDuration(paramLong1);
    localTPDownloadParamData.setFileSize(paramLong2);
    localTPDownloadParamData.setPreloadDuration(paramLong3);
    localTPDownloadParamData.setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
    innerCreatePreDownloadTask(paramSuperPlayerVideoInfo, localTPDownloadParamData);
  }
  
  public void stopPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    paramSuperPlayerVideoInfo = Utils.calculateFileIDForVideoInfo(paramSuperPlayerVideoInfo);
    if (this.mPreloadIdSet.containsKey(paramSuperPlayerVideoInfo))
    {
      int i = ((Integer)this.mPreloadIdSet.get(paramSuperPlayerVideoInfo)).intValue();
      this.mTPPreloadProxy.stopPreload(i);
      this.mPreloadIdSet.remove(paramSuperPlayerVideoInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreLoaderImpl
 * JD-Core Version:    0.7.0.1
 */