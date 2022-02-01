package com.tencent.tbs.one;

import android.content.Context;
import java.io.File;

public abstract interface TBSOneComponent
{
  public abstract ClassLoader getEntryClassLoader();
  
  public abstract Object getEntryObject();
  
  public abstract File getInstallationDirectory();
  
  public abstract String getName();
  
  public abstract Context getResourcesContext();
  
  public abstract int getVersionCode();
  
  public abstract String getVersionName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.TBSOneComponent
 * JD-Core Version:    0.7.0.1
 */