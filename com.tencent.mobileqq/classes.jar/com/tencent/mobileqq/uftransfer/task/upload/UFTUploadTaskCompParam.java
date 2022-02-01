package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;

public class UFTUploadTaskCompParam
{
  public final int h;
  public final String i;
  public String j = "";
  public Object k;
  public boolean l = false;
  public long m = 0L;
  public long n = 0L;
  
  public UFTUploadTaskCompParam(int paramInt, String paramString)
  {
    this.h = paramInt;
    this.i = paramString;
  }
  
  public UFTUploadTaskCompParam(int paramInt, String paramString1, String paramString2, boolean paramBoolean, Object paramObject)
  {
    this.h = paramInt;
    this.i = paramString1;
    this.j = paramString2;
    this.k = paramObject;
    this.l = paramBoolean;
  }
  
  public ExcitingTransferUploaderRp a()
  {
    Object localObject = this.k;
    if ((localObject != null) && ((localObject instanceof ExcitingTransferUploaderRp))) {
      return (ExcitingTransferUploaderRp)localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.upload.UFTUploadTaskCompParam
 * JD-Core Version:    0.7.0.1
 */