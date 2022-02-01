package com.tencent.mobileqq.service.message.api.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateUpdateMsgInfoUtil;
import java.util.Map;
import tencent.im.oidb.cmd0x6ef.oidb_cmd0x6ef.RspBody;

class BaseMessageProcessorForTroopAndDiscServiceImpl$1
  extends ProtoUtils.TroopProtocolObserver
{
  BaseMessageProcessorForTroopAndDiscServiceImpl$1(BaseMessageProcessorForTroopAndDiscServiceImpl paramBaseMessageProcessorForTroopAndDiscServiceImpl, boolean paramBoolean, MessageInfo paramMessageInfo, long paramLong1, long paramLong2, RecentUser paramRecentUser, String paramString, MessageRecord paramMessageRecord, Map paramMap)
  {
    super(paramBoolean);
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0)
    {
      if (paramArrayOfByte == null) {
        return;
      }
      try
      {
        paramBundle = new oidb_cmd0x6ef.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if ((paramBundle.is_create.get() == 1) || (paramBundle.is_join.get() == 1))
        {
          this.a.c.a(21, this.b, this.c);
          if (21 >= this.d.msgType)
          {
            this.d.msgType = 21;
            this.d.msg = TroopAioMsgNavigateUpdateMsgInfoUtil.a(BaseMessageProcessorForTroopAndDiscServiceImpl.access$000(this.h), this.e, this.a, this.d.msg, this.f, true);
            this.g.put(UinTypeUtil.a(this.e, 1), this.d);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.api.impl.BaseMessageProcessorForTroopAndDiscServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */