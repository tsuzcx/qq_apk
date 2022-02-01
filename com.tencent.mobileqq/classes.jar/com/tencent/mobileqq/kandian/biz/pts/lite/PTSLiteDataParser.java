package com.tencent.mobileqq.kandian.biz.pts.lite;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.pts.data.PTSLiteDataFactory;
import com.tencent.mobileqq.kandian.biz.pts.data.PTSLiteDataFactory.Companion;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.PTSParcelableUtil;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PTSLiteDataParser
{
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.i("PTSLiteDataParser", 1, "[preHandlePtsLiteData], articleInfo is null or proteusItemsData is null.");
      return;
    }
    if (!PTSLiteSwitchManager.a().a()) {
      return;
    }
    if (PTSLiteSwitchManager.a().b()) {
      d(paramAbsBaseArticleInfo);
    }
    PTSLiteDataFactory.a.a(paramAbsBaseArticleInfo);
    if (paramAbsBaseArticleInfo.proteusItemsData == null)
    {
      QLog.i("PTSLiteDataParser", 1, "[preHandlePtsLiteData] proteusItemsData is null.");
      return;
    }
    try
    {
      localObject = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData);
      String str = ((JSONObject)localObject).optString("pts_page_name");
      if (TextUtils.isEmpty(str))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[preHandlePtsLiteData], pageName is empty, pageName = ");
        localStringBuilder.append(str);
        localStringBuilder.append(", innerUniqueID = ");
        localStringBuilder.append(paramAbsBaseArticleInfo.innerUniqueID);
        localStringBuilder.append(", json = ");
        localStringBuilder.append(((JSONObject)localObject).toString());
        QLog.i("PTSLiteDataParser", 1, localStringBuilder.toString());
        return;
      }
      paramAbsBaseArticleInfo.ptsLitePageName = str;
      c(paramAbsBaseArticleInfo, (JSONObject)localObject);
      return;
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[preHandlePtsLiteData] error, e = ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo);
      QLog.e("PTSLiteDataParser", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.proteusItemsData != null))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[updateJsonDataPtsRijArticle], key = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", value = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", title = ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mTitle);
      QLog.i("PTSLiteDataParser", 1, ((StringBuilder)localObject).toString());
      try
      {
        localObject = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData);
        if (((JSONObject)localObject).optJSONObject("$RIJArticle") != null) {
          ((JSONObject)localObject).optJSONObject("$RIJArticle").put(paramString1, paramString2);
        }
        c(paramAbsBaseArticleInfo, (JSONObject)localObject);
        return;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramString1 = new StringBuilder();
        paramString1.append("[updateJsonDataPtsRijArticle] error, e = ");
        paramString1.append(paramAbsBaseArticleInfo);
        QLog.e("PTSLiteDataParser", 1, paramString1.toString());
      }
    }
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        b(paramAbsBaseArticleInfo, localJSONObject1);
        if (paramAbsBaseArticleInfo.mSubArticleList != null)
        {
          JSONArray localJSONArray = new JSONArray();
          paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubArticleList.iterator();
          while (paramAbsBaseArticleInfo.hasNext())
          {
            AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.next();
            JSONObject localJSONObject2 = new JSONObject();
            b(localAbsBaseArticleInfo, localJSONObject2);
            localJSONArray.put(localJSONObject2);
          }
          localJSONObject1.put("subArticles", localJSONArray);
        }
        paramJSONObject.put("$RIJArticle", localJSONObject1);
        return;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("[addRIJArticleJson] error, e = ");
        paramJSONObject.append(paramAbsBaseArticleInfo);
        QLog.e("PTSLiteDataParser", 1, paramJSONObject.toString());
      }
    }
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.proteusItemsData == null) {
        return;
      }
      try
      {
        c(paramAbsBaseArticleInfo, new JSONObject(paramAbsBaseArticleInfo.proteusItemsData));
        return;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[refreshArticleInfo] e = ");
        localStringBuilder.append(paramAbsBaseArticleInfo);
        QLog.e("PTSLiteDataParser", 1, localStringBuilder.toString());
      }
    }
  }
  
  private static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        paramJSONObject.put("rowKey", paramAbsBaseArticleInfo.innerUniqueID);
        Object localObject = RIJQQAppInterfaceUtil.a();
        if (localObject != null)
        {
          localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
          if (localObject != null)
          {
            if (!((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().a(paramAbsBaseArticleInfo.mArticleID)) {
              break label96;
            }
            paramAbsBaseArticleInfo = "1";
            paramJSONObject.put("isRead", paramAbsBaseArticleInfo);
            return;
          }
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("[addRIJArticleJsonImp], e = ");
        paramJSONObject.append(paramAbsBaseArticleInfo);
        QLog.e("PTSLiteDataParser", 1, paramJSONObject.toString());
      }
      return;
      label96:
      paramAbsBaseArticleInfo = "0";
    }
  }
  
  public static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    Object localObject = RIJQQAppInterfaceUtil.a();
    if (localObject != null)
    {
      localObject = (ReadInJoyLogicManager)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject != null) {
        ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
      }
    }
    a(paramAbsBaseArticleInfo, "isRead", "1");
  }
  
  private static void c(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo.innerUniqueID))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pts_page_");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      paramAbsBaseArticleInfo.innerUniqueID = ((StringBuilder)localObject).toString();
      QLog.i("PTSLiteDataParser", 1, "[updatePtsItemData], innerUniqueId is null.");
    }
    Object localObject = paramAbsBaseArticleInfo.ptsLitePageName;
    String str1 = paramAbsBaseArticleInfo.innerUniqueID;
    String str2 = PTSStyleManager.a().a("default_feeds", (String)localObject);
    a(paramAbsBaseArticleInfo, paramJSONObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updatePtsItemData], json = ");
    localStringBuilder.append(paramJSONObject.toString());
    QLog.i("PTSLiteDataParser", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(paramJSONObject.toString())) && (!TextUtils.isEmpty(str2)))
    {
      paramAbsBaseArticleInfo.ptsItemData = new PTSItemData.Builder().withPageName((String)localObject).withItemID(str1).withJsonData(paramJSONObject.toString()).withFrameTreeJson(str2).build();
      paramAbsBaseArticleInfo.ptsItemDataBytes = PTSParcelableUtil.a(paramAbsBaseArticleInfo.ptsItemData);
      if (paramAbsBaseArticleInfo.ptsComposer != null) {
        paramAbsBaseArticleInfo.ptsComposer.setData(paramJSONObject.toString());
      }
      paramAbsBaseArticleInfo.proteusItemsData = paramJSONObject.toString();
    }
    else
    {
      QLog.i("PTSLiteDataParser", 1, "[updatePtsItemData] failed, something is null.");
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updatePtsItemData], pageName = ");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", itemId = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", json = ");
      localStringBuilder.append(paramJSONObject.toString());
      QLog.i("PTSLiteDataParser", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(str2)) {
      QLog.i("PTSLiteDataParser", 1, "[updatePtsItemData], frameTreeJson is empty.");
    }
    paramJSONObject = RIJQQAppInterfaceUtil.a();
    if (paramJSONObject != null)
    {
      paramJSONObject = (ReadInJoyLogicManager)paramJSONObject.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (paramJSONObject != null) {
        paramJSONObject.getReadInJoyLogicEngine().b(paramAbsBaseArticleInfo);
      }
    }
  }
  
  private static void d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.proteusItemsData)) {
        return;
      }
      try
      {
        localObject = new JSONObject(paramAbsBaseArticleInfo.proteusItemsData);
        if (TextUtils.equals(((JSONObject)localObject).optString("style_ID"), "ReadInjoy_daily_triple_img_cell")) {
          ((JSONObject)localObject).put("pts_page_name", "daily_triple_img_card");
        }
        paramAbsBaseArticleInfo.proteusItemsData = ((JSONObject)localObject).toString();
        return;
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[convertDailyTripleData] error, e = ");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo);
        QLog.e("PTSLiteDataParser", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteDataParser
 * JD-Core Version:    0.7.0.1
 */