package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okio.-Platform;
import okio.-Util;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_DIGIT_START", "", "OVERFLOW_ZONE", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "commonClear", "", "Lokio/Buffer;", "commonCompleteSegmentByteCount", "commonCopy", "commonCopyTo", "out", "offset", "byteCount", "commonEquals", "other", "", "commonGet", "", "pos", "commonHashCode", "commonIndexOf", "b", "fromIndex", "toIndex", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonRangeEquals", "commonRead", "sink", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadLong", "commonReadShort", "", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonSnapshot", "commonWritableSegment", "minimumCapacity", "commonWrite", "source", "byteString", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteLong", "commonWriteShort", "s", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "readUtf8Line", "newline", "seek", "T", "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "selectTruncated", "okio"}, k=2, mv={1, 1, 16})
public final class BufferKt
{
  @NotNull
  private static final byte[] HEX_DIGIT_BYTES = -Platform.asUtf8ToByteArray("0123456789abcdef");
  public static final long OVERFLOW_DIGIT_START = -7L;
  public static final long OVERFLOW_ZONE = -922337203685477580L;
  public static final int SEGMENTING_THRESHOLD = 4096;
  
  public static final void commonClear(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonClear");
    paramBuffer.skip(paramBuffer.size());
  }
  
  public static final long commonCompleteSegmentByteCount(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonCompleteSegmentByteCount");
    long l2 = paramBuffer.size();
    if (l2 == 0L) {
      return 0L;
    }
    paramBuffer = paramBuffer.head;
    if (paramBuffer == null) {
      Intrinsics.throwNpe();
    }
    paramBuffer = paramBuffer.prev;
    if (paramBuffer == null) {
      Intrinsics.throwNpe();
    }
    long l1 = l2;
    if (paramBuffer.limit < 8192)
    {
      l1 = l2;
      if (paramBuffer.owner) {
        l1 = l2 - (paramBuffer.limit - paramBuffer.pos);
      }
    }
    return l1;
  }
  
  @NotNull
  public static final Buffer commonCopy(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonCopy");
    Buffer localBuffer = new Buffer();
    if (paramBuffer.size() == 0L) {
      return localBuffer;
    }
    Segment localSegment2 = paramBuffer.head;
    if (localSegment2 == null) {
      Intrinsics.throwNpe();
    }
    Segment localSegment3 = localSegment2.sharedCopy();
    localBuffer.head = localSegment3;
    localSegment3.prev = localBuffer.head;
    localSegment3.next = localSegment3.prev;
    for (Segment localSegment1 = localSegment2.next; localSegment1 != localSegment2; localSegment1 = localSegment1.next)
    {
      Segment localSegment4 = localSegment3.prev;
      if (localSegment4 == null) {
        Intrinsics.throwNpe();
      }
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      localSegment4.push(localSegment1.sharedCopy());
    }
    localBuffer.setSize$okio(paramBuffer.size());
    return localBuffer;
  }
  
