package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.view.widget.RingAvatarView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.UtilsForComponent;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;

public class ComponentHeaderPublish
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  public TextView e;
  public ReadInJoyYAFolderTextView f;
  RingAvatarView g;
  ImageView h;
  public boolean i = false;
  public boolean j = false;
  public boolean k = false;
  private FixSizeImageView l;
  private TextView m;
  private View n;
  
  public ComponentHeaderPublish(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderPublish(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderPublish(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void e()
  {
    long l1 = getUin();
    if (l1 != 0L)
    {
      if (RIJQQAppInterfaceUtil.g()) {
        this.l.setImageDrawable(SearchUtils.a(this.c, String.valueOf(l1), 1));
      } else {
        this.l.setImageBitmap(this.b.d(l1));
      }
      this.l.setOnClickListener(this);
    }
  }
  
  private void f()
  {
    if ((this.a.a != null) && (this.a.a.k() != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
      this.e.setText(RIJStringUtils.a(localAbsBaseArticleInfo.mSubscribeName));
      this.e.setOnClickListener(this);
      if ((localAbsBaseArticleInfo.mSocialFeedInfo != null) && (RIJItemViewTypeUtils.a(localAbsBaseArticleInfo)) && (localAbsBaseArticleInfo.mSocialFeedInfo.c.b == 1))
      {
        this.n.setVisibility(0);
        return;
      }
      this.n.setVisibility(8);
    }
  }
  
  private void g()
  {
    if ((this.a.a != null) && (this.a.a.k() != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
      if (ComponentPolymericView.a(this.a.a))
      {
        this.f.setVisibility(8);
      }
      else if ((TextUtils.isEmpty(localAbsBaseArticleInfo.mSummary)) && (!this.i) && (!this.j))
      {
        this.f.setVisibility(8);
      }
      else
      {
        this.f.setVisibility(0);
        this.f.setMaxLines(7);
        this.f.setSpanText(HardCodeUtil.a(2131900514));
        this.f.setMoreSpan(new ComponentHeaderPublish.1(this));
        Object localObject1;
        Object localObject2;
        if (this.i)
        {
          localObject1 = new SpannableStringBuilder();
          if ((localAbsBaseArticleInfo.mSocialFeedInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.t.c != null))
          {
            ((SpannableStringBuilder)localObject1).append(localAbsBaseArticleInfo.mSocialFeedInfo.t.c);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Comment String: ");
              ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mSocialFeedInfo.t.c);
              QLog.d("Q.readinjoy.ui", 2, ((StringBuilder)localObject2).toString());
            }
          }
          else if (localAbsBaseArticleInfo.mTitle != null)
          {
            ((SpannableStringBuilder)localObject1).append(localAbsBaseArticleInfo.mTitle);
          }
          localObject2 = HardCodeUtil.a(2131900499);
          ((SpannableStringBuilder)localObject1).append(" ");
          ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
          ComponentAccountSummary.ReadArticleSpan localReadArticleSpan = new ComponentAccountSummary.ReadArticleSpan(localAbsBaseArticleInfo, -3355444, getContext(), getResources(), this.a);
          localReadArticleSpan.f = 17;
          ((SpannableStringBuilder)localObject1).setSpan(localReadArticleSpan, ((SpannableStringBuilder)localObject1).length() - ((String)localObject2).length(), ((SpannableStringBuilder)localObject1).length(), 33);
          ((SpannableStringBuilder)localObject1).append(" ");
          localObject2 = this.f;
          ((ReadInJoyYAFolderTextView)localObject2).b = true;
          ((ReadInJoyYAFolderTextView)localObject2).setText((CharSequence)localObject1);
        }
        else if (this.j)
        {
          this.f.setHeight(0);
        }
        else if (this.k)
        {
          localObject2 = this.f;
          if (!TextUtils.isEmpty(localAbsBaseArticleInfo.mTitle)) {
            localObject1 = localAbsBaseArticleInfo.mTitle;
          } else {
            localObject1 = localAbsBaseArticleInfo.mSummary;
          }
          ((ReadInJoyYAFolderTextView)localObject2).setText((CharSequence)localObject1);
        }
        else
        {
          this.f.setText(localAbsBaseArticleInfo.mSummary);
        }
      }
      if (localAbsBaseArticleInfo.mTime > 0L) {
        this.m.setText(ReadInJoyTimeUtils.INSTANCE.getRelativeDisplayForTime(localAbsBaseArticleInfo.mTime, true));
      } else {
        this.m.setText(HardCodeUtil.a(2131900483));
      }
      this.m.setOnClickListener(this);
      return;
    }
    this.f.setVisibility(8);
  }
  
  private long getUin()
  {
    try
    {
      long l1 = Long.parseLong(this.a.a.k().mSubscribeID);
      return l1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return 0L;
  }
  
  private void h()
  {
    if ((this.a.a != null) && (this.a.a.k() != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
      com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = localAbsBaseArticleInfo;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(getUin());
      String str1 = ((StringBuilder)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ReadInJoyConstants.l);
      ((StringBuilder)localObject).append(Base64Util.encodeToString(str1.getBytes(), 2));
      localObject = ((StringBuilder)localObject).toString();
      ReadInJoyUtils.a(getContext(), (String)localObject);
      String str2 = RIJTransMergeKanDianReport.a("4", localAbsBaseArticleInfo, getUin());
      if (ReadinjoyReportUtils.d(this.a.a.m())) {
        localObject = "0X800935C";
      } else {
        localObject = "0X8007BA3";
      }
      long l1 = localAbsBaseArticleInfo.mFeedId;
      long l2 = localAbsBaseArticleInfo.mArticleID;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(localAbsBaseArticleInfo.mStrategyId);
      PublicAccountReportUtils.a(null, str1, (String)localObject, (String)localObject, 0, 0, String.valueOf(l1), String.valueOf(l2), localStringBuilder.toString(), str2, false);
    }
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626193, this, true);
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if ((RIJQQAppInterfaceUtil.g()) && (getUin() == paramLong)) {
      this.l.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.l = ((FixSizeImageView)findViewById(2131428988));
    this.e = ((TextView)findViewById(2131439320));
    this.e.getPaint().setFakeBoldText(true);
    this.m = ((TextView)findViewById(2131447345));
    this.f = ((ReadInJoyYAFolderTextView)findViewById(2131431757));
    this.n = findViewById(2131444225);
    this.g = ((RingAvatarView)findViewById(2131444175));
    this.h = ((ImageView)findViewById(2131436589));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    e();
    UtilsForComponent.a(this.a.a, this.g, this.h);
    f();
    g();
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    if ((paramObject instanceof IReadInJoyModel)) {
      a((IReadInJoyModel)paramObject);
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 != 2131428988) && (i1 != 2131439320) && (i1 != 2131447345)) {
      return;
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderPublish
 * JD-Core Version:    0.7.0.1
 */