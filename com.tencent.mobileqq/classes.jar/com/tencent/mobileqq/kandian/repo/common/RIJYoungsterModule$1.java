package com.tencent.mobileqq.kandian.repo.common;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.GetFlagInfoRsp;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.RspBody;
import tencent.kandian.flaginfo.flag_info.FlagInfo;

final class RIJYoungsterModule$1
  extends ProtoUtils.TroopProtocolObserver
{
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {
      if (paramArrayOfByte == null) {
        return;
      }
    }
    try
    {
      paramBundle = new oidb_0xe1b.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      if ((!paramBundle.msg_get_flag_info_rsp.has()) || (!paramBundle.msg_get_flag_info_rsp.rpt_msg_flag_info_list.has())) {
        break label172;
      }
      paramArrayOfByte = ((oidb_0xe1b.GetFlagInfoRsp)paramBundle.msg_get_flag_info_rsp.get()).rpt_msg_flag_info_list.get();
      int j = 0;
      int i = 0;
      paramInt = j;
      if (paramArrayOfByte != null)
      {
        paramInt = j;
        if (!paramArrayOfByte.isEmpty())
        {
          paramInt = 0;
          while (i < paramArrayOfByte.size())
          {
            paramBundle = (flag_info.FlagInfo)paramArrayOfByte.get(i);
            if (paramBundle != null) {
              paramInt = paramBundle.uint32_teenager_flag.get();
            }
            i += 1;
          }
        }
      }
      if (paramInt == 0)
      {
        RIJSPUtils.a("key_sp_is_readinjoy_youngster", Integer.valueOf(2));
        return;
      }
      RIJSPUtils.a("key_sp_is_readinjoy_youngster", Integer.valueOf(1));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      label158:
      label172:
      break label158;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "updateSelfYoungsterModeSetting failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.RIJYoungsterModule.1
 * JD-Core Version:    0.7.0.1
 */