package com.tencent.timi.game.accusation.api;

import com.tencent.timi.game.accusation.impl.TextMsgAccusationParams;
import com.tencent.timi.game.accusation.impl.TimiGameAccusationImpl;

public class TimiGameAccusationApi
{
  public static void a(String paramString)
  {
    TextMsgAccusationParams localTextMsgAccusationParams = new TextMsgAccusationParams(paramString, "", "");
    localTextMsgAccusationParams.d = paramString;
    localTextMsgAccusationParams.h = "25093";
    localTextMsgAccusationParams.g = "qq_esports_king_uin";
    TimiGameAccusationImpl.a(localTextMsgAccusationParams);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = new TextMsgAccusationParams(paramString1, paramString2, paramString3);
    paramString2.d = paramString1;
    paramString2.h = "25094";
    paramString2.g = "qq_esports_king_chat";
    TimiGameAccusationImpl.a(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.accusation.api.TimiGameAccusationApi
 * JD-Core Version:    0.7.0.1
 */