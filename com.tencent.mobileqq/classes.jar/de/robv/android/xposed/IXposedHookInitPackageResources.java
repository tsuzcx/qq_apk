package de.robv.android.xposed;

import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

public abstract interface IXposedHookInitPackageResources
  extends IXposedMod
{
  public abstract void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam paramInitPackageResourcesParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.IXposedHookInitPackageResources
 * JD-Core Version:    0.7.0.1
 */