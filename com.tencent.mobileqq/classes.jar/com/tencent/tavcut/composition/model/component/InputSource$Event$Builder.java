package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/InputSource$Event$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/tavcut/composition/model/component/InputSource$Event;", "()V", "DefalutTrail", "", "", "DrumTrail", "HighlightValueTrail", "SlowRhythmTrail", "StartValueTrail", "build", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class InputSource$Event$Builder
  extends Message.Builder<InputSource.Event, Builder>
{
  @JvmField
  @NotNull
  public List<Integer> DefalutTrail = CollectionsKt.emptyList();
  @JvmField
  @NotNull
  public List<Integer> DrumTrail = CollectionsKt.emptyList();
  @JvmField
  @NotNull
  public List<Integer> HighlightValueTrail = CollectionsKt.emptyList();
  @JvmField
  @NotNull
  public List<Integer> SlowRhythmTrail = CollectionsKt.emptyList();
  @JvmField
  @NotNull
  public List<Integer> StartValueTrail = CollectionsKt.emptyList();
  
  @NotNull
  public final Builder DefalutTrail(@NotNull List<Integer> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "DefalutTrail");
    Internal.checkElementsNotNull(paramList);
    this.DefalutTrail = paramList;
    return this;
  }
  
  @NotNull
  public final Builder DrumTrail(@NotNull List<Integer> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "DrumTrail");
    Internal.checkElementsNotNull(paramList);
    this.DrumTrail = paramList;
    return this;
  }
  
  @NotNull
  public final Builder HighlightValueTrail(@NotNull List<Integer> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "HighlightValueTrail");
    Internal.checkElementsNotNull(paramList);
    this.HighlightValueTrail = paramList;
    return this;
  }
  
  @NotNull
  public final Builder SlowRhythmTrail(@NotNull List<Integer> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "SlowRhythmTrail");
    Internal.checkElementsNotNull(paramList);
    this.SlowRhythmTrail = paramList;
    return this;
  }
  
  @NotNull
  public final Builder StartValueTrail(@NotNull List<Integer> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "StartValueTrail");
    Internal.checkElementsNotNull(paramList);
    this.StartValueTrail = paramList;
    return this;
  }
  
  @NotNull
  public InputSource.Event build()
  {
    return new InputSource.Event(this.DefalutTrail, this.HighlightValueTrail, this.DrumTrail, this.SlowRhythmTrail, this.StartValueTrail, buildUnknownFields());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.InputSource.Event.Builder
 * JD-Core Version:    0.7.0.1
 */