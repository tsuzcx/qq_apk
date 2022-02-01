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
    int i = paramString.indexOf("from");
    if (i >= 0)
    {
      i += 5;
      int j = paramString.indexOf(" ", i);
      if (j > 0)
      {
        paramString = paramString.substring(i, j);
        break label40;
      }
    }
    paramString = "*";
    label40:
    String str = paramString.trim();
    paramString = str;
    if (str.endsWith(":")) {
      paramString = str.substring(0, str.length() - 1).trim();
    }
    str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "*";
    }
    return str;
  }
  
  /* Error */
  private String a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 26
    //   2: astore 4
    //   4: invokestatic 89	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   7: astore_3
    //   8: new 91	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   15: astore 5
    //   17: aload 5
    //   19: ldc 94
    //   21: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 5
    //   27: aload_0
    //   28: getfield 34	com/tencent/mobileqq/msf/core/net/b/h:f	I
    //   31: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 5
    //   37: ldc 103
    //   39: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 5
    //   45: iload_2
    //   46: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 5
    //   52: ldc 51
    //   54: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 5
    //   60: aload_1
    //   61: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_3
    //   66: aload 5
    //   68: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokevirtual 110	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   74: astore 5
    //   76: aload 4
    //   78: astore_3
    //   79: new 112	java/io/BufferedReader
    //   82: dup
    //   83: new 114	java/io/InputStreamReader
    //   86: dup
    //   87: aload 5
    //   89: invokevirtual 120	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   92: invokespecial 123	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   95: invokespecial 126	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   98: astore 6
    //   100: aload 4
    //   102: astore_3
    //   103: new 45	java/lang/String
    //   106: dup
    //   107: invokespecial 127	java/lang/String:<init>	()V
    //   110: pop
    //   111: aload 4
    //   113: astore_1
    //   114: aload_1
    //   115: astore_3
    //   116: aload 6
    //   118: invokevirtual 130	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   121: astore 4
    //   123: aload 4
    //   125: ifnull +44 -> 169
    //   128: aload_1
    //   129: astore_3
    //   130: new 91	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   137: astore 7
    //   139: aload_1
    //   140: astore_3
    //   141: aload 7
    //   143: aload_1
    //   144: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_1
    //   149: astore_3
    //   150: aload 7
    //   152: aload 4
    //   154: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_1
    //   159: astore_3
    //   160: aload 7
    //   162: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore_1
    //   166: goto -52 -> 114
    //   169: aload 5
    //   171: invokevirtual 133	java/lang/Process:exitValue	()I
    //   174: pop
    //   175: goto +49 -> 224
    //   178: astore_3
    //   179: aload 5
    //   181: invokevirtual 136	java/lang/Process:destroy	()V
    //   184: goto +40 -> 224
    //   187: aload_3
    //   188: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   191: goto +33 -> 224
    //   194: astore_1
    //   195: goto +34 -> 229
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   203: aload 5
    //   205: invokevirtual 133	java/lang/Process:exitValue	()I
    //   208: pop
    //   209: aload_3
    //   210: astore_1
    //   211: goto +13 -> 224
    //   214: astore 4
    //   216: aload_3
    //   217: astore_1
    //   218: aload 4
    //   220: astore_3
    //   221: goto -42 -> 179
    //   224: aload_1
    //   225: invokevirtual 142	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   228: areturn
    //   229: aload 5
    //   231: invokevirtual 133	java/lang/Process:exitValue	()I
    //   234: pop
    //   235: goto +16 -> 251
    //   238: astore_3
    //   239: aload 5
    //   241: invokevirtual 136	java/lang/Process:destroy	()V
    //   244: goto +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 139	java/lang/Exception:printStackTrace	()V
    //   251: goto +5 -> 256
    //   254: aload_1
    //   255: athrow
    //   256: goto -2 -> 254
    //   259: astore 4
    //   261: goto -74 -> 187
    //   264: astore 4
    //   266: goto -19 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	h
    //   0	269	1	paramString	String
    //   0	269	2	paramInt	int
    //   7	153	3	localObject1	Object
    //   178	39	3	localException1	Exception
    //   220	1	3	localException2	Exception
    //   238	10	3	localException3	Exception
    //   2	151	4	str	String
    //   214	5	4	localException4	Exception
    //   259	1	4	localException5	Exception
    //   264	1	4	localException6	Exception
    //   15	225	5	localObject2	Object
    //   98	19	6	localBufferedReader	java.io.BufferedReader
    //   137	24	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   169	175	178	java/lang/Exception
    //   79	100	194	finally
    //   103	111	194	finally
    //   116	123	194	finally
    //   130	139	194	finally
    //   141	148	194	finally
    //   150	158	194	finally
    //   160	166	194	finally
    //   199	203	194	finally
    //   79	100	198	java/lang/Exception
    //   103	111	198	java/lang/Exception
    //   116	123	198	java/lang/Exception
    //   130	139	198	java/lang/Exception
    //   141	148	198	java/lang/Exception
    //   150	158	198	java/lang/Exception
    //   160	166	198	java/lang/Exception
    //   203	209	214	java/lang/Exception
    //   229	235	238	java/lang/Exception
    //   179	184	259	java/lang/Exception
    //   239	244	264	java/lang/Exception
  }
  
  private String b(String paramString)
  {
    if (paramString.contains("ping")) {
      return paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
    }
    return "";
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Traceroute start host: ");
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append(" maxTTL: ");
    ((StringBuilder)localObject1).append(this.e);
    ((StringBuilder)localObject1).append(" timeout: ");
    ((StringBuilder)localObject1).append(this.f);
    ((StringBuilder)localObject1).append("s");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (this.b) {
      QLog.d("Traceroute", 1, (String)localObject1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("\n");
    int i = 1;
    Object localObject2;
    while (i < this.e) {
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        localObject1 = a(c(), i);
        long l2 = SystemClock.elapsedRealtime();
        localObject3 = b((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          this.d = ((String)localObject3);
        }
        localObject1 = a((String)localObject1);
        localObject3 = String.format("%10dms     %s", new Object[] { Long.valueOf(l2 - l1), localObject1 }).toString();
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append("\n");
        if (this.b) {
          QLog.d("Traceroute", 1, (String)localObject3);
        }
        if ((this.c.equals(localObject1)) || (this.d.equals(localObject1)))
        {
          this.g.b = true;
          this.g.a = i;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Ping error: ");
        ((StringBuilder)localObject3).append(localException.getMessage());
        localObject2 = ((StringBuilder)localObject3).toString();
        if (this.b) {
          QLog.d("Traceroute", 1, (String)localObject2);
        }
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("\n");
        i += 1;
      }
    }
    if (this.g.b)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Traceroute succ host: ");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(this.d);
      ((StringBuilder)localObject2).append(") TTL: ");
      ((StringBuilder)localObject2).append(this.g.a);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Traceroute fail host: ");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(this.d);
      ((StringBuilder)localObject2).append(") TTL: ");
      ((StringBuilder)localObject2).append(this.g.a);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("\n");
    if (this.b) {
      QLog.d("Traceroute", 1, (String)localObject2);
    }
    this.g.c = localStringBuilder.toString();
    return this.g;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.h
 * JD-Core Version:    0.7.0.1
 */