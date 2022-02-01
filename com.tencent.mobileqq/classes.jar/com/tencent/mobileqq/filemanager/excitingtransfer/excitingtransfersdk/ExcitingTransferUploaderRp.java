package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;

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
  
  @NonNull
  public String toString()
  {
    return "TransferType:" + this.mcXTFTransferType + " m_wTranferPlatform:" + this.mwTranferPlatform + " m_wAppType:" + this.mwAppType + " m_nResult:" + this.mnResult + " m_nSrvReturCode:" + this.mnSrvReturCode + " m_strFileName:" + this.mstrFileName + " m_strSuffix:" + this.mstrSuffix + " m_u64FileSize:" + this.mu64FileSize + " m_uPeerUin:" + this.muPeerUin + " m_uGroupCode:" + this.muGroupCode + " m_bIsBigData:" + this.mbIsBigData + " m_u64TransferSpeed:" + this.mu64TransferSpeed + " m_u64HttpTime:" + this.mu64HttpTime + " m_u64TransferSize:" + this.mu64TransferSize + " m_strServerIp:" + this.mstrServerIp + " m_wServerPort:" + this.mwServerPort + " m_dwProxyType:" + this.mdwProxyType + " m_strFileUrl:" + this.mstrFileUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp
 * JD-Core Version:    0.7.0.1
 */