package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;
import com.tencent.commonsdk.util.HexUtil;

public class ExcitingTransferDownloadReqInfo
{
  public byte[] bufLanUuid;
  public long fileSize;
  public boolean isSupportHttps;
  public ExcitingTransferHostInfo[] mHosts;
  public String mLanHost;
  public int mLanPort;
  public long mSRKey;
  public byte[] md5;
  public String serverPath;
  public String sslCName;
  public String strCookie;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo
 * JD-Core Version:    0.7.0.1
 */