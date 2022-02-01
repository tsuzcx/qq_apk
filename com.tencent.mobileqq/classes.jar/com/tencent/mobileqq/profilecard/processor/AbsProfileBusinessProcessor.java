package com.tencent.mobileqq.profilecard.processor;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

public abstract class AbsProfileBusinessProcessor
  implements IGetProfileDetailCallback, IRequestProfileCardCallback
{
  protected AppRuntime appRuntime;
  
  public AbsProfileBusinessProcessor(AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
  }
  
  public void onGetProfileDetailRequestForLogin(List<Short> paramList) {}
  
  public void onGetProfileDetailResponseBegin(Bundle paramBundle) {}
  
  public void onGetProfileDetailResponseEnd(Bundle paramBundle, boolean paramBoolean, Card paramCard) {}
  
  public void onGetProfileDetailTLV(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer) {}
  
  public void onGetProfileDetailTLVBegin(Bundle paramBundle, long paramLong, Card paramCard) {}
  
  public void onGetProfileDetailTLVEnd(Bundle paramBundle, long paramLong, Card paramCard) {}
  
  public void onProcessProfile0x5eb(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard, oidb_0x5eb.UdcUinData paramUdcUinData) {}
  
  public void onProcessProfileCard(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard) {}
  
  public void onProcessProfileService(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard, SparseArray<BusinessRespBuffer> paramSparseArray) {}
  
  public void onRequestProfileCard(Bundle paramBundle, ArrayList<BusinessReqBuffer> paramArrayList, ArrayList<Integer> paramArrayList1) {}
  
  public void onResponseProfileCard(boolean paramBoolean, Bundle paramBundle, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard) {}
  
  public void requestParseProfileLocation(Card paramCard) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.processor.AbsProfileBusinessProcessor
 * JD-Core Version:    0.7.0.1
 */