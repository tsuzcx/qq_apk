import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicEntranceInfo;

public class pqf
{
  public static int a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public static int a()
  {
    int i = 1;
    if (jdField_a_of_type_Int != -1) {
      return jdField_a_of_type_Int;
    }
    if (bmhv.l())
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        return -1;
      }
      Object localObject;
      if ((localBaseActivity instanceof SplashActivity))
      {
        localObject = FrameHelperActivity.a(BaseActivity.sTopActivity);
        if (localObject != null) {}
      }
      for (;;)
      {
        return -1;
        localObject = (ReadinjoyTabFrame)((FrameHelperActivity)localObject).a(ReadinjoyTabFrame.class);
        if (localObject != null)
        {
          if (bmhv.m()) {
            return 2;
          }
          int j = ((ReadinjoyTabFrame)localObject).b();
          if (j == 0) {
            return 1;
          }
          if (j == 2) {
            return 3;
          }
          if (j == 1) {
            return 2;
          }
          if ((localBaseActivity instanceof PublicFragmentActivity))
          {
            if ((localBaseActivity.getIntent() != null) && (QLog.isColorLevel())) {
              QLog.d("RIJTransMergeKanDianReport", 2, new Object[] { "ClassName: ", localBaseActivity.getIntent().getStringExtra("public_fragment_class") });
            }
            if ((localBaseActivity.getIntent() != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class") != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class").equals("com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment"))) {
              return 3;
            }
            if ((localBaseActivity.getIntent() != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class") != null) && (localBaseActivity.getIntent().getStringExtra("public_fragment_class").equals("com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment"))) {
              return 6;
            }
          }
          if ((localBaseActivity instanceof ReadInJoyNewFeedsActivity)) {
            return ReadInJoyNewFeedsActivity.c + 1;
          }
          if ((localBaseActivity instanceof ReadInJoyChannelActivity))
          {
            if (localBaseActivity.getIntent().getIntExtra("channel_id", 0) == 56) {}
            while (i != 0)
            {
              return 2;
              i = 0;
            }
          }
        }
      }
    }
    return ReadInJoyNewFeedsActivity.c + 1;
  }
  
  public static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mPartnerAccountInfo == null)) {}
    while (!paramBaseArticleInfo.mPartnerAccountInfo.uint32_is_account_display.has()) {
      return 0;
    }
    return paramBaseArticleInfo.mPartnerAccountInfo.uint32_is_account_display.get();
  }
  
  public static int a(Long paramLong)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pnn.a();
    if (localQQAppInterface == null) {
      return 0;
    }
    if (!TextUtils.isEmpty(((KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(paramLong))) {}
    for (int i = 1;; i = 0) {
      return i;
    }
  }
  
  public static Drawable a(QQAppInterface paramQQAppInterface, Drawable paramDrawable)
  {
    Object localObject2 = null;
    boolean bool = false;
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    if (localObject1 == null) {}
    do
    {
      return paramDrawable;
      localObject1 = ((QQMessageFacade)localObject1).getLastMsgForMsgTab(AppConstants.KANDIAN_MERGE_UIN, 7220);
    } while ((localObject1 == null) || (((MessageRecord)localObject1).isread));
    QLog.d("RIJTransMergeKanDianReport", 2, "getSpecAggregateAvatarForKandian run !");
    for (;;)
    {
      try
      {
        localResources = BaseApplicationImpl.getApplication().getResources();
        JSONObject localJSONObject = new JSONObject(((MessageRecord)localObject1).extStr);
        if (localJSONObject.has("kdUin"))
        {
          localObject1 = localJSONObject.getString("kdUin");
          QLog.d("RIJTransMergeKanDianReport", 2, "got tipUin from kdUin: " + (String)localObject1);
          if (localJSONObject.has("kdDefaultSourceAvatarUrl"))
          {
            localObject2 = localJSONObject.getString("kdDefaultSourceAvatarUrl");
            QLog.d("RIJTransMergeKanDianReport", 2, "got defaultAvatarUrl from kdDefaultSourceAvatarUrl: " + (String)localObject2);
          }
          if (localJSONObject.has("kdShouldShowMergedAvatar"))
          {
            bool = localJSONObject.getBoolean("kdShouldShowMergedAvatar");
            QLog.d("RIJTransMergeKanDianReport", 2, "got shouldShowMergedAvatar from kdShouldShowMergedAvatar: " + bool);
          }
          if (!bool)
          {
            QLog.d("RIJTransMergeKanDianReport", 2, "shouldn't show merged icon, give up");
            return paramDrawable;
          }
        }
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        Resources localResources;
        paramQQAppInterface.printStackTrace();
        QLog.d("RIJTransMergeKanDianReport", 2, "get merge icon has error : " + paramQQAppInterface);
        return paramDrawable;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramQQAppInterface = paramQQAppInterface.getFaceBitmapCacheKey(1, "kd_" + (String)localObject1, (byte)3, 0, 100, true);
          localObject2 = (tln)bhdb.a(paramQQAppInterface);
          if (localObject2 != null)
          {
            QLog.d("RIJTransMergeKanDianReport", 2, "getMergeIcon From cache ! key : " + paramQQAppInterface + ", tipUin : " + (String)localObject1);
            return localObject2;
          }
          localObject2 = bheg.a(paramDrawable);
          if (localObject2 == null) {
            break;
          }
          localObject1 = new tln((Bitmap)localObject2, AIOUtils.dp2px(50.0F, localResources), localResources, (String)localObject1, 1);
          bhdb.a(paramQQAppInterface, (Sizeable)localObject1);
          return localObject1;
        }
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        paramQQAppInterface = bheg.a(paramDrawable);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface = new tln(paramQQAppInterface, (String)localObject2, AIOUtils.dp2px(50.0F, localResources), localResources, 1);
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        QLog.d("RIJTransMergeKanDianReport", 2, "get merge icon has error : " + paramQQAppInterface);
        return paramDrawable;
      }
      localObject1 = null;
    }
  }
  
  public static String a()
  {
    int i = 1;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", prp.jdField_a_of_type_Int);
      if (bmhv.C(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
      for (;;)
      {
        ((JSONObject)localObject).put("reddot_style", i);
        ((JSONObject)localObject).put("kandian_mode", pqu.a());
        ((JSONObject)localObject).put("kandian_mode_new", omx.a());
        ((JSONObject)localObject).put("tab_source", a());
        ((JSONObject)localObject).put("session_id", prp.jdField_a_of_type_JavaLangString);
        localObject = ((JSONObject)localObject).toString();
        return localObject;
        i = 0;
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public static String a(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", prp.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("session_id", prp.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("failed_reason", paramInt);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = Integer.toString(a());
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
        localJSONObject.put("source", str);
        localJSONObject.put("feeds_type", paramInt3);
        localJSONObject.put("kandian_mode", pqu.a());
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localJSONObject.put("rowkey", paramString2);
        localJSONObject.put("pic_number", paramInt1);
        if (paramInt2 > 0) {
          localJSONObject.put("pic_position", "" + paramInt2);
        }
        if (paramArticleInfo != null) {
          localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        }
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("RIJTransMergeKanDianReport", 2, "transGridImageClickR5 json exception.");
        paramString1.printStackTrace();
        continue;
      }
      return localJSONObject.toString();
      localJSONObject.put("rowkey", "0");
    }
  }
  
  public static String a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, String paramString3, ArticleInfo paramArticleInfo)
  {
    localJSONObject = new JSONObject();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = Integer.toString(a());
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
        if (TextUtils.isEmpty(paramString3)) {
          continue;
        }
        localJSONObject.put("feeds_source", paramString3);
        localJSONObject.put("feeds_type", paramInt3);
        localJSONObject.put("kandian_mode", pqu.a());
        localJSONObject.put("source", str);
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localJSONObject.put("rowkey", paramString2);
      }
      catch (JSONException paramString1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("RIJTransMergeKanDianReport", 2, "transGridImageClickR5 json exception.");
        paramString1.printStackTrace();
        continue;
        localJSONObject.put("rowkey", "0");
        continue;
      }
      localJSONObject.put("pic_number", paramInt1);
      if (paramInt2 > 0) {
        localJSONObject.put("pic_position", "" + paramInt2);
      }
      if (paramArticleInfo != null)
      {
        localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        localJSONObject.put("channel_id", paramArticleInfo.mChannelID);
      }
      return localJSONObject.toString();
      localJSONObject.put("feeds_source", "0");
    }
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("algorithm_id", paramLong);
      ((JSONObject)localObject).put("folder_status", prp.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("feeds_type", paramInt1);
      ((JSONObject)localObject).put("channel_id", paramInt2);
      ((JSONObject)localObject).put("feeds_channel_entrance", paramInt3);
      ((JSONObject)localObject).put("session_id", prp.jdField_a_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt5, ArticleInfo paramArticleInfo)
  {
    try
    {
      paramString1 = a(paramLong, paramInt1, paramInt2, paramBoolean, paramString1, paramString3, paramString4, paramInt5, a(), paramArticleInfo).toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, ArticleInfo paramArticleInfo)
  {
    return a(paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean, paramString1, paramString2, paramString3, paramString4, 0, paramArticleInfo);
  }
  
  public static String a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, ArticleInfo paramArticleInfo, long paramLong2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean2, int paramInt9, int paramInt10, int paramInt11)
  {
    paramString3 = a(paramLong1, paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramString1, paramString2, paramString3, paramString4, paramArticleInfo);
    paramString1 = paramString3;
    for (;;)
    {
      try
      {
        paramString4 = new JSONObject(paramString3);
        paramString1 = paramString3;
        paramString4.put("kandian_mode", paramInt7);
        paramString1 = paramString3;
        paramString4.put("kandian_mode_new", omx.a());
        paramString1 = paramString3;
        paramString4.put("tab_source", paramInt6);
        paramString1 = paramString3;
        pjc.a(paramString4, "entry_path", paramInt11);
        paramString1 = paramString3;
        pjc.a(paramString4, "behavior_type", paramInt5);
        paramString1 = paramString3;
        pjc.a(paramString4, "stay_duration", paramLong2);
        paramString1 = paramString3;
        paramString4.put("video_inserted", paramBoolean2);
        paramString1 = paramString3;
        paramString4.put("video_strategyid", paramInt8);
        paramString1 = paramString3;
        paramString4.put("proteus_bid", bmhv.a("default_feeds_proteus_offline_bid"));
        paramString1 = paramString3;
        paramString4.put("ads_jump", paramInt9);
        paramString1 = paramString3;
        paramString4.put("ads_source", paramInt10);
        paramString1 = paramString3;
        paramString4.put("star_logo", pqw.a(paramArticleInfo));
        paramString1 = paramString3;
        if (bhyk.a() == 1)
        {
          paramString2 = "1";
          paramString1 = paramString3;
          paramString4.put("simCardType", paramString2);
          if (paramArticleInfo == null) {
            break label715;
          }
          paramString1 = paramString3;
          paramBoolean1 = plm.c(paramInt2);
          paramString1 = paramString3;
          pjc.a(paramString4, "daily_article_first_timestamp", ((Long)bmhv.a("readinjoy_daily_article_first_exposure_" + paramArticleInfo.mArticleID, Long.valueOf(0L))).longValue(), paramBoolean1);
          paramString1 = paramString3;
          if (paramArticleInfo.isShowGif)
          {
            paramInt1 = 1;
            paramString1 = paramString3;
            paramString4.put("short_content_gif", paramInt1);
            paramString1 = paramString3;
            paramString4.put("account_expose_card", a(paramArticleInfo));
            paramString1 = paramString3;
            paramString4.put("picture_click_jumptype", Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0));
            paramString1 = paramString3;
            if (paramArticleInfo.mChannelID != 0L) {
              continue;
            }
            paramString1 = paramString3;
            if (!ppe.n(paramArticleInfo)) {
              continue;
            }
            paramBoolean1 = true;
            paramString1 = paramString3;
            if (paramArticleInfo.mCommentCount > 100L) {
              break label718;
            }
            paramString1 = paramString3;
            if (paramArticleInfo.mVideoCommentCount <= 100) {
              continue;
            }
            break label718;
            paramString1 = paramString3;
            pjc.b(paramString4, "comment_exposure", paramInt1, paramBoolean1);
            paramString1 = paramString3;
            a(paramString4);
            paramString1 = paramString3;
            pjc.b(paramString4, "jump_src", rnz.a(paramArticleInfo), rnz.c(paramArticleInfo));
            paramString1 = paramString3;
            pjc.a(paramString4, "short_content_size", ComponentPGCShortContentBig.jdField_a_of_type_JavaLangString, paramArticleInfo.isPGCShortContent());
            paramString1 = paramString3;
            if (paramArticleInfo.mSocialFeedInfo == null) {
              continue;
            }
            paramString1 = paramString3;
            if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo == null) {
              continue;
            }
            paramString1 = paramString3;
            if (!paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$TopicEntranceInfo.uint32_is_topic.has()) {
              continue;
            }
            paramInt1 = 1;
            paramString1 = paramString3;
            paramString4.put("istopic", paramInt1);
            paramString1 = paramString3;
            paramString4.put("default_feeds_aladdin_keys", ((String)bmhv.a("default_feeds_aladdin_keys", "")).replace("|", "_"));
            paramString1 = paramString3;
            paramString2 = paramString4.toString();
            paramString1 = paramString2;
            return new suu(paramString2).c(paramArticleInfo).d(paramArticleInfo).a(paramArticleInfo.videoReportInfo).a(paramArticleInfo, true).a().a();
          }
        }
        else
        {
          paramString2 = "0";
          continue;
        }
        paramInt1 = 0;
        continue;
        paramBoolean1 = false;
        continue;
        paramInt1 = 2;
        continue;
        paramInt1 = 0;
        continue;
        return paramString3;
      }
      catch (JSONException paramString2)
      {
        paramString2.printStackTrace();
        return paramString1;
      }
      label715:
      label718:
      paramInt1 = 1;
    }
  }
  
  public static String a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, ArticleInfo paramArticleInfo, String paramString3)
  {
    paramString1 = a(paramLong, paramInt1, paramInt2, 0, 0, paramBoolean, paramString1, null, paramString2, null, 0, paramArticleInfo);
    try
    {
      paramString2 = new JSONObject(paramString1);
      paramString2.put("topicid", paramString3);
      paramString2.put("proteus_bid", bmhv.a("default_feeds_proteus_offline_bid"));
      return paramString2.toString();
    }
    catch (JSONException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    int i = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      localJSONObject.put("session_id", prp.jdField_a_of_type_JavaLangString);
      if (NetworkUtil.isWifiConnected(paramContext)) {
        i = 0;
      }
      for (;;)
      {
        localJSONObject.put("network", i);
        localJSONObject.put("version", paramString1);
        localJSONObject.put("os", 1);
        localJSONObject.put("uin", paramString2);
        return localJSONObject.toString();
        boolean bool = NetworkUtil.is3Gor4G(paramContext);
        if (!bool) {
          i = 2;
        }
      }
      return "";
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo)
  {
    return a(paramArticleInfo, false);
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    if (paramArticleInfo == null)
    {
      QLog.d("RIJTransMergeKanDianReport", 1, "transMergeKandianReportR5BaseForFastWeb articleInfo is null.");
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("algorithm_id", paramArticleInfo.mAlgorithmID);
      localJSONObject.put("puin_type", paramString);
      localJSONObject.put("source", pqu.a(paramInt));
      localJSONObject.put("kandian_mode", pqu.a());
      localJSONObject.put("mp_article_id", paramArticleInfo.mArticleID);
      localJSONObject.put("channel_id", paramInt);
      return localJSONObject.toString();
    }
    catch (JSONException paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      a(localJSONObject, paramArticleInfo);
      if (paramBoolean) {}
      for (paramArticleInfo = "1";; paramArticleInfo = "0")
      {
        localJSONObject.put("fast_biu", paramArticleInfo);
        return localJSONObject.toString();
      }
      return "";
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (!plm.c((int)paramBaseArticleInfo.mChannelID)) || (TextUtils.isEmpty(paramBaseArticleInfo.proteusItemsData))) {
      return "";
    }
    try
    {
      paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.proteusItemsData).optString("card_report_params");
      return paramBaseArticleInfo;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("RIJTransMergeKanDianReport", 1, paramBaseArticleInfo, new Object[0]);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    return a(paramString, "");
  }
  
  public static String a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      localJSONObject.put("algorithm_id", paramLong);
      localJSONObject.put("feeds_friends_interaction", paramInt);
      localJSONObject.put("session_id", prp.jdField_a_of_type_JavaLangString);
      localJSONObject.put("os", "1");
      localJSONObject.put("version", "8.4.10".replace(".", ""));
      localJSONObject.put("rowkey", paramString);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mTopicRecommendFeedsInfo == null) || (paramArticleInfo.mTopicRecommendFeedsInfo.a == null) || (paramArticleInfo.mTopicRecommendFeedsInfo.a.isEmpty())) {
      return "";
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      localJSONObject.put("feeds_source", ((rsj)paramArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).jdField_a_of_type_Int);
      localJSONObject.put("feeds_type", "" + pqw.a(paramArticleInfo));
      localJSONObject.put("entry_mode", paramString);
      localJSONObject.put("kandian_mode", "" + pqu.a());
      localJSONObject.put("tab_source", "" + a());
      localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
      localJSONObject.put("channel_id", paramArticleInfo.mChannelID);
      localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString, ArticleInfo paramArticleInfo, long paramLong)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.mSocialFeedInfo == null)) {
      return "";
    }
    SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      if (ppe.a(paramArticleInfo)) {
        localJSONObject.put("feeds_source", paramArticleInfo.mSubscribeID);
      }
      for (;;)
      {
        localJSONObject.put("feeds_type", "" + pqw.a(paramArticleInfo));
        localJSONObject.put("entry_mode", paramString);
        localJSONObject.put("kandian_mode", "" + pqu.a());
        localJSONObject.put("tab_source", "" + a());
        localJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
        localJSONObject.put("channel_id", paramArticleInfo.mChannelID);
        localJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        localJSONObject.put("enter_uin", paramLong);
        return localJSONObject.toString();
        localJSONObject.put("feeds_source", localSocializeFeedsInfo.jdField_a_of_type_Rqy.a);
      }
      return "";
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "", "", false);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      if (paramInt > 0) {
        localJSONObject.put("from", paramInt);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("video_session_id", paramString2);
      }
      paramString2 = localJSONObject.toString();
      return paramString2;
    }
    catch (JSONException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  public static String a(String paramString1, String paramString2, ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      localJSONObject.put("kandian_mode", pqu.a());
      localJSONObject.put("tab_source", a());
      localJSONObject.put("rowkey", paramString1);
      localJSONObject.put("feeds_type", pqw.a(paramArticleInfo));
      localJSONObject.put("topicId", paramString2);
      localJSONObject.put("proteus_bid", bmhv.a("default_feeds_proteus_offline_bid"));
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return Long.toString(System.currentTimeMillis());
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    int j = 1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      localJSONObject.put("time", System.currentTimeMillis());
      localJSONObject.put("algorithm_id", paramString1);
      localJSONObject.put("session_id", prp.jdField_a_of_type_JavaLangString);
      if (paramBoolean)
      {
        i = 1;
        localJSONObject.put("avatar", i);
        localJSONObject.put("kd_pos", prp.b);
        if (!TextUtils.isEmpty(paramString3)) {
          localJSONObject.put("stick", paramString3);
        }
        if (prp.jdField_a_of_type_Int == 6)
        {
          localJSONObject.put("id", paramString2);
          localJSONObject.put("social_uin", paramString4);
        }
        if (!a()) {
          break label231;
        }
        i = 1;
        label143:
        localJSONObject.put("message_status", i);
        if (bmhv.C(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label237;
        }
        i = 1;
        label170:
        localJSONObject.put("reddot_style", i);
        if (!bmhv.C(pnn.a())) {
          break label243;
        }
      }
      label231:
      label237:
      label243:
      for (int i = j;; i = 0)
      {
        localJSONObject.put("hemera_switch", i);
        localJSONObject.put("kandian_mode_new", omx.a());
        paramString1 = localJSONObject.toString();
        return paramString1;
        i = 0;
        break;
        i = 0;
        break label143;
        i = 0;
        break label170;
      }
      return "";
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static String a(JSONObject paramJSONObject)
  {
    int i = 1;
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      if (bmhv.C(BaseApplicationImpl.getApplication().getRuntime()) == 1) {}
      for (;;)
      {
        localJSONObject.put("reddot_style", i);
        localJSONObject.put("kandian_mode", pqu.a());
        localJSONObject.put("kandian_mode_new", omx.a());
        localJSONObject.put("tab_source", a());
        localJSONObject.put("session_id", prp.jdField_a_of_type_JavaLangString);
        paramJSONObject = localJSONObject.toString();
        return paramJSONObject;
        i = 0;
      }
      return "";
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      localJSONObject.put("session_id", prp.jdField_a_of_type_JavaLangString);
      localJSONObject.put("kandian_mode_new", omx.a());
      localJSONObject.put("algorithm_id", prp.jdField_a_of_type_Rpn.jdField_a_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static JSONObject a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt3, int paramInt4, ArticleInfo paramArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (omx.jdField_a_of_type_JavaLangString == null) {
          omx.jdField_a_of_type_JavaLangString = "8.4.10".replace(".", "");
        }
        int j = ReadInJoyBaseFragment.a(paramInt2);
        boolean bool = a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo);
        int i = pqt.a();
        pkm localpkm = new pkm().a(paramLong).a(prp.a(paramInt2)).a(paramInt1).a().b(paramInt2);
        if (paramBoolean)
        {
          paramInt1 = 2;
          paramString1 = localpkm.c(paramInt1).b(paramString1).c(pqu.b()).d(pqu.c()).e(prp.jdField_a_of_type_JavaLangString).I(paramInt2).b(paramInt2, paramArticleInfo).g(paramString2).h(paramString3).b(paramArticleInfo, pqw.a(paramArticleInfo));
          if (bmhv.C(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            break label707;
          }
          paramInt1 = 1;
          paramString1 = paramString1.d(paramInt1).a(pqw.a(paramArticleInfo)).e(pqu.a()).f(omx.a()).g(paramInt4).h(paramInt3).s(paramArticleInfo);
          if (!bmhv.C(pnn.a())) {
            break label712;
          }
          paramInt1 = 1;
          paramString2 = paramString1.j(paramInt1).i(bmhv.a("default_feeds_proteus_offline_bid")).c().k(pqw.a(paramArticleInfo)).r(paramArticleInfo).b(pkm.a(paramArticleInfo)).m(omx.jdField_a_of_type_JavaLangString).n("1").H(paramInt2).a(pnn.a(), paramString2, paramArticleInfo).b();
          if (bhyk.a() != 1) {
            break label717;
          }
          paramString1 = "1";
          paramString1 = paramString2.q(paramString1).q(paramArticleInfo).a(paramArticleInfo, ppe.n(paramArticleInfo)).p(paramArticleInfo).n(j).o(paramArticleInfo).G(paramInt2);
          if (!pqt.a()) {
            break label725;
          }
          paramInt1 = 1;
          paramString2 = paramString1.o(paramInt1).n(paramArticleInfo).s("" + paramArticleInfo.isSuperTop);
          if (TextUtils.isEmpty(paramArticleInfo.mReportCommonData)) {
            break label730;
          }
          paramString1 = paramArticleInfo.mReportCommonData;
          paramString2 = paramString2.B(paramString1);
          if (TextUtils.isEmpty(Build.BRAND)) {
            break label738;
          }
          paramString1 = Build.BRAND;
          paramString2 = paramString2.t(paramString1);
          if (!TextUtils.isEmpty(Build.MODEL))
          {
            paramString1 = Build.MODEL;
            paramString1 = paramString2.u(paramString1).m(paramArticleInfo).t(a(paramArticleInfo)).l(paramArticleInfo).k(paramArticleInfo).a(paramArticleInfo, bool, i).a(paramInt2, paramArticleInfo).F(paramInt2).j(paramArticleInfo).i(paramArticleInfo).h(paramArticleInfo).g(paramArticleInfo);
            if (jdField_a_of_type_Boolean)
            {
              paramInt1 = 1;
              paramString1 = paramString1.z(paramInt1).f(paramArticleInfo).e(paramArticleInfo).c("default_feeds_aladdin_keys", (String)bmhv.a("default_feeds_aladdin_keys", "")).a(paramArticleInfo, a(Long.valueOf(paramArticleInfo.mArticleID))).d(paramArticleInfo);
              if (!paramArticleInfo.hasWalletIcon) {
                continue;
              }
              paramInt1 = 1;
              return paramString1.C(paramInt1).a(paramArticleInfo).b(paramArticleInfo).c(paramArticleInfo).t(paramArticleInfo).a();
            }
          }
          else
          {
            paramString1 = "";
            continue;
          }
          paramInt1 = 0;
          continue;
          paramInt1 = 0;
          continue;
        }
        paramInt1 = 1;
      }
      catch (JSONException paramString1)
      {
        QLog.e("RIJTransMergeKanDianReport", 2, "transMergeKandianReportR5WithTime error r5: " + localJSONObject.toString() + " error: " + paramString1.getMessage());
        return localJSONObject;
      }
      continue;
      label707:
      paramInt1 = 0;
      continue;
      label712:
      paramInt1 = 0;
      continue;
      label717:
      paramString1 = "0";
      continue;
      label725:
      paramInt1 = 0;
      continue;
      label730:
      paramString1 = "";
      continue;
      label738:
      paramString1 = "";
    }
  }
  
  public static JSONObject a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("algorithm_id", paramArticleInfo.mAlgorithmID);
        localJSONObject.put("puin_type", paramString);
        localJSONObject.put("feeds_type", pqw.a(paramArticleInfo));
        localJSONObject.put("source", pqu.a(paramInt));
        localJSONObject.put("is_fans", b(paramArticleInfo));
        localJSONObject.put("kandian_mode", pqu.a());
        localJSONObject.put("session_id", prp.jdField_a_of_type_JavaLangString);
        localJSONObject.put("mp_article_id", paramArticleInfo.mArticleID);
        localJSONObject.put("channel_id", paramInt);
        if (NetworkUtil.isWifiConnected(paramContext))
        {
          paramInt = 1;
          localJSONObject.put("network_type", paramInt);
          localJSONObject.put("os", "1");
          localJSONObject.put("version", "8.4.10".replace(".", ""));
          localJSONObject.put("imei", pqu.b());
          localJSONObject.put("imsi", pqu.c());
          if (pqw.a(paramArticleInfo))
          {
            localJSONObject.put("likes", paramArticleInfo.mSocialFeedInfo.b);
            localJSONObject.put("biu", paramArticleInfo.mSocialFeedInfo.f);
            return localJSONObject;
          }
          localJSONObject.put("likes", 0);
          localJSONObject.put("biu", 0);
          return localJSONObject;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return localJSONObject;
      }
      paramInt = 2;
    }
  }
  
  public static JSONObject a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = a(paramContext, paramArticleInfo, paramInt1, paramString);
    try
    {
      paramContext.put("biu_state", paramInt2);
      return paramContext;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return paramContext;
  }
  
  public static JSONObject a(String paramString1, String paramString2, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("hotword", paramString1);
      localJSONObject.put("rowKey", paramString2);
      localJSONObject.put("hotword_number", paramInt);
      localJSONObject.put("jump_type", 0);
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      QLog.e("RIJTransMergeKanDianReport", 1, "transMergeKandianPeportR5WithTime, hotword = , rowKey = " + paramString2 + ", hotword_number = " + paramInt + ", jump_type = " + 0);
    }
    return localJSONObject;
  }
  
  public static pqg a()
  {
    pqg localpqg = new pqg();
    try
    {
      localpqg.i();
      localpqg.j();
      localpqg.k();
      localpqg.m();
      localpqg.l();
      return localpqg;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localpqg;
  }
  
  public static pqg a(int paramInt1, long paramLong, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    pqg localpqg = new pqg();
    try
    {
      paramString1 = localpqg.a(paramLong).b().c().k(paramInt2).a(paramInt1).l().c(paramString1).j().k().b(paramString2).f(paramInt3).g(paramInt4).h(paramInt5).i(paramInt6).j(paramInt7).d().e().f().g();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return localpqg;
  }
  
  public static pqg a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    localpqg1 = new pqg();
    try
    {
      pqg localpqg2 = localpqg1.b().c().a(paramInt1).e().f().g().h().a(paramString).d(paramInt2).e(paramInt3).a();
      if (paramBoolean) {}
      for (paramString = "1";; paramString = "2")
      {
        localpqg2.a("refresh_way", paramString).i().m();
        if (paramInt4 == -1) {
          break;
        }
        localpqg1.a("pull_image", String.valueOf(paramInt4));
        return localpqg1;
      }
      return localpqg1;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static pqg a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (paramArticleInfo.mSocialFeedInfo != null))
    {
      SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
      Object localObject;
      int i;
      if (ppe.a(paramArticleInfo))
      {
        localObject = paramArticleInfo.mSubscribeID;
        if (localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList == null) {
          break label173;
        }
        i = localSocializeFeedsInfo.jdField_a_of_type_JavaUtilList.size();
        label49:
        if (!TextUtils.isEmpty(localSocializeFeedsInfo.jdField_a_of_type_JavaLangString)) {
          break label178;
        }
      }
      label173:
      label178:
      for (int j = 0;; j = 1)
      {
        int k = localSocializeFeedsInfo.b;
        int m = localSocializeFeedsInfo.d;
        int n = localSocializeFeedsInfo.f;
        return a((int)paramArticleInfo.mChannelID, paramArticleInfo.mAlgorithmID, paramArticleInfo.mFeedType, (String)localObject, paramArticleInfo.innerUniqueID, i + 1, j, k, m, n);
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (localSocializeFeedsInfo.jdField_a_of_type_Rqy != null) {}
        for (localObject = Long.valueOf(localSocializeFeedsInfo.jdField_a_of_type_Rqy.a);; localObject = "")
        {
          localObject = localObject;
          break;
        }
        i = 0;
        break label49;
      }
    }
    return new pqg();
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    if ((qez.a() != -1) && (qez.a() != 0))
    {
      paramJSONObject.put("mainfeeds_showcase", qez.a());
      paramJSONObject.put("configchannel_name", qez.a());
      return;
    }
    paramJSONObject.put("mainfeeds_showcase", 0);
  }
  
  public static void a(JSONObject paramJSONObject, ArticleInfo paramArticleInfo)
  {
    for (;;)
    {
      try
      {
        SocializeFeedsInfo localSocializeFeedsInfo = paramArticleInfo.mSocialFeedInfo;
        paramJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
        if (ppe.a(paramArticleInfo))
        {
          paramJSONObject.put("feeds_source", paramArticleInfo.mSubscribeID);
          paramJSONObject.put("rowkey", paramArticleInfo.innerUniqueID);
          paramJSONObject.put("feeds_type", "" + pqw.a(paramArticleInfo));
          paramJSONObject.put("kandian_mode", "" + pqu.a());
          paramJSONObject.put("tab_source", "" + a());
          paramJSONObject.put("channel_id", paramArticleInfo.mChannelID);
          paramJSONObject.put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
          if (paramArticleInfo.isPGCShortContent())
          {
            paramArticleInfo = "1";
            paramJSONObject.put("content_source", paramArticleInfo);
          }
        }
        else
        {
          if ((localSocializeFeedsInfo == null) || (localSocializeFeedsInfo.jdField_a_of_type_Rqy == null)) {
            continue;
          }
          paramJSONObject.put("feeds_source", localSocializeFeedsInfo.jdField_a_of_type_Rqy.a);
          continue;
        }
        paramArticleInfo = "0";
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
  }
  
  public static boolean a()
  {
    if (!pnn.a()) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    try
    {
      localObject1 = (Conversation)FrameHelperActivity.a(BaseActivity.sTopActivity).a(Conversation.class);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((Conversation)localObject1).a().b();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof RecentBaseData))
        {
          localArrayList.add((RecentBaseData)localObject2);
          continue;
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("RIJTransMergeKanDianReport", 1, "failed to construct recent base " + localException.toString());
    }
    for (;;)
    {
      int j = localException.size();
      int i = 0;
      while (i < j)
      {
        localObject1 = (RecentBaseData)localException.get(i);
        if (localObject1 != null)
        {
          localObject1 = (RecentUserBaseData)localObject1;
          if ((!TextUtils.equals(((RecentUserBaseData)localObject1).getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN)) && (((RecentUserBaseData)localObject1).getRecentUserType() != 5000))
          {
            int k = ((RecentUserBaseData)localObject1).getUnreadNum();
            if (k > 0) {
              return true;
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(Context paramContext, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.mProteusTemplateBean == null) {}
    for (String str = "";; str = paramBaseArticleInfo.mProteusTemplateBean.getStyleName()) {
      return a(paramContext, paramBaseArticleInfo, str);
    }
  }
  
  public static boolean a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    boolean bool1 = true;
    if ((paramBaseArticleInfo.mChannelID != 0L) && (!plm.c((int)paramBaseArticleInfo.mChannelID))) {
      QLog.e("RIJTransMergeKanDianReport", 1, "judgeShouldNoDifferenceJumpToApp channelID: " + paramBaseArticleInfo.mChannelID);
    }
    int i;
    label185:
    label200:
    label213:
    label232:
    label361:
    label363:
    do
    {
      for (;;)
      {
        return false;
        AladdinConfig localAladdinConfig = Aladdin.getConfig(199);
        if (localAladdinConfig == null)
        {
          QLog.e("RIJTransMergeKanDianReport", 1, "judgeShouldNoDifferenceJumpToApp AladdinConfig is empty.");
          return false;
        }
        boolean bool2 = bmhv.B();
        if (!bool2)
        {
          QLog.e("RIJTransMergeKanDianReport", 1, "judgeShouldNoDifferenceJumpToApp is not first no difference jump app today.");
          return false;
        }
        i = ppe.a((ArticleInfo)paramBaseArticleInfo);
        int j;
        int k;
        boolean bool3;
        if ((paramBaseArticleInfo.mFeedType == 0) && ((i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 6)))
        {
          j = 1;
          if ((paramBaseArticleInfo.mFeedType != 29) || ((!paramString.equalsIgnoreCase("ReadInjoy_daily_small_img_cell")) && (!paramString.equalsIgnoreCase("ReadInjoy_daily_triple_img_cell")) && (!paramString.equalsIgnoreCase("ReadInjoy_daily_large_img_cell")))) {
            break label334;
          }
          k = 1;
          if (localAladdinConfig.getIntegerFromString("no_difference_jump_app_switch", 0) != 1) {
            break label340;
          }
          i = 1;
          if ((j == 0) && (k == 0)) {
            break label345;
          }
          j = 1;
          bool3 = TextUtils.isEmpty(paramBaseArticleInfo.mArticleSubscriptText);
          if (paramBaseArticleInfo.isSuperTop != 0) {
            break label351;
          }
          k = 1;
          if ((TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl)) || ((!paramBaseArticleInfo.mArticleContentUrl.startsWith("mqqapi")) && (!paramBaseArticleInfo.mArticleContentUrl.contains("target=4")))) {
            break label357;
          }
        }
        for (int m = 1;; m = 0)
        {
          if ((i == 0) || (!bool2) || (j == 0) || (!bool3) || (k == 0) || (m != 0)) {
            break label361;
          }
          i = localAladdinConfig.getIntegerFromString("no_difference_jump_app_type", 0);
          paramBaseArticleInfo = localAladdinConfig.getString("no_difference_jump_app_package_name", "");
          if (i != 0) {
            break label363;
          }
          return true;
          j = 0;
          break;
          k = 0;
          break label185;
          i = 0;
          break label200;
          j = 0;
          break label213;
          k = 0;
          break label232;
        }
      }
      if (i == 1)
      {
        if (!bhfn.a(paramContext, paramBaseArticleInfo)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
    } while (i != 2);
    label334:
    label340:
    label345:
    label351:
    label357:
    return bhfn.a(paramContext, paramBaseArticleInfo);
  }
  
  public static String b()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      localJSONObject.put("kandian_mode", String.valueOf(pqu.a()));
      localJSONObject.put("kandian_mode_new", omx.a());
      localJSONObject.put("session_id", prp.jdField_a_of_type_JavaLangString);
      if (qep.b()) {}
      for (String str = "1";; str = "0")
      {
        localJSONObject.put("is_requesting_articles", str);
        localJSONObject.put("os", 1);
        localJSONObject.put("version", omx.jdField_a_of_type_JavaLangString);
        return localJSONObject.toString();
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public static String b(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", prp.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("time", System.currentTimeMillis());
      ((JSONObject)localObject).put("channel_id", paramInt);
      ((JSONObject)localObject).put("kandian_mode", pqu.a());
      ((JSONObject)localObject).put("kandian_mode_new", omx.a());
      ((JSONObject)localObject).put("tab_source", a());
      ((JSONObject)localObject).put("session_id", prp.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("os", 1);
      ((JSONObject)localObject).put("version", omx.jdField_a_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String b(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("algorithm_id", paramLong);
      ((JSONObject)localObject).put("folder_status", prp.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("feeds_type", paramInt1);
      ((JSONObject)localObject).put("time", System.currentTimeMillis());
      ((JSONObject)localObject).put("channel_id", paramInt2);
      ((JSONObject)localObject).put("feeds_channel_entrance", paramInt3);
      ((JSONObject)localObject).put("session_id", prp.jdField_a_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  private static String b(ArticleInfo paramArticleInfo)
  {
    if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
      return "0";
    }
    long l = Long.parseLong(paramArticleInfo.mSubscribeID);
    try
    {
      bool = ((aoan)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a(Long.valueOf(l), true);
      if (bool) {
        return "1";
      }
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        QLog.e("RIJTransMergeKanDianReport", 2, paramArticleInfo.getMessage());
        boolean bool = false;
      }
    }
    return "2";
  }
  
  public static JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("folder_status", prp.jdField_a_of_type_Int);
      localJSONObject.put("kandian_mode", pqu.a());
      localJSONObject.put("kandian_mode_new", omx.a());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static String c()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", prp.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("session_id", prp.jdField_a_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  public static String c(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", prp.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("reddot_num", paramInt);
      ((JSONObject)localObject).put("kandian_mode", pqu.a());
      ((JSONObject)localObject).put("session_id", prp.jdField_a_of_type_JavaLangString);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqf
 * JD-Core Version:    0.7.0.1
 */