package com.tencent.qmsp.sdk.b;

import com.tencent.qmsp.sdk.f.k;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class a
{
  private static final byte[] a = { 49, 99, -3, 81, 63, 117, 116, -14, 40 };
  private static final byte[] b = { 4, 85, -128 };
  private static final byte[] c = { 4, 85, -128, 15, 13, 25, 84, -78, 21, 91, -112, 115, 123, 11, 118, -7, 33, 121, -67, 71 };
  private static final byte[] d = { -58, -26, -51, -19 };
  private static final byte[] e = { -58, -26, -51, -19, 30, -3, -21, -29, 87, 39, 40, 12, -119, -40, -84, 65 };
  private static final a.b f = a.b.d;
  private static ThreadLocal<Integer> g = new ThreadLocal();
  
  /* Error */
  public static a.d a(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: getstatic 83	com/tencent/qmsp/sdk/b/a:g	Ljava/lang/ThreadLocal;
    //   3: getstatic 92	com/tencent/qmsp/sdk/b/a$c:c	Lcom/tencent/qmsp/sdk/b/a$c;
    //   6: invokevirtual 95	com/tencent/qmsp/sdk/b/a$c:a	()I
    //   9: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12: invokevirtual 105	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   15: new 107	java/net/InetSocketAddress
    //   18: dup
    //   19: getstatic 28	com/tencent/qmsp/sdk/b/a:a	[B
    //   22: invokestatic 112	com/tencent/qmsp/sdk/f/k:a	([B)Ljava/lang/String;
    //   25: ldc 113
    //   27: invokespecial 116	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   30: astore 9
    //   32: iconst_0
    //   33: istore 4
    //   35: aconst_null
    //   36: astore 7
    //   38: iload 4
    //   40: iconst_1
    //   41: if_icmpge +324 -> 365
    //   44: new 118	java/net/Socket
    //   47: dup
    //   48: invokespecial 119	java/net/Socket:<init>	()V
    //   51: astore 10
    //   53: aload 10
    //   55: aload 9
    //   57: invokestatic 125	com/tencent/qmsp/sdk/app/QmspSDK:getAtomConnTimeOut	()Ljava/util/concurrent/atomic/AtomicInteger;
    //   60: invokevirtual 130	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   63: invokevirtual 134	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   66: new 136	java/io/DataOutputStream
    //   69: dup
    //   70: new 138	java/io/BufferedOutputStream
    //   73: dup
    //   74: aload 10
    //   76: invokevirtual 142	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   79: invokespecial 145	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   82: invokespecial 146	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   85: astore 5
    //   87: aload 5
    //   89: astore 6
    //   91: iload_0
    //   92: aload_1
    //   93: iload_2
    //   94: aload_3
    //   95: aload 5
    //   97: invokestatic 149	com/tencent/qmsp/sdk/b/a:a	(ILjava/lang/String;ILorg/json/JSONObject;Ljava/io/DataOutputStream;)V
    //   100: aload 5
    //   102: astore 6
    //   104: aload 10
    //   106: invokestatic 152	com/tencent/qmsp/sdk/app/QmspSDK:getAtomReadTimeOut	()Ljava/util/concurrent/atomic/AtomicInteger;
    //   109: invokevirtual 130	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   112: invokevirtual 156	java/net/Socket:setSoTimeout	(I)V
    //   115: aload 5
    //   117: astore 6
    //   119: new 158	java/io/DataInputStream
    //   122: dup
    //   123: new 160	java/io/BufferedInputStream
    //   126: dup
    //   127: aload 10
    //   129: invokevirtual 164	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   132: invokespecial 167	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   135: invokespecial 168	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   138: astore 8
    //   140: new 170	com/tencent/qmsp/sdk/b/a$d
    //   143: dup
    //   144: aload 8
    //   146: invokestatic 173	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/DataInputStream;)Lorg/json/JSONObject;
    //   149: getstatic 83	com/tencent/qmsp/sdk/b/a:g	Ljava/lang/ThreadLocal;
    //   152: invokevirtual 176	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   155: checkcast 97	java/lang/Integer
    //   158: invokevirtual 179	java/lang/Integer:intValue	()I
    //   161: invokespecial 182	com/tencent/qmsp/sdk/b/a$d:<init>	(Lorg/json/JSONObject;I)V
    //   164: astore 6
    //   166: aload 8
    //   168: invokestatic 185	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   171: aload 5
    //   173: invokestatic 185	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   176: aload 10
    //   178: invokevirtual 188	java/net/Socket:close	()V
    //   181: aload 6
    //   183: areturn
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   189: aload 6
    //   191: areturn
    //   192: aload 8
    //   194: astore 7
    //   196: goto +94 -> 290
    //   199: aconst_null
    //   200: astore 5
    //   202: aload 5
    //   204: astore 6
    //   206: new 170	com/tencent/qmsp/sdk/b/a$d
    //   209: dup
    //   210: aconst_null
    //   211: getstatic 194	com/tencent/qmsp/sdk/b/a$c:i	Lcom/tencent/qmsp/sdk/b/a$c;
    //   214: invokevirtual 95	com/tencent/qmsp/sdk/b/a$c:a	()I
    //   217: invokespecial 182	com/tencent/qmsp/sdk/b/a$d:<init>	(Lorg/json/JSONObject;I)V
    //   220: astore 8
    //   222: aconst_null
    //   223: invokestatic 185	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   226: aload 5
    //   228: invokestatic 185	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   231: aload 10
    //   233: invokevirtual 188	java/net/Socket:close	()V
    //   236: aload 8
    //   238: areturn
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   244: aload 8
    //   246: areturn
    //   247: new 170	com/tencent/qmsp/sdk/b/a$d
    //   250: dup
    //   251: aconst_null
    //   252: getstatic 197	com/tencent/qmsp/sdk/b/a$c:h	Lcom/tencent/qmsp/sdk/b/a$c;
    //   255: invokevirtual 95	com/tencent/qmsp/sdk/b/a$c:a	()I
    //   258: invokespecial 182	com/tencent/qmsp/sdk/b/a$d:<init>	(Lorg/json/JSONObject;I)V
    //   261: astore 5
    //   263: aconst_null
    //   264: invokestatic 185	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   267: aconst_null
    //   268: invokestatic 185	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   271: aload 10
    //   273: invokevirtual 188	java/net/Socket:close	()V
    //   276: aload 5
    //   278: areturn
    //   279: astore_1
    //   280: aload_1
    //   281: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   284: aload 5
    //   286: areturn
    //   287: aconst_null
    //   288: astore 5
    //   290: getstatic 83	com/tencent/qmsp/sdk/b/a:g	Ljava/lang/ThreadLocal;
    //   293: getstatic 200	com/tencent/qmsp/sdk/b/a$c:l	Lcom/tencent/qmsp/sdk/b/a$c;
    //   296: invokevirtual 95	com/tencent/qmsp/sdk/b/a$c:a	()I
    //   299: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   302: invokevirtual 105	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   305: aload 7
    //   307: invokestatic 185	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   310: aload 5
    //   312: invokestatic 185	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   315: aload 10
    //   317: invokevirtual 188	java/net/Socket:close	()V
    //   320: goto +10 -> 330
    //   323: astore 5
    //   325: aload 5
    //   327: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   330: iload 4
    //   332: iconst_1
    //   333: iadd
    //   334: istore 4
    //   336: goto -301 -> 35
    //   339: astore_1
    //   340: aload 7
    //   342: invokestatic 185	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   345: aload 5
    //   347: invokestatic 185	com/tencent/qmsp/sdk/b/a:a	(Ljava/io/Closeable;)V
    //   350: aload 10
    //   352: invokevirtual 188	java/net/Socket:close	()V
    //   355: goto +8 -> 363
    //   358: astore_3
    //   359: aload_3
    //   360: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   363: aload_1
    //   364: athrow
    //   365: new 170	com/tencent/qmsp/sdk/b/a$d
    //   368: dup
    //   369: aconst_null
    //   370: getstatic 83	com/tencent/qmsp/sdk/b/a:g	Ljava/lang/ThreadLocal;
    //   373: invokevirtual 176	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   376: checkcast 97	java/lang/Integer
    //   379: invokevirtual 179	java/lang/Integer:intValue	()I
    //   382: invokespecial 182	com/tencent/qmsp/sdk/b/a$d:<init>	(Lorg/json/JSONObject;I)V
    //   385: areturn
    //   386: astore 5
    //   388: goto -141 -> 247
    //   391: astore 5
    //   393: goto -106 -> 287
    //   396: astore 5
    //   398: goto -199 -> 199
    //   401: astore 6
    //   403: goto -201 -> 202
    //   406: astore 5
    //   408: aload 6
    //   410: astore 5
    //   412: goto -122 -> 290
    //   415: astore 6
    //   417: goto -225 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	paramInt1	int
    //   0	420	1	paramString	String
    //   0	420	2	paramInt2	int
    //   0	420	3	paramJSONObject	JSONObject
    //   33	302	4	i	int
    //   85	226	5	localObject1	Object
    //   323	23	5	localIOException1	IOException
    //   386	1	5	localIOException2	IOException
    //   391	1	5	localObject2	Object
    //   396	1	5	localIOException3	IOException
    //   406	1	5	localObject3	Object
    //   410	1	5	localObject4	Object
    //   89	116	6	localObject5	Object
    //   401	8	6	localIOException4	IOException
    //   415	1	6	localObject6	Object
    //   36	305	7	localObject7	Object
    //   138	107	8	localObject8	Object
    //   30	26	9	localInetSocketAddress	java.net.InetSocketAddress
    //   51	300	10	localSocket	java.net.Socket
    // Exception table:
    //   from	to	target	type
    //   176	181	184	java/io/IOException
    //   231	236	239	java/io/IOException
    //   271	276	279	java/io/IOException
    //   315	320	323	java/io/IOException
    //   290	305	339	finally
    //   350	355	358	java/io/IOException
    //   53	66	386	java/io/IOException
    //   53	66	391	finally
    //   66	87	391	finally
    //   247	263	391	finally
    //   66	87	396	java/io/IOException
    //   91	100	401	java/io/IOException
    //   91	100	406	finally
    //   104	115	406	finally
    //   119	140	406	finally
    //   206	222	406	finally
    //   140	166	415	finally
  }
  
  private static JSONObject a(a.b paramb, byte[] paramArrayOfByte)
  {
    int i = a.a.a[paramb.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return null;
      }
      return new JSONObject(new String(paramArrayOfByte, Charset.forName("UTF-8")));
    }
    paramb = new SecretKeySpec(e, k.a(b));
    Cipher localCipher = Cipher.getInstance(k.a(c));
    localCipher.init(2, paramb, new IvParameterSpec(e));
    return new JSONObject(new String(localCipher.doFinal(paramArrayOfByte), Charset.forName("UTF-8")));
  }
  
  private static JSONObject a(DataInputStream paramDataInputStream)
  {
    Object localObject1 = new byte[28];
    try
    {
      paramDataInputStream.readFully((byte[])localObject1);
      localObject2 = ByteBuffer.wrap((byte[])localObject1, 18, 10);
      int i = ((ByteBuffer)localObject2).getShort();
      g.set(Integer.valueOf(i));
      localObject1 = a.b.a(((ByteBuffer)localObject2).getShort());
      i = ((ByteBuffer)localObject2).getShort();
      int j = ((ByteBuffer)localObject2).getInt();
      paramDataInputStream.readFully(new byte[i]);
      localObject2 = new byte[j];
      paramDataInputStream.readFully((byte[])localObject2);
      if (j == 0) {
        return null;
      }
    }
    catch (IOException paramDataInputStream)
    {
      Object localObject2;
      label90:
      label111:
      break label111;
    }
    try
    {
      paramDataInputStream = a((a.b)localObject1, (byte[])localObject2);
      return paramDataInputStream;
    }
    catch (Exception paramDataInputStream)
    {
      break label90;
    }
    localObject1 = g;
    for (paramDataInputStream = a.c.m;; paramDataInputStream = a.c.j)
    {
      ((ThreadLocal)localObject1).set(Integer.valueOf(paramDataInputStream.a()));
      return null;
      localObject1 = g;
    }
  }
  
  private static void a(int paramInt1, String paramString, int paramInt2, JSONObject paramJSONObject, DataOutputStream paramDataOutputStream)
  {
    paramDataOutputStream.write(d);
    paramDataOutputStream.writeInt(paramInt1);
    paramDataOutputStream.writeInt(paramInt2);
    paramDataOutputStream.writeInt(0);
    paramDataOutputStream.writeShort(0);
    paramDataOutputStream.writeShort(0);
    a.b localb = f;
    try
    {
      byte[] arrayOfByte = a(localb, paramJSONObject);
      paramJSONObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      label57:
      break label57;
    }
    paramJSONObject = paramJSONObject.toString().getBytes("UTF-8");
    localb = a.b.e;
    paramDataOutputStream.writeShort(localb.a());
    paramString = paramString.getBytes("UTF-8");
    paramDataOutputStream.writeShort(paramString.length + 3);
    paramDataOutputStream.writeInt(paramJSONObject.length);
    paramDataOutputStream.write(1);
    paramDataOutputStream.writeShort(paramString.length);
    paramDataOutputStream.write(paramString);
    paramDataOutputStream.write(paramJSONObject);
    paramDataOutputStream.flush();
  }
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private static byte[] a(a.b paramb, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.toString().getBytes("UTF-8");
    int i = a.a.a[paramb.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return paramJSONObject;
      }
      throw new IOException("unsupported");
    }
    paramb = new SecretKeySpec(e, k.a(b));
    Cipher localCipher = Cipher.getInstance(k.a(c));
    localCipher.init(1, paramb, new IvParameterSpec(e));
    return localCipher.doFinal(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.b.a
 * JD-Core Version:    0.7.0.1
 */