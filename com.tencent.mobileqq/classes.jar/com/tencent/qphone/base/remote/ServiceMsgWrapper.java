package com.tencent.qphone.base.remote;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ServiceMsgWrapper
{
  private static final String TAG = "MSF.S.ServiceMsgWrapper";
  private FromServiceMsg fromServiceMsg;
  private ArrayList hasTransIndex;
  private int hasTransLength;
  private byte[] tmpWupBuffer;
  private ToServiceMsg toServiceMsg;
  private int totalLength;
  
  public ServiceMsgWrapper(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    this.toServiceMsg = paramToServiceMsg;
    this.fromServiceMsg = paramFromServiceMsg;
    this.totalLength = paramInt;
    this.tmpWupBuffer = new byte[paramInt];
    this.hasTransLength = 0;
    this.hasTransIndex = new ArrayList();
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("construct ServiceMsgWrapper: cmd = ");
      paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
      paramToServiceMsg.append(", totalLength = ");
      paramToServiceMsg.append(paramInt);
      QLog.d("MSF.S.ServiceMsgWrapper", 2, paramToServiceMsg.toString());
    }
  }
  
  public boolean buildFromMsgWupBuffer(int paramInt, byte[] paramArrayOfByte)
  {
    try
    {
      if (paramInt < this.hasTransLength)
      {
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("buildFromMsgWupBuffer but the startIndex has trans, startIndex = ");
          paramArrayOfByte.append(paramInt);
          QLog.d("MSF.S.ServiceMsgWrapper", 2, paramArrayOfByte.toString());
        }
        return false;
      }
      if (this.hasTransIndex.contains(Integer.valueOf(paramInt)))
      {
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("buildFromMsgWupBuffer but the index ");
          paramArrayOfByte.append(paramInt);
          paramArrayOfByte.append(" repeat");
          QLog.d("MSF.S.ServiceMsgWrapper", 2, paramArrayOfByte.toString());
        }
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("buildFromMsgWupBuffer: cmd = ");
        localStringBuilder.append(this.fromServiceMsg.getServiceCmd());
        localStringBuilder.append(", hasTransLength = ");
        localStringBuilder.append(this.hasTransLength);
        localStringBuilder.append(", startIndex = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", buffer.length = ");
        localStringBuilder.append(paramArrayOfByte.length);
        QLog.d("MSF.S.ServiceMsgWrapper", 2, localStringBuilder.toString());
      }
      if (this.hasTransLength + paramArrayOfByte.length > this.totalLength)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.ServiceMsgWrapper", 2, "buildFromMsgWupBuffer fail with index out of bound");
        }
        return false;
      }
      this.hasTransLength += paramArrayOfByte.length;
      this.hasTransIndex.add(Integer.valueOf(paramInt));
      System.arraycopy(paramArrayOfByte, 0, this.tmpWupBuffer, paramInt, paramArrayOfByte.length);
      if (isFinishTransported()) {
        this.fromServiceMsg.putWupBuffer(this.tmpWupBuffer);
      }
      return true;
    }
    finally {}
  }
  
  public FromServiceMsg getFromServiceMsg()
  {
    return this.fromServiceMsg;
  }
  
  public ToServiceMsg getToServiceMsg()
  {
    return this.toServiceMsg;
  }
  
  public boolean isFinishTransported()
  {
    return this.hasTransLength == this.totalLength;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.remote.ServiceMsgWrapper
 * JD-Core Version:    0.7.0.1
 */