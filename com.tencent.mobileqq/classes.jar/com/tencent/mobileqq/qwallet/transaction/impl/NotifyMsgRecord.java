package com.tencent.mobileqq.qwallet.transaction.impl;

import android.database.Cursor;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class NotifyMsgRecord
{
  public int a;
  public long b;
  public int c;
  public String d;
  public long e;
  public JSONObject f;
  protected String g;
  
  public NotifyMsgRecord(int paramInt1, long paramLong1, int paramInt2, String paramString1, long paramLong2, String paramString2)
  {
    this.a = paramInt1;
    this.b = paramLong1;
    this.c = paramInt2;
    this.d = paramString1;
    this.e = paramLong2;
    this.g = paramString2;
  }
  
  public static NotifyMsgRecord a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    int i1 = paramCursor.getColumnIndexOrThrow("no");
    int m = paramCursor.getColumnIndexOrThrow("uin");
    int n = paramCursor.getColumnIndexOrThrow("btype");
    int i = paramCursor.getColumnIndexOrThrow("bid");
    int j = paramCursor.getColumnIndexOrThrow("create_time");
    int k = paramCursor.getColumnIndexOrThrow("ext");
    i1 = paramCursor.getInt(i1);
    long l1 = paramCursor.getLong(m);
    m = paramCursor.getInt(n);
    String str = paramCursor.getString(i);
    long l2 = paramCursor.getLong(j);
    paramCursor = paramCursor.getString(k);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fromCursorOrThrow bId:");
      localStringBuilder.append(str);
      localStringBuilder.append(" extJson:");
      localStringBuilder.append(paramCursor);
      QLog.i("NotifyMsgRecord", 2, localStringBuilder.toString());
    }
    return new NotifyMsgRecord(i1, l1, m, str, l2, paramCursor);
  }
  
  public int a(String paramString, int paramInt)
  {
    a(false);
    JSONObject localJSONObject = this.f;
    if (localJSONObject == null) {
      return paramInt;
    }
    return localJSONObject.optInt(paramString, paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(true);
    try
    {
      this.f.put(paramString1, paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      if (QLog.isColorLevel()) {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.f != null) {
      return;
    }
    String str = this.g;
    if ((str != null) && (str.length() > 0))
    {
      try
      {
        this.f = new JSONObject(this.g);
        return;
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        localThrowable.printStackTrace();
        return;
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      localJSONException.printStackTrace();
    }
    else if ((paramBoolean) && (this.f == null))
    {
      this.f = new JSONObject();
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    a(true);
    try
    {
      this.f.put(paramString, paramInt);
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgRecord
 * JD-Core Version:    0.7.0.1
 */