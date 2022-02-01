import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class oyk
{
  public static final String a = anni.a(2131700997);
  public static final String b;
  public static final String c = anni.a(2131700996);
  
  static
  {
    jdField_b_of_type_JavaLangString = anni.a(2131700998);
  }
  
  public static float a()
  {
    try
    {
      f = ((Float)bmqa.a("readinjoy_font_size_ratio_sp", Float.valueOf(1.0F))).floatValue();
      QLog.d("CommentProteusUtil", 1, "getCustomTextSizeRatio | error! msg=" + localException1);
    }
    catch (Exception localException1)
    {
      try
      {
        QLog.d("CommentProteusUtil", 1, "getCustomTextSizeRatio | text size ratio " + f);
        return f;
      }
      catch (Exception localException2)
      {
        float f;
        break label46;
      }
      localException1 = localException1;
      f = 1.0F;
    }
    label46:
    return f;
  }
  
  public static SubCommentData a(pay parampay, int paramInt)
  {
    if ((parampay != null) && ((parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)))
    {
      parampay = (CommentData)parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if ((parampay.subCommentList != null) && (parampay.subCommentList.size() > paramInt)) {
        return (SubCommentData)parampay.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  public static TemplateBean a(VafContext paramVafContext, pay parampay, int paramInt, boolean paramBoolean, pan parampan)
  {
    bkpj.a("CommentProteusUtil.getTemplateBean");
    teh localteh1;
    if (paramVafContext == null)
    {
      teh localteh2 = teh.a("comment_feeds", true);
      localteh1 = localteh2;
      if (localteh2 == null) {
        return null;
      }
    }
    else
    {
      localteh1 = (teh)paramVafContext.getTemplateFactory();
    }
    if (localteh1 != null) {}
    for (;;)
    {
      try
      {
        paramVafContext = localteh1.getTemplateBean(a(parampan, paramVafContext, parampay, paramInt, paramBoolean));
        try
        {
          bkpj.a();
          return paramVafContext;
        }
        catch (JSONException parampay) {}
      }
      catch (JSONException parampay)
      {
        paramVafContext = null;
        continue;
      }
      parampay.printStackTrace();
      return paramVafContext;
      paramVafContext = null;
    }
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String[] arrayOfString1;
    do
    {
      return paramString;
      arrayOfString1 = paramString.split("\\?");
    } while (arrayOfString1.length != 2);
    String[] arrayOfString2 = arrayOfString1[1].split("&");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < arrayOfString2.length)
    {
      String[] arrayOfString3 = arrayOfString2[i].split("=");
      if (arrayOfString3.length == 2) {
        if (i == arrayOfString2.length - 1) {
          break label156;
        }
      }
      label156:
      for (paramString = "&";; paramString = "")
      {
        if ("appSchema".equalsIgnoreCase(arrayOfString3[0])) {
          arrayOfString2[i] = (arrayOfString3[0] + "=" + b(arrayOfString3[1]));
        }
        localStringBuilder.append(arrayOfString2[i] + paramString);
        i += 1;
        break;
      }
    }
    paramString = arrayOfString1[0] + "?" + localStringBuilder.toString();
    QLog.d("CommentProteusUtil", 2, "checkJumpAppSchema | jumpSchema : " + paramString);
    return paramString;
  }
  
  private static List<String> a(pay parampay)
  {
    ArrayList localArrayList = new ArrayList();
    if ((parampay == null) || (parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList == null)) {
      return localArrayList;
    }
    parampay = parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList;
    if (parampay.size() > 0)
    {
      parampay = parampay.iterator();
      while (parampay.hasNext())
      {
        pax localpax = (pax)parampay.next();
        if ((localpax.jdField_e_of_type_Int == 1) || (localpax.jdField_e_of_type_Int == 2)) {
          localArrayList.add(localpax.jdField_b_of_type_JavaLangString);
        } else if (localpax.jdField_e_of_type_Int == 3) {
          localArrayList.add(localpax.d);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "getPicUrlList | pathsize " + localArrayList.size());
    return localArrayList;
  }
  
  public static JSONObject a(pan parampan, VafContext paramVafContext, pay parampay, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject2 = new JSONObject();
    if (parampay == null) {
      return localJSONObject2;
    }
    JSONObject localJSONObject1 = localJSONObject2;
    switch (paramInt)
    {
    default: 
      localJSONObject1 = localJSONObject2;
    }
    for (;;)
    {
      a(parampay, localJSONObject1);
      return localJSONObject1;
      localJSONObject1 = a(parampan, paramVafContext, parampay, paramBoolean);
      continue;
      localJSONObject1 = b(parampay);
      continue;
      localJSONObject1 = a(parampay);
      continue;
      localJSONObject1 = a(parampay, parampan);
      continue;
      localJSONObject1 = opu.a(paramVafContext, parampay, paramBoolean);
    }
  }
  
  private static JSONObject a(@NotNull pan parampan, VafContext paramVafContext, pay parampay, boolean paramBoolean)
  {
    BaseCommentData localBaseCommentData = parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if ((localBaseCommentData == null) || (localBaseCommentData.commentContent == null) || (parampay.jdField_a_of_type_JavaLangCharSequence == null)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_cell");
    a(localJSONObject, localBaseCommentData);
    a(localJSONObject, parampay);
    a(localJSONObject, localBaseCommentData, paramBoolean);
    a(parampan, localJSONObject, localBaseCommentData);
    a(localJSONObject, parampay, paramBoolean);
    a(paramVafContext, localJSONObject, parampay, localBaseCommentData);
    b(localJSONObject, localBaseCommentData);
    QLog.d("CommentProteusUtil", 2, "getCommentDataJson | comment data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(pay parampay)
  {
    if (parampay == null) {}
    do
    {
      return null;
      parampay = parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (parampay == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_banner");
    localJSONObject.put("operation_banner_icon", "rij_icon_notify");
    localJSONObject.put("operation_banner_title", parampay.commentContent);
    QLog.d("CommentProteusUtil", 2, "comment banner data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(pay parampay, JSONObject paramJSONObject)
  {
    if ((parampay == null) || (parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {}
    while (!(parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return paramJSONObject;
    }
    List localList = parampay.c;
    int i;
    if ((localList != null) && (localList.size() > 0))
    {
      i = localList.size();
      if (localList.size() <= 2) {
        break label207;
      }
      i = 2;
    }
    label207:
    for (;;)
    {
      int j = 0;
      if (j < i)
      {
        if (j == 0) {
          paramJSONObject.put("subcomment_one", parampay);
        }
        for (;;)
        {
          if ((((CommentData)parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList != null) && (((CommentData)parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList.get(j) != null) && (((SubCommentData)((CommentData)parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList.get(j)).isAuthorLike)) {
            paramJSONObject.put("author_like_one_text", "作者赞过");
          }
          j += 1;
          break;
          paramJSONObject.put("subcomment_two", parampay);
        }
      }
      QLog.d("CommentProteusUtil", 2, "bindExposeSubCommentData : " + paramJSONObject.toString());
      return paramJSONObject;
    }
  }
  
  private static JSONObject a(pay parampay, pan parampan)
  {
    Object localObject = pbe.a(parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    int i;
    long l1;
    if ((localObject != null) && (parampan != null))
    {
      long l2 = ((pbe)localObject).a(parampan.b());
      i = j;
      l1 = l2;
      if (parampan != null)
      {
        i = j;
        l1 = l2;
        if (parampan.b() == 6)
        {
          i = 0;
          l1 = l2;
        }
      }
    }
    for (;;)
    {
      if (parampay.jdField_a_of_type_Int == 2) {
        parampan = "rij_new_comment_title_icon";
      }
      for (parampay = "rij_comment_menu_new_icon";; parampay = "rij_comment_menu_hot_icon")
      {
        if (l1 > 0L) {}
        for (localObject = "（" + l1 + "）";; localObject = "")
        {
          localJSONObject.put("style_ID", "ReadInJoy_comment_title");
          localJSONObject.put("comment_title", c);
          localJSONObject.put("comment_count", localObject);
          localJSONObject.put("comment_title_icon_url", parampan);
          if (i != 0)
          {
            parampan = new JSONObject();
            parampan.put("commnet_menu_icon_url", parampay);
            parampan.put("rij_comment_type_choose_highlight", parampay);
            localJSONObject.put("id_comment_type_choose_icon", parampan);
          }
          QLog.d("CommentProteusUtil", 2, "getCommentTitleJsonNew | comment title json str : " + localJSONObject.toString());
          return localJSONObject;
        }
        parampan = "rij_hot_comment_title_icon";
      }
      l1 = 0L;
      i = j;
    }
  }
  
  public static void a(Container paramContainer, pan parampan, pay parampay)
  {
    if ((paramContainer == null) || (parampay == null) || (parampan == null)) {
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new oyl(paramContainer, parampan, parampay));
  }
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, pan parampan, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (parampan == null)) {
      return;
    }
    try
    {
      bkpj.a("CommentProteusUtil.bindData");
      pfr.a(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = a(parampan, paramVafContext, (pay)parampan.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramVafContext.put("ratio", a());
          paramTemplateBean.bindData(paramVafContext);
          a(paramContainer, parampan, (pay)parampan.getItem(paramInt1));
        }
      }
      bkpj.a();
      return;
    }
    catch (JSONException paramVafContext)
    {
      QLog.d("CommentProteusUtil", 2, "bindData " + paramVafContext.getMessage());
    }
  }
  
  private static void a(@NotNull VafContext paramVafContext, @NotNull JSONObject paramJSONObject, @NotNull pay parampay, @NotNull BaseCommentData paramBaseCommentData)
  {
    float f1 = 113.0F;
    float f2 = 89.0F;
    if ((paramVafContext != null) && (paramVafContext.getContext() != null) && (paramVafContext.getContext().getResources() != null) && (paramBaseCommentData.mediaDataList != null) && (paramBaseCommentData.mediaDataList.size() > 0))
    {
      paramVafContext = (pax)paramBaseCommentData.mediaDataList.get(0);
      int i = paramVafContext.jdField_e_of_type_Int;
      QLog.d("CommentProteusUtil", 2, "mediaData type is " + i);
      float f3 = paramVafContext.jdField_a_of_type_Int;
      f3 = paramVafContext.jdField_b_of_type_Int;
      if (paramVafContext.jdField_a_of_type_Int >= paramVafContext.jdField_b_of_type_Int) {
        break label273;
      }
      parampay = a(parampay);
      paramJSONObject.put("thumHeight", "" + f1);
      paramJSONObject.put("thumWidth", "" + f2);
      paramJSONObject.put("media_thumimg_url", paramVafContext.jdField_e_of_type_JavaLangString);
      if ((parampay == null) || (parampay.size() <= 0)) {
        break label305;
      }
      paramVafContext = (String)parampay.get(0);
      label219:
      paramJSONObject.put("pic_url", paramVafContext);
      paramVafContext = "";
      switch (i)
      {
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramVafContext)) {
        paramJSONObject.put("media_type_str", paramVafContext);
      }
      return;
      label273:
      if (paramVafContext.jdField_a_of_type_Int > paramVafContext.jdField_b_of_type_Int)
      {
        f2 = 113.0F;
        f1 = 89.0F;
        break;
      }
      f1 = 89.0F;
      break;
      label305:
      paramVafContext = "";
      break label219;
      paramVafContext = anni.a(2131700995);
      continue;
      paramVafContext = anni.a(2131701002);
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, BaseCommentData paramBaseCommentData)
  {
    if (TextUtils.isEmpty(paramBaseCommentData.avatar)) {
      paramJSONObject.put("avator_url", "default_comment_avatar");
    }
    for (;;)
    {
      QLog.d("CommentProteusUtil", 2, "getCommentDataJson | isStar " + paramBaseCommentData.isStar() + " isApproved " + paramBaseCommentData.isApproved());
      if (paramBaseCommentData.isStar()) {
        paramJSONObject.put("rij_comment_avatar_borders", "rij_comment_avatar_borders");
      }
      if (paramBaseCommentData.isApproved()) {
        paramJSONObject.put("rij_comment_v", "rij_comment_v");
      }
      if (paramBaseCommentData.isAuthorReply()) {
        paramJSONObject.put("author_header_flag_one", anni.a(2131701007));
      }
      if (!TextUtils.isEmpty(paramBaseCommentData.userTitle)) {
        paramJSONObject.put("comment_describe", paramBaseCommentData.userTitle);
      }
      String str2 = paa.a(paramBaseCommentData.nickName, 10);
      String str1 = str2;
      if (str2 == null) {
        str1 = anni.a(2131708060);
      }
      paramJSONObject.put("nickname", str1);
      if ((paramBaseCommentData.isFollowing) && (!paramBaseCommentData.isAuthorReply())) {
        paramJSONObject.put("author_header_follow_flag", "我的关注");
      }
      if (!TextUtils.isEmpty(paramBaseCommentData.avatarPendantUrl)) {
        paramJSONObject.put("rij_comment_avatar_pendant", paramBaseCommentData.avatarPendantUrl);
      }
      return;
      paramJSONObject.put("avator_url", paramBaseCommentData.avatar);
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData, boolean paramBoolean)
  {
    long l2 = paramBaseCommentData.commentTime;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = System.currentTimeMillis();
    }
    paramJSONObject.put("time", pgz.a(l1, true));
    if ((paramBaseCommentData instanceof CommentData))
    {
      if (paramBoolean)
      {
        paramBaseCommentData = (CommentData)paramBaseCommentData;
        if (paramBaseCommentData.subCommentNum > 0)
        {
          paramJSONObject.put("reply_count", bmqa.a(paramBaseCommentData.subCommentNum, 99989500L, "9999万+", "0") + anni.a(2131701001));
          paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
          paramJSONObject.put("reply_count_none", "");
          paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
          return;
        }
        paramJSONObject.put("reply_count_none", anni.a(2131701008));
        paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
        paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
        paramJSONObject.remove("reply_count");
        return;
      }
      paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
      return;
    }
    paramJSONObject.put("reply_count_none", anni.a(2131701005));
    paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
    paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
    paramJSONObject.remove("reply_count");
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull pay parampay)
  {
    paramJSONObject.put("commentModel", parampay);
    if (parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null)
    {
      paramJSONObject.put("comment_text", parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentContent);
      paramJSONObject.put("ratio", a());
      if ((parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData))
      {
        parampay = (SubCommentData)parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        if (parampay.hasTarget())
        {
          paramJSONObject.put("reply_normal_text", "回复 ");
          if (!TextUtils.isEmpty(parampay.repliedUserNickname))
          {
            paramJSONObject.put("reply_highLight_text", parampay.repliedUserNickname + "：");
            paramJSONObject.put("jump_url", paa.a(parampay.repliedUserUin));
          }
        }
      }
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull pay parampay, boolean paramBoolean)
  {
    if ((parampay.a()) && (paramBoolean)) {
      paramJSONObject.put("comment_model", parampay);
    }
    if (paramBoolean) {
      a(parampay, paramJSONObject);
    }
  }
  
  private static void a(@NotNull pan parampan, @NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData.isAuthorLike) {
      paramJSONObject.put("author_like_text", "作者赞过");
    }
    if (((paramBaseCommentData instanceof CommentData)) && (paramBaseCommentData.isAwesome())) {
      paramJSONObject.put("awsome_postmark_img", "awsome_postmark");
    }
    if ((paramBaseCommentData.isAuthorSticky) && (parampan.b() == 3))
    {
      paramJSONObject.put("top_img_path", "rij_comment_sticky_icon");
      paramJSONObject.put("top_margin_text", " ");
    }
    if (paramBaseCommentData.medalInfo != null) {
      pha.a(paramJSONObject, paramBaseCommentData.medalInfo);
    }
  }
  
  public static void a(pan parampan, pay parampay)
  {
    if (parampan == null) {
      return;
    }
    bgpa localbgpa = bglp.a(parampan.a(), 230);
    parampan = new oym(parampan, parampay);
    localbgpa.setMessage(ozc.a());
    localbgpa.setNegativeButton("取消", parampan);
    localbgpa.setPositiveButton("确定", parampan);
    localbgpa.setOnCancelListener(null);
    localbgpa.show();
  }
  
  private static void a(pay parampay, JSONObject paramJSONObject)
  {
    if ((parampay == null) || (parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {
      return;
    }
    parampay = parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.styleData;
    QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData : " + parampay + " dataJson : " + paramJSONObject.toString());
    if (TextUtils.isEmpty(parampay))
    {
      QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData is null");
      return;
    }
    try
    {
      parampay = new JSONObject(parampay);
      if (parampay != null)
      {
        Iterator localIterator = parampay.keys();
        while ((localIterator != null) && (localIterator.hasNext()))
        {
          String str = (String)localIterator.next();
          paramJSONObject.put(str, parampay.get(str));
        }
      }
      return;
    }
    catch (JSONException parampay)
    {
      parampay.printStackTrace();
      QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | commentDataJson " + paramJSONObject.toString());
    }
  }
  
  private static String b(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "utf-8");
      StringBuilder localStringBuilder = new StringBuilder(str);
      if (!str.contains("title")) {
        localStringBuilder.append("&title=");
      }
      if (!str.contains("videoId")) {
        localStringBuilder.append("&videoId=");
      }
      if (!str.contains("coverPath")) {
        localStringBuilder.append("&coverPath=");
      }
      if (!str.contains("width")) {
        localStringBuilder.append("&width=");
      }
      if (!str.contains("height")) {
        localStringBuilder.append("&height=");
      }
      str = URLEncoder.encode(localStringBuilder.toString(), "utf-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  private static JSONObject b(pay parampay)
  {
    if (parampay == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return null;
      localBaseCommentData = parampay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_cell");
    localJSONObject.put("avator_url", localBaseCommentData.avatar);
    localJSONObject.put("nickname", localBaseCommentData.nickName);
    localJSONObject.put("commentModel", parampay);
    localJSONObject.put("operation_img_url", localBaseCommentData.activityPicUrl);
    QLog.d("CommentProteusUtil", 2, "comment activity data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static void b(@NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    if (!TextUtils.isEmpty(paramBaseCommentData.flowGuidePtsData)) {}
    try
    {
      paramBaseCommentData = new JSONObject(paramBaseCommentData.flowGuidePtsData);
      paramJSONObject.put("diversion_view_color", paramBaseCommentData.optString("diversion_view_color"));
      paramJSONObject.put("diversion_app_icon", paramBaseCommentData.optString("diversion_app_icon"));
      paramJSONObject.put("app_wording", paramBaseCommentData.optString("app_wording"));
      paramJSONObject.put("diversion_font_color", paramBaseCommentData.optString("diversion_font_color"));
      paramJSONObject.put("jump_schema", a(paramBaseCommentData.optString("app_schema")));
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("CommentProteusUtil", 2, paramJSONObject.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyk
 * JD-Core Version:    0.7.0.1
 */