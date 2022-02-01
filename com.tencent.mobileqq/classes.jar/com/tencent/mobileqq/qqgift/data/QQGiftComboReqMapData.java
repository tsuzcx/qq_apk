package com.tencent.mobileqq.qqgift.data;

import com.tencent.gift.gift_trans_svr.gift_trans_svr.nano.SendGiftOverReq;
import java.util.concurrent.atomic.AtomicInteger;

public class QQGiftComboReqMapData
{
  public AtomicInteger a;
  public SendGiftOverReq b = null;
  
  public QQGiftComboReqMapData()
  {
    this.a = new AtomicInteger(0);
  }
  
  public QQGiftComboReqMapData(AtomicInteger paramAtomicInteger)
  {
    this.a = paramAtomicInteger;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGiftComboReqMapData{unConsumeReq=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", overReq=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.data.QQGiftComboReqMapData
 * JD-Core Version:    0.7.0.1
 */