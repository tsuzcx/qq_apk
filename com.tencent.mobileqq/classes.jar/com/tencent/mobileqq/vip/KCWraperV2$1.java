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
    long l = IOUtil.getCRC32Value(this.jdField_a_of_type_JavaIoFile);
    ??? = this.this$0.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryLoad ");
    localStringBuilder.append(this.jdField_a_of_type_JavaIoFile.getName());
    localStringBuilder.append(" crc32: ");
    localStringBuilder.append(Long.toHexString(l));
    QLog.d((String)???, 1, localStringBuilder.toString());
    QLog.flushLog();
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
      boolean bool1;
      if (TMSManager.a(this.jdField_a_of_type_AndroidContentContext))
      {
        boolean bool2 = KcSdkShellManager.getInstance().initInBaseProcess(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), "00047", "ck_shoujiqq_dfhdsuif5f6d_f4d89e");
        QLog.e(this.this$0.a(), 1, "initInBaseProcess");
        bool1 = bool2;
        if (KcSdkShellManager.getInstance().getKingCardInterface() != null)
        {
          KcSdkShellManager.getInstance().getKingCardInterface().registerOnChangeListener(new KCWraperV2.KingCardListener());
          bool1 = bool2;
        }
      }
      else
      {
        QLog.w(this.this$0.a(), 1, "only load in main process!");
        bool1 = false;
      }
      if (!bool1)
      {
        QLog.e(this.this$0.a(), 1, "tryLoad failed");
        KCWraper.a(false);
      }
      else
      {
        this.this$0.a.set(true);
        KCWraper.a(true);
      }
      this.this$0.a.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KCWraperV2.1
 * JD-Core Version:    0.7.0.1
 */