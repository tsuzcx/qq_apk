import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
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
import org.json.JSONException;
import org.json.JSONObject;

public class ofa
{
  private static final String a = ajya.a(2131702193);
  private static final String b;
  
  static
  {
    jdField_b_of_type_JavaLangString = ajya.a(2131702194);
  }
  
  public static SubCommentData a(oif paramoif, int paramInt)
  {
    if ((paramoif != null) && ((paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)))
    {
      paramoif = (CommentData)paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if ((paramoif.subCommentList != null) && (paramoif.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramoif.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  public static TemplateBean a(VafContext paramVafContext, oif paramoif, int paramInt, boolean paramBoolean, ohs paramohs)
  {
    bfwu.a("CommentProteusUtil.getTemplateBean");
    rpr localrpr1;
    if (paramVafContext == null)
    {
      rpr localrpr2 = rpr.a("comment_feeds", true);
      localrpr1 = localrpr2;
      if (localrpr2 == null) {
        return null;
      }
    }
    else
    {
      localrpr1 = (rpr)paramVafContext.getTemplateFactory();
    }
    if (localrpr1 != null) {}
    for (;;)
    {
      try
      {
        paramVafContext = localrpr1.getTemplateBean(a(paramohs, paramVafContext, paramoif, paramInt, paramBoolean));
        try
        {
          bfwu.a();
          return paramVafContext;
        }
        catch (JSONException paramoif) {}
      }
      catch (JSONException paramoif)
      {
        paramVafContext = null;
        continue;
      }
      paramoif.printStackTrace();
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
  
  private static List<String> a(oif paramoif)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramoif == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList == null)) {
      return localArrayList;
    }
    paramoif = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList;
    if (paramoif.size() > 0)
    {
      paramoif = paramoif.iterator();
      while (paramoif.hasNext())
      {
        oie localoie = (oie)paramoif.next();
        if ((localoie.jdField_e_of_type_Int == 1) || (localoie.jdField_e_of_type_Int == 2)) {
          localArrayList.add(localoie.jdField_b_of_type_JavaLangString);
        } else if (localoie.jdField_e_of_type_Int == 3) {
          localArrayList.add(localoie.d);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "getPicUrlList | pathsize " + localArrayList.size());
    return localArrayList;
  }
  
  private static JSONObject a(VafContext paramVafContext, oif paramoif, boolean paramBoolean)
  {
    BaseCommentData localBaseCommentData = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if ((localBaseCommentData == null) || (localBaseCommentData.commentContent == null) || (paramoif.jdField_a_of_type_JavaLangCharSequence == null)) {
      return null;
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("style_ID", "ReadInJoy_comment_cell");
    if (TextUtils.isEmpty(localBaseCommentData.avatar))
    {
      ((JSONObject)localObject2).put("avator_url", "default_comment_avatar");
      QLog.d("CommentProteusUtil", 2, "getCommentDataJson | isStar " + localBaseCommentData.isStar() + " isApproved " + localBaseCommentData.isApproved());
      if (localBaseCommentData.isStar()) {
        ((JSONObject)localObject2).put("rij_comment_avatar_borders", "rij_comment_avatar_borders");
      }
      if (localBaseCommentData.isApproved()) {
        ((JSONObject)localObject2).put("rij_comment_v", "rij_comment_v");
      }
      if (localBaseCommentData.isAuthorReply()) {
        ((JSONObject)localObject2).put("author_header_flag_one", ajya.a(2131702203));
      }
      if (!TextUtils.isEmpty(localBaseCommentData.userTitle)) {
        ((JSONObject)localObject2).put("comment_describe", localBaseCommentData.userTitle);
      }
      String str = ohf.a(localBaseCommentData.nickName, 10);
      localObject1 = str;
      if (str == null) {
        localObject1 = ajya.a(2131709300);
      }
      ((JSONObject)localObject2).put("nickname", localObject1);
      ((JSONObject)localObject2).put("commentModel", paramoif);
      if (((localBaseCommentData instanceof CommentData)) && (localBaseCommentData.isAwesome())) {
        ((JSONObject)localObject2).put("awsome_postmark_img", "awsome_postmark");
      }
      if ((paramoif.a()) && (paramBoolean)) {
        ((JSONObject)localObject2).put("comment_model", paramoif);
      }
      long l2 = localBaseCommentData.commentTime;
      long l1 = l2;
      if (l2 == 0L) {
        l1 = System.currentTimeMillis();
      }
      ((JSONObject)localObject2).put("time", ong.a(l1, true));
      if (localBaseCommentData.medalInfo != null) {
        onh.a((JSONObject)localObject2, localBaseCommentData.medalInfo);
      }
      if (!paramBoolean) {
        break label1113;
      }
    }
    label472:
    label1113:
    for (Object localObject1 = a(paramoif, (JSONObject)localObject2);; localObject1 = localException) {
      for (;;)
      {
        if ((localBaseCommentData instanceof CommentData)) {
          if (paramBoolean)
          {
            localObject2 = (CommentData)localBaseCommentData;
            if (((CommentData)localObject2).subCommentNum > 0)
            {
              ((JSONObject)localObject1).put("reply_count", bhvy.a(((CommentData)localObject2).subCommentNum, 99989500L, "9999万+", "0") + ajya.a(2131702197));
              ((JSONObject)localObject1).put("id_comment_tail_3_dot", new JSONObject());
              ((JSONObject)localObject1).put("reply_count_none", "");
              ((JSONObject)localObject1).put("id_comment_tail_center_dot", new JSONObject());
              if (TextUtils.isEmpty(localBaseCommentData.flowGuidePtsData)) {}
            }
          }
        }
        try
        {
          localObject2 = new JSONObject(localBaseCommentData.flowGuidePtsData);
          ((JSONObject)localObject1).put("diversion_view_color", ((JSONObject)localObject2).optString("diversion_view_color"));
          ((JSONObject)localObject1).put("diversion_app_icon", ((JSONObject)localObject2).optString("diversion_app_icon"));
          ((JSONObject)localObject1).put("app_wording", ((JSONObject)localObject2).optString("app_wording"));
          ((JSONObject)localObject1).put("diversion_font_color", ((JSONObject)localObject2).optString("diversion_font_color"));
          ((JSONObject)localObject1).put("jump_schema", a(((JSONObject)localObject2).optString("app_schema")));
          float f1;
          float f2;
          if ((paramVafContext != null) && (paramVafContext.getContext() != null) && (paramVafContext.getContext().getResources() != null) && (localBaseCommentData.mediaDataList != null) && (localBaseCommentData.mediaDataList.size() > 0))
          {
            paramVafContext = (oie)localBaseCommentData.mediaDataList.get(0);
            int i = paramVafContext.jdField_e_of_type_Int;
            QLog.d("CommentProteusUtil", 2, "mediaData type is " + i);
            f1 = paramVafContext.jdField_a_of_type_Int;
            f1 = paramVafContext.jdField_b_of_type_Int;
            if (paramVafContext.jdField_a_of_type_Int >= paramVafContext.jdField_b_of_type_Int) {
              break label1047;
            }
            f2 = 89.0F;
            f1 = 113.0F;
            paramoif = a(paramoif);
            ((JSONObject)localObject1).put("thumHeight", "" + f1);
            ((JSONObject)localObject1).put("thumWidth", "" + f2);
            ((JSONObject)localObject1).put("media_thumimg_url", paramVafContext.jdField_e_of_type_JavaLangString);
            if ((paramoif == null) || (paramoif.size() <= 0)) {
              break label1082;
            }
            paramVafContext = (String)paramoif.get(0);
            ((JSONObject)localObject1).put("pic_url", paramVafContext);
            paramVafContext = "";
            switch (i)
            {
            }
          }
          for (;;)
          {
            if (!TextUtils.isEmpty(paramVafContext)) {
              ((JSONObject)localObject1).put("media_type_str", paramVafContext);
            }
            QLog.d("CommentProteusUtil", 2, "comment data json str : " + ((JSONObject)localObject1).toString());
            return localObject1;
            ((JSONObject)localObject2).put("avator_url", localBaseCommentData.avatar);
            break;
            ((JSONObject)localObject1).put("reply_count_none", ajya.a(2131702204));
            ((JSONObject)localObject1).put("id_comment_tail_center_dot", new JSONObject());
            ((JSONObject)localObject1).put("id_comment_tail_3_dot", new JSONObject());
            ((JSONObject)localObject1).remove("reply_count");
            break label472;
            ((JSONObject)localObject1).put("id_comment_tail_3_dot", new JSONObject());
            break label472;
            ((JSONObject)localObject1).put("reply_count_none", ajya.a(2131702201));
            ((JSONObject)localObject1).put("id_comment_tail_center_dot", new JSONObject());
            ((JSONObject)localObject1).put("id_comment_tail_3_dot", new JSONObject());
            ((JSONObject)localObject1).remove("reply_count");
            break label472;
            if (paramVafContext.jdField_a_of_type_Int > paramVafContext.jdField_b_of_type_Int)
            {
              f2 = 113.0F;
              f1 = 89.0F;
              break label707;
            }
            f2 = 89.0F;
            f1 = 89.0F;
            break label707;
            paramVafContext = "";
            break label806;
            paramVafContext = ajya.a(2131702191);
            continue;
            paramVafContext = ajya.a(2131702198);
          }
        }
        catch (Exception localException)
        {
          break label585;
        }
      }
    }
  }
  
  public static JSONObject a(ohs paramohs, VafContext paramVafContext, oif paramoif, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject2 = new JSONObject();
    if (paramoif == null) {
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
      a(paramoif, localJSONObject1);
      return localJSONObject1;
      localJSONObject1 = a(paramVafContext, paramoif, paramBoolean);
      continue;
      localJSONObject1 = b(paramoif);
      continue;
      localJSONObject1 = a(paramoif);
      continue;
      localJSONObject1 = a(paramoif, paramohs);
    }
  }
  
  private static JSONObject a(oif paramoif)
  {
    if (paramoif == null) {}
    do
    {
      return null;
      paramoif = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (paramoif == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_banner");
    localJSONObject.put("operation_banner_icon", "rij_icon_notify");
    localJSONObject.put("operation_banner_title", paramoif.commentContent);
    QLog.d("CommentProteusUtil", 2, "comment banner data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(oif paramoif, ohs paramohs)
  {
    oil localoil = oil.a(paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    String str2 = ajya.a(2131702192);
    String str1 = a;
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    int i;
    long l1;
    if ((localoil != null) && (paramohs != null))
    {
      long l2 = localoil.a(paramohs.b());
      i = j;
      l1 = l2;
      if (paramohs != null)
      {
        i = j;
        l1 = l2;
        if (paramohs.b() == 6)
        {
          i = 0;
          l1 = l2;
        }
      }
    }
    for (;;)
    {
      if (paramoif.jdField_a_of_type_Int == 2) {}
      for (paramoif = jdField_b_of_type_JavaLangString;; paramoif = str1)
      {
        if (l1 > 0L) {}
        for (paramohs = " " + l1 + " ";; paramohs = "")
        {
          localJSONObject.put("style_ID", "ReadInJoy_comment_title");
          localJSONObject.put("comment_title", str2);
          localJSONObject.put("comment_count", paramohs);
          if (i != 0)
          {
            localJSONObject.put("id_comment_type_choose_icon", new JSONObject());
            paramohs = new JSONObject();
            paramohs.put("comment_type", paramoif);
            localJSONObject.put("id_comment_type_choose_text", paramohs);
          }
          QLog.d("CommentProteusUtil", 2, "comment title json str : " + localJSONObject.toString());
          return localJSONObject;
        }
      }
      l1 = 0L;
      i = j;
    }
  }
  
  private static JSONObject a(oif paramoif, JSONObject paramJSONObject)
  {
    if ((paramoif == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {}
    while (!(paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return paramJSONObject;
    }
    List localList = paramoif.c;
    if ((localList != null) && (localList.size() > 0))
    {
      int i = localList.size();
      if (localList.size() > 2) {
        i = 2;
      }
      int j = 0;
      if (j < i)
      {
        if (j == 0) {
          paramJSONObject.put("subcomment_one", paramoif);
        }
        for (;;)
        {
          j += 1;
          break;
          paramJSONObject.put("subcomment_two", paramoif);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "bindExposeSubCommentData : " + paramJSONObject.toString());
    return paramJSONObject;
  }
  
  public static void a(Container paramContainer, ohs paramohs, oif paramoif)
  {
    if ((paramContainer == null) || (paramoif == null) || (paramohs == null)) {
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new ofb(paramohs, paramoif, paramContainer));
  }
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, ohs paramohs, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (paramohs == null)) {
      return;
    }
    try
    {
      bfwu.a("CommentProteusUtil.bindData");
      olo.a(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = a(paramohs, paramVafContext, (oif)paramohs.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramTemplateBean.getViewBean().bindData(paramVafContext, paramTemplateBean.getViewDataBinding());
          a(paramContainer, paramohs, (oif)paramohs.getItem(paramInt1));
        }
      }
      bfwu.a();
      return;
    }
    catch (JSONException paramVafContext)
    {
      QLog.d("CommentProteusUtil", 2, "bindData " + paramVafContext.getMessage());
    }
  }
  
  private static void a(oif paramoif, JSONObject paramJSONObject)
  {
    if ((paramoif == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {
      return;
    }
    paramoif = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.styleData;
    QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData : " + paramoif + " dataJson : " + paramJSONObject.toString());
    if (TextUtils.isEmpty(paramoif))
    {
      QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData is null");
      return;
    }
    try
    {
      paramoif = new JSONObject(paramoif);
      if (paramoif != null)
      {
        Iterator localIterator = paramoif.keys();
        while ((localIterator != null) && (localIterator.hasNext()))
        {
          String str = (String)localIterator.next();
          paramJSONObject.put(str, paramoif.get(str));
        }
      }
      return;
    }
    catch (JSONException paramoif)
    {
      paramoif.printStackTrace();
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
  
  private static JSONObject b(oif paramoif)
  {
    if (paramoif == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return null;
      localBaseCommentData = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_cell");
    localJSONObject.put("avator_url", localBaseCommentData.avatar);
    localJSONObject.put("nickname", localBaseCommentData.nickName);
    localJSONObject.put("commentModel", paramoif);
    localJSONObject.put("operation_img_url", localBaseCommentData.activityPicUrl);
    QLog.d("CommentProteusUtil", 2, "comment activity data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static void b(View paramView, ohs paramohs)
  {
    if (paramohs == null) {}
    okt localokt;
    do
    {
      return;
      localokt = new okt(paramohs, paramohs.a);
      localokt.a(paramohs);
    } while (paramohs.a() == null);
    localokt.b(paramView, paramohs.b());
  }
  
  private static void b(ohs paramohs, oif paramoif)
  {
    if (paramohs == null) {
      return;
    }
    bbgu localbbgu = bbdj.a(paramohs.a(), 230);
    paramohs = new ofr(paramohs, paramoif);
    localbbgu.setMessage(ogi.a());
    localbbgu.setNegativeButton("取消", paramohs);
    localbbgu.setPositiveButton("确定", paramohs);
    localbbgu.setOnCancelListener(null);
    localbbgu.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ofa
 * JD-Core Version:    0.7.0.1
 */