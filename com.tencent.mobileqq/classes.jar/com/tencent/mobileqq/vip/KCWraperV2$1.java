package com.tencent.mobileqq.vip;

import android.content.Context;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.qphone.base.util.QLog;
import dualsim.common.IKingCardInterface;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import tmsdk.common.KcSdkShellManager;

class KCWraperV2$1
  implements Runnable
{
  KCWraperV2$1(KCWraperV2 paramKCWraperV2, File paramFile, Context paramContext) {}
  
  public void run()
  {
    int i = 0;
    long l = IOUtil.getCRC32Value(this.jdField_a_of_type_JavaIoFile);
    QLog.d(this.this$0.a(), 1, "tryLoad " + this.jdField_a_of_type_JavaIoFile.getName() + " crc32: " + Long.toHexString(l));
    QLog.flushLog();
    for (;;)
    {
      synchronized (this.this$0.a)
      {
        if (this.this$0.a.get()) {
          return;
        }
        if (QLog.isColorLevel()) {
          KcSdkShellManager.getInstance().setLogPrint(new KCWraperV2.1.1(this));
        }
        KcSdkShellManager.getInstance().setTMSDKLogEnable(QLog.isColorLevel());
        KcSdkShellManager.getInstance().setPhoneInfoBridge(new KCWraperV2.1.2(this));
        if (TMSManager.a(this.jdField_a_of_type_AndroidContentContext))
        {
          boolean bool = KcSdkShellManager.getInstance().initInBaseProcess(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), "00047", "ck_shoujiqq_dfhdsuif5f6d_f4d89e");
          QLog.e(this.this$0.a(), 1, "initInBaseProcess");
          i = bool;
          if (KcSdkShellManager.getInstance().getKingCardInterface() != null)
          {
            KcSdkShellManager.getInstance().getKingCardInterface().registerOnChangeListener(new KCWraperV2.KingCardListener());
            i = bool;
          }
          if (i != 0) {
            break label268;
          }
          QLog.e(this.this$0.a(), 1, "tryLoad failed");
          KCWraper.a(false);
          this.this$0.a.notify();
          return;
        }
      }
      QLog.w(this.this$0.a(), 1, "only load in main process!");
      continue;
      label268:
      this.this$0.a.set(true);
      KCWraper.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KCWraperV2.1
 * JD-Core Version:    0.7.0.1
 */