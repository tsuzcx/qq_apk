package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.app.LebaDynamicRedPointPathInterface;
import com.tencent.mobileqq.app.LebaIconEntryDynamicRedPointPathInterface;
import com.tencent.mobileqq.app.LoveZoneDynamicRedPointPathInterface;
import com.tencent.mobileqq.app.MyMiniGameDynamicRedPointPathInterface;
import com.tencent.mobileqq.pluspanel.PlusPanelRedPointAppIdInterface;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import java.util.ArrayList;

final class RedTouchConfigImpl$1
  extends ArrayList<BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface>
{
  RedTouchConfigImpl$1()
  {
    add(new LebaDynamicRedPointPathInterface());
    add(new LoveZoneDynamicRedPointPathInterface());
    add(new MyMiniGameDynamicRedPointPathInterface());
    add(new PlusPanelRedPointAppIdInterface());
    add(new LebaIconEntryDynamicRedPointPathInterface());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.RedTouchConfigImpl.1
 * JD-Core Version:    0.7.0.1
 */