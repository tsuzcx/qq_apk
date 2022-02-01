package com.tencent.tavcut.model;

import com.squareup.wire.EnumAdapter;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/model/ClipSource$ClipType$Companion$ADAPTER$1", "Lcom/squareup/wire/EnumAdapter;", "Lcom/tencent/tavcut/model/ClipSource$ClipType;", "fromValue", "value", "", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class ClipSource$ClipType$Companion$ADAPTER$1
  extends EnumAdapter<ClipSource.ClipType>
{
  ClipSource$ClipType$Companion$ADAPTER$1(KClass paramKClass)
  {
    super(paramKClass);
  }
  
  @Nullable
  protected ClipSource.ClipType fromValue(int paramInt)
  {
    return ClipSource.ClipType.Companion.fromValue(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.ClipSource.ClipType.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */