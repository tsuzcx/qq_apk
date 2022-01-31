import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.RequestSearchWord.Rcmd;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class pek
{
  static void A(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("url", onh.a(paramBaseArticleInfo, paramBaseArticleInfo.mArticleContentUrl));
    new JSONObject();
    paramJSONObject.put("article_large_imge_url", paramBaseArticleInfo.mFirstPagePicUrl);
    paramJSONObject.put("rowkey", paramBaseArticleInfo.innerUniqueID);
    Object localObject1 = paramBaseArticleInfo.mTitle;
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramJSONObject.put("artilce_title_text", localObject1);
    }
    if (paramBaseArticleInfo.getVideoDuration() > 0) {
      paramJSONObject.put("video_play_duration", muc.a(paramBaseArticleInfo.getVideoDuration()));
    }
    if (paramBaseArticleInfo.getVideoDuration() <= 0) {
      paramJSONObject.put("subcribe_name_text", paramBaseArticleInfo.mSubscribeName);
    }
    B(paramBaseArticleInfo, paramJSONObject);
    if ((paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null))
    {
      ArrayList localArrayList1 = new ArrayList();
      localObject1 = new JSONArray();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          qbo localqbo = (qbo)localIterator.next();
          if (localqbo == null) {
            continue;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("style_ID", localqbo.i);
          new JSONObject();
          localJSONObject.put("article_large_imge_url", localqbo.jdField_c_of_type_JavaLangString);
          if (localqbo.jdField_c_of_type_Int == 1) {
            localJSONObject.put("gallery_cnt", localqbo.jdField_d_of_type_Int + ajya.a(2131715999));
          }
          localJSONObject.put("rowkey", localqbo.g);
          localArrayList1.add(localqbo.g);
          localJSONObject.put("subcribe_name_text", localqbo.jdField_f_of_type_JavaLangString);
          localJSONObject.put("subscribe_id", localqbo.jdField_e_of_type_JavaLangString);
          localJSONObject.put("artilce_title_text", localqbo.jdField_a_of_type_JavaLangString);
          Object localObject2;
          BaseArticleInfo localBaseArticleInfo;
          if (onh.f(localqbo.jdField_d_of_type_JavaLangString))
          {
            localObject2 = onh.a(localqbo.jdField_d_of_type_JavaLangString, localqbo, paramBaseArticleInfo);
            localBaseArticleInfo = new BaseArticleInfo();
            localBaseArticleInfo.mArticleContentUrl = localqbo.jdField_d_of_type_JavaLangString;
            localBaseArticleInfo.mSubscribeName = localqbo.jdField_f_of_type_JavaLangString;
            localBaseArticleInfo.mSubscribeID = localqbo.jdField_e_of_type_JavaLangString;
            localBaseArticleInfo.mTitle = localqbo.jdField_a_of_type_JavaLangString;
            if (localqbo.jdField_a_of_type_Qbr != null)
            {
              localJSONObject.put("video_play_duration", muc.a(localqbo.jdField_a_of_type_Qbr.jdField_d_of_type_Int));
              localBaseArticleInfo.mVideoDuration = localqbo.jdField_a_of_type_Qbr.jdField_d_of_type_Int;
              localBaseArticleInfo.busiType = localqbo.jdField_a_of_type_Qbr.jdField_a_of_type_Int;
              localBaseArticleInfo.mVideoVid = localqbo.jdField_a_of_type_Qbr.jdField_a_of_type_JavaLangString;
              localBaseArticleInfo.mVideoJsonWidth = localqbo.jdField_a_of_type_Qbr.jdField_b_of_type_Int;
              localBaseArticleInfo.mVideoJsonHeight = localqbo.jdField_a_of_type_Qbr.jdField_c_of_type_Int;
            }
          }
          try
          {
            localBaseArticleInfo.mVideoCoverUrl = new URL(localqbo.jdField_c_of_type_JavaLangString);
            if ((paramBaseArticleInfo.isPGCShortContent()) && (localqbo.jdField_e_of_type_Int == 1)) {
              localJSONObject.put("image_type_text", ajya.a(2131716014));
            }
            localArrayList2.add(localBaseArticleInfo);
            localJSONObject.put("url", localObject2);
            ((JSONArray)localObject1).put(localJSONObject);
            localObject2 = new JSONObject(paramBaseArticleInfo.proteusItemsData);
            if (localObject2 != null)
            {
              localObject2 = ((JSONObject)localObject2).getJSONArray("remoteDatas");
              localObject1 = onh.a((JSONArray)localObject1, (JSONArray)localObject2);
              continue;
              localObject2 = localqbo.jdField_d_of_type_JavaLangString;
            }
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              localMalformedURLException.printStackTrace();
              QLog.d("Util", 2, localMalformedURLException.getMessage());
              continue;
              localObject2 = null;
            }
          }
        }
      }
      paramJSONObject.put("jump_url", paramBaseArticleInfo.mNewPolymericInfo.jdField_d_of_type_JavaLangString);
      paramJSONObject.put("datas", localObject1);
      paramBaseArticleInfo.mGroupSubArticleList = localArrayList2;
      paramJSONObject.put("all_rowkey", localArrayList1.toString());
      QLog.d("Util", 1, "bindDynamicCommonInfo polymetric card : " + paramJSONObject.toString() + ", packType : " + paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int);
    }
    QLog.d("Util", 1, "bindDynamicCommonInfo : " + paramJSONObject.toString());
  }
  
  static void B(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramJSONObject == null))
    {
      QLog.d("Util", 1, "bindTripleImageData, info is null or outData is null.");
      return;
    }
    paramJSONObject.put("gallery_cnt", paramBaseArticleInfo.mGalleryPicNumber + ajya.a(2131715993));
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      JSONArray localJSONArray = ram.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      QLog.d("Util", 1, new Object[] { "bindTripleImageData, info.mJsonPictureList = ", paramBaseArticleInfo.mJsonPictureList });
      if ((localJSONArray == null) || (localJSONArray.length() <= 0))
      {
        QLog.d("Util", 1, "bindTripleImageData, json picture list is empty.");
        return;
      }
      i = 0;
      if (i < localJSONArray.length())
      {
        localObject = localJSONArray.optJSONObject(i);
        if (localObject == null) {}
        for (localObject = paramBaseArticleInfo.mFirstPagePicUrl;; localObject = ((JSONObject)localObject).optString("picture"))
        {
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
    }
    else
    {
      QLog.d("Util", 1, new Object[] { "bindTripleImageData, mPictures length = ", Integer.valueOf(paramBaseArticleInfo.mPictures.length) });
      i = 0;
      if (i < paramBaseArticleInfo.mPictures.length)
      {
        if (paramBaseArticleInfo.mPictures[i] == null) {}
        for (localObject = paramBaseArticleInfo.mSinglePicture;; localObject = paramBaseArticleInfo.mPictures[i])
        {
          if (localObject != null) {
            localArrayList.add(((URL)localObject).getFile());
          }
          i += 1;
          break;
        }
      }
    }
    int i = 0;
    label274:
    if (i < localArrayList.size())
    {
      localObject = "gallery_triple_img_url_" + (i + 1);
      if (!TextUtils.isEmpty((CharSequence)localArrayList.get(i))) {
        break label373;
      }
    }
    label373:
    for (paramBaseArticleInfo = "";; paramBaseArticleInfo = (String)localArrayList.get(i))
    {
      QLog.d("Util", 1, new Object[] { "bindTripleImageData, key = ", localObject, ", value = ", paramBaseArticleInfo });
      paramJSONObject.put((String)localObject, paramBaseArticleInfo);
      i += 1;
      break label274;
      break;
    }
  }
  
  static void C(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((!d(paramBaseArticleInfo)) || (((paramBaseArticleInfo instanceof ArticleInfo)) && (!onh.m()))) {
      return;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
    JSONObject localJSONObject = new JSONObject();
    Object localObject1;
    if ((localSocializeFeedsInfo.a()) && ((paramBaseArticleInfo instanceof ArticleInfo)))
    {
      localObject1 = (ArticleInfo)paramBaseArticleInfo;
      if ((ram.f((ArticleInfo)localObject1)) || (!okz.b((BaseArticleInfo)localObject1))) {
        break label485;
      }
    }
    label279:
    label421:
    label439:
    label457:
    label485:
    for (int i = 0;; i = 1)
    {
      String str;
      if (i == 0)
      {
        str = "0";
        localObject1 = "0.5";
      }
      for (;;)
      {
        Object localObject2 = localObject1;
        if (localSocializeFeedsInfo.jdField_a_of_type_Qcy != null)
        {
          localObject2 = localObject1;
          if (localSocializeFeedsInfo.jdField_a_of_type_Qcy.jdField_a_of_type_Int != 0) {
            localObject2 = "0.5";
          }
        }
        i = localSocializeFeedsInfo.jdField_b_of_type_Int;
        int j = localSocializeFeedsInfo.jdField_d_of_type_Int;
        int k = localSocializeFeedsInfo.jdField_f_of_type_Int;
        QLog.d("Util", 2, new Object[] { "bindSocialData, articleId = ", Long.valueOf(paramBaseArticleInfo.mArticleID), " likeCount = ", Integer.valueOf(i), " commentCount = ", Integer.valueOf(j) });
        localJSONObject.put("like_count", "");
        if (localSocializeFeedsInfo.jdField_c_of_type_Int == 1)
        {
          localJSONObject.put("selected_state", "1");
          if (i <= 0) {
            break label421;
          }
          localJSONObject.put("like_count", bhvy.b(i));
          label243:
          paramJSONObject.put("id_like_button", localJSONObject);
          localObject1 = new JSONObject();
          if (j <= 0) {
            break label439;
          }
          ((JSONObject)localObject1).put("comment_count", bhvy.b(j));
          paramJSONObject.put("id_comment_button", localObject1);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("biu_alpha", localObject2);
          ((JSONObject)localObject1).put("biu_enable", str);
          if (k <= 0) {
            break label457;
          }
          ((JSONObject)localObject1).put("biu_count", bhvy.b(k));
        }
        for (;;)
        {
          ((JSONObject)localObject1).put("setArticleInfo", paramBaseArticleInfo);
          paramJSONObject.put("id_biu_button", localObject1);
          paramBaseArticleInfo = new JSONObject();
          paramBaseArticleInfo.put("share_title", ajya.a(2131715947));
          paramJSONObject.put("id_share_button", paramBaseArticleInfo);
          paramJSONObject.put("id_social_bottom", new JSONObject());
          return;
          localJSONObject.put("selected_state", "0");
          break;
          localJSONObject.put("like_count", ajya.a(2131715988));
          break label243;
          ((JSONObject)localObject1).put("comment_count", ajya.a(2131716008));
          break label279;
          ((JSONObject)localObject1).put("biu_count", "Biu");
        }
        localObject1 = "1.0";
        str = "1";
      }
    }
  }
  
  static void D(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    int j = 0;
    if ((paramBaseArticleInfo == null) || ((paramBaseArticleInfo instanceof ArticleInfo))) {}
    label271:
    for (;;)
    {
      return;
      Object localObject = paramBaseArticleInfo.mSocialFeedInfo;
      int i;
      if (localObject != null)
      {
        j = ((SocializeFeedsInfo)localObject).jdField_b_of_type_Int;
        i = ((SocializeFeedsInfo)localObject).jdField_f_of_type_Int;
        QLog.d("Util", 2, new Object[] { "bindSocialData, articleId = ", Long.valueOf(paramBaseArticleInfo.mArticleID), " likeCount = ", Integer.valueOf(j), " biuCount = ", Integer.valueOf(i) });
      }
      for (;;)
      {
        if ((j <= 0) && (i <= 0)) {
          break label271;
        }
        paramJSONObject.put("id_social_separator_line", new JSONObject());
        paramJSONObject.put("id_social_data_wrapper", new JSONObject());
        if (j > 0)
        {
          paramBaseArticleInfo = bhvy.b(j) + ajya.a(2131716012);
          localObject = new JSONObject();
          paramJSONObject.put("social_data_like", paramBaseArticleInfo);
          paramJSONObject.put("id_social_data_like", localObject);
        }
        if ((j > 0) && (i > 0)) {
          paramJSONObject.put("id_social_data_dot", new JSONObject());
        }
        if (i <= 0) {
          break;
        }
        paramBaseArticleInfo = bhvy.b(i) + "Biu";
        localObject = new JSONObject();
        ((JSONObject)localObject).put("social_data_biu", paramBaseArticleInfo);
        paramJSONObject.put("id_social_data_biu", localObject);
        return;
        i = 0;
      }
    }
  }
  
  static void E(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    do
    {
      return;
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
    } while (((paramBaseArticleInfo.jdField_a_of_type_Qcg == null) || (paramBaseArticleInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList == null) || (paramBaseArticleInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.size() <= 0) || ((paramBaseArticleInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.size() == 1) && ((TextUtils.isEmpty(((SocializeFeedsInfo.BiuCommentInfo)paramBaseArticleInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString)) || (TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramBaseArticleInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, ":")) || (TextUtils.equals(((SocializeFeedsInfo.BiuCommentInfo)paramBaseArticleInfo.jdField_a_of_type_Qcg.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, "："))))) && (TextUtils.isEmpty(paramBaseArticleInfo.jdField_a_of_type_JavaLangString)));
    paramJSONObject.put("id_biu_comment", new JSONObject());
  }
  
  static void F(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    qda localqda;
    do
    {
      do
      {
        return;
      } while (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null);
      localqda = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda;
    } while (((!puy.c((ArticleInfo)paramBaseArticleInfo)) || (ram.d(paramBaseArticleInfo))) && (!onh.a(localqda)) && (TextUtils.isEmpty(localqda.jdField_a_of_type_JavaLangString)));
    paramJSONObject.put("id_article_comment", new JSONObject());
  }
  
  static void G(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_middle_body_wrapper", new JSONObject());
  }
  
  static void H(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_summary", new JSONObject());
  }
  
  static void I(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_article_comment", new JSONObject());
  }
  
  static void J(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (okz.a(paramBaseArticleInfo)) {}
    while ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
      return;
    }
    paramJSONObject.put("id_middle_body_content", new JSONObject());
  }
  
  static void K(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (okz.a(paramBaseArticleInfo)) {}
    while (ram.d(paramBaseArticleInfo)) {
      return;
    }
    paramJSONObject.put("id_middle_body_content", new JSONObject());
  }
  
  static void L(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!ram.e(paramBaseArticleInfo))
    {
      paramJSONObject.put("id_middle_body_content", new JSONObject());
      if (paramBaseArticleInfo.mFeedType == 30) {
        paramJSONObject.remove("id_summary");
      }
    }
  }
  
  static void M(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (okz.a(paramBaseArticleInfo)) {
      return;
    }
    paramJSONObject.put("id_middle_body_content", new JSONObject());
  }
  
  static void N(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.businessName)) && (!paramBaseArticleInfo.isSuperTopic))
    {
      paramJSONObject.put("id_capsule", new JSONObject());
      paramJSONObject.put("id_capsule_topic_tag", new JSONObject());
      if (!TextUtils.isEmpty(paramBaseArticleInfo.businessNamePrefix))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_topic_pre", "topic_pre_image");
        paramJSONObject.put("id_capsule_topic_pre", localJSONObject);
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("capsule_topic_name", onh.a(paramBaseArticleInfo.businessName, a(paramBaseArticleInfo)));
      paramJSONObject.put("id_capsule_topic_name", localJSONObject);
    }
  }
  
  static void O(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("Util", 2, "bindCommunityCapsule info or socialFeedInfo is null");
      }
    }
    qch localqch;
    do
    {
      do
      {
        return;
        localqch = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qch;
      } while (localqch == null);
      if ((!TextUtils.isEmpty(localqch.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(localqch.jdField_d_of_type_JavaLangString))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Util", 2, "bindCommunityCapsule buluoInfo name or headUrl is empty");
    return;
    paramJSONObject.put("id_capsule", new JSONObject());
    paramJSONObject.put("id_capsule_community_tag", new JSONObject());
    if (!TextUtils.isEmpty(localqch.jdField_d_of_type_JavaLangString))
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("capsule_community_pre", localqch.jdField_d_of_type_JavaLangString);
      paramJSONObject.put("id_capsule_community_pre", localJSONObject);
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("capsule_community_name", onh.a(localqch.jdField_c_of_type_JavaLangString, a(paramBaseArticleInfo)));
    paramJSONObject.put("id_capsule_community_name", localJSONObject);
    nol.a(null, "", "0X8009BA5", "0X8009BA5", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), localqch.jdField_a_of_type_Long + "", paramBaseArticleInfo.mChannelID + "", "", false);
  }
  
  static void P(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    SocializeFeedsInfo localSocializeFeedsInfo;
    do
    {
      do
      {
        return;
        localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
        if (!piw.a((ArticleInfo)paramBaseArticleInfo)) {
          break;
        }
      } while (!paramBaseArticleInfo.isNeedShowBtnWhenFollowed);
      paramBaseArticleInfo = new JSONObject();
      paramBaseArticleInfo.put("button_status", ajya.a(2131715990));
      paramBaseArticleInfo.put("selected_status", "1");
      paramJSONObject.put("id_social_header_follow_button", paramBaseArticleInfo);
      return;
    } while (localSocializeFeedsInfo.h != 1);
    paramBaseArticleInfo = new JSONObject();
    paramBaseArticleInfo.put("button_status", ajya.a(2131715991));
    paramBaseArticleInfo.put("selected_status", "0");
    paramJSONObject.put("id_social_header_follow_button", paramBaseArticleInfo);
  }
  
  static void Q(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    SocializeFeedsInfo localSocializeFeedsInfo;
    do
    {
      return;
      localSocializeFeedsInfo = paramBaseArticleInfo.mSocialFeedInfo;
      if (localSocializeFeedsInfo.h == 1)
      {
        paramBaseArticleInfo = new JSONObject();
        paramBaseArticleInfo.put("button_status", ajya.a(2131715987));
        paramBaseArticleInfo.put("selected_status", "0");
        paramJSONObject.put("id_social_header_follow_button", paramBaseArticleInfo);
        return;
      }
    } while ((!paramBaseArticleInfo.isNeedShowBtnWhenFollowed) || (localSocializeFeedsInfo.h != 2));
    paramBaseArticleInfo = new JSONObject();
    paramBaseArticleInfo.put("button_status", ajya.a(2131716011));
    paramBaseArticleInfo.put("selected_status", "1");
    paramJSONObject.put("id_social_header_follow_button", paramBaseArticleInfo);
  }
  
  static void R(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde;
        } while (paramBaseArticleInfo == null);
        if ((TextUtils.isEmpty(paramBaseArticleInfo.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(paramBaseArticleInfo.jdField_d_of_type_JavaLangString))) {
          break;
        }
        paramJSONObject.put("id_super_topic", new JSONObject());
        localJSONObject = new JSONObject();
        if (TextUtils.isEmpty(paramBaseArticleInfo.jdField_c_of_type_JavaLangString)) {
          paramBaseArticleInfo.jdField_c_of_type_JavaLangString = "https://sqimg.qq.com/qq_product_operations/kan/images/super_wenda_default.png";
        }
        localJSONObject.put("super_topic_avator_url", paramBaseArticleInfo.jdField_c_of_type_JavaLangString);
        paramJSONObject.put("id_super_topic_avator", localJSONObject);
        if (!TextUtils.isEmpty(paramBaseArticleInfo.n))
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("super_topic_button_title", paramBaseArticleInfo.n);
          paramJSONObject.put("id_super_topic_button", localJSONObject);
        }
        localJSONObject = new JSONObject();
        localJSONObject.put("super_topic_name", paramBaseArticleInfo.jdField_b_of_type_JavaLangString);
        paramJSONObject.put("id_super_topic_name", localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("super_topic_subname", ComponentSocialOperation.a(paramBaseArticleInfo.jdField_b_of_type_Int) + ajya.a(2131716006) + ComponentSocialOperation.a(paramBaseArticleInfo.jdField_a_of_type_Int) + ajya.a(2131716013));
        paramJSONObject.put("id_super_topic_subname", localJSONObject);
      } while (TextUtils.isEmpty(paramBaseArticleInfo.jdField_e_of_type_JavaLangString));
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("super_topic_hot_icon_url", paramBaseArticleInfo.jdField_e_of_type_JavaLangString);
      paramJSONObject.put("id_super_topic_hot_icon", localJSONObject);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("Util", 2, "bindSuperTopic something is null,wendaInfo.wendaUrl=" + paramBaseArticleInfo.jdField_d_of_type_JavaLangString + ",wendaInfo.questionDes=" + paramBaseArticleInfo.jdField_b_of_type_JavaLangString);
  }
  
  public static void S(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!qav.a(paramBaseArticleInfo))) {
      return;
    }
    paramJSONObject.put("id_pack_bottom", new JSONObject());
    paramJSONObject.put("id_pack_bottom_separator_line", new JSONObject());
    paramBaseArticleInfo = new JSONObject();
    paramBaseArticleInfo.put("pack_bottom_imageview", "qqreadinjoy_kandian_down_arrow.png");
    paramJSONObject.put("id_pack_bottom_imageview", paramBaseArticleInfo);
  }
  
  static void T(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl != null))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl;
      paramJSONObject.put("id_capsule", new JSONObject());
      paramJSONObject.put("id_capsule_common_tag", new JSONObject());
      JSONObject localJSONObject;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_a_of_type_JavaLangString))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_common_pre_url", paramBaseArticleInfo.jdField_a_of_type_JavaLangString);
        paramJSONObject.put("id_capsule_common_pre", localJSONObject);
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_b_of_type_JavaLangString))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("capsule_common_name", paramBaseArticleInfo.jdField_b_of_type_JavaLangString);
        paramJSONObject.put("id_capsule_common_name", localJSONObject);
      }
    }
  }
  
  static void U(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy == null)) {}
    int i;
    long l;
    do
    {
      return;
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy;
      i = paramBaseArticleInfo.jdField_a_of_type_Int;
      l = paramBaseArticleInfo.jdField_a_of_type_Long;
    } while ((onh.a() != l) || (i == 0));
    paramJSONObject.put("id_capsule", new JSONObject());
    paramJSONObject.put("id_capsule_privacy_tag", new JSONObject());
    Object localObject = "";
    paramBaseArticleInfo = "";
    if (i == 1)
    {
      localObject = "readinjoy_privacy_vis_some.png";
      paramBaseArticleInfo = ajya.a(2131716004);
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("capsule_privacy_pre", localObject);
      paramJSONObject.put("id_capsule_privacy_pre", localJSONObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("capsule_privacy_name", paramBaseArticleInfo);
      paramJSONObject.put("id_capsule_privacy_name", localObject);
      return;
      if (i == 2)
      {
        localObject = "readinjoy_privacy_vis_self.png";
        paramBaseArticleInfo = ajya.a(2131715989);
      }
    }
  }
  
  public static void V(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcn == null)) {}
    qcn localqcn;
    do
    {
      return;
      localqcn = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcn;
    } while ((TextUtils.isEmpty(localqcn.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localqcn.jdField_b_of_type_JavaLangString)));
    paramJSONObject.put("id_capsule", new JSONObject());
    paramJSONObject.put("id_capsule_lbs_tag", new JSONObject());
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("capsule_lbs_pre_url", localqcn.jdField_b_of_type_JavaLangString);
    paramJSONObject.put("id_capsule_lbs_pre", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("capsule_lbs_name", onh.a(localqcn.jdField_a_of_type_JavaLangString, a(paramBaseArticleInfo)));
    paramJSONObject.put("id_capsule_lbs_name", localJSONObject);
  }
  
  public static void W(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_socialize_recommend_follow", new JSONObject());
  }
  
  static void X(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramBaseArticleInfo = new JSONObject();
    paramBaseArticleInfo.put("social_header_fold", "social_header_fold");
    paramJSONObject.put("social_header_fold_button", paramBaseArticleInfo);
  }
  
  public static void Y(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = new JSONObject();
    if (paramBaseArticleInfo.hasAwesome)
    {
      if (qam.jdField_c_of_type_Int == 1)
      {
        ((JSONObject)localObject).put("icon_awesome_url", paramBaseArticleInfo.icon_url);
        ((JSONObject)localObject).put("icon_jump_url", paramBaseArticleInfo.jump_url);
        if (paramBaseArticleInfo.icon_height != 0) {
          ((JSONObject)localObject).put("icon_awesome_wh_rate", paramBaseArticleInfo.icon_with / paramBaseArticleInfo.icon_height);
        }
        paramJSONObject.put("id_icon_awesome", localObject);
      }
      if (qam.jdField_c_of_type_Int == 2)
      {
        localObject = new qam();
        ((qam)localObject).jdField_a_of_type_JavaLangString = paramBaseArticleInfo.rawkey;
        ((qam)localObject).jdField_b_of_type_Int = paramBaseArticleInfo.icon_height;
        ((qam)localObject).jdField_a_of_type_Int = paramBaseArticleInfo.icon_with;
        ((qam)localObject).jdField_a_of_type_Long = paramBaseArticleInfo.uin;
        ((qam)localObject).jdField_b_of_type_JavaLangString = paramBaseArticleInfo.icon_url;
        ((qam)localObject).jdField_d_of_type_JavaLangString = paramBaseArticleInfo.nick_name;
        ((qam)localObject).jdField_e_of_type_JavaLangString = paramBaseArticleInfo.avatar;
        ((qam)localObject).jdField_f_of_type_JavaLangString = paramBaseArticleInfo.comment_id;
        ((qam)localObject).jdField_c_of_type_JavaLangString = paramBaseArticleInfo.jump_url;
        ((qam)localObject).g = paramBaseArticleInfo.content;
        ((qam)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("awesomeCommentInfo", localObject);
        paramJSONObject.put("id_awesomeview_mutlilines", localJSONObject);
      }
      if ((!TextUtils.isEmpty(paramBaseArticleInfo.icon_url)) && ((qam.jdField_c_of_type_Int == 1) || (qam.jdField_c_of_type_Int == 2))) {
        qam.a(paramBaseArticleInfo, "0X8009B76");
      }
      QLog.d("Util", 2, "bindAwesomeCommentInfo: " + paramJSONObject);
    }
  }
  
  static void Z(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        bool = osg.a().a(paramBaseArticleInfo.mArticleID);
        paramJSONObject.optString("style_ID");
        if (TextUtils.isEmpty(paramJSONObject.optString("article_main_body_text"))) {
          break label70;
        }
        if (!bool) {
          break label81;
        }
        paramBaseArticleInfo = "#999999";
        paramJSONObject.put("article_main_body_text_color", paramBaseArticleInfo);
      }
      catch (Exception paramBaseArticleInfo)
      {
        return;
      }
      paramJSONObject.put("readable_title_text_color", paramBaseArticleInfo);
      return;
      paramBaseArticleInfo = "#262626";
      continue;
      label70:
      if (bool)
      {
        paramBaseArticleInfo = "#999999";
        continue;
        label81:
        paramBaseArticleInfo = "#737373";
      }
    }
  }
  
  private static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    int j = b(paramBaseArticleInfo);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    QLog.d("Util", 1, new Object[] { "getCapsuleMaxStrLen, count = ", Integer.valueOf(i), "len = ", Integer.valueOf(48 / i) });
    return 48 / i;
  }
  
  private static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mSinglePicture != null) && (paramBaseArticleInfo.mNewPolymericInfo != null) && (!paramBaseArticleInfo.mNewPolymericInfo.b))
    {
      String str = paramBaseArticleInfo.mSinglePicture.getFile();
      Pair localPair = omr.f();
      str = onh.a(str, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
      paramBaseArticleInfo.mSinglePicture = onh.a(str);
      paramBaseArticleInfo.mNewPolymericInfo.b = true;
      if (QLog.isColorLevel()) {
        QLog.e("ComponentContentBigImageVideo", 2, " handled url = " + str);
      }
    }
    return paramBaseArticleInfo.mSinglePicture.getFile();
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static JSONObject a()
  {
    return new JSONObject();
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, int paramInt, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
    {
      QLog.i("Util", 1, "[bindSmallVideo], outData is null.");
      return;
    }
    if (paramBaseArticleInfo == null)
    {
      QLog.i("Util", 1, "[bindSmallVideo], info is null");
      return;
    }
    paramBaseArticleInfo = paramBaseArticleInfo.mGroupSubArticleList;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.size() > 0))
    {
      paramInt = 0;
      label48:
      Object localObject;
      if (paramInt < paramBaseArticleInfo.size())
      {
        localObject = (ArticleInfo)paramBaseArticleInfo.get(paramInt);
        if (localObject != null) {
          break label91;
        }
        QLog.i("Util", 1, "[bindSmallVideo], item articleInfo is null.");
      }
      for (;;)
      {
        paramInt += 1;
        break label48;
        break;
        label91:
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("style_ID", "ReadInjoy_pack_long_video_cell");
          localObject = (qbo)((ArticleInfo)localObject).mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
          localJSONObject.put("article_large_imge_url", onh.a(((qbo)localObject).jdField_c_of_type_JavaLangString, Utils.dp2px(165.0D), Utils.dp2px(293.0D)));
          if (((qbo)localObject).jdField_a_of_type_Qbr != null) {
            localJSONObject.put("video_play_duration", muc.a(((qbo)localObject).jdField_a_of_type_Qbr.jdField_d_of_type_Int));
          }
          QLog.i("Util", 1, "[bindSmallVideo], item = " + localJSONObject);
          paramJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          QLog.e("Util", 1, "[bindSmallVideo], e = " + localJSONException);
        }
        catch (Exception localException)
        {
          QLog.e("Util", 1, "[bindSmallVideo], e = " + localException);
        }
      }
    }
    QLog.i("Util", 1, "[bindSmallVideo], dataList is empty.");
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject1;
    if (!TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText))
    {
      if ((paramBaseArticleInfo instanceof AdvertisementInfo))
      {
        paramJSONObject.put("id_info_operate_parent", new JSONObject());
        paramJSONObject.put("id_large_cell_container", new JSONObject());
        localJSONObject1 = new JSONObject(((AdvertisementInfo)paramBaseArticleInfo).mAdExtInfo);
      }
    }
    else {
      try
      {
        if (localJSONObject1.has("AdsIconText"))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Util", 2, "detail ad  bindSubscriptText adInconText:" + localJSONObject1.optString("AdsIconText"));
          }
          if (!TextUtils.isEmpty(localJSONObject1.optString("AdsIconText")))
          {
            JSONObject localJSONObject3 = new JSONObject();
            localJSONObject3.put("info_status_text", localJSONObject1.optString("AdsIconText"));
            localJSONObject3.put("info_status_text_color", paramBaseArticleInfo.mArticleSubscriptColor);
            paramJSONObject.put("id_info_status", localJSONObject3);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("info_status_text", a(paramBaseArticleInfo.mArticleSubscriptText));
    localJSONObject2.put("info_status_text_color", paramBaseArticleInfo.mArticleSubscriptColor);
    paramJSONObject.put("id_info_status", localJSONObject2);
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, Long paramLong)
  {
    paramBaseArticleInfo = new JSONObject();
    paramBaseArticleInfo.put("info_avator_uin", paramLong);
    paramJSONObject.put("id_info_avator", paramBaseArticleInfo);
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    String str = paramString;
    if (paramBaseArticleInfo != null)
    {
      str = paramString;
      if (paramBaseArticleInfo.mSocialFeedInfo != null)
      {
        str = paramString;
        if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_JavaLangString)) {
          str = paramBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_JavaLangString;
        }
      }
    }
    localJSONObject.put("biu_tips_text", str);
    paramJSONObject.put("id_biu_tips", localJSONObject);
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    if (!"guide_card_type".equals(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        if ("1".equals(String.valueOf(paramObject)))
        {
          QLog.d("Util", 1, "bindSpecialData, show flow guide separator.");
          paramJSONObject.put("flow_guide_separator_color", "#f2f2f2");
          return;
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        QLog.d("Util", 1, "bindSpecialData, e = ", paramBaseArticleInfo);
      }
    }
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
  {
    String str = paramBaseArticleInfo.mTitle;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("artilce_title_text", str);
    boolean bool = osg.a().a(paramBaseArticleInfo.mArticleID);
    if (paramBoolean) {
      if (!bool) {
        break label81;
      }
    }
    label81:
    for (paramBaseArticleInfo = "#999999";; paramBaseArticleInfo = "#262626")
    {
      localJSONObject.put("title_text_color", paramBaseArticleInfo);
      localJSONObject.put("article_title_text_line_space", "0");
      paramJSONObject.put("id_artilce_title", localJSONObject);
      return;
    }
  }
  
  static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean, String paramString)
  {
    String str = paramBaseArticleInfo.mTitle;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("artilce_title_text", str);
    boolean bool = osg.a().a(paramBaseArticleInfo.mArticleID);
    if (paramBoolean) {
      if (bool)
      {
        paramBaseArticleInfo = "#999999";
        localJSONObject.put("title_text_color", paramBaseArticleInfo);
      }
    }
    for (;;)
    {
      localJSONObject.put("article_title_text_line_space", paramString);
      paramJSONObject.put("id_artilce_title", localJSONObject);
      return;
      paramBaseArticleInfo = "#262626";
      break;
      localJSONObject.put("title_text_color", "#ffffff");
    }
  }
  
  public static void a(ViewBase paramViewBase, pau parampau)
  {
    if ((paramViewBase == null) || (parampau == null)) {}
    long l;
    do
    {
      do
      {
        return;
        parampau = parampau.a();
      } while ((parampau == null) || (parampau.mSocialFeedInfo == null) || (parampau.mSocialFeedInfo.jdField_a_of_type_Qci == null));
      l = parampau.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
      paramViewBase = (pmg)paramViewBase.findViewBaseByName("id_nickname");
    } while (paramViewBase == null);
    paramViewBase.a(l);
  }
  
  static void a(JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_comment_edit", new JSONObject());
    paramJSONObject.put("id_comment_edit_label", new JSONObject());
  }
  
  public static void a(JSONObject paramJSONObject, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.proteusItemsData == null)) {
      return;
    }
    QLog.d("Util", 2, "addProteusDynamicData" + paramBaseArticleInfo.proteusItemsData);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramBaseArticleInfo.proteusItemsData);
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = localJSONObject.opt(str);
        if (localObject != null) {
          paramJSONObject.put(str, localObject);
        }
        a(paramBaseArticleInfo, paramJSONObject, str, localObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("Util", 2, "addProteusDynamicData", localJSONException);
      QLog.d("Util", 1, "addProteusDynamicData | " + paramJSONObject.toString());
      Z(paramBaseArticleInfo, paramJSONObject);
    }
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return (!TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData)) && (new JSONObject(paramBaseArticleInfo.proteusItemsData).has("module_bottom_name"));
  }
  
  static void aa(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {}
    Object localObject1;
    double d;
    label25:
    Object localObject3;
    do
    {
      return;
      localObject1 = nmc.a(paramBaseArticleInfo);
      if (localObject1 != null) {
        break;
      }
      d = 0.0D;
      localObject3 = ((AdvertisementInfo)paramBaseArticleInfo).mLocalInfo;
    } while (localObject3 == null);
    if (QLog.isColorLevel()) {
      QLog.d("Util", 2, "bindAdPositionInfoNew localInfo ->" + localObject3);
    }
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        localObject1 = ((qbk)localObject3).h;
        paramBaseArticleInfo = ((qbk)localObject3).jdField_c_of_type_JavaLangString;
        localObject2 = ((qbk)localObject3).jdField_f_of_type_JavaLangString;
        localObject3 = ((qbk)localObject3).jdField_b_of_type_JavaLangString;
        i = nmh.a((String)localObject1, 3000);
        if (d > 0.0D) {
          break label247;
        }
        localObject1 = "";
        d = 0.0D;
        localStringBuilder = new StringBuilder();
        if (d == 0.0D) {
          break label383;
        }
        if (d <= i) {
          break label258;
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        i = 1;
        if (i == 0) {
          break label368;
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("ad_Location", paramBaseArticleInfo);
        ((JSONObject)localObject2).put("ad_Location_content", localObject1);
        ((JSONObject)localObject2).put("ad_url", localObject3);
        paramBaseArticleInfo = new JSONObject();
        paramBaseArticleInfo.put("ad_Location", localObject2);
        paramJSONObject.put("id_view_ad_locationView", paramBaseArticleInfo);
        return;
        d = nmc.a((double[])localObject1, BaseApplicationImpl.getContext());
        break label25;
        label247:
        d = Math.ceil(d);
        localObject1 = null;
        continue;
        label258:
        if (d < 1000.0D)
        {
          localStringBuilder.append((int)d).append('m');
          localObject2 = localStringBuilder.toString();
          localObject1 = paramBaseArticleInfo;
          paramBaseArticleInfo = (BaseArticleInfo)localObject2;
          continue;
        }
        if (d >= i) {
          break label370;
        }
        long l = Math.round(d / 1000.0D);
        if (l < 1000L) {
          localStringBuilder.append(l).append("km");
        }
        for (;;)
        {
          localObject2 = localStringBuilder.toString();
          localObject1 = paramBaseArticleInfo;
          paramBaseArticleInfo = (BaseArticleInfo)localObject2;
          break;
          localStringBuilder.append("999km");
        }
      }
      int i = 0;
      continue;
      label368:
      break;
      label370:
      Object localObject2 = paramBaseArticleInfo;
      paramBaseArticleInfo = (BaseArticleInfo)localObject1;
      localObject1 = localObject2;
      continue;
      label383:
      paramBaseArticleInfo = "";
      localObject1 = localObject2;
    }
  }
  
  static void ab(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mPartnerAccountInfo == null) || (!paramBaseArticleInfo.isAccountShown)) {
      return;
    }
    paramJSONObject.put("info_avator_uin", paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get());
    paramJSONObject.put("partner_nickname_text", onh.d(ReadInJoyUserInfoModule.a()));
    paramJSONObject.put("partner_info_text", onh.a(paramBaseArticleInfo.mPartnerAccountInfo.bytes_recommend_reason.get().toStringUtf8(), 36));
    P(paramBaseArticleInfo, paramJSONObject);
    String str2 = "";
    String str1 = str2;
    if (paramBaseArticleInfo.mPartnerAccountInfo.has())
    {
      str1 = str2;
      if (paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url.has())
      {
        str1 = paramBaseArticleInfo.mPartnerAccountInfo.bytes_head_jump_url.get().toStringUtf8();
        paramJSONObject.put("partner_head_jump_url", str1);
      }
    }
    int i = onh.c(paramBaseArticleInfo);
    paramJSONObject.put("account_expose_card", i);
    paramJSONObject.put("partner_jump_url", paramBaseArticleInfo.mArticleContentUrl);
    QLog.d("Util", 1, new Object[] { "bindPartnerInfo, partner_head_jump_url = ", str1, " proteusItemsData=", paramBaseArticleInfo.proteusItemsData, "  partner_jump_url=", paramBaseArticleInfo.mArticleContentUrl, " ,account_expose_card=", Integer.valueOf(i) });
  }
  
  public static void ac(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    int i;
    if (TextUtils.isEmpty(paramBaseArticleInfo.mSearchWordTitle))
    {
      paramJSONObject.remove(phy.jdField_a_of_type_JavaLangString);
      int j = paramBaseArticleInfo.mSearchWords.size();
      i = 0;
      label28:
      if (i >= j) {
        return;
      }
      RequestSearchWord.Rcmd localRcmd = (RequestSearchWord.Rcmd)paramBaseArticleInfo.mSearchWords.get(i);
      if (localRcmd == null) {
        break label112;
      }
      paramJSONObject.put(phy.b[i], localRcmd.word.get().toStringUtf8());
      paramJSONObject.put(phy.jdField_a_of_type_ArrayOfJavaLangString[i], localRcmd.jmp_url.get());
    }
    for (;;)
    {
      i += 1;
      break label28;
      paramJSONObject.put(phy.jdField_a_of_type_JavaLangString, paramBaseArticleInfo.mSearchWordTitle);
      break;
      label112:
      paramJSONObject.remove(phy.b[i]);
      paramJSONObject.remove(phy.jdField_a_of_type_ArrayOfJavaLangString[i]);
    }
  }
  
  public static void ad(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qck != null))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qck;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_e_of_type_JavaLangString))
      {
        paramJSONObject.put("live_hot_icon_url", "http://pub.idqqimg.com/pc/misc/files/20191127/0be49e55346742bd847bcef3941ec4d4.png");
        paramJSONObject.put("live_hot_text", paramBaseArticleInfo.jdField_e_of_type_JavaLangString);
      }
      if (paramBaseArticleInfo.jdField_a_of_type_Int != 0) {
        break label106;
      }
      paramJSONObject.put("live_status_bg_url", "http://pub.idqqimg.com/pc/misc/files/20191127/d3d83721dfe84278a19c8927e2253f10.png");
      paramJSONObject.put("live_status_text", ajya.a(2131718483));
    }
    for (;;)
    {
      paramJSONObject.put("live_show", "1");
      return;
      label106:
      paramJSONObject.put("live_status_icon_url", "http://pub.idqqimg.com/pc/misc/files/20191127/b7e14064b3d1417788352c8a47d1e85a.gif");
      paramJSONObject.put("live_status_bg_url", "http://pub.idqqimg.com/pc/misc/files/20191127/84cf4158acb64cc0a7bf1d3a8f1b9d27.png");
      paramJSONObject.put("live_status_text", ajya.a(2131718484));
    }
  }
  
  public static void ae(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_play_icon", "ReadInJoy/rij_play_icon.png");
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void af(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_audio_icon", "video_audio_mute");
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void ag(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_title", paramBaseArticleInfo.mTitle);
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void ah(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.a != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_play_count", qoi.c((int)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.a.jdField_a_of_type_Long) + "播放");
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void ai(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.a != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_duration", qoi.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.a.jdField_a_of_type_Int * 1000L));
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  public static void aj(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.a != null) && (paramJSONObject != null)) {}
    try
    {
      paramJSONObject.put("pgc_video_content_vid", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.a.jdField_e_of_type_JavaLangString);
      paramJSONObject.put("pgc_video_content_cover", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.a.jdField_d_of_type_JavaLangString);
      paramJSONObject.put("pgc_video_content_busitype", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qco.a.jdField_b_of_type_Int);
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      paramBaseArticleInfo.printStackTrace();
    }
  }
  
  private static void ak(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    int i = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int;
    String str3 = "";
    String str4 = "";
    String str2;
    String str1;
    if ((ram.c(paramBaseArticleInfo)) || (ram.b(paramBaseArticleInfo)))
    {
      str2 = BaseApplicationImpl.getContext().getString(2131718589);
      str1 = "poly_topic";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str2))
      {
        paramJSONObject.put("corner_text", str2);
        paramJSONObject.put("corner_icon", str1);
      }
      return;
      if ((i == 27) || ((i == 18) && (!paramBaseArticleInfo.isPGCShortContent())) || (i == 31) || ((onh.s(paramBaseArticleInfo)) && (!onh.e(paramBaseArticleInfo))))
      {
        str2 = BaseApplicationImpl.getContext().getString(2131718334);
        str1 = "poly_article";
      }
      else if (i == 52)
      {
        str2 = String.valueOf(paramBaseArticleInfo.mGalleryPicNumber) + ajya.a(2131702265);
        str1 = "poly_gallery";
      }
      else if (i != 48)
      {
        str1 = str4;
        str2 = str3;
        if (i != 49) {}
      }
      else
      {
        str1 = str4;
        str2 = str3;
        if (paramBaseArticleInfo.mSocialFeedInfo != null)
        {
          str1 = str4;
          str2 = str3;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv != null)
          {
            str1 = str4;
            str2 = str3;
            if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.a != null)
            {
              str2 = String.valueOf(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.a.jdField_a_of_type_Long) + ajya.a(2131702322);
              str1 = "poly_gallery";
            }
          }
        }
      }
    }
  }
  
  private static void al(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((osg.a().a(null)) && ((paramBaseArticleInfo instanceof AdvertisementInfo)))
    {
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mAdExtInfo)) {
        break label33;
      }
    }
    for (;;)
    {
      return;
      try
      {
        label33:
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.mAdExtInfo);
        double d1 = paramBaseArticleInfo.getDouble("latitude");
        double d2 = paramBaseArticleInfo.getDouble("longitude");
        paramBaseArticleInfo = akuf.a("readinjoy_feed_ad_distance");
        if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.a != null))
        {
          double d3 = paramBaseArticleInfo.a.a;
          double d4 = paramBaseArticleInfo.a.b;
          if ((d3 >= 0.0D) && (d4 >= 0.0D) && (d1 >= 0.0D) && (d2 >= 0.0D))
          {
            paramBaseArticleInfo = nmc.a(TencentLocationUtils.distanceBetween(d3, d4, d1, d2));
            paramJSONObject.put("id_ad_position_container", new JSONObject());
            paramJSONObject.put("ad_position", paramBaseArticleInfo);
            return;
          }
        }
      }
      catch (Exception paramBaseArticleInfo) {}
    }
  }
  
  private static int b(BaseArticleInfo paramBaseArticleInfo)
  {
    int i;
    if (paramBaseArticleInfo != null) {
      if ((!TextUtils.isEmpty(paramBaseArticleInfo.businessName)) && (!paramBaseArticleInfo.isSuperTopic))
      {
        i = 1;
        j = i;
        if (paramBaseArticleInfo.mSocialFeedInfo != null)
        {
          j = i;
          Object localObject;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcn != null)
          {
            localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcn;
            j = i;
            if (!TextUtils.isEmpty(((qcn)localObject).jdField_a_of_type_JavaLangString))
            {
              j = i;
              if (!TextUtils.isEmpty(((qcn)localObject).jdField_b_of_type_JavaLangString)) {
                j = i + 1;
              }
            }
          }
          i = j;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy != null)
          {
            localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy;
            int k = ((qcy)localObject).jdField_a_of_type_Int;
            long l = ((qcy)localObject).jdField_a_of_type_Long;
            i = j;
            if (onh.a() == l)
            {
              i = j;
              if (k != 0) {
                i = j + 1;
              }
            }
          }
          j = i;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qch != null)
          {
            paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qch;
            j = i;
            if (!TextUtils.isEmpty(paramBaseArticleInfo.jdField_c_of_type_JavaLangString))
            {
              j = i;
              if (TextUtils.isEmpty(paramBaseArticleInfo.jdField_d_of_type_JavaLangString)) {}
            }
          }
        }
      }
    }
    for (int j = i + 1;; j = 0)
    {
      QLog.d("Util", 1, new Object[] { "getCapsuleCount = ", Integer.valueOf(j) });
      return j;
      i = 0;
      break;
    }
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo, int paramInt, JSONArray paramJSONArray)
  {
    if ((paramBaseArticleInfo.mGroupSubArticleList != null) && (paramBaseArticleInfo.mGroupSubArticleList.size() > 0))
    {
      Iterator localIterator = paramBaseArticleInfo.mGroupSubArticleList.iterator();
      if (localIterator.hasNext())
      {
        paramBaseArticleInfo = (BaseArticleInfo)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        paramInt = paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int;
        if (onh.e(paramBaseArticleInfo))
        {
          localJSONObject.put("style_ID", "ReadInjoy_pack_cell_big_gallery");
          label83:
          if (!onh.c(paramBaseArticleInfo)) {
            break label401;
          }
          localJSONObject.put("article_large_imge_url", a(paramBaseArticleInfo));
          if (bbfj.h(BaseApplicationImpl.getContext())) {
            break label375;
          }
          localJSONObject.put("id_play_text_container", new JSONObject());
          localJSONObject.put("id_layout_bottom_cover", new JSONObject());
          localJSONObject.put("id_play_text_icon", new JSONObject());
          if (bbwq.a() != 1) {
            break label307;
          }
          localJSONObject.put("play_text", ajya.a(2131702262));
          label181:
          if ((paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() > 0) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0) != null)) {
            localJSONObject.put("artilce_title_text", ((qbo)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
          }
          if (!osg.a().a(paramBaseArticleInfo.mArticleID)) {
            break label394;
          }
        }
        label394:
        for (paramBaseArticleInfo = "#999999";; paramBaseArticleInfo = "#000000")
        {
          localJSONObject.put("title_text_color", paramBaseArticleInfo);
          paramJSONArray.put(localJSONObject);
          break;
          localJSONObject.put("style_ID", "ReadInjoy_pack_cell_big_img");
          break label83;
          label307:
          if (paramBaseArticleInfo.mXGFileSize > 0L)
          {
            localJSONObject.put("play_text", qoi.b(paramBaseArticleInfo.mXGFileSize) + ajya.a(2131702315));
            break label181;
          }
          localJSONObject.put("play_text", ajya.a(2131702347));
          break label181;
          label375:
          localJSONObject.put("id_play_icon", new JSONObject());
          break label181;
        }
        label401:
        localJSONObject.put("article_large_imge_url", onh.a(((qbo)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_c_of_type_JavaLangString, true, true).getFile());
        ak(paramBaseArticleInfo, localJSONObject);
        al(paramBaseArticleInfo, localJSONObject);
        if ((paramBaseArticleInfo.mNewPolymericInfo != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList != null) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() > 0) && (paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0) != null)) {
          localJSONObject.put("artilce_title_text", ((qbo)paramBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
        }
        if (osg.a().a(paramBaseArticleInfo.mArticleID)) {}
        for (paramBaseArticleInfo = "#999999";; paramBaseArticleInfo = "#000000")
        {
          localJSONObject.put("title_text_color", paramBaseArticleInfo);
          break;
        }
      }
    }
  }
  
  static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("info_source_text", a(paramBaseArticleInfo.mSubscribeName));
    paramJSONObject.put("id_info_source", localJSONObject);
    if (!TextUtils.isEmpty(paramBaseArticleInfo.vIconUrl)) {
      paramJSONObject.put("icon_v_url", paramBaseArticleInfo.vIconUrl);
    }
  }
  
  static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    if (okz.a(paramBaseArticleInfo)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    paramBaseArticleInfo = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramBaseArticleInfo = ajya.a(2131715997);
    }
    localJSONObject.put("read_article", paramBaseArticleInfo);
    paramJSONObject.put("id_read_article", localJSONObject);
    paramJSONObject.put("id_read_article_wrapper", new JSONObject());
  }
  
  public static void b(ViewBase paramViewBase, pau parampau)
  {
    if ((paramViewBase == null) || (parampau == null)) {}
    pmg localpmg;
    do
    {
      return;
      parampau = parampau.a();
      localpmg = (pmg)paramViewBase.findViewBaseByName("id_pack_bottom_label");
      paramViewBase = paramViewBase.findViewBaseByName("id_pack_bottom");
    } while ((localpmg == null) || (paramViewBase == null));
    if ((parampau != null) && (parampau.mSocialFeedInfo != null) && (parampau.mSocialFeedInfo.jdField_a_of_type_Qci != null) && (qav.a(parampau)))
    {
      long l = parampau.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
      localpmg.a("%s还biu了" + parampau.mExtraBiuBriefInfo.jdField_a_of_type_JavaUtilArrayList.size() + ajya.a(2131716005), l);
      localpmg.setVisibility(0);
      paramViewBase.setVisibility(0);
      return;
    }
    paramViewBase.setVisibility(8);
  }
  
  static void b(JSONObject paramJSONObject)
  {
    Object localObject = bhvy.a("kd_topic_recommend_card_jump_switch");
    if ((localObject instanceof Boolean)) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      QLog.d("Util", 1, new Object[] { "bindTopicRecommendCardJumpWrapper, isJumpSwitchOn = ", Boolean.valueOf(bool) });
      if (bool) {
        paramJSONObject.put("id_jump_wrapper", new JSONObject());
      }
      return;
    }
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool = true;
    if (paramBaseArticleInfo == null) {}
    do
    {
      return false;
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
    } while (paramBaseArticleInfo == null);
    if (paramBaseArticleInfo.h == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  static void c(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramBaseArticleInfo = nmc.a(paramBaseArticleInfo, BaseApplicationImpl.getContext(), "latitude", "longitude");
    if (!TextUtils.isEmpty(paramBaseArticleInfo))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ad_Location", paramBaseArticleInfo);
      paramJSONObject.put("id_view_ad_coordinateView", localJSONObject);
    }
  }
  
  public static void c(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, String paramString)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj != null))
    {
      localObject1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj.jdField_b_of_type_JavaLangString;
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("artilce_title_text", localObject1);
      if (!osg.a().a(paramBaseArticleInfo.mArticleID)) {
        break label508;
      }
      localObject1 = "#999999";
      ((JSONObject)localObject2).put("title_text_color", localObject1);
      paramJSONObject.put("id_artilce_title", localObject2);
      localObject1 = "";
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj.jdField_c_of_type_JavaLangString)) {
        localObject1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj.jdField_c_of_type_JavaLangString;
      }
      ((JSONObject)localObject2).put("summary_text", localObject1);
      paramJSONObject.put("id_summary", localObject2);
      i = 12;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("article_small_imge_url", onh.a(paramString, Utils.rp2px(114.0D), Utils.rp2px(87.0D)));
        paramJSONObject.put("id_article_small_imge", localObject1);
        i = 7;
      }
      if (TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.l)) {
        break label532;
      }
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("info_status_text", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.l);
      paramString = "#fe6c6c";
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.m)) {
        paramString = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.m;
      }
      ((JSONObject)localObject1).put("info_status_text_color", paramString);
      ((JSONObject)localObject1).put("setBorderColorString", paramString);
      paramJSONObject.put("id_info_status", localObject1);
      i -= 3;
    }
    label532:
    for (;;)
    {
      localObject2 = new StringBuilder();
      paramString = "0";
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj.jdField_a_of_type_Int > 0) {
        paramString = bhvy.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.jdField_a_of_type_Qaj.jdField_a_of_type_Int, 990000L, "99万", "0");
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.j))
      {
        localObject1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qde.j;
        paramBaseArticleInfo = (BaseArticleInfo)localObject1;
        if (((String)localObject1).length() > i) {
          paramBaseArticleInfo = ((String)localObject1).substring(0, i - 1) + "...";
        }
        ((StringBuilder)localObject2).append(paramBaseArticleInfo).append("的回答 · ").append(paramString).append("赞同");
      }
      for (;;)
      {
        paramBaseArticleInfo = new JSONObject();
        paramBaseArticleInfo.put("nickname_text", ((StringBuilder)localObject2).toString());
        paramJSONObject.put("id_nickname", paramBaseArticleInfo);
        return;
        label508:
        localObject1 = "#000000";
        break;
        ((StringBuilder)localObject2).append(paramString).append("赞同");
      }
    }
  }
  
  private static boolean c(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0);
  }
  
  static void d(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (AdvertisementInfo.isAdvertisementInfo(paramBaseArticleInfo)))
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("article_model", paramBaseArticleInfo);
      paramJSONObject.put("id_view_AdBanner", localJSONObject);
    }
  }
  
  private static boolean d(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null)
    {
      QLog.d("Util", 2, "info == null");
      return false;
    }
    if (paramBaseArticleInfo.mSocialFeedInfo == null)
    {
      QLog.d("Util", 2, "info == " + paramBaseArticleInfo);
      return false;
    }
    return true;
  }
  
  static void e(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (oou.a((int)paramBaseArticleInfo.mChannelID)) {}
    while (paramBaseArticleInfo.isCloseDislike == 1) {
      return;
    }
    localJSONObject.put("feeds_dislike_icon", "feeds_dislike");
    paramJSONObject.put("id_dislike_button", localJSONObject);
  }
  
  static void f(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.hasFamilyCommentIcon()))
    {
      h(paramBaseArticleInfo, paramJSONObject);
      return;
    }
    g(paramBaseArticleInfo, paramJSONObject);
  }
  
  static void g(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    long l = 0L;
    if (paramBaseArticleInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBaseArticleInfo.mCommentCount > 0L)
    {
      l = paramBaseArticleInfo.mCommentCount;
      label41:
      if (!bhvy.a(paramBaseArticleInfo, l)) {
        break label117;
      }
      if (l <= 99990000L) {
        break label119;
      }
      localStringBuilder.append("9999万+");
    }
    for (;;)
    {
      localStringBuilder.append("评论");
      localJSONObject.put("article_comment_num", localStringBuilder.toString());
      paramJSONObject.put("id_comment_num", localJSONObject);
      return;
      if (paramBaseArticleInfo.mVideoCommentCount <= 0) {
        break label41;
      }
      l = paramBaseArticleInfo.mVideoCommentCount;
      break label41;
      label117:
      break;
      label119:
      if (l > 10000L)
      {
        double d = l / 10000.0D;
        localStringBuilder.append(new DecimalFormat("0.0").format(d));
        localStringBuilder.append("万");
      }
      else
      {
        localStringBuilder.append(l);
      }
    }
  }
  
  static void h(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.familyCommentInfo == null)) {}
    while ((TextUtils.isEmpty(paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString))) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("family_icon_url", paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_JavaLangString);
    localJSONObject.put("family_jump_schema", paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_JavaLangString);
    if (paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int > 0) {
      localJSONObject.put("family_icon_wh_rate", paramBaseArticleInfo.familyCommentInfo.jdField_a_of_type_Int / paramBaseArticleInfo.familyCommentInfo.jdField_b_of_type_Int);
    }
    paramJSONObject.put("id_img_family_icon", localJSONObject);
  }
  
  static void i(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo.mSocialFeedInfo == null) {
      return;
    }
    localObject = new JSONObject();
    long l1;
    if (!TextUtils.isEmpty(paramBaseArticleInfo.mSubscribeID)) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramBaseArticleInfo.mSubscribeID);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        localNumberFormatException.printStackTrace();
        continue;
        ((JSONObject)localObject).put("selected_state", "0");
      }
    }
    ((JSONObject)localObject).put("info_avator_uin", l1);
    ((JSONObject)localObject).put("article_model", paramBaseArticleInfo);
    paramJSONObject.put("id_info_avator", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("nickname_text", onh.d(paramBaseArticleInfo.mSubscribeName));
    paramJSONObject.put("id_nickname", localObject);
    paramJSONObject.put("id_view_nickname", new JSONObject());
    localJSONObject = new JSONObject();
    localObject = ajya.a(2131715994);
    if (paramBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int > 0) {
      localObject = bhvy.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int, 990000L, "99万", "0");
    }
    localJSONObject.put("text", localObject);
    paramJSONObject.put("id_img_comment_num", localJSONObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("comment_count", "");
    paramJSONObject.put("id_comment_button", localObject);
    localJSONObject = new JSONObject();
    localObject = ajya.a(2131716003);
    if (paramBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int > 0) {
      localObject = bhvy.a(paramBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int, 990000L, "99万", "0");
    }
    localJSONObject.put("text", localObject);
    paramJSONObject.put("id_img_like_num", localJSONObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("like_count", "");
    if (paramBaseArticleInfo.mSocialFeedInfo.jdField_c_of_type_Int == 1)
    {
      ((JSONObject)localObject).put("selected_state", "1");
      paramJSONObject.put("id_like_button", localObject);
      paramJSONObject.put("id_share_button", new JSONObject());
      paramJSONObject.put("id_img_biu_right", new JSONObject());
      paramJSONObject.put("id_biu_separator", new JSONObject());
      paramJSONObject.put("id_view_comment", new JSONObject());
      paramJSONObject.put("id_view_like", new JSONObject());
      paramJSONObject.put("id_view_share", new JSONObject());
      paramJSONObject.put("id_img_biu_bottom", new JSONObject());
      return;
    }
  }
  
  static void j(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo == null) {}
    JSONObject localJSONObject;
    do
    {
      do
      {
        return;
      } while ((oou.a((int)paramBaseArticleInfo.mChannelID)) || (paramBaseArticleInfo.isCloseDislike == 1));
      if (a(paramBaseArticleInfo))
      {
        QLog.d("Util", 1, "[bindDislikeButtonForChannel] new bottom bar has dislike btn, so return");
        return;
      }
      localJSONObject = new JSONObject();
      if (!shu.a(paramBaseArticleInfo.mChannelID)) {
        break;
      }
    } while ((onh.r(paramBaseArticleInfo)) || (onh.i(paramBaseArticleInfo)));
    localJSONObject.put("feeds_dislike_icon", "feedback_more");
    paramJSONObject.put("id_dislike_button", localJSONObject);
    return;
    localJSONObject.put("feeds_dislike_icon", "feeds_dislike");
    paramJSONObject.put("id_dislike_button", localJSONObject);
  }
  
  static void k(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo == null) {}
    while ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci == null) || (!paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.a())) {
      return;
    }
    paramBaseArticleInfo = new JSONObject();
    paramBaseArticleInfo.put("star_postmark", "readinjoy_star_postmark.png");
    paramJSONObject.put("id_star_postmark", paramBaseArticleInfo);
  }
  
  static void l(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo == null) {}
    while ((TextUtils.isEmpty(paramBaseArticleInfo.mDianDianLabelIconUrl)) || (TextUtils.isEmpty(paramBaseArticleInfo.mDianDianLabelText))) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    paramJSONObject.put("id_label_wrapper", localJSONObject);
    paramJSONObject.put("id_label_header", localJSONObject);
    paramJSONObject.put("id_label_separator_line", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("label_icon_url", paramBaseArticleInfo.mDianDianLabelIconUrl);
    paramJSONObject.put("id_label_icon", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("label_text", paramBaseArticleInfo.mDianDianLabelText);
    paramJSONObject.put("id_label_text", localJSONObject);
  }
  
  static void m(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramJSONObject.put("id_separator", new JSONObject());
  }
  
  static void n(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = paramBaseArticleInfo.multiBiuSameContentList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      paramBaseArticleInfo = new JSONObject();
      localObject = ((List)localObject).iterator();
      int i = 1;
      while (((Iterator)localObject).hasNext())
      {
        MultiBiuSameContent localMultiBiuSameContent = (MultiBiuSameContent)((Iterator)localObject).next();
        paramBaseArticleInfo.put(localMultiBiuSameContent.jdField_a_of_type_Long + "" + i, localMultiBiuSameContent.jdField_a_of_type_Long);
        i += 1;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("uin_list", paramBaseArticleInfo);
      paramJSONObject.put("id_friends_biu", localObject);
      paramJSONObject.put("id_friends_biu_wrapper", new JSONObject());
      paramJSONObject.put("id_friends_biu_separator_line", new JSONObject());
    }
  }
  
  static void o(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      Object localObject = paramBaseArticleInfo.mSocialFeedInfo;
      if (1 == ((SocializeFeedsInfo)localObject).l)
      {
        paramBaseArticleInfo = ((SocializeFeedsInfo)localObject).jdField_f_of_type_JavaLangString;
        localObject = ((SocializeFeedsInfo)localObject).g;
        if ((!TextUtils.isEmpty(paramBaseArticleInfo)) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          JSONObject localJSONObject = a();
          localJSONObject.put("jump_channel_bar_url", paramBaseArticleInfo);
          paramJSONObject.put("id_jump_channel_bar", localJSONObject);
          paramBaseArticleInfo = a();
          paramBaseArticleInfo.put("jump_channel_name", localObject);
          paramJSONObject.put("id_jump_channel_name", paramBaseArticleInfo);
          paramJSONObject.put("id_jump_channel_separator", a());
        }
      }
    }
  }
  
  static void p(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo;
      if (paramBaseArticleInfo.jdField_a_of_type_Ntz != null) {
        onh.a(paramJSONObject, paramBaseArticleInfo.jdField_a_of_type_Ntz);
      }
    }
  }
  
  static void q(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    paramBaseArticleInfo = new JSONObject();
    paramJSONObject.put("id_social_header_wrapper", paramBaseArticleInfo);
    paramJSONObject.put("id_social_header", paramBaseArticleInfo);
  }
  
  static void r(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("nickname_text", onh.d(paramBaseArticleInfo.mSubscribeName));
    paramJSONObject.put("id_nickname", localJSONObject);
  }
  
  static void s(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_JavaLangString))
    {
      localJSONObject.put("short_content_desc_text", paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_JavaLangString);
      paramJSONObject.put("id_description_label", localJSONObject);
    }
  }
  
  static void t(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci == null)) {
      return;
    }
    paramBaseArticleInfo = ReadInJoyUserInfoModule.a();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("nickname_text", onh.d(paramBaseArticleInfo));
    paramJSONObject.put("id_nickname", localJSONObject);
  }
  
  static void u(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    if (paramBaseArticleInfo.isPGCShortContent()) {}
    for (Object localObject = pmo.a((ArticleInfo)paramBaseArticleInfo).toString();; localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_JavaLangString)
    {
      localJSONObject.put("biu_time_text", onh.a((String)localObject, 36));
      paramJSONObject.put("id_biu_time", localJSONObject);
      return;
      if (!b(paramBaseArticleInfo)) {
        break;
      }
    }
    if (paramBaseArticleInfo.mTime > 0L) {}
    for (String str = ong.a(paramBaseArticleInfo.mTime, true);; str = ajya.a(2131715995))
    {
      localObject = str;
      if (paramBaseArticleInfo.mSocialFeedInfo == null) {
        break;
      }
      localObject = str;
      if (TextUtils.isEmpty(paramBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_JavaLangString)) {
        break;
      }
      localObject = str + " · " + paramBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_JavaLangString;
      break;
    }
  }
  
  static void v(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramBaseArticleInfo.mSocialFeedInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) || (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcd == null)) {
      return;
    }
    paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Qcd;
    paramJSONObject.put("id_account_card_container", a());
    paramJSONObject.put("id_cmp_account_card", a());
    JSONObject localJSONObject = a();
    localJSONObject.put("cmp_account_card_avator", paramBaseArticleInfo.jdField_b_of_type_JavaLangString);
    paramJSONObject.put("id_cmp_account_card_avator", localJSONObject);
    localJSONObject = a();
    localJSONObject.put("cmp_account_card_name", paramBaseArticleInfo.jdField_a_of_type_JavaLangString);
    paramJSONObject.put("id_cmp_account_card_name", localJSONObject);
    localJSONObject = a();
    localJSONObject.put("cmp_account_card_desc", paramBaseArticleInfo.jdField_c_of_type_JavaLangString);
    paramJSONObject.put("id_cmp_account_card_desc", localJSONObject);
  }
  
  static void w(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!c(paramBaseArticleInfo))
    {
      QLog.d("Util", 1, "bindTopicRecommendHeader failed, not topicInfo.");
      return;
    }
    paramJSONObject.put("id_topic_recommend_header", new JSONObject());
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("topic_name", paramBaseArticleInfo.businessNamePrefix + paramBaseArticleInfo.businessName);
    paramJSONObject.put("id_topic_name", localObject);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("topic_avator_url", ((qds)paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString);
    paramJSONObject.put("id_topic_avator", localObject);
    y(paramBaseArticleInfo, paramJSONObject);
    JSONObject localJSONObject;
    int i;
    if ((onh.b((ArticleInfo)paramBaseArticleInfo)) || (onh.e((ArticleInfo)paramBaseArticleInfo)))
    {
      localJSONObject = new JSONObject();
      if (((qds)paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int != 1) {
        break label346;
      }
      i = 1;
      if (i == 0) {
        break label351;
      }
      localObject = ajya.a(2131715998);
      label191:
      localJSONObject.put("button_status", localObject);
      if (i == 0) {
        break label361;
      }
    }
    label346:
    label351:
    label361:
    for (localObject = "1";; localObject = "0")
    {
      localJSONObject.put("selected_status", localObject);
      paramJSONObject.put("id_follow_button", localJSONObject);
      paramJSONObject.put("id_header_line", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("topic_name_only", paramBaseArticleInfo.businessName);
      paramJSONObject.put("id_topic_name_only", localObject);
      paramJSONObject.put("id_topic_more", new JSONObject());
      localObject = new JSONObject();
      ((JSONObject)localObject).put("topic_pre", paramBaseArticleInfo.businessNamePrefix);
      paramJSONObject.put("id_topic_pre", localObject);
      paramBaseArticleInfo = new JSONObject();
      paramBaseArticleInfo.put("topic_arrow_img", "topic_arrow_image");
      paramJSONObject.put("id_topic_arrow_img", paramBaseArticleInfo);
      return;
      i = 0;
      break;
      localObject = ajya.a(2131715992);
      break label191;
    }
  }
  
  static void x(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    Object localObject = BaseApplicationImpl.getContext();
    if ((!c(paramBaseArticleInfo)) || (localObject == null))
    {
      QLog.d("Util", 1, "bindTopicPackHeader failed, not topicInfo.");
      return;
    }
    paramJSONObject.put("id_topic_recommend_header", new JSONObject());
    qds localqds = (qds)paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("topic_name", localqds.jdField_c_of_type_JavaLangString + " " + localqds.jdField_a_of_type_JavaLangString);
    paramJSONObject.put("id_topic_name", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("topic_avator_url", localqds.jdField_d_of_type_JavaLangString);
    paramJSONObject.put("id_topic_avator", localJSONObject);
    localJSONObject = new JSONObject();
    localJSONObject.put("biu_time_text", String.format(((Context)localObject).getString(2131718590), new Object[] { bhvy.b(localqds.jdField_b_of_type_Int) }));
    paramJSONObject.put("id_topic_recommend_biu_time", localJSONObject);
    localObject = new JSONObject();
    int i;
    if (((qds)paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int == 1)
    {
      i = 1;
      if (i == 0) {
        break label300;
      }
      paramBaseArticleInfo = ajya.a(2131716010);
      label244:
      ((JSONObject)localObject).put("button_status", paramBaseArticleInfo);
      if (i == 0) {
        break label310;
      }
    }
    label300:
    label310:
    for (paramBaseArticleInfo = "1";; paramBaseArticleInfo = "0")
    {
      ((JSONObject)localObject).put("selected_status", paramBaseArticleInfo);
      paramJSONObject.put("id_follow_button", localObject);
      paramJSONObject.put("id_header_line", new JSONObject());
      return;
      i = 0;
      break;
      paramBaseArticleInfo = ajya.a(2131716000);
      break label244;
    }
  }
  
  static void y(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if (!c(paramBaseArticleInfo))
    {
      QLog.d("Util", 1, "bindTopicTimeAndReason failed, not topicInfo.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((onh.c((ArticleInfo)paramBaseArticleInfo)) || (onh.f((ArticleInfo)paramBaseArticleInfo)))
    {
      if (paramBaseArticleInfo.mTime > 0L) {
        localStringBuilder.append(ong.a(paramBaseArticleInfo.mRecommendTime, true));
      }
    }
    else if (paramBaseArticleInfo.mTopicRecommendFeedsInfo != null)
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(" ");
      }
      if (TextUtils.isEmpty(paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_b_of_type_JavaLangString)) {
        break label157;
      }
      localStringBuilder.append(paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      paramBaseArticleInfo = new JSONObject();
      paramBaseArticleInfo.put("biu_time_text", ajya.a(2131716007));
      paramJSONObject.put("id_topic_recommend_biu_time", paramBaseArticleInfo);
      return;
      localStringBuilder.append("刚刚");
      break;
      label157:
      if (paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0) != null) {
        localStringBuilder.append(bhvy.a(((qds)paramBaseArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int) + "人参与");
      }
    }
  }
  
  static void z(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = null;
    if ((paramBaseArticleInfo == null) || (paramJSONObject == null))
    {
      QLog.d("Util", 1, "bindCommonInfo, info or outData is null.");
      return;
    }
    a(paramBaseArticleInfo, paramJSONObject, true);
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("article_large_imge_url", paramBaseArticleInfo.mFirstPagePicUrl);
    paramJSONObject.put("id_article_large_imge", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("article_small_imge_url", paramBaseArticleInfo.mFirstPagePicUrl);
    paramJSONObject.put("id_article_small_imge", localObject1);
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("text", paramBaseArticleInfo.mSubscribeName);
    paramJSONObject.put("id_subcribe_name", localObject1);
    Object localObject4 = "";
    Object localObject5 = "";
    String str = "";
    Object localObject2;
    Object localObject3;
    if ((paramBaseArticleInfo.mPictures == null) || (paramBaseArticleInfo.mPictures.length <= 0))
    {
      localJSONArray = ram.a(paramBaseArticleInfo.mJsonPictureList, "pictures");
      localObject2 = localObject4;
      localObject3 = localObject5;
      localObject1 = str;
      if (localJSONArray != null)
      {
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject1 = str;
        if (localJSONArray.length() >= 3)
        {
          localObject1 = localJSONArray.optJSONObject(0);
          if (localObject1 != null) {
            break label324;
          }
          localObject2 = paramBaseArticleInfo.mFirstPagePicUrl;
          localObject1 = localJSONArray.optJSONObject(1);
          if (localObject1 != null) {
            break label335;
          }
          localObject3 = paramBaseArticleInfo.mFirstPagePicUrl;
          label222:
          localObject1 = localJSONArray.optJSONObject(2);
          if (localObject1 != null) {
            break label347;
          }
        }
      }
      label324:
      label335:
      label347:
      for (localObject1 = paramBaseArticleInfo.mFirstPagePicUrl;; localObject1 = ((JSONObject)localObject1).optString("picture"))
      {
        paramBaseArticleInfo = (BaseArticleInfo)localObject1;
        localObject4 = localObject2;
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url1", localObject4);
        paramJSONObject.put("id_multi_img_1", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url2", localObject3);
        paramJSONObject.put("id_multi_img_2", localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("multi_img_url3", paramBaseArticleInfo);
        paramJSONObject.put("id_multi_img_3", localObject1);
        return;
        localObject2 = ((JSONObject)localObject1).optString("picture");
        break;
        localObject3 = ((JSONObject)localObject1).optString("picture");
        break label222;
      }
    }
    if ((paramBaseArticleInfo.mPictures.length < 1) || (paramBaseArticleInfo.mPictures[0] == null))
    {
      localObject1 = paramBaseArticleInfo.mSinglePicture;
      label381:
      if (localObject1 == null) {
        break label485;
      }
      localObject1 = ((URL)localObject1).getFile();
      label390:
      if ((paramBaseArticleInfo.mPictures.length >= 2) && (paramBaseArticleInfo.mPictures[1] != null)) {
        break label490;
      }
      localObject2 = paramBaseArticleInfo.mSinglePicture;
      label413:
      if (localObject2 == null) {
        break label500;
      }
      localObject2 = ((URL)localObject2).getFile();
      label422:
      if ((paramBaseArticleInfo.mPictures.length >= 3) && (paramBaseArticleInfo.mPictures[2] != null)) {
        break label505;
      }
    }
    label485:
    label490:
    label500:
    label505:
    for (localObject5 = paramBaseArticleInfo.mSinglePicture;; localObject5 = paramBaseArticleInfo.mPictures[2])
    {
      localObject4 = localObject1;
      localObject3 = localObject2;
      paramBaseArticleInfo = localJSONArray;
      if (localObject5 == null) {
        break;
      }
      paramBaseArticleInfo = ((URL)localObject5).getFile();
      localObject4 = localObject1;
      localObject3 = localObject2;
      break;
      localObject1 = paramBaseArticleInfo.mPictures[0];
      break label381;
      localObject1 = null;
      break label390;
      localObject2 = paramBaseArticleInfo.mPictures[1];
      break label413;
      localObject2 = null;
      break label422;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pek
 * JD-Core Version:    0.7.0.1
 */