package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import org.json.JSONArray;

public abstract interface VoIPManager$EventListener
{
  public abstract void onInterrupt(int paramInt, String paramString);
  
  public abstract void onRoomMemberChange(JSONArray paramJSONArray);
  
  public abstract void onRoomMemberSpeaking(JSONArray paramJSONArray);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager.EventListener
 * JD-Core Version:    0.7.0.1
 */