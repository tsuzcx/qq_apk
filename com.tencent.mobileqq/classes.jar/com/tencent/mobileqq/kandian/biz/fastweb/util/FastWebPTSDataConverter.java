package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.text.Html;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.fastweb.data.MiniAppData;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJBiuAndCommentAladdinUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleTopicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ModuleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.FastWebPTSConstans;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FastWebPTSDataConverter
{
  public static float a()
  {
    Object localObject = a();
    float f1;
    if (localObject != null) {
      try
      {
        localObject = ((JSONObject)localObject).getString(String.valueOf(4));
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          f1 = Float.valueOf((String)localObject).floatValue();
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTextBottomAdWeight error! msg=");
        localStringBuilder.append(localException);
        QLog.d("FastWebPTSDataConverter", 1, localStringBuilder.toString());
      }
    } else {
      f1 = -1.0F;
    }
    float f2 = f1;
    if (f1 == -1.0F) {
      f2 = 3.3F;
    }
    return f2;
  }
  
  public static float a(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 1, 2.0F);
  }
  
  private static float a(SparseArray<Float> paramSparseArray, int paramInt, float paramFloat)
  {
    Object localObject = paramSparseArray;
    if (paramSparseArray == null) {
      localObject = a();
    }
    float f = ((Float)((SparseArray)localObject).get(paramInt, Float.valueOf(-1.0F))).floatValue();
    paramSparseArray = new StringBuilder();
    paramSparseArray.append("getWeight! moduleType=");
    paramSparseArray.append(paramInt);
    paramSparseArray.append("  defaultWeight=");
    paramSparseArray.append(paramFloat);
    QLog.d("FastWebPTSDataConverter", 1, paramSparseArray.toString());
    if (-1.0F == f) {
      return paramFloat;
    }
    return f;
  }
  
  public static float a(BaseData paramBaseData, boolean paramBoolean)
  {
    if (paramBaseData == null) {
      return -1000.0F;
    }
    if (paramBaseData.jdField_b_of_type_Float <= 0.0F) {
      if (paramBoolean) {
        paramBaseData.jdField_b_of_type_Float = c(null);
      } else {
        paramBaseData.jdField_b_of_type_Float = a();
      }
    }
    return paramBaseData.jdField_b_of_type_Float;
  }
  
  public static SparseArray<Float> a()
  {
    localSparseArray = new SparseArray();
    try
    {
      JSONObject localJSONObject = a();
      Object localObject1;
      if (localJSONObject != null)
      {
        localObject1 = localJSONObject.keys();
        while (((Iterator)localObject1).hasNext())
        {
          String str = (String)((Iterator)localObject1).next();
          Object localObject2 = localJSONObject.getString(str);
          try
          {
            localSparseArray.append(Integer.valueOf(str).intValue(), Float.valueOf((String)localObject2));
          }
          catch (Exception localException2)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getModuleWeight error!! msg");
            ((StringBuilder)localObject2).append(localException2);
            QLog.d("FastWebPTSDataConverter", 1, ((StringBuilder)localObject2).toString());
          }
        }
      }
      return localSparseArray;
    }
    catch (Exception localException1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getModuleWeight error! msg");
      ((StringBuilder)localObject1).append(localException1);
      QLog.d("FastWebPTSDataConverter", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  public static TemplateBean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      if (a(paramAbsBaseArticleInfo))
      {
        paramAbsBaseArticleInfo = a(paramAbsBaseArticleInfo.mRecommendFollowInfos);
        return ProteusParser.getTemplateBean(TemplateFactory.a("native_article", true), paramAbsBaseArticleInfo);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildFollowWindowTemplateBean error! articleInfo=");
      localStringBuilder.append(paramAbsBaseArticleInfo);
      QLog.d("FastWebPTSDataConverter", 1, localStringBuilder.toString());
      return null;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildFollowWindowTemplateBean error! msg=");
      localStringBuilder.append(paramAbsBaseArticleInfo);
      QLog.d("FastWebPTSDataConverter", 1, localStringBuilder.toString());
    }
    return null;
  }
  
  public static ProteusItemData a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    boolean bool = RIJBiuAndCommentAladdinUtils.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createOperateAreaData | isCommentBiuMixStyle ");
    ((StringBuilder)localObject).append(bool);
    QLog.d("FastWebPTSDataConverter", 1, ((StringBuilder)localObject).toString());
    a(localJSONObject, paramFastWebArticleInfo, paramAbsBaseArticleInfo);
    localObject = (ModuleInfo)paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray.get(999);
    if (localObject != null) {
      a(localJSONObject, ((ModuleInfo)localObject).a);
    }
    return a(localJSONObject, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
  }
  
  public static ProteusItemData a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      localJSONObject.put("style_ID", "ReadInjoy_article_read_count_cell");
      localObject1 = localObject2;
      a(paramFastWebArticleInfo, localJSONObject);
      localObject1 = localObject2;
      paramAbsBaseArticleInfo = a(localJSONObject, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
      localObject1 = paramAbsBaseArticleInfo;
      paramAbsBaseArticleInfo.A = 1;
      localObject1 = paramAbsBaseArticleInfo;
      paramAbsBaseArticleInfo.jdField_b_of_type_Float = a(paramSparseArray);
      return paramAbsBaseArticleInfo;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramFastWebArticleInfo = new StringBuilder();
      paramFastWebArticleInfo.append("createReadCntData error! msg=");
      paramFastWebArticleInfo.append(paramAbsBaseArticleInfo);
      QLog.d("FastWebPTSDataConverter", 1, paramFastWebArticleInfo.toString());
    }
    return localObject1;
  }
  
  public static ProteusItemData a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, int paramInt3, SparseArray<Float> paramSparseArray)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    label194:
    label196:
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString1)) {
          break label196;
        }
        localObject1 = localObject2;
        paramString1 = FastWebVideoItemUtils.a(paramString2, paramString3, paramString4, paramString5);
        localObject1 = localObject2;
        FastWebVideoItemUtils.a(localJSONObject, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramString4, paramString5, paramInt3);
        localObject1 = localObject2;
        paramAbsBaseArticleInfo = a(localJSONObject, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
        localObject1 = paramAbsBaseArticleInfo;
        paramAbsBaseArticleInfo.A = 1;
        localObject1 = paramAbsBaseArticleInfo;
        paramAbsBaseArticleInfo.jdField_b_of_type_Float = a(paramSparseArray);
        localObject1 = paramAbsBaseArticleInfo;
        paramAbsBaseArticleInfo.z = 3;
        localObject1 = paramAbsBaseArticleInfo;
        if (!TextUtils.isEmpty(paramString2))
        {
          localObject1 = paramAbsBaseArticleInfo;
          if (!TextUtils.isEmpty(paramString5))
          {
            localObject1 = paramAbsBaseArticleInfo;
            if (!TextUtils.isEmpty(paramString3))
            {
              localObject1 = paramAbsBaseArticleInfo;
              paramFastWebArticleInfo = paramAbsBaseArticleInfo;
              if (!TextUtils.isEmpty(paramString4)) {
                break label194;
              }
            }
          }
        }
        localObject1 = paramAbsBaseArticleInfo;
        paramAbsBaseArticleInfo.g = false;
        return paramAbsBaseArticleInfo;
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        paramFastWebArticleInfo = new StringBuilder();
        paramFastWebArticleInfo.append("createArticleVideoData error! msg=");
        paramFastWebArticleInfo.append(paramAbsBaseArticleInfo);
        QLog.d("FastWebPTSDataConverter", 1, paramFastWebArticleInfo.toString());
        paramFastWebArticleInfo = (FastWebArticleInfo)localObject1;
      }
      return paramFastWebArticleInfo;
    }
  }
  
  static ProteusItemData a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, String paramString1, String paramString2, String paramString3, SparseArray<Float> paramSparseArray)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      boolean bool = FastWebImageItemUtils.a(localJSONObject, paramString2, paramString3, ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramString1, 4, null, true).toString());
      localObject1 = localObject2;
      paramAbsBaseArticleInfo = a(localJSONObject, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
      localObject1 = paramAbsBaseArticleInfo;
      paramAbsBaseArticleInfo.A = 1;
      localObject1 = paramAbsBaseArticleInfo;
      paramAbsBaseArticleInfo.jdField_b_of_type_Float = a(paramSparseArray);
      localObject1 = paramAbsBaseArticleInfo;
      paramAbsBaseArticleInfo.z = 2;
      localObject1 = paramAbsBaseArticleInfo;
      paramAbsBaseArticleInfo.g = bool;
      return paramAbsBaseArticleInfo;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramFastWebArticleInfo = new StringBuilder();
      paramFastWebArticleInfo.append("createArticleImageData error! msg=");
      paramFastWebArticleInfo.append(paramAbsBaseArticleInfo);
      QLog.d("FastWebPTSDataConverter", 1, paramFastWebArticleInfo.toString());
    }
    return localObject1;
  }
  
  public static ProteusItemData a(String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, SparseArray<Float> paramSparseArray)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = null;
    if (paramInt2 != 2) {
      if (paramInt2 != 3) {
        paramString = "ReadInjoy_article_text_cell";
      }
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      try
      {
        localJSONObject.put("style_ID", paramString);
        localObject1 = localObject2;
        localJSONObject.put("text_align", String.valueOf(paramInt1));
        localObject1 = localObject2;
        localJSONObject.put("id_attribute_text", paramCharSequence);
        localObject1 = localObject2;
        localJSONObject.put("attribute_text_size", Float.toString(FastWebPTSUtils.a()));
        localObject1 = localObject2;
        paramString = a(localJSONObject, null, null);
        localObject1 = paramString;
        paramString.jdField_b_of_type_Float = a(paramSparseArray);
        localObject1 = paramString;
        paramString.A = 1;
        localObject1 = paramString;
        paramString.z = 1;
        return paramString;
      }
      catch (Exception paramCharSequence)
      {
        label134:
        break label134;
      }
      paramString = new StringBuilder();
      paramString.append("createArticleTextData error! msg=");
      paramString.append(paramCharSequence);
      QLog.d("FastWebPTSDataConverter", 1, paramString.toString());
      return localObject1;
      paramString = "ReadInjoy_article_blockquote_cell";
      continue;
      paramString = "ReadInjoy_article_listitem_cell";
    }
  }
  
  public static ProteusItemData a(String paramString1, String paramString2, SparseArray<Float> paramSparseArray)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      localJSONObject.put("style_ID", "ReadInjoy_article_link_text_cell");
      localObject1 = localObject2;
      localJSONObject.put("id_attribute_text", Html.fromHtml(paramString1));
      localObject1 = localObject2;
      localJSONObject.put("jump_url", paramString2);
      localObject1 = localObject2;
      localJSONObject.put("attribute_text_size", FastWebPTSUtils.a());
      localObject1 = localObject2;
      paramString1 = a(localJSONObject, null, null);
      localObject1 = paramString1;
      paramString1.jdField_b_of_type_Float = a(paramSparseArray);
      localObject1 = paramString1;
      paramString1.A = 1;
      localObject1 = paramString1;
      paramString1.z = 1;
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("createArticleLinkData error! msg=");
      paramString2.append(paramString1);
      QLog.d("FastWebPTSDataConverter", 1, paramString2.toString());
    }
    return localObject1;
  }
  
  public static ProteusItemData a(JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ProteusItemData localProteusItemData = b(paramJSONObject, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
    a(localProteusItemData, paramJSONObject, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
    return localProteusItemData;
  }
  
  private static String a(int paramInt)
  {
    return FastWebPTSUtils.a(paramInt, HardCodeUtil.a(2131718311));
  }
  
  private static String a(long paramLong)
  {
    if (paramLong > 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131716361));
      localStringBuilder.append(ReadInJoyHelper.a(paramLong, 99990000L, "9999万+", ""));
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private static JSONObject a()
  {
    Object localObject = Aladdin.getConfig(242).getString("module_type_weight", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      localObject = new JSONObject((String)localObject);
    }
    catch (Exception localException)
    {
      label35:
      StringBuilder localStringBuilder;
      break label35;
    }
    localObject = null;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getAladdinWeightConfig! msg");
    localStringBuilder.append(localObject);
    QLog.d("FastWebPTSDataConverter", 1, localStringBuilder.toString());
    return localObject;
  }
  
  public static JSONObject a(RecommendFollowInfos paramRecommendFollowInfos)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("style_ID", "ReadInjoy_follow_pack_cell");
      int i = paramRecommendFollowInfos.b;
      if (i == 2) {
        localJSONObject.put("bgColor", "#00000000");
      } else {
        localJSONObject.put("bgColor", "#EEEEEE");
      }
      localObject = new JSONArray();
      a(paramRecommendFollowInfos, (JSONArray)localObject);
      localJSONObject.put("datas", localObject);
      return localJSONObject;
    }
    catch (Exception paramRecommendFollowInfos)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buildFollowWindowJSON error! msg=");
      ((StringBuilder)localObject).append(paramRecommendFollowInfos);
      QLog.d("FastWebPTSDataConverter", 1, ((StringBuilder)localObject).toString());
    }
    return localJSONObject;
  }
  
  private static JSONObject a(RecommendFollowInfos paramRecommendFollowInfos, RecommendFollowInfo paramRecommendFollowInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        int i = paramRecommendFollowInfos.b;
        if (i == 2) {
          localJSONObject.put("style_ID", "RIJ_video_feeds_follow_cell");
        } else {
          localJSONObject.put("style_ID", "RIJ_follow_cell");
        }
        localJSONObject.put("author_name", paramRecommendFollowInfo.nickName);
        localJSONObject.put("author_desc", paramRecommendFollowInfo.recommendReason);
        if (paramRecommendFollowInfo.isFollowed)
        {
          paramRecommendFollowInfos = "1";
          localJSONObject.put("selected_status", paramRecommendFollowInfos);
          localJSONObject.put("avatar_uin", String.valueOf(paramRecommendFollowInfo.uin));
          localJSONObject.put("card_position", paramInt);
          return localJSONObject;
        }
      }
      catch (Exception paramRecommendFollowInfos)
      {
        paramRecommendFollowInfo = new StringBuilder();
        paramRecommendFollowInfo.append("buildFollowCardInfo error! msg=");
        paramRecommendFollowInfo.append(paramRecommendFollowInfos);
        QLog.d("FastWebPTSDataConverter", 1, paramRecommendFollowInfo.toString());
        return localJSONObject;
      }
      paramRecommendFollowInfos = "0";
    }
  }
  
  private static JSONObject a(ArticleTopicInfo paramArticleTopicInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("name", "a");
    Object localObject1 = new JSONObject();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramArticleTopicInfo.b);
    ((StringBuilder)localObject2).append("#native_article_topic_tag");
    ((JSONObject)localObject1).put("href", ((StringBuilder)localObject2).toString());
    ((JSONObject)localObject1).put("style", "color: #40A0FF;");
    localJSONObject.put("attrs", localObject1);
    localObject1 = new JSONArray();
    localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("type", "text");
    ((JSONObject)localObject2).put("text", paramArticleTopicInfo.jdField_a_of_type_JavaLangString);
    ((JSONArray)localObject1).put(localObject2);
    localJSONObject.put("children", localObject1);
    return localJSONObject;
  }
  
  private static JSONObject a(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("name", "text");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("style", "color: #262626;");
    localJSONObject1.put("attrs", localObject);
    localObject = new JSONArray();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("type", "text");
    localJSONObject2.put("text", paramString);
    ((JSONArray)localObject).put(localJSONObject2);
    localJSONObject1.put("children", localObject);
    return localJSONObject1;
  }
  
  private static void a(RecommendFollowInfos paramRecommendFollowInfos, JSONArray paramJSONArray)
  {
    List localList = paramRecommendFollowInfos.a;
    if (localList != null)
    {
      if (paramJSONArray == null) {
        return;
      }
      int i = 0;
      while (i < localList.size())
      {
        paramJSONArray.put(a(paramRecommendFollowInfos, (RecommendFollowInfo)localList.get(i), i));
        i += 1;
      }
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    String str = paramAbsBaseArticleInfo.getSubscribeUin();
    if (!TextUtils.isEmpty(str)) {
      a(paramAbsBaseArticleInfo, paramJSONObject, ReadInJoyUserInfoModule.a(Long.parseLong(str), null));
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramJSONObject != null))
    {
      if (paramReadInJoyUserInfo == null) {
        return;
      }
      try
      {
        if (!TextUtils.isEmpty(paramReadInJoyUserInfo.authorizeDesc))
        {
          paramJSONObject.put("authorizeDesc", paramReadInJoyUserInfo.authorizeDesc);
          return;
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("bindAuthorizeDesc error! msg=");
        paramJSONObject.append(paramAbsBaseArticleInfo);
        QLog.d("FastWebPTSDataConverter", 1, paramJSONObject.toString());
      }
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      paramAbsBaseArticleInfo.bindShowFollowButton = false;
      a(paramJSONObject, paramBoolean, paramAbsBaseArticleInfo);
    }
  }
  
  private static void a(FastWebArticleInfo paramFastWebArticleInfo, JSONObject paramJSONObject)
  {
    if (paramFastWebArticleInfo != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      paramFastWebArticleInfo = a(paramFastWebArticleInfo.jdField_a_of_type_Long);
      if (!TextUtils.isEmpty(paramFastWebArticleInfo)) {
        try
        {
          paramJSONObject.put("read_count", paramFastWebArticleInfo);
          return;
        }
        catch (JSONException paramFastWebArticleInfo)
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("updateReadCountItem error! msg=");
          paramJSONObject.append(paramFastWebArticleInfo);
          QLog.d("FastWebPTSDataConverter", 1, paramJSONObject.toString());
        }
      }
    }
  }
  
  private static void a(ProteusItemData paramProteusItemData, JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    try
    {
      paramProteusItemData.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
      paramProteusItemData.a = paramFastWebArticleInfo;
      paramProteusItemData.b(paramJSONObject);
      paramProteusItemData.a(TemplateFactory.a("native_article", true));
      return;
    }
    catch (Exception paramProteusItemData)
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("createCommonDynamicItem error! msg=");
      paramJSONObject.append(paramProteusItemData);
      QLog.d("FastWebPTSDataConverter", 1, paramJSONObject.toString());
    }
  }
  
  public static void a(List<BaseData> paramList, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = localObject4;
    for (;;)
    {
      try
      {
        localJSONObject.put("style_ID", "Readinjoy_article_compact_interaction_cell");
        localObject2 = localObject4;
        boolean bool = paramFastWebArticleInfo.jdField_a_of_type_Boolean;
        if (bool)
        {
          localObject1 = "NativeArticleLikeEnable";
          localObject2 = localObject4;
          localJSONObject.put("dt_actionid", "click_like");
        }
        else
        {
          localObject1 = "NativeArticleLikeDisable";
          localObject2 = localObject4;
          localJSONObject.put("dt_actionid", "cancel_like");
        }
        localObject2 = localObject4;
        localJSONObject.put("interaction_like_count", a(paramFastWebArticleInfo.jdField_a_of_type_Int));
        localObject2 = localObject4;
        localJSONObject.put("like_normalstate_image", localObject1);
        localObject2 = localObject4;
        localJSONObject.put("dt_rowkey", paramFastWebArticleInfo.j);
        localObject2 = localObject4;
        if (!paramFastWebArticleInfo.jdField_e_of_type_Boolean) {
          break label510;
        }
        Object localObject1 = "CoinIcon";
        localObject2 = localObject4;
        localJSONObject.put("coin_img_status", localObject1);
        localObject2 = localObject4;
        localJSONObject.put("coin_count", FastWebPTSUtils.a(paramFastWebArticleInfo.jdField_e_of_type_Int, HardCodeUtil.a(2131718309)));
        localObject2 = localObject4;
        if (!paramFastWebArticleInfo.b()) {
          break label518;
        }
        localObject1 = "NativeArticleCollectionEnable";
        localObject2 = localObject4;
        localJSONObject.put("collect_normalstate_image", localObject1);
        if (paramAbsBaseArticleInfo != null)
        {
          localObject2 = localObject4;
          if (paramAbsBaseArticleInfo.mShareCount > 0)
          {
            localObject2 = localObject4;
            l = paramAbsBaseArticleInfo.mShareCount;
            continue;
          }
        }
        localObject2 = localObject4;
        long l = paramFastWebArticleInfo.d;
        localObject2 = localObject4;
        localJSONObject.put("interaction_share_count", FastWebPTSUtils.a(l, HardCodeUtil.a(2131715705)));
        localObject2 = localObject4;
        Iterator localIterator = paramList.iterator();
        localObject1 = localObject3;
        localObject2 = localObject4;
        if (localIterator.hasNext())
        {
          localObject2 = localObject4;
          localObject1 = (BaseData)localIterator.next();
          localObject2 = localObject4;
          if (!(localObject1 instanceof ProteusItemData)) {
            continue;
          }
          localObject2 = localObject4;
          localObject1 = (ProteusItemData)localObject1;
          localObject2 = localObject4;
          if (((ProteusItemData)localObject1).A != 2) {
            continue;
          }
        }
        localObject2 = localObject1;
        localObject3 = (ModuleInfo)paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray.get(2);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          a(localJSONObject, ((ModuleInfo)localObject3).a);
          localObject2 = localObject1;
        }
      }
      catch (Exception localException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("insertDislikeData error! msg=");
        ((StringBuilder)localObject3).append(localException);
        QLog.d("FastWebPTSDataConverter", 1, ((StringBuilder)localObject3).toString());
      }
      if (localObject2 == null)
      {
        paramAbsBaseArticleInfo = a(localJSONObject, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
        paramAbsBaseArticleInfo.jdField_b_of_type_Float = d(paramSparseArray);
        paramAbsBaseArticleInfo.A = 2;
        ItemDatasListUtils.a(paramList, paramAbsBaseArticleInfo);
        return;
      }
      a(localObject2, localJSONObject, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
      return;
      label510:
      String str = "NoCoinIcon";
      continue;
      label518:
      str = "NativeArticleCollectionDisable";
    }
  }
  
  public static void a(List<BaseData> paramList, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramList != null)
    {
      if (paramFastWebArticleInfo == null) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (BaseData)paramList.next();
        if ((localObject instanceof ProteusItemData))
        {
          localObject = (ProteusItemData)localObject;
          if ((((ProteusItemData)localObject).c != null) && ("ReadInjoy_article_read_count_cell".equalsIgnoreCase(((ProteusItemData)localObject).c.optString("style_ID")))) {
            a(paramFastWebArticleInfo, ((ProteusItemData)localObject).c);
          }
        }
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject, FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramJSONObject != null) {
      if (paramFastWebArticleInfo == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("dt_rowkey", paramFastWebArticleInfo.j);
        if (!paramFastWebArticleInfo.c()) {
          break label323;
        }
        str = "ReadInjoy_article_operate_cell";
        paramJSONObject.put("style_ID", str);
        boolean bool = paramFastWebArticleInfo.jdField_a_of_type_Boolean;
        if (bool)
        {
          str = "NativeArticleLikeEnable";
          paramJSONObject.put("dt_like_actionid", "click_like");
        }
        else
        {
          str = "NativeArticleLikeDisable";
          paramJSONObject.put("dt_like_actionid", "cancel_like");
        }
        paramJSONObject.put("like_normalstate_image", str);
        if (!paramFastWebArticleInfo.b()) {
          break label331;
        }
        str = "NativeArticleCollectionEnable";
        paramJSONObject.put("collect_normalstate_image", str);
        paramJSONObject.put("comment_count", FastWebPTSUtils.a(paramFastWebArticleInfo.jdField_b_of_type_Long, FastWebPTSConstans.jdField_a_of_type_JavaLangString));
        if (!paramFastWebArticleInfo.jdField_e_of_type_Boolean) {
          break label339;
        }
        str = "CoinIcon";
        paramJSONObject.put("coin_img_status", str);
        paramJSONObject.put("like_count", a(paramFastWebArticleInfo.jdField_a_of_type_Int));
        long l;
        if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mShareCount > 0)) {
          l = paramAbsBaseArticleInfo.mShareCount;
        } else {
          l = paramFastWebArticleInfo.d;
        }
        paramJSONObject.put("share_count", FastWebPTSUtils.a(l, HardCodeUtil.a(2131715705)));
        paramJSONObject.put("coin_count", FastWebPTSUtils.a(paramFastWebArticleInfo.jdField_e_of_type_Int, HardCodeUtil.a(2131718309)));
        paramFastWebArticleInfo = new StringBuilder();
        paramFastWebArticleInfo.append("buildNormalCommentBiuOperationData | dynamicData :");
        paramFastWebArticleInfo.append(paramJSONObject.toString());
        QLog.d("FastWebPTSDataConverter", 2, paramFastWebArticleInfo.toString());
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramFastWebArticleInfo = new StringBuilder();
        paramFastWebArticleInfo.append("createOperateAreaData error! msg=");
        paramFastWebArticleInfo.append(paramJSONObject.getMessage());
        QLog.d("FastWebPTSDataConverter", 1, paramFastWebArticleInfo.toString());
      }
      return;
      label323:
      String str = "ReadInjoy_article_forbid_comment_operate_cell";
      continue;
      label331:
      str = "NativeArticleCollectionDisable";
      continue;
      label339:
      str = "NoCoinIcon";
    }
  }
  
  private static void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject1 != null)
    {
      if (paramJSONObject2 == null) {
        return;
      }
      Object localObject = paramJSONObject2.keys();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        try
        {
          paramJSONObject1.put(str, paramJSONObject2.getString(str));
        }
        catch (Exception localException)
        {
          label47:
          break label47;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mergeJSONData! oriData=");
      ((StringBuilder)localObject).append(paramJSONObject1);
      ((StringBuilder)localObject).append(" mergeData=");
      ((StringBuilder)localObject).append(paramJSONObject2);
      QLog.d("FastWebPTSDataConverter", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private static void a(JSONObject paramJSONObject, boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str;
    if (paramBoolean) {
      str = "1";
    }
    for (;;)
    {
      try
      {
        paramJSONObject.put("selected_status", str);
        paramAbsBaseArticleInfo.bindShowFollowButton = true;
        if (!paramBoolean) {
          break label114;
        }
        i = 2;
        paramAbsBaseArticleInfo.showFollowButtonType = i;
        if (paramBoolean) {
          paramAbsBaseArticleInfo = HardCodeUtil.a(2131716363);
        } else {
          paramAbsBaseArticleInfo = HardCodeUtil.a(2131716364);
        }
        paramJSONObject.put("button_status", paramAbsBaseArticleInfo);
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append("addFollowInfo error! msg=");
        paramAbsBaseArticleInfo.append(paramJSONObject);
        QLog.d("FastWebPTSDataConverter", 1, paramAbsBaseArticleInfo.toString());
        return;
      }
      str = "0";
      continue;
      label114:
      int i = 1;
    }
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mRecommendFollowInfos != null) && (!paramAbsBaseArticleInfo.mRecommendFollowInfos.a.isEmpty());
  }
  
  public static float b(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 3, 3.7F);
  }
  
  public static ProteusItemData b(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      localJSONObject.put("style_ID", "readinjoy_native_tag");
      localObject1 = localObject2;
      b(paramFastWebArticleInfo, localJSONObject);
      localObject1 = localObject2;
      paramAbsBaseArticleInfo = a(localJSONObject, paramAbsBaseArticleInfo, paramFastWebArticleInfo);
      localObject1 = paramAbsBaseArticleInfo;
      paramAbsBaseArticleInfo.A = 1;
      localObject1 = paramAbsBaseArticleInfo;
      paramAbsBaseArticleInfo.jdField_b_of_type_Float = (a(paramSparseArray) + 0.01F);
      return paramAbsBaseArticleInfo;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramFastWebArticleInfo = new StringBuilder();
      paramFastWebArticleInfo.append("[createTopicTagData] exception, e = ");
      paramFastWebArticleInfo.append(paramAbsBaseArticleInfo);
      QLog.e("FastWebPTSDataConverter", 1, paramFastWebArticleInfo.toString());
    }
    return localObject1;
  }
  
  private static ProteusItemData b(JSONObject paramJSONObject, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("mini_program_name"))))
    {
      paramAbsBaseArticleInfo = new MiniAppData(26);
      paramAbsBaseArticleInfo.b = paramJSONObject.optString("movie_name");
      paramAbsBaseArticleInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("mini_program_name");
      paramAbsBaseArticleInfo.c = paramJSONObject.optString("exRowkey");
      paramAbsBaseArticleInfo.jdField_a_of_type_Int = paramJSONObject.optInt("total_time");
      return paramAbsBaseArticleInfo;
    }
    return new ProteusItemData(26);
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    String str = paramAbsBaseArticleInfo.getSubscribeUin();
    if (!TextUtils.isEmpty(str)) {
      b(paramAbsBaseArticleInfo, paramJSONObject, ReadInJoyUserInfoModule.a(Long.parseLong(str), null));
    }
  }
  
  public static void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramJSONObject != null))
    {
      if (paramReadInJoyUserInfo == null) {
        return;
      }
      try
      {
        if (!TextUtils.isEmpty(paramReadInJoyUserInfo.authorizeDesc))
        {
          paramJSONObject.put("user_desc_text", paramReadInJoyUserInfo.authorizeDesc);
          return;
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("bindAuthorizeDesc error! msg=");
        paramJSONObject.append(paramAbsBaseArticleInfo);
        QLog.d("FastWebPTSDataConverter", 1, paramJSONObject.toString());
      }
    }
  }
  
  private static void b(FastWebArticleInfo paramFastWebArticleInfo, JSONObject paramJSONObject)
  {
    JSONArray localJSONArray;
    int i;
    if (paramFastWebArticleInfo != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      if (paramFastWebArticleInfo.jdField_b_of_type_JavaUtilList != null)
      {
        if (paramFastWebArticleInfo.jdField_b_of_type_JavaUtilList.size() <= 0) {
          return;
        }
        localJSONArray = new JSONArray();
        i = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (i < paramFastWebArticleInfo.jdField_b_of_type_JavaUtilList.size())
        {
          localJSONArray.put(a((ArticleTopicInfo)paramFastWebArticleInfo.jdField_b_of_type_JavaUtilList.get(i)));
          if (i == paramFastWebArticleInfo.jdField_b_of_type_JavaUtilList.size() - 1) {
            break label146;
          }
          localJSONArray.put(a("  "));
          break label146;
        }
        paramJSONObject.put("rich_text_info", localJSONArray);
        return;
      }
      catch (JSONException paramFastWebArticleInfo)
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("[insertTopicData] e = ");
        paramJSONObject.append(paramFastWebArticleInfo);
        QLog.e("FastWebPTSDataConverter", 1, paramJSONObject.toString());
      }
      return;
      label146:
      i += 1;
    }
  }
  
  public static float c(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 5, 7.0F);
  }
  
  public static float d(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 2, 3.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter
 * JD-Core Version:    0.7.0.1
 */