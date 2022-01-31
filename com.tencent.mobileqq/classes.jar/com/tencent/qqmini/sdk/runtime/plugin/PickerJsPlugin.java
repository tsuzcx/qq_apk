package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bekr;
import bekz;
import belh;
import belj;
import betc;
import bfep;
import bfes;
import bfev;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class PickerJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "PickerJsPlugin";
  private bfev mutiPickerView;
  
  public void handleGetRegionData(bekr parambekr)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", belh.a(this.mContext, "mini/region"));
      parambekr.a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      betc.d("PickerJsPlugin", "getRegionData exception: ", localJSONException);
      parambekr.b();
    }
  }
  
  public void handleShowDatePickerView(bekr parambekr)
  {
    JSONObject localJSONObject;
    String str;
    try
    {
      Object localObject2 = new JSONObject(parambekr.b);
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
        localObject1 = bfep.b((String)localObject1);
        if (localObject1 == null)
        {
          parambekr.b();
          return;
        }
        bekz.a(new PickerJsPlugin.3(this, (Date)localObject1, (String)localObject2, parambekr, localJSONObject));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      betc.d("PickerJsPlugin", "showDatePickerView error.", localJSONException);
      parambekr.b();
      return;
    }
    if ("time".equals(str)) {
      bekz.a(new PickerJsPlugin.4(this, bfep.a(localJSONException), parambekr, localJSONObject));
    }
  }
  
  public void handleShowMultiPickerView(bekr parambekr)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      int[] arrayOfInt = belj.a(localJSONObject.optJSONArray("current"));
      bekz.a(new PickerJsPlugin.2(this, belj.a(localJSONObject, "array"), arrayOfInt, parambekr));
      return;
    }
    catch (JSONException localJSONException)
    {
      betc.d("PickerJsPlugin", "showMultiPickerView error.", localJSONException);
      parambekr.b();
    }
  }
  
  public void handleShowPickerView(bekr parambekr)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      bekz.a(new PickerJsPlugin.1(this, localJSONObject.optJSONArray("array"), localJSONObject.optInt("current", 0), parambekr));
      return;
    }
    catch (JSONException localJSONException)
    {
      betc.d("PickerJsPlugin", "showPickerView error.", localJSONException);
      parambekr.b();
    }
  }
  
  public void handleUpdateMultiPickerView(bekr parambekr)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambekr.b);
      bekz.a(new PickerJsPlugin.5(this, localJSONObject.optInt("column"), localJSONObject.optInt("current"), localJSONObject.optJSONArray("array"), parambekr));
      return;
    }
    catch (Exception localException)
    {
      betc.d("PickerJsPlugin", "updateMultiPickerView error.", localException);
      parambekr.b();
    }
  }
  
  protected void updateDataPickerFields(bfes parambfes, String paramString)
  {
    if (parambfes == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(paramString))
      {
        parambfes.a(0);
        parambfes.b(0);
        parambfes.c(0);
        return;
      }
      if (paramString.equals("year"))
      {
        parambfes.a(0);
        parambfes.b(8);
        parambfes.c(8);
        return;
      }
      if (paramString.equals("month"))
      {
        parambfes.a(0);
        parambfes.b(0);
        parambfes.c(8);
        return;
      }
    } while (!paramString.equals("day"));
    parambfes.a(0);
    parambfes.b(0);
    parambfes.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin
 * JD-Core Version:    0.7.0.1
 */