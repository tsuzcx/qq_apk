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
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
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
  CmpCtxt a;
  TextView b;
  TextView c;
  TextView d;
  ImageView e;
  View f;
  SocializeFeedsInfo g;
  AbsBaseArticleInfo h;
  boolean i = false;
  int j = 0;
  int k = 0;
  int l = 0;
  ScaleAnimation m;
  ScaleAnimation n;
  ScaleAnimation o;
  
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
      localStringBuilder.append(HardCodeUtil.a(2131900471));
      return localStringBuilder.toString();
    }
    paramInt /= 100000000;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(HardCodeUtil.a(2131900438));
    return localStringBuilder.toString();
  }
  
  private void a(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, @NotNull SocializeFeedsInfo paramSocializeFeedsInfo, ReportInfo paramReportInfo)
  {
    FeedsReportData localFeedsReportData = new FeedsReportData();
    paramReportInfo.mUin = RIJQQAppInterfaceUtil.c();
    paramReportInfo.mSource = 0;
    paramReportInfo.mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
    paramReportInfo.mChannelId = ((int)paramAbsBaseArticleInfo.mChannelID);
    paramReportInfo.mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
    paramReportInfo.mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
    paramReportInfo.mServerContext = paramAbsBaseArticleInfo.mServerContext;
    paramReportInfo.mReadTimeLength = -1;
    localFeedsReportData.a = paramSocializeFeedsInfo.a;
    if (paramSocializeFeedsInfo.c != null) {
      localFeedsReportData.b = paramSocializeFeedsInfo.c.a;
    }
    localFeedsReportData.d = paramSocializeFeedsInfo.h;
    localFeedsReportData.e = paramSocializeFeedsInfo.j;
    paramAbsBaseArticleInfo = paramSocializeFeedsInfo.d;
    if ((paramAbsBaseArticleInfo != null) && (!paramAbsBaseArticleInfo.isEmpty()))
    {
      localFeedsReportData.c = new ArrayList();
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.iterator();
      while (paramAbsBaseArticleInfo.hasNext())
      {
        paramSocializeFeedsInfo = (FeedsInfoUser)paramAbsBaseArticleInfo.next();
        if (paramSocializeFeedsInfo != null) {
          localFeedsReportData.c.add(Long.valueOf(paramSocializeFeedsInfo.a));
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
    if (ReadinjoyReportUtils.d(paramAbsBaseArticleInfo.mChannelID)) {
      str = "0X8009361";
    } else {
      str = "0X8007EE4";
    }
    Object localObject = getContext();
    if ((localObject instanceof Activity))
    {
      localObject = (Activity)localObject;
      Intent localIntent = new Intent((Context)localObject, ReadInJoyDeliverBiuActivity.class);
      localIntent.putExtra("arg_article_info", paramAbsBaseArticleInfo);
      localIntent.putExtra("feedsType", paramAbsBaseArticleInfo.mFeedType);
      if (this.a.a.m() == 70)
      {
        localIntent.putExtra("biu_src", 9);
        localIntent.putExtra("arg_from_type", 14);
      }
      else
      {
        localIntent.putExtra("biu_src", 1);
        localIntent.putExtra("arg_from_type", 1);
      }
      ((Activity)localObject).startActivity(localIntent);
      ((Activity)localObject).overridePendingTransition(0, 0);
    }
    long l1;
    long l2;
    if (a(paramAbsBaseArticleInfo))
    {
      if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
      {
        l1 = paramSocializeFeedsInfo.s.e;
        l2 = paramSocializeFeedsInfo.a;
        paramSocializeFeedsInfo = new StringBuilder();
        paramSocializeFeedsInfo.append("");
        paramSocializeFeedsInfo.append(paramAbsBaseArticleInfo.mStrategyId);
        PublicAccountReportUtils.a(null, String.valueOf(l1), str, str, 0, 0, String.valueOf(l2), "0", paramSocializeFeedsInfo.toString(), paramString, false);
      }
      RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, this.a.a.m());
    }
    else
    {
      try
      {
        localObject = paramAbsBaseArticleInfo.mSubscribeID;
        l1 = paramSocializeFeedsInfo.a;
        l2 = paramAbsBaseArticleInfo.mArticleID;
        paramSocializeFeedsInfo = new StringBuilder();
        paramSocializeFeedsInfo.append("");
        paramSocializeFeedsInfo.append(paramAbsBaseArticleInfo.mStrategyId);
        PublicAccountReportUtils.a(null, (String)localObject, str, str, 0, 0, String.valueOf(l1), String.valueOf(l2), paramSocializeFeedsInfo.toString(), paramString, false);
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
    this.a = new CmpCtxt();
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
    if (ReadinjoyReportUtils.d(paramAbsBaseArticleInfo.mChannelID)) {
      str1 = "0X8009360";
    } else {
      str1 = "0X8007B67";
    }
    long l1;
    long l2;
    if (a(paramAbsBaseArticleInfo))
    {
      if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo)) {
        try
        {
          l1 = paramSocializeFeedsInfo.s.e;
          l2 = paramSocializeFeedsInfo.a;
          paramSocializeFeedsInfo = new StringBuilder();
          paramSocializeFeedsInfo.append("");
          paramSocializeFeedsInfo.append(paramAbsBaseArticleInfo.mStrategyId);
          PublicAccountReportUtils.a(null, String.valueOf(l1), str1, str1, 0, 0, String.valueOf(l2), "0", paramSocializeFeedsInfo.toString(), paramString, false);
        }
        catch (Throwable paramSocializeFeedsInfo)
        {
          paramSocializeFeedsInfo.printStackTrace();
        }
      }
      RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, this.a.a.m());
    }
    else
    {
      String str2 = paramAbsBaseArticleInfo.mSubscribeID;
      l1 = paramSocializeFeedsInfo.a;
      l2 = paramAbsBaseArticleInfo.mArticleID;
      paramSocializeFeedsInfo = new StringBuilder();
      paramSocializeFeedsInfo.append("");
      paramSocializeFeedsInfo.append(paramAbsBaseArticleInfo.mStrategyId);
      PublicAccountReportUtils.a(null, str2, str1, str1, 0, 0, String.valueOf(l1), String.valueOf(l2), paramSocializeFeedsInfo.toString(), paramString, false);
    }
    paramReportInfo.mOperation = 3;
    if (RIJItemViewTypeUtils.a(this.a.a.k()))
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
          localJSONObject.put("feeds_source", paramSocializeFeedsInfo.c.a);
        }
        localJSONObject.put("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
        paramSocializeFeedsInfo = new StringBuilder();
        paramSocializeFeedsInfo.append("");
        paramSocializeFeedsInfo.append(RIJFeedsType.g(paramAbsBaseArticleInfo));
        localJSONObject.put("feeds_type", paramSocializeFeedsInfo.toString());
        paramSocializeFeedsInfo = new StringBuilder();
        paramSocializeFeedsInfo.append("");
        paramSocializeFeedsInfo.append(RIJAppSetting.b());
        localJSONObject.put("kandian_mode", paramSocializeFeedsInfo.toString());
        paramSocializeFeedsInfo = new StringBuilder();
        paramSocializeFeedsInfo.append("");
        paramSocializeFeedsInfo.append(RIJTransMergeKanDianReport.b());
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
    this.b.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131626199, this, true);
    this.b = ((TextView)paramContext.findViewById(2131431117));
    this.c = ((TextView)paramContext.findViewById(2131449198));
    this.e = ((ImageView)paramContext.findViewById(2131449197));
    this.f = paramContext.findViewById(2131449196);
    this.d = ((TextView)paramContext.findViewById(2131429572));
    this.m = new ScaleAnimation(1.0F, 1.8F, 1.0F, 1.8F, 1, 0.5F, 1, 0.5F);
    this.n = new ScaleAnimation(1.8F, 0.85F, 1.8F, 0.85F, 1, 0.5F, 1, 0.5F);
    this.o = new ScaleAnimation(0.85F, 1.0F, 0.85F, 1.0F, 1, 0.5F, 1, 0.5F);
    this.m.setDuration(300L);
    this.n.setDuration(200L);
    this.o.setDuration(100L);
    this.m.setAnimationListener(new ComponentSocialOperation.1(this));
    this.n.setAnimationListener(new ComponentSocialOperation.2(this));
    this.o.setAnimationListener(new ComponentSocialOperation.3(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      this.a.a(paramObject);
      this.h = paramObject.k();
      paramObject = this.h;
      if (paramObject == null) {
        return;
      }
      this.g = paramObject.mSocialFeedInfo;
      paramObject = this.g;
      if (paramObject != null)
      {
        this.j = paramObject.h;
        this.k = this.g.j;
        int i1 = this.g.i;
        boolean bool = true;
        if (i1 != 1) {
          bool = false;
        }
        this.i = bool;
        this.l = this.g.l;
      }
      a(false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.startAnimation(this.m);
    }
    else
    {
      if (this.i)
      {
        this.e.setImageResource(2130848162);
        this.c.setTextColor(Color.parseColor("#07D0B0"));
      }
      else
      {
        this.e.setImageResource(2130848165);
        this.c.setTextColor(Color.parseColor("#777777"));
      }
      i1 = this.j;
      if (i1 > 0) {
        this.c.setText(a(i1));
      } else {
        this.c.setText(2131915569);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set upvote to ");
        localStringBuilder.append(this.i);
        localStringBuilder.append(", set num:");
        localStringBuilder.append(this.j);
        QLog.d("ComponentSocialOperation", 2, localStringBuilder.toString());
      }
    }
    int i1 = this.k;
    if (i1 > 0) {
      this.b.setText(a(i1));
    } else {
      this.b.setText(2131915265);
    }
    i1 = this.l;
    if (i1 > 0)
    {
      this.d.setText(a(i1));
      return;
    }
    this.d.setText("Biu");
  }
  
  public void onClick(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.h;
    SocializeFeedsInfo localSocializeFeedsInfo = this.g;
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
      RIJJumpUtils.a = localAbsBaseArticleInfo;
      Object localObject = new ReportInfo();
      if (paramView.getId() == 2131431117) {
        c(localAbsBaseArticleInfo, localSocializeFeedsInfo, str, (ReportInfo)localObject);
      } else if (paramView.getId() == 2131449196) {
        b(localAbsBaseArticleInfo, localSocializeFeedsInfo, str, (ReportInfo)localObject);
      } else if (paramView.getId() == 2131429572) {
        a(localAbsBaseArticleInfo, localSocializeFeedsInfo, str, (ReportInfo)localObject);
      }
      a(localAbsBaseArticleInfo, localSocializeFeedsInfo, (ReportInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentSocialOperation
 * JD-Core Version:    0.7.0.1
 */