import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SCreateSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoReqBody;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Random;
import mqq.app.MobileQQ;

public abstract class liv
  extends alko
{
  static long jdField_a_of_type_Long;
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private lit jdField_a_of_type_Lit = lit.a();
  private lix jdField_a_of_type_Lix = lix.a();
  private boolean jdField_a_of_type_Boolean;
  
  public liv(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  abstract int a();
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_Lix.jdField_a_of_type_Long);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  abstract void a(long paramLong1, long paramLong2);
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg(paramString2);
    AudioTransClientTransInfo.InfoHead localInfoHead = new AudioTransClientTransInfo.InfoHead();
    Object localObject2 = localInfoHead.str_session_id;
    if (TextUtils.isEmpty(paramString3)) {}
    for (Object localObject1 = "0";; localObject1 = paramString3)
    {
      ((PBStringField)localObject2).set((String)localObject1);
      localInfoHead.str_uin.set(this.mApp.getCurrentAccountUin());
      localInfoHead.uint32_seq.set((int)paramLong);
      localInfoHead.enum_body_type.set(1);
      localObject1 = new AudioTransClientTransInfo.InfoReqBody();
      localObject2 = new AudioTransClientTransInfo.InfoC2SCreateSessionReq();
      String str = b();
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).enum_business_type.set(1);
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).rpt_member_list.set(Arrays.asList(new String[] { localInfoHead.str_uin.get(), str }));
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).enum_business_direction.set(4);
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).enum_term.set(4);
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).uint32_client_ver.set(b());
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).enum_net_type.set(a());
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).bool_translate.set(c());
      ((AudioTransClientTransInfo.InfoReqBody)localObject1).msg_create_session_req.set((MessageMicro)localObject2);
      localObject2 = this.jdField_a_of_type_Lit;
      localToServiceMsg.putWupBuffer(lit.a(localInfoHead.toByteArray(), ((AudioTransClientTransInfo.InfoReqBody)localObject1).toByteArray()));
      boolean bool = bdee.g(this.mApp.getApplication().getApplicationContext());
      if (bool) {
        sendPbReq(localToServiceMsg);
      }
      long l1 = System.currentTimeMillis();
      long l2 = jdField_a_of_type_Long;
      jdField_a_of_type_Long = l1;
      QLog.w("AudioTransClientInfoHandler", 1, "sendCmdToService, cmd[" + paramString2 + "], seq[" + paramLong + "], sessionID[" + paramString3 + "], isNetworkAvailable[" + bool + "], from[" + paramString1 + "], sendInterval[" + (l1 - l2) + "]");
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  abstract int b();
  
  abstract String b();
  
  abstract boolean b();
  
  abstract boolean c();
  
  protected Class<? extends alkr> observerClass()
  {
    return null;
  }
  
  /* Error */
  public void onReceive(ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 263	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +641 -> 645
    //   7: aload_0
    //   8: getfield 28	liv:jdField_a_of_type_Lit	Llit;
    //   11: astore_1
    //   12: aload_2
    //   13: invokevirtual 266	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   16: invokestatic 269	lit:a	([B)Lliu;
    //   19: astore_2
    //   20: aload_2
    //   21: getfield 274	liu:a	[B
    //   24: astore_1
    //   25: aload_2
    //   26: getfield 276	liu:b	[B
    //   29: astore_2
    //   30: new 56	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead
    //   33: dup
    //   34: invokespecial 57	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:<init>	()V
    //   37: astore_3
    //   38: aload_3
    //   39: aload_1
    //   40: invokevirtual 280	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   43: checkcast 56	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead
    //   46: astore_1
    //   47: aload_1
    //   48: getfield 91	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   51: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   54: istore 4
    //   56: aload_1
    //   57: getfield 285	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:uint32_error_no	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   60: invokevirtual 288	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   63: ifeq +572 -> 635
    //   66: new 290	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody
    //   69: dup
    //   70: invokespecial 291	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:<init>	()V
    //   73: aload_2
    //   74: invokevirtual 292	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   77: checkcast 290	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody
    //   80: astore_2
    //   81: aload_1
    //   82: getfield 285	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:uint32_error_no	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   85: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   88: ifne +462 -> 550
    //   91: aload_2
    //   92: getfield 296	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:msg_create_session_rsp	Lcom/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp;
    //   95: invokevirtual 301	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 298	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 35	liv:jdField_a_of_type_Lix	Llix;
    //   106: aload_2
    //   107: getfield 304	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:enum_channel_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   110: invokevirtual 305	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   113: putfield 308	lix:jdField_a_of_type_Int	I
    //   116: aload_0
    //   117: getfield 35	liv:jdField_a_of_type_Lix	Llix;
    //   120: aload_2
    //   121: getfield 311	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:enum_translator_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   124: invokevirtual 305	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   127: putfield 313	lix:b	I
    //   130: aload_0
    //   131: getfield 35	liv:jdField_a_of_type_Lix	Llix;
    //   134: aload_1
    //   135: getfield 61	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:str_session_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   138: invokevirtual 122	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   141: invokestatic 318	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   144: invokevirtual 321	java/lang/Long:longValue	()J
    //   147: putfield 40	lix:jdField_a_of_type_Long	J
    //   150: aload_2
    //   151: getfield 325	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:rpt_msg_interface_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: invokevirtual 330	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   157: astore_1
    //   158: aload_0
    //   159: getfield 35	liv:jdField_a_of_type_Lix	Llix;
    //   162: new 332	java/util/ArrayList
    //   165: dup
    //   166: invokespecial 333	java/util/ArrayList:<init>	()V
    //   169: putfield 336	lix:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   172: aload_0
    //   173: invokevirtual 338	liv:b	()Z
    //   176: istore 5
    //   178: ldc 212
    //   180: iconst_1
    //   181: new 214	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 340
    //   191: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload 4
    //   196: invokevirtual 343	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: ldc_w 345
    //   202: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: getfield 35	liv:jdField_a_of_type_Lix	Llix;
    //   209: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: ldc_w 350
    //   215: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload 5
    //   220: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   223: ldc_w 352
    //   226: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: getfield 48	liv:jdField_a_of_type_Boolean	Z
    //   233: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   236: ldc 239
    //   238: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 248	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_1
    //   248: invokeinterface 358 1 0
    //   253: astore_1
    //   254: aload_1
    //   255: invokeinterface 363 1 0
    //   260: ifeq +233 -> 493
    //   263: aload_1
    //   264: invokeinterface 367 1 0
    //   269: checkcast 369	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr
    //   272: astore_2
    //   273: new 371	com/tencent/av/business/handler/NetAddr
    //   276: dup
    //   277: invokespecial 372	com/tencent/av/business/handler/NetAddr:<init>	()V
    //   280: astore_3
    //   281: aload_3
    //   282: aload_2
    //   283: getfield 376	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   286: invokevirtual 379	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   289: putfield 381	com/tencent/av/business/handler/NetAddr:fixed32_IP	I
    //   292: aload_3
    //   293: aload_2
    //   294: getfield 384	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:uint32_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   297: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   300: putfield 386	com/tencent/av/business/handler/NetAddr:uint32_port	I
    //   303: aload_3
    //   304: aload_2
    //   305: getfield 389	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:enum_proto_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   308: invokevirtual 305	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   311: putfield 391	com/tencent/av/business/handler/NetAddr:enum_proto_type	I
    //   314: aload_3
    //   315: aload_2
    //   316: getfield 394	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_inner_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   319: invokevirtual 379	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   322: putfield 396	com/tencent/av/business/handler/NetAddr:fixed32_inner_IP	I
    //   325: aload_0
    //   326: getfield 35	liv:jdField_a_of_type_Lix	Llix;
    //   329: getfield 336	lix:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   332: aload_3
    //   333: invokeinterface 400 2 0
    //   338: pop
    //   339: new 214	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   346: ldc_w 402
    //   349: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: astore_3
    //   353: aload_0
    //   354: getfield 28	liv:jdField_a_of_type_Lit	Llit;
    //   357: astore 6
    //   359: aload_3
    //   360: aload_2
    //   361: getfield 376	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   364: invokevirtual 379	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   367: invokestatic 405	lit:a	(I)Ljava/lang/String;
    //   370: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc_w 407
    //   376: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_2
    //   380: getfield 384	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:uint32_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   383: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   386: invokevirtual 343	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: ldc_w 407
    //   392: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_2
    //   396: getfield 389	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:enum_proto_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   399: invokevirtual 305	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   402: invokevirtual 343	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: ldc_w 407
    //   408: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: astore_3
    //   412: aload_0
    //   413: getfield 28	liv:jdField_a_of_type_Lit	Llit;
    //   416: astore 6
    //   418: ldc 212
    //   420: iconst_2
    //   421: aload_3
    //   422: aload_2
    //   423: getfield 394	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_inner_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   426: invokevirtual 379	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   429: invokestatic 405	lit:a	(I)Ljava/lang/String;
    //   432: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 410	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: goto -187 -> 254
    //   444: astore_1
    //   445: aload_1
    //   446: invokevirtual 413	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   449: ldc 212
    //   451: iconst_2
    //   452: new 214	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   459: ldc_w 415
    //   462: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_1
    //   466: invokevirtual 418	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   469: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 421	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: return
    //   479: astore_1
    //   480: ldc 212
    //   482: iconst_1
    //   483: ldc_w 423
    //   486: aload_1
    //   487: invokestatic 426	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   490: goto -340 -> 150
    //   493: aload_0
    //   494: getfield 82	liv:mApp	Lcom/tencent/common/app/AppInterface;
    //   497: iconst_0
    //   498: invokevirtual 430	com/tencent/common/app/AppInterface:getBusinessHandler	(I)Ljava/lang/Object;
    //   501: checkcast 432	liy
    //   504: iload 4
    //   506: i2l
    //   507: iconst_1
    //   508: aload_0
    //   509: getfield 35	liv:jdField_a_of_type_Lix	Llix;
    //   512: getfield 336	lix:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   515: aload_0
    //   516: getfield 35	liv:jdField_a_of_type_Lix	Llix;
    //   519: getfield 40	lix:jdField_a_of_type_Long	J
    //   522: invokevirtual 435	liy:a	(JZLjava/util/List;J)V
    //   525: aload_0
    //   526: iconst_1
    //   527: putfield 48	liv:jdField_a_of_type_Boolean	Z
    //   530: iload 5
    //   532: ifeq -54 -> 478
    //   535: aload_0
    //   536: iload 4
    //   538: i2l
    //   539: aload_0
    //   540: getfield 35	liv:jdField_a_of_type_Lix	Llix;
    //   543: getfield 40	lix:jdField_a_of_type_Long	J
    //   546: invokevirtual 437	liv:a	(JJ)V
    //   549: return
    //   550: aload_2
    //   551: getfield 441	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:msg_failed_rsp	Lcom/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp;
    //   554: invokevirtual 444	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   557: checkcast 443	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp
    //   560: astore_1
    //   561: ldc 212
    //   563: iconst_2
    //   564: ldc_w 446
    //   567: invokestatic 410	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: ldc 212
    //   572: iconst_2
    //   573: new 214	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 448
    //   583: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload_1
    //   587: getfield 451	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp:uint32_errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   590: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   593: invokevirtual 343	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 410	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: ldc 212
    //   604: iconst_2
    //   605: new 214	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   612: ldc_w 453
    //   615: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload_1
    //   619: getfield 456	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp:str_errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   622: invokevirtual 122	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   625: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 410	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   634: return
    //   635: ldc 212
    //   637: iconst_2
    //   638: ldc_w 458
    //   641: invokestatic 421	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: return
    //   645: ldc 212
    //   647: iconst_2
    //   648: new 214	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   655: ldc_w 460
    //   658: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload_2
    //   662: invokevirtual 463	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   665: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 421	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	675	0	this	liv
    //   0	675	1	paramToServiceMsg	ToServiceMsg
    //   0	675	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	675	3	paramObject	Object
    //   54	483	4	i	int
    //   176	355	5	bool	boolean
    //   357	60	6	locallit	lit
    // Exception table:
    //   from	to	target	type
    //   38	130	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	150	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   150	254	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   254	441	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   480	490	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   493	530	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   535	549	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   550	634	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   635	644	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	150	479	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     liv
 * JD-Core Version:    0.7.0.1
 */