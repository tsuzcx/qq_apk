package com.tencent.mobileqq.service;

import android.os.Bundle;
import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

public abstract class PeakJceServiceBase
{
  public static volatile int a;
  public static HashMap<String, UniPacket> a;
  private DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  private ConcurrentHashMap<String, BaseProtocolCoder> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public UniPacket a(ToServiceMsg paramToServiceMsg)
  {
    if ("StreamSvr.UploadStreamMsg".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))
    {
      String str = paramToServiceMsg.extraData.getString("filepath");
      UniPacket localUniPacket = (UniPacket)jdField_a_of_type_JavaUtilHashMap.get(str);
      Object localObject;
      if (localUniPacket == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PeakJceServiceBase", 2, "no saved packet, new one " + str);
        }
        localObject = new PttUniPacket(true);
        jdField_a_of_type_JavaUtilHashMap.clear();
        jdField_a_of_type_JavaUtilHashMap.put(str, localObject);
      }
      for (;;)
      {
        paramToServiceMsg = Short.valueOf(paramToServiceMsg.extraData.getShort("PackSeq"));
        int i = StreamDataManager.b(str);
        if (paramToServiceMsg.shortValue() <= i)
        {
          jdField_a_of_type_JavaUtilHashMap.remove(str);
          if (QLog.isColorLevel()) {
            QLog.d("PeakJceServiceBase", 2, "last stream, remove " + i + ", " + paramToServiceMsg);
          }
        }
        return localObject;
        localObject = localUniPacket;
        if (QLog.isColorLevel())
        {
          QLog.d("PeakJceServiceBase", 2, "got last packet, reuse it " + str);
          localObject = localUniPacket;
        }
      }
    }
    return new UniPacket(true);
  }
  
  public abstract AppInterface a();
  
  public BaseProtocolCoder a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    int i;
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        a();
      }
      i = paramString.indexOf('.');
      if (i <= 1) {
        return null;
      }
    }
    finally {}
    paramString = paramString.substring(0, i);
    return (BaseProtocolCoder)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  protected void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg) {}
  
  protected void a(ToServiceMsg paramToServiceMsg, Class<? extends MSFServlet> paramClass)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PeakJceServiceBase", 2, "handleRequest request is null. ");
      }
      return;
    }
    paramToServiceMsg = new PeakJceServiceBase.1(this, paramToServiceMsg, paramClass);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramToServiceMsg, 10, null, false);
      return;
    }
    paramToServiceMsg.run();
  }
  
  /* Error */
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Exception paramException)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: invokevirtual 204	com/tencent/mobileqq/service/PeakJceServiceBase:a	()Lcom/tencent/common/app/AppInterface;
    //   9: astore 9
    //   11: invokestatic 210	java/lang/System:currentTimeMillis	()J
    //   14: aload_2
    //   15: getfield 55	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   18: ldc 212
    //   20: invokevirtual 216	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   23: lsub
    //   24: l2f
    //   25: ldc 217
    //   27: fdiv
    //   28: fstore 5
    //   30: iload_1
    //   31: ifeq +198 -> 229
    //   34: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +66 -> 103
    //   40: ldc 77
    //   42: iconst_2
    //   43: new 79	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   50: ldc 219
    //   52: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: invokevirtual 222	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   59: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 224
    //   64: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_3
    //   68: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
    //   71: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: ldc 230
    //   76: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: getfield 34	com/tencent/mobileqq/service/PeakJceServiceBase:jdField_a_of_type_JavaTextDecimalFormat	Ljava/text/DecimalFormat;
    //   83: fload 5
    //   85: f2d
    //   86: invokevirtual 234	java/text/DecimalFormat:format	(D)Ljava/lang/String;
    //   89: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 236
    //   94: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aconst_null
    //   104: astore 8
    //   106: aload_0
    //   107: aload_3
    //   108: invokevirtual 222	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   111: invokevirtual 238	com/tencent/mobileqq/service/PeakJceServiceBase:a	(Ljava/lang/String;)Lcom/tencent/common/app/BaseProtocolCoder;
    //   114: astore 10
    //   116: iload_1
    //   117: ifeq +325 -> 442
    //   120: aload 10
    //   122: ifnull +270 -> 392
    //   125: aload 10
    //   127: aload_2
    //   128: aload_3
    //   129: invokevirtual 242	com/tencent/common/app/BaseProtocolCoder:decodeRespMsg	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   132: aload 10
    //   134: aload_2
    //   135: aload_3
    //   136: invokevirtual 246	com/tencent/common/app/BaseProtocolCoder:decode	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/Object;
    //   139: astore 4
    //   141: aload_0
    //   142: aload_3
    //   143: invokevirtual 248	com/tencent/mobileqq/service/PeakJceServiceBase:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   146: aload 10
    //   148: ifnull -144 -> 4
    //   151: invokestatic 253	com/tencent/mobileqq/app/Cmd2HandlerMap:b	()Ljava/util/Map;
    //   154: aload_3
    //   155: invokevirtual 222	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   158: invokeinterface 256 2 0
    //   163: checkcast 258	[Ljava/lang/String;
    //   166: astore 8
    //   168: aload 8
    //   170: ifnull -166 -> 4
    //   173: aload 8
    //   175: arraylength
    //   176: ifle -172 -> 4
    //   179: aload 8
    //   181: arraylength
    //   182: istore 7
    //   184: iconst_0
    //   185: istore 6
    //   187: iload 6
    //   189: iload 7
    //   191: if_icmpge -187 -> 4
    //   194: aload 9
    //   196: aload 8
    //   198: iload 6
    //   200: aaload
    //   201: invokevirtual 264	com/tencent/common/app/AppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   204: astore 10
    //   206: aload 10
    //   208: ifnull +12 -> 220
    //   211: aload 10
    //   213: aload_2
    //   214: aload_3
    //   215: aload 4
    //   217: invokevirtual 270	com/tencent/mobileqq/app/BusinessHandler:onReceive	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)V
    //   220: iload 6
    //   222: iconst_1
    //   223: iadd
    //   224: istore 6
    //   226: goto -39 -> 187
    //   229: aload 4
    //   231: ifnull +88 -> 319
    //   234: new 272	java/io/ByteArrayOutputStream
    //   237: dup
    //   238: invokespecial 273	java/io/ByteArrayOutputStream:<init>	()V
    //   241: astore 8
    //   243: aload 4
    //   245: new 275	java/io/PrintStream
    //   248: dup
    //   249: aload 8
    //   251: invokespecial 278	java/io/PrintStream:<init>	(Ljava/io/OutputStream;)V
    //   254: invokevirtual 282	java/lang/Exception:printStackTrace	(Ljava/io/PrintStream;)V
    //   257: new 47	java/lang/String
    //   260: dup
    //   261: aload 8
    //   263: invokevirtual 286	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   266: invokespecial 289	java/lang/String:<init>	([B)V
    //   269: astore 4
    //   271: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq -171 -> 103
    //   277: ldc 77
    //   279: iconst_2
    //   280: new 79	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 291
    //   290: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_3
    //   294: invokevirtual 222	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   297: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc 136
    //   302: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 4
    //   307: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: goto -213 -> 103
    //   319: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq -219 -> 103
    //   325: ldc 77
    //   327: iconst_2
    //   328: new 79	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   335: ldc 219
    //   337: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_3
    //   341: invokevirtual 222	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   344: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 293
    //   350: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_3
    //   354: invokevirtual 296	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   357: invokevirtual 134	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   360: ldc 230
    //   362: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload_0
    //   366: getfield 34	com/tencent/mobileqq/service/PeakJceServiceBase:jdField_a_of_type_JavaTextDecimalFormat	Ljava/text/DecimalFormat;
    //   369: fload 5
    //   371: f2d
    //   372: invokevirtual 234	java/text/DecimalFormat:format	(D)Ljava/lang/String;
    //   375: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: ldc 236
    //   380: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 299	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   389: goto -286 -> 103
    //   392: aload 8
    //   394: astore 4
    //   396: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq -258 -> 141
    //   402: ldc 77
    //   404: iconst_2
    //   405: ldc_w 301
    //   408: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload 8
    //   413: astore 4
    //   415: goto -274 -> 141
    //   418: astore 4
    //   420: aload 4
    //   422: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   425: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq +14 -> 442
    //   431: ldc 77
    //   433: iconst_2
    //   434: ldc_w 305
    //   437: aload 4
    //   439: invokestatic 308	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: aconst_null
    //   443: astore 4
    //   445: goto -304 -> 141
    //   448: astore 11
    //   450: aload 11
    //   452: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   455: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq -238 -> 220
    //   461: ldc 77
    //   463: iconst_2
    //   464: new 79	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   471: aload 10
    //   473: invokevirtual 312	java/lang/Object:getClass	()Ljava/lang/Class;
    //   476: invokevirtual 317	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   479: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: ldc_w 319
    //   485: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: aload 11
    //   493: invokestatic 321	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   496: goto -276 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	this	PeakJceServiceBase
    //   0	499	1	paramBoolean	boolean
    //   0	499	2	paramToServiceMsg	ToServiceMsg
    //   0	499	3	paramFromServiceMsg	FromServiceMsg
    //   0	499	4	paramException	Exception
    //   28	342	5	f	float
    //   185	40	6	i	int
    //   182	10	7	j	int
    //   104	308	8	localObject1	Object
    //   9	186	9	localAppInterface	AppInterface
    //   114	358	10	localObject2	Object
    //   448	44	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   125	141	418	java/lang/Exception
    //   396	411	418	java/lang/Exception
    //   211	220	448	java/lang/Exception
  }
  
  protected boolean a(BaseProtocolCoder paramBaseProtocolCoder)
  {
    int i = 0;
    String[] arrayOfString = paramBaseProtocolCoder.cmdHeaderPrefix();
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return false;
    }
    while (i < arrayOfString.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(arrayOfString[i], paramBaseProtocolCoder);
      i += 1;
    }
    return true;
  }
  
  protected void b()
  {
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, Class<? extends MSFServlet> paramClass)
  {
    int i = 1;
    int j = 0;
    AppInterface localAppInterface = a();
    Object localObject1 = paramToServiceMsg.getServiceCmd();
    Object localObject2 = a((String)localObject1);
    Object localObject3;
    int k;
    if (localObject2 != null)
    {
      localObject3 = a(paramToServiceMsg);
      ((UniPacket)localObject3).setEncodeName("utf-8");
      k = jdField_a_of_type_Int;
      jdField_a_of_type_Int = k + 1;
      ((UniPacket)localObject3).setRequestId(k);
      if (((BaseProtocolCoder)localObject2).enableBinaryProtocol())
      {
        localObject3 = ((BaseProtocolCoder)localObject2).encodeReqMsg(paramToServiceMsg);
        if (localObject3 == null) {
          break label308;
        }
        paramToServiceMsg.putWupBuffer((byte[])localObject3);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramClass = new NewIntent(localAppInterface.getApplication(), paramClass);
        paramClass.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
        localAppInterface.startServlet(paramClass);
        long l = System.currentTimeMillis();
        paramToServiceMsg.extraData.putLong("sendtimekey", l);
      }
      do
      {
        do
        {
          return;
          if (!((BaseProtocolCoder)localObject2).encodeReqMsg(paramToServiceMsg, (UniPacket)localObject3)) {
            break label308;
          }
          paramToServiceMsg.putWupBuffer(((UniPacket)localObject3).encode());
          break;
        } while (localObject2 == null);
        paramClass = new FromServiceMsg(localAppInterface.getCurrentAccountUin(), (String)localObject1);
        localObject1 = (String[])Cmd2HandlerMap.b().get(localObject1);
      } while ((localObject1 == null) || (localObject1.length <= 0));
      k = localObject1.length;
      i = j;
      while (i < k)
      {
        localObject2 = localAppInterface.getBusinessHandler(localObject1[i]);
        if (localObject2 != null) {}
        try
        {
          ((BusinessHandler)localObject2).onReceive(paramToServiceMsg, paramClass, null);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.w("PeakJceServiceBase", 2, localObject2.getClass().getSimpleName() + " onReceive error,", localException);
            }
          }
        }
      }
      label308:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.PeakJceServiceBase
 * JD-Core Version:    0.7.0.1
 */