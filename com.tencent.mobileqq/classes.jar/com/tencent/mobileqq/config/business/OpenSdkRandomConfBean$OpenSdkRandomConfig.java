package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSdkRandomConfBean$OpenSdkRandomConfig
  implements IQStorageSafable<String>
{
  public ArrayList<OpenSdkRandomConfBean.RandomInfo> a = new ArrayList();
  
  public void a(String paramString)
  {
    this.a.clear();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("OpenSdkRandomConfig", 1, "OpenVirtual.config content is empty");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("random_list");
        if (paramString != null)
        {
          i = 0;
          if (i < paramString.length())
          {
            JSONObject localJSONObject = paramString.getJSONObject(i);
            OpenSdkRandomConfBean.RandomInfo localRandomInfo = new OpenSdkRandomConfBean.RandomInfo();
            localRandomInfo.a = localJSONObject.optString("nick", "");
            localRandomInfo.b = localJSONObject.optString("headid", "");
            localRandomInfo.c = localJSONObject.optString("url", "");
            if ((!TextUtils.isEmpty(localRandomInfo.a)) && (!TextUtils.isEmpty(localRandomInfo.b))) {
              if (!TextUtils.isEmpty(localRandomInfo.c)) {
                break label233;
              }
            }
            if (!QLog.isColorLevel()) {
              break label238;
            }
            QLog.e("OpenSdkRandomConfig", 2, new Object[] { "OpenVirtual.random.config.parse.find invalid,index=", Integer.valueOf(i) });
            break label238;
            if (j == 0) {
              break label243;
            }
            this.a.add(localRandomInfo);
            break label243;
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.e("OpenSdkRandomConfig", 2, new Object[] { "OpenVirtual.random.config.parse=", toString() });
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("OpenSdkRandomConfig", 1, "OpenVirtual.config.getException.", paramString);
      }
      return;
      label233:
      int j = 1;
      continue;
      label238:
      j = 0;
      continue;
      label243:
      i += 1;
    }
  }
  
  public String toString()
  {
    if (this.a.size() > 0) {
      return this.a.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkRandomConfBean.OpenSdkRandomConfig
 * JD-Core Version:    0.7.0.1
 */