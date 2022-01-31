package com.tencent.mobileqq.loginwelcome;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.ReqBody;

public class LoginWelcomeHandler
  extends BusinessHandler
{
  public LoginWelcomeHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return LoginWelcomeManager.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.getServiceCmd().equals("OidbSvc.0x59f")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void b()
  {
    b(a("OidbSvc.0x59f", 1439, 1, new oidb_0x59f.ReqBody().toByteArray()));
  }
  
  /* Error */
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore_1
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 6
    //   14: iload 5
    //   16: istore 4
    //   18: aload_2
    //   19: invokevirtual 54	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   22: ifeq +145 -> 167
    //   25: new 56	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   28: dup
    //   29: invokespecial 57	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   32: astore_1
    //   33: aload_1
    //   34: aload_3
    //   35: checkcast 59	[B
    //   38: checkcast 59	[B
    //   41: invokevirtual 63	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   44: pop
    //   45: aload_1
    //   46: getfield 67	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   49: invokevirtual 72	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   52: ifeq +164 -> 216
    //   55: aload_1
    //   56: getfield 67	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   59: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   62: ifne +154 -> 216
    //   65: new 78	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody
    //   68: dup
    //   69: invokespecial 79	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:<init>	()V
    //   72: astore_3
    //   73: aload_3
    //   74: aload_1
    //   75: getfield 83	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   78: invokevirtual 88	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   81: invokevirtual 91	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   84: invokevirtual 92	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   87: pop
    //   88: aload_3
    //   89: getfield 95	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:uint32_is_first_login	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   92: invokevirtual 72	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   95: ifeq +152 -> 247
    //   98: aload_3
    //   99: getfield 95	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:uint32_is_first_login	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   102: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   105: iconst_1
    //   106: if_icmpne +141 -> 247
    //   109: iconst_2
    //   110: anewarray 97	java/lang/Object
    //   113: astore_1
    //   114: aload_3
    //   115: getfield 101	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:str_reg_mobile	Lcom/tencent/mobileqq/pb/PBStringField;
    //   118: invokevirtual 104	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   121: ifeq +90 -> 211
    //   124: aload_3
    //   125: getfield 101	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:str_reg_mobile	Lcom/tencent/mobileqq/pb/PBStringField;
    //   128: invokevirtual 106	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   131: astore_2
    //   132: aload_1
    //   133: iconst_0
    //   134: aload_2
    //   135: aastore
    //   136: aload 6
    //   138: astore_2
    //   139: aload_3
    //   140: getfield 110	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:msg_contact_bind_info	Ltencent/im/oidb/cmd0x59f/oidb_0x59f$ContactBindInfo;
    //   143: invokevirtual 113	tencent/im/oidb/cmd0x59f/oidb_0x59f$ContactBindInfo:has	()Z
    //   146: ifeq +14 -> 160
    //   149: aload_3
    //   150: getfield 110	tencent/im/oidb/cmd0x59f/oidb_0x59f$RspBody:msg_contact_bind_info	Ltencent/im/oidb/cmd0x59f/oidb_0x59f$ContactBindInfo;
    //   153: invokevirtual 116	tencent/im/oidb/cmd0x59f/oidb_0x59f$ContactBindInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   156: checkcast 112	tencent/im/oidb/cmd0x59f/oidb_0x59f$ContactBindInfo
    //   159: astore_2
    //   160: aload_1
    //   161: iconst_1
    //   162: aload_2
    //   163: aastore
    //   164: iconst_1
    //   165: istore 4
    //   167: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +29 -> 199
    //   173: ldc 123
    //   175: iconst_2
    //   176: new 125	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   183: ldc 128
    //   185: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: iload 4
    //   190: invokevirtual 135	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   193: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_0
    //   200: sipush 558
    //   203: iload 4
    //   205: aload_1
    //   206: iconst_1
    //   207: invokevirtual 145	com/tencent/mobileqq/loginwelcome/LoginWelcomeHandler:a	(IZLjava/lang/Object;Z)V
    //   210: return
    //   211: aconst_null
    //   212: astore_2
    //   213: goto -81 -> 132
    //   216: ldc 123
    //   218: iconst_1
    //   219: new 125	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   226: ldc 147
    //   228: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_1
    //   232: getfield 67	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   235: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   238: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 153	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: iconst_0
    //   248: istore 4
    //   250: aload 8
    //   252: astore_1
    //   253: goto -86 -> 167
    //   256: astore_3
    //   257: aload 7
    //   259: astore_2
    //   260: aload_2
    //   261: astore_1
    //   262: iload 5
    //   264: istore 4
    //   266: invokestatic 121	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq -102 -> 167
    //   272: ldc 123
    //   274: iconst_2
    //   275: ldc 155
    //   277: aload_3
    //   278: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   281: aload_2
    //   282: astore_1
    //   283: iload 5
    //   285: istore 4
    //   287: goto -120 -> 167
    //   290: astore_3
    //   291: aload_1
    //   292: astore_2
    //   293: goto -33 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	LoginWelcomeHandler
    //   0	296	1	paramToServiceMsg	ToServiceMsg
    //   0	296	2	paramFromServiceMsg	FromServiceMsg
    //   0	296	3	paramObject	Object
    //   16	270	4	bool1	boolean
    //   1	283	5	bool2	boolean
    //   12	125	6	localObject1	Object
    //   9	249	7	localObject2	Object
    //   4	247	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	114	256	java/lang/Throwable
    //   216	247	256	java/lang/Throwable
    //   114	132	290	java/lang/Throwable
    //   139	160	290	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeHandler
 * JD-Core Version:    0.7.0.1
 */