package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import beka;
import beki;
import bekq;
import beks;
import besl;
import bfdy;
import bfeb;
import bfee;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class PickerJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "PickerJsPlugin";
  private bfee mutiPickerView;
  
  public void handleGetRegionData(beka parambeka)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", bekq.a(this.mContext, "mini/region"));
      parambeka.a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      besl.d("PickerJsPlugin", "getRegionData exception: ", localJSONException);
      parambeka.b();
    }
  }
  
  public void handleShowDatePickerView(beka parambeka)
  {
    JSONObject localJSONObject;
    String str;
    try
    {
      Object localObject2 = new JSONObject(parambeka.b);
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
        localObject1 = bfdy.b((String)localObject1);
        if (localObject1 == null)
        {
          parambeka.b();
          return;
        }
        beki.a(new PickerJsPlugin.3(this, (Date)localObject1, (String)localObject2, parambeka, localJSONObject));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      besl.d("PickerJsPlugin", "showDatePickerView error.", localJSONException);
      parambeka.b();
      return;
    }
    if ("time".equals(str)) {
      beki.a(new PickerJsPlugin.4(this, bfdy.a(localJSONException), parambeka, localJSONObject));
    }
  }
  
  public void handleShowMultiPickerView(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      int[] arrayOfInt = beks.a(localJSONObject.optJSONArray("current"));
      beki.a(new PickerJsPlugin.2(this, beks.a(localJSONObject, "array"), arrayOfInt, parambeka));
      return;
    }
    catch (JSONException localJSONException)
    {
      besl.d("PickerJsPlugin", "showMultiPickerView error.", localJSONException);
      parambeka.b();
    }
  }
  
  public void handleShowPickerView(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      beki.a(new PickerJsPlugin.1(this, localJSONObject.optJSONArray("array"), localJSONObject.optInt("current", 0), parambeka));
      return;
    }
    catch (JSONException localJSONException)
    {
      besl.d("PickerJsPlugin", "showPickerView error.", localJSONException);
      parambeka.b();
    }
  }
  
  public void handleUpdateMultiPickerView(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambeka.b);
      beki.a(new PickerJsPlugin.5(this, localJSONObject.optInt("column"), localJSONObject.optInt("current"), localJSONObject.optJSONArray("array"), parambeka));
      return;
    }
    catch (Exception localException)
    {
      besl.d("PickerJsPlugin", "updateMultiPickerView error.", localException);
      parambeka.b();
    }
  }
  
  protected void updateDataPickerFields(bfeb parambfeb, String paramString)
  {
    if (parambfeb == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(paramString))
      {
        parambfeb.a(0);
        parambfeb.b(0);
        parambfeb.c(0);
        return;
      }
      if (paramString.equals("year"))
      {
        parambfeb.a(0);
        parambfeb.b(8);
        parambfeb.c(8);
        return;
      }
      if (paramString.equals("month"))
      {
        parambfeb.a(0);
        parambfeb.b(0);
        parambfeb.c(8);
        return;
      }
    } while (!paramString.equals("day"));
    parambfeb.a(0);
    parambfeb.b(0);
    parambfeb.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin
 * JD-Core Version:    0.7.0.1
 */