package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.weiyun.WeiyunCallback;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp;
import com.tencent.qphone.base.util.QLog;

class WeiYunLogicCenter$5
  implements IWeiyunCallback<WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp>
{
  WeiYunLogicCenter$5(WeiYunLogicCenter paramWeiYunLogicCenter, WeiyunCallback paramWeiyunCallback) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new StringBuilder();
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("sendWeiYun2Dataline onFailed: errcode[");
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(paramInt);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("], errmsg[");
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append(paramString);
    paramCrossBidProxyCopyFileToOtherBidMsgRsp.append("]");
    QLog.i("WeiYunLogicCenter<FileAssistant>", 1, paramCrossBidProxyCopyFileToOtherBidMsgRsp.toString());
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.a;
    if (paramCrossBidProxyCopyFileToOtherBidMsgRsp != null) {
      paramCrossBidProxyCopyFileToOtherBidMsgRsp.a(paramInt, paramString);
    }
  }
  
  public void a(WeiyunPB.CrossBidProxyCopyFileToOtherBidMsgRsp paramCrossBidProxyCopyFileToOtherBidMsgRsp)
  {
    paramCrossBidProxyCopyFileToOtherBidMsgRsp = new String(paramCrossBidProxyCopyFileToOtherBidMsgRsp.dst_path.get().toByteArray());
    if (paramCrossBidProxyCopyFileToOtherBidMsgRsp.length() < 1)
    {
      QLog.e("WeiYunLogicCenter<FileAssistant>", 1, "=_= ^! [CS Replay]sendWeiYun2Dataline onSucceed,But uuid is null!!!");
      paramCrossBidProxyCopyFileToOtherBidMsgRsp = this.a;
      if (paramCrossBidProxyCopyFileToOtherBidMsgRsp != null) {
        paramCrossBidProxyCopyFileToOtherBidMsgRsp.a(-3, "copyFileToOtherBid_fail");
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("=_= ^ [CS Replay] sendWeiYun2Dataline onSucceed, Uuid[");
    ((StringBuilder)localObject).append(paramCrossBidProxyCopyFileToOtherBidMsgRsp);
    ((StringBuilder)localObject).append("]");
    QLog.i("WeiYunLogicCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject != null) {
      ((WeiyunCallback)localObject).a(paramCrossBidProxyCopyFileToOtherBidMsgRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.5
 * JD-Core Version:    0.7.0.1
 */