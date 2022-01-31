import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager.1;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager.2;
import com.tencent.mobileqq.ac.ArticleComment.GetRecommendPubAccountRequest;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nop
{
  private static nop jdField_a_of_type_Nop;
  private final int jdField_a_of_type_Int = 8;
  private final long jdField_a_of_type_Long = 86400000L;
  private final String jdField_a_of_type_JavaLangString = nop.class.getSimpleName();
  private ArrayList<not> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, nos> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private final long jdField_b_of_type_Long = 3600000L;
  private final String jdField_b_of_type_JavaLangString = "recommend_title";
  private ArrayList<nos> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private final long jdField_c_of_type_Long = 2592000000L;
  private final String jdField_c_of_type_JavaLangString = "recommend_cache_time";
  private long jdField_d_of_type_Long;
  private final String jdField_d_of_type_JavaLangString = "recommend_fetch_time";
  private long jdField_e_of_type_Long;
  private final String jdField_e_of_type_JavaLangString = "recommend_content_list";
  private final String f = "recommend_is_forbidden";
  private final String g = "search_history_list";
  private String h;
  
  private ArrayList<not> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 8) {
      return (ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone();
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      localArrayList.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
      i += 1;
    }
    return (ArrayList)localArrayList.clone();
  }
  
  private ArrayList<not> a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      nos localnos = (nos)localIterator.next();
      paramQQAppInterface.add(new not(this, localnos.jdField_a_of_type_JavaLangString, localnos.jdField_b_of_type_JavaLangString, localnos.jdField_a_of_type_Boolean));
    }
    return paramQQAppInterface;
  }
  
  public static nop a()
  {
    if (jdField_a_of_type_Nop == null) {}
    try
    {
      jdField_a_of_type_Nop = new nop();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_Nop.jdField_a_of_type_JavaLangString, 2, "newInstance!");
      }
      return jdField_a_of_type_Nop;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, nor paramnor)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getRecommendListFromLocal->mRecommendIsForbidden:" + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      paramnor.a(new ArrayList(), null, true);
      return;
    }
    if (b(paramQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getRecommendListFromLocal->使用推荐内容缓存!");
      }
      paramnor.a(a(), this.h, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getRecommendListFromLocal->使用搜索历史!");
    }
    paramnor.a(a(paramQQAppInterface), null, false);
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a(paramQQAppInterface);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = false;
    if (l - this.jdField_e_of_type_Long > 3600000L) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkShouldFetchData->now:" + l + ", fetchTime:" + this.jdField_e_of_type_Long + ", result:" + bool);
    }
    return bool;
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getString("public_account_search_recommend", null);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "loadRecommendListFromLocal->json:" + paramQQAppInterface);
      }
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        try
        {
          paramQQAppInterface = sgj.a(paramQQAppInterface);
          if (paramQQAppInterface != null)
          {
            this.h = paramQQAppInterface.getString("recommend_title");
            this.jdField_d_of_type_Long = paramQQAppInterface.getLong("recommend_cache_time");
            this.jdField_e_of_type_Long = paramQQAppInterface.getLong("recommend_fetch_time");
            this.jdField_b_of_type_Boolean = paramQQAppInterface.getBoolean("recommend_is_forbidden");
            paramQQAppInterface = paramQQAppInterface.getJSONArray("recommend_content_list");
            this.jdField_a_of_type_JavaUtilArrayList.clear();
            int i = 0;
            while (i < paramQQAppInterface.length())
            {
              Object localObject = (JSONObject)paramQQAppInterface.get(i);
              localObject = new not(this, ((JSONObject)localObject).optString("uin"), ((JSONObject)localObject).optString("name"), ((JSONObject)localObject).optBoolean("isPA", true));
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
              i += 1;
            }
          }
          return;
        }
        catch (JSONException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "loadRecommendListFromLocal->error:" + paramQQAppInterface);
          }
        }
      }
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, nor paramnor)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sendGetPublicAccountSearchRecommendRequest->begin!");
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication().getApplicationContext(), nou.class);
    localNewIntent.putExtra("cmd", "PubAccountArticleCenter.GetRecommendPubAccount");
    ArticleComment.GetRecommendPubAccountRequest localGetRecommendPubAccountRequest = new ArticleComment.GetRecommendPubAccountRequest();
    localGetRecommendPubAccountRequest.version.set(sgj.a());
    localGetRecommendPubAccountRequest.cuin.set(Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    localGetRecommendPubAccountRequest.count.set(8);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sendGetPublicAccountSearchRecommendRequset->versionInfo:" + localGetRecommendPubAccountRequest.version.get() + ", cuin:" + localGetRecommendPubAccountRequest.cuin.get() + ", count:" + localGetRecommendPubAccountRequest.count.get());
    }
    localNewIntent.putExtra("data", localGetRecommendPubAccountRequest.toByteArray());
    localNewIntent.setObserver(new noq(this, localNewIntent, paramQQAppInterface, paramnor));
    this.jdField_e_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    paramQQAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "sendGetPublicAccountSearchRecommendRequest->send request, time:" + this.jdField_e_of_type_Long);
    }
  }
  
  private boolean b(QQAppInterface paramQQAppInterface)
  {
    if (!this.jdField_a_of_type_Boolean) {
      a(paramQQAppInterface);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (l - this.jdField_d_of_type_Long < 86400000L)
    {
      bool1 = bool2;
      if (i > 0) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkRecommendCacheValid->now:" + l + ", cacheTime:" + this.jdField_d_of_type_Long + ", size:" + i + ", result:" + bool1);
    }
    return bool1;
  }
  
  private void c(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new PublicAccountSearchRecommendManager.1(this, paramQQAppInterface));
  }
  
  private void d(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getString("public_account_search_history", null);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "loadHistoryListFromLocal->json:" + paramQQAppInterface);
      }
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        try
        {
          paramQQAppInterface = sgj.a(paramQQAppInterface);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = paramQQAppInterface.getJSONArray("search_history_list");
            this.jdField_b_of_type_JavaUtilArrayList.clear();
            this.jdField_a_of_type_JavaUtilHashMap.clear();
            int i = 0;
            while (i < paramQQAppInterface.length())
            {
              Object localObject = (JSONObject)paramQQAppInterface.get(i);
              localObject = new nos(this, ((JSONObject)localObject).optString("uin"), ((JSONObject)localObject).optString("name"), ((JSONObject)localObject).optLong("time"), ((JSONObject)localObject).optBoolean("isPA", true));
              this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
              this.jdField_a_of_type_JavaUtilHashMap.put(((nos)localObject).jdField_a_of_type_JavaLangString, localObject);
              i += 1;
            }
          }
          return;
        }
        catch (JSONException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "loadHistoryListFromLocal->error:" + paramQQAppInterface);
          }
        }
      }
    }
  }
  
  private void e(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new PublicAccountSearchRecommendManager.2(this, paramQQAppInterface));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.h = "";
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "resetManager!");
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((!this.jdField_a_of_type_Boolean) && (paramQQAppInterface != null))
    {
      b(paramQQAppInterface);
      d(paramQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initFromLocalData!");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updatePublicAccountSearchHistoryItem->uin:" + paramString1 + ", name:" + paramString2 + ", isPublicAccount:" + paramBoolean + ", time:" + l);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
    {
      paramString1 = (nos)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      this.jdField_b_of_type_JavaUtilArrayList.remove(paramString1);
      this.jdField_b_of_type_JavaUtilArrayList.add(0, paramString1);
      paramString1.jdField_a_of_type_Long = l;
      paramString1.jdField_a_of_type_Boolean = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updatePublicAccountSearchHistoryItem update!");
      }
    }
    for (;;)
    {
      e(paramQQAppInterface);
      if (!QLog.isColorLevel()) {
        break;
      }
      paramQQAppInterface = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString1 = (nos)paramQQAppInterface.next();
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramString1.toString());
      }
      break;
      paramString2 = new nos(this, paramString1, paramString2, l, paramBoolean);
      this.jdField_b_of_type_JavaUtilArrayList.add(0, paramString2);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updatePublicAccountSearchHistoryItem insert!");
      }
      int i = this.jdField_b_of_type_JavaUtilArrayList.size();
      if (i > 8)
      {
        paramString1 = (nos)this.jdField_b_of_type_JavaUtilArrayList.get(i - 1);
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramString1);
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updatePublicAccountSearchHistoryItem remove lastItem!");
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, nor paramnor)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getRecommendList->isFromCreate:" + paramBoolean);
    }
    if (!paramBoolean)
    {
      paramnor.a(a(paramQQAppInterface), null, false);
      return;
    }
    if (a(paramQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getRecommendList->sendGetPublicAccountSearchRecommendRequest!");
      }
      b(paramQQAppInterface, paramnor);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "getRecommendList->getRecommendListFromLocal!");
    }
    a(paramQQAppInterface, paramnor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nop
 * JD-Core Version:    0.7.0.1
 */