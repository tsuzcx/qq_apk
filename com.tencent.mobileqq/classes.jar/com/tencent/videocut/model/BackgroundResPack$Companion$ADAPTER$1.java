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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/videocut/model/BackgroundResPack$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/BackgroundResPack;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "encodedSize", "", "redact", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class BackgroundResPack$Companion$ADAPTER$1
  extends ProtoAdapter<BackgroundResPack>
{
  BackgroundResPack$Companion$ADAPTER$1(FieldEncoding paramFieldEncoding, KClass paramKClass, String paramString)
  {
    super(paramFieldEncoding, paramKClass, paramString);
  }
  
  public int a(@NotNull BackgroundResPack paramBackgroundResPack)
  {
    Intrinsics.checkParameterIsNotNull(paramBackgroundResPack, "value");
    return ProtoAdapter.STRING.encodedSizeWithTag(1, paramBackgroundResPack.ratio16to9) + ProtoAdapter.STRING.encodedSizeWithTag(2, paramBackgroundResPack.ratio9to16) + ProtoAdapter.STRING.encodedSizeWithTag(3, paramBackgroundResPack.ratio1to1) + ProtoAdapter.STRING.encodedSizeWithTag(4, paramBackgroundResPack.ratio3to4) + ProtoAdapter.STRING.encodedSizeWithTag(5, paramBackgroundResPack.ratio4to3) + ProtoAdapter.STRING.encodedSizeWithTag(6, paramBackgroundResPack.ratio1to2) + paramBackgroundResPack.unknownFields().size();
  }
  
  @NotNull
  public BackgroundResPack a(@NotNull ProtoReader paramProtoReader)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoReader, "reader");
    String str1 = (String)null;
    long l = paramProtoReader.beginMessage();
    String str2 = str1;
    String str3 = str2;
    String str4 = str3;
    String str5 = str4;
    String str6 = str5;
    for (;;)
    {
      int i = paramProtoReader.nextTag();
      if (i == -1) {
        return new BackgroundResPack(str1, str2, str3, str4, str5, str6, paramProtoReader.endMessageAndGetUnknownFields(l));
      }
      switch (i)
      {
      default: 
        paramProtoReader.readUnknownField(i);
        break;
      case 6: 
        str6 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 5: 
        str5 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 4: 
        str4 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 3: 
        str3 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 2: 
        str2 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
        break;
      case 1: 
        str1 = (String)ProtoAdapter.STRING.decode(paramProtoReader);
      }
    }
  }
  
  public void a(@NotNull ProtoWriter paramProtoWriter, @NotNull BackgroundResPack paramBackgroundResPack)
  {
    Intrinsics.checkParameterIsNotNull(paramProtoWriter, "writer");
    Intrinsics.checkParameterIsNotNull(paramBackgroundResPack, "value");
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 1, paramBackgroundResPack.ratio16to9);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 2, paramBackgroundResPack.ratio9to16);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 3, paramBackgroundResPack.ratio1to1);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 4, paramBackgroundResPack.ratio3to4);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 5, paramBackgroundResPack.ratio4to3);
    ProtoAdapter.STRING.encodeWithTag(paramProtoWriter, 6, paramBackgroundResPack.ratio1to2);
    paramProtoWriter.writeBytes(paramBackgroundResPack.unknownFields());
  }
  
  @NotNull
  public BackgroundResPack b(@NotNull BackgroundResPack paramBackgroundResPack)
  {
    Intrinsics.checkParameterIsNotNull(paramBackgroundResPack, "value");
    return BackgroundResPack.copy$default(paramBackgroundResPack, null, null, null, null, null, null, ByteString.EMPTY, 63, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.model.BackgroundResPack.Companion.ADAPTER.1
 * JD-Core Version:    0.7.0.1
 */