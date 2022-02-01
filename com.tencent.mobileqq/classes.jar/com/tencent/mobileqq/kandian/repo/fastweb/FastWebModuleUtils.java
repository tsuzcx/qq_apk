package com.tencent.mobileqq.kandian.repo.fastweb;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleTopicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ModuleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ArticleBusiness;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.CoinInfo;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBiuCount;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBody;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspTopic;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.SentimentEntityData;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ShareNumItem;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.StyleCard;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.Topic;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.UnionNlpInfo;

public class FastWebModuleUtils
{
  private static int a(JSONObject paramJSONObject, ModuleInfo paramModuleInfo)
  {
    if ((paramJSONObject != null) && (paramModuleInfo != null)) {
      try
      {
        paramModuleInfo.jdField_a_of_type_Int = Integer.parseInt(paramJSONObject.getString("moduleType"));
        paramModuleInfo.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
        int i = paramModuleInfo.jdField_a_of_type_Int;
        return i;
      }
      catch (Exception paramJSONObject)
      {
        paramModuleInfo = new StringBuilder();
        paramModuleInfo.append("updateModuleBean,error! msg");
        paramModuleInfo.append(paramJSONObject);
        QLog.d("FastWebModuleUtils", 1, paramModuleInfo.toString());
      }
    }
    return -1;
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback, String paramString)
  {
    a(paramRspBody, paramFastWebArticleInfo, paramFastWebArticleRichReqCallback, paramString);
    b(paramRspBody, paramFastWebArticleInfo, paramFastWebArticleRichReqCallback, paramString);
    a(paramRspBody, paramFastWebArticleInfo, paramFastWebArticleRichReqCallback);
    c(paramRspBody, paramFastWebArticleInfo, paramFastWebArticleRichReqCallback, paramString);
    a(paramRspBody, paramFastWebArticleInfo);
    d(paramRspBody, paramFastWebArticleInfo, paramFastWebArticleRichReqCallback, paramString);
    b(paramRspBody, paramFastWebArticleInfo);
    e(paramRspBody, paramFastWebArticleInfo, paramFastWebArticleRichReqCallback, paramString);
    if (((Boolean)paramToServiceMsg.getAttribute("fetchBusiness", Boolean.valueOf(false))).booleanValue()) {
      b(paramRspBody, paramFastWebArticleInfo, paramFastWebArticleRichReqCallback);
    }
  }
  
