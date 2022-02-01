package com.tencent.mobileqq.kandian.repo.daily;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
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

public class PreLoader
{
  private static String jdField_a_of_type_JavaLangString = "PreLoader";
  private static boolean b = true;
  private Map<String, String> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private boolean jdField_a_of_type_Boolean;
  private boolean c;
  
  public static PreLoader a()
  {
    return PreLoader.Holder.a();
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.proteusItemsData != null) {
      try
      {
        paramAbsBaseArticleInfo = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData).optString("article_jump_url");
        if ((!TextUtils.isEmpty(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.startsWith("mqqapi://readinjoy/open?src_type=internal&target=4")))
        {
          paramAbsBaseArticleInfo = URLUtil.a(paramAbsBaseArticleInfo);
          String str = (String)paramAbsBaseArticleInfo.get("appSchema");
          if (("com.tencent.reading".equals(paramAbsBaseArticleInfo.get("appPackageName"))) && (str != null))
          {
            paramAbsBaseArticleInfo = (String)URLUtil.a(Uri.decode(str)).get("rowkey");
            if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramAbsBaseArticleInfo))
            {
              this.jdField_a_of_type_JavaUtilSet.add(paramAbsBaseArticleInfo);
              str = jdField_a_of_type_JavaLangString;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("searchKBArticleId cache: ");
              localStringBuilder.append(paramAbsBaseArticleInfo);
              QLog.d(str, 1, localStringBuilder.toString());
              return;
            }
          }
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, paramAbsBaseArticleInfo, new Object[] { "" });
      }
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
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isNeedPreload isNeedCheckPreload: ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" isConfigNeedPreload: ");
    localStringBuilder.append(PreLoaderProxy.a.a());
    localStringBuilder.append(" isInstalledKB:");
    localStringBuilder.append(this.c);
    QLog.d(str, 1, localStringBuilder.toString());
    return (this.jdField_a_of_type_Boolean) && (PreLoaderProxy.a.a()) && (this.c);
  }
  
  private void c()
  {
    if (PreLoaderProxy.a.b()) {
      return;
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(209);
    if (localAladdinConfig != null)
    {
      PreLoaderProxy localPreLoaderProxy = PreLoaderProxy.a;
      int i = localAladdinConfig.getIntegerFromString("is_preload_open", 0);
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localPreLoaderProxy.a(bool);
      if (b)
      {
        this.c = PackageUtil.a(BaseApplicationImpl.getApplication(), "com.tencent.reading");
        b = false;
      }
    }
  }
  
  public String a(String paramString)
  {
    if (!a()) {
      return paramString;
    }
    Object localObject = (String)URLUtil.a(paramString).get("rowkey");
    String str = (String)this.jdField_a_of_type_JavaUtilMap.get(localObject);
    localObject = paramString;
    if (!TextUtils.isEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&item=");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
      paramString = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("item=");
      localStringBuilder.append(str.length());
      QLog.e(paramString, 1, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public void a()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onCreate");
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    if (!a()) {
      return;
    }
    b(ReadInJoyLogicEngine.a().a(Integer.valueOf(paramInt), paramList));
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
  }
  
  public void b(List<AbsBaseArticleInfo> paramList)
  {
    if (!a()) {
      return;
    }
    if (paramList == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "startRequest articleInfos == null");
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "startRequest");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((AbsBaseArticleInfo)paramList.next());
    }
    if (this.jdField_a_of_type_JavaUtilSet.size() > 0) {
      a(this.jdField_a_of_type_JavaUtilSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.daily.PreLoader
 * JD-Core Version:    0.7.0.1
 */