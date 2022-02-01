package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SoLoadUtil;

public class ExcitingTransferNative
{
  static
  {
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "xplatform", 0, false);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      try
      {
        for (;;)
        {
          SoLoadUtil.a(BaseApplicationImpl.getContext(), "mbedtlsall", 0, false);
          try
          {
            SoLoadUtil.a(BaseApplicationImpl.getContext(), "excitingtransfer", 0, false);
            return;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
          {
            localUnsatisfiedLinkError3.printStackTrace();
          }
          localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
          localUnsatisfiedLinkError1.printStackTrace();
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        for (;;)
        {
          localUnsatisfiedLinkError2.printStackTrace();
        }
      }
    }
  }
  
  public static native void cancelRecvFile(long paramLong);
  
  public static native void cancelSendFile(long paramLong);
  
  public static native void detectLanChannel(ExcitingTransferUdpDetectInfo paramExcitingTransferUdpDetectInfo);
  
  public static native long getAutoDownloadSize();
  
  @Deprecated
  public static native ExcitingTransferConfigInfo getDownloadConfig();
  
  public static native long getDownloadPieceSize();
  
  public static native String getMediaFileIdCrc(long paramLong);
  
  public static native void init(IExcitingTransferEngineCallback paramIExcitingTransferEngineCallback);
  
  public static native boolean isXTFDownloadEnable();
  
  public static void load() {}
  
  public static native long recvFile(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo);
  
  public static native long recvFileEx(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo, ExcitingTransferDownloadConfig paramExcitingTransferDownloadConfig);
  
  @Deprecated
  public static native void resetDownloadConfig();
  
  public static native long sendFile(ExcitingTransferUploadReqInfo paramExcitingTransferUploadReqInfo, ExcitingTransferUploadFileEntry paramExcitingTransferUploadFileEntry, ExcitingTransferUploadBizInfo paramExcitingTransferUploadBizInfo, ExcitingTransferUploadChnConfigInfo paramExcitingTransferUploadChnConfigInfo);
  
  @Deprecated
  public static native void setDownloadConfig(ExcitingTransferConfigInfo paramExcitingTransferConfigInfo);
  
  public static native void setGlobalProxyInfo(int paramInt, String paramString1, short paramShort, String paramString2, String paramString3);
  
  public static native void setRecvFileConfig(ExcitingTransferDownloadConfig paramExcitingTransferDownloadConfig);
  
  public static native void setSendFileConfig(ExcitingTransferUploadChnConfigInfo paramExcitingTransferUploadChnConfigInfo);
  
  public static native void unInit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferNative
 * JD-Core Version:    0.7.0.1
 */