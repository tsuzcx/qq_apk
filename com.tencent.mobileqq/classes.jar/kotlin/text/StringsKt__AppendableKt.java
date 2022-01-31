package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"append", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendElement", "", "element", "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "appendRange", "startIndex", "", "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/StringsKt")
public class StringsKt__AppendableKt
{
  @NotNull
  public static final <T extends Appendable> T append(@NotNull T paramT, @NotNull CharSequence... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "$this$append");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "value");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramT.append(paramVarArgs[i]);
      i += 1;
    }
    return paramT;
  }
  
  public static final <T> void appendElement(@NotNull Appendable paramAppendable, T paramT, @Nullable Function1<? super T, ? extends CharSequence> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramAppendable, "$this$appendElement");
    if (paramFunction1 != null)
    {
      paramAppendable.append((CharSequence)paramFunction1.invoke(paramT));
      return;
    }
    if (paramT != null) {}
    for (boolean bool = paramT instanceof CharSequence; bool; bool = true)
    {
      paramAppendable.append((CharSequence)paramT);
      return;
    }
    if ((paramT instanceof Character))
    {
      paramAppendable.append(((Character)paramT).charValue());
      return;
    }
    paramAppendable.append((CharSequence)String.valueOf(paramT));
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T extends Appendable> T appendRange(@NotNull T paramT, @Nullable CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "$this$appendRange");
    paramT = paramT.append(paramCharSequence, paramInt1, paramInt2);
    if (paramT == null) {
      throw new TypeCastException("null cannot be cast to non-null type T");
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.text.StringsKt__AppendableKt
 * JD-Core Version:    0.7.0.1
 */