package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class ComponentAccountSummary
  extends FrameLayout
  implements ComponentView
{
  CmpCtxt a;
  ReadInJoyYAFolderTextView b;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  
  public ComponentAccountSummary(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentAccountSummary(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentAccountSummary(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private String a(@NotNull IReadInJoyModel paramIReadInJoyModel)
  {
    String str = paramIReadInJoyModel.k().mSummary;
    if ((this.a.d()) || (this.a.h())) {
      str = paramIReadInJoyModel.k().mTitle;
    }
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    if (paramIReadInJoyModel.o() == 33) {
      return HardCodeUtil.a(2131900509);
    }
    if ((!this.a.c()) && (!this.a.e()) && (!this.a.f()))
    {
      if ((!this.a.d()) && (!this.a.h()))
      {
        if (this.a.i()) {
          return HardCodeUtil.a(2131900500);
        }
        return HardCodeUtil.a(2131900513);
      }
      return HardCodeUtil.a(2131900490);
    }
    return HardCodeUtil.a(2131900511);
  }
  
  private void a(@NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.c != null))
    {
      localSpannableStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.t.c);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Comment String: ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSocialFeedInfo.t.c);
      QLog.d("Q.readinjoy.ui", 2, ((StringBuilder)localObject).toString());
    }
    else if (paramAbsBaseArticleInfo.mTitle != null)
    {
      localSpannableStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
    }
    Object localObject = HardCodeUtil.a(2131900477);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append((CharSequence)localObject);
    localSpannableStringBuilder.setSpan(new ComponentAccountSummary.ReadArticleSpan(paramAbsBaseArticleInfo, -3355444, getContext(), getResources(), this.a), localSpannableStringBuilder.length() - ((String)localObject).length(), localSpannableStringBuilder.length(), 33);
    localSpannableStringBuilder.append(" ");
    paramSpannableStringBuilder.append(localSpannableStringBuilder);
    this.b.b = true;
  }
  
  private void a(@NotNull IReadInJoyModel paramIReadInJoyModel, @NotNull SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    if ((paramIReadInJoyModel.o() == 33) && (paramIReadInJoyModel.k().mSocialFeedInfo != null) && (paramIReadInJoyModel.k().mSocialFeedInfo.v != null))
    {
      if (paramIReadInJoyModel.k().mSocialFeedInfo.v.c == 0L)
      {
        String str = paramIReadInJoyModel.k().mSocialFeedInfo.v.d;
        paramIReadInJoyModel = paramString;
        paramString = str;
      }
      else
      {
        paramString = String.valueOf(paramIReadInJoyModel.k().mSocialFeedInfo.v.c);
        if (RIJQQAppInterfaceUtil.g()) {
          paramIReadInJoyModel = ContactUtils.a((QQAppInterface)ReadInJoyUtils.b(), paramString, true);
        } else {
          paramIReadInJoyModel = ((ReadInJoyBaseAdapter)paramIReadInJoyModel.u()).e(paramIReadInJoyModel.k().mSocialFeedInfo.v.c);
        }
      }
      paramSpannableStringBuilder.append(paramIReadInJoyModel);
      paramSpannableStringBuilder.setSpan(new ComponentAccountSummary.UserSpan(this, paramString, -3355444), 0, paramIReadInJoyModel.length(), 33);
    }
    else if (paramIReadInJoyModel.k().mAccountLess == 0)
    {
      paramIReadInJoyModel = paramIReadInJoyModel.k().mSubscribeID;
      paramSpannableStringBuilder.append(paramString);
      paramSpannableStringBuilder.setSpan(new ComponentAccountSummary.UserSpan(this, paramIReadInJoyModel, -3355444), 0, paramString.length(), 33);
    }
    else
    {
      paramSpannableStringBuilder.append(paramString);
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.rgb(96, 96, 96)), 0, paramString.length(), 33);
    }
    paramSpannableStringBuilder.append(": ");
  }
  
  private void b(Context paramContext)
  {
    this.a = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  private void b(@NotNull SpannableStringBuilder paramSpannableStringBuilder, @NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.c != null))
    {
      localSpannableStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.t.c);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Comment String: ");
        localStringBuilder.append(paramAbsBaseArticleInfo.mSocialFeedInfo.t.c);
        QLog.d("Q.readinjoy.ui", 2, localStringBuilder.toString());
      }
    }
    else if (paramAbsBaseArticleInfo.mTitle != null)
    {
      localSpannableStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
    }
    paramSpannableStringBuilder.append(localSpannableStringBuilder);
  }
  
  private void b(@NotNull IReadInJoyModel paramIReadInJoyModel, @NotNull SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.k();
    if ((!this.c) && (!this.d))
    {
      if (this.e)
      {
        b(paramSpannableStringBuilder, paramIReadInJoyModel);
        return;
      }
      paramSpannableStringBuilder.append(paramString);
      return;
    }
    a(paramSpannableStringBuilder, paramIReadInJoyModel);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131626202, this, true);
    this.b = ((ReadInJoyYAFolderTextView)findViewById(2131431188));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if (!(paramObject instanceof IReadInJoyModel)) {
      return;
    }
    paramObject = (IReadInJoyModel)paramObject;
    this.a.a(paramObject);
    if (paramObject.k() == null) {
      return;
    }
    String str1 = paramObject.k().mSubscribeName;
    String str2 = a(paramObject);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    a(paramObject, localSpannableStringBuilder, str1);
    b(paramObject, localSpannableStringBuilder, str2);
    this.b.setSpanText(HardCodeUtil.a(2131900525));
    this.b.setMaxLines(7);
    this.b.setMoreSpan(new ComponentAccountSummary.MoreSpan(this, paramObject.k(), -3355444));
    this.b.setText(localSpannableStringBuilder);
    b();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentAccountSummary
 * JD-Core Version:    0.7.0.1
 */