package com.tencent.mobileqq.filemanager.app;

public class FileTransferHandler$PreviewBusiData
{
  private Object b;
  private int c;
  private boolean d;
  private long e;
  private int f;
  private FileTransferObserver g;
  private String h;
  private byte[] i;
  private byte[] j;
  private byte[] k;
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler)
  {
    a(false, 0L, null, null, 0);
  }
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler, long paramLong, FileTransferObserver paramFileTransferObserver)
  {
    a(false, paramLong, null, paramFileTransferObserver, 0);
  }
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler, FileTransferObserver paramFileTransferObserver)
  {
    a(false, 0L, null, paramFileTransferObserver, 0);
  }
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler, String paramString)
  {
    a(false, 0L, paramString, null, 0);
  }
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler, boolean paramBoolean, long paramLong)
  {
    a(paramBoolean, paramLong, null, null, 0);
  }
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler, boolean paramBoolean, long paramLong, FileTransferObserver paramFileTransferObserver, int paramInt)
  {
    a(paramBoolean, paramLong, null, paramFileTransferObserver, paramInt);
  }
  
  FileTransferHandler$PreviewBusiData(FileTransferHandler paramFileTransferHandler, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, FileTransferObserver paramFileTransferObserver)
  {
    a(false, 0L, null, paramFileTransferObserver, 0);
    this.i = paramArrayOfByte1;
    this.j = paramArrayOfByte2;
    this.k = paramArrayOfByte3;
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, FileTransferObserver paramFileTransferObserver, int paramInt)
  {
    this.c = 0;
    this.d = paramBoolean;
    this.e = paramLong;
    this.f = paramInt;
    this.h = paramString;
    this.g = paramFileTransferObserver;
    this.b = null;
  }
  
  boolean a()
  {
    return this.d;
  }
  
  Object b()
  {
    return this.b;
  }
  
  long c()
  {
    return this.e;
  }
  
  int d()
  {
    return this.f;
  }
  
  FileTransferObserver e()
  {
    return this.g;
  }
  
  String f()
  {
    return this.h;
  }
  
  int g()
  {
    return this.c;
  }
  
  void h()
  {
    this.c += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.PreviewBusiData
 * JD-Core Version:    0.7.0.1
 */