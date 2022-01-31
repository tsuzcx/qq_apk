package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bgok;
import bgor;
import bgpg;
import bhiu;
import bhjb;
import bhjv;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class PickerJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "PickerJsPlugin";
  private bhjv mutiPickerView;
  
  public void handleShowDatePickerView(bgok parambgok)
  {
    JSONObject localJSONObject;
    String str;
    try
    {
      Object localObject2 = new JSONObject(parambgok.b);
      localJSONObject = ((JSONObject)localObject2).optJSONObject("range");
      str = ((JSONObject)localObject2).optString("current");
      Object localObject1 = str;
      if (TextUtils.isEmpty(str))
      {
        localObject1 = Calendar.getInstance();
        int i = ((Calendar)localObject1).get(1);
        int j = ((Calendar)localObject1).get(2);
        int k = ((Calendar)localObject1).get(5);
        localObject1 = i + "-" + (j + 1) + "" + k;
      }
      str = ((JSONObject)localObject2).optString("mode");
      localObject2 = ((JSONObject)localObject2).optString("fields");
      if ("date".equals(str))
      {
        localObject1 = bhiu.b((String)localObject1);
        if (localObject1 == null)
        {
          parambgok.b();
          return;
        }
        bgor.a(new PickerJsPlugin.3(this, (Date)localObject1, (String)localObject2, parambgok, localJSONObject));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PickerJsPlugin", "showDatePickerView error.", localJSONException);
      parambgok.b();
      return;
    }
    if ("time".equals(str)) {
      bgor.a(new PickerJsPlugin.4(this, bhiu.a(localJSONException), parambgok, localJSONObject));
    }
  }
  
  public void handleShowMultiPickerView(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      int[] arrayOfInt = bgpg.a(localJSONObject.optJSONArray("current"));
      bgor.a(new PickerJsPlugin.2(this, bgpg.a(localJSONObject, "array"), arrayOfInt, parambgok));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PickerJsPlugin", "showMultiPickerView error.", localJSONException);
      parambgok.b();
    }
  }
  
  public void handleShowPickerView(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      bgor.a(new PickerJsPlugin.1(this, localJSONObject.optJSONArray("array"), localJSONObject.optInt("current", 0), parambgok));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PickerJsPlugin", "showPickerView error.", localJSONException);
      parambgok.b();
    }
  }
  
  public void handleUpdateMultiPickerView(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgok.b);
      bgor.a(new PickerJsPlugin.5(this, localJSONObject.optInt("column"), localJSONObject.optInt("current"), localJSONObject.optJSONArray("array"), parambgok));
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PickerJsPlugin", "updateMultiPickerView error.", localException);
      parambgok.b();
    }
  }
  
  protected void updateDataPickerFields(bhjb parambhjb, String paramString)
  {
    if (parambhjb == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(paramString))
      {
        parambhjb.a(0);
        parambhjb.b(0);
        parambhjb.c(0);
        return;
      }
      if (paramString.equals("year"))
      {
        parambhjb.a(0);
        parambhjb.b(8);
        parambhjb.c(8);
        return;
      }
      if (paramString.equals("month"))
      {
        parambhjb.a(0);
        parambhjb.b(0);
        parambhjb.c(8);
        return;
      }
    } while (!paramString.equals("day"));
    parambhjb.a(0);
    parambhjb.b(0);
    parambhjb.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin
 * JD-Core Version:    0.7.0.1
 */