package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlRsp;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.RspBody;

public class C2CPicDownHandler
  extends BaseHandler
{
  /* Error */
  void a(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x352.ReqBody paramReqBody)
  {
    // Byte code:
    //   0: bipush 16
    //   2: istore 4
    //   4: aload_2
    //   5: checkcast 17	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq
    //   8: astore 8
    //   10: new 19	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq
    //   13: dup
    //   14: invokespecial 20	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:<init>	()V
    //   17: astore 9
    //   19: aload 9
    //   21: iconst_1
    //   22: invokevirtual 24	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:setHasFlag	(Z)V
    //   25: aload 9
    //   27: getfield 28	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   30: aload 8
    //   32: getfield 32	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:d	Ljava/lang/String;
    //   35: invokestatic 38	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   38: invokevirtual 42	java/lang/Long:longValue	()J
    //   41: invokevirtual 48	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   44: aload 9
    //   46: getfield 52	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_pic_up_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   49: aload 8
    //   51: getfield 56	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_b_of_type_Int	I
    //   54: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   57: aload 8
    //   59: getfield 64	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   62: astore 7
    //   64: aload 7
    //   66: astore_2
    //   67: aload 7
    //   69: ldc 66
    //   71: invokevirtual 72	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: ifeq +10 -> 84
    //   77: aload 7
    //   79: iconst_1
    //   80: invokevirtual 76	java/lang/String:substring	(I)Ljava/lang/String;
    //   83: astore_2
    //   84: aload_2
    //   85: invokestatic 38	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   88: invokevirtual 42	java/lang/Long:longValue	()J
    //   91: lstore 5
    //   93: aload 9
    //   95: getfield 79	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   98: lload 5
    //   100: invokevirtual 48	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   103: aload 8
    //   105: getfield 81	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   108: ldc 83
    //   110: invokevirtual 87	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   113: astore_2
    //   114: aload 9
    //   116: getfield 91	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_file_resid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   119: aload_2
    //   120: invokestatic 97	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   123: invokevirtual 102	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   126: aload 9
    //   128: getfield 106	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   131: aload 8
    //   133: getfield 109	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_a_of_type_Boolean	Z
    //   136: invokevirtual 113	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   139: ldc 115
    //   141: aload 8
    //   143: getfield 117	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   146: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: ifeq +151 -> 300
    //   152: aload 9
    //   154: getfield 124	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: iconst_2
    //   158: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   161: aload 9
    //   163: getfield 127	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_term	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   166: iconst_5
    //   167: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   170: aload 9
    //   172: getfield 106	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   175: aload 8
    //   177: getfield 109	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_a_of_type_Boolean	Z
    //   180: invokevirtual 113	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   183: aload 9
    //   185: getfield 130	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_platform_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   188: bipush 9
    //   190: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   193: aload 9
    //   195: getfield 133	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_bu_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   198: iconst_1
    //   199: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   202: aload 8
    //   204: getfield 135	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_a_of_type_Int	I
    //   207: istore_1
    //   208: iload_1
    //   209: ldc 136
    //   211: if_icmpne +136 -> 347
    //   214: invokestatic 141	com/tencent/mobileqq/statistics/GeneralConfigUtils:a	()Z
    //   217: ifeq +122 -> 339
    //   220: bipush 16
    //   222: istore_1
    //   223: iconst_4
    //   224: istore 4
    //   226: aload 9
    //   228: getfield 144	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   231: iload 4
    //   233: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   236: aload 9
    //   238: getfield 147	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   241: iload_1
    //   242: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   245: aload 9
    //   247: getfield 150	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_build_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   250: invokestatic 155	com/tencent/mobileqq/transfile/RichMediaUtil:a	()Ljava/lang/String;
    //   253: invokestatic 159	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   256: invokevirtual 102	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   259: aload 9
    //   261: getfield 162	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_transfer_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   264: aload 8
    //   266: getfield 164	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_c_of_type_Int	I
    //   269: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   272: aload_3
    //   273: getfield 170	tencent/im/cs/cmd0x352/cmd0x352$ReqBody:rpt_msg_getimg_url_req	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   276: aload 9
    //   278: invokevirtual 176	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   281: return
    //   282: astore_2
    //   283: aload_2
    //   284: invokevirtual 179	java/lang/Exception:printStackTrace	()V
    //   287: goto -184 -> 103
    //   290: astore_2
    //   291: aload_2
    //   292: invokevirtual 180	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   295: aconst_null
    //   296: astore_2
    //   297: goto -183 -> 114
    //   300: ldc 182
    //   302: aload 8
    //   304: getfield 117	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   307: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   310: ifeq +15 -> 325
    //   313: aload 9
    //   315: getfield 124	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   318: iconst_1
    //   319: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   322: goto -161 -> 161
    //   325: aload 9
    //   327: getfield 124	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   330: sipush 255
    //   333: invokevirtual 61	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   336: goto -175 -> 161
    //   339: iconst_1
    //   340: istore_1
    //   341: iconst_4
    //   342: istore 4
    //   344: goto -118 -> 226
    //   347: iload_1
    //   348: iconst_1
    //   349: if_icmpne +13 -> 362
    //   352: bipush 6
    //   354: istore 4
    //   356: bipush 8
    //   358: istore_1
    //   359: goto -133 -> 226
    //   362: iload_1
    //   363: ldc 183
    //   365: if_icmpne +8 -> 373
    //   368: iconst_2
    //   369: istore_1
    //   370: goto -144 -> 226
    //   373: iconst_0
    //   374: istore_1
    //   375: iconst_0
    //   376: istore 4
    //   378: goto -152 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	this	C2CPicDownHandler
    //   0	381	1	paramInt	int
    //   0	381	2	paramReqCommon	RichProto.RichProtoReq.ReqCommon
    //   0	381	3	paramReqBody	cmd0x352.ReqBody
    //   2	375	4	i	int
    //   91	8	5	l	long
    //   62	16	7	str	String
    //   8	295	8	localC2CPicDownReq	RichProto.RichProtoReq.C2CPicDownReq
    //   17	309	9	localGetImgUrlReq	tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlReq
    // Exception table:
    //   from	to	target	type
    //   57	64	282	java/lang/Exception
    //   67	84	282	java/lang/Exception
    //   84	103	282	java/lang/Exception
    //   103	114	290	java/io/UnsupportedEncodingException
  }
  
  public void a(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    FromServiceMsg localFromServiceMsg = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    byte[] arrayOfByte = paramProtoResp.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.jdField_a_of_type_JavaLangObject;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoResp;
    MessageObserver.StatictisInfo localStatictisInfo = paramProtoResp.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
        paramProtoResp = paramProtoReq;
        if (paramProtoReq == null) {
          paramProtoResp = "";
        }
        a(-1, 9311, (String)localObject1, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
    }
    for (;;)
    {
      RichProtoProc.a(localRichProtoReq, localRichProtoResp);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      a(-1, 9044, (String)localObject1, paramProtoResp, localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      continue;
      try
      {
        paramProtoResp = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(arrayOfByte)).rpt_msg_getimg_url_rsp.get();
        if ((paramProtoResp != null) && (paramProtoResp.size() != 0)) {
          break label264;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramProtoResp)
      {
        a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, localRichProtoResp.jdField_a_of_type_JavaUtilList);
      }
      continue;
      label264:
      Iterator localIterator = paramProtoResp.iterator();
      while (localIterator.hasNext())
      {
        cmd0x352.GetImgUrlRsp localGetImgUrlRsp = (cmd0x352.GetImgUrlRsp)localIterator.next();
        try
        {
          localPicDownResp = (RichProto.RichProtoResp.PicDownResp)localRichProtoResp.jdField_a_of_type_JavaUtilList.get(0);
        }
        catch (Exception paramProtoResp)
        {
          for (;;)
          {
            RichProto.RichProtoResp.PicDownResp localPicDownResp;
            RichProto.RichProtoReq.C2CPicDownReq localC2CPicDownReq;
            label421:
            Object localObject2;
            label450:
            localObject1 = null;
            continue;
            paramProtoResp = null;
            continue;
            i = 0;
            continue;
            i = 1;
            continue;
            if (localObject1 == null)
            {
              localObject1 = null;
              if (localObject2 == null)
              {
                localObject2 = null;
                continue;
                if (paramProtoResp != null) {}
              }
            }
          }
        }
        try
        {
          localC2CPicDownReq = (RichProto.RichProtoReq.C2CPicDownReq)localRichProtoReq.jdField_a_of_type_JavaUtilList.get(0);
          if (localPicDownResp == null) {
            continue;
          }
          if (localFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
            localPicDownResp.e = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          }
          i = localGetImgUrlRsp.uint32_result.get();
          if (i != 0) {
            break label838;
          }
          if (localGetImgUrlRsp.rpt_uint32_down_ip.size() <= 0) {
            break label912;
          }
          if (localGetImgUrlRsp.rpt_uint32_down_port.size() > 0) {
            break label907;
          }
        }
        catch (Exception paramProtoResp)
        {
          localObject1 = localPicDownResp;
        }
        if (GeneralConfigUtils.a())
        {
          paramProtoResp = localGetImgUrlRsp.bytes_big_thumb_down_para.get();
          localObject1 = localGetImgUrlRsp.bytes_original_down_para.get();
          localObject2 = localGetImgUrlRsp.bytes_big_down_para.get();
          if (paramProtoResp != null) {
            break label566;
          }
          paramProtoResp = null;
          break label917;
          if (localC2CPicDownReq.jdField_a_of_type_Int != 65537) {
            break label594;
          }
        }
        for (;;)
        {
          if ((i == 0) || (localGetImgUrlRsp.bytes_down_domain.has())) {
            break label936;
          }
          throw new Exception("no ip");
          if (localObject1 == null) {
            break;
          }
          a(-1, -9527, BaseTransProcessor.a("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localStatictisInfo, (RichProto.RichProtoResp.RespCommon)localObject1);
          break;
          paramProtoResp = localGetImgUrlRsp.bytes_thumb_down_para.get();
          break label421;
          label566:
          paramProtoResp = paramProtoResp.toStringUtf8();
          break label917;
          localObject1 = ((ByteStringMicro)localObject1).toStringUtf8();
          break label925;
          localObject2 = ((ByteStringMicro)localObject2).toStringUtf8();
          break label450;
          label594:
          if (localC2CPicDownReq.jdField_a_of_type_Int == 1)
          {
            paramProtoResp = (ProtoReqManager.ProtoResp)localObject2;
          }
          else
          {
            if (localC2CPicDownReq.jdField_a_of_type_Int != 131075) {
              break label902;
            }
            paramProtoResp = (ProtoReqManager.ProtoResp)localObject1;
          }
        }
        localPicDownResp.jdField_a_of_type_JavaLangString = paramProtoResp;
        if (i == 0)
        {
          paramProtoResp = localGetImgUrlRsp.rpt_uint32_down_ip.get();
          localObject1 = localGetImgUrlRsp.rpt_uint32_down_port.get();
          i = 0;
          while (i < paramProtoResp.size())
          {
            localObject2 = new ServerAddr();
            ((ServerAddr)localObject2).jdField_a_of_type_JavaLangString = PkgTools.a(((Integer)paramProtoResp.get(i)).intValue() & 0xFFFFFFFF);
            ((ServerAddr)localObject2).jdField_a_of_type_Int = ((Integer)((List)localObject1).get(i)).intValue();
            localPicDownResp.jdField_a_of_type_JavaUtilArrayList.add(i, localObject2);
            i += 1;
          }
        }
        if (localGetImgUrlRsp.bytes_down_domain.has())
        {
          paramProtoResp = new ServerAddr();
          paramProtoResp.jdField_a_of_type_JavaLangString = localGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
          paramProtoResp.jdField_a_of_type_Int = 80;
          localPicDownResp.jdField_a_of_type_JavaUtilArrayList.add(paramProtoResp);
          localPicDownResp.jdField_b_of_type_JavaLangString = paramProtoResp.jdField_a_of_type_JavaLangString;
        }
        if (localGetImgUrlRsp.uint32_https_url_flag.has()) {
          localPicDownResp.jdField_a_of_type_Int = localGetImgUrlRsp.uint32_https_url_flag.get();
        }
        a(0, 0, "", "", localStatictisInfo, localPicDownResp);
        continue;
        label838:
        if (C2CPicUpHandler.a(i))
        {
          this.jdField_b_of_type_Int += 1;
          if (this.jdField_b_of_type_Int < 2)
          {
            localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramProtoReq);
            return;
          }
        }
        a(-1, -9527, BaseTransProcessor.a(i), "", localStatictisInfo, localPicDownResp);
      }
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.jdField_a_of_type_JavaUtilList != null) && (paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.jdField_a_of_type_JavaLangString = "LongConn.OffPicDown";
      localProtoReq.jdField_a_of_type_ArrayOfByte = a(paramRichProtoReq.jdField_a_of_type_JavaUtilList);
      localProtoReq.jdField_a_of_type_JavaLangObject = paramRichProtoReq;
      localProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$IProtoRespBack = this;
      a(paramRichProtoReq, localProtoReq);
    }
  }
  
  byte[] a(List paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
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
      RichProto.RichProtoResp.PicDownResp localPicDownResp = new RichProto.RichProtoResp.PicDownResp();
      localRichProtoResp.jdField_a_of_type_JavaUtilList.add(i, localPicDownResp);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPicDownHandler
 * JD-Core Version:    0.7.0.1
 */