package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"contentDeepEqualsImpl", "", "T", "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/ArraysKt")
class ArraysKt__ArraysKt
  extends ArraysKt__ArraysJVMKt
{
  @PublishedApi
  @SinceKotlin(version="1.3")
  @JvmName(name="contentDeepEquals")
  public static final <T> boolean contentDeepEquals(@NotNull T[] paramArrayOfT1, @NotNull T[] paramArrayOfT2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT1, "$this$contentDeepEqualsImpl");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT2, "other");
    if (paramArrayOfT1 == paramArrayOfT2) {
      return true;
    }
    if (paramArrayOfT1.length != paramArrayOfT2.length) {
      return false;
    }
    int j = paramArrayOfT1.length;
    int i = 0;
    label142:
    label176:
    label312:
    label460:
    if (i < j)
    {
      T ? = paramArrayOfT1[i];
      T ? = paramArrayOfT2[i];
      if (? == ?) {}
      label108:
      label244:
      label380:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  i += 1;
                                  break;
                                  if ((? == null) || (? == null)) {
                                    return false;
                                  }
                                  if ((!(? instanceof Object[])) || (!(? instanceof Object[]))) {
                                    break label108;
                                  }
                                } while (ArraysKt.contentDeepEquals((Object[])?, (Object[])?));
                                return false;
                                if ((!(? instanceof byte[])) || (!(? instanceof byte[]))) {
                                  break label142;
                                }
                              } while (Arrays.equals((byte[])?, (byte[])?));
                              return false;
                              if ((!(? instanceof short[])) || (!(? instanceof short[]))) {
                                break label176;
                              }
                            } while (Arrays.equals((short[])?, (short[])?));
                            return false;
                            if ((!(? instanceof int[])) || (!(? instanceof int[]))) {
                              break label210;
                            }
                          } while (Arrays.equals((int[])?, (int[])?));
                          return false;
                          if ((!(? instanceof long[])) || (!(? instanceof long[]))) {
                            break label244;
                          }
                        } while (Arrays.equals((long[])?, (long[])?));
                        return false;
                        if ((!(? instanceof float[])) || (!(? instanceof float[]))) {
                          break label278;
                        }
                      } while (Arrays.equals((float[])?, (float[])?));
                      return false;
                      if ((!(? instanceof double[])) || (!(? instanceof double[]))) {
                        break label312;
                      }
                    } while (Arrays.equals((double[])?, (double[])?));
                    return false;
                    if ((!(? instanceof char[])) || (!(? instanceof char[]))) {
                      break label346;
                    }
                  } while (Arrays.equals((char[])?, (char[])?));
                  return false;
                  if ((!(? instanceof boolean[])) || (!(? instanceof boolean[]))) {
                    break label380;
                  }
                } while (Arrays.equals((boolean[])?, (boolean[])?));
                return false;
                if ((!(? instanceof UByteArray)) || (!(? instanceof UByteArray))) {
                  break label420;
                }
              } while (UArraysKt.contentEquals-kdPth3s(((UByteArray)?).unbox-impl(), ((UByteArray)?).unbox-impl()));
              return false;
              if ((!(? instanceof UShortArray)) || (!(? instanceof UShortArray))) {
                break label460;
              }
            } while (UArraysKt.contentEquals-mazbYpA(((UShortArray)?).unbox-impl(), ((UShortArray)?).unbox-impl()));
            return false;
            if ((!(? instanceof UIntArray)) || (!(? instanceof UIntArray))) {
              break label500;
            }
          } while (UArraysKt.contentEquals-ctEhBpI(((UIntArray)?).unbox-impl(), ((UIntArray)?).unbox-impl()));
          return false;
          if ((!(? instanceof ULongArray)) || (!(? instanceof ULongArray))) {
            break label540;
          }
        } while (UArraysKt.contentEquals-us8wMrg(((ULongArray)?).unbox-impl(), ((ULongArray)?).unbox-impl()));
        return false;
      } while (!(Intrinsics.areEqual(?, ?) ^ true));
      label210:
      label346:
      label500:
      return false;
    }
    label278:
    label420:
    return true;
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @JvmName(name="contentDeepToString")
  @NotNull
  public static final <T> String contentDeepToString(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$contentDeepToStringImpl");
    StringBuilder localStringBuilder = new StringBuilder(RangesKt.coerceAtMost(paramArrayOfT.length, 429496729) * 5 + 2);
    contentDeepToStringInternal$ArraysKt__ArraysKt(paramArrayOfT, localStringBuilder, (List)new ArrayList());
    paramArrayOfT = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "StringBuilder(capacity).…builderAction).toString()");
    return paramArrayOfT;
  }
  
  private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(@NotNull T[] paramArrayOfT, StringBuilder paramStringBuilder, List<Object[]> paramList)
  {
    if (paramList.contains(paramArrayOfT))
    {
      paramStringBuilder.append("[...]");
      return;
    }
    paramList.add(paramArrayOfT);
    paramStringBuilder.append('[');
    int j = paramArrayOfT.length;
    int i = 0;
    if (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(", ");
      }
      Object localObject = paramArrayOfT[i];
      if (localObject == null) {
        paramStringBuilder.append("null");
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof Object[]))
        {
          contentDeepToStringInternal$ArraysKt__ArraysKt((Object[])localObject, paramStringBuilder, paramList);
        }
        else if ((localObject instanceof byte[]))
        {
          localObject = Arrays.toString((byte[])localObject);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof short[]))
        {
          localObject = Arrays.toString((short[])localObject);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof int[]))
        {
          localObject = Arrays.toString((int[])localObject);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof long[]))
        {
          localObject = Arrays.toString((long[])localObject);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof float[]))
        {
          localObject = Arrays.toString((float[])localObject);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof double[]))
        {
          localObject = Arrays.toString((double[])localObject);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof char[]))
        {
          localObject = Arrays.toString((char[])localObject);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof boolean[]))
        {
          localObject = Arrays.toString((boolean[])localObject);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
          paramStringBuilder.append((String)localObject);
        }
        else if ((localObject instanceof UByteArray))
        {
          paramStringBuilder.append(UArraysKt.contentToString-GBYM_sE(((UByteArray)localObject).unbox-impl()));
        }
        else if ((localObject instanceof UShortArray))
        {
          paramStringBuilder.append(UArraysKt.contentToString-rL5Bavg(((UShortArray)localObject).unbox-impl()));
        }
        else if ((localObject instanceof UIntArray))
        {
          paramStringBuilder.append(UArraysKt.contentToString--ajY-9A(((UIntArray)localObject).unbox-impl()));
        }
        else if ((localObject instanceof ULongArray))
        {
          paramStringBuilder.append(UArraysKt.contentToString-QwZRm1k(((ULongArray)localObject).unbox-impl()));
        }
        else
        {
          paramStringBuilder.append(localObject.toString());
        }
      }
    }
    paramStringBuilder.append(']');
    paramList.remove(CollectionsKt.getLastIndex(paramList));
  }
  
  @NotNull
  public static final <T> List<T> flatten(@NotNull T[][] paramArrayOfT)
  {
    int k = 0;
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$flatten");
    Object localObject = (Object[])paramArrayOfT;
    int m = localObject.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += ((Object[])localObject[i]).length;
      i += 1;
    }
    localObject = new ArrayList(j);
    j = paramArrayOfT.length;
    i = k;
    while (i < j)
    {
      T[] arrayOfT = paramArrayOfT[i];
      CollectionsKt.addAll((Collection)localObject, arrayOfT);
      i += 1;
    }
    return (List)localObject;
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final <C extends Object[],  extends R, R> R ifEmpty(C paramC, Function0<? extends R> paramFunction0)
  {
    if (paramC.length == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramC = paramFunction0.invoke();
      }
      return paramC;
    }
  }
  
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean isNullOrEmpty(@Nullable Object[] paramArrayOfObject)
  {
    boolean bool = false;
    if (paramArrayOfObject != null) {
      if (paramArrayOfObject.length != 0) {
        break label21;
      }
    }
    label21:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  @NotNull
  public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull Pair<? extends T, ? extends R>[] paramArrayOfPair)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfPair, "$this$unzip");
    ArrayList localArrayList1 = new ArrayList(paramArrayOfPair.length);
    ArrayList localArrayList2 = new ArrayList(paramArrayOfPair.length);
    int j = paramArrayOfPair.length;
    int i = 0;
    while (i < j)
    {
      Pair<? extends T, ? extends R> localPair = paramArrayOfPair[i];
      localArrayList1.add(localPair.getFirst());
      localArrayList2.add(localPair.getSecond());
      i += 1;
    }
    return TuplesKt.to(localArrayList1, localArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.ArraysKt__ArraysKt
 * JD-Core Version:    0.7.0.1
 */