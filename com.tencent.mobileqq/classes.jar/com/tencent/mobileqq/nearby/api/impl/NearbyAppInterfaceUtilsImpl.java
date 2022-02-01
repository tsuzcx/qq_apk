package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.nearby.api.INearbyAppInterfaceUtils;

public class NearbyAppInterfaceUtilsImpl
  implements INearbyAppInterfaceUtils
{
  public void freePartBitmapCache() {}
  
  public boolean issEnableFreshPreload()
  {
    return NearbyAppInterfaceImpl.issEnableFreshPreload();
  }
  
  public boolean issEnableFreshStaticLayout()
  {
    return NearbyAppInterfaceImpl.issEnableFreshStaticLayout();
  }
  
  public void setsEnableFreshPreload(boolean paramBoolean)
  {
    NearbyAppInterfaceImpl.setsEnableFreshPreload(paramBoolean);
  }
  
  public void setsEnableFreshStaticLayout(boolean paramBoolean)
  {
    NearbyAppInterfaceImpl.setsEnableFreshStaticLayout(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyAppInterfaceUtilsImpl
 * JD-Core Version:    0.7.0.1
 */