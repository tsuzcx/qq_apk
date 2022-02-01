package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.floatscr.IColorScreenManager;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vip.IVipStatusManager;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(needUin=true, process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/IVasSingedApi;", "Lmqq/app/api/IRuntimeService;", "colorScreen", "Lcom/tencent/mobileqq/floatscr/IColorScreenManager;", "getColorScreen", "()Lcom/tencent/mobileqq/floatscr/IColorScreenManager;", "vipStatus", "Lcom/tencent/mobileqq/vip/IVipStatusManager;", "getVipStatus", "()Lcom/tencent/mobileqq/vip/IVipStatusManager;", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasSingedApi
  extends IRuntimeService
{
  @NotNull
  public abstract IColorScreenManager getColorScreen();
  
  @NotNull
  public abstract IVipStatusManager getVipStatus();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IVasSingedApi
 * JD-Core Version:    0.7.0.1
 */