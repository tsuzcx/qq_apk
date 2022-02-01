package com.tencent.nativevue;

import androidx.collection.ArrayMap;
import java.util.Map;

public class NativeVueEngine$Builder
{
  Map<String, String> envMap = new ArrayMap();
  NativeVueLogAdapter logAdapter;
  NativeVuePreconditionAdapter preconditionAdapter;
  
  public Builder env(String paramString1, String paramString2)
  {
    this.envMap.put(paramString1, paramString2);
    return this;
  }
  
  public Builder logAdapter(NativeVueLogAdapter paramNativeVueLogAdapter)
  {
    this.logAdapter = paramNativeVueLogAdapter;
    return this;
  }
  
  public Builder preconditionAdapter(NativeVuePreconditionAdapter paramNativeVuePreconditionAdapter)
  {
    this.preconditionAdapter = paramNativeVuePreconditionAdapter;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nativevue.NativeVueEngine.Builder
 * JD-Core Version:    0.7.0.1
 */