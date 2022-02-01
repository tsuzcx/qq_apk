package com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.richstatus.RichStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/personalitysign/utils/RichStatusUtils$Companion;", "", "()V", "getRichStatus", "Lcom/tencent/mobileqq/richstatus/RichStatus;", "card", "Lcom/tencent/mobileqq/data/Card;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RichStatusUtils$Companion
{
  @Nullable
  public final RichStatus getRichStatus(@NotNull Card paramCard)
  {
    Intrinsics.checkParameterIsNotNull(paramCard, "card");
    Object localObject = (RichStatus)null;
    int i;
    if (paramCard.vRichSign != null)
    {
      localObject = paramCard.vRichSign;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "card.vRichSign");
      if (localObject.length != 0) {
        break label84;
      }
      i = 1;
    }
    while (i != 0) {
      if ((paramCard.lSignModifyTime <= 0L) && (!TextUtils.isEmpty((CharSequence)paramCard.strSign)))
      {
        localObject = new RichStatus(paramCard.strSign);
        ((RichStatus)localObject).time = paramCard.lSignModifyTime;
        return localObject;
        label84:
        i = 0;
      }
      else
      {
        return (RichStatus)null;
      }
    }
    localObject = RichStatus.parseStatus(paramCard.vRichSign);
    ((RichStatus)localObject).time = paramCard.lSignModifyTime;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils.Companion
 * JD-Core Version:    0.7.0.1
 */