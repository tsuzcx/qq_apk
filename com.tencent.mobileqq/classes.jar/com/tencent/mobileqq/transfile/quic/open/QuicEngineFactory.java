package com.tencent.mobileqq.transfile.quic.open;

import com.tencent.mobileqq.transfile.quic.internal.LoadSoImp;
import com.tencent.mobileqq.transfile.quic.internal.QuicEngineImp;
import com.tencent.mobileqq.transfile.quic.internal.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class QuicEngineFactory
{
  private static volatile IQuicEngine sQuicEngine;
  
  private static boolean checkSoDownloaded()
  {
    return (FileUtils.fileExists(Utils.getAndromedaSoPath())) && (FileUtils.fileExists(Utils.getQuicEngineSoPath()));
  }
  
  public static IQuicEngine createEngine()
  {
    if (Utils.checkIfCPUx86())
    {
      QLog.e("quic", 4, "the phone cpu is x86");
      return null;
    }
    if (!checkSoDownloaded())
    {
      QLog.e("quic", 4, "so not downloaded ！");
      return null;
    }
    if (sQuicEngine == null) {
      try
      {
        if (sQuicEngine == null) {
          sQuicEngine = new QuicEngineImp(new LoadSoImp());
        }
      }
      finally {}
    }
    return sQuicEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.open.QuicEngineFactory
 * JD-Core Version:    0.7.0.1
 */