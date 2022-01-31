package com.tencent.qqmini.sdk.runtime.plugin;

import android.graphics.Paint;
import android.graphics.Typeface;
import bglu;
import bglv;
import bgmk;
import bgok;
import bgop;
import bgpg;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class CanvasJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_DRAW_CANVAS = "drawCanvas";
  public static final String EVENT_GET_INAGE_DATA = "canvasGetImageData";
  public static final String EVENT_INSERT_CANVAS = "insertCanvas";
  public static final String EVENT_MEASURE_TEXT = "measureText";
  public static final String EVENT_PUT_IMAGE_DATA = "canvasPutImageData";
  public static final String EVENT_REMOVE_CANVAS = "removeCanvas";
  public static final String EVENT_TO_TEMP_FILE_PATH = "canvasToTempFilePath";
  public static final String EVENT_UPDATE_CANVAS = "updateCanvas";
  
  public void doInterceptJsEvent(bgok parambgok)
  {
    this.mMiniAppContext.a(bgmk.a(parambgok, 2));
  }
  
  public String measureText(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      Paint localPaint = new Paint(1);
      String str = localJSONObject.optString("fontFamily");
      if ("normal".equals(localJSONObject.optString("fontStyle"))) {
        localPaint.setTypeface(Typeface.create(str, 0));
      }
      str = localJSONObject.optString("text");
      localPaint.setTextSize(localJSONObject.optInt("fontSize"));
      float f = localPaint.measureText(str);
      localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("width", f);
        localJSONObject = bgop.a(parambgok.jdField_a_of_type_JavaLangString, localJSONObject);
        if ((parambgok.jdField_a_of_type_Bglu != null) && (localJSONObject != null)) {
          parambgok.jdField_a_of_type_Bglu.a(parambgok.jdField_b_of_type_Int, bgpg.a(localJSONObject, "errMsg", parambgok.jdField_a_of_type_JavaLangString + ":complete").toString());
        }
        return localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      return "";
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.CanvasJsPlugin
 * JD-Core Version:    0.7.0.1
 */