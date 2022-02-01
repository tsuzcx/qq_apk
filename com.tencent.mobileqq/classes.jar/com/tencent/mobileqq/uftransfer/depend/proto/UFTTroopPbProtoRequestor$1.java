package com.tencent.mobileqq.uftransfer.depend.proto;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.proto.UFTProtoRequestor.TroopReqUploadResponseCallback;
import com.tencent.mobileqq.uftransfer.proto.UFTTroopUploadRsp;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.RspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

class UFTTroopPbProtoRequestor$1
  extends ProtoUtils.TroopProtocolObserver
{
  UFTTroopPbProtoRequestor$1(UFTTroopPbProtoRequestor paramUFTTroopPbProtoRequestor, UFTProtoRequestor.TroopReqUploadResponseCallback paramTroopReqUploadResponseCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    String str = "";
    boolean bool = false;
    int i = -1;
    paramBundle = null;
    oidb_0x6d6.RspBody localRspBody;
    if (paramInt != 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("=_= ^! [CS Replay] troop upload response is failed[");
      paramArrayOfByte.append(paramInt);
      paramArrayOfByte.append("]");
      UFTLog.d("[UFTTransfer] UFTTrpPbProtoRequestor", 1, paramArrayOfByte.toString());
      paramInt = -100002;
      paramArrayOfByte = str;
    }
    else
    {
      localRspBody = new oidb_0x6d6.RspBody();
    }
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      if (!localRspBody.upload_file_rsp.has())
      {
        UFTLog.d("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "=_= ^! [CS Replay] troop upload response error. rspBody has not upload_file_rsp");
        paramArrayOfByte = "no upload_file_rsp";
        paramInt = i;
      }
      else
      {
        paramArrayOfByte = (oidb_0x6d6.UploadFileRspBody)localRspBody.upload_file_rsp.get();
        if (!paramArrayOfByte.int32_ret_code.has())
        {
          UFTLog.d("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "=_= ^! [CS Replay] troop upload response error. no retCode");
          paramArrayOfByte = "no upload_file_rsp retcode";
          paramInt = i;
        }
        else
        {
          paramBundle = UFTPbProtoHelper.a(paramArrayOfByte);
          paramInt = 0;
          paramArrayOfByte = str;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label159:
      break label159;
    }
    UFTLog.d("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "=_= ^! [CS Replay] troop upload response error. parse reponseContent excption");
    paramArrayOfByte = "parse pbbuf fail";
    paramInt = i;
    if (paramBundle != null)
    {
      bool = true;
    }
    else
    {
      paramBundle = new UFTTroopUploadRsp();
      paramBundle.a(paramInt);
      paramBundle.a(paramArrayOfByte);
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("[CS Replay] troop upload response. bReqSuc:");
    paramArrayOfByte.append(bool);
    paramArrayOfByte.append(" ");
    paramArrayOfByte.append(paramBundle.toString());
    UFTLog.b("[UFTTransfer] UFTTrpPbProtoRequestor", 1, paramArrayOfByte.toString());
    paramArrayOfByte = this.a;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(bool, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.proto.UFTTroopPbProtoRequestor.1
 * JD-Core Version:    0.7.0.1
 */