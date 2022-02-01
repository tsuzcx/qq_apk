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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/composition/model/component/FilterGroup$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/composition/model/component/FilterGroup;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class FilterGroup$Companion$ADAPTER$1
  extends ProtoAdapter<FilterGroup>
{
  FilterGroup$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public FilterGroup decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Integer localInteger1 = (Integer)null;
    Boolean localBoolean = (Boolean)null;
    String str1 = (String)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    Integer localInteger2 = localInteger1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new FilterGroup(localInteger1, localInteger2, localBoolean, str1, str2, paramProtoReader.endMessageAndGetUnknownFields(l));
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
                str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
              }
            }
            else {
              str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
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
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull FilterGroup paramFilterGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramFilterGroup, "value");
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 1, paramFilterGroup.entityId);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 2, paramFilterGroup.componentID);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 3, paramFilterGroup.enabled);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramFilterGroup.type);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramFilterGroup.name);
    paramProtoWriter.writeBytes(paramFilterGroup.unknownFields());
  }
  
  public int encodedSize(@NotNull FilterGroup paramFilterGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramFilterGroup, "value");
    return ProtoAdapter.INT32.encodedSizeWithTag(1, paramFilterGroup.entityId) + ProtoAdapter.INT32.encodedSizeWithTag(2, paramFilterGroup.componentID) + ProtoAdapter.BOOL.encodedSizeWithTag(3, paramFilterGroup.enabled) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramFilterGroup.type) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramFilterGroup.name) + paramFilterGroup.unknownFields().size();
  }
  
  @NotNull
  public FilterGroup redact(@NotNull FilterGroup paramFilterGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramFilterGroup, "value");
    return FilterGroup.copy$default(paramFilterGroup, null, null, null, null, null, ByteString.EMPTY, 31, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.composition.model.component.FilterGroup.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */