package com.tencent.qqmini.sdk.core.manager;

import org.json.JSONArray;

public abstract interface VoIPManager$JoinRoomListener
{
  public abstract void onError(int paramInt);
  
  public abstract void onJoinRoom(JSONArray paramJSONArray);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.VoIPManager.JoinRoomListener
 * JD-Core Version:    0.7.0.1
 */