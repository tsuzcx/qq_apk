package com.tencent.mobileqq.utils.confighandler;

import com.tencent.common.app.AppInterface;

public abstract interface NormalConfigHandler$GetConfigListen<T extends ConfigInfo>
{
  public abstract void onGetConfig(AppInterface paramAppInterface, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.NormalConfigHandler.GetConfigListen
 * JD-Core Version:    0.7.0.1
 */