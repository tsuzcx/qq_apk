package com.tencent.qapmsdk.socket.handler;

public class FirstPackageOutputFactory
  implements ITrafficOutputStreamHandlerFactory
{
  private FirstPackageOutputFactory.FirstPackageOutputMonitor firstPackageOutputMonitor = new FirstPackageOutputFactory.FirstPackageOutputMonitor(this, null);
  
  public ITrafficOutputStreamHandler create()
  {
    if (this.firstPackageOutputMonitor == null) {
      this.firstPackageOutputMonitor = new FirstPackageOutputFactory.FirstPackageOutputMonitor(this, null);
    }
    return this.firstPackageOutputMonitor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.FirstPackageOutputFactory
 * JD-Core Version:    0.7.0.1
 */