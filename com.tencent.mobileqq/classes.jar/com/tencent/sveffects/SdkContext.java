package com.tencent.sveffects;

import android.app.Application;
import com.tencent.mobileqq.shortvideo.resource.Resources;

public class SdkContext
{
  public static final String APP_DOV = "DOV";
  public static final String APP_QQ = "QQ";
  public static final String APP_UNKNOWN = "UNKNOWN";
  private static SdkContext instance = new SdkContext();
  private String appName;
  private Application application;
  private DpcSwitcher dpcSwitcher;
  private Logger logger;
  private Reporter reporter;
  private Resources resources;
  
  public static SdkContext getInstance()
  {
    return instance;
  }
  
  public String getAppName()
  {
    return this.appName;
  }
  
  public Application getApplication()
  {
    return this.application;
  }
  
  public DpcSwitcher getDpcSwitcher()
  {
    return this.dpcSwitcher;
  }
  
  public Logger getLogger()
  {
    if (this.logger == null) {
      this.logger = new DefaultLogger();
    }
    return this.logger;
  }
  
  public Reporter getReporter()
  {
    return this.reporter;
  }
  
  public Resources getResources()
  {
    return this.resources;
  }
  
  public void init(Application paramApplication, DpcSwitcher paramDpcSwitcher, Resources paramResources, Logger paramLogger, Reporter paramReporter)
  {
    init("UNKNOWN", paramApplication, paramDpcSwitcher, paramResources, paramLogger, paramReporter);
  }
  
  public void init(String paramString, Application paramApplication, DpcSwitcher paramDpcSwitcher, Resources paramResources, Logger paramLogger, Reporter paramReporter)
  {
    this.appName = paramString;
    this.application = paramApplication;
    this.dpcSwitcher = paramDpcSwitcher;
    this.resources = paramResources;
    this.logger = paramLogger;
    this.reporter = paramReporter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sveffects.SdkContext
 * JD-Core Version:    0.7.0.1
 */