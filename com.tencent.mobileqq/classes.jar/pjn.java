import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.1;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.10;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.2;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.3;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.5;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.7;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.9;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.JSONUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ProteusJsHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
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

public class pjn
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ConcurrentHashMap<Integer, ConcurrentHashMap<String, DynamicChannelDataModel>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private ConcurrentHashMap<Integer, piw> b = new ConcurrentHashMap();
  
  public pjn(EntityManager paramEntityManager, Handler paramHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  private List<DynamicChannelDataModel> a(int paramInt, List<DynamicChannelDataModel> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt == -1) || (paramList == null) || (paramList.size() == 0)) {
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
    return localArrayList;
  }
  
  private List<DynamicChannelDataModel> a(int paramInt, JSONObject paramJSONObject, Bundle paramBundle)
  {
    int i;
    if ((paramBundle != null) && (paramBundle.getInt("isPullDownRefresh", 0) == 1))
    {
      i = 1;
      if (paramJSONObject != null) {
        break label40;
      }
      QLog.d("DynamicChannelDataModule", 2, "handleDataFromServer result is null");
      paramJSONObject = null;
    }
    label40:
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    do
    {
      do
      {
        return paramJSONObject;
        i = 0;
        break;
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
        localJSONObject = paramJSONObject.optJSONObject("commonInfo");
        localJSONArray = paramJSONObject.optJSONArray("dataList");
        paramBundle = new ArrayList();
        paramJSONObject = paramBundle;
      } while (localJSONObject == null);
      paramJSONObject = paramBundle;
    } while (localJSONArray == null);
    paramJSONObject = localJSONObject.optString("cookieString");
    if (localJSONObject.optInt("hasMore", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if (!TextUtils.isEmpty(paramJSONObject)) {
        bkwm.a("readinjoy_dynamic_channel_cookie_" + paramInt, paramJSONObject);
      }
      if (i == 0) {
        break;
      }
      return a(localJSONArray, bool, paramInt);
    }
    return b(localJSONArray, bool, paramInt);
  }
  
  private List<DynamicChannelDataModel> a(JSONArray paramJSONArray, boolean paramBoolean, int paramInt)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      QLog.d("DynamicChannelDataModule", 2, "handlePullDownRefresh, dataList is null.");
      return null;
    }
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
            l2 = 1L + l1;
          }
        }
      }
      i += 1;
      l1 = l2;
    }
    if (localArrayList.size() > 0)
    {
      b(paramInt);
      a(true, paramInt, true, paramBoolean, a(paramInt, localArrayList, true));
    }
    return localArrayList;
  }
  
  private JSONObject a(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localObject1 = pay.i();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label287;
        }
        localJSONObject.put("imei", localObject1);
        localJSONObject.put("platform", "Android");
        localJSONObject.put("qqVersionID", "8.4.8");
        localObject2 = (QQAppInterface)pay.a();
        localObject1 = ((QQAppInterface)localObject2).getAccount();
        localObject2 = ((TicketManager)((QQAppInterface)localObject2).getManager(2)).getSkey((String)localObject1);
        localJSONObject.put("uin", localObject1);
        if (localObject2 != null) {
          break label294;
        }
        localObject1 = "";
        localJSONObject.put("token", localObject1);
        localJSONObject.put("cookieString", bkwm.a("readinjoy_dynamic_channel_cookie_" + paramInt1, ""));
        if (paramInt2 == 2) {
          break label318;
        }
        if (paramInt2 != 1) {
          break label329;
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        QLog.d("DynamicChannelDataModule", 2, "makeRequestParams, e = ", localJSONException);
        QLog.d("DynamicChannelDataModule", 2, new Object[] { "makeRequestParams params = ", localJSONObject });
        return localJSONObject;
      }
      localJSONObject.put("isPullDownRefresh", i);
      localObject1 = new JSONArray();
      Object localObject2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
      label287:
      String str;
      if ((paramInt2 == 0) && (localObject2 != null))
      {
        localObject2 = ((ConcurrentHashMap)localObject2).keySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          ((JSONArray)localObject1).put((String)((Iterator)localObject2).next());
          continue;
          str = "";
          continue;
          label294:
          str = rtb.a((String)localObject2);
          continue;
        }
      }
      localJSONObject.put("dataIDList", str);
      continue;
      label318:
      label329:
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 == 0) {
          break label334;
        }
        i = 1;
        break;
      }
      label334:
      int i = 0;
    }
  }
  
  private JSONObject a(JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2 = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.a(paramInt));
    Object localObject1 = paramJSONObject;
    if (localObject2 != null)
    {
      localObject2 = ((syz)localObject2).a();
      localObject1 = paramJSONObject;
      if (localObject2 != null)
      {
        localObject2 = ((pip)localObject2).a("dp_environment_id");
        localObject1 = (piw)this.b.get(Integer.valueOf(paramInt));
        if (localObject1 == null) {
          break label209;
        }
      }
    }
    label209:
    String str;
    for (localObject1 = ((piw)localObject1).c;; str = "")
    {
      StringBuffer localStringBuffer = new StringBuffer();
      long l = System.currentTimeMillis();
      QLog.d("DynamicChannelDataModule", 1, "preProcessRecData, begin.");
      localObject2 = (String)ProteusJsHelper.evaluateJs((String)localObject2, (String)localObject1, paramJSONObject.toString(), localStringBuffer);
      QLog.d("DynamicChannelDataModule", 1, new Object[] { "preProcessRecData, time cost = ", Long.valueOf(System.currentTimeMillis() - l) });
      QLog.d("DynamicChannelDataModule", 1, new Object[] { "preProcessRecData res = ", localObject2, ", exception = ", localStringBuffer });
      localObject1 = paramJSONObject;
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = new JSONObject((String)localObject2);
        }
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("DynamicChannelDataModule", 1, "preProcessRecData e = ", localJSONException);
        return paramJSONObject;
      }
    }
  }
  
  public static pjn a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pay.a();
    if (localQQAppInterface != null) {
      return ((pks)localQQAppInterface.getManager(163)).a().a();
    }
    return null;
  }
  
  private void a(int paramInt, DynamicChannelDataModel paramDynamicChannelDataModel, boolean paramBoolean)
  {
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "saveDataModel, dataModel = ", paramDynamicChannelDataModel });
    if (paramDynamicChannelDataModel == null) {}
    do
    {
      return;
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      localObject = localConcurrentHashMap;
      if (localConcurrentHashMap == null)
      {
        localObject = new ConcurrentHashMap();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject);
      }
      ((ConcurrentHashMap)localObject).put(paramDynamicChannelDataModel.uniqueID, paramDynamicChannelDataModel);
    } while (!paramBoolean);
    Object localObject = new DynamicChannelDataModule.9(this, paramDynamicChannelDataModel);
    if (a())
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute((Runnable)localObject);
      return;
    }
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "saveDataModel failed, dataModel = ", paramDynamicChannelDataModel });
  }
  
  private void a(Entity paramEntity)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramEntity instanceof DynamicChannelDataModel))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(DynamicChannelDataModel.class.getSimpleName()))
      {
        paramEntity = (DynamicChannelDataModel)paramEntity;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(DynamicChannelDataModel.class, "uniqueID = ? and channelID = ?", new String[] { paramEntity.uniqueID, String.valueOf(paramEntity.channelID) });
      }
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove((Entity)localObject1);
    }
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "removeEntityIfExistsInDB entity = ", localObject1 });
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, List<DynamicChannelDataModel> paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new DynamicChannelDataModule.7(this, paramBoolean1, paramInt, paramBoolean2, paramBoolean3, paramList));
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) && (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown());
  }
  
  private boolean a(int paramInt, DynamicChannelDataModel paramDynamicChannelDataModel)
  {
    if (paramDynamicChannelDataModel == null) {
      return false;
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if ((localConcurrentHashMap != null) && (localConcurrentHashMap.containsKey(paramDynamicChannelDataModel.uniqueID))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private List<DynamicChannelDataModel> b(JSONArray paramJSONArray, boolean paramBoolean, int paramInt)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
    {
      QLog.d("DynamicChannelDataModule", 2, "handlePullUpLoadMore, dataList is null.");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    long l1 = 1L + a(paramInt);
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
            l2 = 1L + l1;
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
  
  private JSONObject b(JSONObject paramJSONObject, int paramInt)
  {
    long l = System.currentTimeMillis();
    QLog.d("DynamicChannelDataModule", 1, "preProcessReqData, begin.");
    Object localObject3 = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.a(paramInt));
    Object localObject1 = paramJSONObject;
    if (localObject3 != null)
    {
      localObject3 = ((syz)localObject3).a();
      localObject1 = paramJSONObject;
      if (localObject3 != null)
      {
        localObject3 = ((pip)localObject3).a("dp_environment_id");
        localObject1 = (piw)this.b.get(Integer.valueOf(paramInt));
        if (localObject1 == null) {
          break label213;
        }
      }
    }
    Object localObject2;
    label213:
    for (localObject1 = ((piw)localObject1).b;; localObject2 = "")
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localObject3 = (String)ProteusJsHelper.evaluateJs((String)localObject3, (String)localObject1, paramJSONObject.toString(), localStringBuffer);
      QLog.d("DynamicChannelDataModule", 2, new Object[] { "preProcessReqData res = ", localObject3, ", exception = ", localStringBuffer });
      localObject1 = paramJSONObject;
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = new JSONObject((String)localObject3);
        }
        QLog.d("DynamicChannelDataModule", 1, new Object[] { "preProcessReqData time cost = ", Long.valueOf(System.currentTimeMillis() - l) });
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.d("DynamicChannelDataModule", 2, "preProcessReqData e = ", localJSONException);
          localObject2 = paramJSONObject;
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    if (a())
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new DynamicChannelDataModule.10(this, paramInt));
      return;
    }
    QLog.d("DynamicChannelDataModule", 2, "clearDataModelList failed.");
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    String str = "";
    Object localObject = (piw)this.b.get(Integer.valueOf(paramInt1));
    if (localObject != null) {
      str = ((piw)localObject).a;
    }
    localObject = b(a(paramInt1, paramInt2), paramInt1);
    Bundle localBundle = JSONUtils.a((JSONObject)localObject);
    HashMap localHashMap = new HashMap();
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", BaseApplicationImpl.getApplication());
    localBundle = new Bundle();
    if ((paramInt2 == 1) || (paramInt2 == 2)) {}
    for (paramInt2 = 1;; paramInt2 = 0)
    {
      localBundle.putInt("isPullDownRefresh", paramInt2);
      new beze(JSONUtils.a((JSONObject)localObject, str), "POST", new pjp(this, paramInt1), 1000, localBundle).a(localHashMap);
      return;
    }
  }
  
  public long a(int paramInt)
  {
    long l1 = -1L;
    Object localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    long l2 = l1;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      l2 = l1;
      if (((Iterator)localObject).hasNext())
      {
        DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)((Iterator)localObject).next();
        if (localDynamicChannelDataModel.recommendSeq <= l1) {
          break label87;
        }
        l1 = localDynamicChannelDataModel.recommendSeq;
      }
    }
    label87:
    for (;;)
    {
      break;
      return l2;
    }
  }
  
  public List<DynamicChannelDataModel> a(int paramInt)
  {
    Object localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if ((localObject == null) || (((ConcurrentHashMap)localObject).size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(((ConcurrentHashMap)localObject).size());
    localObject = ((ConcurrentHashMap)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      DynamicChannelDataModel localDynamicChannelDataModel = (DynamicChannelDataModel)((Iterator)localObject).next();
      if (localDynamicChannelDataModel != null) {
        localArrayList.add(localDynamicChannelDataModel);
      }
    }
    Collections.sort(localArrayList, new pjq(this));
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdownNow();
    }
  }
  
  public void a(int paramInt)
  {
    if (a())
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new DynamicChannelDataModule.3(this, paramInt));
      return;
    }
    QLog.d("DynamicChannelDataModule", 2, "pullDownRefresh failed.");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "loadDataFromDB, channelID = ", Integer.valueOf(paramInt1), ", count = ", Integer.valueOf(paramInt2) });
    Object localObject = a(paramInt1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new DynamicChannelDataModule.1(this, paramInt1, (List)localObject));
      return;
    }
    localObject = new DynamicChannelDataModule.2(this, paramInt1, paramInt2);
    if (a())
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute((Runnable)localObject);
      return;
    }
    QLog.d("DynamicChannelDataModule", 2, "loadDataFromDB failed, executor is not available.");
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject = rgp.a(a(paramInt1), new pjo(this, paramLong));
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      a(false, paramInt1, true, true, (List)localObject);
      return;
    }
    localObject = new DynamicChannelDataModule.5(this, paramInt1, paramLong, paramInt2);
    if (a())
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute((Runnable)localObject);
      return;
    }
    QLog.d("DynamicChannelDataModule", 2, "pullUpLoadMore failed.");
  }
  
  public void a(int paramInt, piw parampiw)
  {
    if ((paramInt == -1) || (parampiw == null))
    {
      QLog.d("DynamicChannelDataModule", 2, "channelID of config is not valid.");
      return;
    }
    this.b.put(Integer.valueOf(paramInt), parampiw);
  }
  
  /* Error */
  public boolean a(Entity paramEntity)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokevirtual 613	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   8: sipush 1000
    //   11: if_icmpne +34 -> 45
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 615	pjn:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   19: aload_0
    //   20: getfield 26	pjn:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: aload_1
    //   24: invokevirtual 618	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   27: aload_1
    //   28: invokevirtual 613	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   31: istore_2
    //   32: iload_2
    //   33: sipush 1001
    //   36: if_icmpne +5 -> 41
    //   39: iconst_1
    //   40: istore_3
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_3
    //   44: ireturn
    //   45: aload_1
    //   46: invokevirtual 613	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   49: sipush 1001
    //   52: if_icmpeq +13 -> 65
    //   55: aload_1
    //   56: invokevirtual 613	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   59: sipush 1002
    //   62: if_icmpne -21 -> 41
    //   65: aload_0
    //   66: getfield 26	pjn:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   69: aload_1
    //   70: invokevirtual 621	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   73: istore_3
    //   74: goto -33 -> 41
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	pjn
    //   0	82	1	paramEntity	Entity
    //   31	6	2	i	int
    //   1	73	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	32	77	finally
    //   45	55	77	finally
    //   55	65	77	finally
    //   65	74	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pjn
 * JD-Core Version:    0.7.0.1
 */