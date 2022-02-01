package com.tencent.mobileqq.kandian.base.ktx;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toBoolean", "", "Lcom/tencent/mobileqq/pb/PBBoolField;", "toByteArrayOrNull", "", "Lcom/tencent/mobileqq/pb/PBBytesField;", "toEnum", "", "Lcom/tencent/mobileqq/pb/PBEnumField;", "toInt", "Lcom/tencent/mobileqq/pb/PBUInt32Field;", "defaultValue", "toLong", "", "Lcom/tencent/mobileqq/pb/PBUInt64Field;", "toPBListValue", "", "P", "Lcom/tencent/mobileqq/pb/MessageMicro;", "Lcom/tencent/mobileqq/pb/PBRepeatMessageField;", "toPBParseValue", "R", "pbParser", "Lcom/tencent/mobileqq/kandian/base/ktx/IPbParser;", "(Lcom/tencent/mobileqq/pb/MessageMicro;Ljava/lang/Object;Lcom/tencent/mobileqq/kandian/base/ktx/IPbParser;)Ljava/lang/Object;", "toPBValue", "(Lcom/tencent/mobileqq/pb/MessageMicro;Lcom/tencent/mobileqq/pb/MessageMicro;)Lcom/tencent/mobileqq/pb/MessageMicro;", "toString", "", "Lcom/tencent/mobileqq/pb/PBStringField;", "toStringOrNull", "toStringUtf8", "toStringUtf8OrNull", "kandian-api_release"}, k=2, mv={1, 1, 16})
@JvmName(name="PBFieldUtils")
public final class PBFieldUtils
{
  public static final int a(@NotNull PBEnumField paramPBEnumField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBEnumField, "$this$toEnum");
    if (paramPBEnumField.has()) {
      return paramPBEnumField.get();
    }
    return 0;
  }
  
  public static final int a(@NotNull PBUInt32Field paramPBUInt32Field)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "$this$toInt");
    if (paramPBUInt32Field.has()) {
      return paramPBUInt32Field.get();
    }
    return 0;
  }
  
  public static final int a(@NotNull PBUInt32Field paramPBUInt32Field, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt32Field, "$this$toInt");
    if (paramPBUInt32Field.has()) {
      paramInt = paramPBUInt32Field.get();
    }
    return paramInt;
  }
  
  public static final long a(@NotNull PBUInt64Field paramPBUInt64Field)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt64Field, "$this$toLong");
    if (paramPBUInt64Field.has()) {
      return paramPBUInt64Field.get();
    }
    return 0L;
  }
  
  public static final long a(@NotNull PBUInt64Field paramPBUInt64Field, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramPBUInt64Field, "$this$toLong");
    if (paramPBUInt64Field.has()) {
      paramLong = paramPBUInt64Field.get();
    }
    return paramLong;
  }
  
  @Nullable
  public static final <P extends MessageMicro<P>> P a(@NotNull MessageMicro<P> paramMessageMicro, @Nullable P paramP)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageMicro, "$this$toPBValue");
    if (paramMessageMicro.has()) {
      paramP = paramMessageMicro.get();
    }
    return paramP;
  }
  
  @Nullable
  public static final <P extends MessageMicro<P>, R> R a(@NotNull MessageMicro<P> paramMessageMicro, @Nullable R paramR, @NotNull IPbParser<P, R> paramIPbParser)
  {
    Intrinsics.checkParameterIsNotNull(paramMessageMicro, "$this$toPBParseValue");
    Intrinsics.checkParameterIsNotNull(paramIPbParser, "pbParser");
    if (paramMessageMicro.has())
    {
      paramMessageMicro = paramMessageMicro.get();
      Intrinsics.checkExpressionValueIsNotNull(paramMessageMicro, "get()");
      paramR = paramIPbParser.a(paramMessageMicro);
    }
    return paramR;
  }
  
  @Nullable
  public static final String a(@NotNull PBBytesField paramPBBytesField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBytesField, "$this$toStringUtf8OrNull");
    if (paramPBBytesField.has()) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  @Nullable
  public static final String a(@NotNull PBBytesField paramPBBytesField, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBytesField, "$this$toStringUtf8");
    if (paramPBBytesField.has()) {
      paramString = paramPBBytesField.get().toStringUtf8();
    }
    return paramString;
  }
  
  @Nullable
  public static final String a(@NotNull PBStringField paramPBStringField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBStringField, "$this$toStringOrNull");
    if (paramPBStringField.has()) {
      return paramPBStringField.get().toString();
    }
    return null;
  }
  
  public static final boolean a(@NotNull PBBoolField paramPBBoolField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBoolField, "$this$toBoolean");
    if (paramPBBoolField.has()) {
      return paramPBBoolField.get();
    }
    return false;
  }
  
  @Nullable
  public static final byte[] b(@NotNull PBBytesField paramPBBytesField)
  {
    Intrinsics.checkParameterIsNotNull(paramPBBytesField, "$this$toByteArrayOrNull");
    if (paramPBBytesField.has()) {
      return paramPBBytesField.get().toByteArray();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.ktx.PBFieldUtils
 * JD-Core Version:    0.7.0.1
 */