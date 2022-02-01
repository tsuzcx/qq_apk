package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.AppConstants.RichMediaErrorCode;
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
    int i = 3;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          break label34;
        }
        if (paramInt == 4) {}
      }
      else
      {
        i = 6;
        break label37;
      }
      i = 8;
      break label37;
      label34:
      i = 7;
    }
    label37:
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
  }
  
  public static String getTimeoutReasonForRichMedia(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() == 1013) {
        return String.valueOf(1013);
      }
      if (paramFromServiceMsg.getResultCode() == 1002)
      {
        String str = (String)paramFromServiceMsg.getAttribute("_tag_socket_connerror", "timeout_reason_UNKNOWN");
        paramFromServiceMsg = str;
        if (str.equals("conSucc")) {
          paramFromServiceMsg = "timeout_reason_SERVER_NO_RESPONSE";
        }
        return paramFromServiceMsg;
      }
    }
    return null;
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
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    StatictisInfo localStatictisInfo = paramProtoResp.statisInfo;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      paramProtoResp = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((!paramProtoResp.equals("conSucc")) && (!paramProtoResp.equals("")))
      {
        setResult(-1, 9313, paramProtoResp, localFromServiceMsg.getBusinessFailMsg(), localStatictisInfo, localRichProtoResp.resps);
      }
      else
      {
        int i = localFromServiceMsg.getResultCode();
        if ((i != 1002) && (i != 1013))
        {
          paramProtoResp = localFromServiceMsg.getBusinessFailMsg();
          if (paramProtoResp == null) {
            paramProtoResp = "";
          }
          setResult(-1, 9044, String.valueOf(i), paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
        }
        else
        {
          paramProtoReq = getTimeoutReasonForRichMedia(localFromServiceMsg);
          paramProtoResp = localFromServiceMsg.getBusinessFailMsg();
          if (paramProtoResp == null) {
            paramProtoResp = "";
          }
          setResult(-1, 9311, paramProtoReq, paramProtoResp, localStatictisInfo, localRichProtoResp.resps);
        }
      }
    }
    else
    {
      handleSucResp(localFromServiceMsg, arrayOfByte, localRichProtoReq, localRichProtoResp, localStatictisInfo, paramProtoResp, paramProtoReq);
    }
    RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
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
    paramStatictisInfo = new StringBuilder();
    paramStatictisInfo.append("result:");
    paramStatictisInfo.append(paramInt1);
    paramStatictisInfo.append(" errCode:");
    paramStatictisInfo.append(paramInt2);
    paramStatictisInfo.append(" reason:");
    paramStatictisInfo.append(paramString1);
    paramStatictisInfo.append(" errStr:");
    paramStatictisInfo.append(paramString2);
    QLog.d("Q.richmedia.BaseHandler", 1, paramStatictisInfo.toString());
  }
  
  public void setResult(int paramInt1, int paramInt2, String paramString1, String paramString2, StatictisInfo paramStatictisInfo, List<RichProto.RichProtoResp.RespCommon> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      setResult(paramInt1, paramInt2, paramString1, paramString2, paramStatictisInfo, (RichProto.RichProtoResp.RespCommon)paramList.next());
    }
  }
  
  public boolean shouldRetryByRetCodeForGroup(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.BaseHandler
 * JD-Core Version:    0.7.0.1
 */