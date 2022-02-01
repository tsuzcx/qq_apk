package com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;

public abstract interface IExtfUploaderSink
{
  public abstract void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp);
  
  public abstract void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp);
  
  public abstract void a(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void ar_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.IExtfUploaderSink
 * JD-Core Version:    0.7.0.1
 */