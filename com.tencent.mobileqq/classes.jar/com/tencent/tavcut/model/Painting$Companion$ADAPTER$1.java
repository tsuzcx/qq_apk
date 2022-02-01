package com.tencent.tavcut.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoAdapter.EnumConstantNotFoundException;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.tencent.tavcut.composition.model.component.BackgroundFillMode;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/model/Painting$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/tavcut/model/Painting;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
public final class Painting$Companion$ADAPTER$1
  extends ProtoAdapter<Painting>
{
  Painting$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  @NotNull
  public Painting decode(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    Size localSize = (Size)null;
    ScreenTransform localScreenTransform = (ScreenTransform)null;
    Object localObject = (BackgroundFillMode)null;
    String str1 = (String)null;
    Float localFloat = (Float)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new Painting(localSize, localScreenTransform, (BackgroundFillMode)localObject, str1, str2, localFloat, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 6: 
        localFloat = (Float)ProtoAdapter.FLOAT.decode(paramProtoReader);
        break;
      case 5: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 4: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 3: 
        try
        {
          BackgroundFillMode localBackgroundFillMode = (BackgroundFillMode)BackgroundFillMode.ADAPTER.decode(paramProtoReader);
          localObject = localBackgroundFillMode;
        }
        catch (ProtoAdapter.EnumConstantNotFoundException localEnumConstantNotFoundException)
        {
          paramProtoReader.addUnknownField(i, FieldEncoding.VARINT, Long.valueOf(localEnumConstantNotFoundException.value));
        }
        break;
      case 2: 
        localScreenTransform = (ScreenTransform)ScreenTransform.ADAPTER.decode(paramProtoReader);
        break;
      case 1: 
        localSize = (Size)Size.ADAPTER.decode(paramProtoReader);
      }
    }
  }
  
  public void encode(@NotNull ProtoWriter paramProtoWriter, @NotNull Painting paramPainting)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramPainting, "value");
    Size.ADAPTER.encodeWithTag(paramProtoWriter, 1, paramPainting.renderSize);
    ScreenTransform.ADAPTER.encodeWithTag(paramProtoWriter, 2, paramPainting.screenTransform);
    BackgroundFillMode.ADAPTER.encodeWithTag(paramProtoWriter, 3, paramPainting.backgroundFillMode);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramPainting.pagPath);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramPainting.backgroundColor);
    ProtoAdapter.FLOAT.encodeWithTag(paramProtoWriter, 6, paramPainting.fillScale);
    paramProtoWriter.writeBytes(paramPainting.unknownFields());
  }
  
  public int encodedSize(@NotNull Painting paramPainting)
  {
    Intrinsics.checkParameterIsNotNull(paramPainting, "value");
    return Size.ADAPTER.encodedSizeWithTag(1, paramPainting.renderSize) + ScreenTransform.ADAPTER.encodedSizeWithTag(2, paramPainting.screenTransform) + BackgroundFillMode.ADAPTER.encodedSizeWithTag(3, paramPainting.backgroundFillMode) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramPainting.pagPath) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramPainting.backgroundColor) + ProtoAdapter.FLOAT.encodedSizeWithTag(6, paramPainting.fillScale) + paramPainting.unknownFields().size();
  }
  
  @NotNull
  public Painting redact(@NotNull Painting paramPainting)
  {
    Intrinsics.checkParameterIsNotNull(paramPainting, "value");
    Size localSize = paramPainting.renderSize;
    ScreenTransform localScreenTransform1 = null;
    if (localSize != null) {
      localSize = (Size)Size.ADAPTER.redact(localSize);
    } else {
      localSize = null;
    }
    ScreenTransform localScreenTransform2 = paramPainting.screenTransform;
    if (localScreenTransform2 != null) {
      localScreenTransform1 = (ScreenTransform)ScreenTransform.ADAPTER.redact(localScreenTransform2);
    }
    return Painting.copy$default(paramPainting, localSize, localScreenTransform1, null, null, null, null, ByteString.EMPTY, 60, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.model.Painting.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */