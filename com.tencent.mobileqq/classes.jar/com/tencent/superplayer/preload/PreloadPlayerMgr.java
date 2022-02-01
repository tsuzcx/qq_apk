package com.tencent.superplayer.preload;

import android.app.Activity;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.superplayer.view.SPlayerVideoView;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PreloadPlayerMgr
  implements IPreloadPlayerMgr
{
  private static PreloadPlayerMgr sInstance;
  private final Map<Integer, PreloadPlayerInfo> mPreloadTaskMap = new ConcurrentHashMap();
  private AtomicInteger mTaskIdIncreaser = new AtomicInteger(1);
  
  public static PreloadPlayerMgr getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new PreloadPlayerMgr();
      }
      PreloadPlayerMgr localPreloadPlayerMgr = sInstance;
      return localPreloadPlayerMgr;
    }
    finally {}
  }
  
  private PreloadPlayerInfo getWrapperFromPlayerInfo(PreloadPlayerInfo paramPreloadPlayerInfo)
  {
    if (paramPreloadPlayerInfo.player != null)
    {
      if (paramPreloadPlayerInfo.videoView == null) {
        return null;
      }
      if (paramPreloadPlayerInfo.videoView.isSurfaceReady()) {
        return paramPreloadPlayerInfo;
      }
      ThreadUtil.runOnThreadPool(new PreloadPlayerMgr.3(this, paramPreloadPlayerInfo));
    }
    return null;
  }
  
  private void preloadPlayerAsync(Activity paramActivity, int paramInt1, SuperPlayerVideoInfo paramSuperPlayerVideoInfo, int paramInt2)
  {
    ThreadUtil.runOnThreadPool(new PreloadPlayerMgr.1(this, paramActivity, paramInt1, paramSuperPlayerVideoInfo, paramInt2));
  }
  
  public PreloadPlayerInfo getPlayerFromPool(int paramInt, SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    synchronized (this.mPreloadTaskMap)
    {
      Iterator localIterator = this.mPreloadTaskMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        PreloadPlayerInfo localPreloadPlayerInfo = (PreloadPlayerInfo)((Map.Entry)localIterator.next()).getValue();
        if ((localPreloadPlayerInfo.sceneId == paramInt) && (localPreloadPlayerInfo.videoInfo.equals(paramSuperPlayerVideoInfo)))
        {
          localIterator.remove();
          paramSuperPlayerVideoInfo = getWrapperFromPlayerInfo(localPreloadPlayerInfo);
          return paramSuperPlayerVideoInfo;
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramSuperPlayerVideoInfo;
    }
  }
  
  public int startPreloadTask(Activity paramActivity, int paramInt, SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    int i = this.mTaskIdIncreaser.getAndAdd(1);
    PreloadPlayerInfo localPreloadPlayerInfo = new PreloadPlayerInfo();
    localPreloadPlayerInfo.sceneId = paramInt;
    localPreloadPlayerInfo.videoInfo = paramSuperPlayerVideoInfo;
    this.mPreloadTaskMap.put(Integer.valueOf(i), localPreloadPlayerInfo);
    preloadPlayerAsync(paramActivity, paramInt, paramSuperPlayerVideoInfo, i);
    return i;
  }
  
  public void stopPreloadTask(int paramInt)
  {
    synchronized (this.mPreloadTaskMap)
    {
      PreloadPlayerInfo localPreloadPlayerInfo = (PreloadPlayerInfo)this.mPreloadTaskMap.remove(Integer.valueOf(paramInt));
      if (localPreloadPlayerInfo != null) {
        ThreadUtil.runOnThreadPool(new PreloadPlayerMgr.2(this, localPreloadPlayerInfo));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.preload.PreloadPlayerMgr
 * JD-Core Version:    0.7.0.1
 */