package com.tencent.mobileqq.filemanager.core;

import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdHexUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.turingfd.sdk.xq.IteApkInfoReq;
import com.tencent.turingfd.sdk.xq.IteApkInfoReq.Builder;
import com.tencent.turingfd.sdk.xq.TuringFdService;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;

class MMApkFileSafeChecker$CheckTask
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  MMApkFileSafeChecker.FileBusiInfo jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo;
  MMApkFileSafeChecker.ISafeCheckerProxy jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$ISafeCheckerProxy;
  String jdField_a_of_type_JavaLangString;
  Set<MMApkFileSafeChecker.ICheckResult> jdField_a_of_type_JavaUtilSet = new HashSet();
  Timer jdField_a_of_type_JavaUtilTimer;
  volatile boolean jdField_a_of_type_Boolean = true;
  Signature[] jdField_a_of_type_ArrayOfAndroidContentPmSignature;
  String b;
  String c;
  
  MMApkFileSafeChecker$CheckTask(MMApkFileSafeChecker paramMMApkFileSafeChecker, String paramString1, String paramString2, Signature[] paramArrayOfSignature, long paramLong, MMApkFileSafeChecker.FileBusiInfo paramFileBusiInfo, MMApkFileSafeChecker.ISafeCheckerProxy paramISafeCheckerProxy)
  {
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = FileManagerUtil.a(paramString1);
    this.c = paramString2;
    this.jdField_a_of_type_ArrayOfAndroidContentPmSignature = paramArrayOfSignature;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo = paramFileBusiInfo;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$ISafeCheckerProxy = paramISafeCheckerProxy;
    int i = MMApkFileSafeChecker.jdField_a_of_type_Int;
    MMApkFileSafeChecker.jdField_a_of_type_Int = i + 1;
    this.jdField_a_of_type_Int = i;
  }
  
  void a()
  {
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.jdField_a_of_type_Int + "> start check task. filePath:" + this.b);
    this.jdField_a_of_type_Boolean = false;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.f)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.g)))
    {
      b();
      return;
    }
    long l = System.currentTimeMillis();
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.jdField_a_of_type_Int + "> to get digest of file");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$ISafeCheckerProxy.a(this.b, new MMApkFileSafeChecker.CheckTask.1(this, l));
  }
  
  void a(int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.jdField_a_of_type_Int + "> task complete. errCode:" + paramInt1 + " safeLevel:" + paramInt2 + " tipString:" + paramString1 + " jumpDetailUrl:" + paramString2);
      this.jdField_a_of_type_Boolean = true;
      e();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext()) {
        ((MMApkFileSafeChecker.ICheckResult)localIterator.next()).a(paramInt1, paramInt2, paramString1, paramString2, paramBundle);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$ISafeCheckerProxy == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$ISafeCheckerProxy.a(this.b, null);
  }
  
  void a(MMApkFileSafeChecker.ICheckResult paramICheckResult)
  {
    if (paramICheckResult != null) {
      this.jdField_a_of_type_JavaUtilSet.add(paramICheckResult);
    }
  }
  
  void b()
  {
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if (this.jdField_a_of_type_ArrayOfAndroidContentPmSignature != null)
    {
      localObject1 = localObject3;
      if (this.jdField_a_of_type_ArrayOfAndroidContentPmSignature.length <= 0) {}
    }
    try
    {
      localObject1 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject1).update(this.jdField_a_of_type_ArrayOfAndroidContentPmSignature[0].toByteArray());
      localObject1 = AdHexUtil.bytes2HexString(((MessageDigest)localObject1).digest());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "")
      {
        localObject3 = new HashMap();
        localBuilder = IteApkInfoReq.newBuilder().pkgName(this.c).certMd5((String)localObject1).fileName(this.jdField_a_of_type_JavaLangString).fileSize(this.jdField_a_of_type_Long).fileMd5(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.f).fileSha1(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.g).localQQ("");
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.jdField_a_of_type_Int != 1) {
          break;
        }
        localBuilder.chattingQQ(new ArrayList());
        QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.jdField_a_of_type_Int + "> run check task. fileName:" + this.jdField_a_of_type_JavaLangString + " pkgName:" + this.c + " fileSize:" + this.jdField_a_of_type_Long + " pkgSignMd5:" + (String)localObject1 + " " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.toString());
        localObject1 = localBuilder.build();
        ((Map)localObject3).put(Integer.valueOf(this.jdField_a_of_type_Int), localObject1);
        TuringFdService.checkApk((Map)localObject3, new MMApkFileSafeChecker.CheckTask.2(this));
        d();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        IteApkInfoReq.Builder localBuilder;
        QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.jdField_a_of_type_Int + "> sign md5 calc err");
        Object localObject2 = localObject3;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.jdField_a_of_type_Int == 2) {
          localBuilder.chattingRoomQQ(new ArrayList());
        }
      }
    }
  }
  
  void c()
  {
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.jdField_a_of_type_Int + "> stop task");
    this.jdField_a_of_type_Boolean = true;
    e();
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  /* Error */
  void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 293	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$CheckTask:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: ldc 59
    //   16: iconst_1
    //   17: new 61	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   24: ldc 64
    //   26: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 56	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$CheckTask:jdField_a_of_type_Int	I
    //   33: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: ldc_w 295
    //   39: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 83	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: new 297	java/util/Timer
    //   52: dup
    //   53: invokespecial 298	java/util/Timer:<init>	()V
    //   56: putfield 293	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$CheckTask:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   59: aload_0
    //   60: getfield 293	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$CheckTask:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   63: new 300	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$CheckTask$3
    //   66: dup
    //   67: aload_0
    //   68: invokespecial 301	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$CheckTask$3:<init>	(Lcom/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$CheckTask;)V
    //   71: ldc2_w 302
    //   74: invokevirtual 307	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   77: goto -66 -> 11
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	CheckTask
    //   6	2	1	localTimer	Timer
    //   80	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	80	finally
    //   14	77	80	finally
  }
  
  void e()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask
 * JD-Core Version:    0.7.0.1
 */