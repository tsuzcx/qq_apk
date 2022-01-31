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

public class ntt
{
  private static final String a = ajjy.a(2131636398);
  private static final String b;
  
  static
  {
    jdField_b_of_type_JavaLangString = ajjy.a(2131636399);
  }
  
  public static SubCommentData a(nwx paramnwx, int paramInt)
  {
    if ((paramnwx != null) && ((paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)))
    {
      paramnwx = (CommentData)paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if ((paramnwx.subCommentList != null) && (paramnwx.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramnwx.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  public static TemplateBean a(VafContext paramVafContext, nwx paramnwx, int paramInt, boolean paramBoolean, nwk paramnwk)
  {
    beoj.a("CommentProteusUtil.getTemplateBean");
    rdg localrdg1;
    if (paramVafContext == null)
    {
      rdg localrdg2 = rdg.a("comment_feeds", true);
      localrdg1 = localrdg2;
      if (localrdg2 == null) {
        return null;
      }
    }
    else
    {
      localrdg1 = (rdg)paramVafContext.getTemplateFactory();
    }
    if (localrdg1 != null) {}
    for (;;)
    {
      try
      {
        paramVafContext = localrdg1.getTemplateBean(a(paramnwk, paramVafContext, paramnwx, paramInt, paramBoolean));
        try
        {
          beoj.a();
          return paramVafContext;
        }
        catch (JSONException paramnwx) {}
      }
      catch (JSONException paramnwx)
      {
        paramVafContext = null;
        continue;
      }
      paramnwx.printStackTrace();
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
  
  private static List<String> a(nwx paramnwx)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramnwx == null) || (paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList == null)) {
      return localArrayList;
    }
    paramnwx = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList;
    if (paramnwx.size() > 0)
    {
      paramnwx = paramnwx.iterator();
      while (paramnwx.hasNext())
      {
        nww localnww = (nww)paramnwx.next();
        if ((localnww.jdField_e_of_type_Int == 1) || (localnww.jdField_e_of_type_Int == 2)) {
          localArrayList.add(localnww.jdField_b_of_type_JavaLangString);
        } else if (localnww.jdField_e_of_type_Int == 3) {
          localArrayList.add(localnww.d);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "getPicUrlList | pathsize " + localArrayList.size());
    return localArrayList;
  }
  
  private static JSONObject a(VafContext paramVafContext, nwx paramnwx, boolean paramBoolean)
  {
    BaseCommentData localBaseCommentData = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if (localBaseCommentData == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_cell");
    if (TextUtils.isEmpty(localBaseCommentData.avatar))
    {
      localJSONObject.put("avator_url", "default_comment_avatar");
      QLog.d("CommentProteusUtil", 2, "getCommentDataJson | isStar " + localBaseCommentData.isStar() + " isApproved " + localBaseCommentData.isApproved());
      if (localBaseCommentData.isStar()) {
        localJSONObject.put("rij_comment_avatar_borders", "rij_comment_avatar_borders");
      }
      if (localBaseCommentData.isApproved()) {
        localJSONObject.put("rij_comment_v", "rij_comment_v");
      }
      if (localBaseCommentData.isAuthorReply()) {
        localJSONObject.put("author_header_flag_one", ajjy.a(2131636408));
      }
      if (!TextUtils.isEmpty(localBaseCommentData.userTitle)) {
        localJSONObject.put("comment_describe", localBaseCommentData.userTitle);
      }
      localJSONObject.put("nickname", nvx.a(localBaseCommentData.nickName, 10));
      localJSONObject.put("commentModel", paramnwx);
      if (((localBaseCommentData instanceof CommentData)) && (localBaseCommentData.isAwesome())) {
        localJSONObject.put("awsome_postmark_img", "awsome_postmark");
      }
      if ((paramnwx.a()) && (paramBoolean)) {
        localJSONObject.put("comment_model", paramnwx);
      }
      localJSONObject.put("time", oby.a(localBaseCommentData.commentTime, true));
      if (localBaseCommentData.medalInfo != null) {
        obz.a(localJSONObject, localBaseCommentData.medalInfo);
      }
      if (!paramBoolean) {
        break label1057;
      }
      localJSONObject = a(paramnwx, localJSONObject);
    }
    label415:
    label1057:
    for (;;)
    {
      for (;;)
      {
        Object localObject;
        if ((localBaseCommentData instanceof CommentData)) {
          if (paramBoolean)
          {
            localObject = (CommentData)localBaseCommentData;
            if (((CommentData)localObject).subCommentNum > 0)
            {
              localJSONObject.put("reply_count", bgmq.a(((CommentData)localObject).subCommentNum, 99989500L, "9999万+", "0") + ajjy.a(2131636402));
              localJSONObject.put("id_comment_tail_3_dot", new JSONObject());
              localJSONObject.put("reply_count_none", "");
              localJSONObject.put("id_comment_tail_center_dot", new JSONObject());
              if (TextUtils.isEmpty(localBaseCommentData.flowGuidePtsData)) {}
            }
          }
        }
        try
        {
          localObject = new JSONObject(localBaseCommentData.flowGuidePtsData);
          localJSONObject.put("diversion_view_color", ((JSONObject)localObject).optString("diversion_view_color"));
          localJSONObject.put("diversion_app_icon", ((JSONObject)localObject).optString("diversion_app_icon"));
          localJSONObject.put("app_wording", ((JSONObject)localObject).optString("app_wording"));
          localJSONObject.put("diversion_font_color", ((JSONObject)localObject).optString("diversion_font_color"));
          localJSONObject.put("jump_schema", a(((JSONObject)localObject).optString("app_schema")));
          float f1;
          float f2;
          if ((paramVafContext != null) && (paramVafContext.getContext() != null) && (paramVafContext.getContext().getResources() != null) && (localBaseCommentData.mediaDataList != null) && (localBaseCommentData.mediaDataList.size() > 0))
          {
            paramVafContext = (nww)localBaseCommentData.mediaDataList.get(0);
            int i = paramVafContext.jdField_e_of_type_Int;
            QLog.d("CommentProteusUtil", 2, "mediaData type is " + i);
            f1 = paramVafContext.jdField_a_of_type_Int;
            f1 = paramVafContext.jdField_b_of_type_Int;
            if (paramVafContext.jdField_a_of_type_Int >= paramVafContext.jdField_b_of_type_Int) {
              break label991;
            }
            f2 = 89.0F;
            f1 = 113.0F;
            paramnwx = a(paramnwx);
            localJSONObject.put("thumHeight", "" + f1);
            localJSONObject.put("thumWidth", "" + f2);
            localJSONObject.put("media_thumimg_url", paramVafContext.jdField_e_of_type_JavaLangString);
            if ((paramnwx == null) || (paramnwx.size() <= 0)) {
              break label1026;
            }
            paramVafContext = (String)paramnwx.get(0);
            label749:
            localJSONObject.put("pic_url", paramVafContext);
            paramVafContext = "";
            switch (i)
            {
            }
          }
          for (;;)
          {
            if (!TextUtils.isEmpty(paramVafContext)) {
              localJSONObject.put("media_type_str", paramVafContext);
            }
            QLog.d("CommentProteusUtil", 2, "comment data json str : " + localJSONObject.toString());
            return localJSONObject;
            localJSONObject.put("avator_url", localBaseCommentData.avatar);
            break;
            localJSONObject.put("reply_count_none", ajjy.a(2131636409));
            localJSONObject.put("id_comment_tail_center_dot", new JSONObject());
            localJSONObject.put("id_comment_tail_3_dot", new JSONObject());
            localJSONObject.remove("reply_count");
            break label415;
            localJSONObject.put("id_comment_tail_3_dot", new JSONObject());
            break label415;
            localJSONObject.put("reply_count_none", ajjy.a(2131636406));
            localJSONObject.put("id_comment_tail_center_dot", new JSONObject());
            localJSONObject.put("id_comment_tail_3_dot", new JSONObject());
            localJSONObject.remove("reply_count");
            break label415;
            label991:
            if (paramVafContext.jdField_a_of_type_Int > paramVafContext.jdField_b_of_type_Int)
            {
              f2 = 113.0F;
              f1 = 89.0F;
              break label650;
            }
            f2 = 89.0F;
            f1 = 89.0F;
            break label650;
            paramVafContext = "";
            break label749;
            paramVafContext = ajjy.a(2131636396);
            continue;
            paramVafContext = ajjy.a(2131636403);
          }
        }
        catch (Exception localException)
        {
          break label528;
        }
      }
    }
  }
  
  public static JSONObject a(nwk paramnwk, VafContext paramVafContext, nwx paramnwx, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject2 = new JSONObject();
    if (paramnwx == null) {
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
      a(paramnwx, localJSONObject1);
      return localJSONObject1;
      localJSONObject1 = a(paramVafContext, paramnwx, paramBoolean);
      continue;
      localJSONObject1 = b(paramnwx);
      continue;
      localJSONObject1 = a(paramnwx);
      continue;
      localJSONObject1 = a(paramnwx, paramnwk);
    }
  }
  
  private static JSONObject a(nwx paramnwx)
  {
    if (paramnwx == null) {}
    do
    {
      return null;
      paramnwx = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (paramnwx == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_banner");
    localJSONObject.put("operation_banner_icon", "rij_icon_notify");
    localJSONObject.put("operation_banner_title", paramnwx.commentContent);
    QLog.d("CommentProteusUtil", 2, "comment banner data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(nwx paramnwx, nwk paramnwk)
  {
    nxd localnxd = nxd.a(paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    String str2 = ajjy.a(2131636397);
    String str1 = a;
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    int i;
    long l1;
    if ((localnxd != null) && (paramnwk != null))
    {
      long l2 = localnxd.a(paramnwk.b());
      i = j;
      l1 = l2;
      if (paramnwk != null)
      {
        i = j;
        l1 = l2;
        if (paramnwk.b() == 6)
        {
          i = 0;
          l1 = l2;
        }
      }
    }
    for (;;)
    {
      if (paramnwx.jdField_a_of_type_Int == 2) {}
      for (paramnwx = jdField_b_of_type_JavaLangString;; paramnwx = str1)
      {
        if (l1 > 0L) {}
        for (paramnwk = " " + l1 + " ";; paramnwk = "")
        {
          localJSONObject.put("style_ID", "ReadInJoy_comment_title");
          localJSONObject.put("comment_title", str2);
          localJSONObject.put("comment_count", paramnwk);
          if (i != 0)
          {
            localJSONObject.put("id_comment_type_choose_icon", new JSONObject());
            paramnwk = new JSONObject();
            paramnwk.put("comment_type", paramnwx);
            localJSONObject.put("id_comment_type_choose_text", paramnwk);
          }
          QLog.d("CommentProteusUtil", 2, "comment title json str : " + localJSONObject.toString());
          return localJSONObject;
        }
      }
      l1 = 0L;
      i = j;
    }
  }
  
  private static JSONObject a(nwx paramnwx, JSONObject paramJSONObject)
  {
    if ((paramnwx == null) || (paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {}
    while (!(paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return paramJSONObject;
    }
    List localList = paramnwx.c;
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
          paramJSONObject.put("subcomment_one", paramnwx);
        }
        for (;;)
        {
          j += 1;
          break;
          paramJSONObject.put("subcomment_two", paramnwx);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "bindExposeSubCommentData : " + paramJSONObject.toString());
    return paramJSONObject;
  }
  
  public static void a(Container paramContainer, nwk paramnwk, nwx paramnwx)
  {
    if ((paramContainer == null) || (paramnwx == null) || (paramnwk == null)) {
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new ntu(paramnwk, paramnwx, paramContainer));
  }
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, nwk paramnwk, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (paramnwk == null)) {
      return;
    }
    try
    {
      beoj.a("CommentProteusUtil.bindData");
      oag.a(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = a(paramnwk, paramVafContext, (nwx)paramnwk.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramTemplateBean.getViewBean().bindData(paramVafContext, paramTemplateBean.getViewDataBinding());
          a(paramContainer, paramnwk, (nwx)paramnwk.getItem(paramInt1));
        }
      }
      beoj.a();
      return;
    }
    catch (JSONException paramVafContext)
    {
      QLog.d("CommentProteusUtil", 2, "bindData " + paramVafContext.getMessage());
    }
  }
  
  private static void a(nwx paramnwx, JSONObject paramJSONObject)
  {
    if ((paramnwx == null) || (paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {
      return;
    }
    paramnwx = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.styleData;
    QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData : " + paramnwx + " dataJson : " + paramJSONObject.toString());
    if (TextUtils.isEmpty(paramnwx))
    {
      QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData is null");
      return;
    }
    try
    {
      paramnwx = new JSONObject(paramnwx);
      if (paramnwx != null)
      {
        Iterator localIterator = paramnwx.keys();
        while ((localIterator != null) && (localIterator.hasNext()))
        {
          String str = (String)localIterator.next();
          paramJSONObject.put(str, paramnwx.get(str));
        }
      }
      return;
    }
    catch (JSONException paramnwx)
    {
      paramnwx.printStackTrace();
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
  
  private static JSONObject b(nwx paramnwx)
  {
    if (paramnwx == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return null;
      localBaseCommentData = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_cell");
    localJSONObject.put("avator_url", localBaseCommentData.avatar);
    localJSONObject.put("nickname", localBaseCommentData.nickName);
    localJSONObject.put("commentModel", paramnwx);
    localJSONObject.put("operation_img_url", localBaseCommentData.activityPicUrl);
    QLog.d("CommentProteusUtil", 2, "comment activity data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static void b(View paramView, nwk paramnwk)
  {
    if (paramnwk == null) {}
    nzl localnzl;
    do
    {
      return;
      localnzl = new nzl(paramnwk, paramnwk.a);
      localnzl.a(paramnwk);
    } while (paramnwk.a() == null);
    localnzl.b(paramView, paramnwk.b());
  }
  
  private static void b(nwk paramnwk, nwx paramnwx)
  {
    if (paramnwk == null) {
      return;
    }
    bafb localbafb = babr.a(paramnwk.a(), 230);
    paramnwk = new nui(paramnwk, paramnwx);
    localbafb.setMessage(nva.a());
    localbafb.setNegativeButton("取消", paramnwk);
    localbafb.setPositiveButton("确定", paramnwk);
    localbafb.setOnCancelListener(null);
    localbafb.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ntt
 * JD-Core Version:    0.7.0.1
 */