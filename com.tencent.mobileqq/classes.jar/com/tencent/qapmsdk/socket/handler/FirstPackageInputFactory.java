package com.tencent.qapmsdk.socket.handler;

public class FirstPackageInputFactory
  implements ITrafficInputStreamHandlerFactory
{
  private FirstPackageInputFactory.FirstPackageInputMonitor firstPackageInputMonitor = new FirstPackageInputFactory.FirstPackageInputMonitor(this, null);
  
  public ITrafficInputStreamHandler create()
  {
    if (this.firstPackageInputMonitor == null) {
      this.firstPackageInputMonitor = new FirstPackageInputFactory.FirstPackageInputMonitor(this, null);
    }
    return this.firstPackageInputMonitor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.FirstPackageInputFactory
 * JD-Core Version:    0.7.0.1
 */