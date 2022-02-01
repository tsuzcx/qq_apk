package com.tencent.mqp.app.bps;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
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
import com.tencent.usq.u;
import mqq.app.MobileQQ;

public class d
{
  public static Runnable a = new d.1();
  private static String b = StringManager.a(StringManager.a);
  private static String c = StringManager.a(StringManager.a);
  private static String d = StringManager.a(StringManager.a);
  private static String e = StringManager.a(StringManager.a);
  private static String f = "";
  private static boolean g;
  private static boolean h;
  private static int i;
  private static String j;
  private static String k;
  private static String l;
  private static String m;
  private static String n;
  private static String o;
  private static String p;
  private static String q;
  private static String r;
  private static String s;
  private static Handler t;
  
  static
  {
    f = StringManager.a(StringManager.b);
    g = false;
    h = false;
    i = 0;
    j = "";
    j = StringManager.a(StringManager.c);
    k = "";
    k = StringManager.a(StringManager.d);
    l = "";
    l = StringManager.a(StringManager.e);
    m = "";
    n = "";
    o = "";
    p = "";
    q = "";
    r = "";
    m = StringManager.a(StringManager.f);
    n = StringManager.a(StringManager.g);
    o = StringManager.a(StringManager.h);
    p = StringManager.a(StringManager.i);
    q = StringManager.a(StringManager.j);
    r = StringManager.a(StringManager.k);
    s = "";
    s = StringManager.a(StringManager.l);
    t = new Handler(ThreadManager.getFileThreadLooper());
  }
  
