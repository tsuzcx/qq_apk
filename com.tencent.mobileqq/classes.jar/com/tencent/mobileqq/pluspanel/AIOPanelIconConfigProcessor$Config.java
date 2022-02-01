package com.tencent.mobileqq.pluspanel;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AIOPanelIconConfigProcessor$Config
{
  public final List<AIOPanelIconItem> a = new ArrayList();
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("c2c");
        if (paramString.length() > 0)
        {
          int j = paramString.length();
          int i = 0;
          while (i < j)
          {
            AIOPanelIconItem localAIOPanelIconItem = new AIOPanelIconItem();
            JSONObject localJSONObject = paramString.getJSONObject(i);
            localAIOPanelIconItem.jdField_a_of_type_Int = localJSONObject.optInt("appid");
            localAIOPanelIconItem.d = localJSONObject.optString("title");
            localAIOPanelIconItem.e = localJSONObject.optString("iconNormal");
            localAIOPanelIconItem.f = localJSONObject.optString("iconPress");
            localAIOPanelIconItem.g = localJSONObject.optString("iconNightNormal");
            localAIOPanelIconItem.h = localJSONObject.optString("iconNightPress");
            localAIOPanelIconItem.jdField_b_of_type_Int = localJSONObject.optInt("redDotID");
            localAIOPanelIconItem.jdField_c_of_type_JavaLangString = localJSONObject.optString("redDotPath");
            localAIOPanelIconItem.jdField_a_of_type_JavaLangString = localJSONObject.optString("actionType");
            localAIOPanelIconItem.jdField_b_of_type_JavaLangString = localJSONObject.optString("action");
            localAIOPanelIconItem.jdField_c_of_type_Int = localJSONObject.optInt("order");
            localAIOPanelIconItem.a();
            localAIOPanelIconItem.b();
            this.a.add(localAIOPanelIconItem);
            i += 1;
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("AIOPanelIconConfigProcessor", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor.Config
 * JD-Core Version:    0.7.0.1
 */