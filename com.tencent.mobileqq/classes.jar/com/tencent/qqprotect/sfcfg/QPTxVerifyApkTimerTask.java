package com.tencent.qqprotect.sfcfg;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import bhpn;
import bhpo;
import bhrw;
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
import java.util.TimerTask;
import mqq.app.MobileQQ;

public class QPTxVerifyApkTimerTask
  extends TimerTask
{
  private static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString = "00000000000000000000000000000000";
  private static boolean jdField_a_of_type_Boolean;
  private static String jdField_b_of_type_JavaLangString = "00000000000000000000000000000000";
  private static boolean jdField_b_of_type_Boolean;
  private static String jdField_c_of_type_JavaLangString = "00000000000000000000000000000000";
  private static boolean jdField_c_of_type_Boolean;
  private static String d = "00000000000000000000000000000000";
  private static String e = "SecVAcfg";
  
  public QPTxVerifyApkTimerTask(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    jdField_c_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  private String a(com.tencent.commonsdk.zip.QZipFile paramQZipFile, java.util.zip.ZipEntry paramZipEntry)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: aload_2
    //   5: invokevirtual 44	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: ldc 46
    //   13: invokestatic 52	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   16: astore 4
    //   18: aload_2
    //   19: astore_1
    //   20: sipush 8192
    //   23: newarray byte
    //   25: astore 6
    //   27: aload_2
    //   28: astore_1
    //   29: aload_2
    //   30: aload 6
    //   32: invokevirtual 58	java/io/InputStream:read	([B)I
    //   35: istore_3
    //   36: iload_3
    //   37: iconst_m1
    //   38: if_icmpeq +42 -> 80
    //   41: aload_2
    //   42: astore_1
    //   43: aload 4
    //   45: aload 6
    //   47: iconst_0
    //   48: iload_3
    //   49: invokevirtual 62	java/security/MessageDigest:update	([BII)V
    //   52: goto -25 -> 27
    //   55: astore 4
    //   57: aload_2
    //   58: astore_1
    //   59: aload 4
    //   61: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   64: aload 5
    //   66: astore_1
    //   67: aload_2
    //   68: ifnull +10 -> 78
    //   71: aload_2
    //   72: invokevirtual 68	java/io/InputStream:close	()V
    //   75: aload 5
    //   77: astore_1
    //   78: aload_1
    //   79: areturn
    //   80: aload_2
    //   81: astore_1
    //   82: aload 4
    //   84: invokevirtual 72	java/security/MessageDigest:digest	()[B
    //   87: invokestatic 77	bhpn:a	([B)Ljava/lang/String;
    //   90: astore 4
    //   92: aload 4
    //   94: astore_1
    //   95: aload_2
    //   96: ifnull -18 -> 78
    //   99: aload_2
    //   100: invokevirtual 68	java/io/InputStream:close	()V
    //   103: aload 4
    //   105: areturn
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   111: aload 4
    //   113: areturn
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 68	java/io/InputStream:close	()V
    //   132: aload_2
    //   133: athrow
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   139: goto -7 -> 132
    //   142: astore_2
    //   143: goto -19 -> 124
    //   146: astore 4
    //   148: aconst_null
    //   149: astore_2
    //   150: goto -93 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	QPTxVerifyApkTimerTask
    //   0	153	1	paramQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   0	153	2	paramZipEntry	java.util.zip.ZipEntry
    //   35	14	3	i	int
    //   16	28	4	localMessageDigest	java.security.MessageDigest
    //   55	28	4	localException1	Exception
    //   90	22	4	str	String
    //   146	1	4	localException2	Exception
    //   1	75	5	localObject	Object
    //   25	21	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   11	18	55	java/lang/Exception
    //   20	27	55	java/lang/Exception
    //   29	36	55	java/lang/Exception
    //   43	52	55	java/lang/Exception
    //   82	92	55	java/lang/Exception
    //   99	103	106	java/lang/Exception
    //   71	75	114	java/lang/Exception
    //   3	9	121	finally
    //   128	132	134	java/lang/Exception
    //   11	18	142	finally
    //   20	27	142	finally
    //   29	36	142	finally
    //   43	52	142	finally
    //   59	64	142	finally
    //   82	92	142	finally
    //   3	9	146	java/lang/Exception
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: new 40	com/tencent/commonsdk/zip/QZipFile
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 85	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_2
    //   12: invokevirtual 89	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   15: astore_3
    //   16: aload_2
    //   17: astore_1
    //   18: aload_3
    //   19: invokeinterface 95 1 0
    //   24: ifeq +112 -> 136
    //   27: aload_2
    //   28: astore_1
    //   29: aload_3
    //   30: invokeinterface 99 1 0
    //   35: checkcast 101	java/util/zip/ZipEntry
    //   38: astore 4
    //   40: aload_2
    //   41: astore_1
    //   42: aload 4
    //   44: invokevirtual 104	java/util/zip/ZipEntry:isDirectory	()Z
    //   47: ifne -31 -> 16
    //   50: aload_2
    //   51: astore_1
    //   52: aload 4
    //   54: invokevirtual 108	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   57: astore 5
    //   59: aload_2
    //   60: astore_1
    //   61: aload 5
    //   63: ldc 110
    //   65: invokevirtual 116	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   68: ifne -52 -> 16
    //   71: aload_2
    //   72: astore_1
    //   73: aload 5
    //   75: ldc 118
    //   77: invokevirtual 122	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   80: ifeq -64 -> 16
    //   83: aload_2
    //   84: astore_1
    //   85: aload 5
    //   87: ldc 124
    //   89: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   92: ifeq -76 -> 16
    //   95: aload_2
    //   96: astore_1
    //   97: aload 5
    //   99: bipush 47
    //   101: invokevirtual 131	java/lang/String:lastIndexOf	(I)I
    //   104: bipush 8
    //   106: if_icmpne -90 -> 16
    //   109: aload_2
    //   110: astore_1
    //   111: aload_0
    //   112: aload_2
    //   113: aload 4
    //   115: invokespecial 133	com/tencent/qqprotect/sfcfg/QPTxVerifyApkTimerTask:a	(Lcom/tencent/commonsdk/zip/QZipFile;Ljava/util/zip/ZipEntry;)Ljava/lang/String;
    //   118: astore_3
    //   119: aload_2
    //   120: ifnull +7 -> 127
    //   123: aload_2
    //   124: invokevirtual 134	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   127: aload_3
    //   128: areturn
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   134: aload_3
    //   135: areturn
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 134	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   151: goto -7 -> 144
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_2
    //   158: astore_1
    //   159: aload_3
    //   160: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   163: aload_2
    //   164: ifnull -20 -> 144
    //   167: aload_2
    //   168: invokevirtual 134	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   171: goto -27 -> 144
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   179: goto -35 -> 144
    //   182: astore_3
    //   183: aconst_null
    //   184: astore_2
    //   185: aload_2
    //   186: astore_1
    //   187: aload_3
    //   188: invokevirtual 136	java/lang/OutOfMemoryError:printStackTrace	()V
    //   191: aload_2
    //   192: ifnull -48 -> 144
    //   195: aload_2
    //   196: invokevirtual 134	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   199: goto -55 -> 144
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   207: goto -63 -> 144
    //   210: astore_2
    //   211: aconst_null
    //   212: astore_1
    //   213: aload_1
    //   214: ifnull +7 -> 221
    //   217: aload_1
    //   218: invokevirtual 134	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   221: aload_2
    //   222: athrow
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   228: goto -7 -> 221
    //   231: astore_2
    //   232: goto -19 -> 213
    //   235: astore_3
    //   236: goto -51 -> 185
    //   239: astore_3
    //   240: goto -83 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	QPTxVerifyApkTimerTask
    //   0	243	1	paramString	String
    //   8	188	2	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   210	12	2	localObject1	Object
    //   231	1	2	localObject2	Object
    //   15	120	3	localObject3	Object
    //   154	6	3	localException1	Exception
    //   182	6	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   235	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   239	1	3	localException2	Exception
    //   38	76	4	localZipEntry	java.util.zip.ZipEntry
    //   57	41	5	str	String
    // Exception table:
    //   from	to	target	type
    //   123	127	129	java/io/IOException
    //   140	144	146	java/io/IOException
    //   0	9	154	java/lang/Exception
    //   167	171	174	java/io/IOException
    //   0	9	182	java/lang/OutOfMemoryError
    //   195	199	202	java/io/IOException
    //   0	9	210	finally
    //   217	221	223	java/io/IOException
    //   11	16	231	finally
    //   18	27	231	finally
    //   29	40	231	finally
    //   42	50	231	finally
    //   52	59	231	finally
    //   61	71	231	finally
    //   73	83	231	finally
    //   85	95	231	finally
    //   97	109	231	finally
    //   111	119	231	finally
    //   159	163	231	finally
    //   187	191	231	finally
    //   11	16	235	java/lang/OutOfMemoryError
    //   18	27	235	java/lang/OutOfMemoryError
    //   29	40	235	java/lang/OutOfMemoryError
    //   42	50	235	java/lang/OutOfMemoryError
    //   52	59	235	java/lang/OutOfMemoryError
    //   61	71	235	java/lang/OutOfMemoryError
    //   73	83	235	java/lang/OutOfMemoryError
    //   85	95	235	java/lang/OutOfMemoryError
    //   97	109	235	java/lang/OutOfMemoryError
    //   111	119	235	java/lang/OutOfMemoryError
    //   11	16	239	java/lang/Exception
    //   18	27	239	java/lang/Exception
    //   29	40	239	java/lang/Exception
    //   42	50	239	java/lang/Exception
    //   52	59	239	java/lang/Exception
    //   61	71	239	java/lang/Exception
    //   73	83	239	java/lang/Exception
    //   85	95	239	java/lang/Exception
    //   97	109	239	java/lang/Exception
    //   111	119	239	java/lang/Exception
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
    for (;;)
    {
      SecVerifyApk.ReportDetectResultPacket localReportDetectResultPacket;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localQQAppInterface == null) {
          return;
        }
        localReportDetectResultPacket = new SecVerifyApk.ReportDetectResultPacket();
        if (jdField_c_of_type_Boolean)
        {
          localReportDetectResultPacket.uint32_cmd.set(2);
          localReportDetectResultPacket.uint32_result.set(jdField_a_of_type_Int);
          localReportDetectResultPacket.uint32_appid.set(AppSetting.a());
          Object localObject1 = localQQAppInterface.getApplication().getApplicationInfo().sourceDir;
          if (localObject1 == null) {
            break;
          }
          if (!jdField_b_of_type_Boolean)
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
            if ((str2 == null) || (!str2.equalsIgnoreCase(jdField_b_of_type_JavaLangString)) || (localObject3 == null) || (!((String)localObject3).equalsIgnoreCase("8.3.5.4555"))) {
              break label455;
            }
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
          localReportDetectResultPacket.str_signature.set(d);
          localReportDetectResultPacket.str_apkmd5.set(jdField_a_of_type_JavaLangString);
          localReportDetectResultPacket.str_rsamd5.set(jdField_b_of_type_JavaLangString);
          localReportDetectResultPacket.str_txsfcfgkmd5.set(jdField_c_of_type_JavaLangString);
          localReportDetectResultPacket.str_apkversion.set("8.3.5.4555");
          localReportDetectResultPacket.str_channelid.set(AppSetting.c());
          localReportDetectResultPacket.str_uin.set(localQQAppInterface.getCurrentAccountUin());
          localReportDetectResultPacket.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
          localReportDetectResultPacket.str_sysversion.set(Build.VERSION.RELEASE);
          localReportDetectResultPacket.str_brand.set(Build.BRAND);
          localReportDetectResultPacket.str_model.set(Build.MODEL);
          localObject2 = localQQAppInterface.getApplication().getPackageName();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = "com.tencent.mobileqq";
          }
          localReportDetectResultPacket.package_name.set((String)localObject1);
          localObject1 = new ToServiceMsg("mobileqq.service", localQQAppInterface.getCurrentAccountUin(), "SecurityApk.VA");
          if (localObject1 == null) {
            break;
          }
          ((ToServiceMsg)localObject1).putWupBuffer(localReportDetectResultPacket.toByteArray());
          ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
          ((ToServiceMsg)localObject1).setNeedCallback(false);
          localQQAppInterface.sendToService((ToServiceMsg)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      localReportDetectResultPacket.uint32_cmd.set(1);
      continue;
      label455:
      d = bhrw.a(BaseApplication.getContext());
      jdField_a_of_type_JavaLangString = bhrw.a(localException);
      Object localObject2 = new byte[16];
      if (localObject2 != null)
      {
        bhpn.a(localException, "txsfcfg.dat", (byte[])localObject2);
        jdField_c_of_type_JavaLangString = bhrw.a((byte[])localObject2);
      }
      jdField_b_of_type_Boolean = true;
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
      localEditor.putString("SecVer", "8.3.5.4555");
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
      if (QLog.isColorLevel()) {
        QLog.d("SEC_VA", 2, "start");
      }
      if ((!jdField_c_of_type_Boolean) && (!a())) {
        return;
      }
      if (!jdField_a_of_type_Boolean)
      {
        Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject != null)
        {
          localObject = ((QQAppInterface)localObject).getApplication().getApplicationInfo().sourceDir;
          if (localObject != null)
          {
            jdField_a_of_type_Int = bhpo.a((String)localObject, "txsfcfg.dat");
            if ((jdField_a_of_type_Int != 0) && (jdField_a_of_type_Int != 143)) {
              jdField_a_of_type_Int = bhpo.a((String)localObject, "txsfcfg.dat");
            }
            jdField_a_of_type_Boolean = true;
          }
        }
      }
      else
      {
        long l2 = System.currentTimeMillis();
        b();
        long l3 = System.currentTimeMillis();
        c();
        long l4 = System.currentTimeMillis();
        QLog.d("SEC_VA", 1, "cost(" + (l2 - l1) + ":" + (l3 - l2) + ":" + (l4 - l3) + ")");
        return;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqprotect.sfcfg.QPTxVerifyApkTimerTask
 * JD-Core Version:    0.7.0.1
 */