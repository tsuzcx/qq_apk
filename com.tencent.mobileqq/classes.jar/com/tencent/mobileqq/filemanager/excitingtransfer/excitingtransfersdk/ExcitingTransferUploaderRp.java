package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

public class ExcitingTransferUploaderRp
{
  public boolean mbIsBigData = false;
  public int mcXTFTransferType = -1;
  public int mdwProxyType = 0;
  public long mnResult = 0L;
  public long mnSrvReturCode = 0L;
  public String mstrFileName;
  public String mstrFileUrl;
  public String mstrServerIp;
  public String mstrSuffix;
  public long mu64FileSize = 0L;
  public long mu64HttpTime = 0L;
  public long mu64TransferSize = 0L;
  public long mu64TransferSpeed = 0L;
  public long muGroupCode = 0L;
  public long muPeerUin = 0L;
  public int mwAppType = -1;
  public short mwServerPort = 0;
  public int mwTranferPlatform = -1;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
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
    localStringBuilder.append(" m_bIsBigData:");
    localStringBuilder.append(this.mbIsBigData);
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
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp
 * JD-Core Version:    0.7.0.1
 */