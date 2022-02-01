package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

public class ExcitingTransferUploadChnConfigInfo
{
  public long nConnectTimeout = 7000L;
  public long nDataTimeout = 21000L;
  public int nMaxEachHostErrorCount = 27;
  public int nMaxEachHostParallelUseCount = 10;
  public int nMaxEachHostTotalUseCount = 200;
  public long nTotoalDataTimeout = 120000L;
  public int uMaxChannelNum = 3;
  public long uMuliFileSizeLimit = 10485760L;
  public int uPieceSize = 524288;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uMuliFileSizeLimit:");
    localStringBuilder.append(this.uMuliFileSizeLimit);
    localStringBuilder.append(" uMaxChannelNum:");
    localStringBuilder.append(this.uMaxChannelNum);
    localStringBuilder.append(" uPieceSize:");
    localStringBuilder.append(this.uPieceSize);
    localStringBuilder.append("nMaxEachHostTotalUseCount:");
    localStringBuilder.append(this.nMaxEachHostTotalUseCount);
    localStringBuilder.append(" nMaxEachHostErrorCount:");
    localStringBuilder.append(this.nMaxEachHostErrorCount);
    localStringBuilder.append(" nMaxEachHostParallelUseCount:");
    localStringBuilder.append(this.nMaxEachHostParallelUseCount);
    localStringBuilder.append(" nConnectTimeout:");
    localStringBuilder.append(this.nConnectTimeout);
    localStringBuilder.append(" nDataTimeout:");
    localStringBuilder.append(this.nDataTimeout);
    localStringBuilder.append(" nTotoalDataTimeout:");
    localStringBuilder.append(this.nTotoalDataTimeout);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo
 * JD-Core Version:    0.7.0.1
 */