package com.tencent.mobileqq.msf.core.net.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class h
{
  private static final String a = "Traceroute";
  private boolean b = false;
  private String c = "";
  private String d = "";
  private int e = 30;
  private int f = 10;
  private h.a g = new h.a();
  
  public h(String paramString, boolean paramBoolean)
  {
    this.c = paramString;
    this.b = paramBoolean;
  }
  
  private String a(String paramString)
  {
    String str2 = "*";
    int i = paramString.indexOf("from");
    String str1 = str2;
    if (i >= 0)
    {
      int j = paramString.indexOf(" ", i + 5);
      str1 = str2;
      if (j > 0) {
        str1 = paramString.substring(i + 5, j);
      }
    }
    str1 = str1.trim();
    paramString = str1;
    if (str1.endsWith(":")) {
      paramString = str1.substring(0, str1.length() - 1).trim();
    }
    str1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str1 = "*";
    }
    return str1;
  }
  
  /* Error */
  private String a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 89	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: new 91	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   10: ldc 94
    //   12: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: getfield 34	com/tencent/mobileqq/msf/core/net/b/h:f	I
    //   19: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc 103
    //   24: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_2
    //   28: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc 53
    //   33: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_1
    //   37: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokevirtual 110	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   46: astore 4
    //   48: new 112	java/io/BufferedReader
    //   51: dup
    //   52: new 114	java/io/InputStreamReader
    //   55: dup
    //   56: aload 4
    //   58: invokevirtual 120	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   61: invokespecial 123	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   64: invokespecial 126	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   67: astore 5
    //   69: new 47	java/lang/String
    //   72: dup
    //   73: invokespecial 127	java/lang/String:<init>	()V
    //   76: pop
    //   77: ldc 26
    //   79: astore_1
    //   80: aload 5
    //   82: invokevirtual 130	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +91 -> 178
    //   90: new 91	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   97: aload_1
    //   98: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_3
    //   102: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: astore_3
    //   109: aload_3
    //   110: astore_1
    //   111: goto -31 -> 80
    //   114: astore_3
    //   115: ldc 26
    //   117: astore_1
    //   118: aload_3
    //   119: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   122: aload 4
    //   124: invokevirtual 136	java/lang/Process:exitValue	()I
    //   127: pop
    //   128: aload_1
    //   129: invokevirtual 139	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   132: areturn
    //   133: astore_1
    //   134: aload 4
    //   136: invokevirtual 136	java/lang/Process:exitValue	()I
    //   139: pop
    //   140: aload_1
    //   141: athrow
    //   142: astore_3
    //   143: aload 4
    //   145: invokevirtual 142	java/lang/Process:destroy	()V
    //   148: goto -8 -> 140
    //   151: astore 4
    //   153: aload_3
    //   154: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   157: goto -17 -> 140
    //   160: astore_3
    //   161: aload 4
    //   163: invokevirtual 142	java/lang/Process:destroy	()V
    //   166: goto -38 -> 128
    //   169: astore 4
    //   171: aload_3
    //   172: invokevirtual 133	java/lang/Exception:printStackTrace	()V
    //   175: goto -47 -> 128
    //   178: aload 4
    //   180: invokevirtual 136	java/lang/Process:exitValue	()I
    //   183: pop
    //   184: goto -56 -> 128
    //   187: astore_3
    //   188: aload 4
    //   190: invokevirtual 142	java/lang/Process:destroy	()V
    //   193: goto -65 -> 128
    //   196: astore 4
    //   198: goto -27 -> 171
    //   201: astore_3
    //   202: goto -84 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	h
    //   0	205	1	paramString	String
    //   0	205	2	paramInt	int
    //   85	25	3	str	String
    //   114	5	3	localException1	Exception
    //   142	12	3	localException2	Exception
    //   160	12	3	localException3	Exception
    //   187	1	3	localException4	Exception
    //   201	1	3	localException5	Exception
    //   46	98	4	localProcess	java.lang.Process
    //   151	11	4	localException6	Exception
    //   169	20	4	localException7	Exception
    //   196	1	4	localException8	Exception
    //   67	14	5	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   48	77	114	java/lang/Exception
    //   48	77	133	finally
    //   80	86	133	finally
    //   90	109	133	finally
    //   118	122	133	finally
    //   134	140	142	java/lang/Exception
    //   143	148	151	java/lang/Exception
    //   122	128	160	java/lang/Exception
    //   161	166	169	java/lang/Exception
    //   178	184	187	java/lang/Exception
    //   188	193	196	java/lang/Exception
    //   80	86	201	java/lang/Exception
    //   90	109	201	java/lang/Exception
  }
  
  private String b(String paramString)
  {
    String str = "";
    if (paramString.contains("ping")) {
      str = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
    }
    return str;
  }
  
  private String c()
  {
    if (TextUtils.isEmpty(this.d)) {
      return this.c;
    }
    return this.d;
  }
  
  public h.a a()
  {
    String str1 = "Traceroute start host: " + this.c + " maxTTL: " + this.e + " timeout: " + this.f + "s";
    if (this.b) {
      QLog.d("Traceroute", 1, str1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1).append("\n");
    int i = 1;
    if (i < this.e) {}
    for (;;)
    {
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        str1 = a(c(), i);
        long l2 = SystemClock.elapsedRealtime();
        String str3 = b(str1);
        if (!TextUtils.isEmpty(str3)) {
          this.d = str3;
        }
        str1 = a(str1);
        str3 = String.format("%10dms     %s", new Object[] { Long.valueOf(l2 - l1), str1 }).toString();
        localStringBuilder.append(str3).append("\n");
        if (this.b) {
          QLog.d("Traceroute", 1, str3);
        }
        if ((this.c.equals(str1)) || (this.d.equals(str1)))
        {
          this.g.b = true;
          this.g.a = i;
          if (!this.g.b) {
            break label420;
          }
          str1 = "Traceroute succ host: " + this.c + "(" + this.d + ") TTL: " + this.g.a;
          localStringBuilder.append(str1).append("\n");
          if (this.b) {
            QLog.d("Traceroute", 1, str1);
          }
          this.g.c = localStringBuilder.toString();
          return this.g;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str2 = "Ping error: " + localException.getMessage();
        if (this.b) {
          QLog.d("Traceroute", 1, str2);
        }
        localStringBuilder.append(str2).append("\n");
        i += 1;
      }
      break;
      label420:
      String str2 = "Traceroute fail host: " + this.c + "(" + this.d + ") TTL: " + this.g.a;
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public h.a b()
  {
    return this.g;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.h
 * JD-Core Version:    0.7.0.1
 */