import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ActivityLevel;

public class ozx
{
  public static final String a = anvx.a(2131701690);
  public static final String b;
  public static final String c = anvx.a(2131701689);
  
  static
  {
    jdField_b_of_type_JavaLangString = anvx.a(2131701691);
  }
  
  public static float a()
  {
    try
    {
      f = ((Float)bmhv.a("readinjoy_font_size_ratio_sp", Float.valueOf(1.0F))).floatValue();
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
  
  public static SubCommentData a(pdp parampdp, int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    if ((parampdp != null) && ((parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)))
    {
      parampdp = (CommentData)parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if ((parampdp.subCommentList != null) && (parampdp.subCommentList.size() > paramInt)) {
        return (SubCommentData)parampdp.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  public static TemplateBean a(VafContext paramVafContext, pdp parampdp, int paramInt, boolean paramBoolean, pcf parampcf)
  {
    blfz.a("CommentProteusUtil.getTemplateBean");
    tmh localtmh1;
    if (paramVafContext == null)
    {
      tmh localtmh2 = tmh.a("comment_feeds", true);
      localtmh1 = localtmh2;
      if (localtmh2 == null) {
        return null;
      }
    }
    else
    {
      localtmh1 = (tmh)paramVafContext.getTemplateFactory();
    }
    if (localtmh1 != null) {}
    for (;;)
    {
      try
      {
        paramVafContext = localtmh1.getTemplateBean(a(parampcf, paramVafContext, parampdp, paramInt, paramBoolean));
        try
        {
          blfz.a();
          return paramVafContext;
        }
        catch (JSONException parampdp) {}
      }
      catch (JSONException parampdp)
      {
        paramVafContext = null;
        continue;
      }
      parampdp.printStackTrace();
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
  
  private static List<String> a(pdp parampdp)
  {
    ArrayList localArrayList = new ArrayList();
    if ((parampdp == null) || (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList == null)) {
      return localArrayList;
    }
    parampdp = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList;
    if (parampdp.size() > 0)
    {
      parampdp = parampdp.iterator();
      while (parampdp.hasNext())
      {
        pdo localpdo = (pdo)parampdp.next();
        if ((localpdo.jdField_e_of_type_Int == 1) || (localpdo.jdField_e_of_type_Int == 2)) {
          localArrayList.add(localpdo.jdField_b_of_type_JavaLangString);
        } else if (localpdo.jdField_e_of_type_Int == 3) {
          localArrayList.add(localpdo.d);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "getPicUrlList | pathsize " + localArrayList.size());
    return localArrayList;
  }
  
  public static JSONObject a(pcf parampcf, VafContext paramVafContext, pdp parampdp, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject2 = new JSONObject();
    if (parampdp == null) {
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
      a(parampdp, localJSONObject1);
      return localJSONObject1;
      localJSONObject1 = a(parampcf, paramVafContext, parampdp, paramBoolean);
      continue;
      localJSONObject1 = b(parampdp);
      continue;
      localJSONObject1 = a(parampdp);
      continue;
      localJSONObject1 = a(parampdp, parampcf);
    }
  }
  
  private static JSONObject a(@NotNull pcf parampcf, VafContext paramVafContext, pdp parampdp, boolean paramBoolean)
  {
    BaseCommentData localBaseCommentData = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if ((localBaseCommentData == null) || (localBaseCommentData.commentContent == null) || (parampdp.jdField_a_of_type_JavaLangCharSequence == null)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_cell");
    a(localJSONObject, localBaseCommentData);
    a(localJSONObject, parampdp);
    a(localJSONObject, localBaseCommentData, paramBoolean);
    a(parampcf, localJSONObject, localBaseCommentData);
    a(localJSONObject, parampdp, paramBoolean);
    a(paramVafContext, localJSONObject, parampdp, localBaseCommentData);
    b(localJSONObject, localBaseCommentData);
    QLog.d("CommentProteusUtil", 2, "getCommentDataJson | comment data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(pdp parampdp)
  {
    if (parampdp == null) {}
    do
    {
      return null;
      parampdp = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (parampdp == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_banner");
    localJSONObject.put("operation_banner_icon", "rij_icon_notify");
    localJSONObject.put("operation_banner_title", parampdp.commentContent);
    QLog.d("CommentProteusUtil", 2, "comment banner data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(pdp parampdp, JSONObject paramJSONObject)
  {
    if ((parampdp == null) || (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {}
    while (!(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return paramJSONObject;
    }
    parampdp = ((CommentData)parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList;
    int j;
    String[][] arrayOfString;;
    int i;
    if ((parampdp != null) && (parampdp.size() > 0))
    {
      j = parampdp.size();
      arrayOfString; = new String[2][];
      arrayOfString;[0] = { "subcomment_one_text_line", "subcomment_one_more_url", "subcomment_one_nick_url", "subcomment_one_nick_name", "subcomment_one_tag_icon_path", "subcomment_one_reply", "subcomment_one_to_nick_url", "subcomment_one_to_nick_name", "subcomment_one_text", "author_like_one_text", "subcomment_one_tag_icon_width" };
      arrayOfString;[1] = { "subcomment_two_text_line", "subcomment_two_more_url", "subcomment_two_nick_url", "subcomment_two_nick_name", "subcomment_two_tag_icon_path", "subcomment_two_reply", "subcomment_two_to_nick_url", "subcomment_two_to_nick_name", "subcomment_two_text", "author_like_two_text", "subcomment_two_tag_icon_width" };
      i = 0;
    }
    SubCommentData localSubCommentData;
    for (;;)
    {
      if ((i >= j) || (i >= 2))
      {
        QLog.d("CommentProteusUtil", 2, "bindExposeSubCommentData : " + paramJSONObject.toString());
        return paramJSONObject;
      }
      localSubCommentData = (SubCommentData)parampdp.get(i);
      if (localSubCommentData != null) {
        break;
      }
      i += 1;
    }
    String str = pjj.g + bhcu.encodeToString(localSubCommentData.uin.getBytes(), 2);
    paramJSONObject.put(arrayOfString;[i][0], localSubCommentData.secondMaxLine);
    paramJSONObject.put(arrayOfString;[i][1], "more-" + localSubCommentData.parentCommentId + ":" + localSubCommentData.commentId);
    paramJSONObject.put(arrayOfString;[i][2], str);
    paramJSONObject.put(arrayOfString;[i][3], localSubCommentData.nickName);
    if (localSubCommentData.isAuthorReply())
    {
      paramJSONObject.put(arrayOfString;[i][4], "readinjoy_comment_author_tag");
      paramJSONObject.put(arrayOfString;[i][10], "40px");
    }
    for (;;)
    {
      if ((localSubCommentData.hasTarget()) && (!TextUtils.isEmpty(localSubCommentData.repliedUserNickname)))
      {
        str = pjj.g + bhcu.encodeToString(localSubCommentData.repliedUserUin.getBytes(), 2);
        paramJSONObject.put(arrayOfString;[i][5], anvx.a(2131718082));
        paramJSONObject.put(arrayOfString;[i][6], str);
        paramJSONObject.put(arrayOfString;[i][7], localSubCommentData.repliedUserNickname);
      }
      paramJSONObject.put(arrayOfString;[i][8], " : " + localSubCommentData.commentContent);
      if ((parampdp == null) || (localSubCommentData == null) || (!localSubCommentData.isAuthorLike)) {
        break;
      }
      paramJSONObject.put(arrayOfString;[i][9], "作者赞过");
      break;
      if (localSubCommentData.isFollowing)
      {
        paramJSONObject.put(arrayOfString;[i][4], "readinjoy_comment_follow_tag");
        paramJSONObject.put(arrayOfString;[i][10], "51px");
      }
    }
  }
  
  private static JSONObject a(pdp parampdp, pcf parampcf)
  {
    Object localObject = pdv.a(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    int i;
    long l1;
    if ((localObject != null) && (parampcf != null))
    {
      long l2 = ((pdv)localObject).a(parampcf.b());
      i = j;
      l1 = l2;
      if (parampcf != null)
      {
        i = j;
        l1 = l2;
        if (parampcf.b() == 6)
        {
          i = 0;
          l1 = l2;
        }
      }
    }
    for (;;)
    {
      if (parampdp.jdField_a_of_type_Int == 2) {
        parampcf = "rij_new_comment_title_icon";
      }
      for (parampdp = "rij_comment_menu_new_icon";; parampdp = "rij_comment_menu_hot_icon")
      {
        if (l1 > 0L) {}
        for (localObject = "（" + l1 + "）";; localObject = "")
        {
          localJSONObject.put("style_ID", "ReadInJoy_comment_title");
          localJSONObject.put("comment_title", c);
          localJSONObject.put("comment_count", localObject);
          localJSONObject.put("comment_title_icon_url", parampcf);
          if (i != 0)
          {
            parampcf = new JSONObject();
            parampcf.put("commnet_menu_icon_url", parampdp);
            parampcf.put("rij_comment_type_choose_highlight", parampdp);
            localJSONObject.put("id_comment_type_choose_icon", parampcf);
          }
          QLog.d("CommentProteusUtil", 2, "getCommentTitleJsonNew | comment title json str : " + localJSONObject.toString());
          return localJSONObject;
        }
        parampcf = "rij_hot_comment_title_icon";
      }
      l1 = 0L;
      i = j;
    }
  }
  
  public static void a(Container paramContainer, pcf parampcf, pdp parampdp)
  {
    if ((paramContainer == null) || (parampdp == null) || (parampcf == null)) {
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new ozy(paramContainer, parampcf, parampdp));
  }
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, pcf parampcf, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (parampcf == null)) {
      return;
    }
    try
    {
      blfz.a("CommentProteusUtil.bindData");
      piv.a(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = a(parampcf, paramVafContext, (pdp)parampcf.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramVafContext.put("ratio", a());
          paramTemplateBean.bindData(paramVafContext);
          a(paramContainer, parampcf, (pdp)parampcf.getItem(paramInt1));
        }
      }
      blfz.a();
      return;
    }
    catch (JSONException paramVafContext)
    {
      QLog.d("CommentProteusUtil", 2, "bindData " + paramVafContext.getMessage());
    }
  }
  
  private static void a(@NotNull VafContext paramVafContext, @NotNull JSONObject paramJSONObject, @NotNull pdp parampdp, @NotNull BaseCommentData paramBaseCommentData)
  {
    float f1 = 113.0F;
    float f2 = 89.0F;
    if ((paramVafContext != null) && (paramVafContext.getContext() != null) && (paramVafContext.getContext().getResources() != null) && (paramBaseCommentData.mediaDataList != null) && (paramBaseCommentData.mediaDataList.size() > 0))
    {
      paramVafContext = (pdo)paramBaseCommentData.mediaDataList.get(0);
      int i = paramVafContext.jdField_e_of_type_Int;
      QLog.d("CommentProteusUtil", 2, "mediaData type is " + i);
      float f3 = paramVafContext.jdField_a_of_type_Int;
      f3 = paramVafContext.jdField_b_of_type_Int;
      if (paramVafContext.jdField_a_of_type_Int >= paramVafContext.jdField_b_of_type_Int) {
        break label273;
      }
      parampdp = a(parampdp);
      paramJSONObject.put("thumHeight", "" + f1);
      paramJSONObject.put("thumWidth", "" + f2);
      paramJSONObject.put("media_thumimg_url", paramVafContext.jdField_e_of_type_JavaLangString);
      if ((parampdp == null) || (parampdp.size() <= 0)) {
        break label305;
      }
      paramVafContext = (String)parampdp.get(0);
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
      paramVafContext = anvx.a(2131701688);
      continue;
      paramVafContext = anvx.a(2131701695);
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
        break label302;
      }
      paramJSONObject.put("rij_comment_v", paramBaseCommentData.accountLevelInfo.a);
    }
    for (;;)
    {
      if (paramBaseCommentData.isAuthorReply()) {
        paramJSONObject.put("author_header_flag_one", anvx.a(2131701700));
      }
      if (!TextUtils.isEmpty(paramBaseCommentData.userTitle)) {
        paramJSONObject.put("comment_describe", paramBaseCommentData.userTitle);
      }
      String str2 = pbq.a(paramBaseCommentData.nickName, 10);
      String str1 = str2;
      if (str2 == null) {
        str1 = anvx.a(2131708748);
      }
      paramJSONObject.put("nickname", str1);
      if ((paramBaseCommentData.isFollowing) && (!paramBaseCommentData.isAuthorReply())) {
        paramJSONObject.put("author_header_follow_flag", "我的关注");
      }
      if (!TextUtils.isEmpty(paramBaseCommentData.avatarPendantUrl)) {
        paramJSONObject.put("rij_comment_avatar_pendant", paramBaseCommentData.avatarPendantUrl);
      }
      if ((paramBaseCommentData.activityLevel != null) && (paramBaseCommentData.activityLevel.icon.has())) {
        paramJSONObject.put("activity_level_icon_url", paramBaseCommentData.activityLevel.icon.get());
      }
      return;
      paramJSONObject.put("avator_url", paramBaseCommentData.avatar);
      break;
      label302:
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
    paramJSONObject.put("time", pkg.a(l1, true));
    if ((paramBaseCommentData instanceof CommentData))
    {
      if (paramBoolean)
      {
        paramBaseCommentData = (CommentData)paramBaseCommentData;
        if (paramBaseCommentData.subCommentNum > 0)
        {
          paramJSONObject.put("reply_count", bmhv.a(paramBaseCommentData.subCommentNum, 99989500L, "9999万+", "0") + anvx.a(2131701694));
          paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
          paramJSONObject.put("reply_count_none", "");
          paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
          return;
        }
        paramJSONObject.put("reply_count_none", anvx.a(2131701701));
        paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
        paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
        paramJSONObject.remove("reply_count");
        return;
      }
      paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
      return;
    }
    paramJSONObject.put("reply_count_none", anvx.a(2131701698));
    paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
    paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
    paramJSONObject.remove("reply_count");
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull pdp parampdp)
  {
    paramJSONObject.put("commentModel", parampdp);
    String str;
    if (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null)
    {
      paramJSONObject.put("comment_text", parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentContent);
      if (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.hasLinkData()) {
        paramJSONObject.put("commentLinkModel", parampdp);
      }
      paramJSONObject.put("ratio", a());
      str = null;
      if (!(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
        break label218;
      }
      str = "more-" + parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId;
    }
    for (;;)
    {
      paramJSONObject.put("comment_text_more_url", str);
      paramJSONObject.put("comment_text_line", parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.maxLine);
      if ((parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData))
      {
        parampdp = (SubCommentData)parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        if (parampdp.hasTarget())
        {
          paramJSONObject.put("reply_normal_text", "回复 ");
          if (!TextUtils.isEmpty(parampdp.repliedUserNickname))
          {
            paramJSONObject.put("reply_highLight_text", parampdp.repliedUserNickname + "：");
            paramJSONObject.put("jump_url", pbq.a(parampdp.repliedUserUin));
          }
        }
      }
      return;
      label218:
      if ((parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)) {
        str = "more-" + ((SubCommentData)parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId + ":" + ((SubCommentData)parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).commentId;
      }
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull pdp parampdp, boolean paramBoolean)
  {
    if ((parampdp.a()) && (paramBoolean)) {
      paramJSONObject.put("comment_model", parampdp);
    }
    if (paramBoolean) {
      a(parampdp, paramJSONObject);
    }
  }
  
  private static void a(@NotNull pcf parampcf, @NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData.isAuthorLike) {
      paramJSONObject.put("author_like_text", "作者赞过");
    }
    if (((paramBaseCommentData instanceof CommentData)) && (paramBaseCommentData.isAwesome())) {
      paramJSONObject.put("awsome_postmark_img", "awsome_postmark");
    }
    if ((paramBaseCommentData.isAuthorSticky) && (parampcf.b() == 3))
    {
      paramJSONObject.put("top_img_path", "rij_comment_sticky_icon");
      paramJSONObject.put("top_margin_text", " ");
    }
    if (paramBaseCommentData.medalInfo != null) {
      pnp.a(paramJSONObject, paramBaseCommentData.medalInfo);
    }
  }
  
  public static void a(pcf parampcf, pdp parampdp)
  {
    if (parampcf == null) {
      return;
    }
    QQCustomDialog localQQCustomDialog = bhdj.a(parampcf.a(), 230);
    parampcf = new ozz(parampcf, parampdp);
    localQQCustomDialog.setMessage(pap.a());
    localQQCustomDialog.setNegativeButton("取消", parampcf);
    localQQCustomDialog.setPositiveButton("确定", parampcf);
    localQQCustomDialog.setOnCancelListener(null);
    localQQCustomDialog.show();
  }
  
  private static void a(pdp parampdp, JSONObject paramJSONObject)
  {
    if ((parampdp == null) || (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {
      return;
    }
    parampdp = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.styleData;
    QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData : " + parampdp + " dataJson : " + paramJSONObject.toString());
    if (TextUtils.isEmpty(parampdp))
    {
      QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData is null");
      return;
    }
    try
    {
      parampdp = new JSONObject(parampdp);
      if (parampdp != null)
      {
        Iterator localIterator = parampdp.keys();
        while ((localIterator != null) && (localIterator.hasNext()))
        {
          String str = (String)localIterator.next();
          paramJSONObject.put(str, parampdp.get(str));
        }
      }
      return;
    }
    catch (JSONException parampdp)
    {
      parampdp.printStackTrace();
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
  
  private static JSONObject b(pdp parampdp)
  {
    if (parampdp == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return null;
      localBaseCommentData = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_cell");
    localJSONObject.put("avator_url", localBaseCommentData.avatar);
    localJSONObject.put("nickname", localBaseCommentData.nickName);
    localJSONObject.put("commentModel", parampdp);
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
 * Qualified Name:     ozx
 * JD-Core Version:    0.7.0.1
 */