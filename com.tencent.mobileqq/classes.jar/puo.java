import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelHeaderModule.1;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelHeaderModule.3;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.JSONUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ProteusJsHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class puo
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ConcurrentHashMap<Integer, List<puq>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
  private ConcurrentHashMap<Integer, List<ptu>> b = new ConcurrentHashMap();
  
  public puo(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  private JSONObject a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        str = pkh.b();
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        localJSONObject.put("imei", str);
        localJSONObject.put("platform", "Android");
        localJSONObject.put("qqVersionID", "8.4.10");
        localObject = (QQAppInterface)pkh.a();
        str = ((QQAppInterface)localObject).getAccount();
        localObject = ((TicketManager)((QQAppInterface)localObject).getManager(2)).getSkey(str);
        localJSONObject.put("uin", str);
        if (localObject != null) {
          continue;
        }
        str = "";
        localJSONObject.put("token", str);
        localJSONObject.put("cookieString", bmhv.a("readinjoy_dynamic_channel_header_cookie_" + paramInt, ""));
      }
      catch (JSONException localJSONException)
      {
        String str;
        Object localObject;
        QLog.d("DynamicChannelHeaderModule", 2, "makeRequestParams, e = ", localJSONException);
        continue;
      }
      QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "makeRequestParams params = ", localJSONObject });
      return localJSONObject;
      str = "";
      continue;
      str = sfq.a((String)localObject);
    }
  }
  
  private JSONObject a(JSONObject paramJSONObject, int paramInt, ptu paramptu)
  {
    long l = System.currentTimeMillis();
    QLog.d("DynamicChannelHeaderModule", 1, "preProcessReqData, begin.");
    Object localObject2 = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.a(paramInt));
    Object localObject1 = paramJSONObject;
    if (localObject2 != null)
    {
      localObject2 = ((tmh)localObject2).a();
      localObject1 = paramJSONObject;
      if (localObject2 != null)
      {
        localObject1 = ((ptm)localObject2).a("dp_environment_id");
        localObject2 = paramptu.d;
        paramptu = new StringBuffer();
        localObject2 = (String)ProteusJsHelper.evaluateJs((String)localObject1, (String)localObject2, paramJSONObject.toString(), paramptu);
        QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "preProcessReqData res = ", localObject2, ", exception = ", paramptu });
        localObject1 = paramJSONObject;
      }
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = new JSONObject((String)localObject2);
      }
      QLog.d("DynamicChannelHeaderModule", 1, new Object[] { "preProcessReqData time cost = ", Long.valueOf(System.currentTimeMillis() - l) });
      return localObject1;
    }
    catch (JSONException paramptu)
    {
      for (;;)
      {
        QLog.d("DynamicChannelHeaderModule", 2, "preProcessReqData e = ", paramptu);
        localObject1 = paramJSONObject;
      }
    }
  }
  
  public static puo a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pkh.a();
    if (localQQAppInterface != null) {
      return ((pvp)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a();
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, ptu paramptu)
  {
    JSONObject localJSONObject = a(a(paramInt1), paramInt1, paramptu);
    Bundle localBundle = JSONUtils.a(localJSONObject);
    HashMap localHashMap = new HashMap();
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", BaseApplicationImpl.getApplication());
    localBundle = new Bundle();
    localBundle.putInt("insert_index", paramInt2);
    new bghj(JSONUtils.a(localJSONObject, paramptu.c), "POST", new pup(this, paramInt1, paramptu), 1000, localBundle).a(localHashMap);
  }
  
  private void a(int paramInt, JSONObject paramJSONObject, Bundle paramBundle, ptu paramptu)
  {
    if (paramJSONObject == null)
    {
      QLog.d("DynamicChannelHeaderModule", 2, "handleRequest result is null");
      a(paramInt, false, null, 0);
    }
    int i;
    do
    {
      return;
      QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "result = ", paramJSONObject, ", requestParams = ", paramBundle });
      long l = System.currentTimeMillis();
      QLog.d("DynamicChannelHeaderModule", 1, "handleRequest, begin processRecData");
      paramJSONObject = b(paramJSONObject, paramInt, paramptu);
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
      Object localObject = paramJSONObject.optJSONObject("commonInfo");
      paramJSONObject = paramJSONObject.optJSONArray("dataList");
      paramptu = new ArrayList();
      if ((localObject == null) || (paramJSONObject == null)) {
        break;
      }
      localObject = ((JSONObject)localObject).optString("cookieString");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        bmhv.a("readinjoy_dynamic_channel_header_cookie_" + paramInt, localObject);
      }
      if (paramJSONObject.length() == 0)
      {
        QLog.d("DynamicChannelHeaderModule", 2, "handleRequest dataList is null.");
        a(paramInt, false, null, 0);
        return;
      }
      i = 0;
      if (paramBundle != null) {
        i = paramBundle.getInt("insert_index");
      }
      int j = 0;
      while (j < paramJSONObject.length())
      {
        paramBundle = paramJSONObject.optJSONObject(j);
        if (paramBundle != null)
        {
          localObject = paramBundle.optString("style_ID", "");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            puq localpuq = new puq();
            localpuq.jdField_a_of_type_JavaLangString = ((String)localObject);
            localpuq.b = paramBundle.toString();
            localpuq.jdField_a_of_type_Int = i;
            paramptu.add(localpuq);
            QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "handleRequest [", Integer.valueOf(j), "] = ", localpuq });
          }
        }
        j += 1;
      }
    } while (paramptu.size() <= 0);
    b(paramInt, paramptu);
    a(paramInt, true, a(paramInt), i);
    return;
    QLog.d("DynamicChannelHeaderModule", 2, "handleRequest commonInfo or dataList is null.");
    a(paramInt, false, null, 0);
  }
  
  private void a(int paramInt, puq parampuq)
  {
    if (parampuq == null) {
      return;
    }
    Object localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject);
    }
    for (;;)
    {
      if (((List)localObject).size() > 0)
      {
        paramInt = 0;
        while (paramInt < ((List)localObject).size())
        {
          puq localpuq = (puq)((List)localObject).get(paramInt);
          if (localpuq.jdField_a_of_type_Int > parampuq.jdField_a_of_type_Int)
          {
            ((List)localObject).add(paramInt, parampuq);
            QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "putHeaderDataModel, i = ", Integer.valueOf(paramInt), "dataModel = ", localpuq });
            return;
          }
          paramInt += 1;
        }
      }
      ((List)localObject).add(parampuq);
      return;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean, List<puq> paramList, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new DynamicChannelHeaderModule.3(this, paramInt1, paramBoolean, paramList, paramInt2));
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) && (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown());
  }
  
  private JSONObject b(JSONObject paramJSONObject, int paramInt, ptu paramptu)
  {
    Object localObject2 = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.a(paramInt));
    Object localObject1 = paramJSONObject;
    if (localObject2 != null)
    {
      localObject2 = ((tmh)localObject2).a();
      localObject1 = paramJSONObject;
      if (localObject2 != null)
      {
        localObject1 = ((ptm)localObject2).a("dp_environment_id");
        localObject2 = paramptu.e;
        paramptu = new StringBuffer();
        localObject2 = (String)ProteusJsHelper.evaluateJs((String)localObject1, (String)localObject2, paramJSONObject.toString(), paramptu);
        QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "preProcessRecData res = ", localObject2, ", exception = ", paramptu });
        localObject1 = paramJSONObject;
      }
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = new JSONObject((String)localObject2);
      }
      return localObject1;
    }
    catch (JSONException paramptu)
    {
      QLog.d("DynamicChannelHeaderModule", 2, "preProcessRecData e = ", paramptu);
    }
    return paramJSONObject;
  }
  
  private void b(int paramInt, List<puq> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramInt, (puq)paramList.next());
      }
    }
  }
  
  public List<puq> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if ((localList != null) && (localList.size() > 0)) {
      localArrayList.addAll(localList);
    }
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
    List localList = (List)this.b.get(Integer.valueOf(paramInt));
    if ((localList != null) && (localList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        ptu localptu = (ptu)localList.get(i);
        if ((!TextUtils.isEmpty(localptu.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localptu.b)))
        {
          puq localpuq = new puq();
          localpuq.jdField_a_of_type_JavaLangString = localptu.jdField_a_of_type_JavaLangString;
          localpuq.b = localptu.b;
          localpuq.jdField_a_of_type_Int = i;
          localArrayList.add(localpuq);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localArrayList);
    }
  }
  
  public void a(int paramInt, List<ptu> paramList)
  {
    if ((paramInt == -1) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.b.put(Integer.valueOf(paramInt), paramList);
  }
  
  public void b(int paramInt)
  {
    List localList = (List)this.b.get(Integer.valueOf(paramInt));
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        ptu localptu = (ptu)localList.get(i);
        if ((!TextUtils.isEmpty(localptu.c)) && (a())) {
          this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new DynamicChannelHeaderModule.1(this, paramInt, i, localptu));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puo
 * JD-Core Version:    0.7.0.1
 */