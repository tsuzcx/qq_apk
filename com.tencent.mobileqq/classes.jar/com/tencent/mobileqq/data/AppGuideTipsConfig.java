package com.tencent.mobileqq.data;

import awge;
import awhp;
import awhs;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AppGuideTipsConfig
  extends awge
{
  public static final String SWITCH_KEY_OFF = "0";
  public static final String TAIL_ID = "app_tail_id";
  public static final String TAIL_QIM_ID = "app_qim_tail_id";
  public static final String TIPS_TYPE_TIM = "1";
  public int addCount;
  @awhp
  public String aioTypeStr;
  @awhp
  public HashSet<Integer> aioTypes = new HashSet();
  @awhp
  public boolean allow;
  public long duration;
  public long lastAddTime;
  public int maxCount;
  @awhp
  public Map<Integer, Boolean> msgTypeMap = new HashMap();
  public String msgTypeStr;
  public String opkey;
  public String switchKey;
  public String tipsHighLight;
  public String tipsMsg;
  @awhs
  public String tipsType;
  public String tipsUrl;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.data.AppGuideTipsConfig
 * JD-Core Version:    0.7.0.1
 */