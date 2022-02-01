package com.tencent.mobileqq.troop.troopcard.ui;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import java.util.List;
import tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6.GbarInfo;
import tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6.RspBody;
import tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6.RspInfo;

class TroopInfoActivity$31
  extends ProtoUtils.TroopProtocolObserver
{
  TroopInfoActivity$31(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {
      if (paramArrayOfByte == null) {
        return;
      }
    }
    try
    {
      paramBundle = new oidb_cmd0x6f6.RspBody();
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = paramBundle.rpt_msg_rsp_info.get();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
      {
        paramArrayOfByte = (oidb_cmd0x6f6.RspInfo)paramArrayOfByte.get(0);
        if ((paramArrayOfByte != null) && (paramArrayOfByte.uint32_result.get() == 0))
        {
          this.a.f.tribeId = paramArrayOfByte.stgbarinfo.uint32_bid.get();
          this.a.B = this.a.f.tribeId;
          this.a.f.tribeName = paramArrayOfByte.stgbarinfo.str_name.get().toStringUtf8();
          this.a.J.sendEmptyMessage(7);
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.31
 * JD-Core Version:    0.7.0.1
 */