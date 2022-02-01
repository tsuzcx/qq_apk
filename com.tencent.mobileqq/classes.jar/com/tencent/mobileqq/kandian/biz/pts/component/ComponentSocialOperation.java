package com.tencent.mobileqq.kandian.biz.pts.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentSocialOperation
  extends FrameLayout
  implements View.OnClickListener, ComponentView
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  ScaleAnimation jdField_a_of_type_AndroidViewAnimationScaleAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  SocializeFeedsInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  ScaleAnimation jdField_b_of_type_AndroidViewAnimationScaleAnimation;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  int jdField_c_of_type_Int = 0;
  ScaleAnimation jdField_c_of_type_AndroidViewAnimationScaleAnimation;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public ComponentSocialOperation(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentSocialOperation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentSocialOperation(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt < 10000) {
      return String.valueOf(paramInt);
    }
    if (paramInt < 100000000)
    {
      paramInt /= 10000;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append(HardCodeUtil.a(2131702469));
      return localStringBuilder.toString();
    }
    paramInt /= 100000000;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(HardCodeUtil.a(2131702435));
    return localStringBuilder.toString();
  }
  
  private void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, ReportInfo paramReportInfo)
  {
    FeedsReportData localFeedsReportData = new FeedsReportData();
    paramReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
    paramReportInfo.mSource = 0;
    paramReportInfo.mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
    paramReportInfo.mChannelId = ((int)paramAbsBaseArticleInfo.mChannelID);
    paramReportInfo.mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
    paramReportInfo.mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
    paramReportInfo.mServerContext = paramAbsBaseArticleInfo.mServerContext;
    paramReportInfo.mReadTimeLength = -1;
    localFeedsReportData.jdField_a_of_type_Long = paramSocializeFeedsInfo.jdField_a_of_type_Long;
    if (paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
      localFeedsReportData.jdField_b_of_type_Long = paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
    }
    localFeedsReportData.jdField_a_of_type_Int = paramSocializeFeedsInfo.jdField_b_of_type_Int;
    localFeedsReportData.jdField_b_of_type_Int = paramSocializeFeedsInfo.d;
    paramAbsBaseArticleInfo = paramSocializeFeedsInfo.jdField_a_of_type_JavaUtilList;
    if ((paramAbsBaseArticleInfo != null) && (!paramAbsBaseArticleInfo.isEmpty()))
    {
      localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.iterator();
      while (paramAbsBaseArticleInfo.hasNext())
      {
        paramSocializeFeedsInfo = (FeedsInfoUser)paramAbsBaseArticleInfo.next();
        if (paramSocializeFeedsInfo != null) {
          localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(paramSocializeFeedsInfo.jdField_a_of_type_Long));
        }
      }
    }
    paramReportInfo.mFeedsReportData = localFeedsReportData;
    paramAbsBaseArticleInfo = new ArrayList();
    paramAbsBaseArticleInfo.add(paramReportInfo);
    ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo);
  }
  
  private void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, String paramString, ReportInfo paramReportInfo)
  {
    String str;
    if (ReadinjoyReportUtils.a(paramAbsBaseArticleInfo.mChannelID)) {
      str = "0X8009361";
    } else {
      str = "0X8007EE4";
    }
    Object localObject1 = getContext();
    Object localObject2;
    if ((localObject1 instanceof Activity))
    {
      localObject1 = (Activity)localObject1;
      localObject2 = new Intent((Context)localObject1, ReadInJoyDeliverBiuActivity.class);
      ((Intent)localObject2).putExtra("arg_article_info", paramAbsBaseArticleInfo);
      ((Intent)localObject2).putExtra("feedsType", paramAbsBaseArticleInfo.mFeedType);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c() == 70)
      {
        ((Intent)localObject2).putExtra("biu_src", 9);
        ((Intent)localObject2).putExtra("arg_from_type", 14);
      }
      else
      {
        ((Intent)localObject2).putExtra("biu_src", 1);
        ((Intent)localObject2).putExtra("arg_from_type", 1);
      }
      ((Activity)localObject1).startActivity((Intent)localObject2);
      ((Activity)localObject1).overridePendingTransition(0, 0);
    }
    long l1;
    long l2;
    if (a(paramAbsBaseArticleInfo))
    {
      if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
      {
        localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        l1 = paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
        l2 = paramSocializeFeedsInfo.jdField_a_of_type_Long;
        paramSocializeFeedsInfo = new StringBuilder();
        paramSocializeFeedsInfo.append("");
        paramSocializeFeedsInfo.append(paramAbsBaseArticleInfo.mStrategyId);
        ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEvent(null, String.valueOf(l1), str, str, 0, 0, String.valueOf(l2), "0", paramSocializeFeedsInfo.toString(), paramString, false);
      }
      RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
    }
    else
    {
      try
      {
        localObject1 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject2 = paramAbsBaseArticleInfo.mSubscribeID;
        l1 = paramSocializeFeedsInfo.jdField_a_of_type_Long;
        l2 = paramAbsBaseArticleInfo.mArticleID;
        paramSocializeFeedsInfo = new StringBuilder();
        paramSocializeFeedsInfo.append("");
        paramSocializeFeedsInfo.append(paramAbsBaseArticleInfo.mStrategyId);
        ((IPublicAccountReportUtils)localObject1).publicAccountReportClickEvent(null, (String)localObject2, str, str, 0, 0, String.valueOf(l1), String.valueOf(l2), paramSocializeFeedsInfo.toString(), paramString, false);
      }
      catch (Throwable paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
    paramReportInfo.mOperation = 25;
  }
  
  private boolean a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) || (RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo));
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  private void b(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, String paramString, ReportInfo paramReportInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void c(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, String paramString, ReportInfo paramReportInfo)
  {
    String str1;
    if (ReadinjoyReportUtils.a(paramAbsBaseArticleInfo.mChannelID)) {
      str1 = "0X8009360";
    } else {
      str1 = "0X8007B67";
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    long l1;
    long l2;
    if (a(paramAbsBaseArticleInfo))
    {
      if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo)) {
        try
        {
          localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
          l1 = paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo.jdField_a_of_type_Long;
          l2 = paramSocializeFeedsInfo.jdField_a_of_type_Long;
          paramSocializeFeedsInfo = new StringBuilder();
          paramSocializeFeedsInfo.append("");
          paramSocializeFeedsInfo.append(paramAbsBaseArticleInfo.mStrategyId);
          localIPublicAccountReportUtils.publicAccountReportClickEvent(null, String.valueOf(l1), str1, str1, 0, 0, String.valueOf(l2), "0", paramSocializeFeedsInfo.toString(), paramString, false);
        }
        catch (Throwable paramSocializeFeedsInfo)
        {
          paramSocializeFeedsInfo.printStackTrace();
        }
      }
      RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.c());
    }
    else
    {
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      String str2 = paramAbsBaseArticleInfo.mSubscribeID;
      l1 = paramSocializeFeedsInfo.jdField_a_of_type_Long;
      l2 = paramAbsBaseArticleInfo.mArticleID;
      paramSocializeFeedsInfo = new StringBuilder();
      paramSocializeFeedsInfo.append("");
      paramSocializeFeedsInfo.append(paramAbsBaseArticleInfo.mStrategyId);
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, str1, str1, 0, 0, String.valueOf(l1), String.valueOf(l2), paramSocializeFeedsInfo.toString(), paramString, false);
    }
    paramReportInfo.mOperation = 3;
    if (RIJItemViewTypeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()))
    {
      RIJJumpUtils.a(getContext(), paramAbsBaseArticleInfo, 1, true, 0, true);
      return;
    }
    RIJJumpUtils.a(getContext(), paramAbsBaseArticleInfo, true);
  }
  
  @VisibleForTesting
  @NotNull
  String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
        boolean bool = RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo);
        if (bool) {
          localJSONObject.put("feeds_source", paramAbsBaseArticleInfo.mSubscribeID);
        } else {
          localJSONObject.put("feeds_source", paramSocializeFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long);
        }
        localJSONObject.put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
        paramSocializeFeedsInfo = new StringBuilder();
        paramSocializeFeedsInfo.append("");
        paramSocializeFeedsInfo.append(RIJFeedsType.a(paramAbsBaseArticleInfo));
        localJSONObject.put("feeds_type", paramSocializeFeedsInfo.toString());
        paramSocializeFeedsInfo = new StringBuilder();
        paramSocializeFeedsInfo.append("");
        paramSocializeFeedsInfo.append(RIJAppSetting.a());
        localJSONObject.put("kandian_mode", paramSocializeFeedsInfo.toString());
        paramSocializeFeedsInfo = new StringBuilder();
        paramSocializeFeedsInfo.append("");
        paramSocializeFeedsInfo.append(RIJTransMergeKanDianReport.a());
        localJSONObject.put("tab_source", paramSocializeFeedsInfo.toString());
        paramSocializeFeedsInfo = new StringBuilder();
        paramSocializeFeedsInfo.append("");
        paramSocializeFeedsInfo.append(paramAbsBaseArticleInfo.mChannelID);
        localJSONObject.put("channel_id", paramSocializeFeedsInfo.toString());
        paramSocializeFeedsInfo = new StringBuilder();
        paramSocializeFeedsInfo.append("");
        paramSocializeFeedsInfo.append(paramAbsBaseArticleInfo.mAlgorithmID);
        localJSONObject.put("algorithm_id", paramSocializeFeedsInfo.toString());
        if (paramAbsBaseArticleInfo.isPGCShortContent())
        {
          paramAbsBaseArticleInfo = "1";
          localJSONObject.put("content_source", paramAbsBaseArticleInfo);
          paramAbsBaseArticleInfo = localJSONObject.toString();
          return paramAbsBaseArticleInfo;
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.e("ComponentSocialOperation", 1, QLog.getStackTraceString(paramAbsBaseArticleInfo));
        return "";
      }
      paramAbsBaseArticleInfo = "0";
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560152, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131364986));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131380280));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131380279));
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131380278);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131363659));
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, 1.8F, 1.0F, 1.8F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.8F, 0.85F, 1.8F, 0.85F, 1, 0.5F, 1, 0.5F);
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(0.85F, 1.0F, 0.85F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setDuration(200L);
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new ComponentSocialOperation.1(this));
    this.jdField_b_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new ComponentSocialOperation.2(this));
    this.jdField_c_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new ComponentSocialOperation.3(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramObject);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramObject.a();
      paramObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (paramObject == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo = paramObject.mSocialFeedInfo;
      paramObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo;
      if (paramObject != null)
      {
        this.jdField_a_of_type_Int = paramObject.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo.d;
        int i = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo.jdField_c_of_type_Int;
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        this.jdField_a_of_type_Boolean = bool;
        this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo.f;
      }
      a(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationScaleAnimation);
    }
    else
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846610);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#07D0B0"));
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846613);
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      }
      i = this.jdField_a_of_type_Int;
      if (i > 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(a(i));
      } else {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131718091);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set upvote to ");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        localStringBuilder.append(", set num:");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.d("ComponentSocialOperation", 2, localStringBuilder.toString());
      }
    }
    int i = this.jdField_b_of_type_Int;
    if (i > 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(i));
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717790);
    }
    i = this.jdField_c_of_type_Int;
    if (i > 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(i));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText("Biu");
  }
  
  public void onClick(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    SocializeFeedsInfo localSocializeFeedsInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntitySocializeFeedsInfo;
    if (localAbsBaseArticleInfo != null)
    {
      if (localSocializeFeedsInfo == null) {
        return;
      }
      String str = a(localAbsBaseArticleInfo, localSocializeFeedsInfo);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onclick v:");
        ((StringBuilder)localObject).append(paramView.getId());
        QLog.d("ComponentSocialOperation", 2, ((StringBuilder)localObject).toString());
      }
      RIJJumpUtils.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = localAbsBaseArticleInfo;
      Object localObject = new ReportInfo();
      if (paramView.getId() == 2131364986) {
        c(localAbsBaseArticleInfo, localSocializeFeedsInfo, str, (ReportInfo)localObject);
      } else if (paramView.getId() == 2131380278) {
        b(localAbsBaseArticleInfo, localSocializeFeedsInfo, str, (ReportInfo)localObject);
      } else if (paramView.getId() == 2131363659) {
        a(localAbsBaseArticleInfo, localSocializeFeedsInfo, str, (ReportInfo)localObject);
      }
      a(localAbsBaseArticleInfo, localSocializeFeedsInfo, (ReportInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentSocialOperation
 * JD-Core Version:    0.7.0.1
 */