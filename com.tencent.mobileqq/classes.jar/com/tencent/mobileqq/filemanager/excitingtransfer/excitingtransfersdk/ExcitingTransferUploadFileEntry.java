package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import com.tencent.commonsdk.util.HexUtil;

public class ExcitingTransferUploadFileEntry
{
  public byte[] buf10MMd5;
  public byte[] bufMd5;
  public byte[] bufSha;
  public byte[] bufSha3;
  public String strFileName;
  public String strLocalFilePath;
  public long uFileSize;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("strLocalFilePath:");
    localStringBuilder.append(this.strLocalFilePath);
    localStringBuilder.append(" strFileName:");
    localStringBuilder.append(this.strFileName);
    localStringBuilder.append(" uFileSize:");
    localStringBuilder.append(this.uFileSize);
    localStringBuilder.append(" bufMd5:");
    localStringBuilder.append(HexUtil.bytes2HexStr(this.bufMd5));
    localStringBuilder.append(" buf10MMd5:");
    localStringBuilder.append(HexUtil.bytes2HexStr(this.buf10MMd5));
    localStringBuilder.append(" bufSha3:");
    localStringBuilder.append(HexUtil.bytes2HexStr(this.bufSha3));
    localStringBuilder.append(" bufSha:");
    localStringBuilder.append(HexUtil.bytes2HexStr(this.bufSha));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadFileEntry
 * JD-Core Version:    0.7.0.1
 */