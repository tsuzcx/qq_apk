package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

public class ExcitingTransferUploadReqInfo
{
  public boolean bSupportHttps = false;
  public String strSSLCName;
  public ExcitingTransferHostInfo[] vecSrvIpAndPorts;
  
  public String toString()
  {
    ExcitingTransferHostInfo[] arrayOfExcitingTransferHostInfo = this.vecSrvIpAndPorts;
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
    ((StringBuilder)localObject1).append("BigData Host:");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(" strSSLCName:");
    ((StringBuilder)localObject1).append(this.strSSLCName);
    ((StringBuilder)localObject1).append(" bSupportHttps:");
    ((StringBuilder)localObject1).append(this.bSupportHttps);
    return ((StringBuilder)localObject1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadReqInfo
 * JD-Core Version:    0.7.0.1
 */