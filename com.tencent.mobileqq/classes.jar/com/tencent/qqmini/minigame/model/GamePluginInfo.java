package com.tencent.qqmini.minigame.model;

import android.support.annotation.NonNull;

public class GamePluginInfo
{
  @NonNull
  public final String id;
  @NonNull
  public final String name;
  @NonNull
  public final String path;
  @NonNull
  public final String version;
  
  public GamePluginInfo(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4)
  {
    this.name = paramString1;
    this.id = paramString2;
    this.version = paramString3;
    this.path = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.model.GamePluginInfo
 * JD-Core Version:    0.7.0.1
 */