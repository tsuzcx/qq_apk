package com.tencent.mobileqq.dating;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.nearby.now.nearby_now_anchor.AnchorStatus;
import tencent.nearby.now.nearby_now_anchor.RspBatchGetAnchorStatus;

public abstract class MsgBoxProtocol$ReqNowStateObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public abstract void a(boolean paramBoolean, List<nearby_now_anchor.AnchorStatus> paramList, Bundle paramBundle);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject = null;
    boolean bool2;
    if (paramInt == 0)
    {
      nearby_now_anchor.RspBatchGetAnchorStatus localRspBatchGetAnchorStatus = new nearby_now_anchor.RspBatchGetAnchorStatus();
      boolean bool1 = bool3;
      try
      {
        localRspBatchGetAnchorStatus.mergeFrom(paramArrayOfByte);
        bool1 = bool3;
        bool2 = bool4;
        paramArrayOfByte = localObject;
        if (!localRspBatchGetAnchorStatus.uint32_result.has()) {
          break label182;
        }
        bool1 = bool3;
        bool2 = bool4;
        paramArrayOfByte = localObject;
        if (localRspBatchGetAnchorStatus.uint32_result.get() != 0) {
          break label182;
        }
        bool2 = true;
        bool1 = true;
        paramArrayOfByte = localRspBatchGetAnchorStatus.msg_anchor_stats.get();
      }
      catch (Exception localException)
      {
        bool2 = bool1;
        paramArrayOfByte = localObject;
        if (!QLog.isColorLevel()) {
          break label182;
        }
      }
      QLog.w("Q.msg_box.protocol", 2, localException.toString());
      bool2 = bool1;
      paramArrayOfByte = localObject;
    }
    else
    {
      bool2 = bool4;
      paramArrayOfByte = localObject;
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("getNowState failed, errorCode=");
        paramArrayOfByte.append(paramInt);
        QLog.w("Q.msg_box.protocol", 2, paramArrayOfByte.toString());
        paramArrayOfByte = localObject;
        bool2 = bool4;
      }
    }
    label182:
    a(bool2, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxProtocol.ReqNowStateObserver
 * JD-Core Version:    0.7.0.1
 */