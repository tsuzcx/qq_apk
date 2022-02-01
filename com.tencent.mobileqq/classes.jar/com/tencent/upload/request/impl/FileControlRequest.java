package com.tencent.upload.request.impl;

import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.DumpBussinessReq;
import SLICE_UPLOAD.FileControlReq;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.stEnvironment;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.request.UploadRequest;
import java.util.Map;

public class FileControlRequest
  extends UploadRequest
{
  private String mAppid;
  private int mAsyUpload;
  private byte[] mBizReq;
  private CheckType mCheckType;
  private String mChecksum;
  private Map<Integer, DumpBussinessReq> mDumpReq;
  private long mFileLength;
  private UploadModel mModel;
  private boolean mNeedCheck;
  private boolean mNeedIpRedirect;
  private String mSession;
  private stEnvironment mStEnv;
  private AuthToken mToken;
  private String mUin;
  
  public FileControlRequest(String paramString1, String paramString2, AuthToken paramAuthToken, String paramString3, CheckType paramCheckType, long paramLong, stEnvironment paramstEnvironment, UploadModel paramUploadModel, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt, Map<Integer, DumpBussinessReq> paramMap)
  {
    this.mUin = paramString1;
    this.mAppid = paramString2;
    this.mToken = paramAuthToken;
    this.mChecksum = paramString3;
    this.mCheckType = paramCheckType;
    this.mFileLength = paramLong;
    this.mStEnv = paramstEnvironment;
    this.mModel = paramUploadModel;
    this.mSession = paramString4;
    this.mNeedIpRedirect = paramBoolean1;
    this.mNeedCheck = paramBoolean2;
    this.mAsyUpload = paramInt;
    this.mDumpReq = paramMap;
  }
  
  public JceStruct createJceRequest()
  {
    FileControlReq localFileControlReq = new FileControlReq();
    localFileControlReq.uin = this.mUin;
    localFileControlReq.appid = this.mAppid;
    localFileControlReq.token = this.mToken;
    localFileControlReq.file_len = this.mFileLength;
    localFileControlReq.env = this.mStEnv;
    localFileControlReq.model = this.mModel.value();
    localFileControlReq.biz_req = this.mBizReq;
    localFileControlReq.session = this.mSession;
    localFileControlReq.need_ip_redirect = this.mNeedIpRedirect;
    localFileControlReq.check_type = this.mCheckType.value();
    localFileControlReq.checksum = this.mChecksum;
    if (this.mNeedCheck) {
      localFileControlReq.check_type = this.mCheckType.value();
    }
    localFileControlReq.asy_upload = this.mAsyUpload;
    localFileControlReq.dumpReq = this.mDumpReq;
    return localFileControlReq;
  }
  
  public long getFileDataLength()
  {
    return this.mFileLength;
  }
  
  public void setExtraParam(byte[] paramArrayOfByte)
  {
    this.mBizReq = paramArrayOfByte;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskId=").append(getTaskId()).append(" reqId=").append(getRequestId()).append(" cmd=").append(getCmdId()).append(" mUin=").append(this.mUin).append(" mAppid=").append(this.mAppid).append(" mChecksum=").append(this.mChecksum).append(" mCheckType=").append(this.mCheckType).append(" mFileLength=").append(this.mFileLength).append(" mModel=").append(this.mModel).append(" mSession=").append(this.mSession).append(" mNeedIpRedirect=").append(this.mNeedIpRedirect);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.request.impl.FileControlRequest
 * JD-Core Version:    0.7.0.1
 */