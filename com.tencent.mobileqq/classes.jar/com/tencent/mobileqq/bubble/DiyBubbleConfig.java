package com.tencent.mobileqq.bubble;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class DiyBubbleConfig
{
  static int d = -1;
  public String a;
  public int[] b;
  public int c;
  public String e = "diy_chartlet";
  
  public static HashMap<String, DiyBubbleConfig> a(int paramInt, JSONObject paramJSONObject)
  {
    Object localObject = new ArrayList();
    a(paramJSONObject, (List)localObject);
    if (paramJSONObject.has("diy_animation")) {
      ((List)localObject).add(paramJSONObject.optJSONObject("diy_animation").optString("diy"));
    }
    if (paramJSONObject.has("animation_sets"))
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("animation_sets");
      HashMap localHashMap = new HashMap(4);
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramJSONObject = localHashMap;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramJSONObject = localJSONObject.optJSONObject((String)((Iterator)localObject).next());
        if (paramJSONObject != null)
        {
          if (paramJSONObject.has("text_size")) {
            paramJSONObject = DiyBubbleConfig.DiyBubbleTextConfig.a(paramJSONObject);
          } else {
            paramJSONObject = DiyBubbleConfig.DiyBubblePasterConfig.a(paramJSONObject);
          }
          if (paramJSONObject != null)
          {
            paramJSONObject.c = paramInt;
            localHashMap.put(paramJSONObject.a, paramJSONObject);
          }
        }
      }
    }
    paramJSONObject = null;
    if ((paramJSONObject != null) && (paramJSONObject.size() > 0)) {
      BubbleDiyFetcher.a().k.put(Integer.valueOf(paramInt), paramJSONObject);
    }
    return paramJSONObject;
  }
  
  private static void a(JSONObject paramJSONObject, List<String> paramList)
  {
    if (paramJSONObject.has("chartlet_animation"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("chartlet_animation");
      if (paramJSONObject.has("animation_set"))
      {
        paramJSONObject = paramJSONObject.optJSONArray("animation_set");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          paramList.add(paramJSONObject.optString(i));
          i += 1;
        }
      }
    }
  }
  
  private static float b(Paint paramPaint, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramPaint != null)) {
      return paramPaint.measureText(paramString);
    }
    return 0.0F;
  }
  
  @NotNull
  private static Rect b(VipBubbleDrawable paramVipBubbleDrawable, Rect paramRect, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, float paramFloat4)
  {
    if (paramVipBubbleDrawable.b)
    {
      paramFloat2 = paramRect.width() - paramFloat2 - paramFloat4;
      return new Rect((int)paramFloat2, (int)paramFloat3, (int)(paramFloat2 + paramInt), (int)(paramFloat3 + paramFloat1));
    }
    return new Rect((int)paramFloat2, (int)paramFloat3, (int)(paramFloat2 + paramInt), (int)(paramFloat3 + paramFloat1));
  }
  
  public void a(VipBubbleDrawable paramVipBubbleDrawable, Canvas paramCanvas) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.DiyBubbleConfig
 * JD-Core Version:    0.7.0.1
 */