  public static void a(String paramString, SparseArray<ModuleInfo> paramSparseArray)
  {
    if ((paramString != null) && (paramSparseArray != null)) {
      try
      {
        Object localObject1 = new ModuleInfo();
        JSONArray localJSONArray = new JSONArray(paramString);
        int i = 0;
        while (i < localJSONArray.length())
        {
          Object localObject2 = localJSONArray.get(i);
          if ((localObject2 instanceof JSONObject))
          {
            int j = a((JSONObject)localObject2, (ModuleInfo)localObject1);
            if (-1 != j) {
              paramSparseArray.append(j, localObject1);
            }
          }
          i += 1;
        }
        paramSparseArray = new StringBuilder();
      }
      catch (Exception paramSparseArray)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parsePTSData,error! msg");
        ((StringBuilder)localObject1).append(paramSparseArray);
        QLog.d("FastWebModuleUtils", 1, ((StringBuilder)localObject1).toString());
      }
    }
    paramSparseArray.append("parsePTSData! msg");
    paramSparseArray.append(paramString);
    QLog.d("FastWebModuleUtils", 1, paramSparseArray.toString());
  }
  
  static void a(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramRspBody.bytes_proteus_json_data.has())
    {
      paramRspBody = paramRspBody.bytes_proteus_json_data.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramRspBody))
      {
        paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray.clear();
        a(paramRspBody, paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray);
      }
    }
  }
  
  static void a(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback)
  {
    if (paramRspBody.rpt_msg_style_card.has())
    {
      paramRspBody = paramRspBody.rpt_msg_style_card.get().iterator();
      while (paramRspBody.hasNext())
      {
        Object localObject = (oidb_cmd0xb54.StyleCard)paramRspBody.next();
        try
        {
          if ((((oidb_cmd0xb54.StyleCard)localObject).bytes_sourceid.has()) && (((oidb_cmd0xb54.StyleCard)localObject).bytes_style.has()))
          {
            String str = ((oidb_cmd0xb54.StyleCard)localObject).bytes_sourceid.get().toStringUtf8();
            localObject = ((oidb_cmd0xb54.StyleCard)localObject).bytes_style.get().toStringUtf8();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("0xb54 resp bytes_sourceid : ");
            localStringBuilder.append(str);
            localStringBuilder.append(" json ");
            localStringBuilder.append((String)localObject);
            QLog.d("FastWebModuleUtils", 2, localStringBuilder.toString());
            paramFastWebArticleInfo.a(str, new JSONObject((String)localObject));
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.d("FastWebModuleUtils", 1, localJSONException, new Object[] { "0xb54 rpt_msg_style_card " });
        }
      }
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo.j);
      }
    }
  }
  
  static void a(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback, String paramString)
  {
    if (paramRspBody.msg_rsp_biu_count.has())
    {
      paramFastWebArticleInfo.c = ((oidb_cmd0xb54.RspBiuCount)paramRspBody.msg_rsp_biu_count.get()).uint64_biu_count.get();
      paramRspBody = new StringBuilder();
      paramRspBody.append("0xb54 resp biu count is : ");
      paramRspBody.append(paramFastWebArticleInfo.c);
      QLog.d("FastWebModuleUtils", 2, paramRspBody.toString());
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo.c, paramString);
      }
    }
  }
  
  private static void b(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramFastWebArticleInfo != null)
    {
      if (paramRspBody == null) {
        return;
      }
      if (paramRspBody.msg_coin_info.has())
      {
        paramRspBody = (oidb_cmd0xb54.CoinInfo)paramRspBody.msg_coin_info.get();
        if (paramRspBody != null)
        {
          paramFastWebArticleInfo.jdField_e_of_type_Int = RIJPBFieldUtils.a(paramRspBody.content_coin_num, 0);
          paramFastWebArticleInfo.jdField_e_of_type_Boolean = RIJPBFieldUtils.a(paramRspBody.content_has_coin);
          paramRspBody = new StringBuilder();
          paramRspBody.append("updateCoinInfo, coinNumber= ");
          paramRspBody.append(paramFastWebArticleInfo.jdField_e_of_type_Int);
          paramRspBody.append(" ,hasCoined=");
          paramRspBody.append(paramFastWebArticleInfo.jdField_e_of_type_Boolean);
          QLog.d("FastWebModuleUtils", 1, paramRspBody.toString());
        }
      }
    }
  }
  
  static void b(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback)
  {
    boolean bool = paramRspBody.msg_article_business.has();
    Object localObject = "";
    if ((bool) && (paramRspBody.msg_article_business.get() != null))
    {
      oidb_cmd0xb54.ArticleBusiness localArticleBusiness = (oidb_cmd0xb54.ArticleBusiness)paramRspBody.msg_article_business.get();
      int i = localArticleBusiness.uint32_business_cash_flag.get();
      paramRspBody = (oidb_cmd0xb54.RspBody)localObject;
      if (localArticleBusiness.bytes_business_cash_info.has())
      {
        paramRspBody = (oidb_cmd0xb54.RspBody)localObject;
        if (localArticleBusiness.bytes_business_cash_info.get() != null) {
          paramRspBody = localArticleBusiness.bytes_business_cash_info.get().toStringUtf8();
        }
      }
      if ((localArticleBusiness.msg_sentiment_entity_data.has()) && (localArticleBusiness.msg_sentiment_entity_data.get() != null))
      {
        localObject = (oidb_cmd0xb54.SentimentEntityData)localArticleBusiness.msg_sentiment_entity_data.get();
        if ((((oidb_cmd0xb54.SentimentEntityData)localObject).bytes_data.has()) && (((oidb_cmd0xb54.SentimentEntityData)localObject).bytes_data.get() != null)) {
          paramFastWebArticleInfo.m = ((oidb_cmd0xb54.SentimentEntityData)localObject).bytes_data.get().toStringUtf8();
        }
      }
      if ((localArticleBusiness.msg_union_nlp_info.has()) && (localArticleBusiness.msg_union_nlp_info.get() != null))
      {
        localObject = (oidb_cmd0xb54.UnionNlpInfo)localArticleBusiness.msg_union_nlp_info.get();
        if ((((oidb_cmd0xb54.UnionNlpInfo)localObject).bytes_union_chann.has()) && (((oidb_cmd0xb54.UnionNlpInfo)localObject).bytes_union_chann.get() != null)) {
          paramFastWebArticleInfo.n = ((oidb_cmd0xb54.UnionNlpInfo)localObject).bytes_union_chann.get().toStringUtf8();
        }
      }
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo, i, paramRspBody);
      }
    }
    else
    {
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo, 0, "");
      }
      QLog.d("FastWebModuleUtils", 1, "0xb54 article business is null");
    }
  }
  
  static void b(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback, String paramString)
  {
    if (paramRspBody.uint32_like_count.has())
    {
      paramFastWebArticleInfo.jdField_a_of_type_Int = paramRspBody.uint32_like_count.get();
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo.jdField_a_of_type_Int, paramString);
      }
      paramRspBody = new StringBuilder();
      paramRspBody.append("0xb54 resp like count is : ");
      paramRspBody.append(paramFastWebArticleInfo.jdField_a_of_type_Int);
      QLog.d("FastWebModuleUtils", 2, paramRspBody.toString());
    }
  }
  
  static void c(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback, String paramString)
  {
    if (paramRspBody.uint32_is_like.has())
    {
      int i = paramRspBody.uint32_is_like.get();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = bool;
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo.jdField_a_of_type_Boolean, paramString);
      }
      paramFastWebArticleInfo = new StringBuilder();
      paramFastWebArticleInfo.append("0xb54 resp isLiked : ");
      paramFastWebArticleInfo.append(paramRspBody.uint32_is_like.get());
      QLog.d("FastWebModuleUtils", 2, paramFastWebArticleInfo.toString());
    }
  }
  
  public static void d(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback, String paramString)
  {
    paramRspBody = paramRspBody.msg_rsp_topic;
    if ((paramRspBody.has()) && (paramRspBody.get() != null))
    {
      int j = paramRspBody.rpt_msg_topic.size();
      if (j > 0)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          Object localObject = (oidb_cmd0xb54.Topic)paramRspBody.rpt_msg_topic.get(i);
          ArticleTopicInfo localArticleTopicInfo = new ArticleTopicInfo();
          localArticleTopicInfo.c = ((oidb_cmd0xb54.Topic)localObject).str_rowkey.get();
          localArticleTopicInfo.a = ((oidb_cmd0xb54.Topic)localObject).bytes_title.get().toStringUtf8();
          localArticleTopicInfo.b = ((oidb_cmd0xb54.Topic)localObject).bytes_url.get().toStringUtf8();
          localArrayList.add(localArticleTopicInfo);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[handleTopicTag] topic[");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("], rowKey = ");
          ((StringBuilder)localObject).append(localArticleTopicInfo.c);
          ((StringBuilder)localObject).append(", title = ");
          ((StringBuilder)localObject).append(localArticleTopicInfo.a);
          ((StringBuilder)localObject).append(", jumpUrl = ");
          ((StringBuilder)localObject).append(localArticleTopicInfo.b);
          QLog.i("FastWebModuleUtils", 1, ((StringBuilder)localObject).toString());
          i += 1;
        }
        paramFastWebArticleInfo.b = localArrayList;
        if (paramFastWebArticleRichReqCallback != null) {
          paramFastWebArticleRichReqCallback.a(paramFastWebArticleInfo, paramString);
        }
      }
    }
  }
  
  static void e(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback, String paramString)
  {
    if (paramRspBody.msg_share_num.has())
    {
      paramRspBody = (oidb_cmd0xb54.ShareNumItem)paramRspBody.msg_share_num.get();
      if (paramRspBody != null) {
        paramFastWebArticleInfo.d = paramRspBody.uint64_num.get();
      }
      if (paramFastWebArticleRichReqCallback != null) {
        paramFastWebArticleRichReqCallback.b(paramFastWebArticleInfo.d, paramString);
      }
      if (QLog.isColorLevel())
      {
        paramRspBody = new StringBuilder();
        paramRspBody.append("handleShareCount, shareCount= ");
        paramRspBody.append(paramFastWebArticleInfo.d);
        QLog.d("FastWebModuleUtils", 2, paramRspBody.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.FastWebModuleUtils
 * JD-Core Version:    0.7.0.1
 */