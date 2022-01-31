package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;

public class GroupPttDownHandler
  extends BaseHandler
{
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.GroupPttDownReq)paramReqCommon;
    cmd0x388.GetPttUrlReq localGetPttUrlReq = new cmd0x388.GetPttUrlReq();
    localGetPttUrlReq.setHasFlag(true);
    localGetPttUrlReq.uint64_file_id.set(paramInt);
    localGetPttUrlReq.uint64_dst_uin.set(Long.valueOf(paramReqCommon.c).longValue());
    localGetPttUrlReq.uint64_group_code.set(Long.parseLong(paramReqCommon.d));
    localGetPttUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.jdField_a_of_type_ArrayOfByte));
    if (paramReqCommon.jdField_a_of_type_Long != 0L) {
      localGetPttUrlReq.uint64_fileid.set(paramReqCommon.jdField_a_of_type_Long);
    }
    localGetPttUrlReq.uint32_req_platform_type.set(9);
    localGetPttUrlReq.uint32_req_term.set(5);
    localGetPttUrlReq.uint32_inner_ip.set(0);
    Object localObject = localGetPttUrlReq.uint32_bu_type;
    if (paramReqCommon.f == 1) {
      paramInt = 3;
    }
    for (;;)
    {
      ((PBUInt32Field)localObject).set(paramInt);
      localGetPttUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.a()));
      localGetPttUrlReq.uint32_codec.set(paramReqCommon.jdField_a_of_type_Int);
      if (paramReqCommon.jdField_a_of_type_JavaLangString != null) {}
      try
      {
        localObject = paramReqCommon.jdField_a_of_type_JavaLangString.getBytes("utf-8");
        localGetPttUrlReq.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
        label207:
        localGetPttUrlReq.uint32_is_auto.set(paramReqCommon.b);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.GroupPttDownHandler", 2, "constructReqBody GroupPttDownReq = " + paramReqCommon.toString());
        }
        paramReqBody.rpt_msg_getptt_url_req.add(localGetPttUrlReq);
        return;
        paramInt = 4;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label207;
      }
    }
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 185	com/tencent/mobileqq/transfile/ProtoReqManager$ProtoResp:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   4: astore 8
    //   6: aload_1
    //   7: getfield 185	com/tencent/mobileqq/transfile/ProtoReqManager$ProtoResp:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   10: invokevirtual 191	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   13: astore 9
    //   15: aload_2
    //   16: getfield 196	com/tencent/mobileqq/transfile/ProtoReqManager$ProtoReq:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   19: checkcast 198	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq
    //   22: astore 5
    //   24: aload 5
    //   26: getfield 201	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp	Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp;
    //   29: astore 6
    //   31: aload_1
    //   32: getfield 204	com/tencent/mobileqq/transfile/ProtoReqManager$ProtoResp:jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo	Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;
    //   35: astore 7
    //   37: aload 8
    //   39: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   42: sipush 1000
    //   45: if_icmpeq +114 -> 159
    //   48: aload 8
    //   50: invokevirtual 208	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   53: istore_3
    //   54: iload_3
    //   55: sipush 1002
    //   58: if_icmpeq +10 -> 68
    //   61: iload_3
    //   62: sipush 1013
    //   65: if_icmpne +51 -> 116
    //   68: aload 8
    //   70: invokestatic 213	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/String;
    //   73: astore 4
    //   75: aload 8
    //   77: invokevirtual 216	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   80: astore_2
    //   81: aload_2
    //   82: astore_1
    //   83: aload_2
    //   84: ifnonnull +6 -> 90
    //   87: ldc 218
    //   89: astore_1
    //   90: aload_0
    //   91: iconst_m1
    //   92: sipush 9311
    //   95: aload 4
    //   97: aload_1
    //   98: aload 7
    //   100: aload 6
    //   102: getfield 223	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   105: invokevirtual 226	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Ljava/util/List;)V
    //   108: aload 5
    //   110: aload 6
    //   112: invokestatic 231	com/tencent/mobileqq/transfile/protohandler/RichProtoProc:a	(Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp;)V
    //   115: return
    //   116: aload 8
    //   118: invokestatic 213	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/String;
    //   121: astore 4
    //   123: aload 8
    //   125: invokevirtual 216	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: aload_2
    //   132: ifnonnull +6 -> 138
    //   135: ldc 218
    //   137: astore_1
    //   138: aload_0
    //   139: iconst_m1
    //   140: sipush 9044
    //   143: aload 4
    //   145: aload_1
    //   146: aload 7
    //   148: aload 6
    //   150: getfield 223	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   153: invokevirtual 226	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Ljava/util/List;)V
    //   156: goto -48 -> 108
    //   159: new 233	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   162: dup
    //   163: invokespecial 234	tencent/im/cs/cmd0x388/cmd0x388$RspBody:<init>	()V
    //   166: aload 9
    //   168: invokevirtual 238	tencent/im/cs/cmd0x388/cmd0x388$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   171: checkcast 233	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   174: getfield 241	tencent/im/cs/cmd0x388/cmd0x388$RspBody:rpt_msg_getptt_url_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   177: invokevirtual 245	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   180: invokeinterface 251 1 0
    //   185: astore 10
    //   187: aload 10
    //   189: invokeinterface 256 1 0
    //   194: ifeq -86 -> 108
    //   197: aload 10
    //   199: invokeinterface 260 1 0
    //   204: checkcast 262	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp
    //   207: astore_1
    //   208: aload 6
    //   210: getfield 223	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   213: aload_1
    //   214: getfield 263	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:uint64_file_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   217: invokevirtual 265	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   220: l2i
    //   221: invokeinterface 268 2 0
    //   226: checkcast 270	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp
    //   229: astore 4
    //   231: aload 4
    //   233: ifnull +31 -> 264
    //   236: aload 8
    //   238: ifnull +26 -> 264
    //   241: aload 4
    //   243: aload 8
    //   245: ldc_w 272
    //   248: iconst_0
    //   249: invokestatic 277	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   252: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   255: checkcast 274	java/lang/Boolean
    //   258: invokevirtual 284	java/lang/Boolean:booleanValue	()Z
    //   261: putfield 288	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:e	Z
    //   264: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq +34 -> 301
    //   270: ldc_w 290
    //   273: iconst_2
    //   274: new 151	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 292
    //   284: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 4
    //   289: getfield 288	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:e	Z
    //   292: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   295: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 297	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload_1
    //   302: getfield 300	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   305: invokevirtual 302	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   308: istore_3
    //   309: iload_3
    //   310: ifne +379 -> 689
    //   313: iconst_0
    //   314: istore_3
    //   315: aload_1
    //   316: getfield 306	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_ip	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   319: invokevirtual 311	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   322: ifle +464 -> 786
    //   325: aload_1
    //   326: getfield 314	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_port	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   329: invokevirtual 311	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   332: ifgt +6 -> 338
    //   335: goto +451 -> 786
    //   338: aload_1
    //   339: getfield 317	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_para	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   342: invokevirtual 320	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   345: invokevirtual 323	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   348: astore 11
    //   350: aload 4
    //   352: aload 11
    //   354: putfield 324	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   357: aload 11
    //   359: ifnull +17 -> 376
    //   362: iload_3
    //   363: ifeq +139 -> 502
    //   366: aload_1
    //   367: getfield 327	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_domain	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   370: invokevirtual 330	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   373: ifne +129 -> 502
    //   376: new 180	java/lang/Exception
    //   379: dup
    //   380: ldc_w 332
    //   383: invokespecial 335	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   386: athrow
    //   387: astore_1
    //   388: aload_0
    //   389: iconst_m1
    //   390: sipush -9527
    //   393: ldc_w 337
    //   396: ldc2_w 338
    //   399: invokestatic 344	com/tencent/mobileqq/transfile/BaseTransProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   402: new 151	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   409: aload_1
    //   410: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   413: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: ldc_w 349
    //   419: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 9
    //   424: invokestatic 355	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   427: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: aload 7
    //   435: aload 4
    //   437: invokevirtual 358	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   440: goto -253 -> 187
    //   443: astore_1
    //   444: aload_0
    //   445: iconst_m1
    //   446: sipush -9527
    //   449: ldc_w 337
    //   452: ldc2_w 338
    //   455: invokestatic 344	com/tencent/mobileqq/transfile/BaseTransProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   458: new 151	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   465: aload_1
    //   466: invokevirtual 347	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   469: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: ldc_w 349
    //   475: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload 9
    //   480: invokestatic 355	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   483: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: aload 7
    //   491: aload 6
    //   493: getfield 223	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   496: invokevirtual 226	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Ljava/util/List;)V
    //   499: goto -391 -> 108
    //   502: iload_3
    //   503: ifne +107 -> 610
    //   506: aload_1
    //   507: getfield 306	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_ip	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   510: invokevirtual 359	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   513: astore 11
    //   515: aload_1
    //   516: getfield 314	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_port	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   519: invokevirtual 359	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   522: astore 12
    //   524: iconst_0
    //   525: istore_3
    //   526: iload_3
    //   527: aload 11
    //   529: invokeinterface 360 1 0
    //   534: if_icmpge +76 -> 610
    //   537: new 362	com/tencent/mobileqq/transfile/ServerAddr
    //   540: dup
    //   541: invokespecial 363	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   544: astore 13
    //   546: aload 13
    //   548: aload 11
    //   550: iload_3
    //   551: invokeinterface 268 2 0
    //   556: checkcast 365	java/lang/Integer
    //   559: invokevirtual 368	java/lang/Integer:intValue	()I
    //   562: i2l
    //   563: ldc2_w 369
    //   566: land
    //   567: invokestatic 375	com/tencent/mobileqq/utils/httputils/PkgTools:a	(J)Ljava/lang/String;
    //   570: putfield 376	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   573: aload 13
    //   575: aload 12
    //   577: iload_3
    //   578: invokeinterface 268 2 0
    //   583: checkcast 365	java/lang/Integer
    //   586: invokevirtual 368	java/lang/Integer:intValue	()I
    //   589: putfield 377	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_Int	I
    //   592: aload 4
    //   594: getfield 380	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   597: iload_3
    //   598: aload 13
    //   600: invokevirtual 385	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   603: iload_3
    //   604: iconst_1
    //   605: iadd
    //   606: istore_3
    //   607: goto -81 -> 526
    //   610: aload_1
    //   611: getfield 327	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_domain	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   614: invokevirtual 330	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   617: ifeq +55 -> 672
    //   620: new 362	com/tencent/mobileqq/transfile/ServerAddr
    //   623: dup
    //   624: invokespecial 363	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   627: astore 11
    //   629: aload 11
    //   631: aload_1
    //   632: getfield 327	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_domain	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   635: invokevirtual 320	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   638: invokevirtual 323	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   641: putfield 376	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   644: aload 11
    //   646: bipush 80
    //   648: putfield 377	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_Int	I
    //   651: aload 4
    //   653: getfield 380	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   656: aload 11
    //   658: invokevirtual 388	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   661: pop
    //   662: aload 4
    //   664: aload 11
    //   666: getfield 376	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   669: putfield 390	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:b	Ljava/lang/String;
    //   672: aload_0
    //   673: iconst_0
    //   674: iconst_0
    //   675: ldc 218
    //   677: ldc 218
    //   679: aload 7
    //   681: aload 4
    //   683: invokevirtual 358	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   686: goto -499 -> 187
    //   689: aload_1
    //   690: getfield 393	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:uint32_allow_retry	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   693: invokevirtual 302	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   696: iconst_1
    //   697: if_icmpne +25 -> 722
    //   700: invokestatic 147	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   703: ifeq +13 -> 716
    //   706: ldc_w 395
    //   709: iconst_2
    //   710: ldc_w 397
    //   713: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   716: aload 4
    //   718: iconst_0
    //   719: putfield 399	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:f	Z
    //   722: iload_3
    //   723: invokestatic 404	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:a	(I)Z
    //   726: ifeq +31 -> 757
    //   729: aload_0
    //   730: aload_0
    //   731: getfield 405	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:b	I
    //   734: iconst_1
    //   735: iadd
    //   736: putfield 405	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:b	I
    //   739: aload_0
    //   740: getfield 405	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:b	I
    //   743: iconst_2
    //   744: if_icmpge +13 -> 757
    //   747: aload 5
    //   749: getfield 408	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager	Lcom/tencent/mobileqq/transfile/ProtoReqManager;
    //   752: aload_2
    //   753: invokevirtual 413	com/tencent/mobileqq/transfile/ProtoReqManager:a	(Lcom/tencent/mobileqq/transfile/ProtoReqManager$ProtoReq;)V
    //   756: return
    //   757: aload_0
    //   758: iconst_m1
    //   759: sipush -9527
    //   762: iload_3
    //   763: i2l
    //   764: invokestatic 414	com/tencent/mobileqq/transfile/BaseTransProcessor:a	(J)Ljava/lang/String;
    //   767: ldc 218
    //   769: aload 7
    //   771: aload 4
    //   773: invokevirtual 358	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/MessageObserver$StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   776: goto -589 -> 187
    //   779: astore_1
    //   780: aconst_null
    //   781: astore 4
    //   783: goto -395 -> 388
    //   786: iconst_1
    //   787: istore_3
    //   788: goto -450 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	791	0	this	GroupPttDownHandler
    //   0	791	1	paramProtoResp	com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp
    //   0	791	2	paramProtoReq	ProtoReqManager.ProtoReq
    //   53	735	3	i	int
    //   73	709	4	localObject1	Object
    //   22	726	5	localRichProtoReq	RichProto.RichProtoReq
    //   29	463	6	localRichProtoResp	RichProto.RichProtoResp
    //   35	735	7	localStatictisInfo	com.tencent.mobileqq.app.MessageObserver.StatictisInfo
    //   4	240	8	localFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   13	466	9	arrayOfByte	byte[]
    //   185	13	10	localIterator	java.util.Iterator
    //   348	317	11	localObject2	Object
    //   522	54	12	localList	List
    //   544	55	13	localServerAddr	com.tencent.mobileqq.transfile.ServerAddr
    // Exception table:
    //   from	to	target	type
    //   241	264	387	java/lang/Exception
    //   264	301	387	java/lang/Exception
    //   301	309	387	java/lang/Exception
    //   315	325	387	java/lang/Exception
    //   325	335	387	java/lang/Exception
    //   338	357	387	java/lang/Exception
    //   366	376	387	java/lang/Exception
    //   376	387	387	java/lang/Exception
    //   506	524	387	java/lang/Exception
    //   526	603	387	java/lang/Exception
    //   610	672	387	java/lang/Exception
    //   672	686	387	java/lang/Exception
    //   689	716	387	java/lang/Exception
    //   716	722	387	java/lang/Exception
    //   722	756	387	java/lang/Exception
    //   757	776	387	java/lang/Exception
    //   159	187	443	java/lang/Exception
    //   187	208	443	java/lang/Exception
    //   388	440	443	java/lang/Exception
    //   208	231	779	java/lang/Exception
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "PttStore.GroupPttDown";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
  
  byte[] a(List paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(4);
    int i = 0;
    while (i < paramList.size())
    {
      a(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), localReqBody);
      i += 1;
    }
    switch (NetworkCenter.a().a())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = NetworkCenter.a().a();
      int j = i;
      if (paramList != null)
      {
        j = i;
        if (paramList.contains("wap")) {
          j = 5;
        }
      }
      localReqBody.uint32_net_type.set(j);
      return localReqBody.toByteArray();
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  void b(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    localRichProtoResp.jdField_a_of_type_JavaUtilList.clear();
    int i = 0;
    while (i < paramRichProtoReq.jdField_a_of_type_JavaUtilList.size())
    {
      RichProto.RichProtoResp.GroupPttDownResp localGroupPttDownResp = new RichProto.RichProtoResp.GroupPttDownResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localGroupPttDownResp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GroupPttDownHandler
 * JD-Core Version:    0.7.0.1
 */