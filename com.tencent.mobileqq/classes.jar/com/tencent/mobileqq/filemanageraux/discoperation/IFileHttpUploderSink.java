package com.tencent.mobileqq.filemanageraux.discoperation;

import com.tencent.mobileqq.transfile.NetResp;

public abstract interface IFileHttpUploderSink
{
  public abstract long a(NetResp paramNetResp, FileReportData paramFileReportData);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(FileReportData paramFileReportData);
  
  public abstract void a(boolean paramBoolean, FileReportData paramFileReportData);
  
  public abstract byte[] a(byte[] paramArrayOfByte, long paramLong, FileReportData paramFileReportData);
  
  public abstract void b(FileReportData paramFileReportData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.discoperation.IFileHttpUploderSink
 * JD-Core Version:    0.7.0.1
 */