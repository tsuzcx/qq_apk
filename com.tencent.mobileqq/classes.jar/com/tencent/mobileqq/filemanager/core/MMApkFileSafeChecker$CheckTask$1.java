package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;

class MMApkFileSafeChecker$CheckTask$1
  implements MMApkFileSafeChecker.IGetDigestResult
{
  MMApkFileSafeChecker$CheckTask$1(MMApkFileSafeChecker.CheckTask paramCheckTask, long paramLong) {}
  
  public void a(boolean paramBoolean, MMApkFileSafeChecker.FileDigestInfo paramFileDigestInfo)
  {
    if (this.b.j) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.a;
    if (paramBoolean)
    {
      this.b.c.g = HexUtil.bytes2HexStr(paramFileDigestInfo.a);
      this.b.c.h = HexUtil.bytes2HexStr(paramFileDigestInfo.b);
    }
    paramFileDigestInfo = new StringBuilder();
    paramFileDigestInfo.append("[MMApkCheck] <");
    paramFileDigestInfo.append(this.b.k);
    paramFileDigestInfo.append("> on get digest result:");
    paramFileDigestInfo.append(paramBoolean);
    paramFileDigestInfo.append(" cost:");
    paramFileDigestInfo.append(l1 - l2);
    paramFileDigestInfo.append(" fileMd5:");
    paramFileDigestInfo.append(this.b.c.g);
    paramFileDigestInfo.append(" fileSha:");
    paramFileDigestInfo.append(this.b.c.h);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, paramFileDigestInfo.toString());
    new Handler(Looper.getMainLooper()).post(new MMApkFileSafeChecker.CheckTask.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.1
 * JD-Core Version:    0.7.0.1
 */