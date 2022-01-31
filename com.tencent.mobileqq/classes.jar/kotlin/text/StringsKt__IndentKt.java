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
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return (Function1)StringsKt__IndentKt.getIndentFunction.1.INSTANCE;
    }
    return (Function1)new StringsKt__IndentKt.getIndentFunction.2(paramString);
  }
  
  private static final int indentWidth$StringsKt__IndentKt(@NotNull String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int k = localCharSequence.length();
    int i = 0;
    int j;
    if (i < k) {
      if (!CharsKt.isWhitespace(localCharSequence.charAt(i)))
      {
        j = 1;
        label37:
        if (j == 0) {
          break label60;
        }
      }
    }
    for (;;)
    {
      j = i;
      if (i == -1) {
        j = paramString.length();
      }
      return j;
      j = 0;
      break label37;
      label60:
      i += 1;
      break;
      i = -1;
    }
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
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      String str1;
      if (i < 0)
      {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
          CollectionsKt.throwIndexOverflow();
        }
      }
      else
      {
        str1 = (String)paramList;
        if (((i != 0) && (i != j)) || (!StringsKt.isBlank((CharSequence)str1))) {
          break label135;
        }
        paramList = null;
      }
      for (;;)
      {
        if (paramList != null) {
          localCollection.add(paramList);
        }
        i += 1;
        break;
        throw ((Throwable)new ArithmeticException("Index overflow has happened."));
        label135:
        paramList = (String)paramFunction12.invoke(str1);
        if (paramList != null)
        {
          String str2 = (String)paramFunction11.invoke(paramList);
          paramList = str2;
          if (str2 != null) {}
        }
        else
        {
          paramList = str1;
        }
      }
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
    Object localObject1 = StringsKt.lines((CharSequence)paramString1);
    Object localObject3 = (Iterable)localObject1;
    Object localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    int i;
    label104:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      if (!StringsKt.isBlank((CharSequence)localObject4)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label104;
        }
        ((Collection)localObject2).add(localObject4);
        break;
      }
    }
    localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Integer.valueOf(indentWidth$StringsKt__IndentKt((String)((Iterator)localObject3).next())));
    }
    localObject2 = (Integer)CollectionsKt.min((Iterable)localObject2);
    int k;
    int m;
    int n;
    int j;
    if (localObject2 != null)
    {
      i = ((Integer)localObject2).intValue();
      k = paramString1.length();
      m = paramString2.length();
      n = ((List)localObject1).size();
      localObject2 = getIndentFunction$StringsKt__IndentKt(paramString2);
      int i1 = CollectionsKt.getLastIndex((List)localObject1);
      paramString1 = (Iterable)localObject1;
      localObject3 = (Collection)new ArrayList();
      localObject4 = paramString1.iterator();
      j = 0;
      label270:
      if (!((Iterator)localObject4).hasNext()) {
        break label383;
      }
      paramString1 = ((Iterator)localObject4).next();
      if (j < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      paramString2 = (String)paramString1;
      if (((j != 0) && (j != i1)) || (!StringsKt.isBlank((CharSequence)paramString2))) {
        break label347;
      }
      paramString1 = null;
    }
    for (;;)
    {
      if (paramString1 != null) {
        ((Collection)localObject3).add(paramString1);
      }
      j += 1;
      break label270;
      i = 0;
      break;
      label347:
      paramString1 = StringsKt.drop(paramString2, i);
      if (paramString1 != null)
      {
        localObject1 = (String)((Function1)localObject2).invoke(paramString1);
        paramString1 = (String)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramString1 = paramString2;
      }
    }
    label383:
    paramString1 = ((StringBuilder)CollectionsKt.joinTo$default((Iterable)localObject3, (Appendable)new StringBuilder(k + m * n), (CharSequence)"\n", null, null, 0, null, null, 124, null)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
    return paramString1;
  }
  
  @NotNull
  public static final String replaceIndentByMargin(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceIndentByMargin");
    Intrinsics.checkParameterIsNotNull(paramString2, "newIndent");
    Intrinsics.checkParameterIsNotNull(paramString3, "marginPrefix");
    if (!StringsKt.isBlank((CharSequence)paramString3)) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException("marginPrefix must be non-blank string.".toString()));
    }
    Object localObject = StringsKt.lines((CharSequence)paramString1);
    int m = paramString1.length();
    int n = paramString2.length();
    int i1 = ((List)localObject).size();
    Function1 localFunction1 = getIndentFunction$StringsKt__IndentKt(paramString2);
    int i2 = CollectionsKt.getLastIndex((List)localObject);
    paramString1 = (Iterable)localObject;
    Collection localCollection = (Collection)new ArrayList();
    int j = 0;
    Iterator localIterator = paramString1.iterator();
    while (localIterator.hasNext())
    {
      paramString1 = localIterator.next();
      if (j < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      paramString2 = (String)paramString1;
      if (((j == 0) || (j == i2)) && (StringsKt.isBlank((CharSequence)paramString2)))
      {
        paramString1 = null;
        if (paramString1 != null) {
          localCollection.add(paramString1);
        }
        j += 1;
      }
      else
      {
        paramString1 = (CharSequence)paramString2;
        i = 0;
        int i3 = paramString1.length();
        label219:
        int k;
        if (i < i3) {
          if (!CharsKt.isWhitespace(paramString1.charAt(i)))
          {
            k = 1;
            label241:
            if (k == 0) {
              break label289;
            }
            label246:
            if (i != -1) {
              break label301;
            }
            paramString1 = null;
          }
        }
        for (;;)
        {
          if (paramString1 != null)
          {
            localObject = (String)localFunction1.invoke(paramString1);
            paramString1 = (String)localObject;
            if (localObject != null) {
              break;
            }
          }
          paramString1 = paramString2;
          break;
          k = 0;
          break label241;
          label289:
          i += 1;
          break label219;
          i = -1;
          break label246;
          label301:
          if (StringsKt.startsWith$default(paramString2, paramString3, i, false, 4, null))
          {
            k = paramString3.length();
            if (paramString2 == null) {
              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            paramString1 = paramString2.substring(k + i);
            Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
          }
          else
          {
            paramString1 = null;
          }
        }
      }
    }
    paramString1 = ((StringBuilder)CollectionsKt.joinTo$default((Iterable)localCollection, (Appendable)new StringBuilder(m + n * i1), (CharSequence)"\n", null, null, 0, null, null, 124, null)).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
    return paramString1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.text.StringsKt__IndentKt
 * JD-Core Version:    0.7.0.1
 */