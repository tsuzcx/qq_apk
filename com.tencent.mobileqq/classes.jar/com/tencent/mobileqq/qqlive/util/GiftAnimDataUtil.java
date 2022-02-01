package com.tencent.mobileqq.qqlive.util;

import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;

public class GiftAnimDataUtil
{
  public static GiftAnimData a(GiftMessage paramGiftMessage)
  {
    if (paramGiftMessage == null)
    {
      QLog.e("GiftAnimDataUtil", 1, "covert but giftMessage is null");
      return null;
    }
    GiftAnimData localGiftAnimData = new GiftAnimData();
    localGiftAnimData.a = paramGiftMessage.giftID;
    localGiftAnimData.b = paramGiftMessage.giftType;
    localGiftAnimData.c = paramGiftMessage.giftName;
    localGiftAnimData.d = paramGiftMessage.materialID;
    localGiftAnimData.e = paramGiftMessage.giftNum;
    localGiftAnimData.g = paramGiftMessage.sender;
    localGiftAnimData.h = paramGiftMessage.senderNick;
    localGiftAnimData.k = paramGiftMessage.senderHead;
    localGiftAnimData.j = paramGiftMessage.receiverNick;
    localGiftAnimData.l = paramGiftMessage.receiverHead;
    localGiftAnimData.m = paramGiftMessage.effectLevel;
    localGiftAnimData.n = paramGiftMessage.comboSeq;
    localGiftAnimData.o = paramGiftMessage.allComboCnt;
    return localGiftAnimData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.util.GiftAnimDataUtil
 * JD-Core Version:    0.7.0.1
 */