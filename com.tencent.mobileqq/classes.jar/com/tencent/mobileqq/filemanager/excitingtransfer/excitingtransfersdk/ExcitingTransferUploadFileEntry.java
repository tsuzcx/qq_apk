package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;
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
  
  @NonNull
  public String toString()
  {
    return "strLocalFilePath:" + this.strLocalFilePath + " strFileName:" + this.strFileName + " uFileSize:" + this.uFileSize + " bufMd5:" + HexUtil.bytes2HexStr(this.bufMd5) + " buf10MMd5:" + HexUtil.bytes2HexStr(this.buf10MMd5) + " bufSha3:" + HexUtil.bytes2HexStr(this.bufSha3) + " bufSha:" + HexUtil.bytes2HexStr(this.bufSha);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadFileEntry
 * JD-Core Version:    0.7.0.1
 */