package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import bfrz;
import bfse;
import bfsk;
import bkik;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.core.proxy.ThirdAppProxy.AppDownloadListener;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

class ThirdAppProxyImpl$1
  implements bkik
{
  ThirdAppProxyImpl$1(ThirdAppProxyImpl paramThirdAppProxyImpl) {}
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    Object localObject1;
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      localObject1 = ThirdAppProxyImpl.access$300(this.this$0).entrySet().iterator();
      label78:
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayList = (Map.Entry)((Iterator)localObject1).next();
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
      ThirdAppProxyImpl.access$300(this.this$0).clear();
    }
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject2 = (WadlResult)paramArrayList.next();
        localObject1 = ((WadlResult)localObject2).jdField_a_of_type_CooperationWadlIpcWadlParams;
        String str = ((WadlParams)localObject1).a;
        if ((str != null) && (localObject1 != null)) {
          ThirdAppProxyImpl.access$400(this.this$0).put(str, localObject1);
        }
        if ((str != null) && (ThirdAppProxyImpl.access$300(this.this$0).containsKey(str)))
        {
          localObject1 = (AsyncResult)ThirdAppProxyImpl.access$300(this.this$0).remove(str);
          if (localObject1 != null) {
            try
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("appid", str);
              localJSONObject.put("status", ((WadlResult)localObject2).jdField_b_of_type_Int);
              localJSONObject.put("downloadSize", ((WadlResult)localObject2).jdField_b_of_type_Long);
              localJSONObject.put("totalSize", ((WadlResult)localObject2).jdField_a_of_type_Long);
              localJSONObject.put("progress", ((WadlResult)localObject2).jdField_b_of_type_Long * 100L / ((WadlResult)localObject2).jdField_a_of_type_Long);
              if (((WadlResult)localObject2).jdField_a_of_type_CooperationWadlIpcWadlParams != null) {
                localJSONObject.put("versionCode", ((WadlResult)localObject2).jdField_a_of_type_CooperationWadlIpcWadlParams.f);
              }
              if (((WadlResult)localObject2).jdField_b_of_type_Int == 6)
              {
                localObject2 = ((WadlResult)localObject2).jdField_b_of_type_JavaLangString;
                if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists()))
                {
                  localJSONObject.put("status", 0);
                  localJSONObject.put("progress", 0);
                }
              }
              ((AsyncResult)localObject1).onReceiveResult(true, localJSONObject);
            }
            catch (Throwable localThrowable)
            {
              ((AsyncResult)localObject1).onReceiveResult(false, null);
            }
          }
        }
      }
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList) {}
  
  public void onReceiveYYBInstall(String paramString1, String paramString2) {}
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams == null)) {
      bfrz.a("ThirdAppProxyImpl", "onWadlTaskStatusChanged error wadlResult is null");
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
            WadlParams localWadlParams = paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams;
            str = localWadlParams.a;
            i = bfsk.a(paramWadlResult.jdField_b_of_type_Int);
            bfse.b(localWadlParams.a);
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
              ThirdAppProxyImpl.access$000(this.this$0).remove(str);
              if ((ThirdAppProxyImpl.access$100(this.this$0) != null) && (ThirdAppProxyImpl.access$100(this.this$0).containsKey(str)) && (ThirdAppProxyImpl.access$100(this.this$0).get(str) != null)) {
                ((ThirdAppProxy.AppDownloadListener)ThirdAppProxyImpl.access$100(this.this$0).get(str)).onDownloadComplete();
              }
              ThirdAppProxyImpl.access$100(this.this$0).remove(str);
              return;
            }
          } while (!ThirdAppProxyImpl.access$200(this.this$0).containsKey(str));
          paramWadlResult = (AsyncResult)ThirdAppProxyImpl.access$200(this.this$0).remove(str);
        } while (paramWadlResult == null);
        paramWadlResult.onReceiveResult(true, null);
        return;
        i = bfsk.b(paramWadlResult.c);
        bfsk.a(i);
        ThirdAppProxyImpl.access$000(this.this$0).remove(str);
        if ((ThirdAppProxyImpl.access$100(this.this$0) != null) && (ThirdAppProxyImpl.access$100(this.this$0).containsKey(str)) && (ThirdAppProxyImpl.access$100(this.this$0).get(str) != null)) {
          ((ThirdAppProxy.AppDownloadListener)ThirdAppProxyImpl.access$100(this.this$0).get(str)).onDownloadFailed(i, i, "failed");
        }
        ThirdAppProxyImpl.access$100(this.this$0).remove(str);
        return;
      } while ((ThirdAppProxyImpl.access$100(this.this$0) == null) || (!ThirdAppProxyImpl.access$100(this.this$0).containsKey(str)) || (ThirdAppProxyImpl.access$100(this.this$0).get(str) == null));
      i = 0;
      if (ThirdAppProxyImpl.access$000(this.this$0).containsKey(str)) {
        i = ((Integer)ThirdAppProxyImpl.access$000(this.this$0).get(str)).intValue();
      }
      j = (int)(paramWadlResult.jdField_b_of_type_Long * 100L / paramWadlResult.jdField_a_of_type_Long);
    } while (j - i < 1);
    ((ThirdAppProxy.AppDownloadListener)ThirdAppProxyImpl.access$100(this.this$0).get(str)).onDownloadProgress(paramWadlResult.jdField_b_of_type_Long, paramWadlResult.jdField_a_of_type_Long, j);
    ThirdAppProxyImpl.access$000(this.this$0).put(str, Integer.valueOf(j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ThirdAppProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */