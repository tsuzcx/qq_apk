package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan.Standard;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentReportManager;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentLinkData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class CommentLinkItemView
  extends LinearLayout
  implements View.OnClickListener
{
  private BaseCommentData.CommentLinkData a;
  private Context b;
  private NativeReadInjoyImageView c;
  private TextView d;
  private AbsBaseArticleInfo e;
  private BaseCommentData f;
  
  public CommentLinkItemView(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    a();
  }
  
  public CommentLinkItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    a();
  }
  
  public CommentLinkItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    a();
  }
  
  private void a()
  {
    inflate(this.b, 2131629131, this);
    this.c = ((NativeReadInjoyImageView)findViewById(2131436444));
    this.d = ((TextView)findViewById(2131448566));
  }
  
  private void setDefaultIcon(int paramInt)
  {
    NativeReadInjoyImageView localNativeReadInjoyImageView = this.c;
    if (localNativeReadInjoyImageView != null)
    {
      Context localContext = this.b;
      if (localContext == null) {
        return;
      }
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              localNativeReadInjoyImageView.setImageDrawable(localContext.getResources().getDrawable(2130843869));
              return;
            }
            localNativeReadInjoyImageView.setImageDrawable(localContext.getResources().getDrawable(2097479705));
            return;
          }
          localNativeReadInjoyImageView.setImageDrawable(localContext.getResources().getDrawable(2130843873));
          return;
        }
        localNativeReadInjoyImageView.setImageDrawable(localContext.getResources().getDrawable(2130843870));
        return;
      }
      localNativeReadInjoyImageView.setImageDrawable(localContext.getResources().getDrawable(2130843872));
    }
  }
  
  private void setLinkIcon(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if (TextUtils.isEmpty(paramCommentLinkData.iconUrl))
    {
      QLog.d("CommentLinkItemView", 2, "createLinkItemView | mLinkData setDefaultIcon");
      setDefaultIcon(paramCommentLinkData.type);
      return;
    }
    NativeReadInjoyImageView localNativeReadInjoyImageView = this.c;
    if (localNativeReadInjoyImageView != null) {
      localNativeReadInjoyImageView.setImageSrc(paramCommentLinkData.iconUrl);
    }
  }
  
  private void setLinkWord(BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if ((this.d != null) && (paramCommentLinkData != null))
    {
      paramCommentLinkData = new SpannableString(paramCommentLinkData.wording);
      paramCommentLinkData.setSpan(new LeadingMarginSpan.Standard(DisplayUtil.a(this.b, 19.0F), 0), 0, paramCommentLinkData.length(), 18);
      this.d.setText(paramCommentLinkData);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, BaseCommentData paramBaseCommentData, BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    if ((paramCommentLinkData != null) && (paramBaseCommentData != null))
    {
      if (paramAbsBaseArticleInfo == null) {
        return;
      }
      this.e = paramAbsBaseArticleInfo;
      this.f = paramBaseCommentData;
      this.a = paramCommentLinkData;
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("createLinkItemView | mLinkData ");
      paramAbsBaseArticleInfo.append(this.a);
      QLog.d("CommentLinkItemView", 2, paramAbsBaseArticleInfo.toString());
      setLinkIcon(this.a);
      setLinkWord(this.a);
      setOnClickListener(this);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if ((paramView != null) && (!TextUtils.isEmpty(paramView.linkUrl)))
    {
      paramView = new StringBuilder();
      paramView.append("linkItemView click url ");
      paramView.append(this.a.linkUrl);
      QLog.d("CommentLinkItemView", 2, paramView.toString());
      if (this.a.type == 4) {
        RIJJumpUtils.a(getContext(), this.a.linkUrl, 2104, new CommentLinkItemView.1(this));
      } else if (this.a.type == 5) {
        ReadInJoyCommentUtils.a(getContext(), this.a.linkUrl, String.valueOf(this.e.mFeedType));
      } else {
        ReadInJoyUtils.a(this.b, this.a.linkUrl);
      }
      ReadInJoyCommentReportManager.a(this.e, this.f, this.a.type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.CommentLinkItemView
 * JD-Core Version:    0.7.0.1
 */