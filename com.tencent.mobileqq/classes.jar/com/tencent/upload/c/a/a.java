package com.tencent.upload.c.a;

import SLICE_UPLOAD.FileBatchCommitReq;
import SLICE_UPLOAD.FileCommitReq;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.c.b;
import java.util.Map;

public class a
  extends b
{
  public Map<String, FileCommitReq> b;
  
  public a(FileBatchCommitReq paramFileBatchCommitReq, int paramInt)
  {
    super(paramInt);
    this.b = paramFileBatchCommitReq.commit_req;
  }
  
  public int d()
  {
    return 3;
  }
  
  public JceStruct h()
  {
    return new FileBatchCommitReq(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.c.a.a
 * JD-Core Version:    0.7.0.1
 */