package com.tencent.mobileqq.qqlive.api.gift.impl;

import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.gift_trans_svr.nano.LiveGiftPushMsg;
import com.tencent.trpcprotocol.ilive.commonNotify.commonNotify.nano.ExtData;

public class QQLivePushCmdHelperImpl
  implements IQQLivePushCmdHelper
{
  private static final String TAG = "QQLiveGiftHelper";
  
  public GiftMessage covertPushDataToGiftMessage(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ExtData.a(paramArrayOfByte);
    if (paramArrayOfByte.a != paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLiveGiftHelper", 4, "get HIGH_PRIORITY_MESSAGE but not gift");
      }
      return null;
    }
    paramArrayOfByte = LiveGiftPushMsg.a(paramArrayOfByte.c);
    GiftMessage localGiftMessage = new GiftMessage();
    localGiftMessage.giftID = paramArrayOfByte.b;
    localGiftMessage.giftNum = paramArrayOfByte.d;
    localGiftMessage.giftType = paramArrayOfByte.a;
    localGiftMessage.materialID = paramArrayOfByte.g;
    localGiftMessage.sender = paramArrayOfByte.e;
    localGiftMessage.senderNick = paramArrayOfByte.f;
    localGiftMessage.effectLevel = paramArrayOfByte.h;
    localGiftMessage.giftName = paramArrayOfByte.c;
    localGiftMessage.senderHead = paramArrayOfByte.i;
    localGiftMessage.receiverNick = paramArrayOfByte.j;
    localGiftMessage.receiverHead = paramArrayOfByte.k;
    localGiftMessage.comboSeq = paramArrayOfByte.l;
    localGiftMessage.allComboCnt = paramArrayOfByte.m;
    localGiftMessage.comboOver = paramArrayOfByte.n;
    return localGiftMessage;
  }
  
  public int getGiftPushSubCmd(String paramString)
  {
    if ("1054".equals(paramString)) {}
    return 16;
  }
  
  public int getHighPriorityPushCmd(String paramString)
  {
    if ("1054".equals(paramString)) {
      return 232;
    }
    return 167;
  }
  
  public int getLowPriorityPushCmd(String paramString)
  {
    if ("1054".equals(paramString)) {
      return 233;
    }
    return 234;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.gift.impl.QQLivePushCmdHelperImpl
 * JD-Core Version:    0.7.0.1
 */