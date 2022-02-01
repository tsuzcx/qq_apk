package de.robv.android.xposed;

import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public final class IXposedHookLoadPackage$Wrapper
  extends XC_LoadPackage
{
  private final IXposedHookLoadPackage instance;
  
  public IXposedHookLoadPackage$Wrapper(IXposedHookLoadPackage paramIXposedHookLoadPackage)
  {
    this.instance = paramIXposedHookLoadPackage;
  }
  
  public void handleLoadPackage(XC_LoadPackage.LoadPackageParam paramLoadPackageParam)
  {
    this.instance.handleLoadPackage(paramLoadPackageParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.IXposedHookLoadPackage.Wrapper
 * JD-Core Version:    0.7.0.1
 */