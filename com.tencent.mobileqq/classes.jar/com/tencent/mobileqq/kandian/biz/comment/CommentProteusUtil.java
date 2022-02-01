package com.tencent.mobileqq.kandian.biz.comment;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.ad.RIJCommentAdUtils;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ExposedSubCommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.AccountLevelInfo;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.MediaData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.UserIdentityIcon;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
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

public class CommentProteusUtil
{
  public static final String a = HardCodeUtil.a(2131900383);
  public static final String b = HardCodeUtil.a(2131900384);
  public static final String c = HardCodeUtil.a(2131900382);
  
  public static float a()
  {
    float f1 = 1.0F;
    try
    {
      float f2 = ((Float)RIJSPUtils.b("readinjoy_font_size_ratio_sp", Float.valueOf(1.0F))).floatValue();
      f1 = f2;
      StringBuilder localStringBuilder1 = new StringBuilder();
      f1 = f2;
      localStringBuilder1.append("getCustomTextSizeRatio | text size ratio ");
      f1 = f2;
      localStringBuilder1.append(f2);
      f1 = f2;
      QLog.d("CommentProteusUtil", 1, localStringBuilder1.toString());
      return f2;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("getCustomTextSizeRatio | error! msg=");
      localStringBuilder2.append(localException);
      QLog.d("CommentProteusUtil", 1, localStringBuilder2.toString());
    }
    return f1;
  }
  
  public static TemplateBean a(VafContext paramVafContext, CommentViewItem paramCommentViewItem, int paramInt, boolean paramBoolean, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter)
  {
    TraceUtils.traceBegin("CommentProteusUtil.getTemplateBean");
    Object localObject = null;
    TemplateBean localTemplateBean = null;
    TemplateFactory localTemplateFactory1;
    if (paramVafContext == null)
    {
      TemplateFactory localTemplateFactory2 = TemplateFactory.a("comment_feeds", true);
      localTemplateFactory1 = localTemplateFactory2;
      if (localTemplateFactory2 == null) {
        return null;
      }
    }
    else
    {
      localTemplateFactory1 = (TemplateFactory)paramVafContext.getTemplateFactory();
    }
    if (localTemplateFactory1 != null) {}
    try
    {
      localTemplateBean = localTemplateFactory1.getTemplateBean(a(paramReadinjoyCommentListBaseAdapter, paramVafContext, paramCommentViewItem, paramInt, paramBoolean));
      localObject = localTemplateBean;
      TraceUtils.traceEnd();
      return localTemplateBean;
    }
    catch (JSONException paramVafContext)
    {
      label77:
      break label77;
    }
    paramVafContext.printStackTrace();
    return localObject;
  }
  
