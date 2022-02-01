package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import com.tencent.thumbplayer.core.downloadproxy.utils.TVKThreadUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class TPListenerManager
{
  private static final int DLTASK_CALLBACK_MSG_QUIC_DOWNLOAD_STATUS = 20;
  private static final String FILE_NAME = "TPListenerManager";
  private static final int MSG_CALLBACK_MSG_REPORT = 30001;
  private static final int MSG_CALLBACK_MSG_REPORT_QUIC_QUALITY = 30002;
  private static final int MSG_CURRENT_CDN_URL = 5;
  private static final int MSG_CURRENT_CDN_URL_INFO = 6;
  private static final int MSG_DOWNLOAD_PROTOCOL = 9;
  private static final int MSG_DOWNLOAD_STATUS = 8;
  private static final int MSG_ERROR = 4;
  private static final int MSG_FINISH = 3;
  private static final int MSG_NOTIFY_HTTP_HEADER = 2006;
  private static final int MSG_NOTIFY_LOSE_PACKAGE_CEHCK = 2004;
  private static final int MSG_NOTIFY_M3U8_CONTENT = 2007;
  private static final int MSG_NOTIFY_PLAYER_SWITCH_DEFINITION = 2003;
  private static final int MSG_PLAY_VIDEO_NOT_FOUND = 101;
  private static final int MSG_PREPARE_FINISH = 50;
  private static final int MSG_PROGRESS = 2;
  private static final int MSG_PROXY_CANCEL_READ_DATA = 202;
  private static final int MSG_PROXY_GET_CONTENT_TYPE = 205;
  private static final int MSG_PROXY_GET_DATA_FILE_PATH = 204;
  private static final int MSG_PROXY_GET_DATA_TOTAL_SIZE = 203;
  private static final int MSG_PROXY_READ_DATA = 201;
  private static final int MSG_PROXY_START_READ_DATA = 200;
  private static final int MSG_URL_EXPIRED = 7;
  private static final Object OFFLINE_LISTENER_MAP_MUTEX = new Object();
  private static final Object PLAY_LISTENER_MAP_MUTEX = new Object();
  private static final Object PRELOAD_LISTENER_MAP_MUTEX = new Object();
  private static final String THREAD_NAME = "TVKDL-Listener";
  private ITPDownloadListener mITPDownloadListener = null;
  private Handler mMsgHandler;
  private HandlerThread mMsgHandlerThread;
  private Map<Integer, ITPOfflineDownloadListener> mOfflineDownloadListenerMap = new HashMap();
  private Map<Integer, ITPPlayListener> mPlayListenerMap = new HashMap();
  private Map<Integer, ITPPreLoadListener> mPreLoadListenerMap = new HashMap();
  private Runnable updatePlayerInfo = new TPListenerManager.1(this);
  
  private void dispatchCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    Object localObject = getPlaylistener(paramInt2);
    if (localObject != null) {
      dispatchPlayMessage((ITPPlayListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
    }
    do
    {
      return;
      localObject = getPreLoadListener(paramInt2);
      if (localObject != null)
      {
        dispatchPreLoadMessage((ITPPreLoadListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
        return;
      }
      localObject = getOfflineDownloadListener(paramInt2);
      if (localObject != null)
      {
        dispatchOfflineDownloadMessage((ITPOfflineDownloadListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
        return;
      }
    } while (this.mITPDownloadListener == null);
    switch (paramInt1)
    {
    default: 
      return;
    case 30001: 
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      this.mITPDownloadListener.onDownloadInfoReportUpdate(paramObject1);
      return;
    }
    paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
    this.mITPDownloadListener.onQuicQualityReportUpdate(paramObject1);
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
      paramITPOfflineDownloadListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L), TPDLProxyUtils.byteArrayToString((byte[])paramObject5));
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
      paramITPPlayListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L), TPDLProxyUtils.byteArrayToString((byte[])paramObject5));
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
    case 2003: 
      paramITPPlayListener.onPlayCallback(2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), Integer.valueOf(TPDLProxyUtils.objectToInt(paramObject3, 0)), null);
      return;
    case 2004: 
      paramInt1 = TPDLProxyUtils.objectToInt(paramObject2, 0);
      TVKThreadUtil.getScheduledExecutorServiceInstance().execute(new TPListenerManager.3(this, paramInt1));
      return;
    case 2006: 
      paramITPPlayListener.onPlayCallback(3, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), null, null, null);
      return;
    case 2007: 
      paramITPPlayListener.onPlayCallback(4, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), null, null, null);
      return;
    }
    paramITPPlayListener.onQuicDownloadStatusUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
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
      paramITPPreLoadListener.onPrepareDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L), TPDLProxyUtils.byteArrayToString((byte[])paramObject5));
      return;
    case 50: 
      paramITPPreLoadListener.onPrepareOK();
      return;
    }
    paramITPPreLoadListener.onPrepareError(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue(), TPDLProxyUtils.byteArrayToString((byte[])paramObject3));
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
  
  public void handleCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    try
    {
      this.mMsgHandler.post(new TPListenerManager.2(this, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5));
      return;
    }
    finally
    {
      paramObject1 = finally;
      throw paramObject1;
    }
  }
  
  public int handleIntCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    int j = 0;
    paramObject4 = getPlaylistener(paramInt2);
    int i = j;
    if (paramObject4 != null)
    {
      if (paramInt1 != 200) {
        break label63;
      }
      i = paramObject4.onStartReadData(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.objectToLong(paramObject2, 0L), TPDLProxyUtils.objectToLong(paramObject3, -1L));
    }
    label63:
    do
    {
      return i;
      if (paramInt1 == 202) {
        return paramObject4.onStopReadData(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.objectToInt(paramObject2, 0));
      }
      i = j;
    } while (paramInt1 != 201);
    return paramObject4.onReadData(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.objectToLong(paramObject2, 0L), TPDLProxyUtils.objectToInt(paramObject3, 0));
  }
  
  public String handleStringCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    paramObject3 = "";
    paramObject4 = getPlaylistener(paramInt2);
    paramObject2 = paramObject3;
    if (paramObject4 != null)
    {
      if (paramInt1 != 205) {
        break label51;
      }
      paramObject2 = paramObject4.getContentType(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
    }
    label51:
    do
    {
      return paramObject2;
      if (paramInt1 == 203) {
        return String.valueOf(paramObject4.getDataTotalSize(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1)));
      }
      paramObject2 = paramObject3;
    } while (paramInt1 != 204);
    return paramObject4.getDataFilePath(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
  }
  
  public void initHandler()
  {
    if (this.mMsgHandlerThread == null)
    {
      this.mMsgHandlerThread = new HandlerThread("TVKDL-Listener");
      this.mMsgHandlerThread.start();
      this.mMsgHandler = new Handler(this.mMsgHandlerThread.getLooper());
      this.mMsgHandler.postDelayed(this.updatePlayerInfo, 1000L);
    }
  }
  
  public void removeAllPlayListener()
  {
    synchronized (PLAY_LISTENER_MAP_MUTEX)
    {
      this.mPlayListenerMap.clear();
      return;
    }
  }
  
  public void removeAllPreLoadListener()
  {
    synchronized (PRELOAD_LISTENER_MAP_MUTEX)
    {
      this.mPreLoadListenerMap.clear();
      return;
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
  
  public void setDownloadListener(ITPDownloadListener paramITPDownloadListener)
  {
    this.mITPDownloadListener = paramITPDownloadListener;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager
 * JD-Core Version:    0.7.0.1
 */