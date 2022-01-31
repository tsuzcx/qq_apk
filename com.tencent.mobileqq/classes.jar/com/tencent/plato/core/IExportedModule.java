package com.tencent.plato.core;

import java.util.Map;
import org.json.JSONObject;

public abstract interface IExportedModule
{
  public abstract Map<String, IExportedMethod> getExportedMethods();
  
  public abstract JSONObject getModuleDesc();
  
  public abstract String getName();
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.core.IExportedModule
 * JD-Core Version:    0.7.0.1
 */