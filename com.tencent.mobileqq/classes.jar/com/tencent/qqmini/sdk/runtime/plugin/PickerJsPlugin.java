package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bgkd;
import bgkk;
import bgkz;
import bhen;
import bheu;
import bhfo;
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
  private bhfo mutiPickerView;
  
  public void handleShowDatePickerView(bgkd parambgkd)
  {
    JSONObject localJSONObject;
    String str;
    try
    {
      Object localObject2 = new JSONObject(parambgkd.b);
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
        localObject1 = bhen.b((String)localObject1);
        if (localObject1 == null)
        {
          parambgkd.b();
          return;
        }
        bgkk.a(new PickerJsPlugin.3(this, (Date)localObject1, (String)localObject2, parambgkd, localJSONObject));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PickerJsPlugin", "showDatePickerView error.", localJSONException);
      parambgkd.b();
      return;
    }
    if ("time".equals(str)) {
      bgkk.a(new PickerJsPlugin.4(this, bhen.a(localJSONException), parambgkd, localJSONObject));
    }
  }
  
  public void handleShowMultiPickerView(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      int[] arrayOfInt = bgkz.a(localJSONObject.optJSONArray("current"));
      bgkk.a(new PickerJsPlugin.2(this, bgkz.a(localJSONObject, "array"), arrayOfInt, parambgkd));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PickerJsPlugin", "showMultiPickerView error.", localJSONException);
      parambgkd.b();
    }
  }
  
  public void handleShowPickerView(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      bgkk.a(new PickerJsPlugin.1(this, localJSONObject.optJSONArray("array"), localJSONObject.optInt("current", 0), parambgkd));
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("PickerJsPlugin", "showPickerView error.", localJSONException);
      parambgkd.b();
    }
  }
  
  public void handleUpdateMultiPickerView(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambgkd.b);
      bgkk.a(new PickerJsPlugin.5(this, localJSONObject.optInt("column"), localJSONObject.optInt("current"), localJSONObject.optJSONArray("array"), parambgkd));
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PickerJsPlugin", "updateMultiPickerView error.", localException);
      parambgkd.b();
    }
  }
  
  protected void updateDataPickerFields(bheu parambheu, String paramString)
  {
    if (parambheu == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(paramString))
      {
        parambheu.a(0);
        parambheu.b(0);
        parambheu.c(0);
        return;
      }
      if (paramString.equals("year"))
      {
        parambheu.a(0);
        parambheu.b(8);
        parambheu.c(8);
        return;
      }
      if (paramString.equals("month"))
      {
        parambheu.a(0);
        parambheu.b(0);
        parambheu.c(8);
        return;
      }
    } while (!paramString.equals("day"));
    parambheu.a(0);
    parambheu.b(0);
    parambheu.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin
 * JD-Core Version:    0.7.0.1
 */