import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoRepository.1;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoRepository.2;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class pgu
{
  private awgf jdField_a_of_type_Awgf;
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  private ConcurrentHashMap<String, ReadInJoyUserInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  public pgu(ExecutorService paramExecutorService, ReadInJoyUserInfoModule paramReadInJoyUserInfoModule, awgf paramawgf)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = paramReadInJoyUserInfoModule;
    this.jdField_a_of_type_Awgf = paramawgf;
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "saveReadInJoyUserInfoToDB, \n  userInfo = ", paramReadInJoyUserInfo });
    if (paramReadInJoyUserInfo != null) {
      ors.a("saveReadInJoyUserInfoToDB", new ReadInJoyUserInfoRepository.1(this, paramReadInJoyUserInfo), this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    }
  }
  
  public ReadInJoyUserInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ReadInJoyUserInfo localReadInJoyUserInfo = (ReadInJoyUserInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localReadInJoyUserInfo != null) && (!localReadInJoyUserInfo.requestFlag))
    {
      localReadInJoyUserInfo.requestFlag = true;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a(localArrayList, 1, 1, 0);
      }
    }
    QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "getReadInJoyUserInfoByUin, \n ", "userInfo = ", localReadInJoyUserInfo });
    return localReadInJoyUserInfo;
  }
  
  public List<ReadInJoyUserInfo> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    List localList;
    do
    {
      return null;
      localList = this.jdField_a_of_type_Awgf.a(ReadInJoyUserInfo.class, true, "uin = ?", new String[] { paramString }, null, null, null, "1");
    } while ((localList == null) || (localList.size() <= 0));
    QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "loadSingleReadInJoyUserInfoFromDB, userInfo = ", localList.get(0) });
    a(paramString, (ReadInJoyUserInfo)localList.get(0), false, true);
    return localList;
  }
  
  public void a()
  {
    QLog.d("ReadInJoyUserInfoRepository", 2, "resetRequestFlag.");
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyUserInfo)((Map.Entry)localIterator.next()).getValue()).requestFlag = false;
      }
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      ors.a("loadReadInJoyUserInfoFromDB", new ReadInJoyUserInfoRepository.2(this, paramInt), this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      QLog.d("ReadInJoyUserInfoRepository", 1, "loadReadInJoyUserInfoFromDB exception.");
      localRejectedExecutionException.printStackTrace();
    }
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      QLog.d("ReadInJoyUserInfoRepository", 2, "notifyCallback.");
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule == null);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a();
    if ((localObject != null) && (((ConcurrentHashMap)localObject).get(paramString) != null))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = (List)((ConcurrentHashMap)localObject).get(paramString);
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        pgr localpgr = (pgr)localIterator.next();
        if (localpgr != null)
        {
          localpgr.a(paramString, paramReadInJoyUserInfo);
          localArrayList.add(localpgr);
        }
      }
      if (localArrayList.size() > 0) {
        ((List)localObject).removeAll(localArrayList);
      }
    }
    for (;;)
    {
      paramReadInJoyUserInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.b();
      if (paramReadInJoyUserInfo == null) {
        break;
      }
      paramReadInJoyUserInfo.remove(paramString);
      return;
      QLog.d("ReadInJoyUserInfoRepository", 2, "notifyCallback tempList is null.");
      continue;
      QLog.d("ReadInJoyUserInfoRepository", 2, "notifyCallback callbackList is null.");
    }
  }
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramReadInJoyUserInfo == null)) {
      QLog.d("ReadInJoyUserInfoRepository", 2, "updateReadInJoyUserInfo failed, uin is null or empty, or userInfo is null");
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramReadInJoyUserInfo);
      QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "updateReadInJoyUserInfo, \n uin = ", paramString, Character.valueOf('\n'), "userInfo = ", paramReadInJoyUserInfo, Character.valueOf('\n'), "saveToDB = ", Boolean.valueOf(paramBoolean1), Character.valueOf('\n'), "notifyCallback = ", Boolean.valueOf(paramBoolean2) });
      if (paramBoolean2) {
        a(paramString, paramReadInJoyUserInfo);
      }
    } while (!paramBoolean1);
    a(paramReadInJoyUserInfo);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pgu
 * JD-Core Version:    0.7.0.1
 */