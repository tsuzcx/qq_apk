package com.tencent.viola.ui.component.image;

import android.text.TextUtils;
import com.tencent.viola.ui.dom.Style;
import java.util.HashMap;
import java.util.Map;

public class ImageCacheManager$ImageCacheKey
{
  private Map<String, Object> keyMap = new HashMap();
  
  public ImageCacheManager$ImageCacheKey(String paramString, int paramInt1, int paramInt2, int paramInt3, Style paramStyle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.keyMap.put("url", paramString);
    }
    this.keyMap.put("width", Integer.valueOf(paramInt1));
    this.keyMap.put("height", Integer.valueOf(paramInt2));
    this.keyMap.put("blurRadius", Integer.valueOf(paramInt3));
    if (paramStyle.containsKey("borderRadius")) {
      this.keyMap.put("borderRadius", paramStyle.get("borderRadius"));
    }
    if (paramStyle.containsKey("borderTopLeftRadius")) {
      this.keyMap.put("borderTopLeftRadius", paramStyle.get("borderTopLeftRadius"));
    }
    if (paramStyle.containsKey("borderTopRightRadius")) {
      this.keyMap.put("borderTopRightRadius", paramStyle.get("borderTopRightRadius"));
    }
    if (paramStyle.containsKey("borderBottomLeftRadius")) {
      this.keyMap.put("borderBottomLeftRadius", paramStyle.get("borderBottomLeftRadius"));
    }
    if (paramStyle.containsKey("borderBottomRightRadius")) {
      this.keyMap.put("borderBottomRightRadius", paramStyle.get("borderBottomRightRadius"));
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ImageCacheKey)) {
      return false;
    }
    paramObject = (ImageCacheKey)paramObject;
    return this.keyMap.equals(paramObject.keyMap);
  }
  
  public int hashCode()
  {
    return this.keyMap.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageCacheKey{keyMap=");
    localStringBuilder.append(this.keyMap);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.image.ImageCacheManager.ImageCacheKey
 * JD-Core Version:    0.7.0.1
 */