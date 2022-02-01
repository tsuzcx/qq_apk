package com.tencent.mobileqq.profilecard.processor;

import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.entity.BusinessRespBuffer;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

public abstract interface IRequestProfileCardCallback
{
  public abstract void onProcessProfile0x5eb(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard, oidb_0x5eb.UdcUinData paramUdcUinData);
  
  public abstract void onProcessProfileCard(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard);
  
  public abstract void onProcessProfileService(Bundle paramBundle, Card paramCard, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard, SparseArray<BusinessRespBuffer> paramSparseArray);
  
  public abstract void onRequestProfileCard(Bundle paramBundle, ArrayList<BusinessReqBuffer> paramArrayList, ArrayList<Integer> paramArrayList1);
  
  public abstract void onResponseProfileCard(boolean paramBoolean, Bundle paramBundle, RespHead paramRespHead, RespSummaryCard paramRespSummaryCard);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.processor.IRequestProfileCardCallback
 * JD-Core Version:    0.7.0.1
 */