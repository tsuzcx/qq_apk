package com.tencent.thumbplayer.core.downloadproxy.apiinner;

import android.net.Network;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;
import com.tencent.thumbplayer.core.downloadproxy.utils.TVKThreadUtil;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class TPListenerManager
{
  private static final int DEFAULT_UPDATE_PLAYER_INFO_INTERVAL = 1000;
  private static final String FILE_NAME = "TPListenerManager";
  private static final int MSG_CALLBACK_MSG_REPORT = 3000;
  private static final int MSG_CURRENT_CDN_URL = 5;
  private static final int MSG_CURRENT_CDN_URL_INFO = 6;
  private static final int MSG_DOWNLOAD_PROTOCOL = 9;
  private static final int MSG_DOWNLOAD_STATUS = 8;
  private static final int MSG_ERROR = 4;
  private static final int MSG_FINISH = 3;
  private static final int MSG_NOTIFY_FLV_PRELOAD_STATUS = 2009;
  private static final int MSG_NOTIFY_HTTP_HEADER = 2006;
  private static final int MSG_NOTIFY_LOSE_PACKAGE_CEHCK = 2004;
  private static final int MSG_NOTIFY_M3U8_CONTENT = 2007;
  private static final int MSG_NOTIFY_PLAYER_SWITCH_DEFINITION = 2003;
  private static final int MSG_NOTIFY_SOCKET_FD = 2008;
  private static final int MSG_PLAY_VIDEO_NOT_FOUND = 101;
  private static final int MSG_PREPARE_FINISH = 50;
  private static final int MSG_PROGRESS = 2;
  private static final int MSG_PROXY_CANCEL_READ_DATA = 202;
  private static final int MSG_PROXY_GET_CONTENT_TYPE = 205;
  private static final int MSG_PROXY_GET_DATA_FILE_PATH = 204;
  private static final int MSG_PROXY_GET_DATA_TOTAL_SIZE = 203;
  private static final int MSG_PROXY_READ_DATA = 201;
  private static final int MSG_PROXY_START_READ_DATA = 200;
  private static final int MSG_QUIC_DOWNLOAD_STATUS = 3001;
  private static final int MSG_REPORT_QUIC_QUALITY = 3002;
  private static final int MSG_URL_EXPIRED = 7;
  private static final Object OFFLINE_LISTENER_MAP_MUTEX = new Object();
  private static final Object PLAY_LISTENER_MAP_MUTEX = new Object();
  private static final Object PRELOAD_LISTENER_MAP_MUTEX = new Object();
  private static final String THREAD_NAME = "TVKDL-Listener";
  private ITPDownloadListener mITPDownloadListener = null;
  private Handler mMsgHandler;
  private HandlerThread mMsgHandlerThread;
  private Network mNetwork = null;
  private Map<Integer, ITPOfflineDownloadListener> mOfflineDownloadListenerMap = new HashMap();
  private Map<Integer, ITPPlayListener> mPlayListenerMap = new HashMap();
  private Map<Integer, ITPPreLoadListener> mPreLoadListenerMap = new HashMap();
  private Runnable updatePlayerInfo = new TPListenerManager.1(this);
  private int updatePlayerInfoINterval = 1000;
  
  private void dispatchCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    Object localObject = getPlaylistener(paramInt2);
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
    if (localObject != null)
    {
      dispatchOfflineDownloadMessage((ITPOfflineDownloadListener)localObject, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
      return;
    }
    if (this.mITPDownloadListener != null)
    {
      if (paramInt1 != 3000)
      {
        if (paramInt1 != 3002) {
          return;
        }
        paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
        this.mITPDownloadListener.onQuicQualityReportUpdate(paramObject1);
        return;
      }
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      this.mITPDownloadListener.onDownloadInfoReportUpdate(paramObject1);
    }
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
    case 9: 
      paramITPOfflineDownloadListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2));
      return;
    case 8: 
      paramITPOfflineDownloadListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0));
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
    case 6: 
      paramITPOfflineDownloadListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), TPDLProxyUtils.byteArrayToString((byte[])paramObject3), TPDLProxyUtils.byteArrayToString((byte[])paramObject4));
      return;
    case 5: 
      paramITPOfflineDownloadListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
      return;
    case 4: 
      paramITPOfflineDownloadListener.onDownloadError(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue(), TPDLProxyUtils.byteArrayToString((byte[])paramObject3));
      return;
    case 3: 
      paramITPOfflineDownloadListener.onDownloadFinish();
      return;
    }
    paramITPOfflineDownloadListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L), TPDLProxyUtils.byteArrayToString((byte[])paramObject5));
  }
  
  private void dispatchPlayMessage(ITPPlayListener paramITPPlayListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if (paramITPPlayListener == null) {
      return;
    }
    if (paramInt1 != 101)
    {
      if (paramInt1 != 2009)
      {
        if (paramInt1 != 3001)
        {
          if (paramInt1 != 2003)
          {
            if (paramInt1 != 2004)
            {
              if (paramInt1 != 2006) {
                if (paramInt1 != 2007) {
                  switch (paramInt1)
                  {
                  }
                }
              }
              for (;;)
              {
                return;
                paramITPPlayListener.onDownloadProtocolUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2));
                continue;
                paramITPPlayListener.onDownloadStatusUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0));
                continue;
                paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
                l = TPDLProxyUtils.objectToLong(paramObject2, 0L);
                paramObject2 = new HashMap();
                if (!TextUtils.isEmpty(paramObject1))
                {
                  paramObject2.put("exttag", paramObject1);
                  paramObject2.put("randnum", String.valueOf(l));
                }
                paramITPPlayListener.onDownloadCdnUrlExpired(paramObject2);
                continue;
                paramITPPlayListener.onDownloadCdnUrlInfoUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), TPDLProxyUtils.byteArrayToString((byte[])paramObject3), TPDLProxyUtils.byteArrayToString((byte[])paramObject4));
                continue;
                paramITPPlayListener.onDownloadCdnUrlUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
                continue;
                paramITPPlayListener.onDownloadFinish();
                continue;
                paramITPPlayListener.onDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L), TPDLProxyUtils.byteArrayToString((byte[])paramObject5));
                continue;
                paramITPPlayListener.onPlayCallback(4, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), null, null, null);
                continue;
                paramITPPlayListener.onPlayCallback(3, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), null, null, null);
              }
            }
            paramInt1 = TPDLProxyUtils.objectToInt(paramObject2, 0);
            TVKThreadUtil.getScheduledExecutorServiceInstance().execute(new TPListenerManager.3(this, paramInt1));
            return;
          }
          paramITPPlayListener.onPlayCallback(2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.byteArrayToString((byte[])paramObject2), Integer.valueOf(TPDLProxyUtils.objectToInt(paramObject3, 0)), null);
          return;
        }
        paramITPPlayListener.onQuicDownloadStatusUpdate(TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
        return;
      }
      paramInt1 = TPDLProxyUtils.objectToInt(paramObject1, 0);
      if (paramObject2 == null) {
        paramObject1 = null;
      } else {
        paramObject1 = (byte[])paramObject2;
      }
      paramITPPlayListener.onPlayCallback(5, Integer.valueOf(paramInt1), paramObject1, TPDLProxyUtils.byteArrayToString((byte[])paramObject3), Integer.valueOf(TPDLProxyUtils.objectToInt(paramObject4, 0)));
      return;
    }
    paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
    long l = TPDLProxyUtils.objectToLong(paramObject2, 0L);
    paramObject2 = new HashMap();
    if (!TextUtils.isEmpty(paramObject1))
    {
      paramObject2.put("exttag", paramObject1);
      paramObject2.put("randnum", String.valueOf(l));
    }
    paramITPPlayListener.onPlayCallback(1, paramObject2, null, null, null);
  }
  
  private void dispatchPreLoadMessage(ITPPreLoadListener paramITPPreLoadListener, int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    if (paramITPPreLoadListener == null) {
      return;
    }
    if (paramInt1 != 2)
    {
      if (paramInt1 != 4)
      {
        if (paramInt1 != 50) {
          return;
        }
        paramITPPreLoadListener.onPrepareOK();
        return;
      }
      paramITPPreLoadListener.onPrepareError(((Integer)paramObject1).intValue(), ((Integer)paramObject2).intValue(), TPDLProxyUtils.byteArrayToString((byte[])paramObject3));
      return;
    }
    paramITPPreLoadListener.onPrepareDownloadProgressUpdate(TPDLProxyUtils.objectToInt(paramObject1, 0), TPDLProxyUtils.objectToInt(paramObject2, 0), TPDLProxyUtils.objectToLong(paramObject3, 0L), TPDLProxyUtils.objectToLong(paramObject4, 0L), TPDLProxyUtils.byteArrayToString((byte[])paramObject5));
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
    if (2008 == paramInt1) {}
    try
    {
      TPDLProxyLog.i("FILE_NAME", 0, "tpdlnative", "cellular_network sock call back start");
      paramObject1 = TPDLProxyUtils.byteArrayToString((byte[])paramObject1);
      paramInt1 = Integer.parseInt(paramObject1);
      try
      {
        paramObject2 = new FileDescriptor();
        paramObject3 = FileDescriptor.class.getDeclaredField("descriptor");
        paramObject3.setAccessible(true);
        paramObject3.setInt(paramObject2, paramInt1);
        paramObject3 = new StringBuilder();
        paramObject3.append("cellular_network sock call back, bind begin, sock fd: ");
        paramObject3.append(paramInt1);
        TPDLProxyLog.i("FILE_NAME", 0, "tpdlnative", paramObject3.toString());
        if (Build.VERSION.SDK_INT >= 23)
        {
          this.mNetwork.bindSocket(paramObject2);
          paramObject2 = new StringBuilder();
          paramObject2.append("cellular_network sock call back, bind socket success, sock fd: ");
          paramObject2.append(paramInt1);
          TPDLProxyLog.i("FILE_NAME", 0, "tpdlnative", paramObject2.toString());
        }
      }
      catch (Throwable paramObject2)
      {
        paramObject3 = new StringBuilder();
        paramObject3.append("cellular_network sock call back failed: ");
        paramObject3.append(paramObject2.toString());
        TPDLProxyLog.i("FILE_NAME", 0, "tpdlnative", paramObject3.toString());
      }
      paramObject2 = new StringBuilder();
      paramObject2.append("cellular_network sock call back end, sock fd: ");
      paramObject2.append(paramInt1);
      paramObject2.append(", str_sock: ");
      paramObject2.append(paramObject1);
      TPDLProxyLog.i("FILE_NAME", 0, "tpdlnative", paramObject2.toString());
      return;
    }
    finally {}
    this.mMsgHandler.post(new TPListenerManager.2(this, paramInt1, paramInt2, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5));
  }
  
  public int handleIntCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    paramObject4 = getPlaylistener(paramInt2);
    int j = 0;
    int i = j;
    if (paramObject4 != null)
    {
      if (paramInt1 == 200) {
        return paramObject4.onStartReadData(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.objectToLong(paramObject2, 0L), TPDLProxyUtils.objectToLong(paramObject3, -1L));
      }
      if (paramInt1 == 202) {
        return paramObject4.onStopReadData(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.objectToInt(paramObject2, 0));
      }
      i = j;
      if (paramInt1 == 201) {
        i = paramObject4.onReadData(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1), TPDLProxyUtils.objectToLong(paramObject2, 0L), TPDLProxyUtils.objectToInt(paramObject3, 0));
      }
    }
    return i;
  }
  
  public String handleStringCallbackMessage(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    paramObject2 = getPlaylistener(paramInt2);
    if (paramObject2 != null)
    {
      if (paramInt1 == 205) {
        return paramObject2.getContentType(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
      }
      if (paramInt1 == 203) {
        return String.valueOf(paramObject2.getDataTotalSize(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1)));
      }
      if (paramInt1 == 204) {
        return paramObject2.getDataFilePath(paramInt2, TPDLProxyUtils.byteArrayToString((byte[])paramObject1));
      }
    }
    return "";
  }
  
  public void initHandler()
  {
    if (this.mMsgHandlerThread == null)
    {
      this.mMsgHandlerThread = new HandlerThread("TVKDL-Listener");
      this.mMsgHandlerThread.start();
      this.mMsgHandler = new Handler(this.mMsgHandlerThread.getLooper());
      this.mMsgHandler.postDelayed(this.updatePlayerInfo, this.updatePlayerInfoINterval);
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
  
  public void setITPDownloadListener(ITPDownloadListener paramITPDownloadListener)
  {
    this.mITPDownloadListener = paramITPDownloadListener;
  }
  
  public void setNetwork(Network paramNetwork)
  {
    TPDLProxyLog.i("FILE_NAME", 0, "tpdlnative", "cellular_network set network");
    this.mNetwork = paramNetwork;
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
  
  public void setUpdatePlayerInfoInterval(int paramInt)
  {
    this.updatePlayerInfoINterval = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager
 * JD-Core Version:    0.7.0.1
 */