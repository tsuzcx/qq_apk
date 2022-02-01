package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import android.net.Uri;
import android.support.annotation.Nullable;
import java.util.Arrays;

public final class DataSpec
{
  public static final int FLAG_ALLOW_CACHE_FRAGMENTATION = 16;
  public static final int FLAG_ALLOW_GZIP = 1;
  public static final int FLAG_ALLOW_ICY_METADATA = 2;
  public static final int FLAG_DONT_CACHE_IF_LENGTH_UNKNOWN = 4;
  public static final int HTTP_METHOD_DELETE = 5;
  public static final int HTTP_METHOD_GET = 1;
  public static final int HTTP_METHOD_HEAD = 3;
  public static final int HTTP_METHOD_POST = 2;
  public static final int HTTP_METHOD_PUT = 4;
  public final long absoluteStreamPosition;
  public final int flags;
  @Nullable
  public final byte[] httpBody;
  public final int httpMethod;
  @Nullable
  public final String key;
  public final long length;
  public final long position;
  public final Uri uri;
  
  public DataSpec(Uri paramUri, int paramInt)
  {
    this(paramUri, paramInt, 0);
  }
  
  public DataSpec(Uri paramUri, int paramInt1, int paramInt2)
  {
    this(paramUri, paramInt1, 0L, -1L, null, paramInt2);
  }
  
  public DataSpec(Uri paramUri, int paramInt1, long paramLong1, long paramLong2, long paramLong3, @Nullable String paramString, int paramInt2)
  {
    this(paramUri, paramInt1, null, paramLong1, paramLong2, paramLong3, paramString, paramInt2);
  }
  
  public DataSpec(Uri paramUri, int paramInt, long paramLong1, long paramLong2, @Nullable String paramString)
  {
    this(paramUri, paramInt, paramLong1, paramLong1, paramLong2, paramString, 0);
  }
  
  public DataSpec(Uri paramUri, int paramInt1, long paramLong1, long paramLong2, @Nullable String paramString, int paramInt2)
  {
    this(paramUri, paramInt1, paramLong1, paramLong1, paramLong2, paramString, paramInt2);
  }
  
  public DataSpec(Uri paramUri, int paramInt1, @Nullable byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, @Nullable String paramString, int paramInt2)
  {
    boolean bool2 = true;
    if (paramLong1 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    if (paramLong2 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1);
    boolean bool1 = bool2;
    if (paramLong3 <= 0L) {
      if (paramLong3 == -1L) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    Assertions.checkArgument(bool1);
    this.uri = paramUri;
    this.httpMethod = paramInt1;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      paramArrayOfByte = null;
    }
    this.httpBody = paramArrayOfByte;
    this.absoluteStreamPosition = paramLong1;
    this.position = paramLong2;
    this.length = paramLong3;
    this.key = paramString;
    this.flags = paramInt2;
  }
  
  public static String getStringForHttpMethod(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt == 5) {
              return "DELETE";
            }
            throw new AssertionError(paramInt);
          }
          return "PUT";
        }
        return "HEAD";
      }
      return "POST";
    }
    return "GET";
  }
  
  public final String getHttpMethodString()
  {
    return getStringForHttpMethod(this.httpMethod);
  }
  
  public boolean isFlagSet(int paramInt)
  {
    return (this.flags & paramInt) == paramInt;
  }
  
  public DataSpec subrange(long paramLong)
  {
    long l2 = this.length;
    long l1 = -1L;
    if (l2 != -1L) {
      l1 = l2 - paramLong;
    }
    return subrange(paramLong, l1);
  }
  
  public DataSpec subrange(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) && (this.length == paramLong2)) {
      return this;
    }
    return new DataSpec(this.uri, this.httpMethod, this.httpBody, this.absoluteStreamPosition + paramLong1, this.position + paramLong1, paramLong2, this.key, this.flags);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataSpec[");
    localStringBuilder.append(getHttpMethodString());
    localStringBuilder.append(" ");
    localStringBuilder.append(this.uri);
    localStringBuilder.append(", ");
    localStringBuilder.append(Arrays.toString(this.httpBody));
    localStringBuilder.append(", ");
    localStringBuilder.append(this.absoluteStreamPosition);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.position);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.length);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.key);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.flags);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public DataSpec withUri(Uri paramUri)
  {
    return new DataSpec(paramUri, this.httpMethod, this.httpBody, this.absoluteStreamPosition, this.position, this.length, this.key, this.flags);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.DataSpec
 * JD-Core Version:    0.7.0.1
 */