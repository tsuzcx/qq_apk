package com.tencent.mobileqq.microapp.apkg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s
  implements Cloneable
{
  public int a;
  public int b;
  public int c;
  public String d;
  public String e;
  public List f;
  
  public static Bitmap a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (paramString != null)
        {
          paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
          return paramString;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static s a(JSONObject paramJSONObject)
  {
    s locals = null;
    if (paramJSONObject != null)
    {
      locals = new s();
      locals.a = DisplayUtil.parseColor(paramJSONObject.optString("color"));
      locals.b = DisplayUtil.parseColor(paramJSONObject.optString("selectedColor"));
      locals.c = DisplayUtil.parseColor(paramJSONObject.optString("backgroundColor"));
      locals.d = paramJSONObject.optString("borderStyle", "black");
      locals.f = a(paramJSONObject.optJSONArray("list"));
      locals.e = paramJSONObject.optString("position", "bottom");
    }
    return locals;
  }
  
  public static List a(JSONArray paramJSONArray)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {
          localLinkedList.add(s.a.a(localJSONObject));
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public s a()
  {
    try
    {
      locals1 = (s)super.clone();
      try
      {
        locals1.f = new LinkedList();
        Iterator localIterator = this.f.iterator();
        for (;;)
        {
          Object localObject = locals1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (s.a)localIterator.next();
          locals1.f.add(((s.a)localObject).a());
        }
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        s locals2;
        s locals1 = null;
      }
    }
    locals2 = locals1;
    return locals2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.s
 * JD-Core Version:    0.7.0.1
 */