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
    if (QLog.isColorLevel()) {
      QLog.d("MSF.S.ServiceMsgWrapper", 2, "construct ServiceMsgWrapper: cmd = " + paramFromServiceMsg.getServiceCmd() + ", totalLength = " + paramInt);
    }
  }
  
  public boolean buildFromMsgWupBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = false;
    for (;;)
    {
      boolean bool1;
      try
      {
        if (paramInt < this.hasTransLength)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.S.ServiceMsgWrapper", 2, "buildFromMsgWupBuffer but the startIndex has trans, startIndex = " + paramInt);
            bool1 = bool2;
          }
          return bool1;
        }
        if (this.hasTransIndex.contains(Integer.valueOf(paramInt)))
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MSF.S.ServiceMsgWrapper", 2, "buildFromMsgWupBuffer but the index " + paramInt + " repeat");
          bool1 = bool2;
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label186;
        }
      }
      finally {}
      QLog.d("MSF.S.ServiceMsgWrapper", 2, "buildFromMsgWupBuffer: cmd = " + this.fromServiceMsg.getServiceCmd() + ", hasTransLength = " + this.hasTransLength + ", startIndex = " + paramInt + ", buffer.length = " + paramArrayOfByte.length);
      label186:
      if (this.hasTransLength + paramArrayOfByte.length > this.totalLength)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("MSF.S.ServiceMsgWrapper", 2, "buildFromMsgWupBuffer fail with index out of bound");
          bool1 = bool2;
        }
      }
      else
      {
        this.hasTransLength += paramArrayOfByte.length;
        this.hasTransIndex.add(Integer.valueOf(paramInt));
        System.arraycopy(paramArrayOfByte, 0, this.tmpWupBuffer, paramInt, paramArrayOfByte.length);
        if (isFinishTransported()) {
          this.fromServiceMsg.putWupBuffer(this.tmpWupBuffer);
        }
        bool1 = true;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.ServiceMsgWrapper
 * JD-Core Version:    0.7.0.1
 */