package com.tencent.plato.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.plato.ExportedModule;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.annotation.Exported;

public class StorageModule
  extends ExportedModule
{
  public StorageModule()
  {
    super("localStorage");
  }
  
  @Exported("getItem")
  public String getItem(IPlatoRuntime paramIPlatoRuntime, String paramString)
  {
    return paramIPlatoRuntime.getContext().getSharedPreferences("plato_localStorage", 0).getString(paramString, null);
  }
  
  @Exported("setItem")
  public void setItem(IPlatoRuntime paramIPlatoRuntime, String paramString1, String paramString2)
  {
    paramIPlatoRuntime = paramIPlatoRuntime.getContext().getSharedPreferences("plato_localStorage", 0).edit();
    paramIPlatoRuntime.putString(paramString1, paramString2);
    paramIPlatoRuntime.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.module.StorageModule
 * JD-Core Version:    0.7.0.1
 */