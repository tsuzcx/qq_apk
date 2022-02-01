package com.tencent.videocut.model;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/model/ActionScope;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ON_VIDEO", "ON_CANVAS", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum ActionScope
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<ActionScope> ADAPTER = (ProtoAdapter)new ActionScope.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(ActionScope.class));
  public static final ActionScope.Companion Companion;
  private final int value;
  
  static
  {
    ActionScope localActionScope1 = new ActionScope("ON_VIDEO", 0, 0);
    ON_VIDEO = localActionScope1;
    ActionScope localActionScope2 = new ActionScope("ON_CANVAS", 1, 1);
    ON_CANVAS = localActionScope2;
    $VALUES = new ActionScope[] { localActionScope1, localActionScope2 };
    Companion = new ActionScope.Companion(null);
  }
  
  private ActionScope(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final ActionScope fromValue(int paramInt)
  {
    return Companion.a(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.ActionScope
 * JD-Core Version:    0.7.0.1
 */