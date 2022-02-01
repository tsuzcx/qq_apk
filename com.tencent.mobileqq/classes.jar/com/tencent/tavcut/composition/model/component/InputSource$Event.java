package com.tencent.tavcut.composition.model.component;

import android.os.Parcelable.Creator;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.AndroidMessage.Companion;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.squareup.wire.WireField.Label;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/composition/model/component/InputSource$Event;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/tavcut/composition/model/component/InputSource$Event$Builder;", "DefalutTrail", "", "", "HighlightValueTrail", "DrumTrail", "SlowRhythmTrail", "StartValueTrail", "unknownFields", "Lokio/ByteString;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "", "Builder", "Companion", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class InputSource$Event
  extends AndroidMessage<Event, InputSource.Event.Builder>
{
  @JvmField
  @NotNull
  public static final ProtoAdapter<Event> ADAPTER = (ProtoAdapter)new InputSource.Event.Companion.ADAPTER.1(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Event.class), "type.googleapis.com/publisher.InputSource.Event");
  @JvmField
  @NotNull
  public static final Parcelable.Creator<Event> CREATOR = AndroidMessage.Companion.newCreator(ADAPTER);
  public static final InputSource.Event.Companion Companion = new InputSource.Event.Companion(null);
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REPEATED, tag=1)
  @JvmField
  @NotNull
  public final List<Integer> DefalutTrail;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REPEATED, tag=3)
  @JvmField
  @NotNull
  public final List<Integer> DrumTrail;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REPEATED, tag=2)
  @JvmField
  @NotNull
  public final List<Integer> HighlightValueTrail;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REPEATED, tag=4)
  @JvmField
  @NotNull
  public final List<Integer> SlowRhythmTrail;
  @WireField(adapter="com.squareup.wire.ProtoAdapter#INT32", label=WireField.Label.REPEATED, tag=5)
  @JvmField
  @NotNull
  public final List<Integer> StartValueTrail;
  
  public InputSource$Event()
  {
    this(null, null, null, null, null, null, 63, null);
  }
  
  public InputSource$Event(@NotNull List<Integer> paramList1, @NotNull List<Integer> paramList2, @NotNull List<Integer> paramList3, @NotNull List<Integer> paramList4, @NotNull List<Integer> paramList5, @NotNull ByteString paramByteString)
  {
    super(ADAPTER, paramByteString);
    this.DefalutTrail = paramList1;
    this.HighlightValueTrail = paramList2;
    this.DrumTrail = paramList3;
    this.SlowRhythmTrail = paramList4;
    this.StartValueTrail = paramList5;
  }
  
  @NotNull
  public final Event copy(@NotNull List<Integer> paramList1, @NotNull List<Integer> paramList2, @NotNull List<Integer> paramList3, @NotNull List<Integer> paramList4, @NotNull List<Integer> paramList5, @NotNull ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramList1, "DefalutTrail");
    Intrinsics.checkParameterIsNotNull(paramList2, "HighlightValueTrail");
    Intrinsics.checkParameterIsNotNull(paramList3, "DrumTrail");
    Intrinsics.checkParameterIsNotNull(paramList4, "SlowRhythmTrail");
    Intrinsics.checkParameterIsNotNull(paramList5, "StartValueTrail");
    Intrinsics.checkParameterIsNotNull(paramByteString, "unknownFields");
    return new Event(paramList1, paramList2, paramList3, paramList4, paramList5, paramByteString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == (Event)this) {
      return true;
    }
    if (!(paramObject instanceof Event)) {
      return false;
    }
    ByteString localByteString = unknownFields();
    paramObject = (Event)paramObject;
    return (Intrinsics.areEqual(localByteString, paramObject.unknownFields())) && (Intrinsics.areEqual(this.DefalutTrail, paramObject.DefalutTrail)) && (Intrinsics.areEqual(this.HighlightValueTrail, paramObject.HighlightValueTrail)) && (Intrinsics.areEqual(this.DrumTrail, paramObject.DrumTrail)) && (Intrinsics.areEqual(this.SlowRhythmTrail, paramObject.SlowRhythmTrail)) && (Intrinsics.areEqual(this.StartValueTrail, paramObject.StartValueTrail));
  }
  
  public int hashCode()
  {
    int j = this.hashCode;
    int i = j;
    if (j == 0)
    {
      i = ((((unknownFields().hashCode() * 37 + this.DefalutTrail.hashCode()) * 37 + this.HighlightValueTrail.hashCode()) * 37 + this.DrumTrail.hashCode()) * 37 + this.SlowRhythmTrail.hashCode()) * 37 + this.StartValueTrail.hashCode();
      this.hashCode = i;
    }
    return i;
  }
  
  @NotNull
  public InputSource.Event.Builder newBuilder()
  {
    InputSource.Event.Builder localBuilder = new InputSource.Event.Builder();
    localBuilder.DefalutTrail = this.DefalutTrail;
    localBuilder.HighlightValueTrail = this.HighlightValueTrail;
    localBuilder.DrumTrail = this.DrumTrail;
    localBuilder.SlowRhythmTrail = this.SlowRhythmTrail;
    localBuilder.StartValueTrail = this.StartValueTrail;
    localBuilder.addUnknownFields(unknownFields());
    return localBuilder;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = (List)new ArrayList();
    StringBuilder localStringBuilder;
    if ((((Collection)this.DefalutTrail).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DefalutTrail=");
      localStringBuilder.append(this.DefalutTrail);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.HighlightValueTrail).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("HighlightValueTrail=");
      localStringBuilder.append(this.HighlightValueTrail);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.DrumTrail).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DrumTrail=");
      localStringBuilder.append(this.DrumTrail);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.SlowRhythmTrail).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("SlowRhythmTrail=");
      localStringBuilder.append(this.SlowRhythmTrail);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    if ((((Collection)this.StartValueTrail).isEmpty() ^ true))
    {
      localObject2 = (Collection)localObject1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("StartValueTrail=");
      localStringBuilder.append(this.StartValueTrail);
      ((Collection)localObject2).add(localStringBuilder.toString());
    }
    localObject1 = (Iterable)localObject1;
    Object localObject2 = (CharSequence)"Event{";
    return CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)"}", 0, null, null, 56, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.InputSource.Event
 * JD-Core Version:    0.7.0.1
 */