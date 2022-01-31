package com.tencent.qqmini.proxyimpl;

import bglv;
import bgok;
import com.tencent.mobileqq.minigame.ui.GameActivity1;

class AIOEntryPlugin$2
  implements Runnable
{
  AIOEntryPlugin$2(AIOEntryPlugin paramAIOEntryPlugin, bgok parambgok) {}
  
  public void run()
  {
    if ((AIOEntryPlugin.access$200(this.this$0).a() instanceof GameActivity1)) {
      ((GameActivity1)AIOEntryPlugin.access$300(this.this$0).a()).hideMiniAIOEntrance();
    }
    this.val$req.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AIOEntryPlugin.2
 * JD-Core Version:    0.7.0.1
 */