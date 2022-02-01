package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.Card;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/CardSettingObserver;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "()V", "handleGetCardDisplaySettingNotify", "", "isSuccess", "", "data", "", "handleSetCardDisplaySettingNotify", "onGetCardDisplaySetting", "uin", "", "card", "Lcom/tencent/mobileqq/data/Card;", "onSetCardDisplaySetting", "items", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/profilesetting/ReqSetSettingItem;", "Lkotlin/collections/ArrayList;", "onUpdate", "type", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class CardSettingObserver
  implements BusinessObserver
{
  public static final CardSettingObserver.Companion Companion = new CardSettingObserver.Companion(null);
  public static final int ON_GET_CARD_DISPLAY_SETTING = 1;
  public static final int ON_SET_CARD_DISPLAY_SETTING = 2;
  
  private final void handleGetCardDisplaySettingNotify(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      onGetCardDisplaySetting(paramBoolean, (String)((Object[])paramObject)[0], (Card)((Object[])paramObject)[1]);
    }
  }
  
  private final void handleSetCardDisplaySettingNotify(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      onSetCardDisplaySetting(paramBoolean, (String)((Object[])paramObject)[0], (Card)((Object[])paramObject)[1], (ArrayList)((Object[])paramObject)[2]);
    }
  }
  
  public void onGetCardDisplaySetting(boolean paramBoolean, @Nullable String paramString, @Nullable Card paramCard) {}
  
  public void onSetCardDisplaySetting(boolean paramBoolean, @Nullable String paramString, @Nullable Card paramCard, @Nullable ArrayList<ReqSetSettingItem> paramArrayList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "data");
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      handleGetCardDisplaySettingNotify(paramBoolean, paramObject);
      return;
    }
    handleSetCardDisplaySettingNotify(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.CardSettingObserver
 * JD-Core Version:    0.7.0.1
 */