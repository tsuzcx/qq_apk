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
    paramJceStruct = paramJceStruct.substring(0, paramJceStruct.length() - "Request".length()) + "Response";
    try
    {
      paramJceStruct = (JceStruct)Class.forName(paramJceStruct).newInstance();
      ab.c(TAG, "exit");
      return paramJceStruct;
    }
    catch (ClassNotFoundException paramJceStruct)
    {
      for (;;)
      {
        ab.b(TAG, "exception: ", paramJceStruct);
        paramJceStruct.printStackTrace();
        paramJceStruct = null;
      }
    }
    catch (IllegalAccessException paramJceStruct)
    {
      for (;;)
      {
        ab.b(TAG, "exception: ", paramJceStruct);
        paramJceStruct.printStackTrace();
        paramJceStruct = null;
      }
    }
    catch (InstantiationException paramJceStruct)
    {
      for (;;)
      {
        ab.b(TAG, "exception: ", paramJceStruct);
        paramJceStruct.printStackTrace();
        paramJceStruct = null;
      }
    }
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
    //   0: new 203	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 204	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 206	java/io/DataOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 209	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: aload_1
    //   22: astore_2
    //   23: aload_0
    //   24: invokeinterface 215 1 0
    //   29: astore_0
    //   30: aload 4
    //   32: astore_3
    //   33: aload_1
    //   34: astore_2
    //   35: aload_0
    //   36: invokeinterface 221 1 0
    //   41: ifeq +97 -> 138
    //   44: aload 4
    //   46: astore_3
    //   47: aload_1
    //   48: astore_2
    //   49: aload_0
    //   50: invokeinterface 224 1 0
    //   55: checkcast 225	[B
    //   58: astore 5
    //   60: aload 4
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload 4
    //   67: aload 5
    //   69: arraylength
    //   70: invokevirtual 229	java/io/DataOutputStream:writeInt	(I)V
    //   73: aload 4
    //   75: astore_3
    //   76: aload_1
    //   77: astore_2
    //   78: aload 4
    //   80: aload 5
    //   82: invokevirtual 232	java/io/DataOutputStream:write	([B)V
    //   85: goto -55 -> 30
    //   88: astore_2
    //   89: aload 4
    //   91: astore_0
    //   92: aload_2
    //   93: astore 4
    //   95: aload_0
    //   96: astore_3
    //   97: aload_1
    //   98: astore_2
    //   99: getstatic 18	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   102: ldc 139
    //   104: aload 4
    //   106: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload_0
    //   110: astore_3
    //   111: aload_1
    //   112: astore_2
    //   113: aload 4
    //   115: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 236	java/io/ByteArrayOutputStream:close	()V
    //   126: aload_0
    //   127: ifnull +7 -> 134
    //   130: aload_0
    //   131: invokevirtual 237	java/io/DataOutputStream:close	()V
    //   134: aconst_null
    //   135: astore_1
    //   136: aload_1
    //   137: areturn
    //   138: aload 4
    //   140: astore_3
    //   141: aload_1
    //   142: astore_2
    //   143: aload_1
    //   144: invokevirtual 240	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   147: astore_0
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 236	java/io/ByteArrayOutputStream:close	()V
    //   156: aload_0
    //   157: astore_1
    //   158: aload 4
    //   160: ifnull -24 -> 136
    //   163: aload 4
    //   165: invokevirtual 237	java/io/DataOutputStream:close	()V
    //   168: aload_0
    //   169: areturn
    //   170: astore_1
    //   171: getstatic 18	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   174: ldc 139
    //   176: aload_1
    //   177: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   180: aload_1
    //   181: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   184: aload_0
    //   185: areturn
    //   186: astore_1
    //   187: getstatic 18	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   190: ldc 139
    //   192: aload_1
    //   193: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: aload_1
    //   197: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   200: goto -44 -> 156
    //   203: astore_1
    //   204: getstatic 18	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   207: ldc 139
    //   209: aload_1
    //   210: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_1
    //   214: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   217: goto -91 -> 126
    //   220: astore_0
    //   221: getstatic 18	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   224: ldc 139
    //   226: aload_0
    //   227: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   230: aload_0
    //   231: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   234: goto -100 -> 134
    //   237: astore_0
    //   238: aconst_null
    //   239: astore_3
    //   240: aconst_null
    //   241: astore_1
    //   242: aload_1
    //   243: ifnull +7 -> 250
    //   246: aload_1
    //   247: invokevirtual 236	java/io/ByteArrayOutputStream:close	()V
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 237	java/io/DataOutputStream:close	()V
    //   258: aload_0
    //   259: athrow
    //   260: astore_1
    //   261: getstatic 18	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   264: ldc 139
    //   266: aload_1
    //   267: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   270: aload_1
    //   271: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   274: goto -24 -> 250
    //   277: astore_1
    //   278: getstatic 18	com/tencent/tmassistant/common/ProtocolPackage:TAG	Ljava/lang/String;
    //   281: ldc 139
    //   283: aload_1
    //   284: invokestatic 143	com/tencent/tmassistantbase/util/ab:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   287: aload_1
    //   288: invokevirtual 241	java/io/IOException:printStackTrace	()V
    //   291: goto -33 -> 258
    //   294: astore_0
    //   295: aconst_null
    //   296: astore_3
    //   297: goto -55 -> 242
    //   300: astore_0
    //   301: aload_2
    //   302: astore_1
    //   303: goto -61 -> 242
    //   306: astore 4
    //   308: aconst_null
    //   309: astore_0
    //   310: aconst_null
    //   311: astore_1
    //   312: goto -217 -> 95
    //   315: astore 4
    //   317: aconst_null
    //   318: astore_0
    //   319: goto -224 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramList	List<byte[]>
    //   7	151	1	localObject1	Object
    //   170	11	1	localIOException1	java.io.IOException
    //   186	11	1	localIOException2	java.io.IOException
    //   203	11	1	localIOException3	java.io.IOException
    //   241	6	1	localObject2	Object
    //   260	11	1	localIOException4	java.io.IOException
    //   277	11	1	localIOException5	java.io.IOException
    //   302	10	1	localObject3	Object
    //   22	56	2	localObject4	Object
    //   88	5	2	localException1	Exception
    //   98	204	2	localObject5	Object
    //   20	277	3	localObject6	Object
    //   16	148	4	localObject7	Object
    //   306	1	4	localException2	Exception
    //   315	1	4	localException3	Exception
    //   58	23	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   23	30	88	java/lang/Exception
    //   35	44	88	java/lang/Exception
    //   49	60	88	java/lang/Exception
    //   65	73	88	java/lang/Exception
    //   78	85	88	java/lang/Exception
    //   143	148	88	java/lang/Exception
    //   163	168	170	java/io/IOException
    //   152	156	186	java/io/IOException
    //   122	126	203	java/io/IOException
    //   130	134	220	java/io/IOException
    //   0	8	237	finally
    //   246	250	260	java/io/IOException
    //   254	258	277	java/io/IOException
    //   8	18	294	finally
    //   23	30	300	finally
    //   35	44	300	finally
    //   49	60	300	finally
    //   65	73	300	finally
    //   78	85	300	finally
    //   99	109	300	finally
    //   113	118	300	finally
    //   143	148	300	finally
    //   0	8	306	java/lang/Exception
    //   8	18	315	java/lang/Exception
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
      paramJceStruct = ((String)localObject).substring(0, ((String)localObject).length() - "Request".length());
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
        if (!paramJceStruct.d) {
          break label479;
        }
      }
    }
    label479:
    for (((Net)localObject).isWap = 1;; ((Net)localObject).isWap = 0)
    {
      ((Net)localObject).extNetworkOperator = paramJceStruct.b;
      ((Net)localObject).extNetworkType = paramJceStruct.c;
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
      paramJceStruct = (JceStruct)localObject;
      if (!((String)localObject).endsWith("Req")) {
        break;
      }
      paramJceStruct = ((String)localObject).substring(0, ((String)localObject).length() - "Req".length());
      break;
    }
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
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4))
    {
      ab.c(TAG, "null == dataBuffer || dataBuffer.length < 4");
      ab.c(TAG, "exit");
      return null;
    }
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
    }
    return null;
  }
  
  public static Request unpackRequestPackage(byte[] paramArrayOfByte)
  {
    ab.c(TAG, "enter");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4))
    {
      ab.c(TAG, "null == dataBuffer || dataBuffer.length < 4");
      ab.c(TAG, "exit");
      return null;
    }
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
    }
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
        return null;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.ProtocolPackage
 * JD-Core Version:    0.7.0.1
 */