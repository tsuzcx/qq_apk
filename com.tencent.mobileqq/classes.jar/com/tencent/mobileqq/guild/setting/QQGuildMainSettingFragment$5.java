package com.tencent.mobileqq.guild.setting;

import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.data.IElementDynamicParams;
import java.util.HashMap;
import java.util.Map;

class QQGuildMainSettingFragment$5
  implements IElementDynamicParams
{
  QQGuildMainSettingFragment$5(QQGuildMainSettingFragment paramQQGuildMainSettingFragment) {}
  
  public Map<String, Object> getElementDynamicParams()
  {
    HashMap localHashMap = new HashMap();
    int i;
    if (QQGuildMainSettingFragment.f(this.a).a()) {
      i = 1;
    } else {
      i = 2;
    }
    localHashMap.put("op_result", Integer.valueOf(i));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMainSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */