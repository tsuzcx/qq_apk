package com.tencent.superplayer.datatransport;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.superplayer.vinfo.VInfoGetter;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.proxy.TPP2PProxyFactory;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SPlayerPreDownloaderImpl
  implements ISPlayerPreDownloader
{
  public static final String TAG = SPlayerPreDownloaderImpl.class.getSimpleName();
  private ISPlayerPreDownloader.Listener mCallbackListener;
  private Context mContext;
  private HandlerThread mHandlerThread;
  private Looper mLooper;
  private ITPPreloadProxy mTPPreloadProxy;
  private AtomicInteger mTaskIdIncreaser = new AtomicInteger(0);
  private final Hashtable<Integer, Integer> mTaskIdMap = new Hashtable();
  
  public SPlayerPreDownloaderImpl(Context paramContext, int paramInt)
  {
    CommonUtil.a(CommonUtil.a(paramInt));
    this.mContext = paramContext.getApplicationContext();
    this.mTPPreloadProxy = TPP2PProxyFactory.createPreloadManager(paramContext, CommonUtil.a(paramInt));
    this.mHandlerThread = new HandlerThread(SPlayerPreDownloaderImpl.class.getSimpleName());
    this.mHandlerThread.start();
  }
  
  private boolean checkParamCorrect(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
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
            } while (paramSuperPlayerVideoInfo.getFormat() != 304);
            return false;
            if (TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) {
              break;
            }
            bool1 = bool2;
          } while (paramSuperPlayerVideoInfo.getFormat() == 302);
          bool1 = bool2;
        } while (paramSuperPlayerVideoInfo.getFormat() == 301);
        bool1 = bool2;
      } while (paramSuperPlayerVideoInfo.getFormat() == 101);
      bool1 = bool2;
    } while (paramSuperPlayerVideoInfo.getFormat() == 102);
    return false;
  }
  
  private void configDownloadParamData(TPDownloadParamData paramTPDownloadParamData, SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    paramTPDownloadParamData.setUrl(paramSuperPlayerVideoInfo.getPlayUrl());
    paramTPDownloadParamData.setDownloadFileID(CommonUtil.a(paramSuperPlayerVideoInfo));
    int i = 0;
    switch (paramSuperPlayerVideoInfo.getFormat())
    {
    }
    for (;;)
    {
      paramTPDownloadParamData.setDlType(i);
      return;
      i = 1;
      continue;
      i = 3;
    }
  }
  
  private void configDownloadParamData(TPDownloadParamData paramTPDownloadParamData, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, SuperPlayerDownOption paramSuperPlayerDownOption)
  {
    if (paramTPDownloadParamData == null) {}
    do
    {
      return;
      if (paramSuperPlayerVideoInfo != null)
      {
        paramTPDownloadParamData.setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
        paramTPDownloadParamData.setUrlHostList(paramSuperPlayerVideoInfo.getUrlHostList());
      }
    } while (paramSuperPlayerDownOption == null);
    if (paramSuperPlayerDownOption.enableP2P) {}
    for (int i = 1;; i = 0)
    {
      paramTPDownloadParamData.setFp2p(i);
      paramTPDownloadParamData.setPreloadSize(paramSuperPlayerDownOption.preloadSize);
      paramSuperPlayerVideoInfo = new HashMap();
      paramSuperPlayerVideoInfo.put("dl_param_is_enable_quic", Boolean.valueOf(paramSuperPlayerDownOption.enableUseQuic));
      paramSuperPlayerVideoInfo.put("dl_param_enable_teg_pcdn", Boolean.valueOf(paramSuperPlayerDownOption.enablePcdn));
      paramSuperPlayerVideoInfo.put("dl_param_is_enable_quic_plaintext", Boolean.valueOf(paramSuperPlayerDownOption.enableQuicPlaintext));
      paramSuperPlayerVideoInfo.put("dl_param_is_enable_quic_connection_migration", Boolean.valueOf(paramSuperPlayerDownOption.enableQuicConnectionMigration));
      paramSuperPlayerVideoInfo.put("dl_param_quic_congestion_type", Integer.valueOf(paramSuperPlayerDownOption.quicCongestionType));
      paramTPDownloadParamData.setExtInfoMap(paramSuperPlayerVideoInfo);
      return;
    }
  }
  
  private void createPreDownloadTask(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, TPDownloadParamData paramTPDownloadParamData, int paramInt)
  {
    switch (paramSuperPlayerVideoInfo.getVideoSource())
    {
    case 2: 
    default: 
      return;
    case 1: 
      if (this.mLooper == null) {
        if (this.mHandlerThread == null) {
          break label97;
        }
      }
      label97:
      for (this.mLooper = this.mHandlerThread.getLooper();; this.mLooper = Looper.getMainLooper())
      {
        VInfoGetter localVInfoGetter = new VInfoGetter(this.mContext, this.mLooper);
        localVInfoGetter.setListener(new SPlayerPreDownloaderImpl.3(this, paramTPDownloadParamData, paramInt));
        localVInfoGetter.doGetVInfo(paramSuperPlayerVideoInfo);
        return;
      }
    }
    doPreDownload(paramSuperPlayerVideoInfo, paramTPDownloadParamData, paramInt);
  }
  
  private void doPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, TPDownloadParamData paramTPDownloadParamData, int paramInt)
  {
    LogUtil.d(TAG, "doPreDownload() taskid=" + paramInt + ", videoInfo=" + paramSuperPlayerVideoInfo);
    if (!checkParamCorrect(paramSuperPlayerVideoInfo))
    {
      LogUtil.d(TAG, "doPreDownload() checkParamCorrect(videoInfo) error, return");
      return;
    }
    configDownloadParamData(paramTPDownloadParamData, paramSuperPlayerVideoInfo);
    int i = this.mTPPreloadProxy.startPreload(CommonUtil.a(paramSuperPlayerVideoInfo), paramTPDownloadParamData, new SPlayerPreDownloaderImpl.4(this, paramInt));
    this.mTaskIdMap.put(Integer.valueOf(paramInt), Integer.valueOf(i));
    LogUtil.d(TAG, "doPreDownload() map: taskid=" + paramInt + "-> taskIdForTPProxy=" + i);
  }
  
  public void destory()
  {
    LogUtil.d(TAG, "destory()");
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    this.mCallbackListener = null;
  }
  
  public void setOnPreDownloadListener(ISPlayerPreDownloader.Listener paramListener)
  {
    this.mCallbackListener = paramListener;
  }
  
  public int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong)
  {
    int i = this.mTaskIdIncreaser.addAndGet(1);
    LogUtil.d(TAG, "startPreDownload() videoInfo=" + paramSuperPlayerVideoInfo.toString() + ", preloadSize=" + paramLong + ", taskId=" + i);
    TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData();
    localTPDownloadParamData.setPreloadSize(paramLong);
    localTPDownloadParamData.setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
    localTPDownloadParamData.setUrlHostList(paramSuperPlayerVideoInfo.getUrlHostList());
    createPreDownloadTask(paramSuperPlayerVideoInfo, localTPDownloadParamData, i);
    return i;
  }
  
  public int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong1, long paramLong2)
  {
    int i = this.mTaskIdIncreaser.addAndGet(1);
    LogUtil.d(TAG, "startPreDownload() videoInfo=" + paramSuperPlayerVideoInfo.toString() + ", videoDurationMs=" + paramLong1 + ", preloadDurationMs=" + paramLong2 + ", taskId=" + i);
    TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData();
    localTPDownloadParamData.setFileDuration(paramLong1);
    localTPDownloadParamData.setPreloadDuration(paramLong2);
    localTPDownloadParamData.setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
    localTPDownloadParamData.setUrlHostList(paramSuperPlayerVideoInfo.getUrlHostList());
    createPreDownloadTask(paramSuperPlayerVideoInfo, localTPDownloadParamData, i);
    return i;
  }
  
  public int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong1, long paramLong2, SuperPlayerDownOption paramSuperPlayerDownOption)
  {
    int i = this.mTaskIdIncreaser.addAndGet(1);
    LogUtil.d(TAG, "startPreDownload() videoInfo=" + paramSuperPlayerVideoInfo.toString() + ", videoDurationMs=" + paramLong1 + ", preloadDurationMs=" + paramLong2 + ", taskId=" + i);
    TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData();
    localTPDownloadParamData.setFileDuration(paramLong1);
    localTPDownloadParamData.setPreloadDuration(paramLong2);
    configDownloadParamData(localTPDownloadParamData, paramSuperPlayerVideoInfo, paramSuperPlayerDownOption);
    createPreDownloadTask(paramSuperPlayerVideoInfo, localTPDownloadParamData, i);
    return i;
  }
  
  public int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerDownOption paramSuperPlayerDownOption)
  {
    int i = this.mTaskIdIncreaser.addAndGet(1);
    LogUtil.d(TAG, "startPreDownload() videoInfo=" + paramSuperPlayerVideoInfo.toString() + ", preloadSize=" + paramLong + ", taskId=" + i);
    TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData();
    localTPDownloadParamData.setPreloadSize(paramLong);
    configDownloadParamData(localTPDownloadParamData, paramSuperPlayerVideoInfo, paramSuperPlayerDownOption);
    createPreDownloadTask(paramSuperPlayerVideoInfo, localTPDownloadParamData, i);
    return i;
  }
  
  public void stopAllPreDownload()
  {
    synchronized (this.mTaskIdMap)
    {
      LogUtil.d(TAG, "stopAllPreDownload(), mTaskIdMap.size()=" + this.mTaskIdMap.size());
      Iterator localIterator = this.mTaskIdMap.keySet().iterator();
      if (localIterator.hasNext()) {
        ThreadUtil.runOnThreadPool(new SPlayerPreDownloaderImpl.2(this, ((Integer)localIterator.next()).intValue()));
      }
    }
    this.mTaskIdMap.clear();
  }
  
  public void stopPreDownload(int paramInt)
  {
    LogUtil.d(TAG, "stopPreDownload() taskid=" + paramInt);
    synchronized (this.mTaskIdMap)
    {
      if (this.mTaskIdMap.containsKey(Integer.valueOf(paramInt)))
      {
        ThreadUtil.runOnThreadPool(new SPlayerPreDownloaderImpl.1(this, paramInt, ((Integer)this.mTaskIdMap.get(Integer.valueOf(paramInt))).intValue()));
        this.mTaskIdMap.remove(Integer.valueOf(paramInt));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */