import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ArticleBusiness;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBiuCount;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBody;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.SentimentEntityData;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.StyleCard;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.UnionNlpInfo;

public class ppk
{
  static void a(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (paramRspBody.bytes_proteus_json_data.has())
    {
      paramRspBody = paramRspBody.bytes_proteus_json_data.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramRspBody))
      {
        paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray.clear();
        srw.a(paramRspBody, paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray);
      }
    }
  }
  
  static void a(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, pph parampph)
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
            QLog.d("FastWebModuleUtils", 2, "0xb54 resp bytes_sourceid : " + str + " json " + (String)localObject);
            paramFastWebArticleInfo.a(str, new JSONObject((String)localObject));
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.d("FastWebModuleUtils", 1, localJSONException, new Object[] { "0xb54 rpt_msg_style_card " });
        }
      }
      if (parampph != null) {
        parampph.a(paramFastWebArticleInfo.j);
      }
    }
  }
  
  static void a(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, pph parampph, String paramString)
  {
    if (paramRspBody.msg_rsp_biu_count.has())
    {
      paramFastWebArticleInfo.c = ((oidb_cmd0xb54.RspBiuCount)paramRspBody.msg_rsp_biu_count.get()).uint64_biu_count.get();
      QLog.d("FastWebModuleUtils", 2, "0xb54 resp biu count is : " + paramFastWebArticleInfo.c);
      if (parampph != null) {
        parampph.a(paramFastWebArticleInfo.c, paramString);
      }
    }
  }
  
  static void b(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, pph parampph)
  {
    Object localObject;
    int i;
    if ((paramRspBody.msg_article_business.has()) && (paramRspBody.msg_article_business.get() != null))
    {
      localObject = (oidb_cmd0xb54.ArticleBusiness)paramRspBody.msg_article_business.get();
      i = ((oidb_cmd0xb54.ArticleBusiness)localObject).uint32_business_cash_flag.get();
      if ((!((oidb_cmd0xb54.ArticleBusiness)localObject).bytes_business_cash_info.has()) || (((oidb_cmd0xb54.ArticleBusiness)localObject).bytes_business_cash_info.get() == null)) {
        break label252;
      }
    }
    label252:
    for (paramRspBody = ((oidb_cmd0xb54.ArticleBusiness)localObject).bytes_business_cash_info.get().toStringUtf8();; paramRspBody = "")
    {
      if ((((oidb_cmd0xb54.ArticleBusiness)localObject).msg_sentiment_entity_data.has()) && (((oidb_cmd0xb54.ArticleBusiness)localObject).msg_sentiment_entity_data.get() != null))
      {
        oidb_cmd0xb54.SentimentEntityData localSentimentEntityData = (oidb_cmd0xb54.SentimentEntityData)((oidb_cmd0xb54.ArticleBusiness)localObject).msg_sentiment_entity_data.get();
        if ((localSentimentEntityData.bytes_data.has()) && (localSentimentEntityData.bytes_data.get() != null)) {
          paramFastWebArticleInfo.m = localSentimentEntityData.bytes_data.get().toStringUtf8();
        }
      }
      if ((((oidb_cmd0xb54.ArticleBusiness)localObject).msg_union_nlp_info.has()) && (((oidb_cmd0xb54.ArticleBusiness)localObject).msg_union_nlp_info.get() != null))
      {
        localObject = (oidb_cmd0xb54.UnionNlpInfo)((oidb_cmd0xb54.ArticleBusiness)localObject).msg_union_nlp_info.get();
        if ((((oidb_cmd0xb54.UnionNlpInfo)localObject).bytes_union_chann.has()) && (((oidb_cmd0xb54.UnionNlpInfo)localObject).bytes_union_chann.get() != null)) {
          paramFastWebArticleInfo.n = ((oidb_cmd0xb54.UnionNlpInfo)localObject).bytes_union_chann.get().toStringUtf8();
        }
      }
      if (parampph != null) {
        parampph.a(paramFastWebArticleInfo, i, paramRspBody);
      }
      return;
      if (parampph != null) {
        parampph.a(paramFastWebArticleInfo, 0, "");
      }
      QLog.d("FastWebModuleUtils", 1, "0xb54 article business is null");
      return;
    }
  }
  
  static void b(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, pph parampph, String paramString)
  {
    if (paramRspBody.uint32_like_count.has())
    {
      paramFastWebArticleInfo.jdField_a_of_type_Int = paramRspBody.uint32_like_count.get();
      if (parampph != null) {
        parampph.a(paramFastWebArticleInfo.jdField_a_of_type_Int, paramString);
      }
      QLog.d("FastWebModuleUtils", 2, "0xb54 resp like count is : " + paramFastWebArticleInfo.jdField_a_of_type_Int);
    }
  }
  
  static void c(oidb_cmd0xb54.RspBody paramRspBody, FastWebArticleInfo paramFastWebArticleInfo, pph parampph, String paramString)
  {
    boolean bool = true;
    if (paramRspBody.uint32_is_like.has()) {
      if (paramRspBody.uint32_is_like.get() != 1) {
        break label75;
      }
    }
    for (;;)
    {
      paramFastWebArticleInfo.jdField_a_of_type_Boolean = bool;
      if (parampph != null) {
        parampph.a(paramFastWebArticleInfo.jdField_a_of_type_Boolean, paramString);
      }
      QLog.d("FastWebModuleUtils", 2, "0xb54 resp isLiked : " + paramRspBody.uint32_is_like.get());
      return;
      label75:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppk
 * JD-Core Version:    0.7.0.1
 */