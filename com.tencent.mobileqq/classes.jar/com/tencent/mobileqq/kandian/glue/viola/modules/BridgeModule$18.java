package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.repo.account.IUserLevelCallBack;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import org.json.JSONObject;

class BridgeModule$18
  implements IUserLevelCallBack
{
  BridgeModule$18(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(UserLevelInfo paramUserLevelInfo)
  {
    this.b.invokeCallJS(this.a, new JSONObject());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.18
 * JD-Core Version:    0.7.0.1
 */