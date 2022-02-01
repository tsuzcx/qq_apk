package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.ApiCompatibilityUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.text.QQText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComponentHeaderNewSocial
  extends ComponentHeaderFriendRecommend
{
  View o;
  TextView p;
  ImageView q;
  View r;
  ReadInJoyYAFolderTextView s;
  
  public ComponentHeaderNewSocial(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderNewSocial(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderNewSocial(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private List<Long> a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    Iterator localIterator = null;
    Object localObject = localIterator;
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo == null) {
        return null;
      }
      List localList = paramAbsBaseArticleInfo.mSocialFeedInfo.d;
      localObject = localIterator;
      if (localList != null)
      {
        if (localList.size() == 0) {
          return null;
        }
        paramAbsBaseArticleInfo = new ArrayList();
        localIterator = localList.iterator();
        for (;;)
        {
          localObject = paramAbsBaseArticleInfo;
          if (!localIterator.hasNext()) {
            break;
          }
          paramAbsBaseArticleInfo.add(Long.valueOf(((FeedsInfoUser)localIterator.next()).a));
        }
      }
    }
    return localObject;
  }
  
  private void b(IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.k();
    if (paramIReadInJoyModel == null)
    {
      this.o.setVisibility(8);
      this.o.setOnClickListener(null);
      return;
    }
    List localList = a(paramIReadInJoyModel);
    if ((localList != null) && (localList.size() != 0))
    {
      this.o.setVisibility(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("你的其他");
      localStringBuilder.append(localList.size());
      localStringBuilder.append("个好友也Biu了");
      this.p.setText(localStringBuilder.toString());
      this.o.setOnClickListener(new ComponentHeaderNewSocial.1(this, paramIReadInJoyModel));
      return;
    }
    this.o.setVisibility(8);
    this.o.setOnClickListener(null);
  }
  
  private void c(IReadInJoyModel paramIReadInJoyModel)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.k();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null))
    {
      paramIReadInJoyModel = localAbsBaseArticleInfo.mSocialFeedInfo;
      Object localObject1;
      if ((paramIReadInJoyModel.n != null) && (paramIReadInJoyModel.n.a != null) && (paramIReadInJoyModel.n.a.size() > 0) && ((paramIReadInJoyModel.n.a.size() != 1) || ((!TextUtils.isEmpty(((BiuCommentInfo)paramIReadInJoyModel.n.a.get(0)).mBiuComment)) && (!TextUtils.equals(((BiuCommentInfo)paramIReadInJoyModel.n.a.get(0)).mBiuComment, ":")) && (!TextUtils.equals(((BiuCommentInfo)paramIReadInJoyModel.n.a.get(0)).mBiuComment, "：")))))
      {
        this.r.setVisibility(0);
        List localList = paramIReadInJoyModel.n.a;
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2 = new ArrayList();
        int i = localList.size();
        localObject1 = ((BiuCommentInfo)localList.get(i - 1)).mBiuComment;
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith(":")) || (((String)localObject1).startsWith("："))))
        {
          paramIReadInJoyModel = ((String)localObject1).substring(1);
        }
        else
        {
          paramIReadInJoyModel = (IReadInJoyModel)localObject1;
          if (localObject1 == null) {
            paramIReadInJoyModel = "";
          }
        }
        localStringBuilder.append(paramIReadInJoyModel);
        int j = localStringBuilder.length();
        i -= 2;
        while (i >= 0)
        {
          BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)localList.get(i);
          long l = localBiuCommentInfo.mUin.longValue();
          paramIReadInJoyModel = ReadInJoyUserInfoModule.a(l, null);
          if (paramIReadInJoyModel != null) {
            paramIReadInJoyModel = paramIReadInJoyModel.nick;
          } else {
            paramIReadInJoyModel = ReadInJoyUserInfoModule.d();
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("@");
          ((StringBuilder)localObject1).append(paramIReadInJoyModel);
          localObject1 = ((StringBuilder)localObject1).toString();
          paramIReadInJoyModel = (IReadInJoyModel)localObject1;
          if (localBiuCommentInfo.mOpType == 1)
          {
            paramIReadInJoyModel = new StringBuilder();
            paramIReadInJoyModel.append((String)localObject1);
            paramIReadInJoyModel.append(" ");
            paramIReadInJoyModel = paramIReadInJoyModel.toString();
          }
          if (localBiuCommentInfo.mBiuComment == null) {
            localObject1 = "";
          } else {
            localObject1 = localBiuCommentInfo.mBiuComment;
          }
          localStringBuilder.append(paramIReadInJoyModel);
          localStringBuilder.append((String)localObject1);
          localObject1 = new ComponentHeaderNewSocial.BiuUserStruct();
          ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).a = j;
          ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).b = (j + paramIReadInJoyModel.length());
          ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).c = l;
          ((List)localObject2).add(localObject1);
          j = localStringBuilder.length();
          i -= 1;
        }
        paramIReadInJoyModel = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ComponentHeaderNewSocial.BiuUserStruct)((Iterator)localObject1).next();
          paramIReadInJoyModel.setSpan(new ComponentHeaderNewSocial.UserSpan(this, ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).c, -3355444), ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).a, ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).b, 17);
        }
        this.s.setMaxLines(7);
        this.s.setSpanText(HardCodeUtil.a(2131900464));
        this.s.setMoreSpan(new ComponentHeaderNewSocial.MoreSpan(this, localAbsBaseArticleInfo, -3355444));
        this.s.setText(paramIReadInJoyModel);
        return;
      }
      if (!TextUtils.isEmpty(paramIReadInJoyModel.e))
      {
        this.r.setVisibility(0);
        if (paramIReadInJoyModel.e.length() >= 100)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramIReadInJoyModel.e.substring(0, 99));
          ((StringBuilder)localObject1).append('…');
          paramIReadInJoyModel.e = ((StringBuilder)localObject1).toString();
        }
        this.s.setText(paramIReadInJoyModel.e);
        return;
      }
      this.r.setVisibility(8);
      return;
    }
    this.r.setVisibility(8);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626190, this, true);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.o = findViewById(2131439243);
    ApiCompatibilityUtils.a(this.o, getResources().getDrawable(2130842690));
    this.p = ((TextView)findViewById(2131439245));
    this.q = ((ImageView)findViewById(2131439244));
    this.r = findViewById(2131439240);
    this.s = ((ReadInJoyYAFolderTextView)findViewById(2131439241));
    this.s.setSpannableFactory(QQText.SPANNABLE_FACTORY);
    this.g[1].setVisibility(8);
    this.g[2].setVisibility(8);
    this.g[3].setVisibility(8);
    this.h.setTextSize(2, 15.5F);
    this.j.setTextSize(2, 16.0F);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    int i;
    if (e()) {
      i = 0;
    } else {
      i = 8;
    }
    setVisibility(i);
    if ((paramObject instanceof IReadInJoyModel))
    {
      paramObject = (IReadInJoyModel)paramObject;
      b(paramObject);
      c(paramObject);
    }
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void setReadedStatus(boolean paramBoolean)
  {
    this.s.setTextColor(getContext().getResources().getColor(2131165564));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderNewSocial
 * JD-Core Version:    0.7.0.1
 */