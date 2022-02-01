package com.tencent.mobileqq.guild.vas.panel;

import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import java.util.HashMap;
import java.util.Map;

class GiftPanelController$8
  implements IElementDynamicParams
{
  GiftPanelController$8(GiftPanelController paramGiftPanelController) {}
  
  @Nullable
  public Map<String, Object> getElementDynamicParams()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("balance_amt", Long.valueOf(GiftPanelController.f(this.a)));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.vas.panel.GiftPanelController.8
 * JD-Core Version:    0.7.0.1
 */