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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MMApkCheck] <");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("> start check task. filePath:");
    localStringBuilder.append(this.b);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = false;
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.f)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.g)))
    {
      long l = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MMApkCheck] <");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("> to get digest of file");
      QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$ISafeCheckerProxy.a(this.b, new MMApkFileSafeChecker.CheckTask.1(this, l));
      return;
    }
    b();
  }
  
  void a(int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MMApkCheck] <");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("> task complete. errCode:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" safeLevel:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" tipString:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" jumpDetailUrl:");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_Boolean = true;
    e();
    localObject = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((MMApkFileSafeChecker.ICheckResult)((Iterator)localObject).next()).a(paramInt1, paramInt2, paramString1, paramString2, paramBundle);
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$ISafeCheckerProxy;
    if (paramString1 != null) {
      paramString1.a(this.b, null);
    }
  }
  
  void a(MMApkFileSafeChecker.ICheckResult paramICheckResult)
  {
    if (paramICheckResult != null) {
      this.jdField_a_of_type_JavaUtilSet.add(paramICheckResult);
    }
  }
  
  void b()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidContentPmSignature;
    if ((localObject != null) && (localObject.length > 0)) {}
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(this.jdField_a_of_type_ArrayOfAndroidContentPmSignature[0].toByteArray());
      localObject = AdHexUtil.bytes2HexString(((MessageDigest)localObject).digest());
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label97;
      }
      localObject = ((String)localObject).toUpperCase();
    }
    catch (Exception localException)
    {
      label56:
      HashMap localHashMap;
      IteApkInfoReq.Builder localBuilder;
      StringBuilder localStringBuilder;
      break label56;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MMApkCheck] <");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("> sign md5 calc err");
    QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    label97:
    localObject = "";
    localHashMap = new HashMap();
    localBuilder = IteApkInfoReq.newBuilder().pkgName(this.c).certMd5((String)localObject).fileName(this.jdField_a_of_type_JavaLangString).fileSize(this.jdField_a_of_type_Long).fileMd5(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.f).fileSha1(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.g).localQQ("");
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.jdField_a_of_type_Int == 1) {
      localBuilder.chattingQQ(new ArrayList());
    } else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.jdField_a_of_type_Int == 2) {
      localBuilder.chattingRoomQQ(new ArrayList());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MMApkCheck] <");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("> run check task. fileName:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" pkgName:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" fileSize:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" pkgSignMd5:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreMMApkFileSafeChecker$FileBusiInfo.toString());
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
    localObject = localBuilder.build();
    localHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), localObject);
    TuringFdService.checkApk(localHashMap, new MMApkFileSafeChecker.CheckTask.2(this));
    d();
  }
  
  void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MMApkCheck] <");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("> stop task");
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = true;
    e();
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  void d()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilTimer;
      if (localObject1 != null) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[MMApkCheck] <");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append("> setTimeoutTimer");
      QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new MMApkFileSafeChecker.CheckTask.3(this), 40000L);
      return;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask
 * JD-Core Version:    0.7.0.1
 */