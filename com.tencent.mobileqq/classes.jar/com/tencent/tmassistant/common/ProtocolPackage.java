package com.tencent.tmassistant.common;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.jce.JceCmd;
import com.tencent.tmassistant.common.jce.Net;
import com.tencent.tmassistant.common.jce.ReportLogRequest;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistant.common.jce.Response;
import com.tencent.tmassistant.common.jce.RomInfo;
import com.tencent.tmassistant.common.jce.RspHead;
import com.tencent.tmassistant.common.jce.Terminal;
import com.tencent.tmassistantbase.common.a;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.ag;
import com.tencent.tmassistantbase.util.f;
import com.tencent.tmassistantbase.util.o;
import java.util.List;

public class ProtocolPackage
{
  public static final String CRYPT_KEY = "ji*9^&43U0X-~./(";
  public static final String ServerEncoding = "utf-8";
  protected static String TAG = "ProtocolPackage";
  
  public static byte[] buildPostData(Request paramRequest)
  {
    ab.c(TAG, "enter");
    if (paramRequest == null)
    {
      ab.c(TAG, "null == request");
      ab.c(TAG, "exit");
      return null;
    }
    paramRequest.head.encryptWithPack = 0;
    if (paramRequest.body.length > 256)
    {
      paramRequest.body = ag.a(paramRequest.body);
      ab.c(TAG, "zip process");
      paramRequest.head.encryptWithPack = ((byte)(paramRequest.head.encryptWithPack | 0x1));
    }
    paramRequest.body = encrypt(paramRequest.body, "ji*9^&43U0X-~./(".getBytes());
    ab.c(TAG, "encrypt process");
    paramRequest.head.encryptWithPack = ((byte)(paramRequest.head.encryptWithPack | 0x2));
    ab.c(TAG, "exit");
    return jceStructToUTF8Byte(paramRequest);
  }
  
  public static JceStruct buildReportRequest(byte paramByte, List<byte[]> paramList, String paramString1, int paramInt, String paramString2)
  {
    ReportLogRequest localReportLogRequest = new ReportLogRequest();
    localReportLogRequest.logType = paramByte;
    localReportLogRequest.logData = formatLogData(paramList);
    localReportLogRequest.hostAppPackageName = paramString1;
    localReportLogRequest.hostAppVersion = paramInt;
    localReportLogRequest.hostUserId = paramString2;
    return localReportLogRequest;
  }
  
  public static Request buildRequest(JceStruct paramJceStruct)
  {
    ab.c(TAG, "enter");
    if (paramJceStruct == null)
    {
      ab.c(TAG, "null == jceRequestStruce");
      ab.c(TAG, "exit");
      return null;
    }
    Request localRequest = new Request();
    localRequest.head = getReqHead(paramJceStruct);
    localRequest.body = jceStructToUTF8Byte(paramJceStruct);
    ab.c(TAG, "exit");
    return localRequest;
  }
  
