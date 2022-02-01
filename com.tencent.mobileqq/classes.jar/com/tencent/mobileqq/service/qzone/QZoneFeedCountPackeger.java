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
  public static String a;
  private static AtomicInteger a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "hostuin";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(Math.abs(new Random(65535L).nextInt()));
  }
  
  public static JceStruct a(int paramInt, long paramLong)
  {
    for (;;)
    {
      try
      {
        str = QZConfigProviderUtil.a();
        QLog.e("UndealCount.QZoneFeedCountPackeger", 1, localThrowable1, new Object[0]);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          QLog.d("UndealCount.QZoneFeedCountPackeger", 1, "getCongfigPacket cookies: " + str);
          if (QLog.isDevelopLevel()) {
            QLog.d("GetUndealCountTag", 4, "config Scene=" + paramInt);
          }
          if (str == null) {
            break label95;
          }
          return new mobile_get_config_req(1000027, paramInt, str);
        }
        catch (Throwable localThrowable2)
        {
          String str;
          break label80;
        }
        localThrowable1 = localThrowable1;
        str = null;
      }
      label80:
      continue;
      label95:
      str = "";
    }
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
            break label186;
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
      if (localObject1 != null)
      {
        int i = ((QmfDownstream)localObject1).WnsCode;
        if (i != 0) {
          return null;
        }
      }
      if (localObject1 == null) {
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    return null;
    label186:
    return null;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, mobile_get_config_rsp parammobile_get_config_rsp)
  {
    if ((parammobile_get_config_rsp != null) && (parammobile_get_config_rsp.config != null) && (!parammobile_get_config_rsp.config.isEmpty())) {}
    try
    {
      ExtraConfig.a(parammobile_get_config_rsp.config, true);
      label32:
      String str2 = BaseApplication.getContext().getPackageName();
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "unknow";
      }
      if (QLog.isColorLevel()) {
        QLog.i("ConfigProvider", 2, "qq config update:" + str1);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("UndealCount.QZoneFeedCountPackeger", 4, "UndealCount.QZoneFeedCountPackeger saveConfigToProvider");
      }
      QZConfigProviderUtil.a(parammobile_get_config_rsp.config, parammobile_get_config_rsp.cookies, str1, paramQQAppInterface);
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
    //   0: ldc 51
    //   2: iconst_1
    //   3: new 53	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   10: ldc 220
    //   12: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: lload_2
    //   16: invokevirtual 223	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: new 110	com/qq/jce/wup/UniAttribute
    //   28: dup
    //   29: invokespecial 111	com/qq/jce/wup/UniAttribute:<init>	()V
    //   32: astore 7
    //   34: aload 7
    //   36: ldc 225
    //   38: invokevirtual 123	com/qq/jce/wup/UniAttribute:setEncodeName	(Ljava/lang/String;)V
    //   41: aload 7
    //   43: getstatic 13	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   46: lload_2
    //   47: invokestatic 231	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   50: invokevirtual 235	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   53: aload_0
    //   54: ifnull +21 -> 75
    //   57: aload_1
    //   58: ifnull +17 -> 75
    //   61: aload_1
    //   62: invokevirtual 240	java/lang/String:length	()I
    //   65: ifle +10 -> 75
    //   68: aload 7
    //   70: aload_1
    //   71: aload_0
    //   72: invokevirtual 235	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   75: aload 7
    //   77: invokevirtual 244	com/qq/jce/wup/UniAttribute:encode	()[B
    //   80: astore 9
    //   82: new 53	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   89: ldc 246
    //   91: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: iload 4
    //   96: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc 248
    //   101: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload 5
    //   106: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore 8
    //   114: new 53	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   121: astore 10
    //   123: aload 10
    //   125: ldc 250
    //   127: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokestatic 256	cooperation/qzone/PlatformInfor:g	()Lcooperation/qzone/PlatformInfor;
    //   133: invokevirtual 259	cooperation/qzone/PlatformInfor:getDeviceInfor	()Ljava/lang/String;
    //   136: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: ldc_w 261
    //   143: invokestatic 266	com/tencent/mobileqq/servlet/QZoneNotifyServlet:a	(Ljava/lang/String;)Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   146: astore 11
    //   148: ldc 92
    //   150: astore 7
    //   152: ldc 92
    //   154: astore_0
    //   155: aload 11
    //   157: ifnonnull +160 -> 317
    //   160: ldc_w 261
    //   163: invokestatic 268	com/tencent/mobileqq/servlet/QZoneNotifyServlet:a	(Ljava/lang/String;)V
    //   166: aload 10
    //   168: bipush 38
    //   170: invokevirtual 271	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   173: ldc_w 273
    //   176: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_0
    //   180: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 10
    //   186: bipush 38
    //   188: invokevirtual 271	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   191: ldc_w 275
    //   194: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 7
    //   199: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 8
    //   205: astore_0
    //   206: aload 10
    //   208: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 195	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   214: ifne +27 -> 241
    //   217: new 53	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   224: aload 8
    //   226: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 10
    //   231: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: astore_0
    //   241: new 97	cooperation/qzone/WNSStream
    //   244: dup
    //   245: ldc 83
    //   247: invokestatic 280	cooperation/qzone/QZoneHelper:getQUA	()Ljava/lang/String;
    //   250: lload_2
    //   251: iconst_0
    //   252: newarray byte
    //   254: aload_0
    //   255: invokespecial 283	cooperation/qzone/WNSStream:<init>	(ILjava/lang/String;J[BLjava/lang/String;)V
    //   258: astore 8
    //   260: aload 9
    //   262: ifnull +111 -> 373
    //   265: aconst_null
    //   266: astore_0
    //   267: iload 6
    //   269: lload_2
    //   270: invokestatic 285	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:a	(IJ)Lcom/qq/taf/jce/JceStruct;
    //   273: astore 7
    //   275: aload 7
    //   277: astore_0
    //   278: aload 8
    //   280: getstatic 38	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   283: invokevirtual 288	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   286: new 53	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 290
    //   296: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_1
    //   300: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aload 9
    //   308: iconst_0
    //   309: aload_0
    //   310: invokevirtual 294	cooperation/qzone/WNSStream:packForUndeal	(ILjava/lang/String;[BZLcom/qq/taf/jce/JceStruct;)[B
    //   313: invokestatic 296	com/tencent/mobileqq/utils/WupUtil:a	([B)[B
    //   316: areturn
    //   317: dconst_1
    //   318: aload 11
    //   320: getfield 301	cooperation/qzone/LbsDataV2$GpsInfo:lat	I
    //   323: i2d
    //   324: dmul
    //   325: ldc2_w 302
    //   328: ddiv
    //   329: invokestatic 306	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   332: astore 7
    //   334: dconst_1
    //   335: aload 11
    //   337: getfield 309	cooperation/qzone/LbsDataV2$GpsInfo:lon	I
    //   340: i2d
    //   341: dmul
    //   342: ldc2_w 302
    //   345: ddiv
    //   346: invokestatic 306	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   349: astore_0
    //   350: goto -184 -> 166
    //   353: astore 7
    //   355: ldc 51
    //   357: iconst_1
    //   358: aload 7
    //   360: iconst_0
    //   361: anewarray 4	java/lang/Object
    //   364: invokestatic 90	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   367: goto -89 -> 278
    //   370: astore_0
    //   371: aconst_null
    //   372: areturn
    //   373: aconst_null
    //   374: areturn
    //   375: astore_0
    //   376: goto -236 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramJceStruct	JceStruct
    //   0	379	1	paramString	String
    //   0	379	2	paramLong	long
    //   0	379	4	paramInt1	int
    //   0	379	5	paramInt2	int
    //   0	379	6	paramInt3	int
    //   32	301	7	localObject1	Object
    //   353	6	7	localError	Error
    //   112	167	8	localObject2	Object
    //   80	227	9	arrayOfByte	byte[]
    //   121	109	10	localStringBuilder	java.lang.StringBuilder
    //   146	190	11	localGpsInfo	cooperation.qzone.LbsDataV2.GpsInfo
    // Exception table:
    //   from	to	target	type
    //   267	275	353	java/lang/Error
    //   0	53	370	java/lang/Throwable
    //   61	75	370	java/lang/Throwable
    //   75	123	370	java/lang/Throwable
    //   123	140	370	java/lang/Throwable
    //   140	148	370	java/lang/Throwable
    //   160	166	370	java/lang/Throwable
    //   166	203	370	java/lang/Throwable
    //   206	241	370	java/lang/Throwable
    //   241	260	370	java/lang/Throwable
    //   267	275	370	java/lang/Throwable
    //   278	317	370	java/lang/Throwable
    //   317	350	370	java/lang/Throwable
    //   355	367	370	java/lang/Throwable
    //   123	140	375	java/lang/Exception
  }
  
  private static void b(UniAttribute paramUniAttribute, QQAppInterface paramQQAppInterface)
  {
    if (paramUniAttribute != null) {
      try
      {
        Object localObject = paramUniAttribute.get("conf_info_rsp_len");
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UndealCount.QZoneFeedCountPackeger", 2, "processConfig pack get conf_info_rsp_len is null ");
          }
        }
        else
        {
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
      }
      catch (Error paramUniAttribute)
      {
        paramUniAttribute.printStackTrace();
        return;
      }
      catch (Exception paramUniAttribute)
      {
        paramUniAttribute.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger
 * JD-Core Version:    0.7.0.1
 */