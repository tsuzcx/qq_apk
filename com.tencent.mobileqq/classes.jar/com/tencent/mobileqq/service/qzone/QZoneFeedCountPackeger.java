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
  private static AtomicInteger a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(Math.abs(new Random(65535L).nextInt()));
  }
  
  public static JceStruct a(int paramInt, long paramLong)
  {
    String str;
    try
    {
      str = QZConfigProviderUtil.a();
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
    //   0: new 49	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   7: astore 9
    //   9: aload 9
    //   11: ldc 218
    //   13: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 9
    //   19: lload_2
    //   20: invokevirtual 221	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 58
    //   26: iconst_1
    //   27: aload 9
    //   29: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: new 108	com/qq/jce/wup/UniAttribute
    //   38: dup
    //   39: invokespecial 109	com/qq/jce/wup/UniAttribute:<init>	()V
    //   42: astore 9
    //   44: aload 9
    //   46: ldc 223
    //   48: invokevirtual 121	com/qq/jce/wup/UniAttribute:setEncodeName	(Ljava/lang/String;)V
    //   51: aload 9
    //   53: getstatic 225	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: lload_2
    //   57: invokestatic 231	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   60: invokevirtual 235	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   63: aload_0
    //   64: ifnull +21 -> 85
    //   67: aload_1
    //   68: ifnull +17 -> 85
    //   71: aload_1
    //   72: invokevirtual 240	java/lang/String:length	()I
    //   75: ifle +10 -> 85
    //   78: aload 9
    //   80: aload_1
    //   81: aload_0
    //   82: invokevirtual 235	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   85: aload 9
    //   87: invokevirtual 244	com/qq/jce/wup/UniAttribute:encode	()[B
    //   90: astore 11
    //   92: new 49	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   99: astore_0
    //   100: aload_0
    //   101: ldc 246
    //   103: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_0
    //   108: iload 4
    //   110: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_0
    //   115: ldc 248
    //   117: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_0
    //   122: iload 5
    //   124: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_0
    //   129: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 10
    //   134: new 49	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   141: astore 12
    //   143: aload 12
    //   145: ldc 250
    //   147: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 12
    //   153: invokestatic 256	cooperation/qzone/PlatformInfor:g	()Lcooperation/qzone/PlatformInfor;
    //   156: invokevirtual 259	cooperation/qzone/PlatformInfor:getDeviceInfor	()Ljava/lang/String;
    //   159: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: ldc_w 261
    //   166: invokestatic 266	com/tencent/mobileqq/servlet/QZoneNotifyServlet:a	(Ljava/lang/String;)Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   169: astore_0
    //   170: ldc 84
    //   172: astore 9
    //   174: aload_0
    //   175: ifnonnull +15 -> 190
    //   178: ldc_w 261
    //   181: invokestatic 268	com/tencent/mobileqq/servlet/QZoneNotifyServlet:a	(Ljava/lang/String;)V
    //   184: ldc 84
    //   186: astore_0
    //   187: goto +70 -> 257
    //   190: aload_0
    //   191: getfield 273	cooperation/qzone/LbsDataV2$GpsInfo:lat	I
    //   194: istore 4
    //   196: iload 4
    //   198: i2d
    //   199: dstore 7
    //   201: dload 7
    //   203: invokestatic 279	java/lang/Double:isNaN	(D)Z
    //   206: pop
    //   207: dload 7
    //   209: dconst_1
    //   210: dmul
    //   211: ldc2_w 280
    //   214: ddiv
    //   215: dstore 7
    //   217: dload 7
    //   219: invokestatic 284	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   222: astore 9
    //   224: aload_0
    //   225: getfield 287	cooperation/qzone/LbsDataV2$GpsInfo:lon	I
    //   228: istore 4
    //   230: iload 4
    //   232: i2d
    //   233: dstore 7
    //   235: dload 7
    //   237: invokestatic 279	java/lang/Double:isNaN	(D)Z
    //   240: pop
    //   241: dload 7
    //   243: dconst_1
    //   244: dmul
    //   245: ldc2_w 280
    //   248: ddiv
    //   249: dstore 7
    //   251: dload 7
    //   253: invokestatic 284	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   256: astore_0
    //   257: aload 12
    //   259: bipush 38
    //   261: invokevirtual 290	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 12
    //   267: ldc_w 292
    //   270: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 12
    //   276: aload_0
    //   277: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 12
    //   283: bipush 38
    //   285: invokevirtual 290	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 12
    //   291: ldc_w 294
    //   294: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 12
    //   300: aload 9
    //   302: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 10
    //   308: astore_0
    //   309: aload 12
    //   311: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   317: ifne +33 -> 350
    //   320: new 49	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   327: astore_0
    //   328: aload_0
    //   329: aload 10
    //   331: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_0
    //   336: aload 12
    //   338: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_0
    //   346: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: astore_0
    //   350: new 95	cooperation/qzone/WNSStream
    //   353: dup
    //   354: ldc 87
    //   356: invokestatic 299	cooperation/qzone/QZoneHelper:getQUA	()Ljava/lang/String;
    //   359: lload_2
    //   360: iconst_0
    //   361: newarray byte
    //   363: aload_0
    //   364: invokespecial 302	cooperation/qzone/WNSStream:<init>	(ILjava/lang/String;J[BLjava/lang/String;)V
    //   367: astore 9
    //   369: aload 11
    //   371: ifnull +82 -> 453
    //   374: iload 6
    //   376: lload_2
    //   377: invokestatic 304	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:a	(IJ)Lcom/qq/taf/jce/JceStruct;
    //   380: astore_0
    //   381: goto +17 -> 398
    //   384: astore_0
    //   385: ldc 58
    //   387: iconst_1
    //   388: aload_0
    //   389: iconst_0
    //   390: anewarray 4	java/lang/Object
    //   393: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   396: aconst_null
    //   397: astore_0
    //   398: getstatic 36	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   401: invokevirtual 307	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   404: istore 4
    //   406: new 49	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   413: astore 10
    //   415: aload 10
    //   417: ldc_w 309
    //   420: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 10
    //   426: aload_1
    //   427: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload 9
    //   433: iload 4
    //   435: aload 10
    //   437: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: aload 11
    //   442: iconst_0
    //   443: aload_0
    //   444: invokevirtual 313	cooperation/qzone/WNSStream:packForUndeal	(ILjava/lang/String;[BZLcom/qq/taf/jce/JceStruct;)[B
    //   447: invokestatic 315	com/tencent/mobileqq/utils/WupUtil:a	([B)[B
    //   450: astore_0
    //   451: aload_0
    //   452: areturn
    //   453: aconst_null
    //   454: areturn
    //   455: aconst_null
    //   456: areturn
    //   457: astore_0
    //   458: goto -3 -> 455
    //   461: astore_0
    //   462: goto -299 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	paramJceStruct	JceStruct
    //   0	465	1	paramString	String
    //   0	465	2	paramLong	long
    //   0	465	4	paramInt1	int
    //   0	465	5	paramInt2	int
    //   0	465	6	paramInt3	int
    //   199	53	7	d	double
    //   7	425	9	localObject1	Object
    //   132	304	10	localObject2	Object
    //   90	351	11	arrayOfByte	byte[]
    //   141	196	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   374	381	384	java/lang/Error
    //   0	63	457	java/lang/Throwable
    //   71	85	457	java/lang/Throwable
    //   85	143	457	java/lang/Throwable
    //   143	163	457	java/lang/Throwable
    //   163	170	457	java/lang/Throwable
    //   178	184	457	java/lang/Throwable
    //   190	196	457	java/lang/Throwable
    //   217	230	457	java/lang/Throwable
    //   251	257	457	java/lang/Throwable
    //   257	306	457	java/lang/Throwable
    //   309	350	457	java/lang/Throwable
    //   350	369	457	java/lang/Throwable
    //   374	381	457	java/lang/Throwable
    //   385	396	457	java/lang/Throwable
    //   398	451	457	java/lang/Throwable
    //   143	163	461	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger
 * JD-Core Version:    0.7.0.1
 */