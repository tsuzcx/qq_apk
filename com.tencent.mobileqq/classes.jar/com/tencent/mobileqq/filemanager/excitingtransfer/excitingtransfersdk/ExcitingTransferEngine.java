package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import mqq.os.MqqHandler;

public class ExcitingTransferEngine
  implements IExcitingTransferEngineCallback
{
  static String TAG = "ExcitingTransferEngine";
  private static ExcitingTransferEngine s_instance;
  private boolean mInited = false;
  private HashMap<Long, ExcitingTransferEngine.ExcitingRecvJobContent> mRecvJobs = new LinkedHashMap();
  private HashMap<Long, ExcitingTransferEngine.ExcitingSendJobContent> mSendJobs = new LinkedHashMap();
  
  private ExcitingTransferEngine()
  {
    ExcitingTransferNative.load();
  }
  
  private void addRecvJobContent(long paramLong, ExcitingTransferEngine.ExcitingRecvJobContent paramExcitingRecvJobContent)
  {
    try
    {
      this.mRecvJobs.put(Long.valueOf(paramLong), paramExcitingRecvJobContent);
      return;
    }
    finally
    {
      paramExcitingRecvJobContent = finally;
      throw paramExcitingRecvJobContent;
    }
  }
  
  private void addSendJobContent(long paramLong, ExcitingTransferEngine.ExcitingSendJobContent paramExcitingSendJobContent)
  {
    try
    {
      this.mSendJobs.put(Long.valueOf(paramLong), paramExcitingSendJobContent);
      return;
    }
    finally
    {
      paramExcitingSendJobContent = finally;
      throw paramExcitingSendJobContent;
    }
  }
  
  private void delRecvJobContent(long paramLong)
  {
    try
    {
      this.mRecvJobs.remove(Long.valueOf(paramLong));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void delSendJobContent(long paramLong)
  {
    try
    {
      this.mSendJobs.remove(Long.valueOf(paramLong));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static ExcitingTransferEngine getInstance()
  {
    try
    {
      if (s_instance == null) {
        s_instance = new ExcitingTransferEngine();
      }
      if (!s_instance.isInited()) {
        s_instance.init();
      }
      ExcitingTransferEngine localExcitingTransferEngine = s_instance;
      return localExcitingTransferEngine;
    }
    finally {}
  }
  
  private ExcitingTransferEngine.ExcitingRecvJobContent getRecvJobContent(long paramLong)
  {
    try
    {
      ExcitingTransferEngine.ExcitingRecvJobContent localExcitingRecvJobContent = (ExcitingTransferEngine.ExcitingRecvJobContent)this.mRecvJobs.get(Long.valueOf(paramLong));
      return localExcitingRecvJobContent;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private ExcitingTransferEngine.ExcitingSendJobContent getSendJobContent(long paramLong)
  {
    try
    {
      ExcitingTransferEngine.ExcitingSendJobContent localExcitingSendJobContent = (ExcitingTransferEngine.ExcitingSendJobContent)this.mSendJobs.get(Long.valueOf(paramLong));
      return localExcitingSendJobContent;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void init()
  {
    if (this.mInited) {
      return;
    }
    ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "init...");
    ExcitingTransferNative.init(this);
    ExcitingTransferNative.setRecvFileConfig(new ExcitingTransferDownloadConfig());
    this.mInited = true;
  }
  
  private boolean isInited()
  {
    return this.mInited;
  }
  
  public void cancelRecvFile(long paramLong)
  {
    delRecvJobContent(paramLong);
    ExcitingTransferNative.cancelRecvFile(paramLong);
  }
  
  public void cancelSendFile(long paramLong)
  {
    String str = TAG;
    int i = ExcitingTransferUtil.Log.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelSendFile:");
    localStringBuilder.append(paramLong);
    ExcitingTransferUtil.Log.i(str, i, localStringBuilder.toString());
    delSendJobContent(paramLong);
    ExcitingTransferNative.cancelSendFile(paramLong);
  }
  
  public void detectLanChannel(ExcitingTransferUdpDetectInfo paramExcitingTransferUdpDetectInfo)
  {
    String str = TAG;
    int i = ExcitingTransferUtil.Log.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("detectLanChannel:");
    localStringBuilder.append(paramExcitingTransferUdpDetectInfo.toString());
    ExcitingTransferUtil.Log.i(str, i, localStringBuilder.toString());
    ExcitingTransferNative.detectLanChannel(paramExcitingTransferUdpDetectInfo);
  }
  
  @Deprecated
  public long getAutoDownloadSize()
  {
    return ExcitingTransferNative.getAutoDownloadSize();
  }
  
  @Deprecated
  public ExcitingTransferConfigInfo getDownloadConfig()
  {
    return ExcitingTransferNative.getDownloadConfig();
  }
  
  @Deprecated
  public long getDownloadPieceSize()
  {
    return ExcitingTransferNative.getDownloadPieceSize();
  }
  
  public ExcitingTransferHostInfo getNextBigDataHost(long paramLong)
  {
    return null;
  }
  
  @Deprecated
  public boolean isXTFDownloadEnable()
  {
    return ExcitingTransferNative.isXTFDownloadEnable();
  }
  
  public void onOneSlotComplete(long paramLong, int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    ThreadManager.getUIHandler().post(new ExcitingTransferEngine.8(this, paramLong, paramInt, paramExcitingTransferOneSlotComplete));
  }
  
  public void onRecvComplete(long paramLong, int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    ThreadManager.getUIHandler().post(new ExcitingTransferEngine.6(this, paramLong, paramInt, paramExcitingTransferDownloadCompletedInfo));
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    ThreadManager.getUIHandler().post(new ExcitingTransferEngine.7(this, paramLong1, paramLong2, paramLong3, paramLong4));
  }
  
  public void onRecvStart(long paramLong)
  {
    ThreadManager.getUIHandler().post(new ExcitingTransferEngine.5(this, paramLong));
  }
  
  public void onSendComplete(long paramLong, int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    Object localObject = getSendJobContent(paramLong);
    if (localObject == null) {
      return;
    }
    if ((((ExcitingTransferEngine.ExcitingSendJobContent)localObject).mExcSendInfo.mBusInfo.bUseMediaPlatform) && (paramInt == 0))
    {
      paramExcitingTransferUploadResultRp.mstrFileIdCrc = ExcitingTransferNative.getMediaFileIdCrc(paramLong);
      localObject = TAG;
      int i = ExcitingTransferUtil.Log.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("excitingID[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("] onSendComplete success, bUseMediaPlatform:true, m_strFileIdCrc:");
      localStringBuilder.append(paramExcitingTransferUploadResultRp.mstrFileIdCrc);
      ExcitingTransferUtil.Log.i((String)localObject, i, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new ExcitingTransferEngine.2(this, paramLong, paramInt, paramExcitingTransferUploadResultRp));
  }
  
  public void onSendProgress(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    ThreadManager.getUIHandler().post(new ExcitingTransferEngine.3(this, paramLong1, paramLong3, paramLong2, paramLong4));
  }
  
  public void onSendStart(long paramLong)
  {
    ThreadManager.getUIHandler().post(new ExcitingTransferEngine.1(this, paramLong));
  }
  
  public void onSpeed(long paramLong, ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    ThreadManager.getUIHandler().post(new ExcitingTransferEngine.9(this, paramLong, paramExcitingTransferDownloadSpeedInfo));
  }
  
  public void onSubSenderResult(long paramLong, int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    ThreadManager.getUIHandler().post(new ExcitingTransferEngine.4(this, paramLong, paramInt, paramExcitingTransferUploaderRp));
  }
  
  public long recvFile(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo, IExcitingTransferRecvListener paramIExcitingTransferRecvListener)
  {
    long l = ExcitingTransferNative.recvFile(paramExcitingTransferDownloadReqInfo);
    if (l != -1L) {
      addRecvJobContent(l, new ExcitingTransferEngine.ExcitingRecvJobContent(this, l, paramExcitingTransferDownloadReqInfo, paramIExcitingTransferRecvListener));
    }
    return l;
  }
  
  public long recvFileEx(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo, ExcitingTransferDownloadConfig paramExcitingTransferDownloadConfig, IExcitingTransferRecvListener paramIExcitingTransferRecvListener)
  {
    long l = ExcitingTransferNative.recvFileEx(paramExcitingTransferDownloadReqInfo, paramExcitingTransferDownloadConfig);
    if (l != -1L) {
      addRecvJobContent(l, new ExcitingTransferEngine.ExcitingRecvJobContent(this, l, paramExcitingTransferDownloadReqInfo, paramIExcitingTransferRecvListener));
    }
    return l;
  }
  
  @Deprecated
  public void resetDownloadConfig()
  {
    ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "resetDownloadConfig...");
    ExcitingTransferNative.resetDownloadConfig();
  }
  
  public long sendFile(ExcitingTransferEngine.ExcitingSendInfo paramExcitingSendInfo, IExcitingTransferSendListener paramIExcitingTransferSendListener)
  {
    long l = ExcitingTransferNative.sendFile(paramExcitingSendInfo.mReqInfo, paramExcitingSendInfo.mFileEntry, paramExcitingSendInfo.mBusInfo, paramExcitingSendInfo.mConfig);
    if (l != -1L) {
      addSendJobContent(l, new ExcitingTransferEngine.ExcitingSendJobContent(this, l, paramExcitingSendInfo, paramIExcitingTransferSendListener));
    }
    return l;
  }
  
  @Deprecated
  public void setDownloadConfig(ExcitingTransferConfigInfo paramExcitingTransferConfigInfo)
  {
    String str = TAG;
    int i = ExcitingTransferUtil.Log.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDownloadConfig:");
    localStringBuilder.append(paramExcitingTransferConfigInfo.toString());
    ExcitingTransferUtil.Log.i(str, i, localStringBuilder.toString());
    ExcitingTransferNative.setDownloadConfig(paramExcitingTransferConfigInfo);
  }
  
  public void setFailBigDataHost(long paramLong, String paramString, int paramInt) {}
  
  public void setGlobalProxyInfo(int paramInt, String paramString1, short paramShort, String paramString2, String paramString3)
  {
    String str = TAG;
    int i = ExcitingTransferUtil.Log.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGlobalProxyInfo proxyType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("strProxyip:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("proxyport:");
    localStringBuilder.append(paramShort);
    localStringBuilder.append("strUsename:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("strPassword:");
    localStringBuilder.append(paramString3);
    ExcitingTransferUtil.Log.i(str, i, localStringBuilder.toString());
    ExcitingTransferNative.setGlobalProxyInfo(paramInt, paramString1, paramShort, paramString2, paramString3);
  }
  
  public void setRecvFileConfig(ExcitingTransferDownloadConfig paramExcitingTransferDownloadConfig)
  {
    String str = TAG;
    int i = ExcitingTransferUtil.Log.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRecvFileConfig:");
    localStringBuilder.append(paramExcitingTransferDownloadConfig.toString());
    ExcitingTransferUtil.Log.i(str, i, localStringBuilder.toString());
    ExcitingTransferNative.setRecvFileConfig(paramExcitingTransferDownloadConfig);
  }
  
  public void setSendFileConfig(ExcitingTransferUploadChnConfigInfo paramExcitingTransferUploadChnConfigInfo)
  {
    String str = TAG;
    int i = ExcitingTransferUtil.Log.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSendFileConfig:");
    localStringBuilder.append(paramExcitingTransferUploadChnConfigInfo.toString());
    ExcitingTransferUtil.Log.i(str, i, localStringBuilder.toString());
    ExcitingTransferNative.setSendFileConfig(paramExcitingTransferUploadChnConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine
 * JD-Core Version:    0.7.0.1
 */