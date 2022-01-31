package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.HashMap;
import java.util.Map;

public class TPListenerManager
{
  private static final String FILE_NAME = "TPListenerManager";
  private static final int MSG_CURRENT_CDN_URL = 5;
  private static final int MSG_CURRENT_CDN_URL_INFO = 6;
  private static final int MSG_DOWNLOAD_PROTOCOL = 9;
  private static final int MSG_DOWNLOAD_STATUS = 8;
  private static final int MSG_ERROR = 4;
  private static final int MSG_FINISH = 3;
  private static final int MSG_NOTIFY_PLAYER_SWITCH_DEFINITION = 2003;
  private static final int MSG_PLAY_VIDEO_NOT_FOUND = 101;
  private static final int MSG_PREPARE_FINISH = 50;
  private static final int MSG_PROGRESS = 2;
  private static final int MSG_URL_EXPIRED = 7;
  private static final Object OFFLINE_LISTENER_MAP_MUTEX = new Object();
  private static final Object PLAY_LISTENER_MAP_MUTEX = new Object();
  private static final Object PRELOAD_LISTENER_MAP_MUTEX;
  private static final Object PROXY_PLAY_LISTENER_MAP_MUTEX = new Object();
  private static final String THREAD_NAME = "TVKDL-Listener";
  private Handler mMsgHandler;
  private HandlerThread mMsgHandlerThread;
  private Map<Integer, ITPOfflineDownloadListener> mOfflineDownloadListenerMap = new HashMap();
  private Map<Integer, ITPPlayListener> mPlayListenerMap = new HashMap();
  private Map<Integer, ITPPreLoadListener> mPreLoadListenerMap = new HashMap();
  private Map<Integer, ITPPlayListener> mProxyPlayListenerMap = new HashMap();
  private Runnable updatePlayerInfo = new TPListenerManager.1(this);
  private Runnable updateProxyPlayerInfo = new TPListenerManager.2(this);
  
  static
  {
    PRELOAD_LISTENER_MAP_MUTEX = new Object();
  }
  
