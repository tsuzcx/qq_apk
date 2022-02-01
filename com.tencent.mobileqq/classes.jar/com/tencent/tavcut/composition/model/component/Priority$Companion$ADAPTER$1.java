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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/Priority$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/Priority;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Priority$Companion$ADAPTER$1
  extends ProtoAdapter<Priority>
{
  Priority$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Priority decode(@NotNull ProtoReader paramProtoReader)
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
        return new Priority(localInteger1, localInteger2, localBoolean, str, localInteger3, paramProtoReader.endMessageAndGetUnknownFields(l));
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
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull Priority paramPriority)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramPriority, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramPriority.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramPriority.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramPriority.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramPriority.type);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 5, paramPriority.priority);
    paramProtoWriter.writeBytes(paramPriority.unknownFields());
  }
  
  public int encodedSize(@NotNull Priority paramPriority)
  {
    Intrinsics.checkParameterIsNotNull(paramPriority, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramPriority.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramPriority.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramPriority.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramPriority.type) + ProtoAdapter.INT32.encodedSizeWithTag(5, paramPriority.priority) + paramPriority.unknownFields().size();
  }
  
  @NotNull
  public Priority redact(@NotNull Priority paramPriority)
  {
    Intrinsics.checkParameterIsNotNull(paramPriority, "value");
    return Priority.copy$default(paramPriority, null, null, null, null, null, ByteString.EMPTY, 31, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.Priority.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */