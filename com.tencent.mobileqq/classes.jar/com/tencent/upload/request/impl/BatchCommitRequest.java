package com.tencent.upload.request.impl;

import SLICE_UPLOAD.FileBatchCommitReq;
import SLICE_UPLOAD.FileCommitReq;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.request.UploadRequest;
import java.util.Map;

public class BatchCommitRequest
  extends UploadRequest
{
  public Map<String, FileCommitReq> mMap;
  
  public BatchCommitRequest(FileBatchCommitReq paramFileBatchCommitReq, int paramInt)
  {
    super(paramInt);
    this.mMap = paramFileBatchCommitReq.commit_req;
  }
  
  public BatchCommitRequest(Map<String, FileCommitReq> paramMap)
  {
    this.mMap = paramMap;
  }
  
  public JceStruct createJceRequest()
  {
    return new FileBatchCommitReq(this.mMap);
  }
  
  public int getCmdId()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.request.impl.BatchCommitRequest
 * JD-Core Version:    0.7.0.1
 */