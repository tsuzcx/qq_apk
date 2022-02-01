package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class ComponentHeaderTopicRecommend
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  private static final String n = HardCodeUtil.a(2131899712);
  private static final String o = HardCodeUtil.a(2131900512);
  private KanDianUrlRoundCornerImageView e;
  private Button f;
  private TextView g;
  private TopicRecommendFeedsInfo.TopicRecommendInfo h;
  private ReadInJoyYAFolderTextView i;
  private TextView j;
  private AbsBaseArticleInfo k;
  private ActionSheet l;
  private LinearLayout m;
  
  public ComponentHeaderTopicRecommend(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderTopicRecommend(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = ReadInJoyUtils.b();
    if (this.h != null)
    {
      localObject = ((AppRuntime)localObject).getAccount();
      if (paramBoolean)
      {
        ReadInJoyLogicEngine.a().c().request0x978((String)localObject, Long.toString(this.h.a), true, "", new ComponentHeaderTopicRecommend.4(this), 3);
        return;
      }
      ReadInJoyLogicEngine.a().c().request0x978((String)localObject, Long.toString(this.h.a), false, "", new ComponentHeaderTopicRecommend.5(this), 3);
    }
  }
  
  private void f()
  {
    if (k())
    {
      this.k = this.a.a.k();
      this.h = ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.a.a.k().mTopicRecommendFeedsInfo.g.get(0));
    }
    this.k = this.a.a.k();
    if (this.k == null) {
      return;
    }
    i();
    j();
    l();
    if (RIJItemViewTypeUtils.n(this.k))
    {
      h();
      return;
    }
    g();
  }
  
  private void g()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(this.k.mSubscribeName);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("less =");
      ((StringBuilder)localObject).append(this.k.mAccountLess);
      ((StringBuilder)localObject).append(" title = ");
      ((StringBuilder)localObject).append(this.k.mTitle);
      QLog.d("ComponentHeaderTopicRecommend", 2, ((StringBuilder)localObject).toString());
    }
    if (this.k.mAccountLess == 0) {
      localSpannableStringBuilder.setSpan(new ComponentHeaderTopicRecommend.SubscribeClickSpan(this, this.k.mSubscribeID, -3355444), 0, localSpannableStringBuilder.length(), 33);
    }
    localSpannableStringBuilder.append(": ");
    localSpannableStringBuilder.append(this.k.mSummary);
    if ((this.k.mSocialFeedInfo != null) && (this.k.mSocialFeedInfo.b == 9))
    {
      localObject = HardCodeUtil.a(2131900443);
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append((CharSequence)localObject);
      ComponentAccountSummary.ReadArticleSpan localReadArticleSpan = new ComponentAccountSummary.ReadArticleSpan(this.k, -3355444, getContext(), getResources(), this.a);
      localReadArticleSpan.f = 17;
      localSpannableStringBuilder.setSpan(localReadArticleSpan, localSpannableStringBuilder.length() - ((String)localObject).length(), localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(" ");
    }
    this.i.setMaxLines(7);
    this.i.setSpanText(HardCodeUtil.a(2131900479));
    this.i.setMoreSpan(new ComponentHeaderTopicRecommend.MoreSpan(this, this.k, -3355444));
    this.i.setText(localSpannableStringBuilder);
  }
  
  private void h()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.k;
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null) && (this.k.mSocialFeedInfo.c != null) && (this.k.mSocialFeedInfo.s != null))
    {
      long l1 = this.k.mSocialFeedInfo.c.a;
      localSpannableStringBuilder.append(RIJStringUtils.a(ContactUtils.a((QQAppInterface)ReadInJoyUtils.b(), String.valueOf(l1), true)));
      localSpannableStringBuilder.setSpan(new CommonBasicComponent.UserSpan(l1, -3355444, this.a), 0, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(": ");
      if ((CmpCtxt.c(this.k)) && (!RIJItemViewTypeUtils.x(this.k)))
      {
        localSpannableStringBuilder.append(((UGCVideoInfo)this.k.mSocialFeedInfo.s.c.get(0)).e);
        this.i.setText(localSpannableStringBuilder);
      }
      else
      {
        ReadInJoyYAFolderTextView.setUgcFolderTextView(this.k.mSocialFeedInfo.s, this.i, this.a, localSpannableStringBuilder);
      }
      this.i.setMaxLines(7);
      this.i.setSpanText(HardCodeUtil.a(2131900446));
      this.i.setMoreSpan(new ComponentHeaderTopicRecommend.MoreSpan(this, this.k, -3355444));
      return;
    }
    QLog.d("ComponentHeaderTopicRecommend", 1, new Object[] { "Some ugc info is null. ", this.k });
  }
  
  private void i()
  {
    if (!k()) {
      return;
    }
    if ((this.a.a != null) && (this.a.a.k() != null))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      if ((RIJFeedsType.q(this.k)) || (RIJFeedsType.t(this.k))) {
        if (this.k.mTime > 0L) {
          localStringBuilder1.append(ReadInJoyTimeUtils.INSTANCE.getRelativeDisplayForTime(this.k.mRecommendTime, true));
        } else {
          localStringBuilder1.append("刚刚");
        }
      }
      if (this.k.mTopicRecommendFeedsInfo != null)
      {
        localStringBuilder1.append(" ");
        if (!TextUtils.isEmpty(this.k.mTopicRecommendFeedsInfo.h))
        {
          localStringBuilder1.append(this.k.mTopicRecommendFeedsInfo.h);
        }
        else if (this.k.mTopicRecommendFeedsInfo.g.get(0) != null)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(ReadInJoyHelper.c(((TopicRecommendFeedsInfo.TopicRecommendInfo)this.k.mTopicRecommendFeedsInfo.g.get(0)).e));
          localStringBuilder2.append(o);
          localStringBuilder1.append(localStringBuilder2.toString());
        }
      }
      this.j.setText(localStringBuilder1);
    }
  }
  
  private void j()
  {
    if (k())
    {
      Object localObject = this.k.businessName;
      String str = this.k.businessNamePrefix;
      TextView localTextView = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject);
      localTextView.setText(localStringBuilder.toString());
      localObject = new ImageRequest();
      try
      {
        ((ImageRequest)localObject).a = new URL(this.h.f);
        ((ImageRequest)localObject).b = this.e.getWidth();
        ((ImageRequest)localObject).c = this.e.getHeight();
        this.e.setImageForImageCollection((ImageRequest)localObject, new ComponentHeaderTopicRecommend.1(this));
        return;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
      }
    }
  }
  
  private boolean k()
  {
    return (this.a.a != null) && (this.a.a.k() != null) && (this.a.a.k().mTopicRecommendFeedsInfo != null) && (this.a.a.k().mTopicRecommendFeedsInfo.g.size() > 0);
  }
  
  private void l()
  {
    if (this.h != null) {
      if ((!RIJFeedsType.p(this.a.a.k())) && (!RIJFeedsType.s(this.a.a.k())))
      {
        if ((RIJFeedsType.q(this.a.a.k())) || (RIJFeedsType.t(this.a.a.k()))) {
          this.f.setVisibility(4);
        }
      }
      else
      {
        if (this.h.g == 1)
        {
          this.f.setText(HardCodeUtil.a(2131900461));
          this.f.setBackgroundColor(-1);
          this.f.setTextColor(Color.parseColor("#bbbbbb"));
          this.f.getPaint().setFakeBoldText(false);
        }
        else
        {
          this.f.setText(n);
          this.f.setBackgroundColor(-1);
          this.f.setTextColor(Color.parseColor("#07D0B0"));
          this.f.getPaint().setFakeBoldText(true);
        }
        this.f.setVisibility(0);
      }
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("business url is ");
      ((StringBuilder)localObject).append(this.k.businessUrl);
      QLog.d("ComponentHeaderTopicRecommend", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.k;
    if ((localObject != null) && (this.h != null))
    {
      if (TextUtils.isEmpty(((AbsBaseArticleInfo)localObject).businessUrl)) {
        return;
      }
      localObject = new Intent(getContext(), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      ((Intent)localObject).putExtra("url", this.k.businessUrl);
      getContext().startActivity((Intent)localObject);
      localObject = RIJFeedsType.k(this.k);
      String str = this.k.innerUniqueID;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h.a);
      localStringBuilder.append("");
      str = RIJTransMergeKanDianReport.a(str, localStringBuilder.toString(), this.k);
      PublicAccountReportUtils.a(null, (String)localObject, "0X8008A63", "0X8008A63", 0, 0, Long.toString(this.k.mFeedId), Long.toString(this.k.mArticleID), Long.toString(this.k.mStrategyId), str, false);
      RIJFrameworkReportManager.b(this.k, this.a.a.m());
      RIJFrameworkReportManager.c(this.k, this.b.c());
      return;
    }
    QLog.d("ComponentHeaderTopicRecommend", 1, new Object[] { "articleInfo is null or topicRecommendInfo is null, articleInfo: ", this.k, " topicRecommendInfo: ", this.h });
  }
  
  private void n()
  {
    if (this.f.getText().equals(HardCodeUtil.a(2131900494)))
    {
      e();
      return;
    }
    a(true);
    String str1 = RIJFeedsType.k(this.k);
    long l1 = this.k.mAlgorithmID;
    int i1 = RIJFeedsType.g(this.k);
    int i2 = this.a.a.m();
    boolean bool = NetworkUtil.isWifiConnected(getContext());
    String str2 = this.k.innerUniqueID;
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.k;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.k.businessId);
    localStringBuilder.append("");
    str2 = RIJTransMergeKanDianReport.a(l1, i1, i2, bool, str1, str2, localAbsBaseArticleInfo, localStringBuilder.toString());
    PublicAccountReportUtils.a(null, str1, "0X8008A61", "0X8008A61", 0, 0, Long.toString(this.k.mFeedId), Long.toString(this.k.mArticleID), Long.toString(this.k.mAlgorithmID), str2, false);
    RIJFrameworkReportManager.b(this.k, this.a.a.m());
  }
  
  private void setTopicImageView(Bitmap paramBitmap)
  {
    Bitmap localBitmap;
    try
    {
      localBitmap = ImageUtil.b(paramBitmap, AIOUtils.b(3.0F, getResources()), paramBitmap.getWidth(), paramBitmap.getHeight());
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localBitmap = paramBitmap;
      if (QLog.isColorLevel())
      {
        QLog.d("ComponentHeaderTopicRecommend", 2, QLog.getStackTraceString(localOutOfMemoryError));
        localBitmap = paramBitmap;
      }
    }
    this.e.setImageBitmap(localBitmap);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626195, this, true);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.e = ((KanDianUrlRoundCornerImageView)paramView.findViewById(2131447772));
    this.e.setCorner(AIOUtils.b(3.0F, getResources()));
    this.f = ((Button)paramView.findViewById(2131429893));
    this.f.getPaint().setFakeBoldText(true);
    this.g = ((TextView)paramView.findViewById(2131447774));
    this.g.getPaint().setFakeBoldText(true);
    this.i = ((ReadInJoyYAFolderTextView)paramView.findViewById(2131447771));
    this.j = ((TextView)paramView.findViewById(2131447773));
    this.m = ((LinearLayout)paramView.findViewById(2131447775));
    this.m.setOnClickListener(this);
    this.f.setOnClickListener(this);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      f();
    }
  }
  
  public void b()
  {
    super.b();
    if ((this.m.getLayoutParams() instanceof LinearLayout.LayoutParams))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.m.getLayoutParams();
      if (c()) {
        localLayoutParams.setMargins(ViewUtils.dip2px(12.0F), 0, ViewUtils.dip2px(15.0F), 0);
      } else {
        localLayoutParams.setMargins(ViewUtils.dip2px(12.0F), 0, ViewUtils.dip2px(2.25F), 0);
      }
      this.m.setLayoutParams(localLayoutParams);
    }
  }
  
  protected void e()
  {
    this.l = ((ActionSheet)ActionSheetHelper.b(getContext(), null));
    this.l.addButton(2131893006, 3);
    this.l.addCancelButton(2131887648);
    this.l.setOnDismissListener(new ComponentHeaderTopicRecommend.2(this));
    this.l.setOnButtonClickListener(new ComponentHeaderTopicRecommend.3(this));
    if (!this.l.isShowing()) {
      this.l.show();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131429893)
    {
      if (i1 != 2131447775) {
        return;
      }
      m();
      return;
    }
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderTopicRecommend
 * JD-Core Version:    0.7.0.1
 */