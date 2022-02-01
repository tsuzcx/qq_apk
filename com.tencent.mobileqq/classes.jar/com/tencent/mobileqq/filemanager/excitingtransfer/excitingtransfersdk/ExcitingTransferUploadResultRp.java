package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;

public class ExcitingTransferUploadResultRp
{
  public boolean mbIsFlashTransfer = false;
  public boolean mbIsXTFValid = false;
  public int mcXTFTransferType = -1;
  public long mdwFileCookieId;
  public int mdwProxyType = 0;
  public int meInvalidReason = 0;
  public long mnResult = 0L;
  public long mnSrvReturCode = 0L;
  public int mnTcpCnnCode = 0;
  public int mnTcpSocketCode = 0;
  public String mstrFileIdCrc;
  public String mstrFileName;
  public String mstrFileUrl;
  public String mstrServerIp;
  public String mstrSuffix;
  public long mu64FileSize = 0L;
  public long mu64HttpTime = 0L;
  public long mu64ReportVer = 0L;
  public long mu64StartSize = 0L;
  public long mu64TransferSize = 0L;
  public long mu64TransferSpeed = 0L;
  public long muDelayTotoalCount = 0L;
  public long muFullHashCaculateTime = 0L;
  public long muGroupCode = 0L;
  public long muHashCaculateTime = 0L;
  public long muIpChangeCount = 0L;
  public long muMaxUploadingFtnNum = 0L;
  public long muPeerUin = 0L;
  public long muQueryHoleCount = 0L;
  public long muRangDiffCount = 0L;
  public long muRetryCount = 0L;
  public long muRollBackCount = 0L;
  public long muSecurityTime = 0L;
  public long muTotalTime = 0L;
  public int mwAppType = -1;
  public short mwHttpsSupport = 0;
  public short mwServerPort = 0;
  public int mwTranferPlatform = -1;
  
  @NonNull
  public String toString()
  {
    return "m_dwFileCookieId:" + this.mdwFileCookieId + "TransferType:" + this.mcXTFTransferType + " m_wTranferPlatform:" + this.mwTranferPlatform + " m_wAppType:" + this.mwAppType + " m_nResult:" + this.mnResult + " m_nSrvReturCode:" + this.mnSrvReturCode + " m_strFileName:" + this.mstrFileName + " m_strSuffix:" + this.mstrSuffix + " m_u64FileSize:" + this.mu64FileSize + " m_uPeerUin:" + this.muPeerUin + " m_uGroupCode:" + this.muGroupCode + " m_bIsXTFValid:" + this.mbIsXTFValid + " m_u64TransferSpeed:" + this.mu64TransferSpeed + " m_u64HttpTime:" + this.mu64HttpTime + " m_u64TransferSize:" + this.mu64TransferSize + " m_strServerIp:" + this.mstrServerIp + " m_wServerPort:" + this.mwServerPort + " m_dwProxyType:" + this.mdwProxyType + " m_strFileUrl:" + this.mstrFileUrl + " m_u64StartSize:" + this.mu64StartSize + " m_u64ReportVer:" + this.mu64ReportVer + " m_eInvalidReason:" + this.meInvalidReason + " m_uMaxUploadingFtnNum:" + this.muMaxUploadingFtnNum + " m_uRetryCount:" + this.muRetryCount + " m_uIpChangeCount:" + this.muIpChangeCount + " m_uRollBackCount:" + this.muRollBackCount + " m_uQueryHoleCount:" + this.muQueryHoleCount + " m_uRangDiffCount:" + this.muRangDiffCount + " m_uDelayTotoalCount:" + this.muDelayTotoalCount + " m_nTcpCnnCode:" + this.mnTcpCnnCode + " m_nTcpSocketCode:" + this.mnTcpSocketCode + " m_wHttpsSupport:" + this.mwHttpsSupport + " m_uTotalTime:" + this.muTotalTime + " m_uFullHashCaculateTime:" + this.muFullHashCaculateTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp
 * JD-Core Version:    0.7.0.1
 */