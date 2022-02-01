package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
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
  
  public void a(WadlResult paramWadlResult)
  {
    if ((paramWadlResult != null) && (paramWadlResult.a != null))
    {
      String str = paramWadlResult.a.e;
      int i = GameCenterUtil.a(paramWadlResult.d);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWadlTaskStatusChanged:");
      localStringBuilder.append(paramWadlResult);
      localStringBuilder.append(",localStatus:");
      localStringBuilder.append(i);
      QLog.i("ThirdAppProxyImpl", 1, localStringBuilder.toString());
      if (i != -2)
      {
        if ((i != 6) && (i != 13))
        {
          if (i != 20) {
            if (i != 2)
            {
              if (i != 3) {
                if (i != 4)
                {
                  if ((i != 9) && (i != 10)) {
                    QLog.e("ThirdAppProxyImpl", 1, "download status not response!");
                  }
                }
                else
                {
                  ThirdAppProxyImpl.a(this.a).remove(str);
                  if ((ThirdAppProxyImpl.b(this.a) != null) && (ThirdAppProxyImpl.b(this.a).containsKey(str)) && (ThirdAppProxyImpl.b(this.a).get(str) != null)) {
                    ((ThirdAppProxy.AppDownloadListener)ThirdAppProxyImpl.b(this.a).get(str)).onDownloadComplete();
                  }
                  ThirdAppProxyImpl.b(this.a).remove(str);
                }
              }
            }
            else if ((ThirdAppProxyImpl.b(this.a) != null) && (ThirdAppProxyImpl.b(this.a).containsKey(str)) && (ThirdAppProxyImpl.b(this.a).get(str) != null))
            {
              i = 0;
              if (ThirdAppProxyImpl.a(this.a).containsKey(str)) {
                i = ((Integer)ThirdAppProxyImpl.a(this.a).get(str)).intValue();
              }
              int j = (int)(paramWadlResult.f * 100L / paramWadlResult.e);
              if (j - i >= 1)
              {
                ((ThirdAppProxy.AppDownloadListener)ThirdAppProxyImpl.b(this.a).get(str)).onDownloadProgress(paramWadlResult.f, paramWadlResult.e, j);
                ThirdAppProxyImpl.a(this.a).put(str, Integer.valueOf(j));
              }
            }
          }
        }
        else if (ThirdAppProxyImpl.c(this.a).containsKey(str))
        {
          paramWadlResult = (AsyncResult)ThirdAppProxyImpl.c(this.a).remove(str);
          if (paramWadlResult != null) {
            paramWadlResult.onReceiveResult(true, null);
          }
        }
      }
      else
      {
        i = GameCenterUtil.b(paramWadlResult.j);
        GameCenterUtil.c(i);
        ThirdAppProxyImpl.a(this.a).remove(str);
        if ((ThirdAppProxyImpl.b(this.a) != null) && (ThirdAppProxyImpl.b(this.a).containsKey(str)) && (ThirdAppProxyImpl.b(this.a).get(str) != null)) {
          ((ThirdAppProxy.AppDownloadListener)ThirdAppProxyImpl.b(this.a).get(str)).onDownloadFailed(i, i, "failed");
        }
        ThirdAppProxyImpl.b(this.a).remove(str);
      }
      return;
    }
    QLog.e("ThirdAppProxyImpl", 1, "onWadlTaskStatusChanged error wadlResult is null");
  }
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        WadlResult localWadlResult = (WadlResult)localIterator.next();
        Object localObject = localWadlResult.a;
        if (localObject != null) {
          paramArrayList = ((WadlParams)localObject).e;
        } else {
          paramArrayList = null;
        }
        if ((paramArrayList != null) && (localObject != null)) {
          ThirdAppProxyImpl.e(this.a).put(paramArrayList, localObject);
        }
        if ((paramArrayList != null) && (ThirdAppProxyImpl.d(this.a).containsKey(paramArrayList)))
        {
          localObject = (AsyncResult)ThirdAppProxyImpl.d(this.a).remove(paramArrayList);
          if (localObject == null) {}
        }
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("appid", paramArrayList);
          localJSONObject.put("status", localWadlResult.d);
          localJSONObject.put("downloadSize", localWadlResult.f);
          localJSONObject.put("totalSize", localWadlResult.e);
          localJSONObject.put("progress", localWadlResult.f * 100L / localWadlResult.e);
          if (localWadlResult.a != null) {
            localJSONObject.put("versionCode", localWadlResult.a.l);
          }
          if (localWadlResult.d == 6)
          {
            paramArrayList = localWadlResult.g;
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
          label285:
          break label285;
        }
        ((AsyncResult)localObject).onReceiveResult(false, null);
      }
      return;
    }
    Iterator localIterator = ThirdAppProxyImpl.d(this.a).entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramArrayList = (Map.Entry)localIterator.next();
      if (paramArrayList != null) {
        paramArrayList = (AsyncResult)paramArrayList.getValue();
      } else {
        paramArrayList = null;
      }
      if (paramArrayList != null) {
        paramArrayList.onReceiveResult(false, null);
      }
    }
    ThirdAppProxyImpl.d(this.a).clear();
  }
  
  public void b(ArrayList<WadlResult> paramArrayList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ThirdAppProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */