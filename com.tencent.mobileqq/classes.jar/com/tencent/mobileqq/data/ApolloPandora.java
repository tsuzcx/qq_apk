package com.tencent.mobileqq.data;

import android.text.TextUtils;
import awbv;
import awdj;

public class ApolloPandora
  extends awbv
{
  public static final int BOX_TYPE_BEAN = 3;
  public static final int BOX_TYPE_CARD = 1;
  public static final int BOX_TYPE_CRYSTAL = 2;
  public static final int BOX_TYPE_NONE = -1;
  public short boxSubType;
  public short boxType;
  public short canSteal;
  public long checkPoint;
  public short hadStolen;
  public String mBoxTipUrl;
  public long queryInterval;
  @awdj
  public String uin;
  public long updateTime;
  
  public boolean needShow(int paramInt)
  {
    if (TextUtils.isEmpty(this.mBoxTipUrl)) {}
    while ((paramInt == this.boxType) || (this.hadStolen != 0)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloPandora
 * JD-Core Version:    0.7.0.1
 */