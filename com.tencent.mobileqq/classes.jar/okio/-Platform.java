package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"synchronized", "R", "lock", "", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asUtf8ToByteArray", "", "", "toUtf8String", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "EOFException", "Ljava/io/EOFException;", "IOException", "Ljava/io/IOException;", "okio"}, k=2, mv={1, 1, 16})
@JvmName(name="-Platform")
public final class -Platform
{
  @NotNull
  public static final byte[] asUtf8ToByteArray(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$asUtf8ToByteArray");
    paramString = paramString.getBytes(Charsets.UTF_8);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
    return paramString;
  }
  
  public static final <R> R jdMethod_synchronized(@NotNull Object paramObject, @NotNull Function0<? extends R> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "lock");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    try
    {
      paramFunction0 = paramFunction0.invoke();
      return paramFunction0;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      InlineMarker.finallyEnd(1);
    }
  }
  
  @NotNull
  public static final String toUtf8String(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toUtf8String");
    return new String(paramArrayOfByte, Charsets.UTF_8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.-Platform
 * JD-Core Version:    0.7.0.1
 */