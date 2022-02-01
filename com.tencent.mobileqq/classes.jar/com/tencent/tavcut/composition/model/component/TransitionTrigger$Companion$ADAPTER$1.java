package com.tencent.tavcut.composition.model.component;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/TransitionTrigger$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/TransitionTrigger;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class TransitionTrigger$Companion$ADAPTER$1
  extends ProtoAdapter<TransitionTrigger>
{
  TransitionTrigger$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public TransitionTrigger decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean = (Boolean)null;
    String str = (String)null;
    long l = paramProtoReader.beginMessage();
    Integer localInteger2 = localInteger1;
    Integer localInteger3 = localInteger2;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new TransitionTrigger(localInteger1, localInteger2, localBoolean, str, localInteger3, paramProtoReader.endMessageAndGetUnknownFields(l));
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
                localInteger3 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
              }
            }
            else {
              str = (String)ProtoAdapter.STRING.decode(paramProtoReader);
            }
          }
          else {
            localBoolean = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
          }
        }
        else {
          localInteger2 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
        }
      }
      else {
        localInteger1 = (Integer)ProtoAdapter.INT32.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull TransitionTrigger paramTransitionTrigger)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramTransitionTrigger, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramTransitionTrigger.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramTransitionTrigger.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramTransitionTrigger.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramTransitionTrigger.type);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 5, paramTransitionTrigger.threshold);
    paramProtoWriter.writeBytes(paramTransitionTrigger.unknownFields());
  }
  
  public int encodedSize(@NotNull TransitionTrigger paramTransitionTrigger)
  {
    Intrinsics.checkParameterIsNotNull(paramTransitionTrigger, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramTransitionTrigger.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramTransitionTrigger.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramTransitionTrigger.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramTransitionTrigger.type) + ProtoAdapter.INT32.encodedSizeWithTag(5, paramTransitionTrigger.threshold) + paramTransitionTrigger.unknownFields().size();
  }
  
  @NotNull
  public TransitionTrigger redact(@NotNull TransitionTrigger paramTransitionTrigger)
  {
    Intrinsics.checkParameterIsNotNull(paramTransitionTrigger, "value");
    return TransitionTrigger.copy$default(paramTransitionTrigger, null, null, null, null, null, ByteString.EMPTY, 31, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.TransitionTrigger.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */