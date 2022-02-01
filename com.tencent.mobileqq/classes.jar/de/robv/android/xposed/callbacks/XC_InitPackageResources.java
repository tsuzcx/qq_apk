package de.robv.android.xposed.callbacks;

import de.robv.android.xposed.IXposedHookInitPackageResources;

public abstract class XC_InitPackageResources
  extends XCallback
  implements IXposedHookInitPackageResources
{
  public XC_InitPackageResources() {}
  
  public XC_InitPackageResources(int paramInt)
  {
    super(paramInt);
  }
  
  protected void call(XCallback.Param paramParam)
  {
    if ((paramParam instanceof XC_InitPackageResources.InitPackageResourcesParam)) {
      handleInitPackageResources((XC_InitPackageResources.InitPackageResourcesParam)paramParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.callbacks.XC_InitPackageResources
 * JD-Core Version:    0.7.0.1
 */