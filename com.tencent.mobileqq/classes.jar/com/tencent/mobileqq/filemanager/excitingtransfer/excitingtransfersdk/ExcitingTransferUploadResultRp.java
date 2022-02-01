package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("m_dwFileCookieId:");
    localStringBuilder.append(this.mdwFileCookieId);
    localStringBuilder.append("TransferType:");
    localStringBuilder.append(this.mcXTFTransferType);
    localStringBuilder.append(" m_wTranferPlatform:");
    localStringBuilder.append(this.mwTranferPlatform);
    localStringBuilder.append(" m_wAppType:");
    localStringBuilder.append(this.mwAppType);
    localStringBuilder.append(" m_nResult:");
    localStringBuilder.append(this.mnResult);
    localStringBuilder.append(" m_nSrvReturCode:");
    localStringBuilder.append(this.mnSrvReturCode);
    localStringBuilder.append(" m_strFileName:");
    localStringBuilder.append(this.mstrFileName);
    localStringBuilder.append(" m_strSuffix:");
    localStringBuilder.append(this.mstrSuffix);
    localStringBuilder.append(" m_u64FileSize:");
    localStringBuilder.append(this.mu64FileSize);
    localStringBuilder.append(" m_uPeerUin:");
    localStringBuilder.append(this.muPeerUin);
    localStringBuilder.append(" m_uGroupCode:");
    localStringBuilder.append(this.muGroupCode);
    localStringBuilder.append(" m_bIsXTFValid:");
    localStringBuilder.append(this.mbIsXTFValid);
    localStringBuilder.append(" m_u64TransferSpeed:");
    localStringBuilder.append(this.mu64TransferSpeed);
    localStringBuilder.append(" m_u64HttpTime:");
    localStringBuilder.append(this.mu64HttpTime);
    localStringBuilder.append(" m_u64TransferSize:");
    localStringBuilder.append(this.mu64TransferSize);
    localStringBuilder.append(" m_strServerIp:");
    localStringBuilder.append(this.mstrServerIp);
    localStringBuilder.append(" m_wServerPort:");
    localStringBuilder.append(this.mwServerPort);
    localStringBuilder.append(" m_dwProxyType:");
    localStringBuilder.append(this.mdwProxyType);
    localStringBuilder.append(" m_strFileUrl:");
    localStringBuilder.append(this.mstrFileUrl);
    localStringBuilder.append(" m_u64StartSize:");
    localStringBuilder.append(this.mu64StartSize);
    localStringBuilder.append(" m_u64ReportVer:");
    localStringBuilder.append(this.mu64ReportVer);
    localStringBuilder.append(" m_eInvalidReason:");
    localStringBuilder.append(this.meInvalidReason);
    localStringBuilder.append(" m_uMaxUploadingFtnNum:");
    localStringBuilder.append(this.muMaxUploadingFtnNum);
    localStringBuilder.append(" m_uRetryCount:");
    localStringBuilder.append(this.muRetryCount);
    localStringBuilder.append(" m_uIpChangeCount:");
    localStringBuilder.append(this.muIpChangeCount);
    localStringBuilder.append(" m_uRollBackCount:");
    localStringBuilder.append(this.muRollBackCount);
    localStringBuilder.append(" m_uQueryHoleCount:");
    localStringBuilder.append(this.muQueryHoleCount);
    localStringBuilder.append(" m_uRangDiffCount:");
    localStringBuilder.append(this.muRangDiffCount);
    localStringBuilder.append(" m_uDelayTotoalCount:");
    localStringBuilder.append(this.muDelayTotoalCount);
    localStringBuilder.append(" m_nTcpCnnCode:");
    localStringBuilder.append(this.mnTcpCnnCode);
    localStringBuilder.append(" m_nTcpSocketCode:");
    localStringBuilder.append(this.mnTcpSocketCode);
    localStringBuilder.append(" m_wHttpsSupport:");
    localStringBuilder.append(this.mwHttpsSupport);
    localStringBuilder.append(" m_uTotalTime:");
    localStringBuilder.append(this.muTotalTime);
    localStringBuilder.append(" m_uFullHashCaculateTime:");
    localStringBuilder.append(this.muFullHashCaculateTime);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp
 * JD-Core Version:    0.7.0.1
 */