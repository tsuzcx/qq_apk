package com.tencent.qqmini.sdk.widget.media.danmu;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.util.Arrays;
import org.json.JSONObject;

public class Barrage
{
  public final int color;
  public final String text;
  public final long time;
  
  public Barrage(String paramString, int paramInt, long paramLong)
  {
    this.text = paramString;
    this.color = paramInt;
    this.time = paramLong;
  }
  
  public static Barrage parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    String str;
    long l;
    do
    {
      do
      {
        return null;
        str = paramJSONObject.optString("text");
      } while (TextUtils.isEmpty(str));
      l = paramJSONObject.optLong("time", -1L);
    } while (l < 0L);
    paramJSONObject = paramJSONObject.optString("color");
    if (TextUtils.isEmpty(paramJSONObject)) {}
    for (int i = -1;; i = ColorUtils.parseColor(paramJSONObject)) {
      return new Barrage(str, i, l);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (getClass() != paramObject.getClass());
        paramObject = (Barrage)paramObject;
        if ((this.color == paramObject.color) && (this.time == paramObject.time) && (this.text == null) && (paramObject.text == null)) {
          break;
        }
        bool1 = bool2;
      } while (this.text == null);
      bool1 = bool2;
    } while (!this.text.equals(paramObject.text));
    return true;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.text, Integer.valueOf(this.color), Long.valueOf(this.time) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.danmu.Barrage
 * JD-Core Version:    0.7.0.1
 */