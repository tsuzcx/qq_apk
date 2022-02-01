package com.tencent.mobileqq.triton.bridge.d;

import com.tencent.mobileqq.triton.audio.e;
import com.tencent.mobileqq.triton.engine.TTLog;
import org.json.JSONObject;

class a$g
  implements Runnable
{
  a$g(a parama, String paramString) {}
  
  public void run()
  {
    int i;
    try
    {
      localObject = new JSONObject(this.a);
      i = ((JSONObject)localObject).optInt("audioId", -1);
      if (i == -1) {
        return;
      }
      if (((JSONObject)localObject).has("src")) {
        localObject = ((JSONObject)localObject).getString("src");
      }
    }
    finally
    {
      Object localObject;
      TTLog.b("[audio] AudioPlugin", "API_SET_AUDIO_STATE exception:", localThrowable);
      return;
    }
    boolean bool;
    if (localThrowable.has("autoplay"))
    {
      bool = localThrowable.getBoolean("autoplay");
      a.a(this.b).a(i, bool);
      return;
    }
    double d;
    if (localThrowable.has("startTime"))
    {
      d = localThrowable.getDouble("startTime");
      a.a(this.b).b(i, (float)d);
      return;
    }
    if (localThrowable.has("loop"))
    {
      bool = localThrowable.getBoolean("loop");
      a.a(this.b).b(i, bool);
      return;
    }
    if (localThrowable.has("volume"))
    {
      d = localThrowable.getDouble("volume");
      a.a(this.b).c(i, (float)d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.d.a.g
 * JD-Core Version:    0.7.0.1
 */