package de.robv.android.xposed;

import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public abstract interface IXposedHookLoadPackage
  extends IXposedMod
{
  public abstract void handleLoadPackage(XC_LoadPackage.LoadPackageParam paramLoadPackageParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.IXposedHookLoadPackage
 * JD-Core Version:    0.7.0.1
 */