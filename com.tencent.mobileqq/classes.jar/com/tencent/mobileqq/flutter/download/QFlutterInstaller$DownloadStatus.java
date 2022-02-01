package com.tencent.mobileqq.flutter.download;

class QFlutterInstaller$DownloadStatus
{
  public int a = 1;
  public boolean b = false;
  private long c = 0L;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  private boolean g = false;
  
  public void a()
  {
    this.a = 1;
    this.b = false;
    this.c = 0L;
    this.d = 0L;
    this.g = false;
    this.e = System.currentTimeMillis();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramBoolean1;
    this.a = 2;
    this.g = paramBoolean2;
    this.f = (System.currentTimeMillis() - this.e);
  }
  
  public boolean b()
  {
    return this.a == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.download.QFlutterInstaller.DownloadStatus
 * JD-Core Version:    0.7.0.1
 */