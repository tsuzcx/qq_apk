package com.tencent.mobileqq.writetogether.api.impl;

import android.os.Bundle;
import com.google.gson.Gson;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.writetogether.WriteTogetherOidbObserver;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.api.IWriteTogetherOidbHandler;
import com.tencent.mobileqq.writetogether.data.CreateDocParam;
import com.tencent.mobileqq.writetogether.data.GetChangesetsReq;
import com.tencent.mobileqq.writetogether.data.GetChangesetsResp;
import com.tencent.mobileqq.writetogether.data.OpenDocParam;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.Atext;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.ReqBody;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.ReqCreatePad;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.ReqGetChangeList;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.ReqGetDocContent;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.RspBody;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.RspCreatePad;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.RspGetChangeList;
import tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.RspGetDocContent;
import tencent.im.oidb.cmd0xe94.oidb_cmd0xe94.ReqBody;
import tencent.im.oidb.cmd0xe94.oidb_cmd0xe94.RspBody;
import tencent.im.oidb.cmd0xe95.oidb_0xe95.BaseInfo;
import tencent.im.oidb.cmd0xe95.oidb_0xe95.ReqBody;
import tencent.im.oidb.cmd0xe95.oidb_0xe95.RspBody;
import tencent.im.oidb.cmd0xe95.oidb_0xe95.SendWriteTogetherMsgReq;
import tencent.im.oidb.cmd0xe95.oidb_0xe95.SendWriteTogetherMsgRsp;

