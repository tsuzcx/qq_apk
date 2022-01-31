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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;

public class WNSStream
{
  private static final String BUSICOMPCONTROL = "busiCompCtl";
  private static final String ENCODE_CODE = "UTF-8";
  private int SUPPORT_COMPRESS = 1;
  private byte[] mA2;
  private int mAppId;
  private String mDeviceInfo;
  private String mQUA;
  private RetryInfo mRetryInfo;
  private long mUin;
  
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
    QmfBusiControl localQmfBusiControl = new QmfBusiControl();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localQmfBusiControl.compFlag = i;
      localQmfBusiControl.lenBeforeComp = paramInt1;
      localQmfBusiControl.rspCompFlag = paramInt2;
      return localQmfBusiControl;
    }
  }
  
  public static <T extends JceStruct> T decodeWup(Class<T> paramClass, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
    try
    {
      paramClass = (JceStruct)paramClass.newInstance();
      paramClass.readFrom(new JceInputStream(paramArrayOfByte));
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static byte[] decompress(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: iconst_0
    //   10: newarray byte
    //   12: astore_3
    //   13: new 98	java/util/zip/Inflater
    //   16: dup
    //   17: invokespecial 99	java/util/zip/Inflater:<init>	()V
    //   20: astore 5
    //   22: aload 5
    //   24: invokevirtual 102	java/util/zip/Inflater:reset	()V
    //   27: aload 5
    //   29: aload_0
    //   30: invokevirtual 105	java/util/zip/Inflater:setInput	([B)V
    //   33: new 107	java/io/ByteArrayOutputStream
    //   36: dup
    //   37: aload_0
    //   38: arraylength
    //   39: invokespecial 110	java/io/ByteArrayOutputStream:<init>	(I)V
    //   42: astore_2
    //   43: aload_2
    //   44: astore_1
    //   45: sipush 1024
    //   48: newarray byte
    //   50: astore 4
    //   52: aload_2
    //   53: astore_1
    //   54: aload 5
    //   56: invokevirtual 114	java/util/zip/Inflater:finished	()Z
    //   59: ifne +46 -> 105
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: aload 4
    //   67: iconst_0
    //   68: aload 5
    //   70: aload 4
    //   72: invokevirtual 118	java/util/zip/Inflater:inflate	([B)I
    //   75: invokevirtual 122	java/io/ByteArrayOutputStream:write	([BII)V
    //   78: goto -26 -> 52
    //   81: astore_1
    //   82: aload_1
    //   83: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   86: aload_0
    //   87: astore_1
    //   88: aload_2
    //   89: ifnull +9 -> 98
    //   92: aload_2
    //   93: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   96: aload_0
    //   97: astore_1
    //   98: aload 5
    //   100: invokevirtual 129	java/util/zip/Inflater:end	()V
    //   103: aload_1
    //   104: areturn
    //   105: aload_2
    //   106: astore_1
    //   107: aload_2
    //   108: invokevirtual 133	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   111: astore 4
    //   113: aload 4
    //   115: astore_0
    //   116: aload_0
    //   117: astore_1
    //   118: aload_2
    //   119: ifnull -21 -> 98
    //   122: aload_2
    //   123: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   126: aload_0
    //   127: astore_1
    //   128: goto -30 -> 98
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   136: aload_0
    //   137: astore_1
    //   138: goto -40 -> 98
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   146: aload_0
    //   147: astore_1
    //   148: goto -50 -> 98
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_2
    //   154: aload_2
    //   155: astore_1
    //   156: aload_0
    //   157: invokevirtual 135	java/lang/OutOfMemoryError:printStackTrace	()V
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   168: aload_3
    //   169: astore_1
    //   170: goto -72 -> 98
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   178: aload_3
    //   179: astore_1
    //   180: goto -82 -> 98
    //   183: astore_0
    //   184: aconst_null
    //   185: astore_1
    //   186: aload_1
    //   187: ifnull +7 -> 194
    //   190: aload_1
    //   191: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   194: aload_0
    //   195: athrow
    //   196: astore_1
    //   197: aload_1
    //   198: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   201: goto -7 -> 194
    //   204: astore_0
    //   205: goto -19 -> 186
    //   208: astore_0
    //   209: aload_2
    //   210: astore_1
    //   211: goto -25 -> 186
    //   214: astore_0
    //   215: goto -61 -> 154
    //   218: astore_1
    //   219: aload 4
    //   221: astore_2
    //   222: goto -140 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramArrayOfByte	byte[]
    //   44	20	1	localObject1	Object
    //   81	2	1	localException1	Exception
    //   87	41	1	localObject2	Object
    //   131	2	1	localIOException1	IOException
    //   137	1	1	arrayOfByte1	byte[]
    //   141	2	1	localIOException2	IOException
    //   147	44	1	localObject3	Object
    //   196	2	1	localIOException3	IOException
    //   210	1	1	localObject4	Object
    //   218	1	1	localException2	Exception
    //   42	180	2	localObject5	Object
    //   12	167	3	arrayOfByte2	byte[]
    //   1	219	4	arrayOfByte3	byte[]
    //   20	79	5	localInflater	java.util.zip.Inflater
    // Exception table:
    //   from	to	target	type
    //   45	52	81	java/lang/Exception
    //   54	62	81	java/lang/Exception
    //   64	78	81	java/lang/Exception
    //   107	113	81	java/lang/Exception
    //   122	126	131	java/io/IOException
    //   92	96	141	java/io/IOException
    //   33	43	151	java/lang/OutOfMemoryError
    //   164	168	173	java/io/IOException
    //   33	43	183	finally
    //   190	194	196	java/io/IOException
    //   45	52	204	finally
    //   54	62	204	finally
    //   64	78	204	finally
    //   107	113	204	finally
    //   156	160	204	finally
    //   82	86	208	finally
    //   45	52	214	java/lang/OutOfMemoryError
    //   54	62	214	java/lang/OutOfMemoryError
    //   64	78	214	java/lang/OutOfMemoryError
    //   107	113	214	java/lang/OutOfMemoryError
    //   33	43	218	java/lang/Exception
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
  
  public byte[] compress(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte1 = new byte[0];
    Deflater localDeflater = new Deflater();
    localDeflater.reset();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte2 = new byte[1024];
      while (!localDeflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte2, 0, localDeflater.deflate(arrayOfByte2));
      }
      try
      {
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        for (;;)
        {
          localDeflater.end();
          return paramArrayOfByte;
          arrayOfByte2 = localByteArrayOutputStream.toByteArray();
          paramArrayOfByte = arrayOfByte2;
          try
          {
            localByteArrayOutputStream.close();
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
          }
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = paramArrayOfByte;
        paramArrayOfByte.printStackTrace();
        try
        {
          localByteArrayOutputStream.close();
          paramArrayOfByte = localIOException2;
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = localIOException2;
        }
      }
    }
    finally {}
  }
  
  QmfUpstream createQmfUpstream(int paramInt1, String paramString1, int paramInt2, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, String paramString2, String paramString3, RetryInfo paramRetryInfo)
  {
    if ((paramArrayOfByte2 == null) || (paramArrayOfByte3 == null) || (paramArrayOfByte1 == null)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(1), new byte[] { 0 });
    return new QmfUpstream(paramInt1, paramInt2, paramLong, paramString2, paramString1, paramString3, new QmfTokenInfo(64, paramArrayOfByte1, localHashMap), new QmfClientIpInfo((byte)0, (short)0, 0, new byte[] { 0, 0, 0, 0, 0, 0 }), paramArrayOfByte2, paramArrayOfByte3, 0L, 0L, paramRetryInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.WNSStream
 * JD-Core Version:    0.7.0.1
 */