package com.tencent.qqinterface;

import org.json.JSONObject;

public abstract interface QQConfigAbilityInterface
{
  public abstract JSONObject getConfigFromQQ();
  
  public abstract void requestConfigFromQQ(QQConfigAbilityInterface.Callback<JSONObject> paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqinterface.QQConfigAbilityInterface
 * JD-Core Version:    0.7.0.1
 */