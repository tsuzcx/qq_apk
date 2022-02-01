package com.tencent.open.agent.strategy;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory
{
  public static IAgentAction a(String paramString)
  {
    Map localMap = a();
    String str = paramString;
    if (!localMap.containsKey(paramString)) {
      str = "action_error";
    }
    return (IAgentAction)localMap.get(str);
  }
  
  private static Map<String, IAgentAction> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("action_pay", new PayAction("action_pay"));
    localHashMap.put("action_quick_login", new QuickLoginAction("action_quick_login"));
    localHashMap.put("action_ptlogin_login", new QuickLoginAction("action_ptlogin_login"));
    localHashMap.put("action_invite", new SocialFriendChooserAction("action_invite"));
    localHashMap.put("action_gift", new SocialFriendChooserAction("action_gift"));
    localHashMap.put("action_ask", new SocialFriendChooserAction("action_ask"));
    localHashMap.put("action_reactive", new SocialFriendChooserAction("action_reactive"));
    localHashMap.put("action_story", new StoryAction("action_story"));
    localHashMap.put("action_brag", new BragAction("action_brag"));
    localHashMap.put("action_challenge", new ChallengeAction("action_challenge"));
    localHashMap.put("action_error", new ErrorAction("action_error"));
    localHashMap.put("action_ark_multi", new ArkMultiAction("action_ark_multi"));
    localHashMap.put("action_sso_login_by_im_block", new IMBlockLoginAction("action_sso_login_by_im_block"));
    localHashMap.put("action_login", new SSOLoginAction("action_login"));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.strategy.ActionFactory
 * JD-Core Version:    0.7.0.1
 */