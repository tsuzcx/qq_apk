package com.tencent.qqmini.proxyimpl;

import bgho;
import bgkd;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import org.json.JSONObject;

class AIOEntryPlugin$1
  implements Runnable
{
  AIOEntryPlugin$1(AIOEntryPlugin paramAIOEntryPlugin, JSONObject paramJSONObject, bgkd parambgkd) {}
  
  public void run()
  {
    boolean bool = false;
    if ((AIOEntryPlugin.access$000(this.this$0).a() instanceof GameActivity1)) {
      bool = ((GameActivity1)AIOEntryPlugin.access$100(this.this$0).a()).showMiniAIOEntrance(this.val$jsonObject);
    }
    if (bool)
    {
      this.val$req.a();
      return;
    }
    this.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AIOEntryPlugin.1
 * JD-Core Version:    0.7.0.1
 */