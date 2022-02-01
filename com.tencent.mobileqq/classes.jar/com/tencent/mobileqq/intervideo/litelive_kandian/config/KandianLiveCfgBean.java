package com.tencent.mobileqq.intervideo.litelive_kandian.config;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.litelivesdk.utils.ConfigUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class KandianLiveCfgBean
{
  private boolean a = true;
  private ArrayList<String> b = new ArrayList();
  private ArrayList<Integer> c = new ArrayList();
  
  public static KandianLiveCfgBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new KandianLiveCfgBean();
    }
    KandianLiveCfgBean localKandianLiveCfgBean = new KandianLiveCfgBean();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        int i = Integer.parseInt(paramString.getString("isLite"));
        int j = 0;
        if (i != 1) {
          break label223;
        }
        bool = true;
        localKandianLiveCfgBean.a = bool;
        localObject = paramString.optJSONArray("blackList");
        if (localObject != null)
        {
          ArrayList localArrayList = new ArrayList();
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            localArrayList.add((String)((JSONArray)localObject).get(i));
            i += 1;
            continue;
          }
          localKandianLiveCfgBean.b = localArrayList;
        }
        paramString = paramString.optJSONArray("black_version_list");
        if (paramString != null)
        {
          localObject = new ArrayList();
          i = j;
          if (i < paramString.length())
          {
            ((ArrayList)localObject).add((Integer)paramString.get(i));
            i += 1;
            continue;
          }
          localKandianLiveCfgBean.c = ((ArrayList)localObject);
          return localKandianLiveCfgBean;
        }
      }
      catch (Throwable paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("error parse bean ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("KandianLiveCfgBean", 1, ((StringBuilder)localObject).toString());
      }
      return localKandianLiveCfgBean;
      label223:
      boolean bool = false;
    }
  }
  
  public boolean a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("useLiteSdk------mIsLite = ");
    ((StringBuilder)localObject).append(this.a);
    QLog.i("KandianLiveCfgBean", 1, ((StringBuilder)localObject).toString());
    if (!this.a) {
      return false;
    }
    localObject = this.c;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if ((localInteger != null) && (localInteger.intValue() == Build.VERSION.SDK_INT))
        {
          QLog.e("KandianLiveCfgBean", 1, "useLiteSdk----version is Invalid, will not user LiteSDK");
          return false;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("useLiteSdk----KandianLiveCfgBean has not data , currentVersion = ");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      QLog.e("KandianLiveCfgBean", 1, ((StringBuilder)localObject).toString());
    }
    return ConfigUtil.a(this.b) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.config.KandianLiveCfgBean
 * JD-Core Version:    0.7.0.1
 */