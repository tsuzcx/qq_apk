package de.robv.android.xposed.callbacks;

import android.content.res.XResources;
import android.content.res.XResources.ResourceNames;
import android.view.View;
import de.robv.android.xposed.XposedBridge.CopyOnWriteSortedSet;

public final class XC_LayoutInflated$LayoutInflatedParam
  extends XCallback.Param
{
  public XResources res;
  public XResources.ResourceNames resNames;
  public String variant;
  public View view;
  
  public XC_LayoutInflated$LayoutInflatedParam(XposedBridge.CopyOnWriteSortedSet<XC_LayoutInflated> paramCopyOnWriteSortedSet)
  {
    super(paramCopyOnWriteSortedSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.callbacks.XC_LayoutInflated.LayoutInflatedParam
 * JD-Core Version:    0.7.0.1
 */