package com.tencent.mqp.app.sec;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.SecSharedInfo.FileInfo;
import com.tencent.ims.SecSharedInfo.SendInfo;
import com.tencent.ims.SecSharedInfo.SharedInfoPacket;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import com.tencent.securitysdk.utils.MD5;
import com.tencent.usq.u;
import java.io.File;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.MobileQQ;

public class SecShareInfoUtil
{
  private static SecShareInfoUtil jdField_a_of_type_ComTencentMqpAppSecSecShareInfoUtil;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentLinkedQueue<SecShareInfoUtil.FileInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    paramString = paramString.split("[.]");
    if (paramString == null) {
      return 0;
    }
    if ((paramString.length != 3) && (paramString.length != 4)) {
      return 0;
    }
    int j = 0;
    int i = 0;
    try
    {
      while (j < paramString.length)
      {
        i = i << 8 | Integer.parseInt(paramString[j]) & 0xFF;
        j += 1;
      }
      j = paramString.length;
      if (3 == j) {
        return i << 8;
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private long a(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null) {
      return 0L;
    }
    if (TextUtils.isEmpty(paramPackageInfo.applicationInfo.sourceDir))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SecShare.AV", 2, "Path is empty.");
      }
      return 0L;
    }
    try
    {
      long l = new File(paramPackageInfo.applicationInfo.sourceDir).length();
      return l;
    }
    catch (Exception paramPackageInfo)
    {
      label55:
      break label55;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SecShare.AV", 2, "Read file failed.");
    }
    return 0L;
  }
  
  private PackageInfo a(String paramString)
  {
    try
    {
      paramString = BaseApplication.getContext().getPackageManager().getPackageInfo(paramString, 192);
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static SecShareInfoUtil a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMqpAppSecSecShareInfoUtil == null) {
        jdField_a_of_type_ComTencentMqpAppSecSecShareInfoUtil = new SecShareInfoUtil();
      }
      SecShareInfoUtil localSecShareInfoUtil = jdField_a_of_type_ComTencentMqpAppSecSecShareInfoUtil;
      return localSecShareInfoUtil;
    }
    finally {}
  }
  
  public static String a(PackageInfo paramPackageInfo)
  {
    try
    {
      PackageManager localPackageManager = BaseApplication.getContext().getPackageManager();
      paramPackageInfo = paramPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
      return paramPackageInfo;
    }
    catch (Exception paramPackageInfo)
    {
      paramPackageInfo.printStackTrace();
    }
    return "";
  }
  
  private String a(String paramString)
  {
    String str = "";
    try
    {
      File localFile = new File(paramString);
      if (localFile.exists())
      {
        if (!localFile.canRead()) {
          return "";
        }
        if (localFile.length() >= 125829120L) {
          return "toolarge";
        }
        str = u.a(paramString);
      }
      return str;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  private String b(PackageInfo paramPackageInfo)
  {
    if (paramPackageInfo == null) {
      return "f0";
    }
    if (paramPackageInfo.signatures == null) {
      return "f1";
    }
    if (paramPackageInfo.signatures[0] == null) {
      return "f2";
    }
    paramPackageInfo = paramPackageInfo.signatures[0].toByteArray();
    if (paramPackageInfo == null) {
      return "f3";
    }
    if (paramPackageInfo.length == 0) {
      return "f4";
    }
    return MD5FileUtil.a(paramPackageInfo);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  private void c()
  {
    for (;;)
    {
      try
      {
        localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localQQAppInterface == null) {
          return;
        }
        localSharedInfoPacket = new SecSharedInfo.SharedInfoPacket();
        localSharedInfoPacket.version.set(1);
        localSharedInfoPacket.type.set(1);
        localSharedInfoPacket.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
        localSharedInfoPacket.uint32_appid.set(AppSetting.a());
        localSharedInfoPacket.str_sysversion.set(Build.VERSION.RELEASE);
        localSharedInfoPacket.str_brand.set(Build.BRAND);
        localSharedInfoPacket.str_model.set(Build.MODEL);
        localSharedInfoPacket.qq_version.set(a("8.7.0"));
        if (QLog.isColorLevel()) {
          QLog.d("SecShare.AV", 2, String.format("Version = %s intVersion= 0x%x", new Object[] { "8.7.0", Integer.valueOf(a("8.7.0")) }));
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.isEmpty()) {
          continue;
        }
        localSendInfo = new SecSharedInfo.SendInfo();
        localObject1 = (SecShareInfoUtil.FileInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
        i = ((SecShareInfoUtil.FileInfo)localObject1).a();
        localObject2 = ((SecShareInfoUtil.FileInfo)localObject1).a();
        str3 = ((SecShareInfoUtil.FileInfo)localObject1).b();
        j = ((SecShareInfoUtil.FileInfo)localObject1).b();
        localSendInfo.type.set(i);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SecShare.AV", 2, String.format("Type = %d", new Object[] { Integer.valueOf(i) }));
      }
      catch (Exception localException)
      {
        QQAppInterface localQQAppInterface;
        SecSharedInfo.SharedInfoPacket localSharedInfoPacket;
        SecSharedInfo.SendInfo localSendInfo;
        Object localObject1;
        int i;
        Object localObject2;
        String str3;
        int j;
        String str2;
        continue;
        if (i == 3) {
          continue;
        }
        if (i != 4) {
          continue;
        }
        continue;
        if (str3 != null) {
          continue;
        }
        String str1 = "null";
        continue;
        str1 = str3;
        continue;
      }
      if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localObject1 = MD5.a((String)localObject2);
        localSendInfo.md5.set((String)localObject1);
      }
      else if ((i == 2) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localObject1 = MD5.a((String)localObject2);
        localSendInfo.md5.set((String)localObject1);
        localSendInfo.url.set((String)localObject2);
      }
      else if (i == 5)
      {
        localSendInfo.url.set((String)localObject2);
        continue;
        localSendInfo.url.set((String)localObject2);
        localObject1 = a((String)localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localSendInfo.md5.set((String)localObject1);
        }
      }
      str1 = localQQAppInterface.getCurrentAccountUin();
      if (!TextUtils.isEmpty(str1)) {
        localSendInfo.src_uin.set(str1);
      }
      if (QLog.isColorLevel())
      {
        str2 = "null";
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "null";
        }
        localObject2 = str1;
        if (str1 != null) {
          continue;
        }
        localObject2 = "null";
        continue;
        if (localSendInfo.md5.get() != null) {
          str2 = localSendInfo.md5.get();
        }
        QLog.d("SecShare.AV", 2, String.format("type = %d uri = %s uin = %s dest_uin = %s uin_type = 0x%x file_hash = %s", new Object[] { Integer.valueOf(i), localObject1, localObject2, str1, Integer.valueOf(j), str2 }));
      }
      if (!TextUtils.isEmpty(str3))
      {
        localSendInfo.des_uin.set(str3);
        localSendInfo.des_type.set(j);
      }
      localSharedInfoPacket.send_info.add(localSendInfo);
    }
    if (QLog.isColorLevel()) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        QLog.d("SecShare.AV", 2, String.format("Act ref = %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
      } else {
        QLog.d("SecShare.AV", 2, String.format("Act ref = NullorEmpty", new Object[0]));
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject1 = a(this.jdField_a_of_type_JavaLangString);
      if (localObject1 != null)
      {
        localSharedInfoPacket.file_info.setHasFlag(true);
        localSharedInfoPacket.file_info.package_name.set(this.jdField_a_of_type_JavaLangString);
        localSharedInfoPacket.file_info.soft_name.set(a((PackageInfo)localObject1));
        localSharedInfoPacket.file_info.cert_md5.set(b((PackageInfo)localObject1));
        localSharedInfoPacket.file_info.apk_filesize.set((int)a((PackageInfo)localObject1));
      }
    }
    localObject1 = new ToServiceMsg("mobileqq.service", localQQAppInterface.getCurrentAccountUin(), "ShareRiskSvc.SecReport");
    ((ToServiceMsg)localObject1).putWupBuffer(localSharedInfoPacket.toByteArray());
    ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
    ((ToServiceMsg)localObject1).setNeedCallback(false);
    localQQAppInterface.sendToService((ToServiceMsg)localObject1);
    break label775;
    if (QLog.isColorLevel()) {
      QLog.d("SecShare.AV", 2, "Do sso exception.");
    }
    label775:
    b();
  }
  
  public void a()
  {
    ThreadManager.post(new SecShareInfoUtil.1(this), 5, null, true);
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(new SecShareInfoUtil.FileInfo(paramInt1, paramString1, paramInt2, paramString2));
  }
  
  public void a(Object paramObject, String paramString)
  {
    if ((paramObject != null) && ((paramObject instanceof Activity)) && (Build.VERSION.SDK_INT >= 22)) {
      try
      {
        Field localField = Activity.class.getDeclaredField("mReferrer");
        localField.setAccessible(true);
        paramObject = (String)localField.get(paramObject);
      }
      catch (Exception paramObject)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("SecShare.AV", 2, "Get ACT Ref failed.");
          QLog.d("SecShare.AV", 2, Log.getStackTraceString(paramObject));
        }
      }
    } else {
      paramObject = "";
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    if (!TextUtils.isEmpty(paramObject)) {
      this.jdField_a_of_type_JavaLangString = paramObject;
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.sec.SecShareInfoUtil
 * JD-Core Version:    0.7.0.1
 */