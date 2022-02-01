package com.tencent.webbundle.sdk;

import java.util.ArrayList;

public class WebBundleConfig
{
  private Class carrierActivityClass;
  private WebBundleLogListener logListener;
  private boolean logPrintEnabled = false;
  private WebBundleH5OptionListner optionListener;
  private long preloadTimeoutLimit = 15000L;
  private ArrayList<String> preloadUrlList = new ArrayList();
  private long preloadWebViewCount = 2L;
  
  public WebBundleConfig enableLogPrint(boolean paramBoolean)
  {
    this.logPrintEnabled = paramBoolean;
    return this;
  }
  
  public Class getCarrierActivityClass()
  {
    return this.carrierActivityClass;
  }
  
  public WebBundleLogListener getLogListener()
  {
    return this.logListener;
  }
  
  public WebBundleH5OptionListner getOptionListener()
  {
    return this.optionListener;
  }
  
  public long getPreloadTimeoutLimit()
  {
    return this.preloadTimeoutLimit;
  }
  
  public ArrayList<String> getPreloadUrlList()
  {
    return this.preloadUrlList;
  }
  
  public long getPreloadWebViewCount()
  {
    return this.preloadWebViewCount;
  }
  
  public boolean isLogPrintEnabled()
  {
    return this.logPrintEnabled;
  }
  
  public final boolean isValidate()
  {
    return (this.carrierActivityClass != null) && (this.preloadUrlList.size() > 0);
  }
  
  public void reset()
  {
    this.carrierActivityClass = null;
    this.preloadUrlList.clear();
    this.preloadTimeoutLimit = 15000L;
    this.preloadWebViewCount = 2L;
    this.logPrintEnabled = false;
    this.logListener = null;
    this.optionListener = null;
  }
  
  public WebBundleConfig setCarrierActivityClass(Class paramClass)
  {
    this.carrierActivityClass = paramClass;
    return this;
  }
  
  public WebBundleConfig setLogListener(WebBundleLogListener paramWebBundleLogListener)
  {
    this.logListener = paramWebBundleLogListener;
    return this;
  }
  
  public WebBundleConfig setOptionListener(WebBundleH5OptionListner paramWebBundleH5OptionListner)
  {
    this.optionListener = paramWebBundleH5OptionListner;
    return this;
  }
  
  public WebBundleConfig setPreloadTimeoutLimit(long paramLong)
  {
    this.preloadTimeoutLimit = paramLong;
    return this;
  }
  
  public WebBundleConfig setPreloadUrl(String paramString)
  {
    this.preloadUrlList.clear();
    this.preloadUrlList.add(paramString);
    return this;
  }
  
  public WebBundleConfig setPreloadUrlList(ArrayList<String> paramArrayList)
  {
    this.preloadUrlList.clear();
    this.preloadUrlList.addAll(paramArrayList);
    return this;
  }
  
  public WebBundleConfig setPreloadWebViewCount(long paramLong)
  {
    this.preloadWebViewCount = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.webbundle.sdk.WebBundleConfig
 * JD-Core Version:    0.7.0.1
 */