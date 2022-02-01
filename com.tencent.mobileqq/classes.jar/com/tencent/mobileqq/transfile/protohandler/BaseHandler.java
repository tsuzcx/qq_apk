package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.AppConstants.RichMediaErrorCode;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class BaseHandler
  implements AppConstants.RichMediaErrorCode, ProtoReqManagerImpl.IProtoRespBack, RichProtoProc.RichProtoHandler
{
  public static final String TAG = "Q.richmedia.BaseHandler";
  int mReqUrlCount = 0;
  
  public static int getHandlerNetType()
  {
    return getHandlerNetType(NetworkCenter.getInstance().getNetType());
  }
  
  public static int getHandlerNetType(int paramInt)
  {
    int j = 6;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      String str = NetworkCenter.getInstance().getApnType();
      paramInt = i;
      if (str != null)
      {
        paramInt = i;
        if (str.contains("wap")) {
          paramInt = 5;
        }
      }
      return paramInt;
      i = 3;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  public void cancel(RichProto.RichProtoReq paramRichProtoReq) {}
  
  protected void handleSucResp(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp, StatictisInfo paramStatictisInfo, ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq) {}
  
  abstract void initResps(RichProto.RichProtoReq paramRichProtoReq);
  
  void inner_sendToProtoReq(RichProto.RichProtoReq paramRichProtoReq, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    initResps(paramRichProtoReq);
    paramRichProtoReq.protoReq = paramProtoReq;
    if (paramRichProtoReq.protoReqMgr != null) {
      paramRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
    }
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    FromServiceMsg localFromServiceMsg = paramProtoResp.resp;
    Object localObject = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    StatictisInfo localStatictisInfo = paramProtoResp.statisInfo;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      paramProtoResp = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((paramProtoResp.equals("conSucc")) || (paramProtoResp.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.b(localFromServiceMsg);
          paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
          paramProtoResp = paramProtoReq;
          if (paramProtoReq == null) {
            paramProtoResp = "";
          }
          setResult(-1, 9311, (String)localObject, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
        }
      }
    }
    for (;;)
    {
      RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      return;
      paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      setResult(-1, 9044, String.valueOf(i), paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
      continue;
      setResult(-1, 9313, paramProtoResp, localFromServiceMsg.getBusinessFailMsg(), localStatictisInfo, localRichProtoResp.resps);
      continue;
      handleSucResp(localFromServiceMsg, (byte[])localObject, localRichProtoReq, localRichProtoResp, localStatictisInfo, paramProtoResp, paramProtoReq);
    }
  }
  
  public void setResult(int paramInt1, int paramInt2, String paramString1, String paramString2, StatictisInfo paramStatictisInfo, RichProto.RichProtoResp.RespCommon paramRespCommon)
  {
    paramRespCommon.result = paramInt1;
    paramRespCommon.errCode = paramInt2;
    paramRespCommon.reason = paramString1;
    paramRespCommon.errStr = paramString2;
    if (paramInt1 == 0)
    {
      paramRespCommon.successCount = 1;
      paramRespCommon.failCount = (paramStatictisInfo.c - 1);
      return;
    }
    paramRespCommon.successCount = 0;
    paramRespCommon.failCount = paramStatictisInfo.c;
    QLog.d("Q.richmedia.BaseHandler", 1, "result:" + paramInt1 + " errCode:" + paramInt2 + " reason:" + paramString1 + " errStr:" + paramString2);
  }
  
  public void setResult(int paramInt1, int paramInt2, String paramString1, String paramString2, StatictisInfo paramStatictisInfo, List<RichProto.RichProtoResp.RespCommon> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      setResult(paramInt1, paramInt2, paramString1, paramString2, paramStatictisInfo, (RichProto.RichProtoResp.RespCommon)paramList.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.BaseHandler
 * JD-Core Version:    0.7.0.1
 */