package com.tencent.mobileqq.msgbackup.util;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupSessionRequest;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.transfile.IPAddressUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class MsgBackupUtil
{
  public static AtomicLong a;
  public static boolean a = true;
  public static boolean b = true;
  public static boolean c = true;
  public static boolean d = false;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(1L);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt == -1000) {
      return 1;
    }
    return 2;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    paramString = paramString.split("\\.");
    if (paramString.length != 4) {
      return 0;
    }
    try
    {
      int i = Integer.parseInt(paramString[0]);
      int j = Integer.parseInt(paramString[1]);
      int k = Integer.parseInt(paramString[2]);
      int m = Integer.parseInt(paramString[3]);
      return m << 24 | i | j << 8 | k << 16;
    }
    catch (Exception paramString)
    {
      QLog.e("MsgBackup", 1, paramString, new Object[0]);
    }
    return 0;
  }
  
  public static long a()
  {
    long l = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(1L + l);
    return l;
  }
  
  public static long a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000)) {
      return (short)(int)paramMessageRecord.shmsgseq & 0xFFFF;
    }
    return paramMessageRecord.shmsgseq;
  }
  
  public static String a(double paramDouble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    double d1 = paramDouble;
    if (paramDouble < 0.0D)
    {
      localStringBuilder.append('-');
      d1 = -paramDouble;
    }
    long l3 = (d1 * 100.0D + 0.5D);
    long l1 = 100L;
    int i = 3;
    long l2;
    int j;
    for (;;)
    {
      l2 = l1 * 10L;
      j = i;
      if (l2 > l3) {
        break;
      }
      i += 1;
      l1 = l2;
    }
    while (j > 0)
    {
      if (j == 2) {
        localStringBuilder.append('.');
      }
      l2 = l3 / l1 % 10L;
      l1 /= 10L;
      if ((j != 1) || (l2 != 0L)) {
        localStringBuilder.append((char)(int)(l2 + 48L));
      }
      j -= 1;
    }
    return localStringBuilder.toString();
  }
  
  private static String a(double paramDouble, boolean paramBoolean)
  {
    if (paramBoolean) {
      return b(paramDouble);
    }
    return a(paramDouble);
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, true);
  }
  
  private static String a(long paramLong, boolean paramBoolean)
  {
    if (paramLong == 0L) {
      return "0K";
    }
    if (paramLong <= 1024L)
    {
      if (paramBoolean) {
        return "1.00K";
      }
      return "1.0K";
    }
    Object localObject = "";
    double d1;
    StringBuilder localStringBuilder;
    if (paramLong >= 1073741824L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      d1 = paramLong;
      Double.isNaN(d1);
      ((StringBuilder)localObject).append(a(d1 / 1073741824.0D, paramBoolean));
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("G");
      return localStringBuilder.toString();
    }
    if (paramLong >= 1048576L)
    {
      if (paramLong >= 1048576000L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        d1 = paramLong;
        Double.isNaN(d1);
        ((StringBuilder)localObject).append(a(d1 / 1048576.0D / 1024.0D, paramBoolean));
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("G");
        return localStringBuilder.toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      d1 = paramLong;
      Double.isNaN(d1);
      ((StringBuilder)localObject).append(a(d1 / 1048576.0D, paramBoolean));
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("M");
      return localStringBuilder.toString();
    }
    if (paramLong >= 1024L)
    {
      if (paramLong >= 1024000L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        d1 = paramLong;
        Double.isNaN(d1);
        ((StringBuilder)localObject).append(a(d1 / 1024.0D / 1024.0D, paramBoolean));
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("M");
        return localStringBuilder.toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      d1 = paramLong;
      Double.isNaN(d1);
      ((StringBuilder)localObject).append(a(d1 / 1024.0D, paramBoolean));
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("K");
      localObject = localStringBuilder.toString();
    }
    return localObject;
  }
  
  public static String a(MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    String str = String.format("%s_%d", new Object[] { paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString, Integer.valueOf(b(paramMsgBackupSessionRequest.jdField_a_of_type_Int)) });
    if (!TextUtils.isEmpty(paramMsgBackupSessionRequest.b)) {
      str = String.format("%s_%d_%s", new Object[] { paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString, Integer.valueOf(b(paramMsgBackupSessionRequest.jdField_a_of_type_Int)), paramMsgBackupSessionRequest.b });
    }
    paramMsgBackupSessionRequest = new StringBuilder();
    paramMsgBackupSessionRequest.append(MsgBackupConstant.c);
    paramMsgBackupSessionRequest.append(str);
    paramMsgBackupSessionRequest.append(".db");
    return paramMsgBackupSessionRequest.toString();
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  public static String a(String paramString, int paramInt)
  {
    String str;
    if (IPAddressUtil.isIPv6LiteralAddress(paramString)) {
      str = "http://[%s]:%d/";
    } else {
      str = "http://%s:%d/";
    }
    return String.format(str, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    String str = String.format("%s_%d", new Object[] { paramString1, Integer.valueOf(paramInt) });
    if (!TextUtils.isEmpty(paramString2)) {
      str = String.format("%s_%d_%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
    }
    paramString1 = new StringBuilder();
    paramString1.append(MsgBackupConstant.c);
    paramString1.append(str);
    paramString1.append(".db");
    return paramString1.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      a("MsgBackup", "decryptPartionUrlParams key is null", new Object[0]);
    }
    String str = paramString1;
    if (b)
    {
      str = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        str = paramString1;
        if (!TextUtils.isEmpty(paramString2))
        {
          a("MsgBackup", "originUrl = %s, encryptkey = %s", new Object[] { paramString1, paramString2 });
          String[] arrayOfString = paramString1.split("\\/");
          str = paramString1;
          if (arrayOfString.length == 2)
          {
            paramString1 = MsgBackupJniProxy.decryptFromString(arrayOfString[1], paramString2);
            paramString2 = new StringBuilder();
            paramString2.append("/");
            paramString2.append(paramString1);
            str = paramString2.toString();
            a("MsgBackup", "decryptUrl = %s", new Object[] { str });
          }
        }
      }
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      a("MsgBackup", "decrptUrlPathParams key is null", new Object[0]);
    }
    boolean bool = b;
    String str2 = "";
    String str1 = str2;
    if (bool)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString1))
      {
        str1 = str2;
        if (!TextUtils.isEmpty(paramString3))
        {
          a("MsgBackup", "decrptUrlPathParams originUrl = %s, ip = %s, port = %d, encryptkey is not null!", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
          paramString1 = paramString1.split(a(paramString2, paramInt));
          str1 = str2;
          if (paramString1.length == 2)
          {
            paramString2 = (String)a(MsgBackupJniProxy.decryptFromString(paramString1[1], paramString3)).get("filepath");
            if (TextUtils.isEmpty(paramString2)) {
              return "";
            }
            paramString1 = paramString2;
            if (c) {
              paramString1 = Uri.decode(paramString2);
            }
            str1 = a(paramString1);
            a("decrptUrlPathParams filepath = %s", str1, new Object[0]);
          }
        }
      }
    }
    return str1;
  }
  
  public static Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("\\?");
      if (paramString.length > 1)
      {
        paramString = paramString[1].split("&");
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramString[i];
          int k = localObject.indexOf("=");
          if (k != -1) {
            localHashMap.put(localObject.substring(0, k), localObject.substring(k + 1));
          }
          i += 1;
        }
      }
    }
    return localHashMap;
  }
  
  public static void a()
  {
    FileUtil.c(MsgBackupConstant.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(MessageRecord paramMessageRecord, MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000))
    {
      int i = MessageUtils.b(paramMessageRecord.msgUid);
      paramMsgBackupResEntity.msgSeq = ((short)(int)paramMessageRecord.shmsgseq & 0xFFFF);
      paramMsgBackupResEntity.msgRandom = i;
      return;
    }
    paramMsgBackupResEntity.msgSeq = paramMessageRecord.shmsgseq;
  }
  
  public static void a(MsgBackupMsgEntity paramMsgBackupMsgEntity)
  {
    if ((b) && (paramMsgBackupMsgEntity != null))
    {
      if (!TextUtils.isEmpty(paramMsgBackupMsgEntity.chatUin)) {
        paramMsgBackupMsgEntity.chatUin = MsgBackupJniProxy.decryptFromString(paramMsgBackupMsgEntity.chatUin, MsgBackupManager.c);
      }
      if (paramMsgBackupMsgEntity.extraData != null) {
        paramMsgBackupMsgEntity.extraData = MsgBackupJniProxy.decryptFromByteArray(paramMsgBackupMsgEntity.extraData, MsgBackupManager.c);
      }
      if (paramMsgBackupMsgEntity.extensionData != null) {
        paramMsgBackupMsgEntity.extensionData = MsgBackupJniProxy.decryptFromByteArray(paramMsgBackupMsgEntity.extensionData, MsgBackupManager.c);
      }
    }
  }
  
  public static void a(MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((b) && (paramMsgBackupResEntity != null) && (paramMsgBackupResEntity.extraData != null) && (MsgBackupManager.b != null)) {
      paramMsgBackupResEntity.extraData = MsgBackupJniProxy.encryptFromByteArray(paramMsgBackupResEntity.extraData, MsgBackupManager.b);
    }
  }
  
  public static void a(String paramString, MsgBackupSessionRequest paramMsgBackupSessionRequest)
  {
    paramString = paramString.substring(0, paramString.indexOf(".")).split("_");
    paramMsgBackupSessionRequest.jdField_a_of_type_JavaLangString = paramString[0];
    paramMsgBackupSessionRequest.jdField_a_of_type_Int = c(Integer.parseInt(paramString[1]));
    if (paramString.length > 2) {
      paramMsgBackupSessionRequest.b = paramString[2];
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "MsgBackup";
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(str, 4, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgBackup", 4, String.format(paramString, paramVarArgs));
    }
  }
  
  public static boolean a()
  {
    String str = MsgBackupConstant.c;
    Object localObject = new File(str);
    boolean bool1 = ((File)localObject).exists();
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = ((File)localObject).mkdirs();
    }
    if (bool2)
    {
      File localFile = new File(MsgBackupConstant.b);
      boolean bool3 = localFile.exists();
      localObject = localFile;
      bool1 = bool3;
      if (!bool3)
      {
        bool1 = localFile.mkdirs();
        localObject = localFile;
      }
    }
    else
    {
      bool1 = false;
    }
    a("Manager.init.file mkdirs result = %b,dbDirExist = %b,filePath = %s,multimsgDirExist = %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(((File)localObject).exists()), str, Boolean.valueOf(bool1) });
    return bool2;
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong <= 1048576L;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 3000) {
      return 2;
    }
    return 3;
  }
  
  public static long b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000)) {
      return MessageUtils.b(paramMessageRecord.msgUid);
    }
    return 0L;
  }
  
  public static String b(double paramDouble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    double d1 = paramDouble;
    if (paramDouble < 0.0D)
    {
      localStringBuilder.append('-');
      d1 = -paramDouble;
    }
    long l3 = (d1 * 100.0D + 0.5D);
    long l1 = 100L;
    int i = 3;
    long l2;
    int j;
    for (;;)
    {
      l2 = l1 * 10L;
      j = i;
      if (l2 > l3) {
        break;
      }
      i += 1;
      l1 = l2;
    }
    while (j > 0)
    {
      if (j == 2) {
        localStringBuilder.append('.');
      }
      l2 = l3 / l1;
      l1 /= 10L;
      localStringBuilder.append((char)(int)(l2 % 10L + 48L));
      j -= 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MsgBackupConstant.b);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      a("MsgBackup", "encryptUrlParams key is null", new Object[0]);
    }
    String str = paramString1;
    if (b)
    {
      str = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        str = paramString1;
        if (!TextUtils.isEmpty(paramString2))
        {
          a("MsgBackup", "encryptUrlParams urlParams = %s, encryptkey is not null!", new Object[] { paramString1 });
          str = MsgBackupJniProxy.encryptFromString(paramString1, paramString2);
          a("MsgBackup", "encryptUrlParams params = %s", new Object[] { str });
        }
      }
    }
    return str;
  }
  
  public static String b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3)) {
      a("MsgBackup", "decryptUrlParams key is null", new Object[0]);
    }
    Object localObject = paramString1;
    if (b)
    {
      localObject = paramString1;
      if (!TextUtils.isEmpty(paramString1))
      {
        localObject = paramString1;
        if (!TextUtils.isEmpty(paramString3))
        {
          a("MsgBackup", "originUrl = %s, ip = %s, port = %d, encryptkey is not null!", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
          paramString2 = a(paramString2, paramInt);
          localObject = paramString1.split(paramString2);
          if (localObject.length == 2)
          {
            paramString1 = MsgBackupJniProxy.decryptFromString(localObject[1], paramString3);
            paramString3 = new StringBuilder();
            paramString3.append(paramString2);
            paramString3.append(paramString1);
            paramString1 = paramString3.toString();
          }
          a("MsgBackup", "decryptUrl = %s", new Object[] { paramString1 });
          localObject = paramString1;
        }
      }
    }
    return localObject;
  }
  
  public static void b(MsgBackupMsgEntity paramMsgBackupMsgEntity)
  {
    if ((b) && (paramMsgBackupMsgEntity != null) && (MsgBackupManager.b != null))
    {
      if (!TextUtils.isEmpty(paramMsgBackupMsgEntity.chatUin)) {
        paramMsgBackupMsgEntity.chatUin = MsgBackupJniProxy.encryptFromString(paramMsgBackupMsgEntity.chatUin, MsgBackupManager.b);
      }
      if (paramMsgBackupMsgEntity.extraData != null) {
        paramMsgBackupMsgEntity.extraData = MsgBackupJniProxy.encryptFromByteArray(paramMsgBackupMsgEntity.extraData, MsgBackupManager.b);
      }
      if (paramMsgBackupMsgEntity.extensionData != null) {
        paramMsgBackupMsgEntity.extensionData = MsgBackupJniProxy.encryptFromByteArray(paramMsgBackupMsgEntity.extensionData, MsgBackupManager.b);
      }
    }
  }
  
  public static void b(MsgBackupResEntity paramMsgBackupResEntity)
  {
    if ((b) && (paramMsgBackupResEntity != null) && (paramMsgBackupResEntity.extraData != null) && (MsgBackupManager.c != null)) {
      paramMsgBackupResEntity.extraData = MsgBackupJniProxy.decryptFromByteArray(paramMsgBackupResEntity.extraData, MsgBackupManager.c);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, String.format(paramString2, paramVarArgs));
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, String.format(paramString, paramVarArgs));
    }
  }
  
  public static int c(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 3000;
    }
    return 0;
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (c) {
      str = Uri.encode(paramString);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupUtil
 * JD-Core Version:    0.7.0.1
 */