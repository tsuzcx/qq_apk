package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"}, k=1, mv={1, 1, 16})
public final class Options$Companion
{
  private final void buildTrieRecursive(long paramLong, Buffer paramBuffer, int paramInt1, List<? extends ByteString> paramList, int paramInt2, int paramInt3, List<Integer> paramList1)
  {
    int i = paramInt1;
    if (paramInt2 < paramInt3) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0)
    {
      paramInt1 = paramInt2;
      while (paramInt1 < paramInt3)
      {
        if (((ByteString)paramList.get(paramInt1)).size() >= i) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0) {
          paramInt1 += 1;
        } else {
          throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
        }
      }
      Object localObject1 = (ByteString)paramList.get(paramInt2);
      Object localObject2 = (ByteString)paramList.get(paramInt3 - 1);
      if (i == ((ByteString)localObject1).size())
      {
        j = ((Number)paramList1.get(paramInt2)).intValue();
        paramInt1 = paramInt2 + 1;
        localObject1 = (ByteString)paramList.get(paramInt1);
        paramInt2 = j;
      }
      else
      {
        paramInt1 = paramInt2;
        paramInt2 = -1;
      }
      if (((ByteString)localObject1).getByte(i) != ((ByteString)localObject2).getByte(i))
      {
        j = paramInt1 + 1;
        for (k = 1; j < paramInt3; k = m)
        {
          m = k;
          if (((ByteString)paramList.get(j - 1)).getByte(i) != ((ByteString)paramList.get(j)).getByte(i)) {
            m = k + 1;
          }
          j += 1;
        }
        localObject2 = (Companion)this;
        paramLong = paramLong + ((Companion)localObject2).getIntCount(paramBuffer) + 2 + k * 2;
        paramBuffer.writeInt(k);
        paramBuffer.writeInt(paramInt2);
        paramInt2 = paramInt1;
        while (paramInt2 < paramInt3)
        {
          j = ((ByteString)paramList.get(paramInt2)).getByte(i);
          if ((paramInt2 == paramInt1) || (j != ((ByteString)paramList.get(paramInt2 - 1)).getByte(i))) {
            paramBuffer.writeInt(j & 0xFF);
          }
          paramInt2 += 1;
        }
        localObject1 = new Buffer();
        for (paramInt2 = paramInt1; paramInt2 < paramInt3; paramInt2 = paramInt1)
        {
          k = ((ByteString)paramList.get(paramInt2)).getByte(i);
          j = paramInt2 + 1;
          paramInt1 = j;
          while (paramInt1 < paramInt3)
          {
            if (k != ((ByteString)paramList.get(paramInt1)).getByte(i)) {
              break label494;
            }
            paramInt1 += 1;
          }
          paramInt1 = paramInt3;
          label494:
          if ((j == paramInt1) && (i + 1 == ((ByteString)paramList.get(paramInt2)).size()))
          {
            paramBuffer.writeInt(((Number)paramList1.get(paramInt2)).intValue());
          }
          else
          {
            paramBuffer.writeInt((int)(paramLong + ((Companion)localObject2).getIntCount((Buffer)localObject1)) * -1);
            ((Companion)localObject2).buildTrieRecursive(paramLong, (Buffer)localObject1, i + 1, paramList, paramInt2, paramInt1, paramList1);
          }
        }
        paramBuffer.writeAll((Source)localObject1);
        return;
      }
      int m = Math.min(((ByteString)localObject1).size(), ((ByteString)localObject2).size());
      int j = i;
      int k = 0;
      while ((j < m) && (((ByteString)localObject1).getByte(j) == ((ByteString)localObject2).getByte(j)))
      {
        k += 1;
        j += 1;
      }
      localObject2 = (Companion)this;
      paramLong = paramLong + ((Companion)localObject2).getIntCount(paramBuffer) + 2 + k + 1L;
      paramBuffer.writeInt(-k);
      paramBuffer.writeInt(paramInt2);
      paramInt2 = i + k;
      while (i < paramInt2)
      {
        paramBuffer.writeInt(((ByteString)localObject1).getByte(i) & 0xFF);
        i += 1;
      }
      if (paramInt1 + 1 == paramInt3)
      {
        if (paramInt2 == ((ByteString)paramList.get(paramInt1)).size()) {
          paramInt2 = 1;
        } else {
          paramInt2 = 0;
        }
        if (paramInt2 != 0)
        {
          paramBuffer.writeInt(((Number)paramList1.get(paramInt1)).intValue());
          return;
        }
        throw ((Throwable)new IllegalStateException("Check failed.".toString()));
      }
      localObject1 = new Buffer();
      paramBuffer.writeInt((int)(((Companion)localObject2).getIntCount((Buffer)localObject1) + paramLong) * -1);
      ((Companion)localObject2).buildTrieRecursive(paramLong, (Buffer)localObject1, paramInt2, paramList, paramInt1, paramInt3, paramList1);
      paramBuffer.writeAll((Source)localObject1);
      return;
    }
    paramBuffer = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
    for (;;)
    {
      throw paramBuffer;
    }
  }
  
  private final long getIntCount(@NotNull Buffer paramBuffer)
  {
    return paramBuffer.size() / 4;
  }
  
  @JvmStatic
  @NotNull
  public final Options of(@NotNull ByteString... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "byteStrings");
    int i = paramVarArgs.length;
    int n = 0;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return new Options(new ByteString[0], new int[] { 0, -1 }, null);
    }
    Object localObject1 = ArraysKt.toMutableList(paramVarArgs);
    CollectionsKt.sort((List)localObject1);
    Object localObject2 = (Collection)new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject3 = paramVarArgs[i];
      ((Collection)localObject2).add(Integer.valueOf(-1));
      i += 1;
    }
    localObject2 = ((Collection)localObject2).toArray(new Integer[0]);
    if (localObject2 != null)
    {
      localObject2 = (Integer[])localObject2;
      localObject2 = CollectionsKt.mutableListOf((Integer[])Arrays.copyOf((Object[])localObject2, localObject2.length));
      int k = paramVarArgs.length;
      j = 0;
      i = 0;
      while (j < k)
      {
        ((List)localObject2).set(CollectionsKt.binarySearch$default((List)localObject1, (Comparable)paramVarArgs[j], 0, 0, 6, null), Integer.valueOf(i));
        j += 1;
        i += 1;
      }
      if (((ByteString)((List)localObject1).get(0)).size() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        for (i = 0; i < ((List)localObject1).size(); i = j)
        {
          localObject4 = (ByteString)((List)localObject1).get(i);
          j = i + 1;
          k = j;
          while (k < ((List)localObject1).size())
          {
            localObject3 = (ByteString)((List)localObject1).get(k);
            if (((ByteString)localObject3).startsWith((ByteString)localObject4))
            {
              int m;
              if (((ByteString)localObject3).size() != ((ByteString)localObject4).size()) {
                m = 1;
              } else {
                m = 0;
              }
              if (m != 0)
              {
                if (((Number)((List)localObject2).get(k)).intValue() > ((Number)((List)localObject2).get(i)).intValue())
                {
                  ((List)localObject1).remove(k);
                  ((List)localObject2).remove(k);
                }
                else
                {
                  k += 1;
                }
              }
              else
              {
                paramVarArgs = new StringBuilder();
                paramVarArgs.append("duplicate option: ");
                paramVarArgs.append(localObject3);
                throw ((Throwable)new IllegalArgumentException(paramVarArgs.toString().toString()));
              }
            }
          }
        }
        localObject3 = new Buffer();
        Object localObject4 = (Companion)this;
        buildTrieRecursive$default((Companion)localObject4, 0L, (Buffer)localObject3, 0, (List)localObject1, 0, 0, (List)localObject2, 53, null);
        localObject1 = new int[(int)((Companion)localObject4).getIntCount((Buffer)localObject3)];
        i = n;
        while (!((Buffer)localObject3).exhausted())
        {
          localObject1[i] = ((Buffer)localObject3).readInt();
          i += 1;
        }
        paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
        Intrinsics.checkExpressionValueIsNotNull(paramVarArgs, "java.util.Arrays.copyOf(this, size)");
        return new Options((ByteString[])paramVarArgs, (int[])localObject1, null);
      }
      throw ((Throwable)new IllegalArgumentException("the empty byte string is not a supported option".toString()));
    }
    paramVarArgs = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramVarArgs;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Options.Companion
 * JD-Core Version:    0.7.0.1
 */