package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vas.manager.api.IKingCardManager;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.tianshu.ITianshuWebManager;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vip.IGameCardManager;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(needUin=false, process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/IVasService;", "Lmqq/app/api/IRuntimeService;", "funCallManager", "Lcom/tencent/mobileqq/vas/vipav/api/IVipFunCallManager;", "getFunCallManager", "()Lcom/tencent/mobileqq/vas/vipav/api/IVipFunCallManager;", "gameCardManager", "Lcom/tencent/mobileqq/vip/IGameCardManager;", "getGameCardManager", "()Lcom/tencent/mobileqq/vip/IGameCardManager;", "hiBoomManager", "Lcom/tencent/mobileqq/hiboom/api/IHiBoomManager;", "getHiBoomManager", "()Lcom/tencent/mobileqq/hiboom/api/IHiBoomManager;", "jceRequset", "Lcom/tencent/mobileqq/vas/api/IJce;", "getJceRequset", "()Lcom/tencent/mobileqq/vas/api/IJce;", "kingCardManager", "Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "getKingCardManager", "()Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "pbRequest", "Lcom/tencent/mobileqq/vas/api/IPbProtocol;", "getPbRequest", "()Lcom/tencent/mobileqq/vas/api/IPbProtocol;", "specialSoundManager", "Lcom/tencent/mobileqq/activity/specialcare/api/IQvipSpecialSoundManager;", "getSpecialSoundManager", "()Lcom/tencent/mobileqq/activity/specialcare/api/IQvipSpecialSoundManager;", "themeSwitchManager", "Lcom/tencent/mobileqq/vas/manager/api/IThemeSwitchManager;", "getThemeSwitchManager", "()Lcom/tencent/mobileqq/vas/manager/api/IThemeSwitchManager;", "tianshuWebManager", "Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "getTianshuWebManager", "()Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "vasFtManager", "Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "getVasFtManager", "()Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "vasUpdateManager", "Lcom/tencent/mobileqq/vas/api/IVasUpdateManager;", "getVasUpdateManager", "()Lcom/tencent/mobileqq/vas/api/IVasUpdateManager;", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasService
  extends IRuntimeService
{
  @NotNull
  public abstract IVipFunCallManager getFunCallManager();
  
  @NotNull
  public abstract IGameCardManager getGameCardManager();
  
  @NotNull
  public abstract IHiBoomManager getHiBoomManager();
  
  @NotNull
  public abstract IJce getJceRequset();
  
  @NotNull
  public abstract IKingCardManager getKingCardManager();
  
  @NotNull
  public abstract IPbProtocol getPbRequest();
  
  @NotNull
  public abstract IQvipSpecialSoundManager getSpecialSoundManager();
  
  @NotNull
  public abstract IThemeSwitchManager getThemeSwitchManager();
  
  @NotNull
  public abstract ITianshuWebManager getTianshuWebManager();
  
  @NotNull
  public abstract IVasFTManager getVasFtManager();
  
  @NotNull
  public abstract IVasUpdateManager getVasUpdateManager();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IVasService
 * JD-Core Version:    0.7.0.1
 */