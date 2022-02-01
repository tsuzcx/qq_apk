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
    int i = NetworkUtil.getSystemNetwork(null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isWifiOrG3OrG4 netType = ");
      localStringBuilder.append(i);
      QLog.d("SonicPreload", 2, localStringBuilder.toString());
    }
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 1)
    {
      bool1 = bool2;
      if (i != 3)
      {
        if (i == 4) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public SparseArray<SonicPreloadData> getSonicPreloadDataList(SonicParserInfo paramSonicParserInfo)
  {
    if (paramSonicParserInfo == null) {
      return null;
    }
    Object localObject1 = paramSonicParserInfo.a;
    Object localObject2;
    long l1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if ("null".equals(localObject1)) {
        return null;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getSonicPreloadDataList : preloadBusinessId = ");
        ((StringBuilder)localObject2).append(paramSonicParserInfo.c);
        QLog.d("SonicPreload", 2, ((StringBuilder)localObject2).toString());
      }
      l1 = paramSonicParserInfo.b;
    }
    label471:
    label474:
    for (;;)
    {
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
        SparseArray localSparseArray = new SparseArray();
        int i = 0;
        if (i < k)
        {
          localObject2 = ((JSONObject)localObject1).getJSONObject(localJSONArray.getString(i)).getString("extinfo");
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getSonicPreloadDataList : extInfo = ");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("SonicPreload", 2, ((StringBuilder)localObject3).toString());
          }
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = localObject1;
            l2 = l1;
            break label471;
          }
          Object localObject3 = new JSONObject((String)localObject2).optJSONArray("preload");
          localObject2 = localObject1;
          long l2 = l1;
          if (localObject3 == null) {
            break label471;
          }
          localObject2 = localObject1;
          l2 = l1;
          if (((JSONArray)localObject3).length() <= 0) {
            break label471;
          }
          int j = 0;
          localObject2 = localObject1;
          l2 = l1;
          if (j >= ((JSONArray)localObject3).length()) {
            break label471;
          }
          localObject2 = ((JSONArray)localObject3).getJSONObject(j);
          int m = ((JSONObject)localObject2).optInt("id");
          l2 = ((JSONObject)localObject2).optLong("templateChangeTime", -1L);
          if ((l2 < l1) || ((paramSonicParserInfo.c != 0) && (m != paramSonicParserInfo.c))) {
            break label474;
          }
          int n = localSparseArray.indexOfKey(m);
          if (n > 0)
          {
            SonicPreloadData localSonicPreloadData = (SonicPreloadData)localSparseArray.get(m);
            if (localSonicPreloadData.d >= l2) {
              break label474;
            }
            localSonicPreloadData.d = l2;
            localSonicPreloadData.e = ((JSONObject)localObject2).optInt("preloadType", 0);
            break label474;
          }
          localSparseArray.put(m, new SonicPreloadData(m, "", true, l2, ((JSONObject)localObject2).optInt("preloadType", 0)));
          j += 1;
          continue;
          i += 1;
          localObject1 = localObject2;
          l1 = l2;
          continue;
        }
        return localSparseArray;
      }
      catch (Exception paramSonicParserInfo)
      {
        QLog.e("SonicPreload", 1, "preloadSonicSession exception", paramSonicParserInfo);
      }
      return null;
    }
  }
  
  public boolean preload(List<SonicPreloadData> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramList != null)
    {
      if (paramList.size() < 1) {
        return false;
      }
      if (!enablePreloadSonic())
      {
        QLog.e("SonicPreload", 1, "preload net type not wifi or 3g or 4g ");
        return false;
      }
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject1 = (SonicPreloadData)localIterator.next();
        if (localObject1 != null)
        {
          paramList = ((SonicPreloadData)localObject1).b;
          if (!TextUtils.isEmpty(paramList))
          {
            if (paramList.contains("?"))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramList);
              ((StringBuilder)localObject2).append("&_sonic_rp=1");
              paramList = ((StringBuilder)localObject2).toString();
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramList);
              ((StringBuilder)localObject2).append("?_sonic_rp=1");
              paramList = ((StringBuilder)localObject2).toString();
            }
            Object localObject2 = new SonicSessionConfig.Builder();
            ((SonicSessionConfig.Builder)localObject2).setSessionMode(1);
            SonicEngine localSonicEngine = WebAccelerateHelper.getSonicEngine();
            bool2 = bool1;
            if (localSonicEngine != null) {
              bool2 = localSonicEngine.preCreateSession(paramList, ((SonicSessionConfig.Builder)localObject2).build(), ((SonicPreloadData)localObject1).d, ((SonicPreloadData)localObject1).e);
            }
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("preload: url = ");
              ((StringBuilder)localObject1).append(paramList);
              ((StringBuilder)localObject1).append(",result = ");
              ((StringBuilder)localObject1).append(bool2);
              QLog.d("SonicPreload", 2, ((StringBuilder)localObject1).toString());
              bool1 = bool2;
            }
          }
        }
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.api.impl.SonicPreloaderServiceImpl
 * JD-Core Version:    0.7.0.1
 */