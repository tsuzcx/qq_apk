package com.tencent.mobileqq.data;

import aukm;
import aulx;
import auma;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AppGuideTipsConfig
  extends aukm
{
  public static final String SWITCH_KEY_OFF = "0";
  public static final String TAIL_ID = "app_tail_id";
  public static final String TAIL_QIM_ID = "app_qim_tail_id";
  public static final String TIPS_TYPE_TIM = "1";
  public int addCount;
  @aulx
  public String aioTypeStr;
  @aulx
  public HashSet<Integer> aioTypes = new HashSet();
  @aulx
  public boolean allow;
  public long duration;
  public long lastAddTime;
  public int maxCount;
  @aulx
  public Map<Integer, Boolean> msgTypeMap = new HashMap();
  public String msgTypeStr;
  public String opkey;
  public String switchKey;
  public String tipsHighLight;
  public String tipsMsg;
  @auma
  public String tipsType;
  public String tipsUrl;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.AppGuideTipsConfig
 * JD-Core Version:    0.7.0.1
 */