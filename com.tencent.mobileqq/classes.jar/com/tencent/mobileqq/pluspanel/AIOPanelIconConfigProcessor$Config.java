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
            localAIOPanelIconItem.a = localJSONObject.optInt("appid");
            localAIOPanelIconItem.h = localJSONObject.optString("title");
            localAIOPanelIconItem.i = localJSONObject.optString("iconNormal");
            localAIOPanelIconItem.j = localJSONObject.optString("iconPress");
            localAIOPanelIconItem.k = localJSONObject.optString("iconNightNormal");
            localAIOPanelIconItem.l = localJSONObject.optString("iconNightPress");
            localAIOPanelIconItem.b = localJSONObject.optInt("redDotID");
            localAIOPanelIconItem.e = localJSONObject.optString("redDotPath");
            localAIOPanelIconItem.c = localJSONObject.optString("actionType");
            localAIOPanelIconItem.d = localJSONObject.optString("action");
            localAIOPanelIconItem.f = localJSONObject.optInt("order");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.AIOPanelIconConfigProcessor.Config
 * JD-Core Version:    0.7.0.1
 */