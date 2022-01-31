import android.net.Uri;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.qnreading.PreLoader.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class pxc
{
  private static String jdField_a_of_type_JavaLangString = "PreLoader";
  private static boolean c = true;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean d;
  private boolean e;
  
  public static pxc a()
  {
    return pxd.a();
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.proteusItemsData != null) {}
    try
    {
      paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.proteusItemsData).optString("article_jump_url");
      if ((!TextUtils.isEmpty(paramBaseArticleInfo)) && (paramBaseArticleInfo.startsWith("mqqapi://readinjoy/open?src_type=internal&target=4")))
      {
        paramBaseArticleInfo = bhos.a(paramBaseArticleInfo);
        String str = (String)paramBaseArticleInfo.get("appSchema");
        if (("com.tencent.reading".equals(paramBaseArticleInfo.get("appPackageName"))) && (str != null))
        {
          paramBaseArticleInfo = (String)bhos.a(Uri.decode(str)).get("rowkey");
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramBaseArticleInfo))
          {
            this.jdField_a_of_type_JavaUtilSet.add(paramBaseArticleInfo);
            QLog.d(jdField_a_of_type_JavaLangString, 1, "searchKBArticleId cache: " + paramBaseArticleInfo);
          }
        }
      }
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramBaseArticleInfo, new Object[] { "" });
    }
  }
  
  private void a(Set<String> paramSet)
  {
    ThreadManager.executeOnNetWorkThread(new PreLoader.1(this, paramSet));
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.getInt("ret") == 0)
        {
          paramString = paramString.getJSONArray("fullnews");
          int i = 0;
          while (i < paramString.length())
          {
            JSONObject localJSONObject = (JSONObject)paramString.get(i);
            String str = localJSONObject.getString("id");
            this.jdField_a_of_type_JavaUtilMap.put(str, Uri.encode(localJSONObject.toString()));
            this.jdField_a_of_type_JavaUtilSet.remove(str);
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, paramString, new Object[] { "" });
      }
    }
  }
  
  private boolean a()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "isNeedPreload isNeedCheckPreload: " + this.b + " isConfigNeedPreload: " + this.jdField_a_of_type_Boolean + " isInstalledKB:" + this.d);
    return (this.b) && (this.jdField_a_of_type_Boolean) && (this.d);
  }
  
  private void c()
  {
    boolean bool = true;
    if (this.e) {}
    AladdinConfig localAladdinConfig;
    do
    {
      return;
      localAladdinConfig = Aladdin.getConfig(209);
    } while (localAladdinConfig == null);
    if (localAladdinConfig.getIntegerFromString("is_preload_open", 0) == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!c) {
        break;
      }
      this.d = bdem.a(BaseApplicationImpl.getApplication(), "com.tencent.reading");
      c = false;
      return;
      bool = false;
    }
  }
  
  public String a(String paramString)
  {
    if (!a()) {}
    String str;
    do
    {
      return paramString;
      str = (String)bhos.a(paramString).get("rowkey");
      str = (String)this.jdField_a_of_type_JavaUtilMap.get(str);
    } while (TextUtils.isEmpty(str));
    paramString = paramString + "&item=" + str;
    QLog.e(jdField_a_of_type_JavaLangString, 1, "item=" + str.length());
    return paramString;
  }
  
  public void a()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onCreate");
    this.b = true;
    c();
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    if (!a()) {
      return;
    }
    b(owy.a().a(Integer.valueOf(paramInt), paramList));
  }
  
  public void a(List<ArticleInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList);
    b(localArrayList);
  }
  
  public void b()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onDestroy");
    this.b = false;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void b(List<BaseArticleInfo> paramList)
  {
    if (!a()) {}
    do
    {
      return;
      if (paramList == null)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "startRequest articleInfos == null");
        return;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "startRequest");
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((BaseArticleInfo)paramList.next());
      }
    } while (this.jdField_a_of_type_JavaUtilSet.size() <= 0);
    a(this.jdField_a_of_type_JavaUtilSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pxc
 * JD-Core Version:    0.7.0.1
 */