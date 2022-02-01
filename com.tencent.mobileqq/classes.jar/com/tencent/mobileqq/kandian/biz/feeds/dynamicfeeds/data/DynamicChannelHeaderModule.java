package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicChannelConfig;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.MonitorTimeExecutor;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.task.ProteusJsHelper;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicChannelHeaderModule
{
  private ExecutorService a = MonitorTimeExecutor.a();
  private Handler b;
  private ConcurrentHashMap<Integer, List<HeaderDataModel>> c = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, List<ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig>> d = new ConcurrentHashMap();
  
  public DynamicChannelHeaderModule(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  public static DynamicChannelHeaderModule a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.b();
    if (localQQAppInterface != null) {
      return ((ReadInJoyLogicManager)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().g();
    }
    return null;
  }
  
  private JSONObject a(JSONObject paramJSONObject, int paramInt, ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig paramOfflineHeaderConfig)
  {
    long l = System.currentTimeMillis();
    QLog.d("DynamicChannelHeaderModule", 1, "preProcessReqData, begin.");
    Object localObject2 = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.d(paramInt));
    Object localObject1 = paramJSONObject;
    if (localObject2 != null)
    {
      localObject2 = ((TemplateFactory)localObject2).f();
      localObject1 = paramJSONObject;
      if (localObject2 != null)
      {
        localObject1 = ((DynamicChannelConfig)localObject2).a("dp_environment_id");
        localObject2 = paramOfflineHeaderConfig.d;
        paramOfflineHeaderConfig = new StringBuffer();
        localObject2 = (String)ProteusJsHelper.a((String)localObject1, (String)localObject2, paramJSONObject.toString(), paramOfflineHeaderConfig);
        QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "preProcessReqData res = ", localObject2, ", exception = ", paramOfflineHeaderConfig });
        localObject1 = paramJSONObject;
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = new JSONObject((String)localObject2);
          }
        }
        catch (JSONException paramOfflineHeaderConfig)
        {
          QLog.d("DynamicChannelHeaderModule", 2, "preProcessReqData e = ", paramOfflineHeaderConfig);
          localObject1 = paramJSONObject;
        }
      }
    }
    QLog.d("DynamicChannelHeaderModule", 1, new Object[] { "preProcessReqData time cost = ", Long.valueOf(System.currentTimeMillis() - l) });
    return localObject1;
  }
  
  private void a(int paramInt1, int paramInt2, ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig paramOfflineHeaderConfig)
  {
    JSONObject localJSONObject = a(d(paramInt1), paramInt1, paramOfflineHeaderConfig);
    Bundle localBundle = JSONUtils.b(localJSONObject);
    HashMap localHashMap = new HashMap();
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", BaseApplicationImpl.getApplication());
    localBundle = new Bundle();
    localBundle.putInt("insert_index", paramInt2);
    new HttpWebCgiAsyncTask2(JSONUtils.a(localJSONObject, paramOfflineHeaderConfig.c), "POST", new DynamicChannelHeaderModule.2(this, paramInt1, paramOfflineHeaderConfig), 1000, localBundle).a(localHashMap);
  }
  
  private void a(int paramInt, HeaderDataModel paramHeaderDataModel)
  {
    if (paramHeaderDataModel == null) {
      return;
    }
    Object localObject2 = (List)this.c.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ArrayList();
      this.c.put(Integer.valueOf(paramInt), localObject1);
    }
    if (((List)localObject1).size() > 0)
    {
      paramInt = 0;
      while (paramInt < ((List)localObject1).size())
      {
        localObject2 = (HeaderDataModel)((List)localObject1).get(paramInt);
        if (((HeaderDataModel)localObject2).c > paramHeaderDataModel.c)
        {
          ((List)localObject1).add(paramInt, paramHeaderDataModel);
          QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "putHeaderDataModel, i = ", Integer.valueOf(paramInt), "dataModel = ", localObject2 });
          return;
        }
        paramInt += 1;
      }
    }
    ((List)localObject1).add(paramHeaderDataModel);
  }
  
  private void a(int paramInt, JSONObject paramJSONObject, Bundle paramBundle, ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig paramOfflineHeaderConfig)
  {
    if (paramJSONObject == null)
    {
      QLog.d("DynamicChannelHeaderModule", 2, "handleRequest result is null");
      a(paramInt, false, null, 0);
      return;
    }
    QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "result = ", paramJSONObject, ", requestParams = ", paramBundle });
    long l = System.currentTimeMillis();
    QLog.d("DynamicChannelHeaderModule", 1, "handleRequest, begin processRecData");
    paramJSONObject = b(paramJSONObject, paramInt, paramOfflineHeaderConfig);
    QLog.d("DynamicChannelHeaderModule", 1, new Object[] { "handleRequest, processedResult time cost = ", Long.valueOf(System.currentTimeMillis() - l) });
    QLog.d("DynamicChannelHeaderModule", 1, new Object[] { "handleRequest, processedResult = ", paramJSONObject });
    if (paramJSONObject == null)
    {
      QLog.d("DynamicChannelHeaderModule", 2, "handleRequest processedResult is null");
      a(paramInt, false, null, 0);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if (paramJSONObject == null)
    {
      QLog.d("DynamicChannelHeaderModule", 2, "handleRequest data is null.");
      a(paramInt, false, null, 0);
      return;
    }
    Object localObject1 = paramJSONObject.optJSONObject("commonInfo");
    paramJSONObject = paramJSONObject.optJSONArray("dataList");
    paramOfflineHeaderConfig = new ArrayList();
    if ((localObject1 != null) && (paramJSONObject != null))
    {
      localObject1 = ((JSONObject)localObject1).optString("cookieString");
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("readinjoy_dynamic_channel_header_cookie_");
        ((StringBuilder)localObject2).append(paramInt);
        RIJSPUtils.a(((StringBuilder)localObject2).toString(), localObject1);
      }
      if (paramJSONObject.length() == 0)
      {
        QLog.d("DynamicChannelHeaderModule", 2, "handleRequest dataList is null.");
        a(paramInt, false, null, 0);
        return;
      }
      int i;
      if (paramBundle != null) {
        i = paramBundle.getInt("insert_index");
      } else {
        i = 0;
      }
      int j = 0;
      while (j < paramJSONObject.length())
      {
        paramBundle = paramJSONObject.optJSONObject(j);
        if (paramBundle != null)
        {
          localObject1 = paramBundle.optString("style_ID", "");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new HeaderDataModel();
            ((HeaderDataModel)localObject2).a = ((String)localObject1);
            ((HeaderDataModel)localObject2).b = paramBundle.toString();
            ((HeaderDataModel)localObject2).c = i;
            paramOfflineHeaderConfig.add(localObject2);
            QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "handleRequest [", Integer.valueOf(j), "] = ", localObject2 });
          }
        }
        j += 1;
      }
      if (paramOfflineHeaderConfig.size() > 0)
      {
        b(paramInt, paramOfflineHeaderConfig);
        a(paramInt, true, c(paramInt), i);
      }
    }
    else
    {
      QLog.d("DynamicChannelHeaderModule", 2, "handleRequest commonInfo or dataList is null.");
      a(paramInt, false, null, 0);
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean, List<HeaderDataModel> paramList, int paramInt2)
  {
    this.b.post(new DynamicChannelHeaderModule.3(this, paramInt1, paramBoolean, paramList, paramInt2));
  }
  
  private JSONObject b(JSONObject paramJSONObject, int paramInt, ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig paramOfflineHeaderConfig)
  {
    Object localObject = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.d(paramInt));
    if (localObject != null)
    {
      localObject = ((TemplateFactory)localObject).f();
      if (localObject != null)
      {
        localObject = ((DynamicChannelConfig)localObject).a("dp_environment_id");
        String str = paramOfflineHeaderConfig.e;
        paramOfflineHeaderConfig = new StringBuffer();
        localObject = (String)ProteusJsHelper.a((String)localObject, str, paramJSONObject.toString(), paramOfflineHeaderConfig);
        QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "preProcessRecData res = ", localObject, ", exception = ", paramOfflineHeaderConfig });
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramOfflineHeaderConfig = new JSONObject((String)localObject);
            return paramOfflineHeaderConfig;
          }
        }
        catch (JSONException paramOfflineHeaderConfig)
        {
          QLog.d("DynamicChannelHeaderModule", 2, "preProcessRecData e = ", paramOfflineHeaderConfig);
        }
      }
    }
    return paramJSONObject;
  }
  
  private void b(int paramInt, List<HeaderDataModel> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramInt, (HeaderDataModel)paramList.next());
      }
    }
  }
  
  private boolean c()
  {
    ExecutorService localExecutorService = this.a;
    return (localExecutorService != null) && (!localExecutorService.isShutdown());
  }
  
  private JSONObject d(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      Object localObject1 = ReadInJoyUtils.c();
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (bool) {
        localObject1 = "";
      }
      localJSONObject.put("imei", localObject1);
      localJSONObject.put("platform", "Android");
      localJSONObject.put("qqVersionID", "8.8.17");
      Object localObject2 = (QQAppInterface)ReadInJoyUtils.b();
      localObject1 = ((QQAppInterface)localObject2).getAccount();
      localObject2 = ((TicketManager)((QQAppInterface)localObject2).getManager(2)).getSkey((String)localObject1);
      localJSONObject.put("uin", localObject1);
      if (localObject2 == null) {
        localObject1 = "";
      } else {
        localObject1 = ReadInJoyWebDataManager.a((String)localObject2);
      }
      localJSONObject.put("token", localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("readinjoy_dynamic_channel_header_cookie_");
      ((StringBuilder)localObject1).append(paramInt);
      localJSONObject.put("cookieString", RIJSPUtils.b(((StringBuilder)localObject1).toString(), ""));
    }
    catch (JSONException localJSONException)
    {
      QLog.d("DynamicChannelHeaderModule", 2, "makeRequestParams, e = ", localJSONException);
    }
    QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "makeRequestParams params = ", localJSONObject });
    return localJSONObject;
  }
  
  public void a(int paramInt)
  {
    List localList = (List)this.d.get(Integer.valueOf(paramInt));
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig localOfflineHeaderConfig = (ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig)localList.get(i);
        if ((!TextUtils.isEmpty(localOfflineHeaderConfig.a)) && (!TextUtils.isEmpty(localOfflineHeaderConfig.b)))
        {
          HeaderDataModel localHeaderDataModel = new HeaderDataModel();
          localHeaderDataModel.a = localOfflineHeaderConfig.a;
          localHeaderDataModel.b = localOfflineHeaderConfig.b;
          localHeaderDataModel.c = i;
          localArrayList.add(localHeaderDataModel);
        }
        i += 1;
      }
      this.c.put(Integer.valueOf(paramInt), localArrayList);
    }
  }
  
  public void a(int paramInt, List<ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig> paramList)
  {
    if ((paramInt != -1) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.d.put(Integer.valueOf(paramInt), paramList);
    }
  }
  
  public void b()
  {
    this.c.clear();
    this.d.clear();
    ExecutorService localExecutorService = this.a;
    if (localExecutorService != null) {
      localExecutorService.shutdownNow();
    }
  }
  
  public void b(int paramInt)
  {
    List localList = (List)this.d.get(Integer.valueOf(paramInt));
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig localOfflineHeaderConfig = (ReadInJoyDynamicChannelBaseFragment.OfflineHeaderConfig)localList.get(i);
        if ((!TextUtils.isEmpty(localOfflineHeaderConfig.c)) && (c())) {
          this.a.execute(new DynamicChannelHeaderModule.1(this, paramInt, i, localOfflineHeaderConfig));
        }
        i += 1;
      }
    }
  }
  
  public List<HeaderDataModel> c(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = (List)this.c.get(Integer.valueOf(paramInt));
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelHeaderModule
 * JD-Core Version:    0.7.0.1
 */