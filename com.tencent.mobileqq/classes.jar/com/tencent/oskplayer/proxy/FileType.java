package com.tencent.oskplayer.proxy;

import android.text.TextUtils;
import com.tencent.oskplayer.util.Base16;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class FileType
{
  public static final FileType OCTET_STREAM;
  public static final FileType UNKNOWN = new FileType("unknown");
  private static final byte[] UNKNOWN_UTF8_BYTES = { 117, 110, 107, 110, 111, 119, 110 };
  public static final FileType VIDEO_MP4;
  private static final String charset = "UTF-8";
  public static HashMap<String, FileType> sEncodeFileTypeCacheMap = new HashMap();
  String encodeBase16PlainType;
  String plainType;
  
  static
  {
    OCTET_STREAM = new FileType("application/octet-stream");
    VIDEO_MP4 = new FileType("video/mp4");
  }
  
  private FileType(String paramString)
  {
    this.plainType = paramString;
  }
  
  public static FileType decode(String paramString)
  {
    if (sEncodeFileTypeCacheMap.containsKey(paramString)) {
      return (FileType)sEncodeFileTypeCacheMap.get(paramString);
    }
    FileType localFileType = getFileType(decodeBase16(paramString));
    sEncodeFileTypeCacheMap.put(paramString, localFileType);
    return localFileType;
  }
  
  private static String decodeBase16(String paramString)
  {
    try
    {
      paramString = new String(Base16.decode(paramString), "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label16:
      break label16;
    }
    return UNKNOWN.toString();
  }
  
  private static String encodeBase16(String paramString)
  {
    try
    {
      paramString = Base16.encode(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label12:
      break label12;
    }
    return Base16.encode(UNKNOWN_UTF8_BYTES);
  }
  
  public static FileType getFileType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return UNKNOWN;
    }
    if (paramString.equals("video/mp4")) {
      return VIDEO_MP4;
    }
    if (paramString.equals("unknown")) {
      return UNKNOWN;
    }
    return new FileType(paramString);
  }
  
  public String encode()
  {
    if (TextUtils.isEmpty(this.encodeBase16PlainType))
    {
      this.encodeBase16PlainType = encodeBase16(this.plainType);
      return this.encodeBase16PlainType;
    }
    return this.encodeBase16PlainType;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (FileType)paramObject;
      String str = this.plainType;
      if (str != null) {
        if (str.equals(paramObject.plainType)) {
          break label65;
        }
      } else if (paramObject.plainType == null) {
        return true;
      }
      bool = false;
      label65:
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.plainType;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return this.plainType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.FileType
 * JD-Core Version:    0.7.0.1
 */