  private void dispatchCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    Object localObject = getPlaylistener(paramInt2);
    if (localObject != null) {
      dispatchPlayMessage((ITPPlayListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    }
    do
    {
      return;
      localObject = getProxyPlayListener(paramInt2);
      if (localObject != null)
      {
        dispatchPlayMessage((ITPPlayListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
        return;
      }
      localObject = getPreLoadListener(paramInt2);
      if (localObject != null)
      {
        dispatchPreLoadMessage((ITPPreLoadListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
        return;
      }
      localObject = getOfflineDownloadListener(paramInt2);
    } while (localObject == null);
    dispatchOfflineDownloadMessage((ITPOfflineDownloadListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
  }
  
  private void dispatchOfflineDownloadMessage(ITPOfflineDownloadListener paramITPOfflineDownloadListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if (paramITPOfflineDownloadListener == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 2: 
      paramITPOfflineDownloadListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L));
      return;
    case 3: 
      paramITPOfflineDownloadListener.onDownloadFinish();
      return;
    case 4: 
      paramITPOfflineDownloadListener.onDownloadError(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue(), TPDLProxyUtils.byteArrayToString((byte[])paramObject3));
      return;
    case 5: 
      paramITPOfflineDownloadListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
      return;
    case 6: 
      paramITPOfflineDownloadListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), TPDLProxyUtils.byteArrayToString((byte[])paramObject3), TPDLProxyUtils.byteArrayToString((byte[])paramObject4));
      return;
    case 7: 
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      long l = TPDLProxyUtils.objectToLong(paramObject2, 0L);
      paramObject2 = new HashMap();
      if (!TextUtils.isEmpty(paramObject1))
      {
        paramObject2.put("exttag", paramObject1);
        paramObject2.put("randnum", String.valueOf(l));
      }
      paramITPOfflineDownloadListener.onDownloadCdnUrlExpired(paramObject2);
      return;
    case 8: 
      paramITPOfflineDownloadListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0));
      return;
    }
    paramITPOfflineDownloadListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2));
  }
  
  private void dispatchPlayMessage(ITPPlayListener paramITPPlayListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if (paramITPPlayListener == null) {
      return;
    }
    long l;
    switch (paramInt1)
    {
    case 4: 
    default: 
      return;
    case 2: 
      paramITPPlayListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L));
      return;
    case 3: 
      paramITPPlayListener.onDownloadFinish();
      return;
    case 5: 
      paramITPPlayListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
      return;
    case 6: 
      paramITPPlayListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), TPDLProxyUtils.byteArrayToString((byte[])paramObject3), TPDLProxyUtils.byteArrayToString((byte[])paramObject4));
      return;
    case 7: 
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      l = TPDLProxyUtils.objectToLong(paramObject2, 0L);
      paramObject2 = new HashMap();
      if (!TextUtils.isEmpty(paramObject1))
      {
        paramObject2.put("exttag", paramObject1);
        paramObject2.put("randnum", String.valueOf(l));
      }
      paramITPPlayListener.onDownloadCdnUrlExpired(paramObject2);
      return;
    case 8: 
      paramITPPlayListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0));
      return;
    case 9: 
      paramITPPlayListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2));
      return;
    case 101: 
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      l = TPDLProxyUtils.objectToLong(paramObject2, 0L);
      paramObject2 = new HashMap();
      if (!TextUtils.isEmpty(paramObject1))
      {
        paramObject2.put("exttag", paramObject1);
        paramObject2.put("randnum", String.valueOf(l));
      }
      paramITPPlayListener.onPlayCallback(1, paramObject2, null, null, null);
      return;
    }
    paramITPPlayListener.onPlayCallback(2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), Integer.valueOf(TPDLProxyUtils.objectToInt(paramObject3, 0)), null);
  }
  
  private void dispatchPreLoadMessage(ITPPreLoadListener paramITPPreLoadListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if (paramITPPreLoadListener == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 2: 
      paramITPPreLoadListener.onPrepareDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L));
      return;
    case 50: 
      paramITPPreLoadListener.onPrepareOK();
      return;
    }
    paramITPPreLoadListener.onPrepareError();
  }
  
  public static TPListenerManager getInstance()
  {
    return TPListenerManager.SingletonHolder.access$100();
  }
  
  public ITPOfflineDownloadListener getOfflineDownloadListener(int paramInt)
  {
    synchronized (OFFLINE_LISTENER_MAP_MUTEX)
    {
      ITPOfflineDownloadListener localITPOfflineDownloadListener = (ITPOfflineDownloadListener)this.mOfflineDownloadListenerMap.get(Integer.valueOf(paramInt));
      return localITPOfflineDownloadListener;
    }
  }
  
  public ITPPlayListener getPlaylistener(int paramInt)
  {
    synchronized (PLAY_LISTENER_MAP_MUTEX)
    {
      ITPPlayListener localITPPlayListener = (ITPPlayListener)this.mPlayListenerMap.get(Integer.valueOf(paramInt));
      return localITPPlayListener;
    }
  }
  
  public ITPPreLoadListener getPreLoadListener(int paramInt)
  {
    synchronized (PRELOAD_LISTENER_MAP_MUTEX)
    {
      ITPPreLoadListener localITPPreLoadListener = (ITPPreLoadListener)this.mPreLoadListenerMap.get(Integer.valueOf(paramInt));
      return localITPPreLoadListener;
    }
  }
  
  public ITPPlayListener getProxyPlayListener(int paramInt)
  {
    synchronized (PROXY_PLAY_LISTENER_MAP_MUTEX)
    {
      ITPPlayListener localITPPlayListener = (ITPPlayListener)this.mProxyPlayListenerMap.get(Integer.valueOf(paramInt));
      return localITPPlayListener;
    }
  }
  
  public void handleCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    try
    {
      this.mMsgHandler.post(new TPListenerManager.3(this, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5));
      return;
    }
    finally
    {
      paramObject1 = finally;
      throw paramObject1;
    }
  }
  
  public void initHandler()
  {
    if (this.mMsgHandlerThread == null)
    {
      this.mMsgHandlerThread = new HandlerThread("TVKDL-Listener");
      this.mMsgHandlerThread.start();
      this.mMsgHandler = new Handler(this.mMsgHandlerThread.getLooper());
      this.mMsgHandler.postDelayed(this.updatePlayerInfo, 1000L);
      this.mMsgHandler.postDelayed(this.updateProxyPlayerInfo, 1000L);
    }
  }
  
  public void removeOfflineDownloadListener(int paramInt)
  {
    if (paramInt > 0) {
      synchronized (OFFLINE_LISTENER_MAP_MUTEX)
      {
        this.mOfflineDownloadListenerMap.remove(Integer.valueOf(paramInt));
        return;
      }
    }
  }
  
  public void removePlayListener(int paramInt)
  {
    if (paramInt > 0) {
      synchronized (PLAY_LISTENER_MAP_MUTEX)
      {
        this.mPlayListenerMap.remove(Integer.valueOf(paramInt));
        return;
      }
    }
  }
  
  public void removePreLoadListener(int paramInt)
  {
    if (paramInt > 0) {
      synchronized (PRELOAD_LISTENER_MAP_MUTEX)
      {
        this.mPreLoadListenerMap.remove(Integer.valueOf(paramInt));
        return;
      }
    }
  }
  
  public void removeProxyPlayListener(int paramInt)
  {
    if (paramInt > 0) {
      synchronized (PROXY_PLAY_LISTENER_MAP_MUTEX)
      {
        this.mProxyPlayListenerMap.remove(Integer.valueOf(paramInt));
        return;
      }
    }
  }
  
  public void setOfflineDownloadListener(int paramInt, ITPOfflineDownloadListener paramITPOfflineDownloadListener)
  {
    if ((paramInt > 0) && (paramITPOfflineDownloadListener != null)) {
      synchronized (OFFLINE_LISTENER_MAP_MUTEX)
      {
        this.mOfflineDownloadListenerMap.put(Integer.valueOf(paramInt), paramITPOfflineDownloadListener);
        return;
      }
    }
  }
  
  public void setPlayListener(int paramInt, ITPPlayListener paramITPPlayListener)
  {
    if ((paramInt > 0) && (paramITPPlayListener != null)) {
      synchronized (PLAY_LISTENER_MAP_MUTEX)
      {
        this.mPlayListenerMap.put(Integer.valueOf(paramInt), paramITPPlayListener);
        return;
      }
    }
  }
  
  public void setPreLoadListener(int paramInt, ITPPreLoadListener paramITPPreLoadListener)
  {
    if ((paramInt > 0) && (paramITPPreLoadListener != null)) {
      synchronized (PRELOAD_LISTENER_MAP_MUTEX)
      {
        this.mPreLoadListenerMap.put(Integer.valueOf(paramInt), paramITPPreLoadListener);
        return;
      }
    }
  }
  
  public void setProxyPlayListener(int paramInt, ITPPlayListener paramITPPlayListener)
  {
    if ((paramInt > 0) && (paramITPPlayListener != null)) {
      synchronized (PROXY_PLAY_LISTENER_MAP_MUTEX)
      {
        this.mProxyPlayListenerMap.put(Integer.valueOf(paramInt), paramITPPlayListener);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager
 * JD-Core Version:    0.7.0.1
 */