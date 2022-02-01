package com.tencent.mobileqq.data;

public class PushRecommend
  extends MayKnowRecommend
{
  public static final int MAX_SAVE_COUNT = 200;
  public static final long MAX_SAVE_TIME = 15552000000L;
  public static final long MAX_SHOW_TIME = 2592000000L;
  public int fromSource;
  public boolean isReaded;
  public boolean isReported;
  public int sourceId;
  public String sourceReason;
  public int subSourceId;
  public long timestamp;
  public String wzryGameNick;
  public int wzrySourceId;
  public String wzryVerifyStr;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.PushRecommend
 * JD-Core Version:    0.7.0.1
 */