package com.tencent.mobileqq.transfile.quic.open;

import com.tencent.mobileqq.transfile.quic.internal.Utils;
import com.tencent.qphone.base.util.QLog;

public class QuicNetFactory
{
  private static final byte[] INSTANCE_LOCK = new byte[0];
  private static volatile QuicNetFactory mInstance;
  private QuicDownloaderImpl sQuicDownloader = new QuicDownloaderImpl();
  
  public static QuicNetFactory getInstance()
  {
    if (mInstance == null) {}
    synchronized (INSTANCE_LOCK)
    {
      if (mInstance == null) {
        mInstance = new QuicNetFactory();
      }
      return mInstance;
    }
  }
  
  public QuicDownloader createQuicDownloader()
  {
    if (Utils.checkIfCPUx86()) {
      QLog.e("quic", 4, "the phone cpu is x86");
    }
    while (QuicDownloader.initError()) {
      return null;
    }
    return this.sQuicDownloader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.open.QuicNetFactory
 * JD-Core Version:    0.7.0.1
 */