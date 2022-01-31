package com.tencent.qqmini.sdk.runtime.widget.camera;

import android.util.Log;
import bghn;
import bgjm;
import bgkd;
import bglo;
import org.json.JSONObject;

class MiniAppCamera$5
  implements Runnable
{
  MiniAppCamera$5(MiniAppCamera paramMiniAppCamera, String paramString, bgkd parambgkd) {}
  
  public void run()
  {
    try
    {
      String str = MiniAppCamera.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      if (bglo.a(str))
      {
        Log.i("MiniAppCamera", "run: null video thumb path");
        this.jdField_a_of_type_Bgkd.b();
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tempThumbPath", bgjm.a().e(str));
      localJSONObject.put("tempVideoPath", bgjm.a().e(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Bgkd.a.a(this.jdField_a_of_type_Bgkd.b, localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      Log.w("MiniAppCamera", "run: failed to stop record", localException);
      this.jdField_a_of_type_Bgkd.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.camera.MiniAppCamera.5
 * JD-Core Version:    0.7.0.1
 */