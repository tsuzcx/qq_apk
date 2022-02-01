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
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private ArrayList<Integer> b = new ArrayList();
  
  public static KandianLiveCfgBean a(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      return new KandianLiveCfgBean();
    }
    KandianLiveCfgBean localKandianLiveCfgBean = new KandianLiveCfgBean();
    try
    {
      paramString = new JSONObject(paramString);
      if (Integer.parseInt(paramString.getString("isLite")) != 1) {
        break label208;
      }
      bool = true;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Object localObject;
        ArrayList localArrayList;
        int i;
        QLog.e("KandianLiveCfgBean", 1, "error parse bean " + paramString);
        continue;
        boolean bool = false;
      }
    }
    localKandianLiveCfgBean.jdField_a_of_type_Boolean = bool;
    localObject = paramString.optJSONArray("blackList");
    if (localObject != null)
    {
      localArrayList = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        localArrayList.add((String)((JSONArray)localObject).get(i));
        i += 1;
      }
      localKandianLiveCfgBean.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    }
    paramString = paramString.optJSONArray("black_version_list");
    if (paramString != null)
    {
      localObject = new ArrayList();
      i = j;
      while (i < paramString.length())
      {
        ((ArrayList)localObject).add((Integer)paramString.get(i));
        i += 1;
      }
      localKandianLiveCfgBean.b = ((ArrayList)localObject);
    }
    return localKandianLiveCfgBean;
  }
  
  public boolean a()
  {
    QLog.i("KandianLiveCfgBean", 1, "useLiteSdk------mIsLite = " + this.jdField_a_of_type_Boolean);
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if ((this.b != null) && (this.b.size() > 0))
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if ((localInteger != null) && (localInteger.intValue() == Build.VERSION.SDK_INT))
        {
          QLog.e("KandianLiveCfgBean", 1, "useLiteSdk----version is Invalid, will not user LiteSDK");
          return false;
        }
      }
      QLog.e("KandianLiveCfgBean", 1, "useLiteSdk----KandianLiveCfgBean has not data , currentVersion = " + Build.VERSION.SDK_INT);
    }
    if (!ConfigUtil.a(this.jdField_a_of_type_JavaUtilArrayList)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.config.KandianLiveCfgBean
 * JD-Core Version:    0.7.0.1
 */