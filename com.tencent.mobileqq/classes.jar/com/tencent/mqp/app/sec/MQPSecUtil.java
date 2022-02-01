package com.tencent.mqp.app.sec;

import android.content.Context;
import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MQPSecUtil
{
  public static int a = 1;
  private static MQPSecUtil a;
  
  static
  {
    String str1 = "x86";
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localBaseApplication.getFilesDir().getParent());
    ((StringBuilder)localObject2).append("/txlib/lib");
    ((StringBuilder)localObject2).append("mqpintchk");
    ((StringBuilder)localObject2).append(".so");
    localObject2 = new File(((StringBuilder)localObject2).toString());
    if (!((File)localObject2).exists()) {}
    for (;;)
    {
      try
      {
        boolean bool = Build.CPU_ABI.contains("x86");
        if (!bool)
        {
          if (!Build.CPU_ABI.contains("mip")) {
            break label279;
          }
          str1 = "mips";
        }
        if (str1 != "mips") {
          a(localBaseApplication, str1);
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      Object localObject1 = localObject2;
      if (!((File)localObject2).exists())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localBaseApplication.getFilesDir().getParent());
        ((StringBuilder)localObject1).append("/lib/lib");
        ((StringBuilder)localObject1).append("mqpintchk");
        ((StringBuilder)localObject1).append(".so");
        localObject1 = new File(((StringBuilder)localObject1).toString());
      }
      if (((File)localObject1).exists()) {}
      try
      {
        System.load(((File)localObject1).getAbsolutePath());
        i = 1;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        int i;
        label204:
        break label204;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cannot load library ");
        ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
        QLog.d("MQPSecUtil", 2, ((StringBuilder)localObject2).toString());
      }
      i = 0;
      if (i == 0) {}
      try
      {
        System.loadLibrary("mqpintchk");
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        label256:
        break label256;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MQPSecUtil", 2, "cannot load library mqpintchk");
      }
      return;
      label279:
      String str2 = "armeabi";
    }
  }
  
  /* Error */
  private static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 24	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 119
    //   11: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: ldc 121
    //   24: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_3
    //   29: ldc 123
    //   31: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_3
    //   36: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore_1
    //   40: new 24	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   47: astore_3
    //   48: aload_3
    //   49: aload_0
    //   50: invokevirtual 33	android/content/Context:getFilesDir	()Ljava/io/File;
    //   53: invokevirtual 39	java/io/File:getParent	()Ljava/lang/String;
    //   56: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_3
    //   61: ldc 125
    //   63: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_3
    //   68: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: astore_3
    //   72: new 24	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   79: astore 4
    //   81: aload 4
    //   83: aload_3
    //   84: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 4
    //   90: ldc 121
    //   92: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 4
    //   98: ldc 123
    //   100: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 4
    //   106: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore 5
    //   111: new 35	java/io/File
    //   114: dup
    //   115: aload_3
    //   116: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   119: invokevirtual 128	java/io/File:mkdirs	()Z
    //   122: pop
    //   123: aconst_null
    //   124: astore_3
    //   125: aconst_null
    //   126: astore 4
    //   128: aload_0
    //   129: invokevirtual 132	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   132: aload_1
    //   133: invokevirtual 138	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   136: astore_0
    //   137: new 140	java/io/FileOutputStream
    //   140: dup
    //   141: aload 5
    //   143: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   146: astore_1
    //   147: sipush 4096
    //   150: newarray byte
    //   152: astore_3
    //   153: aload_0
    //   154: aload_3
    //   155: invokevirtual 147	java/io/InputStream:read	([B)I
    //   158: istore_2
    //   159: iload_2
    //   160: ifle +13 -> 173
    //   163: aload_1
    //   164: aload_3
    //   165: iconst_0
    //   166: iload_2
    //   167: invokevirtual 153	java/io/OutputStream:write	([BII)V
    //   170: goto -17 -> 153
    //   173: aload_0
    //   174: ifnull +7 -> 181
    //   177: aload_0
    //   178: invokevirtual 156	java/io/InputStream:close	()V
    //   181: aload_1
    //   182: invokevirtual 157	java/io/OutputStream:close	()V
    //   185: return
    //   186: astore 4
    //   188: aload_0
    //   189: astore_3
    //   190: aload 4
    //   192: astore_0
    //   193: goto +25 -> 218
    //   196: goto +54 -> 250
    //   199: astore 5
    //   201: aload 4
    //   203: astore_1
    //   204: aload_0
    //   205: astore_3
    //   206: aload 5
    //   208: astore_0
    //   209: goto +9 -> 218
    //   212: astore_0
    //   213: aconst_null
    //   214: astore_3
    //   215: aload 4
    //   217: astore_1
    //   218: aload_3
    //   219: ifnull +10 -> 229
    //   222: aload_3
    //   223: invokevirtual 156	java/io/InputStream:close	()V
    //   226: goto +3 -> 229
    //   229: aload_1
    //   230: ifnull +14 -> 244
    //   233: aload_1
    //   234: invokevirtual 157	java/io/OutputStream:close	()V
    //   237: goto +7 -> 244
    //   240: aload_1
    //   241: invokevirtual 158	java/io/IOException:printStackTrace	()V
    //   244: aload_0
    //   245: athrow
    //   246: aconst_null
    //   247: astore_0
    //   248: aload_3
    //   249: astore_1
    //   250: aload_0
    //   251: ifnull +10 -> 261
    //   254: aload_0
    //   255: invokevirtual 156	java/io/InputStream:close	()V
    //   258: goto +3 -> 261
    //   261: aload_1
    //   262: ifnull +12 -> 274
    //   265: aload_1
    //   266: invokevirtual 157	java/io/OutputStream:close	()V
    //   269: return
    //   270: aload_0
    //   271: invokevirtual 158	java/io/IOException:printStackTrace	()V
    //   274: return
    //   275: astore_0
    //   276: goto -30 -> 246
    //   279: astore_1
    //   280: aload_3
    //   281: astore_1
    //   282: goto -32 -> 250
    //   285: astore_3
    //   286: goto -90 -> 196
    //   289: astore_1
    //   290: goto -50 -> 240
    //   293: astore_0
    //   294: goto -24 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramContext	Context
    //   0	297	1	paramString	String
    //   158	9	2	i	int
    //   7	274	3	localObject1	Object
    //   285	1	3	localException	java.lang.Exception
    //   79	48	4	localStringBuilder	StringBuilder
    //   186	30	4	localObject2	Object
    //   109	33	5	str	String
    //   199	8	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   147	153	186	finally
    //   153	159	186	finally
    //   163	170	186	finally
    //   137	147	199	finally
    //   128	137	212	finally
    //   128	137	275	java/lang/Exception
    //   137	147	279	java/lang/Exception
    //   147	153	285	java/lang/Exception
    //   153	159	285	java/lang/Exception
    //   163	170	285	java/lang/Exception
    //   222	226	289	java/io/IOException
    //   233	237	289	java/io/IOException
    //   177	181	293	java/io/IOException
    //   181	185	293	java/io/IOException
    //   254	258	293	java/io/IOException
    //   265	269	293	java/io/IOException
  }
  
  public static void do_report(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report_tracer:");
      localStringBuilder.append(paramString);
      QLog.d("MQPSecUtil", 2, localStringBuilder.toString());
    }
    ReportController.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "P_CliOper", "Safe_MQPSecUtil", "", "AntiTrace", paramString, 0, 0, "", "", "", "");
  }
  
  public static native boolean memchk(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public static native byte[] memreport(String paramString, int paramInt1, int paramInt2);
  
  public native void antitrace(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSecUtil
 * JD-Core Version:    0.7.0.1
 */