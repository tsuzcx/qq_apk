package com.tencent.shadow.core.runtime.qcircle.container;

import com.tencent.shadow.core.runtime.UriParseDelegate;

public abstract interface DelegateProvider
{
  public static final String LOADER_VERSION_KEY = "LOADER_VERSION";
  public static final String PROCESS_ID_KEY = "PROCESS_ID_KEY";
  
  public abstract HostActivityDelegate getHostActivityDelegate(Class<? extends HostActivityDelegator> paramClass);
  
  public abstract UriParseDelegate getUriParseDelegate();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.qcircle.container.DelegateProvider
 * JD-Core Version:    0.7.0.1
 */