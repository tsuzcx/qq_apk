package com.tencent.mobileqq.profile;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class VipWZRYTemplateConfig
{
  public static VipWZRYTemplateConfig a;
  public SparseArray<VipWZRYTemplateConfig.WZRYHonorItem> b;
  
  public static boolean a()
  {
    if (a == null)
    {
      if (!VipWZRYTemplateHelper.a("cardWZ.zip"))
      {
        VipWZRYTemplateHelper.a(null);
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(VipWZRYTemplateHelper.a());
      localStringBuilder.append("xydata.json");
      return a(localStringBuilder.toString());
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("configPath = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("VipWZRYTemplateConfig", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    Object localObject = new File(paramString);
    for (;;)
    {
      int i;
      try
      {
        localObject = FileUtils.readFileToString((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" content is empty.");
          QLog.e("VipWZRYTemplateConfig", 1, ((StringBuilder)localObject).toString());
          return false;
        }
        paramString = new VipWZRYTemplateConfig();
        localObject = new JSONObject((String)localObject).optJSONArray("cardWZResourceGrade");
        if ((localObject != null) && (((JSONArray)localObject).length() > 0))
        {
          paramString.b = new SparseArray();
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
            if (localJSONObject == null) {
              break label359;
            }
            VipWZRYTemplateConfig.WZRYHonorItem localWZRYHonorItem = new VipWZRYTemplateConfig.WZRYHonorItem();
            localWZRYHonorItem.a = localJSONObject.optInt("wz_id");
            localWZRYHonorItem.b = localJSONObject.optString("wz_name");
            localWZRYHonorItem.c = localJSONObject.optString("wz_format");
            localWZRYHonorItem.d = localJSONObject.optInt("position_type", 1);
            if (localJSONObject.has("wz_icon"))
            {
              VipWZRYTemplateConfig.WZRYResourceItem localWZRYResourceItem = new VipWZRYTemplateConfig.WZRYResourceItem();
              localJSONObject = localJSONObject.getJSONObject("wz_icon");
              localWZRYResourceItem.a = localJSONObject.optString("src");
              localWZRYResourceItem.b = localJSONObject.optInt("size");
              localWZRYResourceItem.c = localJSONObject.optString("md5");
              localWZRYResourceItem.d = localJSONObject.optInt("width");
              localWZRYResourceItem.e = localJSONObject.optInt("height");
              localWZRYResourceItem.f = localJSONObject.optString("mainColor");
              localWZRYHonorItem.e = localWZRYResourceItem;
            }
            paramString.b.put(localWZRYHonorItem.a, localWZRYHonorItem);
            break label359;
          }
        }
        a = paramString;
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("VipWZRYTemplateConfig", 1, paramString.getMessage());
        return false;
      }
      label359:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipWZRYTemplateConfig
 * JD-Core Version:    0.7.0.1
 */