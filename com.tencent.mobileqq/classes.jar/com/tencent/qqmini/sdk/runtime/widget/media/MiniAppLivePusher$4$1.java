package com.tencent.qqmini.sdk.runtime.widget.media;

import android.graphics.Bitmap;
import bglu;
import bgnt;
import bgok;
import bgop;
import bhku;
import java.io.File;
import org.json.JSONObject;

public class MiniAppLivePusher$4$1
  implements Runnable
{
  public MiniAppLivePusher$4$1(bhku parambhku, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      Object localObject = new File(bgnt.a().b("jpg"));
      ((File)localObject).getParentFile().mkdirs();
      MiniAppLivePusher.a(this.jdField_a_of_type_AndroidGraphicsBitmap, (File)localObject);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("tempImagePath", ((File)localObject).getAbsolutePath());
      localJSONObject2.put("width", this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
      localJSONObject2.put("height", this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      localObject = bgop.a(this.jdField_a_of_type_Bhku.jdField_a_of_type_JavaLangString, localJSONObject2);
      this.jdField_a_of_type_Bhku.jdField_a_of_type_Bgok.a.a(this.jdField_a_of_type_Bhku.jdField_a_of_type_Bgok.b, ((JSONObject)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      JSONObject localJSONObject1 = bgop.b(this.jdField_a_of_type_Bhku.jdField_a_of_type_JavaLangString, new JSONObject());
      this.jdField_a_of_type_Bhku.jdField_a_of_type_Bgok.a.a(this.jdField_a_of_type_Bhku.jdField_a_of_type_Bgok.b, localJSONObject1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.media.MiniAppLivePusher.4.1
 * JD-Core Version:    0.7.0.1
 */