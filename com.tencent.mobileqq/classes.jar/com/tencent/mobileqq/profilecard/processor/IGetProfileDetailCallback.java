package com.tencent.mobileqq.profilecard.processor;

import android.os.Bundle;
import com.tencent.mobileqq.data.Card;
import java.nio.ByteBuffer;
import java.util.List;

public abstract interface IGetProfileDetailCallback
{
  public abstract void onGetProfileDetailRequestForLogin(List<Short> paramList);
  
  public abstract void onGetProfileDetailResponseBegin(Bundle paramBundle);
  
  public abstract void onGetProfileDetailResponseEnd(Bundle paramBundle, boolean paramBoolean, Card paramCard);
  
  public abstract void onGetProfileDetailTLV(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer);
  
  public abstract void onGetProfileDetailTLVBegin(Bundle paramBundle, long paramLong, Card paramCard);
  
  public abstract void onGetProfileDetailTLVEnd(Bundle paramBundle, long paramLong, Card paramCard);
  
  public abstract void requestParseProfileLocation(Card paramCard);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.processor.IGetProfileDetailCallback
 * JD-Core Version:    0.7.0.1
 */