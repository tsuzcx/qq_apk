package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.UGCVideoInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComponentContentUgcOriginalHeader
  extends LinearLayout
  implements ComponentView
{
  public ReadInJoyYAFolderTextView a;
  CmpCtxt b;
  private SpannableStringBuilder c;
  
  public ComponentContentUgcOriginalHeader(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ComponentContentUgcOriginalHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void setDesc(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    long l = paramAbsBaseArticleInfo.mSocialFeedInfo.s.e;
    Object localObject2 = paramAbsBaseArticleInfo.mSocialFeedInfo.s.f;
    Object localObject1 = ReadInJoyUserInfoModule.a(l, null);
    if (localObject1 != null) {
      localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
    } else {
      localObject1 = ReadInJoyUserInfoModule.d();
    }
    this.c = new SpannableStringBuilder();
    this.c.append(RIJStringUtils.a((String)localObject1));
    this.c.setSpan(new ComponentContentUgcOriginalHeader.UserSpan(this, l, -3355444), 0, this.c.length(), 33);
    this.c.append(": ");
    if ((CmpCtxt.c(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.x(paramAbsBaseArticleInfo)))
    {
      localObject1 = ((UGCVideoInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.s.c.get(0)).e;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.c.append((CharSequence)localObject1);
      }
    }
    else if (RIJFeedsType.a(paramAbsBaseArticleInfo.mSocialFeedInfo.s))
    {
      List localList = paramAbsBaseArticleInfo.mSocialFeedInfo.s.h.a;
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject3 = new ArrayList();
      int i = localList.size();
      localObject2 = ((BiuCommentInfo)localList.get(i - 1)).mBiuComment;
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((((String)localObject2).startsWith(":")) || (((String)localObject2).startsWith("："))))
      {
        localObject1 = ((String)localObject2).substring(1);
      }
      else
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      localStringBuilder.append((String)localObject1);
      int j = localStringBuilder.length();
      i -= 2;
      while (i >= 0)
      {
        BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)localList.get(i);
        l = localBiuCommentInfo.mUin.longValue();
        localObject1 = ReadInJoyUserInfoModule.a(l, null);
        if (localObject1 != null) {
          localObject1 = ((ReadInJoyUserInfo)localObject1).nick;
        } else {
          localObject1 = ReadInJoyUserInfoModule.d();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("@");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        if (localBiuCommentInfo.mOpType == 1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(" ");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        if (localBiuCommentInfo.mBiuComment == null) {
          localObject2 = "";
        } else {
          localObject2 = localBiuCommentInfo.mBiuComment;
        }
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append((String)localObject2);
        localObject2 = new ComponentHeaderNewSocial.BiuUserStruct();
        ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).a = j;
        ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).b = (j + ((String)localObject1).length());
        ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).c = l;
        ((List)localObject3).add(localObject2);
        j = localStringBuilder.length();
        i -= 1;
      }
      localObject1 = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
      localObject2 = ((List)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ComponentHeaderNewSocial.BiuUserStruct)((Iterator)localObject2).next();
        ((SpannableStringBuilder)localObject1).setSpan(new ComponentContentUgcOriginalHeader.UserSpan(this, ((ComponentHeaderNewSocial.BiuUserStruct)localObject3).c, -3355444), ((ComponentHeaderNewSocial.BiuUserStruct)localObject3).a, ((ComponentHeaderNewSocial.BiuUserStruct)localObject3).b, 17);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        this.c.append((CharSequence)localObject1);
      }
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = new QQText(EmotionCodecUtils.c((String)localObject2), 7, 16);
      this.c.append((CharSequence)localObject1);
    }
    this.a.setText(this.c);
    this.a.setMoreSpan(new ComponentContentUgcOriginalHeader.MoreSpan(this, paramAbsBaseArticleInfo, -3355444));
  }
  
  public void a(Context paramContext)
  {
    this.b = new CmpCtxt();
    setOrientation(0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(AIOUtils.b(12.0F, paramContext.getResources()), AIOUtils.b(12.0F, paramContext.getResources()), AIOUtils.b(20.0F, paramContext.getResources()), 0);
    setLayoutParams(localLayoutParams);
    this.a = new ReadInJoyYAFolderTextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.a.setLayoutParams(paramContext);
    this.a.setIncludeFontPadding(false);
    this.a.setTextColor(Color.parseColor("#606060"));
    this.a.setTextSize(2, 16.0F);
    this.a.setSpanText(HardCodeUtil.a(2131900519));
    this.a.setMaxLines(7);
    this.a.setMoreSpan(new ComponentContentUgcOriginalHeader.1(this));
    addView(this.a);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener) {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      CmpCtxt localCmpCtxt = this.b;
      paramObject = (IReadInJoyModel)paramObject;
      localCmpCtxt.a(paramObject);
      paramObject = paramObject.k();
      if ((paramObject != null) && (paramObject.mSocialFeedInfo != null) && (paramObject.mSocialFeedInfo.s != null))
      {
        setDesc(paramObject);
        if ((RIJItemViewTypeUtils.r(paramObject)) && (TextUtils.isEmpty(paramObject.businessName)))
        {
          paramObject = (LinearLayout.LayoutParams)getLayoutParams();
          paramObject.bottomMargin = AIOUtils.b(12.0F, getContext().getResources());
          setLayoutParams(paramObject);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ComponentContentUgcOriginalHeader", 2, "article info is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcOriginalHeader
 * JD-Core Version:    0.7.0.1
 */