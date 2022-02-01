package com.tencent.upload.request.impl;

import SLICE_UPLOAD.FileBatchControlReq;
import SLICE_UPLOAD.FileControlReq;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.request.UploadRequest;
import java.util.Map;

public class BatchControlRequest
  extends UploadRequest
{
  Map<String, FileControlReq> mMap;
  
  public BatchControlRequest(Map<String, FileControlReq> paramMap)
  {
    this.mMap = paramMap;
  }
  
  public JceStruct createJceRequest()
  {
    return new FileBatchControlReq(this.mMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.request.impl.BatchControlRequest
 * JD-Core Version:    0.7.0.1
 */