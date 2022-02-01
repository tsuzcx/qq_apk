package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.CollectionUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicChannelConfig;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig;
import com.tencent.mobileqq.kandian.biz.pts.data.DynamicChannelDataModel;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.MonitorTimeExecutor;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.task.ProteusJsHelper;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicChannelDataModule
{
  private EntityManager a;
  private ExecutorService b;
  private Handler c;
  private ConcurrentHashMap<Integer, ConcurrentHashMap<String, DynamicChannelDataModel>> d = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig> e = new ConcurrentHashMap();
  
  public DynamicChannelDataModule(EntityManager paramEntityManager, Handler paramHandler)
  {
    this.a = paramEntityManager;
    this.b = MonitorTimeExecutor.a();
    this.c = paramHandler;
  }
  
  public static DynamicChannelDataModule a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.b();
    if (localQQAppInterface != null) {
      return ((ReadInJoyLogicManager)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine().f();
    }
    return null;
  }
  
  private List<DynamicChannelDataModel> a(int paramInt, List<DynamicChannelDataModel> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt != -1) && (paramList != null))
    {
      if (paramList.size() == 0) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)paramList.next();
        boolean bool = a(paramInt, localDynamicChannelDataModel);
        QLog.d("DynamicChannelDataModule", 2, new Object[] { "saveDataModelList, isDuplicate = ", Boolean.valueOf(bool), ", dataModel = ", localDynamicChannelDataModel });
        if (!bool)
        {
          localArrayList.add(localDynamicChannelDataModel);
          a(paramInt, localDynamicChannelDataModel, paramBoolean);
        }
      }
    }
    return localArrayList;
  }
  
  private List<DynamicChannelDataModel> a(int paramInt, JSONObject paramJSONObject, Bundle paramBundle)
  {
    boolean bool = false;
    int i;
    if ((paramBundle != null) && (paramBundle.getInt("isPullDownRefresh", 0) == 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramJSONObject == null)
    {
      QLog.d("DynamicChannelDataModule", 2, "handleDataFromServer result is null");
      return null;
    }
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "result = ", paramJSONObject, ", requestParams = ", paramBundle });
    long l = System.currentTimeMillis();
    QLog.d("DynamicChannelDataModule", 1, "handleDataFromServer, begin processRecData");
    paramJSONObject = a(paramJSONObject, paramInt);
    QLog.d("DynamicChannelDataModule", 1, new Object[] { "handleDataFromServer, processedResult time cost = ", Long.valueOf(System.currentTimeMillis() - l) });
    QLog.d("DynamicChannelDataModule", 1, new Object[] { "handleDataFromServer, processedResult = ", paramJSONObject });
    if (paramJSONObject == null)
    {
      QLog.d("DynamicChannelDataModule", 2, "handleDataFromServer processedResult is null");
      return null;
    }
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if (paramJSONObject == null)
    {
      QLog.d("DynamicChannelDataModule", 2, "handleDataFromServer data is null.");
      return null;
    }
    JSONObject localJSONObject = paramJSONObject.optJSONObject("commonInfo");
    JSONArray localJSONArray = paramJSONObject.optJSONArray("dataList");
    paramBundle = new ArrayList();
    paramJSONObject = paramBundle;
    if (localJSONObject != null)
    {
      paramJSONObject = paramBundle;
      if (localJSONArray != null)
      {
        paramJSONObject = localJSONObject.optString("cookieString");
        if (localJSONObject.optInt("hasMore", 0) == 1) {
          bool = true;
        }
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          paramBundle = new StringBuilder();
          paramBundle.append("readinjoy_dynamic_channel_cookie_");
          paramBundle.append(paramInt);
          RIJSPUtils.a(paramBundle.toString(), paramJSONObject);
        }
        if (i != 0) {
          return a(localJSONArray, bool, paramInt);
        }
        paramJSONObject = b(localJSONArray, bool, paramInt);
      }
    }
    return paramJSONObject;
  }
  
  private List<DynamicChannelDataModel> a(JSONArray paramJSONArray, boolean paramBoolean, int paramInt)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      long l1 = 1L;
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        long l2 = l1;
        if (localJSONObject != null)
        {
          String str1 = localJSONObject.optString("style_ID", "");
          String str2 = localJSONObject.optString("uniqueID", "");
          l2 = l1;
          if (!TextUtils.isEmpty(str1))
          {
            l2 = l1;
            if (!TextUtils.isEmpty(str2))
            {
              DynamicChannelDataModel localDynamicChannelDataModel = new DynamicChannelDataModel();
              localDynamicChannelDataModel.styleID = str1;
              localDynamicChannelDataModel.uniqueID = str2;
              localDynamicChannelDataModel.channelID = paramInt;
              localDynamicChannelDataModel.proteusData = localJSONObject.toString();
              localDynamicChannelDataModel.recommendSeq = l1;
              localArrayList.add(localDynamicChannelDataModel);
              QLog.d("DynamicChannelDataModule", 2, new Object[] { "handlePullDownRefresh [", Integer.valueOf(i), "] = ", localDynamicChannelDataModel });
              l2 = l1 + 1L;
            }
          }
        }
        i += 1;
        l1 = l2;
      }
      if (localArrayList.size() > 0)
      {
        d(paramInt);
        a(true, paramInt, true, paramBoolean, a(paramInt, localArrayList, true));
      }
      return localArrayList;
    }
    QLog.d("DynamicChannelDataModule", 2, "handlePullDownRefresh, dataList is null.");
    return null;
  }
  
  private JSONObject a(JSONObject paramJSONObject, int paramInt)
  {
    Object localObject = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.d(paramInt));
    if (localObject != null)
    {
      localObject = ((TemplateFactory)localObject).f();
      if (localObject != null)
      {
        String str = ((DynamicChannelConfig)localObject).a("dp_environment_id");
        localObject = (ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)this.e.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          localObject = ((ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject).d;
        } else {
          localObject = "";
        }
        StringBuffer localStringBuffer = new StringBuffer();
        long l = System.currentTimeMillis();
        QLog.d("DynamicChannelDataModule", 1, "preProcessRecData, begin.");
        localObject = (String)ProteusJsHelper.a(str, (String)localObject, paramJSONObject.toString(), localStringBuffer);
        QLog.d("DynamicChannelDataModule", 1, new Object[] { "preProcessRecData, time cost = ", Long.valueOf(System.currentTimeMillis() - l) });
        QLog.d("DynamicChannelDataModule", 1, new Object[] { "preProcessRecData res = ", localObject, ", exception = ", localStringBuffer });
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject((String)localObject);
            return localObject;
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.d("DynamicChannelDataModule", 1, "preProcessRecData e = ", localJSONException);
        }
      }
    }
    return paramJSONObject;
  }
  
  private void a(int paramInt, DynamicChannelDataModel paramDynamicChannelDataModel, boolean paramBoolean)
  {
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "saveDataModel, dataModel = ", paramDynamicChannelDataModel });
    if (paramDynamicChannelDataModel == null) {
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.d.get(Integer.valueOf(paramInt));
    Object localObject = localConcurrentHashMap;
    if (localConcurrentHashMap == null)
    {
      localObject = new ConcurrentHashMap();
      this.d.put(Integer.valueOf(paramInt), localObject);
    }
    ((ConcurrentHashMap)localObject).put(paramDynamicChannelDataModel.uniqueID, paramDynamicChannelDataModel);
    if (paramBoolean)
    {
      localObject = new DynamicChannelDataModule.9(this, paramDynamicChannelDataModel);
      if (c())
      {
        this.b.execute((Runnable)localObject);
        return;
      }
      QLog.d("DynamicChannelDataModule", 2, new Object[] { "saveDataModel failed, dataModel = ", paramDynamicChannelDataModel });
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, List<DynamicChannelDataModel> paramList)
  {
    this.c.post(new DynamicChannelDataModule.7(this, paramBoolean1, paramInt, paramBoolean2, paramBoolean3, paramList));
  }
  
  private boolean a(int paramInt, DynamicChannelDataModel paramDynamicChannelDataModel)
  {
    boolean bool2 = false;
    if (paramDynamicChannelDataModel == null) {
      return false;
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.d.get(Integer.valueOf(paramInt));
    boolean bool1 = bool2;
    if (localConcurrentHashMap != null)
    {
      bool1 = bool2;
      if (localConcurrentHashMap.containsKey(paramDynamicChannelDataModel.uniqueID)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private List<DynamicChannelDataModel> b(JSONArray paramJSONArray, boolean paramBoolean, int paramInt)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      long l1 = c(paramInt) + 1L;
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        long l2 = l1;
        if (localJSONObject != null)
        {
          String str1 = localJSONObject.optString("style_ID", "");
          String str2 = localJSONObject.optString("uniqueID", "");
          l2 = l1;
          if (!TextUtils.isEmpty(str1))
          {
            l2 = l1;
            if (!TextUtils.isEmpty(str2))
            {
              DynamicChannelDataModel localDynamicChannelDataModel = new DynamicChannelDataModel();
              localDynamicChannelDataModel.styleID = str1;
              localDynamicChannelDataModel.uniqueID = str2;
              localDynamicChannelDataModel.channelID = paramInt;
              localDynamicChannelDataModel.proteusData = localJSONObject.toString();
              localDynamicChannelDataModel.recommendSeq = l1;
              localArrayList.add(localDynamicChannelDataModel);
              QLog.d("DynamicChannelDataModule", 2, new Object[] { "handlePullUpLoadMore [", Integer.valueOf(i), "] = ", localDynamicChannelDataModel });
              l2 = l1 + 1L;
            }
          }
        }
        i += 1;
        l1 = l2;
      }
      if (localArrayList.size() > 0) {
        a(false, paramInt, true, paramBoolean, a(paramInt, localArrayList, true));
      }
      return localArrayList;
    }
    QLog.d("DynamicChannelDataModule", 2, "handlePullUpLoadMore, dataList is null.");
    return null;
  }
  
  private JSONObject b(JSONObject paramJSONObject, int paramInt)
  {
    long l = System.currentTimeMillis();
    QLog.d("DynamicChannelDataModule", 1, "preProcessReqData, begin.");
    Object localObject2 = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.d(paramInt));
    Object localObject1 = paramJSONObject;
    JSONObject localJSONObject;
    if (localObject2 != null)
    {
      localObject2 = ((TemplateFactory)localObject2).f();
      localObject1 = paramJSONObject;
      if (localObject2 != null)
      {
        localObject2 = ((DynamicChannelConfig)localObject2).a("dp_environment_id");
        localObject1 = (ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)this.e.get(Integer.valueOf(paramInt));
        if (localObject1 != null) {
          localObject1 = ((ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject1).c;
        } else {
          localObject1 = "";
        }
        StringBuffer localStringBuffer = new StringBuffer();
        localObject2 = (String)ProteusJsHelper.a((String)localObject2, (String)localObject1, paramJSONObject.toString(), localStringBuffer);
        QLog.d("DynamicChannelDataModule", 2, new Object[] { "preProcessReqData res = ", localObject2, ", exception = ", localStringBuffer });
        localObject1 = paramJSONObject;
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = new JSONObject((String)localObject2);
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.d("DynamicChannelDataModule", 2, "preProcessReqData e = ", localJSONException);
          localJSONObject = paramJSONObject;
        }
      }
    }
    QLog.d("DynamicChannelDataModule", 1, new Object[] { "preProcessReqData time cost = ", Long.valueOf(System.currentTimeMillis() - l) });
    return localJSONObject;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    Object localObject = (ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)this.e.get(Integer.valueOf(paramInt1));
    if (localObject != null) {
      localObject = ((ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig)localObject).a;
    } else {
      localObject = "";
    }
    JSONObject localJSONObject = b(c(paramInt1, paramInt2), paramInt1);
    Bundle localBundle = JSONUtils.b(localJSONObject);
    HashMap localHashMap = new HashMap();
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", BaseApplicationImpl.getApplication());
    localBundle = new Bundle();
    int j = 1;
    int i = j;
    if (paramInt2 != 1) {
      if (paramInt2 == 2) {
        i = j;
      } else {
        i = 0;
      }
    }
    localBundle.putInt("isPullDownRefresh", i);
    new HttpWebCgiAsyncTask2(JSONUtils.a(localJSONObject, (String)localObject), "POST", new DynamicChannelDataModule.6(this, paramInt1), 1000, localBundle).a(localHashMap);
  }
  
  private void b(Entity paramEntity)
  {
    if (((paramEntity instanceof DynamicChannelDataModel)) && (this.a.tabbleIsExist(DynamicChannelDataModel.class.getSimpleName())))
    {
      paramEntity = (DynamicChannelDataModel)paramEntity;
      paramEntity = this.a.find(DynamicChannelDataModel.class, "uniqueID = ? and channelID = ?", new String[] { paramEntity.uniqueID, String.valueOf(paramEntity.channelID) });
    }
    else
    {
      paramEntity = null;
    }
    if (paramEntity != null) {
      this.a.remove(paramEntity);
    }
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "removeEntityIfExistsInDB entity = ", paramEntity });
  }
  
  private JSONObject c(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      int i;
      try
      {
        localObject1 = ReadInJoyUtils.c();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        if (bool) {
          localObject1 = "";
        }
        localJSONObject.put("imei", localObject1);
        localJSONObject.put("platform", "Android");
        localJSONObject.put("qqVersionID", "8.8.17");
        localObject2 = (QQAppInterface)ReadInJoyUtils.b();
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
        ((StringBuilder)localObject1).append("readinjoy_dynamic_channel_cookie_");
        ((StringBuilder)localObject1).append(paramInt1);
        localJSONObject.put("cookieString", RIJSPUtils.b(((StringBuilder)localObject1).toString(), ""));
        if (paramInt2 == 2) {
          break label337;
        }
        if (paramInt2 != 1) {
          break label332;
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        Object localObject2;
        QLog.d("DynamicChannelDataModule", 2, "makeRequestParams, e = ", localJSONException);
      }
      localJSONObject.put("isPullDownRefresh", i);
      localObject1 = new JSONArray();
      localObject2 = (ConcurrentHashMap)this.d.get(Integer.valueOf(paramInt1));
      if ((paramInt2 == 0) && (localObject2 != null))
      {
        localObject2 = ((ConcurrentHashMap)localObject2).keySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          ((JSONArray)localObject1).put((String)((Iterator)localObject2).next());
          continue;
        }
      }
      localJSONObject.put("dataIDList", localObject1);
      QLog.d("DynamicChannelDataModule", 2, new Object[] { "makeRequestParams params = ", localJSONObject });
      return localJSONObject;
      label332:
      paramInt2 = 0;
      break label339;
      label337:
      paramInt2 = 1;
      label339:
      if (paramInt2 != 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  private boolean c()
  {
    ExecutorService localExecutorService = this.b;
    return (localExecutorService != null) && (!localExecutorService.isShutdown());
  }
  
  private void d(int paramInt)
  {
    this.d.remove(Integer.valueOf(paramInt));
    if (c())
    {
      this.b.execute(new DynamicChannelDataModule.10(this, paramInt));
      return;
    }
    QLog.d("DynamicChannelDataModule", 2, "clearDataModelList failed.");
  }
  
  public void a(int paramInt)
  {
    if (c())
    {
      this.b.execute(new DynamicChannelDataModule.3(this, paramInt));
      return;
    }
    QLog.d("DynamicChannelDataModule", 2, "pullDownRefresh failed.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "loadDataFromDB, channelID = ", Integer.valueOf(paramInt1), ", count = ", Integer.valueOf(paramInt2) });
    Object localObject = b(paramInt1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      this.c.post(new DynamicChannelDataModule.1(this, paramInt1, (List)localObject));
      return;
    }
    localObject = new DynamicChannelDataModule.2(this, paramInt1, paramInt2);
    if (c())
    {
      this.b.execute((Runnable)localObject);
      return;
    }
    QLog.d("DynamicChannelDataModule", 2, "loadDataFromDB failed, executor is not available.");
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject = CollectionUtils.a(b(paramInt1), new DynamicChannelDataModule.4(this, paramLong));
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      a(false, paramInt1, true, true, (List)localObject);
      return;
    }
    localObject = new DynamicChannelDataModule.5(this, paramInt1, paramLong, paramInt2);
    if (c())
    {
      this.b.execute((Runnable)localObject);
      return;
    }
    QLog.d("DynamicChannelDataModule", 2, "pullUpLoadMore failed.");
  }
  
  public void a(int paramInt, ReadInJoyDynamicChannelBaseFragment.OfflineBodyConfig paramOfflineBodyConfig)
  {
    if ((paramInt != -1) && (paramOfflineBodyConfig != null))
    {
      this.e.put(Integer.valueOf(paramInt), paramOfflineBodyConfig);
      return;
    }
    QLog.d("DynamicChannelDataModule", 2, "channelID of config is not valid.");
  }
  
  public boolean a(Entity paramEntity)
  {
    try
    {
      int i = paramEntity.getStatus();
      boolean bool = false;
      if (i == 1000)
      {
        b(paramEntity);
        this.a.persistOrReplace(paramEntity);
        i = paramEntity.getStatus();
        if (i == 1001) {
          bool = true;
        }
        return bool;
      }
      if (paramEntity.getStatus() != 1001)
      {
        i = paramEntity.getStatus();
        if (i != 1002) {
          return false;
        }
      }
      bool = this.a.update(paramEntity);
      return bool;
    }
    finally {}
  }
  
  public List<DynamicChannelDataModel> b(int paramInt)
  {
    Object localObject = (ConcurrentHashMap)this.d.get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() != 0))
    {
      ArrayList localArrayList = new ArrayList(((ConcurrentHashMap)localObject).size());
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)((Iterator)localObject).next();
        if (localDynamicChannelDataModel != null) {
          localArrayList.add(localDynamicChannelDataModel);
        }
      }
      Collections.sort(localArrayList, new DynamicChannelDataModule.8(this));
      return localArrayList;
    }
    return null;
  }
  
  public void b()
  {
    this.d.clear();
    this.e.clear();
    ExecutorService localExecutorService = this.b;
    if (localExecutorService != null) {
      localExecutorService.shutdownNow();
    }
  }
  
  public long c(int paramInt)
  {
    Object localObject = (ConcurrentHashMap)this.d.get(Integer.valueOf(paramInt));
    long l1 = -1L;
    long l2 = l1;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      for (;;)
      {
        l2 = l1;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)((Iterator)localObject).next();
        if (localDynamicChannelDataModel.recommendSeq > l1) {
          l1 = localDynamicChannelDataModel.recommendSeq;
        }
      }
    }
    return l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule
 * JD-Core Version:    0.7.0.1
 */