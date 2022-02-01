package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.qrscan.api.IQRScanEarlyHandlerApi;
import com.tencent.mobileqq.qrscan.earlydown.ChirpSoHandler;
import com.tencent.mobileqq.qrscan.earlydown.MiniScanDecodeSoDownloadHandler;
import com.tencent.mobileqq.qrscan.earlydown.MiniScanDetectModelsDownloadHandler;
import com.tencent.mobileqq.qrscan.earlydown.MiniScanDetectSoDownloadHandler;
import com.tencent.mobileqq.qrscan.earlydown.QBarModelDownloadHandler;
import mqq.app.AppRuntime;

public class QRScanEarlyHandlerApiImpl
  implements IQRScanEarlyHandlerApi
{
  public EarlyHandler getHandler(int paramInt, AppRuntime paramAppRuntime)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return null;
            }
            return new ChirpSoHandler(paramAppRuntime);
          }
          return new QBarModelDownloadHandler(paramAppRuntime);
        }
        return new MiniScanDetectModelsDownloadHandler(paramAppRuntime);
      }
      return new MiniScanDetectSoDownloadHandler(paramAppRuntime);
    }
    return new MiniScanDecodeSoDownloadHandler(paramAppRuntime);
  }
  
  public String getResName(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return null;
            }
            return "qq.android.system.chirp";
          }
          return "qq.android.qbarnative.model_v8.6.0";
        }
        return "qq.android.minidetect.model_v8.6.0";
      }
      return "qq.android.minidetect.so_v8.6.0";
    }
    return "qq.android.minidecode.so_v8.2.0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.QRScanEarlyHandlerApiImpl
 * JD-Core Version:    0.7.0.1
 */