package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;
import com.tencent.commonsdk.util.HexUtil;

public class ExcitingTransferDownloadReqInfo
{
  public byte[] bufLanUuid = null;
  public long fileSize = 0L;
  public boolean isSupportHttps = false;
  public ExcitingTransferHostInfo[] mHosts = null;
  public String mLanHost = null;
  public int mLanPort = 0;
  public long mSRKey = 0L;
  public byte[] md5;
  public String serverPath = null;
  public String sslCName = null;
  public String strCookie = null;
  public String strFileName;
  public String strSaveFileDir;
  public String strTempFilePath;
  
  @NonNull
  public String toString()
  {
    String str1 = "";
    String str2 = str1;
    if (this.mHosts != null)
    {
      ExcitingTransferHostInfo[] arrayOfExcitingTransferHostInfo = this.mHosts;
      int j = arrayOfExcitingTransferHostInfo.length;
      int i = 0;
      for (;;)
      {
        str2 = str1;
        if (i >= j) {
          break;
        }
        str2 = arrayOfExcitingTransferHostInfo[i];
        str1 = str1 + "[" + str2.mstrIp + ":" + str2.mport + "] ";
        i += 1;
      }
    }
    return "strFileName:" + this.strFileName + " fileSize:" + this.fileSize + " serverPath:" + this.serverPath + " strCookie:" + this.strCookie + " hostList:" + str2 + " isSupportHttps:" + this.isSupportHttps + " sslCName:" + this.sslCName + " strSaveFileDir:" + this.strSaveFileDir + " strTempFilePath:" + this.strTempFilePath + " md5:" + HexUtil.bytes2HexStr(this.md5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo
 * JD-Core Version:    0.7.0.1
 */