package com.tencent.mobileqq.leba.config;

import com.tencent.mobileqq.config.QConfigManager;

public class LebaConfigApi
{
  public boolean a()
  {
    LebaRedTouchSwitchBean localLebaRedTouchSwitchBean = (LebaRedTouchSwitchBean)QConfigManager.b().b(598);
    boolean bool = true;
    if (localLebaRedTouchSwitchBean != null) {
      bool = true ^ localLebaRedTouchSwitchBean.a;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.config.LebaConfigApi
 * JD-Core Version:    0.7.0.1
 */