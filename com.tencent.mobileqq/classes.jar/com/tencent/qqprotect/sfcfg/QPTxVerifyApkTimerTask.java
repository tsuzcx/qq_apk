package com.tencent.qqprotect.sfcfg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.SecVerifyApk.ReportDetectResultPacket;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.usq.u;
import java.util.TimerTask;
import mqq.app.MobileQQ;

public class QPTxVerifyApkTimerTask
  extends TimerTask
{
  private static int jdField_a_of_type_Int = 0;
  private static String jdField_a_of_type_JavaLangString = "00000000000000000000000000000000";
  private static boolean jdField_a_of_type_Boolean = false;
  private static String jdField_b_of_type_JavaLangString = "00000000000000000000000000000000";
  private static boolean jdField_b_of_type_Boolean = false;
  private static String jdField_c_of_type_JavaLangString = "00000000000000000000000000000000";
  private static boolean jdField_c_of_type_Boolean = false;
  private static String d = "00000000000000000000000000000000";
  private static String e = "SecVAcfg";
  
  public QPTxVerifyApkTimerTask(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public static int a()
  {
    if (jdField_a_of_type_Boolean) {
      return jdField_a_of_type_Int;
    }
    return -1;
  }
  
  /* Error */
  private String a(com.tencent.commonsdk.zip.QZipFile paramQZipFile, java.util.zip.ZipEntry paramZipEntry)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: invokevirtual 40	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   5: astore_2
    //   6: aload_2
    //   7: astore_1
    //   8: ldc 42
    //   10: invokestatic 48	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   13: astore 4
    //   15: aload_2
    //   16: astore_1
    //   17: sipush 8192
    //   20: newarray byte
    //   22: astore 5
    //   24: aload_2
    //   25: astore_1
    //   26: aload_2
    //   27: aload 5
    //   29: invokevirtual 54	java/io/InputStream:read	([B)I
    //   32: istore_3
    //   33: iload_3
    //   34: iconst_m1
    //   35: if_icmpeq +17 -> 52
    //   38: aload_2
    //   39: astore_1
    //   40: aload 4
    //   42: aload 5
    //   44: iconst_0
    //   45: iload_3
    //   46: invokevirtual 58	java/security/MessageDigest:update	([BII)V
    //   49: goto -25 -> 24
    //   52: aload_2
    //   53: astore_1
    //   54: aload 4
    //   56: invokevirtual 62	java/security/MessageDigest:digest	()[B
    //   59: invokestatic 67	com/tencent/qqprotect/sfcfg/TXSafeCheckUtil:a	([B)Ljava/lang/String;
    //   62: astore 4
    //   64: aload_2
    //   65: ifnull +15 -> 80
    //   68: aload_2
    //   69: invokevirtual 70	java/io/InputStream:close	()V
    //   72: aload 4
    //   74: areturn
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   80: aload 4
    //   82: areturn
    //   83: astore_2
    //   84: goto +42 -> 126
    //   87: astore 4
    //   89: goto +13 -> 102
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: goto +31 -> 126
    //   98: astore 4
    //   100: aconst_null
    //   101: astore_2
    //   102: aload_2
    //   103: astore_1
    //   104: aload 4
    //   106: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   109: aload_2
    //   110: ifnull +14 -> 124
    //   113: aload_2
    //   114: invokevirtual 70	java/io/InputStream:close	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: aload_1
    //   127: ifnull +15 -> 142
    //   130: aload_1
    //   131: invokevirtual 70	java/io/InputStream:close	()V
    //   134: goto +8 -> 142
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   142: goto +5 -> 147
    //   145: aload_2
    //   146: athrow
    //   147: goto -2 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	QPTxVerifyApkTimerTask
    //   0	150	1	paramQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   0	150	2	paramZipEntry	java.util.zip.ZipEntry
    //   32	14	3	i	int
    //   13	68	4	localObject	Object
    //   87	1	4	localException1	Exception
    //   98	7	4	localException2	Exception
    //   22	21	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   68	72	75	java/lang/Exception
    //   8	15	83	finally
    //   17	24	83	finally
    //   26	33	83	finally
    //   40	49	83	finally
    //   54	64	83	finally
    //   104	109	83	finally
    //   8	15	87	java/lang/Exception
    //   17	24	87	java/lang/Exception
    //   26	33	87	java/lang/Exception
    //   40	49	87	java/lang/Exception
    //   54	64	87	java/lang/Exception
    //   0	6	92	finally
    //   0	6	98	java/lang/Exception
    //   113	117	119	java/lang/Exception
    //   130	134	137	java/lang/Exception
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: new 36	com/tencent/commonsdk/zip/QZipFile
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 81	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_2
    //   12: invokevirtual 85	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   15: astore_3
    //   16: aload_2
    //   17: astore_1
    //   18: aload_3
    //   19: invokeinterface 91 1 0
    //   24: ifeq +114 -> 138
    //   27: aload_2
    //   28: astore_1
    //   29: aload_3
    //   30: invokeinterface 95 1 0
    //   35: checkcast 97	java/util/zip/ZipEntry
    //   38: astore 4
    //   40: aload_2
    //   41: astore_1
    //   42: aload 4
    //   44: invokevirtual 100	java/util/zip/ZipEntry:isDirectory	()Z
    //   47: ifeq +6 -> 53
    //   50: goto -34 -> 16
    //   53: aload_2
    //   54: astore_1
    //   55: aload 4
    //   57: invokevirtual 104	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   60: astore 5
    //   62: aload_2
    //   63: astore_1
    //   64: aload 5
    //   66: ldc 106
    //   68: invokevirtual 112	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   71: ifeq +6 -> 77
    //   74: goto -58 -> 16
    //   77: aload_2
    //   78: astore_1
    //   79: aload 5
    //   81: ldc 114
    //   83: invokevirtual 118	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   86: ifeq -70 -> 16
    //   89: aload_2
    //   90: astore_1
    //   91: aload 5
    //   93: ldc 120
    //   95: invokevirtual 123	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   98: ifeq -82 -> 16
    //   101: aload_2
    //   102: astore_1
    //   103: aload 5
    //   105: bipush 47
    //   107: invokevirtual 127	java/lang/String:lastIndexOf	(I)I
    //   110: bipush 8
    //   112: if_icmpne -96 -> 16
    //   115: aload_2
    //   116: astore_1
    //   117: aload_0
    //   118: aload_2
    //   119: aload 4
    //   121: invokespecial 129	com/tencent/qqprotect/sfcfg/QPTxVerifyApkTimerTask:a	(Lcom/tencent/commonsdk/zip/QZipFile;Ljava/util/zip/ZipEntry;)Ljava/lang/String;
    //   124: astore_3
    //   125: aload_2
    //   126: invokevirtual 130	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   129: aload_3
    //   130: areturn
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   136: aload_3
    //   137: areturn
    //   138: aload_2
    //   139: invokevirtual 130	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_3
    //   145: goto +16 -> 161
    //   148: astore_3
    //   149: goto +31 -> 180
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: goto +49 -> 204
    //   158: astore_3
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: astore_1
    //   163: aload_3
    //   164: invokevirtual 132	java/lang/OutOfMemoryError:printStackTrace	()V
    //   167: aload_2
    //   168: ifnull +33 -> 201
    //   171: aload_2
    //   172: invokevirtual 130	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_2
    //   180: aload_2
    //   181: astore_1
    //   182: aload_3
    //   183: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   186: aload_2
    //   187: ifnull +14 -> 201
    //   190: aload_2
    //   191: invokevirtual 130	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   194: aconst_null
    //   195: areturn
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   201: aconst_null
    //   202: areturn
    //   203: astore_2
    //   204: aload_1
    //   205: ifnull +15 -> 220
    //   208: aload_1
    //   209: invokevirtual 130	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   212: goto +8 -> 220
    //   215: astore_1
    //   216: aload_1
    //   217: invokevirtual 131	java/io/IOException:printStackTrace	()V
    //   220: goto +5 -> 225
    //   223: aload_2
    //   224: athrow
    //   225: goto -2 -> 223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	QPTxVerifyApkTimerTask
    //   0	228	1	paramString	String
    //   8	131	2	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   152	1	2	localObject1	Object
    //   160	31	2	localObject2	Object
    //   203	21	2	localObject3	Object
    //   15	122	3	localObject4	Object
    //   144	1	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   148	1	3	localException1	Exception
    //   158	6	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   177	6	3	localException2	Exception
    //   38	82	4	localZipEntry	java.util.zip.ZipEntry
    //   60	44	5	str	String
    // Exception table:
    //   from	to	target	type
    //   125	129	131	java/io/IOException
    //   11	16	144	java/lang/OutOfMemoryError
    //   18	27	144	java/lang/OutOfMemoryError
    //   29	40	144	java/lang/OutOfMemoryError
    //   42	50	144	java/lang/OutOfMemoryError
    //   55	62	144	java/lang/OutOfMemoryError
    //   64	74	144	java/lang/OutOfMemoryError
    //   79	89	144	java/lang/OutOfMemoryError
    //   91	101	144	java/lang/OutOfMemoryError
    //   103	115	144	java/lang/OutOfMemoryError
    //   117	125	144	java/lang/OutOfMemoryError
    //   11	16	148	java/lang/Exception
    //   18	27	148	java/lang/Exception
    //   29	40	148	java/lang/Exception
    //   42	50	148	java/lang/Exception
    //   55	62	148	java/lang/Exception
    //   64	74	148	java/lang/Exception
    //   79	89	148	java/lang/Exception
    //   91	101	148	java/lang/Exception
    //   103	115	148	java/lang/Exception
    //   117	125	148	java/lang/Exception
    //   0	9	152	finally
    //   0	9	158	java/lang/OutOfMemoryError
    //   0	9	177	java/lang/Exception
    //   138	142	196	java/io/IOException
    //   171	175	196	java/io/IOException
    //   190	194	196	java/io/IOException
    //   11	16	203	finally
    //   18	27	203	finally
    //   29	40	203	finally
    //   42	50	203	finally
    //   55	62	203	finally
    //   64	74	203	finally
    //   79	89	203	finally
    //   91	101	203	finally
    //   103	115	203	finally
    //   117	125	203	finally
    //   163	167	203	finally
    //   182	186	203	finally
    //   208	212	215	java/io/IOException
  }
  
  private boolean a()
  {
    try
    {
      long l1 = BaseApplication.getContext().getSharedPreferences(e, 0).getLong("SecHisStamp", 0L);
      long l2 = System.currentTimeMillis();
      return l2 > l1 + 86400000L;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  private void b()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localQQAppInterface == null) {
        return;
      }
      SecVerifyApk.ReportDetectResultPacket localReportDetectResultPacket = new SecVerifyApk.ReportDetectResultPacket();
      if (jdField_c_of_type_Boolean) {
        localReportDetectResultPacket.uint32_cmd.set(2);
      } else {
        localReportDetectResultPacket.uint32_cmd.set(1);
      }
      localReportDetectResultPacket.uint32_result.set(jdField_a_of_type_Int);
      localReportDetectResultPacket.uint32_appid.set(AppSetting.a());
      Object localObject1 = localQQAppInterface.getApplication().getApplicationInfo().sourceDir;
      if (localObject1 == null) {
        return;
      }
      boolean bool = jdField_b_of_type_Boolean;
      if (!bool)
      {
        Object localObject3 = BaseApplication.getContext().getSharedPreferences(e, 0);
        localObject2 = ((SharedPreferences)localObject3).getString("SecHisSit", null);
        String str1 = ((SharedPreferences)localObject3).getString("SecHisTxs", null);
        String str2 = ((SharedPreferences)localObject3).getString("SecHisRa", null);
        String str3 = ((SharedPreferences)localObject3).getString("SecHisAk", null);
        localObject3 = ((SharedPreferences)localObject3).getString("SecVer", null);
        String str4 = a((String)localObject1);
        if (str4 != null) {
          jdField_b_of_type_JavaLangString = str4;
        }
        if ((str2 != null) && (str2.equalsIgnoreCase(jdField_b_of_type_JavaLangString)) && (localObject3 != null) && (((String)localObject3).equalsIgnoreCase("8.7.0.5295")))
        {
          if (localObject2 != null) {
            d = (String)localObject2;
          }
          if (str3 != null) {
            jdField_a_of_type_JavaLangString = str3;
          }
          if (str1 != null) {
            jdField_c_of_type_JavaLangString = str1;
          }
        }
        else
        {
          d = u.a(BaseApplication.getContext());
          jdField_a_of_type_JavaLangString = u.a((String)localObject1);
          localObject2 = new byte[16];
          TXSafeCheckUtil.a((String)localObject1, "txsfcfg.dat", (byte[])localObject2);
          jdField_c_of_type_JavaLangString = u.a((byte[])localObject2);
          jdField_b_of_type_Boolean = true;
        }
      }
      localReportDetectResultPacket.str_signature.set(d);
      localReportDetectResultPacket.str_apkmd5.set(jdField_a_of_type_JavaLangString);
      localReportDetectResultPacket.str_rsamd5.set(jdField_b_of_type_JavaLangString);
      localReportDetectResultPacket.str_txsfcfgkmd5.set(jdField_c_of_type_JavaLangString);
      localReportDetectResultPacket.str_apkversion.set("8.7.0.5295");
      localReportDetectResultPacket.str_channelid.set(AppSetting.c());
      localReportDetectResultPacket.str_uin.set(localQQAppInterface.getCurrentAccountUin());
      localReportDetectResultPacket.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
      localReportDetectResultPacket.str_sysversion.set(Build.VERSION.RELEASE);
      localReportDetectResultPacket.str_brand.set(Build.BRAND);
      localReportDetectResultPacket.str_model.set(Build.MODEL);
      Object localObject2 = localQQAppInterface.getApplication().getPackageName();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "com.tencent.mobileqq";
      }
      localReportDetectResultPacket.package_name.set((String)localObject1);
      localObject1 = new ToServiceMsg("mobileqq.service", localQQAppInterface.getCurrentAccountUin(), "SecurityApk.VA");
      ((ToServiceMsg)localObject1).putWupBuffer(localReportDetectResultPacket.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
      ((ToServiceMsg)localObject1).setNeedCallback(false);
      localQQAppInterface.sendToService((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void c()
  {
    try
    {
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(e, 0).edit();
      localEditor.putLong("SecHisStamp", System.currentTimeMillis());
      localEditor.putString("SecHisSit", d);
      localEditor.putString("SecHisTxs", jdField_c_of_type_JavaLangString);
      localEditor.putString("SecHisRa", jdField_b_of_type_JavaLangString);
      localEditor.putString("SecHisAk", jdField_a_of_type_JavaLangString);
      localEditor.putString("SecVer", "8.7.0.5295");
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      boolean bool = QLog.isColorLevel();
      if (bool) {
        QLog.d("SEC_VA", 2, "start");
      }
      if ((!jdField_c_of_type_Boolean) && (!a())) {
        return;
      }
      if (!jdField_a_of_type_Boolean)
      {
        localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject == null) {
          return;
        }
        localObject = ((QQAppInterface)localObject).getApplication().getApplicationInfo().sourceDir;
        if (localObject == null) {
          return;
        }
        jdField_a_of_type_Int = TXVerifyAPKUtil.a((String)localObject, "txsfcfg.dat");
        if ((jdField_a_of_type_Int != 0) && (jdField_a_of_type_Int != 143)) {
          jdField_a_of_type_Int = TXVerifyAPKUtil.a((String)localObject, "txsfcfg.dat");
        }
        jdField_a_of_type_Boolean = true;
      }
      long l2 = System.currentTimeMillis();
      b();
      long l3 = System.currentTimeMillis();
      c();
      long l4 = System.currentTimeMillis();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cost(");
      ((StringBuilder)localObject).append(l2 - l1);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(l3 - l2);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(l4 - l3);
      ((StringBuilder)localObject).append(")");
      QLog.d("SEC_VA", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void run()
  {
    ThreadManager.post(new QPTxVerifyApkTimerTask.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.sfcfg.QPTxVerifyApkTimerTask
 * JD-Core Version:    0.7.0.1
 */