  /* Error */
  private static String a(com.tencent.commonsdk.zip.QZipFile paramQZipFile, java.util.zip.ZipEntry paramZipEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 130	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   5: astore_1
    //   6: aload_1
    //   7: astore_0
    //   8: getstatic 132	com/tencent/mqp/app/bps/StringManager:m	[B
    //   11: invokestatic 41	com/tencent/mqp/app/bps/StringManager:a	([B)Ljava/lang/String;
    //   14: invokestatic 138	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   17: astore_3
    //   18: aload_1
    //   19: astore_0
    //   20: sipush 8192
    //   23: newarray byte
    //   25: astore 4
    //   27: aload_1
    //   28: astore_0
    //   29: aload_1
    //   30: aload 4
    //   32: invokevirtual 144	java/io/InputStream:read	([B)I
    //   35: istore_2
    //   36: iload_2
    //   37: iconst_m1
    //   38: if_icmpeq +16 -> 54
    //   41: aload_1
    //   42: astore_0
    //   43: aload_3
    //   44: aload 4
    //   46: iconst_0
    //   47: iload_2
    //   48: invokevirtual 148	java/security/MessageDigest:update	([BII)V
    //   51: goto -24 -> 27
    //   54: aload_1
    //   55: astore_0
    //   56: aload_3
    //   57: invokevirtual 152	java/security/MessageDigest:digest	()[B
    //   60: invokestatic 155	com/tencent/mqp/app/bps/TXSafeCheckUtilClone:a	([B)Ljava/lang/String;
    //   63: astore_3
    //   64: aload_1
    //   65: ifnull +14 -> 79
    //   68: aload_1
    //   69: invokevirtual 158	java/io/InputStream:close	()V
    //   72: aload_3
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   79: aload_3
    //   80: areturn
    //   81: astore_1
    //   82: goto +39 -> 121
    //   85: astore_3
    //   86: goto +12 -> 98
    //   89: astore_1
    //   90: aconst_null
    //   91: astore_0
    //   92: goto +29 -> 121
    //   95: astore_3
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_1
    //   99: astore_0
    //   100: aload_3
    //   101: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   104: aload_1
    //   105: ifnull +14 -> 119
    //   108: aload_1
    //   109: invokevirtual 158	java/io/InputStream:close	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   119: aconst_null
    //   120: areturn
    //   121: aload_0
    //   122: ifnull +15 -> 137
    //   125: aload_0
    //   126: invokevirtual 158	java/io/InputStream:close	()V
    //   129: goto +8 -> 137
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   137: goto +5 -> 142
    //   140: aload_1
    //   141: athrow
    //   142: goto -2 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   0	145	1	paramZipEntry	java.util.zip.ZipEntry
    //   35	13	2	i1	int
    //   17	63	3	localObject	Object
    //   85	1	3	localException1	Exception
    //   95	6	3	localException2	Exception
    //   25	20	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   68	72	74	java/lang/Exception
    //   8	18	81	finally
    //   20	27	81	finally
    //   29	36	81	finally
    //   43	51	81	finally
    //   56	64	81	finally
    //   100	104	81	finally
    //   8	18	85	java/lang/Exception
    //   20	27	85	java/lang/Exception
    //   29	36	85	java/lang/Exception
    //   43	51	85	java/lang/Exception
    //   56	64	85	java/lang/Exception
    //   0	6	89	finally
    //   0	6	95	java/lang/Exception
    //   108	112	114	java/lang/Exception
    //   125	129	132	java/lang/Exception
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: new 126	com/tencent/commonsdk/zip/QZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 169	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 173	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   15: astore_2
    //   16: aload_1
    //   17: astore_0
    //   18: aload_2
    //   19: invokeinterface 179 1 0
    //   24: ifeq +117 -> 141
    //   27: aload_1
    //   28: astore_0
    //   29: aload_2
    //   30: invokeinterface 183 1 0
    //   35: checkcast 185	java/util/zip/ZipEntry
    //   38: astore_3
    //   39: aload_1
    //   40: astore_0
    //   41: aload_3
    //   42: invokevirtual 188	java/util/zip/ZipEntry:isDirectory	()Z
    //   45: ifeq +6 -> 51
    //   48: goto -32 -> 16
    //   51: aload_1
    //   52: astore_0
    //   53: aload_3
    //   54: invokevirtual 192	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   57: astore 4
    //   59: aload_1
    //   60: astore_0
    //   61: aload 4
    //   63: ldc 194
    //   65: invokevirtual 200	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   68: ifeq +6 -> 74
    //   71: goto -55 -> 16
    //   74: aload_1
    //   75: astore_0
    //   76: aload 4
    //   78: getstatic 202	com/tencent/mqp/app/bps/StringManager:n	[B
    //   81: invokestatic 41	com/tencent/mqp/app/bps/StringManager:a	([B)Ljava/lang/String;
    //   84: invokevirtual 206	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   87: ifeq -71 -> 16
    //   90: aload_1
    //   91: astore_0
    //   92: aload 4
    //   94: getstatic 208	com/tencent/mqp/app/bps/StringManager:o	[B
    //   97: invokestatic 41	com/tencent/mqp/app/bps/StringManager:a	([B)Ljava/lang/String;
    //   100: invokevirtual 211	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   103: ifeq -87 -> 16
    //   106: aload_1
    //   107: astore_0
    //   108: aload 4
    //   110: bipush 47
    //   112: invokevirtual 215	java/lang/String:lastIndexOf	(I)I
    //   115: bipush 8
    //   117: if_icmpne -101 -> 16
    //   120: aload_1
    //   121: astore_0
    //   122: aload_1
    //   123: aload_3
    //   124: invokestatic 217	com/tencent/mqp/app/bps/d:a	(Lcom/tencent/commonsdk/zip/QZipFile;Ljava/util/zip/ZipEntry;)Ljava/lang/String;
    //   127: astore_2
    //   128: aload_1
    //   129: invokevirtual 218	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   132: aload_2
    //   133: areturn
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   139: aload_2
    //   140: areturn
    //   141: aload_1
    //   142: invokevirtual 218	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_2
    //   148: goto +16 -> 164
    //   151: astore_2
    //   152: goto +31 -> 183
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_0
    //   158: goto +49 -> 207
    //   161: astore_2
    //   162: aconst_null
    //   163: astore_1
    //   164: aload_1
    //   165: astore_0
    //   166: aload_2
    //   167: invokevirtual 220	java/lang/OutOfMemoryError:printStackTrace	()V
    //   170: aload_1
    //   171: ifnull +33 -> 204
    //   174: aload_1
    //   175: invokevirtual 218	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: astore_0
    //   185: aload_2
    //   186: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   189: aload_1
    //   190: ifnull +14 -> 204
    //   193: aload_1
    //   194: invokevirtual 218	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   197: aconst_null
    //   198: areturn
    //   199: astore_0
    //   200: aload_0
    //   201: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_1
    //   207: aload_0
    //   208: ifnull +15 -> 223
    //   211: aload_0
    //   212: invokevirtual 218	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   215: goto +8 -> 223
    //   218: astore_0
    //   219: aload_0
    //   220: invokevirtual 219	java/io/IOException:printStackTrace	()V
    //   223: goto +5 -> 228
    //   226: aload_1
    //   227: athrow
    //   228: goto -2 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramString	String
    //   8	134	1	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   155	1	1	localObject1	Object
    //   163	31	1	localObject2	Object
    //   206	21	1	localObject3	Object
    //   15	125	2	localObject4	Object
    //   147	1	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   151	1	2	localException1	Exception
    //   161	6	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   180	6	2	localException2	Exception
    //   38	86	3	localZipEntry	java.util.zip.ZipEntry
    //   57	52	4	str	String
    // Exception table:
    //   from	to	target	type
    //   128	132	134	java/io/IOException
    //   11	16	147	java/lang/OutOfMemoryError
    //   18	27	147	java/lang/OutOfMemoryError
    //   29	39	147	java/lang/OutOfMemoryError
    //   41	48	147	java/lang/OutOfMemoryError
    //   53	59	147	java/lang/OutOfMemoryError
    //   61	71	147	java/lang/OutOfMemoryError
    //   76	90	147	java/lang/OutOfMemoryError
    //   92	106	147	java/lang/OutOfMemoryError
    //   108	120	147	java/lang/OutOfMemoryError
    //   122	128	147	java/lang/OutOfMemoryError
    //   11	16	151	java/lang/Exception
    //   18	27	151	java/lang/Exception
    //   29	39	151	java/lang/Exception
    //   41	48	151	java/lang/Exception
    //   53	59	151	java/lang/Exception
    //   61	71	151	java/lang/Exception
    //   76	90	151	java/lang/Exception
    //   92	106	151	java/lang/Exception
    //   108	120	151	java/lang/Exception
    //   122	128	151	java/lang/Exception
    //   0	9	155	finally
    //   0	9	161	java/lang/OutOfMemoryError
    //   0	9	180	java/lang/Exception
    //   141	145	199	java/io/IOException
    //   174	178	199	java/io/IOException
    //   193	197	199	java/io/IOException
    //   11	16	206	finally
    //   18	27	206	finally
    //   29	39	206	finally
    //   41	48	206	finally
    //   53	59	206	finally
    //   61	71	206	finally
    //   76	90	206	finally
    //   92	106	206	finally
    //   108	120	206	finally
    //   122	128	206	finally
    //   166	170	206	finally
    //   185	189	206	finally
    //   211	215	218	java/io/IOException
  }
  
