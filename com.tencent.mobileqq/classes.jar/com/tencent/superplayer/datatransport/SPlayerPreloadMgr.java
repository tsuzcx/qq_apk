package com.tencent.superplayer.datatransport;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.SPlayerLogUtil;
import com.tencent.superplayer.utils.SPlayerUtils;
import com.tencent.superplayer.vinfo.VInfoGetter;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.proxy.TPP2PProxyFactory;
import java.util.HashMap;

public class SPlayerPreloadMgr
{
  public static final String TAG = SPlayerPreloadMgr.class.getSimpleName();
  private static SPlayerPreloadMgr mInstance;
  private Context mContext;
  private ITPPreloadProxy mDownloadManager;
  private HandlerThread mHandlerThread;
  private Looper mLooper;
  private HashMap<String, Integer> mPreloadIdSet = new HashMap();
  
  private SPlayerPreloadMgr(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mDownloadManager = TPP2PProxyFactory.createPreloadManager(paramContext, SuperPlayerMgr.getPlatform());
    initLooper();
  }
  
  public static SPlayerPreloadMgr getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new SPlayerPreloadMgr(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  private void initLooper()
  {
    this.mHandlerThread = new HandlerThread("FCCPreloadMgr");
    this.mHandlerThread.start();
    this.mLooper = this.mHandlerThread.getLooper();
  }
  
  private boolean innerCheckParamCorrect(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    return (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) && (paramSuperPlayerVideoInfo.getVideoType() == 1) && (paramSuperPlayerVideoInfo.getFormat() != 103);
  }
  
  private void innerDoPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (!innerCheckParamCorrect(paramSuperPlayerVideoInfo)) {}
    while (this.mPreloadIdSet.containsKey(paramSuperPlayerVideoInfo.getVid())) {
      return;
    }
    TPDownloadParamData localTPDownloadParamData = new TPDownloadParamData();
    localTPDownloadParamData.setUrl(paramSuperPlayerVideoInfo.getPlayUrl());
    localTPDownloadParamData.setPreloadSize(393216L);
    int i = 0;
    switch (paramSuperPlayerVideoInfo.getFormat())
    {
    }
    for (;;)
    {
      localTPDownloadParamData.setDlType(i);
      SPlayerLogUtil.i(TAG, "innerDoPreDownload() url = " + paramSuperPlayerVideoInfo.getPlayUrl());
      i = this.mDownloadManager.startPreload(SPlayerUtils.calculateFileID(paramSuperPlayerVideoInfo.getPlayUrl()), localTPDownloadParamData);
      this.mPreloadIdSet.put(paramSuperPlayerVideoInfo.getVid(), Integer.valueOf(i));
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
  
  public void preDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    switch (paramSuperPlayerVideoInfo.getVideoSource())
    {
    default: 
      return;
    }
    VInfoGetter localVInfoGetter = new VInfoGetter(this.mContext, this.mLooper);
    localVInfoGetter.setListener(new SPlayerPreloadMgr.1(this));
    localVInfoGetter.doGetVInfo(paramSuperPlayerVideoInfo);
  }
  
  public void stopPreDownload(String paramString)
  {
    if (this.mPreloadIdSet.containsKey(paramString))
    {
      int i = ((Integer)this.mPreloadIdSet.get(paramString)).intValue();
      this.mDownloadManager.stopPreload(i);
      this.mPreloadIdSet.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreloadMgr
 * JD-Core Version:    0.7.0.1
 */