package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vas.kingcard.IKingCardManager;
import com.tencent.mobileqq.vas.tianshu.ITianshuWebManager;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(needUin=false, process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/IVasService;", "Lmqq/app/api/IRuntimeService;", "kingCardManager", "Lcom/tencent/mobileqq/vas/kingcard/IKingCardManager;", "getKingCardManager", "()Lcom/tencent/mobileqq/vas/kingcard/IKingCardManager;", "tianshuWebManager", "Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "getTianshuWebManager", "()Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasService
  extends IRuntimeService
{
  @NotNull
  public abstract IKingCardManager getKingCardManager();
  
  @NotNull
  public abstract ITianshuWebManager getTianshuWebManager();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.IVasService
 * JD-Core Version:    0.7.0.1
 */