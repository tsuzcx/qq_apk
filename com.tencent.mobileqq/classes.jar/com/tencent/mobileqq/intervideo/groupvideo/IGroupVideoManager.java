package com.tencent.mobileqq.intervideo.groupvideo;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;

public abstract interface IGroupVideoManager
{
  public abstract void a(Context paramContext);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, PluginLoadListener paramPluginLoadListener);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void a(Bundle paramBundle, long paramLong);
  
  public abstract void a(ConfigurationService.Config paramConfig);
  
  public abstract void a(String paramString);
  
  public abstract void a(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager
 * JD-Core Version:    0.7.0.1
 */