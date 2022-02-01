package com.tencent.qzonehub.model;

import java.io.Serializable;

public class MQUnReadSummaryInfo
  implements Serializable
{
  public static final String TAG = "MQUnReadSummaryInfo";
  public String attachInfo = "";
  public int hasMore = 0;
  public int needMoreUnreadMsg = 0;
  public int reqNum = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.model.MQUnReadSummaryInfo
 * JD-Core Version:    0.7.0.1
 */