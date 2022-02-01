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
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.text.PositionalSpanStruct;
import com.tencent.mobileqq.kandian.base.view.widget.text.SeparatorSpan;
import com.tencent.mobileqq.kandian.biz.account.api.impl.RIJUserProtoUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommonCommentData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
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
  private int aA = 0;
  private String aB;
  private long aC = 0L;
  private int aD = 5000;
  private Button aE;
  private View aF;
  private ImageView aG;
  private View aH;
  private RelativeLayout aI;
  private RelativeLayout aJ;
  private RelativeLayout aK;
  private ImageView aL;
  private ImageView aM;
  private ImageView aN;
  private ImageView aO;
  private FixSizeImageView aP;
  private FixSizeImageView aQ;
  private FixSizeImageView aR;
  private ImageView aS;
  private RelativeLayout aT;
  private String[] aU = new String[3];
  private int aV = 1;
  private int aW = 2;
  private int aX = 3;
  private String aY = "1920*1080;1280*720;1812*1080;1208*720;1280*760;1184*720;1794*1080;1776*1080;1800*1080;2960*1440;2560*1440";
  private int aZ = 0;
  private String ag;
  private String ah;
  private String ai;
  private String aj;
  private int ak;
  private String al;
  private int am;
  private long an;
  private AbsBaseArticleInfo ao;
  private String ap;
  private int aq = 1;
  private int ar = -1;
  private ReadInJoyNickNameTextView as;
  private TextView at;
  private KandianUrlImageView au;
  private RelativeLayout av;
  private TextView aw;
  private RelativeLayout ax;
  private TextView ay;
  private int az = 0;
  AnimatorSet b;
  private int ba = 0;
  private int bb = 0;
  private boolean bc;
  private boolean bd = true;
  private boolean be = false;
  private long bf = 0L;
  private CommonCommentData bg;
  private FriendListObserver bh = new ReadInJoyDeliverBiuActivity.13(this);
  IPublicAccountObserver c;
  ReadInJoyObserver d = new ReadInJoyDeliverBiuActivity.9(this);
  
  private void A()
  {
    Object localObject = this.bg;
    if ((localObject != null) && (!TextUtils.isEmpty(((CommonCommentData)localObject).getBiuTitle())))
    {
      this.ag = this.bg.getBiuTitle();
      localObject = new QQText(EmotionCodecUtils.c(new String(Base64Util.decode(this.ag, 0))), 7, 16);
      this.at.setVisibility(0);
      this.at.setText((CharSequence)localObject);
    }
  }
  
  private void B()
  {
    if ((RIJItemViewTypeUtils.o(this.ao)) && (!RIJItemViewTypeUtils.v(this.ao)))
    {
      if (!RIJItemViewTypeUtils.x(this.ao))
      {
        this.ag = ((UGCVideoInfo)this.ao.mSocialFeedInfo.s.c.get(0)).e;
        return;
      }
      if ((((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).isUgcAd(this.ao)) && (!TextUtils.isEmpty(((AdvertisementInfo)this.ao).mAdTxt)))
      {
        this.ag = ((AdvertisementInfo)this.ao).mAdTxt;
        return;
      }
      this.ag = this.ao.mSocialFeedInfo.s.f;
      return;
    }
    if (RIJItemViewTypeUtils.s(this.ao))
    {
      if (!RIJItemViewTypeUtils.z(this.ao))
      {
        TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)this.ao.mSocialFeedInfo.v.g.get(0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localTopicRecommendInfo.d);
        localStringBuilder.append(localTopicRecommendInfo.b);
        this.ag = localStringBuilder.toString();
        return;
      }
      this.ag = this.ao.mTitle;
      return;
    }
    if (this.ak == 4)
    {
      this.ag = this.ao.mSubscribeName;
      return;
    }
    if (E())
    {
      this.ag = this.ao.mSocialFeedInfo.E.b;
      return;
    }
    if (D())
    {
      this.ag = this.ao.mSocialFeedInfo.s.f;
      return;
    }
    this.ag = this.ao.mTitle;
    this.ah = this.ao.mSummary;
  }
  
  private boolean C()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.ao;
    return (localAbsBaseArticleInfo != null) && (RIJItemViewTypeUtils.s(localAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.z(this.ao)) && (this.ao.mSocialFeedInfo != null) && (this.ao.mSocialFeedInfo.v != null) && (this.ao.mSocialFeedInfo.v.c != 0L);
  }
  
  private boolean D()
  {
    if (this.ak == 5)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.ao;
      if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.ao.mSocialFeedInfo.s != null)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean E()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.ao;
    return (localAbsBaseArticleInfo != null) && (RIJFeedsType.ac(localAbsBaseArticleInfo) == 27) && (this.ao.mSocialFeedInfo != null) && (this.ao.mSocialFeedInfo.E != null);
  }
  
  private void F()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  private void G()
  {
    Object localObject2 = this.ao;
    Object localObject1 = "ReadInJoyDeliverBiuActivity";
    if ((localObject2 != null) && (((AbsBaseArticleInfo)localObject2).mSocialFeedInfo != null) && (this.ao.mSocialFeedInfo.n != null) && (this.ao.mSocialFeedInfo.n.a != null))
    {
      if (this.az <= 0)
      {
        this.az = getResources().getDisplayMetrics().widthPixels;
        this.az = (this.az - this.e.getPaddingLeft() - this.e.getPaddingRight());
      }
      List localList = this.ao.mSocialFeedInfo.n.a;
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject3 = new ArrayList();
      if (localList.size() > 0)
      {
        i = localStringBuilder.length();
        localStringBuilder.append(a);
        ((List)localObject3).add(new PositionalSpanStruct(i, a.length() + i, new SeparatorSpan()));
      }
      int j = localStringBuilder.length();
      int i = localList.size() - 1;
      while (i >= 0)
      {
        Object localObject4 = (BiuCommentInfo)localList.get(i);
        int k = ((BiuCommentInfo)localObject4).mOpType;
        localObject2 = "";
        String str2;
        Object localObject5;
        String str1;
        if (k != 1)
        {
          if (k != 3)
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
              ((List)localObject3).add(new PositionalSpanStruct(j, str2.length() + j, new BiuNicknameSpan(((BiuCommentInfo)localObject4).mUin.toString(), ((BiuCommentInfo)localObject4).mFeedId.longValue(), str2)));
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
            ((List)localObject3).add(new PositionalSpanStruct(j, str2.length() + j, new JumpSpan((String)localObject5, 13421772)));
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
            k = str2.length();
            str1 = ((BiuCommentInfo)localObject4).mUin.toString();
            localObject4 = ((BiuCommentInfo)localObject4).mFeedId;
            try
            {
              ((List)localObject3).add(new PositionalSpanStruct(j, k + j, new AtFriendsSpan(str1, ((Long)localObject4).longValue(), str2)));
            }
            catch (NumberFormatException localNumberFormatException2) {}
            QLog.e((String)localObject1, 2, "initEditText: ", localNumberFormatException3);
          }
          catch (NumberFormatException localNumberFormatException3) {}
        }
        j = localStringBuilder.length();
        i -= 1;
      }
      localObject1 = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
      Iterator localIterator = ((List)localObject3).iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (PositionalSpanStruct)localIterator.next();
        ((SpannableStringBuilder)localObject1).setSpan(((PositionalSpanStruct)localObject3).c(), ((PositionalSpanStruct)localObject3).a(), ((PositionalSpanStruct)localObject3).b(), 33);
      }
      this.s = true;
      this.e.setText((CharSequence)localObject1);
      return;
    }
    QLog.d("ReadInJoyDeliverBiuActivity", 2, "initEditText: got null stuff");
  }
  
  private boolean H()
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = l1 - this.aC;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDeliver!Time now=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", last=");
      localStringBuilder.append(this.aC);
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
    if (!super.c())
    {
      if (this.bc) {
        finish();
      }
      return false;
    }
    return true;
  }
  
  private void I()
  {
    ThreadManager.post(new ReadInJoyDeliverBiuActivity.10(this), 5, null, true);
  }
  
  private boolean J()
  {
    return (RIJItemViewTypeUtils.o(this.ao)) && (!RIJItemViewTypeUtils.v(this.ao));
  }
  
  private void K()
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.ag)) {
      localObject = this.ag;
    } else if (!TextUtils.isEmpty(this.ah)) {
      localObject = this.ah;
    } else {
      localObject = "";
    }
    try
    {
      localObject = EmotionCodecUtils.c((String)localObject);
      if ((RIJItemViewTypeUtils.o(this.ao)) && (!RIJItemViewTypeUtils.v(this.ao)) && (!UtilsForComponent.b(this.ao)))
      {
        UGCFeedsInfo localUGCFeedsInfo = this.ao.mSocialFeedInfo.s;
        if (!RIJFeedsType.a(localUGCFeedsInfo))
        {
          localObject = new QQText((CharSequence)localObject, 7, 16);
          this.at.setText((CharSequence)localObject);
          return;
        }
        localObject = new QQText(BiuInfoUtil.a(localUGCFeedsInfo.h), 7, 16);
        this.at.setText((CharSequence)localObject);
        return;
      }
      localObject = new QQText((CharSequence)localObject, 7, 16);
      this.at.setText((CharSequence)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyDeliverBiuActivity", 2, localException.toString());
      }
    }
  }
  
  private String a(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
  }
  
  private String a(BiuCommentInfo paramBiuCommentInfo)
  {
    Object localObject2 = this.ap;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = paramBiuCommentInfo.mUin;
      paramBiuCommentInfo = ReadInJoyUserInfoModule.a(((Long)localObject2).longValue());
      localObject1 = paramBiuCommentInfo;
      if (ReadInJoyUserInfoModule.d().equalsIgnoreCase(paramBiuCommentInfo))
      {
        paramBiuCommentInfo = ReadInJoyUserInfoModule.a(((Long)localObject2).longValue(), null);
        if (paramBiuCommentInfo != null) {
          paramBiuCommentInfo = paramBiuCommentInfo.nick;
        } else {
          paramBiuCommentInfo = ReadInJoyUserInfoModule.d();
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
  
  private static void a(Bundle paramBundle) {}
  
  private void a(ArrayList<BiuCommentInfo> paramArrayList)
  {
    BiuInfo localBiuInfo = new BiuInfo();
    long l;
    int i;
    if (this.ao.mSocialFeedInfo != null)
    {
      Object localObject;
      if ((this.am == 23) || (this.aA == 24))
      {
        localObject = new ShareWebPageInfo();
        ((ShareWebPageInfo)localObject).b = this.ag;
        ((ShareWebPageInfo)localObject).d = this.ai;
        ((ShareWebPageInfo)localObject).c = this.aj;
        ((ShareWebPageInfo)localObject).a = getIntent().getStringExtra("arg_source_url");
        this.ao.mSocialFeedInfo.E = ((ShareWebPageInfo)localObject);
      }
      NowLiveInfo.MixInfo localMixInfo;
      if (this.aA == 24)
      {
        localObject = new NowLiveInfo();
        localMixInfo = new NowLiveInfo.MixInfo();
        localMixInfo.a(new NowLiveInfo.MixInfo.AnchorInfo(getIntent().getLongExtra("arg_now_anchor_uin", 0L)));
        localMixInfo.a(new NowLiveInfo.MixInfo.LiveInfo(getIntent().getStringExtra("arg_now_live_vid")));
        ((NowLiveInfo)localObject).a(localMixInfo);
        this.ao.mSocialFeedInfo.F = ((NowLiveInfo)localObject);
      }
      l = this.ao.mSocialFeedInfo.c.a;
      if (this.ao.mSocialFeedInfo.n != null)
      {
        localBiuInfo.b = this.ao.mSocialFeedInfo.n.b;
        localBiuInfo.c = this.ao.mSocialFeedInfo.n.c;
        i = paramArrayList.size() - 1;
        while (i > 0)
        {
          BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)paramArrayList.get(i);
          localMixInfo = null;
          localObject = localMixInfo;
          if (localBiuCommentInfo.mFeedId.longValue() != 0L)
          {
            localObject = localMixInfo;
            if (localBiuCommentInfo.mOpType == 0)
            {
              Iterator localIterator = this.ao.mSocialFeedInfo.n.a.iterator();
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
            localObject = (BiuCommentInfo)paramArrayList.get(i);
          } else {
            ((BiuCommentInfo)localObject).mBiuComment = localBiuCommentInfo.mBiuComment;
          }
          localBiuInfo.a.add(localObject);
          i -= 1;
        }
      }
      i = paramArrayList.size() - 1;
      while (i > 0)
      {
        localBiuInfo.a.add(paramArrayList.get(i));
        i -= 1;
      }
    }
    else
    {
      i = paramArrayList.size() - 1;
      while (i > 0)
      {
        localBiuInfo.a.add(paramArrayList.get(i));
        i -= 1;
      }
      l = 0L;
    }
    if (this.be)
    {
      ReadInJoyLogicEngine.a().a(RIJQQAppInterfaceUtil.c(), this.bf, localBiuInfo, ((BiuCommentInfo)paramArrayList.get(0)).mBiuComment);
      return;
    }
    ReadInJoyLogicEngine.a().a(RIJQQAppInterfaceUtil.c(), this.ao.mFeedId, localBiuInfo, l, ((BiuCommentInfo)paramArrayList.get(0)).mBiuComment, this.ao.mArticleID, this.ao.mRecommendSeq, this.aA, this.ao.innerUniqueID, this.aq, this.ao, this.bc);
    paramArrayList = new StringBuilder();
    paramArrayList.append("mFeedId:");
    paramArrayList.append(this.ao.mFeedId);
    paramArrayList.append(" masterUin");
    paramArrayList.append(l);
    paramArrayList.append(", mArticleID:");
    paramArrayList.append(this.ao.mArticleID);
    paramArrayList.append(" mRecommendSeq: ");
    paramArrayList.append(this.ao.mRecommendSeq);
    paramArrayList.append(" biuSrc:");
    paramArrayList.append(this.aA);
    paramArrayList.append(" innerUniqueID");
    paramArrayList.append(this.ao.innerUniqueID);
    paramArrayList.append(" feedstype:");
    paramArrayList.append(this.aq);
    QLog.d("ReadInJoyDeliverBiuActivity", 2, paramArrayList.toString());
    this.aC = NetConnInfoCenter.getServerTimeMillis();
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
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.n == null) {
          return false;
        }
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.n.c.longValue() == 30L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    if (((!TextUtils.isEmpty(this.aB)) && (this.aA == 17)) || (this.aA == 24))
    {
      String str2 = paramIntent.getStringExtra("arg_title");
      Object localObject = paramIntent.getStringExtra("arg_src");
      String str1 = paramIntent.getStringExtra("arg_cover");
      paramIntent = str2;
      if (TextUtils.isEmpty(str2)) {
        paramIntent = this.ag;
      }
      this.ag = paramIntent;
      paramIntent = (Intent)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramIntent = this.ai;
      }
      this.ai = paramIntent;
      paramIntent = str1;
      if (TextUtils.isEmpty(str1)) {
        paramIntent = this.aj;
      }
      this.aj = paramIntent;
      if (this.ao == null)
      {
        this.ao = new BaseArticleInfo();
        this.ao.mSocialFeedInfo = new SocializeFeedsInfo();
      }
      localObject = this.at;
      str1 = this.ag;
      paramIntent = str1;
      if (str1 == null) {
        paramIntent = "";
      }
      ((TextView)localObject).setText(paramIntent);
      localObject = this.as;
      str1 = this.ai;
      paramIntent = str1;
      if (str1 == null) {
        paramIntent = "";
      }
      ((ReadInJoyNickNameTextView)localObject).setText(paramIntent);
      if (TextUtils.isEmpty(this.aj))
      {
        this.au.setVisibility(8);
        return;
      }
      try
      {
        paramIntent = new URL(this.aj);
        this.au.setImage(paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  private void b(ArrayList<Long> paramArrayList)
  {
    ThreadManager.post(new ReadInJoyDeliverBiuActivity.11(this, paramArrayList), 5, null, true);
  }
  
  private void c(@NotNull Intent paramIntent)
  {
    this.ak = paramIntent.getIntExtra("arg_type", -1);
    if (this.ak == -1)
    {
      this.ak = 1;
      if (((this.ao.mFeedType == 1) && (this.ao.mSocialFeedInfo != null) && (this.ao.mSocialFeedInfo.b == 5)) || (RIJFeedsType.a(this.ao)))
      {
        this.ak = 2;
        return;
      }
      if ((RIJItemViewTypeUtils.o(this.ao)) && (this.ao.mSocialFeedInfo.s != null))
      {
        if (c(this.ao.mSocialFeedInfo.s.a))
        {
          this.ak = 2;
          return;
        }
        this.ak = 1;
        return;
      }
      if (a(this.ao)) {
        this.ak = 5;
      }
    }
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 5) || (paramInt == 4) || (paramInt == 6);
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject3 = "";
    for (;;)
    {
      int j;
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(RIJAppSetting.b());
        ((JSONObject)localObject2).put("kandian_mode", ((StringBuilder)localObject1).toString());
        if (!this.bc) {
          break label372;
        }
        localObject1 = "1";
        ((JSONObject)localObject2).put("fast_biu", localObject1);
        localObject1 = this.ao;
        if ((localObject1 != null) && (RIJItemViewTypeUtils.o(this.ao)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(this.ao.mFeedId);
          ((JSONObject)localObject2).put("feeds_id", ((StringBuilder)localObject1).toString());
        }
        else
        {
          ((JSONObject)localObject2).put("feeds_id", "0");
        }
        localObject1 = getIntent().getExtras();
        j = 0;
        if ((localObject1 == null) || (!((Bundle)localObject1).containsKey("arg_forward"))) {
          break label380;
        }
        i = 1;
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        localJSONException.printStackTrace();
      }
      ((JSONObject)localObject2).put("outside", j);
      localObject1 = ((JSONObject)localObject2).toString();
      localObject3 = localObject1;
      long l = this.an;
      if (l < 0L) {
        str = "0";
      } else {
        str = String.valueOf(l);
      }
      Object localObject2 = this.ao;
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
      if (this.r) {
        i = 3;
      } else if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      if (this.bc) {
        i = 1;
      }
      PublicAccountReportUtils.a(null, "", "0X8007EE9", "0X8007EE9", 0, 0, String.valueOf(i), str, (String)localObject2, (String)localObject3, false);
      return;
      label372:
      String str = "0";
      continue;
      label380:
      int i = 0;
      if (i != 0) {
        j = 1;
      }
    }
  }
  
  private void f(boolean paramBoolean)
  {
    int i = this.am;
    if ((i == 18) || (i == 17))
    {
      if (this.am == 18)
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
        i = 1;
      } else {
        i = 11;
      }
      FastWebShareUtils.a((Context)localObject2, (String)localObject1, i, this.ao, this.ar);
      Object localObject1 = new ReportInfo();
      ((ReportInfo)localObject1).mUin = RIJQQAppInterfaceUtil.c();
      ((ReportInfo)localObject1).mSource = ((int)this.ao.mChannelID);
      ((ReportInfo)localObject1).mSourceArticleId = this.ao.mArticleID;
      ((ReportInfo)localObject1).mChannelId = ((int)this.ao.mChannelID);
      ((ReportInfo)localObject1).mAlgorithmId = ((int)this.ao.mAlgorithmID);
      ((ReportInfo)localObject1).mStrategyId = this.ao.mStrategyId;
      ((ReportInfo)localObject1).mServerContext = this.ao.mServerContext;
      ((ReportInfo)localObject1).mInnerId = this.ao.innerUniqueID;
      ((ReportInfo)localObject1).mOperation = 25;
      ((ReportInfo)localObject1).mOpSource = 12;
      ((ReportInfo)localObject1).mReadTimeLength = -1;
      localObject2 = new ArrayList();
      ((List)localObject2).add(localObject1);
      ReadInJoyLogicEngine.a().a((List)localObject2);
    }
  }
  
  private boolean g(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 2);
  }
  
  private void s()
  {
    this.bc = getIntent().getBooleanExtra("fast_biu_type", false);
    this.bd = getIntent().getBooleanExtra("should_show_dialog", true);
    this.be = getIntent().getBooleanExtra("is_modified_biu", false);
    this.bf = getIntent().getLongExtra("modified_feeds_id", 0L);
    this.Z = (this.bc ^ true);
  }
  
  private void t()
  {
    Object localObject = (RelativeLayout)findViewById(2131431340);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    localLayoutParams.addRule(11, -1);
    localLayoutParams.addRule(1, 2131435357);
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(0, 0);
    ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.au.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 0);
    ((RelativeLayout.LayoutParams)localObject).width = getResources().getDimensionPixelSize(2131299527);
    this.au.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.at.setMaxLines(1);
    this.as.setMaxLines(2);
  }
  
  private int u()
  {
    if ((this.j != null) && (this.j.getCurrentPanelView() != null)) {
      return this.j.getCurrentPanelView().getHeight();
    }
    return 0;
  }
  
  private void v()
  {
    if (this.bg != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("commonCommentData is not null mcover:");
      ((StringBuilder)localObject).append(this.aj);
      ((StringBuilder)localObject).append("video duration: ");
      ((StringBuilder)localObject).append(this.al);
      ((StringBuilder)localObject).append("msource : ");
      ((StringBuilder)localObject).append(this.ai);
      ((StringBuilder)localObject).append("mtitle");
      ((StringBuilder)localObject).append(this.ag);
      QLog.d("ReadInJoyDeliverBiuActivity", 2, ((StringBuilder)localObject).toString());
      if (!TextUtils.isEmpty(this.bg.getBiuSourceName()))
      {
        this.ai = this.bg.getBiuSourceName();
        localObject = new QQText(EmotionCodecUtils.c(new String(Base64Util.decode(this.ai, 0))), 7, 16);
        this.as.setVisibility(0);
        this.as.setText((CharSequence)localObject);
      }
      if (!TextUtils.isEmpty(this.bg.getBiuPicUrl()))
      {
        this.aj = this.bg.getBiuPicUrl();
        this.au.setVisibility(0);
        try
        {
          this.au.setImage(new URL(this.aj));
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
        }
      }
      if (this.bg.getBiuDuration() != -1L)
      {
        long l = this.bg.getBiuDuration();
        this.al = String.format("%02d:%02d", new Object[] { Long.valueOf(l / 60L), Long.valueOf(l % 60L) });
        if (l != 0L)
        {
          this.ax.setVisibility(0);
          this.ay.setText(this.al);
        }
      }
    }
  }
  
  private void w()
  {
    int i = this.ao.mSocialFeedInfo.s.a;
    if ((!RIJItemViewTypeUtils.x(this.ao)) && (c(i)))
    {
      this.aj = ((UGCVideoInfo)this.ao.mSocialFeedInfo.s.c.get(0)).d;
      return;
    }
    if ((!RIJItemViewTypeUtils.w(this.ao)) && (g(i)))
    {
      this.aj = ((UGCPicInfo)this.ao.mSocialFeedInfo.s.b.get(0)).e;
      return;
    }
    if (ReadInjoyFeedsUtils.a(this.ao))
    {
      this.aj = this.ao.mSocialFeedInfo.s.k.d;
      return;
    }
    if ((((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).isUgcAd(this.ao)) && (!TextUtils.isEmpty(((AdvertisementInfo)this.ao).mAdImg)))
    {
      this.aj = ((AdvertisementInfo)this.ao).mAdImg;
      return;
    }
    this.aj = null;
  }
  
  private void x()
  {
    if ((RIJItemViewTypeUtils.o(this.ao)) && (!RIJItemViewTypeUtils.v(this.ao))) {
      w();
    } else if ((RIJItemViewTypeUtils.s(this.ao)) && (!RIJItemViewTypeUtils.z(this.ao))) {
      this.aj = ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.ao.mSocialFeedInfo.v.g.get(0)).f;
    } else if ((RIJFeedsType.ac(this.ao) == 27) && (this.ao.mSocialFeedInfo.E != null)) {
      this.aj = this.ao.mSocialFeedInfo.E.c;
    } else {
      this.aj = this.ao.mFirstPagePicUrl;
    }
    if ((TextUtils.isEmpty(this.aj)) && (!a(this.ao)))
    {
      this.au.setVisibility(8);
    }
    else if (a(this.ao))
    {
      this.au.setVisibility(0);
      this.au.setImageDrawable(BaseApplication.getContext().getResources().getDrawable(2130851337));
    }
    else
    {
      try
      {
        URL localURL = new URL(this.aj);
        this.au.setImage(localURL);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    y();
  }
  
  private void y()
  {
    if (this.ak == 2)
    {
      long l2 = this.ao.mVideoDuration;
      long l1 = l2;
      if (RIJItemViewTypeUtils.o(this.ao))
      {
        l1 = l2;
        if (!RIJItemViewTypeUtils.x(this.ao)) {
          l1 = ((UGCVideoInfo)this.ao.mSocialFeedInfo.s.c.get(0)).g / 1000L;
        }
      }
      this.al = a(l1);
      if (l1 != 0L)
      {
        this.ax.setVisibility(0);
        this.ay.setText(this.al);
      }
    }
  }
  
  private void z()
  {
    long l;
    if (J())
    {
      l = this.ao.mSocialFeedInfo.s.e;
      if (l == 0L)
      {
        this.ai = this.ao.mSubscribeName;
        this.as.setText(this.ai);
        return;
      }
      this.as.setNickNameByUin(l);
      return;
    }
    if (C())
    {
      this.ai = ContactUtils.a((QQAppInterface)ReadInJoyUtils.b(), String.valueOf(this.ao.mSocialFeedInfo.v.c), true);
      if (!TextUtils.isEmpty(this.ai))
      {
        this.as.setText(this.ai);
        return;
      }
      this.as.setVisibility(8);
      return;
    }
    int i = this.ak;
    if (i == 4)
    {
      if (TextUtils.isEmpty(this.ao.mSummary)) {
        this.ai = HardCodeUtil.a(2131910348);
      } else {
        this.ai = this.ao.mSummary;
      }
      this.as.setText(this.ai);
      return;
    }
    if (i == 5)
    {
      l = this.ao.mSocialFeedInfo.s.e;
      if (l == 0L)
      {
        this.ai = this.ao.mSubscribeName;
        this.as.setText(this.ai);
        return;
      }
      this.as.setNickNameByUin(l);
      return;
    }
    if (E())
    {
      this.ai = this.ao.mSocialFeedInfo.E.d;
      this.as.setText(this.ai);
      return;
    }
    this.ai = this.ao.mSubscribeName;
    if (!TextUtils.isEmpty(this.ai))
    {
      this.as.setText(this.ai);
      return;
    }
    this.as.setVisibility(8);
  }
  
  public int a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("biu_src", 1);
    if (ReadInJoyHelper.b(this.ao)) {
      i = 100;
    }
    return i;
  }
  
  protected void a()
  {
    this.aI = ((RelativeLayout)findViewById(2131429571));
    this.E = 178;
    this.E = ViewUtils.dpToPx(this.E);
    this.C = new ReadInJoyDeliverBiuActivity.1(this);
    super.a();
    this.k.a(new ReadInJoyDeliverBiuActivity.2(this));
    this.ba = ViewUtils.getScreenHeight();
    Object localObject = (ViewGroup.MarginLayoutParams)this.j.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (this.ba * 8 / 100);
    this.j.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.as = ((ReadInJoyNickNameTextView)findViewById(2131447463));
    this.at = ((TextView)findViewById(2131439121));
    this.au = ((KandianUrlImageView)findViewById(2131435357));
    this.av = ((RelativeLayout)findViewById(2131440295));
    this.aw = ((TextView)findViewById(2131440301));
    this.ax = ((RelativeLayout)findViewById(2131449510));
    this.ay = ((TextView)findViewById(2131449537));
    getTitleBarView().setVisibility(8);
    this.aE = ((Button)findViewById(2131431725));
    if (this.be) {
      this.aE.setText(getString(2131895248));
    }
    this.aE.setOnClickListener(new ReadInJoyDeliverBiuActivity.3(this));
    if (this.i != null)
    {
      localObject = this.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.u);
      ((TextView)localObject).setText(localStringBuilder.toString());
      this.i.setTextColor(-4473925);
    }
    this.aG = ((ImageView)findViewById(2131430806));
    this.aG.setOnClickListener(new ReadInJoyDeliverBiuActivity.4(this));
    this.aF = findViewById(2131431035);
    this.aF.setOnClickListener(new ReadInJoyDeliverBiuActivity.5(this));
    this.aH = findViewById(2131445137);
    this.aJ = ((RelativeLayout)findViewById(2131447716));
    this.aK = ((RelativeLayout)findViewById(2131429569));
    this.aL = ((ImageView)findViewById(2131429564));
    this.aL.setRotation(-30.0F);
    this.aM = ((ImageView)findViewById(2131439702));
    this.aN = ((ImageView)findViewById(2131439704));
    this.aN.setRotation(30.0F);
    this.aO = ((ImageView)findViewById(2131439705));
    this.aP = ((FixSizeImageView)findViewById(2131433198));
    this.aQ = ((FixSizeImageView)findViewById(2131445474));
    this.aR = ((FixSizeImageView)findViewById(2131428988));
    this.aS = ((ImageView)findViewById(2131429572));
    this.aT = ((RelativeLayout)findViewById(2131429566));
    localObject = AnimationUtils.loadAnimation(this, 2130772298);
    this.aH.startAnimation((Animation)localObject);
    localObject = AnimationUtils.loadAnimation(this, 2130772299);
    this.aF.startAnimation((Animation)localObject);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverBiuActivity.6(this), 250L);
    if (getIntent().getIntExtra("arg_type", -1) == 4) {
      t();
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
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.init();
        this.mSystemBarComp.setStatusBarColor(-872415232);
        return;
      }
      this.mSystemBarComp.init();
      if (!SystemUtil.g())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
        return;
      }
      this.mSystemBarComp.setStatusBarColor(-872415232);
      this.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  protected void b()
  {
    super.b();
    this.ad = "0X800865F";
    this.au.setImagePlaceHolder(getResources().getDrawable(2130851376));
    Intent localIntent = getIntent();
    boolean bool = false;
    this.am = localIntent.getIntExtra("arg_from_type", 0);
    this.ar = localIntent.getIntExtra("arg_biu_state", -1);
    this.ao = ((AbsBaseArticleInfo)localIntent.getParcelableExtra("arg_article_info"));
    this.ap = localIntent.getStringExtra("arg_nickname");
    this.aA = a(localIntent);
    this.aB = localIntent.getStringExtra("biu_rowkey");
    this.aq = localIntent.getIntExtra("feedsType", 1);
    this.bg = ((CommonCommentData)localIntent.getSerializableExtra("arg_common_comment_info"));
    if (this.bc) {
      findViewById(2131431044).setVisibility(8);
    }
    if (this.ao != null)
    {
      c(localIntent);
      this.an = this.ao.mArticleID;
      B();
      K();
      A();
      z();
      x();
      v();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mcover:");
      localStringBuilder.append(this.aj);
      localStringBuilder.append("video duration: ");
      localStringBuilder.append(this.al);
      localStringBuilder.append("msource : ");
      localStringBuilder.append(this.ai);
      localStringBuilder.append("mtitle : ");
      localStringBuilder.append(this.ag);
      QLog.d("ReadInJoyDeliverBiuActivity", 2, localStringBuilder.toString());
    }
    b(localIntent);
    if (ArticleInfoHelper.a(this.ao))
    {
      this.ag = this.ao.mSocialFeedInfo.D;
      this.at.setText(this.ag);
      this.au.setVisibility(8);
      this.ax.setVisibility(8);
    }
    if (ReadInJoyHelper.I(this.app) == 0) {
      bool = true;
    }
    this.y = bool;
    if ((!this.y) && (this.g != null)) {
      this.g.setVisibility(8);
    }
    G();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.d);
    if (this.bc) {
      c();
    }
  }
  
  protected void b(int paramInt)
  {
    this.af = this.p;
    d(0);
    super.a(true, paramInt, false, 0L);
  }
  
  protected boolean c()
  {
    if (!H()) {
      return false;
    }
    if (this.bd) {
      f(2131892958);
    }
    this.bd = true;
    ArrayList localArrayList = new ArrayList();
    boolean bool = Utils.a(this.e, this.app.getCurrentAccountUin(), this.S, true, localArrayList);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDeliver deliverList:\n");
    ((StringBuilder)localObject).append(localArrayList.toString());
    QLog.d("biu_data_trace", 2, ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(this.aB)) && (this.aA == 17))
    {
      ReadInJoyLogicEngine.a().a(RIJQQAppInterfaceUtil.c(), this.aB, this.aA, ((BiuCommentInfo)localArrayList.get(0)).mBiuComment, localArrayList, this.bc);
    }
    else if (this.am == 21)
    {
      localObject = new AccountProfileInfo();
      ((AccountProfileInfo)localObject).e = this.ao.mSummary;
      ((AccountProfileInfo)localObject).a = getIntent().getLongExtra("arg_account_id", -1L);
      ((AccountProfileInfo)localObject).b = getIntent().getIntExtra("arg_account_type", -1);
      ((AccountProfileInfo)localObject).d = this.ao.mFirstPagePicUrl;
      ((AccountProfileInfo)localObject).c = this.ao.mSubscribeName;
      ReadInJoyLogicEngine.a().a(this.app.getCurrentUin(), this.am, k(), localArrayList, (AccountProfileInfo)localObject);
    }
    else if ((this.ao != null) && (!localArrayList.isEmpty()))
    {
      a(localArrayList);
    }
    e(bool);
    return true;
  }
  
  protected void d()
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
    PublicAccountReportUtils.a(null, "", "0X8007EE8", "0X8007EE8", 0, 0, "", "", "", str, false);
    super.d();
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
    super.setContentView(2131626219);
    RIJDtReportHelper.a.a(getActivity());
    addObserver(this.bh);
    s();
    a(2131915333);
    a();
    b();
    if (this.bc) {
      return true;
    }
    RIJUserProtoUtils.INSTANCE.check(this, null);
    try
    {
      paramBundle = new JSONObject();
      paramBundle.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(RIJAppSetting.b());
      paramBundle.put("kandian_mode", ((StringBuilder)localObject1).toString());
      localObject1 = this.ao;
      if ((localObject1 != null) && (RIJItemViewTypeUtils.o(this.ao)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(this.ao.mFeedId);
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
    long l = this.an;
    if (l < 0L) {
      paramBundle = "0";
    } else {
      paramBundle = String.valueOf(l);
    }
    Object localObject1 = this.ao;
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
    PublicAccountReportUtils.a(null, "", "0X8007EE7", "0X8007EE7", 0, 0, String.valueOf(this.am), paramBundle, (String)localObject1, (String)localObject2, false);
    a(getIntent().getExtras());
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.bh);
    Object localObject = this.b;
    if (localObject != null) {
      ((AnimatorSet)localObject).cancel();
    }
    localObject = this.c;
    if (localObject != null) {
      super.removeObserver(((IPublicAccountObserver)localObject).getBusinessObserver());
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(this.d);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (isInMultiWindow())
    {
      QQToast.makeText(this, HardCodeUtil.a(2131910497), 0).show();
      finish();
    }
  }
  
  public void finish()
  {
    if (this.j != null) {
      this.j.b();
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130772300);
    localAnimation.setFillAfter(true);
    this.aH.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(this, 2130772301);
    localAnimation.setFillAfter(true);
    this.aF.startAnimation(localAnimation);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyDeliverBiuActivity.8(this), 300L);
  }
  
  protected boolean onBackEvent()
  {
    if ((this.r) && ((!this.v) || (this.x != -1)))
    {
      b(this.aX);
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity
 * JD-Core Version:    0.7.0.1
 */