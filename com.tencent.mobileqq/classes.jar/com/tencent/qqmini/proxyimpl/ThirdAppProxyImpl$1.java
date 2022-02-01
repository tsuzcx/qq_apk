package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.WLog;
import com.tencent.open.wadl.WadlJsBridgeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy.AppDownloadListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

class ThirdAppProxyImpl$1
  implements WadlProxyServiceCallBackInterface
{
  ThirdAppProxyImpl$1(ThirdAppProxyImpl paramThirdAppProxyImpl) {}
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      localIterator = ThirdAppProxyImpl.d(this.a).entrySet().iterator();
      label78:
      while (localIterator.hasNext())
      {
        paramArrayList = (Map.Entry)localIterator.next();
        if (paramArrayList != null) {}
        for (paramArrayList = (AsyncResult)paramArrayList.getValue();; paramArrayList = null)
        {
          if (paramArrayList == null) {
            break label78;
          }
          paramArrayList.onReceiveResult(false, null);
          break;
        }
      }
      ThirdAppProxyImpl.d(this.a).clear();
      return;
    }
    Iterator localIterator = paramArrayList.iterator();
    label96:
    WadlResult localWadlResult;
    Object localObject;
    if (localIterator.hasNext())
    {
      localWadlResult = (WadlResult)localIterator.next();
      localObject = localWadlResult.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams;
      if (localObject == null) {
        break label370;
      }
    }
    label370:
    for (paramArrayList = ((WadlParams)localObject).a;; paramArrayList = null)
    {
      for (;;)
      {
        if ((paramArrayList != null) && (localObject != null)) {
          ThirdAppProxyImpl.e(this.a).put(paramArrayList, localObject);
        }
        if ((paramArrayList == null) || (!ThirdAppProxyImpl.d(this.a).containsKey(paramArrayList))) {
          break;
        }
        localObject = (AsyncResult)ThirdAppProxyImpl.d(this.a).remove(paramArrayList);
        if (localObject == null) {
          break;
        }
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("appid", paramArrayList);
          localJSONObject.put("status", localWadlResult.jdField_b_of_type_Int);
          localJSONObject.put("downloadSize", localWadlResult.jdField_b_of_type_Long);
          localJSONObject.put("totalSize", localWadlResult.jdField_a_of_type_Long);
          localJSONObject.put("progress", localWadlResult.jdField_b_of_type_Long * 100L / localWadlResult.jdField_a_of_type_Long);
          if (localWadlResult.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams != null) {
            localJSONObject.put("versionCode", localWadlResult.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams.e);
          }
          if (localWadlResult.jdField_b_of_type_Int == 6)
          {
            paramArrayList = localWadlResult.jdField_b_of_type_JavaLangString;
            if ((TextUtils.isEmpty(paramArrayList)) || (!new File(paramArrayList).exists()))
            {
              localJSONObject.put("status", 0);
              localJSONObject.put("progress", 0);
            }
          }
          ((AsyncResult)localObject).onReceiveResult(true, localJSONObject);
        }
        catch (Throwable paramArrayList)
        {
          ((AsyncResult)localObject).onReceiveResult(false, null);
        }
      }
      break label96;
      break;
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList) {}
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams == null)) {
      WLog.a("ThirdAppProxyImpl", "onWadlTaskStatusChanged error wadlResult is null");
    }
    String str;
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            str = paramWadlResult.jdField_a_of_type_ComTencentGamecenterWadlBizEntityWadlParams.a;
            i = WadlJsBridgeUtil.a(paramWadlResult.jdField_b_of_type_Int);
            QLog.i("ThirdAppProxyImpl", 1, "onWadlTaskStatusChanged:" + paramWadlResult + ",localStatus:" + i);
            switch (i)
            {
            case 3: 
            case 9: 
            case 10: 
            case 20: 
            default: 
              QLog.e("ThirdAppProxyImpl", 1, "download status not response!");
              return;
            case 4: 
              ThirdAppProxyImpl.a(this.a).remove(str);
              if ((ThirdAppProxyImpl.b(this.a) != null) && (ThirdAppProxyImpl.b(this.a).containsKey(str)) && (ThirdAppProxyImpl.b(this.a).get(str) != null)) {
                ((ThirdAppProxy.AppDownloadListener)ThirdAppProxyImpl.b(this.a).get(str)).onDownloadComplete();
              }
              ThirdAppProxyImpl.b(this.a).remove(str);
              return;
            }
          } while (!ThirdAppProxyImpl.c(this.a).containsKey(str));
          paramWadlResult = (AsyncResult)ThirdAppProxyImpl.c(this.a).remove(str);
        } while (paramWadlResult == null);
        paramWadlResult.onReceiveResult(true, null);
        return;
        i = WadlJsBridgeUtil.b(paramWadlResult.c);
        WadlJsBridgeUtil.a(i);
        ThirdAppProxyImpl.a(this.a).remove(str);
        if ((ThirdAppProxyImpl.b(this.a) != null) && (ThirdAppProxyImpl.b(this.a).containsKey(str)) && (ThirdAppProxyImpl.b(this.a).get(str) != null)) {
          ((ThirdAppProxy.AppDownloadListener)ThirdAppProxyImpl.b(this.a).get(str)).onDownloadFailed(i, i, "failed");
        }
        ThirdAppProxyImpl.b(this.a).remove(str);
        return;
      } while ((ThirdAppProxyImpl.b(this.a) == null) || (!ThirdAppProxyImpl.b(this.a).containsKey(str)) || (ThirdAppProxyImpl.b(this.a).get(str) == null));
      i = 0;
      if (ThirdAppProxyImpl.a(this.a).containsKey(str)) {
        i = ((Integer)ThirdAppProxyImpl.a(this.a).get(str)).intValue();
      }
      j = (int)(paramWadlResult.jdField_b_of_type_Long * 100L / paramWadlResult.jdField_a_of_type_Long);
    } while (j - i < 1);
    ((ThirdAppProxy.AppDownloadListener)ThirdAppProxyImpl.b(this.a).get(str)).onDownloadProgress(paramWadlResult.jdField_b_of_type_Long, paramWadlResult.jdField_a_of_type_Long, j);
    ThirdAppProxyImpl.a(this.a).put(str, Integer.valueOf(j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ThirdAppProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */