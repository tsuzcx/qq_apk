package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;

public class ExcitingTransferUploadResultRp
{
  public boolean m_bIsFlashTransfer;
  public boolean m_bIsXTFValid;
  public int m_cXTFTransferType = -1;
  public long m_dwFileCookieId;
  public int m_dwProxyType;
  public int m_eInvalidReason;
  public long m_nResult;
  public long m_nSrvReturCode;
  public int m_nTcpCnnCode;
  public int m_nTcpSocketCode;
  public String m_strFileIdCrc;
  public String m_strFileName;
  public String m_strFileUrl;
  public String m_strServerIp;
  public String m_strSuffix;
  public long m_u64FileSize;
  public long m_u64HttpTime;
  public long m_u64ReportVer;
  public long m_u64StartSize;
  public long m_u64TransferSize;
  public long m_u64TransferSpeed;
  public long m_uDelayTotoalCount;
  public long m_uFullHashCaculateTime;
  public long m_uGroupCode;
  public long m_uHashCaculateTime;
  public long m_uIpChangeCount;
  public long m_uMaxUploadingFtnNum;
  public long m_uPeerUin;
  public long m_uQueryHoleCount;
  public long m_uRangDiffCount;
  public long m_uRetryCount;
  public long m_uRollBackCount;
  public long m_uSecurityTime;
  public long m_uTotalTime;
  public int m_wAppType = -1;
  public short m_wHttpsSupport;
  public short m_wServerPort;
  public int m_wTranferPlatform = -1;
  
  @NonNull
  public String toString()
  {
    return "m_dwFileCookieId:" + this.m_dwFileCookieId + "TransferType:" + this.m_cXTFTransferType + " m_wTranferPlatform:" + this.m_wTranferPlatform + " m_wAppType:" + this.m_wAppType + " m_nResult:" + this.m_nResult + " m_nSrvReturCode:" + this.m_nSrvReturCode + " m_strFileName:" + this.m_strFileName + " m_strSuffix:" + this.m_strSuffix + " m_u64FileSize:" + this.m_u64FileSize + " m_uPeerUin:" + this.m_uPeerUin + " m_uGroupCode:" + this.m_uGroupCode + " m_bIsXTFValid:" + this.m_bIsXTFValid + " m_u64TransferSpeed:" + this.m_u64TransferSpeed + " m_u64HttpTime:" + this.m_u64HttpTime + " m_u64TransferSize:" + this.m_u64TransferSize + " m_strServerIp:" + this.m_strServerIp + " m_wServerPort:" + this.m_wServerPort + " m_dwProxyType:" + this.m_dwProxyType + " m_strFileUrl:" + this.m_strFileUrl + " m_u64StartSize:" + this.m_u64StartSize + " m_u64ReportVer:" + this.m_u64ReportVer + " m_eInvalidReason:" + this.m_eInvalidReason + " m_uMaxUploadingFtnNum:" + this.m_uMaxUploadingFtnNum + " m_uRetryCount:" + this.m_uRetryCount + " m_uIpChangeCount:" + this.m_uIpChangeCount + " m_uRollBackCount:" + this.m_uRollBackCount + " m_uQueryHoleCount:" + this.m_uQueryHoleCount + " m_uRangDiffCount:" + this.m_uRangDiffCount + " m_uDelayTotoalCount:" + this.m_uDelayTotoalCount + " m_nTcpCnnCode:" + this.m_nTcpCnnCode + " m_nTcpSocketCode:" + this.m_nTcpSocketCode + " m_wHttpsSupport:" + this.m_wHttpsSupport + " m_uTotalTime:" + this.m_uTotalTime + " m_uFullHashCaculateTime:" + this.m_uFullHashCaculateTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp
 * JD-Core Version:    0.7.0.1
 */