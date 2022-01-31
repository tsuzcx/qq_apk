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

public class owd
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ConcurrentHashMap<Integer, List<owf>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
  private ConcurrentHashMap<Integer, List<ovj>> b = new ConcurrentHashMap();
  
  public owd(Handler paramHandler)
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
        str = ors.f();
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        localJSONObject.put("imei", str);
        localJSONObject.put("platform", "Android");
        localJSONObject.put("qqVersionID", "8.3.3");
        localObject = (QQAppInterface)ors.a();
        str = ((QQAppInterface)localObject).getAccount();
        localObject = ((TicketManager)((QQAppInterface)localObject).getManager(2)).getSkey(str);
        localJSONObject.put("uin", str);
        if (localObject != null) {
          continue;
        }
        str = "";
        localJSONObject.put("token", str);
        localJSONObject.put("cookieString", bjxj.a("readinjoy_dynamic_channel_header_cookie_" + paramInt, ""));
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
      str = qzi.a((String)localObject);
    }
  }
  
  private JSONObject a(JSONObject paramJSONObject, int paramInt, ovj paramovj)
  {
    long l = System.currentTimeMillis();
    QLog.d("DynamicChannelHeaderModule", 1, "preProcessReqData, begin.");
    Object localObject2 = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.a(paramInt));
    Object localObject1 = paramJSONObject;
    if (localObject2 != null)
    {
      localObject2 = ((sfq)localObject2).a();
      localObject1 = paramJSONObject;
      if (localObject2 != null)
      {
        localObject1 = ((ovb)localObject2).a("dp_environment_id");
        localObject2 = paramovj.d;
        paramovj = new StringBuffer();
        localObject2 = (String)ProteusJsHelper.evaluateJs((String)localObject1, (String)localObject2, paramJSONObject.toString(), paramovj);
        QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "preProcessReqData res = ", localObject2, ", exception = ", paramovj });
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
    catch (JSONException paramovj)
    {
      for (;;)
      {
        QLog.d("DynamicChannelHeaderModule", 2, "preProcessReqData e = ", paramovj);
        localObject1 = paramJSONObject;
      }
    }
  }
  
  public static owd a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ors.a();
    if (localQQAppInterface != null) {
      return ((oxd)localQQAppInterface.getManager(163)).a().a();
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, ovj paramovj)
  {
    JSONObject localJSONObject = a(a(paramInt1), paramInt1, paramovj);
    Bundle localBundle = JSONUtils.a(localJSONObject);
    HashMap localHashMap = new HashMap();
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", BaseApplicationImpl.getApplication());
    localBundle = new Bundle();
    localBundle.putInt("insert_index", paramInt2);
    new bcgp(JSONUtils.a(localJSONObject, paramovj.c), "POST", new owe(this, paramInt1, paramovj), 1000, localBundle).a(localHashMap);
  }
  
  private void a(int paramInt, JSONObject paramJSONObject, Bundle paramBundle, ovj paramovj)
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
      paramJSONObject = b(paramJSONObject, paramInt, paramovj);
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
      paramovj = new ArrayList();
      if ((localObject == null) || (paramJSONObject == null)) {
        break;
      }
      localObject = ((JSONObject)localObject).optString("cookieString");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        bjxj.a("readinjoy_dynamic_channel_header_cookie_" + paramInt, localObject);
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
            owf localowf = new owf();
            localowf.jdField_a_of_type_JavaLangString = ((String)localObject);
            localowf.b = paramBundle.toString();
            localowf.jdField_a_of_type_Int = i;
            paramovj.add(localowf);
            QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "handleRequest [", Integer.valueOf(j), "] = ", localowf });
          }
        }
        j += 1;
      }
    } while (paramovj.size() <= 0);
    b(paramInt, paramovj);
    a(paramInt, true, a(paramInt), i);
    return;
    QLog.d("DynamicChannelHeaderModule", 2, "handleRequest commonInfo or dataList is null.");
    a(paramInt, false, null, 0);
  }
  
  private void a(int paramInt, owf paramowf)
  {
    if (paramowf == null) {
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
          owf localowf = (owf)((List)localObject).get(paramInt);
          if (localowf.jdField_a_of_type_Int > paramowf.jdField_a_of_type_Int)
          {
            ((List)localObject).add(paramInt, paramowf);
            QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "putHeaderDataModel, i = ", Integer.valueOf(paramInt), "dataModel = ", localowf });
            return;
          }
          paramInt += 1;
        }
      }
      ((List)localObject).add(paramowf);
      return;
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean, List<owf> paramList, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new DynamicChannelHeaderModule.3(this, paramInt1, paramBoolean, paramList, paramInt2));
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) && (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown());
  }
  
  private JSONObject b(JSONObject paramJSONObject, int paramInt, ovj paramovj)
  {
    Object localObject2 = ReadInJoyDynamicChannelBaseFragment.a(ReadInJoyDynamicChannelBaseFragment.a(paramInt));
    Object localObject1 = paramJSONObject;
    if (localObject2 != null)
    {
      localObject2 = ((sfq)localObject2).a();
      localObject1 = paramJSONObject;
      if (localObject2 != null)
      {
        localObject1 = ((ovb)localObject2).a("dp_environment_id");
        localObject2 = paramovj.e;
        paramovj = new StringBuffer();
        localObject2 = (String)ProteusJsHelper.evaluateJs((String)localObject1, (String)localObject2, paramJSONObject.toString(), paramovj);
        QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "preProcessRecData res = ", localObject2, ", exception = ", paramovj });
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
    catch (JSONException paramovj)
    {
      QLog.d("DynamicChannelHeaderModule", 2, "preProcessRecData e = ", paramovj);
    }
    return paramJSONObject;
  }
  
  private void b(int paramInt, List<owf> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramInt, (owf)paramList.next());
      }
    }
  }
  
  public List<owf> a(int paramInt)
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
        ovj localovj = (ovj)localList.get(i);
        if ((!TextUtils.isEmpty(localovj.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localovj.b)))
        {
          owf localowf = new owf();
          localowf.jdField_a_of_type_JavaLangString = localovj.jdField_a_of_type_JavaLangString;
          localowf.b = localovj.b;
          localowf.jdField_a_of_type_Int = i;
          localArrayList.add(localowf);
        }
        i += 1;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localArrayList);
    }
  }
  
  public void a(int paramInt, List<ovj> paramList)
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
        ovj localovj = (ovj)localList.get(i);
        if ((!TextUtils.isEmpty(localovj.c)) && (a())) {
          this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new DynamicChannelHeaderModule.1(this, paramInt, i, localovj));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     owd
 * JD-Core Version:    0.7.0.1
 */