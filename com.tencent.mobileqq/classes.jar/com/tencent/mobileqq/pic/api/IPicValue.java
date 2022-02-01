package com.tencent.mobileqq.pic.api;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPicValue
  extends QRouteApi
{
  public abstract void fillStickInfo(MessageForPic paramMessageForPic);
  
  public abstract int getAioOtherSpaceValue();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.IPicValue
 * JD-Core Version:    0.7.0.1
 */