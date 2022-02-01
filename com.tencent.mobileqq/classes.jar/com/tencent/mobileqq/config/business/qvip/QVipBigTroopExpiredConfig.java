package com.tencent.mobileqq.config.business.qvip;

import java.io.Serializable;

public class QVipBigTroopExpiredConfig
  implements Serializable
{
  public boolean mIsEnable = true;
  public int mNotifyDialogExpiredIntervalDay = 1;
  public int mNotifyDialogMaxCount = 2;
  public int mNotifyDialogMaxDay = 7;
  public int mNotifyDialogMinDay = 0;
  public int mNotifyDialogPerDay = 1;
  public int mNotifyTipsMaxCloseCount = 2;
  public int mNotifyTipsMaxCount = 2;
  public int mNotifyTipsMaxDay = 15;
  public int mNotifyTipsMinDay = 8;
  public int mNotifyTipsPerDay = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig
 * JD-Core Version:    0.7.0.1
 */