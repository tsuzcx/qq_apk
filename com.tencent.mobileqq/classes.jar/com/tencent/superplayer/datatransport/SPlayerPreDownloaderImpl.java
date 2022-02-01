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
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SPlayerPreDownloaderImpl
  implements ISPlayerPreDownloader
{
  public static final String TAG = "SPlayerPreDownloaderImpl";
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
    int i = paramSuperPlayerVideoInfo.getVideoSource();
    boolean bool3 = false;
    boolean bool2 = false;
    if (i != 1)
    {
      if (i != 3) {
        return false;
      }
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) {
        if ((paramSuperPlayerVideoInfo.getFormat() != 302) && (paramSuperPlayerVideoInfo.getFormat() != 301) && (paramSuperPlayerVideoInfo.getFormat() != 101))
        {
          bool1 = bool2;
          if (paramSuperPlayerVideoInfo.getFormat() != 102) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    boolean bool1 = bool3;
    if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl()))
    {
      bool1 = bool3;
      if (paramSuperPlayerVideoInfo.getVideoType() == 1)
      {
        bool1 = bool3;
        if (paramSuperPlayerVideoInfo.getFormat() != 304) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void configDownloadParamData(TPDownloadParamData paramTPDownloadParamData, SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    paramTPDownloadParamData.setUrl(paramSuperPlayerVideoInfo.getPlayUrl());
    paramTPDownloadParamData.setDownloadFileID(CommonUtil.a(paramSuperPlayerVideoInfo));
    int i = paramSuperPlayerVideoInfo.getFormat();
    if (i != 101)
    {
      if (i != 102)
      {
        if (i == 301) {
          break label57;
        }
        if (i != 302)
        {
          i = 0;
          break label59;
        }
      }
      i = 3;
      break label59;
    }
    label57:
    i = 1;
    label59:
    paramTPDownloadParamData.setDlType(i);
  }
  
  private void configDownloadParamData(TPDownloadParamData paramTPDownloadParamData, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, SuperPlayerDownOption paramSuperPlayerDownOption)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void createPreDownloadTask(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, TPDownloadParamData paramTPDownloadParamData, int paramInt)
  {
    int i = paramSuperPlayerVideoInfo.getVideoSource();
    if (i != 1)
    {
      if (i != 3) {
        return;
      }
      doPreDownload(paramSuperPlayerVideoInfo, paramTPDownloadParamData, paramInt);
      return;
    }
    if (this.mLooper == null)
    {
      localObject = this.mHandlerThread;
      if (localObject != null) {
        this.mLooper = ((HandlerThread)localObject).getLooper();
      } else {
        this.mLooper = Looper.getMainLooper();
      }
    }
    Object localObject = new VInfoGetter(this.mContext, this.mLooper);
    ((VInfoGetter)localObject).setListener(new SPlayerPreDownloaderImpl.3(this, paramTPDownloadParamData, paramInt));
    ((VInfoGetter)localObject).doGetVInfo(paramSuperPlayerVideoInfo);
  }
  
  private void doPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, TPDownloadParamData paramTPDownloadParamData, int paramInt)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doPreDownload() taskid=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", videoInfo=");
    localStringBuilder.append(paramSuperPlayerVideoInfo);
    LogUtil.d(str, localStringBuilder.toString());
    if (!checkParamCorrect(paramSuperPlayerVideoInfo))
    {
      LogUtil.d(TAG, "doPreDownload() checkParamCorrect(videoInfo) error, return");
      return;
    }
    configDownloadParamData(paramTPDownloadParamData, paramSuperPlayerVideoInfo);
    int i = this.mTPPreloadProxy.startPreload(CommonUtil.a(paramSuperPlayerVideoInfo), paramTPDownloadParamData, new SPlayerPreDownloaderImpl.4(this, paramInt));
    this.mTaskIdMap.put(Integer.valueOf(paramInt), Integer.valueOf(i));
    paramSuperPlayerVideoInfo = TAG;
    paramTPDownloadParamData = new StringBuilder();
    paramTPDownloadParamData.append("doPreDownload() map: taskid=");
    paramTPDownloadParamData.append(paramInt);
    paramTPDownloadParamData.append("-> taskIdForTPProxy=");
    paramTPDownloadParamData.append(i);
    LogUtil.d(paramSuperPlayerVideoInfo, paramTPDownloadParamData.toString());
  }
  
  public void destory()
  {
    LogUtil.d(TAG, "destory()");
    HandlerThread localHandlerThread = this.mHandlerThread;
    if (localHandlerThread != null)
    {
      localHandlerThread.quit();
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
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPreDownload() videoInfo=");
    localStringBuilder.append(paramSuperPlayerVideoInfo.toString());
    localStringBuilder.append(", preloadSize=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", taskId=");
    localStringBuilder.append(i);
    LogUtil.d((String)localObject, localStringBuilder.toString());
    localObject = new TPDownloadParamData();
    ((TPDownloadParamData)localObject).setPreloadSize(paramLong);
    ((TPDownloadParamData)localObject).setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
    ((TPDownloadParamData)localObject).setUrlHostList(paramSuperPlayerVideoInfo.getUrlHostList());
    createPreDownloadTask(paramSuperPlayerVideoInfo, (TPDownloadParamData)localObject, i);
    return i;
  }
  
  public int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong1, long paramLong2)
  {
    int i = this.mTaskIdIncreaser.addAndGet(1);
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPreDownload() videoInfo=");
    localStringBuilder.append(paramSuperPlayerVideoInfo.toString());
    localStringBuilder.append(", videoDurationMs=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", preloadDurationMs=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(", taskId=");
    localStringBuilder.append(i);
    LogUtil.d((String)localObject, localStringBuilder.toString());
    localObject = new TPDownloadParamData();
    ((TPDownloadParamData)localObject).setFileDuration(paramLong1);
    ((TPDownloadParamData)localObject).setPreloadDuration(paramLong2);
    ((TPDownloadParamData)localObject).setSavePath(paramSuperPlayerVideoInfo.getLocalSavePath());
    ((TPDownloadParamData)localObject).setUrlHostList(paramSuperPlayerVideoInfo.getUrlHostList());
    createPreDownloadTask(paramSuperPlayerVideoInfo, (TPDownloadParamData)localObject, i);
    return i;
  }
  
  public int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong1, long paramLong2, SuperPlayerDownOption paramSuperPlayerDownOption)
  {
    int i = this.mTaskIdIncreaser.addAndGet(1);
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPreDownload() videoInfo=");
    localStringBuilder.append(paramSuperPlayerVideoInfo.toString());
    localStringBuilder.append(", videoDurationMs=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", preloadDurationMs=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(", taskId=");
    localStringBuilder.append(i);
    LogUtil.d((String)localObject, localStringBuilder.toString());
    localObject = new TPDownloadParamData();
    ((TPDownloadParamData)localObject).setFileDuration(paramLong1);
    ((TPDownloadParamData)localObject).setPreloadDuration(paramLong2);
    configDownloadParamData((TPDownloadParamData)localObject, paramSuperPlayerVideoInfo, paramSuperPlayerDownOption);
    createPreDownloadTask(paramSuperPlayerVideoInfo, (TPDownloadParamData)localObject, i);
    return i;
  }
  
  public int startPreDownload(SuperPlayerVideoInfo paramSuperPlayerVideoInfo, long paramLong, SuperPlayerDownOption paramSuperPlayerDownOption)
  {
    int i = this.mTaskIdIncreaser.addAndGet(1);
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPreDownload() videoInfo=");
    localStringBuilder.append(paramSuperPlayerVideoInfo.toString());
    localStringBuilder.append(", preloadSize=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", taskId=");
    localStringBuilder.append(i);
    LogUtil.d((String)localObject, localStringBuilder.toString());
    localObject = new TPDownloadParamData();
    ((TPDownloadParamData)localObject).setPreloadSize(paramLong);
    configDownloadParamData((TPDownloadParamData)localObject, paramSuperPlayerVideoInfo, paramSuperPlayerDownOption);
    createPreDownloadTask(paramSuperPlayerVideoInfo, (TPDownloadParamData)localObject, i);
    return i;
  }
  
  public void stopAllPreDownload()
  {
    synchronized (this.mTaskIdMap)
    {
      Object localObject1 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopAllPreDownload(), mTaskIdMap.size()=");
      localStringBuilder.append(this.mTaskIdMap.size());
      LogUtil.d((String)localObject1, localStringBuilder.toString());
      localObject1 = this.mTaskIdMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ThreadUtil.runOnThreadPool(new SPlayerPreDownloaderImpl.2(this, ((Integer)((Iterator)localObject1).next()).intValue()));
      }
      this.mTaskIdMap.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void stopPreDownload(int paramInt)
  {
    ??? = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopPreDownload() taskid=");
    localStringBuilder.append(paramInt);
    LogUtil.d((String)???, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.datatransport.SPlayerPreDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */