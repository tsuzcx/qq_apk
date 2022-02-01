package com.tencent.mobileqq.webview.api.impl;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.api.ISonicPreloaderService;
import com.tencent.mobileqq.webview.data.SonicParserInfo;
import com.tencent.mobileqq.webview.data.SonicPreloadData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicSessionConfig.Builder;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SonicPreloaderServiceImpl
  implements ISonicPreloaderService
{
  public static final String TAG = "SonicPreload";
  
  public boolean enablePreloadSonic()
  {
    int i = NetworkUtil.a(null);
    if (QLog.isColorLevel()) {
      QLog.d("SonicPreload", 2, "isWifiOrG3OrG4 netType = " + i);
    }
    return (i == 1) || (i == 3) || (i == 4);
  }
  
  public SparseArray<SonicPreloadData> getSonicPreloadDataList(SonicParserInfo paramSonicParserInfo)
  {
    if (paramSonicParserInfo == null) {
      return null;
    }
    Object localObject1 = paramSonicParserInfo.jdField_a_of_type_JavaLangString;
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || ("null".equals(localObject1))) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SonicPreload", 2, "getSonicPreloadDataList : preloadBusinessId = " + paramSonicParserInfo.jdField_a_of_type_Int);
    }
    long l1 = paramSonicParserInfo.jdField_a_of_type_Long;
    for (;;)
    {
      SparseArray localSparseArray;
      int i;
      int j;
      JSONObject localJSONObject;
      int m;
      long l2;
      try
      {
        localObject1 = new JSONObject((String)localObject1).optJSONObject("msg");
        if (localObject1 == null) {
          return null;
        }
        JSONArray localJSONArray = ((JSONObject)localObject1).names();
        if (localJSONArray == null) {
          return null;
        }
        int k = localJSONArray.length();
        localSparseArray = new SparseArray();
        i = 0;
        if (i >= k) {
          break label390;
        }
        Object localObject2 = ((JSONObject)localObject1).getJSONObject(localJSONArray.getString(i)).getString("extinfo");
        if (QLog.isColorLevel()) {
          QLog.d("SonicPreload", 2, "getSonicPreloadDataList : extInfo = " + (String)localObject2);
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label393;
        }
        localObject2 = new JSONObject((String)localObject2).optJSONArray("preload");
        if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
          break label393;
        }
        j = 0;
        if (j >= ((JSONArray)localObject2).length()) {
          break label393;
        }
        localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
        m = localJSONObject.optInt("id");
        l2 = localJSONObject.optLong("templateChangeTime", -1L);
        if ((l2 < l1) || ((paramSonicParserInfo.jdField_a_of_type_Int != 0) && (m != paramSonicParserInfo.jdField_a_of_type_Int))) {
          break label400;
        }
        if (localSparseArray.indexOfKey(m) > 0)
        {
          SonicPreloadData localSonicPreloadData = (SonicPreloadData)localSparseArray.get(m);
          if (localSonicPreloadData.jdField_a_of_type_Long >= l2) {
            break label400;
          }
          localSonicPreloadData.jdField_a_of_type_Long = l2;
          localSonicPreloadData.b = localJSONObject.optInt("preloadType", 0);
        }
      }
      catch (Exception paramSonicParserInfo)
      {
        QLog.e("SonicPreload", 1, "preloadSonicSession exception", paramSonicParserInfo);
        return null;
      }
      localSparseArray.put(m, new SonicPreloadData(m, "", true, l2, localJSONObject.optInt("preloadType", 0)));
      break label400;
      label390:
      return localSparseArray;
      label393:
      i += 1;
      continue;
      label400:
      j += 1;
    }
  }
  
  public boolean preload(List<SonicPreloadData> paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return false;
    }
    if (!enablePreloadSonic())
    {
      QLog.e("SonicPreload", 1, "preload net type not wifi or 3g or 4g ");
      return false;
    }
    Iterator localIterator = paramList.iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      SonicPreloadData localSonicPreloadData = (SonicPreloadData)localIterator.next();
      boolean bool2 = bool1;
      if (localSonicPreloadData != null)
      {
        paramList = localSonicPreloadData.jdField_a_of_type_JavaLangString;
        if (TextUtils.isEmpty(paramList)) {
          continue;
        }
        if (!paramList.contains("?")) {
          break label211;
        }
      }
      label211:
      for (paramList = paramList + "&_sonic_rp=1";; paramList = paramList + "?_sonic_rp=1")
      {
        SonicSessionConfig.Builder localBuilder = new SonicSessionConfig.Builder();
        localBuilder.setSessionMode(1);
        SonicEngine localSonicEngine = WebAccelerateHelper.getSonicEngine();
        if (localSonicEngine != null) {
          bool1 = localSonicEngine.preCreateSession(paramList, localBuilder.build(), localSonicPreloadData.jdField_a_of_type_Long, localSonicPreloadData.b);
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("SonicPreload", 2, "preload: url = " + paramList + ",result = " + bool1);
          bool2 = bool1;
        }
        bool1 = bool2;
        break;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.SonicPreloaderServiceImpl
 * JD-Core Version:    0.7.0.1
 */