package com.tencent.mtt.hippy.utils;

import android.util.LruCache;
import com.tencent.mtt.hippy.common.HippyArray;
import java.nio.charset.Charset;

public class HippyBuffer
{
  private static final byte[] BASE64_IMG_HEADER = { 100, 97, 116, 97, 58, 105, 109, 97, 103, 101, 47 };
  private static final Charset CHARSET_FOR_ONE_BYTE_STR;
  private static final String IMG_SRC_PROP_NAME = "src";
  private static final String IMG_URI_PROP_NAME = "uri";
  private static final int MAP_PROPERTY_POOL_SZIE = 2048;
  private static final String TAG = "HippyBuffer";
  private static final byte TYPE_ARRAY = 6;
  private static final byte TYPE_BOOLEAN_FALSE = 3;
  private static final byte TYPE_BOOLEAN_TRUE = 2;
  private static final byte TYPE_DOUBLE = 5;
  private static final byte TYPE_INTEGER = 4;
  private static final byte TYPE_MAP = 7;
  private static final byte TYPE_NULL = 0;
  private static final byte TYPE_ONE_BYTE_STRING = 8;
  private static final byte TYPE_STRING = 1;
  private static final byte TYPE_UNDEFINED = -1;
  private static final Object VALUE_UNDEFINED = new Object();
  private static final String[] sPropertyCachePool;
  private static final ThreadLocal<char[]> sThreadCharBuffer;
  private int mCacheHitCount;
  private final LruCache<Integer, HippyBuffer.CacheItem> mImgStringCache = new LruCache(32);
  private int mTotalCount;
  
  static
  {
    CHARSET_FOR_ONE_BYTE_STR = loadOneByteStrCharset();
    sThreadCharBuffer = new ThreadLocal();
    sPropertyCachePool = new String[2048];
  }
  
  private static final Charset loadOneByteStrCharset()
  {
    try
    {
      localCharset1 = Charset.forName("ISO-8859-1");
      if (localCharset1 == null) {
        break label32;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Charset localCharset1;
        Charset localCharset2;
        localThrowable.printStackTrace();
        Object localObject = null;
        continue;
        label32:
        localObject = null;
      }
    }
    localCharset2 = localCharset1;
    if (localCharset1 == null) {
      localCharset2 = Charset.defaultCharset();
    }
    return localCharset2;
  }
  
  public final byte[] build(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      HippyBuffer.Builder localBuilder = new HippyBuffer.Builder(null);
      paramObject = HippyBuffer.Builder.access$400(localBuilder, paramObject);
      HippyBuffer.Builder.access$500(localBuilder);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        LogUtils.e("HippyBuffer", "Error Building Buffer", paramObject);
        paramObject = null;
      }
    }
  }
  
  public final Object parse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new HippyArray();
    }
    try
    {
      paramArrayOfByte = new HippyBuffer.Parser(this, paramArrayOfByte, null);
      Object localObject = HippyBuffer.Parser.access$100(paramArrayOfByte);
      HippyBuffer.Parser.access$200(paramArrayOfByte);
      return localObject;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      LogUtils.e("HippyBuffer", "Error Parsing Buffer", paramArrayOfByte);
    }
    return new HippyArray();
  }
  
  public final void release()
  {
    this.mImgStringCache.evictAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.HippyBuffer
 * JD-Core Version:    0.7.0.1
 */