package com.tencent.oskplayer.datasource;

import android.net.Uri;
import com.tencent.oskplayer.util.Assertions;

public final class DataSpec
{
  public static final int FLAG_ALLOW_GZIP = 1;
  public final long absoluteStreamPosition;
  public final int flags;
  public final String key;
  public final long length;
  public String originUrl;
  public final long position;
  public final int priority;
  public final Uri uri;
  public final String uuid;
  
  public DataSpec(Uri paramUri, int paramInt, String paramString)
  {
    this(paramUri, 0L, -1L, null, paramInt, paramString);
  }
  
  public DataSpec(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt, String paramString2)
  {
    this(paramUri, paramLong1, paramLong2, paramLong3, paramString1, paramInt, paramString2, -1);
  }
  
  public DataSpec(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramLong1 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    for (;;)
    {
      try
      {
        Assertions.checkArgument(bool1);
        if (paramLong2 >= 0L)
        {
          bool1 = true;
          Assertions.checkArgument(bool1);
          if (paramLong3 > 0L) {
            break label136;
          }
          bool1 = bool2;
          if (paramLong3 == -1L) {
            break label136;
          }
          Assertions.checkArgument(bool1);
          this.uri = paramUri;
          this.absoluteStreamPosition = paramLong1;
          this.position = paramLong2;
          this.length = paramLong3;
          this.key = paramString1;
          this.flags = paramInt1;
          this.uuid = paramString2;
          this.priority = paramInt2;
          return;
        }
      }
      catch (IllegalArgumentException paramUri)
      {
        throw new IllegalDataSpecException(paramUri);
      }
      bool1 = false;
      continue;
      label136:
      bool1 = true;
    }
  }
  
  public DataSpec(Uri paramUri, long paramLong1, long paramLong2, String paramString1, int paramInt, String paramString2)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString1, paramInt, paramString2);
  }
  
  public DataSpec(Uri paramUri, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString1, 0, paramString2);
  }
  
  public DataSpec(Uri paramUri, String paramString)
  {
    this(paramUri, 0, paramString);
  }
  
  public DataSpec(Uri paramUri, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, int paramInt, String paramString3)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramLong1 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    for (;;)
    {
      try
      {
        Assertions.checkArgument(bool1);
        if (paramLong2 >= 0L)
        {
          bool1 = true;
          Assertions.checkArgument(bool1);
          if (paramLong3 > 0L) {
            break label140;
          }
          bool1 = bool2;
          if (paramLong3 == -1L) {
            break label140;
          }
          Assertions.checkArgument(bool1);
          this.originUrl = paramString1;
          this.uri = paramUri;
          this.absoluteStreamPosition = paramLong1;
          this.position = paramLong2;
          this.length = paramLong3;
          this.key = paramString2;
          this.flags = paramInt;
          this.uuid = paramString3;
          this.priority = -1;
          return;
        }
      }
      catch (IllegalArgumentException paramUri)
      {
        throw new IllegalDataSpecException(paramUri);
      }
      bool1 = false;
      continue;
      label140:
      bool1 = true;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataSpec[uri=");
    localStringBuilder.append(this.uri);
    localStringBuilder.append(", originUrl=");
    localStringBuilder.append(this.originUrl);
    localStringBuilder.append(", absPos=");
    localStringBuilder.append(this.absoluteStreamPosition);
    localStringBuilder.append(", pos=");
    localStringBuilder.append(this.position);
    localStringBuilder.append(", len=");
    localStringBuilder.append(this.length);
    localStringBuilder.append(", key=");
    localStringBuilder.append(this.key);
    localStringBuilder.append(", flags=");
    localStringBuilder.append(this.flags);
    localStringBuilder.append(", uuid=");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DataSpec
 * JD-Core Version:    0.7.0.1
 */