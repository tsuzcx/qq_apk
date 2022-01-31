package com.tencent.qqmini.sdk.runtime.widget.media;

import android.graphics.Bitmap;
import bglu;
import bgnt;
import bgok;
import bgop;
import bhkr;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;
import org.json.JSONObject;

public class MiniAppLivePlayer$6$1
  implements Runnable
{
  public MiniAppLivePlayer$6$1(bhkr parambhkr, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(bgnt.a().b("jpg"));
      ((File)localObject).getParentFile().mkdirs();
      MiniAppLivePlayer.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (File)localObject);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempImagePath", ((File)localObject).getAbsolutePath());
      localJSONObject2.put("width", this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
      localJSONObject2.put("height", this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      localObject = bgop.a(this.jdField_a_of_type_Bhkr.jdField_a_of_type_JavaLangString, localJSONObject2);
      this.jdField_a_of_type_Bhkr.jdField_a_of_type_Bgok.a.a(this.jdField_a_of_type_Bhkr.jdField_a_of_type_Bgok.b, ((JSONObject)localObject).toString());
      QMLog.e("MiniAppLivePlayer", "takePhoto - evaluateCallbackJs：" + ((JSONObject)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject1 = bgop.b(this.jdField_a_of_type_Bhkr.jdField_a_of_type_JavaLangString, new JSONObject());
      this.jdField_a_of_type_Bhkr.jdField_a_of_type_Bgok.a.a(this.jdField_a_of_type_Bhkr.jdField_a_of_type_Bgok.b, localJSONObject1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.media.MiniAppLivePlayer.6.1
 * JD-Core Version:    0.7.0.1
 */