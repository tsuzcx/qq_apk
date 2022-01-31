package com.tencent.mobileqq.service.qzone;

import QMF_PROTOCAL.QmfBusiControl;
import QMF_PROTOCAL.QmfDownstream;
import QMF_PROTOCAL.mobile_get_config_req;
import QMF_PROTOCAL.mobile_get_config_rsp;
import ahjp;
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
import cooperation.qzone.util.QZoneLogTags;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class QZoneFeedCountPackeger
{
  public static String a;
  private static AtomicInteger a;
  private static final String b = QZoneLogTags.LOG_TAG_UNDEALCOUNT + "QZoneFeedCountPackeger";
  
  static
  {
    jdField_a_of_type_JavaLangString = "hostuin";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(Math.abs(new Random(65535L).nextInt()));
  }
  
  public static JceStruct a(int paramInt)
  {
    String str = QZConfigProviderUtil.a();
    if (QLog.isDevelopLevel()) {
      QLog.d("GetUndealCountTag", 4, "config Scene=" + paramInt);
    }
    if (str != null) {}
    for (;;)
    {
      return new mobile_get_config_req(1000027, paramInt, str);
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
        ThreadManager.post(new ahjp(paramArrayOfByte, paramQQAppInterface), 8, null, true);
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
        QLog.d(b, 4, b + " saveConfigToProvider");
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
    //   0: new 109	com/qq/jce/wup/UniAttribute
    //   3: dup
    //   4: invokespecial 110	com/qq/jce/wup/UniAttribute:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc 221
    //   13: invokevirtual 122	com/qq/jce/wup/UniAttribute:setEncodeName	(Ljava/lang/String;)V
    //   16: aload 7
    //   18: getstatic 36	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: lload_2
    //   22: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   25: invokevirtual 231	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   28: aload_0
    //   29: ifnull +21 -> 50
    //   32: aload_1
    //   33: ifnull +17 -> 50
    //   36: aload_1
    //   37: invokevirtual 236	java/lang/String:length	()I
    //   40: ifle +10 -> 50
    //   43: aload 7
    //   45: aload_1
    //   46: aload_0
    //   47: invokevirtual 231	com/qq/jce/wup/UniAttribute:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   50: aload 7
    //   52: invokevirtual 240	com/qq/jce/wup/UniAttribute:encode	()[B
    //   55: astore 9
    //   57: new 12	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   64: ldc 242
    //   66: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: iload 4
    //   71: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: ldc 244
    //   76: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload 5
    //   81: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 8
    //   89: new 12	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   96: astore 10
    //   98: aload 10
    //   100: ldc 246
    //   102: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokestatic 251	cooperation/qzone/PlatformInfor:a	()Lcooperation/qzone/PlatformInfor;
    //   108: invokevirtual 253	cooperation/qzone/PlatformInfor:b	()Ljava/lang/String;
    //   111: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: invokestatic 258	com/tencent/mobileqq/servlet/QZoneNotifyServlet:a	()Lcooperation/qzone/LbsDataV2$GpsInfo;
    //   118: astore 11
    //   120: ldc 92
    //   122: astore 7
    //   124: ldc 92
    //   126: astore_0
    //   127: aload 11
    //   129: ifnonnull +156 -> 285
    //   132: invokestatic 260	com/tencent/mobileqq/servlet/QZoneNotifyServlet:a	()V
    //   135: aload 10
    //   137: bipush 38
    //   139: invokevirtual 263	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   142: ldc_w 265
    //   145: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_0
    //   149: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 10
    //   155: bipush 38
    //   157: invokevirtual 263	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   160: ldc_w 267
    //   163: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload 7
    //   168: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 8
    //   174: astore_0
    //   175: aload 10
    //   177: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifne +27 -> 210
    //   186: new 12	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   193: aload 8
    //   195: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 10
    //   200: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: astore_0
    //   210: new 97	cooperation/qzone/WNSStream
    //   213: dup
    //   214: ldc 87
    //   216: invokestatic 270	cooperation/qzone/QZoneHelper:a	()Ljava/lang/String;
    //   219: lload_2
    //   220: iconst_0
    //   221: newarray byte
    //   223: aload_0
    //   224: invokespecial 273	cooperation/qzone/WNSStream:<init>	(ILjava/lang/String;J[BLjava/lang/String;)V
    //   227: astore 8
    //   229: aload 9
    //   231: ifnull +103 -> 334
    //   234: aconst_null
    //   235: astore_0
    //   236: iload 6
    //   238: invokestatic 275	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:a	(I)Lcom/qq/taf/jce/JceStruct;
    //   241: astore 7
    //   243: aload 7
    //   245: astore_0
    //   246: aload 8
    //   248: getstatic 60	com/tencent/mobileqq/service/qzone/QZoneFeedCountPackeger:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   251: invokevirtual 278	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   254: new 12	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 15	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 280
    //   264: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_1
    //   268: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: aload 9
    //   276: iconst_0
    //   277: aload_0
    //   278: invokevirtual 284	cooperation/qzone/WNSStream:packForUndeal	(ILjava/lang/String;[BZLcom/qq/taf/jce/JceStruct;)[B
    //   281: invokestatic 286	com/tencent/mobileqq/utils/WupUtil:a	([B)[B
    //   284: areturn
    //   285: dconst_1
    //   286: aload 11
    //   288: getfield 291	cooperation/qzone/LbsDataV2$GpsInfo:lat	I
    //   291: i2d
    //   292: dmul
    //   293: ldc2_w 292
    //   296: ddiv
    //   297: invokestatic 296	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   300: astore 7
    //   302: dconst_1
    //   303: aload 11
    //   305: getfield 299	cooperation/qzone/LbsDataV2$GpsInfo:lon	I
    //   308: i2d
    //   309: dmul
    //   310: ldc2_w 292
    //   313: ddiv
    //   314: invokestatic 296	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   317: astore_0
    //   318: goto -183 -> 135
    //   321: astore 7
    //   323: aload 7
    //   325: invokevirtual 302	java/lang/Error:printStackTrace	()V
    //   328: goto -82 -> 246
    //   331: astore_0
    //   332: aconst_null
    //   333: areturn
    //   334: aconst_null
    //   335: areturn
    //   336: astore_0
    //   337: goto -222 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	340	0	paramJceStruct	JceStruct
    //   0	340	1	paramString	String
    //   0	340	2	paramLong	long
    //   0	340	4	paramInt1	int
    //   0	340	5	paramInt2	int
    //   0	340	6	paramInt3	int
    //   7	294	7	localObject1	Object
    //   321	3	7	localError	Error
    //   87	160	8	localObject2	Object
    //   55	220	9	arrayOfByte	byte[]
    //   96	103	10	localStringBuilder	java.lang.StringBuilder
    //   118	186	11	localGpsInfo	cooperation.qzone.LbsDataV2.GpsInfo
    // Exception table:
    //   from	to	target	type
    //   236	243	321	java/lang/Error
    //   0	28	331	java/lang/Throwable
    //   36	50	331	java/lang/Throwable
    //   50	98	331	java/lang/Throwable
    //   98	115	331	java/lang/Throwable
    //   115	120	331	java/lang/Throwable
    //   132	135	331	java/lang/Throwable
    //   135	172	331	java/lang/Throwable
    //   175	210	331	java/lang/Throwable
    //   210	229	331	java/lang/Throwable
    //   236	243	331	java/lang/Throwable
    //   246	285	331	java/lang/Throwable
    //   285	318	331	java/lang/Throwable
    //   323	328	331	java/lang/Throwable
    //   98	115	336	java/lang/Exception
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
            QLog.d(b, 2, "processConfig pack get conf_info_rsp_len is null ");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneFeedCountPackeger
 * JD-Core Version:    0.7.0.1
 */