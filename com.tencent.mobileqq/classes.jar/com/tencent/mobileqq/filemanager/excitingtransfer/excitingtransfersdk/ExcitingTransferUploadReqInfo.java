package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;

public class ExcitingTransferUploadReqInfo
{
  public boolean bSupportHttps = false;
  public String strSSLCName;
  public ExcitingTransferHostInfo[] vecSrvIpAndPorts;
  
  @NonNull
  public String toString()
  {
    String str1 = "";
    String str2 = str1;
    if (this.vecSrvIpAndPorts != null)
    {
      ExcitingTransferHostInfo[] arrayOfExcitingTransferHostInfo = this.vecSrvIpAndPorts;
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
    return "BigData Host:" + str2 + " strSSLCName:" + this.strSSLCName + " bSupportHttps:" + this.bSupportHttps;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadReqInfo
 * JD-Core Version:    0.7.0.1
 */