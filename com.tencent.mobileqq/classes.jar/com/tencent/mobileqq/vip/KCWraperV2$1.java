package com.tencent.mobileqq.vip;

import android.content.Context;
import bhyw;
import bhyx;
import bhyy;
import bhyz;
import bhza;
import bhzh;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.qphone.base.util.QLog;
import dualsim.common.IKingCardInterface;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import tmsdk.common.KcSdkShellManager;

public class KCWraperV2$1
  implements Runnable
{
  public KCWraperV2$1(bhyx parambhyx, File paramFile, Context paramContext) {}
  
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
          KcSdkShellManager.getInstance().setLogPrint(new bhyy(this));
        }
        KcSdkShellManager.getInstance().setTMSDKLogEnable(QLog.isColorLevel());
        KcSdkShellManager.getInstance().setPhoneInfoBridge(new bhyz(this));
        if (bhzh.a(this.jdField_a_of_type_AndroidContentContext))
        {
          boolean bool = KcSdkShellManager.getInstance().initInBaseProcess(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), "00047", "ck_shoujiqq_dfhdsuif5f6d_f4d89e");
          QLog.e(this.this$0.a(), 1, "initInBaseProcess");
          i = bool;
          if (KcSdkShellManager.getInstance().getKingCardInterface() != null)
          {
            KcSdkShellManager.getInstance().getKingCardInterface().registerOnChangeListener(new bhza());
            i = bool;
          }
          if (i != 0) {
            break label268;
          }
          QLog.e(this.this$0.a(), 1, "tryLoad failed");
          bhyw.a(false);
          this.this$0.a.notify();
          return;
        }
      }
      QLog.w(this.this$0.a(), 1, "only load in main process!");
      continue;
      label268:
      this.this$0.a.set(true);
      bhyw.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KCWraperV2.1
 * JD-Core Version:    0.7.0.1
 */