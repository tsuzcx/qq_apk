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
    boolean bool;
    if (paramLong1 >= 0L) {
      bool = true;
    }
    label132:
    for (;;)
    {
      try
      {
        Assertions.checkArgument(bool);
        if (paramLong2 >= 0L)
        {
          bool = true;
          Assertions.checkArgument(bool);
          if (paramLong3 > 0L) {
            break label132;
          }
          if (paramLong3 == -1L)
          {
            break label132;
            Assertions.checkArgument(bool);
            this.uri = paramUri;
            this.absoluteStreamPosition = paramLong1;
            this.position = paramLong2;
            this.length = paramLong3;
            this.key = paramString1;
            this.flags = paramInt1;
            this.uuid = paramString2;
            this.priority = paramInt2;
            return;
            bool = false;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        bool = false;
        continue;
        bool = true;
      }
      catch (IllegalArgumentException paramUri)
      {
        throw new IllegalDataSpecException(paramUri);
      }
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
    boolean bool;
    if (paramLong1 >= 0L) {
      bool = true;
    }
    label136:
    for (;;)
    {
      try
      {
        Assertions.checkArgument(bool);
        if (paramLong2 >= 0L)
        {
          bool = true;
          Assertions.checkArgument(bool);
          if (paramLong3 > 0L) {
            break label136;
          }
          if (paramLong3 == -1L)
          {
            break label136;
            Assertions.checkArgument(bool);
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
            bool = false;
          }
        }
        else
        {
          bool = false;
          continue;
        }
        bool = false;
        continue;
        bool = true;
      }
      catch (IllegalArgumentException paramUri)
      {
        throw new IllegalDataSpecException(paramUri);
      }
    }
  }
  
  public String toString()
  {
    return "DataSpec[uri=" + this.uri + ", originUrl=" + this.originUrl + ", absPos=" + this.absoluteStreamPosition + ", pos=" + this.position + ", len=" + this.length + ", key=" + this.key + ", flags=" + this.flags + ", uuid=" + this.uuid + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DataSpec
 * JD-Core Version:    0.7.0.1
 */