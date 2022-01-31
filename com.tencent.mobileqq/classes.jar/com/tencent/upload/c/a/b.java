package com.tencent.upload.c.a;

import SLICE_UPLOAD.FileBatchControlReq;
import SLICE_UPLOAD.FileControlReq;
import com.qq.taf.jce.JceStruct;
import java.util.Map;

public class b
  extends com.tencent.upload.c.b
{
  Map<String, FileControlReq> b;
  
  public b(Map<String, FileControlReq> paramMap)
  {
    this.b = paramMap;
  }
  
  public JceStruct h()
  {
    return new FileBatchControlReq(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.c.a.b
 * JD-Core Version:    0.7.0.1
 */