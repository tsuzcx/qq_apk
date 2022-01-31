package com.tencent.mqp.app.bps;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import bevz;
import bewa;
import bewb;
import bhnp;
import com.tencent.common.config.AppSetting;
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

public class d
  extends TimerTask
{
  private static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean;
  private static String jdField_b_of_type_JavaLangString = "";
  private static boolean jdField_b_of_type_Boolean;
  private static String c = "";
  private static String d = "";
  private static String e;
  private static String f;
  private static String g;
  private static String h;
  private static String i;
  private static String j;
  private static String k;
  private static String l;
  private static String m;
  private static String n;
  private static String o = bevz.a(bevz.l);
  
  static
  {
    jdField_a_of_type_JavaLangString = bevz.a(bevz.a);
    jdField_b_of_type_JavaLangString = bevz.a(bevz.a);
    c = bevz.a(bevz.a);
    d = bevz.a(bevz.a);
    e = "";
    e = bevz.a(bevz.b);
    f = "";
    f = bevz.a(bevz.c);
    g = "";
    g = bevz.a(bevz.d);
    h = "";
    h = bevz.a(bevz.e);
    i = "";
    j = "";
    k = "";
    l = "";
    m = "";
    n = "";
    i = bevz.a(bevz.f);
    j = bevz.a(bevz.g);
    k = bevz.a(bevz.h);
    l = bevz.a(bevz.i);
    m = bevz.a(bevz.j);
    n = bevz.a(bevz.k);
    o = "";
  }
  
  /* Error */
  private String a(com.tencent.commonsdk.zip.QZipFile paramQZipFile, java.util.zip.ZipEntry paramZipEntry)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: aload_2
    //   5: invokevirtual 99	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: getstatic 101	bevz:m	[B
    //   14: invokestatic 42	bevz:a	([B)Ljava/lang/String;
    //   17: invokestatic 107	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore 4
    //   22: aload_2
    //   23: astore_1
    //   24: sipush 8192
    //   27: newarray byte
    //   29: astore 6
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: aload 6
    //   36: invokevirtual 113	java/io/InputStream:read	([B)I
    //   39: istore_3
    //   40: iload_3
    //   41: iconst_m1
    //   42: if_icmpeq +42 -> 84
    //   45: aload_2
    //   46: astore_1
    //   47: aload 4
    //   49: aload 6
    //   51: iconst_0
    //   52: iload_3
    //   53: invokevirtual 117	java/security/MessageDigest:update	([BII)V
    //   56: goto -25 -> 31
    //   59: astore 4
    //   61: aload_2
    //   62: astore_1
    //   63: aload 4
    //   65: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   68: aload 5
    //   70: astore_1
    //   71: aload_2
    //   72: ifnull +10 -> 82
    //   75: aload_2
    //   76: invokevirtual 123	java/io/InputStream:close	()V
    //   79: aload 5
    //   81: astore_1
    //   82: aload_1
    //   83: areturn
    //   84: aload_2
    //   85: astore_1
    //   86: aload 4
    //   88: invokevirtual 127	java/security/MessageDigest:digest	()[B
    //   91: invokestatic 130	bewa:a	([B)Ljava/lang/String;
    //   94: astore 4
    //   96: aload 4
    //   98: astore_1
    //   99: aload_2
    //   100: ifnull -18 -> 82
    //   103: aload_2
    //   104: invokevirtual 123	java/io/InputStream:close	()V
    //   107: aload 4
    //   109: areturn
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   115: aload 4
    //   117: areturn
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 123	java/io/InputStream:close	()V
    //   136: aload_2
    //   137: athrow
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   143: goto -7 -> 136
    //   146: astore_2
    //   147: goto -19 -> 128
    //   150: astore 4
    //   152: aconst_null
    //   153: astore_2
    //   154: goto -93 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	d
    //   0	157	1	paramQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   0	157	2	paramZipEntry	java.util.zip.ZipEntry
    //   39	14	3	i1	int
    //   20	28	4	localMessageDigest	java.security.MessageDigest
    //   59	28	4	localException1	Exception
    //   94	22	4	str	String
    //   150	1	4	localException2	Exception
    //   1	79	5	localObject	Object
    //   29	21	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   11	22	59	java/lang/Exception
    //   24	31	59	java/lang/Exception
    //   33	40	59	java/lang/Exception
    //   47	56	59	java/lang/Exception
    //   86	96	59	java/lang/Exception
    //   103	107	110	java/lang/Exception
    //   75	79	118	java/lang/Exception
    //   3	9	125	finally
    //   132	136	138	java/lang/Exception
    //   11	22	146	finally
    //   24	31	146	finally
    //   33	40	146	finally
    //   47	56	146	finally
    //   63	68	146	finally
    //   86	96	146	finally
    //   3	9	150	java/lang/Exception
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: new 95	com/tencent/commonsdk/zip/QZipFile
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 138	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_2
    //   12: invokevirtual 142	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   15: astore_3
    //   16: aload_2
    //   17: astore_1
    //   18: aload_3
    //   19: invokeinterface 148 1 0
    //   24: ifeq +120 -> 144
    //   27: aload_2
    //   28: astore_1
    //   29: aload_3
    //   30: invokeinterface 152 1 0
    //   35: checkcast 154	java/util/zip/ZipEntry
    //   38: astore 4
    //   40: aload_2
    //   41: astore_1
    //   42: aload 4
    //   44: invokevirtual 157	java/util/zip/ZipEntry:isDirectory	()Z
    //   47: ifne -31 -> 16
    //   50: aload_2
    //   51: astore_1
    //   52: aload 4
    //   54: invokevirtual 161	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   57: astore 5
    //   59: aload_2
    //   60: astore_1
    //   61: aload 5
    //   63: ldc 163
    //   65: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   68: ifne -52 -> 16
    //   71: aload_2
    //   72: astore_1
    //   73: aload 5
    //   75: getstatic 171	bevz:n	[B
    //   78: invokestatic 42	bevz:a	([B)Ljava/lang/String;
    //   81: invokevirtual 175	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   84: ifeq -68 -> 16
    //   87: aload_2
    //   88: astore_1
    //   89: aload 5
    //   91: getstatic 177	bevz:o	[B
    //   94: invokestatic 42	bevz:a	([B)Ljava/lang/String;
    //   97: invokevirtual 180	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   100: ifeq -84 -> 16
    //   103: aload_2
    //   104: astore_1
    //   105: aload 5
    //   107: bipush 47
    //   109: invokevirtual 184	java/lang/String:lastIndexOf	(I)I
    //   112: bipush 8
    //   114: if_icmpne -98 -> 16
    //   117: aload_2
    //   118: astore_1
    //   119: aload_0
    //   120: aload_2
    //   121: aload 4
    //   123: invokespecial 186	com/tencent/mqp/app/bps/d:a	(Lcom/tencent/commonsdk/zip/QZipFile;Ljava/util/zip/ZipEntry;)Ljava/lang/String;
    //   126: astore_3
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 187	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   135: aload_3
    //   136: areturn
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   142: aload_3
    //   143: areturn
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 187	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   159: goto -7 -> 152
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: astore_1
    //   167: aload_3
    //   168: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   171: aload_2
    //   172: ifnull -20 -> 152
    //   175: aload_2
    //   176: invokevirtual 187	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   179: goto -27 -> 152
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   187: goto -35 -> 152
    //   190: astore_3
    //   191: aconst_null
    //   192: astore_2
    //   193: aload_2
    //   194: astore_1
    //   195: aload_3
    //   196: invokevirtual 189	java/lang/OutOfMemoryError:printStackTrace	()V
    //   199: aload_2
    //   200: ifnull -48 -> 152
    //   203: aload_2
    //   204: invokevirtual 187	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   207: goto -55 -> 152
    //   210: astore_1
    //   211: aload_1
    //   212: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   215: goto -63 -> 152
    //   218: astore_2
    //   219: aconst_null
    //   220: astore_1
    //   221: aload_1
    //   222: ifnull +7 -> 229
    //   225: aload_1
    //   226: invokevirtual 187	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   229: aload_2
    //   230: athrow
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   236: goto -7 -> 229
    //   239: astore_2
    //   240: goto -19 -> 221
    //   243: astore_3
    //   244: goto -51 -> 193
    //   247: astore_3
    //   248: goto -83 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	d
    //   0	251	1	paramString	String
    //   8	196	2	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   218	12	2	localObject1	Object
    //   239	1	2	localObject2	Object
    //   15	128	3	localObject3	Object
    //   162	6	3	localException1	Exception
    //   190	6	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   243	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   247	1	3	localException2	Exception
    //   38	84	4	localZipEntry	java.util.zip.ZipEntry
    //   57	49	5	str	String
    // Exception table:
    //   from	to	target	type
    //   131	135	137	java/io/IOException
    //   148	152	154	java/io/IOException
    //   0	9	162	java/lang/Exception
    //   175	179	182	java/io/IOException
    //   0	9	190	java/lang/OutOfMemoryError
    //   203	207	210	java/io/IOException
    //   0	9	218	finally
    //   225	229	231	java/io/IOException
    //   11	16	239	finally
    //   18	27	239	finally
    //   29	40	239	finally
    //   42	50	239	finally
    //   52	59	239	finally
    //   61	71	239	finally
    //   73	87	239	finally
    //   89	103	239	finally
    //   105	117	239	finally
    //   119	127	239	finally
    //   167	171	239	finally
    //   195	199	239	finally
    //   11	16	243	java/lang/OutOfMemoryError
    //   18	27	243	java/lang/OutOfMemoryError
    //   29	40	243	java/lang/OutOfMemoryError
    //   42	50	243	java/lang/OutOfMemoryError
    //   52	59	243	java/lang/OutOfMemoryError
    //   61	71	243	java/lang/OutOfMemoryError
    //   73	87	243	java/lang/OutOfMemoryError
    //   89	103	243	java/lang/OutOfMemoryError
    //   105	117	243	java/lang/OutOfMemoryError
    //   119	127	243	java/lang/OutOfMemoryError
    //   11	16	247	java/lang/Exception
    //   18	27	247	java/lang/Exception
    //   29	40	247	java/lang/Exception
    //   42	50	247	java/lang/Exception
    //   52	59	247	java/lang/Exception
    //   61	71	247	java/lang/Exception
    //   73	87	247	java/lang/Exception
    //   89	103	247	java/lang/Exception
    //   105	117	247	java/lang/Exception
    //   119	127	247	java/lang/Exception
  }
  
  private boolean a()
  {
    try
    {
      long l1 = BaseApplication.getContext().getSharedPreferences(f, 0).getLong(i, 0L);
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
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localQQAppInterface == null) {
          return;
        }
        c localc = new c();
        localc.uint32_cmd.set(3);
        localc.uint32_result.set(jdField_a_of_type_Int);
        localc.uint32_appid.set(AppSetting.a());
        Object localObject1 = localQQAppInterface.getApplication().getApplicationInfo().sourceDir;
        if (localObject1 == null) {
          break;
        }
        if (!jdField_b_of_type_Boolean)
        {
          Object localObject3 = BaseApplication.getContext().getSharedPreferences(f, 0);
          localObject2 = ((SharedPreferences)localObject3).getString(j, null);
          String str1 = ((SharedPreferences)localObject3).getString(k, null);
          String str2 = ((SharedPreferences)localObject3).getString(l, null);
          String str3 = ((SharedPreferences)localObject3).getString(m, null);
          localObject3 = ((SharedPreferences)localObject3).getString(n, null);
          String str4 = a((String)localObject1);
          if (str4 != null) {
            jdField_b_of_type_JavaLangString = str4;
          }
          if ((str2 == null) || (!str2.equalsIgnoreCase(jdField_b_of_type_JavaLangString)) || (localObject3 == null) || (!((String)localObject3).equalsIgnoreCase("8.3.3.4515"))) {
            break label444;
          }
          if (localObject2 != null) {
            d = (String)localObject2;
          }
          if (str3 != null) {
            jdField_a_of_type_JavaLangString = str3;
          }
          if (str1 != null) {
            c = str1;
          }
        }
        localc.str_signature.set(d);
        localc.str_apkmd5.set(jdField_a_of_type_JavaLangString);
        localc.str_rsamd5.set(jdField_b_of_type_JavaLangString);
        localc.str_txsfcfgkmd5.set(c);
        localc.str_apkversion.set("8.3.3.4515");
        localc.str_channelid.set(AppSetting.c());
        localc.str_uin.set(localQQAppInterface.getCurrentAccountUin());
        localc.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
        localc.str_sysversion.set(Build.VERSION.RELEASE);
        localc.str_brand.set(Build.BRAND);
        localc.str_model.set(Build.MODEL);
        localObject2 = localQQAppInterface.getApplication().getPackageName();
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "com.tencent.mobileqq";
        }
        localc.package_name.set((String)localObject1);
        localObject1 = new ToServiceMsg("mobileqq.service", localQQAppInterface.getCurrentAccountUin(), e);
        if (localObject1 == null) {
          break;
        }
        ((ToServiceMsg)localObject1).putWupBuffer(localc.toByteArray());
        ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
        ((ToServiceMsg)localObject1).setNeedCallback(false);
        localQQAppInterface.sendToService((ToServiceMsg)localObject1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label444:
      d = bhnp.a(BaseApplication.getContext());
      jdField_a_of_type_JavaLangString = bhnp.a(localException);
      Object localObject2 = new byte[16];
      if (localObject2 != null)
      {
        bewa.a(localException, g, (byte[])localObject2);
        c = bhnp.a((byte[])localObject2);
      }
      jdField_b_of_type_Boolean = true;
    }
  }
  
  private void c()
  {
    try
    {
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(f, 0).edit();
      localEditor.putLong(i, System.currentTimeMillis());
      localEditor.putString(j, d);
      localEditor.putString(k, c);
      localEditor.putString(l, jdField_b_of_type_JavaLangString);
      localEditor.putString(m, jdField_a_of_type_JavaLangString);
      localEditor.putString(n, "8.3.3.4515");
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
        QLog.d(o, 2, "start");
      }
      if (!a()) {
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
            jdField_a_of_type_Int = bewb.a((String)localObject, g);
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
        QLog.d(o, 1, "cost(" + (l2 - l1) + ":" + (l3 - l2) + ":" + (l4 - l3) + ")");
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
    ThreadManager.post(new d.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.bps.d
 * JD-Core Version:    0.7.0.1
 */