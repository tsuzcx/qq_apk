package com.tencent.upload.request;

import com.tencent.upload.utils.PDUtil;
import com.tencent.upload.utils.PduHeader;

public final class UploadResponse
{
  public int code;
  private int mCmd;
  private int mRequestSequence;
  private byte[] mResult;
  private int mTaskId;
  public String msg;
  private String sid;
  
  public UploadResponse.DecodeResult decode(byte[] paramArrayOfByte)
  {
    PduHeader localPduHeader = PDUtil.decodeHeader(paramArrayOfByte);
    if (localPduHeader == null)
    {
      PDUtil.printHexString("----------recv header:", paramArrayOfByte);
      return UploadResponse.DecodeResult.DECODE_PDU_HEADER_ERROR;
    }
    paramArrayOfByte = PDUtil.decodeJce(paramArrayOfByte);
    if (paramArrayOfByte == null) {
      return UploadResponse.DecodeResult.DECODE_PDU_JCE_ERROR;
    }
    if ((localPduHeader.cmd != 1) && (localPduHeader.cmd != 2) && (localPduHeader.cmd != 3)) {
      return UploadResponse.DecodeResult.UNKNOWN_CMD_ERROR;
    }
    this.mCmd = localPduHeader.cmd;
    this.mRequestSequence = localPduHeader.seq;
    this.mResult = paramArrayOfByte;
    return UploadResponse.DecodeResult.SUCCEED;
  }
  
  public int getCmd()
  {
    return this.mCmd;
  }
  
  public byte[] getReponseData()
  {
    return this.mResult;
  }
  
  public int getRequestSequence()
  {
    return this.mRequestSequence;
  }
  
  public String getSid()
  {
    return this.sid;
  }
  
  public int getTaskId()
  {
    return this.mTaskId;
  }
  
  public void setRequestSequence(int paramInt)
  {
    this.mRequestSequence = paramInt;
  }
  
  public void setSid(String paramString)
  {
    this.sid = paramString;
  }
  
  public void setTaskId(int paramInt)
  {
    this.mTaskId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.request.UploadResponse
 * JD-Core Version:    0.7.0.1
 */