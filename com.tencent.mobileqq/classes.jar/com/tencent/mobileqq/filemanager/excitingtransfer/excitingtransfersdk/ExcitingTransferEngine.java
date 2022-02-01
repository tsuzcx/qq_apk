package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import mqq.os.MqqHandler;

public class ExcitingTransferEngine
  implements IExcitingTransferEngineCallback
{
  static String TAG = "ExcitingTransferEngine";
  private static ExcitingTransferEngine s_instance;
  private boolean mInited;
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
  
  public void OnOneSlotComplete(long paramLong, int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    ThreadManager.getUIHandler().post(new ExcitingTransferEngine.8(this, paramLong, paramInt, paramExcitingTransferOneSlotComplete));
  }
  
  public void OnSpeed(long paramLong, ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    ThreadManager.getUIHandler().post(new ExcitingTransferEngine.9(this, paramLong, paramExcitingTransferDownloadSpeedInfo));
  }
  
  public void cancelRecvFile(long paramLong)
  {
    delRecvJobContent(paramLong);
    ExcitingTransferNative.cancelRecvFile(paramLong);
  }
  
  public void cancelSendFile(long paramLong)
  {
    ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "cancelSendFile:" + paramLong);
    delSendJobContent(paramLong);
    ExcitingTransferNative.cancelSendFile(paramLong);
  }
  
  public void detectLanChannel(ExcitingTransferUdpDetectInfo paramExcitingTransferUdpDetectInfo)
  {
    ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "detectLanChannel:" + paramExcitingTransferUdpDetectInfo.toString());
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
    ExcitingTransferEngine.ExcitingSendJobContent localExcitingSendJobContent = getSendJobContent(paramLong);
    if (localExcitingSendJobContent == null) {
      return;
    }
    if ((localExcitingSendJobContent.mExcSendInfo.mBusInfo.bUseMediaPlatform) && (paramInt == 0))
    {
      paramExcitingTransferUploadResultRp.m_strFileIdCrc = ExcitingTransferNative.getMediaFileIdCrc(paramLong);
      QLog.i(TAG, 1, "excitingID[" + paramLong + "] onSendComplete success, bUseMediaPlatform:true, m_strFileIdCrc:" + paramExcitingTransferUploadResultRp.m_strFileIdCrc);
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
    ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "setDownloadConfig:" + paramExcitingTransferConfigInfo.toString());
    ExcitingTransferNative.setDownloadConfig(paramExcitingTransferConfigInfo);
  }
  
  public void setFailBigDataHost(long paramLong, String paramString, int paramInt) {}
  
  public void setGlobalProxyInfo(int paramInt, String paramString1, short paramShort, String paramString2, String paramString3)
  {
    ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "setGlobalProxyInfo proxyType:" + paramInt + "strProxyip:" + paramString1 + "proxyport:" + paramShort + "strUsename:" + paramString2 + "strPassword:" + paramString3);
    ExcitingTransferNative.setGlobalProxyInfo(paramInt, paramString1, paramShort, paramString2, paramString3);
  }
  
  public void setRecvFileConfig(ExcitingTransferDownloadConfig paramExcitingTransferDownloadConfig)
  {
    ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "setRecvFileConfig:" + paramExcitingTransferDownloadConfig.toString());
    ExcitingTransferNative.setRecvFileConfig(paramExcitingTransferDownloadConfig);
  }
  
  public void setSendFileConfig(ExcitingTransferUploadChnConfigInfo paramExcitingTransferUploadChnConfigInfo)
  {
    ExcitingTransferUtil.Log.i(TAG, ExcitingTransferUtil.Log.USR, "setSendFileConfig:" + paramExcitingTransferUploadChnConfigInfo.toString());
    ExcitingTransferNative.setSendFileConfig(paramExcitingTransferUploadChnConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine
 * JD-Core Version:    0.7.0.1
 */