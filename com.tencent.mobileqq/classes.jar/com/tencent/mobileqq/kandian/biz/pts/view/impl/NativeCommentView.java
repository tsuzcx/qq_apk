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
  protected long a;
  protected CmpCtxt a;
  protected Observable<CharSequence> a;
  protected String a;
  protected int b;
  public boolean b;
  public boolean c = false;
  
  public NativeCommentView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    setShouldCallClick(true);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mSocialFeedInfo != null))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable = localAbsBaseArticleInfo.articleViewModel.a();
      a(localAbsBaseArticleInfo);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable.a(this);
      CharSequence localCharSequence = (CharSequence)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable.a();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDesc: ");
      ((StringBuilder)localObject).append(localCharSequence);
      QLog.d("NativeCommentView", 2, ((StringBuilder)localObject).toString());
      if ((localAbsBaseArticleInfo.mFeedType != 30) && ((localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo == null) || (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.b.longValue() != 30L)))
      {
        localObject = localCharSequence;
        if (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBuluoInfo != null)
        {
          localObject = localCharSequence;
          if (TextUtils.isEmpty(localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBuluoInfo.c)) {}
        }
      }
      else
      {
        localObject = new QQText(TroopBarUtils.a(((CharSequence)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable.a()).toString().replaceAll("\024", "")), 3, 16);
      }
      setVisibility(0);
      if (this.c)
      {
        setMaxLines(2);
        setSpanText("");
        setMoreSpan(null);
        setEllipsis("...");
        setText((CharSequence)localObject);
        return;
      }
      if ((!RIJItemViewTypeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a())) && (!RIJItemViewTypeUtils.t(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a())) && (!RIJItemViewTypeUtils.g(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a())))
      {
        if (localAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUGCFeedsInfo != null)
        {
          setMaxLines(a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()));
          if (((RIJFeedsType.s(localAbsBaseArticleInfo)) || (RIJFeedsType.t(localAbsBaseArticleInfo))) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a().mChannelID != 0L))
          {
            setSpanText("");
            setMoreSpan(null);
          }
          else
          {
            setMoreSpan(new NativeCommentView.2(this, this.jdField_a_of_type_Int, 16777215, 860716207, localAbsBaseArticleInfo));
            setCustomViewLinkTextColor(this.jdField_a_of_type_Int);
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
      setMaxLines(a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a()));
      if (localAbsBaseArticleInfo.mArticleType == 2) {
        setSpanText(BaseApplication.getContext().getString(2131718002));
      } else if (localAbsBaseArticleInfo.isPGCShortContent()) {
        setSpanText(HardCodeUtil.a(2131707106));
      }
      setMoreSpan(new NativeCommentView.1(this, this.jdField_a_of_type_Int, 16777215, 860716207));
      setCustomViewLinkTextColor(this.jdField_a_of_type_Int);
      if (this.c)
      {
        setHeight(0);
        return;
      }
      setText((CharSequence)localObject);
    }
  }
  
  protected void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("current text: ");
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable;
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
      paramAbsBaseArticleInfo.articleViewModel.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      paramAbsBaseArticleInfo.articleViewModel.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      paramAbsBaseArticleInfo.articleViewModel.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Long != 0L) {
        paramAbsBaseArticleInfo.articleViewModel.a();
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("current text: ");
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityObservable;
    paramAbsBaseArticleInfo = localObject2;
    if (localObject3 != null) {
      paramAbsBaseArticleInfo = (CharSequence)((Observable)localObject3).a();
    }
    ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo);
    QLog.d("NativeCommentView", 1, ((StringBuilder)localObject1).toString());
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
      localStringBuilder.append(HardCodeUtil.a(2131718277));
      localStringBuilder.append("：");
      this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    }
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
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
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
    int i = paramIReadInJoyModel.d();
    if ((i == 48) || (i == 64) || (i == 65)) {
      this.c = true;
    }
    b();
    setShouldCallClick(this.c);
  }
  
  public void setPreAccountUin(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPreAccountUin: ");
    localStringBuilder.append(paramLong);
    QLog.d("NativeCommentView", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setPreBlankNum(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPreBlankNum: ");
    localStringBuilder.append(paramInt);
    QLog.d("NativeCommentView", 1, localStringBuilder.toString());
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeCommentView
 * JD-Core Version:    0.7.0.1
 */