package com.tencent.mobileqq.kandian.biz.biu;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.text.PositionalSpanStruct;
import com.tencent.mobileqq.kandian.base.view.widget.text.SeparatorSpan;
import com.tencent.mobileqq.kandian.biz.account.api.IRIJUserProtoUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.ReadInjoyFeedsUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity;
import com.tencent.mobileqq.kandian.biz.ugc.Utils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.glue.text.JumpSpan;
import com.tencent.mobileqq.kandian.repo.account.ArticleInfoHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.common.constant.IReadInJoyDeliverBiuActivityConst;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BiuInfoUtil;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AccountProfileInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ShareWebPageInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCPicInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.handler.JumpInfo;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.NowLiveInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.NowLiveInfo.MixInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.NowLiveInfo.MixInfo.AnchorInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.NowLiveInfo.MixInfo.LiveInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDeliverBiuActivity
  extends ReadInJoyBaseDeliverActivity
  implements IReadInJoyDeliverBiuActivityConst
{
  protected static String a = " //";
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  IPublicAccountObserver jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ReadInJoyDeliverBiuActivity.13(this);
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private CommonCommentData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView;
  ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyDeliverBiuActivity.9(this);
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private FixSizeImageView jdField_a_of_type_ComTencentWidgetFixSizeImageView;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[3];
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FixSizeImageView jdField_b_of_type_ComTencentWidgetFixSizeImageView;
  private long jdField_c_of_type_Long = 0L;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FixSizeImageView jdField_c_of_type_ComTencentWidgetFixSizeImageView;
  private long jdField_d_of_type_Long = 0L;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_f_of_type_AndroidWidgetRelativeLayout;
  private String jdField_f_of_type_JavaLangString;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private String jdField_g_of_type_JavaLangString;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private String jdField_h_of_type_JavaLangString;
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private String jdField_i_of_type_JavaLangString;
  private String j;
  private int jdField_k_of_type_Int;
  private String jdField_k_of_type_JavaLangString;
  private int jdField_l_of_type_Int;
  private String jdField_l_of_type_JavaLangString;
  private int jdField_m_of_type_Int = 1;
  private String jdField_m_of_type_JavaLangString = "1920*1080;1280*720;1812*1080;1208*720;1280*760;1184*720;1794*1080;1776*1080;1800*1080;2960*1440;2560*1440";
  private int n = -1;
  private int o;
  private int p;
  private int jdField_q_of_type_Int = 5000;
  private boolean jdField_q_of_type_Boolean;
  private int jdField_r_of_type_Int = 1;
  private boolean jdField_r_of_type_Boolean = true;
  private int jdField_s_of_type_Int = 2;
  private boolean jdField_s_of_type_Boolean = false;
  private int t = 3;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  
  public ReadInJoyDeliverBiuActivity()
  {
    this.jdField_o_of_type_Int = 0;
    this.jdField_p_of_type_Int = 0;
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != null)) {
      return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getHeight();
    }
    return 0;
  }
  
  private String a(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  private String a(BiuCommentInfo paramBiuCommentInfo)
  {
    Object localObject2 = this.jdField_k_of_type_JavaLangString;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = paramBiuCommentInfo.mUin;
      paramBiuCommentInfo = ReadInJoyUserInfoModule.a(((Long)localObject2).longValue());
      localObject1 = paramBiuCommentInfo;
      if (ReadInJoyUserInfoModule.a().equalsIgnoreCase(paramBiuCommentInfo))
      {
        paramBiuCommentInfo = ReadInJoyUserInfoModule.a(((Long)localObject2).longValue(), null);
        if (paramBiuCommentInfo != null) {
          paramBiuCommentInfo = paramBiuCommentInfo.nick;
        } else {
          paramBiuCommentInfo = ReadInJoyUserInfoModule.a();
        }
        localObject1 = paramBiuCommentInfo;
      }
    }
    paramBiuCommentInfo = new StringBuilder();
    paramBiuCommentInfo.append("getBiuUserName : ");
    paramBiuCommentInfo.append((String)localObject1);
    QLog.d("ReadInJoyDeliverBiuActivity", 2, paramBiuCommentInfo.toString());
    return localObject1;
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (((!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) && (this.jdField_p_of_type_Int == 17)) || (this.jdField_p_of_type_Int == 24))
    {
      String str2 = paramIntent.getStringExtra("arg_title");
      Object localObject = paramIntent.getStringExtra("arg_src");
      String str1 = paramIntent.getStringExtra("arg_cover");
      paramIntent = str2;
      if (TextUtils.isEmpty(str2)) {
        paramIntent = this.jdField_f_of_type_JavaLangString;
      }
      this.jdField_f_of_type_JavaLangString = paramIntent;
      paramIntent = (Intent)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramIntent = this.jdField_h_of_type_JavaLangString;
      }
      this.jdField_h_of_type_JavaLangString = paramIntent;
      paramIntent = str1;
      if (TextUtils.isEmpty(str1)) {
        paramIntent = this.jdField_i_of_type_JavaLangString;
      }
      this.jdField_i_of_type_JavaLangString = paramIntent;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = new BaseArticleInfo();
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
      }
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      str1 = this.jdField_f_of_type_JavaLangString;
      paramIntent = str1;
      if (str1 == null) {
        paramIntent = "";
      }
      ((TextView)localObject).setText(paramIntent);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView;
      str1 = this.jdField_h_of_type_JavaLangString;
      paramIntent = str1;
      if (str1 == null) {
        paramIntent = "";
      }
      ((ReadInJoyNickNameTextView)localObject).setText(paramIntent);
      if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
        return;
      }
      try
      {
        paramIntent = new URL(this.jdField_i_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage(paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  private static void a(Bundle paramBundle) {}
  
  private void a(ArrayList<BiuCommentInfo> paramArrayList)
  {
    BiuInfo localBiuInfo = new BiuInfo();
    long l1;
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      Object localObject;
      if ((this.jdField_l_of_type_Int == 23) || (this.jdField_p_of_type_Int == 24))
      {
        localObject = new ShareWebPageInfo();
        ((ShareWebPageInfo)localObject).b = this.jdField_f_of_type_JavaLangString;
        ((ShareWebPageInfo)localObject).d = this.jdField_h_of_type_JavaLangString;
        ((ShareWebPageInfo)localObject).c = this.jdField_i_of_type_JavaLangString;
        ((ShareWebPageInfo)localObject).jdField_a_of_type_JavaLangString = getIntent().getStringExtra("arg_source_url");
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo = ((ShareWebPageInfo)localObject);
      }
      NowLiveInfo.MixInfo localMixInfo;
      if (this.jdField_p_of_type_Int == 24)
      {
        localObject = new NowLiveInfo();
        localMixInfo = new NowLiveInfo.MixInfo();
        localMixInfo.a(new NowLiveInfo.MixInfo.AnchorInfo(getIntent().getLongExtra("arg_now_anchor_uin", 0L)));
        localMixInfo.a(new NowLiveInfo.MixInfo.LiveInfo(getIntent().getStringExtra("arg_now_live_vid")));
        ((NowLiveInfo)localObject).a(localMixInfo);
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityNowLiveInfo = ((NowLiveInfo)localObject);
      }
      l1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null)
      {
        localBiuInfo.jdField_a_of_type_JavaLangLong = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaLangLong;
        localBiuInfo.b = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b;
        i1 = paramArrayList.size() - 1;
        while (i1 > 0)
        {
          BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)paramArrayList.get(i1);
          localMixInfo = null;
          localObject = localMixInfo;
          if (localBiuCommentInfo.mFeedId.longValue() != 0L)
          {
            localObject = localMixInfo;
            if (localBiuCommentInfo.mOpType == 0)
            {
              Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList.iterator();
              do
              {
                localObject = localMixInfo;
                if (!localIterator.hasNext()) {
                  break;
                }
                localObject = (BiuCommentInfo)localIterator.next();
              } while (!((BiuCommentInfo)localObject).mFeedId.equals(localBiuCommentInfo.mFeedId));
            }
          }
          if (localObject == null) {
            localObject = (BiuCommentInfo)paramArrayList.get(i1);
          } else {
            ((BiuCommentInfo)localObject).mBiuComment = localBiuCommentInfo.mBiuComment;
          }
          localBiuInfo.jdField_a_of_type_JavaUtilList.add(localObject);
          i1 -= 1;
        }
      }
      i1 = paramArrayList.size() - 1;
      while (i1 > 0)
      {
        localBiuInfo.jdField_a_of_type_JavaUtilList.add(paramArrayList.get(i1));
        i1 -= 1;
      }
    }
    else
    {
      i1 = paramArrayList.size() - 1;
      while (i1 > 0)
      {
        localBiuInfo.jdField_a_of_type_JavaUtilList.add(paramArrayList.get(i1));
        i1 -= 1;
      }
      l1 = 0L;
    }
    if (this.jdField_s_of_type_Boolean)
    {
      ReadInJoyLogicEngine.a().a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), this.jdField_d_of_type_Long, localBiuInfo, ((BiuCommentInfo)paramArrayList.get(0)).mBiuComment);
      return;
    }
    ReadInJoyLogicEngine.a().a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId, localBiuInfo, l1, ((BiuCommentInfo)paramArrayList.get(0)).mBiuComment, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendSeq, this.jdField_p_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, this.jdField_m_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_q_of_type_Boolean);
    paramArrayList = new StringBuilder();
    paramArrayList.append("mFeedId:");
    paramArrayList.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
    paramArrayList.append(" masterUin");
    paramArrayList.append(l1);
    paramArrayList.append(", mArticleID:");
    paramArrayList.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
    paramArrayList.append(" mRecommendSeq: ");
    paramArrayList.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mRecommendSeq);
    paramArrayList.append(" biuSrc:");
    paramArrayList.append(this.jdField_p_of_type_Int);
    paramArrayList.append(" innerUniqueID");
    paramArrayList.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
    paramArrayList.append(" feedstype:");
    paramArrayList.append(this.jdField_m_of_type_Int);
    QLog.d("ReadInJoyDeliverBiuActivity", 2, paramArrayList.toString());
    this.jdField_c_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 5) || (paramInt == 4) || (paramInt == 6);
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo == null) {
          return false;
        }
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.longValue() == 30L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(@NotNull Intent paramIntent)
  {
    this.jdField_k_of_type_Int = paramIntent.getIntExtra("arg_type", -1);
    if (this.jdField_k_of_type_Int == -1)
    {
      this.jdField_k_of_type_Int = 1;
      if (((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (RIJFeedsType.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
      {
        this.jdField_k_of_type_Int = 2;
        return;
      }
      if ((RIJItemViewTypeUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null))
      {
        if (a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Int))
        {
          this.jdField_k_of_type_Int = 2;
          return;
        }
        this.jdField_k_of_type_Int = 1;
        return;
      }
      if (a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
        this.jdField_k_of_type_Int = 5;
      }
    }
  }
  
  private void b(ArrayList<Long> paramArrayList)
  {
    ThreadManager.post(new ReadInJoyDeliverBiuActivity.11(this, paramArrayList), 5, null, true);
  }
  
  private boolean b()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    return (localAbsBaseArticleInfo != null) && (RIJItemViewTypeUtils.s(localAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.z(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.jdField_b_of_type_Long != 0L);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 2);
  }
  
  private boolean c()
  {
    if (this.jdField_k_of_type_Int == 5)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean d()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    return (localAbsBaseArticleInfo != null) && (RIJFeedsType.d(localAbsBaseArticleInfo) == 27) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo != null);
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject3 = "";
    for (;;)
    {
      int i2;
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(RIJAppSetting.a());
        ((JSONObject)localObject2).put("kandian_mode", ((StringBuilder)localObject1).toString());
        if (!this.jdField_q_of_type_Boolean) {
          break label379;
        }
        localObject1 = "1";
        ((JSONObject)localObject2).put("fast_biu", localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        if ((localObject1 != null) && (RIJItemViewTypeUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
          ((JSONObject)localObject2).put("feeds_id", ((StringBuilder)localObject1).toString());
        }
        else
        {
          ((JSONObject)localObject2).put("feeds_id", "0");
        }
        localObject1 = getIntent().getExtras();
        i2 = 0;
        if ((localObject1 == null) || (!((Bundle)localObject1).containsKey("arg_forward"))) {
          break label387;
        }
        i1 = 1;
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        localJSONException.printStackTrace();
      }
      ((JSONObject)localObject2).put("outside", i2);
      localObject1 = ((JSONObject)localObject2).toString();
      localObject3 = localObject1;
      long l1 = this.jdField_b_of_type_Long;
      if (l1 < 0L) {
        str = "0";
      } else {
        str = String.valueOf(l1);
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (localObject2 != null)
      {
        localObject2 = String.valueOf(((AbsBaseArticleInfo)localObject2).businessId);
        if (!((String)localObject2).equals("0")) {
          str = "0";
        }
      }
      else
      {
        localObject2 = "0";
      }
      if (this.jdField_b_of_type_Boolean) {
        i1 = 3;
      } else if (paramBoolean) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      if (this.jdField_q_of_type_Boolean) {
        i1 = 1;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007EE9", "0X8007EE9", 0, 0, String.valueOf(i1), str, (String)localObject2, (String)localObject3, false);
      return;
      label379:
      String str = "0";
      continue;
      label387:
      int i1 = 0;
      if (i1 != 0) {
        i2 = 1;
      }
    }
  }
  
  private boolean e()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = l1 - this.jdField_c_of_type_Long;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDeliver!Time now=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", last=");
      localStringBuilder.append(this.jdField_c_of_type_Long);
      localStringBuilder.append(", diff=");
      localStringBuilder.append(l2);
      QLog.d("ReadInJoyDeliverBiuActivity", 2, localStringBuilder.toString());
    }
    if (l2 <= 2000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDeliverBiuActivity", 2, "deliver too fast(<=2000), return!");
      }
      return false;
    }
    if (!super.a())
    {
      if (this.jdField_q_of_type_Boolean) {
        finish();
      }
      return false;
    }
    return true;
  }
  
  private void f(boolean paramBoolean)
  {
    int i1 = this.jdField_l_of_type_Int;
    if ((i1 == 18) || (i1 == 17))
    {
      if (this.jdField_l_of_type_Int == 18)
      {
        if (!paramBoolean) {
          return;
        }
        localObject1 = "0X8008992";
      }
      else
      {
        localObject1 = "0X800898D";
      }
      Object localObject2 = getApplicationContext();
      if (paramBoolean) {
        i1 = 1;
      } else {
        i1 = 11;
      }
      FastWebShareUtils.a((Context)localObject2, (String)localObject1, i1, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.n);
      Object localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
      ((ReportInfo)localObject1).mSource = ((int)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID);
      ((ReportInfo)localObject1).mSourceArticleId = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID;
      ((ReportInfo)localObject1).mChannelId = ((int)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID);
      ((ReportInfo)localObject1).mAlgorithmId = ((int)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject1).mStrategyId = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId;
      ((ReportInfo)localObject1).mServerContext = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mServerContext;
      ((ReportInfo)localObject1).mInnerId = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID;
      ((ReportInfo)localObject1).mOperation = 25;
      ((ReportInfo)localObject1).mOpSource = 12;
      ((ReportInfo)localObject1).mReadTimeLength = -1;
      localObject2 = new ArrayList();
      ((List)localObject2).add(localObject1);
      ReadInJoyLogicEngine.a().a((List)localObject2);
    }
  }
  
  private boolean f()
  {
    return (RIJItemViewTypeUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.v(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
  }
  
  private void m()
  {
    this.jdField_q_of_type_Boolean = getIntent().getBooleanExtra("fast_biu_type", false);
    this.jdField_r_of_type_Boolean = getIntent().getBooleanExtra("should_show_dialog", true);
    this.jdField_s_of_type_Boolean = getIntent().getBooleanExtra("is_modified_biu", false);
    this.jdField_d_of_type_Long = getIntent().getLongExtra("modified_feeds_id", 0L);
    this.jdField_p_of_type_Boolean = (this.jdField_q_of_type_Boolean ^ true);
  }
  
  private void n()
  {
    Object localObject = (RelativeLayout)findViewById(2131365179);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(1, 2131368461);
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(0, 0);
    ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
    ((RelativeLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131298810);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setMaxLines(2);
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("commonCommentData is not null mcover:");
      ((StringBuilder)localObject).append(this.jdField_i_of_type_JavaLangString);
      ((StringBuilder)localObject).append("video duration: ");
      ((StringBuilder)localObject).append(this.jdField_j_of_type_JavaLangString);
      ((StringBuilder)localObject).append("msource : ");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_JavaLangString);
      ((StringBuilder)localObject).append("mtitle");
      ((StringBuilder)localObject).append(this.jdField_f_of_type_JavaLangString);
      QLog.d("ReadInJoyDeliverBiuActivity", 2, ((StringBuilder)localObject).toString());
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData.getBiuSourceName()))
      {
        this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData.getBiuSourceName();
        localObject = new QQText(EmotionCodecUtils.b(new String(Base64Util.decode(this.jdField_h_of_type_JavaLangString, 0))), 7, 16);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText((CharSequence)localObject);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData.getBiuPicUrl()))
      {
        this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData.getBiuPicUrl();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage(new URL(this.jdField_i_of_type_JavaLangString));
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData.getBiuDuration() != -1L)
      {
        long l1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData.getBiuDuration();
        this.jdField_j_of_type_JavaLangString = String.format("%02d:%02d", new Object[] { Long.valueOf(l1 / 60L), Long.valueOf(l1 % 60L) });
        if (l1 != 0L)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
        }
      }
    }
  }
  
  private void p()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Int;
    if ((!RIJItemViewTypeUtils.x(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (a(i1)))
    {
      this.jdField_i_of_type_JavaLangString = ((UGCVideoInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).d;
      return;
    }
    if ((!RIJItemViewTypeUtils.w(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (b(i1)))
    {
      this.jdField_i_of_type_JavaLangString = ((UGCPicInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).c;
      return;
    }
    if (ReadInjoyFeedsUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAccountProfileInfo.b;
      return;
    }
    if ((((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).isUgcAd(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (!TextUtils.isEmpty(((AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).mAdImg)))
    {
      this.jdField_i_of_type_JavaLangString = ((AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).mAdImg;
      return;
    }
    this.jdField_i_of_type_JavaLangString = null;
  }
  
  private void q()
  {
    if ((RIJItemViewTypeUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.v(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))) {
      p();
    } else if ((RIJItemViewTypeUtils.s(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.z(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))) {
      this.jdField_i_of_type_JavaLangString = ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).d;
    } else if ((RIJFeedsType.d(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo) == 27) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo != null)) {
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo.c;
    } else {
      this.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFirstPagePicUrl;
    }
    if ((TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) && (!a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
    }
    else if (a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageDrawable(BaseApplication.getContext().getResources().getDrawable(2130849632));
    }
    else
    {
      try
      {
        URL localURL = new URL(this.jdField_i_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImage(localURL);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    r();
  }
  
  private void r()
  {
    if (this.jdField_k_of_type_Int == 2)
    {
      long l2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoDuration;
      long l1 = l2;
      if (RIJItemViewTypeUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
      {
        l1 = l2;
        if (!RIJItemViewTypeUtils.x(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
          l1 = ((UGCVideoInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).jdField_a_of_type_Long / 1000L;
        }
      }
      this.jdField_j_of_type_JavaLangString = a(l1);
      if (l1 != 0L)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_j_of_type_JavaLangString);
      }
    }
  }
  
  private void s()
  {
    long l1;
    if (f())
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
      if (l1 == 0L)
      {
        this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeName;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setNickNameByUin(l1);
      return;
    }
    if (b())
    {
      this.jdField_h_of_type_JavaLangString = ContactUtils.a((QQAppInterface)ReadInJoyUtils.a(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.jdField_b_of_type_Long), true);
      if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(8);
      return;
    }
    int i1 = this.jdField_k_of_type_Int;
    if (i1 == 4)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSummary)) {
        this.jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131712775);
      } else {
        this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSummary;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
      return;
    }
    if (i1 == 5)
    {
      l1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
      if (l1 == 0L)
      {
        this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeName;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setNickNameByUin(l1);
      return;
    }
    if (d())
    {
      this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo.d;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
      return;
    }
    this.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeName;
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setText(this.jdField_h_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView.setVisibility(8);
  }
  
  private void t()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData;
    if ((localObject != null) && (!TextUtils.isEmpty(((CommonCommentData)localObject).getBiuTitle())))
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData.getBiuTitle();
      localObject = new QQText(EmotionCodecUtils.b(new String(Base64Util.decode(this.jdField_f_of_type_JavaLangString, 0))), 7, 16);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
  }
  
  private void u()
  {
    if ((RIJItemViewTypeUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.v(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
    {
      if (!RIJItemViewTypeUtils.x(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
      {
        this.jdField_f_of_type_JavaLangString = ((UGCVideoInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.b.get(0)).jdField_e_of_type_JavaLangString;
        return;
      }
      if ((((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).isUgcAd(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (!TextUtils.isEmpty(((AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).mAdTxt)))
      {
        this.jdField_f_of_type_JavaLangString = ((AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).mAdTxt;
        return;
      }
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_JavaLangString;
      return;
    }
    if (RIJItemViewTypeUtils.s(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      if (!RIJItemViewTypeUtils.z(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
      {
        TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localTopicRecommendInfo.c);
        localStringBuilder.append(localTopicRecommendInfo.jdField_a_of_type_JavaLangString);
        this.jdField_f_of_type_JavaLangString = localStringBuilder.toString();
        return;
      }
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTitle;
      return;
    }
    if (this.jdField_k_of_type_Int == 4)
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeName;
      return;
    }
    if (d())
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityShareWebPageInfo.b;
      return;
    }
    if (c())
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_JavaLangString;
      return;
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTitle;
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSummary;
  }
  
  private void v()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  private void w()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    Object localObject1 = "ReadInJoyDeliverBiuActivity";
    if ((localObject2 != null) && (((AbsBaseArticleInfo)localObject2).mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList != null))
    {
      if (this.jdField_o_of_type_Int <= 0)
      {
        this.jdField_o_of_type_Int = getResources().getDisplayMetrics().widthPixels;
        this.jdField_o_of_type_Int = (this.jdField_o_of_type_Int - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetEditText.getPaddingRight());
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.jdField_a_of_type_JavaUtilList;
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject3 = new ArrayList();
      if (localList.size() > 0)
      {
        i1 = localStringBuilder.length();
        localStringBuilder.append(jdField_a_of_type_JavaLangString);
        ((List)localObject3).add(new PositionalSpanStruct(i1, jdField_a_of_type_JavaLangString.length() + i1, new SeparatorSpan()));
      }
      int i2 = localStringBuilder.length();
      int i1 = localList.size() - 1;
      while (i1 >= 0)
      {
        Object localObject4 = (BiuCommentInfo)localList.get(i1);
        int i3 = ((BiuCommentInfo)localObject4).mOpType;
        localObject2 = "";
        String str2;
        Object localObject5;
        String str1;
        if (i3 != 1)
        {
          if (i3 != 3)
          {
            try
            {
              str2 = a((BiuCommentInfo)localObject4);
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("@");
              ((StringBuilder)localObject5).append(str2);
              str2 = ((StringBuilder)localObject5).toString();
              localStringBuilder.append(str2);
              if (((BiuCommentInfo)localObject4).mBiuComment != null) {
                localObject2 = ((BiuCommentInfo)localObject4).mBiuComment;
              }
              localStringBuilder.append((String)localObject2);
              ((List)localObject3).add(new PositionalSpanStruct(i2, str2.length() + i2, new BiuNicknameSpan(((BiuCommentInfo)localObject4).mUin.toString(), ((BiuCommentInfo)localObject4).mFeedId.longValue(), str2)));
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              QLog.d((String)localObject1, 2, localNumberFormatException1.getMessage());
            }
          }
          else if (((BiuCommentInfo)localObject4).jumpInfo != null)
          {
            str2 = ((BiuCommentInfo)localObject4).jumpInfo.getWording();
            localObject5 = ((BiuCommentInfo)localObject4).jumpInfo.getJumpUrl();
            if (((BiuCommentInfo)localObject4).mBiuComment != null) {
              str1 = ((BiuCommentInfo)localObject4).mBiuComment;
            }
            localStringBuilder.append(str2);
            localStringBuilder.append(str1);
            ((List)localObject3).add(new PositionalSpanStruct(i2, str2.length() + i2, new JumpSpan((String)localObject5, 13421772)));
          }
        }
        else {
          try
          {
            str2 = a((BiuCommentInfo)localObject4);
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("@");
            ((StringBuilder)localObject5).append(str2);
            ((StringBuilder)localObject5).append(" ");
            str2 = ((StringBuilder)localObject5).toString();
            localStringBuilder.append(str2);
            if (((BiuCommentInfo)localObject4).mBiuComment != null) {
              str1 = ((BiuCommentInfo)localObject4).mBiuComment;
            }
            localStringBuilder.append(str1);
            i3 = str2.length();
            str1 = ((BiuCommentInfo)localObject4).mUin.toString();
            localObject4 = ((BiuCommentInfo)localObject4).mFeedId;
            try
            {
              ((List)localObject3).add(new PositionalSpanStruct(i2, i3 + i2, new AtFriendsSpan(str1, ((Long)localObject4).longValue(), str2)));
            }
            catch (NumberFormatException localNumberFormatException2) {}
            QLog.e((String)localObject1, 2, "initEditText: ", localNumberFormatException3);
          }
          catch (NumberFormatException localNumberFormatException3) {}
        }
        i2 = localStringBuilder.length();
        i1 -= 1;
      }
      localObject1 = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
      Iterator localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (PositionalSpanStruct)localIterator.next();
        ((SpannableStringBuilder)localObject1).setSpan(((PositionalSpanStruct)localObject3).a(), ((PositionalSpanStruct)localObject3).a(), ((PositionalSpanStruct)localObject3).b(), 33);
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
      return;
    }
    QLog.d("ReadInJoyDeliverBiuActivity", 2, "initEditText: got null stuff");
  }
  
  private void x()
  {
    ThreadManager.post(new ReadInJoyDeliverBiuActivity.10(this), 5, null, true);
  }
  
  private void y()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      localObject = this.jdField_f_of_type_JavaLangString;
    } else if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
      localObject = this.jdField_g_of_type_JavaLangString;
    } else {
      localObject = "";
    }
    try
    {
      localObject = EmotionCodecUtils.b((String)localObject);
      if ((RIJItemViewTypeUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.v(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && (!UtilsForComponent.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
      {
        UGCFeedsInfo localUGCFeedsInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo;
        if (!RIJFeedsType.a(localUGCFeedsInfo))
        {
          localObject = new QQText((CharSequence)localObject, 7, 16);
          this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          return;
        }
        localObject = new QQText(BiuInfoUtil.a(localUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo), 7, 16);
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
      }
      localObject = new QQText((CharSequence)localObject, 7, 16);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyDeliverBiuActivity", 2, localException.toString());
      }
    }
  }
  
  public int a(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("biu_src", 1);
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
      i1 = 100;
    }
    return i1;
  }
  
  protected void a()
  {
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363658));
    this.jdField_f_of_type_Int = 178;
    this.jdField_f_of_type_Int = ViewUtils.b(this.jdField_f_of_type_Int);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ReadInJoyDeliverBiuActivity.1(this);
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new ReadInJoyDeliverBiuActivity.2(this));
    this.v = ViewUtils.b();
    Object localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (this.v * 8 / 100);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)findViewById(2131378784));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371697));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)findViewById(2131368461));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131372746));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372752));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131380553));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380578));
    getTitleBarView().setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365511));
    if (this.jdField_s_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131697475));
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ReadInJoyDeliverBiuActivity.3(this));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4473925);
    }
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364703));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new ReadInJoyDeliverBiuActivity.4(this));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364912);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ReadInJoyDeliverBiuActivity.5(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376809);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378998));
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363656));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363651));
    this.jdField_e_of_type_AndroidWidgetImageView.setRotation(-30.0F);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372202));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372204));
    this.jdField_g_of_type_AndroidWidgetImageView.setRotation(30.0F);
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372205));
    this.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131366869));
    this.jdField_b_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131377103));
    this.jdField_c_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)findViewById(2131363135));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363659));
    this.jdField_f_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131363653));
    localObject = AnimationUtils.loadAnimation(this, 2130772232);
    this.jdField_b_of_type_AndroidViewView.startAnimation((Animation)localObject);
    localObject = AnimationUtils.loadAnimation(this, 2130772233);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverBiuActivity.6(this), 250L);
    if (getIntent().getIntExtra("arg_type", -1) == 4) {
      n();
    }
  }
  
  protected void a(int paramInt)
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.init();
        this.mSystemBarComp.setStatusBarColor(-872415232);
        return;
      }
      this.mSystemBarComp.init();
      if (!SystemUtil.d())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
        return;
      }
      this.mSystemBarComp.setStatusBarColor(-872415232);
      this.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  protected boolean a()
  {
    if (!e()) {
      return false;
    }
    if (this.jdField_r_of_type_Boolean) {
      e(2131695224);
    }
    this.jdField_r_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    boolean bool = Utils.a(this.jdField_a_of_type_AndroidWidgetEditText, this.app.getCurrentAccountUin(), this.jdField_o_of_type_Boolean, true, localArrayList);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDeliver deliverList:\n");
    ((StringBuilder)localObject).append(localArrayList.toString());
    QLog.d("biu_data_trace", 2, ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) && (this.jdField_p_of_type_Int == 17))
    {
      ReadInJoyLogicEngine.a().a(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin(), this.jdField_l_of_type_JavaLangString, this.jdField_p_of_type_Int, ((BiuCommentInfo)localArrayList.get(0)).mBiuComment, localArrayList, this.jdField_q_of_type_Boolean);
    }
    else if (this.jdField_l_of_type_Int == 21)
    {
      localObject = new AccountProfileInfo();
      ((AccountProfileInfo)localObject).c = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSummary;
      ((AccountProfileInfo)localObject).jdField_a_of_type_Long = getIntent().getLongExtra("arg_account_id", -1L);
      ((AccountProfileInfo)localObject).jdField_a_of_type_Int = getIntent().getIntExtra("arg_account_type", -1);
      ((AccountProfileInfo)localObject).b = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFirstPagePicUrl;
      ((AccountProfileInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeName;
      ReadInJoyLogicEngine.a().a(this.app.getCurrentUin(), this.jdField_l_of_type_Int, c(), localArrayList, (AccountProfileInfo)localObject);
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (!localArrayList.isEmpty()))
    {
      a(localArrayList);
    }
    e(bool);
    return true;
  }
  
  protected void b()
  {
    super.b();
    this.jdField_e_of_type_JavaLangString = "0X800865F";
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImagePlaceHolder(getResources().getDrawable(2130849671));
    Intent localIntent = getIntent();
    boolean bool = false;
    this.jdField_l_of_type_Int = localIntent.getIntExtra("arg_from_type", 0);
    this.n = localIntent.getIntExtra("arg_biu_state", -1);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)localIntent.getParcelableExtra("arg_article_info"));
    this.jdField_k_of_type_JavaLangString = localIntent.getStringExtra("arg_nickname");
    this.jdField_p_of_type_Int = a(localIntent);
    this.jdField_l_of_type_JavaLangString = localIntent.getStringExtra("biu_rowkey");
    this.jdField_m_of_type_Int = localIntent.getIntExtra("feedsType", 1);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityCommonCommentData = ((CommonCommentData)localIntent.getSerializableExtra("arg_common_comment_info"));
    if (this.jdField_q_of_type_Boolean) {
      findViewById(2131364921).setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      b(localIntent);
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID;
      u();
      y();
      t();
      s();
      q();
      o();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mcover:");
      localStringBuilder.append(this.jdField_i_of_type_JavaLangString);
      localStringBuilder.append("video duration: ");
      localStringBuilder.append(this.jdField_j_of_type_JavaLangString);
      localStringBuilder.append("msource : ");
      localStringBuilder.append(this.jdField_h_of_type_JavaLangString);
      localStringBuilder.append("mtitle : ");
      localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
      QLog.d("ReadInJoyDeliverBiuActivity", 2, localStringBuilder.toString());
    }
    a(localIntent);
    if (ArticleInfoHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSocialFeedInfo.jdField_e_of_type_JavaLangString;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (ReadInJoyHelper.k(this.app) == 0) {
      bool = true;
    }
    this.jdField_g_of_type_Boolean = bool;
    if ((!this.jdField_g_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    w();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    if (this.jdField_q_of_type_Boolean) {
      a();
    }
  }
  
  protected void b(int paramInt)
  {
    this.jdField_j_of_type_Int = this.jdField_a_of_type_Int;
    c(0);
    super.a(true, paramInt, false, 0L);
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "onEmotionBtn!");
    }
    String str;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localObject = ((JSONObject)localObject).toString();
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      str = "";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007EE8", "0X8007EE8", 0, 0, "", "", "", str, false);
    super.c();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    f(false);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject2 = "";
    super.doOnCreate(paramBundle);
    super.setContentView(2131560172);
    RIJDtReportHelper.a.a(getActivity());
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    m();
    a(2131717860);
    a();
    b();
    if (this.jdField_q_of_type_Boolean) {
      return true;
    }
    ((IRIJUserProtoUtils)QRoute.api(IRIJUserProtoUtils.class)).check(this, null);
    try
    {
      paramBundle = new JSONObject();
      paramBundle.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(RIJAppSetting.a());
      paramBundle.put("kandian_mode", ((StringBuilder)localObject1).toString());
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if ((localObject1 != null) && (RIJItemViewTypeUtils.o(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId);
        paramBundle.put("feeds_id", ((StringBuilder)localObject1).toString());
      }
      else
      {
        paramBundle.put("feeds_id", "0");
      }
      paramBundle = paramBundle.toString();
      localObject2 = paramBundle;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
    long l1 = this.jdField_b_of_type_Long;
    if (l1 < 0L) {
      paramBundle = "0";
    } else {
      paramBundle = String.valueOf(l1);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if (localObject1 != null)
    {
      localObject1 = String.valueOf(((AbsBaseArticleInfo)localObject1).businessId);
      if (!((String)localObject1).equals("0")) {
        paramBundle = "0";
      }
    }
    else
    {
      localObject1 = "0";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8007EE7", "0X8007EE7", 0, 0, String.valueOf(this.jdField_l_of_type_Int), paramBundle, (String)localObject1, (String)localObject2, false);
    a(getIntent().getExtras());
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    Object localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localObject != null) {
      ((AnimatorSet)localObject).cancel();
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
    if (localObject != null) {
      super.removeObserver(((IPublicAccountObserver)localObject).getBusinessObserver());
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (isInMultiWindow())
    {
      QQToast.a(this, HardCodeUtil.a(2131712928), 0).a();
      finish();
    }
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130772234);
    localAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(this, 2130772235);
    localAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverBiuActivity.8(this), 300L);
  }
  
  protected boolean onBackEvent()
  {
    if ((this.jdField_b_of_type_Boolean) && ((!this.jdField_e_of_type_Boolean) || (this.jdField_d_of_type_Int != -1)))
    {
      b(this.t);
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity
 * JD-Core Version:    0.7.0.1
 */