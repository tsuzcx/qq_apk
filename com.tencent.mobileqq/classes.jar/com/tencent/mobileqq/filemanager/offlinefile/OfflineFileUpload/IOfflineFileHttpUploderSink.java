package com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload;

import com.tencent.mobileqq.transfile.NetResp;

public abstract interface IOfflineFileHttpUploderSink
{
  public abstract long a(NetResp paramNetResp);
  
  public abstract void a();
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract byte[] a(byte[] paramArrayOfByte, long paramLong);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.IOfflineFileHttpUploderSink
 * JD-Core Version:    0.7.0.1
 */