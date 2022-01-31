package com.tencent.qqmini.sdk.runtime.widget.camera;

import android.util.Log;
import bglu;
import bgnt;
import bgok;
import bgpv;
import org.json.JSONObject;

class MiniAppCamera$5
  implements Runnable
{
  MiniAppCamera$5(MiniAppCamera paramMiniAppCamera, String paramString, bgok parambgok) {}
  
  public void run()
  {
    try
    {
      String str = MiniAppCamera.a(this.this$0, this.jdField_a_of_type_JavaLangString);
      if (bgpv.a(str))
      {
        Log.i("MiniAppCamera", "run: null video thumb path");
        this.jdField_a_of_type_Bgok.b();
        return;
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("tempThumbPath", bgnt.a().e(str));
      localJSONObject.put("tempVideoPath", bgnt.a().e(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_Bgok.a.a(this.jdField_a_of_type_Bgok.b, localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      Log.w("MiniAppCamera", "run: failed to stop record", localException);
      this.jdField_a_of_type_Bgok.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.camera.MiniAppCamera.5
 * JD-Core Version:    0.7.0.1
 */