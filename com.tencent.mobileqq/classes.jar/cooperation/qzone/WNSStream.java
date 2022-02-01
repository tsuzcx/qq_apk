package cooperation.qzone;

import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfClientIpInfo;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.QmfTokenInfo;
import QMF_PROTOCAL.QmfUpstream;
import QMF_PROTOCAL.RetryInfo;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public class WNSStream
{
  private static final String BUSICOMPCONTROL = "busiCompCtl";
  private static final String ENCODE_CODE = "UTF-8";
  private int SUPPORT_COMPRESS = 1;
  private byte[] mA2 = null;
  private int mAppId = 0;
  private String mDeviceInfo = null;
  private String mQUA = null;
  private RetryInfo mRetryInfo = null;
  private long mUin = 0L;
  
  public WNSStream() {}
  
  public WNSStream(int paramInt, String paramString1, long paramLong, byte[] paramArrayOfByte, String paramString2)
  {
    this.mAppId = paramInt;
    this.mQUA = paramString1;
    this.mUin = paramLong;
    this.mA2 = paramArrayOfByte;
    this.mDeviceInfo = paramString2;
  }
  
  public WNSStream(int paramInt, String paramString1, long paramLong, byte[] paramArrayOfByte, String paramString2, RetryInfo paramRetryInfo)
  {
    this(paramInt, paramString1, paramLong, paramArrayOfByte, paramString2);
    this.mRetryInfo = paramRetryInfo;
  }
  
  private QmfBusiControl createBusiControl(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static <T extends JceStruct> T decodeWup(Class<T> paramClass, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      try
      {
        paramClass = (JceStruct)paramClass.newInstance();
        paramClass.readFrom(new JceInputStream(paramArrayOfByte));
        return paramClass;
      }
      catch (InstantiationException paramClass)
      {
        paramClass.printStackTrace();
      }
      catch (IllegalAccessException paramClass)
      {
        paramClass.printStackTrace();
      }
    }
    return null;
  }
  
  /* Error */
  public static byte[] decompress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: ifnonnull +5 -> 10
    //   8: aconst_null
    //   9: areturn
    //   10: new 95	java/util/zip/Inflater
    //   13: dup
    //   14: invokespecial 96	java/util/zip/Inflater:<init>	()V
    //   17: astore 5
    //   19: aload 5
    //   21: invokevirtual 99	java/util/zip/Inflater:reset	()V
    //   24: aload 5
    //   26: aload_0
    //   27: invokevirtual 102	java/util/zip/Inflater:setInput	([B)V
    //   30: new 104	java/io/ByteArrayOutputStream
    //   33: dup
    //   34: aload_0
    //   35: arraylength
    //   36: invokespecial 107	java/io/ByteArrayOutputStream:<init>	(I)V
    //   39: astore_1
    //   40: aload_1
    //   41: astore_2
    //   42: sipush 1024
    //   45: newarray byte
    //   47: astore_3
    //   48: aload_1
    //   49: astore_2
    //   50: aload 5
    //   52: invokevirtual 111	java/util/zip/Inflater:finished	()Z
    //   55: ifne +20 -> 75
    //   58: aload_1
    //   59: astore_2
    //   60: aload_1
    //   61: aload_3
    //   62: iconst_0
    //   63: aload 5
    //   65: aload_3
    //   66: invokevirtual 115	java/util/zip/Inflater:inflate	([B)I
    //   69: invokevirtual 119	java/io/ByteArrayOutputStream:write	([BII)V
    //   72: goto -24 -> 48
    //   75: aload_1
    //   76: astore_2
    //   77: aload_1
    //   78: invokevirtual 123	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   81: astore_3
    //   82: aload_3
    //   83: astore_2
    //   84: aload_1
    //   85: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   88: aload_3
    //   89: astore_1
    //   90: goto +89 -> 179
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   98: aload_2
    //   99: astore_1
    //   100: goto +79 -> 179
    //   103: astore_2
    //   104: aload_1
    //   105: astore_0
    //   106: aload_2
    //   107: astore_1
    //   108: goto +17 -> 125
    //   111: astore 4
    //   113: aload_1
    //   114: astore_3
    //   115: goto +43 -> 158
    //   118: astore_0
    //   119: goto +68 -> 187
    //   122: astore_1
    //   123: aload_3
    //   124: astore_0
    //   125: aload_0
    //   126: astore_2
    //   127: aload_1
    //   128: invokevirtual 128	java/lang/OutOfMemoryError:printStackTrace	()V
    //   131: aload_0
    //   132: ifnull +15 -> 147
    //   135: aload_0
    //   136: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   139: goto +8 -> 147
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   147: iconst_0
    //   148: newarray byte
    //   150: astore_1
    //   151: goto +28 -> 179
    //   154: astore 4
    //   156: aconst_null
    //   157: astore_3
    //   158: aload_3
    //   159: astore_2
    //   160: aload 4
    //   162: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   165: aload_0
    //   166: astore_1
    //   167: aload_3
    //   168: ifnull +11 -> 179
    //   171: aload_0
    //   172: astore_2
    //   173: aload_3
    //   174: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   177: aload_0
    //   178: astore_1
    //   179: aload 5
    //   181: invokevirtual 132	java/util/zip/Inflater:end	()V
    //   184: aload_1
    //   185: areturn
    //   186: astore_0
    //   187: aload_2
    //   188: ifnull +15 -> 203
    //   191: aload_2
    //   192: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   195: goto +8 -> 203
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   203: goto +5 -> 208
    //   206: aload_0
    //   207: athrow
    //   208: goto -2 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramArrayOfByte	byte[]
    //   39	75	1	localObject1	Object
    //   122	6	1	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   150	35	1	arrayOfByte	byte[]
    //   198	2	1	localIOException	java.io.IOException
    //   3	96	2	localObject2	Object
    //   103	4	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   126	66	2	localObject3	Object
    //   1	173	3	localObject4	Object
    //   111	1	4	localException1	java.lang.Exception
    //   154	7	4	localException2	java.lang.Exception
    //   17	163	5	localInflater	java.util.zip.Inflater
    // Exception table:
    //   from	to	target	type
    //   84	88	93	java/io/IOException
    //   173	177	93	java/io/IOException
    //   42	48	103	java/lang/OutOfMemoryError
    //   50	58	103	java/lang/OutOfMemoryError
    //   60	72	103	java/lang/OutOfMemoryError
    //   77	82	103	java/lang/OutOfMemoryError
    //   42	48	111	java/lang/Exception
    //   50	58	111	java/lang/Exception
    //   60	72	111	java/lang/Exception
    //   77	82	111	java/lang/Exception
    //   30	40	118	finally
    //   127	131	118	finally
    //   30	40	122	java/lang/OutOfMemoryError
    //   135	139	142	java/io/IOException
    //   30	40	154	java/lang/Exception
    //   42	48	186	finally
    //   50	58	186	finally
    //   60	72	186	finally
    //   77	82	186	finally
    //   160	165	186	finally
    //   191	195	198	java/io/IOException
  }
  
  public static byte[] encodeWup(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("UTF-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
  
  /* Error */
  public byte[] compress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 149	java/util/zip/Deflater
    //   9: dup
    //   10: invokespecial 150	java/util/zip/Deflater:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: invokevirtual 151	java/util/zip/Deflater:reset	()V
    //   20: aload 4
    //   22: aload_1
    //   23: invokevirtual 152	java/util/zip/Deflater:setInput	([B)V
    //   26: aload 4
    //   28: invokevirtual 155	java/util/zip/Deflater:finish	()V
    //   31: new 104	java/io/ByteArrayOutputStream
    //   34: dup
    //   35: aload_1
    //   36: arraylength
    //   37: invokespecial 107	java/io/ByteArrayOutputStream:<init>	(I)V
    //   40: astore 5
    //   42: sipush 1024
    //   45: newarray byte
    //   47: astore_2
    //   48: aload 4
    //   50: invokevirtual 156	java/util/zip/Deflater:finished	()Z
    //   53: ifne +19 -> 72
    //   56: aload 5
    //   58: aload_2
    //   59: iconst_0
    //   60: aload 4
    //   62: aload_2
    //   63: invokevirtual 159	java/util/zip/Deflater:deflate	([B)I
    //   66: invokevirtual 119	java/io/ByteArrayOutputStream:write	([BII)V
    //   69: goto -21 -> 48
    //   72: aload 5
    //   74: invokevirtual 123	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   77: astore_3
    //   78: aload_3
    //   79: astore_2
    //   80: aload 5
    //   82: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   85: aload_3
    //   86: astore_1
    //   87: goto +54 -> 141
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   95: aload_2
    //   96: astore_1
    //   97: goto +44 -> 141
    //   100: astore_1
    //   101: goto +47 -> 148
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 128	java/lang/OutOfMemoryError:printStackTrace	()V
    //   109: aload 5
    //   111: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   114: goto +8 -> 122
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   122: iconst_0
    //   123: newarray byte
    //   125: astore_1
    //   126: goto +15 -> 141
    //   129: astore_2
    //   130: aload_2
    //   131: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   134: aload_1
    //   135: astore_2
    //   136: aload 5
    //   138: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   141: aload 4
    //   143: invokevirtual 160	java/util/zip/Deflater:end	()V
    //   146: aload_1
    //   147: areturn
    //   148: aload 5
    //   150: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   153: goto +8 -> 161
    //   156: astore_2
    //   157: aload_2
    //   158: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   161: goto +5 -> 166
    //   164: aload_1
    //   165: athrow
    //   166: goto -2 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	WNSStream
    //   0	169	1	paramArrayOfByte	byte[]
    //   47	49	2	localObject	Object
    //   129	2	2	localException	java.lang.Exception
    //   135	1	2	arrayOfByte1	byte[]
    //   156	2	2	localIOException	java.io.IOException
    //   77	9	3	arrayOfByte2	byte[]
    //   13	129	4	localDeflater	java.util.zip.Deflater
    //   40	109	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   80	85	90	java/io/IOException
    //   136	141	90	java/io/IOException
    //   42	48	100	finally
    //   48	69	100	finally
    //   72	78	100	finally
    //   105	109	100	finally
    //   130	134	100	finally
    //   42	48	104	java/lang/OutOfMemoryError
    //   48	69	104	java/lang/OutOfMemoryError
    //   72	78	104	java/lang/OutOfMemoryError
    //   109	114	117	java/io/IOException
    //   42	48	129	java/lang/Exception
    //   48	69	129	java/lang/Exception
    //   72	78	129	java/lang/Exception
    //   148	153	156	java/io/IOException
  }
  
  QmfUpstream createQmfUpstream(int paramInt1, String paramString1, int paramInt2, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, String paramString2, String paramString3, RetryInfo paramRetryInfo)
  {
    if ((paramArrayOfByte2 != null) && (paramArrayOfByte3 != null) && (paramArrayOfByte1 != null))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(1), new byte[] { 0 });
      return new QmfUpstream(paramInt1, paramInt2, paramLong, paramString2, paramString1, paramString3, new QmfTokenInfo(64, paramArrayOfByte1, localHashMap), new QmfClientIpInfo((byte)0, (short)0, 0, new byte[] { 0, 0, 0, 0, 0, 0 }), paramArrayOfByte2, paramArrayOfByte3, 0L, 0L, paramRetryInfo);
    }
    return null;
  }
  
  public byte[] pack(int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    UniAttribute localUniAttribute = new UniAttribute();
    localUniAttribute.put("busiCompCtl", createBusiControl(paramBoolean, paramArrayOfByte.length, this.SUPPORT_COMPRESS));
    if (paramBoolean)
    {
      paramArrayOfByte = compress(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return null;
      }
      return encodeWup(createQmfUpstream(paramInt, paramString, this.mAppId, this.mUin, this.mA2, paramArrayOfByte, localUniAttribute.encode(), this.mQUA, this.mDeviceInfo, this.mRetryInfo));
    }
    return encodeWup(createQmfUpstream(paramInt, paramString, this.mAppId, this.mUin, this.mA2, paramArrayOfByte, localUniAttribute.encode(), this.mQUA, this.mDeviceInfo, this.mRetryInfo));
  }
  
  public byte[] packForUndeal(int paramInt, String paramString, byte[] paramArrayOfByte, boolean paramBoolean, JceStruct paramJceStruct)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    UniAttribute localUniAttribute = new UniAttribute();
    localUniAttribute.put("busiCompCtl", createBusiControl(paramBoolean, paramArrayOfByte.length, this.SUPPORT_COMPRESS));
    if (paramJceStruct != null)
    {
      localUniAttribute.put("conf_info_req", paramJceStruct);
      localUniAttribute.put("wns_sdk_version", new Integer(1));
    }
    if (paramBoolean)
    {
      paramArrayOfByte = compress(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return null;
      }
      return encodeWup(createQmfUpstream(paramInt, paramString, this.mAppId, this.mUin, this.mA2, paramArrayOfByte, localUniAttribute.encode(), this.mQUA, this.mDeviceInfo, this.mRetryInfo));
    }
    return encodeWup(createQmfUpstream(paramInt, paramString, this.mAppId, this.mUin, this.mA2, paramArrayOfByte, localUniAttribute.encode(), this.mQUA, this.mDeviceInfo, this.mRetryInfo));
  }
  
  public QmfDownstream unpack(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return (QmfDownstream)decodeWup(QmfDownstream.class, paramArrayOfByte);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.WNSStream
 * JD-Core Version:    0.7.0.1
 */