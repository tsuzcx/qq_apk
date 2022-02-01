package oicq.wlogin_sdk.request;

import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import oicq.wlogin_sdk.tlv_type.tlv_t508;
import oicq.wlogin_sdk.tlv_type.tlv_t8;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;

public class h
{
  private t a;
  private int b;
  private int c;
  private ErrMsg d;
  
  public h(t paramt, int paramInt1, int paramInt2, ErrMsg paramErrMsg)
  {
    this.a = paramt;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramErrMsg;
  }
  
  int a(byte[] paramArrayOfByte)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("notice len ");
    ((StringBuilder)localObject1).append(paramArrayOfByte.length);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a.f);
    ((StringBuilder)localObject2).append("");
    util.LOGI((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = util.string_to_buf("30820122300d06092a864886f70d01010105000382010f003082010a0282010100bb65a9189e42aabf8c4c97b8bb7e35f6239df71152c0108d5c9b98d86ed7b14fa4b6e2ca5749eda03b5746e97b10c1772eab364fcedbfc4b3bb4d839ed97f657daa54622b54dfb29fe66f37f3e26e779675fec2337d0f8cbdf550b04f936be0927bbbecc851b6d966a3ba51c9747a8c588979ec248d5c8a66d1dd4fed0bcd3eb78725fd04b25cdceeac17d0068f07b3a2a360105cc1f4a0fd361d8d3ff0a9e5598b4196304635482be7ceda63a80479aa396a341fb206c81d7c476f860ac6d90734d523d1015eb73f390104c2bb85d0c05db4d11feae941ff5c92be9a1c123283dc2e0dc1368420d6f71cc50e343534e7c0ff16345680859e14c35f1f021cdfb0203010001");
    Object localObject4 = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte = null;
    localObject2 = null;
    try
    {
      Object localObject5 = new byte[((ByteBuffer)localObject4).getShort()];
      ((ByteBuffer)localObject4).get((byte[])localObject5);
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(2, (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec((byte[])localObject1)));
      localObject1 = localCipher.doFinal((byte[])localObject5);
      if (localObject1 != null)
      {
        if (localObject1.length == 0) {
          return -1000;
        }
        localObject5 = ByteBuffer.wrap((byte[])localObject1);
        localObject1 = new byte[((ByteBuffer)localObject5).getShort()];
        paramArrayOfByte = (byte[])localObject2;
        try
        {
          ((ByteBuffer)localObject5).get((byte[])localObject1);
          paramArrayOfByte = (byte[])localObject2;
          localObject2 = new byte[((ByteBuffer)localObject5).getShort()];
          paramArrayOfByte = (byte[])localObject2;
          ((ByteBuffer)localObject5).get((byte[])localObject2);
          paramArrayOfByte = (byte[])localObject2;
          ((ByteBuffer)localObject5).getInt();
          paramArrayOfByte = (byte[])localObject2;
        }
        catch (Exception localException1)
        {
          break label243;
        }
      }
      else
      {
        return -1000;
      }
    }
    catch (Exception localException2)
    {
      localObject1 = null;
      label243:
      util.printException(localException2);
      if (localObject1 != null)
      {
        if (paramArrayOfByte == null) {
          return -1000;
        }
        Object localObject3 = new byte[((ByteBuffer)localObject4).limit() - ((ByteBuffer)localObject4).position()];
        ((ByteBuffer)localObject4).get((byte[])localObject3);
        int j = localObject3.length;
        int i = 0;
        localObject1 = cryptor.decrypt((byte[])localObject3, 0, j, (byte[])localObject1);
        if (localObject1 != null)
        {
          if (localObject1.length == 0) {
            return -1000;
          }
          if (!Arrays.equals(paramArrayOfByte, MD5.toMD5Byte((byte[])localObject1))) {
            return -1000;
          }
          paramArrayOfByte = ByteBuffer.wrap((byte[])localObject1);
          paramArrayOfByte.getShort();
          j = paramArrayOfByte.getShort();
          if (j == 0) {
            return -1000;
          }
          while (i < j)
          {
            int k = paramArrayOfByte.getShort();
            localObject1 = new byte[paramArrayOfByte.getShort()];
            paramArrayOfByte.get((byte[])localObject1);
            if (k != 1281)
            {
              if (k == 1282) {
                this.d.setTitle(new String((byte[])localObject1));
              }
            }
            else
            {
              localObject1 = ByteBuffer.wrap((byte[])localObject1);
              k = ((ByteBuffer)localObject1).getInt();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("what ");
              ((StringBuilder)localObject3).append(k);
              util.LOGI(((StringBuilder)localObject3).toString(), "");
              if (k != 0) {
                return -1000;
              }
              localObject3 = new byte[((ByteBuffer)localObject1).getShort()];
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("msg len ");
              ((StringBuilder)localObject4).append(localObject3.length);
              util.LOGI(((StringBuilder)localObject4).toString(), "");
              if (localObject3.length == 0) {
                return -1000;
              }
              ((ByteBuffer)localObject1).get((byte[])localObject3);
              this.d.setMessage(new String((byte[])localObject3));
              this.d.setType(257);
            }
            i += 1;
          }
          return this.d.getType();
        }
      }
    }
    return -1000;
  }
  
  byte[] a(int paramInt)
  {
    Object localObject1 = ByteBuffer.allocate(43);
    Object localObject2 = t.b(this.a.h);
    ((ByteBuffer)localObject1).put(t.ag);
    ((ByteBuffer)localObject1).putInt((int)((async_context)localObject2)._sappid);
    ((ByteBuffer)localObject1).putInt((int)((async_context)localObject2)._sub_appid);
    ((ByteBuffer)localObject1).putShort((short)0);
    ((ByteBuffer)localObject1).putLong(this.a.f);
    ((ByteBuffer)localObject1).putShort((short)10);
    ((ByteBuffer)localObject1).put("6.0.0.2477".getBytes());
    ((ByteBuffer)localObject1).putShort((short)this.b);
    ((ByteBuffer)localObject1).putShort((short)this.c);
    int i;
    if (paramInt == -1000) {
      i = 1;
    } else {
      i = 0;
    }
    ((ByteBuffer)localObject1).put((byte)i);
    ((ByteBuffer)localObject1).putInt(paramInt);
    localObject2 = new tlv_t8().get_tlv_8(0, t.v, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(((ByteBuffer)localObject1).capacity() + 4 + 4 + (tlv_t508.userBuf.length + 4) + 8 + localObject2.length);
    localByteBuffer.putShort((short)2);
    localByteBuffer.putShort((short)3);
    localByteBuffer.putShort((short)512);
    localByteBuffer.putShort((short)((ByteBuffer)localObject1).capacity());
    localByteBuffer.put(((ByteBuffer)localObject1).array());
    localByteBuffer.putShort((short)513);
    localByteBuffer.putShort((short)4);
    localByteBuffer.putInt(2);
    localByteBuffer.putShort((short)2);
    localByteBuffer.putShort((short)tlv_t508.userBuf.length);
    localByteBuffer.put(tlv_t508.userBuf);
    localByteBuffer.put((byte[])localObject2);
    localObject2 = cryptor.encrypt(localByteBuffer.array(), 0, localByteBuffer.position(), this.a.c);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[0];
    }
    localObject2 = ByteBuffer.allocate(this.a.c.length + 2 + 2 + localObject1.length);
    ((ByteBuffer)localObject2).putShort((short)this.a.c.length);
    ((ByteBuffer)localObject2).put(this.a.c);
    ((ByteBuffer)localObject2).putShort((short)localObject1.length);
    ((ByteBuffer)localObject2).put((byte[])localObject1);
    return ((ByteBuffer)localObject2).array();
  }
  
  /* Error */
  int b(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_3
    //   9: aload_0
    //   10: iload_1
    //   11: invokevirtual 243	oicq/wlogin_sdk/request/h:a	(I)[B
    //   14: astore 5
    //   16: aload 4
    //   18: astore_3
    //   19: new 30	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   26: astore 7
    //   28: iconst_0
    //   29: istore_1
    //   30: aload 4
    //   32: astore_3
    //   33: invokestatic 249	java/lang/Math:random	()D
    //   36: ldc2_w 250
    //   39: dmul
    //   40: invokestatic 255	java/lang/Math:round	(D)J
    //   43: l2i
    //   44: istore_2
    //   45: aload 4
    //   47: astore_3
    //   48: aload 7
    //   50: iconst_3
    //   51: anewarray 147	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: ldc_w 257
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: ldc_w 259
    //   65: aastore
    //   66: dup
    //   67: iconst_2
    //   68: ldc_w 261
    //   71: aastore
    //   72: iload_2
    //   73: iconst_3
    //   74: irem
    //   75: aaload
    //   76: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 4
    //   82: astore_3
    //   83: aload 7
    //   85: ldc_w 263
    //   88: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 4
    //   94: astore_3
    //   95: aload 7
    //   97: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore 7
    //   102: aload 4
    //   104: astore_3
    //   105: new 30	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   112: astore 8
    //   114: aload 4
    //   116: astore_3
    //   117: aload 8
    //   119: ldc_w 265
    //   122: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 4
    //   128: astore_3
    //   129: aload 8
    //   131: aload 7
    //   133: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 4
    //   139: astore_3
    //   140: aload 8
    //   142: ldc_w 267
    //   145: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 4
    //   151: astore_3
    //   152: new 269	java/net/URL
    //   155: dup
    //   156: aload 8
    //   158: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokespecial 271	java/net/URL:<init>	(Ljava/lang/String;)V
    //   164: invokevirtual 275	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   167: checkcast 277	java/net/HttpURLConnection
    //   170: astore 4
    //   172: aload 4
    //   174: ldc_w 279
    //   177: invokevirtual 282	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   180: new 30	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   187: astore_3
    //   188: aload_3
    //   189: aload 5
    //   191: arraylength
    //   192: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_3
    //   197: ldc 55
    //   199: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 4
    //   205: ldc_w 284
    //   208: aload_3
    //   209: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokevirtual 287	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload 4
    //   217: ldc_w 289
    //   220: ldc_w 291
    //   223: invokevirtual 287	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload 4
    //   228: getstatic 294	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   231: invokevirtual 297	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   234: aload 4
    //   236: getstatic 294	oicq/wlogin_sdk/tlv_type/tlv_t508:timeout	I
    //   239: invokevirtual 300	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   242: aload 4
    //   244: iconst_1
    //   245: invokevirtual 304	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   248: aload 4
    //   250: iconst_1
    //   251: invokevirtual 307	java/net/HttpURLConnection:setDoInput	(Z)V
    //   254: aload 4
    //   256: aload_0
    //   257: getfield 18	oicq/wlogin_sdk/request/h:a	Loicq/wlogin_sdk/request/t;
    //   260: getfield 310	oicq/wlogin_sdk/request/t:l	I
    //   263: i2l
    //   264: invokestatic 315	oicq/wlogin_sdk/request/i:a	(Ljava/net/HttpURLConnection;J)Z
    //   267: ifne +54 -> 321
    //   270: new 30	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   277: astore_3
    //   278: aload_3
    //   279: ldc 55
    //   281: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_3
    //   286: aload_0
    //   287: getfield 18	oicq/wlogin_sdk/request/h:a	Loicq/wlogin_sdk/request/t;
    //   290: getfield 50	oicq/wlogin_sdk/request/t:f	J
    //   293: invokevirtual 53	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: ldc_w 317
    //   300: aload_3
    //   301: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 61	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload 4
    //   309: ifnull +8 -> 317
    //   312: aload 4
    //   314: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   317: sipush -1000
    //   320: ireturn
    //   321: aload 4
    //   323: invokevirtual 324	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   326: astore_3
    //   327: aload_3
    //   328: aload 5
    //   330: invokevirtual 329	java/io/OutputStream:write	([B)V
    //   333: aload_3
    //   334: invokevirtual 332	java/io/OutputStream:close	()V
    //   337: aload 4
    //   339: invokevirtual 335	java/net/HttpURLConnection:getResponseCode	()I
    //   342: istore_2
    //   343: new 30	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   350: astore_3
    //   351: aload_3
    //   352: ldc_w 337
    //   355: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload_3
    //   360: iload_2
    //   361: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload_3
    //   366: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: astore_3
    //   370: new 30	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   377: astore 5
    //   379: aload 5
    //   381: ldc 55
    //   383: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload 5
    //   389: aload_0
    //   390: getfield 18	oicq/wlogin_sdk/request/h:a	Loicq/wlogin_sdk/request/t;
    //   393: getfield 50	oicq/wlogin_sdk/request/t:f	J
    //   396: invokevirtual 53	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload_3
    //   401: aload 5
    //   403: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 61	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: sipush 200
    //   412: iload_2
    //   413: if_icmpeq +17 -> 430
    //   416: aload 4
    //   418: ifnull +8 -> 426
    //   421: aload 4
    //   423: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   426: sipush -1000
    //   429: ireturn
    //   430: new 30	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   437: astore_3
    //   438: aload_3
    //   439: ldc 55
    //   441: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_3
    //   446: aload_0
    //   447: getfield 18	oicq/wlogin_sdk/request/h:a	Loicq/wlogin_sdk/request/t;
    //   450: getfield 50	oicq/wlogin_sdk/request/t:f	J
    //   453: invokevirtual 53	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: ldc_w 339
    //   460: aload_3
    //   461: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 61	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: aload 4
    //   469: invokevirtual 343	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   472: astore_3
    //   473: new 345	java/io/ByteArrayOutputStream
    //   476: dup
    //   477: invokespecial 346	java/io/ByteArrayOutputStream:<init>	()V
    //   480: astore 5
    //   482: sipush 1024
    //   485: newarray byte
    //   487: astore 6
    //   489: aload_3
    //   490: aload 6
    //   492: invokevirtual 351	java/io/InputStream:read	([B)I
    //   495: istore_2
    //   496: iload_2
    //   497: iconst_m1
    //   498: if_icmpeq +15 -> 513
    //   501: aload 5
    //   503: aload 6
    //   505: iconst_0
    //   506: iload_2
    //   507: invokevirtual 354	java/io/ByteArrayOutputStream:write	([BII)V
    //   510: goto -21 -> 489
    //   513: aload_0
    //   514: aload 5
    //   516: invokevirtual 357	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   519: invokevirtual 359	oicq/wlogin_sdk/request/h:a	([B)I
    //   522: sipush -1000
    //   525: if_icmpeq +5 -> 530
    //   528: iconst_1
    //   529: istore_1
    //   530: aload 5
    //   532: invokevirtual 360	java/io/ByteArrayOutputStream:close	()V
    //   535: iload_1
    //   536: ifne +17 -> 553
    //   539: aload 4
    //   541: ifnull +8 -> 549
    //   544: aload 4
    //   546: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   549: sipush -1000
    //   552: ireturn
    //   553: aload 4
    //   555: ifnull +8 -> 563
    //   558: aload 4
    //   560: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   563: sipush 257
    //   566: ireturn
    //   567: astore_3
    //   568: goto +47 -> 615
    //   571: astore 5
    //   573: goto +20 -> 593
    //   576: astore 5
    //   578: aload_3
    //   579: astore 4
    //   581: aload 5
    //   583: astore_3
    //   584: goto +31 -> 615
    //   587: astore 5
    //   589: aload 6
    //   591: astore 4
    //   593: aload 4
    //   595: astore_3
    //   596: aload 5
    //   598: invokestatic 122	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;)V
    //   601: aload 4
    //   603: ifnull +8 -> 611
    //   606: aload 4
    //   608: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   611: sipush -1000
    //   614: ireturn
    //   615: aload 4
    //   617: ifnull +8 -> 625
    //   620: aload 4
    //   622: invokevirtual 320	java/net/HttpURLConnection:disconnect	()V
    //   625: goto +5 -> 630
    //   628: aload_3
    //   629: athrow
    //   630: goto -2 -> 628
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	633	0	this	h
    //   0	633	1	paramInt	int
    //   44	463	2	i	int
    //   8	482	3	localObject1	Object
    //   567	12	3	localObject2	Object
    //   583	46	3	localObject3	Object
    //   4	617	4	localObject4	Object
    //   14	517	5	localObject5	Object
    //   571	1	5	localException1	Exception
    //   576	6	5	localObject6	Object
    //   587	10	5	localException2	Exception
    //   1	589	6	arrayOfByte	byte[]
    //   26	106	7	localObject7	Object
    //   112	45	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   172	307	567	finally
    //   321	409	567	finally
    //   430	489	567	finally
    //   489	496	567	finally
    //   501	510	567	finally
    //   513	528	567	finally
    //   530	535	567	finally
    //   172	307	571	java/lang/Exception
    //   321	409	571	java/lang/Exception
    //   430	489	571	java/lang/Exception
    //   489	496	571	java/lang/Exception
    //   501	510	571	java/lang/Exception
    //   513	528	571	java/lang/Exception
    //   530	535	571	java/lang/Exception
    //   9	16	576	finally
    //   19	28	576	finally
    //   33	45	576	finally
    //   48	80	576	finally
    //   83	92	576	finally
    //   95	102	576	finally
    //   105	114	576	finally
    //   117	126	576	finally
    //   129	137	576	finally
    //   140	149	576	finally
    //   152	172	576	finally
    //   596	601	576	finally
    //   9	16	587	java/lang/Exception
    //   19	28	587	java/lang/Exception
    //   33	45	587	java/lang/Exception
    //   48	80	587	java/lang/Exception
    //   83	92	587	java/lang/Exception
    //   95	102	587	java/lang/Exception
    //   105	114	587	java/lang/Exception
    //   117	126	587	java/lang/Exception
    //   129	137	587	java/lang/Exception
    //   140	149	587	java/lang/Exception
    //   152	172	587	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.request.h
 * JD-Core Version:    0.7.0.1
 */