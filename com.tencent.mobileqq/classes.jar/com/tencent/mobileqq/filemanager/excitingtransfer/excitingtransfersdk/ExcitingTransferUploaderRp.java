package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;

public class ExcitingTransferUploaderRp
{
  public boolean m_bIsBigData;
  public int m_cXTFTransferType = -1;
  public int m_dwProxyType;
  public long m_nResult;
  public long m_nSrvReturCode;
  public String m_strFileName;
  public String m_strFileUrl;
  public String m_strServerIp;
  public String m_strSuffix;
  public long m_u64FileSize;
  public long m_u64HttpTime;
  public long m_u64TransferSize;
  public long m_u64TransferSpeed;
  public long m_uGroupCode;
  public long m_uPeerUin;
  public int m_wAppType = -1;
  public short m_wServerPort;
  public int m_wTranferPlatform = -1;
  
  @NonNull
  public String toString()
  {
    return "TransferType:" + this.m_cXTFTransferType + " m_wTranferPlatform:" + this.m_wTranferPlatform + " m_wAppType:" + this.m_wAppType + " m_nResult:" + this.m_nResult + " m_nSrvReturCode:" + this.m_nSrvReturCode + " m_strFileName:" + this.m_strFileName + " m_strSuffix:" + this.m_strSuffix + " m_u64FileSize:" + this.m_u64FileSize + " m_uPeerUin:" + this.m_uPeerUin + " m_uGroupCode:" + this.m_uGroupCode + " m_bIsBigData:" + this.m_bIsBigData + " m_u64TransferSpeed:" + this.m_u64TransferSpeed + " m_u64HttpTime:" + this.m_u64HttpTime + " m_u64TransferSize:" + this.m_u64TransferSize + " m_strServerIp:" + this.m_strServerIp + " m_wServerPort:" + this.m_wServerPort + " m_dwProxyType:" + this.m_dwProxyType + " m_strFileUrl:" + this.m_strFileUrl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp
 * JD-Core Version:    0.7.0.1
 */