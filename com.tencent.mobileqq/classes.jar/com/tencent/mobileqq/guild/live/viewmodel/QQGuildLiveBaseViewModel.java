package com.tencent.mobileqq.guild.live.viewmodel;

import androidx.lifecycle.ViewModel;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class QQGuildLiveBaseViewModel
  extends ViewModel
{
  protected AppRuntime a()
  {
    return MobileQQ.sMobileQQ.peekAppRuntime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveBaseViewModel
 * JD-Core Version:    0.7.0.1
 */