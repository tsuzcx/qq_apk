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
  public static final String CLASS_NAME = WriteTogetherOidbHandlerImpl.class.getName();
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
    try
    {
      l = Long.parseLong(this.appRuntime.getAccount());
      if (l == 10000L) {
        return;
      }
    }
    catch (Exception localException)
    {
      long l;
      for (;;)
      {
        QLog.e("WriteTogetherOidbHandler", 1, "parse long err, cause protocol does not support string uin", localException);
        l = 10000L;
      }
      oidb_cmd0xe89.ReqCreatePad localReqCreatePad = new oidb_cmd0xe89.ReqCreatePad();
      localReqCreatePad.uint64_uin.set(l);
      localReqCreatePad.uint32_doc_type.set(0);
      localReqCreatePad.uint32_src_type.set(0);
      ArrayList localArrayList = new ArrayList();
      oidb_cmd0xe89.Atext localAtext = new oidb_cmd0xe89.Atext();
      localAtext.bytes_text.set(ByteStringMicro.copyFrom(paramCreateDocParam.d.getBytes()));
      localAtext.bytes_attribs.set(ByteStringMicro.copyFrom(paramCreateDocParam.e.getBytes()));
      localAtext.bytes_apool.set(ByteStringMicro.copyFrom(paramCreateDocParam.c.getBytes()));
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
        QLog.e("WriteTogetherOidbHandler", 1, "cause protocol limit, group id can only be number");
      }
    }
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
      QLog.e("WriteTogetherOidbHandler", 1, "cause protocol limit, group id can only be number");
    }
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
    QLog.d("WriteTogetherOidbHandler", 1, "handlePullDoc result: " + i);
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
    Object localObject = null;
    oidb_cmd0xe94.RspBody localRspBody = new oidb_cmd0xe94.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder().append("[handleSendGrayTipResp] result: ").append(i).append(", ret: ");
      if (!localRspBody.uint32Return.has()) {
        break label125;
      }
    }
    label125:
    for (paramToServiceMsg = Integer.valueOf(localRspBody.uint32Return.get());; paramToServiceMsg = null)
    {
      paramFromServiceMsg = paramFromServiceMsg.append(paramToServiceMsg).append(", error: ");
      paramToServiceMsg = localObject;
      if (localRspBody.stringError.has()) {
        paramToServiceMsg = localRspBody.stringError.get();
      }
      QLog.d("WriteTogetherOidbHandler", 2, paramToServiceMsg);
      return;
    }
  }
  
  private void handleSendMsgResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xe95.RspBody localRspBody = new oidb_0xe95.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherOidbHandler", 2, "[handleSendMsgResp] result: " + i);
    }
    paramToServiceMsg = paramToServiceMsg.extraData.getStringArray("write_together_doc_info");
    if ((i == 0) && (localRspBody.msg_send_write_together_msg_rsp.has()))
    {
      paramFromServiceMsg = (oidb_0xe95.SendWriteTogetherMsgRsp)localRspBody.msg_send_write_together_msg_rsp.get();
      i = paramFromServiceMsg.int32_result.get();
      long l = paramFromServiceMsg.uint32_msg_seq.get();
      int j = paramFromServiceMsg.uint32_rand_num.get();
      if (QLog.isColorLevel()) {
        QLog.d("WriteTogetherOidbHandler", 2, "[handleSendMsgResp] rspCode: " + i);
      }
      notifyUI(4, true, new Object[] { paramToServiceMsg, Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
      return;
    }
    notifyUI(4, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0) });
  }
  
  public void createDoc(CreateDocParam paramCreateDocParam, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherOidbHandler", 2, "[createDoc] send create doc, group id: " + paramString);
    }
    oidb_cmd0xe89.ReqBody localReqBody = new oidb_cmd0xe89.ReqBody();
    fillCreateReqBody(localReqBody, paramCreateDocParam, paramString);
    paramCreateDocParam = buildCreateOpenPullMsg(localReqBody, 0, "OidbSvcTcp.0xe89_0");
    paramCreateDocParam.extraData.putString("write_together_group_code", paramString);
    sendPbReq(paramCreateDocParam);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return WriteTogetherOidbObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (paramObject == null)) {
      QLog.e("WriteTogetherOidbHandler", 1, "[onReceive] params: res: " + paramFromServiceMsg + ". data: " + paramObject);
    }
    oidb_cmd0xe89.RspBody localRspBody;
    int i;
    do
    {
      return;
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
      localRspBody = new oidb_cmd0xe89.RspBody();
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      QLog.d("WriteTogetherOidbHandler", 4, "[onReceive] receive oidb package result: " + i);
      if ("OidbSvcTcp.0xe89_0".equals(paramToServiceMsg.getServiceCmd()))
      {
        paramObject = new CreateDocParam();
        paramObject.jdField_a_of_type_Int = i;
        if ((i == 0) && (localRspBody.create_pad_rsp_info.has()))
        {
          paramFromServiceMsg = localRspBody.create_pad_rsp_info.bytes_global_padid.get().toStringUtf8();
          paramObject.jdField_a_of_type_JavaLangString = paramFromServiceMsg;
          notifyUI(1, true, paramObject);
          sendWtMessage(paramFromServiceMsg, "", 0, paramToServiceMsg.extraData.getString("write_together_group_code"));
          return;
        }
        paramObject.b = paramFromServiceMsg.extraData.getString("str_error_msg");
        notifyUI(1, false, paramObject);
        return;
      }
    } while (!"OidbSvcTcp.0xe89_1".equals(paramToServiceMsg.getServiceCmd()));
    if ((i == 0) && (localRspBody.get_pad_content_rsp_info.has()))
    {
      notifyUI(2, true, WriteTogetherUtils.a((oidb_cmd0xe89.RspGetDocContent)localRspBody.get_pad_content_rsp_info.get()));
      return;
    }
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("write_together_group_code");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("write_together_pad_id");
    paramObject = new OpenDocParam();
    paramObject.k = paramFromServiceMsg;
    paramObject.f = paramToServiceMsg;
    paramObject.h = i;
    notifyUI(2, false, paramObject);
  }
  
  public void openDoc(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherOidbHandler", 2, "[openDoc] send open doc: " + paramString1 + ", group id: " + paramString2);
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
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherOidbHandler", 2, "send pull doc: " + paramString2 + ", from: " + paramInt1 + ", to: " + paramInt2);
    }
    oidb_cmd0xe89.ReqBody localReqBody = new oidb_cmd0xe89.ReqBody();
    paramString2 = new GetChangesetsReq(paramString2, paramInt1, paramInt2);
    Gson localGson = new Gson();
    try
    {
      localReqBody.uint64_group_code.set(Long.parseLong(paramString1));
      paramString1 = localGson.toJson(paramString2);
      paramString2 = new oidb_cmd0xe89.ReqGetChangeList();
      paramString2.bytes_req_json_buf.set(ByteStringMicro.copyFrom(paramString1, "utf-8"));
      localReqBody.req_get_change_list_info.set(paramString2);
      sendPbReq(buildCreateOpenPullMsg(localReqBody, 2, "OidbSvcTcp.0xe89_2"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.api.impl.WriteTogetherOidbHandlerImpl
 * JD-Core Version:    0.7.0.1
 */