package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"reflectField", "", "obj", "", "fieldName", "", "callback", "Lkotlin/Function1;", "Ljava/lang/reflect/Field;", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class TimelinePanelKt
{
  public static final void a(@NotNull Object paramObject, @NotNull String paramString, @NotNull Function1<? super Field, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    Intrinsics.checkParameterIsNotNull(paramString, "fieldName");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    try
    {
      paramObject = paramObject.getClass().getDeclaredField(paramString);
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "field");
      boolean bool = paramObject.isAccessible();
      paramObject.setAccessible(true);
      paramFunction1.invoke(paramObject);
      paramObject.setAccessible(bool);
      return;
    }
    catch (NoSuchFieldException paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelKt
 * JD-Core Version:    0.7.0.1
 */