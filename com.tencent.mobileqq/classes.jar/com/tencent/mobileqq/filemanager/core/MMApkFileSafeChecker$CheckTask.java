package com.tencent.mobileqq.filemanager.core;

import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdHexUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.turingfd.sdk.xq.IteApkInfoReq;
import com.tencent.turingfd.sdk.xq.IteApkInfoReq.Builder;
import com.tencent.turingfd.sdk.xq.TuringSecurityService;
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
  String a;
  String b;
  MMApkFileSafeChecker.FileBusiInfo c;
  long d;
  String e;
  Signature[] f;
  Set<MMApkFileSafeChecker.ICheckResult> g = new HashSet();
  MMApkFileSafeChecker.ISafeCheckerProxy h;
  Timer i;
  volatile boolean j = true;
  int k;
  
  MMApkFileSafeChecker$CheckTask(MMApkFileSafeChecker paramMMApkFileSafeChecker, String paramString1, String paramString2, Signature[] paramArrayOfSignature, long paramLong, MMApkFileSafeChecker.FileBusiInfo paramFileBusiInfo, MMApkFileSafeChecker.ISafeCheckerProxy paramISafeCheckerProxy)
  {
    this.b = paramString1;
    this.a = FileManagerUtil.a(paramString1);
    this.e = paramString2;
    this.f = paramArrayOfSignature;
    this.d = paramLong;
    this.c = paramFileBusiInfo;
    this.h = paramISafeCheckerProxy;
    int m = MMApkFileSafeChecker.a;
    MMApkFileSafeChecker.a = m + 1;
    this.k = m;
  }
  
  void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MMApkCheck] <");
    localStringBuilder.append(this.k);
    localStringBuilder.append("> start check task. filePath:");
    localStringBuilder.append(this.b);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
    this.j = false;
    if ((TextUtils.isEmpty(this.c.g)) && (TextUtils.isEmpty(this.c.h)))
    {
      long l1 = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[MMApkCheck] <");
      localStringBuilder.append(this.k);
      localStringBuilder.append("> to get digest of file");
      QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
      this.h.a(this.b, new MMApkFileSafeChecker.CheckTask.1(this, l1));
      return;
    }
    b();
  }
  
  void a(int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (this.j) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[MMApkCheck] <");
    ((StringBuilder)localObject).append(this.k);
    ((StringBuilder)localObject).append("> task complete. errCode:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" safeLevel:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" tipString:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" jumpDetailUrl:");
    ((StringBuilder)localObject).append(paramString2);
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    this.j = true;
    e();
    localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((MMApkFileSafeChecker.ICheckResult)((Iterator)localObject).next()).a(paramInt1, paramInt2, paramString1, paramString2, paramBundle);
    }
    paramString1 = this.h;
    if (paramString1 != null) {
      paramString1.a(this.b, null);
    }
  }
  
  void a(MMApkFileSafeChecker.ICheckResult paramICheckResult)
  {
    if (paramICheckResult != null) {
      this.g.add(paramICheckResult);
    }
  }
  
  void b()
  {
    Object localObject = this.f;
    if ((localObject != null) && (localObject.length > 0)) {}
    try
    {
      localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(this.f[0].toByteArray());
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
    ((StringBuilder)localObject).append(this.k);
    ((StringBuilder)localObject).append("> sign md5 calc err");
    QLog.e("MMApkFileSafeChecker<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    label97:
    localObject = "";
    localHashMap = new HashMap();
    localBuilder = IteApkInfoReq.newBuilder().pkgName(this.e).certMd5((String)localObject).fileName(this.a).fileSize(this.d).fileMd5(this.c.g).fileSha1(this.c.h).localQQ("");
    if (this.c.a == 1) {
      localBuilder.chattingQQ(new ArrayList());
    } else if (this.c.a == 2) {
      localBuilder.chattingRoomQQ(new ArrayList());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MMApkCheck] <");
    localStringBuilder.append(this.k);
    localStringBuilder.append("> run check task. fileName:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" pkgName:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" fileSize:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" pkgSignMd5:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.c.toString());
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
    localObject = localBuilder.build();
    localHashMap.put(Integer.valueOf(this.k), localObject);
    TuringSecurityService.a(localHashMap, new MMApkFileSafeChecker.CheckTask.2(this));
    d();
  }
  
  void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MMApkCheck] <");
    localStringBuilder.append(this.k);
    localStringBuilder.append("> stop task");
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
    this.j = true;
    e();
    this.g.clear();
  }
  
  void d()
  {
    try
    {
      Object localObject1 = this.i;
      if (localObject1 != null) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[MMApkCheck] <");
      ((StringBuilder)localObject1).append(this.k);
      ((StringBuilder)localObject1).append("> setTimeoutTimer");
      QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      this.i = new Timer();
      this.i.schedule(new MMApkFileSafeChecker.CheckTask.3(this), 40000L);
      return;
    }
    finally {}
  }
  
  void e()
  {
    try
    {
      if (this.i != null)
      {
        this.i.cancel();
        this.i = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask
 * JD-Core Version:    0.7.0.1
 */