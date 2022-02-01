package com.tencent.mobileqq.vas.treasurecard.api;

import android.content.Context;
import com.tencent.mobileqq.vas.api.IVasManager;
import com.tencent.mobileqq.vas.treasurecard.VasFtCard;
import com.tencent.treasurecard.net.INetCallBack;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "init", "", "context", "Landroid/content/Context;", "obtainCardInfo", "Lcom/tencent/mobileqq/vas/treasurecard/VasFtCard;", "from", "", "obtainCardState", "", "queryTreasureCard", "callBack", "Lcom/tencent/treasurecard/net/INetCallBack;", "Companion", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasFTManager
  extends IVasManager
{
  public static final IVasFTManager.Companion Companion = IVasFTManager.Companion.a;
  public static final int VAS_FT_CARD_STATE_KING = 2;
  public static final int VAS_FT_CARD_STATE_NOORDER = 0;
  public static final int VAS_FT_CARD_STATE_TREASURE = 1;
  public static final int VAS_FT_CARD_STATE_UNKOWN = -1;
  
  public abstract void init(@NotNull Context paramContext);
  
  @Nullable
  public abstract VasFtCard obtainCardInfo(@NotNull String paramString);
  
  public abstract int obtainCardState(@NotNull String paramString);
  
  public abstract void queryTreasureCard(@NotNull INetCallBack paramINetCallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager
 * JD-Core Version:    0.7.0.1
 */