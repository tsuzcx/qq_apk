package com.tencent.mobileqq.service.qzone;

import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.mobile_get_config_req;
import QMF_PROTOCAL.mobile_get_config_rsp;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.config.provider.ExtraConfig;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.WNSStream;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class QZoneFeedCountPackeger
{
  public static String a = "hostuin";
  private static AtomicInteger b = new AtomicInteger(Math.abs(new Random(65535L).nextInt()));
  
  public static JceStruct a(int paramInt, long paramLong)
  {
    String str;
    try
    {
      str = QZConfigProviderUtil.c();
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("getCongfigPacket cookies: ");
        localStringBuilder1.append(str);
        QLog.d("UndealCount.QZoneFeedCountPackeger", 1, localStringBuilder1.toString());
      }
      catch (Throwable localThrowable1) {}
      QLog.e("UndealCount.QZoneFeedCountPackeger", 1, localThrowable2, new Object[0]);
    }
    catch (Throwable localThrowable2)
    {
      str = null;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("config Scene=");
      localStringBuilder2.append(paramInt);
      QLog.d("GetUndealCountTag", 4, localStringBuilder2.toString());
    }
    if (str == null) {
      str = "";
    }
    return new mobile_get_config_req(1000027, paramInt, str);
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = new WNSStream();
    try
    {
      localObject1 = ((WNSStream)localObject1).unpack(WupUtil.b(paramArrayOfByte));
      paramArrayOfByte = new UniAttribute();
      if ((localObject1 != null) && (((QmfDownstream)localObject1).WnsCode == 0))
      {
        paramArrayOfByte.setEncodeName("utf-8");
        paramArrayOfByte.decode(((QmfDownstream)localObject1).Extra);
        Object localObject2 = (QmfBusiControl)paramArrayOfByte.get("busiCompCtl");
        if ((localObject2 != null) && (1 == ((QmfBusiControl)localObject2).compFlag))
        {
          localObject2 = WNSStream.decompress(((QmfDownstream)localObject1).BusiBuff);
          if (localObject2 == null) {
            break label187;
          }
          ((QmfDownstream)localObject1).BusiBuff = ((byte[])localObject2);
        }
        localObject2 = new UniAttribute();
        ((UniAttribute)localObject2).setEncodeName("utf-8");
        ((UniAttribute)localObject2).decode(((QmfDownstream)localObject1).BusiBuff);
        paramString = (JceStruct)((UniAttribute)localObject2).get(paramString);
        ThreadManager.post(new QZoneFeedCountPackeger.1(paramArrayOfByte, paramQQAppInterface), 8, null, true);
        return paramString;
      }
      else
      {
        if (localObject1 != null)
        {
          int i = ((QmfDownstream)localObject1).WnsCode;
          if (i != 0) {
            return null;
          }
        }
        if (localObject1 == null) {}
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    label187:
    return null;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, mobile_get_config_rsp parammobile_get_config_rsp)
  {
    if ((parammobile_get_config_rsp != null) && (parammobile_get_config_rsp.config != null) && (!parammobile_get_config_rsp.config.isEmpty())) {}
    try
    {
      ExtraConfig.a(parammobile_get_config_rsp.config, true);
      label32:
      Object localObject2 = BaseApplication.getContext().getPackageName();
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "unknow";
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("qq config update:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("ConfigProvider", 2, ((StringBuilder)localObject2).toString());
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("UndealCount.QZoneFeedCountPackeger", 4, "UndealCount.QZoneFeedCountPackeger saveConfigToProvider");
      }
      QZConfigProviderUtil.a(parammobile_get_config_rsp.config, parammobile_get_config_rsp.cookies, (String)localObject1, paramQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  /* Error */
  public static byte[] a(JceStruct paramJceStruct, String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: new 51	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   7: astore 11
    //   9: aload 11
    //   11: ldc 219
    //   13: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 11
    //   19: lload_2
    //   20: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   23: invokestatic 231	mqq/util/LogUtil:getSafePrintUin	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 60
    //   32: iconst_1
    //   33: aload 11
    //   35: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: new 109	com/qq/jce/wup/UniAttribute
    //   44: dup
    //   45: invokespecial 110	com/qq/jce/wup/UniAttribute:<init>	()V
    //   48: astore 11
    //   50: aload 11
    //   52: ldc 233
    //   54: invokevirtual 122	com/qq/jce/wup/UniAttribute:setEncodeName	(Ljava/lang/String;)V
    //   57: aload 11
    //   59: getstatic 235	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:a	Ljava/lang/String;
    //   62: lload_2
    //   63: invokestatic 240	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   66: invokevirtual 244	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   69: aload_0
    //   70: ifnull +21 -> 91
    //   73: aload_1
    //   74: ifnull +17 -> 91
    //   77: aload_1
    //   78: invokevirtual 247	java/lang/String:length	()I
    //   81: ifle +10 -> 91
    //   84: aload 11
    //   86: aload_1
    //   87: aload_0
    //   88: invokevirtual 244	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   91: aload 11
    //   93: invokevirtual 251	com/qq/jce/wup/UniAttribute:encode	()[B
    //   96: astore 13
    //   98: new 51	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   105: astore_0
    //   106: aload_0
    //   107: ldc 253
    //   109: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_0
    //   114: iload 4
    //   116: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_0
    //   121: ldc 255
    //   123: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_0
    //   128: iload 5
    //   130: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_0
    //   135: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore 12
    //   140: new 51	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   147: astore 14
    //   149: aload 14
    //   151: ldc_w 257
    //   154: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 14
    //   160: invokestatic 263	cooperation/qzone/PlatformInfor:g	()Lcooperation/qzone/PlatformInfor;
    //   163: invokevirtual 266	cooperation/qzone/PlatformInfor:getDeviceInfor	()Ljava/lang/String;
    //   166: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: ldc_w 268
    //   173: invokestatic 273	com/tencent/mobileqq/servlet/QZoneNotifyServlet:a	(Ljava/lang/String;)Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   176: astore_0
    //   177: ldc 86
    //   179: astore 11
    //   181: aload_0
    //   182: ifnonnull +15 -> 197
    //   185: ldc_w 268
    //   188: invokestatic 275	com/tencent/mobileqq/servlet/QZoneNotifyServlet:b	(Ljava/lang/String;)V
    //   191: ldc 86
    //   193: astore_0
    //   194: goto +70 -> 264
    //   197: aload_0
    //   198: getfield 280	cooperation/qzone/LbsDataV2$GpsInfo:lat	I
    //   201: istore 4
    //   203: iload 4
    //   205: i2d
    //   206: dstore 7
    //   208: dload 7
    //   210: invokestatic 286	java/lang/Double:isNaN	(D)Z
    //   213: pop
    //   214: dload 7
    //   216: dconst_1
    //   217: dmul
    //   218: ldc2_w 287
    //   221: ddiv
    //   222: dstore 7
    //   224: aload_0
    //   225: getfield 291	cooperation/qzone/LbsDataV2$GpsInfo:lon	I
    //   228: istore 4
    //   230: iload 4
    //   232: i2d
    //   233: dstore 9
    //   235: dload 9
    //   237: invokestatic 286	java/lang/Double:isNaN	(D)Z
    //   240: pop
    //   241: dload 9
    //   243: dconst_1
    //   244: dmul
    //   245: ldc2_w 287
    //   248: ddiv
    //   249: dstore 9
    //   251: dload 9
    //   253: invokestatic 294	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   256: astore 11
    //   258: dload 7
    //   260: invokestatic 294	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   263: astore_0
    //   264: aload 14
    //   266: bipush 38
    //   268: invokevirtual 297	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 14
    //   274: ldc_w 299
    //   277: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 14
    //   283: aload 11
    //   285: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 14
    //   291: bipush 38
    //   293: invokevirtual 297	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 14
    //   299: ldc_w 301
    //   302: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 14
    //   308: aload_0
    //   309: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 12
    //   315: astore_0
    //   316: aload 14
    //   318: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   324: ifne +33 -> 357
    //   327: new 51	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   334: astore_0
    //   335: aload_0
    //   336: aload 12
    //   338: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_0
    //   343: aload 14
    //   345: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload_0
    //   353: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: astore_0
    //   357: new 97	cooperation/qzone/WNSStream
    //   360: dup
    //   361: ldc 89
    //   363: invokestatic 306	cooperation/qzone/QZoneHelper:getQUA	()Ljava/lang/String;
    //   366: lload_2
    //   367: iconst_0
    //   368: newarray byte
    //   370: aload_0
    //   371: invokespecial 309	cooperation/qzone/WNSStream:<init>	(ILjava/lang/String;J[BLjava/lang/String;)V
    //   374: astore 11
    //   376: aload 13
    //   378: ifnull +82 -> 460
    //   381: iload 6
    //   383: lload_2
    //   384: invokestatic 311	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:a	(IJ)Lcom/qq/taf/jce/JceStruct;
    //   387: astore_0
    //   388: goto +17 -> 405
    //   391: astore_0
    //   392: ldc 60
    //   394: iconst_1
    //   395: aload_0
    //   396: iconst_0
    //   397: anewarray 4	java/lang/Object
    //   400: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   403: aconst_null
    //   404: astore_0
    //   405: getstatic 37	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:b	Ljava/util/concurrent/atomic/AtomicInteger;
    //   408: invokevirtual 314	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   411: istore 4
    //   413: new 51	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   420: astore 12
    //   422: aload 12
    //   424: ldc_w 316
    //   427: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload 12
    //   433: aload_1
    //   434: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload 11
    //   440: iload 4
    //   442: aload 12
    //   444: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: aload 13
    //   449: iconst_0
    //   450: aload_0
    //   451: invokevirtual 320	cooperation/qzone/WNSStream:packForUndeal	(ILjava/lang/String;[BZLcom/qq/taf/jce/JceStruct;)[B
    //   454: invokestatic 322	com/tencent/mobileqq/utils/WupUtil:a	([B)[B
    //   457: astore_0
    //   458: aload_0
    //   459: areturn
    //   460: aconst_null
    //   461: areturn
    //   462: aconst_null
    //   463: areturn
    //   464: astore_0
    //   465: goto -3 -> 462
    //   468: astore_0
    //   469: goto -299 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	paramJceStruct	JceStruct
    //   0	472	1	paramString	String
    //   0	472	2	paramLong	long
    //   0	472	4	paramInt1	int
    //   0	472	5	paramInt2	int
    //   0	472	6	paramInt3	int
    //   206	53	7	d1	double
    //   233	19	9	d2	double
    //   7	432	11	localObject1	Object
    //   138	305	12	localObject2	Object
    //   96	352	13	arrayOfByte	byte[]
    //   147	197	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   381	388	391	java/lang/Error
    //   0	69	464	java/lang/Throwable
    //   77	91	464	java/lang/Throwable
    //   91	149	464	java/lang/Throwable
    //   149	170	464	java/lang/Throwable
    //   170	177	464	java/lang/Throwable
    //   185	191	464	java/lang/Throwable
    //   197	203	464	java/lang/Throwable
    //   224	230	464	java/lang/Throwable
    //   251	264	464	java/lang/Throwable
    //   264	313	464	java/lang/Throwable
    //   316	357	464	java/lang/Throwable
    //   357	376	464	java/lang/Throwable
    //   381	388	464	java/lang/Throwable
    //   392	403	464	java/lang/Throwable
    //   405	458	464	java/lang/Throwable
    //   149	170	468	java/lang/Exception
  }
  
  private static void b(UniAttribute paramUniAttribute, QQAppInterface paramQQAppInterface)
  {
    if (paramUniAttribute != null) {
      try
      {
        Object localObject = paramUniAttribute.get("conf_info_rsp_len");
        if (localObject == null)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("UndealCount.QZoneFeedCountPackeger", 2, "processConfig pack get conf_info_rsp_len is null ");
          return;
        }
        int i = ((Integer)localObject).intValue();
        localObject = (byte[])paramUniAttribute.get("conf_info_rsp");
        paramUniAttribute = (UniAttribute)localObject;
        if (localObject != null)
        {
          paramUniAttribute = (UniAttribute)localObject;
          if (i != 0) {
            paramUniAttribute = WNSStream.decompress((byte[])localObject);
          }
        }
        if (paramUniAttribute != null)
        {
          paramUniAttribute = WNSStream.decodeWup(mobile_get_config_rsp.class, paramUniAttribute);
          if ((paramQQAppInterface != null) && (paramQQAppInterface.getApp() != null) && (paramUniAttribute != null))
          {
            a(paramQQAppInterface, (mobile_get_config_rsp)paramUniAttribute);
            return;
          }
        }
      }
      catch (Exception paramUniAttribute)
      {
        paramUniAttribute.printStackTrace();
        return;
      }
      catch (Error paramUniAttribute)
      {
        paramUniAttribute.printStackTrace();
      }
    } else {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger
 * JD-Core Version:    0.7.0.1
 */