package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleViewModel;
import com.tencent.mobileqq.kandian.repo.feeds.entity.Observable;
import com.tencent.mobileqq.kandian.repo.feeds.entity.Observer;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class NativeBiuCommentView
  extends NativeCommentView
  implements IView, Observer<CharSequence>
{
  public NativeBiuCommentView(Context paramContext)
  {
    super(paramContext);
    setSpannableFactory(QQText.SPANNABLE_FACTORY);
    setShouldCallClick(false);
  }
  
  private void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bindRecommendCommentHeader | linkTextColor ");
    ((StringBuilder)localObject).append(this.c);
    QLog.d("NativeBiuCommentView", 2, ((StringBuilder)localObject).toString());
    if (this.a != null)
    {
      localObject = this.a.b();
      b((AbsBaseArticleInfo)localObject);
      setMaxLines(a((AbsBaseArticleInfo)localObject));
      setSpanText(HardCodeUtil.a(2131904943));
      setMoreSpan(new NativeBiuCommentView.MoreSpan(this, (AbsBaseArticleInfo)localObject, this.c));
      this.a.a(this.c);
      this.g = this.a.e();
      this.g.a(this);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindRecommendCommentHeader: ");
      ((StringBuilder)localObject).append(this.g.a());
      QLog.d("NativeBiuCommentView", 2, ((StringBuilder)localObject).toString());
      setText((CharSequence)this.g.a());
    }
  }
  
  public void a(Observable<CharSequence> paramObservable)
  {
    paramObservable = (CharSequence)paramObservable.a();
    ThreadManager.getUIHandler().post(new NativeBiuCommentView.1(this, paramObservable));
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
    if (this.g != null) {
      this.g.b(this);
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if (this.g != null) {
      this.g.b(this);
    }
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel)
  {
    this.f.a(paramIReadInJoyModel);
    this.a = paramIReadInJoyModel.k().articleViewModel;
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeBiuCommentView
 * JD-Core Version:    0.7.0.1
 */