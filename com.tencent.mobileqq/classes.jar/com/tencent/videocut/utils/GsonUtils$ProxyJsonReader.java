package com.tencent.videocut.utils;

import com.google.gson.stream.JsonReader;
import com.tencent.videocut.utils.log.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/GsonUtils$ProxyJsonReader;", "Lcom/google/gson/stream/JsonReader;", "input", "Ljava/io/Reader;", "(Ljava/io/Reader;)V", "nextBoolean", "", "nextDouble", "", "nextInt", "", "nextLong", "", "nextName", "", "nextString", "Companion", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class GsonUtils$ProxyJsonReader
  extends JsonReader
{
  @NotNull
  public static final GsonUtils.ProxyJsonReader.Companion a = new GsonUtils.ProxyJsonReader.Companion(null);
  
  public boolean nextBoolean()
  {
    try
    {
      boolean bool = super.nextBoolean();
      return bool;
    }
    catch (Exception localException)
    {
      Logger.a("ProxyJsonReader", "nextBoolean", (Throwable)localException);
    }
    return false;
  }
  
  public double nextDouble()
  {
    try
    {
      double d = super.nextDouble();
      return d;
    }
    catch (Exception localException)
    {
      Logger.a("ProxyJsonReader", "nextDouble", (Throwable)localException);
    }
    return 0.0D;
  }
  
  public int nextInt()
  {
    try
    {
      int i = super.nextInt();
      return i;
    }
    catch (Exception localException)
    {
      Logger.a("ProxyJsonReader", "nextInt", (Throwable)localException);
    }
    return 0;
  }
  
  public long nextLong()
  {
    try
    {
      long l = super.nextLong();
      return l;
    }
    catch (Exception localException)
    {
      Logger.a("ProxyJsonReader", "nextLong", (Throwable)localException);
    }
    return 0L;
  }
  
  @NotNull
  public String nextName()
  {
    try
    {
      String str = super.nextName();
      Intrinsics.checkNotNullExpressionValue(str, "super.nextName()");
      return str;
    }
    catch (Exception localException)
    {
      Logger.a("ProxyJsonReader", "nextName", (Throwable)localException);
    }
    return "";
  }
  
  @NotNull
  public String nextString()
  {
    try
    {
      String str = super.nextString();
      Intrinsics.checkNotNullExpressionValue(str, "super.nextString()");
      return str;
    }
    catch (Exception localException)
    {
      Logger.a("ProxyJsonReader", "nextString", (Throwable)localException);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.GsonUtils.ProxyJsonReader
 * JD-Core Version:    0.7.0.1
 */