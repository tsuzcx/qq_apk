package com.tencent.mobileqq.transfile.protohandler;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.longconn.multimsg.MultiMsg.ReqBody;

public class MultiMsgDownHandler
  extends BaseHandler
{
  int mReqNetType;
  
  private void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, MultiMsg.ReqBody paramReqBody)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    int j = NetworkCenter.getInstance().getNetType();
    this.mReqNetType = j;
    int i = 3;
    if (j != 1) {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4) {
            i = 255;
          } else {
            i = 8;
          }
        }
        else {
          i = 7;
        }
      }
      else {
        i = 6;
      }
    }
    Object localObject = NetworkCenter.getInstance().getApnType();
    j = i;
    if (localObject != null)
    {
      j = i;
      if (((String)localObject).contains("wap")) {
        j = 5;
      }
    }
    localObject = new MultiMsg.ReqBody();
    ((MultiMsg.ReqBody)localObject).setHasFlag(true);
    ((MultiMsg.ReqBody)localObject).uint32_subcmd.set(2);
    ((MultiMsg.ReqBody)localObject).uint32_term_type.set(5);
    ((MultiMsg.ReqBody)localObject).uint32_platform_type.set(9);
    ((MultiMsg.ReqBody)localObject).uint32_net_type.set(j);
    ((MultiMsg.ReqBody)localObject).bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
    ((MultiMsg.ReqBody)localObject).uint32_req_channel_type.set(2);
    i = 0;
    while (i < paramList.size())
    {
      addOne(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), (MultiMsg.ReqBody)localObject);
      i += 1;
    }
    return ((MultiMsg.ReqBody)localObject).toByteArray();
  }
  
  public static List<ExcitingTransferHostInfo> getBDHServerIp(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = ConfigManager.getInstance(BaseApplication.getContext(), ((QQAppInterface)localObject1).getHwEngine());
      if (localObject2 != null)
      {
        localObject2 = ((ConfigManager)localObject2).getOtherTypeIp(((QQAppInterface)localObject1).getApp().getBaseContext(), 21, paramBoolean);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          localObject1 = ((List)localObject2).iterator();
        }
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (EndPoint)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((EndPoint)localObject2).host)))
          {
            localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject2).host, ((EndPoint)localObject2).port, true));
            continue;
            HwServlet.getConfig((AppRuntime)localObject1, ((QQAppInterface)localObject1).getCurrentUin());
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static byte[] getHttpConnKey()
  {
    return SessionInfo.getInstance(BaseApplicationImpl.getApplication().getRuntime().getAccount()).getSessionKey();
  }
  
  public static byte[] getHttpConnSig()
  {
    return SessionInfo.getInstance(BaseApplicationImpl.getApplication().getRuntime().getAccount()).getHttpconn_sig_session();
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.MultiMsgDownResp localMultiMsgDownResp = new RichProto.RichProtoResp.MultiMsgDownResp();
      localRichProtoResp.resps.add(i, localMultiMsgDownResp);
      i += 1;
    }
  }
  
  /* Error */
  public void onProtoResp(com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 262	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:resp	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   4: astore 12
    //   6: aload_1
    //   7: getfield 262	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:resp	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   10: invokevirtual 267	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   13: astore 17
    //   15: aload_2
    //   16: getfield 273	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:busiData	Ljava/lang/Object;
    //   19: checkcast 231	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq
    //   22: astore 18
    //   24: aload 18
    //   26: getfield 235	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:resp	Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp;
    //   29: astore 19
    //   31: aload_1
    //   32: getfield 277	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:statisInfo	Lcom/tencent/mobileqq/app/StatictisInfo;
    //   35: astore 20
    //   37: aload 12
    //   39: invokevirtual 280	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   42: sipush 1000
    //   45: if_icmpeq +78 -> 123
    //   48: aload 12
    //   50: invokevirtual 280	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   53: istore_3
    //   54: iload_3
    //   55: sipush 1002
    //   58: if_icmpeq +39 -> 97
    //   61: iload_3
    //   62: sipush 1013
    //   65: if_icmpne +6 -> 71
    //   68: goto +29 -> 97
    //   71: aload_0
    //   72: iconst_m1
    //   73: sipush 9044
    //   76: aload 12
    //   78: invokestatic 286	com/tencent/mobileqq/app/BaseMessageHandler:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/String;
    //   81: ldc_w 288
    //   84: aload 20
    //   86: aload 19
    //   88: getfield 241	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   91: invokevirtual 292	com/tencent/mobileqq/transfile/protohandler/MultiMsgDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   94: goto +1209 -> 1303
    //   97: aload_0
    //   98: iconst_m1
    //   99: sipush 9311
    //   102: aload 12
    //   104: invokestatic 286	com/tencent/mobileqq/app/BaseMessageHandler:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/String;
    //   107: ldc_w 288
    //   110: aload 20
    //   112: aload 19
    //   114: getfield 241	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   117: invokevirtual 292	com/tencent/mobileqq/transfile/protohandler/MultiMsgDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   120: goto +1183 -> 1303
    //   123: new 294	tencent/im/longconn/multimsg/MultiMsg$RspBody
    //   126: dup
    //   127: invokespecial 295	tencent/im/longconn/multimsg/MultiMsg$RspBody:<init>	()V
    //   130: aload 17
    //   132: invokevirtual 299	tencent/im/longconn/multimsg/MultiMsg$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   135: checkcast 294	tencent/im/longconn/multimsg/MultiMsg$RspBody
    //   138: getfield 303	tencent/im/longconn/multimsg/MultiMsg$RspBody:rpt_multimsg_applydown_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   141: invokevirtual 308	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull +1075 -> 1221
    //   149: aload_1
    //   150: invokeinterface 102 1 0
    //   155: ifeq +1066 -> 1221
    //   158: iconst_0
    //   159: istore_3
    //   160: iload_3
    //   161: aload_1
    //   162: invokeinterface 102 1 0
    //   167: if_icmpge +1136 -> 1303
    //   170: aload_1
    //   171: iload_3
    //   172: invokeinterface 106 2 0
    //   177: checkcast 310	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp
    //   180: astore 21
    //   182: aload 19
    //   184: getfield 241	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   187: iload_3
    //   188: invokeinterface 106 2 0
    //   193: checkcast 249	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$MultiMsgDownResp
    //   196: astore 14
    //   198: aload 21
    //   200: getfield 313	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   203: invokevirtual 315	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   206: istore 5
    //   208: iload 5
    //   210: ifne +762 -> 972
    //   213: aload 21
    //   215: getfield 318	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:bytes_thumb_down_para	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   218: invokevirtual 321	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   221: ifeq +740 -> 961
    //   224: aload 21
    //   226: getfield 318	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:bytes_thumb_down_para	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokevirtual 324	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   232: astore 12
    //   234: aload 12
    //   236: ifnonnull +9 -> 245
    //   239: aconst_null
    //   240: astore 13
    //   242: goto +10 -> 252
    //   245: aload 12
    //   247: invokevirtual 327	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   250: astore 13
    //   252: aload 13
    //   254: ifnull +696 -> 950
    //   257: aload 13
    //   259: ldc_w 288
    //   262: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   265: ifne +685 -> 950
    //   268: aload 21
    //   270: getfield 333	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:bytes_msg_resid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   273: invokevirtual 321	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   276: ifeq +663 -> 939
    //   279: aload 21
    //   281: getfield 333	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:bytes_msg_resid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   284: invokevirtual 324	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   287: invokevirtual 334	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   290: astore 15
    //   292: aload 15
    //   294: ifnull +634 -> 928
    //   297: aload 15
    //   299: arraylength
    //   300: ifle +628 -> 928
    //   303: aload 21
    //   305: getfield 337	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:bytes_msg_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   308: invokevirtual 321	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   311: ifeq +606 -> 917
    //   314: aload 21
    //   316: getfield 337	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:bytes_msg_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   319: invokevirtual 324	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   322: invokevirtual 334	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   325: astore 16
    //   327: aload 16
    //   329: ifnull +577 -> 906
    //   332: aload 16
    //   334: arraylength
    //   335: ifle +571 -> 906
    //   338: aload 21
    //   340: getfield 341	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:msg_extern_info	Ltencent/im/longconn/multimsg/MultiMsg$ExternMsg;
    //   343: invokevirtual 344	tencent/im/longconn/multimsg/MultiMsg$ExternMsg:has	()Z
    //   346: istore 7
    //   348: iload 7
    //   350: ifeq +54 -> 404
    //   353: iload_3
    //   354: istore 4
    //   356: aload_1
    //   357: astore 12
    //   359: aload 21
    //   361: getfield 341	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:msg_extern_info	Ltencent/im/longconn/multimsg/MultiMsg$ExternMsg;
    //   364: invokevirtual 347	tencent/im/longconn/multimsg/MultiMsg$ExternMsg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   367: checkcast 343	tencent/im/longconn/multimsg/MultiMsg$ExternMsg
    //   370: getfield 350	tencent/im/longconn/multimsg/MultiMsg$ExternMsg:uint32_channel_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   373: invokevirtual 315	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   376: istore 5
    //   378: iload 5
    //   380: istore 4
    //   382: goto +25 -> 407
    //   385: astore 15
    //   387: aload 14
    //   389: astore 13
    //   391: iload 4
    //   393: istore_3
    //   394: aload 12
    //   396: astore_1
    //   397: aload 15
    //   399: astore 12
    //   401: goto +747 -> 1148
    //   404: iconst_0
    //   405: istore 4
    //   407: aload 14
    //   409: iload 4
    //   411: putfield 353	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$MultiMsgDownResp:mChannelType	I
    //   414: aload 14
    //   416: aload 13
    //   418: putfield 356	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$MultiMsgDownResp:urlParam	Ljava/lang/String;
    //   421: aload 14
    //   423: aload 15
    //   425: putfield 360	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$MultiMsgDownResp:resId	[B
    //   428: aload 14
    //   430: aload 16
    //   432: putfield 363	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$MultiMsgDownResp:msgkey	[B
    //   435: aload 21
    //   437: getfield 367	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:rpt_uint32_down_ip	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   440: invokevirtual 370	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   443: astore 16
    //   445: aload 21
    //   447: getfield 373	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:rpt_uint32_down_port	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   450: invokevirtual 370	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   453: astore 15
    //   455: aload 16
    //   457: ifnull +438 -> 895
    //   460: aload 16
    //   462: invokeinterface 102 1 0
    //   467: istore 4
    //   469: iload 4
    //   471: ifeq +424 -> 895
    //   474: iload_3
    //   475: istore 5
    //   477: aload_1
    //   478: astore 13
    //   480: aload 16
    //   482: ifnull +186 -> 668
    //   485: iload_3
    //   486: istore 4
    //   488: aload_1
    //   489: astore 12
    //   491: iload_3
    //   492: istore 5
    //   494: aload_1
    //   495: astore 13
    //   497: aload 16
    //   499: invokeinterface 102 1 0
    //   504: ifle +164 -> 668
    //   507: iconst_0
    //   508: istore 6
    //   510: iload_3
    //   511: istore 4
    //   513: aload_1
    //   514: astore 12
    //   516: iload_3
    //   517: istore 5
    //   519: aload_1
    //   520: astore 13
    //   522: iload 6
    //   524: aload 16
    //   526: invokeinterface 102 1 0
    //   531: if_icmpge +137 -> 668
    //   534: iload_3
    //   535: istore 4
    //   537: aload_1
    //   538: astore 12
    //   540: aload 16
    //   542: iload 6
    //   544: invokeinterface 106 2 0
    //   549: checkcast 375	java/lang/Integer
    //   552: invokevirtual 378	java/lang/Integer:intValue	()I
    //   555: istore 5
    //   557: aload_1
    //   558: astore 12
    //   560: iload 5
    //   562: i2l
    //   563: lstore 8
    //   565: aload 12
    //   567: astore_1
    //   568: iload_3
    //   569: istore 5
    //   571: aload 15
    //   573: iload 6
    //   575: invokeinterface 106 2 0
    //   580: checkcast 375	java/lang/Integer
    //   583: invokevirtual 378	java/lang/Integer:intValue	()I
    //   586: i2l
    //   587: lstore 10
    //   589: aload 12
    //   591: astore_1
    //   592: iload_3
    //   593: istore 5
    //   595: new 380	com/tencent/mobileqq/transfile/ServerAddr
    //   598: dup
    //   599: invokespecial 381	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   602: astore 13
    //   604: aload 12
    //   606: astore_1
    //   607: iload_3
    //   608: istore 5
    //   610: aload 13
    //   612: lload 8
    //   614: ldc2_w 382
    //   617: land
    //   618: invokestatic 389	com/tencent/mobileqq/utils/httputils/PkgTools:int2IPNet	(J)Ljava/lang/String;
    //   621: putfield 392	com/tencent/mobileqq/transfile/ServerAddr:mIp	Ljava/lang/String;
    //   624: aload 12
    //   626: astore_1
    //   627: iload_3
    //   628: istore 5
    //   630: aload 13
    //   632: lload 10
    //   634: l2i
    //   635: putfield 393	com/tencent/mobileqq/transfile/ServerAddr:port	I
    //   638: aload 12
    //   640: astore_1
    //   641: iload_3
    //   642: istore 5
    //   644: aload 14
    //   646: getfield 397	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$MultiMsgDownResp:ipList	Ljava/util/ArrayList;
    //   649: iload 6
    //   651: aload 13
    //   653: invokevirtual 398	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   656: iload 6
    //   658: iconst_1
    //   659: iadd
    //   660: istore 6
    //   662: aload 12
    //   664: astore_1
    //   665: goto -155 -> 510
    //   668: iload 5
    //   670: istore 4
    //   672: aload 13
    //   674: astore 12
    //   676: aload 21
    //   678: getfield 401	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:rpt_bytes_down_ip_v6	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   681: invokevirtual 370	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   684: astore 13
    //   686: aload 21
    //   688: getfield 404	tencent/im/longconn/multimsg/MultiMsg$MultiMsgApplyDownRsp:rpt_uint32_down_v6_port	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   691: invokevirtual 370	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   694: astore 15
    //   696: aload 13
    //   698: ifnull +166 -> 864
    //   701: aload 12
    //   703: astore_1
    //   704: iload 4
    //   706: istore 5
    //   708: aload 13
    //   710: invokeinterface 102 1 0
    //   715: ifle +149 -> 864
    //   718: iconst_0
    //   719: istore_3
    //   720: aload 12
    //   722: astore_1
    //   723: iload 4
    //   725: istore 5
    //   727: iload_3
    //   728: aload 13
    //   730: invokeinterface 102 1 0
    //   735: if_icmpge +129 -> 864
    //   738: aload 12
    //   740: astore_1
    //   741: iload 4
    //   743: istore 5
    //   745: new 380	com/tencent/mobileqq/transfile/ServerAddr
    //   748: dup
    //   749: invokespecial 381	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   752: astore 16
    //   754: aload 12
    //   756: astore_1
    //   757: iload 4
    //   759: istore 5
    //   761: aload 16
    //   763: aload 13
    //   765: iload_3
    //   766: invokeinterface 106 2 0
    //   771: checkcast 85	com/tencent/mobileqq/pb/ByteStringMicro
    //   774: invokevirtual 334	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   777: invokestatic 410	java/net/Inet6Address:getByAddress	([B)Ljava/net/InetAddress;
    //   780: invokevirtual 415	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   783: putfield 392	com/tencent/mobileqq/transfile/ServerAddr:mIp	Ljava/lang/String;
    //   786: aload 12
    //   788: astore_1
    //   789: iload 4
    //   791: istore 5
    //   793: aload 16
    //   795: aload 15
    //   797: iload_3
    //   798: invokeinterface 106 2 0
    //   803: checkcast 375	java/lang/Integer
    //   806: invokevirtual 378	java/lang/Integer:intValue	()I
    //   809: i2l
    //   810: l2i
    //   811: putfield 393	com/tencent/mobileqq/transfile/ServerAddr:port	I
    //   814: aload 12
    //   816: astore_1
    //   817: iload 4
    //   819: istore 5
    //   821: aload 16
    //   823: iconst_1
    //   824: putfield 419	com/tencent/mobileqq/transfile/ServerAddr:isIpv6	Z
    //   827: aload 12
    //   829: astore_1
    //   830: iload 4
    //   832: istore 5
    //   834: aload 14
    //   836: getfield 422	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$MultiMsgDownResp:mIpv6List	Ljava/util/ArrayList;
    //   839: iload_3
    //   840: aload 16
    //   842: invokevirtual 398	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   845: iload_3
    //   846: iconst_1
    //   847: iadd
    //   848: istore_3
    //   849: goto -129 -> 720
    //   852: astore 12
    //   854: aload 14
    //   856: astore 13
    //   858: iload 5
    //   860: istore_3
    //   861: goto +287 -> 1148
    //   864: aload 12
    //   866: astore_1
    //   867: iload 4
    //   869: istore_3
    //   870: aload_0
    //   871: iconst_0
    //   872: iconst_0
    //   873: ldc_w 288
    //   876: ldc_w 288
    //   879: aload 20
    //   881: aload 14
    //   883: invokevirtual 425	com/tencent/mobileqq/transfile/protohandler/MultiMsgDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   886: aload 12
    //   888: astore_1
    //   889: iload 4
    //   891: istore_3
    //   892: goto +430 -> 1322
    //   895: new 257	java/lang/Exception
    //   898: dup
    //   899: ldc_w 427
    //   902: invokespecial 428	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   905: athrow
    //   906: new 257	java/lang/Exception
    //   909: dup
    //   910: ldc_w 430
    //   913: invokespecial 428	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   916: athrow
    //   917: new 257	java/lang/Exception
    //   920: dup
    //   921: ldc_w 432
    //   924: invokespecial 428	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   927: athrow
    //   928: new 257	java/lang/Exception
    //   931: dup
    //   932: ldc_w 434
    //   935: invokespecial 428	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   938: athrow
    //   939: new 257	java/lang/Exception
    //   942: dup
    //   943: ldc_w 436
    //   946: invokespecial 428	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   949: athrow
    //   950: new 257	java/lang/Exception
    //   953: dup
    //   954: ldc_w 438
    //   957: invokespecial 428	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   960: athrow
    //   961: new 257	java/lang/Exception
    //   964: dup
    //   965: ldc_w 440
    //   968: invokespecial 428	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   971: athrow
    //   972: iload_3
    //   973: istore 4
    //   975: aload_1
    //   976: astore 12
    //   978: iload 5
    //   980: sipush 196
    //   983: if_icmpne +43 -> 1026
    //   986: aload 12
    //   988: astore_1
    //   989: iload 4
    //   991: istore_3
    //   992: aconst_null
    //   993: ldc_w 442
    //   996: ldc_w 288
    //   999: ldc_w 288
    //   1002: ldc_w 444
    //   1005: ldc_w 444
    //   1008: iconst_0
    //   1009: iconst_1
    //   1010: iconst_0
    //   1011: ldc_w 288
    //   1014: ldc_w 288
    //   1017: ldc_w 288
    //   1020: ldc_w 288
    //   1023: invokestatic 450	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1026: aload 12
    //   1028: astore_1
    //   1029: iload 4
    //   1031: istore_3
    //   1032: aload_0
    //   1033: iload 5
    //   1035: invokevirtual 454	com/tencent/mobileqq/transfile/protohandler/MultiMsgDownHandler:shouldRetryByRetCodeForGroup	(I)Z
    //   1038: ifeq +51 -> 1089
    //   1041: aload 12
    //   1043: astore_1
    //   1044: iload 4
    //   1046: istore_3
    //   1047: aload_0
    //   1048: aload_0
    //   1049: getfield 457	com/tencent/mobileqq/transfile/protohandler/MultiMsgDownHandler:mReqUrlCount	I
    //   1052: iconst_1
    //   1053: iadd
    //   1054: putfield 457	com/tencent/mobileqq/transfile/protohandler/MultiMsgDownHandler:mReqUrlCount	I
    //   1057: aload 12
    //   1059: astore_1
    //   1060: iload 4
    //   1062: istore_3
    //   1063: aload_0
    //   1064: getfield 457	com/tencent/mobileqq/transfile/protohandler/MultiMsgDownHandler:mReqUrlCount	I
    //   1067: iconst_2
    //   1068: if_icmpge +21 -> 1089
    //   1071: aload 12
    //   1073: astore_1
    //   1074: iload 4
    //   1076: istore_3
    //   1077: aload 18
    //   1079: getfield 461	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:protoReqMgr	Lcom/tencent/mobileqq/transfile/api/IProtoReqManager;
    //   1082: aload_2
    //   1083: invokeinterface 467 2 0
    //   1088: return
    //   1089: aload 12
    //   1091: astore_1
    //   1092: iload 4
    //   1094: istore_3
    //   1095: aload_0
    //   1096: iconst_m1
    //   1097: sipush -9527
    //   1100: iload 5
    //   1102: i2l
    //   1103: invokestatic 472	com/tencent/mobileqq/transfile/report/ProcessorReport:getUrlReason	(J)Ljava/lang/String;
    //   1106: ldc_w 288
    //   1109: aload 20
    //   1111: aload 14
    //   1113: invokevirtual 425	com/tencent/mobileqq/transfile/protohandler/MultiMsgDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   1116: aload 12
    //   1118: astore_1
    //   1119: iload 4
    //   1121: istore_3
    //   1122: goto +200 -> 1322
    //   1125: astore 13
    //   1127: goto +5 -> 1132
    //   1130: astore 13
    //   1132: aload 13
    //   1134: astore 12
    //   1136: aload 14
    //   1138: astore 13
    //   1140: goto +8 -> 1148
    //   1143: astore 12
    //   1145: aconst_null
    //   1146: astore 13
    //   1148: ldc_w 474
    //   1151: ldc2_w 475
    //   1154: invokestatic 480	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   1157: astore 14
    //   1159: new 482	java/lang/StringBuilder
    //   1162: dup
    //   1163: invokespecial 483	java/lang/StringBuilder:<init>	()V
    //   1166: astore 15
    //   1168: aload 15
    //   1170: aload 12
    //   1172: invokevirtual 486	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1175: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: pop
    //   1179: aload 15
    //   1181: ldc_w 492
    //   1184: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: pop
    //   1188: aload 15
    //   1190: aload 17
    //   1192: invokestatic 498	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   1195: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: pop
    //   1199: aload_0
    //   1200: iconst_m1
    //   1201: sipush -9527
    //   1204: aload 14
    //   1206: aload 15
    //   1208: invokevirtual 501	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1211: aload 20
    //   1213: aload 13
    //   1215: invokevirtual 425	com/tencent/mobileqq/transfile/protohandler/MultiMsgDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   1218: goto +104 -> 1322
    //   1221: new 257	java/lang/Exception
    //   1224: dup
    //   1225: ldc_w 503
    //   1228: invokespecial 428	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1231: athrow
    //   1232: astore_1
    //   1233: ldc_w 474
    //   1236: ldc2_w 475
    //   1239: invokestatic 480	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   1242: astore_2
    //   1243: new 482	java/lang/StringBuilder
    //   1246: dup
    //   1247: invokespecial 483	java/lang/StringBuilder:<init>	()V
    //   1250: astore 12
    //   1252: aload 12
    //   1254: aload_1
    //   1255: invokevirtual 486	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1258: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload 12
    //   1264: ldc_w 492
    //   1267: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: pop
    //   1271: aload 12
    //   1273: aload 17
    //   1275: invokestatic 498	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   1278: invokevirtual 490	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: pop
    //   1282: aload_0
    //   1283: iconst_m1
    //   1284: sipush -9527
    //   1287: aload_2
    //   1288: aload 12
    //   1290: invokevirtual 501	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1293: aload 20
    //   1295: aload 19
    //   1297: getfield 241	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   1300: invokevirtual 292	com/tencent/mobileqq/transfile/protohandler/MultiMsgDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   1303: aload 18
    //   1305: aload 19
    //   1307: invokestatic 509	com/tencent/mobileqq/transfile/protohandler/RichProtoProc:onBusiProtoResp	(Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp;)V
    //   1310: return
    //   1311: astore 13
    //   1313: aload 12
    //   1315: astore_1
    //   1316: iload 4
    //   1318: istore_3
    //   1319: goto -187 -> 1132
    //   1322: iload_3
    //   1323: iconst_1
    //   1324: iadd
    //   1325: istore_3
    //   1326: goto -1166 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1329	0	this	MultiMsgDownHandler
    //   0	1329	1	paramProtoResp	com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp
    //   0	1329	2	paramProtoReq	ProtoReqManagerImpl.ProtoReq
    //   53	1273	3	i	int
    //   354	963	4	j	int
    //   206	895	5	k	int
    //   508	153	6	m	int
    //   346	3	7	bool	boolean
    //   563	50	8	l1	long
    //   587	46	10	l2	long
    //   4	824	12	localObject1	Object
    //   852	35	12	localException1	java.lang.Exception
    //   976	159	12	localObject2	Object
    //   1143	28	12	localException2	java.lang.Exception
    //   1250	64	12	localStringBuilder	java.lang.StringBuilder
    //   240	617	13	localObject3	Object
    //   1125	1	13	localException3	java.lang.Exception
    //   1130	3	13	localException4	java.lang.Exception
    //   1138	76	13	localObject4	Object
    //   1311	1	13	localException5	java.lang.Exception
    //   196	1009	14	localObject5	Object
    //   290	8	15	arrayOfByte1	byte[]
    //   385	39	15	localException6	java.lang.Exception
    //   453	754	15	localObject6	Object
    //   325	516	16	localObject7	Object
    //   13	1261	17	arrayOfByte2	byte[]
    //   22	1282	18	localRichProtoReq	RichProto.RichProtoReq
    //   29	1277	19	localRichProtoResp	RichProto.RichProtoResp
    //   35	1259	20	localStatictisInfo	com.tencent.mobileqq.app.StatictisInfo
    //   180	507	21	localMultiMsgApplyDownRsp	tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyDownRsp
    // Exception table:
    //   from	to	target	type
    //   359	378	385	java/lang/Exception
    //   497	507	385	java/lang/Exception
    //   522	534	385	java/lang/Exception
    //   540	557	385	java/lang/Exception
    //   571	589	852	java/lang/Exception
    //   595	604	852	java/lang/Exception
    //   610	624	852	java/lang/Exception
    //   630	638	852	java/lang/Exception
    //   644	656	852	java/lang/Exception
    //   708	718	852	java/lang/Exception
    //   727	738	852	java/lang/Exception
    //   745	754	852	java/lang/Exception
    //   761	786	852	java/lang/Exception
    //   793	814	852	java/lang/Exception
    //   821	827	852	java/lang/Exception
    //   834	845	852	java/lang/Exception
    //   870	886	1125	java/lang/Exception
    //   895	906	1125	java/lang/Exception
    //   906	917	1125	java/lang/Exception
    //   917	928	1125	java/lang/Exception
    //   928	939	1125	java/lang/Exception
    //   939	950	1125	java/lang/Exception
    //   950	961	1125	java/lang/Exception
    //   961	972	1125	java/lang/Exception
    //   992	1026	1125	java/lang/Exception
    //   1032	1041	1125	java/lang/Exception
    //   1047	1057	1125	java/lang/Exception
    //   1063	1071	1125	java/lang/Exception
    //   1077	1088	1125	java/lang/Exception
    //   1095	1116	1125	java/lang/Exception
    //   198	208	1130	java/lang/Exception
    //   213	234	1130	java/lang/Exception
    //   245	252	1130	java/lang/Exception
    //   257	292	1130	java/lang/Exception
    //   297	327	1130	java/lang/Exception
    //   332	348	1130	java/lang/Exception
    //   407	455	1130	java/lang/Exception
    //   460	469	1130	java/lang/Exception
    //   182	198	1143	java/lang/Exception
    //   123	145	1232	java/lang/Exception
    //   149	158	1232	java/lang/Exception
    //   160	182	1232	java/lang/Exception
    //   1148	1218	1232	java/lang/Exception
    //   1221	1232	1232	java/lang/Exception
    //   676	696	1311	java/lang/Exception
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "MultiMsg.ApplyDown";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.MultiMsgDownHandler
 * JD-Core Version:    0.7.0.1
 */