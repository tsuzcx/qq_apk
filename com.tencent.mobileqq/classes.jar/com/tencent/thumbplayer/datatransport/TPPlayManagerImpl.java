package com.tencent.thumbplayer.datatransport;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.thumbplayer.adapter.player.TPUrlDataSource;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.composition.TPMediaComposition;
import com.tencent.thumbplayer.composition.TPMediaCompositionTrackClip;
import com.tencent.thumbplayer.composition.TPMediaDRMAsset;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.utils.TPCommonUtils;
import com.tencent.thumbplayer.utils.TPFutureResult;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication.OnGlobalEventChangeListener;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor.OnNetStatusChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Ljava.lang.String;>;
import java.util.Set;
import org.json.JSONObject;

public class TPPlayManagerImpl
  implements ITPPlayManager, TPGlobalEventNofication.OnGlobalEventChangeListener, TPNetworkChangeMonitor.OnNetStatusChangeListener
{
  private static final int API_CALL_TIME_OUT_MS = 500;
  private static final int LOD_P2P_TIMES = 3;
  private static final int MSG_DOWN_LOAD_CDN_INFO_UPDATE = 4100;
  private static final int MSG_DOWN_LOAD_CDN_URL_EXPERIED = 4103;
  private static final int MSG_DOWN_LOAD_CDN_URL_UPDATE = 4099;
  private static final int MSG_DOWN_LOAD_ERROR = 4098;
  private static final int MSG_DOWN_LOAD_FINISH = 4097;
  private static final int MSG_DOWN_LOAD_LONG_GET_PLAY_INFO = 4105;
  private static final int MSG_DOWN_LOAD_PLAY_BACK = 4104;
  private static final int MSG_DOWN_LOAD_PROGRESS_UPDARE = 4106;
  private static final int MSG_DOWN_LOAD_PROTOCOL_UPDATE = 4102;
  private static final int MSG_DOWN_LOAD_STATUS_UPDATE = 4101;
  private static final int MSG_DOWN_LOAD_STRING_GET_PLAY_INFO = 4107;
  private static final int MSG_INDEX = 4096;
  private static final int MSG_PROXY_CANCEL_READ_DATA = 4109;
  private static final int MSG_PROXY_GET_CONTENT_TYPE = 4112;
  private static final int MSG_PROXY_GET_DATA_FILE_PATH = 4111;
  private static final int MSG_PROXY_GET_DATA_TOTAL_SIZE = 4110;
  private static final int MSG_PROXY_START_READ_DATA = 4108;
  private static final String TAG = "TPThumbPlayer[TPPlayManagerImpl.java]";
  private static int TYPE_NOT_INIT = -1;
  private boolean loadProxySucc = false;
  private Context mContext;
  private ArrayList<TPDownloadParamData> mDownloadPramList;
  private ITPDownloadProxy mDownloadProxy;
  private String mFileID;
  private TPPlayManagerImpl.EventHandler mHandler;
  private TPPlayManagerImpl.InnerProxyListener mInnerProxyListener;
  private boolean mIsActive = true;
  private boolean mIsDemuxer = false;
  private boolean mIsUseResourceLoader = false;
  private String mOriginUrl;
  private LinkedList<TPPlayManagerImpl.TPDefTaskModel> mPendingDefTaskQueue;
  private int mPlayID = -1;
  private ITPPlayListener mPlayListener;
  private ITPPlayerProxyListener mPlayerProxyListener = null;
  private int mServiceType = TYPE_NOT_INIT;
  private long mSkipEndTimeMs;
  private long mStartTimeMs;
  private HashMap<String, Integer> mTrackProxyUrlPlayIdMap;
  private TPVideoInfo mVideoInfo;
  private int tryLoadP2pTimes = 3;
  
  public TPPlayManagerImpl(Context paramContext, Looper paramLooper)
  {
    this.mContext = paramContext;
    this.mHandler = new TPPlayManagerImpl.EventHandler(this, paramLooper);
    TPGlobalEventNofication.addEventListener(this);
    TPNetworkChangeMonitor.getInstance().addOnNetStatusChangeListener(this);
    this.mInnerProxyListener = new TPPlayManagerImpl.InnerProxyListener(this, null);
    this.mPlayListener = new TPPlayProxyListenerEmptyImpl("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.mTrackProxyUrlPlayIdMap = new HashMap();
    this.mDownloadPramList = new ArrayList();
  }
  
  private boolean addAudioTrack(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    paramString1 = new HashMap();
    paramString1.put("dl_param_data_transfer_mode", Integer.valueOf(1));
    paramString1 = new TPDownloadParam(localArrayList, 3, paramString1);
    return this.mDownloadProxy.setClipInfo(this.mPlayID, 2, paramString2, paramString1);
  }
  
  private TPDownloadParam convertDownloadParam(String paramString, TPDownloadParamData paramTPDownloadParamData, Map<String, String> paramMap)
  {
    return TPProxyUtils.convertProxyDownloadParams(paramString, paramTPDownloadParamData, paramMap);
  }
  
  private List<ITPMediaTrackClip> getAssetClips(ITPMediaAsset paramITPMediaAsset)
  {
    if ((paramITPMediaAsset instanceof TPMediaComposition))
    {
      paramITPMediaAsset = ((TPMediaComposition)paramITPMediaAsset).getAllAVTracks();
      if (!TPCommonUtils.isEmpty(paramITPMediaAsset))
      {
        paramITPMediaAsset = (ITPMediaTrack)paramITPMediaAsset.get(0);
        if ((paramITPMediaAsset != null) && (!TPCommonUtils.isEmpty(paramITPMediaAsset.getAllTrackClips()))) {
          return paramITPMediaAsset.getAllTrackClips();
        }
      }
    }
    else if ((paramITPMediaAsset instanceof ITPMediaTrack))
    {
      paramITPMediaAsset = (ITPMediaTrack)paramITPMediaAsset;
      if (!TPCommonUtils.isEmpty(paramITPMediaAsset.getAllTrackClips())) {
        return paramITPMediaAsset.getAllTrackClips();
      }
    }
    else if ((paramITPMediaAsset instanceof ITPMediaTrackClip))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add((ITPMediaTrackClip)paramITPMediaAsset);
      return localArrayList;
    }
    return null;
  }
  
  private TPDownloadParamData getDownloadParamDataWithIndex(ArrayList<TPDownloadParamData> paramArrayList, int paramInt)
  {
    if ((!TPCommonUtils.isEmpty(paramArrayList)) && (paramInt < paramArrayList.size())) {
      return (TPDownloadParamData)paramArrayList.get(paramInt);
    }
    return null;
  }
  
  private String getFileId()
  {
    return this.mFileID;
  }
  
  private Object getFutureResult(TPFutureResult paramTPFutureResult)
  {
    try
    {
      paramTPFutureResult = paramTPFutureResult.getResult(500L);
      return paramTPFutureResult;
    }
    catch (Throwable paramTPFutureResult)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlayCallback getResult has exception:");
      localStringBuilder.append(paramTPFutureResult.toString());
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localStringBuilder.toString());
    }
    return null;
  }
  
  private String getHttpValue(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.indexOf(':');
      if (i >= 0)
      {
        i += 1;
        if (i < paramString.length())
        {
          paramString = paramString.substring(i);
          if (paramString != null) {
            return paramString.trim();
          }
        }
      }
    }
    return null;
  }
  
  private void initProxy()
  {
    if (this.loadProxySucc) {
      return;
    }
    if (this.tryLoadP2pTimes > 0) {
      try
      {
        if (this.mServiceType == TYPE_NOT_INIT) {
          this.mServiceType = TPPlayerConfig.getProxyServiceType();
        }
        ITPProxyManagerAdapter localITPProxyManagerAdapter = TPProxyGlobalManager.getInstance().getPlayerProxy(this.mServiceType);
        if ((localITPProxyManagerAdapter != null) && (localITPProxyManagerAdapter.getDownloadProxy() != null))
        {
          this.mDownloadProxy = localITPProxyManagerAdapter.getDownloadProxy();
          this.mDownloadProxy.setUserData("qq_is_vip", Boolean.valueOf(TPPlayerConfig.isUserIsVip()));
          if (!TextUtils.isEmpty(TPPlayerConfig.getUserUin())) {
            this.mDownloadProxy.setUserData("user_uin", TPPlayerConfig.getUserUin());
          }
          if (!TextUtils.isEmpty(TPPlayerConfig.getAppVersionName(this.mContext))) {
            this.mDownloadProxy.setUserData("app_version_name", TPPlayerConfig.getAppVersionName(this.mContext));
          }
          if (TPPlayerConfig.getBuildNumber(this.mContext) != -1L) {
            this.mDownloadProxy.setUserData("app_version_code", String.valueOf(TPPlayerConfig.getBuildNumber(this.mContext)));
          }
          this.mDownloadProxy.setUserData("carrier_pesudo_code", TPPlayerConfig.getUserUpc());
          this.mDownloadProxy.setUserData("carrier_pesudo_state", Integer.valueOf(TPPlayerConfig.getUserUpcState()));
          this.mDownloadProxy.setUserData("external_network_ip", TPPlayerConfig.getOutNetIp());
          this.loadProxySucc = true;
          return;
        }
        this.tryLoadP2pTimes -= 1;
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p so load failed");
        return;
      }
      catch (Exception localException)
      {
        this.tryLoadP2pTimes -= 1;
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException);
      }
    }
  }
  
  private void internalMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (this.mHandler == null)
    {
      paramObject = new StringBuilder();
      paramObject.append(messageToCommand(paramInt1));
      paramObject.append(" , send failed , handler null");
      TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", paramObject.toString());
      return;
    }
    if ((paramBoolean1) && (paramObject == null))
    {
      paramObject = new StringBuilder();
      paramObject.append(messageToCommand(paramInt1));
      paramObject.append(", send failed , params null");
      TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", paramObject.toString());
      return;
    }
    if (paramBoolean2) {
      this.mHandler.removeMessages(paramInt1);
    }
    Message localMessage = this.mHandler.obtainMessage();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    this.mHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void internalMessage(int paramInt, Object paramObject)
  {
    internalMessage(paramInt, 0, 0, paramObject, false, false, 0L);
  }
  
  private boolean isInitDownloadProxyFailed()
  {
    return isInitDownloadProxyFailed(false);
  }
  
  private boolean isInitDownloadProxyFailed(boolean paramBoolean)
  {
    if (!TPPlayerConfig.isUseP2P())
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "config set don't use p2p proxy!");
      return true;
    }
    if (paramBoolean) {
      this.tryLoadP2pTimes = 3;
    }
    initProxy();
    return this.loadProxySucc ^ true;
  }
  
  private boolean isQQVideoExpired(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.has("httpHeader")) {
        break label122;
      }
      paramString = paramString.getString("httpHeader");
      localObject = null;
      if (TextUtils.isEmpty(paramString)) {
        break label122;
      }
      arrayOfString = paramString.split("\r\n");
      if (arrayOfString == null) {
        break label122;
      }
      i = 1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        String[] arrayOfString;
        int i;
        boolean bool;
        continue;
        i += 1;
      }
    }
    paramString = localObject;
    if (i < arrayOfString.length)
    {
      paramString = arrayOfString[i];
      if (!paramString.startsWith("User-ReturnCode")) {
        break label128;
      }
      paramString = getHttpValue(paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.equals("-5103059"))
      {
        bool = paramString.equals("-5103017");
        if (!bool) {}
      }
      else
      {
        return true;
      }
    }
    label122:
    return false;
  }
  
  private String messageToCommand(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 4106: 
      return "onDownloadProgressUpdate";
    case 4105: 
    case 4107: 
      return "getPlayInfo";
    case 4104: 
      return "onPlayCallback";
    case 4103: 
      return "onDownloadCdnUrlExpired";
    case 4102: 
      return "onDownloadProtocolUpdate";
    case 4101: 
      return "onDownloadStatusUpdate";
    case 4100: 
      return "onDownloadCdnUrlInfoUpdate";
    case 4099: 
      return "onDownloadCdnUrlUpdate";
    case 4098: 
      return "onDownloadError";
    }
    return "onDownloadFinish";
  }
  
  private void pauseDownload(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.pauseDownload(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("p2p proxy pause download failed, taskId:");
      localStringBuilder.append(paramInt);
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, localStringBuilder.toString());
    }
  }
  
  private void releaseHandler()
  {
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "inner event : release handler");
    try
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException);
    }
  }
  
  private void reset()
  {
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "reset");
    this.mFileID = "";
    this.mOriginUrl = "";
    this.mVideoInfo = null;
    this.mStartTimeMs = 0L;
    this.mSkipEndTimeMs = 0L;
    this.mIsDemuxer = false;
    if (!TPCommonUtils.isEmpty(this.mDownloadPramList)) {
      this.mDownloadPramList.clear();
    }
  }
  
  private void resumeDownload(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.resumeDownload(this.mPlayID);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("p2p proxy resume download failed, taskId:");
      localStringBuilder.append(paramInt);
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, localStringBuilder.toString());
    }
  }
  
  private void setPlayUserData()
  {
    this.mDownloadProxy.setUserData("dl_param_play_start_time", Long.valueOf(this.mStartTimeMs));
    this.mDownloadProxy.setUserData("dl_param_play_end_time", Long.valueOf(this.mSkipEndTimeMs));
  }
  
  private int startClipPlay(List<ITPMediaTrackClip> paramList, String paramString, ArrayList<TPDownloadParamData> paramArrayList)
  {
    if (TPCommonUtils.isEmpty(paramList))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "clipList is empty, return");
      return -1;
    }
    int m = paramList.size();
    Object localObject1 = new HashMap();
    int i = 0;
    Object localObject2;
    int k;
    for (int j = 1; i < m; j = k)
    {
      localObject2 = (ITPMediaTrackClip)paramList.get(i);
      k = j;
      if ((localObject2 instanceof TPMediaCompositionTrackClip))
      {
        k = j;
        if (TPCommonUtils.isUrl(((TPMediaCompositionTrackClip)localObject2).getFilePath()))
        {
          ((HashMap)localObject1).put(localObject2, new TPPlayManagerImpl.TPDownloadSeqAndClipIndexMapping(j, i));
          k = j + 1;
        }
      }
      i += 1;
    }
    if (TPCommonUtils.isEmpty((Map)localObject1))
    {
      TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "all urls is local file url, return");
      return -1;
    }
    i = this.mDownloadProxy.startClipPlay(paramString, ((HashMap)localObject1).size(), this.mInnerProxyListener);
    if (i > 0)
    {
      paramList = ((HashMap)localObject1).entrySet().iterator();
      while (paramList.hasNext())
      {
        paramString = (Map.Entry)paramList.next();
        localObject1 = (ITPMediaTrackClip)paramString.getKey();
        paramString = (TPPlayManagerImpl.TPDownloadSeqAndClipIndexMapping)paramString.getValue();
        if ((localObject1 instanceof TPMediaCompositionTrackClip))
        {
          localObject1 = (TPMediaCompositionTrackClip)localObject1;
          localObject2 = getDownloadParamDataWithIndex(paramArrayList, paramString.clipIndex);
          if (localObject2 == null)
          {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "fatal err, paramData is null.");
            return -1;
          }
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("multi trackClipIndex:");
          ((StringBuilder)localObject3).append(paramString.clipIndex);
          ((StringBuilder)localObject3).append(", download seq:");
          ((StringBuilder)localObject3).append(paramString.downloadSeq);
          ((StringBuilder)localObject3).append(", clip.url:");
          ((StringBuilder)localObject3).append(((TPMediaCompositionTrackClip)localObject1).getUrl());
          ((StringBuilder)localObject3).append(", clip.getFilePath:");
          ((StringBuilder)localObject3).append(((TPMediaCompositionTrackClip)localObject1).getFilePath());
          ((StringBuilder)localObject3).append(", paramData.savePath:");
          ((StringBuilder)localObject3).append(((TPDownloadParamData)localObject2).getSavePath());
          ((StringBuilder)localObject3).append(", paramData.DownloadFileID:");
          ((StringBuilder)localObject3).append(((TPDownloadParamData)localObject2).getDownloadFileID());
          TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", ((StringBuilder)localObject3).toString());
          localObject3 = ((TPDownloadParamData)localObject2).getDownloadFileID();
          localObject2 = convertDownloadParam(((TPMediaCompositionTrackClip)localObject1).getFilePath(), (TPDownloadParamData)localObject2, null);
          if (this.mDownloadProxy.setClipInfo(i, paramString.downloadSeq, (String)localObject3, (TPDownloadParam)localObject2)) {
            ((TPMediaCompositionTrackClip)localObject1).setFilePath(this.mDownloadProxy.getClipPlayUrl(i, paramString.downloadSeq, 1));
          }
        }
      }
    }
    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start clip play failed, cause : playId < 0");
    return i;
  }
  
  private TPUrlDataSource startSwitchDefTask(long paramLong, String paramString, TPDownloadParamData paramTPDownloadParamData, Map<String, String> paramMap)
  {
    TPUrlDataSource localTPUrlDataSource = new TPUrlDataSource(paramString);
    if (!TPCommonUtils.isUrl(paramString)) {
      return localTPUrlDataSource;
    }
    if (isInitDownloadProxyFailed()) {
      return localTPUrlDataSource;
    }
    if (this.mPendingDefTaskQueue == null) {
      this.mPendingDefTaskQueue = new LinkedList();
    }
    String str = null;
    if (paramTPDownloadParamData != null) {
      paramMap = convertDownloadParam(paramString, paramTPDownloadParamData, paramMap);
    } else {
      paramMap = null;
    }
    if (paramTPDownloadParamData != null) {}
    try
    {
      str = paramTPDownloadParamData.getDownloadFileID();
      i = this.mDownloadProxy.startPlay(str, paramMap, this.mInnerProxyListener);
      if (i <= 0) {
        break label248;
      }
      paramMap = this.mDownloadProxy.getPlayUrl(i, 1);
      paramTPDownloadParamData = paramMap;
      if (TextUtils.isEmpty(paramMap)) {
        paramTPDownloadParamData = paramString;
      }
      localTPUrlDataSource.setSelfPlayerUrl(paramTPDownloadParamData);
      paramTPDownloadParamData = this.mDownloadProxy.getPlayUrl(this.mPlayID, 0);
      if (!TextUtils.isEmpty(paramTPDownloadParamData)) {
        break label275;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        int i;
        continue;
        paramString = paramTPDownloadParamData;
      }
    }
    localTPUrlDataSource.setSystemPlayerUrl(paramString);
    this.mPendingDefTaskQueue.offer(new TPPlayManagerImpl.TPDefTaskModel(paramLong, i));
    paramString = new StringBuilder();
    paramString.append("p2p proxy switch def sucess, defId:");
    paramString.append(paramLong);
    paramString.append(",playId:");
    paramString.append(i);
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", paramString.toString());
    return localTPUrlDataSource;
    label248:
    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def failed, cause : playId < 0");
    return localTPUrlDataSource;
    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy switch def failed");
    return localTPUrlDataSource;
  }
  
  private void stopDownload(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.stopPlay(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("p2p proxy stop play failed, taskID:");
      localStringBuilder.append(paramInt);
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, localStringBuilder.toString());
    }
  }
  
  private void updateVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    this.mVideoInfo = paramTPVideoInfo;
    if ((paramTPVideoInfo != null) && (paramTPVideoInfo.getDownloadPraramList() != null))
    {
      if (this.mPlayID <= 0)
      {
        TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy not start, return");
        return;
      }
      paramTPVideoInfo = paramTPVideoInfo.getDownloadPraramList();
      int i = 0;
      while (i < paramTPVideoInfo.size())
      {
        TPDownloadParamData localTPDownloadParamData = (TPDownloadParamData)paramTPVideoInfo.get(i);
        Object localObject = convertDownloadParam(localTPDownloadParamData.getUrl(), localTPDownloadParamData, null);
        if (!this.mDownloadProxy.setClipInfo(this.mPlayID, localTPDownloadParamData.getClipNo(), localTPDownloadParamData.getDownloadFileID(), (TPDownloadParam)localObject))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setClipInfo failed, playID:");
          ((StringBuilder)localObject).append(this.mPlayID);
          ((StringBuilder)localObject).append(", clipNo:");
          ((StringBuilder)localObject).append(localTPDownloadParamData.getClipNo());
          ((StringBuilder)localObject).append(", downloadFileID:");
          ((StringBuilder)localObject).append(localTPDownloadParamData.getDownloadFileID());
          TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", ((StringBuilder)localObject).toString());
        }
        i += 1;
      }
      return;
    }
    TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "video or downloadParamList is null, return");
  }
  
  public String getPlayErrorCodeStr()
  {
    if (isInitDownloadProxyFailed()) {
      return null;
    }
    try
    {
      String str = this.mDownloadProxy.getPlayErrorCodeStr(this.mPlayID);
      return str;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
    }
    return null;
  }
  
  public ITPPlayerProxyListener getTPPlayerProxyListener()
  {
    return this.mPlayerProxyListener;
  }
  
  public boolean hasWaitDefTask()
  {
    boolean bool1 = isInitDownloadProxyFailed();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    LinkedList localLinkedList = this.mPendingDefTaskQueue;
    bool1 = bool2;
    if (localLinkedList != null)
    {
      bool1 = bool2;
      if (localLinkedList.size() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isEnable()
  {
    return isInitDownloadProxyFailed() ^ true;
  }
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEvent eventId: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", arg1: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", arg2: ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", object");
    localStringBuilder.append(paramObject);
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", localStringBuilder.toString());
    switch (paramInt1)
    {
    default: 
      return;
    case 100002: 
      pushEventByInner(14);
      return;
    }
    pushEventByInner(13);
  }
  
  public void onStatusChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNetworkStatusChanged oldNetStatus: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", netStatus: ");
    localStringBuilder.append(paramInt2);
    TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", localStringBuilder.toString());
    if (paramInt2 == 1)
    {
      pushEventByInner(1);
      pushEventByInner(10);
      return;
    }
    if (paramInt2 == 2)
    {
      pushEventByInner(2);
      pushEventByInner(9);
      return;
    }
    if (paramInt2 == 3)
    {
      pushEventByInner(2);
      pushEventByInner(10);
    }
  }
  
  public void pauseDownload()
  {
    pauseDownload(this.mPlayID);
    Iterator localIterator;
    if (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))
    {
      localIterator = this.mPendingDefTaskQueue.iterator();
      while (localIterator.hasNext())
      {
        TPPlayManagerImpl.TPDefTaskModel localTPDefTaskModel = (TPPlayManagerImpl.TPDefTaskModel)localIterator.next();
        if (localTPDefTaskModel != null) {
          pauseDownload(localTPDefTaskModel.proxyTaskID);
        }
      }
    }
    if (!TPCommonUtils.isEmpty(this.mTrackProxyUrlPlayIdMap))
    {
      localIterator = this.mTrackProxyUrlPlayIdMap.values().iterator();
      while (localIterator.hasNext()) {
        pauseDownload(((Integer)localIterator.next()).intValue());
      }
    }
  }
  
  public void playerSwitchDefComplete(long paramLong)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      if (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))
      {
        StringBuilder localStringBuilder;
        for (TPPlayManagerImpl.TPDefTaskModel localTPDefTaskModel = (TPPlayManagerImpl.TPDefTaskModel)this.mPendingDefTaskQueue.peek(); (localTPDefTaskModel != null) && (localTPDefTaskModel.definitionID != paramLong); localTPDefTaskModel = (TPPlayManagerImpl.TPDefTaskModel)this.mPendingDefTaskQueue.peek())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("stop proxy definitionID:");
          localStringBuilder.append(localTPDefTaskModel.definitionID);
          localStringBuilder.append(", taskID:");
          localStringBuilder.append(localTPDefTaskModel.proxyTaskID);
          TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", localStringBuilder.toString());
          stopDownload(localTPDefTaskModel.proxyTaskID);
          this.mPendingDefTaskQueue.removeFirst();
        }
        if (localTPDefTaskModel != null)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("stop proxy task id:");
          localStringBuilder.append(localTPDefTaskModel.proxyTaskID);
          TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", localStringBuilder.toString());
          stopDownload(this.mPlayID);
          this.mPlayID = localTPDefTaskModel.proxyTaskID;
          this.mPendingDefTaskQueue.remove(localTPDefTaskModel);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localException, "playerSwitchDefComplete exception");
    }
  }
  
  public void pushEvent(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      paramInt = TPProxyEnumUtils.eventID2Inner(paramInt);
      pushEventByInner(paramInt);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localIllegalArgumentException);
    }
  }
  
  public void pushEventByInner(int paramInt)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.pushEvent(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("p2p proxy pushEvent failed, event:");
      localStringBuilder.append(paramInt);
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable, localStringBuilder.toString());
    }
  }
  
  public void release()
  {
    stopDownload();
    TPNetworkChangeMonitor.getInstance().removeOnNetStatusChangeListener(this);
    TPGlobalEventNofication.removeEventListener(this);
    releaseHandler();
    this.mPlayerProxyListener = null;
    this.mPlayListener = new TPPlayProxyListenerEmptyImpl("TPThumbPlayer[TPPlayManagerImpl.java]");
    this.mInnerProxyListener = null;
    this.mDownloadProxy = null;
  }
  
  public void resumeDownload()
  {
    resumeDownload(this.mPlayID);
    Iterator localIterator;
    if (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))
    {
      localIterator = this.mPendingDefTaskQueue.iterator();
      while (localIterator.hasNext())
      {
        TPPlayManagerImpl.TPDefTaskModel localTPDefTaskModel = (TPPlayManagerImpl.TPDefTaskModel)localIterator.next();
        if (localTPDefTaskModel != null) {
          resumeDownload(localTPDefTaskModel.proxyTaskID);
        }
      }
    }
    if (!TPCommonUtils.isEmpty(this.mTrackProxyUrlPlayIdMap))
    {
      localIterator = this.mTrackProxyUrlPlayIdMap.values().iterator();
      while (localIterator.hasNext()) {
        resumeDownload(((Integer)localIterator.next()).intValue());
      }
    }
  }
  
  public void setBusinessDownloadStrategy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.setBusinessDownloadStrategy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
    }
  }
  
  public void setIsActive(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mPlayId=");
    ((StringBuilder)localObject).append(this.mPlayID);
    ((StringBuilder)localObject).append(", setIsActive: ");
    ((StringBuilder)localObject).append(paramBoolean);
    TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", ((StringBuilder)localObject).toString());
    this.mIsActive = paramBoolean;
    int j;
    if (!isInitDownloadProxyFailed())
    {
      j = this.mPlayID;
      if (j < 0) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject = this.mDownloadProxy;
        if (!paramBoolean) {
          break label112;
        }
        i = 101;
        ((ITPDownloadProxy)localObject).setPlayState(j, i);
        return;
      }
      catch (Throwable localThrowable)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
      }
      return;
      label112:
      int i = 100;
    }
  }
  
  public void setIsUseResourceLoader(boolean paramBoolean)
  {
    this.mIsUseResourceLoader = paramBoolean;
  }
  
  public void setLogListener(ITPDLProxyLogListener paramITPDLProxyLogListener) {}
  
  public void setPlayListener(ITPPlayListener paramITPPlayListener)
  {
    if (paramITPPlayListener == null)
    {
      this.mPlayListener = new TPPlayProxyListenerEmptyImpl("TPThumbPlayer[TPPlayManagerImpl.java]");
      return;
    }
    this.mPlayListener = paramITPPlayListener;
  }
  
  public void setPlayerOptionalParam(TPOptionalParam paramTPOptionalParam)
  {
    if (isInitDownloadProxyFailed()) {
      return;
    }
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 100))
    {
      this.mStartTimeMs = paramTPOptionalParam.getParamLong().value;
      return;
    }
    if ((paramTPOptionalParam != null) && (paramTPOptionalParam.getKey() == 500))
    {
      this.mSkipEndTimeMs = paramTPOptionalParam.getParamLong().value;
      if (this.mPlayID > 0) {
        this.mDownloadProxy.setUserData("dl_param_play_end_time", Long.valueOf(this.mSkipEndTimeMs));
      }
    }
  }
  
  public void setProxyPlayState(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setProxyPlayState: ");
    ((StringBuilder)localObject).append(paramInt);
    TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", ((StringBuilder)localObject).toString());
    if (isInitDownloadProxyFailed()) {
      return;
    }
    try
    {
      this.mDownloadProxy.setPlayState(this.mPlayID, paramInt);
      if (((paramInt == 5) || (paramInt == 0)) && (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue)))
      {
        localObject = this.mPendingDefTaskQueue.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TPPlayManagerImpl.TPDefTaskModel localTPDefTaskModel = (TPPlayManagerImpl.TPDefTaskModel)((Iterator)localObject).next();
          if (localTPDefTaskModel != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("setProxyPlayState definitionID:");
            localStringBuilder.append(localTPDefTaskModel.definitionID);
            localStringBuilder.append(", taskID:");
            localStringBuilder.append(localTPDefTaskModel.proxyTaskID);
            localStringBuilder.append(", state:");
            localStringBuilder.append(paramInt);
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", localStringBuilder.toString());
            this.mDownloadProxy.setPlayState(localTPDefTaskModel.proxyTaskID, paramInt);
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localThrowable);
    }
  }
  
  public void setProxyServiceType(int paramInt)
  {
    this.mServiceType = paramInt;
  }
  
  public void setTPPlayerProxyListener(ITPPlayerProxyListener paramITPPlayerProxyListener)
  {
    this.mPlayerProxyListener = paramITPPlayerProxyListener;
  }
  
  public void setVideoInfo(TPVideoInfo paramTPVideoInfo)
  {
    if (paramTPVideoInfo == null)
    {
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, param is null ");
      return;
    }
    if (this.mVideoInfo != null) {
      updateVideoInfo(paramTPVideoInfo);
    }
    this.mVideoInfo = paramTPVideoInfo;
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, enter");
    this.mFileID = paramTPVideoInfo.getProxyFileID();
    if (!TPCommonUtils.isEmpty(this.mDownloadPramList)) {
      this.mDownloadPramList.clear();
    }
    if ((paramTPVideoInfo.getDownloadPraramList() != null) && (paramTPVideoInfo.getDownloadPraramList().size() > 0)) {
      this.mDownloadPramList.addAll(paramTPVideoInfo.getDownloadPraramList());
    }
  }
  
  public void startDemuxer(String paramString1, String paramString2)
  {
    if ((TPCommonUtils.isUrl(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!this.mIsDemuxer)
      {
        if (!addAudioTrack(paramString1, paramString2)) {
          throw new Exception("setClipInfo err.");
        }
      }
      else
      {
        stopDownload(this.mPlayID);
        startDownloadPlay(this.mOriginUrl, null);
        if (!addAudioTrack(paramString1, paramString2)) {
          break label77;
        }
      }
      this.mIsDemuxer = true;
      return;
      label77:
      throw new Exception("setClipInfo err.");
    }
    throw new Exception("illegal argument.");
  }
  
  public String startDownLoadTrackUrl(int paramInt, String paramString, TPDownloadParamData paramTPDownloadParamData)
  {
    if (TextUtils.isEmpty(paramString))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
      return paramString;
    }
    if (!TPCommonUtils.isUrl(paramString))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is locol url, not need use proxy");
      return paramString;
    }
    if (isInitDownloadProxyFailed())
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
      return paramString;
    }
    int j = 1;
    int i = 1;
    String str1;
    if (paramTPDownloadParamData != null) {
      str1 = paramString;
    }
    for (;;)
    {
      try
      {
        TPDownloadParam localTPDownloadParam2 = TPProxyUtils.convertProxyDownloadParams(paramString, paramTPDownloadParamData, null);
        paramInt = i;
        str1 = paramString;
        if (paramTPDownloadParamData.getTaskType() == 1) {
          paramInt = 2;
        }
        str1 = paramString;
        String str2 = paramTPDownloadParamData.getDownloadFileID();
        i = paramInt;
        TPDownloadParam localTPDownloadParam1 = localTPDownloadParam2;
        paramTPDownloadParamData = str2;
        str1 = paramString;
        if (TextUtils.isEmpty(str2))
        {
          str1 = paramString;
          paramTPDownloadParamData = TPCommonUtils.getMd5(paramString);
          i = paramInt;
          localTPDownloadParam1 = localTPDownloadParam2;
          continue;
          str1 = paramString;
          paramTPDownloadParamData = new ArrayList();
          str1 = paramString;
          paramTPDownloadParamData.add(paramString);
          i = 0;
          if (paramInt != 3) {
            break label349;
          }
          i = 10;
          str1 = paramString;
          localTPDownloadParam1 = new TPDownloadParam(paramTPDownloadParamData, i, null);
          str1 = paramString;
          paramTPDownloadParamData = TPCommonUtils.getMd5(paramString);
          i = j;
        }
        str1 = paramString;
        paramInt = this.mDownloadProxy.startPlay(paramTPDownloadParamData, localTPDownloadParam1, this.mInnerProxyListener);
        if (paramInt > 0)
        {
          str1 = paramString;
          paramTPDownloadParamData = new StringBuilder();
          str1 = paramString;
          paramTPDownloadParamData.append("p2p proxy start play, url type");
          str1 = paramString;
          paramTPDownloadParamData.append(i);
          str1 = paramString;
          TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", paramTPDownloadParamData.toString());
          str1 = paramString;
          paramString = this.mDownloadProxy.getPlayUrl(paramInt, i);
          str1 = paramString;
          this.mTrackProxyUrlPlayIdMap.put(paramString, Integer.valueOf(paramInt));
          return paramString;
        }
        str1 = paramString;
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
        return paramString;
      }
      catch (Throwable paramString)
      {
        paramTPDownloadParamData = new StringBuilder();
        paramTPDownloadParamData.append("p2p proxy start play failed:");
        paramTPDownloadParamData.append(paramString);
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramTPDownloadParamData.toString());
        return str1;
      }
      label349:
      if (paramInt == 2) {
        i = 3;
      }
    }
  }
  
  public TPUrlDataSource startDownloadPlay(String paramString, Map<String, String> paramMap)
  {
    TPUrlDataSource localTPUrlDataSource = new TPUrlDataSource(paramString);
    if (!TPCommonUtils.isUrl(paramString)) {
      return localTPUrlDataSource;
    }
    if (isInitDownloadProxyFailed(true)) {
      return localTPUrlDataSource;
    }
    setPlayUserData();
    this.mOriginUrl = paramString;
    Object localObject2 = getDownloadParamDataWithIndex(this.mDownloadPramList, 0);
    Object localObject1 = localObject2;
    if (this.mIsUseResourceLoader)
    {
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((TPDownloadParamData)localObject2).getDlType() == 1) {
          localObject1 = new TPDownloadParamData(11);
        }
      }
    }
    if (localObject1 != null) {
      paramMap = convertDownloadParam(paramString, (TPDownloadParamData)localObject1, paramMap);
    } else {
      paramMap = null;
    }
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("single url:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", paramData.savePath:");
        String str = "null";
        if (localObject1 != null)
        {
          localObject2 = ((TPDownloadParamData)localObject1).getSavePath();
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append(", paramData.DownloadFileID:");
          localObject2 = str;
          if (localObject1 != null) {
            localObject2 = ((TPDownloadParamData)localObject1).getDownloadFileID();
          }
          localStringBuilder.append((String)localObject2);
          TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", localStringBuilder.toString());
          this.mPlayID = this.mDownloadProxy.startPlay(getFileId(), paramMap, this.mInnerProxyListener);
          setIsActive(this.mIsActive);
          if (this.mPlayID > 0)
          {
            localObject1 = this.mDownloadProxy.getPlayUrl(this.mPlayID, 0);
            paramMap = (Map<String, String>)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramMap = paramString;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("startDownloadPlay, playId:");
            ((StringBuilder)localObject1).append(this.mPlayID);
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", ((StringBuilder)localObject1).toString());
            localTPUrlDataSource.setSelfPlayerUrl(paramMap);
            paramMap = this.mDownloadProxy.getPlayUrl(this.mPlayID, 1);
            if (!TextUtils.isEmpty(paramMap)) {
              break label378;
            }
            localTPUrlDataSource.setSystemPlayerUrl(paramString);
            return localTPUrlDataSource;
          }
          TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId < 0");
          return localTPUrlDataSource;
        }
      }
      catch (Throwable paramString)
      {
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", paramString, "p2p proxy start play failed");
        return localTPUrlDataSource;
      }
      localObject2 = "null";
      continue;
      label378:
      paramString = paramMap;
    }
  }
  
  public ITPMediaAsset startDownloadPlayByAsset(ITPMediaAsset paramITPMediaAsset)
  {
    if (isInitDownloadProxyFailed(true)) {
      return paramITPMediaAsset;
    }
    setPlayUserData();
    if ((paramITPMediaAsset instanceof TPMediaDRMAsset))
    {
      localObject = (TPMediaDRMAsset)paramITPMediaAsset;
      ((TPMediaDRMAsset)localObject).setDrmPlayUrl(startDownloadPlay(((TPMediaDRMAsset)localObject).getDrmPlayUrl(), null).getSelfPlayerUrl());
      return paramITPMediaAsset;
    }
    Object localObject = getAssetClips(paramITPMediaAsset);
    if (!TPCommonUtils.isEmpty((Collection)localObject)) {
      this.mPlayID = startClipPlay((List)localObject, getFileId(), this.mDownloadPramList);
    }
    return paramITPMediaAsset;
  }
  
  public TPUrlDataSource startSwitchDefTask(long paramLong, String paramString, TPVideoInfo paramTPVideoInfo, Map<String, String> paramMap)
  {
    if (paramTPVideoInfo == null) {
      return new TPUrlDataSource(paramString);
    }
    TPDownloadParamData localTPDownloadParamData = null;
    if (paramTPVideoInfo.getDownloadPraramList() != null) {
      localTPDownloadParamData = (TPDownloadParamData)paramTPVideoInfo.getDownloadPraramList().get(0);
    }
    return startSwitchDefTask(paramLong, paramString, localTPDownloadParamData, paramMap);
  }
  
  public ITPMediaAsset startSwitchDefTaskByAsset(ITPMediaAsset paramITPMediaAsset, long paramLong, TPVideoInfo paramTPVideoInfo)
  {
    if (!isInitDownloadProxyFailed())
    {
      if (paramITPMediaAsset == null) {
        return paramITPMediaAsset;
      }
      if (this.mPendingDefTaskQueue == null) {
        this.mPendingDefTaskQueue = new LinkedList();
      }
      if (paramTPVideoInfo == null) {
        return paramITPMediaAsset;
      }
      if ((paramITPMediaAsset instanceof ITPMediaDRMAsset))
      {
        localObject = null;
        if (paramTPVideoInfo.getDownloadPraramList() != null) {
          localObject = (TPDownloadParamData)paramTPVideoInfo.getDownloadPraramList().get(0);
        }
        paramTPVideoInfo = startSwitchDefTask(paramLong, ((ITPMediaDRMAsset)paramITPMediaAsset).getDrmPlayUrl(), (TPDownloadParamData)localObject, null);
        ((TPMediaDRMAsset)paramITPMediaAsset).setDrmPlayUrl(paramTPVideoInfo.getSelfPlayerUrl());
        return paramITPMediaAsset;
      }
      Object localObject = getAssetClips(paramITPMediaAsset);
      if ((!TPCommonUtils.isEmpty((Collection)localObject)) && (paramTPVideoInfo != null))
      {
        int i = startClipPlay((List)localObject, paramTPVideoInfo.getProxyFileID(), paramTPVideoInfo.getDownloadPraramList());
        if (i > 0)
        {
          this.mPendingDefTaskQueue.offer(new TPPlayManagerImpl.TPDefTaskModel(paramLong, i));
          paramTPVideoInfo = new StringBuilder();
          paramTPVideoInfo.append("p2p proxy switch def sucess, defId:");
          paramTPVideoInfo.append(paramLong);
          paramTPVideoInfo.append(",playId:");
          paramTPVideoInfo.append(i);
          TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", paramTPVideoInfo.toString());
          return paramITPMediaAsset;
        }
        TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch clip def failed, cause : playId < 0");
      }
    }
    return paramITPMediaAsset;
  }
  
  public void stopDemuxer()
  {
    if (this.mIsDemuxer)
    {
      stopDownload(this.mPlayID);
      startDownloadPlay(this.mOriginUrl, null);
    }
    this.mIsDemuxer = false;
  }
  
  public void stopDownLoadTrackUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz url is empty");
      return;
    }
    if (isInitDownloadProxyFailed())
    {
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "return coz download proxy init failed");
      return;
    }
    StringBuilder localStringBuilder;
    if (!this.mTrackProxyUrlPlayIdMap.containsKey(paramString))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("return, coz mTrackProxyUrlPlayIdMap not contain current proxy url:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", or it is not proxy url");
      TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", localStringBuilder.toString());
      return;
    }
    int i = ((Integer)this.mTrackProxyUrlPlayIdMap.get(paramString)).intValue();
    try
    {
      this.mDownloadProxy.stopPlay(i);
      return;
    }
    catch (Exception paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("p2p proxy stop play failed:");
      localStringBuilder.append(paramString);
      TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", localStringBuilder.toString());
    }
  }
  
  public void stopDownload()
  {
    if (this.mPlayID < 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopDownload failed, coz playId:");
      ((StringBuilder)localObject).append(this.mPlayID);
      ((StringBuilder)localObject).append(", less than zero. maybe download proxy didn't started");
      TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stopDownload, playId:");
    ((StringBuilder)localObject).append(this.mPlayID);
    TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", ((StringBuilder)localObject).toString());
    stopDownload(this.mPlayID);
    if (!TPCommonUtils.isEmpty(this.mPendingDefTaskQueue))
    {
      localObject = this.mPendingDefTaskQueue.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TPPlayManagerImpl.TPDefTaskModel localTPDefTaskModel = (TPPlayManagerImpl.TPDefTaskModel)((Iterator)localObject).next();
        if (localTPDefTaskModel != null) {
          stopDownload(localTPDefTaskModel.proxyTaskID);
        }
      }
      this.mPendingDefTaskQueue.clear();
    }
    if (!TPCommonUtils.isEmpty(this.mTrackProxyUrlPlayIdMap))
    {
      localObject = this.mTrackProxyUrlPlayIdMap.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        stopDownload(((Integer)((Iterator)localObject).next()).intValue());
      }
      this.mTrackProxyUrlPlayIdMap.clear();
    }
    this.mPlayID = -1;
    reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPPlayManagerImpl
 * JD-Core Version:    0.7.0.1
 */