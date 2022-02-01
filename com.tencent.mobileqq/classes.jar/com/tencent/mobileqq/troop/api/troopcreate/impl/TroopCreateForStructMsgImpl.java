package com.tencent.mobileqq.troop.api.troopcreate.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateForStructMsg;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import mqq.app.AppRuntime;

public class TroopCreateForStructMsgImpl
  implements ITroopCreateForStructMsg
{
  private AbsStructMsg mStructMsg;
  
  public boolean instanceofImgaeShare()
  {
    return this.mStructMsg instanceof StructMsgForImageShare;
  }
  
  public void onDestroy()
  {
    this.mStructMsg = null;
  }
  
  public void sendStructingMsg(AppRuntime paramAppRuntime, String paramString, int paramInt, BusinessObserver paramBusinessObserver)
  {
    paramBusinessObserver = this.mStructMsg;
    if ((paramBusinessObserver != null) && ((paramAppRuntime instanceof QQAppInterface))) {
      ShareMsgHelper.a((QQAppInterface)paramAppRuntime, paramString, paramInt, paramBusinessObserver, null);
    }
  }
  
  public void setAbsStructMsgFromByte(byte[] paramArrayOfByte)
  {
    this.mStructMsg = StructMsgFactory.a(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.impl.TroopCreateForStructMsgImpl
 * JD-Core Version:    0.7.0.1
 */