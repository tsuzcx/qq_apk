package com.tencent.mobileqq.intervideo.huiyin;

import android.util.Log;
import aqmw;
import aqna;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class HuiyinJsPlugin$4$1
  implements Runnable
{
  public HuiyinJsPlugin$4$1(aqna paramaqna, int paramInt, String paramString) {}
  
  public void run()
  {
    Log.i("Huiyin", "upload code " + this.jdField_a_of_type_Int + ", msg " + this.jdField_a_of_type_JavaLangString);
    try
    {
      if (this.jdField_a_of_type_Int == 0) {
        aqmw.a(this.jdField_a_of_type_Aqna.jdField_a_of_type_Aqmw, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aqna.jdField_a_of_type_Long, this.jdField_a_of_type_Aqna.jdField_a_of_type_JavaLangString, null, new JSONObject(this.jdField_a_of_type_JavaLangString));
      }
      for (;;)
      {
        new File(aqmw.a(this.jdField_a_of_type_Aqna.jdField_a_of_type_Aqmw)).delete();
        aqmw.a(this.jdField_a_of_type_Aqna.jdField_a_of_type_Aqmw, null);
        return;
        aqmw.a(this.jdField_a_of_type_Aqna.jdField_a_of_type_Aqmw, this.jdField_a_of_type_Int, this.jdField_a_of_type_Aqna.jdField_a_of_type_Long, this.jdField_a_of_type_Aqna.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, null);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("Huiyin", localJSONException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.HuiyinJsPlugin.4.1
 * JD-Core Version:    0.7.0.1
 */