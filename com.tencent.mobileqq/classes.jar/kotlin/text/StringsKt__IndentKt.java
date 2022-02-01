package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__IndentKt
  extends StringsKt__AppendableKt
{
  private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(String paramString)
  {
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return (Function1)StringsKt__IndentKt.getIndentFunction.1.INSTANCE;
    }
    return (Function1)new StringsKt__IndentKt.getIndentFunction.2(paramString);
  }
  
  private static final int indentWidth$StringsKt__IndentKt(@NotNull String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int j = localCharSequence.length();
    int i = 0;
    while (i < j)
    {
      if ((CharsKt.isWhitespace(localCharSequence.charAt(i)) ^ true)) {
        break label46;
      }
      i += 1;
    }
    i = -1;
    label46:
    j = i;
    if (i == -1) {
      j = paramString.length();
    }
    return j;
  }
  
  @NotNull
  public static final String prependIndent(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$prependIndent");
    Intrinsics.checkParameterIsNotNull(paramString2, "indent");
    return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence((CharSequence)paramString1), (Function1)new StringsKt__IndentKt.prependIndent.1(paramString2)), (CharSequence)"\n", null, null, 0, null, null, 62, null);
  }
  
  private static final String reindent$StringsKt__IndentKt(@NotNull List<String> paramList, int paramInt, Function1<? super String, String> paramFunction11, Function1<? super String, String> paramFunction12)
  {
    int j = CollectionsKt.getLastIndex(paramList);
    paramList = (Iterable)paramList;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        } else {
          throw ((Throwable)new ArithmeticException("Index overflow has happened."));
        }
      }
      String str1 = (String)paramList;
      if (((i == 0) || (i == j)) && (StringsKt.isBlank((CharSequence)str1)))
      {
        paramList = null;
      }
      else
      {
        String str2 = (String)paramFunction12.invoke(str1);
        paramList = str1;
        if (str2 != null)
        {
          str2 = (String)paramFunction11.invoke(str2);
          paramList = str1;
          if (str2 != null) {
            paramList = str2;
          }
        }
      }
      if (paramList != null) {
        localCollection.add(paramList);
      }
      i += 1;
    }
    paramList = ((StringBuilder)CollectionsKt.joinTo$default((Iterable)localCollection, (Appendable)new StringBuilder(paramInt), (CharSequence)"\n", null, null, 0, null, null, 124, null)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramList, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
    return paramList;
  }
  
  @NotNull
  public static final String replaceIndent(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceIndent");
    Intrinsics.checkParameterIsNotNull(paramString2, "newIndent");
    Object localObject2 = StringsKt.lines((CharSequence)paramString1);
    Object localObject1 = (Iterable)localObject2;
    Object localObject3 = (Collection)new ArrayList();
    Object localObject4 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = ((Iterator)localObject4).next();
      if ((StringsKt.isBlank((CharSequence)localObject5) ^ true)) {
        ((Collection)localObject3).add(localObject5);
      }
    }
    localObject4 = (Iterable)localObject3;
    localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext()) {
      ((Collection)localObject3).add(Integer.valueOf(indentWidth$StringsKt__IndentKt((String)((Iterator)localObject4).next())));
    }
    localObject3 = (Integer)CollectionsKt.min((Iterable)localObject3);
    int j = 0;
    int i;
    if (localObject3 != null) {
      i = ((Integer)localObject3).intValue();
    } else {
      i = 0;
    }
    int k = paramString1.length();
    int m = paramString2.length();
    int n = ((List)localObject2).size();
    localObject3 = getIndentFunction$StringsKt__IndentKt(paramString2);
    int i1 = CollectionsKt.getLastIndex((List)localObject2);
    localObject2 = (Collection)new ArrayList();
    localObject4 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      paramString1 = ((Iterator)localObject4).next();
      if (j < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      paramString2 = (String)paramString1;
      if (((j == 0) || (j == i1)) && (StringsKt.isBlank((CharSequence)paramString2)))
      {
        paramString1 = null;
      }
      else
      {
        localObject1 = StringsKt.drop(paramString2, i);
        paramString1 = paramString2;
        if (localObject1 != null)
        {
          localObject1 = (String)((Function1)localObject3).invoke(localObject1);
          paramString1 = paramString2;
          if (localObject1 != null) {
            paramString1 = (String)localObject1;
          }
        }
      }
      if (paramString1 != null) {
        ((Collection)localObject2).add(paramString1);
      }
      j += 1;
    }
    paramString1 = ((StringBuilder)CollectionsKt.joinTo$default((Iterable)localObject2, (Appendable)new StringBuilder(k + m * n), (CharSequence)"\n", null, null, 0, null, null, 124, null)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
    return paramString1;
  }
  
  @NotNull
  public static final String replaceIndentByMargin(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceIndentByMargin");
    Intrinsics.checkParameterIsNotNull(paramString2, "newIndent");
    Intrinsics.checkParameterIsNotNull(paramString3, "marginPrefix");
    if ((StringsKt.isBlank((CharSequence)paramString3) ^ true))
    {
      Object localObject = StringsKt.lines((CharSequence)paramString1);
      int k = paramString1.length();
      int m = paramString2.length();
      int n = ((List)localObject).size();
      Function1 localFunction1 = getIndentFunction$StringsKt__IndentKt(paramString2);
      int i1 = CollectionsKt.getLastIndex((List)localObject);
      paramString1 = (Iterable)localObject;
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramString1.iterator();
      int j = 0;
      while (localIterator.hasNext())
      {
        paramString1 = localIterator.next();
        if (j < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject = (String)paramString1;
        paramString2 = null;
        if (((j == 0) || (j == i1)) && (StringsKt.isBlank((CharSequence)localObject)))
        {
          paramString1 = null;
        }
        else
        {
          paramString1 = (CharSequence)localObject;
          int i2 = paramString1.length();
          int i = 0;
          while (i < i2)
          {
            if ((CharsKt.isWhitespace(paramString1.charAt(i)) ^ true)) {
              break label213;
            }
            i += 1;
          }
          i = -1;
          label213:
          if ((i != -1) && (StringsKt.startsWith$default((String)localObject, paramString3, i, false, 4, null)))
          {
            i2 = paramString3.length();
            if (localObject != null)
            {
              paramString2 = ((String)localObject).substring(i + i2);
              Intrinsics.checkExpressionValueIsNotNull(paramString2, "(this as java.lang.String).substring(startIndex)");
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
          }
          paramString1 = (String)localObject;
          if (paramString2 != null)
          {
            paramString2 = (String)localFunction1.invoke(paramString2);
            paramString1 = (String)localObject;
            if (paramString2 != null) {
              paramString1 = paramString2;
            }
          }
        }
        if (paramString1 != null) {
          localCollection.add(paramString1);
        }
        j += 1;
      }
      paramString1 = ((StringBuilder)CollectionsKt.joinTo$default((Iterable)localCollection, (Appendable)new StringBuilder(k + m * n), (CharSequence)"\n", null, null, 0, null, null, 124, null)).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
      return paramString1;
    }
    paramString1 = (Throwable)new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    for (;;)
    {
      throw paramString1;
    }
  }
  
  @NotNull
  public static final String trimIndent(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$trimIndent");
    return StringsKt.replaceIndent(paramString, "");
  }
  
  @NotNull
  public static final String trimMargin(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$trimMargin");
    Intrinsics.checkParameterIsNotNull(paramString2, "marginPrefix");
    return StringsKt.replaceIndentByMargin(paramString1, "", paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.text.StringsKt__IndentKt
 * JD-Core Version:    0.7.0.1
 */