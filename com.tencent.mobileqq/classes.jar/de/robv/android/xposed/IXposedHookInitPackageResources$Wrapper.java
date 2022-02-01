package de.robv.android.xposed;

import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

public final class IXposedHookInitPackageResources$Wrapper
  extends XC_InitPackageResources
{
  private final IXposedHookInitPackageResources instance;
  
  public IXposedHookInitPackageResources$Wrapper(IXposedHookInitPackageResources paramIXposedHookInitPackageResources)
  {
    this.instance = paramIXposedHookInitPackageResources;
  }
  
  public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam paramInitPackageResourcesParam)
  {
    this.instance.handleInitPackageResources(paramInitPackageResourcesParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.IXposedHookInitPackageResources.Wrapper
 * JD-Core Version:    0.7.0.1
 */