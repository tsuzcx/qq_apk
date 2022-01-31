package com.tencent.msfmqpsdkbridge;

import com.tencent.mqpsdk.secsrv.MQPEmuDetectService.IEmuDetectResultListener;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class MSFEmuDetectWrapper
  implements MQPEmuDetectService.IEmuDetectResultListener
{
  public static boolean a()
  {
    boolean bool = true;
    File localFile = new File(BaseApplication.getContext().getFilesDir(), "QPfile");
    if (localFile.exists()) {
      bool = localFile.delete();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFEmuDetectWrapper
 * JD-Core Version:    0.7.0.1
 */