  public static JceStruct bytes2JceObj(byte[] paramArrayOfByte, Class<? extends JceStruct> paramClass)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf-8");
      paramClass = (JceStruct)paramClass.newInstance();
      paramClass.readFrom(paramArrayOfByte);
      return paramClass;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.b(TAG, "exception: ", paramArrayOfByte);
    }
    return null;
  }
  
  private static JceStruct createFromRequest(JceStruct paramJceStruct)
  {
    ab.c(TAG, "enter");
    if (paramJceStruct == null) {
      return null;
    }
    paramJceStruct = paramJceStruct.getClass().getName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramJceStruct.substring(0, paramJceStruct.length() - 7));
    localStringBuilder.append("Response");
    paramJceStruct = localStringBuilder.toString();
    try
    {
      paramJceStruct = (JceStruct)Class.forName(paramJceStruct).newInstance();
    }
    catch (InstantiationException paramJceStruct)
    {
      ab.b(TAG, "exception: ", paramJceStruct);
      paramJceStruct.printStackTrace();
    }
    catch (IllegalAccessException paramJceStruct)
    {
      ab.b(TAG, "exception: ", paramJceStruct);
      paramJceStruct.printStackTrace();
    }
    catch (ClassNotFoundException paramJceStruct)
    {
      ab.b(TAG, "exception: ", paramJceStruct);
      paramJceStruct.printStackTrace();
    }
    paramJceStruct = null;
    ab.c(TAG, "exit");
    return paramJceStruct;
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new com.tencent.tmassistantbase.util.e().a(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new com.tencent.tmassistantbase.util.e().b(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  /* Error */
  public static byte[] formatLogData(List<byte[]> paramList)
  {
    // Byte code:
    //   0: new 201	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 202	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: new 204	java/io/DataOutputStream
    //   11: dup
    //   12: aload_2
    //   13: invokespecial 207	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore 4
    //   18: aload_2
    //   19: astore_1
    //   20: aload 4
    //   22: astore_3
    //   23: aload_0
    //   24: invokeinterface 213 1 0
    //   29: astore_0
    //   30: aload_2
    //   31: astore_1
    //   32: aload 4
    //   34: astore_3
    //   35: aload_0
    //   36: invokeinterface 219 1 0
    //   41: ifeq +47 -> 88
    //   44: aload_2
    //   45: astore_1
    //   46: aload 4
    //   48: astore_3
    //   49: aload_0
    //   50: invokeinterface 222 1 0
    //   55: checkcast 223	[B
    //   58: astore 5
    //   60: aload_2
    //   61: astore_1
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: aload 5
    //   69: arraylength
    //   70: invokevirtual 227	java/io/DataOutputStream:writeInt	(I)V
    //   73: aload_2
    //   74: astore_1
    //   75: aload 4
    //   77: astore_3
    //   78: aload 4
    //   80: aload 5
    //   82: invokevirtual 230	java/io/DataOutputStream:write	([B)V
    //   85: goto -55 -> 30
    //   88: aload_2
    //   89: astore_1
    //   90: aload 4
    //   92: astore_3
    //   93: aload_2
    //   94: invokevirtual 233	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   97: astore_0
    //   98: aload_2
    //   99: invokevirtual 236	java/io/ByteArrayOutputStream:close	()V
    //   102: goto +17 -> 119
    //   105: astore_1
    //   106: getstatic 24	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   109: ldc 139
    //   111: aload_1
    //   112: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_1
    //   116: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   119: aload 4
    //   121: invokevirtual 238	java/io/DataOutputStream:close	()V
    //   124: aload_0
    //   125: areturn
    //   126: astore_1
    //   127: getstatic 24	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   130: ldc 139
    //   132: aload_1
    //   133: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload_1
    //   137: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   140: aload_0
    //   141: areturn
    //   142: astore_1
    //   143: aload 4
    //   145: astore_0
    //   146: aload_1
    //   147: astore 4
    //   149: goto +32 -> 181
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_3
    //   155: aload_2
    //   156: astore_1
    //   157: goto +99 -> 256
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_0
    //   164: goto +17 -> 181
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_1
    //   170: aload_1
    //   171: astore_3
    //   172: goto +84 -> 256
    //   175: astore 4
    //   177: aconst_null
    //   178: astore_2
    //   179: aload_2
    //   180: astore_0
    //   181: aload_2
    //   182: astore_1
    //   183: aload_0
    //   184: astore_3
    //   185: getstatic 24	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   188: ldc 139
    //   190: aload 4
    //   192: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   195: aload_2
    //   196: astore_1
    //   197: aload_0
    //   198: astore_3
    //   199: aload 4
    //   201: invokevirtual 239	java/lang/Exception:printStackTrace	()V
    //   204: aload_2
    //   205: ifnull +24 -> 229
    //   208: aload_2
    //   209: invokevirtual 236	java/io/ByteArrayOutputStream:close	()V
    //   212: goto +17 -> 229
    //   215: astore_1
    //   216: getstatic 24	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   219: ldc 139
    //   221: aload_1
    //   222: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload_1
    //   226: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   229: aload_0
    //   230: ifnull +23 -> 253
    //   233: aload_0
    //   234: invokevirtual 238	java/io/DataOutputStream:close	()V
    //   237: aconst_null
    //   238: areturn
    //   239: astore_0
    //   240: getstatic 24	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   243: ldc 139
    //   245: aload_0
    //   246: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   249: aload_0
    //   250: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   253: aconst_null
    //   254: areturn
    //   255: astore_0
    //   256: aload_1
    //   257: ifnull +24 -> 281
    //   260: aload_1
    //   261: invokevirtual 236	java/io/ByteArrayOutputStream:close	()V
    //   264: goto +17 -> 281
    //   267: astore_1
    //   268: getstatic 24	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   271: ldc 139
    //   273: aload_1
    //   274: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   277: aload_1
    //   278: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   281: aload_3
    //   282: ifnull +24 -> 306
    //   285: aload_3
    //   286: invokevirtual 238	java/io/DataOutputStream:close	()V
    //   289: goto +17 -> 306
    //   292: astore_1
    //   293: getstatic 24	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   296: ldc 139
    //   298: aload_1
    //   299: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   302: aload_1
    //   303: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   306: goto +5 -> 311
    //   309: aload_0
    //   310: athrow
    //   311: goto -2 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	paramList	List<byte[]>
    //   19	71	1	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   105	11	1	localIOException1	java.io.IOException
    //   126	11	1	localIOException2	java.io.IOException
    //   142	5	1	localException1	Exception
    //   156	41	1	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   215	46	1	localIOException3	java.io.IOException
    //   267	11	1	localIOException4	java.io.IOException
    //   292	11	1	localIOException5	java.io.IOException
    //   7	202	2	localByteArrayOutputStream3	java.io.ByteArrayOutputStream
    //   22	264	3	localObject1	Object
    //   16	132	4	localObject2	Object
    //   160	1	4	localException2	Exception
    //   175	25	4	localException3	Exception
    //   58	23	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   98	102	105	java/io/IOException
    //   119	124	126	java/io/IOException
    //   23	30	142	java/lang/Exception
    //   35	44	142	java/lang/Exception
    //   49	60	142	java/lang/Exception
    //   65	73	142	java/lang/Exception
    //   78	85	142	java/lang/Exception
    //   93	98	142	java/lang/Exception
    //   8	18	152	finally
    //   8	18	160	java/lang/Exception
    //   0	8	167	finally
    //   0	8	175	java/lang/Exception
    //   208	212	215	java/io/IOException
    //   233	237	239	java/io/IOException
    //   23	30	255	finally
    //   35	44	255	finally
    //   49	60	255	finally
    //   65	73	255	finally
    //   78	85	255	finally
    //   93	98	255	finally
    //   185	195	255	finally
    //   199	204	255	finally
    //   260	264	267	java/io/IOException
    //   285	289	292	java/io/IOException
  }
  
  public static ReqHead getReqHead(JceStruct paramJceStruct)
  {
    ab.c(TAG, "enter");
    if (paramJceStruct == null)
    {
      ab.c(TAG, "null == jceRequestStruce");
      ab.c(TAG, "exit");
      return null;
    }
    ReqHead localReqHead = new ReqHead();
    localReqHead.requestId = GlobalUtil.getMemUUID();
    Object localObject = paramJceStruct.getClass().getSimpleName();
    if (((String)localObject).endsWith("Request"))
    {
      paramJceStruct = ((String)localObject).substring(0, ((String)localObject).length() - 7);
    }
    else
    {
      paramJceStruct = (JceStruct)localObject;
      if (((String)localObject).endsWith("Req")) {
        paramJceStruct = ((String)localObject).substring(0, ((String)localObject).length() - 3);
      }
    }
    localReqHead.cmdId = JceCmd.convert(paramJceStruct).value();
    localReqHead.qua = GlobalUtil.getInstance().mQUA;
    localReqHead.phoneGuid = GlobalUtil.getInstance().getPhoneGuid();
    paramJceStruct = new Terminal();
    paramJceStruct.androidId = GlobalUtil.getInstance().getAndroidIdInPhone();
    paramJceStruct.androidIdSdCard = "";
    paramJceStruct.imei = GlobalUtil.getInstance().getImei();
    paramJceStruct.imsi = GlobalUtil.getInstance().getImsi();
    paramJceStruct.macAdress = GlobalUtil.getInstance().getMacAddress();
    paramJceStruct.manufacture = GlobalUtil.getInstance().getManufacture();
    paramJceStruct.product = GlobalUtil.getInstance().getProduct();
    paramJceStruct.xResolution = GlobalUtil.getInstance().getScreenWidth();
    paramJceStruct.yResolution = GlobalUtil.getInstance().getScreenHeight();
    paramJceStruct.brand = GlobalUtil.getInstance().getBrand();
    paramJceStruct.mode = GlobalUtil.getInstance().getModel();
    localReqHead.terminal = paramJceStruct;
    localReqHead.terminalExtra = f.a().b();
    localReqHead.assistantAPILevel = GlobalUtil.getInstance().getQQDownloaderAPILevel();
    localReqHead.assistantVersionCode = GlobalUtil.getInstance().getQQDownloaderVersionCode();
    paramJceStruct = o.b();
    localObject = new Net();
    if (paramJceStruct != null)
    {
      if (paramJceStruct.a != null) {
        ((Net)localObject).netType = ((byte)GlobalUtil.getInt(Integer.valueOf(paramJceStruct.a.b())));
      }
      if (paramJceStruct.d) {
        ((Net)localObject).isWap = 1;
      } else {
        ((Net)localObject).isWap = 0;
      }
      ((Net)localObject).extNetworkOperator = paramJceStruct.b;
      ((Net)localObject).extNetworkType = paramJceStruct.c;
    }
    localReqHead.net = ((Net)localObject);
    localReqHead.hostPackageName = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
    localReqHead.hostVersionCode = GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext());
    paramJceStruct = new RomInfo();
    paramJceStruct.sysVersionCode = GlobalUtil.getString(String.valueOf(Build.VERSION.SDK_INT));
    paramJceStruct.sysVersionName = GlobalUtil.getString(Build.VERSION.RELEASE);
    if (GlobalUtil.getInstance().getContext() != null) {
      paramJceStruct.sysId = Settings.Secure.getString(GlobalUtil.getInstance().getContext().getContentResolver(), "android_id");
    }
    localReqHead.romInfo = paramJceStruct;
    GlobalUtil.getInstance().getQimei();
    GlobalUtil.getInstance().getQadid();
    ab.c(TAG, "exit");
    return localReqHead;
  }
  
  public static byte[] jceStructToUTF8Byte(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    JceOutputStream localJceOutputStream = new JceOutputStream();
    localJceOutputStream.setServerEncoding("utf-8");
    paramJceStruct.writeTo(localJceOutputStream);
    return localJceOutputStream.toByteArray();
  }
  
  public static Response unpackPackage(byte[] paramArrayOfByte)
  {
    ab.c(TAG, "enter");
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 4))
    {
      Response localResponse = new Response();
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        localResponse.readFrom(paramArrayOfByte);
        if (localResponse.head.ret == 0)
        {
          if ((localResponse.head.encryptWithPack & 0x2) == 2)
          {
            localResponse.body = decrypt(localResponse.body, "ji*9^&43U0X-~./(".getBytes());
            ab.c(TAG, "decrypt process");
          }
          if ((localResponse.head.encryptWithPack & 0x1) == 1)
          {
            localResponse.body = ag.b(localResponse.body);
            ab.c(TAG, "unzip process");
          }
          if (!TextUtils.isEmpty(localResponse.head.phoneGuid)) {
            GlobalUtil.getInstance().setPhoneGuid(localResponse.head.phoneGuid);
          }
        }
        ab.c(TAG, "exit");
        return localResponse;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        ab.b(TAG, "exception: ", paramArrayOfByte);
        return null;
      }
    }
    ab.c(TAG, "null == dataBuffer || dataBuffer.length < 4");
    ab.c(TAG, "exit");
    return null;
  }
  
  public static Request unpackRequestPackage(byte[] paramArrayOfByte)
  {
    ab.c(TAG, "enter");
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 4))
    {
      Request localRequest = new Request();
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        localRequest.readFrom(paramArrayOfByte);
        if ((localRequest.head.encryptWithPack & 0x2) == 2)
        {
          localRequest.body = decrypt(localRequest.body, "ji*9^&43U0X-~./(".getBytes());
          ab.c(TAG, "decrypt process");
        }
        if ((localRequest.head.encryptWithPack & 0x1) == 1)
        {
          localRequest.body = ag.b(localRequest.body);
          ab.c(TAG, "unzip process");
        }
        ab.c(TAG, "exit");
        return localRequest;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        ab.b(TAG, "exception: ", paramArrayOfByte);
        return null;
      }
    }
    ab.c(TAG, "null == dataBuffer || dataBuffer.length < 4");
    ab.c(TAG, "exit");
    return null;
  }
  
  public static JceStruct unpageageJceResponse(JceStruct paramJceStruct, byte[] paramArrayOfByte)
  {
    ab.c(TAG, "enter");
    if ((paramJceStruct != null) && (paramArrayOfByte != null))
    {
      paramJceStruct = createFromRequest(paramJceStruct);
      if (paramJceStruct != null) {
        try
        {
          paramArrayOfByte = new JceInputStream(paramArrayOfByte);
          paramArrayOfByte.setServerEncoding("utf-8");
          paramJceStruct.readFrom(paramArrayOfByte);
          ab.c(TAG, "exit");
          return paramJceStruct;
        }
        catch (Exception paramJceStruct)
        {
          paramJceStruct.printStackTrace();
          ab.b(TAG, "exception: ", paramJceStruct);
          return null;
        }
      }
    }
    ab.c(TAG, "exit");
    return null;
  }
  
  public static JceStruct unpageageJceResponse(byte[] paramArrayOfByte, Class<? extends JceStruct> paramClass)
  {
    if (paramArrayOfByte != null) {
      try
      {
        paramClass = (JceStruct)paramClass.newInstance();
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        paramClass.readFrom(paramArrayOfByte);
        return paramClass;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.common.ProtocolPackage
 * JD-Core Version:    0.7.0.1
 */