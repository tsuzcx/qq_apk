package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.Card;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilesetting/CardSettingObserver;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "()V", "handleGetCardDisplaySettingNotify", "", "isSuccess", "", "data", "", "handleSetCardDisplaySettingNotify", "onGetCardDisplaySetting", "uin", "", "card", "Lcom/tencent/mobileqq/data/Card;", "onSetCardDisplaySetting", "items", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/profilesetting/ReqSetSettingItem;", "Lkotlin/collections/ArrayList;", "onUpdate", "type", "", "Companion", "profilecard-temp-api_release"}, k=1, mv={1, 1, 16})
public class CardSettingObserver
  implements BusinessObserver
{
  public static final CardSettingObserver.Companion Companion = new CardSettingObserver.Companion(null);
  public static final int ON_GET_CARD_DISPLAY_SETTING = 1;
  public static final int ON_SET_CARD_DISPLAY_SETTING = 2;
  
  private final void handleGetCardDisplaySettingNotify(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onGetCardDisplaySetting(paramBoolean, (String)paramObject[0], (Card)paramObject[1]);
    }
  }
  
  private final void handleSetCardDisplaySettingNotify(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onSetCardDisplaySetting(paramBoolean, (String)paramObject[0], (Card)paramObject[1], (ArrayList)paramObject[2]);
    }
  }
  
  public void onGetCardDisplaySetting(boolean paramBoolean, @Nullable String paramString, @Nullable Card paramCard) {}
  
  public void onSetCardDisplaySetting(boolean paramBoolean, @Nullable String paramString, @Nullable Card paramCard, @Nullable ArrayList<ReqSetSettingItem> paramArrayList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "data");
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      handleSetCardDisplaySettingNotify(paramBoolean, paramObject);
      return;
    }
    handleGetCardDisplaySettingNotify(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.CardSettingObserver
 * JD-Core Version:    0.7.0.1
 */