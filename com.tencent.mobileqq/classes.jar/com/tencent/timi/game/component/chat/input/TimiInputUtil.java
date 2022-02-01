package com.tencent.timi.game.component.chat.input;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/input/TimiInputUtil;", "", "()V", "KEY_TIMI_GAME_KEYBOARD_HEIGHT", "", "defaultKeyBoardHeight", "", "getDefaultKeyBoardHeight", "()I", "defaultKeyBoardHeight$delegate", "Lkotlin/Lazy;", "getKeyboardHeight", "ctx", "Landroid/content/Context;", "hideSoftKeyboard", "", "context", "view", "Landroid/view/View;", "saveKeyboardHeight", "height", "showSoftKeyboard", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiInputUtil
{
  public static final TimiInputUtil a = new TimiInputUtil();
  private static final Lazy b = LazyKt.lazy((Function0)TimiInputUtil.defaultKeyBoardHeight.2.INSTANCE);
  
  private final int a()
  {
    return ((Number)b.getValue()).intValue();
  }
  
  public final int a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "ctx");
    paramContext = BaseSharedPreUtil.a(paramContext, "-1", "key_timi_game_keyboard_height", Integer.valueOf(a()));
    if (paramContext != null) {
      return ((Integer)paramContext).intValue();
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
  }
  
  public final void a(@NotNull Context paramContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "ctx");
    BaseSharedPreUtil.a(paramContext, "-1", true, "key_timi_game_keyboard_height", Integer.valueOf(paramInt));
  }
  
  public final void a(@NotNull Context paramContext, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Object localObject = paramContext.getSystemService("input_method");
    paramContext = localObject;
    if (!(localObject instanceof InputMethodManager)) {
      paramContext = null;
    }
    paramContext = (InputMethodManager)paramContext;
    if (paramContext != null)
    {
      paramView.requestFocus();
      paramContext.showSoftInput(paramView, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.TimiInputUtil
 * JD-Core Version:    0.7.0.1
 */