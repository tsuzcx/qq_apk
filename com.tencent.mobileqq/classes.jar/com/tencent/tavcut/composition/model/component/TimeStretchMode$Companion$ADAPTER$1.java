package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.EnumAdapter;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/TimeStretchMode$Companion$ADAPTER$1", "Lcom/squareup/wire/EnumAdapter;", "Lcom/tencent/tavcut/composition/model/component/TimeStretchMode;", "fromValue", "value", "", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TimeStretchMode$Companion$ADAPTER$1
  extends EnumAdapter<TimeStretchMode>
{
  TimeStretchMode$Companion$ADAPTER$1(KClass paramKClass)
  {
    super(paramKClass);
  }
  
  @Nullable
  protected TimeStretchMode fromValue(int paramInt)
  {
    return TimeStretchMode.Companion.fromValue(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.TimeStretchMode.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */