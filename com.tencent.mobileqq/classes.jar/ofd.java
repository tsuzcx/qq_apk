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

public class ofd
{
  private static final String a = ajyc.a(2131702182);
  private static final String b;
  
  static
  {
    jdField_b_of_type_JavaLangString = ajyc.a(2131702183);
  }
  
  public static SubCommentData a(oii paramoii, int paramInt)
  {
    if ((paramoii != null) && ((paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)))
    {
      paramoii = (CommentData)paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if ((paramoii.subCommentList != null) && (paramoii.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramoii.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  public static TemplateBean a(VafContext paramVafContext, oii paramoii, int paramInt, boolean paramBoolean, ohv paramohv)
  {
    bfwd.a("CommentProteusUtil.getTemplateBean");
    rpu localrpu1;
    if (paramVafContext == null)
    {
      rpu localrpu2 = rpu.a("comment_feeds", true);
      localrpu1 = localrpu2;
      if (localrpu2 == null) {
        return null;
      }
    }
    else
    {
      localrpu1 = (rpu)paramVafContext.getTemplateFactory();
    }
    if (localrpu1 != null) {}
    for (;;)
    {
      try
      {
        paramVafContext = localrpu1.getTemplateBean(a(paramohv, paramVafContext, paramoii, paramInt, paramBoolean));
        try
        {
          bfwd.a();
          return paramVafContext;
        }
        catch (JSONException paramoii) {}
      }
      catch (JSONException paramoii)
      {
        paramVafContext = null;
        continue;
      }
      paramoii.printStackTrace();
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
  
  private static List<String> a(oii paramoii)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramoii == null) || (paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList == null)) {
      return localArrayList;
    }
    paramoii = paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList;
    if (paramoii.size() > 0)
    {
      paramoii = paramoii.iterator();
      while (paramoii.hasNext())
      {
        oih localoih = (oih)paramoii.next();
        if ((localoih.jdField_e_of_type_Int == 1) || (localoih.jdField_e_of_type_Int == 2)) {
          localArrayList.add(localoih.jdField_b_of_type_JavaLangString);
        } else if (localoih.jdField_e_of_type_Int == 3) {
          localArrayList.add(localoih.d);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "getPicUrlList | pathsize " + localArrayList.size());
    return localArrayList;
  }
  
  private static JSONObject a(VafContext paramVafContext, oii paramoii, boolean paramBoolean)
  {
    BaseCommentData localBaseCommentData = paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if ((localBaseCommentData == null) || (localBaseCommentData.commentContent == null) || (paramoii.jdField_a_of_type_JavaLangCharSequence == null)) {
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
        ((JSONObject)localObject2).put("author_header_flag_one", ajyc.a(2131702192));
      }
      if (!TextUtils.isEmpty(localBaseCommentData.userTitle)) {
        ((JSONObject)localObject2).put("comment_describe", localBaseCommentData.userTitle);
      }
      String str = ohi.a(localBaseCommentData.nickName, 10);
      localObject1 = str;
      if (str == null) {
        localObject1 = ajyc.a(2131709289);
      }
      ((JSONObject)localObject2).put("nickname", localObject1);
      ((JSONObject)localObject2).put("commentModel", paramoii);
      if (((localBaseCommentData instanceof CommentData)) && (localBaseCommentData.isAwesome())) {
        ((JSONObject)localObject2).put("awsome_postmark_img", "awsome_postmark");
      }
      if ((paramoii.a()) && (paramBoolean)) {
        ((JSONObject)localObject2).put("comment_model", paramoii);
      }
      long l2 = localBaseCommentData.commentTime;
      long l1 = l2;
      if (l2 == 0L) {
        l1 = System.currentTimeMillis();
      }
      ((JSONObject)localObject2).put("time", onj.a(l1, true));
      if (localBaseCommentData.medalInfo != null) {
        onk.a((JSONObject)localObject2, localBaseCommentData.medalInfo);
      }
      if (!paramBoolean) {
        break label1113;
      }
    }
    label472:
    label1113:
    for (Object localObject1 = a(paramoii, (JSONObject)localObject2);; localObject1 = localException) {
      for (;;)
      {
        if ((localBaseCommentData instanceof CommentData)) {
          if (paramBoolean)
          {
            localObject2 = (CommentData)localBaseCommentData;
            if (((CommentData)localObject2).subCommentNum > 0)
            {
              ((JSONObject)localObject1).put("reply_count", bhvh.a(((CommentData)localObject2).subCommentNum, 99989500L, "9999万+", "0") + ajyc.a(2131702186));
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
            paramVafContext = (oih)localBaseCommentData.mediaDataList.get(0);
            int i = paramVafContext.jdField_e_of_type_Int;
            QLog.d("CommentProteusUtil", 2, "mediaData type is " + i);
            f1 = paramVafContext.jdField_a_of_type_Int;
            f1 = paramVafContext.jdField_b_of_type_Int;
            if (paramVafContext.jdField_a_of_type_Int >= paramVafContext.jdField_b_of_type_Int) {
              break label1047;
            }
            f2 = 89.0F;
            f1 = 113.0F;
            paramoii = a(paramoii);
            ((JSONObject)localObject1).put("thumHeight", "" + f1);
            ((JSONObject)localObject1).put("thumWidth", "" + f2);
            ((JSONObject)localObject1).put("media_thumimg_url", paramVafContext.jdField_e_of_type_JavaLangString);
            if ((paramoii == null) || (paramoii.size() <= 0)) {
              break label1082;
            }
            paramVafContext = (String)paramoii.get(0);
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
            ((JSONObject)localObject1).put("reply_count_none", ajyc.a(2131702193));
            ((JSONObject)localObject1).put("id_comment_tail_center_dot", new JSONObject());
            ((JSONObject)localObject1).put("id_comment_tail_3_dot", new JSONObject());
            ((JSONObject)localObject1).remove("reply_count");
            break label472;
            ((JSONObject)localObject1).put("id_comment_tail_3_dot", new JSONObject());
            break label472;
            ((JSONObject)localObject1).put("reply_count_none", ajyc.a(2131702190));
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
            paramVafContext = ajyc.a(2131702180);
            continue;
            paramVafContext = ajyc.a(2131702187);
          }
        }
        catch (Exception localException)
        {
          break label585;
        }
      }
    }
  }
  
  public static JSONObject a(ohv paramohv, VafContext paramVafContext, oii paramoii, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject2 = new JSONObject();
    if (paramoii == null) {
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
      a(paramoii, localJSONObject1);
      return localJSONObject1;
      localJSONObject1 = a(paramVafContext, paramoii, paramBoolean);
      continue;
      localJSONObject1 = b(paramoii);
      continue;
      localJSONObject1 = a(paramoii);
      continue;
      localJSONObject1 = a(paramoii, paramohv);
    }
  }
  
  private static JSONObject a(oii paramoii)
  {
    if (paramoii == null) {}
    do
    {
      return null;
      paramoii = paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (paramoii == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_banner");
    localJSONObject.put("operation_banner_icon", "rij_icon_notify");
    localJSONObject.put("operation_banner_title", paramoii.commentContent);
    QLog.d("CommentProteusUtil", 2, "comment banner data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(oii paramoii, ohv paramohv)
  {
    oio localoio = oio.a(paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    String str2 = ajyc.a(2131702181);
    String str1 = a;
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    int i;
    long l1;
    if ((localoio != null) && (paramohv != null))
    {
      long l2 = localoio.a(paramohv.b());
      i = j;
      l1 = l2;
      if (paramohv != null)
      {
        i = j;
        l1 = l2;
        if (paramohv.b() == 6)
        {
          i = 0;
          l1 = l2;
        }
      }
    }
    for (;;)
    {
      if (paramoii.jdField_a_of_type_Int == 2) {}
      for (paramoii = jdField_b_of_type_JavaLangString;; paramoii = str1)
      {
        if (l1 > 0L) {}
        for (paramohv = " " + l1 + " ";; paramohv = "")
        {
          localJSONObject.put("style_ID", "ReadInJoy_comment_title");
          localJSONObject.put("comment_title", str2);
          localJSONObject.put("comment_count", paramohv);
          if (i != 0)
          {
            localJSONObject.put("id_comment_type_choose_icon", new JSONObject());
            paramohv = new JSONObject();
            paramohv.put("comment_type", paramoii);
            localJSONObject.put("id_comment_type_choose_text", paramohv);
          }
          QLog.d("CommentProteusUtil", 2, "comment title json str : " + localJSONObject.toString());
          return localJSONObject;
        }
      }
      l1 = 0L;
      i = j;
    }
  }
  
  private static JSONObject a(oii paramoii, JSONObject paramJSONObject)
  {
    if ((paramoii == null) || (paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {}
    while (!(paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return paramJSONObject;
    }
    List localList = paramoii.c;
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
          paramJSONObject.put("subcomment_one", paramoii);
        }
        for (;;)
        {
          j += 1;
          break;
          paramJSONObject.put("subcomment_two", paramoii);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "bindExposeSubCommentData : " + paramJSONObject.toString());
    return paramJSONObject;
  }
  
  public static void a(Container paramContainer, ohv paramohv, oii paramoii)
  {
    if ((paramContainer == null) || (paramoii == null) || (paramohv == null)) {
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new ofe(paramohv, paramoii, paramContainer));
  }
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, ohv paramohv, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (paramohv == null)) {
      return;
    }
    try
    {
      bfwd.a("CommentProteusUtil.bindData");
      olr.a(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = a(paramohv, paramVafContext, (oii)paramohv.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramTemplateBean.getViewBean().bindData(paramVafContext, paramTemplateBean.getViewDataBinding());
          a(paramContainer, paramohv, (oii)paramohv.getItem(paramInt1));
        }
      }
      bfwd.a();
      return;
    }
    catch (JSONException paramVafContext)
    {
      QLog.d("CommentProteusUtil", 2, "bindData " + paramVafContext.getMessage());
    }
  }
  
  private static void a(oii paramoii, JSONObject paramJSONObject)
  {
    if ((paramoii == null) || (paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {
      return;
    }
    paramoii = paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.styleData;
    QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData : " + paramoii + " dataJson : " + paramJSONObject.toString());
    if (TextUtils.isEmpty(paramoii))
    {
      QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData is null");
      return;
    }
    try
    {
      paramoii = new JSONObject(paramoii);
      if (paramoii != null)
      {
        Iterator localIterator = paramoii.keys();
        while ((localIterator != null) && (localIterator.hasNext()))
        {
          String str = (String)localIterator.next();
          paramJSONObject.put(str, paramoii.get(str));
        }
      }
      return;
    }
    catch (JSONException paramoii)
    {
      paramoii.printStackTrace();
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
  
  private static JSONObject b(oii paramoii)
  {
    if (paramoii == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return null;
      localBaseCommentData = paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_cell");
    localJSONObject.put("avator_url", localBaseCommentData.avatar);
    localJSONObject.put("nickname", localBaseCommentData.nickName);
    localJSONObject.put("commentModel", paramoii);
    localJSONObject.put("operation_img_url", localBaseCommentData.activityPicUrl);
    QLog.d("CommentProteusUtil", 2, "comment activity data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static void b(View paramView, ohv paramohv)
  {
    if (paramohv == null) {}
    okw localokw;
    do
    {
      return;
      localokw = new okw(paramohv, paramohv.a);
      localokw.a(paramohv);
    } while (paramohv.a() == null);
    localokw.b(paramView, paramohv.b());
  }
  
  private static void b(ohv paramohv, oii paramoii)
  {
    if (paramohv == null) {
      return;
    }
    bbgg localbbgg = bbcv.a(paramohv.a(), 230);
    paramohv = new ofu(paramohv, paramoii);
    localbbgg.setMessage(ogl.a());
    localbbgg.setNegativeButton("取消", paramohv);
    localbbgg.setPositiveButton("确定", paramohv);
    localbbgg.setOnCancelListener(null);
    localbbgg.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ofd
 * JD-Core Version:    0.7.0.1
 */