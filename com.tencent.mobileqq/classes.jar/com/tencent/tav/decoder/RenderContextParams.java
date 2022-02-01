package com.tencent.tav.decoder;

import android.support.annotation.Nullable;
import java.util.HashMap;

public class RenderContextParams
{
  private HashMap<String, Object> params = new HashMap();
  
  @Nullable
  public Object getParam(String paramString)
  {
    return this.params.get(paramString);
  }
  
  public void putParam(String paramString, Object paramObject)
  {
    this.params.put(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.RenderContextParams
 * JD-Core Version:    0.7.0.1
 */