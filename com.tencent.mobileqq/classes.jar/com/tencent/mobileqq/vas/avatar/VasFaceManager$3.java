package com.tencent.mobileqq.vas.avatar;

import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

class VasFaceManager$3
  extends LinkedHashMap<String, Object>
{
  VasFaceManager$3(VasFaceManager paramVasFaceManager, int paramInt, float paramFloat, boolean paramBoolean)
  {
    super(paramInt, paramFloat, paramBoolean);
  }
  
  public Object put(String paramString, Object paramObject)
  {
    try
    {
      paramString = super.put(paramString, paramObject);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected boolean removeEldestEntry(Map.Entry<String, Object> paramEntry)
  {
    if (size() > 20)
    {
      GlobalImageCache.a.remove(paramEntry.getKey());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasFaceManager.3
 * JD-Core Version:    0.7.0.1
 */