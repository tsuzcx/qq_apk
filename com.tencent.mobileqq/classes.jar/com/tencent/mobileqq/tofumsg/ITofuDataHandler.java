package com.tencent.mobileqq.tofumsg;

import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfo;
import tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult;

public abstract interface ITofuDataHandler
{
  public abstract int a();
  
  public abstract TofuItem a(@NotNull TofuItem paramTofuItem, long paramLong, int paramInt);
  
  public abstract oidb_0xe61.BeancurdCubeInfo a(TofuItem paramTofuItem);
  
  public abstract void a(@NotNull TofuItem paramTofuItem, @NotNull oidb_0xe61.BeancurdCubeInfoResult paramBeancurdCubeInfoResult, long paramLong);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.ITofuDataHandler
 * JD-Core Version:    0.7.0.1
 */