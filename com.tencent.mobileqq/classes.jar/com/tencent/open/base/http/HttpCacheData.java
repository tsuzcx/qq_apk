package com.tencent.open.base.http;

import android.content.ContentValues;
import android.os.Parcel;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.component.cache.database.DbCacheData;
import com.tencent.open.component.cache.database.DbCacheData.DbCreator;

public class HttpCacheData
  extends DbCacheData
{
  public static final DbCacheData.DbCreator<HttpCacheData> g = new HttpCacheData.1();
  public String a;
  public String b;
  public long c;
  public long d;
  public String e;
  public String f;
  
  protected HttpCacheData(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramString3;
  }
  
  HttpCacheData(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    this.a = MD5Utils.encodeHexStr(paramString1);
    this.b = paramString2;
    this.c = paramLong;
    this.d = System.currentTimeMillis();
    this.e = paramString3;
    this.f = paramString4;
  }
  
  public void a(ContentValues paramContentValues)
  {
    paramContentValues.put("urlKey", this.a);
    paramContentValues.put("ETag", this.b);
    paramContentValues.put("lastModify", Long.valueOf(this.c));
    paramContentValues.put("cacheTime", Long.valueOf(this.d));
    Parcel localParcel = Parcel.obtain();
    localParcel.writeString(this.e);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    paramContentValues.put("response", arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.http.HttpCacheData
 * JD-Core Version:    0.7.0.1
 */