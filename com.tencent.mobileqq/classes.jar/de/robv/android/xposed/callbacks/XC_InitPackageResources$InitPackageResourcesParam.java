package de.robv.android.xposed.callbacks;

import android.content.res.XResources;
import de.robv.android.xposed.XposedBridge.CopyOnWriteSortedSet;

public final class XC_InitPackageResources$InitPackageResourcesParam
  extends XCallback.Param
{
  public String packageName;
  public XResources res;
  
  public XC_InitPackageResources$InitPackageResourcesParam(XposedBridge.CopyOnWriteSortedSet<XC_InitPackageResources> paramCopyOnWriteSortedSet)
  {
    super(paramCopyOnWriteSortedSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam
 * JD-Core Version:    0.7.0.1
 */