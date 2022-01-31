package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bdfz;
import bdgi;
import bdgo;
import bdgq;
import bdnw;
import bdxh;
import bdxj;
import bdxm;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class PickerJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "PickerJsPlugin";
  private bdxm mutiPickerView;
  
  public void handleGetRegionData(bdfz parambdfz)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("data", bdgo.a(this.mContext, "mini/region"));
      parambdfz.a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      bdnw.d("PickerJsPlugin", "getRegionData exception: ", localJSONException);
      parambdfz.b();
    }
  }
  
  public void handleShowDatePickerView(bdfz parambdfz)
  {
    JSONObject localJSONObject;
    String str;
    try
    {
      Object localObject2 = new JSONObject(parambdfz.b);
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
        localObject1 = bdxh.b((String)localObject1);
        if (localObject1 == null)
        {
          parambdfz.b();
          return;
        }
        bdgi.a(new PickerJsPlugin.3(this, (Date)localObject1, (String)localObject2, parambdfz, localJSONObject));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      bdnw.d("PickerJsPlugin", "showDatePickerView error.", localJSONException);
      parambdfz.b();
      return;
    }
    if ("time".equals(str)) {
      bdgi.a(new PickerJsPlugin.4(this, bdxh.a(localJSONException), parambdfz, localJSONObject));
    }
  }
  
  public void handleShowMultiPickerView(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.b);
      int[] arrayOfInt = bdgq.a(localJSONObject.optJSONArray("current"));
      bdgi.a(new PickerJsPlugin.2(this, bdgq.a(localJSONObject, "array"), arrayOfInt, parambdfz));
      return;
    }
    catch (JSONException localJSONException)
    {
      bdnw.d("PickerJsPlugin", "showMultiPickerView error.", localJSONException);
      parambdfz.b();
    }
  }
  
  public void handleShowPickerView(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.b);
      bdgi.a(new PickerJsPlugin.1(this, localJSONObject.optJSONArray("array"), localJSONObject.optInt("current", 0), parambdfz));
      return;
    }
    catch (JSONException localJSONException)
    {
      bdnw.d("PickerJsPlugin", "showPickerView error.", localJSONException);
      parambdfz.b();
    }
  }
  
  public void handleUpdateMultiPickerView(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.b);
      bdgi.a(new PickerJsPlugin.5(this, localJSONObject.optInt("column"), localJSONObject.optInt("current"), localJSONObject.optJSONArray("array"), parambdfz));
      return;
    }
    catch (Exception localException)
    {
      bdnw.d("PickerJsPlugin", "updateMultiPickerView error.", localException);
      parambdfz.b();
    }
  }
  
  protected void updateDataPickerFields(bdxj parambdxj, String paramString)
  {
    if (parambdxj == null) {}
    do
    {
      return;
      if (TextUtils.isEmpty(paramString))
      {
        parambdxj.a(0);
        parambdxj.b(0);
        parambdxj.c(0);
        return;
      }
      if (paramString.equals("year"))
      {
        parambdxj.a(0);
        parambdxj.b(8);
        parambdxj.c(8);
        return;
      }
      if (paramString.equals("month"))
      {
        parambdxj.a(0);
        parambdxj.b(0);
        parambdxj.c(8);
        return;
      }
    } while (!paramString.equals("day"));
    parambdxj.a(0);
    parambdxj.b(0);
    parambdxj.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin
 * JD-Core Version:    0.7.0.1
 */