package com.tencent.mobileqq.easysync2;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.SparseArrayCompat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.tencent.util.Pair;

public class AttribPool
{
  SparseArrayCompat<Pair<String, String>> a = new SparseArrayCompat();
  ArrayMap<String, Integer> b = new ArrayMap();
  int c;
  
  public static JsonSerializer<AttribPool> a()
  {
    return new AttribPool.1();
  }
  
  public static AttribPool a(String paramString)
  {
    GsonBuilder localGsonBuilder = new GsonBuilder();
    localGsonBuilder.registerTypeAdapter(AttribPool.class, c());
    return (AttribPool)localGsonBuilder.create().fromJson(paramString, AttribPool.class);
  }
  
  private static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static JsonDeserializer<AttribPool> c()
  {
    return new AttribPool.2();
  }
  
  public int a(Pair<String, String> paramPair)
  {
    return a((String)paramPair.first, (String)paramPair.second, false);
  }
  
  public int a(Pair<String, String> paramPair, boolean paramBoolean)
  {
    return a((String)paramPair.first, (String)paramPair.second, paramBoolean);
  }
  
  public int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = b(paramString1, paramString2);
    if (this.b.containsKey(str)) {
      return ((Integer)this.b.get(str)).intValue();
    }
    if (paramBoolean) {
      return -1;
    }
    int i = this.c;
    this.c = (i + 1);
    this.b.put(str, Integer.valueOf(i));
    SparseArrayCompat localSparseArrayCompat = this.a;
    str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localSparseArrayCompat.put(i, new Pair(str, paramString1));
    return i;
  }
  
  public Pair<String, String> a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    Pair localPair = (Pair)this.a.get(paramInt);
    return new Pair(localPair.first, localPair.second);
  }
  
  public String b()
  {
    GsonBuilder localGsonBuilder = new GsonBuilder();
    localGsonBuilder.registerTypeAdapter(AttribPool.class, a());
    return localGsonBuilder.create().toJson(this);
  }
  
  public String b(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (String)((Pair)this.a.get(paramInt)).first;
  }
  
  public String c(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (String)((Pair)this.a.get(paramInt)).second;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.easysync2.AttribPool
 * JD-Core Version:    0.7.0.1
 */