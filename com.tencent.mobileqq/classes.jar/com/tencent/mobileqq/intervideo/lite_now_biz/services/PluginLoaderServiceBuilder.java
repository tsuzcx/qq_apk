package com.tencent.mobileqq.intervideo.lite_now_biz.services;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilivesdk.pluginloaderservice.PluginLoaderService;
import com.tencent.ilivesdk.pluginloaderservice.interfaces.IPluginLoaderService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;
import java.io.File;
import mqq.app.AppRuntime;

public class PluginLoaderServiceBuilder
  implements BaseServiceBuilder, IPluginLoaderServiceBuilder
{
  public IPluginLoaderService build(ServiceAccessor paramServiceAccessor)
  {
    PluginLoaderService localPluginLoaderService = new PluginLoaderService();
    localPluginLoaderService.a(new PluginLoaderServiceAdapter(paramServiceAccessor, BaseApplicationImpl.getApplication().getRuntime().getApplicationContext().getFilesDir().getAbsolutePath()));
    return localPluginLoaderService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.services.PluginLoaderServiceBuilder
 * JD-Core Version:    0.7.0.1
 */