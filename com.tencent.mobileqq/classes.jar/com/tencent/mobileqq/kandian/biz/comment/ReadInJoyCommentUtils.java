package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.base.ReadInJoyCommentEntrance;
import com.tencent.mobileqq.kandian.biz.comment.bean.CommentComponentArgs;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.MediaData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeAvatarView;
import com.tencent.mobileqq.kandian.biz.ugc.Utils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.CommentGuideConfigHandler;
import com.tencent.mobileqq.kandian.repo.comment.entity.CommentInfo;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentUtils
{
  private static final Pattern a = Pattern.compile("\n|\r\n");
  
  private static int a(BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData != null)
    {
      if ((paramBaseCommentData.commentLinkDataList != null) && (!paramBaseCommentData.commentLinkDataList.isEmpty())) {
        return 1;
      }
      return 0;
    }
    return 2;
  }
  
  public static int a(boolean paramBoolean, SimpleCommentData paramSimpleCommentData, String paramString)
  {
    if ((!paramBoolean) && ((!(paramSimpleCommentData instanceof SubCommentCreateData)) || (((SubCommentCreateData)paramSimpleCommentData).m().isEmpty())))
    {
      if ((TextUtils.isEmpty(paramString)) && ((paramSimpleCommentData == null) || ((paramSimpleCommentData instanceof FirstCommentCreateData)))) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
  
  private static SpannableString a(String paramString1, String paramString2, String paramString3)
  {
    SpannableString localSpannableString = new SpannableString(paramString1);
    int i = paramString1.lastIndexOf(paramString2);
    int j = paramString2.length();
    if (i >= 0)
    {
      if (TextUtils.isEmpty(paramString3)) {
        return localSpannableString;
      }
      localSpannableString.setSpan(new ReadInJoyCommentUtils.11(paramString3), i, j + i, 33);
    }
    return localSpannableString;
  }
  
  public static Pair<Integer, Integer> a(AbsBaseArticleInfo paramAbsBaseArticleInfo, CommonCommentData paramCommonCommentData)
  {
    int j = 20;
    int i;
    if ((paramCommonCommentData != null) && (paramCommonCommentData.getAdTag() != -1))
    {
      j = paramCommonCommentData.getAdTag();
      i = paramCommonCommentData.getAdTag();
    }
    else
    {
      if (paramAbsBaseArticleInfo != null)
      {
        if (((paramAbsBaseArticleInfo.mFeedType == 1) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.b == 5)) || (RIJFeedsType.a(paramAbsBaseArticleInfo)))
        {
          i = 2;
          break label137;
        }
        if ((RIJItemViewTypeUtils.o(paramAbsBaseArticleInfo)) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null))
        {
          if (RIJItemViewTypeUtils.b(paramAbsBaseArticleInfo.mSocialFeedInfo.s.a))
          {
            i = 9;
            break label137;
          }
        }
        else if (paramAbsBaseArticleInfo.mIsGallery != 0)
        {
          j = 10;
          i = 17;
          break label137;
        }
      }
      i = 4;
      j = 19;
    }
    label137:
    return new Pair(Integer.valueOf(i), Integer.valueOf(j));
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    if (((RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo))) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null)) {
      return String.valueOf(paramAbsBaseArticleInfo.mSocialFeedInfo.c.a);
    }
    return paramAbsBaseArticleInfo.mSubscribeID;
  }
  
  public static String a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.length() <= paramInt)) {
        return paramString;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, paramInt));
        ((StringBuilder)localObject).append("...");
        return ((StringBuilder)localObject).toString();
      }
      localObject = "";
    }
    return localObject;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    String str2 = UUID.randomUUID().toString();
    String str1 = Utils.a(paramString, str2);
    paramString = str1;
    if (paramBoolean) {
      paramString = str1.trim();
    }
    if (paramString.length() <= 0) {
      return "";
    }
    return EmotionCodecUtils.a(Utils.b(paramString, str2));
  }
  
  public static Map<String, String> a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = paramString.lastIndexOf("?");
    if (-1 != i)
    {
      if (i == paramString.length() - 1) {
        return null;
      }
      Object localObject1 = paramString.substring(i + 1).split("&");
      HashMap localHashMap = new HashMap();
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i].split("=");
        localHashMap.put(localObject2[0], localObject2[1]);
        i += 1;
      }
      localObject1 = (String)localHashMap.get("isOnlyFans");
      Object localObject2 = (String)localHashMap.get("uin");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        if (((QQAppInterface)ReadInJoyUtils.b()).getAccount().equals(localObject2))
        {
          d(paramContext, paramString);
          return null;
        }
        return localHashMap;
      }
      d(paramContext, paramString);
    }
    return null;
  }
  
  private static void a()
  {
    PublicAccountReportUtils.a(null, String.valueOf(RIJQQAppInterfaceUtil.c()), "0X800B99A", "0X800B99A", 0, 0, "", "", "", "", false);
  }
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = ReadInJoyLogicEngine.a().a(0, paramLong);
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null))
    {
      SocializeFeedsInfo localSocializeFeedsInfo;
      if (paramBoolean)
      {
        localSocializeFeedsInfo = localAbsBaseArticleInfo.mSocialFeedInfo;
        localSocializeFeedsInfo.j += 1;
      }
      else
      {
        localSocializeFeedsInfo = localAbsBaseArticleInfo.mSocialFeedInfo;
        localSocializeFeedsInfo.j -= 1;
      }
      localAbsBaseArticleInfo.invalidateProteusTemplateBean();
      ReadInJoyLogicEngine.a().d(localAbsBaseArticleInfo);
      ThreadManager.getUIHandler().post(new ReadInJoyCommentUtils.3());
    }
  }
  
  public static void a(Activity paramActivity, ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener)
  {
    if (paramActivity == null) {
      return;
    }
    Object localObject2 = Aladdin.getConfig(430);
    Object localObject1 = ((AladdinConfig)localObject2).getString("comment_dirty_word_content", paramActivity.getString(2131915275));
    String str1 = ((AladdinConfig)localObject2).getString("comment_dirty_word_hyperlink_text", paramActivity.getString(2131915276));
    String str4 = ((AladdinConfig)localObject2).getString("comment_dirty_word_hyperlink_url", "");
    localObject2 = paramActivity.getString(2131915279);
    String str2 = paramActivity.getString(2131915278);
    String str3 = paramActivity.getString(2131915277);
    localObject1 = a((String)localObject1, str1, str4);
    paramActivity = DialogUtil.a(paramActivity, 230).setTitle((String)localObject2).setMessageWithoutAutoLink((CharSequence)localObject1).setPositiveButton(str2, new ReadInJoyCommentUtils.10(paramCustomDialogClickListener)).setNegativeButton(str3, new ReadInJoyCommentUtils.9(paramCustomDialogClickListener));
    a(paramActivity);
    paramActivity.show();
    a();
  }
  
  public static void a(Activity paramActivity, CommentComponentArgs paramCommentComponentArgs)
  {
    if (paramActivity == null)
    {
      QLog.d("ReadInJoyCommentUtils", 1, "openCommentComponentNew | activity is null");
      return;
    }
    BaseCommentData localBaseCommentData = paramCommentComponentArgs.b();
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramCommentComponentArgs.a();
    int i = paramCommentComponentArgs.c();
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("arg_comment_enable_anonymous", false);
    localIntent.putExtra("placeholder", paramCommentComponentArgs.d());
    localIntent.putExtra("defaultTxt", paramCommentComponentArgs.e());
    localIntent.putExtra("maxLength", -1);
    localIntent.putExtra("firstAction", paramCommentComponentArgs.j());
    localIntent.putExtra("arg_comment_open_at", false);
    localIntent.putExtra("arg_comment_gif_switch", false);
    localIntent.putExtra("arg_comment_zhitu_switch", false);
    localIntent.putExtra("arg_comment_transparent_bg", paramCommentComponentArgs.f());
    localIntent.putExtra("comment_native", true);
    boolean bool = localBaseCommentData instanceof SubCommentData;
    localIntent.putExtra("comment_reply_second", bool);
    localIntent.putExtra("click_comment_edit_src", paramCommentComponentArgs.h());
    localIntent.putExtra("comment_article_info", localAbsBaseArticleInfo);
    localIntent.putExtra("biu_src", i);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openCommentComponent | comment_placeholder after decode: ");
    ((StringBuilder)localObject).append(paramCommentComponentArgs.d());
    QLog.d("ReadInJoyCommentUtils", 2, ((StringBuilder)localObject).toString());
    if (localBaseCommentData != null)
    {
      localIntent.putExtra("comment_id", localBaseCommentData.commentId);
      localIntent.putExtra("first_comment_uin", localBaseCommentData.uin);
      localObject = localBaseCommentData.getWholeStringContent();
      String str = localBaseCommentData.uin;
      localIntent.putExtra("comment_val", (String)localObject);
      localIntent.putExtra("comment_author_uin", str);
      if ((localBaseCommentData != null) && (localBaseCommentData.mediaDataList != null) && (localBaseCommentData.mediaDataList.size() > 0) && (((BaseCommentData.MediaData)localBaseCommentData.mediaDataList.get(0)).i != 0)) {
        localIntent.putExtra("comment_can_biu", false);
      }
    }
    localIntent.putExtra("comment_to_reply_contain_link", a(localBaseCommentData));
    if (localAbsBaseArticleInfo != null) {
      localIntent.putExtra("feedsType", localAbsBaseArticleInfo.mFeedType);
    }
    if (bool) {
      localIntent.putExtra("comment_reply_second_uin", localBaseCommentData.uin);
    }
    if (i == 2) {
      localIntent.putExtra("comment_is_show_pic", CommentGuideConfigHandler.a());
    }
    localIntent.putExtra("arg_ad_show_biu", paramCommentComponentArgs.i());
    ReadInJoyCommentEntrance.a(paramActivity, localIntent, 117);
    if (paramCommentComponentArgs.g() != null) {
      paramCommentComponentArgs.g().a();
    }
  }
  
  public static void a(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, CommentInfo paramCommentInfo, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2, ReadInJoyCommentUtils.CommentComponetEventListener paramCommentComponetEventListener, int paramInt2)
  {
    RIJUserLevelModule.getInstance().doActionsByUserLevel(paramActivity, 3, new ReadInJoyCommentUtils.1(paramActivity, paramAbsBaseArticleInfo, paramCommentInfo, paramInt1, paramString1, paramString2, paramBoolean1, paramString3, paramBoolean2, paramCommentComponetEventListener, paramInt2));
  }
  
  public static void a(Context paramContext, ReadInJoyUserInfo paramReadInJoyUserInfo, String paramString1, String paramString2)
  {
    long l = Long.parseLong(paramReadInJoyUserInfo.uin);
    paramReadInJoyUserInfo = DialogUtil.a(paramContext, 230).setTitle(paramReadInJoyUserInfo.nick).setMessage(2131915280).setNegativeButton(2131887648, new ReadInJoyCommentUtils.8()).setPositiveButton(2131915281, new ReadInJoyCommentUtils.7(l, paramReadInJoyUserInfo, paramString2, paramContext, paramString1));
    paramReadInJoyUserInfo.getBtnight().getPaint().setFakeBoldText(true);
    paramReadInJoyUserInfo.getBtnLeft().getPaint().setFakeBoldText(true);
    paramString1 = paramReadInJoyUserInfo.getTitleTextView();
    paramString1.setSingleLine();
    paramString1.setEllipsize(TextUtils.TruncateAt.END);
    paramString1.getPaint().setFakeBoldText(true);
    paramString2 = (RelativeLayout)paramString1.getParent();
    Resources localResources = paramContext.getResources();
    paramContext = new NativeAvatarView(paramContext);
    paramContext.setId(2131444277);
    paramContext.setUin(l);
    int i = localResources.getDimensionPixelSize(2131299530);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.bottomMargin = localResources.getDimensionPixelSize(2131299529);
    localLayoutParams.addRule(14);
    paramString2.addView(paramContext, localLayoutParams);
    ((RelativeLayout.LayoutParams)paramString1.getLayoutParams()).addRule(3, 2131444277);
    paramReadInJoyUserInfo.show();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject = a(paramContext, paramString1);
    if (localObject != null)
    {
      if (((Map)localObject).size() == 0) {
        return;
      }
      if (((String)((Map)localObject).get("isOnlyFans")).equalsIgnoreCase("false"))
      {
        d(paramContext, paramString1);
        return;
      }
      long l = Long.parseLong((String)((Map)localObject).get("uin"));
      ReadInJoyLogicEngine.a().W();
      if (FollowListInfoModule.a(String.valueOf(l)))
      {
        d(paramContext, paramString1);
        return;
      }
      localObject = ReadInJoyUserInfoModule.a(l, null);
      if (localObject != null)
      {
        a(paramContext, (ReadInJoyUserInfo)localObject, paramString1, paramString2);
        return;
      }
      ReadInJoyUserInfoModule.a(l, new ReadInJoyCommentUtils.5(paramContext, paramString1, paramString2));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt)
  {
    if (paramIntent == null)
    {
      QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(2131915296), 0).show();
      QLog.d("ReadInJoyCommentUtils", 2, "comment result intent data is null");
      return;
    }
    paramQQAppInterface = paramIntent.getStringExtra("arg_result_json");
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramIntent.getParcelableExtra("comment_article_info");
    boolean bool = paramIntent.getBooleanExtra("comment_gallery_channel", false);
    if ((paramInt == -1) || (paramInt == 1699))
    {
      if ((localAbsBaseArticleInfo != null) && (bool))
      {
        ReadInJoyCommentDataManager.a(localAbsBaseArticleInfo, 0).j(paramQQAppInterface);
        ReadInJoyCommentDataManager.b(localAbsBaseArticleInfo);
        return;
      }
      ReadInJoyLogicEngine.a().a(localAbsBaseArticleInfo, paramQQAppInterface);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, CommentInfo paramCommentInfo, boolean paramBoolean)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramCommentInfo != null))
    {
      long l = paramAbsBaseArticleInfo.mRecommendSeq;
      paramAbsBaseArticleInfo = ReadInJoyLogicEngine.a().a((int)paramAbsBaseArticleInfo.mChannelID, l);
      if (paramAbsBaseArticleInfo != null)
      {
        if (!paramBoolean)
        {
          paramCommentInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
          paramCommentInfo.j += 1;
        }
        paramAbsBaseArticleInfo.invalidateProteusTemplateBean();
        ThreadManager.getUIHandler().post(new ReadInJoyCommentUtils.2());
      }
      return;
    }
    QLog.d("ReadInJoyCommentUtils", 2, "localUpdateCommentData: articleInfo or commentInfo is null");
  }
  
  private static void a(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.getBtnight().setTextColor(Color.parseColor("#00CAFC"));
    paramQQCustomDialog.getBtnight().getPaint().setFakeBoldText(true);
    paramQQCustomDialog.getBtnLeft().getPaint().setFakeBoldText(true);
    paramQQCustomDialog.getTitleTextView().getPaint().setFakeBoldText(true);
  }
  
  public static void a(String paramString, Context paramContext)
  {
    a(paramString, paramContext, null);
  }
  
  public static void a(String paramString, Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramContext == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyConstants.h);
    localStringBuilder.append(Base64Util.encodeToString(paramString.getBytes(), 2));
    paramString = ReadinjoyReportUtils.a(paramAbsBaseArticleInfo, localStringBuilder.toString(), ReadinjoyReportUtils.g);
    ReadInJoyUtils.a(paramContext, paramString);
    paramContext = new StringBuilder();
    paramContext.append("personal url =");
    paramContext.append(paramString);
    QLog.d("ReadInJoyCommentUtils", 1, paramContext.toString());
  }
  
  public static void a(String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    PublicAccountReportUtils.a(null, a(paramAbsBaseArticleInfo), paramString, paramString, 0, 0, String.valueOf(paramAbsBaseArticleInfo.mArticleID), String.valueOf(paramAbsBaseArticleInfo.mStrategyId), paramAbsBaseArticleInfo.innerUniqueID, paramReportR5Builder.build(), false);
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if (paramAbsBaseArticleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentUtils", 2, " marticleinfo=null");
      }
      return false;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = new SocializeFeedsInfo();
    localSocializeFeedsInfo.n = new BiuInfo();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getJSONObject("biu_info");
        j = paramString.optInt("biuSrc");
        k = paramString.optInt("feedtype");
        if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.n != null))
        {
          localSocializeFeedsInfo.n.c = paramAbsBaseArticleInfo.mSocialFeedInfo.n.c;
          localSocializeFeedsInfo.n.b = paramAbsBaseArticleInfo.mSocialFeedInfo.n.b;
        }
        paramString = paramString.optJSONArray("biuinfo");
        i = 0;
        if (i < paramString.length())
        {
          paramString.getJSONObject(i);
          localObject = paramString.getJSONObject(i).optString("biu_uin");
          long l;
          if ((paramString.getJSONObject(i).opt("biu_feedid") instanceof Integer)) {
            l = ((Integer)paramString.getJSONObject(i).opt("biu_feedid")).intValue();
          } else {
            l = ((Long)paramString.getJSONObject(i).opt("biu_feedid")).longValue();
          }
          localObject = new ReadInJoyCommentUtils.UserBiuInfo((String)localObject, l, paramString.getJSONObject(i).optString("biu_info_comment"));
          ((ReadInJoyCommentUtils.UserBiuInfo)localObject).e = paramString.getJSONObject(i).optInt("biu_optype");
          ((ReadInJoyCommentUtils.UserBiuInfo)localObject).b = paramString.getJSONObject(i).optString("biu_nickname");
          localArrayList.add(localObject);
          i += 1;
          continue;
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder("onDeliver deliverList:\n");
          localObject = localArrayList.iterator();
          if (((Iterator)localObject).hasNext())
          {
            paramString.append(((ReadInJoyCommentUtils.UserBiuInfo)((Iterator)localObject).next()).toString());
            paramString.append("\n");
            continue;
          }
          QLog.d("ReadInJoyCommentUtils", 2, paramString.toString());
        }
        if ((paramAbsBaseArticleInfo != null) && (localArrayList.size() > 0))
        {
          i = 1;
          if (i < localArrayList.size())
          {
            localObject = (ReadInJoyCommentUtils.UserBiuInfo)localArrayList.get(i);
            localBiuCommentInfo = new BiuCommentInfo();
          }
        }
      }
      catch (Exception paramAbsBaseArticleInfo)
      {
        int j;
        int k;
        int i;
        Object localObject;
        BiuCommentInfo localBiuCommentInfo;
        return false;
      }
      try
      {
        localBiuCommentInfo.mUin = Long.valueOf(((ReadInJoyCommentUtils.UserBiuInfo)localObject).a);
      }
      catch (Exception paramString)
      {
        continue;
      }
      localBiuCommentInfo.mUin = Long.valueOf(0L);
      if (((ReadInJoyCommentUtils.UserBiuInfo)localObject).c == null) {
        paramString = "";
      } else {
        paramString = ((ReadInJoyCommentUtils.UserBiuInfo)localObject).c.toString();
      }
      localBiuCommentInfo.mBiuComment = paramString;
      localBiuCommentInfo.mOpType = ((ReadInJoyCommentUtils.UserBiuInfo)localObject).e;
      localBiuCommentInfo.mFeedId = Long.valueOf(((ReadInJoyCommentUtils.UserBiuInfo)localObject).d);
      localSocializeFeedsInfo.n.a.add(localBiuCommentInfo);
      i += 1;
    }
    ReadInJoyLogicEngine.a().a(RIJQQAppInterfaceUtil.c(), paramAbsBaseArticleInfo.mFeedId, localSocializeFeedsInfo.n, 0L, ((ReadInJoyCommentUtils.UserBiuInfo)localArrayList.get(0)).c.toString(), paramAbsBaseArticleInfo.mArticleID, paramAbsBaseArticleInfo.mRecommendSeq, j, paramAbsBaseArticleInfo.innerUniqueID, k, paramAbsBaseArticleInfo);
    return true;
  }
  
  private static void b(int paramInt)
  {
    String str;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("os", 1);
      ((JSONObject)localObject).put("version", VideoReporter.a);
      ((JSONObject)localObject).put("place", paramInt);
      localObject = ((JSONObject)localObject).toString();
    }
    catch (JSONException localJSONException)
    {
      QLog.d("ReadInJoyCommentUtils", 2, localJSONException.getMessage());
      str = "";
    }
    PublicAccountReportUtils.a(null, String.valueOf(RIJQQAppInterfaceUtil.c()), "0X800B99B", "0X800B99B", 0, 0, "", "", "", str, false);
  }
  
  private static void b(long paramLong, String paramString1, String paramString2)
  {
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().c();
    if (localUserOperationModule == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      i = NumberUtil.a(paramString2);
      if ((i == 4) || (i == 5))
      {
        i = 2;
        break label48;
      }
    }
    int i = 1;
    label48:
    localUserOperationModule.request0x978(((QQAppInterface)ReadInJoyUtils.b()).getAccount(), String.valueOf(paramLong), true, paramString1, new ReadInJoyCommentUtils.6(), i);
  }
  
  public static void b(Activity paramActivity, AbsBaseArticleInfo paramAbsBaseArticleInfo, CommentInfo paramCommentInfo, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2, ReadInJoyCommentUtils.CommentComponetEventListener paramCommentComponetEventListener, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("arg_comment_enable_anonymous", false);
    localIntent.putExtra("placeholder", paramString1);
    localIntent.putExtra("defaultTxt", paramString2);
    localIntent.putExtra("maxLength", -1);
    localIntent.putExtra("arg_comment_open_at", false);
    localIntent.putExtra("arg_comment_gif_switch", false);
    localIntent.putExtra("arg_comment_zhitu_switch", false);
    localIntent.putExtra("arg_comment_transparent_bg", paramBoolean2);
    localIntent.putExtra("comment_native", true);
    localIntent.putExtra("comment_reply_second", paramBoolean1);
    localIntent.putExtra("click_comment_edit_src", paramInt2);
    if (paramCommentInfo != null)
    {
      localIntent.putExtra("comment_id", paramCommentInfo.commentId);
      localIntent.putExtra("first_comment_uin", paramCommentInfo.authorUin);
    }
    localIntent.putExtra("comment_article_info", paramAbsBaseArticleInfo);
    if (paramCommentInfo != null)
    {
      paramString1 = paramCommentInfo.commentContent;
      paramCommentInfo = paramCommentInfo.authorUin;
      localIntent.putExtra("comment_val", paramString1);
      localIntent.putExtra("comment_author_uin", paramCommentInfo);
    }
    localIntent.putExtra("biu_src", paramInt1);
    if (paramAbsBaseArticleInfo != null) {
      localIntent.putExtra("feedsType", paramAbsBaseArticleInfo.mFeedType);
    }
    if (paramBoolean1) {
      localIntent.putExtra("comment_reply_second_uin", paramString3);
    }
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      localIntent.putExtra("arg_ad_show_biu", false);
    }
    ReadInJoyCommentEntrance.a(paramActivity, localIntent, 117);
    if (paramCommentComponetEventListener != null) {
      paramCommentComponetEventListener.a();
    }
  }
  
  public static void b(String paramString, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    if ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
      return;
    }
    ReadInJoyUtils.a(paramContext, paramString);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("personal url =");
      paramContext.append(paramString);
      QLog.d("ReadInJoyCommentUtils", 2, paramContext.toString());
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      if (paramContext == null) {
        return false;
      }
      paramContext = (ClipboardManager)paramContext.getSystemService("clipboard");
      if (paramContext.hasPrimaryClip())
      {
        paramContext = paramContext.getPrimaryClip();
        if ((paramContext != null) && (paramContext.getItemCount() > 0))
        {
          paramContext = paramContext.getItemAt(0);
          if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.getText())))
          {
            paramContext = String.valueOf(paramContext.getText());
            paramString = new QQText(EmotionCodecUtils.c(paramString), 7, 18).toString();
            if (!TextUtils.isEmpty(paramContext)) {
              return paramContext.contains(paramString);
            }
          }
        }
      }
    }
    return false;
  }
  
  private static void d(Context paramContext, String paramString)
  {
    RIJJumpUtils.c(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils
 * JD-Core Version:    0.7.0.1
 */