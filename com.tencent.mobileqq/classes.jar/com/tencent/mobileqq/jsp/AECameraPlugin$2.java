package com.tencent.mobileqq.jsp;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class AECameraPlugin$2
  implements Runnable
{
  AECameraPlugin$2(AECameraPlugin paramAECameraPlugin, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject1 = AECameraPlugin.a(this.this$0, this.a, 0);
      this.this$0.callJs(this.b, new String[] { localJSONObject1.toString() });
      return;
    }
    catch (IOException localIOException)
    {
      JSONObject localJSONObject2 = AECameraPlugin.a(this.this$0, "io exception");
      this.this$0.callJs(this.b, new String[] { localJSONObject2.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject3 = AECameraPlugin.a(this.this$0, "json exception");
      this.this$0.callJs(this.b, new String[] { localJSONObject3.toString() });
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      JSONObject localJSONObject4 = AECameraPlugin.a(this.this$0, "out of memory");
      this.this$0.callJs(this.b, new String[] { localJSONObject4.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AECameraPlugin.2
 * JD-Core Version:    0.7.0.1
 */