package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface IRIJAdReporter
  extends QRouteApi
{
  public static final String ACTION_CLICK = "click";
  public static final String ACTION_EXPOSE = "expose";
  public static final String ACTION_INTERACT = "interact";
  public static final String ACTION_NEGATIVE = "negative_feedback";
  public static final String CLICK_POSITION_DEFAULT = "0";
  public static final String CLICK_POSITION_EGGCARD = "2";
  public static final String CLICK_POSITION_FEEDS = "1";
  public static final String CLICK_TYPE_DEFAULT = "0";
  public static final String CLICK_TYPE_NO_BEHAVIOR = "2";
  public static final String CLICK_TYPE_NO_EGG_AUTO_JUMP = "3";
  public static final String CLICK_TYPE_SKIP = "1";
  public static final String EXPOSE_SUBTYPE_BIGGUIDE = "2";
  public static final String EXPOSE_SUBTYPE_DEFAULT = "0";
  public static final String EXPOSE_SUBTYPE_EGGCARD = "3";
  public static final String EXPOSE_SUBTYPE_MINIGUIDE = "1";
  public static final String EXPOSE_TYPE_DEFAULT = "0";
  public static final String EXPOSE_TYPE_LOOSE = "2";
  public static final String EXPOSE_TYPE_STRICT = "1";
  public static final String INTERACT_PLAY_TYPE_DEFAULT = "0";
  public static final String INTERACT_PLAY_TYPE_EGGCARD = "1";
  public static final String INTERACT_TYPE_DEFAULT = "0";
  public static final String INTERACT_TYPE_SHAKE = "1";
  public static final String JUMP_MODE_DEFAULT = "0";
  public static final String JUMP_MODE_NOT_OUT = "1";
  public static final String JUMP_MODE_OUT = "2";
  
  public abstract void init(String paramString1, String paramString2);
  
  public abstract void report(HashMap<String, String> paramHashMap, String paramString);
  
  public abstract void reportAdShake(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdReporter
 * JD-Core Version:    0.7.0.1
 */