  public static SubCommentData a(CommentViewItem paramCommentViewItem, int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    if ((paramCommentViewItem != null) && ((paramCommentViewItem.c instanceof CommentData)))
    {
      paramCommentViewItem = (CommentData)paramCommentViewItem.c;
      if ((paramCommentViewItem.subCommentList != null) && (paramCommentViewItem.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramCommentViewItem.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  @Nullable
  public static SubCommentData a(@NonNull CommentViewItem paramCommentViewItem, String paramString)
  {
    if ((paramCommentViewItem.c instanceof CommentData))
    {
      paramCommentViewItem = (CommentData)paramCommentViewItem.c;
      if (!ListUtils.a(paramCommentViewItem.subCommentList))
      {
        boolean bool = paramString.isEmpty();
        int k = 0;
        int j = k;
        if (!bool)
        {
          int m = paramCommentViewItem.subCommentList.size();
          int i = 0;
          for (;;)
          {
            j = k;
            if (i >= m) {
              break;
            }
            if (TextUtils.equals(paramString, ((SubCommentData)paramCommentViewItem.subCommentList.get(i)).commentId))
            {
              j = i;
              break;
            }
            i += 1;
          }
        }
        return (SubCommentData)paramCommentViewItem.subCommentList.get(j);
      }
    }
    return null;
  }
  
  public static String a(BaseCommentData paramBaseCommentData)
  {
    if (!(paramBaseCommentData instanceof SubCommentData)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((SubCommentData)paramBaseCommentData).parentCommentId);
    localStringBuilder.append("_");
    localStringBuilder.append(paramBaseCommentData.commentId);
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    Object localObject1 = paramString.split("\\?");
    if (localObject1.length != 2) {
      return paramString;
    }
    String[] arrayOfString = localObject1[1].split("&");
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    while (i < arrayOfString.length)
    {
      Object localObject2 = arrayOfString[i].split("=");
      if (localObject2.length == 2)
      {
        if (i != arrayOfString.length - 1) {
          paramString = "&";
        } else {
          paramString = "";
        }
        if ("appSchema".equalsIgnoreCase(localObject2[0]))
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(localObject2[0]);
          localStringBuilder2.append("=");
          localStringBuilder2.append(b(localObject2[1]));
          arrayOfString[i] = localStringBuilder2.toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(arrayOfString[i]);
        ((StringBuilder)localObject2).append(paramString);
        localStringBuilder1.append(((StringBuilder)localObject2).toString());
      }
      i += 1;
    }
    paramString = new StringBuilder();
    paramString.append(localObject1[0]);
    paramString.append("?");
    paramString.append(localStringBuilder1.toString());
    paramString = paramString.toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkJumpAppSchema | jumpSchema : ");
    ((StringBuilder)localObject1).append(paramString);
    QLog.d("CommentProteusUtil", 2, ((StringBuilder)localObject1).toString());
    return paramString;
  }
  
  public static JSONObject a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, VafContext paramVafContext, CommentViewItem paramCommentViewItem, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramCommentViewItem == null) {
      return localJSONObject;
    }
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2))
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 9) {
              paramReadinjoyCommentListBaseAdapter = localJSONObject;
            } else {
              paramReadinjoyCommentListBaseAdapter = RIJCommentAdUtils.a(paramCommentViewItem, paramBoolean);
            }
          }
          else {
            paramReadinjoyCommentListBaseAdapter = a(paramCommentViewItem);
          }
        }
        else {
          paramReadinjoyCommentListBaseAdapter = b(paramCommentViewItem);
        }
      }
      else {
        paramReadinjoyCommentListBaseAdapter = a(paramCommentViewItem, paramReadinjoyCommentListBaseAdapter);
      }
    }
    else {
      paramReadinjoyCommentListBaseAdapter = a(paramReadinjoyCommentListBaseAdapter, paramVafContext, paramCommentViewItem, paramBoolean);
    }
    c(paramCommentViewItem, paramReadinjoyCommentListBaseAdapter);
    return paramReadinjoyCommentListBaseAdapter;
  }
  
  private static JSONObject a(@NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, VafContext paramVafContext, CommentViewItem paramCommentViewItem, boolean paramBoolean)
  {
    BaseCommentData localBaseCommentData = paramCommentViewItem.c;
    if ((localBaseCommentData != null) && (localBaseCommentData.getWholeStringContent() != null) && (paramCommentViewItem.e != null))
    {
      JSONObject localJSONObject = new JSONObject();
      if (!paramBoolean) {
        localJSONObject.put("style_ID", "ReadInJoy_secondPage_comment_cell");
      } else {
        localJSONObject.put("style_ID", "ReadInJoy_comment_cell");
      }
      a(localJSONObject, localBaseCommentData, paramReadinjoyCommentListBaseAdapter);
      a(localJSONObject, paramCommentViewItem);
      a(localJSONObject, localBaseCommentData, paramBoolean);
      b(paramReadinjoyCommentListBaseAdapter, localJSONObject, localBaseCommentData);
      a(localJSONObject, paramCommentViewItem, paramBoolean);
      a(paramVafContext, localJSONObject, paramCommentViewItem, localBaseCommentData);
      a(localJSONObject, localBaseCommentData);
      b(localJSONObject, localBaseCommentData);
      paramReadinjoyCommentListBaseAdapter = new StringBuilder();
      paramReadinjoyCommentListBaseAdapter.append("getCommentDataJson | comment data json str : ");
      paramReadinjoyCommentListBaseAdapter.append(localJSONObject.toString());
      QLog.d("CommentProteusUtil", 2, paramReadinjoyCommentListBaseAdapter.toString());
      return localJSONObject;
    }
    return null;
  }
  
  private static JSONObject a(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return null;
    }
    Object localObject = paramCommentViewItem.c;
    if (localObject == null) {
      return null;
    }
    paramCommentViewItem = new JSONObject();
    paramCommentViewItem.put("style_ID", "ReadInJoy_comment_operation_banner");
    paramCommentViewItem.put("operation_banner_icon", "rij_icon_notify");
    paramCommentViewItem.put("operation_banner_title", ((BaseCommentData)localObject).getWholeStringContent());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("comment banner data json str : ");
    ((StringBuilder)localObject).append(paramCommentViewItem.toString());
    QLog.d("CommentProteusUtil", 2, ((StringBuilder)localObject).toString());
    return paramCommentViewItem;
  }
  
  private static JSONObject a(CommentViewItem paramCommentViewItem, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter)
  {
    Object localObject = ReadInJoyCommentDataManager.a(paramCommentViewItem.d);
    JSONObject localJSONObject = new JSONObject();
    int j = 1;
    int i;
    long l1;
    if ((localObject != null) && (paramReadinjoyCommentListBaseAdapter != null))
    {
      long l2 = ((ReadInJoyCommentDataManager)localObject).b(paramReadinjoyCommentListBaseAdapter.o());
      i = j;
      l1 = l2;
      if (paramReadinjoyCommentListBaseAdapter != null)
      {
        i = j;
        l1 = l2;
        if (paramReadinjoyCommentListBaseAdapter.o() == 6)
        {
          i = 0;
          l1 = l2;
        }
      }
    }
    else
    {
      l1 = 0L;
      i = j;
    }
    if (paramCommentViewItem.a == 2)
    {
      paramReadinjoyCommentListBaseAdapter = "rij_new_comment_title_icon";
      paramCommentViewItem = "rij_comment_menu_new_icon";
    }
    else
    {
      paramReadinjoyCommentListBaseAdapter = "rij_hot_comment_title_icon";
      paramCommentViewItem = "rij_comment_menu_hot_icon";
    }
    if (l1 > 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("（");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("）");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localJSONObject.put("style_ID", "ReadInJoy_comment_title");
    localJSONObject.put("comment_title", c);
    localJSONObject.put("comment_count", localObject);
    localJSONObject.put("comment_title_icon_url", paramReadinjoyCommentListBaseAdapter);
    if (i != 0)
    {
      paramReadinjoyCommentListBaseAdapter = new JSONObject();
      paramReadinjoyCommentListBaseAdapter.put("commnet_menu_icon_url", paramCommentViewItem);
      paramReadinjoyCommentListBaseAdapter.put("rij_comment_type_choose_highlight", paramCommentViewItem);
      localJSONObject.put("id_comment_type_choose_icon", paramReadinjoyCommentListBaseAdapter);
    }
    paramCommentViewItem = new StringBuilder();
    paramCommentViewItem.append("getCommentTitleJsonNew | comment title json str : ");
    paramCommentViewItem.append(localJSONObject.toString());
    QLog.d("CommentProteusUtil", 2, paramCommentViewItem.toString());
    return localJSONObject;
  }
  
  public static void a(Container paramContainer, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem)
  {
    if ((paramContainer != null) && (paramCommentViewItem != null))
    {
      if (paramReadinjoyCommentListBaseAdapter == null) {
        return;
      }
      ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new CommentProteusUtil.1(paramContainer, paramReadinjoyCommentListBaseAdapter, paramCommentViewItem));
    }
  }
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer != null) && (paramTemplateBean != null))
    {
      if (paramReadinjoyCommentListBaseAdapter == null) {
        return;
      }
      try
      {
        TraceUtils.traceBegin("CommentProteusUtil.bindData");
        ProteusSupportUtil.a(paramContainer, null, paramTemplateBean);
        if (paramTemplateBean.getViewBean() != null)
        {
          paramVafContext = a(paramReadinjoyCommentListBaseAdapter, paramVafContext, (CommentViewItem)paramReadinjoyCommentListBaseAdapter.getItem(paramInt1), paramInt2, paramBoolean);
          if (paramVafContext != null)
          {
            paramVafContext.put("ratio", a());
            paramTemplateBean.bindData(paramVafContext);
            a(paramContainer, paramReadinjoyCommentListBaseAdapter, (CommentViewItem)paramReadinjoyCommentListBaseAdapter.getItem(paramInt1));
          }
        }
        TraceUtils.traceEnd();
        return;
      }
      catch (JSONException paramVafContext)
      {
        paramContainer = new StringBuilder();
        paramContainer.append("bindData ");
        paramContainer.append(paramVafContext.getMessage());
        QLog.d("CommentProteusUtil", 2, paramContainer.toString());
      }
    }
  }
  
  private static void a(@NotNull VafContext paramVafContext, @NotNull JSONObject paramJSONObject, @NotNull CommentViewItem paramCommentViewItem, @NotNull BaseCommentData paramBaseCommentData)
  {
    if ((paramVafContext != null) && (paramVafContext.getContext() != null) && (paramVafContext.getContext().getResources() != null) && (paramBaseCommentData.mediaDataList != null) && (paramBaseCommentData.mediaDataList.size() > 0))
    {
      paramVafContext = (BaseCommentData.MediaData)paramBaseCommentData.mediaDataList.get(0);
      int i = paramVafContext.i;
      paramBaseCommentData = new StringBuilder();
      paramBaseCommentData.append("mediaData type is ");
      paramBaseCommentData.append(i);
      QLog.d("CommentProteusUtil", 2, paramBaseCommentData.toString());
      int j = paramVafContext.c;
      j = paramVafContext.d;
      j = paramVafContext.c;
      int k = paramVafContext.d;
      float f1 = 113.0F;
      float f2 = 89.0F;
      if (j < k)
      {
        f1 = 89.0F;
        f2 = 113.0F;
      }
      else if (paramVafContext.c <= paramVafContext.d)
      {
        f1 = 89.0F;
      }
      paramBaseCommentData = c(paramCommentViewItem);
      StringBuilder localStringBuilder = new StringBuilder();
      paramCommentViewItem = "";
      localStringBuilder.append("");
      localStringBuilder.append(f2);
      paramJSONObject.put("thumHeight", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(f1);
      paramJSONObject.put("thumWidth", localStringBuilder.toString());
      paramJSONObject.put("media_thumimg_url", paramVafContext.j);
      if ((paramBaseCommentData != null) && (paramBaseCommentData.size() > 0)) {
        paramVafContext = paramBaseCommentData.get(0);
      } else {
        paramVafContext = "";
      }
      paramJSONObject.put("pic_url", paramVafContext);
      if (i != 2)
      {
        if (i != 3) {
          paramVafContext = paramCommentViewItem;
        } else {
          paramVafContext = HardCodeUtil.a(2131900388);
        }
      }
      else {
        paramVafContext = HardCodeUtil.a(2131900381);
      }
      if (!TextUtils.isEmpty(paramVafContext)) {
        paramJSONObject.put("media_type_str", paramVafContext);
      }
    }
  }
  
  public static void a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem)
  {
    if (paramReadinjoyCommentListBaseAdapter == null) {
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramReadinjoyCommentListBaseAdapter.n(), 230);
    paramReadinjoyCommentListBaseAdapter = new CommentProteusUtil.2(paramReadinjoyCommentListBaseAdapter, paramCommentViewItem);
    localQQCustomDialog.setMessage(ReadInJoyCommentHelper.b());
    localQQCustomDialog.setNegativeButton("取消", paramReadinjoyCommentListBaseAdapter);
    localQQCustomDialog.setPositiveButton("确定", paramReadinjoyCommentListBaseAdapter);
    localQQCustomDialog.setOnCancelListener(null);
    localQQCustomDialog.show();
  }
  
  private static void a(@NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, @NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    if ((paramBaseCommentData.shouldShowFollowButton) && (paramBaseCommentData.isFollowButtonShown) && (paramReadinjoyCommentListBaseAdapter.o() == 3))
    {
      if (!FollowListInfoModule.a(paramBaseCommentData.uin))
      {
        paramJSONObject.put("follow_btn_show", "0");
        return;
      }
      paramJSONObject.put("follow_btn_show", "1");
    }
  }
  
  @VisibleForTesting
  static void a(CommentViewItem paramCommentViewItem, JSONObject paramJSONObject)
  {
    if ((paramCommentViewItem != null) && (paramCommentViewItem.c != null))
    {
      if (paramJSONObject == null) {
        return;
      }
      if (!(paramCommentViewItem.c instanceof SubCommentData)) {
        return;
      }
      if (((SubCommentData)paramCommentViewItem.c).repliedCommentData == null) {
        return;
      }
      SubCommentData localSubCommentData = (SubCommentData)paramCommentViewItem.c;
      localSubCommentData.secondMaxLine = 3;
      paramJSONObject.put("subcomment_one", new ExposedSubCommentViewItem(paramCommentViewItem, localSubCommentData));
      paramJSONObject.put("subcomment_one_text_line", localSubCommentData.secondMaxLine);
      paramJSONObject.put("subcomment_one_ratio", a());
      RIJCommentRptDataUtil.a(localSubCommentData, paramJSONObject, "subcomment_one_rpt_data_info");
    }
  }
  
  public static void a(BaseCommentData paramBaseCommentData, JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("follow_btn_show"))
    {
      if (!TextUtils.isEmpty(paramBaseCommentData.avatarPendantUrl)) {
        paramJSONObject.put("rij_comment_avatar_pendant", paramBaseCommentData.avatarPendantUrl);
      }
      if ((paramBaseCommentData.accountLevelInfo != null) && (paramBaseCommentData.accountLevelInfo.a()) && (!TextUtils.isEmpty(paramBaseCommentData.accountLevelInfo.b)))
      {
        paramJSONObject.put("rij_comment_v", paramBaseCommentData.accountLevelInfo.b);
        return;
      }
      if ((paramBaseCommentData.userIdentityIcon != null) && (!TextUtils.isEmpty(paramBaseCommentData.userIdentityIcon.b)))
      {
        paramJSONObject.put("rij_comment_v", paramBaseCommentData.userIdentityIcon.b);
        return;
      }
      if (paramBaseCommentData.isApproved()) {
        paramJSONObject.put("rij_comment_v", "rij_comment_v");
      }
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull CommentViewItem paramCommentViewItem)
  {
    paramJSONObject.put("commentModel", paramCommentViewItem);
    if (paramCommentViewItem.c != null)
    {
      paramJSONObject.put("comment_text", paramCommentViewItem.c.getWholeStringContent());
      RIJCommentRptDataUtil.a(paramCommentViewItem.c, paramJSONObject, "rpt_data_info", false);
      if (paramCommentViewItem.c.hasLinkData()) {
        paramJSONObject.put("commentLinkModel", paramCommentViewItem);
      }
      paramJSONObject.put("ratio", a());
      Object localObject = null;
      if ((paramCommentViewItem.c instanceof CommentData))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("more-");
        ((StringBuilder)localObject).append(paramCommentViewItem.c.commentId);
        localObject = ((StringBuilder)localObject).toString();
      }
      else if ((paramCommentViewItem.c instanceof SubCommentData))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("more-");
        ((StringBuilder)localObject).append(((SubCommentData)paramCommentViewItem.c).parentCommentId);
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(((SubCommentData)paramCommentViewItem.c).commentId);
        localObject = ((StringBuilder)localObject).toString();
      }
      paramJSONObject.put("comment_text_more_url", localObject);
      paramJSONObject.put("comment_text_line", paramCommentViewItem.c.maxLine);
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull CommentViewItem paramCommentViewItem, boolean paramBoolean)
  {
    if ((paramCommentViewItem.b()) && (paramBoolean)) {
      paramJSONObject.put("comment_model", paramCommentViewItem);
    }
    if (paramBoolean)
    {
      b(paramCommentViewItem, paramJSONObject);
      return;
    }
    a(paramCommentViewItem, paramJSONObject);
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    if (!TextUtils.isEmpty(paramBaseCommentData.flowGuidePtsData)) {
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
  
  @VisibleForTesting
  static void a(@NotNull JSONObject paramJSONObject, @Nullable BaseCommentData paramBaseCommentData, @NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter)
  {
    Object localObject = paramReadinjoyCommentListBaseAdapter.i;
    if (TextUtils.isEmpty(paramBaseCommentData.avatar)) {
      paramJSONObject.put("avator_url", "default_comment_avatar");
    } else {
      paramJSONObject.put("avator_url", paramBaseCommentData.avatar);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCommentDataJson | isStar ");
    ((StringBuilder)localObject).append(paramBaseCommentData.isStar());
    ((StringBuilder)localObject).append(" isApproved ");
    ((StringBuilder)localObject).append(paramBaseCommentData.isApproved());
    QLog.d("CommentProteusUtil", 2, ((StringBuilder)localObject).toString());
    if (paramBaseCommentData.isStar()) {
      paramJSONObject.put("rij_comment_avatar_borders", "rij_comment_avatar_borders");
    }
    if (paramBaseCommentData.isAuthorReply()) {
      paramJSONObject.put("author_header_flag_one", HardCodeUtil.a(2131900393));
    }
    if (!TextUtils.isEmpty(paramBaseCommentData.userTitle)) {
      paramJSONObject.put("comment_describe", paramBaseCommentData.userTitle);
    }
    String str = ReadInJoyCommentUtils.a(paramBaseCommentData.nickName, 10);
    localObject = str;
    if (str == null) {
      localObject = HardCodeUtil.a(2131907018);
    }
    paramJSONObject.put("nickname", localObject);
    if ((paramBaseCommentData.isFollowing) && (!paramBaseCommentData.isAuthorReply())) {
      paramJSONObject.put("author_header_follow_flag", "我的关注");
    }
    a(paramReadinjoyCommentListBaseAdapter, paramJSONObject, paramBaseCommentData);
    a(paramBaseCommentData, paramJSONObject);
    if ((paramBaseCommentData.activityLevel != null) && (paramBaseCommentData.activityLevel.icon.has())) {
      paramJSONObject.put("activity_level_icon_url", paramBaseCommentData.activityLevel.icon.get());
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData, boolean paramBoolean)
  {
    long l2 = paramBaseCommentData.commentTime;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = System.currentTimeMillis();
    }
    paramJSONObject.put("time", ReadInJoyTimeUtils.INSTANCE.getRelativeDisplayForTime(l1, true));
    JSONObject localJSONObject = new JSONObject();
    c(localJSONObject, paramBaseCommentData);
    if ((paramBaseCommentData instanceof CommentData))
    {
      if (paramBoolean)
      {
        paramBaseCommentData = (CommentData)paramBaseCommentData;
        if (paramBaseCommentData.subCommentNum > 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(ReadInJoyHelper.a(paramBaseCommentData.subCommentNum, 99989500L, "9999万+", "0"));
          localStringBuilder.append(HardCodeUtil.a(2131900387));
          paramJSONObject.put("reply_count", localStringBuilder.toString());
          paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
          paramJSONObject.put("reply_count_none", "");
          paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
          paramJSONObject.put("id_reply_comment_button", localJSONObject);
          return;
        }
        paramJSONObject.put("reply_count_none", HardCodeUtil.a(2131900394));
        paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
        paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
        paramJSONObject.remove("reply_count");
        paramJSONObject.put("id_reply_comment_null_button", localJSONObject);
        return;
      }
      paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
      return;
    }
    paramJSONObject.put("reply_count_none", HardCodeUtil.a(2131900391));
    paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
    paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
    paramJSONObject.remove("reply_count");
    paramJSONObject.put("id_reply_comment_null_button", localJSONObject);
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
  
  private static JSONObject b(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return null;
    }
    BaseCommentData localBaseCommentData = paramCommentViewItem.c;
    if (localBaseCommentData == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_cell");
    localJSONObject.put("avator_url", localBaseCommentData.avatar);
    localJSONObject.put("nickname", localBaseCommentData.nickName);
    localJSONObject.put("commentModel", paramCommentViewItem);
    localJSONObject.put("operation_img_url", localBaseCommentData.activityPicUrl);
    paramCommentViewItem = new StringBuilder();
    paramCommentViewItem.append("comment activity data json str : ");
    paramCommentViewItem.append(localJSONObject.toString());
    QLog.d("CommentProteusUtil", 2, paramCommentViewItem.toString());
    return localJSONObject;
  }
  
  @VisibleForTesting
  static JSONObject b(CommentViewItem paramCommentViewItem, JSONObject paramJSONObject)
  {
    if ((paramCommentViewItem != null) && (paramCommentViewItem.c != null))
    {
      if (paramJSONObject == null) {
        return paramJSONObject;
      }
      if (!(paramCommentViewItem.c instanceof CommentData)) {
        return paramJSONObject;
      }
      List localList = ((CommentData)paramCommentViewItem.c).subCommentList;
      if ((localList != null) && (localList.size() > 0))
      {
        int i = localList.size();
        int j = 0;
        while ((j < i) && (j < 2))
        {
          SubCommentData localSubCommentData = (SubCommentData)localList.get(j);
          if (localSubCommentData != null)
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append(ReadInJoyConstants.h);
            ((StringBuilder)localObject).append(Base64Util.encodeToString(localSubCommentData.uin.getBytes(), 2));
            String str14 = ((StringBuilder)localObject).toString();
            int k;
            if (j == 0) {
              k = 1;
            } else {
              k = 0;
            }
            if (k != 0) {
              localObject = "subcomment_one";
            } else {
              localObject = "subcomment_two";
            }
            String str1;
            if (k != 0) {
              str1 = "subcomment_one_text_line";
            } else {
              str1 = "subcomment_two_text_line";
            }
            String str2;
            if (k != 0) {
              str2 = "subcomment_one_more_url";
            } else {
              str2 = "subcomment_two_more_url";
            }
            String str3;
            if (k != 0) {
              str3 = "subcomment_one_nick_url";
            } else {
              str3 = "subcomment_two_nick_url";
            }
            String str4;
            if (k != 0) {
              str4 = "subcomment_one_nick_name";
            } else {
              str4 = "subcomment_two_nick_name";
            }
            String str5;
            if (k != 0) {
              str5 = "subcomment_one_tag_icon_path";
            } else {
              str5 = "subcomment_two_tag_icon_path";
            }
            String str6;
            if (k != 0) {
              str6 = "subcomment_one_tag_icon_width";
            } else {
              str6 = "subcomment_two_tag_icon_width";
            }
            String str7;
            if (k != 0) {
              str7 = "subcomment_one_reply";
            } else {
              str7 = "subcomment_two_reply";
            }
            String str8;
            if (k != 0) {
              str8 = "subcomment_one_to_nick_url";
            } else {
              str8 = "subcomment_two_to_nick_url";
            }
            String str9;
            if (k != 0) {
              str9 = "subcomment_one_to_nick_name";
            } else {
              str9 = "subcomment_two_to_nick_name";
            }
            String str10;
            if (k != 0) {
              str10 = "subcomment_one_rpt_data_info";
            } else {
              str10 = "subcomment_two_rpt_data_info";
            }
            String str11;
            if (k != 0) {
              str11 = "author_like_one_text";
            } else {
              str11 = "author_like_two_text";
            }
            String str13;
            if (k != 0) {
              str13 = "subcomment_one_ratio";
            } else {
              str13 = "subcomment_two_ratio";
            }
            String str12;
            if (k != 0) {
              str12 = "subcomment_one_text";
            } else {
              str12 = "subcomment_two_text";
            }
            paramJSONObject.put((String)localObject, new ExposedSubCommentViewItem(paramCommentViewItem, localSubCommentData));
            paramJSONObject.put(str1, localSubCommentData.secondMaxLine);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("more-");
            ((StringBuilder)localObject).append(localSubCommentData.parentCommentId);
            ((StringBuilder)localObject).append(":");
            ((StringBuilder)localObject).append(localSubCommentData.commentId);
            paramJSONObject.put(str2, ((StringBuilder)localObject).toString());
            paramJSONObject.put(str3, str14);
            paramJSONObject.put(str4, localSubCommentData.nickName);
            paramJSONObject.put(str13, a());
            if (localSubCommentData.isAuthorReply())
            {
              paramJSONObject.put(str5, "readinjoy_comment_author_tag");
              paramJSONObject.put(str6, "40px");
            }
            else if (localSubCommentData.isFollowing)
            {
              paramJSONObject.put(str5, "readinjoy_comment_follow_tag");
              paramJSONObject.put(str6, "51px");
            }
            if ((localSubCommentData.hasTarget()) && (!TextUtils.isEmpty(localSubCommentData.repliedUserNickname)))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(ReadInJoyConstants.h);
              ((StringBuilder)localObject).append(Base64Util.encodeToString(localSubCommentData.repliedUserUin.getBytes(), 2));
              localObject = ((StringBuilder)localObject).toString();
              paramJSONObject.put(str7, HardCodeUtil.a(2131915783));
              paramJSONObject.put(str8, localObject);
              paramJSONObject.put(str9, localSubCommentData.repliedUserNickname);
            }
            RIJCommentRptDataUtil.a(localSubCommentData, paramJSONObject, str10, true);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(" : ");
            ((StringBuilder)localObject).append(localSubCommentData.getWholeStringContent());
            paramJSONObject.put(str12, ((StringBuilder)localObject).toString());
            if ((localList != null) && (localSubCommentData != null) && (localSubCommentData.isAuthorLike)) {
              paramJSONObject.put(str11, "作者赞过");
            }
          }
          j += 1;
        }
      }
      paramCommentViewItem = new StringBuilder();
      paramCommentViewItem.append("bindExposeSubCommentData : ");
      paramCommentViewItem.append(paramJSONObject.toString());
      QLog.d("CommentProteusUtil", 2, paramCommentViewItem.toString());
    }
    return paramJSONObject;
  }
  
  private static void b(@NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, @NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData.isAuthorLike) {
      paramJSONObject.put("author_like_text", "作者赞过");
    }
    if (((paramBaseCommentData instanceof CommentData)) && (paramBaseCommentData.isAwesome())) {
      paramJSONObject.put("awsome_postmark_img", "awsome_postmark");
    }
    if ((paramBaseCommentData.isAuthorSticky) && (paramReadinjoyCommentListBaseAdapter.o() == 3))
    {
      paramJSONObject.put("top_img_path", "rij_comment_sticky_icon");
      paramJSONObject.put("top_margin_text", " ");
    }
    if (paramBaseCommentData.medalInfo != null) {
      RIJMedalUtils.a(paramJSONObject, paramBaseCommentData.medalInfo);
    }
  }
  
  private static void b(@NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("puin", paramBaseCommentData.uin);
    c(localJSONObject1, paramBaseCommentData);
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBaseCommentData.isLiked()) {
      localObject = "click_like_comment";
    } else {
      localObject = "cancel_like_comment";
    }
    localJSONObject2.put("comment_like_actionid", localObject);
    c(localJSONObject2, paramBaseCommentData);
    Object localObject = new JSONObject();
    c((JSONObject)localObject, paramBaseCommentData);
    paramJSONObject.put("id_comment_avator", localJSONObject1);
    paramJSONObject.put("id_like_button", localJSONObject2);
    paramJSONObject.put("id_first_comment_view", localObject);
  }
  
  private static List<String> c(CommentViewItem paramCommentViewItem)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramCommentViewItem != null) && (paramCommentViewItem.c != null))
    {
      if (paramCommentViewItem.c.mediaDataList == null) {
        return localArrayList;
      }
      paramCommentViewItem = paramCommentViewItem.c.mediaDataList;
      if (paramCommentViewItem.size() > 0)
      {
        paramCommentViewItem = paramCommentViewItem.iterator();
        while (paramCommentViewItem.hasNext())
        {
          BaseCommentData.MediaData localMediaData = (BaseCommentData.MediaData)paramCommentViewItem.next();
          if ((localMediaData.i != 1) && (localMediaData.i != 2))
          {
            if (localMediaData.i == 3) {
              localArrayList.add(localMediaData.g);
            }
          }
          else {
            localArrayList.add(localMediaData.b);
          }
        }
      }
      paramCommentViewItem = new StringBuilder();
      paramCommentViewItem.append("getPicUrlList | pathsize ");
      paramCommentViewItem.append(localArrayList.size());
      QLog.d("CommentProteusUtil", 2, paramCommentViewItem.toString());
    }
    return localArrayList;
  }
  
  private static void c(CommentViewItem paramCommentViewItem, JSONObject paramJSONObject)
  {
    if ((paramCommentViewItem != null) && (paramCommentViewItem.c != null))
    {
      if (paramJSONObject == null) {
        return;
      }
      paramCommentViewItem = paramCommentViewItem.c.styleData;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindDynamicStyleData | styleData : ");
      ((StringBuilder)localObject).append(paramCommentViewItem);
      ((StringBuilder)localObject).append(" dataJson : ");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.d("CommentProteusUtil", 2, ((StringBuilder)localObject).toString());
      if (TextUtils.isEmpty(paramCommentViewItem))
      {
        QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData is null");
        return;
      }
      try
      {
        paramCommentViewItem = new JSONObject(paramCommentViewItem);
        localObject = paramCommentViewItem.keys();
        while ((localObject != null) && (((Iterator)localObject).hasNext()))
        {
          String str = (String)((Iterator)localObject).next();
          paramJSONObject.put(str, paramCommentViewItem.get(str));
        }
        return;
      }
      catch (JSONException paramCommentViewItem)
      {
        paramCommentViewItem.printStackTrace();
        paramCommentViewItem = new StringBuilder();
        paramCommentViewItem.append("bindDynamicStyleData | commentDataJson ");
        paramCommentViewItem.append(paramJSONObject.toString());
        QLog.d("CommentProteusUtil", 2, paramCommentViewItem.toString());
      }
    }
  }
  
  private static void c(@NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    String str1;
    String str2;
    String str3;
    if ((paramBaseCommentData instanceof SubCommentData))
    {
      str1 = ((SubCommentData)paramBaseCommentData).parentCommentId;
      str2 = paramBaseCommentData.commentId;
      str3 = "second_level";
    }
    else
    {
      str1 = paramBaseCommentData.commentId;
      str2 = "";
      str3 = "first_level";
    }
    paramJSONObject.put("rowkey", paramBaseCommentData.rowKey);
    paramJSONObject.put("comment_id", str1);
    paramJSONObject.put("sub_comment_id", str2);
    paramJSONObject.put("comment_type", str3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentProteusUtil
 * JD-Core Version:    0.7.0.1
 */