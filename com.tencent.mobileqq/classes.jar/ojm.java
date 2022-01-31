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
import org.json.JSONException;
import org.json.JSONObject;

public class ojm
{
  private static final String a = alud.a(2131702577);
  private static final String b;
  private static final String c = alud.a(2131702576);
  
  static
  {
    jdField_b_of_type_JavaLangString = alud.a(2131702578);
  }
  
  public static SubCommentData a(omt paramomt, int paramInt)
  {
    if ((paramomt != null) && ((paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)))
    {
      paramomt = (CommentData)paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if ((paramomt.subCommentList != null) && (paramomt.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramomt.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  public static TemplateBean a(VafContext paramVafContext, omt paramomt, int paramInt, boolean paramBoolean, omg paramomg)
  {
    biby.a("CommentProteusUtil.getTemplateBean");
    sfq localsfq1;
    if (paramVafContext == null)
    {
      sfq localsfq2 = sfq.a("comment_feeds", true);
      localsfq1 = localsfq2;
      if (localsfq2 == null) {
        return null;
      }
    }
    else
    {
      localsfq1 = (sfq)paramVafContext.getTemplateFactory();
    }
    if (localsfq1 != null) {}
    for (;;)
    {
      try
      {
        paramVafContext = localsfq1.getTemplateBean(a(paramomg, paramVafContext, paramomt, paramInt, paramBoolean));
        try
        {
          biby.a();
          return paramVafContext;
        }
        catch (JSONException paramomt) {}
      }
      catch (JSONException paramomt)
      {
        paramVafContext = null;
        continue;
      }
      paramomt.printStackTrace();
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
  
  private static List<String> a(omt paramomt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramomt == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList == null)) {
      return localArrayList;
    }
    paramomt = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList;
    if (paramomt.size() > 0)
    {
      paramomt = paramomt.iterator();
      while (paramomt.hasNext())
      {
        oms localoms = (oms)paramomt.next();
        if ((localoms.jdField_e_of_type_Int == 1) || (localoms.jdField_e_of_type_Int == 2)) {
          localArrayList.add(localoms.jdField_b_of_type_JavaLangString);
        } else if (localoms.jdField_e_of_type_Int == 3) {
          localArrayList.add(localoms.d);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "getPicUrlList | pathsize " + localArrayList.size());
    return localArrayList;
  }
  
  private static JSONObject a(VafContext paramVafContext, omt paramomt, boolean paramBoolean)
  {
    BaseCommentData localBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if ((localBaseCommentData == null) || (localBaseCommentData.commentContent == null) || (paramomt.jdField_a_of_type_JavaLangCharSequence == null)) {
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
        ((JSONObject)localObject2).put("author_header_flag_one", alud.a(2131702587));
      }
      if (!TextUtils.isEmpty(localBaseCommentData.userTitle)) {
        ((JSONObject)localObject2).put("comment_describe", localBaseCommentData.userTitle);
      }
      String str = olt.a(localBaseCommentData.nickName, 10);
      localObject1 = str;
      if (str == null) {
        localObject1 = alud.a(2131709684);
      }
      ((JSONObject)localObject2).put("nickname", localObject1);
      ((JSONObject)localObject2).put("commentModel", paramomt);
      if (((localBaseCommentData instanceof CommentData)) && (localBaseCommentData.isAwesome())) {
        ((JSONObject)localObject2).put("awsome_postmark_img", "awsome_postmark");
      }
      if ((paramomt.a()) && (paramBoolean)) {
        ((JSONObject)localObject2).put("comment_model", paramomt);
      }
      long l2 = localBaseCommentData.commentTime;
      long l1 = l2;
      if (l2 == 0L) {
        l1 = System.currentTimeMillis();
      }
      ((JSONObject)localObject2).put("time", orr.a(l1, true));
      if (localBaseCommentData.medalInfo != null) {
        ors.a((JSONObject)localObject2, localBaseCommentData.medalInfo);
      }
      if (!paramBoolean) {
        break label1113;
      }
    }
    label586:
    label1113:
    for (Object localObject1 = a(paramomt, (JSONObject)localObject2);; localObject1 = localException) {
      for (;;)
      {
        if ((localBaseCommentData instanceof CommentData)) {
          if (paramBoolean)
          {
            localObject2 = (CommentData)localBaseCommentData;
            if (((CommentData)localObject2).subCommentNum > 0)
            {
              ((JSONObject)localObject1).put("reply_count", bkbq.a(((CommentData)localObject2).subCommentNum, 99989500L, "9999万+", "0") + alud.a(2131702581));
              ((JSONObject)localObject1).put("id_comment_tail_3_dot", new JSONObject());
              ((JSONObject)localObject1).put("reply_count_none", "");
              ((JSONObject)localObject1).put("id_comment_tail_center_dot", new JSONObject());
              label473:
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
            paramVafContext = (oms)localBaseCommentData.mediaDataList.get(0);
            int i = paramVafContext.jdField_e_of_type_Int;
            QLog.d("CommentProteusUtil", 2, "mediaData type is " + i);
            f1 = paramVafContext.jdField_a_of_type_Int;
            f1 = paramVafContext.jdField_b_of_type_Int;
            if (paramVafContext.jdField_a_of_type_Int >= paramVafContext.jdField_b_of_type_Int) {
              break label1047;
            }
            f2 = 89.0F;
            f1 = 113.0F;
            paramomt = a(paramomt);
            ((JSONObject)localObject1).put("thumHeight", "" + f1);
            ((JSONObject)localObject1).put("thumWidth", "" + f2);
            ((JSONObject)localObject1).put("media_thumimg_url", paramVafContext.jdField_e_of_type_JavaLangString);
            if ((paramomt == null) || (paramomt.size() <= 0)) {
              break label1082;
            }
            paramVafContext = (String)paramomt.get(0);
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
            ((JSONObject)localObject1).put("reply_count_none", alud.a(2131702588));
            ((JSONObject)localObject1).put("id_comment_tail_center_dot", new JSONObject());
            ((JSONObject)localObject1).put("id_comment_tail_3_dot", new JSONObject());
            ((JSONObject)localObject1).remove("reply_count");
            break label473;
            ((JSONObject)localObject1).put("id_comment_tail_3_dot", new JSONObject());
            break label473;
            ((JSONObject)localObject1).put("reply_count_none", alud.a(2131702585));
            ((JSONObject)localObject1).put("id_comment_tail_center_dot", new JSONObject());
            ((JSONObject)localObject1).put("id_comment_tail_3_dot", new JSONObject());
            ((JSONObject)localObject1).remove("reply_count");
            break label473;
            if (paramVafContext.jdField_a_of_type_Int > paramVafContext.jdField_b_of_type_Int)
            {
              f2 = 113.0F;
              f1 = 89.0F;
              break label708;
            }
            f2 = 89.0F;
            f1 = 89.0F;
            break label708;
            paramVafContext = "";
            break label807;
            paramVafContext = alud.a(2131702575);
            continue;
            paramVafContext = alud.a(2131702582);
          }
        }
        catch (Exception localException)
        {
          break label586;
        }
      }
    }
  }
  
  public static JSONObject a(omg paramomg, VafContext paramVafContext, omt paramomt, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject2 = new JSONObject();
    if (paramomt == null) {
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
      a(paramomt, localJSONObject1);
      return localJSONObject1;
      localJSONObject1 = a(paramVafContext, paramomt, paramBoolean);
      continue;
      localJSONObject1 = b(paramomt);
      continue;
      localJSONObject1 = a(paramomt);
      continue;
      localJSONObject1 = a(paramomt, paramomg);
    }
  }
  
  private static JSONObject a(omt paramomt)
  {
    if (paramomt == null) {}
    do
    {
      return null;
      paramomt = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (paramomt == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_banner");
    localJSONObject.put("operation_banner_icon", "rij_icon_notify");
    localJSONObject.put("operation_banner_title", paramomt.commentContent);
    QLog.d("CommentProteusUtil", 2, "comment banner data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(omt paramomt, omg paramomg)
  {
    Object localObject = omz.a(paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    int i;
    long l1;
    if ((localObject != null) && (paramomg != null))
    {
      long l2 = ((omz)localObject).a(paramomg.b());
      i = j;
      l1 = l2;
      if (paramomg != null)
      {
        i = j;
        l1 = l2;
        if (paramomg.b() == 6)
        {
          i = 0;
          l1 = l2;
        }
      }
    }
    for (;;)
    {
      if (paramomt.jdField_a_of_type_Int == 2) {
        paramomg = "rij_new_comment_title_icon";
      }
      for (paramomt = "rij_comment_menu_new_icon";; paramomt = "rij_comment_menu_hot_icon")
      {
        if (l1 > 0L) {}
        for (localObject = "（" + l1 + "）";; localObject = "")
        {
          localJSONObject.put("style_ID", "ReadInJoy_comment_title");
          localJSONObject.put("comment_title", c);
          localJSONObject.put("comment_count", localObject);
          localJSONObject.put("comment_title_icon_url", paramomg);
          if (i != 0)
          {
            paramomg = new JSONObject();
            paramomg.put("commnet_menu_icon_url", paramomt);
            paramomg.put("rij_comment_type_choose_highlight", paramomt);
            localJSONObject.put("id_comment_type_choose_icon", paramomg);
          }
          QLog.d("CommentProteusUtil", 2, "getCommentTitleJsonNew | comment title json str : " + localJSONObject.toString());
          return localJSONObject;
        }
        paramomg = "rij_hot_comment_title_icon";
      }
      l1 = 0L;
      i = j;
    }
  }
  
  private static JSONObject a(omt paramomt, JSONObject paramJSONObject)
  {
    if ((paramomt == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {}
    while (!(paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return paramJSONObject;
    }
    List localList = paramomt.c;
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
          paramJSONObject.put("subcomment_one", paramomt);
        }
        for (;;)
        {
          j += 1;
          break;
          paramJSONObject.put("subcomment_two", paramomt);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "bindExposeSubCommentData : " + paramJSONObject.toString());
    return paramJSONObject;
  }
  
  public static void a(Container paramContainer, omg paramomg, omt paramomt)
  {
    if ((paramContainer == null) || (paramomt == null) || (paramomg == null)) {
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new ojn(paramomg, paramomt, paramContainer));
  }
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, omg paramomg, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (paramomg == null)) {
      return;
    }
    try
    {
      biby.a("CommentProteusUtil.bindData");
      opy.a(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = a(paramomg, paramVafContext, (omt)paramomg.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramTemplateBean.bindData(paramVafContext);
          a(paramContainer, paramomg, (omt)paramomg.getItem(paramInt1));
        }
      }
      biby.a();
      return;
    }
    catch (JSONException paramVafContext)
    {
      QLog.d("CommentProteusUtil", 2, "bindData " + paramVafContext.getMessage());
    }
  }
  
  private static void a(omt paramomt, JSONObject paramJSONObject)
  {
    if ((paramomt == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {
      return;
    }
    paramomt = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.styleData;
    QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData : " + paramomt + " dataJson : " + paramJSONObject.toString());
    if (TextUtils.isEmpty(paramomt))
    {
      QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData is null");
      return;
    }
    try
    {
      paramomt = new JSONObject(paramomt);
      if (paramomt != null)
      {
        Iterator localIterator = paramomt.keys();
        while ((localIterator != null) && (localIterator.hasNext()))
        {
          String str = (String)localIterator.next();
          paramJSONObject.put(str, paramomt.get(str));
        }
      }
      return;
    }
    catch (JSONException paramomt)
    {
      paramomt.printStackTrace();
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
  
  private static JSONObject b(omt paramomt)
  {
    if (paramomt == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return null;
      localBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_cell");
    localJSONObject.put("avator_url", localBaseCommentData.avatar);
    localJSONObject.put("nickname", localBaseCommentData.nickName);
    localJSONObject.put("commentModel", paramomt);
    localJSONObject.put("operation_img_url", localBaseCommentData.activityPicUrl);
    QLog.d("CommentProteusUtil", 2, "comment activity data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static void b(omg paramomg, omt paramomt)
  {
    if (paramomg == null) {
      return;
    }
    bdjz localbdjz = bdgm.a(paramomg.a(), 230);
    paramomg = new okd(paramomg, paramomt);
    localbdjz.setMessage(okv.a());
    localbdjz.setNegativeButton("取消", paramomg);
    localbdjz.setPositiveButton("确定", paramomg);
    localbdjz.setOnCancelListener(null);
    localbdjz.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ojm
 * JD-Core Version:    0.7.0.1
 */