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

public class oqy
{
  public static final String a = anzj.a(2131701104);
  public static final String b;
  public static final String c = anzj.a(2131701103);
  
  static
  {
    jdField_b_of_type_JavaLangString = anzj.a(2131701105);
  }
  
  public static float a()
  {
    try
    {
      f = ((Float)bnrf.a("readinjoy_font_size_ratio_sp", Float.valueOf(1.0F))).floatValue();
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
  
  public static SubCommentData a(otp paramotp, int paramInt)
  {
    if ((paramotp != null) && ((paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)))
    {
      paramotp = (CommentData)paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if ((paramotp.subCommentList != null) && (paramotp.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramotp.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  public static TemplateBean a(VafContext paramVafContext, otp paramotp, int paramInt, boolean paramBoolean, otd paramotd)
  {
    blqm.a("CommentProteusUtil.getTemplateBean");
    suz localsuz1;
    if (paramVafContext == null)
    {
      suz localsuz2 = suz.a("comment_feeds", true);
      localsuz1 = localsuz2;
      if (localsuz2 == null) {
        return null;
      }
    }
    else
    {
      localsuz1 = (suz)paramVafContext.getTemplateFactory();
    }
    if (localsuz1 != null) {}
    for (;;)
    {
      try
      {
        paramVafContext = localsuz1.getTemplateBean(a(paramotd, paramVafContext, paramotp, paramInt, paramBoolean));
        try
        {
          blqm.a();
          return paramVafContext;
        }
        catch (JSONException paramotp) {}
      }
      catch (JSONException paramotp)
      {
        paramVafContext = null;
        continue;
      }
      paramotp.printStackTrace();
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
  
  private static List<String> a(otp paramotp)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramotp == null) || (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList == null)) {
      return localArrayList;
    }
    paramotp = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList;
    if (paramotp.size() > 0)
    {
      paramotp = paramotp.iterator();
      while (paramotp.hasNext())
      {
        oto localoto = (oto)paramotp.next();
        if ((localoto.jdField_e_of_type_Int == 1) || (localoto.jdField_e_of_type_Int == 2)) {
          localArrayList.add(localoto.jdField_b_of_type_JavaLangString);
        } else if (localoto.jdField_e_of_type_Int == 3) {
          localArrayList.add(localoto.d);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "getPicUrlList | pathsize " + localArrayList.size());
    return localArrayList;
  }
  
  public static JSONObject a(otd paramotd, VafContext paramVafContext, otp paramotp, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject2 = new JSONObject();
    if (paramotp == null) {
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
      a(paramotp, localJSONObject1);
      return localJSONObject1;
      localJSONObject1 = a(paramotd, paramVafContext, paramotp, paramBoolean);
      continue;
      localJSONObject1 = b(paramotp);
      continue;
      localJSONObject1 = a(paramotp);
      continue;
      localJSONObject1 = a(paramotp, paramotd);
      continue;
      localJSONObject1 = tpk.a(paramVafContext, paramotp, paramBoolean);
    }
  }
  
  private static JSONObject a(@NotNull otd paramotd, VafContext paramVafContext, otp paramotp, boolean paramBoolean)
  {
    BaseCommentData localBaseCommentData = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if ((localBaseCommentData == null) || (localBaseCommentData.commentContent == null) || (paramotp.jdField_a_of_type_JavaLangCharSequence == null)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_cell");
    a(localJSONObject, localBaseCommentData);
    a(localJSONObject, paramotp);
    a(localJSONObject, localBaseCommentData, paramBoolean);
    a(paramotd, localJSONObject, localBaseCommentData);
    a(localJSONObject, paramotp, paramBoolean);
    a(paramVafContext, localJSONObject, paramotp, localBaseCommentData);
    b(localJSONObject, localBaseCommentData);
    QLog.d("CommentProteusUtil", 2, "getCommentDataJson | comment data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(otp paramotp)
  {
    if (paramotp == null) {}
    do
    {
      return null;
      paramotp = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (paramotp == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_banner");
    localJSONObject.put("operation_banner_icon", "rij_icon_notify");
    localJSONObject.put("operation_banner_title", paramotp.commentContent);
    QLog.d("CommentProteusUtil", 2, "comment banner data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(otp paramotp, JSONObject paramJSONObject)
  {
    if ((paramotp == null) || (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {}
    while (!(paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return paramJSONObject;
    }
    Object localObject = paramotp.c;
    int i;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      i = ((List)localObject).size();
      if (((List)localObject).size() <= 2) {
        break label606;
      }
      i = 2;
    }
    label606:
    for (;;)
    {
      localObject = new String[2][];
      localObject[0] = { "subcomment_one_text_line", "subcomment_one_more_url", "subcomment_one_nick_url", "subcomment_one_nick_name", "subcomment_one_tag_icon_path", "subcomment_one_reply", "subcomment_one_to_nick_url", "subcomment_one_to_nick_name", "subcomment_one_text" };
      localObject[1] = { "subcomment_two_text_line", "subcomment_two_more_url", "subcomment_one_nick_url", "subcomment_two_nick_name", "subcomment_two_tag_icon_path", "subcomment_two_reply", "subcomment_two_to_nick_url", "subcomment_two_to_nick_name", "subcomment_two_text" };
      int j = 0;
      while (j < i)
      {
        SubCommentData localSubCommentData = (SubCommentData)((CommentData)paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList.get(j);
        paramJSONObject.put(localObject[j][0], localSubCommentData.secondMaxLine);
        paramJSONObject.put(localObject[j][1], "more-" + localSubCommentData.parentCommentId + ":" + localSubCommentData.commentId);
        paramJSONObject.put(localObject[j][2], "https://" + localSubCommentData.homepage);
        paramJSONObject.put(localObject[j][3], localSubCommentData.nickName);
        paramJSONObject.put(localObject[j][4], "readinjoy_comment_author_tag");
        if ((localSubCommentData.hasTarget()) && (!TextUtils.isEmpty(localSubCommentData.repliedUserNickname)))
        {
          paramJSONObject.put(localObject[j][5], 2131717475);
          paramJSONObject.put(localObject[j][6], "https://" + localSubCommentData.repliedUserHomePage);
          paramJSONObject.put(localObject[j][7], localSubCommentData.repliedUserNickname);
        }
        paramJSONObject.put(localObject[j][8], " : " + ((CharSequence)paramotp.b.get(j)).toString());
        if ((((CommentData)paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList != null) && (((CommentData)paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList.get(j) != null) && (((SubCommentData)((CommentData)paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList.get(j)).isAuthorLike)) {
          paramJSONObject.put("author_like_one_text", "作者赞过");
        }
        j += 1;
      }
      QLog.d("CommentProteusUtil", 2, "bindExposeSubCommentData : " + paramJSONObject.toString());
      return paramJSONObject;
    }
  }
  
  private static JSONObject a(otp paramotp, otd paramotd)
  {
    Object localObject = otv.a(paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    int i;
    long l1;
    if ((localObject != null) && (paramotd != null))
    {
      long l2 = ((otv)localObject).a(paramotd.b());
      i = j;
      l1 = l2;
      if (paramotd != null)
      {
        i = j;
        l1 = l2;
        if (paramotd.b() == 6)
        {
          i = 0;
          l1 = l2;
        }
      }
    }
    for (;;)
    {
      if (paramotp.jdField_a_of_type_Int == 2) {
        paramotd = "rij_new_comment_title_icon";
      }
      for (paramotp = "rij_comment_menu_new_icon";; paramotp = "rij_comment_menu_hot_icon")
      {
        if (l1 > 0L) {}
        for (localObject = "（" + l1 + "）";; localObject = "")
        {
          localJSONObject.put("style_ID", "ReadInJoy_comment_title");
          localJSONObject.put("comment_title", c);
          localJSONObject.put("comment_count", localObject);
          localJSONObject.put("comment_title_icon_url", paramotd);
          if (i != 0)
          {
            paramotd = new JSONObject();
            paramotd.put("commnet_menu_icon_url", paramotp);
            paramotd.put("rij_comment_type_choose_highlight", paramotp);
            localJSONObject.put("id_comment_type_choose_icon", paramotd);
          }
          QLog.d("CommentProteusUtil", 2, "getCommentTitleJsonNew | comment title json str : " + localJSONObject.toString());
          return localJSONObject;
        }
        paramotd = "rij_hot_comment_title_icon";
      }
      l1 = 0L;
      i = j;
    }
  }
  
  public static void a(Container paramContainer, otd paramotd, otp paramotp)
  {
    if ((paramContainer == null) || (paramotp == null) || (paramotd == null)) {
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new oqz(paramContainer, paramotd, paramotp));
  }
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, otd paramotd, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (paramotd == null)) {
      return;
    }
    try
    {
      blqm.a("CommentProteusUtil.bindData");
      oyj.a(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = a(paramotd, paramVafContext, (otp)paramotd.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramVafContext.put("ratio", a());
          paramTemplateBean.bindData(paramVafContext);
          a(paramContainer, paramotd, (otp)paramotd.getItem(paramInt1));
        }
      }
      blqm.a();
      return;
    }
    catch (JSONException paramVafContext)
    {
      QLog.d("CommentProteusUtil", 2, "bindData " + paramVafContext.getMessage());
    }
  }
  
  private static void a(@NotNull VafContext paramVafContext, @NotNull JSONObject paramJSONObject, @NotNull otp paramotp, @NotNull BaseCommentData paramBaseCommentData)
  {
    float f1 = 113.0F;
    float f2 = 89.0F;
    if ((paramVafContext != null) && (paramVafContext.getContext() != null) && (paramVafContext.getContext().getResources() != null) && (paramBaseCommentData.mediaDataList != null) && (paramBaseCommentData.mediaDataList.size() > 0))
    {
      paramVafContext = (oto)paramBaseCommentData.mediaDataList.get(0);
      int i = paramVafContext.jdField_e_of_type_Int;
      QLog.d("CommentProteusUtil", 2, "mediaData type is " + i);
      float f3 = paramVafContext.jdField_a_of_type_Int;
      f3 = paramVafContext.jdField_b_of_type_Int;
      if (paramVafContext.jdField_a_of_type_Int >= paramVafContext.jdField_b_of_type_Int) {
        break label273;
      }
      paramotp = a(paramotp);
      paramJSONObject.put("thumHeight", "" + f1);
      paramJSONObject.put("thumWidth", "" + f2);
      paramJSONObject.put("media_thumimg_url", paramVafContext.jdField_e_of_type_JavaLangString);
      if ((paramotp == null) || (paramotp.size() <= 0)) {
        break label305;
      }
      paramVafContext = (String)paramotp.get(0);
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
      paramVafContext = anzj.a(2131701102);
      continue;
      paramVafContext = anzj.a(2131701109);
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, BaseCommentData paramBaseCommentData)
  {
    if (TextUtils.isEmpty(paramBaseCommentData.avatar))
    {
      paramJSONObject.put("avator_url", "default_comment_avatar");
      QLog.d("CommentProteusUtil", 2, "getCommentDataJson | isStar " + paramBaseCommentData.isStar() + " isApproved " + paramBaseCommentData.isApproved());
      if (paramBaseCommentData.isStar()) {
        paramJSONObject.put("rij_comment_avatar_borders", "rij_comment_avatar_borders");
      }
      if ((paramBaseCommentData.accountLevelInfo == null) || (!paramBaseCommentData.accountLevelInfo.a()) || (TextUtils.isEmpty(paramBaseCommentData.accountLevelInfo.a))) {
        break label264;
      }
      paramJSONObject.put("rij_comment_v", paramBaseCommentData.accountLevelInfo.a);
    }
    for (;;)
    {
      if (paramBaseCommentData.isAuthorReply()) {
        paramJSONObject.put("author_header_flag_one", anzj.a(2131701114));
      }
      if (!TextUtils.isEmpty(paramBaseCommentData.userTitle)) {
        paramJSONObject.put("comment_describe", paramBaseCommentData.userTitle);
      }
      String str2 = osp.a(paramBaseCommentData.nickName, 10);
      String str1 = str2;
      if (str2 == null) {
        str1 = anzj.a(2131708169);
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
      break;
      label264:
      if (paramBaseCommentData.isApproved()) {
        paramJSONObject.put("rij_comment_v", "rij_comment_v");
      }
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData, boolean paramBoolean)
  {
    long l2 = paramBaseCommentData.commentTime;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = System.currentTimeMillis();
    }
    paramJSONObject.put("time", ozr.a(l1, true));
    if ((paramBaseCommentData instanceof CommentData))
    {
      if (paramBoolean)
      {
        paramBaseCommentData = (CommentData)paramBaseCommentData;
        if (paramBaseCommentData.subCommentNum > 0)
        {
          paramJSONObject.put("reply_count", bnrf.a(paramBaseCommentData.subCommentNum, 99989500L, "9999万+", "0") + anzj.a(2131701108));
          paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
          paramJSONObject.put("reply_count_none", "");
          paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
          return;
        }
        paramJSONObject.put("reply_count_none", anzj.a(2131701115));
        paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
        paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
        paramJSONObject.remove("reply_count");
        return;
      }
      paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
      return;
    }
    paramJSONObject.put("reply_count_none", anzj.a(2131701112));
    paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
    paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
    paramJSONObject.remove("reply_count");
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull otp paramotp)
  {
    paramJSONObject.put("commentModel", paramotp);
    if (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null)
    {
      paramJSONObject.put("comment_text", paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentContent);
      paramJSONObject.put("ratio", a());
      if (!(paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
        break label195;
      }
      paramJSONObject.put("comment_more_url", "more-" + paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId);
    }
    for (;;)
    {
      paramJSONObject.put("comment_text_line", paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.maxLine);
      if ((paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData))
      {
        paramotp = (SubCommentData)paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        if (paramotp.hasTarget())
        {
          paramJSONObject.put("reply_normal_text", "回复 ");
          if (!TextUtils.isEmpty(paramotp.repliedUserNickname))
          {
            paramJSONObject.put("reply_highLight_text", paramotp.repliedUserNickname + "：");
            paramJSONObject.put("jump_url", osp.a(paramotp.repliedUserUin));
          }
        }
      }
      return;
      label195:
      if ((paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)) {
        paramJSONObject.put("comment_more_url", "more-" + ((SubCommentData)paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId + ":" + ((SubCommentData)paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).commentId);
      }
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull otp paramotp, boolean paramBoolean)
  {
    if ((paramotp.a()) && (paramBoolean)) {
      paramJSONObject.put("comment_model", paramotp);
    }
    if (paramBoolean) {
      a(paramotp, paramJSONObject);
    }
  }
  
  private static void a(@NotNull otd paramotd, @NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData.isAuthorLike) {
      paramJSONObject.put("author_like_text", "作者赞过");
    }
    if (((paramBaseCommentData instanceof CommentData)) && (paramBaseCommentData.isAwesome())) {
      paramJSONObject.put("awsome_postmark_img", "awsome_postmark");
    }
    if ((paramBaseCommentData.isAuthorSticky) && (paramotd.b() == 3))
    {
      paramJSONObject.put("top_img_path", "rij_comment_sticky_icon");
      paramJSONObject.put("top_margin_text", " ");
    }
    if (paramBaseCommentData.medalInfo != null) {
      ozs.a(paramJSONObject, paramBaseCommentData.medalInfo);
    }
  }
  
  public static void a(otd paramotd, otp paramotp)
  {
    if (paramotd == null) {
      return;
    }
    bhpc localbhpc = bhlq.a(paramotd.a(), 230);
    paramotd = new ora(paramotd, paramotp);
    localbhpc.setMessage(orq.a());
    localbhpc.setNegativeButton("取消", paramotd);
    localbhpc.setPositiveButton("确定", paramotd);
    localbhpc.setOnCancelListener(null);
    localbhpc.show();
  }
  
  private static void a(otp paramotp, JSONObject paramJSONObject)
  {
    if ((paramotp == null) || (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {
      return;
    }
    paramotp = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.styleData;
    QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData : " + paramotp + " dataJson : " + paramJSONObject.toString());
    if (TextUtils.isEmpty(paramotp))
    {
      QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData is null");
      return;
    }
    try
    {
      paramotp = new JSONObject(paramotp);
      if (paramotp != null)
      {
        Iterator localIterator = paramotp.keys();
        while ((localIterator != null) && (localIterator.hasNext()))
        {
          String str = (String)localIterator.next();
          paramJSONObject.put(str, paramotp.get(str));
        }
      }
      return;
    }
    catch (JSONException paramotp)
    {
      paramotp.printStackTrace();
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
  
  private static JSONObject b(otp paramotp)
  {
    if (paramotp == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return null;
      localBaseCommentData = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_cell");
    localJSONObject.put("avator_url", localBaseCommentData.avatar);
    localJSONObject.put("nickname", localBaseCommentData.nickName);
    localJSONObject.put("commentModel", paramotp);
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
 * Qualified Name:     oqy
 * JD-Core Version:    0.7.0.1
 */