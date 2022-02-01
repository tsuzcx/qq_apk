package com.tencent.tkd.topicsdk.common;

import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/EmojiUtils;", "", "()V", "emojiSignatureSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "addUnicodeToSet", "", "set", "", "code", "", "", "codeStart", "codeEnd", "containsEmoji", "s", "", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class EmojiUtils
{
  public static final EmojiUtils a = new EmojiUtils();
  private static HashSet<Character> b;
  
  static
  {
    HashSet localHashSet = new HashSet();
    EmojiUtils localEmojiUtils = a;
    Set localSet = (Set)localHashSet;
    localEmojiUtils.a(localSet, 127);
    a.a(localSet, 169);
    a.a(localSet, 174);
    a.a(localSet, 8205);
    a.a(localSet, 8252);
    a.a(localSet, 8265);
    a.a(localSet, 8419);
    a.a(localSet, 8482);
    a.a(localSet, 8505);
    a.a(localSet, 8596, 8601);
    a.a(localSet, 8617, 8618);
    a.a(localSet, 8986, 8987);
    a.a(localSet, 9000);
    a.a(localSet, 9096);
    a.a(localSet, 9167);
    a.a(localSet, 9193, 9203);
    a.a(localSet, 9208, 9210);
    a.a(localSet, 9410);
    a.a(localSet, 9642, 9643);
    a.a(localSet, 9654);
    a.a(localSet, 9664);
    a.a(localSet, 9723, 9726);
    a.a(localSet, 9728, 9733);
    a.a(localSet, 9735, 9746);
    a.a(localSet, 9748, 9861);
    a.a(localSet, 9872, 9989);
    a.a(localSet, 9992, 10002);
    a.a(localSet, 10004);
    a.a(localSet, 10006);
    a.a(localSet, 10013);
    a.a(localSet, 10017);
    a.a(localSet, 10024);
    a.a(localSet, 10035, 10036);
    a.a(localSet, 10052);
    a.a(localSet, 10055);
    a.a(localSet, 10060);
    a.a(localSet, 10062);
    a.a(localSet, 10067, 10069);
    a.a(localSet, 10071);
    a.a(localSet, 10083, 10087);
    a.a(localSet, 10133, 10135);
    a.a(localSet, 10145);
    a.a(localSet, 10160);
    a.a(localSet, 10175);
    a.a(localSet, 10548, 10549);
    a.a(localSet, 11013, 11015);
    a.a(localSet, 11035, 11036);
    a.a(localSet, 11088);
    a.a(localSet, 11093);
    a.a(localSet, 12336);
    a.a(localSet, 12349);
    a.a(localSet, 12951);
    a.a(localSet, 12953);
    a.a(localSet, 61440, 61483);
    a.a(localSet, 61488, 61587);
    a.a(localSet, 61600, 61614);
    a.a(localSet, 61617, 61631);
    a.a(localSet, 61633, 61647);
    a.a(localSet, 61649, 61685);
    a.a(localSet, 61743);
    a.a(localSet, 61808, 61809);
    a.a(localSet, 61822, 61823);
    a.a(localSet, 61838);
    a.a(localSet, 61841, 61850);
    a.a(localSet, 61926, 61951);
    a.a(localSet, 61953, 61954);
    a.a(localSet, 61978);
    a.a(localSet, 61999);
    a.a(localSet, 62002, 62010);
    a.a(localSet, 62032, 62033);
    a.a(localSet, 62048, 62053);
    a.a(localSet, 62208, 62781);
    a.a(localSet, 62790, 63055);
    a.a(localSet, 63104, 63188);
    a.a(localSet, 63200, 63212);
    a.a(localSet, 63216, 63225);
    a.a(localSet, 63445, 63448);
    a.a(localSet, 63760, 63802);
    a.a(localSet, 63804, 63806);
    a.a(localSet, 63808, 63813);
    a.a(localSet, 63815, 63856);
    a.a(localSet, 63859, 63862);
    a.a(localSet, 63866);
    a.a(localSet, 63868, 63906);
    a.a(localSet, 63920, 63929);
    a.a(localSet, 63936, 63938);
    a.a(localSet, 63952, 63999);
    a.a(localSet, 64096, 64109);
    a.a(localSet, 65038, 65039);
    b = localHashSet;
  }
  
  private final void a(Set<Character> paramSet, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2) {
      for (;;)
      {
        a(paramSet, paramInt1);
        if (paramInt1 == paramInt2) {
          break;
        }
        paramInt1 += 1;
      }
    }
  }
  
  private final boolean a(Set<Character> paramSet, int paramInt)
  {
    return paramSet.add(Character.valueOf((char)paramInt));
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "s");
    paramString = paramString.toCharArray();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toCharArray()");
    int i1 = paramString.length;
    int m;
    for (int k = 0; k < i1; k = m + 1)
    {
      int j = paramString[k];
      int i;
      if (55296 > j)
      {
        m = k;
        i = j;
      }
      else
      {
        m = k;
        i = j;
        if (56319 >= j)
        {
          int n = k + 1;
          m = k;
          i = j;
          if (n < i1)
          {
            i = (char)((j - 55296) * 1024 + 65536 + (paramString[n] - 56320));
            m = n;
          }
        }
      }
      if (b.contains(Character.valueOf(i))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.EmojiUtils
 * JD-Core Version:    0.7.0.1
 */