  @NotNull
  public static final Buffer commonCopyTo(@NotNull Buffer paramBuffer1, @NotNull Buffer paramBuffer2, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer1, "$this$commonCopyTo");
    Intrinsics.checkParameterIsNotNull(paramBuffer2, "out");
    -Util.checkOffsetAndCount(paramBuffer1.size(), paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return paramBuffer1;
    }
    paramBuffer2.setSize$okio(paramBuffer2.size() + paramLong2);
    Segment localSegment2;
    long l1;
    long l2;
    for (Segment localSegment1 = paramBuffer1.head;; localSegment1 = localSegment1.next)
    {
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      localSegment2 = localSegment1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < localSegment1.limit - localSegment1.pos) {
        break;
      }
      paramLong1 -= localSegment1.limit - localSegment1.pos;
    }
    while (l2 > 0L)
    {
      if (localSegment2 == null) {
        Intrinsics.throwNpe();
      }
      localSegment1 = localSegment2.sharedCopy();
      localSegment1.pos += (int)l1;
      localSegment1.limit = Math.min(localSegment1.pos + (int)l2, localSegment1.limit);
      if (paramBuffer2.head == null)
      {
        localSegment1.prev = localSegment1;
        localSegment1.next = localSegment1.prev;
        paramBuffer2.head = localSegment1.next;
      }
      else
      {
        Segment localSegment3 = paramBuffer2.head;
        if (localSegment3 == null) {
          Intrinsics.throwNpe();
        }
        localSegment3 = localSegment3.prev;
        if (localSegment3 == null) {
          Intrinsics.throwNpe();
        }
        localSegment3.push(localSegment1);
      }
      l2 -= localSegment1.limit - localSegment1.pos;
      localSegment2 = localSegment2.next;
      l1 = 0L;
    }
    return paramBuffer1;
  }
  
  public static final boolean commonEquals(@NotNull Buffer paramBuffer, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonEquals");
    if (paramBuffer == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Buffer)) {
      return false;
    }
    long l1 = paramBuffer.size();
    paramObject = (Buffer)paramObject;
    if (l1 != paramObject.size()) {
      return false;
    }
    if (paramBuffer.size() == 0L) {
      return true;
    }
    Object localObject2 = paramBuffer.head;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    paramObject = paramObject.head;
    if (paramObject == null) {
      Intrinsics.throwNpe();
    }
    int j = ((Segment)localObject2).pos;
    int i = paramObject.pos;
    l1 = 0L;
    while (l1 < paramBuffer.size())
    {
      long l3 = Math.min(((Segment)localObject2).limit - j, paramObject.limit - i);
      long l2 = 0L;
      int k = j;
      while (l2 < l3)
      {
        if (localObject2.data[k] != paramObject.data[i]) {
          return false;
        }
        l2 += 1L;
        k += 1;
        i += 1;
      }
      j = k;
      Object localObject1 = localObject2;
      if (k == ((Segment)localObject2).limit)
      {
        localObject1 = ((Segment)localObject2).next;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        j = ((Segment)localObject1).pos;
      }
      Object localObject3 = paramObject;
      k = i;
      if (i == paramObject.limit)
      {
        localObject3 = paramObject.next;
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        k = ((Segment)localObject3).pos;
      }
      l1 += l3;
      localObject2 = localObject1;
      paramObject = localObject3;
      i = k;
    }
    return true;
  }
  
  public static final byte commonGet(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonGet");
    -Util.checkOffsetAndCount(paramBuffer.size(), paramLong, 1L);
    Segment localSegment = paramBuffer.head;
    if (localSegment != null)
    {
      if (paramBuffer.size() - paramLong < paramLong)
      {
        for (l1 = paramBuffer.size(); l1 > paramLong; l1 -= localSegment.limit - localSegment.pos)
        {
          localSegment = localSegment.prev;
          if (localSegment == null) {
            Intrinsics.throwNpe();
          }
        }
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
        return localSegment.data[((int)(localSegment.pos + paramLong - l1))];
      }
      long l2;
      for (long l1 = 0L;; l1 = l2)
      {
        l2 = localSegment.limit - localSegment.pos + l1;
        if (l2 > paramLong)
        {
          if (localSegment == null) {
            Intrinsics.throwNpe();
          }
          return localSegment.data[((int)(localSegment.pos + paramLong - l1))];
        }
        localSegment = localSegment.next;
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
      }
    }
    paramBuffer = (Segment)null;
    Intrinsics.throwNpe();
    return paramBuffer.data[((int)(paramBuffer.pos + paramLong + 1L))];
  }
  
  public static final int commonHashCode(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonHashCode");
    Object localObject = paramBuffer.head;
    if (localObject != null)
    {
      int i = 1;
      int j;
      Segment localSegment;
      do
      {
        int k = ((Segment)localObject).pos;
        int m = ((Segment)localObject).limit;
        j = i;
        while (k < m)
        {
          j = j * 31 + localObject.data[k];
          k += 1;
        }
        localSegment = ((Segment)localObject).next;
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
        localObject = localSegment;
        i = j;
      } while (localSegment != paramBuffer.head);
      return j;
    }
    return 0;
  }
  
  public static final long commonIndexOf(@NotNull Buffer paramBuffer, byte paramByte, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonIndexOf");
    long l2 = 0L;
    int i;
    if ((0L <= paramLong1) && (paramLong2 >= paramLong1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      long l1 = paramLong2;
      if (paramLong2 > paramBuffer.size()) {
        l1 = paramBuffer.size();
      }
      if (paramLong1 == l1) {
        return -1L;
      }
      Segment localSegment = paramBuffer.head;
      if (localSegment != null)
      {
        paramLong2 = l2;
        localObject = localSegment;
        int j;
        if (paramBuffer.size() - paramLong1 < paramLong1)
        {
          paramLong2 = paramBuffer.size();
          paramBuffer = localSegment;
          while (paramLong2 > paramLong1)
          {
            paramBuffer = paramBuffer.prev;
            if (paramBuffer == null) {
              Intrinsics.throwNpe();
            }
            paramLong2 -= paramBuffer.limit - paramBuffer.pos;
          }
          if (paramBuffer != null) {
            while (paramLong2 < l1)
            {
              localObject = paramBuffer.data;
              j = (int)Math.min(paramBuffer.limit, paramBuffer.pos + l1 - paramLong2);
              i = (int)(paramBuffer.pos + paramLong1 - paramLong2);
              while (i < j)
              {
                if (localObject[i] == paramByte) {
                  return i - paramBuffer.pos + paramLong2;
                }
                i += 1;
              }
              paramLong1 = paramBuffer.limit - paramBuffer.pos + paramLong2;
              paramBuffer = paramBuffer.next;
              if (paramBuffer == null) {
                Intrinsics.throwNpe();
              }
              paramLong2 = paramLong1;
            }
          }
          return -1L;
        }
        for (;;)
        {
          l2 = ((Segment)localObject).limit - ((Segment)localObject).pos + paramLong2;
          if (l2 > paramLong1)
          {
            if (localObject != null) {
              for (;;)
              {
                if (paramLong2 >= l1) {
                  break label420;
                }
                paramBuffer = ((Segment)localObject).data;
                j = (int)Math.min(((Segment)localObject).limit, ((Segment)localObject).pos + l1 - paramLong2);
                i = (int)(((Segment)localObject).pos + paramLong1 - paramLong2);
                for (;;)
                {
                  if (i >= j) {
                    break label383;
                  }
                  if (paramBuffer[i] == paramByte)
                  {
                    paramBuffer = (Buffer)localObject;
                    break;
                  }
                  i += 1;
                }
                label383:
                paramLong1 = ((Segment)localObject).limit - ((Segment)localObject).pos + paramLong2;
                localObject = ((Segment)localObject).next;
                if (localObject == null) {
                  Intrinsics.throwNpe();
                }
                paramLong2 = paramLong1;
              }
            }
            label420:
            return -1L;
          }
          localObject = ((Segment)localObject).next;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          paramLong2 = l2;
        }
      }
      paramBuffer = (Segment)null;
      return -1L;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("size=");
    ((StringBuilder)localObject).append(paramBuffer.size());
    ((StringBuilder)localObject).append(" fromIndex=");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" toIndex=");
    ((StringBuilder)localObject).append(paramLong2);
    paramBuffer = (Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString());
    for (;;)
    {
      throw paramBuffer;
    }
  }
  
  public static final long commonIndexOf(@NotNull Buffer paramBuffer, @NotNull ByteString paramByteString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonIndexOf");
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    int i;
    if (paramByteString.size() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      long l1 = 0L;
      if (paramLong >= 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        Object localObject2 = paramBuffer.head;
        if (localObject2 != null)
        {
          Object localObject1 = localObject2;
          int j;
          int k;
          long l2;
          long l3;
          int m;
          if (paramBuffer.size() - paramLong < paramLong)
          {
            l1 = paramBuffer.size();
            localObject1 = localObject2;
            while (l1 > paramLong)
            {
              localObject1 = ((Segment)localObject1).prev;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              l1 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
            }
            if (localObject1 != null)
            {
              localObject2 = paramByteString.internalArray$okio();
              j = localObject2[0];
              k = paramByteString.size();
              l2 = paramBuffer.size() - k + 1L;
              while (l1 < l2)
              {
                paramBuffer = ((Segment)localObject1).data;
                i = ((Segment)localObject1).limit;
                l3 = ((Segment)localObject1).pos;
                m = (int)Math.min(i, l3 + l2 - l1);
                i = (int)(((Segment)localObject1).pos + paramLong - l1);
                while (i < m)
                {
                  if ((paramBuffer[i] == j) && (rangeEquals((Segment)localObject1, i + 1, (byte[])localObject2, 1, k))) {
                    return i - ((Segment)localObject1).pos + l1;
                  }
                  i += 1;
                }
                paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos;
                localObject1 = ((Segment)localObject1).next;
                if (localObject1 == null) {
                  Intrinsics.throwNpe();
                }
                l1 = paramLong + l1;
                paramLong = l1;
              }
              return -1L;
            }
            return -1L;
          }
          for (;;)
          {
            l2 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
            if (l2 > paramLong)
            {
              if (localObject1 != null)
              {
                localObject2 = paramByteString.internalArray$okio();
                j = localObject2[0];
                k = paramByteString.size();
                l2 = paramBuffer.size();
                l2 = l2 - k + 1L;
                while (l1 < l2)
                {
                  paramBuffer = ((Segment)localObject1).data;
                  i = ((Segment)localObject1).limit;
                  l3 = ((Segment)localObject1).pos;
                  m = (int)Math.min(i, l3 + l2 - l1);
                  i = (int)(((Segment)localObject1).pos + paramLong - l1);
                  while (i < m)
                  {
                    if ((paramBuffer[i] == j) && (rangeEquals((Segment)localObject1, i + 1, (byte[])localObject2, 1, k))) {
                      return i - ((Segment)localObject1).pos + l1;
                    }
                    i += 1;
                  }
                  paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos;
                  localObject1 = ((Segment)localObject1).next;
                  if (localObject1 == null) {
                    Intrinsics.throwNpe();
                  }
                  l1 = paramLong + l1;
                  paramLong = l1;
                }
                return -1L;
              }
              return -1L;
            }
            localObject1 = ((Segment)localObject1).next;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            l1 = l2;
          }
        }
        paramBuffer = (Segment)null;
        return -1L;
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("fromIndex < 0: ");
      paramBuffer.append(paramLong);
      throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
    }
    paramBuffer = (Throwable)new IllegalArgumentException("bytes is empty".toString());
    for (;;)
    {
      throw paramBuffer;
    }
  }
  
  public static final long commonIndexOfElement(@NotNull Buffer paramBuffer, @NotNull ByteString paramByteString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonIndexOfElement");
    Intrinsics.checkParameterIsNotNull(paramByteString, "targetBytes");
    long l1 = 0L;
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Object localObject2 = paramBuffer.head;
      if (localObject2 != null)
      {
        Object localObject1 = localObject2;
        int k;
        int m;
        int j;
        int n;
        int i1;
        if (paramBuffer.size() - paramLong < paramLong)
        {
          l1 = paramBuffer.size();
          localObject1 = localObject2;
          while (l1 > paramLong)
          {
            localObject1 = ((Segment)localObject1).prev;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            l1 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
          }
          if (localObject1 != null)
          {
            if (paramByteString.size() == 2)
            {
              k = paramByteString.getByte(0);
              m = paramByteString.getByte(1);
              while (l1 < paramBuffer.size())
              {
                localObject2 = ((Segment)localObject1).data;
                j = (int)(((Segment)localObject1).pos + paramLong - l1);
                n = ((Segment)localObject1).limit;
                while (j < n)
                {
                  i1 = localObject2[j];
                  paramLong = l1;
                  paramByteString = (ByteString)localObject1;
                  i = j;
                  if (i1 != k) {
                    if (i1 == m)
                    {
                      paramLong = l1;
                      paramByteString = (ByteString)localObject1;
                      i = j;
                    }
                    else
                    {
                      j += 1;
                      continue;
                    }
                  }
                  j = paramByteString.pos;
                  return i - j + paramLong;
                }
                paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
                localObject1 = ((Segment)localObject1).next;
                if (localObject1 == null) {
                  Intrinsics.throwNpe();
                }
                l1 = paramLong;
              }
            }
            paramByteString = paramByteString.internalArray$okio();
            for (;;)
            {
              if (l1 >= paramBuffer.size()) {
                break label440;
              }
              localObject2 = ((Segment)localObject1).data;
              i = (int)(((Segment)localObject1).pos + paramLong - l1);
              k = ((Segment)localObject1).limit;
              for (;;)
              {
                if (i >= k) {
                  break label403;
                }
                m = localObject2[i];
                n = paramByteString.length;
                j = 0;
                for (;;)
                {
                  if (j >= n) {
                    break label394;
                  }
                  if (m == paramByteString[j])
                  {
                    j = ((Segment)localObject1).pos;
                    paramLong = l1;
                    break;
                  }
                  j += 1;
                }
                label394:
                i += 1;
              }
              label403:
              paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
              localObject1 = ((Segment)localObject1).next;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              l1 = paramLong;
            }
          }
          label440:
          return -1L;
        }
        for (;;)
        {
          long l2 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
          if (l2 > paramLong)
          {
            if (localObject1 != null)
            {
              if (paramByteString.size() == 2)
              {
                k = paramByteString.getByte(0);
                m = paramByteString.getByte(1);
                for (;;)
                {
                  if (l1 >= paramBuffer.size()) {
                    break label768;
                  }
                  localObject2 = ((Segment)localObject1).data;
                  j = (int)(((Segment)localObject1).pos + paramLong - l1);
                  n = ((Segment)localObject1).limit;
                  for (;;)
                  {
                    if (j >= n) {
                      break label593;
                    }
                    i1 = localObject2[j];
                    paramLong = l1;
                    paramByteString = (ByteString)localObject1;
                    i = j;
                    if (i1 == k) {
                      break;
                    }
                    if (i1 == m)
                    {
                      paramLong = l1;
                      paramByteString = (ByteString)localObject1;
                      i = j;
                      break;
                    }
                    j += 1;
                  }
                  label593:
                  paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
                  localObject1 = ((Segment)localObject1).next;
                  if (localObject1 == null) {
                    Intrinsics.throwNpe();
                  }
                  l1 = paramLong;
                }
              }
              paramByteString = paramByteString.internalArray$okio();
              for (;;)
              {
                if (l1 >= paramBuffer.size()) {
                  break label768;
                }
                localObject2 = ((Segment)localObject1).data;
                i = (int)(((Segment)localObject1).pos + paramLong - l1);
                k = ((Segment)localObject1).limit;
                for (;;)
                {
                  if (i >= k) {
                    break label731;
                  }
                  m = localObject2[i];
                  n = paramByteString.length;
                  j = 0;
                  for (;;)
                  {
                    if (j >= n) {
                      break label722;
                    }
                    if (m == paramByteString[j]) {
                      break;
                    }
                    j += 1;
                  }
                  label722:
                  i += 1;
                }
                label731:
                paramLong = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
                localObject1 = ((Segment)localObject1).next;
                if (localObject1 == null) {
                  Intrinsics.throwNpe();
                }
                l1 = paramLong;
              }
            }
            label768:
            return -1L;
          }
          localObject1 = ((Segment)localObject1).next;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          l1 = l2;
        }
      }
      paramBuffer = (Segment)null;
      return -1L;
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("fromIndex < 0: ");
    paramBuffer.append(paramLong);
    paramBuffer = (Throwable)new IllegalArgumentException(paramBuffer.toString().toString());
    for (;;)
    {
      throw paramBuffer;
    }
  }
  
  public static final boolean commonRangeEquals(@NotNull Buffer paramBuffer, long paramLong, @NotNull ByteString paramByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonRangeEquals");
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    if ((paramLong >= 0L) && (paramInt1 >= 0) && (paramInt2 >= 0) && (paramBuffer.size() - paramLong >= paramInt2))
    {
      if (paramByteString.size() - paramInt1 < paramInt2) {
        return false;
      }
      int i = 0;
      while (i < paramInt2)
      {
        if (paramBuffer.getByte(i + paramLong) != paramByteString.getByte(paramInt1 + i)) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public static final int commonRead(@NotNull Buffer paramBuffer, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonRead");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    return paramBuffer.read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final int commonRead(@NotNull Buffer paramBuffer, @NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonRead");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    -Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    Segment localSegment = paramBuffer.head;
    if (localSegment != null)
    {
      paramInt2 = Math.min(paramInt2, localSegment.limit - localSegment.pos);
      ArraysKt.copyInto(localSegment.data, paramArrayOfByte, paramInt1, localSegment.pos, localSegment.pos + paramInt2);
      localSegment.pos += paramInt2;
      paramBuffer.setSize$okio(paramBuffer.size() - paramInt2);
      if (localSegment.pos == localSegment.limit)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
      }
      return paramInt2;
    }
    return -1;
  }
  
  public static final long commonRead(@NotNull Buffer paramBuffer1, @NotNull Buffer paramBuffer2, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer1, "$this$commonRead");
    Intrinsics.checkParameterIsNotNull(paramBuffer2, "sink");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramBuffer1.size() == 0L) {
        return -1L;
      }
      long l = paramLong;
      if (paramLong > paramBuffer1.size()) {
        l = paramBuffer1.size();
      }
      paramBuffer2.write(paramBuffer1, l);
      return l;
    }
    paramBuffer1 = new StringBuilder();
    paramBuffer1.append("byteCount < 0: ");
    paramBuffer1.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer1.toString().toString()));
  }
  
  public static final long commonReadAll(@NotNull Buffer paramBuffer, @NotNull Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadAll");
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    long l = paramBuffer.size();
    if (l > 0L) {
      paramSink.write(paramBuffer, l);
    }
    return l;
  }
  
  public static final byte commonReadByte(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadByte");
    if (paramBuffer.size() != 0L)
    {
      Segment localSegment = paramBuffer.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int i = localSegment.pos;
      int j = localSegment.limit;
      byte[] arrayOfByte = localSegment.data;
      int k = i + 1;
      byte b = arrayOfByte[i];
      paramBuffer.setSize$okio(paramBuffer.size() - 1L);
      if (k == j)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
        return b;
      }
      localSegment.pos = k;
      return b;
    }
    throw ((Throwable)new EOFException());
  }
  
  @NotNull
  public static final byte[] commonReadByteArray(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadByteArray");
    return paramBuffer.readByteArray(paramBuffer.size());
  }
  
  @NotNull
  public static final byte[] commonReadByteArray(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadByteArray");
    int i;
    if ((paramLong >= 0L) && (paramLong <= 2147483647)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramBuffer.size() >= paramLong)
      {
        byte[] arrayOfByte = new byte[(int)paramLong];
        paramBuffer.readFully(arrayOfByte);
        return arrayOfByte;
      }
      throw ((Throwable)new EOFException());
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
  }
  
  @NotNull
  public static final ByteString commonReadByteString(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadByteString");
    return paramBuffer.readByteString(paramBuffer.size());
  }
  
  @NotNull
  public static final ByteString commonReadByteString(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadByteString");
    int i;
    if ((paramLong >= 0L) && (paramLong <= 2147483647)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramBuffer.size() >= paramLong)
      {
        if (paramLong >= 4096)
        {
          ByteString localByteString = paramBuffer.snapshot((int)paramLong);
          paramBuffer.skip(paramLong);
          return localByteString;
        }
        return new ByteString(paramBuffer.readByteArray(paramLong));
      }
      throw ((Throwable)new EOFException());
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
  }
  
  public static final long commonReadDecimalLong(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadDecimalLong");
    long l1 = paramBuffer.size();
    long l3 = 0L;
    if (l1 != 0L)
    {
      int i1 = 0;
      long l2 = -7L;
      int i2 = 0;
      int j = 0;
      int k;
      int m;
      label268:
      do
      {
        Object localObject = paramBuffer.head;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        byte[] arrayOfByte = ((Segment)localObject).data;
        int n = ((Segment)localObject).pos;
        int i3 = ((Segment)localObject).limit;
        k = i1;
        l1 = l3;
        m = i2;
        while (n < i3)
        {
          int i = arrayOfByte[n];
          i1 = (byte)48;
          if ((i >= i1) && (i <= (byte)57))
          {
            i1 -= i;
            if ((l1 >= -922337203685477580L) && ((l1 != -922337203685477580L) || (i1 >= l2)))
            {
              l1 = l1 * 10L + i1;
            }
            else
            {
              paramBuffer = new Buffer().writeDecimalLong(l1).writeByte(i);
              if (m == 0) {
                paramBuffer.readByte();
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Number too large: ");
              ((StringBuilder)localObject).append(paramBuffer.readUtf8());
              throw ((Throwable)new NumberFormatException(((StringBuilder)localObject).toString()));
            }
          }
          else
          {
            if ((i != (byte)45) || (k != 0)) {
              break label268;
            }
            l2 -= 1L;
            m = 1;
          }
          n += 1;
          k += 1;
          continue;
          if (k != 0)
          {
            j = 1;
          }
          else
          {
            paramBuffer = new StringBuilder();
            paramBuffer.append("Expected leading [0-9] or '-' character but was 0x");
            paramBuffer.append(-Util.toHexString(i));
            throw ((Throwable)new NumberFormatException(paramBuffer.toString()));
          }
        }
        if (n == i3)
        {
          paramBuffer.head = ((Segment)localObject).pop();
          SegmentPool.INSTANCE.recycle((Segment)localObject);
        }
        else
        {
          ((Segment)localObject).pos = n;
        }
        if (j != 0) {
          break;
        }
        i2 = m;
        l3 = l1;
        i1 = k;
      } while (paramBuffer.head != null);
      paramBuffer.setSize$okio(paramBuffer.size() - k);
      if (m != 0) {
        return l1;
      }
      return -l1;
    }
    paramBuffer = (Throwable)new EOFException();
    for (;;)
    {
      throw paramBuffer;
    }
  }
  
  public static final void commonReadFully(@NotNull Buffer paramBuffer1, @NotNull Buffer paramBuffer2, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer1, "$this$commonReadFully");
    Intrinsics.checkParameterIsNotNull(paramBuffer2, "sink");
    if (paramBuffer1.size() >= paramLong)
    {
      paramBuffer2.write(paramBuffer1, paramLong);
      return;
    }
    paramBuffer2.write(paramBuffer1, paramBuffer1.size());
    throw ((Throwable)new EOFException());
  }
  
  public static final void commonReadFully(@NotNull Buffer paramBuffer, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadFully");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramBuffer.read(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j != -1) {
        i += j;
      } else {
        throw ((Throwable)new EOFException());
      }
    }
  }
  
  public static final long commonReadHexadecimalUnsignedLong(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadHexadecimalUnsignedLong");
    if (paramBuffer.size() != 0L)
    {
      int n = 0;
      long l1 = 0L;
      int j = 0;
      long l2;
      int k;
      label255:
      do
      {
        Object localObject = paramBuffer.head;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        byte[] arrayOfByte = ((Segment)localObject).data;
        int m = ((Segment)localObject).pos;
        int i2 = ((Segment)localObject).limit;
        l2 = l1;
        k = n;
        int i1;
        int i;
        for (;;)
        {
          i1 = j;
          if (m >= i2) {
            break label305;
          }
          i = arrayOfByte[m];
          n = (byte)48;
          if ((i >= n) && (i <= (byte)57))
          {
            n = i - n;
          }
          else
          {
            n = (byte)97;
            if ((i >= n) && (i <= (byte)102)) {}
            for (;;)
            {
              n = i - n + 10;
              break;
              n = (byte)65;
              if ((i < n) || (i > (byte)70)) {
                break label255;
              }
            }
          }
          if ((0x0 & l2) != 0L) {
            break;
          }
          l2 = l2 << 4 | n;
          m += 1;
          k += 1;
        }
        paramBuffer = new Buffer().writeHexadecimalUnsignedLong(l2).writeByte(i);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Number too large: ");
        ((StringBuilder)localObject).append(paramBuffer.readUtf8());
        throw ((Throwable)new NumberFormatException(((StringBuilder)localObject).toString()));
        if (k != 0)
        {
          i1 = 1;
        }
        else
        {
          paramBuffer = new StringBuilder();
          paramBuffer.append("Expected leading [0-9a-fA-F] character but was 0x");
          paramBuffer.append(-Util.toHexString(i));
          throw ((Throwable)new NumberFormatException(paramBuffer.toString()));
        }
        if (m == i2)
        {
          paramBuffer.head = ((Segment)localObject).pop();
          SegmentPool.INSTANCE.recycle((Segment)localObject);
        }
        else
        {
          ((Segment)localObject).pos = m;
        }
        if (i1 != 0) {
          break;
        }
        n = k;
        j = i1;
        l1 = l2;
      } while (paramBuffer.head != null);
      label305:
      paramBuffer.setSize$okio(paramBuffer.size() - k);
      return l2;
    }
    paramBuffer = (Throwable)new EOFException();
    for (;;)
    {
      throw paramBuffer;
    }
  }
  
  public static final int commonReadInt(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadInt");
    if (paramBuffer.size() >= 4L)
    {
      Segment localSegment = paramBuffer.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int j = localSegment.pos;
      int i = localSegment.limit;
      if (i - j < 4L)
      {
        i = paramBuffer.readByte();
        j = paramBuffer.readByte();
        k = paramBuffer.readByte();
        return paramBuffer.readByte() & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
      }
      byte[] arrayOfByte = localSegment.data;
      int k = j + 1;
      j = arrayOfByte[j];
      int n = k + 1;
      k = arrayOfByte[k];
      int m = n + 1;
      int i1 = arrayOfByte[n];
      n = m + 1;
      j = (j & 0xFF) << 24 | (k & 0xFF) << 16 | (i1 & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
      paramBuffer.setSize$okio(paramBuffer.size() - 4L);
      if (n == i)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
        return j;
      }
      localSegment.pos = n;
      return j;
    }
    throw ((Throwable)new EOFException());
  }
  
  public static final long commonReadLong(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadLong");
    if (paramBuffer.size() >= 8L)
    {
      Segment localSegment = paramBuffer.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int k = localSegment.pos;
      int i = localSegment.limit;
      if (i - k < 8L) {
        return (paramBuffer.readInt() & 0xFFFFFFFF) << 32 | 0xFFFFFFFF & paramBuffer.readInt();
      }
      byte[] arrayOfByte = localSegment.data;
      int j = k + 1;
      long l1 = arrayOfByte[k];
      k = j + 1;
      long l2 = arrayOfByte[j];
      j = k + 1;
      long l3 = arrayOfByte[k];
      k = j + 1;
      long l4 = arrayOfByte[j];
      j = k + 1;
      long l5 = arrayOfByte[k];
      k = j + 1;
      long l6 = arrayOfByte[j];
      j = k + 1;
      long l7 = arrayOfByte[k];
      k = j + 1;
      l1 = (l4 & 0xFF) << 32 | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | arrayOfByte[j] & 0xFF;
      paramBuffer.setSize$okio(paramBuffer.size() - 8L);
      if (k == i)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
        return l1;
      }
      localSegment.pos = k;
      return l1;
    }
    throw ((Throwable)new EOFException());
  }
  
  public static final short commonReadShort(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadShort");
    if (paramBuffer.size() >= 2L)
    {
      Segment localSegment = paramBuffer.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int k = localSegment.pos;
      int i = localSegment.limit;
      if (i - k < 2)
      {
        i = paramBuffer.readByte();
        return (short)(paramBuffer.readByte() & 0xFF | (i & 0xFF) << 8);
      }
      byte[] arrayOfByte = localSegment.data;
      int j = k + 1;
      k = arrayOfByte[k];
      int m = j + 1;
      j = arrayOfByte[j];
      paramBuffer.setSize$okio(paramBuffer.size() - 2L);
      if (m == i)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
      }
      else
      {
        localSegment.pos = m;
      }
      return (short)((k & 0xFF) << 8 | j & 0xFF);
    }
    throw ((Throwable)new EOFException());
  }
  
  @NotNull
  public static final String commonReadUtf8(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadUtf8");
    int i;
    if ((paramLong >= 0L) && (paramLong <= 2147483647)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramBuffer.size() >= paramLong)
      {
        if (paramLong == 0L) {
          return "";
        }
        Segment localSegment = paramBuffer.head;
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
        if (localSegment.pos + paramLong > localSegment.limit) {
          return _Utf8Kt.commonToUtf8String$default(paramBuffer.readByteArray(paramLong), 0, 0, 3, null);
        }
        Object localObject = localSegment.data;
        i = localSegment.pos;
        int j = localSegment.pos;
        int k = (int)paramLong;
        localObject = _Utf8Kt.commonToUtf8String((byte[])localObject, i, j + k);
        localSegment.pos += k;
        paramBuffer.setSize$okio(paramBuffer.size() - paramLong);
        if (localSegment.pos == localSegment.limit)
        {
          paramBuffer.head = localSegment.pop();
          SegmentPool.INSTANCE.recycle(localSegment);
        }
        return localObject;
      }
      throw ((Throwable)new EOFException());
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
  }
  
  public static final int commonReadUtf8CodePoint(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadUtf8CodePoint");
    if (paramBuffer.size() != 0L)
    {
      int i = paramBuffer.getByte(0L);
      int n = 1;
      int j;
      int k;
      int m;
      if ((i & 0x80) == 0)
      {
        j = i & 0x7F;
        k = 1;
        m = 0;
      }
      else if ((i & 0xE0) == 192)
      {
        j = i & 0x1F;
        k = 2;
        m = 128;
      }
      else if ((i & 0xF0) == 224)
      {
        j = i & 0xF;
        k = 3;
        m = 2048;
      }
      else
      {
        if ((i & 0xF8) != 240) {
          break label337;
        }
        j = i & 0x7;
        k = 4;
        m = 65536;
      }
      long l2 = paramBuffer.size();
      long l1 = k;
      if (l2 >= l1)
      {
        while (n < k)
        {
          l2 = n;
          int i1 = paramBuffer.getByte(l2);
          if ((i1 & 0xC0) == 128)
          {
            j = j << 6 | i1 & 0x3F;
            n += 1;
          }
          else
          {
            paramBuffer.skip(l2);
            return 65533;
          }
        }
        paramBuffer.skip(l1);
        if (j > 1114111) {
          return 65533;
        }
        if ((55296 <= j) && (57343 >= j)) {
          return 65533;
        }
        if (j < m) {
          return 65533;
        }
        return j;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("size < ");
      localStringBuilder.append(k);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramBuffer.size());
      localStringBuilder.append(" (to read code point prefixed 0x");
      localStringBuilder.append(-Util.toHexString(i));
      localStringBuilder.append(')');
      throw ((Throwable)new EOFException(localStringBuilder.toString()));
      label337:
      paramBuffer.skip(1L);
      return 65533;
    }
    paramBuffer = (Throwable)new EOFException();
    for (;;)
    {
      throw paramBuffer;
    }
  }
  
  @Nullable
  public static final String commonReadUtf8Line(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadUtf8Line");
    long l = paramBuffer.indexOf((byte)10);
    if (l != -1L) {
      return readUtf8Line(paramBuffer, l);
    }
    if (paramBuffer.size() != 0L) {
      return paramBuffer.readUtf8(paramBuffer.size());
    }
    return null;
  }
  
  @NotNull
  public static final String commonReadUtf8LineStrict(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonReadUtf8LineStrict");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      long l1 = 9223372036854775807L;
      if (paramLong != 9223372036854775807L) {
        l1 = paramLong + 1L;
      }
      byte b = (byte)10;
      long l2 = paramBuffer.indexOf(b, 0L, l1);
      if (l2 != -1L) {
        return readUtf8Line(paramBuffer, l2);
      }
      if ((l1 < paramBuffer.size()) && (paramBuffer.getByte(l1 - 1L) == (byte)13) && (paramBuffer.getByte(l1) == b)) {
        return readUtf8Line(paramBuffer, l1);
      }
      Buffer localBuffer = new Buffer();
      l1 = paramBuffer.size();
      paramBuffer.copyTo(localBuffer, 0L, Math.min(32, l1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\n not found: limit=");
      localStringBuilder.append(Math.min(paramBuffer.size(), paramLong));
      localStringBuilder.append(" content=");
      localStringBuilder.append(localBuffer.readByteString().hex());
      localStringBuilder.append('…');
      throw ((Throwable)new EOFException(localStringBuilder.toString()));
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("limit < 0: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
  }
  
  public static final int commonSelect(@NotNull Buffer paramBuffer, @NotNull Options paramOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonSelect");
    Intrinsics.checkParameterIsNotNull(paramOptions, "options");
    int i = selectPrefix$default(paramBuffer, paramOptions, false, 2, null);
    if (i == -1) {
      return -1;
    }
    paramBuffer.skip(paramOptions.getByteStrings$okio()[i].size());
    return i;
  }
  
  public static final void commonSkip(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonSkip");
    while (paramLong > 0L)
    {
      Segment localSegment = paramBuffer.head;
      if (localSegment != null)
      {
        int i = (int)Math.min(paramLong, localSegment.limit - localSegment.pos);
        long l1 = paramBuffer.size();
        long l2 = i;
        paramBuffer.setSize$okio(l1 - l2);
        l1 = paramLong - l2;
        localSegment.pos += i;
        paramLong = l1;
        if (localSegment.pos == localSegment.limit)
        {
          paramBuffer.head = localSegment.pop();
          SegmentPool.INSTANCE.recycle(localSegment);
          paramLong = l1;
        }
      }
      else
      {
        throw ((Throwable)new EOFException());
      }
    }
  }
  
  @NotNull
  public static final ByteString commonSnapshot(@NotNull Buffer paramBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonSnapshot");
    int i;
    if (paramBuffer.size() <= 2147483647) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return paramBuffer.snapshot((int)paramBuffer.size());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size > Int.MAX_VALUE: ");
    localStringBuilder.append(paramBuffer.size());
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  @NotNull
  public static final ByteString commonSnapshot(@NotNull Buffer paramBuffer, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonSnapshot");
    if (paramInt == 0) {
      return ByteString.EMPTY;
    }
    -Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramInt);
    Object localObject = paramBuffer.head;
    int k = 0;
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((Segment)localObject).limit != ((Segment)localObject).pos)
      {
        j += ((Segment)localObject).limit - ((Segment)localObject).pos;
        i += 1;
        localObject = ((Segment)localObject).next;
      }
      else
      {
        throw ((Throwable)new AssertionError("s.limit == s.pos"));
      }
    }
    localObject = new byte[i][];
    int[] arrayOfInt = new int[i * 2];
    paramBuffer = paramBuffer.head;
    i = 0;
    j = k;
    while (j < paramInt)
    {
      if (paramBuffer == null) {
        Intrinsics.throwNpe();
      }
      localObject[i] = paramBuffer.data;
      j += paramBuffer.limit - paramBuffer.pos;
      arrayOfInt[i] = Math.min(j, paramInt);
      arrayOfInt[(((Object[])localObject).length + i)] = paramBuffer.pos;
      paramBuffer.shared = true;
      i += 1;
      paramBuffer = paramBuffer.next;
    }
    return (ByteString)new SegmentedByteString((byte[][])localObject, arrayOfInt);
  }
  
  @NotNull
  public static final Segment commonWritableSegment(@NotNull Buffer paramBuffer, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWritableSegment");
    int i = 1;
    if ((paramInt < 1) || (paramInt > 8192)) {
      i = 0;
    }
    if (i != 0)
    {
      if (paramBuffer.head == null)
      {
        localSegment = SegmentPool.INSTANCE.take();
        paramBuffer.head = localSegment;
        localSegment.prev = localSegment;
        localSegment.next = localSegment;
        return localSegment;
      }
      paramBuffer = paramBuffer.head;
      if (paramBuffer == null) {
        Intrinsics.throwNpe();
      }
      Segment localSegment = paramBuffer.prev;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      if (localSegment.limit + paramInt <= 8192)
      {
        paramBuffer = localSegment;
        if (localSegment.owner) {}
      }
      else
      {
        paramBuffer = localSegment.push(SegmentPool.INSTANCE.take());
      }
      return paramBuffer;
    }
    throw ((Throwable)new IllegalArgumentException("unexpected capacity".toString()));
  }
  
  @NotNull
  public static final Buffer commonWrite(@NotNull Buffer paramBuffer, @NotNull ByteString paramByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramByteString, "byteString");
    paramByteString.write$okio(paramBuffer, paramInt1, paramInt2);
    return paramBuffer;
  }
  
  @NotNull
  public static final Buffer commonWrite(@NotNull Buffer paramBuffer, @NotNull Source paramSource, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    while (paramLong > 0L)
    {
      long l = paramSource.read(paramBuffer, paramLong);
      if (l != -1L) {
        paramLong -= l;
      } else {
        throw ((Throwable)new EOFException());
      }
    }
    return paramBuffer;
  }
  
  @NotNull
  public static final Buffer commonWrite(@NotNull Buffer paramBuffer, @NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "source");
    return paramBuffer.write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  @NotNull
  public static final Buffer commonWrite(@NotNull Buffer paramBuffer, @NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "source");
    long l1 = paramArrayOfByte.length;
    long l2 = paramInt1;
    long l3 = paramInt2;
    -Util.checkOffsetAndCount(l1, l2, l3);
    int i = paramInt2 + paramInt1;
    while (paramInt1 < i)
    {
      Segment localSegment = paramBuffer.writableSegment$okio(1);
      int j = Math.min(i - paramInt1, 8192 - localSegment.limit);
      byte[] arrayOfByte = localSegment.data;
      int k = localSegment.limit;
      paramInt2 = paramInt1 + j;
      ArraysKt.copyInto(paramArrayOfByte, arrayOfByte, k, paramInt1, paramInt2);
      localSegment.limit += j;
      paramInt1 = paramInt2;
    }
    paramBuffer.setSize$okio(paramBuffer.size() + l3);
    return paramBuffer;
  }
  
  public static final void commonWrite(@NotNull Buffer paramBuffer1, @NotNull Buffer paramBuffer2, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer1, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramBuffer2, "source");
    int i;
    if (paramBuffer2 != paramBuffer1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      -Util.checkOffsetAndCount(paramBuffer2.size(), 0L, paramLong);
      while (paramLong > 0L)
      {
        Segment localSegment1 = paramBuffer2.head;
        if (localSegment1 == null) {
          Intrinsics.throwNpe();
        }
        i = localSegment1.limit;
        localSegment1 = paramBuffer2.head;
        if (localSegment1 == null) {
          Intrinsics.throwNpe();
        }
        Segment localSegment2;
        if (paramLong < i - localSegment1.pos)
        {
          if (paramBuffer1.head != null)
          {
            localSegment1 = paramBuffer1.head;
            if (localSegment1 == null) {
              Intrinsics.throwNpe();
            }
            localSegment1 = localSegment1.prev;
          }
          else
          {
            localSegment1 = null;
          }
          if ((localSegment1 != null) && (localSegment1.owner))
          {
            l = localSegment1.limit;
            if (localSegment1.shared) {
              i = 0;
            } else {
              i = localSegment1.pos;
            }
            if (l + paramLong - i <= 8192)
            {
              localSegment2 = paramBuffer2.head;
              if (localSegment2 == null) {
                Intrinsics.throwNpe();
              }
              localSegment2.writeTo(localSegment1, (int)paramLong);
              paramBuffer2.setSize$okio(paramBuffer2.size() - paramLong);
              paramBuffer1.setSize$okio(paramBuffer1.size() + paramLong);
              return;
            }
          }
          localSegment1 = paramBuffer2.head;
          if (localSegment1 == null) {
            Intrinsics.throwNpe();
          }
          paramBuffer2.head = localSegment1.split((int)paramLong);
        }
        localSegment1 = paramBuffer2.head;
        if (localSegment1 == null) {
          Intrinsics.throwNpe();
        }
        long l = localSegment1.limit - localSegment1.pos;
        paramBuffer2.head = localSegment1.pop();
        if (paramBuffer1.head == null)
        {
          paramBuffer1.head = localSegment1;
          localSegment1.prev = localSegment1;
          localSegment1.next = localSegment1.prev;
        }
        else
        {
          localSegment2 = paramBuffer1.head;
          if (localSegment2 == null) {
            Intrinsics.throwNpe();
          }
          localSegment2 = localSegment2.prev;
          if (localSegment2 == null) {
            Intrinsics.throwNpe();
          }
          localSegment2.push(localSegment1).compact();
        }
        paramBuffer2.setSize$okio(paramBuffer2.size() - l);
        paramBuffer1.setSize$okio(paramBuffer1.size() + l);
        paramLong -= l;
      }
      return;
    }
    paramBuffer1 = (Throwable)new IllegalArgumentException("source == this".toString());
    for (;;)
    {
      throw paramBuffer1;
    }
  }
  
  public static final long commonWriteAll(@NotNull Buffer paramBuffer, @NotNull Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWriteAll");
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramSource.read(paramBuffer, 8192);
      if (l2 == -1L) {
        return l1;
      }
    }
  }
  
  @NotNull
  public static final Buffer commonWriteByte(@NotNull Buffer paramBuffer, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWriteByte");
    Segment localSegment = paramBuffer.writableSegment$okio(1);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    localSegment.limit = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    paramBuffer.setSize$okio(paramBuffer.size() + 1L);
    return paramBuffer;
  }
  
  @NotNull
  public static final Buffer commonWriteDecimalLong(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWriteDecimalLong");
    if (paramLong == 0L) {
      return paramBuffer.writeByte(48);
    }
    int j = 0;
    int i = 1;
    long l = paramLong;
    if (paramLong < 0L)
    {
      l = -paramLong;
      if (l < 0L) {
        return paramBuffer.writeUtf8("-9223372036854775808");
      }
      j = 1;
    }
    if (l < 100000000L)
    {
      if (l < 10000L)
      {
        if (l < 100L)
        {
          if (l >= 10L) {
            i = 2;
          }
        }
        else if (l < 1000L) {
          i = 3;
        } else {
          i = 4;
        }
      }
      else if (l < 1000000L)
      {
        if (l < 100000L) {
          i = 5;
        } else {
          i = 6;
        }
      }
      else if (l < 10000000L) {
        i = 7;
      } else {
        i = 8;
      }
    }
    else if (l < 1000000000000L)
    {
      if (l < 10000000000L)
      {
        if (l < 1000000000L) {
          i = 9;
        } else {
          i = 10;
        }
      }
      else if (l < 100000000000L) {
        i = 11;
      } else {
        i = 12;
      }
    }
    else if (l < 1000000000000000L)
    {
      if (l < 10000000000000L) {
        i = 13;
      } else if (l < 100000000000000L) {
        i = 14;
      } else {
        i = 15;
      }
    }
    else if (l < 100000000000000000L)
    {
      if (l < 10000000000000000L) {
        i = 16;
      } else {
        i = 17;
      }
    }
    else if (l < 1000000000000000000L) {
      i = 18;
    } else {
      i = 19;
    }
    int k = i;
    if (j != 0) {
      k = i + 1;
    }
    Segment localSegment = paramBuffer.writableSegment$okio(k);
    byte[] arrayOfByte = localSegment.data;
    i = localSegment.limit + k;
    while (l != 0L)
    {
      paramLong = 10;
      int m = (int)(l % paramLong);
      i -= 1;
      arrayOfByte[i] = getHEX_DIGIT_BYTES()[m];
      l /= paramLong;
    }
    if (j != 0) {
      arrayOfByte[(i - 1)] = ((byte)45);
    }
    localSegment.limit += k;
    paramBuffer.setSize$okio(paramBuffer.size() + k);
    return paramBuffer;
  }
  
  @NotNull
  public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWriteHexadecimalUnsignedLong");
    if (paramLong == 0L) {
      return paramBuffer.writeByte(48);
    }
    long l = paramLong >>> 1 | paramLong;
    l |= l >>> 2;
    l |= l >>> 4;
    l |= l >>> 8;
    l |= l >>> 16;
    l |= l >>> 32;
    l -= (l >>> 1 & 0x55555555);
    l = (l >>> 2 & 0x33333333) + (l & 0x33333333);
    l = (l >>> 4) + l & 0xF0F0F0F;
    l += (l >>> 8);
    l += (l >>> 16);
    int j = (int)(((l & 0x3F) + (l >>> 32 & 0x3F) + 3) / 4);
    Segment localSegment = paramBuffer.writableSegment$okio(j);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit + j - 1;
    int k = localSegment.limit;
    while (i >= k)
    {
      arrayOfByte[i] = getHEX_DIGIT_BYTES()[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localSegment.limit += j;
    paramBuffer.setSize$okio(paramBuffer.size() + j);
    return paramBuffer;
  }
  
  @NotNull
  public static final Buffer commonWriteInt(@NotNull Buffer paramBuffer, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWriteInt");
    Segment localSegment = paramBuffer.writableSegment$okio(4);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (i + 1);
    paramBuffer.setSize$okio(paramBuffer.size() + 4L);
    return paramBuffer;
  }
  
  @NotNull
  public static final Buffer commonWriteLong(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWriteLong");
    Segment localSegment = paramBuffer.writableSegment$okio(8);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 56 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 48 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 40 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 32 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
    localSegment.limit = (i + 1);
    paramBuffer.setSize$okio(paramBuffer.size() + 8L);
    return paramBuffer;
  }
  
  @NotNull
  public static final Buffer commonWriteShort(@NotNull Buffer paramBuffer, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWriteShort");
    Segment localSegment = paramBuffer.writableSegment$okio(2);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (j + 1);
    paramBuffer.setSize$okio(paramBuffer.size() + 2L);
    return paramBuffer;
  }
  
  @NotNull
  public static final Buffer commonWriteUtf8(@NotNull Buffer paramBuffer, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWriteUtf8");
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 >= paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 <= paramString.length()) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          while (paramInt1 < paramInt2)
          {
            int k = paramString.charAt(paramInt1);
            Segment localSegment;
            int j;
            if (k < 128)
            {
              localSegment = paramBuffer.writableSegment$okio(1);
              byte[] arrayOfByte = localSegment.data;
              j = localSegment.limit - paramInt1;
              int m = Math.min(paramInt2, 8192 - j);
              i = paramInt1 + 1;
              arrayOfByte[(paramInt1 + j)] = ((byte)k);
              paramInt1 = i;
              while (paramInt1 < m)
              {
                i = paramString.charAt(paramInt1);
                if (i >= 128) {
                  break;
                }
                arrayOfByte[(paramInt1 + j)] = ((byte)i);
                paramInt1 += 1;
              }
              i = j + paramInt1 - localSegment.limit;
              localSegment.limit += i;
              paramBuffer.setSize$okio(paramBuffer.size() + i);
            }
            else
            {
              label224:
              if (k < 2048)
              {
                localSegment = paramBuffer.writableSegment$okio(2);
                localSegment.data[localSegment.limit] = ((byte)(k >> 6 | 0xC0));
                localSegment.data[(localSegment.limit + 1)] = ((byte)(k & 0x3F | 0x80));
                localSegment.limit += 2;
                paramBuffer.setSize$okio(paramBuffer.size() + 2L);
              }
              for (;;)
              {
                paramInt1 += 1;
                break;
                if ((k >= 55296) && (k <= 57343))
                {
                  j = paramInt1 + 1;
                  if (j < paramInt2) {
                    i = paramString.charAt(j);
                  } else {
                    i = 0;
                  }
                  if ((k <= 56319) && (56320 <= i) && (57343 >= i))
                  {
                    i = ((k & 0x3FF) << 10 | i & 0x3FF) + 65536;
                    localSegment = paramBuffer.writableSegment$okio(4);
                    localSegment.data[localSegment.limit] = ((byte)(i >> 18 | 0xF0));
                    localSegment.data[(localSegment.limit + 1)] = ((byte)(i >> 12 & 0x3F | 0x80));
                    localSegment.data[(localSegment.limit + 2)] = ((byte)(i >> 6 & 0x3F | 0x80));
                    localSegment.data[(localSegment.limit + 3)] = ((byte)(i & 0x3F | 0x80));
                    localSegment.limit += 4;
                    paramBuffer.setSize$okio(paramBuffer.size() + 4L);
                    paramInt1 += 2;
                    break;
                  }
                  paramBuffer.writeByte(63);
                  paramInt1 = j;
                  break label224;
                }
                localSegment = paramBuffer.writableSegment$okio(3);
                localSegment.data[localSegment.limit] = ((byte)(k >> 12 | 0xE0));
                localSegment.data[(localSegment.limit + 1)] = ((byte)(0x3F & k >> 6 | 0x80));
                localSegment.data[(localSegment.limit + 2)] = ((byte)(k & 0x3F | 0x80));
                localSegment.limit += 3;
                paramBuffer.setSize$okio(paramBuffer.size() + 3L);
              }
            }
          }
          return paramBuffer;
        }
        paramBuffer = new StringBuilder();
        paramBuffer.append("endIndex > string.length: ");
        paramBuffer.append(paramInt2);
        paramBuffer.append(" > ");
        paramBuffer.append(paramString.length());
        throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("endIndex < beginIndex: ");
      paramBuffer.append(paramInt2);
      paramBuffer.append(" < ");
      paramBuffer.append(paramInt1);
      throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("beginIndex < 0: ");
    paramBuffer.append(paramInt1);
    paramBuffer = (Throwable)new IllegalArgumentException(paramBuffer.toString().toString());
    for (;;)
    {
      throw paramBuffer;
    }
  }
  
  @NotNull
  public static final Buffer commonWriteUtf8CodePoint(@NotNull Buffer paramBuffer, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$commonWriteUtf8CodePoint");
    if (paramInt < 128)
    {
      paramBuffer.writeByte(paramInt);
      return paramBuffer;
    }
    Segment localSegment;
    if (paramInt < 2048)
    {
      localSegment = paramBuffer.writableSegment$okio(2);
      localSegment.data[localSegment.limit] = ((byte)(paramInt >> 6 | 0xC0));
      localSegment.data[(localSegment.limit + 1)] = ((byte)(paramInt & 0x3F | 0x80));
      localSegment.limit += 2;
      paramBuffer.setSize$okio(paramBuffer.size() + 2L);
      return paramBuffer;
    }
    if ((55296 <= paramInt) && (57343 >= paramInt))
    {
      paramBuffer.writeByte(63);
      return paramBuffer;
    }
    if (paramInt < 65536)
    {
      localSegment = paramBuffer.writableSegment$okio(3);
      localSegment.data[localSegment.limit] = ((byte)(paramInt >> 12 | 0xE0));
      localSegment.data[(localSegment.limit + 1)] = ((byte)(paramInt >> 6 & 0x3F | 0x80));
      localSegment.data[(localSegment.limit + 2)] = ((byte)(paramInt & 0x3F | 0x80));
      localSegment.limit += 3;
      paramBuffer.setSize$okio(paramBuffer.size() + 3L);
      return paramBuffer;
    }
    if (paramInt <= 1114111)
    {
      localSegment = paramBuffer.writableSegment$okio(4);
      localSegment.data[localSegment.limit] = ((byte)(paramInt >> 18 | 0xF0));
      localSegment.data[(localSegment.limit + 1)] = ((byte)(paramInt >> 12 & 0x3F | 0x80));
      localSegment.data[(localSegment.limit + 2)] = ((byte)(paramInt >> 6 & 0x3F | 0x80));
      localSegment.data[(localSegment.limit + 3)] = ((byte)(paramInt & 0x3F | 0x80));
      localSegment.limit += 4;
      paramBuffer.setSize$okio(paramBuffer.size() + 4L);
      return paramBuffer;
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("Unexpected code point: 0x");
    paramBuffer.append(-Util.toHexString(paramInt));
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString()));
  }
  
  @NotNull
  public static final byte[] getHEX_DIGIT_BYTES()
  {
    return HEX_DIGIT_BYTES;
  }
  
  public static final boolean rangeEquals(@NotNull Segment paramSegment, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramSegment, "segment");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "bytes");
    int i = paramSegment.limit;
    Object localObject = paramSegment.data;
    while (paramInt2 < paramInt3)
    {
      int j = i;
      Segment localSegment = paramSegment;
      int k = paramInt1;
      if (paramInt1 == i)
      {
        localSegment = paramSegment.next;
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
        paramSegment = localSegment.data;
        k = localSegment.pos;
        j = localSegment.limit;
        localObject = paramSegment;
      }
      if (localObject[k] != paramArrayOfByte[paramInt2]) {
        return false;
      }
      paramInt1 = k + 1;
      paramInt2 += 1;
      i = j;
      paramSegment = localSegment;
    }
    return true;
  }
  
  @NotNull
  public static final String readUtf8Line(@NotNull Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$readUtf8Line");
    if (paramLong > 0L)
    {
      long l = paramLong - 1L;
      if (paramBuffer.getByte(l) == (byte)13)
      {
        str = paramBuffer.readUtf8(l);
        paramBuffer.skip(2L);
        return str;
      }
    }
    String str = paramBuffer.readUtf8(paramLong);
    paramBuffer.skip(1L);
    return str;
  }
  
  public static final <T> T seek(@NotNull Buffer paramBuffer, long paramLong, @NotNull Function2<? super Segment, ? super Long, ? extends T> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$seek");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "lambda");
    Segment localSegment = paramBuffer.head;
    if (localSegment != null)
    {
      if (paramBuffer.size() - paramLong < paramLong)
      {
        for (l1 = paramBuffer.size(); l1 > paramLong; l1 -= localSegment.limit - localSegment.pos)
        {
          localSegment = localSegment.prev;
          if (localSegment == null) {
            Intrinsics.throwNpe();
          }
        }
        return paramFunction2.invoke(localSegment, Long.valueOf(l1));
      }
      long l2;
      for (long l1 = 0L;; l1 = l2)
      {
        l2 = localSegment.limit - localSegment.pos + l1;
        if (l2 > paramLong) {
          return paramFunction2.invoke(localSegment, Long.valueOf(l1));
        }
        localSegment = localSegment.next;
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
      }
    }
    return paramFunction2.invoke(null, Long.valueOf(-1L));
  }
  
  public static final int selectPrefix(@NotNull Buffer paramBuffer, @NotNull Options paramOptions, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "$this$selectPrefix");
    Intrinsics.checkParameterIsNotNull(paramOptions, "options");
    Segment localSegment = paramBuffer.head;
    if (localSegment != null)
    {
      Object localObject1 = localSegment.data;
      int i = localSegment.pos;
      int j = localSegment.limit;
      int[] arrayOfInt = paramOptions.getTrie$okio();
      int m = -1;
      paramOptions = localSegment;
      int n = 0;
      int k = n + 1;
      int i4 = arrayOfInt[n];
      n = k + 1;
      k = arrayOfInt[k];
      if (k != -1) {
        m = k;
      }
      Object localObject2;
      int i2;
      if (paramOptions != null)
      {
        if (i4 < 0)
        {
          k = n;
          i1 = j;
          localObject2 = localObject1;
          localObject1 = paramOptions;
        }
      }
      else {
        for (;;)
        {
          int i3 = i + 1;
          i = localObject2[i];
          i2 = k + 1;
          if ((i & 0xFF) != arrayOfInt[k]) {
            return m;
          }
          if (i2 == n + i4 * -1) {
            k = 1;
          } else {
            k = 0;
          }
          i = i3;
          paramBuffer = (Buffer)localObject1;
          paramOptions = (Options)localObject2;
          j = i1;
          if (i3 == i1)
          {
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            localObject1 = ((Segment)localObject1).next;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            i = ((Segment)localObject1).pos;
            paramOptions = ((Segment)localObject1).data;
            j = ((Segment)localObject1).limit;
            paramBuffer = (Buffer)localObject1;
            if (localObject1 == localSegment)
            {
              if (k == 0)
              {
                if (paramBoolean) {
                  return -2;
                }
                return m;
              }
              paramBuffer = (Segment)null;
            }
          }
          if (k != 0)
          {
            n = arrayOfInt[i2];
            localObject1 = paramOptions;
            k = j;
            break;
          }
          k = i2;
          localObject1 = paramBuffer;
          localObject2 = paramOptions;
          i1 = j;
        }
      }
      int i1 = i + 1;
      k = localObject1[i];
      i = n;
      for (;;)
      {
        if (i == n + i4) {
          return m;
        }
        if ((k & 0xFF) == arrayOfInt[i])
        {
          i2 = arrayOfInt[(i + i4)];
          paramBuffer = paramOptions;
          n = i2;
          k = j;
          i = i1;
          if (i1 == j)
          {
            paramBuffer = paramOptions.next;
            if (paramBuffer == null) {
              Intrinsics.throwNpe();
            }
            i = paramBuffer.pos;
            localObject1 = paramBuffer.data;
            k = paramBuffer.limit;
            if (paramBuffer == localSegment)
            {
              paramBuffer = (Segment)null;
              n = i2;
            }
            else
            {
              n = i2;
            }
          }
          if (n >= 0) {
            return n;
          }
          n = -n;
          paramOptions = paramBuffer;
          j = k;
          break;
        }
        i += 1;
      }
    }
    if (paramBoolean) {
      return -2;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.internal.BufferKt
 * JD-Core Version:    0.7.0.1
 */