public class WriteTogetherOidbHandlerImpl
  extends BusinessHandler
  implements IWriteTogetherOidbHandler
{
  public static final String CLASS_NAME = "com.tencent.mobileqq.writetogether.api.impl.WriteTogetherOidbHandlerImpl";
  private static final String TAG = "WriteTogetherOidbHandler";
  
  public WriteTogetherOidbHandlerImpl(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private ToServiceMsg buildCreateOpenPullMsg(oidb_cmd0xe89.ReqBody paramReqBody, int paramInt, String paramString)
  {
    return makeOIDBPkg(paramString, 3721, paramInt, paramReqBody.toByteArray());
  }
  
  private ToServiceMsg buildSendReqMsg(oidb_0xe95.ReqBody paramReqBody)
  {
    return makeOIDBPkg("OidbSvc.0xe95", 3733, 1, paramReqBody.toByteArray());
  }
  
  private void fillCreateReqBody(oidb_cmd0xe89.ReqBody paramReqBody, CreateDocParam paramCreateDocParam, String paramString)
  {
    long l;
    try
    {
      l = Long.parseLong(this.appRuntime.getAccount());
    }
    catch (Exception localException)
    {
      QLog.e("WriteTogetherOidbHandler", 1, "parse long err, cause protocol does not support string uin", localException);
      l = 10000L;
    }
    if (l == 10000L) {
      return;
    }
    oidb_cmd0xe89.ReqCreatePad localReqCreatePad = new oidb_cmd0xe89.ReqCreatePad();
    localReqCreatePad.uint64_uin.set(l);
    localReqCreatePad.uint32_doc_type.set(0);
    localReqCreatePad.uint32_src_type.set(0);
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0xe89.Atext localAtext = new oidb_cmd0xe89.Atext();
    localAtext.bytes_text.set(ByteStringMicro.copyFrom(paramCreateDocParam.e.getBytes()));
    localAtext.bytes_attribs.set(ByteStringMicro.copyFrom(paramCreateDocParam.f.getBytes()));
    localAtext.bytes_apool.set(ByteStringMicro.copyFrom(paramCreateDocParam.d.getBytes()));
    localArrayList.add(localAtext);
    localReqCreatePad.msg_atext.set(localArrayList);
    paramReqBody.create_pad_req_info.set(localReqCreatePad);
    try
    {
      l = Long.parseLong(paramString);
      paramReqBody.uint64_group_code.set(l);
      return;
    }
    catch (Exception paramReqBody)
    {
      label196:
      break label196;
    }
    QLog.e("WriteTogetherOidbHandler", 1, "cause protocol limit, group id can only be number");
  }
  
  private void fillOpenReqBody(oidb_cmd0xe89.ReqBody paramReqBody, String paramString1, String paramString2)
  {
    oidb_cmd0xe89.ReqGetDocContent localReqGetDocContent = new oidb_cmd0xe89.ReqGetDocContent();
    localReqGetDocContent.bytes_global_padid.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
    paramReqBody.get_pad_content_req_info.set(localReqGetDocContent);
    try
    {
      paramReqBody.uint64_group_code.set(Long.parseLong(paramString2));
      return;
    }
    catch (Exception paramReqBody)
    {
      label45:
      break label45;
    }
    QLog.e("WriteTogetherOidbHandler", 1, "cause protocol limit, group id can only be number");
  }
  
  private void fillSendReqBodyForCreateAndOpenDoc(oidb_0xe95.ReqBody paramReqBody, String paramString1, String paramString2)
  {
    oidb_0xe95.SendWriteTogetherMsgReq localSendWriteTogetherMsgReq = new oidb_0xe95.SendWriteTogetherMsgReq();
    localSendWriteTogetherMsgReq.bytes_global_padid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    paramReqBody.msg_send_write_together_msg_req.set(localSendWriteTogetherMsgReq);
    paramString2 = new oidb_0xe95.BaseInfo();
    paramString2.uint64_group_code.set(Long.valueOf(paramString1).longValue());
    paramReqBody.msg_base_info.set(paramString2);
  }
  
  private void fillSendReqBodyForForwardDoc(oidb_0xe95.ReqBody paramReqBody, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    oidb_0xe95.SendWriteTogetherMsgReq localSendWriteTogetherMsgReq = new oidb_0xe95.SendWriteTogetherMsgReq();
    localSendWriteTogetherMsgReq.bytes_global_padid.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    localSendWriteTogetherMsgReq.uint32_get_rev.set(paramInt);
    localSendWriteTogetherMsgReq.bytes_token.set(ByteStringMicro.copyFrom(paramString3.getBytes()));
    paramReqBody.msg_send_write_together_msg_req.set(localSendWriteTogetherMsgReq);
    paramString2 = new oidb_0xe95.BaseInfo();
    paramString2.uint64_group_code.set(Long.valueOf(paramString1).longValue());
    paramReqBody.msg_base_info.set(paramString2);
  }
  
  private void handlePullDoc(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xe89.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handlePullDoc result: ");
    paramFromServiceMsg.append(i);
    QLog.d("WriteTogetherOidbHandler", 1, paramFromServiceMsg.toString());
    if ((i == 0) && (paramToServiceMsg.rsp_get_change_list_info.has()))
    {
      paramToServiceMsg = ((oidb_cmd0xe89.RspGetChangeList)paramToServiceMsg.rsp_get_change_list_info.get()).bytes_rsp_json_buf.get().toStringUtf8();
      notifyUI(3, true, (GetChangesetsResp)new Gson().fromJson(paramToServiceMsg, GetChangesetsResp.class));
      return;
    }
    notifyUI(3, false, null);
  }
  
  private void handleSendGrayTipResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xe94.RspBody localRspBody = new oidb_cmd0xe94.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("[handleSendGrayTipResp] result: ");
      paramObject.append(i);
      paramObject.append(", ret: ");
      boolean bool = localRspBody.uint32Return.has();
      paramFromServiceMsg = null;
      if (bool) {
        paramToServiceMsg = Integer.valueOf(localRspBody.uint32Return.get());
      } else {
        paramToServiceMsg = null;
      }
      paramObject.append(paramToServiceMsg);
      paramObject.append(", error: ");
      paramToServiceMsg = paramFromServiceMsg;
      if (localRspBody.stringError.has()) {
        paramToServiceMsg = localRspBody.stringError.get();
      }
      paramObject.append(paramToServiceMsg);
      QLog.d("WriteTogetherOidbHandler", 2, paramObject.toString());
    }
  }
  
  private void handleSendMsgResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xe95.RspBody localRspBody = new oidb_0xe95.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("[handleSendMsgResp] result: ");
      paramFromServiceMsg.append(i);
      QLog.d("WriteTogetherOidbHandler", 2, paramFromServiceMsg.toString());
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getStringArray("write_together_doc_info");
    if ((i == 0) && (localRspBody.msg_send_write_together_msg_rsp.has()))
    {
      paramFromServiceMsg = (oidb_0xe95.SendWriteTogetherMsgRsp)localRspBody.msg_send_write_together_msg_rsp.get();
      i = paramFromServiceMsg.int32_result.get();
      long l = paramFromServiceMsg.uint32_msg_seq.get();
      int j = paramFromServiceMsg.uint32_rand_num.get();
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("[handleSendMsgResp] rspCode: ");
        paramFromServiceMsg.append(i);
        QLog.d("WriteTogetherOidbHandler", 2, paramFromServiceMsg.toString());
      }
      notifyUI(4, true, new Object[] { paramToServiceMsg, Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
      return;
    }
    notifyUI(4, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  public void createDoc(CreateDocParam paramCreateDocParam, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[createDoc] send create doc, group id: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WriteTogetherOidbHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_cmd0xe89.ReqBody();
    fillCreateReqBody((oidb_cmd0xe89.ReqBody)localObject, paramCreateDocParam, paramString);
    paramCreateDocParam = buildCreateOpenPullMsg((oidb_cmd0xe89.ReqBody)localObject, 0, "OidbSvcTcp.0xe89_0");
    paramCreateDocParam.extraData.putString("write_together_group_code", paramString);
    sendPbReq(paramCreateDocParam);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return WriteTogetherOidbObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramObject != null))
    {
      if ("OidbSvcTcp.0xe89_2".equals(paramToServiceMsg.getServiceCmd()))
      {
        handlePullDoc(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe95".equals(paramToServiceMsg.getServiceCmd()))
      {
        handleSendMsgResp(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe94".equals(paramToServiceMsg.getServiceCmd()))
      {
        handleSendGrayTipResp(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      oidb_cmd0xe89.RspBody localRspBody = new oidb_cmd0xe89.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      paramObject = new StringBuilder();
      paramObject.append("[onReceive] receive oidb package result: ");
      paramObject.append(i);
      QLog.d("WriteTogetherOidbHandler", 4, paramObject.toString());
      if ("OidbSvcTcp.0xe89_0".equals(paramToServiceMsg.getServiceCmd()))
      {
        paramObject = new CreateDocParam();
        paramObject.b = i;
        if ((i == 0) && (localRspBody.create_pad_rsp_info.has()))
        {
          paramFromServiceMsg = localRspBody.create_pad_rsp_info.bytes_global_padid.get().toStringUtf8();
          paramObject.a = paramFromServiceMsg;
          notifyUI(1, true, paramObject);
          sendWtMessage(paramFromServiceMsg, "", 0, paramToServiceMsg.extraData.getString("write_together_group_code"));
          return;
        }
        paramObject.c = paramFromServiceMsg.extraData.getString("str_error_msg");
        notifyUI(1, false, paramObject);
        return;
      }
      if ("OidbSvcTcp.0xe89_1".equals(paramToServiceMsg.getServiceCmd()))
      {
        if ((i == 0) && (localRspBody.get_pad_content_rsp_info.has()))
        {
          notifyUI(2, true, WriteTogetherUtils.a((oidb_cmd0xe89.RspGetDocContent)localRspBody.get_pad_content_rsp_info.get()));
          return;
        }
        paramFromServiceMsg = paramToServiceMsg.extraData.getString("write_together_group_code");
        paramToServiceMsg = paramToServiceMsg.extraData.getString("write_together_pad_id");
        paramObject = new OpenDocParam();
        paramObject.u = paramFromServiceMsg;
        paramObject.f = paramToServiceMsg;
        paramObject.w = i;
        notifyUI(2, false, paramObject);
      }
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("[onReceive] params: res: ");
    paramToServiceMsg.append(paramFromServiceMsg);
    paramToServiceMsg.append(". data: ");
    paramToServiceMsg.append(paramObject);
    QLog.e("WriteTogetherOidbHandler", 1, paramToServiceMsg.toString());
  }
  
  public void openDoc(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[openDoc] send open doc: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", group id: ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("WriteTogetherOidbHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_cmd0xe89.ReqBody();
    fillOpenReqBody((oidb_cmd0xe89.ReqBody)localObject, paramString1, paramString2);
    localObject = buildCreateOpenPullMsg((oidb_cmd0xe89.ReqBody)localObject, 1, "OidbSvcTcp.0xe89_1");
    ((ToServiceMsg)localObject).extraData.putString("write_together_group_code", paramString2);
    ((ToServiceMsg)localObject).extraData.putString("write_together_pad_id", paramString1);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void pullDoc(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send pull doc: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", from: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", to: ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("WriteTogetherOidbHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_cmd0xe89.ReqBody();
    paramString2 = new GetChangesetsReq(paramString2, paramInt1, paramInt2);
    Gson localGson = new Gson();
    try
    {
      ((oidb_cmd0xe89.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString1));
      paramString1 = localGson.toJson(paramString2);
      paramString2 = new oidb_cmd0xe89.ReqGetChangeList();
      paramString2.bytes_req_json_buf.set(ByteStringMicro.copyFrom(paramString1, "utf-8"));
      ((oidb_cmd0xe89.ReqBody)localObject).req_get_change_list_info.set(paramString2);
      sendPbReq(buildCreateOpenPullMsg((oidb_cmd0xe89.ReqBody)localObject, 2, "OidbSvcTcp.0xe89_2"));
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("WriteTogetherOidbHandler", 1, paramString1, new Object[0]);
    }
  }
  
  public void sendForwardWtMessage(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    oidb_0xe95.ReqBody localReqBody = new oidb_0xe95.ReqBody();
    fillSendReqBodyForForwardDoc(localReqBody, paramString3, paramString1, paramInt, paramString2);
    paramString3 = buildSendReqMsg(localReqBody);
    paramString3.extraData.putStringArray("write_together_doc_info", new String[] { paramString1, paramString2, String.valueOf(paramInt) });
    sendPbReq(paramString3);
  }
  
  public void sendGrayTip(String paramString1, String paramString2, String paramString3)
  {
    oidb_cmd0xe94.ReqBody localReqBody = new oidb_cmd0xe94.ReqBody();
    try
    {
      localReqBody.uint64Uid.set(Long.parseLong(paramString1));
      localReqBody.uint64GroupCode.set(Long.parseLong(paramString2));
      localReqBody.bytesDocid.set(ByteStringMicro.copyFromUtf8(paramString3));
      sendPbReq(makeOIDBPkg("OidbSvc.0xe94", 3732, 0, localReqBody.toByteArray()));
      return;
    }
    catch (RuntimeException paramString1)
    {
      QLog.e("WriteTogetherOidbHandler", 1, paramString1, new Object[0]);
    }
  }
  
  public void sendWtMessage(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    oidb_0xe95.ReqBody localReqBody = new oidb_0xe95.ReqBody();
    fillSendReqBodyForCreateAndOpenDoc(localReqBody, paramString3, paramString1);
    paramString3 = buildSendReqMsg(localReqBody);
    paramString3.extraData.putStringArray("write_together_doc_info", new String[] { paramString1, paramString2, String.valueOf(paramInt) });
    sendPbReq(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.api.impl.WriteTogetherOidbHandlerImpl
 * JD-Core Version:    0.7.0.1
 */