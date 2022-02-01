package com.tencent.qqinterface;

import org.json.JSONObject;

public abstract interface QQConfigAbilityInterface
{
  public static final int STUDY_ROOM_FUNCTION_PIC_UPLOAD = 1;
  public static final int STUDY_ROOM_FUNCTION_PIC_UPLOAD_CANCEL = 2;
  
  public abstract boolean callMethod(int paramInt, JSONObject paramJSONObject, QQConfigAbilityInterface.Callback<JSONObject> paramCallback);
  
  public abstract JSONObject getConfigFromQQ();
  
  public abstract void printQLog(int paramInt, String paramString1, String paramString2);
  
  public abstract void requestConfigFromQQ(QQConfigAbilityInterface.Callback<JSONObject> paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqinterface.QQConfigAbilityInterface
 * JD-Core Version:    0.7.0.1
 */