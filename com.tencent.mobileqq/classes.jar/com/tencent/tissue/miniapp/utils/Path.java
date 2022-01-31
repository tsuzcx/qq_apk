package com.tencent.tissue.miniapp.utils;

import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

public class Path
{
  private static ThreadLocal<SoftReference<CharsetEncoder>> encoder = new ThreadLocal();
  private static final Charset jnuEncoding = Charset.forName("UTF-8");
  private volatile int[] offsets;
  private final byte[] path;
  private volatile String stringValue;
  
  public Path(String paramString)
  {
    this(encode(normalizeAndCheck(paramString)));
  }
  
  public Path(byte[] paramArrayOfByte)
  {
    this.path = paramArrayOfByte;
  }
  
  private static void checkNotNul(String paramString, char paramChar)
  {
    if (paramChar == 0) {
      throw new IllegalArgumentException(paramString + " Nul character not allowed");
    }
  }
  
  private static byte[] encode(String paramString)
  {
    int i = 1;
    Object localObject1 = (SoftReference)encoder.get();
    if (localObject1 != null) {}
    Object localObject2;
    ByteBuffer localByteBuffer;
    for (localObject1 = (CharsetEncoder)((SoftReference)localObject1).get();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = jnuEncoding.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
        encoder.set(new SoftReference(localObject2));
      }
      Object localObject3 = paramString.toCharArray();
      localObject1 = new byte[(int)(localObject3.length * ((CharsetEncoder)localObject2).maxBytesPerChar())];
      localByteBuffer = ByteBuffer.wrap((byte[])localObject1);
      localObject3 = CharBuffer.wrap((char[])localObject3);
      ((CharsetEncoder)localObject2).reset();
      if (((CharsetEncoder)localObject2).encode((CharBuffer)localObject3, localByteBuffer, true).isUnderflow()) {
        break;
      }
      if (i == 0) {
        break label174;
      }
      throw new IllegalArgumentException(paramString + " Malformed input or input contains unmappable characters");
    }
    if (!((CharsetEncoder)localObject2).flush(localByteBuffer).isUnderflow()) {}
    for (i = 1;; i = 0) {
      break;
    }
    label174:
    i = localByteBuffer.position();
    if (i != localObject1.length) {
      return Arrays.copyOf((byte[])localObject1, i);
    }
    return localObject1;
  }
  
  public static Path getPath(String paramString, String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (;;)
    {
      return new Path(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramString = paramVarArgs[i];
        if (paramString.length() > 0)
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append('/');
          }
          localStringBuilder.append(paramString);
        }
        i += 1;
      }
      paramString = localStringBuilder.toString();
    }
  }
  
  private void initOffsets()
  {
    int m = 0;
    if (this.offsets == null)
    {
      int k;
      Object localObject1;
      int j;
      int i;
      if (isEmpty())
      {
        k = 1;
        localObject1 = new int[k];
        j = 0;
        i = m;
        for (;;)
        {
          label29:
          if (i < this.path.length) {
            if (this.path[i] == 47)
            {
              i += 1;
              continue;
              label56:
              i = k;
            }
          }
        }
      }
      for (;;)
      {
        k = j;
        if (i >= this.path.length) {
          break;
        }
        localObject1 = this.path;
        k = i + 1;
        if (localObject1[i] == 47) {
          break label56;
        }
        int n = j + 1;
        for (;;)
        {
          i = k;
          j = n;
          if (k >= this.path.length) {
            break;
          }
          i = k;
          j = n;
          if (this.path[k] == 47) {
            break;
          }
          k += 1;
        }
        localObject1[j] = i;
        i += 1;
        while ((i < this.path.length) && (this.path[i] != 47))
        {
          i += 1;
          continue;
          try
          {
            if (this.offsets == null) {
              this.offsets = ((int[])localObject1);
            }
            return;
          }
          finally {}
        }
        j += 1;
        break label29;
        i = 0;
        j = 0;
      }
    }
  }
  
  private boolean isEmpty()
  {
    return this.path.length == 0;
  }
  
  private static String normalize(String paramString, int paramInt1, int paramInt2)
  {
    int k = 0;
    int i = paramInt1;
    if (paramInt1 == 0) {
      return paramString;
    }
    while ((i > 0) && (paramString.charAt(i - 1) == '/')) {
      i -= 1;
    }
    if (i == 0) {
      return "/";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int j = k;
    paramInt1 = paramInt2;
    if (paramInt2 > 0)
    {
      localStringBuilder.append(paramString.substring(0, paramInt2));
      paramInt1 = paramInt2;
      j = k;
    }
    if (paramInt1 < i)
    {
      char c = paramString.charAt(paramInt1);
      if ((c == '/') && (j == 47)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        checkNotNul(paramString, c);
        localStringBuilder.append(c);
        j = c;
      }
    }
    return localStringBuilder.toString();
  }
  
  static String normalizeAndCheck(String paramString)
  {
    int i = 0;
    int k = paramString.length();
    int j = 0;
    char c;
    String str;
    if (i < k)
    {
      c = paramString.charAt(i);
      if ((c == '/') && (j == 47)) {
        str = normalize(paramString, k, i - 1);
      }
    }
    do
    {
      return str;
      checkNotNul(paramString, c);
      i += 1;
      j = c;
      break;
      str = paramString;
    } while (j != 47);
    return normalize(paramString, k, k - 1);
  }
  
  public Path getFileName()
  {
    initOffsets();
    int i = this.offsets.length;
    if (i == 0) {
      localObject = null;
    }
    do
    {
      return localObject;
      if ((i != 1) || (this.path.length <= 0)) {
        break;
      }
      localObject = this;
    } while (this.path[0] != 47);
    i = this.offsets[(i - 1)];
    int j = this.path.length - i;
    Object localObject = new byte[j];
    System.arraycopy(this.path, i, localObject, 0, j);
    return new Path((byte[])localObject);
  }
  
  public int getNameCount()
  {
    initOffsets();
    return this.offsets.length;
  }
  
  public boolean isAbsolute()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.path.length > 0)
    {
      bool1 = bool2;
      if (this.path[0] == 47) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public Path normalize()
  {
    int i2 = getNameCount();
    if ((i2 == 0) || (isEmpty())) {
      return this;
    }
    Object localObject = new boolean[i2];
    int[] arrayOfInt = new int[i2];
    int j = 0;
    boolean bool = isAbsolute();
    int k = 0;
    int i = i2;
    label45:
    int n;
    int m;
    if (k < i2)
    {
      n = this.offsets[k];
      if (k == this.offsets.length - 1)
      {
        m = this.path.length - n;
        label80:
        arrayOfInt[k] = m;
        if (this.path[n] != 46) {
          break label624;
        }
        if (m != 1) {
          break label154;
        }
        localObject[k] = 1;
        m = i - 1;
        i = j;
        j = m;
      }
    }
    for (;;)
    {
      m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break label45;
      m = this.offsets[(k + 1)] - n - 1;
      break label80;
      label154:
      if (this.path[(n + 1)] == 46)
      {
        m = 1;
        j = i;
        i = m;
        continue;
        k = i;
        if (j != 0)
        {
          m = i;
          label188:
          j = -1;
          k = 0;
          i = m;
          label195:
          if (k < i2) {
            if (localObject[k] != 0)
            {
              n = j;
              j = i;
              i = n;
            }
          }
        }
        for (;;)
        {
          n = k + 1;
          k = i;
          i = j;
          j = k;
          k = n;
          break label195;
          if (arrayOfInt[k] != 2)
          {
            j = i;
            i = k;
          }
          else
          {
            n = this.offsets[k];
            if ((this.path[n] != 46) || (this.path[(n + 1)] != 46))
            {
              j = i;
              i = k;
            }
            else if (j >= 0)
            {
              localObject[j] = 1;
              localObject[k] = 1;
              j = i - 2;
              i = -1;
            }
            else
            {
              if (bool)
              {
                int i3 = 0;
                n = 0;
                for (;;)
                {
                  int i1 = i3;
                  if (n < k)
                  {
                    if (localObject[n] == 0) {
                      i1 = 1;
                    }
                  }
                  else
                  {
                    if (i1 != 0) {
                      break label613;
                    }
                    localObject[k] = 1;
                    n = i - 1;
                    i = j;
                    j = n;
                    break;
                  }
                  n += 1;
                }
                if (m <= i)
                {
                  k = i;
                  if (k == i2) {
                    break;
                  }
                  if (k == 0)
                  {
                    if (bool) {}
                    for (localObject = new Path(new byte[47]);; localObject = new Path(new byte[0])) {
                      return localObject;
                    }
                  }
                  j = k - 1;
                  i = j;
                  if (bool) {
                    i = j + 1;
                  }
                  j = 0;
                  while (j < i2)
                  {
                    m = i;
                    if (localObject[j] == 0) {
                      m = i + arrayOfInt[j];
                    }
                    j += 1;
                    i = m;
                  }
                  byte[] arrayOfByte = new byte[i];
                  if (bool)
                  {
                    i = 1;
                    arrayOfByte[0] = 47;
                  }
                  for (;;)
                  {
                    n = 0;
                    if (n < i2)
                    {
                      j = i;
                      m = k;
                      if (localObject[n] == 0)
                      {
                        System.arraycopy(this.path, this.offsets[n], arrayOfByte, i, arrayOfInt[n]);
                        i = arrayOfInt[n] + i;
                        m = k - 1;
                        if (m <= 0) {
                          break label596;
                        }
                        j = i + 1;
                        arrayOfByte[i] = 47;
                      }
                      k = m;
                      i = j;
                    }
                    for (;;)
                    {
                      n += 1;
                      break;
                      return new Path(arrayOfByte);
                      label596:
                      k = m;
                    }
                    i = 0;
                  }
                }
                m = i;
                break label188;
              }
              label613:
              n = i;
              i = j;
              j = n;
            }
          }
        }
      }
      else
      {
        label624:
        m = i;
        i = j;
        j = m;
      }
    }
  }
  
  public String toString()
  {
    if (this.stringValue == null) {
      this.stringValue = new String(this.path, jnuEncoding);
    }
    return this.stringValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.miniapp.utils.Path
 * JD-Core Version:    0.7.0.1
 */