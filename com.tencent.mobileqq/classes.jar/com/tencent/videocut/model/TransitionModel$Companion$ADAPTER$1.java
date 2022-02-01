package com.tencent.videocut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/TransitionModel$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/TransitionModel;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class TransitionModel$Companion$ADAPTER$1
  extends ProtoAdapter<TransitionModel>
{
  TransitionModel$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull TransitionModel paramTransitionModel)
  {
    Intrinsics.checkParameterIsNotNull(paramTransitionModel, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramTransitionModel.id) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramTransitionModel.path) + ProtoAdapter.INT32.encodedSizeWithTag(3, Integer.valueOf(paramTransitionModel.position)) + ProtoAdapter.INT64.encodedSizeWithTag(4, Long.valueOf(paramTransitionModel.duration)) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramTransitionModel.landscapePagPath) + ProtoAdapter.STRING.encodedSizeWithTag(6, paramTransitionModel.pagPath) + ProtoAdapter.BOOL.encodedSizeWithTag(7, Boolean.valueOf(paramTransitionModel.isLandscape)) + ProtoAdapter.STRING.encodedSizeWithTag(8, paramTransitionModel.resId) + ProtoAdapter.STRING.encodedSizeWithTag(9, paramTransitionModel.relatedClipId) + ProtoAdapter.STRING.encodedSizeWithTag(10, paramTransitionModel.categoryId) + paramTransitionModel.unknownFields().size();
  }
  
  @NotNull
  public TransitionModel a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Boolean localBoolean = (Boolean)null;
    long l2 = paramProtoReader.beginMessage();
    String str7 = "";
    String str1 = str7;
    String str2 = str1;
    String str3 = str2;
    String str4 = str3;
    String str5 = str4;
    String str6 = str5;
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      int j = paramProtoReader.nextTag();
      if (j == -1)
      {
        paramProtoReader = paramProtoReader.endMessageAndGetUnknownFields(l2);
        boolean bool;
        if (localBoolean != null) {
          bool = localBoolean.booleanValue();
        } else {
          bool = false;
        }
        return new TransitionModel(str7, str1, i, l1, str2, str3, bool, str4, str5, str6, paramProtoReader);
      }
      switch (j)
      {
      default: 
        paramProtoReader.readUnknownField(j);
        break;
      case 10: 
        str6 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 9: 
        str5 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 8: 
        str4 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 7: 
        localBoolean = (Boolean)ProtoAdapter.BOOL.decode(paramProtoReader);
        break;
      case 6: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 5: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 4: 
        l1 = ((Number)ProtoAdapter.INT64.decode(paramProtoReader)).longValue();
        break;
      case 3: 
        i = ((Number)ProtoAdapter.INT32.decode(paramProtoReader)).intValue();
        break;
      case 2: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        str7 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull TransitionModel paramTransitionModel)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramTransitionModel, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramTransitionModel.id);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramTransitionModel.path);
    ProtoAdapter.INT32.encodeWithTag(paramProtoWriter, 3, Integer.valueOf(paramTransitionModel.position));
    ProtoAdapter.INT64.encodeWithTag(paramProtoWriter, 4, Long.valueOf(paramTransitionModel.duration));
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramTransitionModel.landscapePagPath);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 6, paramTransitionModel.pagPath);
    ProtoAdapter.BOOL.encodeWithTag(paramProtoWriter, 7, Boolean.valueOf(paramTransitionModel.isLandscape));
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 8, paramTransitionModel.resId);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 9, paramTransitionModel.relatedClipId);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 10, paramTransitionModel.categoryId);
    paramProtoWriter.writeBytes(paramTransitionModel.unknownFields());
  }
  
  @NotNull
  public TransitionModel b(@NotNull TransitionModel paramTransitionModel)
  {
    Intrinsics.checkParameterIsNotNull(paramTransitionModel, "value");
    return TransitionModel.copy$default(paramTransitionModel, null, null, null, null, null, null, null, null, null, null, ByteString.EMPTY, 1023, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.TransitionModel.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */