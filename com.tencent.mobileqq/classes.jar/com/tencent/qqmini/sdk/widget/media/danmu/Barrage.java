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
    if (paramJSONObject == null) {
      return null;
    }
    String str = paramJSONObject.optString("text");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    long l = paramJSONObject.optLong("time", -1L);
    if (l < 0L) {
      return null;
    }
    paramJSONObject = paramJSONObject.optString("color");
    int i;
    if (TextUtils.isEmpty(paramJSONObject)) {
      i = -1;
    } else {
      i = ColorUtils.parseColor(paramJSONObject);
    }
    return new Barrage(str, i, l);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (Barrage)paramObject;
      if ((this.color != paramObject.color) || (this.time != paramObject.time) || (this.text != null) || (paramObject.text != null))
      {
        String str = this.text;
        if ((str != null) && (str.equals(paramObject.text))) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.text, Integer.valueOf(this.color), Long.valueOf(this.time) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.danmu.Barrage
 * JD-Core Version:    0.7.0.1
 */