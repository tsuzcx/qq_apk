package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/PAGAsset$PagScaleMode;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "STRETCH", "LETTERBOX", "ZOOM", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public enum PAGAsset$PagScaleMode
  implements WireEnum
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<PagScaleMode> ADAPTER = (ProtoAdapter)new PAGAsset.PagScaleMode.Companion.ADAPTER.1(Reflection.getOrCreateKotlinClass(PagScaleMode.class));
  public static final PAGAsset.PagScaleMode.Companion Companion;
  private final int value;
  
  static
  {
    PagScaleMode localPagScaleMode1 = new PagScaleMode("NONE", 0, 0);
    NONE = localPagScaleMode1;
    PagScaleMode localPagScaleMode2 = new PagScaleMode("STRETCH", 1, 1);
    STRETCH = localPagScaleMode2;
    PagScaleMode localPagScaleMode3 = new PagScaleMode("LETTERBOX", 2, 2);
    LETTERBOX = localPagScaleMode3;
    PagScaleMode localPagScaleMode4 = new PagScaleMode("ZOOM", 3, 3);
    ZOOM = localPagScaleMode4;
    $VALUES = new PagScaleMode[] { localPagScaleMode1, localPagScaleMode2, localPagScaleMode3, localPagScaleMode4 };
    Companion = new PAGAsset.PagScaleMode.Companion(null);
  }
  
  private PAGAsset$PagScaleMode(int paramInt)
  {
    this.value = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final PagScaleMode fromValue(int paramInt)
  {
    return Companion.fromValue(paramInt);
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.PAGAsset.PagScaleMode
 * JD-Core Version:    0.7.0.1
 */