package com.tencent.mobileqq.kandian.biz.pts.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ColorUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase.ClickStatus;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnBiuClickListener;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.biu.BiuBehaviour;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;

public class ReadInJoyBiuButton
  extends ButtonBase
  implements View.OnLongClickListener
{
  private LinearLayout a;
  private ReadInJoyBiuButton.NativeBiuButton b;
  private AbsBaseArticleInfo c;
  private TextView d;
  
  public ReadInJoyBiuButton(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private void a(VafContext paramVafContext)
  {
    this.a = new LinearLayout(paramVafContext.getContext());
    this.b = new ReadInJoyBiuButton.NativeBiuButton(paramVafContext.getContext());
    this.d = new TextView(paramVafContext.getContext());
    paramVafContext = new LinearLayout.LayoutParams(-2, -2);
    paramVafContext.gravity = 16;
    this.a.setOrientation(0);
    this.a.setGravity(1);
    this.a.addView(this.b, paramVafContext);
    this.a.addView(this.d, paramVafContext);
    this.a.setOnLongClickListener(this);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return;
      }
      Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo;
      String str1;
      if (ReadinjoyReportUtils.d(paramAbsBaseArticleInfo.mChannelID)) {
        str1 = "0X8009361";
      } else {
        str1 = "0X8007EE4";
      }
      String str2 = RIJTransMergeKanDianReport.a(paramAbsBaseArticleInfo, true);
      long l1;
      long l2;
      if ((!RIJItemViewTypeUtils.l(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.n(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.p(paramAbsBaseArticleInfo)))
      {
        String str3 = paramAbsBaseArticleInfo.mSubscribeID;
        l1 = ((SocializeFeedsInfo)localObject).a;
        l2 = paramAbsBaseArticleInfo.mArticleID;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
        PublicAccountReportUtils.a(null, str3, str1, str1, 0, 0, String.valueOf(l1), String.valueOf(l2), ((StringBuilder)localObject).toString(), str2, false);
        return;
      }
      if (!RIJItemViewTypeUtils.v(paramAbsBaseArticleInfo))
      {
        l1 = ((SocializeFeedsInfo)localObject).s.e;
        l2 = ((SocializeFeedsInfo)localObject).a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mStrategyId);
        PublicAccountReportUtils.a(null, String.valueOf(l1), str1, str1, 0, 0, String.valueOf(l2), "0", ((StringBuilder)localObject).toString(), str2, false);
      }
      if ((!RIJFeedsType.y(paramAbsBaseArticleInfo)) && (!RIJFeedsType.z(paramAbsBaseArticleInfo))) {
        RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, (int)paramAbsBaseArticleInfo.mChannelID);
      }
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measure(paramInt1, paramInt2);
  }
  
  public boolean onLongClick(View paramView)
  {
    Object localObject = this.c;
    if ((localObject != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null) && (this.c.mSocialFeedInfo.d())) {
      return false;
    }
    localObject = paramView.getContext();
    if ((localObject instanceof Activity))
    {
      paramView = this.c;
      if (paramView != null)
      {
        localObject = (Activity)localObject;
        paramView = OnBiuClickListener.a((Activity)localObject, paramView);
        int i = BiuBehaviour.b();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        paramView.putExtra("fast_biu_type", bool);
        ((Activity)localObject).startActivity(paramView);
        ((Activity)localObject).overridePendingTransition(0, 0);
      }
    }
    a(this.c);
    return false;
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.a.setClickable(true);
    this.d.setIncludeFontPadding(false);
    this.d.setTextSize(0, this.mTextSize);
    this.d.setPadding(this.mCompoundDrawablePadding, 0, 0, 0);
    this.a.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.d.setText(this.mText);
  }
  
  public void refresh()
  {
    super.refresh();
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt == 1029) {
      this.c = ((AbsBaseArticleInfo)paramObject);
    }
    return super.setAttribute(paramInt, paramObject);
  }
  
  protected void setBackgroundColorForStates() {}
  
  protected void setBackgroundForStates()
  {
    Object localObject = this.a.getContext();
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    this.a.setBackgroundDrawable((Drawable)localObject);
  }
  
  protected void setCompoundDrawableForStates()
  {
    Object localObject = this.a.getContext();
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    this.b.setImageDrawable((Drawable)localObject);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.mText))
    {
      this.mText = paramCharSequence;
      this.d.setText(paramCharSequence);
    }
  }
  
  protected void setTextColorForStates()
  {
    ColorStateList localColorStateList = ColorUtil.getColorStateList(getStatus(0).textColor, getStatus(1).textColor, getStatus(4).textColor);
    this.d.setTextColor(localColorStateList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyBiuButton
 * JD-Core Version:    0.7.0.1
 */