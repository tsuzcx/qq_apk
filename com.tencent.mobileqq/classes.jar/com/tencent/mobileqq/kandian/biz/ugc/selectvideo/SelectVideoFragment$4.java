package com.tencent.mobileqq.kandian.biz.ugc.selectvideo;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.AppProtocolObserver;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.JudgeUserStatusRsp;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.RspBody;

class SelectVideoFragment$4
  extends ProtoUtils.AppProtocolObserver
{
  SelectVideoFragment$4(SelectVideoFragment paramSelectVideoFragment, AppRuntime paramAppRuntime) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      paramBundle = new oidb_0xe2a.RspBody();
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (paramBundle.msg_judge_user_status_rsp.user_status.get() != 1) {
          break label129;
        }
        bool = true;
        ReadInJoyHelper.p(this.b, bool);
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("user publish status is ");
        paramArrayOfByte.append(bool);
        QLog.i("RIJUGC.SelectVideoFragment", 1, paramArrayOfByte.toString());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.e("RIJUGC.SelectVideoFragment", 1, paramArrayOfByte, new Object[0]);
        return;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("errorCode is ");
      paramArrayOfByte.append(paramInt);
      QLog.e("RIJUGC.SelectVideoFragment", 1, paramArrayOfByte.toString());
      return;
      label129:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectvideo.SelectVideoFragment.4
 * JD-Core Version:    0.7.0.1
 */