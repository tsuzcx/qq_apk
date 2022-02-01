package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleViewModel;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BuluoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.Observable;
import com.tencent.mobileqq.kandian.repo.feeds.entity.Observer;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class NativeCommentView
  extends ReadInJoyYAFolderTextView
  implements IView, Observer<CharSequence>
{
  public boolean d = false;
  public boolean e = false;
  protected CmpCtxt f = new CmpCtxt();
  protected Observable<CharSequence> g;
  protected int h;
  protected long i;
  protected String j;
  
  public NativeCommentView(Context paramContext)
  {
    super(paramContext);
    setShouldCallClick(true);
  }
  
  private void b()
  {
    if ((this.f.a != null) && (this.f.a.k() != null) && (this.f.a.k().mSocialFeedInfo != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.f.a.k();
      this.g = localAbsBaseArticleInfo.articleViewModel.c();
      b(localAbsBaseArticleInfo);
      this.g.a(this);
      CharSequence localCharSequence = (CharSequence)this.g.a();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDesc: ");
      ((StringBuilder)localObject).append(localCharSequence);
      QLog.d("NativeCommentView", 2, ((StringBuilder)localObject).toString());
      if ((localAbsBaseArticleInfo.mFeedType != 30) && ((localAbsBaseArticleInfo.mSocialFeedInfo.n == null) || (localAbsBaseArticleInfo.mSocialFeedInfo.n.c.longValue() != 30L)))
      {
        localObject = localCharSequence;
        if (localAbsBaseArticleInfo.mSocialFeedInfo.K != null)
        {
          localObject = localCharSequence;
          if (TextUtils.isEmpty(localAbsBaseArticleInfo.mSocialFeedInfo.K.d)) {}
        }
      }
      else
      {
        localObject = new QQText(TroopBarUtils.a(((CharSequence)this.g.a()).toString().replaceAll("\024", "")), 3, 16);
      }
      setVisibility(0);
      if (this.e)
      {
        setMaxLines(2);
        setSpanText("");
        setMoreSpan(null);
        setEllipsis("...");
        setText((CharSequence)localObject);
        return;
      }
      if ((!RIJItemViewTypeUtils.a(this.f.a.k())) && (!RIJItemViewTypeUtils.t(this.f.a.k())) && (!RIJItemViewTypeUtils.g(this.f.a.k())))
      {
        if (localAbsBaseArticleInfo.mSocialFeedInfo.s != null)
        {
          setMaxLines(a(this.f.a.k()));
          if (((RIJFeedsType.y(localAbsBaseArticleInfo)) || (RIJFeedsType.z(localAbsBaseArticleInfo))) && (this.f.a.k().mChannelID != 0L))
          {
            setSpanText("");
            setMoreSpan(null);
          }
          else
          {
            setMoreSpan(new NativeCommentView.2(this, this.c, 16777215, 860716207, localAbsBaseArticleInfo));
            setCustomViewLinkTextColor(this.c);
          }
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            setText((CharSequence)localObject);
            return;
          }
          setVisibility(8);
          return;
        }
        setVisibility(8);
        return;
      }
      setMaxLines(a(this.f.a.k()));
      if (localAbsBaseArticleInfo.mArticleType == 2) {
        setSpanText(BaseApplication.getContext().getString(2131915482));
      } else if (localAbsBaseArticleInfo.isPGCShortContent()) {
        setSpanText(HardCodeUtil.a(2131904944));
      }
      setMoreSpan(new NativeCommentView.1(this, this.c, 16777215, 860716207));
      setCustomViewLinkTextColor(this.c);
      if (this.e)
      {
        setHeight(0);
        return;
      }
      setText((CharSequence)localObject);
    }
  }
  
  public void a(Observable<CharSequence> paramObservable)
  {
    paramObservable = (CharSequence)paramObservable.a();
    ThreadManager.getUIHandler().post(new NativeCommentView.3(this, paramObservable));
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPreCommentText: ");
    localStringBuilder.append(paramBoolean);
    QLog.d("NativeCommentView", 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131915769));
      localStringBuilder.append("：");
      this.j = localStringBuilder.toString();
    }
  }
  
  protected void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("current text: ");
    Object localObject1 = this.g;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = (CharSequence)((Observable)localObject1).a();
    } else {
      localObject1 = null;
    }
    ((StringBuilder)localObject3).append(localObject1);
    QLog.d("NativeCommentView", 1, ((StringBuilder)localObject3).toString());
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.articleViewModel != null))
    {
      paramAbsBaseArticleInfo.articleViewModel.a = this.h;
      paramAbsBaseArticleInfo.articleViewModel.b = this.i;
      paramAbsBaseArticleInfo.articleViewModel.c = this.j;
      if (this.i != 0L) {
        paramAbsBaseArticleInfo.articleViewModel.a();
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("current text: ");
    localObject3 = this.g;
    paramAbsBaseArticleInfo = localObject2;
    if (localObject3 != null) {
      paramAbsBaseArticleInfo = (CharSequence)((Observable)localObject3).a();
    }
    ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo);
    QLog.d("NativeCommentView", 1, ((StringBuilder)localObject1).toString());
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
    Observable localObservable = this.g;
    if (localObservable != null) {
      localObservable.b(this);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    Observable localObservable = this.g;
    if (localObservable != null) {
      localObservable.b(this);
    }
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel)
  {
    this.f.a(paramIReadInJoyModel);
    int k = paramIReadInJoyModel.o();
    if ((k == 48) || (k == 64) || (k == 65)) {
      this.e = true;
    }
    b();
    setShouldCallClick(this.e);
  }
  
  public void setPreAccountUin(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPreAccountUin: ");
    localStringBuilder.append(paramLong);
    QLog.d("NativeCommentView", 1, localStringBuilder.toString());
    this.i = paramLong;
  }
  
  public void setPreBlankNum(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPreBlankNum: ");
    localStringBuilder.append(paramInt);
    QLog.d("NativeCommentView", 1, localStringBuilder.toString());
    this.h = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeCommentView
 * JD-Core Version:    0.7.0.1
 */