  public static void a()
  {
    t.removeCallbacks(a);
    t.postDelayed(a, 210000L);
  }
  
  private static void a(long paramLong)
  {
    t.removeCallbacks(a);
    t.postDelayed(a, paramLong);
  }
  
  public static void b()
  {
    if (e() == true) {
      c();
    }
    a(86400000L);
  }
  
  private static void c()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(s, 2, "start");
      }
      if (!g)
      {
        localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject == null) {
          return;
        }
        localObject = ((QQAppInterface)localObject).getApplication().getApplicationInfo().sourceDir;
        if (localObject == null) {
          return;
        }
        i = TXVerifyAPKUtilClone.a((String)localObject, k);
        g = true;
      }
      long l2 = System.currentTimeMillis();
      d();
      long l3 = System.currentTimeMillis();
      f();
      long l4 = System.currentTimeMillis();
      Object localObject = s;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cost(");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(":");
      localStringBuilder.append(l3 - l2);
      localStringBuilder.append(":");
      localStringBuilder.append(l4 - l3);
      localStringBuilder.append(")");
      QLog.d((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void d()
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localQQAppInterface == null) {
        return;
      }
      c localc = new c();
      localc.uint32_cmd.set(3);
      localc.uint32_result.set(i);
      localc.uint32_appid.set(AppSetting.d());
      Object localObject1 = localQQAppInterface.getApplication().getApplicationInfo().sourceDir;
      if (localObject1 == null) {
        return;
      }
      boolean bool = h;
      if (!bool)
      {
        Object localObject3 = BaseApplication.getContext().getSharedPreferences(j, 0);
        localObject2 = ((SharedPreferences)localObject3).getString(n, null);
        String str1 = ((SharedPreferences)localObject3).getString(o, null);
        String str2 = ((SharedPreferences)localObject3).getString(p, null);
        String str3 = ((SharedPreferences)localObject3).getString(q, null);
        localObject3 = ((SharedPreferences)localObject3).getString(r, null);
        String str4 = a((String)localObject1);
        if (str4 != null) {
          c = str4;
        }
        if ((str2 != null) && (str2.equalsIgnoreCase(c)) && (localObject3 != null) && (((String)localObject3).equalsIgnoreCase("8.8.17.5770")))
        {
          if (localObject2 != null) {
            e = (String)localObject2;
          }
          if (str3 != null) {
            b = str3;
          }
          if (str1 != null) {
            d = str1;
          }
        }
        else
        {
          e = u.a(BaseApplication.getContext());
          b = u.a((String)localObject1);
          localObject2 = new byte[16];
          TXSafeCheckUtilClone.a((String)localObject1, k, (byte[])localObject2);
          d = u.a((byte[])localObject2);
          h = true;
        }
      }
      localc.str_signature.set(e);
      localc.str_apkmd5.set(b);
      localc.str_rsamd5.set(c);
      localc.str_txsfcfgkmd5.set(d);
      localc.str_apkversion.set("8.8.17.5770");
      localc.str_channelid.set(AppSetting.e());
      localc.str_uin.set(localQQAppInterface.getCurrentAccountUin());
      localc.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
      localc.str_sysversion.set(Build.VERSION.RELEASE);
      localc.str_brand.set(Build.BRAND);
      localc.str_model.set(Build.MODEL);
      Object localObject2 = localQQAppInterface.getApplication().getPackageName();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "com.tencent.mobileqq";
      }
      localc.package_name.set((String)localObject1);
      localObject1 = new ToServiceMsg("mobileqq.service", localQQAppInterface.getCurrentAccountUin(), f);
      ((ToServiceMsg)localObject1).putWupBuffer(localc.toByteArray());
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
  
  private static boolean e()
  {
    try
    {
      long l1 = BaseApplication.getContext().getSharedPreferences(j, 0).getLong(m, 0L);
      long l2 = System.currentTimeMillis();
      return l2 - l1 >= 86400000L;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  private static void f()
  {
    try
    {
      SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(j, 0).edit();
      localEditor.putLong(m, System.currentTimeMillis());
      localEditor.putString(n, e);
      localEditor.putString(o, d);
      localEditor.putString(p, c);
      localEditor.putString(q, b);
      localEditor.putString(r, "8.8.17.5770");
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqp.app.bps.d
 * JD-Core Version:    0.7.0.1
 */