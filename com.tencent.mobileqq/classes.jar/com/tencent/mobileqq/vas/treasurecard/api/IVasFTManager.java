package com.tencent.mobileqq.vas.treasurecard.api;

import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vas.treasurecard.VasFtCard;
import com.tencent.treasurecard.net.INetCallBack;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "clearCacheAndRequest", "", "init", "", "obtainCardInfo", "Lcom/tencent/mobileqq/vas/treasurecard/VasFtCard;", "from", "", "obtainCardState", "", "queryTreasureCard", "callBack", "Lcom/tencent/treasurecard/net/INetCallBack;", "treasureCardState", "Companion", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasFTManager
  extends IVasManager
{
  public static final int CARD_STATE_KING = 1;
  public static final int CARD_STATE_NOORDER = 0;
  public static final int CARD_STATE_TREASURE = 2;
  public static final int CARD_STATE_UNKNOW = -1;
  public static final IVasFTManager.Companion Companion = IVasFTManager.Companion.a;
  
  public abstract boolean clearCacheAndRequest();
  
  public abstract void init();
  
  @Nullable
  public abstract VasFtCard obtainCardInfo(@NotNull String paramString);
  
  public abstract int obtainCardState(@NotNull String paramString);
  
  public abstract void queryTreasureCard(@NotNull INetCallBack paramINetCallBack);
  
  public abstract int treasureCardState(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager
 * JD-Core Version:    0.7.0.1
 */