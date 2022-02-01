package com.tencent.timi.game.jump.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserBase;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.timi.game.utils.Logger;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/jump/api/impl/TimiGameParserBase;", "Lcom/tencent/mobileqq/app/parser/JumpParserBase;", "()V", "getJumpAction", "Lcom/tencent/mobileqq/utils/JumpAction;", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "context", "Landroid/content/Context;", "parse", "jump", "", "jumpParserResult", "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class TimiGameParserBase
  extends JumpParserBase
{
  public static final TimiGameParserBase.Companion b = new TimiGameParserBase.Companion(null);
  
  @NotNull
  public abstract JumpAction a(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext);
  
  @NotNull
  public JumpAction a(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable Context paramContext, @NotNull String paramString, @Nullable JumpParserResult paramJumpParserResult)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "jump");
    paramJumpParserResult = new StringBuilder();
    paramJumpParserResult.append("parse jump:");
    paramJumpParserResult.append(paramString);
    Logger.a("TimiGameParserBase_", paramJumpParserResult.toString());
    paramBaseQQAppInterface = a(paramBaseQQAppInterface, paramContext);
    paramBaseQQAppInterface.c = paramString;
    paramContext = ((Collection)StringsKt.split$default((CharSequence)paramString, new String[] { "?" }, false, 0, 6, null)).toArray(new String[0]);
    if (paramContext != null)
    {
      paramContext = (String[])paramContext;
      if (paramContext.length != 2) {
        return paramBaseQQAppInterface;
      }
      paramContext = ((Collection)StringsKt.split$default((CharSequence)paramContext[1], new String[] { "&" }, false, 0, 6, null)).toArray(new String[0]);
      if (paramContext != null)
      {
        paramContext = (String[])paramContext;
        int j = paramContext.length;
        int i = 0;
        while (i < j)
        {
          paramString = ((Collection)StringsKt.split$default((CharSequence)paramContext[i], new String[] { "=" }, false, 0, 6, null)).toArray(new String[0]);
          if (paramString != null)
          {
            paramString = (String[])paramString;
            if (paramString.length == 2) {
              paramBaseQQAppInterface.a(paramString[0], paramString[1]);
            }
            i += 1;
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
          }
        }
        return paramBaseQQAppInterface;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    paramBaseQQAppInterface = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramBaseQQAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.jump.api.impl.TimiGameParserBase
 * JD-Core Version:    0.7.0.1
 */