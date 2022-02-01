package de.robv.android.xposed.callbacks;

import de.robv.android.xposed.IXposedHookLoadPackage;

public abstract class XC_LoadPackage
  extends XCallback
  implements IXposedHookLoadPackage
{
  public XC_LoadPackage() {}
  
  public XC_LoadPackage(int paramInt)
  {
    super(paramInt);
  }
  
  protected void call(XCallback.Param paramParam)
  {
    if ((paramParam instanceof XC_LoadPackage.LoadPackageParam)) {
      handleLoadPackage((XC_LoadPackage.LoadPackageParam)paramParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.callbacks.XC_LoadPackage
 * JD-Core Version:    0.7.0.1
 */