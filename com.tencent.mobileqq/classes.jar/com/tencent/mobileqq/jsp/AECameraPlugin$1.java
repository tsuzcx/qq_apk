package com.tencent.mobileqq.jsp;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class AECameraPlugin$1
  implements Runnable
{
  AECameraPlugin$1(AECameraPlugin paramAECameraPlugin, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject1 = AECameraPlugin.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b);
      this.this$0.callJs(AECameraPlugin.a(this.this$0), new String[] { localJSONObject1.toString() });
      return;
    }
    catch (IOException localIOException)
    {
      JSONObject localJSONObject2 = AECameraPlugin.a(this.this$0, "io exception");
      this.this$0.callJs(AECameraPlugin.a(this.this$0), new String[] { localJSONObject2.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject3 = AECameraPlugin.a(this.this$0, "json exception");
      this.this$0.callJs(AECameraPlugin.a(this.this$0), new String[] { localJSONObject3.toString() });
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      JSONObject localJSONObject4 = AECameraPlugin.a(this.this$0, "out of memory");
      this.this$0.callJs(AECameraPlugin.a(this.this$0), new String[] { localJSONObject4.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AECameraPlugin.1
 * JD-Core Version:    0.7.0.1
 */