package de.robv.android.xposed.callbacks;

import android.content.pm.ApplicationInfo;
import de.robv.android.xposed.XposedBridge.CopyOnWriteSortedSet;

public final class XC_LoadPackage$LoadPackageParam
  extends XCallback.Param
{
  public ApplicationInfo appInfo;
  public ClassLoader classLoader;
  public boolean isFirstApplication;
  public String packageName;
  public String processName;
  
  public XC_LoadPackage$LoadPackageParam(XposedBridge.CopyOnWriteSortedSet<XC_LoadPackage> paramCopyOnWriteSortedSet)
  {
    super(paramCopyOnWriteSortedSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam
 * JD-Core Version:    0.7.0.1
 */