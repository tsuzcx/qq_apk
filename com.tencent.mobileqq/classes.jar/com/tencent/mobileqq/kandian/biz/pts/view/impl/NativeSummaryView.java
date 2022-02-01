package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyToSelf;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.glue.text.UserSpan;
import com.tencent.mobileqq.kandian.repo.account.ArticleInfoHelper;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.db.struct.SocializeFeedsInfoUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleViewModel;
import com.tencent.mobileqq.kandian.repo.feeds.entity.Observable;
import com.tencent.mobileqq.kandian.repo.feeds.entity.Observer;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@IgnoreDenyDependencyToSelf
public class NativeSummaryView
  extends ReadInJoyYAFolderTextView
  implements IView, Observer<CharSequence>
{
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
  private Observable<CharSequence> jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable;
  
  public NativeSummaryView(Context paramContext)
  {
    super(paramContext);
  }
  
  private static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, SpannableStringBuilder paramSpannableStringBuilder, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    String str = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_JavaLangString;
    if (RIJFeedsType.a(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo))
    {
      a(paramAbsBaseArticleInfo, paramSpannableStringBuilder, paramRefreshUserInfoCallBack);
      return 4;
    }
    if ((CmpCtxt.c(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo))) {
      return 5;
    }
    if (!TextUtils.isEmpty(str))
    {
      a(str, paramSpannableStringBuilder);
      return 6;
    }
    return 0;
  }
  
  private static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder, boolean paramBoolean)
  {
    int i = RIJBaseItemViewType.a(paramAbsBaseArticleInfo);
    if (paramIReadInJoyModel.a().isPGCShortContent())
    {
      a(paramAbsBaseArticleInfo, paramSpannableStringBuilder);
      return 7;
    }
    if ((35 != i) && (34 != i))
    {
      if (paramBoolean)
      {
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSummary)) {
          paramIReadInJoyModel = paramAbsBaseArticleInfo.mSummary;
        } else {
          paramIReadInJoyModel = "";
        }
        if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mTitle)) {
          paramIReadInJoyModel = paramAbsBaseArticleInfo.mTitle;
        }
        paramSpannableStringBuilder.append(paramIReadInJoyModel);
        return 2;
      }
      a(paramAbsBaseArticleInfo, paramSpannableStringBuilder, paramIReadInJoyModel);
      return 3;
    }
    b(paramAbsBaseArticleInfo, paramSpannableStringBuilder);
    return 1;
  }
  
  private static String a(@NotNull IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel.d() == 33) {
      return HardCodeUtil.a(2131707115);
    }
    if ((!CmpCtxt.e(paramIReadInJoyModel)) && (!CmpCtxt.g(paramIReadInJoyModel)) && (!CmpCtxt.h(paramIReadInJoyModel)))
    {
      if ((!CmpCtxt.f(paramIReadInJoyModel)) && (!CmpCtxt.i(paramIReadInJoyModel)))
      {
        if (CmpCtxt.a(paramIReadInJoyModel)) {
          return HardCodeUtil.a(2131707112);
        }
        return HardCodeUtil.a(2131707110);
      }
      return HardCodeUtil.a(2131707111);
    }
    return HardCodeUtil.a(2131707113);
  }
  
  public static void a(int paramInt, IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = paramIReadInJoyModel.a();
    if (!RIJItemViewTypeUtils.h((AbsBaseArticleInfo)localObject)) {
      localSpannableStringBuilder.append("@");
    }
    long l1;
    if ((!RIJItemViewTypeUtils.c((AbsBaseArticleInfo)localObject)) && (!RIJItemViewTypeUtils.s((AbsBaseArticleInfo)localObject)) && (!RIJItemViewTypeUtils.a(paramIReadInJoyModel.d())) && (!RIJItemViewTypeUtils.h((AbsBaseArticleInfo)localObject)))
    {
      if ((RIJItemViewTypeUtils.e((AbsBaseArticleInfo)localObject)) && (RIJItemViewTypeUtils.l((AbsBaseArticleInfo)localObject)))
      {
        l1 = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
        paramRefreshUserInfoCallBack = ReadInJoyUserInfoModule.a(l1, paramRefreshUserInfoCallBack);
        if (paramRefreshUserInfoCallBack != null) {
          paramRefreshUserInfoCallBack = paramRefreshUserInfoCallBack.nick;
        } else {
          paramRefreshUserInfoCallBack = ReadInJoyUserInfoModule.a();
        }
        if (!TextUtils.isEmpty(paramRefreshUserInfoCallBack))
        {
          localSpannableStringBuilder.append(RIJStringUtils.a(paramRefreshUserInfoCallBack));
          localSpannableStringBuilder.setSpan(new UserSpan(l1, "2", paramIReadInJoyModel.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
        }
        if (RIJFeedsType.x((AbsBaseArticleInfo)localObject)) {
          localSpannableStringBuilder.append(" 回答了");
        }
        localSpannableStringBuilder.append(": ");
      }
    }
    else
    {
      paramRefreshUserInfoCallBack = paramIReadInJoyModel.a().mSubscribeName;
      int i = paramIReadInJoyModel.d();
      l1 = 0L;
      long l2;
      if ((i == 33) && (paramIReadInJoyModel.a().mSocialFeedInfo != null) && (paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo != null))
      {
        if (paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.b == 0L)
        {
          localObject = paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.jdField_a_of_type_JavaLangString;
        }
        else
        {
          localObject = String.valueOf(paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.b);
          if (RIJQQAppInterfaceUtil.a()) {
            paramRefreshUserInfoCallBack = ContactUtils.a((QQAppInterface)ReadInJoyUtils.a(), (String)localObject, true);
          } else {
            paramRefreshUserInfoCallBack = ((ReadInJoyBaseAdapter)paramIReadInJoyModel.a()).a(paramIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.b);
          }
        }
        localSpannableStringBuilder.append(paramRefreshUserInfoCallBack);
        try
        {
          l2 = Long.valueOf((String)localObject).longValue();
          l1 = l2;
        }
        catch (NumberFormatException paramRefreshUserInfoCallBack)
        {
          paramRefreshUserInfoCallBack.printStackTrace();
        }
        localSpannableStringBuilder.setSpan(new UserSpan(l1, "2", paramIReadInJoyModel.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
      }
      else if (paramIReadInJoyModel.a().mAccountLess == 0)
      {
        localObject = paramIReadInJoyModel.a().mSubscribeID;
        try
        {
          l2 = Long.valueOf((String)localObject).longValue();
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
        localSpannableStringBuilder.append(paramRefreshUserInfoCallBack);
        localSpannableStringBuilder.setSpan(new UserSpan(l1, "2", paramIReadInJoyModel.a(), paramInt), 0, localSpannableStringBuilder.length(), 33);
      }
      else
      {
        localSpannableStringBuilder.append(paramRefreshUserInfoCallBack);
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, localSpannableStringBuilder.length(), 33);
      }
      localSpannableStringBuilder.append(": ");
    }
    paramSpannableStringBuilder.append(new SpannableStringBuilder(new QQText(localSpannableStringBuilder, 3, 16)));
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mTitle)) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mTitle;
    } else if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSummary)) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSummary;
    } else {
      paramAbsBaseArticleInfo = "";
    }
    paramSpannableStringBuilder.append(paramAbsBaseArticleInfo);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!paramAbsBaseArticleInfo.isPGCShortContent()) {
      setSpanText(HardCodeUtil.a(2131707114));
    }
    setMaxLines(a(paramAbsBaseArticleInfo));
    setMoreSpan(new NativeSummaryView.MoreSpan(this, paramAbsBaseArticleInfo, this.jdField_a_of_type_Int));
    if ((RIJFeedsType.s(paramAbsBaseArticleInfo)) || (RIJFeedsType.t(paramAbsBaseArticleInfo)))
    {
      setSpanText("");
      setMoreSpan(null);
    }
    setCustomViewLinkTextColor(this.jdField_a_of_type_Int);
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    if ((RIJFeedsType.j(paramAbsBaseArticleInfo)) || (RIJFeedsType.k(paramAbsBaseArticleInfo)))
    {
      RIJJumpUtils.a(paramContext, paramAbsBaseArticleInfo, 1, false, 4, false);
      RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
      RIJFrameworkReportManager.c(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
    }
  }
  
  private static void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_JavaLangString))) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_JavaLangString;
    } else if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mTitle))) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mTitle;
    } else {
      paramAbsBaseArticleInfo = "";
    }
    paramSpannableStringBuilder.append(paramAbsBaseArticleInfo);
  }
  
  private static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, SpannableStringBuilder paramSpannableStringBuilder, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    paramAbsBaseArticleInfo = SocializeFeedsInfoUtils.a(paramAbsBaseArticleInfo, "2", paramRefreshUserInfoCallBack, paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a);
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
      paramSpannableStringBuilder.append(paramAbsBaseArticleInfo);
    }
  }
  
  private static void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull IReadInJoyModel paramIReadInJoyModel)
  {
    Object localObject1 = paramIReadInJoyModel.a().mSummary;
    if ((CmpCtxt.f(paramIReadInJoyModel)) || (CmpCtxt.i(paramIReadInJoyModel))) {
      localObject1 = paramIReadInJoyModel.a().mTitle;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = a(paramIReadInJoyModel);
    }
    paramSpannableStringBuilder.append((CharSequence)localObject2);
    if ((paramIReadInJoyModel.d() == 33) && (!RIJItemViewTypeUtils.z(paramAbsBaseArticleInfo)))
    {
      paramIReadInJoyModel = (TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0);
      localObject1 = paramSpannableStringBuilder.append("“");
      boolean bool = TextUtils.isEmpty(paramIReadInJoyModel.c);
      paramSpannableStringBuilder = "";
      if (bool) {
        paramAbsBaseArticleInfo = "";
      } else {
        paramAbsBaseArticleInfo = paramIReadInJoyModel.c;
      }
      localObject1 = ((SpannableStringBuilder)localObject1).append(paramAbsBaseArticleInfo);
      if (TextUtils.isEmpty(paramIReadInJoyModel.jdField_a_of_type_JavaLangString)) {
        paramAbsBaseArticleInfo = paramSpannableStringBuilder;
      } else {
        paramAbsBaseArticleInfo = paramIReadInJoyModel.jdField_a_of_type_JavaLangString;
      }
      ((SpannableStringBuilder)localObject1).append(paramAbsBaseArticleInfo).append("”");
    }
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel.a() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable = paramIReadInJoyModel.a().articleViewModel.b();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable.a(this);
    setText((CharSequence)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable.a());
    a(paramIReadInJoyModel.a());
  }
  
  public static void a(IReadInJoyModel paramIReadInJoyModel, SpannableStringBuilder paramSpannableStringBuilder, IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.a();
    if (ArticleInfoHelper.a(localAbsBaseArticleInfo))
    {
      paramSpannableStringBuilder.append(localAbsBaseArticleInfo.mSocialFeedInfo.e);
      return;
    }
    boolean bool = a(paramIReadInJoyModel);
    if (RIJItemViewTypeUtils.h(localAbsBaseArticleInfo))
    {
      a(paramSpannableStringBuilder, localAbsBaseArticleInfo);
    }
    else
    {
      if ((RIJItemViewTypeUtils.c(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.s(localAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.a(paramIReadInJoyModel.d()))) {
        break label116;
      }
      if ((RIJItemViewTypeUtils.e(localAbsBaseArticleInfo)) && (RIJItemViewTypeUtils.l(localAbsBaseArticleInfo)))
      {
        i = a(localAbsBaseArticleInfo, paramSpannableStringBuilder, paramRefreshUserInfoCallBack);
        break label126;
      }
    }
    int i = 0;
    break label126;
    label116:
    i = a(localAbsBaseArticleInfo, paramIReadInJoyModel, paramSpannableStringBuilder, bool);
    label126:
    paramIReadInJoyModel = new StringBuilder();
    paramIReadInJoyModel.append("addComment: ");
    paramIReadInJoyModel.append(localAbsBaseArticleInfo.rawkey);
    paramIReadInJoyModel.append(" ssb: ");
    paramIReadInJoyModel.append(paramSpannableStringBuilder);
    paramIReadInJoyModel.append(" condition flag: ");
    paramIReadInJoyModel.append(i);
    QLog.d("NativeSummaryView", 2, paramIReadInJoyModel.toString());
  }
  
  private static void a(String paramString, SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(new QQText(EmotionCodecUtils.b(paramString), 3, 16));
  }
  
  private static boolean a(IReadInJoyModel paramIReadInJoyModel)
  {
    boolean bool = false;
    if (paramIReadInJoyModel != null)
    {
      int i = paramIReadInJoyModel.d();
      if ((i != 27) && (i != 28) && (i != 49) && (i != 62) && (i != 63)) {
        return false;
      }
      bool = true;
    }
    return bool;
  }
  
  private static void b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull SpannableStringBuilder paramSpannableStringBuilder)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_JavaLangString != null))
    {
      localSpannableStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Comment String: ");
        localStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.jdField_a_of_type_JavaLangString);
        QLog.d("Q.readinjoy.ui", 2, localStringBuilder.toString());
      }
    }
    else if (paramAbsBaseArticleInfo.mTitle != null)
    {
      localSpannableStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
    }
    paramSpannableStringBuilder.append(localSpannableStringBuilder);
  }
  
  public void a(Observable<CharSequence> paramObservable)
  {
    paramObservable = (CharSequence)paramObservable.a();
    ThreadManager.getUIHandler().post(new NativeSummaryView.1(this, paramObservable));
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Observable localObservable = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable;
    if (localObservable != null) {
      localObservable.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    Observable localObservable = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable;
    if (localObservable != null) {
      localObservable.b(this);
    }
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramIReadInJoyModel);
    setShouldCallClick(false);
    int i = paramIReadInJoyModel.d();
    if ((i == 49) || (i == 62) || (i == 63)) {
      setShouldCallClick(true);
    }
    a(paramIReadInJoyModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeSummaryView
 * JD-Core Version:    0.7.0.1
 */