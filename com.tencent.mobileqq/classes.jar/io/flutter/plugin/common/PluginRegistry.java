package io.flutter.plugin.common;

public abstract interface PluginRegistry
{
  public abstract boolean hasPlugin(String paramString);
  
  public abstract PluginRegistry.Registrar registrarFor(String paramString);
  
  public abstract <T> T valuePublishedByPlugin(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.plugin.common.PluginRegistry
 * JD-Core Version:    0.7.0.1
 */