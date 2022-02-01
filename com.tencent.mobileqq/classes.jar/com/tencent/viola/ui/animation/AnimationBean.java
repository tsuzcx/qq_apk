package com.tencent.viola.ui.animation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.viola.utils.ViolaUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AnimationBean
{
  public static final int NUM_CUBIC_PARAM = 4;
  public long delay;
  public long duration;
  public boolean needLayout;
  @Nullable
  public AnimationBean.Style styles;
  public String timingFunction;
  public boolean topIndex;
  
  public AnimationBean(@NonNull JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.delay = paramJSONObject.optLong("delay", 0L);
      this.duration = paramJSONObject.optLong("duration", 16L);
      this.timingFunction = paramJSONObject.optString("timingFunction", "ease");
      this.needLayout = paramJSONObject.optBoolean("needLayout", false);
      this.topIndex = ViolaUtils.getBoolean(paramJSONObject.optString("topIndex"));
    }
    try
    {
      this.styles = new AnimationBean.Style(new JSONObject(paramJSONObject.getString("styles")));
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.animation.AnimationBean
 * JD-Core Version:    0.7.0.1
 */