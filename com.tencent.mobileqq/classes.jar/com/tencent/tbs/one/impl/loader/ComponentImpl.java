package com.tencent.tbs.one.impl.loader;

import android.content.Context;
import com.tencent.tbs.one.TBSOneComponent;
import java.io.File;

public class ComponentImpl
  implements TBSOneComponent
{
  private ClassLoader mEntryClassLoader;
  private Object mEntryObject;
  private File mInstallationDirectory;
  private String mName;
  private Context mResourcesContext;
  private int mVersionCode;
  private String mVersionName;
  
  public ComponentImpl(String paramString1, String paramString2, int paramInt, File paramFile)
  {
    this.mName = paramString1;
    this.mVersionName = paramString2;
    this.mVersionCode = paramInt;
    this.mInstallationDirectory = paramFile;
  }
  
  public ClassLoader getEntryClassLoader()
  {
    return this.mEntryClassLoader;
  }
  
  public Object getEntryObject()
  {
    return this.mEntryObject;
  }
  
  public File getInstallationDirectory()
  {
    return this.mInstallationDirectory;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public Context getResourcesContext()
  {
    return this.mResourcesContext;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String getVersionName()
  {
    return this.mVersionName;
  }
  
  public void setEntryClassLoader(ClassLoader paramClassLoader)
  {
    this.mEntryClassLoader = paramClassLoader;
  }
  
  public void setEntryObject(Object paramObject)
  {
    this.mEntryObject = paramObject;
  }
  
  public void setResourcesContext(Context paramContext)
  {
    this.mResourcesContext = paramContext;
  }
  
  public String toString()
  {
    return String.format("{name: '%s', versionName: '%s', versionCode: %d, installationDirectory: '%s', apkContext: '%s', entryClassLoader: '%s', entryObject: '%s'}", new Object[] { this.mName, this.mVersionName, Integer.valueOf(this.mVersionCode), this.mInstallationDirectory, this.mResourcesContext, this.mEntryClassLoader, this.mEntryObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.ComponentImpl
 * JD-Core Version:    0.7.0.1
 */