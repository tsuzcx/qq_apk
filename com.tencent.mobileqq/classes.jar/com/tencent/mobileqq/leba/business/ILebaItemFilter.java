package com.tencent.mobileqq.leba.business;

import com.tencent.mobileqq.leba.entity.LebaViewItem;
import mqq.app.AppRuntime;

public abstract interface ILebaItemFilter
{
  public abstract boolean a(LebaViewItem paramLebaViewItem);
  
  public abstract boolean a(AppRuntime paramAppRuntime, StringBuffer paramStringBuffer, LebaViewItem paramLebaViewItem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.ILebaItemFilter
 * JD-Core Version:    0.7.0.1
 */