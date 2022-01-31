package com.tencent.upload.uinterface.data;

import SLICE_UPLOAD.FileControlRsp;
import com.tencent.upload.uinterface.AbstractUploadResult;
import java.util.HashMap;
import java.util.Map;

public class BatchControlResult
  extends AbstractUploadResult
{
  Map<String, FileControlRsp> mMap = new HashMap();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.data.BatchControlResult
 * JD-Core Version:    0.7.0.1
 */