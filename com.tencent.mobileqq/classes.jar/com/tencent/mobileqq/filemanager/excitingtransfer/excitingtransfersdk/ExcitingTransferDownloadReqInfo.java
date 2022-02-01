package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

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
  
  public String toString()
  {
    ExcitingTransferHostInfo[] arrayOfExcitingTransferHostInfo = this.mHosts;
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (arrayOfExcitingTransferHostInfo != null)
    {
      int j = arrayOfExcitingTransferHostInfo.length;
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        localObject2 = arrayOfExcitingTransferHostInfo[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("[");
        localStringBuilder.append(((ExcitingTransferHostInfo)localObject2).mstrIp);
        localStringBuilder.append(":");
        localStringBuilder.append(((ExcitingTransferHostInfo)localObject2).mport);
        localStringBuilder.append("] ");
        localObject1 = localStringBuilder.toString();
        i += 1;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("strFileName:");
    ((StringBuilder)localObject1).append(this.strFileName);
    ((StringBuilder)localObject1).append(" fileSize:");
    ((StringBuilder)localObject1).append(this.fileSize);
    ((StringBuilder)localObject1).append(" serverPath:");
    ((StringBuilder)localObject1).append(this.serverPath);
    ((StringBuilder)localObject1).append(" strCookie:");
    ((StringBuilder)localObject1).append(this.strCookie);
    ((StringBuilder)localObject1).append(" hostList:");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(" isSupportHttps:");
    ((StringBuilder)localObject1).append(this.isSupportHttps);
    ((StringBuilder)localObject1).append(" sslCName:");
    ((StringBuilder)localObject1).append(this.sslCName);
    ((StringBuilder)localObject1).append(" strSaveFileDir:");
    ((StringBuilder)localObject1).append(this.strSaveFileDir);
    ((StringBuilder)localObject1).append(" strTempFilePath:");
    ((StringBuilder)localObject1).append(this.strTempFilePath);
    ((StringBuilder)localObject1).append(" md5:");
    ((StringBuilder)localObject1).append(HexUtil.bytes2HexStr(this.md5));
    return ((StringBuilder)localObject1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo
 * JD-Core Version:    0.7.0.1
 */