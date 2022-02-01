package com.tencent.mqpsdk.secsrv;

import com.tencent.ims.signature.SignatureResult;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mqpsdk.INetTransportProvider;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportCodec;
import com.tencent.mqpsdk.INetTransportProvider.INetTransportEventListener;
import com.tencent.mqpsdk.MQPSecServiceManager;
import org.json.JSONObject;

public class MQPSigCheckService
  implements INetTransportProvider.INetTransportEventListener
{
  private MQPSecServiceManager jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager = null;
  private MQPSigCheckService.ISigCheckResultListener jdField_a_of_type_ComTencentMqpsdkSecsrvMQPSigCheckService$ISigCheckResultListener = null;
  
  public MQPSigCheckService(MQPSecServiceManager paramMQPSecServiceManager)
  {
    INetTransportProvider localINetTransportProvider = paramMQPSecServiceManager.a;
    if (localINetTransportProvider != null) {
      localINetTransportProvider.setNetTransportEventListener("sig_check", this);
    }
    this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager = paramMQPSecServiceManager;
  }
  
  public void a(MQPSigCheckService.ISigCheckResultListener paramISigCheckResultListener)
  {
    this.jdField_a_of_type_ComTencentMqpsdkSecsrvMQPSigCheckService$ISigCheckResultListener = paramISigCheckResultListener;
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    if (this.jdField_a_of_type_ComTencentMqpsdkSecsrvMQPSigCheckService$ISigCheckResultListener == null) {
      return;
    }
    paramObject1 = this.jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager;
    if (paramObject1 == null) {
      return;
    }
    paramObject1 = paramObject1.a;
    if (paramObject1 == null) {
      return;
    }
    paramObject1 = paramObject1.getCodec("sig_check");
    if (paramObject1 == null) {
      return;
    }
    paramObject1 = (byte[])paramObject1.decode(paramObject2);
    if (paramObject1 == null) {
      return;
    }
    Object localObject = new signature.SignatureResult();
    try
    {
      ((signature.SignatureResult)localObject).mergeFrom(paramObject1);
    }
    catch (Exception paramObject1)
    {
      paramObject1.printStackTrace();
    }
    int i = -1;
    int j = 604800;
    if (((signature.SignatureResult)localObject).u32_check_result.has()) {
      i = ((signature.SignatureResult)localObject).u32_check_result.get();
    }
    boolean bool = ((signature.SignatureResult)localObject).str_title.has();
    String str3 = "";
    if (bool) {
      paramObject1 = ((signature.SignatureResult)localObject).str_title.get();
    } else {
      paramObject1 = "";
    }
    if (((signature.SignatureResult)localObject).str_content.has()) {
      paramObject2 = ((signature.SignatureResult)localObject).str_content.get();
    } else {
      paramObject2 = "";
    }
    String str1;
    if (((signature.SignatureResult)localObject).str_left_button.has()) {
      str1 = ((signature.SignatureResult)localObject).str_left_button.get();
    } else {
      str1 = "";
    }
    String str2;
    if (((signature.SignatureResult)localObject).str_right_button.has()) {
      str2 = ((signature.SignatureResult)localObject).str_right_button.get();
    } else {
      str2 = "";
    }
    if (((signature.SignatureResult)localObject).str_url.has()) {
      str3 = ((signature.SignatureResult)localObject).str_url.get();
    }
    if (((signature.SignatureResult)localObject).u32_cache_time.has()) {
      j = ((signature.SignatureResult)localObject).u32_cache_time.get();
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("dialog_title", paramObject1);
      ((JSONObject)localObject).put("dialog_content", paramObject2);
      ((JSONObject)localObject).put("dialog_left_button", str1);
      ((JSONObject)localObject).put("dialog_right_button", str2);
      ((JSONObject)localObject).put("url", str3);
      paramObject1 = new JSONObject();
      paramObject1.put("sig_check_result", i);
      paramObject1.put("dialog_config", localObject);
      paramObject1.put("cache_time", j);
      this.jdField_a_of_type_ComTencentMqpsdkSecsrvMQPSigCheckService$ISigCheckResultListener.a(paramObject1.toString());
      return;
    }
    catch (Exception paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: ldc 82
    //   2: astore 18
    //   4: iconst_0
    //   5: istore 5
    //   7: iconst_0
    //   8: istore 4
    //   10: iconst_0
    //   11: istore_2
    //   12: lconst_0
    //   13: lstore 10
    //   15: lload 10
    //   17: lstore 8
    //   19: new 102	org/json/JSONObject
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 136	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   27: astore 19
    //   29: lload 10
    //   31: lstore 6
    //   33: lload 10
    //   35: lstore 8
    //   37: aload 19
    //   39: ldc 138
    //   41: invokevirtual 141	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   44: ifeq +16 -> 60
    //   47: lload 10
    //   49: lstore 8
    //   51: aload 19
    //   53: ldc 138
    //   55: invokevirtual 145	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   58: lstore 6
    //   60: lload 6
    //   62: lstore 8
    //   64: aload 19
    //   66: ldc 147
    //   68: invokevirtual 141	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   71: ifeq +18 -> 89
    //   74: lload 6
    //   76: lstore 8
    //   78: aload 19
    //   80: ldc 147
    //   82: invokevirtual 151	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   85: istore_3
    //   86: goto +5 -> 91
    //   89: iconst_0
    //   90: istore_3
    //   91: iload 5
    //   93: istore 4
    //   95: aload 19
    //   97: ldc 153
    //   99: invokevirtual 141	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   102: ifeq +15 -> 117
    //   105: iload 5
    //   107: istore 4
    //   109: aload 19
    //   111: ldc 153
    //   113: invokevirtual 151	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   116: istore_2
    //   117: iload_2
    //   118: istore 4
    //   120: aload 19
    //   122: ldc 155
    //   124: invokevirtual 141	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   127: ifeq +18 -> 145
    //   130: iload_2
    //   131: istore 4
    //   133: aload 19
    //   135: ldc 155
    //   137: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   140: astore 14
    //   142: goto +7 -> 149
    //   145: ldc 82
    //   147: astore 14
    //   149: aload 19
    //   151: ldc 161
    //   153: invokevirtual 141	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   156: ifeq +15 -> 171
    //   159: aload 19
    //   161: ldc 161
    //   163: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   166: astore 13
    //   168: goto +7 -> 175
    //   171: ldc 82
    //   173: astore 13
    //   175: aload 19
    //   177: ldc 163
    //   179: invokevirtual 141	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   182: ifeq +14 -> 196
    //   185: aload 19
    //   187: ldc 163
    //   189: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   192: astore_1
    //   193: goto +6 -> 199
    //   196: ldc 82
    //   198: astore_1
    //   199: aload_1
    //   200: astore 17
    //   202: aload 13
    //   204: astore 16
    //   206: aload 14
    //   208: astore 12
    //   210: aload 18
    //   212: astore 15
    //   214: iload_2
    //   215: istore 5
    //   217: lload 6
    //   219: lstore 8
    //   221: iload_3
    //   222: istore 4
    //   224: aload 19
    //   226: ldc 165
    //   228: invokevirtual 141	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   231: ifeq +129 -> 360
    //   234: aload 19
    //   236: ldc 165
    //   238: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   241: astore 15
    //   243: aload_1
    //   244: astore 17
    //   246: aload 13
    //   248: astore 16
    //   250: aload 14
    //   252: astore 12
    //   254: iload_2
    //   255: istore 5
    //   257: lload 6
    //   259: lstore 8
    //   261: iload_3
    //   262: istore 4
    //   264: goto +96 -> 360
    //   267: astore 12
    //   269: goto +61 -> 330
    //   272: astore 12
    //   274: ldc 82
    //   276: astore_1
    //   277: goto +53 -> 330
    //   280: astore 12
    //   282: ldc 82
    //   284: astore_1
    //   285: aload_1
    //   286: astore 13
    //   288: goto +42 -> 330
    //   291: astore 12
    //   293: ldc 82
    //   295: astore_1
    //   296: aload_1
    //   297: astore 13
    //   299: aload 13
    //   301: astore 14
    //   303: iload 4
    //   305: istore_2
    //   306: goto +24 -> 330
    //   309: astore 12
    //   311: ldc 82
    //   313: astore_1
    //   314: aload_1
    //   315: astore 13
    //   317: aload 13
    //   319: astore 14
    //   321: iconst_0
    //   322: istore_3
    //   323: lload 8
    //   325: lstore 6
    //   327: iload 4
    //   329: istore_2
    //   330: aload 12
    //   332: invokevirtual 58	java/lang/Exception:printStackTrace	()V
    //   335: iload_3
    //   336: istore 4
    //   338: lload 6
    //   340: lstore 8
    //   342: iload_2
    //   343: istore 5
    //   345: aload 18
    //   347: astore 15
    //   349: aload 14
    //   351: astore 12
    //   353: aload 13
    //   355: astore 16
    //   357: aload_1
    //   358: astore 17
    //   360: new 167	com/tencent/ims/signature$SignatureReport
    //   363: dup
    //   364: invokespecial 168	com/tencent/ims/signature$SignatureReport:<init>	()V
    //   367: astore_1
    //   368: aload_1
    //   369: getfield 172	com/tencent/ims/signature$SignatureReport:u64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   372: lload 8
    //   374: invokevirtual 178	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   377: aload_1
    //   378: getfield 181	com/tencent/ims/signature$SignatureReport:u32_client_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   381: iload 4
    //   383: invokevirtual 184	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   386: aload_1
    //   387: getfield 187	com/tencent/ims/signature$SignatureReport:u32_is_repack	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   390: iload 5
    //   392: invokevirtual 184	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   395: aload_1
    //   396: getfield 190	com/tencent/ims/signature$SignatureReport:str_packname	Lcom/tencent/mobileqq/pb/PBStringField;
    //   399: aload 12
    //   401: invokevirtual 192	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   404: aload_1
    //   405: getfield 195	com/tencent/ims/signature$SignatureReport:str_version	Lcom/tencent/mobileqq/pb/PBStringField;
    //   408: aload 16
    //   410: invokevirtual 192	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   413: aload_1
    //   414: getfield 198	com/tencent/ims/signature$SignatureReport:str_md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   417: aload 17
    //   419: invokevirtual 192	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   422: aload_1
    //   423: getfield 201	com/tencent/ims/signature$SignatureReport:str_signature	Lcom/tencent/mobileqq/pb/PBStringField;
    //   426: aload 15
    //   428: invokevirtual 192	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   431: aload_0
    //   432: getfield 16	com/tencent/mqpsdk/secsrv/MQPSigCheckService:jdField_a_of_type_ComTencentMqpsdkMQPSecServiceManager	Lcom/tencent/mqpsdk/MQPSecServiceManager;
    //   435: astore 12
    //   437: aload 12
    //   439: ifnonnull +4 -> 443
    //   442: return
    //   443: aload 12
    //   445: getfield 23	com/tencent/mqpsdk/MQPSecServiceManager:a	Lcom/tencent/mqpsdk/INetTransportProvider;
    //   448: astore 13
    //   450: aload 13
    //   452: ifnonnull +4 -> 456
    //   455: return
    //   456: aload_1
    //   457: invokevirtual 205	com/tencent/ims/signature$SignatureReport:toByteArray	()[B
    //   460: astore 12
    //   462: aload 13
    //   464: ldc 25
    //   466: invokeinterface 40 2 0
    //   471: astore 14
    //   473: aload 12
    //   475: astore_1
    //   476: aload 14
    //   478: ifnull +13 -> 491
    //   481: aload 14
    //   483: aload 12
    //   485: invokeinterface 208 2 0
    //   490: astore_1
    //   491: aload 13
    //   493: aload_1
    //   494: invokeinterface 212 2 0
    //   499: pop
    //   500: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	this	MQPSigCheckService
    //   0	501	1	paramString	String
    //   11	332	2	i	int
    //   85	251	3	j	int
    //   8	374	4	k	int
    //   5	386	5	m	int
    //   31	308	6	l1	long
    //   17	356	8	l2	long
    //   13	35	10	l3	long
    //   208	45	12	localObject1	Object
    //   267	1	12	localException1	Exception
    //   272	1	12	localException2	Exception
    //   280	1	12	localException3	Exception
    //   291	1	12	localException4	Exception
    //   309	22	12	localException5	Exception
    //   351	133	12	localObject2	Object
    //   166	326	13	localObject3	Object
    //   140	342	14	localObject4	Object
    //   212	215	15	str1	String
    //   204	205	16	localObject5	Object
    //   200	218	17	str2	String
    //   2	344	18	str3	String
    //   27	208	19	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   224	243	267	java/lang/Exception
    //   175	193	272	java/lang/Exception
    //   149	168	280	java/lang/Exception
    //   95	105	291	java/lang/Exception
    //   109	117	291	java/lang/Exception
    //   120	130	291	java/lang/Exception
    //   133	142	291	java/lang/Exception
    //   19	29	309	java/lang/Exception
    //   37	47	309	java/lang/Exception
    //   51	60	309	java/lang/Exception
    //   64	74	309	java/lang/Exception
    //   78	86	309	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqpsdk.secsrv.MQPSigCheckService
 * JD-Core Version:    0.7.0.1
 */