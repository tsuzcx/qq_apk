package com.tencent.timi.game.image.impl;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.timi.game.image.api.IDrawableService;
import com.tencent.timi.game.utils.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DrawableServiceImpl
  implements IDrawableService
{
  private Map<String, URLDrawable.URLDrawableOptions> a = new HashMap();
  
  public URLDrawable a(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    this.a.put(paramString, paramURLDrawableOptions);
    return URLDrawable.getDrawable(paramString, paramURLDrawableOptions);
  }
  
  public void a(Context paramContext) {}
  
  public void g()
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getKey() != null) && (localEntry.getValue() != null))
      {
        URLDrawable.removeMemoryCacheByUrl((String)localEntry.getKey(), (URLDrawable.URLDrawableOptions)localEntry.getValue());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("移除一条图片缓存：");
        localStringBuilder.append((String)localEntry.getKey());
        Logger.a("DrawableServiceImpl", localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.image.impl.DrawableServiceImpl
 * JD-Core Version:    0.7.0.1
 */