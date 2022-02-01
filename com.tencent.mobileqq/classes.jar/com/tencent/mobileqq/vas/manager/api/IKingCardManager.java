package com.tencent.mobileqq.vas.manager.api;

import com.tencent.mobileqq.vas.api.IVasManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "Lcom/tencent/mobileqq/vas/api/IVasManager;", "addChangeListener", "", "block", "Lkotlin/Function1;", "", "isKingCard", "setKingCardState", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKingCardManager
  extends IVasManager
{
  public abstract void addChangeListener(@NotNull Function1<? super Boolean, Unit> paramFunction1);
  
  public abstract boolean isKingCard();
  
  public abstract void setKingCardState(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.manager.api.IKingCardManager
 * JD-Core Version:    0.7.0.1
 */