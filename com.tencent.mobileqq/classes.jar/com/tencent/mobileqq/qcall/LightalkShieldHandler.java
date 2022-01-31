package com.tencent.mobileqq.qcall;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.cmd0x488.oidb_0x488.AddBlockReq;
import tencent.im.oidb.cmd0x488.oidb_0x488.OneAddBlockData;
import tencent.im.oidb.cmd0x488.oidb_0x488.ReqBody;
import tencent.im.oidb.cmd0x489.oidb_0x489.DelBlockReq;
import tencent.im.oidb.cmd0x489.oidb_0x489.OneDelBlockData;
import tencent.im.oidb.cmd0x489.oidb_0x489.ReqBody;
import tencent.im.oidb.cmd0x48b.oidb_0x48b.GetblockListReq;
import tencent.im.oidb.cmd0x48b.oidb_0x48b.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class LightalkShieldHandler
  extends BusinessHandler
{
  public LightalkShieldHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = new oidb_0x48b.ReqBody();
    Object localObject2 = new oidb_0x48b.GetblockListReq();
    ((oidb_0x48b.GetblockListReq)localObject2).uint32_start_idx.set(paramInt1);
    ((oidb_0x48b.GetblockListReq)localObject2).uint32_req_num.set(100);
    ((oidb_0x48b.GetblockListReq)localObject2).uint32_last_get_time.set(paramInt2);
    ((oidb_0x48b.ReqBody)localObject1).msg_get_blocklist_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1163);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).str_client_version.set(AppSetting.c());
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x48b.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x48b_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  /* Error */
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 112	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifne +14 -> 22
    //   11: aload_0
    //   12: iconst_1
    //   13: iconst_0
    //   14: iconst_m1
    //   15: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   21: return
    //   22: new 44	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   25: dup
    //   26: invokespecial 45	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   29: astore 4
    //   31: aload 4
    //   33: aload_1
    //   34: invokevirtual 124	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   37: invokevirtual 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   40: checkcast 44	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +312 -> 357
    //   48: aload_1
    //   49: getfield 131	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   52: invokevirtual 134	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   55: ifeq +302 -> 357
    //   58: aload_1
    //   59: getfield 131	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   62: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   65: istore_3
    //   66: iload_3
    //   67: istore_2
    //   68: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +45 -> 116
    //   74: ldc 145
    //   76: iconst_2
    //   77: new 147	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   84: ldc 150
    //   86: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: iload_3
    //   90: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: ldc 159
    //   95: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: getfield 162	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   102: invokevirtual 164	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   105: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: iload_3
    //   115: istore_2
    //   116: iload_2
    //   117: ifne +229 -> 346
    //   120: aload_1
    //   121: getfield 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   124: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   127: ifeq +219 -> 346
    //   130: aload_1
    //   131: getfield 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   134: invokevirtual 175	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   137: ifnull +209 -> 346
    //   140: aload_1
    //   141: getfield 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   144: invokevirtual 175	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   147: invokevirtual 176	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   150: astore 4
    //   152: new 178	tencent/im/oidb/cmd0x488/oidb_0x488$RspBody
    //   155: dup
    //   156: invokespecial 179	tencent/im/oidb/cmd0x488/oidb_0x488$RspBody:<init>	()V
    //   159: astore_1
    //   160: aload_1
    //   161: aload 4
    //   163: invokevirtual 180	tencent/im/oidb/cmd0x488/oidb_0x488$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   166: pop
    //   167: aload_1
    //   168: getfield 184	tencent/im/oidb/cmd0x488/oidb_0x488$RspBody:msg_add_block_rsp	Ltencent/im/oidb/cmd0x488/oidb_0x488$AddBlockRsp;
    //   171: getfield 190	tencent/im/oidb/cmd0x488/oidb_0x488$AddBlockRsp:msg_one_block_data	Ltencent/im/oidb/cmd0x488/oidb_0x488$OneAddBlockData;
    //   174: invokevirtual 195	tencent/im/oidb/cmd0x488/oidb_0x488$OneAddBlockData:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   177: checkcast 192	tencent/im/oidb/cmd0x488/oidb_0x488$OneAddBlockData
    //   180: astore_1
    //   181: aload_1
    //   182: getfield 196	tencent/im/oidb/cmd0x488/oidb_0x488$OneAddBlockData:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   185: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   188: istore_2
    //   189: iload_2
    //   190: ifeq +8 -> 198
    //   193: iload_2
    //   194: iconst_1
    //   195: if_icmpne +140 -> 335
    //   198: new 198	com/tencent/mobileqq/qcall/LightalkShieldData
    //   201: dup
    //   202: invokespecial 199	com/tencent/mobileqq/qcall/LightalkShieldData:<init>	()V
    //   205: astore 4
    //   207: aload 4
    //   209: aload_1
    //   210: getfield 203	tencent/im/oidb/cmd0x488/oidb_0x488$OneAddBlockData:uint64_block_qcall_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   213: invokevirtual 208	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   216: putfield 212	com/tencent/mobileqq/qcall/LightalkShieldData:qcallId	J
    //   219: aload 4
    //   221: aload_1
    //   222: getfield 215	tencent/im/oidb/cmd0x488/oidb_0x488$OneAddBlockData:bytes_mobile	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   225: invokevirtual 175	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   228: invokevirtual 218	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   231: putfield 222	com/tencent/mobileqq/qcall/LightalkShieldData:phone	Ljava/lang/String;
    //   234: aload_0
    //   235: getfield 225	com/tencent/mobileqq/qcall/LightalkShieldHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   238: sipush 138
    //   241: invokevirtual 231	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   244: checkcast 233	com/tencent/mobileqq/qcall/LightalkShieldManager
    //   247: aload 4
    //   249: invokevirtual 236	com/tencent/mobileqq/qcall/LightalkShieldManager:a	(Lcom/tencent/mobileqq/qcall/LightalkShieldData;)V
    //   252: aload_0
    //   253: iconst_1
    //   254: iconst_1
    //   255: iload_2
    //   256: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   262: return
    //   263: astore_1
    //   264: ldc 238
    //   266: iconst_4
    //   267: aload_1
    //   268: invokevirtual 241	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   271: aload_1
    //   272: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   275: aload 4
    //   277: astore_1
    //   278: goto -234 -> 44
    //   281: astore_1
    //   282: ldc 238
    //   284: iconst_4
    //   285: aload_1
    //   286: invokevirtual 246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   289: aload_1
    //   290: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   293: aload 4
    //   295: astore_1
    //   296: goto -252 -> 44
    //   299: astore 4
    //   301: ldc 238
    //   303: iconst_4
    //   304: aload 4
    //   306: invokevirtual 241	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   309: aload 4
    //   311: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   314: goto -147 -> 167
    //   317: astore 4
    //   319: ldc 238
    //   321: iconst_4
    //   322: aload 4
    //   324: invokevirtual 246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   327: aload 4
    //   329: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   332: goto -165 -> 167
    //   335: aload_0
    //   336: iconst_1
    //   337: iconst_0
    //   338: iload_2
    //   339: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   345: return
    //   346: aload_0
    //   347: iconst_1
    //   348: iconst_0
    //   349: iconst_m1
    //   350: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   356: return
    //   357: iconst_m1
    //   358: istore_2
    //   359: goto -243 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	LightalkShieldHandler
    //   0	362	1	paramFromServiceMsg	FromServiceMsg
    //   67	292	2	i	int
    //   65	50	3	j	int
    //   29	265	4	localObject	Object
    //   299	11	4	localInvalidProtocolBufferMicroException	InvalidProtocolBufferMicroException
    //   317	11	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   31	44	263	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   31	44	281	java/lang/Exception
    //   160	167	299	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   160	167	317	java/lang/Exception
  }
  
  /* Error */
  private void c(FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 112	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifne +14 -> 22
    //   11: aload_0
    //   12: iconst_1
    //   13: iconst_0
    //   14: iconst_m1
    //   15: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   21: return
    //   22: new 44	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   25: dup
    //   26: invokespecial 45	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   29: astore 4
    //   31: aload 4
    //   33: aload_1
    //   34: invokevirtual 124	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   37: invokevirtual 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   40: checkcast 44	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +312 -> 357
    //   48: aload_1
    //   49: getfield 131	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   52: invokevirtual 134	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   55: ifeq +302 -> 357
    //   58: aload_1
    //   59: getfield 131	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   62: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   65: istore_3
    //   66: iload_3
    //   67: istore_2
    //   68: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +45 -> 116
    //   74: ldc 145
    //   76: iconst_2
    //   77: new 147	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   84: ldc 248
    //   86: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: iload_3
    //   90: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: ldc 159
    //   95: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_1
    //   99: getfield 162	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   102: invokevirtual 164	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   105: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: iload_3
    //   115: istore_2
    //   116: iload_2
    //   117: ifne +229 -> 346
    //   120: aload_1
    //   121: getfield 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   124: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   127: ifeq +219 -> 346
    //   130: aload_1
    //   131: getfield 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   134: invokevirtual 175	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   137: ifnull +209 -> 346
    //   140: aload_1
    //   141: getfield 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   144: invokevirtual 175	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   147: invokevirtual 176	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   150: astore 4
    //   152: new 250	tencent/im/oidb/cmd0x489/oidb_0x489$RspBody
    //   155: dup
    //   156: invokespecial 251	tencent/im/oidb/cmd0x489/oidb_0x489$RspBody:<init>	()V
    //   159: astore_1
    //   160: aload_1
    //   161: aload 4
    //   163: invokevirtual 252	tencent/im/oidb/cmd0x489/oidb_0x489$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   166: pop
    //   167: aload_1
    //   168: getfield 256	tencent/im/oidb/cmd0x489/oidb_0x489$RspBody:msg_del_block_rsp	Ltencent/im/oidb/cmd0x489/oidb_0x489$DelBlockRsp;
    //   171: getfield 261	tencent/im/oidb/cmd0x489/oidb_0x489$DelBlockRsp:msg_one_block_data	Ltencent/im/oidb/cmd0x489/oidb_0x489$OneDelBlockData;
    //   174: invokevirtual 264	tencent/im/oidb/cmd0x489/oidb_0x489$OneDelBlockData:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   177: checkcast 263	tencent/im/oidb/cmd0x489/oidb_0x489$OneDelBlockData
    //   180: astore_1
    //   181: aload_1
    //   182: getfield 265	tencent/im/oidb/cmd0x489/oidb_0x489$OneDelBlockData:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   185: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   188: istore_2
    //   189: iload_2
    //   190: ifeq +8 -> 198
    //   193: iload_2
    //   194: iconst_1
    //   195: if_icmpne +140 -> 335
    //   198: new 198	com/tencent/mobileqq/qcall/LightalkShieldData
    //   201: dup
    //   202: invokespecial 199	com/tencent/mobileqq/qcall/LightalkShieldData:<init>	()V
    //   205: astore 4
    //   207: aload 4
    //   209: aload_1
    //   210: getfield 266	tencent/im/oidb/cmd0x489/oidb_0x489$OneDelBlockData:uint64_block_qcall_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   213: invokevirtual 208	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   216: putfield 212	com/tencent/mobileqq/qcall/LightalkShieldData:qcallId	J
    //   219: aload 4
    //   221: aload_1
    //   222: getfield 267	tencent/im/oidb/cmd0x489/oidb_0x489$OneDelBlockData:bytes_mobile	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   225: invokevirtual 175	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   228: invokevirtual 218	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   231: putfield 222	com/tencent/mobileqq/qcall/LightalkShieldData:phone	Ljava/lang/String;
    //   234: aload_0
    //   235: getfield 225	com/tencent/mobileqq/qcall/LightalkShieldHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   238: sipush 138
    //   241: invokevirtual 231	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   244: checkcast 233	com/tencent/mobileqq/qcall/LightalkShieldManager
    //   247: aload 4
    //   249: invokevirtual 269	com/tencent/mobileqq/qcall/LightalkShieldManager:b	(Lcom/tencent/mobileqq/qcall/LightalkShieldData;)V
    //   252: aload_0
    //   253: iconst_2
    //   254: iconst_1
    //   255: iload_2
    //   256: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   262: return
    //   263: astore_1
    //   264: ldc 238
    //   266: iconst_4
    //   267: aload_1
    //   268: invokevirtual 241	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   271: aload_1
    //   272: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   275: aload 4
    //   277: astore_1
    //   278: goto -234 -> 44
    //   281: astore_1
    //   282: ldc 238
    //   284: iconst_4
    //   285: aload_1
    //   286: invokevirtual 246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   289: aload_1
    //   290: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   293: aload 4
    //   295: astore_1
    //   296: goto -252 -> 44
    //   299: astore 4
    //   301: ldc 238
    //   303: iconst_4
    //   304: aload 4
    //   306: invokevirtual 241	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   309: aload 4
    //   311: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   314: goto -147 -> 167
    //   317: astore 4
    //   319: ldc 238
    //   321: iconst_4
    //   322: aload 4
    //   324: invokevirtual 246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   327: aload 4
    //   329: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   332: goto -165 -> 167
    //   335: aload_0
    //   336: iconst_2
    //   337: iconst_0
    //   338: iload_2
    //   339: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   345: return
    //   346: aload_0
    //   347: iconst_2
    //   348: iconst_0
    //   349: iconst_m1
    //   350: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   356: return
    //   357: iconst_m1
    //   358: istore_2
    //   359: goto -243 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	LightalkShieldHandler
    //   0	362	1	paramFromServiceMsg	FromServiceMsg
    //   67	292	2	i	int
    //   65	50	3	j	int
    //   29	265	4	localObject	Object
    //   299	11	4	localInvalidProtocolBufferMicroException	InvalidProtocolBufferMicroException
    //   317	11	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   31	44	263	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   31	44	281	java/lang/Exception
    //   160	167	299	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   160	167	317	java/lang/Exception
  }
  
  private void d()
  {
    a(0, ((LightalkShieldManager)this.b.getManager(138)).a());
  }
  
  /* Error */
  private void d(FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 112	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifne +11 -> 19
    //   11: aload_0
    //   12: iconst_3
    //   13: iconst_0
    //   14: aconst_null
    //   15: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   18: return
    //   19: new 44	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   22: dup
    //   23: invokespecial 45	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   26: astore 5
    //   28: aload 5
    //   30: aload_1
    //   31: invokevirtual 124	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   34: invokevirtual 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   37: checkcast 44	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   40: astore_1
    //   41: iconst_m1
    //   42: istore_3
    //   43: iload_3
    //   44: istore_2
    //   45: aload_1
    //   46: ifnull +74 -> 120
    //   49: iload_3
    //   50: istore_2
    //   51: aload_1
    //   52: getfield 131	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   55: invokevirtual 134	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   58: ifeq +62 -> 120
    //   61: aload_1
    //   62: getfield 131	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   65: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   68: istore_3
    //   69: iload_3
    //   70: istore_2
    //   71: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +46 -> 120
    //   77: ldc 145
    //   79: iconst_2
    //   80: new 147	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 275
    //   90: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload_3
    //   94: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: ldc 159
    //   99: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: getfield 162	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   106: invokevirtual 164	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   109: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: iload_3
    //   119: istore_2
    //   120: iload_2
    //   121: ifne +199 -> 320
    //   124: aload_1
    //   125: getfield 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   128: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   131: ifeq +189 -> 320
    //   134: aload_1
    //   135: getfield 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   138: invokevirtual 175	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   141: ifnull +179 -> 320
    //   144: aload_1
    //   145: getfield 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   148: invokevirtual 175	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   151: invokevirtual 176	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   154: astore 5
    //   156: new 277	tencent/im/oidb/cmd0x48a/oidb_0x48a$RspBody
    //   159: dup
    //   160: invokespecial 278	tencent/im/oidb/cmd0x48a/oidb_0x48a$RspBody:<init>	()V
    //   163: astore_1
    //   164: aload_1
    //   165: aload 5
    //   167: invokevirtual 279	tencent/im/oidb/cmd0x48a/oidb_0x48a$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   170: pop
    //   171: aload_1
    //   172: getfield 283	tencent/im/oidb/cmd0x48a/oidb_0x48a$RspBody:msg_chk_block_rsp	Ltencent/im/oidb/cmd0x48a/oidb_0x48a$ChkBlockRsp;
    //   175: getfield 286	tencent/im/oidb/cmd0x48a/oidb_0x48a$ChkBlockRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   178: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   181: istore_2
    //   182: aload_1
    //   183: getfield 283	tencent/im/oidb/cmd0x48a/oidb_0x48a$RspBody:msg_chk_block_rsp	Ltencent/im/oidb/cmd0x48a/oidb_0x48a$ChkBlockRsp;
    //   186: getfield 290	tencent/im/oidb/cmd0x48a/oidb_0x48a$ChkBlockRsp:msg_block_account_data	Ltencent/im/oidb/cmd0x48a/oidb_0x48a$OneBlockAccountData;
    //   189: invokevirtual 293	tencent/im/oidb/cmd0x48a/oidb_0x48a$OneBlockAccountData:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   192: checkcast 292	tencent/im/oidb/cmd0x48a/oidb_0x48a$OneBlockAccountData
    //   195: astore_1
    //   196: aload_1
    //   197: getfield 294	tencent/im/oidb/cmd0x48a/oidb_0x48a$OneBlockAccountData:uint64_block_qcall_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   200: invokevirtual 208	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   203: pop2
    //   204: aload_1
    //   205: getfield 297	tencent/im/oidb/cmd0x48a/oidb_0x48a$OneBlockAccountData:uint32_account_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   208: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   211: pop
    //   212: iload_2
    //   213: bipush 100
    //   215: irem
    //   216: bipush 10
    //   218: idiv
    //   219: istore_3
    //   220: iload_2
    //   221: bipush 10
    //   223: irem
    //   224: ifne +90 -> 314
    //   227: iconst_0
    //   228: istore 4
    //   230: aload_0
    //   231: iconst_3
    //   232: iconst_1
    //   233: iload 4
    //   235: invokestatic 302	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   238: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   241: return
    //   242: astore_1
    //   243: ldc 238
    //   245: iconst_4
    //   246: aload_1
    //   247: invokevirtual 241	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   250: aload_1
    //   251: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   254: aload 5
    //   256: astore_1
    //   257: goto -216 -> 41
    //   260: astore_1
    //   261: ldc 238
    //   263: iconst_4
    //   264: aload_1
    //   265: invokevirtual 246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   268: aload_1
    //   269: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload 5
    //   274: astore_1
    //   275: goto -234 -> 41
    //   278: astore 5
    //   280: ldc 238
    //   282: iconst_4
    //   283: aload 5
    //   285: invokevirtual 241	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   288: aload 5
    //   290: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   293: goto -122 -> 171
    //   296: astore 5
    //   298: ldc 238
    //   300: iconst_4
    //   301: aload 5
    //   303: invokevirtual 246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   306: aload 5
    //   308: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: goto -140 -> 171
    //   314: iconst_1
    //   315: istore 4
    //   317: goto -87 -> 230
    //   320: aload_0
    //   321: iconst_3
    //   322: iconst_0
    //   323: aconst_null
    //   324: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   327: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	LightalkShieldHandler
    //   0	328	1	paramFromServiceMsg	FromServiceMsg
    //   44	180	2	i	int
    //   42	178	3	j	int
    //   228	88	4	bool	boolean
    //   26	247	5	localObject	Object
    //   278	11	5	localInvalidProtocolBufferMicroException	InvalidProtocolBufferMicroException
    //   296	11	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   28	41	242	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   28	41	260	java/lang/Exception
    //   164	171	278	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   164	171	296	java/lang/Exception
  }
  
  /* Error */
  private void e(FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 112	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   8: ifne +11 -> 19
    //   11: aload_0
    //   12: iconst_4
    //   13: iconst_0
    //   14: aconst_null
    //   15: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   18: return
    //   19: new 44	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   22: dup
    //   23: invokespecial 45	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   26: astore 5
    //   28: aload 5
    //   30: aload_1
    //   31: invokevirtual 124	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   34: invokevirtual 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   37: checkcast 44	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   40: astore_1
    //   41: iconst_m1
    //   42: istore_3
    //   43: iload_3
    //   44: istore_2
    //   45: aload_1
    //   46: ifnull +74 -> 120
    //   49: iload_3
    //   50: istore_2
    //   51: aload_1
    //   52: getfield 131	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   55: invokevirtual 134	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   58: ifeq +62 -> 120
    //   61: aload_1
    //   62: getfield 131	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   65: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   68: istore_3
    //   69: iload_3
    //   70: istore_2
    //   71: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +46 -> 120
    //   77: ldc 145
    //   79: iconst_2
    //   80: new 147	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 305
    //   90: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload_3
    //   94: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: ldc 159
    //   99: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: getfield 162	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   106: invokevirtual 164	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   109: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: iload_3
    //   119: istore_2
    //   120: iload_2
    //   121: ifne +354 -> 475
    //   124: aload_1
    //   125: getfield 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   128: invokevirtual 172	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   131: ifeq +344 -> 475
    //   134: aload_1
    //   135: getfield 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   138: invokevirtual 175	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   141: ifnull +334 -> 475
    //   144: aload_1
    //   145: getfield 70	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   148: invokevirtual 175	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   151: invokevirtual 176	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   154: astore_1
    //   155: new 307	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody
    //   158: dup
    //   159: invokespecial 308	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody:<init>	()V
    //   162: astore 5
    //   164: aload 5
    //   166: aload_1
    //   167: invokevirtual 309	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   170: pop
    //   171: aload 5
    //   173: getfield 313	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody:msg_get_blocklist_rsp	Ltencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp;
    //   176: getfield 318	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp:uint32_over	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   179: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   182: istore_2
    //   183: aload 5
    //   185: getfield 313	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody:msg_get_blocklist_rsp	Ltencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp;
    //   188: getfield 321	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp:uint32_next_start_idx	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   191: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   194: istore_3
    //   195: aload 5
    //   197: getfield 313	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody:msg_get_blocklist_rsp	Ltencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp;
    //   200: getfield 324	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp:uint32_get_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   203: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   206: istore 4
    //   208: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +50 -> 261
    //   214: ldc 145
    //   216: iconst_2
    //   217: new 147	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 326
    //   227: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: iload_2
    //   231: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc_w 328
    //   237: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: iload_3
    //   241: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 330
    //   247: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: iload 4
    //   252: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 171	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload_0
    //   262: getfield 225	com/tencent/mobileqq/qcall/LightalkShieldHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   265: sipush 138
    //   268: invokevirtual 231	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   271: checkcast 233	com/tencent/mobileqq/qcall/LightalkShieldManager
    //   274: astore_1
    //   275: aload 5
    //   277: getfield 313	tencent/im/oidb/cmd0x48b/oidb_0x48b$RspBody:msg_get_blocklist_rsp	Ltencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp;
    //   280: getfield 334	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetblockListRsp:rpt_msg_get_total_block_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   283: invokevirtual 339	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   286: astore 5
    //   288: aload 5
    //   290: ifnull +157 -> 447
    //   293: aload 5
    //   295: invokeinterface 344 1 0
    //   300: ifle +147 -> 447
    //   303: aload 5
    //   305: invokeinterface 348 1 0
    //   310: astore 5
    //   312: aload 5
    //   314: invokeinterface 353 1 0
    //   319: ifeq +128 -> 447
    //   322: aload 5
    //   324: invokeinterface 357 1 0
    //   329: checkcast 359	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetTotalblockInfo
    //   332: astore 6
    //   334: new 198	com/tencent/mobileqq/qcall/LightalkShieldData
    //   337: dup
    //   338: invokespecial 199	com/tencent/mobileqq/qcall/LightalkShieldData:<init>	()V
    //   341: astore 7
    //   343: aload 7
    //   345: aload 6
    //   347: getfield 360	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetTotalblockInfo:uint64_block_qcall_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   350: invokevirtual 208	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   353: putfield 212	com/tencent/mobileqq/qcall/LightalkShieldData:qcallId	J
    //   356: aload 7
    //   358: aload 6
    //   360: getfield 361	tencent/im/oidb/cmd0x48b/oidb_0x48b$GetTotalblockInfo:bytes_mobile	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   363: invokevirtual 175	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   366: invokevirtual 218	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   369: putfield 222	com/tencent/mobileqq/qcall/LightalkShieldData:phone	Ljava/lang/String;
    //   372: aload_1
    //   373: aload 7
    //   375: invokevirtual 236	com/tencent/mobileqq/qcall/LightalkShieldManager:a	(Lcom/tencent/mobileqq/qcall/LightalkShieldData;)V
    //   378: goto -66 -> 312
    //   381: astore_1
    //   382: ldc 238
    //   384: iconst_4
    //   385: aload_1
    //   386: invokevirtual 241	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   389: aload_1
    //   390: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   393: aload 5
    //   395: astore_1
    //   396: goto -355 -> 41
    //   399: astore_1
    //   400: ldc 238
    //   402: iconst_4
    //   403: aload_1
    //   404: invokevirtual 246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   407: aload_1
    //   408: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   411: aload 5
    //   413: astore_1
    //   414: goto -373 -> 41
    //   417: astore_1
    //   418: ldc 238
    //   420: iconst_4
    //   421: aload_1
    //   422: invokevirtual 241	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   425: aload_1
    //   426: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   429: goto -258 -> 171
    //   432: astore_1
    //   433: ldc 238
    //   435: iconst_4
    //   436: aload_1
    //   437: invokevirtual 246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   440: aload_1
    //   441: invokestatic 245	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   444: goto -273 -> 171
    //   447: iload_2
    //   448: ifne +13 -> 461
    //   451: aload_0
    //   452: iload_3
    //   453: aload_1
    //   454: invokevirtual 271	com/tencent/mobileqq/qcall/LightalkShieldManager:a	()I
    //   457: invokespecial 273	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(II)V
    //   460: return
    //   461: aload_1
    //   462: iload 4
    //   464: invokevirtual 363	com/tencent/mobileqq/qcall/LightalkShieldManager:a	(I)V
    //   467: aload_0
    //   468: iconst_4
    //   469: iconst_1
    //   470: aconst_null
    //   471: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   474: return
    //   475: aload_0
    //   476: iconst_4
    //   477: iconst_0
    //   478: aconst_null
    //   479: invokevirtual 121	com/tencent/mobileqq/qcall/LightalkShieldHandler:a	(IZLjava/lang/Object;)V
    //   482: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	LightalkShieldHandler
    //   0	483	1	paramFromServiceMsg	FromServiceMsg
    //   44	404	2	i	int
    //   42	411	3	j	int
    //   206	257	4	k	int
    //   26	386	5	localObject	Object
    //   332	27	6	localGetTotalblockInfo	tencent.im.oidb.cmd0x48b.oidb_0x48b.GetTotalblockInfo
    //   341	33	7	localLightalkShieldData	LightalkShieldData
    // Exception table:
    //   from	to	target	type
    //   28	41	381	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   28	41	399	java/lang/Exception
    //   164	171	417	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   164	171	432	java/lang/Exception
  }
  
  private void f(FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
      a(4, false, null);
    }
    label215:
    do
    {
      do
      {
        for (;;)
        {
          return;
          oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
          try
          {
            paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom(paramFromServiceMsg.getWupBuffer());
            int j = -1;
            int i = j;
            if (paramFromServiceMsg != null)
            {
              i = j;
              if (paramFromServiceMsg.uint32_result.has())
              {
                j = paramFromServiceMsg.uint32_result.get();
                i = j;
                if (QLog.isColorLevel())
                {
                  QLog.d("lightalk_shield_handler", 2, "handleShieldLightalkFlag| ret:" + j + " errMsg:" + paramFromServiceMsg.str_error_msg.get());
                  i = j;
                }
              }
            }
            if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()))
            {
              paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
              if (paramFromServiceMsg.length != 5) {
                break label215;
              }
              if (paramFromServiceMsg[4] == 1)
              {
                d();
                return;
              }
            }
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            for (;;)
            {
              QLog.w("LightalkShieldHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
              paramFromServiceMsg = localOIDBSSOPkg;
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            for (;;)
            {
              QLog.w("LightalkShieldHandler", 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
              paramFromServiceMsg = localOIDBSSOPkg;
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("lightalk_shield_handler", 2, "handleShieldLightalkFlag| flag!=1.");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("lightalk_shield_handler", 2, "handleShieldLightalkFlag| data.len!=5.");
  }
  
  protected Class a()
  {
    return LightalkShieldObserver.class;
  }
  
  public void a(int paramInt, long paramLong)
  {
    oidb_0x488.OneAddBlockData localOneAddBlockData = new oidb_0x488.OneAddBlockData();
    localOneAddBlockData.uint32_account_type.set(paramInt);
    localOneAddBlockData.uint64_block_qcall_id.set(paramLong);
    a(localOneAddBlockData, 0);
  }
  
  public void a(int paramInt, String paramString)
  {
    oidb_0x488.OneAddBlockData localOneAddBlockData = new oidb_0x488.OneAddBlockData();
    localOneAddBlockData.uint32_account_type.set(paramInt);
    localOneAddBlockData.bytes_mobile.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    a(localOneAddBlockData, 1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      return;
      paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
      if (paramToServiceMsg.equals("OidbSvc.0x488_0"))
      {
        a(paramFromServiceMsg);
        return;
      }
      if (paramToServiceMsg.equals("OidbSvc.0x489_0"))
      {
        c(paramFromServiceMsg);
        return;
      }
      if (paramToServiceMsg.equals("OidbSvc.0x48a_0"))
      {
        d(paramFromServiceMsg);
        return;
      }
      if (paramToServiceMsg.equals("OidbSvc.0x48b_0"))
      {
        e(paramFromServiceMsg);
        return;
      }
    } while (!paramToServiceMsg.equals("OidbSvc.0x492_114"));
    f(paramFromServiceMsg);
  }
  
  public void a(oidb_0x488.OneAddBlockData paramOneAddBlockData, int paramInt)
  {
    Object localObject = new oidb_0x488.AddBlockReq();
    ((oidb_0x488.AddBlockReq)localObject).msg_one_block_data.set(paramOneAddBlockData);
    paramOneAddBlockData = new oidb_0x488.ReqBody();
    paramOneAddBlockData.msg_add_block_req.set((MessageMicro)localObject);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1160);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.c());
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramOneAddBlockData.toByteArray()));
    paramOneAddBlockData = a("OidbSvc.0x488_0");
    paramOneAddBlockData.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    b(paramOneAddBlockData);
  }
  
  public void a(oidb_0x489.OneDelBlockData paramOneDelBlockData, int paramInt)
  {
    Object localObject = new oidb_0x489.ReqBody();
    oidb_0x489.DelBlockReq localDelBlockReq = new oidb_0x489.DelBlockReq();
    localDelBlockReq.msg_one_block_data.set(paramOneDelBlockData);
    ((oidb_0x489.ReqBody)localObject).msg_del_block_req.set(localDelBlockReq);
    paramOneDelBlockData = new oidb_sso.OIDBSSOPkg();
    paramOneDelBlockData.uint32_command.set(1161);
    paramOneDelBlockData.uint32_service_type.set(paramInt);
    paramOneDelBlockData.str_client_version.set(AppSetting.c());
    paramOneDelBlockData.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x489.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x489_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramOneDelBlockData.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void b()
  {
    c();
  }
  
  public void b(int paramInt, long paramLong)
  {
    oidb_0x489.OneDelBlockData localOneDelBlockData = new oidb_0x489.OneDelBlockData();
    localOneDelBlockData.uint32_account_type.set(paramInt);
    localOneDelBlockData.uint64_block_qcall_id.set(paramLong);
    a(localOneDelBlockData, 0);
  }
  
  public void b(int paramInt, String paramString)
  {
    oidb_0x489.OneDelBlockData localOneDelBlockData = new oidb_0x489.OneDelBlockData();
    localOneDelBlockData.uint32_account_type.set(paramInt);
    localOneDelBlockData.bytes_mobile.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    a(localOneDelBlockData, 1);
  }
  
  public void c()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1170);
    localOIDBSSOPkg.uint32_service_type.set(114);
    Object localObject = this.b.c();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    try
    {
      localByteBuffer.putInt(Integer.parseInt((String)localObject));
      localObject = localByteBuffer.array();
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom((byte[])localObject));
      localObject = a("OidbSvc.0x492_114");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("lightalk_shield_handler", 2, "reqShieldLightalkFlag| uin format exception.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.LightalkShieldHandler
 * JD-Core Version:    0.7.0.1
 */