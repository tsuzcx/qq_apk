package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/InputSource$Event$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/InputSource$Event;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class InputSource$Event$Companion$ADAPTER$1
  extends ProtoAdapter<InputSource.Event>
{
  InputSource$Event$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public InputSource.Event decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    List localList1 = (List)new ArrayList();
    List localList2 = (List)new ArrayList();
    List localList3 = (List)new ArrayList();
    List localList4 = (List)new ArrayList();
    List localList5 = (List)new ArrayList();
    long l = paramProtoReader.beginMessage();
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new InputSource.Event(localList1, localList2, localList3, localList4, localList5, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                paramProtoReader.readUnknownField(i);
              } else {
                localList5.add(ProtoAdapter.INT32.decode(paramProtoReader));
              }
            }
            else {
              localList4.add(ProtoAdapter.INT32.decode(paramProtoReader));
            }
          }
          else {
            localList3.add(ProtoAdapter.INT32.decode(paramProtoReader));
          }
        }
        else {
          localList2.add(ProtoAdapter.INT32.decode(paramProtoReader));
        }
      }
      else {
        localList1.add(ProtoAdapter.INT32.decode(paramProtoReader));
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull InputSource.Event paramEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramEvent, "value");
    ProtoAdapter.INT32.asRepeated().encodeWithTag(paramProtoWriter, 1, paramEvent.DefalutTrail);
    ProtoAdapter.INT32.asRepeated().encodeWithTag(paramProtoWriter, 2, paramEvent.HighlightValueTrail);
    ProtoAdapter.INT32.asRepeated().encodeWithTag(paramProtoWriter, 3, paramEvent.DrumTrail);
    ProtoAdapter.INT32.asRepeated().encodeWithTag(paramProtoWriter, 4, paramEvent.SlowRhythmTrail);
    ProtoAdapter.INT32.asRepeated().encodeWithTag(paramProtoWriter, 5, paramEvent.StartValueTrail);
    paramProtoWriter.writeBytes(paramEvent.unknownFields());
  }
  
  public int encodedSize(@NotNull InputSource.Event paramEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramEvent, "value");
    return ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(1, paramEvent.DefalutTrail) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(2, paramEvent.HighlightValueTrail) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(3, paramEvent.DrumTrail) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(4, paramEvent.SlowRhythmTrail) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(5, paramEvent.StartValueTrail) + paramEvent.unknownFields().size();
  }
  
  @NotNull
  public InputSource.Event redact(@NotNull InputSource.Event paramEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramEvent, "value");
    return InputSource.Event.copy$default(paramEvent, null, null, null, null, null, ByteString.EMPTY, 31, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.InputSource.Event.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */