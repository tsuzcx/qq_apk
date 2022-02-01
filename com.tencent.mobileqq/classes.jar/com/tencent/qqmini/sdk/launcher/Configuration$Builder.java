package com.tencent.qqmini.sdk.launcher;

import android.content.Context;

public class Configuration$Builder
{
  Configuration configuration;
  
  public Configuration$Builder(Context paramContext)
  {
    this.configuration = new Configuration(paramContext, null);
  }
  
  public Configuration build()
  {
    return this.configuration;
  }
  
  public Builder setFlutterEnabled(boolean paramBoolean)
  {
    this.configuration.flutterEnabled = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.Configuration.Builder
 * JD-Core Version:    0.7.0.1
 */